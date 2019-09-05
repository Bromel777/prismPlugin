package org.encryfoundation.prismPlugin.inscpection

import com.intellij.codeInsight.daemon.impl.actions.AbstractBatchSuppressByNoInspectionCommentFix
import com.intellij.psi.PsiElement
import com.intellij.psi.util.{PsiTreeUtil, PsiUtil}

case class PrismSuppressInspectionFix(id: String, text: String, container: Class[_ <: PsiElement]) extends
  AbstractBatchSuppressByNoInspectionCommentFix(id, false) {

  override def getContainer(context: PsiElement): PsiElement = PsiTreeUtil.getParentOfType(context, container)
}
