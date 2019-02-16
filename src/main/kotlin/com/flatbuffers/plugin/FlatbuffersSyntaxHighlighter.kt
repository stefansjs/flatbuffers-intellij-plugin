/**
 *   Copyright 2019 Stefan Sullivan
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.flatbuffers.plugin

import com.flatbuffers.plugin.psi.FlatbuffersTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

/* Created by stefansullivan on 2019-02-15 */
class FlatbuffersSyntaxHighlighter: SyntaxHighlighterBase() {

    val COMMENT = createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val BAD_CHARACTER = createTextAttributesKey("FLATBUFFERS_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

    val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    val BAD_CHARACTERS_KEYS = arrayOf(BAD_CHARACTER)
    val COMMENT_KEYS = arrayOf(COMMENT)

    override fun getTokenHighlights(token: IElementType?): Array<TextAttributesKey> {
        if(token == null) {
            return BAD_CHARACTERS_KEYS
        }
        else if(token.equals(FlatbuffersTypes.COMMENT)) {
            return COMMENT_KEYS
        }
        else {
            return EMPTY_KEYS
        }
    }

    override fun getHighlightingLexer() = FlatbuffersLexerAdapter()
}