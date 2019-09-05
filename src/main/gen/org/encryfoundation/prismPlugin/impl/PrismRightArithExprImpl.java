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

public class PrismRightArithExprImpl extends PrismCompositeElementImpl implements PrismRightArithExpr {

  public PrismRightArithExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitRightArithExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PrismMathOp getMathOp() {
    return findNotNullChildByClass(PrismMathOp.class);
  }

  @Override
  @Nullable
  public PrismRightArithExpr getRightArithExpr() {
    return findChildByClass(PrismRightArithExpr.class);
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

}
