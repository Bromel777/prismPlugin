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

import scala.collection.immutable.HashSet

final case class PrismSyntaxHighlighter() extends SyntaxHighlighterBase {

  private val KEYWORDS = Sets.newHashSet(BOOLEAN_TRUE, ARITM_EXPR, BASE_16_STR, BASE_58_STR, BOOLEAN_TYPE,
    COMPR_EXPR, COMPR_OP, CONTRACT, EXPR, FUNCTION_DEFINITION, LAMB_EXPR, MATH_OP, RIGHT_ARITH_EXPR,
    RIGHT_COMPR_EXPR, TYPE, VARIABLE_DEFINITION, ADD, ANY_TYPE, BASE16_STR, BASE58_STR, BOOL_TYPE, BOOLEAN_FALSE,
    BOOLEAN_TRUE, BYTE_TYPE, CONTRACT_INIT, DEF, DIV, EQ, GT, GTE, IDENTIFIER, INT_TYPE, LAMB_DEF, LT, LTE,
    MOD, MULT, NOTEQ, NUMBER, POW, STRING, SUB, UNIT_TYPE, VAR_DEF, LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET,
    LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET, EQU)

  private val types = HashSet(INT_TYPE, BOOL_TYPE, UNIT_TYPE, BYTE_TYPE, STRING_TYPE, ANY_TYPE)

  override def getHighlightingLexer: Lexer = new FlexAdapter(new _GeneratedLexer(null.asInstanceOf[Reader]))

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = tokenType match {
    case TokenType.BAD_CHARACTER =>
      println("illigal")
      Array(PrismSyntaxHighlighter.ILLEGAL)
    case PrismTypes.STRING =>
      println("string")
      Array(PrismSyntaxHighlighter.STRING)
    case PrismTypes.IDENTIFIER =>
      println("id")
      Array(PrismSyntaxHighlighter.ID)
    case DEF => Array(PrismSyntaxHighlighter.FUNC_DEF)
    case LEFT_CURLY_BRACKET | RIGHT_CURLY_BRACKET | LEFT_CURLY_BRACKET | RIGHT_CURLY_BRACKET =>
      println("bracket")
      Array(PrismSyntaxHighlighter.BRACKETS)
    case type_word if types.contains(type_word) =>
      println("type")
      Array(PrismSyntaxHighlighter.TYPE_ATTR)
    case EQU => Array(PrismSyntaxHighlighter.EQU_ATTR)
    case keyword if KEYWORDS.contains(keyword) =>
      println(s"keyword: ${keyword}")
      Array(PrismSyntaxHighlighter.KEYWORD)
    case PrismTypes.INT_TYPE =>
      println("int")
      Array(PrismSyntaxHighlighter.NUMBER)
    case t =>
      println(s"empty!!! $t")
      PrismSyntaxHighlighter.EMPTY
  }
}

object PrismSyntaxHighlighter {

  val ILLEGAL: TextAttributesKey = createTextAttributesKey("PRISM_ILLEGAL", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE)
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
}