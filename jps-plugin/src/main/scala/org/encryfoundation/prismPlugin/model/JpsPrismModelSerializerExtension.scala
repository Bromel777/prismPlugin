package org.encryfoundation.prismPlugin.model

import java.util

import org.jdom.Element

import scala.jdk.CollectionConverters._
import org.jetbrains.jps.model.{JpsDummyElement, JpsElement, JpsElementFactory}
import org.jetbrains.jps.model.serialization.JpsModelSerializerExtension
import org.jetbrains.jps.model.serialization.module.JpsModulePropertiesSerializer

class JpsPrismModelSerializerExtension extends JpsModelSerializerExtension {

  override def getModulePropertiesSerializers: util.List[_ <: JpsModulePropertiesSerializer[_ <: JpsElement]] = {
    List(
      new JpsModulePropertiesSerializer[JpsDummyElement](JpsPrismModuleType.instance,
        "PRISM_MODULE",
        null) {
        override def loadProperties(componentElement: Element): JpsDummyElement =
          JpsElementFactory.getInstance().createDummyElement()

        override def saveProperties(properties: JpsDummyElement, componentElement: Element): Unit = ()
      }
    ).asJava
  }
}


