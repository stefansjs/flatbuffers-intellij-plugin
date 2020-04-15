package com.flatbuffers.plugin

import com.flatbuffers.plugin.psi.FlatbuffersTypeDecl
import com.flatbuffers.plugin.psi.ref.FlatbuffersNamedElement
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement

class FlatbuffersAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is FlatbuffersNamedElement) {
            applyFormatting(element, holder)
        }
    }

    fun applyFormatting(element: FlatbuffersNamedElement, holder: AnnotationHolder) {
        if(element is FlatbuffersTypeDecl) {
            val annotation = holder.createInfoAnnotation(element.ident, null)
            annotation.textAttributes = DefaultLanguageHighlighterColors.CLASS_NAME
        }
    }
}