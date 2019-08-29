package org.encryfoundation.prismPlugin.builders

import org.encryfoundation.prismPlugin.target.{PrismBuildRootDescriptor, PrismBuildTarget, PrismBuildTargetType}
import org.jetbrains.jps.builders.{BuildOutputConsumer, DirtyFilesHolder}
import org.jetbrains.jps.incremental.messages.{BuildMessage, CompilerMessage}
import org.jetbrains.jps.incremental.{CompileContext, TargetBuilder}

import scala.jdk.CollectionConverters._

case class PrismBuilder() extends
  TargetBuilder[PrismBuildRootDescriptor, PrismBuildTarget](List(PrismBuildTargetType.instance).asJava){

  override def build(target: PrismBuildTarget,
                     holder: DirtyFilesHolder[PrismBuildRootDescriptor, PrismBuildTarget],
                     outputConsumer: BuildOutputConsumer,
                     context: CompileContext): Unit = {
    println("Call build method!")
    val message = new CompilerMessage("Prism compiler", BuildMessage.Kind.ERROR, "Test Error")
    context.processMessage(message)
  }

  override def getPresentableName: String = {
    println("getPresentableName ")
    "Prism builder"
  }
}
