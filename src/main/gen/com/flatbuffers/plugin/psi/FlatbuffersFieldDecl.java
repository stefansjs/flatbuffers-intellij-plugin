// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersFieldDecl extends PsiElement {

  @NotNull
  FlatbuffersFieldType getFieldType();

  @NotNull
  List<FlatbuffersIdent> getIdentList();

  @NotNull
  FlatbuffersMetadata getMetadata();

  @Nullable
  FlatbuffersScalar getScalar();

}
