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

public class FlatbuffersRpcDeclImpl extends ASTWrapperPsiElement implements FlatbuffersRpcDecl {

  public FlatbuffersRpcDeclImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitRpcDecl(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FlatbuffersIdent getIdent() {
    return findNotNullChildByClass(FlatbuffersIdent.class);
  }

  @Override
  @NotNull
  public List<FlatbuffersRpcMethod> getRpcMethodList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FlatbuffersRpcMethod.class);
  }

}
