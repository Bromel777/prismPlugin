package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.{PsiElement, PsiReference, ResolveState}

object PrismPsiUtilImpl {

  def getNameIdentifier(variable: PrismVariableDefinition): PsiElement = {
    variable.getIdentifier
  }

  def getReference(variable: PrismVariableDefinition): PsiReference = {
    val range =
      if (variable.getStmt == null) null
      else {
        val identLength = variable.getText.reverse.trim.takeWhile(ch => ch != ' ' && ch != '=').length
        TextRange.from(variable.getTextLength - identLength, identLength)
      }
    val r = PrismVariableReferenceImpl(variable, range)
    println(r.getCanonicalText)
    r
  }

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
    val valueNode = element.getNode.findChildByType(TokenSet.create(PrismTypes.EXPR_WO_DECLR, PrismTypes.FUNC_CALL_EXPR, PrismTypes.STMT))

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
