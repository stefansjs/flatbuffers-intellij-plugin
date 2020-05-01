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

  //WARNING: getClassName(...) is skipped
  //matching getClassName(FlatbuffersTypeDecl, ...)
  //methods are not found in FlatbuffersPsiImplUtilKt

  //WARNING: getName(...) is skipped
  //matching getName(FlatbuffersTypeDecl, ...)
  //methods are not found in FlatbuffersPsiImplUtilKt

  //WARNING: setName(...) is skipped
  //matching setName(FlatbuffersTypeDecl, ...)
  //methods are not found in FlatbuffersPsiImplUtilKt

  //WARNING: getNameIdentifier(...) is skipped
  //matching getNameIdentifier(FlatbuffersTypeDecl, ...)
  //methods are not found in FlatbuffersPsiImplUtilKt

}
