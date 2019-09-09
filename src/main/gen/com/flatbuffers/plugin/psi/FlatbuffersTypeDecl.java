// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersTypeDecl extends PsiElement {

  @NotNull
  List<FlatbuffersFieldDecl> getFieldDeclList();

  @NotNull
  FlatbuffersIdent getIdent();

  @NotNull
  FlatbuffersMetadata getMetadata();

  //WARNING: getClass(...) is skipped
  //matching getClass(FlatbuffersTypeDecl, ...)
  //methods are not found in FlatbuffersPsiImplUtil

}
