package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode

abstract class FlatbuffersNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), FlatbuffersNamedElement