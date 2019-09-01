package org.encryfoundation.prismPlugin.sdk

import com.intellij.openapi.projectRoots._
import org.jdom.Element

case class PrismSdkType() extends SdkType("Prism Sdk Type") {

  override def suggestHomePath(): String = "/dummy/"

  override def isValidSdkHome(path: String): Boolean = true

  override def suggestSdkName(currentSdkName: String, sdkHome: String): String = "Prism"

  override def createAdditionalDataConfigurable(sdkModel: SdkModel,
                                                sdkModificator: SdkModificator): AdditionalDataConfigurable = null

  override def getPresentableName: String = "Prism"

  override def saveAdditionalData(additionalData: SdkAdditionalData, additional: Element): Unit = println("test")
}

object PrismSdkType {

  def getInstance: PrismSdkType = SdkType.findInstance(classOf[PrismSdkType])
}
