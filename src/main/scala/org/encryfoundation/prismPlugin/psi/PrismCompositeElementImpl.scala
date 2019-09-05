package org.encryfoundation.prismPlugin.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.{PsiElement, ResolveState}
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.usageView.UsageViewUtil
import javax.swing.Icon

class PrismCompositeElementImpl(node: ASTNode) extends ASTWrapperPsiElement(node) with PrismCompositeElement {

  override def getPresentation: ItemPresentation = {
    val text = UsageViewUtil.createNodeText(this)
    new ItemPresentation {
      override def getPresentableText: String = text

      override def getLocationString: String = getContainingFile.getName

      override def getIcon(unused: Boolean): Icon = PrismCompositeElementImpl.this.getIcon(0)
    }
  }
}
