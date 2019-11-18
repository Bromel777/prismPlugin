package org.encryfoundation.prismPlugin.psi

import java.util

import com.intellij.openapi.util.Key
import com.intellij.psi.{PsiElement, ResolveState}
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.util.containers.ContainerUtil

import scala.collection.JavaConverters._

final case class PrismVarProcessor(reqName: String, origin: PsiElement) extends PsiScopeProcessor {

  var myVarList: util.List[PrismDeclr] = List.empty[PrismDeclr].asJava

  import PrismVarProcessor._

  override def execute(element: PsiElement, state: ResolveState): Boolean = {
    val context: Map[String, PrismDeclr] = element.getContainingFile.getOriginalFile.getUserData(PRISM_VARIABLE_CONTEXT)
    //if (context == null) element.getContainingFile.getOriginalFile.putUserData(PRISM_VARIABLE_CONTEXT, Map.empty[String, PrismVariableDefinition])

    println("------------------------")

    println(element.getClass)
    println(element.getText)
    println(s"context: $context")
    println(s"myVarList: ${myVarList.asScala.mkString(", ")}")
    println(element.isInstanceOf[PrismDeclr])
    if (context != null && context.contains(reqName)) {
      context.get(reqName).foreach(myVarList.add)
      true
    } else if (!(element.getText == reqName)) {
      println(2)
      true
    } else if (element.equals(origin)) {
      println(3)
      true
    } else if (!element.isInstanceOf[PrismVariableDefinition]) {
      println(4)
      true
    } else {
      println(5)
      myVarList.add(element.asInstanceOf[PrismDeclr])
      false
    }
  }

  def getAllResults() = myVarList
}

object PrismVarProcessor {
  val PRISM_VARIABLE_CONTEXT: Key[Map[String, PrismDeclr]] = Key.create("PRISM_VARIABLE_CONTEXT")
}
