package org.encryfoundation.prismPlugin.target

import java.io.File

import org.jetbrains.jps.builders.BuildRootDescriptor

case class PrismBuildRootDescriptor(root: File, rootId: String, target: PrismBuildTarget) extends BuildRootDescriptor {

  override def getRootId: String = rootId

  override def getRootFile: File = {
    println("getRootFile")
    root
  }

  override def getTarget: PrismBuildTarget = target
}
