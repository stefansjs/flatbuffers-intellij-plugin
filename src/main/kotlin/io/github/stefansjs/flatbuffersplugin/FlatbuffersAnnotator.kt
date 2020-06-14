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

package io.github.stefansjs.flatbuffersplugin

import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredType
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumvalDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersFieldDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersNamespaceDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersRootDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypeDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersUnionDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersUnionvalDecl
import io.github.stefansjs.flatbuffersplugin.psi.impl.getNameIdentifier
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
                applyAttribute(element.ident, holder, CLASS_NAME)
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
                applyAttribute(element.declaredType, holder, CLASS_REFERENCE)
            }
            is FlatbuffersNamespaceDecl -> {
                applyFormatting(element, holder)
            }
        }
    }

    private fun applyFormatting(element: FlatbuffersFieldDecl, holder: AnnotationHolder) {
        applyAttribute(element.identList[0], holder, MEMBER)
        applyFormatting(element.fieldType?.declaredType, holder)
        if( element.identList.size > 1 ) {
            // according to the grammar there should either be a constant or identifier after an equal sign.
            // There's currently no possibility of anything else
            applyAttribute(element.identList[1], holder, ENUM_REFERENCE)
        }
    }

    private fun applyFormatting(declaredType: FlatbuffersDeclaredType?, holder: AnnotationHolder) {
        if (declaredType == null) return

        val parts = declaredType.identList
        applyAttribute(parts.last(), holder, CLASS_REFERENCE)
        parts.subList(0, parts.lastIndex).map { applyAttribute(it, holder, NAMESPACE_REF) }
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