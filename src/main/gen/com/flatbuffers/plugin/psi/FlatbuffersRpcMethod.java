// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersRpcMethod extends PsiElement {

  @NotNull
  List<FlatbuffersIdent> getIdentList();

  @NotNull
  FlatbuffersMetadata getMetadata();

}