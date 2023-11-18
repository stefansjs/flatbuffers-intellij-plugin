// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersUnionDecl extends PsiElement {

  @Nullable
  FlatbuffersDocumentation getDocumentation();

  @Nullable
  FlatbuffersMetadata getMetadata();

  @NotNull
  FlatbuffersTypeName getTypeName();

  @NotNull
  List<FlatbuffersUnionvalDecl> getUnionvalDeclList();

}
