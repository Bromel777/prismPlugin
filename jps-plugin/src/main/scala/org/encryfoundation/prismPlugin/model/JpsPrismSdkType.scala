package org.encryfoundation.prismPlugin.model

import org.jetbrains.jps.model.{JpsDummyElement, JpsElementFactory, JpsElementTypeWithDefaultProperties}
import org.jetbrains.jps.model.library.sdk.JpsSdkType

final case class JpsPrismSdkType()
  extends JpsSdkType[JpsDummyElement]
    with JpsElementTypeWithDefaultProperties[JpsDummyElement]{

  override def createDefaultProperties(): JpsDummyElement = JpsElementFactory.getInstance().createDummyElement()
}

object JpsPrismSdkType {
  val instance = JpsPrismSdkType()
}
