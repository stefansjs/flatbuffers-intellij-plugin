// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FlatbuffersFloatConstant extends PsiElement {

  @Nullable
  FlatbuffersDecimalFloatConstant getDecimalFloatConstant();

  @Nullable
  FlatbuffersHexadecimalFloatConstant getHexadecimalFloatConstant();

  @Nullable
  FlatbuffersSpecialFloatConstant getSpecialFloatConstant();

}
