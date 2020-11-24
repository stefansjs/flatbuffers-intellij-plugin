package io.github.stefansjs.flatbuffersplugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredName
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersTypeReference

abstract class FlatbuffersDeclaredNameMixin(node: ASTNode): FlatbuffersDeclaredName, ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference? {
        return FlatbuffersTypeReference(this)
    }
}