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
import com.flatbuffers.plugin.psi.FlatbuffersRootDecl
import com.flatbuffers.plugin.psi.FlatbuffersTypeDecl
import com.flatbuffers.plugin.psi.impl.getFieldName
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
    }


    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is FlatbuffersTypeDecl -> {
                applyAttribute(element.nameIdentifier, holder, CLASS_NAME)
            }
            is FlatbuffersEnumDecl -> {
                applyAttribute(getNameIdentifier(element), holder, CLASS_NAME)
            }
            is FlatbuffersFieldDecl -> {
                applyFormatting(element, holder)
            }
            is FlatbuffersEnumvalDecl -> {
                applyAttribute(element.ident, holder, ENUM_VALUE)
            }
        }
    }

    private fun applyFormatting(element: FlatbuffersFieldDecl, holder: AnnotationHolder) {
        applyAttribute(getFieldName(element), holder, MEMBER)
        val declaredType = element.fieldType.declaredType
        if( declaredType != null ) {
            applyAttribute(declaredType.identList.last(), holder, CLASS_REFERENCE)
        }
    }

    private fun applyAttribute(element: PsiElement, holder: AnnotationHolder, textAttributesKey: TextAttributesKey) {
        val annotation = holder.createInfoAnnotation(element, null)
        val attributes = EditorColorsManager.getInstance().globalScheme.getAttributes(textAttributesKey)
        annotation.enforcedTextAttributes = attributes
    }
}