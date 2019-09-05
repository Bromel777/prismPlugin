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

public class PrismLambExprImpl extends PrismCompositeElementImpl implements PrismLambExpr {

  public PrismLambExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitLambExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PrismArgsList getArgsList() {
    return findNotNullChildByClass(PrismArgsList.class);
  }

  @Override
  @NotNull
  public PrismExpr getExpr() {
    return findNotNullChildByClass(PrismExpr.class);
  }

}
