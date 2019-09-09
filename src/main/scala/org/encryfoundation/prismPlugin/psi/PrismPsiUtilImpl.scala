package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiReference}

object PrismPsiUtilImpl {

  def getNameIdentifier(variable: PrismVariableDefinition): PsiElement = {
    variable.getIdentifier
  }

  def getReference(variable: PrismVariableDefinition): PsiReference = {
    println("invoke getReference")
    val ref = PrismVariableReferenceImpl(variable, TextRange.from(0, variable.getTextLength))
    println(s"Ref for ${variable.getText} is $ref")
    ref
  }
}
