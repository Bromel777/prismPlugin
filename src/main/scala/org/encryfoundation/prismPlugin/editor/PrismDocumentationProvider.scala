package org.encryfoundation.prismPlugin.editor

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.psi.PsiElement
import org.encryfoundation.prismPlugin.psi.{PrismReferencedIdentifier, PrismTypeInferenceUtil}

class PrismDocumentationProvider extends AbstractDocumentationProvider {
  override def getQuickNavigateInfo(element: PsiElement, originalElement: PsiElement): String = originalElement match {
    case pri: PrismReferencedIdentifier =>
      val inferredTypeOpt = PrismTypeInferenceUtil.inferenceReferencedIdentifierType(pri)
      inferredTypeOpt match {
        case Some(tp) => renderElementDoc(element) + s". Type: $tp"
        case None => renderElementDoc(element)
      }
    case _ => renderElementDoc(element)
  }

  private def renderElementDoc(element: PsiElement) = if (element.getTextLength >= 25) element.getText.take(25).filter(_ != '\n') + "..." else element.getText

}
