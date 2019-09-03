// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.encryfoundation.prismPlugin.impl.*;

public interface PrismTypes {

  IElementType ARGS_LIST = new PrismElementType("ARGS_LIST");
  IElementType ARITM_EXPR = new PrismElementType("ARITM_EXPR");
  IElementType BASE_16_STR = new PrismElementType("BASE_16_STR");
  IElementType BASE_58_STR = new PrismElementType("BASE_58_STR");
  IElementType BOOLEAN_TYPE = new PrismElementType("BOOLEAN_TYPE");
  IElementType COMPR_EXPR = new PrismElementType("COMPR_EXPR");
  IElementType COMPR_OP = new PrismElementType("COMPR_OP");
  IElementType CONTRACT = new PrismElementType("CONTRACT");
  IElementType EXPR = new PrismElementType("EXPR");
  IElementType FUNCTION_DEFINITION = new PrismElementType("FUNCTION_DEFINITION");
  IElementType LAMB_EXPR = new PrismElementType("LAMB_EXPR");
  IElementType MATH_OP = new PrismElementType("MATH_OP");
  IElementType RIGHT_ARITH_EXPR = new PrismElementType("RIGHT_ARITH_EXPR");
  IElementType RIGHT_COMPR_EXPR = new PrismElementType("RIGHT_COMPR_EXPR");
  IElementType STMT = new PrismElementType("STMT");
  IElementType TYPE = new PrismElementType("TYPE");
  IElementType VARIABLE_DEFINITION = new PrismElementType("VARIABLE_DEFINITION");

  IElementType ADD = new PrismTokenType("+");
  IElementType ANY = new PrismTokenType("Any");
  IElementType BASE16_STR = new PrismTokenType("Base16_STR");
  IElementType BASE58_STR = new PrismTokenType("base58");
  IElementType BOOL = new PrismTokenType("Bool");
  IElementType BOOLEAN_FALSE = new PrismTokenType("false");
  IElementType BOOLEAN_TRUE = new PrismTokenType("true");
  IElementType BYTE = new PrismTokenType("Byte");
  IElementType COLON = new PrismTokenType(":");
  IElementType CONTRACT_INIT = new PrismTokenType("contract");
  IElementType DEF = new PrismTokenType("def");
  IElementType DIV = new PrismTokenType("/");
  IElementType EQ = new PrismTokenType("==");
  IElementType EQU = new PrismTokenType("=");
  IElementType GT = new PrismTokenType(">");
  IElementType GTE = new PrismTokenType(">=");
  IElementType IDENTIFIER = new PrismTokenType("IDENTIFIER");
  IElementType INT = new PrismTokenType("Int");
  IElementType LAMB_DEF = new PrismTokenType("lamb");
  IElementType LEFT_CURLY_BRACKET = new PrismTokenType("{");
  IElementType LEFT_ROUND_BRACKET = new PrismTokenType("(");
  IElementType LT = new PrismTokenType("<");
  IElementType LTE = new PrismTokenType("<=");
  IElementType MOD = new PrismTokenType("%");
  IElementType MULT = new PrismTokenType("*");
  IElementType NOTEQ = new PrismTokenType("<>");
  IElementType NUMBER = new PrismTokenType("NUMBER");
  IElementType POW = new PrismTokenType("**");
  IElementType RIGHT_CURLY_BRACKET = new PrismTokenType("}");
  IElementType RIGHT_ROUND_BRACKET = new PrismTokenType(")");
  IElementType STRING = new PrismTokenType("String");
  IElementType SUB = new PrismTokenType("-");
  IElementType UNIT = new PrismTokenType("Unit");
  IElementType VAR_DEF = new PrismTokenType("let");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGS_LIST) {
        return new PrismArgsListImpl(node);
      }
      else if (type == ARITM_EXPR) {
        return new PrismAritmExprImpl(node);
      }
      else if (type == BASE_16_STR) {
        return new PrismBase16StrImpl(node);
      }
      else if (type == BASE_58_STR) {
        return new PrismBase58StrImpl(node);
      }
      else if (type == BOOLEAN_TYPE) {
        return new PrismBooleanTypeImpl(node);
      }
      else if (type == COMPR_EXPR) {
        return new PrismComprExprImpl(node);
      }
      else if (type == COMPR_OP) {
        return new PrismComprOpImpl(node);
      }
      else if (type == CONTRACT) {
        return new PrismContractImpl(node);
      }
      else if (type == EXPR) {
        return new PrismExprImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new PrismFunctionDefinitionImpl(node);
      }
      else if (type == LAMB_EXPR) {
        return new PrismLambExprImpl(node);
      }
      else if (type == MATH_OP) {
        return new PrismMathOpImpl(node);
      }
      else if (type == RIGHT_ARITH_EXPR) {
        return new PrismRightArithExprImpl(node);
      }
      else if (type == RIGHT_COMPR_EXPR) {
        return new PrismRightComprExprImpl(node);
      }
      else if (type == STMT) {
        return new PrismStmtImpl(node);
      }
      else if (type == TYPE) {
        return new PrismTypeImpl(node);
      }
      else if (type == VARIABLE_DEFINITION) {
        return new PrismVariableDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
