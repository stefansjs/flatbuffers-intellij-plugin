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

public class FlatbuffersEnumDeclImpl extends ASTWrapperPsiElement implements FlatbuffersEnumDecl {

  public FlatbuffersEnumDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitEnumDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FlatbuffersEnumvalDecl> getEnumvalDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlatbuffersEnumvalDecl.class);
  }

  @Override
  @NotNull
  public FlatbuffersIdent getIdent() {
    return findNotNullChildByClass(FlatbuffersIdent.class);
  }

  @Override
  @NotNull
  public FlatbuffersMetadata getMetadata() {
    return findNotNullChildByClass(FlatbuffersMetadata.class);
  }

  @Override
  @Nullable
  public FlatbuffersType getType() {
    return findChildByClass(FlatbuffersType.class);
  }

}
