package org.encryfoundation.prismPlugin.builders

import org.encryfoundation.prismPlugin.model.JpsPrismModuleType
import org.encryfoundation.prismPlugin.target.{PrismBuildRootDescriptor, PrismBuildTarget, PrismBuildTargetType}
import org.jetbrains.jps.builders.{BuildOutputConsumer, DirtyFilesHolder}
import org.jetbrains.jps.incremental.messages.{BuildMessage, CompilerMessage}
import org.jetbrains.jps.incremental.resources.{ResourcesBuilder, StandardResourceBuilderEnabler}
import org.jetbrains.jps.incremental.{CompileContext, TargetBuilder}
import org.jetbrains.jps.model.module.JpsModule

import scala.jdk.CollectionConverters._

class PrismBuilder() extends
  TargetBuilder[PrismBuildRootDescriptor, PrismBuildTarget](List(PrismBuildTargetType.instance).asJava){

  ResourcesBuilder.registerEnabler(new StandardResourceBuilderEnabler {
    override def isResourceProcessingEnabled(module: JpsModule): Boolean =
      !module.getModuleType.isInstanceOf[JpsPrismModuleType]
  })

  println("PrismBuilder")

  override def build(target: PrismBuildTarget,
                     holder: DirtyFilesHolder[PrismBuildRootDescriptor, PrismBuildTarget],
                     outputConsumer: BuildOutputConsumer,
                     context: CompileContext): Unit = {
    println("Call build method!")
    val message = new CompilerMessage("Prism compiler", BuildMessage.Kind.ERROR, "Test Error")
    throw new Exception("build")
    context.processMessage(message)
  }

  override def getPresentableName: String = {
    println("getPresentableName ")
    "Prism builder"
  }
}
