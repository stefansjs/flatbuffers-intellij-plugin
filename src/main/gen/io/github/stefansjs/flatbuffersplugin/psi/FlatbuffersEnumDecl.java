// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersEnumDecl extends PsiElement {

  @Nullable
  FlatbuffersDocumentation getDocumentation();

  @NotNull
  List<FlatbuffersEnumvalDecl> getEnumvalDeclList();

  @NotNull
  FlatbuffersIdent getIdent();

  @NotNull
  FlatbuffersMetadata getMetadata();

  @Nullable
  FlatbuffersPrimitive getPrimitive();

}
