package io.github.stefansjs.flatbuffersplugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumValue
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersEnumReference

abstract class FlatbuffersEnumValueMixin(node: ASTNode) : FlatbuffersEnumValue, ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference {
        return FlatbuffersEnumReference(this)
    }
}