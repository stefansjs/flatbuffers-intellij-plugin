// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersNamedElement;

public interface FlatbuffersUnionDecl extends FlatbuffersNamedElement {

  @Nullable
  FlatbuffersDocumentation getDocumentation();

  @NotNull
  FlatbuffersIdent getIdent();

  @NotNull
  List<FlatbuffersUnionvalDecl> getUnionvalDeclList();

  String getName();

  @NotNull
  FlatbuffersNamedElement setName(@NotNull String newName);

  @NotNull
  FlatbuffersIdent getNameIdentifier();

}
