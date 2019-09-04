package org.encryfoundation.prismPlugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.encryfoundation.prismPlugin.psi.PrismTypes.*;

%%

%{
  public _GeneratedLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _GeneratedLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

NUMBER=[0-9]+
STRING=[\"][a-zA-Z0-9_]*[\"]
BASE_STRING=['][a-zA-Z0-9_]*[']
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
WHITE_SPACE=[ \t\n\x0B\f\r]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "true"             { return BOOLEAN_TRUE; }
  "false"            { return BOOLEAN_FALSE; }
  "<"                { return LT; }
  ">"                { return GT; }
  "=="               { return EQ; }
  ">="               { return GTE; }
  "<="               { return LTE; }
  "<>"               { return NOTEQ; }
  "+"                { return ADD; }
  "-"                { return SUB; }
  "**"               { return POW; }
  "*"                { return MULT; }
  "/"                { return DIV; }
  "%"                { return MOD; }
  "Any"              { return ANY_TYPE; }
  "Unit"             { return UNIT_TYPE; }
  "Bool"             { return BOOL_TYPE; }
  "Int"              { return INT_TYPE; }
  "Byte"             { return BYTE_TYPE; }
  "Sting"            { return STRING_TYPE; }
  "{"                { return LEFT_CURLY_BRACKET; }
  "}"                { return RIGHT_CURLY_BRACKET; }
  "("                { return LEFT_ROUND_BRACKET; }
  ")"                { return RIGHT_ROUND_BRACKET; }
  "="                { return EQU; }
  ":"                { return COLON; }
  "\""               { return DOUBLE_QUOTES; }
  "'"                { return SINGLE_QUOTE; }
  "lamb"             { return LAMB_DEF; }
  "let"              { return VAR_DEF; }
  "contract"         { return CONTRACT_INIT; }
  "base58"           { return BASE58; }
  "base16"           { return BASE16; }
  "def"              { return DEF; }

  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {BASE_STRING}      { return BASE_STRING; }
  {IDENTIFIER}       { return IDENTIFIER; }
  {WHITE_SPACE}      { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
