package org.encryfoundation.prismPlugin.target

import java.io.File
import java.util
import scala.collection.JavaConverters._
import com.intellij.util.containers.ContainerUtil
import org.apache.commons.lang.NotImplementedException
import org.jetbrains.jps.builders._
import org.jetbrains.jps.builders.storage.BuildDataPaths
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.indices.IgnoredFileIndex
import org.jetbrains.jps.indices.ModuleExcludeIndex
import org.jetbrains.jps.model.JpsModel
import org.jetbrains.jps.model.java.{JavaSourceRootType, JpsJavaClasspathKind, JpsJavaExtensionService}
import org.jetbrains.jps.model.module.JpsModule

final case class PrismBuildTarget(targetType: PrismBuildTargetType, jpsModule: JpsModule)
  extends ModuleBasedTarget[PrismBuildRootDescriptor](targetType, jpsModule){

  println("invoke: PrismBuildTarget")

  override def getId: String = myModule.getName

  override def computeDependencies(targetRegistry: BuildTargetRegistry,
                                   outputIndex: TargetOutputIndex): util.Collection[BuildTarget[_ <: BuildRootDescriptor]] = {
    println("computeDependencies")
    val modules = JpsJavaExtensionService.dependencies(myModule).includedIn(JpsJavaClasspathKind.compile(isTests)).getModules
    modules.asScala.foldLeft(List.empty[BuildTarget[_ <: BuildRootDescriptor]]){
      case (acc, module) => acc :+ PrismBuildTarget(getPrismBuildTargetType, module)
    }.asJava
  }

  override def computeRootDescriptors(model: JpsModel,
                                      index: ModuleExcludeIndex,
                                      ignoredFileIndex: IgnoredFileIndex,
                                      dataPaths: BuildDataPaths): util.List[PrismBuildRootDescriptor] = {
    println("computeRootDescriptors")
    val `type` = if (isTests) JavaSourceRootType.TEST_SOURCE else JavaSourceRootType.SOURCE
    myModule.getSourceRoots(`type`).asScala.foldLeft(List.empty[PrismBuildRootDescriptor]) {
      case (acc, root) => acc :+ PrismBuildRootDescriptor(root.getFile, this)
    }.asJava
  }

  override def findRootDescriptor(rootId: String,
                                  rootIndex: BuildRootIndex): PrismBuildRootDescriptor = {
    println("findRootDescriptor")
    rootIndex.getRootDescriptors(
      new File(rootId),
      List(getPrismBuildTargetType).asJava,
      null
    ).asScala.head
  }

  override def getPresentableName: String = "prism build target represent"

  override def getOutputRoots(context: CompileContext): util.Collection[File] = {
    println("getOutputRoots")
    ContainerUtil.createMaybeSingletonList(JpsJavaExtensionService.getInstance.getOutputDirectory(myModule, isTests))
  }
  override def isTests: Boolean = false

  def getPrismBuildTargetType: PrismBuildTargetType = {
    println("getPrismBuildTargetType")
    getTargetType.asInstanceOf[PrismBuildTargetType]
  }
}
