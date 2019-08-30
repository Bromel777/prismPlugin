package org.encryfoundation.prismPlugin.target

import java.util
import scala.jdk.CollectionConverters._
import org.apache.commons.lang.NotImplementedException
import org.encryfoundation.prismPlugin.model.JpsPrismModuleType
import org.jetbrains.jps.builders.{BuildTargetLoader, BuildTargetType, ModuleBasedBuildTargetType}
import org.jetbrains.jps.model.JpsModel

case class PrismBuildTargetType(typeId: String,
                                fileBased: Boolean) extends ModuleBasedBuildTargetType[PrismBuildTarget](typeId, fileBased){

  override def computeAllTargets(model: JpsModel): util.List[PrismBuildTarget] = {
    model.getProject.getModules.forEach(m => println(s"ModulegetModuleType: ${m.getModuleType}"))
    model.getProject.getModules.forEach(m => println(s"ModulegetProject: ${m.getProject}"))
    model.getProject.getModules.forEach(m => println(s"ModulegetModuleType: ${m.getModuleType}"))
    model.getProject.getModules.forEach(m => println(s"ModulegetMName: ${m.getName}"))
    model.getProject.getModules.forEach(m => println(s"ModulegetMName: ${m.getClass}"))
    println(s"models: ${model.getProject.getModules(JpsPrismModuleType.instance).forEach(m => println(s"ModulePr: ${m.getProperties}"))}")
    val target = model.getProject.getModules(JpsPrismModuleType.instance).asScala.foldLeft(List.empty[PrismBuildTarget]) {
      case (acc, module) => acc :+ PrismBuildTarget(this, module)
    }.asJava
    println(target)
    target
  }

  override def createLoader(model: JpsModel): BuildTargetLoader[PrismBuildTarget] =
    new BuildTargetLoader[PrismBuildTarget]() {
      override def createTarget(targetId: String): PrismBuildTarget = {
        model.getProject.getModules(JpsPrismModuleType.instance).asScala.foreach(module =>
          if (module.getName.equals(targetId)) {
            return PrismBuildTarget(PrismBuildTargetType.this, module)
          }
        )
        null
      }
    }
}

object PrismBuildTargetType {

  val instance: PrismBuildTargetType = PrismBuildTargetType("Prism-building-type", fileBased = true)
}
