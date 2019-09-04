package org.encryfoundation.prismPlugin.project

import com.intellij.ide.util.projectWizard.{ModuleBuilder, ModuleWizardStep, ProjectJdkForModuleStep, WizardContext}
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ui.configuration.ModulesProvider

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

  override def createWizardSteps(wizardContext: WizardContext,
                                 modulesProvider: ModulesProvider): Array[ModuleWizardStep] =
    Array[ModuleWizardStep](new ProjectJdkForModuleStep(wizardContext, JavaSdk.getInstance) {
      override def updateDataModel() = {
        PrismModuleBuilder.this.setModuleJdk(getJdk)
        super.updateDataModel()
      }
  })
}
