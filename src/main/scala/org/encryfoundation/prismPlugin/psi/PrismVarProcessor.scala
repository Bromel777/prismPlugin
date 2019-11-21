package org.encryfoundation.prismPlugin.psi

import java.util

import com.intellij.openapi.util.Key
import com.intellij.psi.{PsiElement, ResolveState}
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.util.containers.ContainerUtil
//import org.encryfoundation.prismPlugin.impl.PrismVariableDefinitionImpl

import scala.collection.JavaConverters._

final case class PrismVarProcessor(reqName: String, origin: PsiElement) extends PsiScopeProcessor {

  var myVarList: util.List[PrismVariableDefinition] = List.empty[PrismVariableDefinition].asJava

  import PrismVarProcessor._

  override def execute(element: PsiElement, state: ResolveState): Boolean = {
    val parent = element.getParent

    println("------------------------")

//    if (parent != null && element.isInstanceOf[PrismVariableDefinitionImpl]) {
//      println(parent)
//      println(PRISM_VARIABLE_CONTEXT(element.getParent))
//      val context: Map[String, PrismVariableDefinition] = element.getContainingFile.getOriginalFile.getUserData(PRISM_VARIABLE_CONTEXT(element.getParent))
//      if (context == null) element.getContainingFile.getOriginalFile.putUserData(PRISM_VARIABLE_CONTEXT(parent), Map(element.getText -> element.asInstanceOf[PrismVariableDefinitionImpl]))
//      else element.getContainingFile.getOriginalFile.putUserData(PRISM_VARIABLE_CONTEXT(parent), context.updated(element.getText, element.asInstanceOf[PrismVariableDefinitionImpl]))
//    }
      //
//    val context: Map[String, PrismVariableDefinition] = element.getContainingFile.getOriginalFile.getUserData(PRISM_VARIABLE_CONTEXT(element.getParent))
        //
//    //val context: Map[String, PrismVariableDefinition] = element.getContainingFile.getOriginalFile.getUserData(PRISM_VARIABLE_CONTEXT(element.getParent))
//    //if (context == null) element.getContainingFile.getOriginalFile.putUserData(PRISM_VARIABLE_CONTEXT, Map.empty[String, PrismVariableDefinition])
      //
      //
//    println(element.getClass)
//    println(element.getText)
//    println(element.getParent)
//    println(s"context: $context")
//    println(s"myVarList: ${myVarList.asScala.mkString(", ")}")
//    println(element.isInstanceOf[PrismVariableDefinition])
//    if (context != null && context.contains(reqName)) {
//      context.get(reqName).foreach(myVarList.add)
//      true
//    } else if (!(element.getText == reqName)) {
//      println(2)
//      true
//    } else if (element.equals(origin)) {
//      println(3)
//      true
//    } else if (element.isInstanceOf[PrismVariableDefinitionImpl]) {
//      myVarList.add(element.asInstanceOf[PrismVariableDefinition])
//      println(4)
//      false
//    } else {
//      println(5)
//      false
//    }
    true
  }

  def getAllResults() = myVarList
}

object PrismVarProcessor {
  def PRISM_VARIABLE_CONTEXT(elem: PsiElement): Key[Map[String, PrismVariableDefinition]] = Key.create(s"PRISM_VARIABLE_CONTEXT${elem.hashCode()}")
}
