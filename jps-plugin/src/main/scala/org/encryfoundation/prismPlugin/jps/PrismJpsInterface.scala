package org.encryfoundation.prismPlugin.jps

import java.io.File

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.application.ex.PathManagerEx
import com.intellij.openapi.roots.ProjectRootManager
import org.encryfoundation.prismPlugin.model.JpsPrismSdkType
import org.jetbrains.jps.incremental.CompileContext
import org.jetbrains.jps.model.module.JpsModule
import org.jetbrains.jps.model.library._

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
    context.getProjectDescriptor
      .getProjectJavaSdks
      .asScala
      .foreach(sdk => println(s"Sdk: ${sdk.getHomePath}"))
    println("libs:" + module.getLibraryCollection)
    val rootDir = new File(moduleRoot)
    val compilerPath = module.getProject
      .getLibraryCollection
      .getLibraries
      .asScala.filter { lib =>
        println(s"libName: ${lib.createReference().getLibraryName}")
        lib.createReference().getLibraryName == "Prism"
      }
      .flatMap { lib =>
        lib.getFiles(JpsOrderRootType.COMPILED).asScala
      }
      .head
    val sdk = module.getSdk(JpsPrismSdkType.instance)
    println(s"sdk: ${sdk}")
    new PrismJpsInterface(rootDir, compilerPath)
  }
}
