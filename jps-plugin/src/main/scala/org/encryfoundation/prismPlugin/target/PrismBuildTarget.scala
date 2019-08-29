package org.encryfoundation.prismPlugin.target

import java.io.File
import java.util

import org.apache.commons.lang.NotImplementedException
import org.jetbrains.jps.builders._
import org.jetbrains.jps.builders.storage.BuildDataPaths
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.indices.IgnoredFileIndex
import org.jetbrains.jps.indices.ModuleExcludeIndex
import org.jetbrains.jps.model.JpsModel

class PrismBuildTarget(targetType: PrismBuildTargetType) extends BuildTarget[PrismBuildRootDescriptor](targetType){

  override def getId: String = "prism build target"

  override def computeDependencies(targetRegistry: BuildTargetRegistry,
                                   outputIndex: TargetOutputIndex): util.Collection[BuildTarget[_ <: BuildRootDescriptor]] =
    {
      println("computeDependencies")
      throw new NotImplementedException("computeDependencies")
    }

  override def computeRootDescriptors(model: JpsModel,
                                      index: ModuleExcludeIndex,
                                      ignoredFileIndex: IgnoredFileIndex,
                                      dataPaths: BuildDataPaths): util.List[PrismBuildRootDescriptor] =
    {
      println("computeRootDescriptors")
      throw new NotImplementedException("computeRootDescriptors")
    }

  override def findRootDescriptor(rootId: String,
                                  rootIndex: BuildRootIndex): PrismBuildRootDescriptor =
    {
      println("findRootDescriptor")
      throw new NotImplementedException("findRootDescriptor")
    }

  override def getPresentableName: String = "prism build target represent"

  override def getOutputRoots(context: CompileContext): util.Collection[File] =
    throw new NotImplementedException("getOutputRoots")
}
