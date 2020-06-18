// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersFieldDecl extends PsiElement {

  @Nullable
  FlatbuffersFieldType getFieldType();

  @NotNull
  List<FlatbuffersIdent> getIdentList();

  @Nullable
  FlatbuffersMetadata getMetadata();

  @Nullable
  FlatbuffersScalar getScalar();

}
