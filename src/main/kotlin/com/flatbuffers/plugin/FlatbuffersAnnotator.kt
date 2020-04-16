package com.flatbuffers.plugin

import com.flatbuffers.plugin.psi.FlatbuffersTypeDecl
import com.flatbuffers.plugin.psi.ref.FlatbuffersNamedElement
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement

class FlatbuffersAnnotator: Annotator {
    companion object {
        // Here's some attributes that are used by the Annotator and not used in token highlights below
        val CLASS_NAME = FlatbuffersSyntaxHighlighter.attributeFromFallback(DefaultLanguageHighlighterColors.CLASS_NAME)
        val CLASS_REFERENCE = FlatbuffersSyntaxHighlighter.attributeFromFallback(DefaultLanguageHighlighterColors.CLASS_REFERENCE)
    }


    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is FlatbuffersNamedElement) {
            applyFormatting(element, holder)
        }
    }

    fun applyFormatting(element: FlatbuffersNamedElement, holder: AnnotationHolder) {
        if(element is FlatbuffersTypeDecl) {
            val annotation = holder.createInfoAnnotation(element.ident, null)
            annotation.textAttributes = CLASS_NAME
        }
    }
}