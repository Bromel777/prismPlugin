package org.encryfoundation.prismPlugin.inscpection

import com.intellij.codeInspection.{CustomSuppressableInspectionTool, LocalInspectionTool, SuppressIntentionAction}
import com.intellij.psi.PsiElement

class PrismInspectionBase extends LocalInspectionTool with CustomSuppressableInspectionTool {

  override def getSuppressActions(element: PsiElement): Array[SuppressIntentionAction] = Array.empty[SuppressIntentionAction]
}
