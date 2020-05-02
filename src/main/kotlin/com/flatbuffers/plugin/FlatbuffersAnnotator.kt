/*
 * Copyright (c) 2020. Stefan Sullivan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flatbuffers.plugin

import com.flatbuffers.plugin.psi.FlatbuffersEnumDecl
import com.flatbuffers.plugin.psi.FlatbuffersEnumvalDecl
import com.flatbuffers.plugin.psi.FlatbuffersFieldDecl
import com.flatbuffers.plugin.psi.FlatbuffersNamespaceDecl
import com.flatbuffers.plugin.psi.FlatbuffersRootDecl
import com.flatbuffers.plugin.psi.FlatbuffersTypeDecl
import com.flatbuffers.plugin.psi.FlatbuffersUnionDecl
import com.flatbuffers.plugin.psi.FlatbuffersUnionvalDecl
import com.flatbuffers.plugin.psi.impl.getNameIdentifier
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.psi.PsiElement

class FlatbuffersAnnotator: Annotator {
    companion object {
        // Here's some attributes that are used by the Annotator and not used in token highlights below
        val CLASS_NAME = createTextAttributesKey("FLATBUFFERS_CLASS_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
        val CLASS_REFERENCE = createTextAttributesKey("FLATBUFFERS_CLASS_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
        val MEMBER = createTextAttributesKey("FLATBUFFERS_INSTANCE_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
        val ENUM_VALUE = createTextAttributesKey("FLATBUFFERS_STATIC_FIELD", DefaultLanguageHighlighterColors.STATIC_FIELD)
        val ENUM_REFERENCE = createTextAttributesKey("FLATBUFFERS_ENUM_REFERENCE", DefaultLanguageHighlighterColors.CONSTANT)
        val UNION_ALIAS = createTextAttributesKey("FLATBUFFERS_UNION_ALIAS", DefaultLanguageHighlighterColors.STATIC_FIELD)
        val NAMESPACE_NAME = createTextAttributesKey("FLATBUFFERS_NAMESPACE", DefaultLanguageHighlighterColors.CLASS_NAME)
        val NAMESPACE_REF = createTextAttributesKey("FLATBUFFERS_NAMESPACE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)
    }


    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is FlatbuffersTypeDecl -> {
                applyAttribute(element.nameIdentifier, holder, CLASS_NAME)
            }
            is FlatbuffersEnumDecl -> {
                applyAttribute(getNameIdentifier(element), holder, CLASS_NAME)
            }
            is FlatbuffersUnionDecl -> {
                applyAttribute(element.ident, holder, CLASS_NAME)
            }
            is FlatbuffersFieldDecl -> {
                applyFormatting(element, holder)
            }
            is FlatbuffersEnumvalDecl -> {
                applyAttribute(element.ident, holder, ENUM_VALUE)
            }
            is FlatbuffersUnionvalDecl -> {
                applyFormatting(element, holder)
            }
            is FlatbuffersRootDecl -> {
                applyAttribute(element.ident, holder, CLASS_REFERENCE)
            }
            is FlatbuffersNamespaceDecl -> {
                applyFormatting(element, holder)
            }
        }
    }

    private fun applyFormatting(element: FlatbuffersFieldDecl, holder: AnnotationHolder) {
        applyAttribute(element.identList[0], holder, MEMBER)
        val declaredType = element.fieldType.declaredType
        if( declaredType != null ) {
            val parts = declaredType.identList
            applyAttribute(parts.last(), holder, CLASS_REFERENCE)
            parts.subList(0, parts.lastIndex).map { applyAttribute(it, holder, NAMESPACE_REF) }
        }
        if( element.identList.size > 1 ) {
            // according to the grammar there should either be a constant or identifier after an equal sign.
            // There's currently no possibility of anything else
            applyAttribute(element.identList[1], holder, ENUM_REFERENCE)
        }
    }

    private fun applyFormatting(element: FlatbuffersUnionvalDecl, holder: AnnotationHolder) {
        applyAttribute(element.identList.last(), holder, CLASS_REFERENCE)
        if( element.identList.size > 1 ) {
            // Again, there should only be either one or two identifiers
            applyAttribute(element.identList[0], holder, UNION_ALIAS)
        }
    }

    private fun applyFormatting(element: FlatbuffersNamespaceDecl, holder: AnnotationHolder) {
        element.identList.map { applyAttribute(it, holder, NAMESPACE_NAME) }
    }

    private fun applyAttribute(element: PsiElement, holder: AnnotationHolder, textAttributesKey: TextAttributesKey) {
        val annotation = holder.createInfoAnnotation(element, null)
        val attributes = EditorColorsManager.getInstance().globalScheme.getAttributes(textAttributesKey)
        annotation.enforcedTextAttributes = attributes
    }
}