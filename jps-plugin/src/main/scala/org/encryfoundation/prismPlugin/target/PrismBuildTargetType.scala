package org.encryfoundation.prismPlugin.target

import java.util

import org.apache.commons.lang.NotImplementedException
import org.jetbrains.jps.builders.{BuildTargetLoader, BuildTargetType}
import org.jetbrains.jps.model.JpsModel

case class PrismBuildTargetType(typeId: String,
                                fileBased: Boolean) extends BuildTargetType[PrismBuildTarget](typeId, fileBased){

  override def computeAllTargets(model: JpsModel): util.List[PrismBuildTarget] =
    {
      println("computeAllTargets")
      throw new NotImplementedException("compute all targets not implemented")
    }

  override def createLoader(model: JpsModel): BuildTargetLoader[PrismBuildTarget] =
    {
      println("createLoader")
      throw new NotImplementedException("createLoader")
    }
}

object PrismBuildTargetType {

  val instance: PrismBuildTargetType = PrismBuildTargetType("Prism-building-type", fileBased = true)
}
