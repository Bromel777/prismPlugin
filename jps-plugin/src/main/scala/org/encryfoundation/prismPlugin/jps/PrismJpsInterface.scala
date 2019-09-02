package org.encryfoundation.prismPlugin.jps

import java.io.File

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.{CapturingProcessHandler, OSProcessHandler, ProcessOutput}
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.roots.impl.OrderEntryUtil
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar
import org.apache.commons.io.FilenameUtils
import org.jetbrains.jps.incremental.{CompileContext, ProjectBuildException}
import org.encryfoundation.prismPlugin.model.{JpsPrismModuleType, JpsPrismSdkType}
import org.jetbrains.jps.incremental.messages.{BuildMessage, CompilerMessage}
import org.jetbrains.jps.model.module.JpsModule

case class PrismJpsInterface private (rootDir: File, comilerFileName: File) {

  def buildCommandLine: GeneralCommandLine = {
    val commandLine = new GeneralCommandLine()
    commandLine.setExePath("java")
    commandLine.withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType. CONSOLE)
    commandLine.addParameters("-jar",
      comilerFileName.getAbsolutePath,
    )
    System.out.println("command: " + commandLine.getCommandLineString)
    commandLine
  }

  private def getFileExtension(file: File) = {
    val fileName = file.getName
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) fileName.substring(fileName.lastIndexOf(".") + 1)
    else ""
  }
}

object PrismJpsInterface {

  import scala.jdk.CollectionConverters._

  def apply(module: JpsModule, context: CompileContext): PrismJpsInterface = {
    val moduleRoot = module.getContentRootsList.getUrls.get(0).substring("file://".length)
    println("libs:" + module.getLibraryCollection)
    val rootDir = new File(moduleRoot)
    println(s"rootDir: $rootDir")
    println(s"sdks in project: ${module.getProject.getLibraryCollection.getLibraries.asScala.map(lib => lib.toString).mkString(",")}")
    val sdk = module.getSdk(JpsPrismSdkType.instance)
    println(s"sdk: ${sdk}")
    new PrismJpsInterface(rootDir, new File("/Users/aleksandr/IdeaProjects/PrismLang/target/scala-2.12/Prism.jar"))
  }
}
