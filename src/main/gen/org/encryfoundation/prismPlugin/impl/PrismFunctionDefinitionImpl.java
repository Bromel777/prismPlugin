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

public class PrismFunctionDefinitionImpl extends PrismCompositeElementImpl implements PrismFunctionDefinition {

  public PrismFunctionDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitFunctionDefinition(this);
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
  public PrismExpr getExpr() {
    return findNotNullChildByClass(PrismExpr.class);
  }

  @Override
  @Nullable
  public PrismType getType() {
    return findChildByClass(PrismType.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
