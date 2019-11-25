package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.{PsiElement, PsiFile, PsiManager}
import com.intellij.psi.search.{FileTypeIndex, GlobalSearchScope}
import org.encryfoundation.prismPlugin.PrismFileType

import collection.JavaConverters._
import scala.collection.mutable
import scala.util.Try

object PrismUtil {

  def findVariableDefinition(project: Project, elem: PsiElement): Vector[PsiElement] = {
    val virtualFiles = FileTypeIndex.getFiles(PrismFileType.INSTANCE, GlobalSearchScope.allScope(project))

    val identOpt = elem match {
      case pri: PrismReferencedIdentifier => Some(pri.getIdentifier.getText)
      case pfd: PrismFunctionDefinition => Some(pfd.getIdentifier.getText)
      case _ => None
    }

    identOpt.map { ident =>
      virtualFiles.asScala.foldLeft(Vector.empty[PsiElement]) { case (acc, virtualFile) =>
        val file = PsiManager.getInstance(project).findFile(virtualFile)
        if (file != null) {
          val foundGlobal = findVariableDefinitionInGlobalScope(elem, ident)
          val foundArgs = findVariableInArgs(elem)
          acc ++ foundArgs ++ foundGlobal
        } else acc
      }
    }.getOrElse(Vector.empty[PsiElement])
  }

  def findVariableDefinition(project: Project): Vector[PrismVariableDefinition] = {
    val virtualFiles = FileTypeIndex.getFiles(PrismFileType.INSTANCE, GlobalSearchScope.allScope(project))

    virtualFiles.asScala.foldLeft(Vector.empty[PrismVariableDefinition]) { case (acc, virtualFile) =>
      val file = PsiManager.getInstance(project).findFile(virtualFile)
      if (file != null) {
        val props = PsiTreeUtil.getChildrenOfType(file, classOf[PrismVariableDefinition])
        if (props != null) acc ++ props
        else acc
      } else acc
    }
  }

  def findVariableDefinitionInGlobalScope(file: PsiFile, elem: PsiElement): Vector[PsiElement] = {
    val props = PsiTreeUtil.getChildrenOfType(file.getFirstChild, classOf[PrismVariableDefinition])
    if (props != null)
      props
        .filter(e => Try(e.getIdentifier.getText).toOption.contains(elem.getText))
        .takeWhile(_.getIdentifier.getTextRange.getEndOffset < elem.getTextRange.getStartOffset)
        .toVector
    else Vector.empty
  }

  def findVariableDefinitionInGlobalScope(elem: PsiElement, identifierText: String): Vector[PrismVariableDefinition] = {
    var parent = elem.getParent
    val buffer = mutable.Buffer[PrismVariableDefinition]()
    if (parent == null) Vector.empty
    else {
      while (parent != null && !parent.isInstanceOf[PsiFile]) {
        val props: Array[PrismVariableDefinition] = PsiTreeUtil.getChildrenOfType(parent, classOf[PrismVariableDefinition])
        val found =
          if (props == null) Array.empty[PrismVariableDefinition]
          else props.filter(pr => pr.getIdentifier.getText == identifierText && !pr.equals(elem) && pr.getTextRange.getEndOffset < elem.getTextRange.getStartOffset)
        found.foreach(e => buffer.append(e))
        parent = parent.getParent
      }
      buffer.toVector
    }
  }

  def findVariableInArgs(elem: PsiElement): Vector[PsiElement] = {

    @scala.annotation.tailrec
    def findInArgs(args: PrismArgsList): Option[PsiElement] =
      if (args == null) None
      else if (Try(args.getIdentifier.getText).toOption.contains(elem.getText)) Some(args.getIdentifier)
      else {
        val next = args.getArgsList
        if (next != null) findInArgs(next)
        else None
      }

    var parent = elem.getParent
    val buffer = mutable.Buffer[PsiElement]()
    if (parent == null || parent.isInstanceOf[PrismContract]) Vector.empty
    else {
      while (parent != null && !parent.isInstanceOf[PsiFile]) {
        val found = parent match {
          case pfd: PrismFunctionDefinition => findInArgs(pfd.getArgsList)
          case lamb: PrismLambExpr => findInArgs(lamb.getArgsList)
          case cont: PrismContract => findInArgs(cont.getArgsList)
          case _ => None
        }
        found.foreach(e => buffer.append(e))
        parent = parent.getParent
      }
      buffer.toVector
    }
  }

  def findFunctionDefinition(elem: PrismFuncCallExpr): Vector[PrismFunctionDefinition] = {
    var parent = elem.getParent
    val buffer = mutable.Buffer[PrismFunctionDefinition]()
    if (parent == null) Vector.empty
    else {
      while (parent != null && !parent.isInstanceOf[PsiFile]) {
        val props: Array[PrismFunctionDefinition] = PsiTreeUtil.getChildrenOfType(parent, classOf[PrismFunctionDefinition])
        val found =
          if (props == null) Array.empty[PrismFunctionDefinition]
          else props.filter(_.getIdentifier.getText == elem.getReferencedIdentifier.getIdentifier.getText)
        found.foreach(e => buffer.append(e))
        parent = parent.getParent
      }
      buffer.toVector
    }
  }

  def findFunctionDefinition(elem: PsiElement, identifierText: String): Vector[PrismFunctionDefinition] = {
    var parent = elem.getParent
    val buffer = mutable.Buffer[PrismFunctionDefinition]()
    if (parent == null) Vector.empty
    else {
      while (parent != null && !parent.isInstanceOf[PsiFile]) {
        val props: Array[PrismFunctionDefinition] = PsiTreeUtil.getChildrenOfType(parent, classOf[PrismFunctionDefinition])
        val found =
          if (props == null) Array.empty[PrismFunctionDefinition]
          else props.filter(pr => pr.getIdentifier.getText == identifierText && !pr.equals(elem) && pr.getTextRange.getEndOffset < elem.getTextRange.getStartOffset)
        found.foreach(e => buffer.append(e))
        parent = parent.getParent
      }
      buffer.toVector
    }
  }

}
