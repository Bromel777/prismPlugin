package org.encryfoundation.prismPlugin.builders

import java.util
import scala.jdk.CollectionConverters._
import org.encryfoundation.prismPlugin.target.PrismBuildTargetType
import org.jetbrains.jps.builders.{BuildRootDescriptor, BuildTarget, BuildTargetType}
import org.jetbrains.jps.incremental.{BuilderService, TargetBuilder}

class PrismBuildService extends BuilderService {

  override def getTargetTypes: util.List[PrismBuildTargetType] = {
    println("getTargetTypes")
    List(PrismBuildTargetType.instance).asJava
  }

  override def createBuilders(): util.List[PrismBuilder] = {
    println("Called createBuilders")
    List(PrismBuilder()).asJava
  }
}
