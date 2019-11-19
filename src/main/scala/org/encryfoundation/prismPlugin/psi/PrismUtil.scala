package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.PsiManager
import com.intellij.psi.search.{FileTypeIndex, GlobalSearchScope}
import org.encryfoundation.prismPlugin.PrismFileType

import collection.JavaConverters._

object PrismUtil {

  def findVariableDefinition(project: Project, key: String): Vector[PrismVariableDefinition] = {
    val virtualFiles = FileTypeIndex.getFiles(PrismFileType.INSTANCE, GlobalSearchScope.allScope(project))

    virtualFiles.asScala.foldLeft(Vector.empty[PrismVariableDefinition]) { case (acc, virtualFile) =>
      val file = PsiManager.getInstance(project).findFile(virtualFile)
        println(file.getChildren.map(_.getClass).mkString(", "))
        if (file != null) {
          val props = PsiTreeUtil.getChildrenOfType(file.getFirstChild, classOf[PrismVariableDefinition])
          println(props)
          if (props != null) acc ++ props.filter(_.getIdentifier.getText == key)
          else acc
        } else acc
    }
  }

  def findVariableDefinition(project: Project): Vector[PrismVariableDefinition] = {
    val virtualFiles = FileTypeIndex.getFiles(PrismFileType.INSTANCE, GlobalSearchScope.allScope(project))

    virtualFiles.asScala.foldLeft(Vector.empty[PrismVariableDefinition]) { case (acc, virtualFile) =>
      val file = PsiManager.getInstance(project).findFile(virtualFile)
      if (file != null) {
        val props = PsiTreeUtil.getChildrenOfType(file, classOf[PrismVariableDefinition])
        if (props != null) acc ++ props
        else acc
      } else acc
    }
  }

}
