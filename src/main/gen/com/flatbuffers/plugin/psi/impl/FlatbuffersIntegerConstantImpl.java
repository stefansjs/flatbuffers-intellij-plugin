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

public class FlatbuffersIntegerConstantImpl extends ASTWrapperPsiElement implements FlatbuffersIntegerConstant {

  public FlatbuffersIntegerConstantImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitIntegerConstant(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FlatbuffersDecIntegerConstant getDecIntegerConstant() {
    return findChildByClass(FlatbuffersDecIntegerConstant.class);
  }

  @Override
  @Nullable
  public FlatbuffersHexIntegerConstant getHexIntegerConstant() {
    return findChildByClass(FlatbuffersHexIntegerConstant.class);
  }

}
