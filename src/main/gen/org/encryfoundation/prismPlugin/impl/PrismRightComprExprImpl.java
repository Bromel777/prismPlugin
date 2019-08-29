// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.encryfoundation.prismPlugin.psi.PrismTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.encryfoundation.prismPlugin.psi.*;

public class PrismRightComprExprImpl extends ASTWrapperPsiElement implements PrismRightComprExpr {

  public PrismRightComprExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitRightComprExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismBooleanType getBooleanType() {
    return findChildByClass(PrismBooleanType.class);
  }

  @Override
  @NotNull
  public PrismComprOp getComprOp() {
    return findNotNullChildByClass(PrismComprOp.class);
  }

  @Override
  @Nullable
  public PrismRightComprExpr getRightComprExpr() {
    return findChildByClass(PrismRightComprExpr.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
