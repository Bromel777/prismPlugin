package org.encryfoundation.prismPlugin.syntax

import java.io.Reader

import org.encryfoundation.prismPlugin.lexer._GeneratedLexer
import com.google.common.collect.Sets
import com.intellij.lexer.FlexAdapter
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import org.encryfoundation.prismPlugin.psi.PrismTypes
import org.encryfoundation.prismPlugin.psi.PrismTypes._
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType


final case class PrismSyntaxHighlighter() extends SyntaxHighlighterBase {

  val ILLEGAL: TextAttributesKey = createTextAttributesKey("PONY_ILLEGAL", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)
  val STRING: TextAttributesKey = createTextAttributesKey("STRINGS", DefaultLanguageHighlighterColors.STRING)
  val ID: TextAttributesKey = createTextAttributesKey("ID", DefaultLanguageHighlighterColors.IDENTIFIER)
  val NUMBER: TextAttributesKey = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER)
  val KEYWORD: TextAttributesKey = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
  val FUNC_DEF: TextAttributesKey = createTextAttributesKey("FUNC_DEF", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
  val ML_STRING: TextAttributesKey = createTextAttributesKey("ML_STRING", DefaultLanguageHighlighterColors.DOC_COMMENT)
  val BRACKETS: TextAttributesKey = createTextAttributesKey("BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
  val SL_COMMENT: TextAttributesKey = createTextAttributesKey("SL_COMMENT_CONTENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  val CAP: TextAttributesKey = createTextAttributesKey("CAP", DefaultLanguageHighlighterColors.KEYWORD)
  val TYPE_ATTR: TextAttributesKey = createTextAttributesKey("TYPE", DefaultLanguageHighlighterColors.METADATA)
  val EQU_ATTR: TextAttributesKey = createTextAttributesKey("EQU", DefaultLanguageHighlighterColors.METADATA)
  val EMPTY = Array.empty[TextAttributesKey]

  private val KEYWORDS = Sets.newHashSet(BOOLEAN_TRUE, ARITM_EXPR, BASE_16_STR, BASE_58_STR, BOOLEAN_TYPE,
    COMPR_EXPR, COMPR_OP, CONTRACT, EXPR, FUNCTION_DEFINITION, LAMB_EXPR, MATH_OP, RIGHT_ARITH_EXPR,
    RIGHT_COMPR_EXPR, TYPE, VARIABLE_DEFINITION, ADD, ANY, BASE16_STR, BASE58_STR, BOOL, BOOLEAN_FALSE,
    BOOLEAN_TRUE, BYTE, CONTRACT_INIT, DEF, DIV, EQ, GT, GTE, IDENTIFIER, INT, LAMB_DEF, LT, LTE,
    MOD, MULT, NOTEQ, NUMBER, POW, STRING, SUB, UNIT, VAR_DEF, LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET,
    LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET, EQU)

  override def getHighlightingLexer: Lexer = new FlexAdapter(new _GeneratedLexer(null.asInstanceOf[Reader]))

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = tokenType match {
    case TokenType.BAD_CHARACTER =>
      println("illigal")
      Array(ILLEGAL)
    case PrismTypes.STRING =>
      println("string")
      Array(STRING)
    case PrismTypes.IDENTIFIER =>
      println("id")
      Array(ID)
    case DEF => Array(FUNC_DEF)
    case LEFT_CURLY_BRACKET | RIGHT_CURLY_BRACKET | LEFT_CURLY_BRACKET | RIGHT_CURLY_BRACKET => Array(BRACKETS)
    case TYPE => Array(TYPE_ATTR)
    case EQU => Array(EQU_ATTR)
    case keyword if KEYWORDS.contains(keyword) =>
      println("keyword")
      Array(KEYWORD)
    case PrismTypes.INT =>
      println("int")
      Array(NUMBER)
    case _ =>
      println("empty!!!")
      EMPTY
  }
}
