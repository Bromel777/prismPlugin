package org.encryfoundation.prismPlugin.jps

import java.io.File

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.{CapturingProcessHandler, OSProcessHandler, ProcessOutput}
import org.apache.commons.io.FilenameUtils
import org.jetbrains.jps.incremental.CompileContext
import org.encryfoundation.prismPlugin.model.JpsPrismSdkType
import org.jetbrains.jps.model.module.JpsModule

case class PrismJpsInterface private (rootDir: File, comilerFileName: File) {

  def buildCommandLine: GeneralCommandLine = {
    rootDir.listFiles()
      .filter(file => getFileExtension(file) == "pr")
      .map{ file =>
        val filePath = file.getAbsolutePath
        val commandLine = new GeneralCommandLine()
        commandLine.setExePath("java")
        commandLine.withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType. CONSOLE)
        commandLine.addParameters("-jar",
          comilerFileName.getAbsolutePath,
          filePath
        )
        System.out.println("command: " + commandLine.getCommandLineString)
        val process = commandLine.createProcess()
        val handle = new OSProcessHandler(process, commandLine.getCommandLineString)
        handle.startNotify()
        commandLine
      }.head
  }

  def execute(cmd: GeneralCommandLine): ProcessOutput = {
    val processHandler = new CapturingProcessHandler(cmd)
    processHandler.runProcess()
  }

  private def getFileExtension(file: File) = {
    val fileName = file.getName
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) fileName.substring(fileName.lastIndexOf(".") + 1)
    else ""
  }
}

object PrismJpsInterface {

  def apply(module: JpsModule, context: CompileContext): PrismJpsInterface = {
    val moduleRoot = module.getContentRootsList.getUrls.get(0).substring("file://".length)
    val rootDir = new File(moduleRoot)
    println(s"rootDir: $rootDir")
    val sdk = module.getSdk(JpsPrismSdkType.instance)
    new PrismJpsInterface(rootDir, new File("/Users/aleksandr/IdeaProjects/PrismLang/target/scala-2.12/Prism.jar"))
  }
}
