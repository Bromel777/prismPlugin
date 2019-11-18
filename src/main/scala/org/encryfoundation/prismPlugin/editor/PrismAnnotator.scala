package org.encryfoundation.prismPlugin.editor

import com.intellij.lang.annotation.{AnnotationHolder, Annotator}
import com.intellij.psi.PsiElement

class PrismAnnotator extends Annotator {

  override def annotate(element: PsiElement, holder: AnnotationHolder): Unit = {
    //println(s"Annotator: ${element.getNode} | ${holder}")
  }
}
