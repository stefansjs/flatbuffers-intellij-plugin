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

public class FlatbuffersEnumDeclImpl extends ASTWrapperPsiElement implements FlatbuffersEnumDecl {

  public FlatbuffersEnumDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitEnumDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FlatbuffersDocumentation getDocumentation() {
    return findChildByClass(FlatbuffersDocumentation.class);
  }

  @Override
  @NotNull
  public List<FlatbuffersEnumvalDecl> getEnumvalDeclList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlatbuffersEnumvalDecl.class);
  }

  @Override
  @Nullable
  public FlatbuffersMetadata getMetadata() {
    return findChildByClass(FlatbuffersMetadata.class);
  }

  @Override
  @Nullable
  public FlatbuffersPrimitive getPrimitive() {
    return findChildByClass(FlatbuffersPrimitive.class);
  }

  @Override
  @NotNull
  public FlatbuffersTypeName getTypeName() {
    return findNotNullChildByClass(FlatbuffersTypeName.class);
  }

}
