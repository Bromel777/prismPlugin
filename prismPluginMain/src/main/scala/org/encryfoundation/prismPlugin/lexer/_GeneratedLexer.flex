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
STRING=[\"][a-zA-Z0-9_]*[\"]]
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
  "base58"           { return BASE58_STR; }
  "base16"           { return BASE16_STR; }
  "lamb"             { return LAMB_DEF; }
  "let"              { return VAR_DEF; }
  "contract"         { return CONTRACT_INIT; }
  "def"              { return DEF; }
  "Any"              { return ANY; }
  "Unit"             { return UNIT; }
  "Bool"             { return BOOL; }
  "Int"              { return INT; }
  "Byte"             { return BYTE; }

  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {IDENTIFIER}       { return IDENTIFIER; }
  {WHITE_SPACE}      { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
