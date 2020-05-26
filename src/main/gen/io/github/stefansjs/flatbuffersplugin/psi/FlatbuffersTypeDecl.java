// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersNamedElement;

public interface FlatbuffersTypeDecl extends FlatbuffersNamedElement {

  @NotNull
  List<FlatbuffersFieldDecl> getFieldDeclList();

  @NotNull
  FlatbuffersIdent getIdent();

  @NotNull
  FlatbuffersMetadata getMetadata();

  @Nullable
  String getName();

  @NotNull
  FlatbuffersTypeDecl setName(@NotNull String newName);

  @NotNull
  FlatbuffersIdent getNameIdentifier();

}
