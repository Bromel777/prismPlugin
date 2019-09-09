package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiPolyVariantReferenceBase, ResolveResult}

abstract class PrismPsiPolyVariantCachingReferenceBase[T <: PsiElement](element: T, range: TextRange)
  extends PsiPolyVariantReferenceBase[T](element: T, range: TextRange)