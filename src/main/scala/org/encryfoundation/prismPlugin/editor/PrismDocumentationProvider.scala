package org.encryfoundation.prismPlugin.editor

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement

class PrismDocumentationProvider extends AbstractDocumentationProvider {
  override def getQuickNavigateInfo(element: PsiElement, originalElement: PsiElement): String =
    if (element.getTextLength >= 25) element.getText.take(25).filter(_ != '\n') + "..." else element.getText
}
