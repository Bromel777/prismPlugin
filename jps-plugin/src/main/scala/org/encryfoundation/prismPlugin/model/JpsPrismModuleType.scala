package org.encryfoundation.prismPlugin.model

import org.jetbrains.jps.model.JpsDummyElement
import org.jetbrains.jps.model.ex.JpsElementTypeWithDummyProperties
import org.jetbrains.jps.model.module.JpsModuleType

final case class JpsPrismModuleType() extends JpsElementTypeWithDummyProperties with JpsModuleType[JpsDummyElement] {
  println("invoke JpsPrismModuleType!")
}

object JpsPrismModuleType {

  val instance: JpsPrismModuleType = {
    println("JpsPrismModuleType.instance")
    JpsPrismModuleType()
  }
}
