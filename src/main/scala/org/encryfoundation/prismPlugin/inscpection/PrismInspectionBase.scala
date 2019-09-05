package org.encryfoundation.prismPlugin.inscpection

import com.intellij.codeInspection.{CustomSuppressableInspectionTool, LocalInspectionTool, SuppressIntentionAction}
import com.intellij.psi.PsiElement
import org.encryfoundation.prismPlugin.impl.PrismExprImpl
import org.encryfoundation.prismPlugin.psi.PrismExpr

class PrismInspectionBase extends LocalInspectionTool with CustomSuppressableInspectionTool {

  override def getSuppressActions(element: PsiElement): Array[SuppressIntentionAction] = List(
    PrismSuppressInspectionFix("", "", PrismExprImpl.class)
  )
}
