package org.encryfoundation.prismPlugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

class PrismCompositeElementImpl(node: ASTNode) extends ASTWrapperPsiElement(node) with PrismCompositeElement {

}
