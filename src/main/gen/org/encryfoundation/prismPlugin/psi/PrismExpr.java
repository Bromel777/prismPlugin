// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismExpr extends PsiElement {

  @Nullable
  PrismAritmExpr getAritmExpr();

  @Nullable
  PrismComprExpr getComprExpr();

  @Nullable
  PrismFunctionDefinition getFunctionDefinition();

  @Nullable
  PrismLambExpr getLambExpr();

  @Nullable
  PrismVariableDefinition getVariableDefinition();

}
