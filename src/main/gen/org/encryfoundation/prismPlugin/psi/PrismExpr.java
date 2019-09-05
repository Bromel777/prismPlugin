// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismExpr extends PrismCompositeElement {

  @Nullable
  PrismAritmExpr getAritmExpr();

  @Nullable
  PrismBoolExpr getBoolExpr();

  @Nullable
  PrismFunctionDefinition getFunctionDefinition();

  @Nullable
  PrismIfExpr getIfExpr();

  @Nullable
  PrismIfLetExpr getIfLetExpr();

  @Nullable
  PrismLambExpr getLambExpr();

  @Nullable
  PrismVariableDefinition getVariableDefinition();

}
