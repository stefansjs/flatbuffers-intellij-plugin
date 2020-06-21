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
        // Flatbuffers lets you use protected keywords as field names.
        // Conceptually I like to think of identifiers as being generic identifiers _or_ keyword identifiers, but since
        // the lexer will eliminate those tokens entirely, it's possible to have a null identifier and no alternative.
        element.fieldIdent.ident?.let { applyAttribute(it, holder, MEMBER) }

        // declared type is similar. It might be a built-in keyword (which does not become part of the PSI) or an
        // identifier, which should be referential of some declared type
        element.fieldType?.declaredType?.let { applyFormatting(it, holder) }

        // according to the grammar there should either be a constant or identifier after an equal sign.
        // There's currently no identifier allowed other than an enum value
        element.fieldValue?.ident?.let { applyAttribute(it, holder, ENUM_REFERENCE) }
    }

    private fun applyFormatting(declaredType: FlatbuffersDeclaredType, holder: AnnotationHolder) {
        applyAttribute(declaredType.ident, holder, CLASS_REFERENCE)

        val namespaceParts = declaredType.declaredNamespace.identList
        namespaceParts.map { applyAttribute(it, holder, NAMESPACE_REF) }
    }

    private fun applyFormatting(element: FlatbuffersUnionvalDecl, holder: AnnotationHolder) {
        element.ident?.let { applyAttribute(it, holder, UNION_ALIAS) }
        applyAttribute(element.declaredType, holder, CLASS_REFERENCE)
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