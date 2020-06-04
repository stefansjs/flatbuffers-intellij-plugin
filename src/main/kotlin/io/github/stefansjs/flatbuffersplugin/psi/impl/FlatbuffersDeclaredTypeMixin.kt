package io.github.stefansjs.flatbuffersplugin.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiReference
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredType
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersTypeReference

abstract class FlatbuffersDeclaredTypeMixin(node: ASTNode): FlatbuffersDeclaredType, ASTWrapperPsiElement(node) {
    override fun getReference(): PsiReference? {
        if(identList.size == 0) return null

        val typeName = identList.last() ?: return null
        return FlatbuffersTypeReference(typeName)
    }
}