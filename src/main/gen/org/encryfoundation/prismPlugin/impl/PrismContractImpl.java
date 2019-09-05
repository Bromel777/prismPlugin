// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.encryfoundation.prismPlugin.psi.PrismTypes.*;
import org.encryfoundation.prismPlugin.psi.PrismCompositeElementType;
import org.encryfoundation.prismPlugin.psi.*;

public class PrismContractImpl extends PrismCompositeElementType implements PrismContract {

  public PrismContractImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitContract(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismArgsList getArgsList() {
    return findChildByClass(PrismArgsList.class);
  }

  @Override
  @NotNull
  public List<PrismExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PrismExpr.class);
  }

}
