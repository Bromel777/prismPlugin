package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.{PsiElement, PsiReference, ResolveState}

import scala.util.Try

object PrismPsiUtilImpl {

  def getNameIdentifier(variable: PrismVariableDefinition): PsiElement = {
    variable.getIdentifier
  }

  def getNameIdentifier(func: PrismFunctionDefinition): PsiElement = {
    func.getIdentifier
  }

  def getNameIdentifier(func: PrismReferencedIdentifier): PsiElement = {
    func.getIdentifier
  }

  def getReference(call: PrismFuncCallExpr): PsiReference = {
    val initOffset = call.getText.indexOf(call.getReferencedIdentifier.getIdentifier.getText)
    PrismFunctionCallReferenceImpl(call, TextRange.from(initOffset, call.getReferencedIdentifier.getText.length))
  }

  def getReference(ident: PrismReferencedIdentifier): PsiReference = {
    //val identLength = ident.getIdentifier.getText.reverse.trim.takeWhile(ch => ch != ' ' && ch != '=').length
    val offset = ident.getParent.getText.indexOf(ident.getIdentifier.getText)
    println(s"elem is ${ident.getText}, parent is ${ident.getParent.getText}")
    PrismIdentReferenceImpl(ident, TextRange.from(0, ident.getIdentifier.getTextLength))
  }

//  def getReference(variable: PrismStmt): PsiReference = {
//    //val range =
//    if (Try(variable.getReferencedIdentifier.getIdentifier).isFailure) null
//    else {
//      val identLength = variable.getText.reverse.trim.takeWhile(ch => ch != ' ' && ch != '=').length
//      //TextRange.from(variable.getTextLength - identLength, identLength)
//      //println(variable.getExpr.getStmt.getIdentifier.getTextRange)
//      //variable.getExpr.getStmt.getIdentifier.getTextRange
//      TextRange.from(variable.getTextLength - identLength, identLength)
//      PrismIdentReferenceImpl(variable.getReferencedIdentifier, TextRange.from(variable.getTextLength - identLength, identLength))
//    }
//    // PrismVariableReferenceImpl(variable, range)
//  }

//  def getReference(ref: PrismVariableReference): PsiReference = {
//    PrismVariableCallReferenceImpl(ref, ref.getTextRange)
//  }

  def processDeclarations(o: PrismNamedElement, processor: PsiScopeProcessor, state: ResolveState, lastParent: PsiElement, place: PsiElement): Boolean =
    processor.execute(o, state)



  def getKey(element: PrismVariableDefinition): String = {
    val keyNode = element.getNode.findChildByType(PrismTypes.IDENTIFIER)

    if (keyNode != null) {
      keyNode.getText.replaceAll("\\\\ ", " ")
    }
    else null
  }

  def getValue(element: PrismVariableDefinition): String = {
    val valueNode = element.getNode.findChildByType(TokenSet.create(PrismTypes.EXPR, PrismTypes.FUNC_CALL_EXPR, PrismTypes.STMT))

    if (valueNode != null) valueNode.getText else null
  }

  def getName(el: PrismVariableDefinition): String = getKey(el)

  def setName(el: PrismVariableDefinition, newName: String): PsiElement = {
    val keyNode = el.getNode.findChildByType(PrismTypes.IDENTIFIER)
    if (keyNode != null) {
      val definition = PrismElementFactory.createVariableDefinition(el.getProject, newName)
      val newKeyNode = definition.getFirstChild.getNode
      el.getNode.replaceChild(keyNode, newKeyNode)
    }
    el
  }

//  def getNameIdentifier(el: PrismVariableDefinition): PsiElement = {
//    val keyNode = el.getNode.findChildByType(PrismTypes.IDENTIFIER)
//    if (keyNode != null) keyNode.getPsi else null //todo Opt
//  }

}
