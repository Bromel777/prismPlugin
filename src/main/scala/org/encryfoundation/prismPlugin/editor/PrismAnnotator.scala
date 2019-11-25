package org.encryfoundation.prismPlugin.editor

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.psi.PsiElement
import org.encryfoundation.prismPlugin.psi.{PrismArgsList, PrismFuncCallExpr, PrismFunctionCallReferenceImpl, PrismFunctionDefinition, PrismIdentifiersList, PrismReferencedIdentifier, PrismUtil, PrismVariableDefinition}

import scala.util.Try

class PrismAnnotator extends Annotator {

  override def annotate(element: PsiElement, holder: AnnotationHolder): Unit = {
    element match {
      case pvd: PrismVariableDefinition =>
        val sameNameVariablesExist = PrismUtil.findVariableDefinition(element.getProject, pvd.getIdentifier).nonEmpty
        val sameNameFunctionExist = PrismUtil.findFunctionDefinition(pvd, pvd.getIdentifier.getText).exists(f => unfoldArgList(f).isEmpty)
        if (sameNameVariablesExist) holder.createErrorAnnotation(element.getTextRange, s"Variable ${pvd.getIdentifier.getText} is already defined in a scope")
        else if (sameNameFunctionExist) holder.createErrorAnnotation(element.getTextRange, s"Function without arguments with the same name is already defined in a scope")
      case pfd: PrismFunctionDefinition =>
        val argList = unfoldArgList(pfd)
        val sameNameAndArgumentsFunctionsExist = PrismUtil.findFunctionDefinition(pfd, pfd.getIdentifier.getText).exists { d =>
          (pfd.getArgsList == null && d.getArgsList == null) || Try(argList == unfoldArgList(d)).getOrElse(false)
        }
        val typeAnnotationPresent = Option(pfd.getType).isDefined
        val sameNameVariablesExist = if (argList.nonEmpty) false else PrismUtil.findVariableDefinition(pfd.getProject, pfd).nonEmpty
        if (!typeAnnotationPresent) holder.createErrorAnnotation(element.getTextRange, s"Type annotation required")
        else if (sameNameAndArgumentsFunctionsExist) holder.createErrorAnnotation(element.getTextRange, s"Function ${pfd.getIdentifier.getText} is already defined in a scope")
        else if (sameNameVariablesExist) holder.createErrorAnnotation(element.getTextRange, s"Variable with the same name is already defined in a scope")
      case pri: PrismReferencedIdentifier =>
        if (pri.getParent != null) {
          pri.getParent match {
            case pfc: PrismFuncCallExpr =>
              if (!PrismUtil.findFunctionDefinition(pri, pri.getIdentifier.getText).exists { f =>
                  unfoldArgList(Vector.empty, f.getArgsList).length == unfoldIdentifierList(pfc).size
              }) holder.createErrorAnnotation(element.getTextRange, s"Function definition not found")
            case _ =>
              if (PrismUtil.findVariableDefinition(pri.getProject, pri).isEmpty)
                holder.createErrorAnnotation(element.getTextRange, s"Variable definition not found")
          }
        }
      case _ =>
    }
  }

  private def unfoldArgList(f: PrismFunctionDefinition): String = unfoldArgList(Vector.empty, f.getArgsList).mkString(", ")

  private def unfoldArgList(prevArgs: Vector[String], args: PrismArgsList): Vector[String] =
    if (args == null) prevArgs
    else {
      val currentArgs: Vector[String] = Try {
        prevArgs :+ args.getType.getText
      }.getOrElse(prevArgs)
      unfoldArgList(currentArgs, args.getArgsList)
    }

  private def unfoldIdentifierList(funcCall: PrismFuncCallExpr): Vector[String] = unfoldIdentifierList(Vector.empty, funcCall.getIdentifiersList)

  private def unfoldIdentifierList(prevIdents: Vector[String], identifiers: PrismIdentifiersList): Vector[String] =
    if (identifiers == null) prevIdents
    else unfoldIdentifierList(prevIdents :+ identifiers.getStmt.getText, identifiers.getIdentifiersList)
}
