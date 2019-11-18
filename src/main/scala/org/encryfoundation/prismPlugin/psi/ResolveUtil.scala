package org.encryfoundation.prismPlugin.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.ResolveState


trait ResolveUtil

object ResolveUtil {

  def treeWalkUp(place: PsiElement, processor: PsiScopeProcessor): Boolean = {
    var lastParent = Option.empty[PsiElement]
    var run = place
    var flag = true
    while (run != null && flag) {
      if ((place ne run) && !run.processDeclarations(processor, ResolveState.initial, lastParent.orNull, place)) flag = false
      lastParent = Some(run)
      run = run.getParent
    }
    flag
  }

  def processChildren(element: PsiElement,
                      processor: PsiScopeProcessor,
                      substitutor: ResolveState,
                      lastParent: PsiElement,
                      place: PsiElement): Boolean = {
    var run = if (lastParent == null) element.getLastChild
    else lastParent.getPrevSibling
    var flag = true
    while ( {
      run != null && flag
    }) {
      if (run.isInstanceOf[PrismCompositeElement] && !run.processDeclarations(processor, substitutor, null, place)) flag = false
      run = run.getPrevSibling
    }
    flag
  }
}
