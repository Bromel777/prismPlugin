package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import org.encryfoundation.prismPlugin.PrismFileType

object PrismElementFactory {

  def createVariableDefinition(project: Project, name: String): PrismVariableDefinition =
    PsiFileFactory
      .getInstance(project)
      .createFileFromText(name, PrismFileType.INSTANCE, "")
      .getFirstChild
      .asInstanceOf[PrismVariableDefinition]

}
