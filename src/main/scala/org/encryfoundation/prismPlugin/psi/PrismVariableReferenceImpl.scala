package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElementResolveResult, ResolveResult}

case class PrismVariableReferenceImpl(element: PrismVariableDefinition, range: TextRange)
  extends PrismPsiPolyVariantCachingReferenceBase[PrismVariableDefinition](element: PrismVariableDefinition, range: TextRange) {

  override def multiResolve(incompleteCode: Boolean) = {
    val processor = PrismVarProcessor(element.getText, element)
    val place = myElement
    ResolveUtil.treeWalkUp(place, processor)
    val result = processor.getAllResults()
    if (!result.isEmpty) {
      PsiElementResolveResult.createResults(result)
    } else {
      println("empty result!")
      Array.empty[ResolveResult]
    }
  }
}
