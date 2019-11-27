package org.encryfoundation.prismPlugin.psi

import com.intellij.psi.tree.IElementType

import scala.util.Try

object PrismTypeInferenceUtil {

  def inferredTypeCorrespondsToDeclaredType(pvd: PrismVariableDefinition): (Boolean, Option[IElementType], Option[IElementType]) = {
    val (inferredOpt, declaredOpt) = inferVarDefinitionType(pvd)
    val result = declaredOpt.forall { declared =>
      if (declared == PrismTypes.ANY_TYPE || declared == PrismTypes.UNIT_TYPE) true
      else inferredOpt.contains(declared)
    }
    (result, inferredOpt, declaredOpt)
  }

  // returns inferred type and declared type
  def inferVarDefinitionType(pvd: PrismVariableDefinition): (Option[IElementType], Option[IElementType]) =
    (inferExpressionType(pvd.getExpr), Option(pvd.getType).flatMap(prismTypeToElementType))

  def inferExpressionType(expr: PrismExpr): Option[IElementType] =
    expr match {
      case _ if expr.getArithExpr    != null => Some(PrismTypes.INT_TYPE)
      case _ if expr.getBoolExpr     != null => Some(PrismTypes.BOOL_TYPE)
      case _ if expr.getStmt         != null => inferStatementType(expr.getStmt)
      case _ if expr.getFuncCallExpr != null => PrismUtil.findFunctionDefinition(expr.getFuncCallExpr).headOption.map(_.getType).flatMap(prismTypeToElementType)
      case _ if expr.getLambExpr     != null => Some(PrismTypes.LAMB)
      case _ if expr.getIfExpr       != null => Try {
        val firstType = inferExpressionType(expr.getIfExpr.getExprList.get(0)).getOrElse(PrismTypes.ANY_TYPE)
        val secondType = inferExpressionType(expr.getIfExpr.getExprList.get(1)).getOrElse(PrismTypes.ANY_TYPE)
        if (firstType != secondType) PrismTypes.ANY_TYPE else firstType //todo common type inference
      }.toOption
      case _ if expr.getIfLetExpr    != null => None //todo

    }

  def inferStatementType(stmt: PrismStmt): Option[IElementType] = stmt match {
    case _ if stmt.getBase16Str != null            => Some(PrismTypes.BASE16)
    case _ if stmt.getBase58Str != null            => Some(PrismTypes.BASE58)
    case _ if stmt.getBooleanType != null          => Some(PrismTypes.BOOL_TYPE)
    case _ if stmt.getNumber != null               => Some(PrismTypes.INT_TYPE)
    case _ if stmt.getString != null               => Some(PrismTypes.STRING_TYPE)
    case _ if stmt.getReferencedIdentifier != null => inferenceReferencedIdentifierType(stmt.getReferencedIdentifier)
  }

  def inferenceReferencedIdentifierType(ident: PrismReferencedIdentifier): Option[IElementType] = Try {
    val defInferred = PrismUtil
      .findVariableDefinitionInGlobalScope(ident, ident.getText)
      .headOption
      .flatMap { pvd =>
        val inferred = inferVarDefinitionType(pvd)
        inferred._2.orElse(inferred._1)
      }

    def fromArgs: Option[IElementType] = PrismUtil
        .findVariableInArgs(ident).headOption.flatMap(_._2).flatMap(prismTypeToElementType)

    fromArgs.orElse(defInferred).get
  }.toOption

  def prismTypeToElementType(pt: PrismType): Option[IElementType] = pt.getText match {
    case "Any"    => Some(PrismTypes.ANY_TYPE)
    case "Unit"   => Some(PrismTypes.UNIT_TYPE)
    case "Bool"   => Some(PrismTypes.BOOL_TYPE)
    case "Int"    => Some(PrismTypes.INT_TYPE)
    case "Byte"   => Some(PrismTypes.BYTE_TYPE)
    case "String" => Some(PrismTypes.STRING_TYPE)
    case _        => None
  }

}
