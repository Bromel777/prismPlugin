package org.encryfoundation.prismPlugin.jps

import java.io.File

import com.intellij.execution.configurations.GeneralCommandLine
import org.jetbrains.jps.incremental.CompileContext
import org.encryfoundation.prismPlugin.model.JpsPrismSdkType
import org.jetbrains.jps.model.module.JpsModule

case class PrismJpsInterface private (rootDir: File, comilerFileName: File) {

  def buildCommandLine: GeneralCommandLine = {
    val commandLine = new GeneralCommandLine()
    commandLine.setExePath(comilerFileName.getAbsolutePath)
    commandLine
  }
}

object PrismJpsInterface {

  def apply(module: JpsModule, context: CompileContext): PrismJpsInterface = {
    val moduleRoot = module.getContentRootsList.getUrls.get(0).substring("file://".length)
    val rootDir = new File(moduleRoot)
    val sdk = module.getSdk(JpsPrismSdkType.instance)
    new PrismJpsInterface(rootDir, new File("/user/test"))
  }
}
