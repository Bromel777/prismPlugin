package org.encryfoundation.prismPlugin.psi

import com.intellij.codeInsight.lookup.{LookupElement, LookupElementBuilder}
import com.intellij.openapi.util.TextRange
import com.intellij.psi.{PsiElement, PsiElementResolveResult, PsiReference, ResolveResult, ResolveState}
import org.encryfoundation.prismPlugin.Icons

import collection.JavaConverters._

case class PrismVariableReferenceImpl(element: PrismVariableDefinition, range: TextRange)
  extends PrismPsiPolyVariantCachingReferenceBase[PrismVariableDefinition](element: PrismVariableDefinition, range: TextRange) {

  //println(element.getType)
  //println(element.getFuncCallExpr)
  //println(element.getExprWODeclr)
  //println(element.getText)
  //println(element.getIdentifier.getText)
  //println(element.getNameIdentifier.getText)

  val keyOpt: Option[String] = Option(element.getStmt).flatMap(stmt => Option(stmt.getIdentifier)).map(_.getText)

//  override def multiResolve(incompleteCode: Boolean): Array[ResolveResult] = {
//    val processor = PrismVarProcessor(element.getText, element)
//    val place = myElement
//    ResolveUtil.treeWalkUp(place, processor)
//    val result = processor.getAllResults()
//    if (!result.isEmpty) {
//      println(s"result is ${result.asScala.mkString(", ")}")
//      PsiElementResolveResult.createResults(result)
//    } else {
//      println("empty result!")
//      Array.empty[ResolveResult]
//    }
//  }

  override def multiResolve(incompleteCode: Boolean): Array[ResolveResult] = {
    println(element.getText)
    println(s"key $keyOpt")
    val r = keyOpt match {
      case Some(key) => PsiElementResolveResult.createResults(PrismUtil.findVariableDefinition(myElement.getProject, key): _*)
      case None => Array.empty[ResolveResult]
    }

    r
  }

  override def resolve(): PsiElement = multiResolve(false).headOption.map(_.getElement).orNull

  override def getVariants: Array[AnyRef] =
    PrismUtil.findVariableDefinition(myElement.getProject).foldLeft(Vector.empty[LookupElement]) { case (acc, el) =>
        if (el.getIdentifier != null && el.getIdentifier.getText.length > 0)
          acc :+ LookupElementBuilder.create(el).withIcon(Icons.prismLogo).withTypeText(el.getContainingFile.getName)
        else acc
    }.toArray


}
