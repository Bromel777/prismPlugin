package org.encryfoundation.prismPlugin.builders

import java.io.File
import java.nio.charset.Charset

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.{BaseOSProcessHandler, ProcessEvent, ProcessListener}
import com.intellij.openapi.util.Key
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

import scala.collection.JavaConverters._

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
    val outputDirectory = getOutputDirectory(target.getModule, forTests = false, context)
    context.processMessage(new ProgressMessage("Compiling Prism sources"))
    runPrismC(target.getModule, outputDirectory, context)
    context.checkCanceled()
    context.processMessage(new ProgressMessage(""))
  }

  def runPrismC(module: JpsModule,
                outputDirectory: File,
                compileContext: CompileContext): Unit = {
    val jpsInter = PrismJpsInterface(module, compileContext)
    val commandLine = jpsInter.buildCommandLine
    val fileToCompile = new File(
      module.getContentRootsList.getUrls.get(0).substring("file://".length)
    ).listFiles()
      .find(file => getFileExtension(file) == "pr")
      .head
    println(fileToCompile.getAbsoluteFile)
    commandLine.addParameter(fileToCompile.getAbsolutePath)
    println(s"command: ${commandLine.getCommandLineString}")
    val handler = new BaseOSProcessHandler(
      commandLine.createProcess(),
      commandLine.getCommandLineString,
      Charset.defaultCharset()
    )
    handler.addProcessListener(PrismCProcessListener())
    handler.startNotify()
    handler.waitFor()
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

  private def getFileExtension(file: File) = {
    val fileName = file.getName
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) fileName.substring(fileName.lastIndexOf(".") + 1)
    else ""
  }

  case class PrismCProcessListener() extends ProcessListener {

    var parsingState = "Start"

    override def startNotified(event: ProcessEvent): Unit = ()

    override def processTerminated(event: ProcessEvent): Unit = ()

    override def processWillTerminate(event: ProcessEvent, willBeDestroyed: Boolean): Unit = ()

    override def onTextAvailable(event: ProcessEvent, outputType: Key[_]): Unit = ()
  }
}

