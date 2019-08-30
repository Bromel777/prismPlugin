package org.encryfoundation.prismPlugin.project

import com.intellij.icons.AllIcons
import com.intellij.openapi.module.{ModuleType, ModuleTypeManager}
import javax.swing.Icon

class PrismModuleType extends ModuleType[PrismModuleBuilder](PrismModuleType.id){

  override def createModuleBuilder(): PrismModuleBuilder = new PrismModuleBuilder

  override def getName: String = "PRISM_MODULE"

  override def getDescription: String = "Prism (desc)"

  override def getNodeIcon(isOpened: Boolean): Icon = AllIcons.General.Information
}

object PrismModuleType {

  def getInstance: PrismModuleType = {
    val inst = ModuleTypeManager.getInstance().findByID(id).asInstanceOf[PrismModuleType]
    println(s"inst: ${inst}")
    inst
  }

  val id = "PRISM_MODULE"
}
