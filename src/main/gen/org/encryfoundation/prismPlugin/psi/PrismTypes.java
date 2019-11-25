// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.encryfoundation.prismPlugin.impl.*;

public interface PrismTypes {

  IElementType AND_TEST = new PrismCompositeElementType("AND_TEST");
  IElementType ARGS_LIST = new PrismCompositeElementType("ARGS_LIST");
  IElementType ARITH_EXPR = new PrismCompositeElementType("ARITH_EXPR");
  IElementType BASE_16_STR = new PrismCompositeElementType("BASE_16_STR");
  IElementType BASE_58_STR = new PrismCompositeElementType("BASE_58_STR");
  IElementType BOOLEAN_TYPE = new PrismCompositeElementType("BOOLEAN_TYPE");
  IElementType BOOL_EXPR = new PrismCompositeElementType("BOOL_EXPR");
  IElementType COMPARISON = new PrismCompositeElementType("COMPARISON");
  IElementType COMPR_OP = new PrismCompositeElementType("COMPR_OP");
  IElementType CONTRACT = new PrismCompositeElementType("CONTRACT");
  IElementType EXPR = new PrismCompositeElementType("EXPR");
  IElementType FUNCTION_DEFINITION = new PrismCompositeElementType("FUNCTION_DEFINITION");
  IElementType FUNC_CALL_EXPR = new PrismCompositeElementType("FUNC_CALL_EXPR");
  IElementType IDENTIFIERS_LIST = new PrismCompositeElementType("IDENTIFIERS_LIST");
  IElementType IF_EXPR = new PrismCompositeElementType("IF_EXPR");
  IElementType IF_LET_EXPR = new PrismCompositeElementType("IF_LET_EXPR");
  IElementType LAMB_EXPR = new PrismCompositeElementType("LAMB_EXPR");
  IElementType MATH_OP = new PrismCompositeElementType("MATH_OP");
  IElementType NOT_TEST = new PrismCompositeElementType("NOT_TEST");
  IElementType REFERENCED_IDENTIFIER = new PrismCompositeElementType("REFERENCED_IDENTIFIER");
  IElementType RIGHT_ARITH_EXPR = new PrismCompositeElementType("RIGHT_ARITH_EXPR");
  IElementType STMT = new PrismCompositeElementType("STMT");
  IElementType TYPE = new PrismCompositeElementType("TYPE");
  IElementType VARIABLE_DEFINITION = new PrismCompositeElementType("VARIABLE_DEFINITION");

  IElementType ADD = new PrismTokenType("+");
  IElementType AND = new PrismTokenType("&&");
  IElementType ANY_TYPE = new PrismTokenType("Any");
  IElementType BASE16 = new PrismTokenType("base16");
  IElementType BASE58 = new PrismTokenType("base58");
  IElementType BASE_STRING = new PrismTokenType("BASE_STRING");
  IElementType BOOLEAN_FALSE = new PrismTokenType("false");
  IElementType BOOLEAN_TRUE = new PrismTokenType("true");
  IElementType BOOL_TYPE = new PrismTokenType("Bool");
  IElementType BYTE_TYPE = new PrismTokenType("Byte");
  IElementType COLON = new PrismTokenType(":");
  IElementType CONTRACT_INIT = new PrismTokenType("contract");
  IElementType DEF = new PrismTokenType("def");
  IElementType DIV = new PrismTokenType("/");
  IElementType DOUBLE_QUOTES = new PrismTokenType("\"");
  IElementType ELSE = new PrismTokenType("else");
  IElementType EQ = new PrismTokenType("==");
  IElementType EQU = new PrismTokenType("=");
  IElementType GT = new PrismTokenType(">");
  IElementType GTE = new PrismTokenType(">=");
  IElementType IDENTIFIER = new PrismTokenType("IDENTIFIER");
  IElementType IF = new PrismTokenType("if");
  IElementType INT_TYPE = new PrismTokenType("Int");
  IElementType LAMB = new PrismTokenType("lamb");
  IElementType LEFT_CURLY_BRACKET = new PrismTokenType("{");
  IElementType LEFT_ROUND_BRACKET = new PrismTokenType("(");
  IElementType LET = new PrismTokenType("let");
  IElementType LT = new PrismTokenType("<");
  IElementType LTE = new PrismTokenType("<=");
  IElementType MOD = new PrismTokenType("%");
  IElementType MULT = new PrismTokenType("*");
  IElementType NOT = new PrismTokenType("NOT");
  IElementType NOTEQ = new PrismTokenType("<>");
  IElementType NUMBER = new PrismTokenType("NUMBER");
  IElementType OR = new PrismTokenType("||");
  IElementType POW = new PrismTokenType("**");
  IElementType RIGHT_CURLY_BRACKET = new PrismTokenType("}");
  IElementType RIGHT_ROUND_BRACKET = new PrismTokenType(")");
  IElementType SINGLE_QUOTE = new PrismTokenType("'");
  IElementType STRING = new PrismTokenType("STRING");
  IElementType STRING_TYPE = new PrismTokenType("Sting");
  IElementType SUB = new PrismTokenType("-");
  IElementType UNIT_TYPE = new PrismTokenType("Unit");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_TEST) {
        return new PrismAndTestImpl(node);
      }
      else if (type == ARGS_LIST) {
        return new PrismArgsListImpl(node);
      }
      else if (type == ARITH_EXPR) {
        return new PrismArithExprImpl(node);
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
      else if (type == BOOL_EXPR) {
        return new PrismBoolExprImpl(node);
      }
      else if (type == COMPARISON) {
        return new PrismComparisonImpl(node);
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
      else if (type == FUNC_CALL_EXPR) {
        return new PrismFuncCallExprImpl(node);
      }
      else if (type == IDENTIFIERS_LIST) {
        return new PrismIdentifiersListImpl(node);
      }
      else if (type == IF_EXPR) {
        return new PrismIfExprImpl(node);
      }
      else if (type == IF_LET_EXPR) {
        return new PrismIfLetExprImpl(node);
      }
      else if (type == LAMB_EXPR) {
        return new PrismLambExprImpl(node);
      }
      else if (type == MATH_OP) {
        return new PrismMathOpImpl(node);
      }
      else if (type == NOT_TEST) {
        return new PrismNotTestImpl(node);
      }
      else if (type == REFERENCED_IDENTIFIER) {
        return new PrismReferencedIdentifierImpl(node);
      }
      else if (type == RIGHT_ARITH_EXPR) {
        return new PrismRightArithExprImpl(node);
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
