// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersDeclaration extends PsiElement {

  @Nullable
  FlatbuffersAttributeDecl getAttributeDecl();

  @Nullable
  FlatbuffersEnumDecl getEnumDecl();

  @Nullable
  FlatbuffersFileExtensionDecl getFileExtensionDecl();

  @Nullable
  FlatbuffersFileIdentifierDecl getFileIdentifierDecl();

  @Nullable
  FlatbuffersNamespaceDecl getNamespaceDecl();

  @Nullable
  FlatbuffersObject getObject();

  @Nullable
  FlatbuffersRootDecl getRootDecl();

  @Nullable
  FlatbuffersRpcDecl getRpcDecl();

  @Nullable
  FlatbuffersTypeDecl getTypeDecl();

  @Nullable
  FlatbuffersUnionDecl getUnionDecl();

}
