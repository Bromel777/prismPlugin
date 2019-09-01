package org.encryfoundation.prismPlugin.builders

import java.io.File

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.util.io.FileUtil
import org.encryfoundation.prismPlugin.jps.PrismJpsInterface
import org.encryfoundation.prismPlugin.model.JpsPrismModuleType
import org.encryfoundation.prismPlugin.target.{PrismBuildRootDescriptor, PrismBuildTarget, PrismBuildTargetType}
import org.jetbrains.jps.builders.{BuildOutputConsumer, DirtyFilesHolder}
import org.jetbrains.jps.incremental.messages.{BuildMessage, CompilerMessage, ProgressMessage}
import org.jetbrains.jps.incremental.resources.{ResourcesBuilder, StandardResourceBuilderEnabler}
import org.jetbrains.jps.incremental.{CompileContext, TargetBuilder}
import org.jetbrains.jps.model.java.JpsJavaExtensionService
import org.jetbrains.jps.model.module.JpsModule

import scala.jdk.CollectionConverters._

class PrismBuilder() extends
  TargetBuilder[PrismBuildRootDescriptor, PrismBuildTarget](List(PrismBuildTargetType.instance).asJava){

  ResourcesBuilder.registerEnabler(new StandardResourceBuilderEnabler {
    override def isResourceProcessingEnabled(module: JpsModule): Boolean = {
      println(s"enable: ${!module.getModuleType.isInstanceOf[JpsPrismModuleType]}")
      !module.getModuleType.isInstanceOf[JpsPrismModuleType]
    }
  })

  println("PrismBuilder")

  override def build(target: PrismBuildTarget,
                     holder: DirtyFilesHolder[PrismBuildRootDescriptor, PrismBuildTarget],
                     outputConsumer: BuildOutputConsumer,
                     context: CompileContext): Unit = {
    System.out.println("Call build method!")
    val message = new CompilerMessage("Prism compiler", BuildMessage.Kind.ERROR, "Test Error")
    getOutputDirectory(target.getModule, forTests = false, context)
    //context.processMessage(message)
    println(s"Output stream: ")
    val jpsInter = PrismJpsInterface(target.getModule, context)
    val commandLine = jpsInter.buildCommandLine
    //throw new Exception("build")
  }

  def getOutputDirectory(module: JpsModule, forTests: Boolean, context: CompileContext): File = {
    context.processMessage(new ProgressMessage("getOutputDirectory"))
    val instance = JpsJavaExtensionService.getInstance
    context.processMessage(new ProgressMessage(s"getOutputDirectory: ${instance}"))
    val outputDirectory = instance.getOutputDirectory(module, forTests)
    if (outputDirectory == null) {
      val errorMessage = "No output dir for module " + module.getName
      context.processMessage(new CompilerMessage("prismc", BuildMessage.Kind.ERROR, errorMessage))
      println("123")
      throw new Exception(errorMessage)
    }
    if (!outputDirectory.exists) FileUtil.createDirectory(outputDirectory)
    println("456")
    outputDirectory
  }

  override def getPresentableName: String = {
    println("getPresentableName ")
    "Prism builder"
  }
}
