package org.encryfoundation.prismPlugin.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

abstract class PrismNamedElementImpl(node: ASTNode) extends PrismCompositeElementImpl(node) with PrismCompositeElement with PrismNamedElement {

  override def setName(name: String): PsiElement = this
}
