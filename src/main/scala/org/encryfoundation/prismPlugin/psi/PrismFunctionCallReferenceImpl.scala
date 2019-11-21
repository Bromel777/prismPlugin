package org.encryfoundation.prismPlugin.psi

import com.intellij.codeInsight.lookup.{LookupElement, LookupElementBuilder}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiElementResolveResult, ResolveResult}
import org.encryfoundation.prismPlugin.Icons

case class PrismFunctionCallReferenceImpl(element: PrismFuncCallExpr, range: TextRange)
  extends PrismPsiPolyVariantCachingReferenceBase[PrismFuncCallExpr](element: PrismFuncCallExpr, range: TextRange) {

  //println(element.getReferencedIdentifier.getIdentifier.getText)

  override def multiResolve(incompleteCode: Boolean): Array[ResolveResult] =
    PsiElementResolveResult.createResults(
      PrismUtil.findFunctionDefinition(element): _*
    )

  override def resolve(): PsiElement = multiResolve(false).headOption.map(_.getElement).orNull

  override def getVariants: Array[AnyRef] = {
    PrismUtil.findFunctionDefinition(element).foldLeft(Vector.empty[LookupElement]) { case (acc, el) =>
      if (el.getIdentifier != null && el.getIdentifier.getText.length > 0)
        acc :+ LookupElementBuilder.create(el).withIcon(Icons.prismLogo).withTypeText(el.getContainingFile.getName)
      else acc
    }.toArray
  }
}
