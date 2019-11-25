// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismFunctionDefinition extends PrismNamedElement {

  @Nullable
  PrismArgsList getArgsList();

  @NotNull
  List<PrismExpr> getExprList();

  @NotNull
  List<PrismFunctionDefinition> getFunctionDefinitionList();

  @Nullable
  PrismType getType();

  @NotNull
  List<PrismVariableDefinition> getVariableDefinitionList();

  @NotNull
  PsiElement getIdentifier();

  PsiElement getNameIdentifier();

}
