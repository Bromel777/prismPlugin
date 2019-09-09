package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.util.Key
import com.intellij.psi.{PsiElement, ResolveState}
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.util.containers.ContainerUtil
import scala.collection.JavaConverters._

final case class PrismVarProcessor(reqName: String, origin: PsiElement) extends PsiScopeProcessor {

  val PRISM_VARIABLE_CONTEXT = Key.create("PRISM_VARIABLE_CONTEXT")
  var myVarList = List.empty[PrismVariableDefinition].asJava

  override def execute(element: PsiElement, state: ResolveState): Boolean = {
    val context: Map[String, PrismVariableDefinition] = element.getContainingFile.getOriginalFile.getUserData(PRISM_VARIABLE_CONTEXT)
    if (context == null) {
      ContainerUtil.addIfNotNull(myVarList, context(reqName))
      true
    } else {
      true
    }
  }

  def getAllResults() = myVarList
}
