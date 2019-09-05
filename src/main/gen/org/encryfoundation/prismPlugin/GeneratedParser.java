// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.encryfoundation.prismPlugin.psi.PrismTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class GeneratedParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t instanceof IFileElementType) {
      r = parse_root_(t, b, 0);
    }
    else {
      r = false;
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return SimpleFile(b, l + 1);
  }

  /* ********************************************************** */
  // IDENTIFIER (COLON Type)? (',' ArgsList)?
  public static boolean ArgsList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgsList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && ArgsList_1(b, l + 1);
    r = r && ArgsList_2(b, l + 1);
    exit_section_(b, m, ARGS_LIST, r);
    return r;
  }

  // (COLON Type)?
  private static boolean ArgsList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgsList_1")) return false;
    ArgsList_1_0(b, l + 1);
    return true;
  }

  // COLON Type
  private static boolean ArgsList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgsList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' ArgsList)?
  private static boolean ArgsList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgsList_2")) return false;
    ArgsList_2_0(b, l + 1);
    return true;
  }

  // ',' ArgsList
  private static boolean ArgsList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgsList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && ArgsList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (NUMBER | IDENTIFIER) RightArithExpr
  public static boolean AritmExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AritmExpr")) return false;
    if (!nextTokenIs(b, "<aritm expr>", IDENTIFIER, NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARITM_EXPR, "<aritm expr>");
    r = AritmExpr_0(b, l + 1);
    r = r && RightArithExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NUMBER | IDENTIFIER
  private static boolean AritmExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AritmExpr_0")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // base16init BASE_STRING
  public static boolean BASE16_STR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BASE16_STR")) return false;
    if (!nextTokenIs(b, BASE16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = base16init(b, l + 1);
    r = r && consumeToken(b, BASE_STRING);
    exit_section_(b, m, BASE_16_STR, r);
    return r;
  }

  /* ********************************************************** */
  // base58init BASE_STRING
  public static boolean BASE58_STR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BASE58_STR")) return false;
    if (!nextTokenIs(b, BASE58)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = base58init(b, l + 1);
    r = r && consumeToken(b, BASE_STRING);
    exit_section_(b, m, BASE_58_STR, r);
    return r;
  }

  /* ********************************************************** */
  // (BooleanType | FuncCallExpr | IDENTIFIER | STMT) RightBoolExpr?
  public static boolean BoolExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_EXPR, "<bool expr>");
    r = BoolExpr_0(b, l + 1);
    r = r && BoolExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BooleanType | FuncCallExpr | IDENTIFIER | STMT
  private static boolean BoolExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolExpr_0")) return false;
    boolean r;
    r = BooleanType(b, l + 1);
    if (!r) r = FuncCallExpr(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = STMT(b, l + 1);
    return r;
  }

  // RightBoolExpr?
  private static boolean BoolExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BoolExpr_1")) return false;
    RightBoolExpr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BOOLEAN_TRUE | BOOLEAN_FALSE
  public static boolean BooleanType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanType")) return false;
    if (!nextTokenIs(b, "<boolean type>", BOOLEAN_FALSE, BOOLEAN_TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_TYPE, "<boolean type>");
    r = consumeToken(b, BOOLEAN_TRUE);
    if (!r) r = consumeToken(b, BOOLEAN_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AND | OR | GtE | LtE | NotEq | GT | LT | EQ
  public static boolean ComprOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ComprOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPR_OP, "<compr op>");
    r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, GTE);
    if (!r) r = consumeToken(b, LTE);
    if (!r) r = consumeToken(b, NOTEQ);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, EQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONTRACT_INIT LEFT_ROUND_BRACKET ArgsList? RIGHT_ROUND_BRACKET EQU LEFT_CURLY_BRACKET Expr* RIGHT_CURLY_BRACKET
  public static boolean Contract(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Contract")) return false;
    if (!nextTokenIs(b, CONTRACT_INIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONTRACT_INIT, LEFT_ROUND_BRACKET);
    r = r && Contract_2(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_ROUND_BRACKET, EQU, LEFT_CURLY_BRACKET);
    r = r && Contract_6(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACKET);
    exit_section_(b, m, CONTRACT, r);
    return r;
  }

  // ArgsList?
  private static boolean Contract_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Contract_2")) return false;
    ArgsList(b, l + 1);
    return true;
  }

  // Expr*
  private static boolean Contract_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Contract_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Contract_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // AritmExpr
  //     | BoolExpr
  //     | LambExpr
  //     | FunctionDefinition
  //     | VariableDefinition
  //     | IfExpr
  //     | IfLetExpr
  public static boolean Expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = AritmExpr(b, l + 1);
    if (!r) r = BoolExpr(b, l + 1);
    if (!r) r = LambExpr(b, l + 1);
    if (!r) r = FunctionDefinition(b, l + 1);
    if (!r) r = VariableDefinition(b, l + 1);
    if (!r) r = IfExpr(b, l + 1);
    if (!r) r = IfLetExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER LEFT_ROUND_BRACKET identifiers_list RIGHT_ROUND_BRACKET
  public static boolean FuncCallExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FuncCallExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, LEFT_ROUND_BRACKET);
    r = r && identifiers_list(b, l + 1);
    r = r && consumeToken(b, RIGHT_ROUND_BRACKET);
    exit_section_(b, m, FUNC_CALL_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // def IDENTIFIER LEFT_ROUND_BRACKET ArgsList? RIGHT_ROUND_BRACKET (COLON Type)? EQU LEFT_CURLY_BRACKET Expr RIGHT_CURLY_BRACKET
  public static boolean FunctionDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition")) return false;
    if (!nextTokenIs(b, DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DEF, IDENTIFIER, LEFT_ROUND_BRACKET);
    r = r && FunctionDefinition_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_ROUND_BRACKET);
    r = r && FunctionDefinition_5(b, l + 1);
    r = r && consumeTokens(b, 0, EQU, LEFT_CURLY_BRACKET);
    r = r && Expr(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACKET);
    exit_section_(b, m, FUNCTION_DEFINITION, r);
    return r;
  }

  // ArgsList?
  private static boolean FunctionDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_3")) return false;
    ArgsList(b, l + 1);
    return true;
  }

  // (COLON Type)?
  private static boolean FunctionDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_5")) return false;
    FunctionDefinition_5_0(b, l + 1);
    return true;
  }

  // COLON Type
  private static boolean FunctionDefinition_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDefinition_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF LEFT_ROUND_BRACKET BoolExpr RIGHT_ROUND_BRACKET LEFT_CURLY_BRACKET Expr? RIGHT_CURLY_BRACKET
  //                ELSE LEFT_CURLY_BRACKET Expr? RIGHT_CURLY_BRACKET
  public static boolean IfExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, LEFT_ROUND_BRACKET);
    r = r && BoolExpr(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_ROUND_BRACKET, LEFT_CURLY_BRACKET);
    r = r && IfExpr_5(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_CURLY_BRACKET, ELSE, LEFT_CURLY_BRACKET);
    r = r && IfExpr_9(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACKET);
    exit_section_(b, m, IF_EXPR, r);
    return r;
  }

  // Expr?
  private static boolean IfExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr_5")) return false;
    Expr(b, l + 1);
    return true;
  }

  // Expr?
  private static boolean IfExpr_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfExpr_9")) return false;
    Expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IF LEFT_ROUND_BRACKET VariableDefinition RIGHT_ROUND_BRACKET LEFT_CURLY_BRACKET Expr? RIGHT_CURLY_BRACKET
  //                   ELSE LEFT_CURLY_BRACKET Expr? RIGHT_CURLY_BRACKET
  public static boolean IfLetExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetExpr")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, LEFT_ROUND_BRACKET);
    r = r && VariableDefinition(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_ROUND_BRACKET, LEFT_CURLY_BRACKET);
    r = r && IfLetExpr_5(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_CURLY_BRACKET, ELSE, LEFT_CURLY_BRACKET);
    r = r && IfLetExpr_9(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACKET);
    exit_section_(b, m, IF_LET_EXPR, r);
    return r;
  }

  // Expr?
  private static boolean IfLetExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetExpr_5")) return false;
    Expr(b, l + 1);
    return true;
  }

  // Expr?
  private static boolean IfLetExpr_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetExpr_9")) return false;
    Expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LAMB LEFT_ROUND_BRACKET ArgsList RIGHT_ROUND_BRACKET EQU Expr
  public static boolean LambExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LambExpr")) return false;
    if (!nextTokenIs(b, LAMB)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LAMB, LEFT_ROUND_BRACKET);
    r = r && ArgsList(b, l + 1);
    r = r && consumeTokens(b, 0, RIGHT_ROUND_BRACKET, EQU);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, LAMB_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // ADD | SUB | POW | MULT | DIV | MOD
  public static boolean MathOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATH_OP, "<math op>");
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, POW);
    if (!r) r = consumeToken(b, MULT);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MathOp (NUMBER | IDENTIFIER) (RightArithExpr)?
  public static boolean RightArithExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightArithExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RIGHT_ARITH_EXPR, "<right arith expr>");
    r = MathOp(b, l + 1);
    r = r && RightArithExpr_1(b, l + 1);
    r = r && RightArithExpr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NUMBER | IDENTIFIER
  private static boolean RightArithExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightArithExpr_1")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  // (RightArithExpr)?
  private static boolean RightArithExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightArithExpr_2")) return false;
    RightArithExpr_2_0(b, l + 1);
    return true;
  }

  // (RightArithExpr)
  private static boolean RightArithExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightArithExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RightArithExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ComprOp (BooleanType | FuncCallExpr| IDENTIFIER | STMT) (RightBoolExpr)?
  public static boolean RightBoolExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightBoolExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RIGHT_BOOL_EXPR, "<right bool expr>");
    r = ComprOp(b, l + 1);
    r = r && RightBoolExpr_1(b, l + 1);
    r = r && RightBoolExpr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BooleanType | FuncCallExpr| IDENTIFIER | STMT
  private static boolean RightBoolExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightBoolExpr_1")) return false;
    boolean r;
    r = BooleanType(b, l + 1);
    if (!r) r = FuncCallExpr(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = STMT(b, l + 1);
    return r;
  }

  // (RightBoolExpr)?
  private static boolean RightBoolExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightBoolExpr_2")) return false;
    RightBoolExpr_2_0(b, l + 1);
    return true;
  }

  // (RightBoolExpr)
  private static boolean RightBoolExpr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RightBoolExpr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RightBoolExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BASE58_STR | BASE16_STR | NUMBER | STRING | BooleanType | IDENTIFIER
  public static boolean STMT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "STMT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STMT, "<stmt>");
    r = BASE58_STR(b, l + 1);
    if (!r) r = BASE16_STR(b, l + 1);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = BooleanType(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Contract
  static boolean SimpleFile(PsiBuilder b, int l) {
    return Contract(b, l + 1);
  }

  /* ********************************************************** */
  // ANY_TYPE | UNIT_TYPE | BOOL_TYPE | INT_TYPE | BYTE_TYPE | STRING_TYPE
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, ANY_TYPE);
    if (!r) r = consumeToken(b, UNIT_TYPE);
    if (!r) r = consumeToken(b, BOOL_TYPE);
    if (!r) r = consumeToken(b, INT_TYPE);
    if (!r) r = consumeToken(b, BYTE_TYPE);
    if (!r) r = consumeToken(b, STRING_TYPE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LET IDENTIFIER (COLON Type)? EQU (FuncCallExpr | STMT)
  public static boolean VariableDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LET, IDENTIFIER);
    r = r && VariableDefinition_2(b, l + 1);
    r = r && consumeToken(b, EQU);
    r = r && VariableDefinition_4(b, l + 1);
    exit_section_(b, m, VARIABLE_DEFINITION, r);
    return r;
  }

  // (COLON Type)?
  private static boolean VariableDefinition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2")) return false;
    VariableDefinition_2_0(b, l + 1);
    return true;
  }

  // COLON Type
  private static boolean VariableDefinition_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FuncCallExpr | STMT
  private static boolean VariableDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinition_4")) return false;
    boolean r;
    r = FuncCallExpr(b, l + 1);
    if (!r) r = STMT(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // base16
  static boolean base16init(PsiBuilder b, int l) {
    return consumeToken(b, BASE16);
  }

  /* ********************************************************** */
  // base58
  static boolean base58init(PsiBuilder b, int l) {
    return consumeToken(b, BASE58);
  }

  /* ********************************************************** */
  // IDENTIFIER ("," identifiers_list)?
  static boolean identifiers_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_list")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && identifiers_list_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ("," identifiers_list)?
  private static boolean identifiers_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_list_1")) return false;
    identifiers_list_1_0(b, l + 1);
    return true;
  }

  // "," identifiers_list
  private static boolean identifiers_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifiers_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && identifiers_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
