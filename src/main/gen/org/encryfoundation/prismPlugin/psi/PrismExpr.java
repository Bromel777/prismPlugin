// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismExpr extends PrismCompositeElement {

  @Nullable
  PrismArithExpr getArithExpr();

  @Nullable
  PrismBoolExpr getBoolExpr();

  @Nullable
  PrismFuncCallExpr getFuncCallExpr();

  @Nullable
  PrismIfExpr getIfExpr();

  @Nullable
  PrismIfLetExpr getIfLetExpr();

  @Nullable
  PrismLambExpr getLambExpr();

  @Nullable
  PrismStmt getStmt();

}
