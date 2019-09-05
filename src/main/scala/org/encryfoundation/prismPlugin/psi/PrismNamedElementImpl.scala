package org.encryfoundation.prismPlugin.psi

import com.intellij.lang.ASTNode

case class PrismNamedElementImpl(node: ASTNode) extends PrismCompositeElementImpl(node) with PrismCompositeElement with PrismNamedElement
