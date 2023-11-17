// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.github.stefansjs.flatbuffersplugin.psi.*;

public class FlatbuffersUnionvalDeclImpl extends ASTWrapperPsiElement implements FlatbuffersUnionvalDecl {

  public FlatbuffersUnionvalDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitUnionvalDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FlatbuffersDeclaredName getDeclaredName() {
    return findNotNullChildByClass(FlatbuffersDeclaredName.class);
  }

  @Override
  @NotNull
  public FlatbuffersDeclaredNamespace getDeclaredNamespace() {
    return findNotNullChildByClass(FlatbuffersDeclaredNamespace.class);
  }

  @Override
  @Nullable
  public FlatbuffersIdent getIdent() {
    return findChildByClass(FlatbuffersIdent.class);
  }

  @Override
  @Nullable
  public FlatbuffersIntegerConstant getIntegerConstant() {
    return findChildByClass(FlatbuffersIntegerConstant.class);
  }

}
