// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismFunctionDefinition extends PsiElement {

  @NotNull
  PrismArgsList getArgsList();

  @NotNull
  PrismExpr getExpr();

  @Nullable
  PrismType getType();

  @NotNull
  PsiElement getIdentifier();

}
