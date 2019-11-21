package org.encryfoundation.prismPlugin.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.{PsiElement, PsiFile, PsiManager}
import com.intellij.psi.search.{FileTypeIndex, GlobalSearchScope}
import org.encryfoundation.prismPlugin.PrismFileType

import collection.JavaConverters._
import scala.collection.mutable
import scala.util.Try

object PrismUtil {

  def findVariableDefinition(project: Project, elem: PrismReferencedIdentifier): Vector[PsiElement] = {
    val virtualFiles = FileTypeIndex.getFiles(PrismFileType.INSTANCE, GlobalSearchScope.allScope(project))

    virtualFiles.asScala.foldLeft(Vector.empty[PsiElement]) { case (acc, virtualFile) =>
      val file = PsiManager.getInstance(project).findFile(virtualFile)
        if (file != null) {
          val foundGlobal = findVariableDefinitionInGlobalScope(file, elem)
          println(s"refs for ${elem.getText} from global are ${foundGlobal.map(_.getText).mkString(", ")}")
          val foundArgs = findVariableInArgs(elem)
          println(s"refs for ${elem.getText} from args are ${foundArgs.map(_.getText).mkString(", ")}")
          acc ++ foundArgs ++ foundGlobal
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

  def findVariableDefinitionInGlobalScope(file: PsiFile, elem: PrismReferencedIdentifier): Vector[PsiElement] = {
    val props = PsiTreeUtil.getChildrenOfType(file.getFirstChild, classOf[PrismVariableDefinition])
    if (props != null)
      props
        .filter(e => Try(e.getIdentifier.getText).toOption.contains(elem.getText))
        .takeWhile(_.getIdentifier.getTextRange.getEndOffset < elem.getTextRange.getStartOffset)
        .toVector
    else Vector.empty
  }

  def findVariableInArgs(elem: PrismReferencedIdentifier): Vector[PsiElement] = {

    def findInArgs(args: PrismArgsList): Option[PsiElement] =
      if (args == null) None
      else if (Try(args.getIdentifier.getText).toOption.contains(elem.getText)) Some(args.getIdentifier)
      else {
        val next = args.getArgsList
        if (next != null) findInArgs(next)
        else None
      }

    var parent = elem.getParent
    val buffer = mutable.Buffer[PsiElement]()
    if (parent == null || parent.isInstanceOf[PrismContract]) Vector.empty
    else {
      while (parent != null && !parent.isInstanceOf[PsiFile]) {
        val found = parent match {
          case pfd: PrismFunctionDefinition => findInArgs(pfd.getArgsList)
          case lamb: PrismLambExpr => findInArgs(lamb.getArgsList)
          case cont: PrismContract => findInArgs(cont.getArgsList)
          case _ => None
        }
        found.foreach(e => buffer.append(e))
        parent = parent.getParent
      }
      buffer.toVector
    }
  }

  def findFunctionDefinition(elem: PrismFuncCallExpr): Vector[PrismFunctionDefinition] = {
    var parent = elem.getParent
    val buffer = mutable.Buffer[PrismFunctionDefinition]()
    if (parent == null) Vector.empty
    else {
      while (parent != null && !parent.isInstanceOf[PsiFile]) {
        val props: Array[PrismFunctionDefinition] = PsiTreeUtil.getChildrenOfType(parent, classOf[PrismFunctionDefinition])
        //println("props")
        //println(s"parent is ${parent.getClass}")
        //println(props)
        //if (props != null) println(props.map(_.getClass).mkString(", "))
        //if (props != null) println(props.map(_.getIdentifier.getText).mkString(", "))
        //println(parent.getChildren.map(_.getClass).mkString(", "))
        //println(parent.getChildren.map(_.getText).mkString(", "))
        val found =
          if (props == null) Array.empty[PrismFunctionDefinition]
          else props.filter(_.getIdentifier.getText == elem.getReferencedIdentifier.getIdentifier.getText)
        //println(s"found: ${found.map(_.getText).mkString(", ")}")
        found.foreach(e => buffer.append(e))
        parent = parent.getParent
      }
      buffer.toVector
    }
  }

}
