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

public class FlatbuffersArrayTypeImpl extends ASTWrapperPsiElement implements FlatbuffersArrayType {

  public FlatbuffersArrayTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitArrayType(this);
  }

  @Override
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
  public FlatbuffersDeclaredType getDeclaredType() {
    return findChildByClass(FlatbuffersDeclaredType.class);
  }

  @Override
  @Nullable
  public FlatbuffersPrimitive getPrimitive() {
    return findChildByClass(FlatbuffersPrimitive.class);
  }

}
