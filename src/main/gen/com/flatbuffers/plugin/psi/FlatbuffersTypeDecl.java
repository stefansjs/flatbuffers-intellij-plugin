// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.flatbuffers.plugin.psi.ref.FlatbuffersNamedElement;

public interface FlatbuffersTypeDecl extends FlatbuffersNamedElement {

  @NotNull
  List<FlatbuffersFieldDecl> getFieldDeclList();

  @NotNull
  FlatbuffersIdent getIdent();

  @NotNull
  FlatbuffersMetadata getMetadata();

  @Nullable
  String getClassName();

  @Nullable
  String getName();

  @NotNull
  FlatbuffersTypeDecl setName(@NotNull String newName);

  @Nullable
  PsiElement getNameIdentifier();

}
