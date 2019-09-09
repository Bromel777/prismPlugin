// This is a generated file. Not intended for manual editing.
package org.encryfoundation.prismPlugin.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.encryfoundation.prismPlugin.psi.PrismTypes.*;
import org.encryfoundation.prismPlugin.psi.PrismNamedElementImpl;
import org.encryfoundation.prismPlugin.psi.*;
import com.intellij.psi.PsiReference;

public class PrismVariableDefinitionImpl extends PrismNamedElementImpl implements PrismVariableDefinition {

  public PrismVariableDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitVariableDefinition(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismFuncCallExpr getFuncCallExpr() {
    return findChildByClass(PrismFuncCallExpr.class);
  }

  @Override
  @Nullable
  public PrismStmt getStmt() {
    return findChildByClass(PrismStmt.class);
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

  @Override
  public PsiElement getNameIdentifier() {
    return PrismPsiUtilImpl.getNameIdentifier(this);
  }

  @Override
  public PsiReference getReference() {
    return PrismPsiUtilImpl.getReference(this);
  }

}
