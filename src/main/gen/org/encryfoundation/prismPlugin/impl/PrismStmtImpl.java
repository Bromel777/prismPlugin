// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.encryfoundation.prismPlugin.psi.PrismTypes.*;
import org.encryfoundation.prismPlugin.psi.PrismCompositeElementImpl;
import org.encryfoundation.prismPlugin.psi.*;

public class PrismStmtImpl extends PrismCompositeElementImpl implements PrismStmt {

  public PrismStmtImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitStmt(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismBase16Str getBase16Str() {
    return findChildByClass(PrismBase16Str.class);
  }

  @Override
  @Nullable
  public PrismBase58Str getBase58Str() {
    return findChildByClass(PrismBase58Str.class);
  }

  @Override
  @Nullable
  public PrismBooleanType getBooleanType() {
    return findChildByClass(PrismBooleanType.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

}
