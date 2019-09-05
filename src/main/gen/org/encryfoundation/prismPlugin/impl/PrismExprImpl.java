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

public class PrismExprImpl extends PrismCompositeElementImpl implements PrismExpr {

  public PrismExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PrismVisitor visitor) {
    visitor.visitExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PrismVisitor) accept((PrismVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PrismAritmExpr getAritmExpr() {
    return findChildByClass(PrismAritmExpr.class);
  }

  @Override
  @Nullable
  public PrismBoolExpr getBoolExpr() {
    return findChildByClass(PrismBoolExpr.class);
  }

  @Override
  @Nullable
  public PrismFunctionDefinition getFunctionDefinition() {
    return findChildByClass(PrismFunctionDefinition.class);
  }

  @Override
  @Nullable
  public PrismIfExpr getIfExpr() {
    return findChildByClass(PrismIfExpr.class);
  }

  @Override
  @Nullable
  public PrismIfLetExpr getIfLetExpr() {
    return findChildByClass(PrismIfLetExpr.class);
  }

  @Override
  @Nullable
  public PrismLambExpr getLambExpr() {
    return findChildByClass(PrismLambExpr.class);
  }

  @Override
  @Nullable
  public PrismVariableDefinition getVariableDefinition() {
    return findChildByClass(PrismVariableDefinition.class);
  }

}
