package org.encryfoundation.prismPlugin.psi

import com.intellij.psi.{PsiNameIdentifierOwner, PsiReference}

trait PrismNamedElement extends PrismCompositeElement with PsiNameIdentifierOwner {

  override def getReference: PsiReference = {
    println(s"this is ${this}")
    this match {
      case vd: PrismVariableDefinition => PrismPsiUtilImpl.getReference(vd)
      case _ => null
    }
  }

}
