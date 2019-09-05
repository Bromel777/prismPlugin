// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismVariableDefinition extends PrismNamedElement {

  @Nullable
  PrismFuncCallExpr getFuncCallExpr();

  @Nullable
  PrismStmt getStmt();

  @Nullable
  PrismType getType();

  @NotNull
  PsiElement getIdentifier();

}
