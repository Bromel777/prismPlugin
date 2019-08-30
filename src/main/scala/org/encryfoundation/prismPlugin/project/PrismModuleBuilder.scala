package org.encryfoundation.prismPlugin.project

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel

class PrismModuleBuilder extends ModuleBuilder {

  override def setupRootModel(modifiableRootModel: ModifiableRootModel): Unit = {
    val projectBaseDir = modifiableRootModel.getProject.getBaseDir
    val contentEntry = modifiableRootModel.addContentEntry(projectBaseDir)
    println("contentEntry:" + contentEntry)
    println("projectBaseDir:" + projectBaseDir)
    contentEntry.addSourceFolder(projectBaseDir, false)
    modifiableRootModel.inheritSdk()
  }

  override def getModuleType: PrismModuleType = {
    println("Invoke getModuleType")
    PrismModuleType.getInstance
  }
}
