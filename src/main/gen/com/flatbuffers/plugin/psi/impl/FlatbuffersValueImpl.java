// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flatbuffers.plugin.psi.FlatbuffersTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.flatbuffers.plugin.psi.*;

public class FlatbuffersValueImpl extends ASTWrapperPsiElement implements FlatbuffersValue {

  public FlatbuffersValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitValue(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FlatbuffersObject getObject() {
    return findChildByClass(FlatbuffersObject.class);
  }

  @Override
  @Nullable
  public FlatbuffersSingleValue getSingleValue() {
    return findChildByClass(FlatbuffersSingleValue.class);
  }

  @Override
  @NotNull
  public List<FlatbuffersValue> getValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlatbuffersValue.class);
  }

}