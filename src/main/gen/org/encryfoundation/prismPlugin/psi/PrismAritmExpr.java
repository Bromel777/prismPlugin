// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismAritmExpr extends PrismCompositeElement {

  @NotNull
  PrismRightArithExpr getRightArithExpr();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getNumber();

}
