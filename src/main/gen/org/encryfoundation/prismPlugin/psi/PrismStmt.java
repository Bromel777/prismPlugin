// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PrismStmt extends PsiElement {

  @Nullable
  PrismBase16Str getBase16Str();

  @Nullable
  PrismBase58Str getBase58Str();

  @Nullable
  PrismBooleanType getBooleanType();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

}
