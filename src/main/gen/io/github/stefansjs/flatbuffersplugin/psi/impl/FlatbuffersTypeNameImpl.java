// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypes.*;
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersNamedElementImpl;
import io.github.stefansjs.flatbuffersplugin.psi.*;
import com.intellij.openapi.util.NlsSafe;
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersNamedElement;

public class FlatbuffersTypeNameImpl extends FlatbuffersNamedElementImpl implements FlatbuffersTypeName {

  public FlatbuffersTypeNameImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FlatbuffersVisitor visitor) {
    visitor.visitTypeName(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FlatbuffersVisitor) accept((FlatbuffersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

  @Override
  public @NlsSafe String getName() {
    return FlatbuffersPsiImplUtilKt.getName(this);
  }

  @Override
  @NotNull
  public FlatbuffersNamedElement setName(@NotNull String newName) {
    return FlatbuffersPsiImplUtilKt.setName(this, newName);
  }

  @Override
  @NotNull
  public PsiElement getNameIdentifier() {
    return FlatbuffersPsiImplUtilKt.getNameIdentifier(this);
  }

}
