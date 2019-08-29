package org.encryfoundation.prismPlugin.scope

import java.util
import java.util.{Collections, stream}

import scala.jdk.CollectionConverters._
import java.util.stream.Collectors

import com.intellij.compiler.impl.BuildTargetScopeProvider
import com.intellij.compiler.server.impl.BuildProcessClasspathManager
import com.intellij.openapi.compiler.CompileScope
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.NotNull
import org.jetbrains.jps.api.CmdlineProtoUtil
import com.intellij.openapi.module.Module
import org.encryfoundation.prismPlugin.target.PrismBuildTargetType
import org.jetbrains.jps.api.CmdlineRemoteProto.Message.ControllerMessage.ParametersMessage.TargetTypeBuildScope

class PrismBuildScopeProvider extends BuildTargetScopeProvider {

  val a = BuildProcessClasspathManager

  override def getBuildTargetScopes(baseScope: CompileScope,
                                    project: Project,
                                    forceBuild: Boolean): util.List[TargetTypeBuildScope] = {
    System.out.println("getBuildTargetScopes was called")
    val modules = List(baseScope.getAffectedModules).flatten
    val moduleIds = modules.map(_.getName).asJava
    val scope = CmdlineProtoUtil.createTargetsScope(PrismBuildTargetType.instance.getTypeId, moduleIds, true)
    Collections.singletonList(scope)
  }
}
