package org.encryfoundation.prismPlugin.target

import java.io.File
import org.jetbrains.jps.builders.BuildRootDescriptor

case class PrismBuildRootDescriptor(root: File, target: PrismBuildTarget) extends BuildRootDescriptor {

  override def getRootId: String = root.getAbsolutePath

  override def getRootFile: File = {
    println("getRootFile")
    root
  }

  override def getTarget: PrismBuildTarget = target
}
