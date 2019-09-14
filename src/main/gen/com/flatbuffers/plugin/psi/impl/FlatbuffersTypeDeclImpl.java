// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.flatbuffers.plugin.psi.FlatbuffersTypes.*;
import com.flatbuffers.plugin.psi.ref.FlatbuffersNamedElementImpl;
import com.flatbuffers.plugin.psi.*;

public class FlatbuffersTypeDeclImpl extends FlatbuffersNamedElementImpl implements FlatbuffersTypeDecl {

  public FlatbuffersTypeDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitTypeDecl(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FlatbuffersFieldDecl> getFieldDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlatbuffersFieldDecl.class);
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
  public String getClassName() {
    return FlatbuffersPsiImplUtilKt.getClassName(this);
  }

  @Override
  @Nullable
  public String getName() {
    return FlatbuffersPsiImplUtilKt.getName(this);
  }

  @Override
  @NotNull
  public FlatbuffersTypeDecl setName(@NotNull String newName) {
    return FlatbuffersPsiImplUtilKt.setName(this, newName);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return FlatbuffersPsiImplUtilKt.getNameIdentifier(this);
  }

}
