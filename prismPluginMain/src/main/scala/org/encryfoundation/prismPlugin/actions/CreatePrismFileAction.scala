package org.encryfoundation.prismPlugin.actions

import com.intellij.icons.AllIcons
import com.intellij.ide.actions.{CreateFileFromTemplateAction, CreateFileFromTemplateDialog}
import com.intellij.openapi.project.{DumbAware, Project}
import com.intellij.psi.PsiDirectory

case class CreatePrismFileAction() extends CreateFileFromTemplateAction(CreatePrismFileAction.NEW_PRISM_FILE, "", AllIcons.FileTypes.Custom)
  with DumbAware {

  override protected def buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder): Unit = {
    builder
      .setTitle(CreatePrismFileAction.NEW_PRISM_FILE)
      .addKind("Prism Contract", AllIcons.FileTypes.Custom, "Prism Contract")
  }

  override protected def getActionName(directory: PsiDirectory, newName: String, templateName: String): String = {
    System.out.println("HERE!!!")
    CreatePrismFileAction.NEW_PRISM_FILE
  }

  override def hashCode = 0

  override def equals(obj: Any): Boolean = obj.isInstanceOf[CreatePrismFileAction]
}

object CreatePrismFileAction {

  val NEW_PRISM_FILE = "New Prism File"
}
