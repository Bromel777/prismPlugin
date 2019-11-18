package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiElementResolveResult, PsiReference, ResolveResult, ResolveState}

import collection.JavaConverters._

case class PrismVariableReferenceImpl(element: PrismVariableDefinition, range: TextRange)
  extends PrismPsiPolyVariantCachingReferenceBase[PrismVariableDefinition](element: PrismVariableDefinition, range: TextRange) {

  override def multiResolve(incompleteCode: Boolean): Array[ResolveResult] = {
    val processor = PrismVarProcessor(element.getText, element)
    val place = myElement
    ResolveUtil.treeWalkUp(place, processor)
    val result = processor.getAllResults()
    if (!result.isEmpty) {
      println(s"result is ${result.asScala.mkString(", ")}")
      PsiElementResolveResult.createResults(result)
    } else {
      println("empty result!")
      Array.empty[ResolveResult]
    }
  }

  override def resolve(): PsiElement = multiResolve(false).headOption.map(_.getElement).orNull

}
