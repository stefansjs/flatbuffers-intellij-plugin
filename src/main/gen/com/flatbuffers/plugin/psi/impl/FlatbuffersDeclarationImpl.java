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

public class FlatbuffersDeclarationImpl extends ASTWrapperPsiElement implements FlatbuffersDeclaration {

  public FlatbuffersDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FlatbuffersAttributeDecl getAttributeDecl() {
    return findChildByClass(FlatbuffersAttributeDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersEnumDecl getEnumDecl() {
    return findChildByClass(FlatbuffersEnumDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersFileExtensionDecl getFileExtensionDecl() {
    return findChildByClass(FlatbuffersFileExtensionDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersFileIdentifierDecl getFileIdentifierDecl() {
    return findChildByClass(FlatbuffersFileIdentifierDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersNamespaceDecl getNamespaceDecl() {
    return findChildByClass(FlatbuffersNamespaceDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersObject getObject() {
    return findChildByClass(FlatbuffersObject.class);
  }

  @Override
  @Nullable
  public FlatbuffersRootDecl getRootDecl() {
    return findChildByClass(FlatbuffersRootDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersRpcDecl getRpcDecl() {
    return findChildByClass(FlatbuffersRpcDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersTypeDecl getTypeDecl() {
    return findChildByClass(FlatbuffersTypeDecl.class);
  }

}
