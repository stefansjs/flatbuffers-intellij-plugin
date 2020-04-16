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
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

/* Created by stefansullivan on 2019-02-15 */
class FlatbuffersSyntaxHighlighter: SyntaxHighlighterBase() {

    companion object {
        fun attributeFromFallback(fallback: TextAttributesKey, name: String?=null): TextAttributesKey {
            return createTextAttributesKey(name ?: "FLATBUFFERS_" + fallback, fallback)
        }

        val BAD_CHARACTER = attributeFromFallback(HighlighterColors.BAD_CHARACTER)
        val COMMENT = attributeFromFallback(DefaultLanguageHighlighterColors.LINE_COMMENT)
        val STRING = attributeFromFallback(DefaultLanguageHighlighterColors.STRING)
        val KEYWORD = attributeFromFallback(DefaultLanguageHighlighterColors.KEYWORD)
        val TYPE = attributeFromFallback(DefaultLanguageHighlighterColors.KEYWORD, "FLATBUFFERS_TYPE")
        val NUMBER = attributeFromFallback(DefaultLanguageHighlighterColors.NUMBER)
        val OPERATOR = attributeFromFallback(DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val IDENTIFIER = attributeFromFallback(DefaultLanguageHighlighterColors.IDENTIFIER)


        val EMPTY_KEYS = emptyArray<TextAttributesKey>()
        val BAD_CHARACTERS_KEYS = arrayOf(BAD_CHARACTER)
        val COMMENT_KEYS = arrayOf(COMMENT)
        val STRING_KEYS = arrayOf(STRING)
        val KEYWORD_KEYS = arrayOf(KEYWORD)
        val TYPE_KEYS = arrayOf(TYPE)
        val NUMBER_KEYS = arrayOf(NUMBER)
        val OPERATOR_KEYS = arrayOf(OPERATOR)
        val ID_KEYS = arrayOf(IDENTIFIER)
    }

    override fun getTokenHighlights(token: IElementType?): Array<TextAttributesKey> {
        if(token == null)
        {
            return BAD_CHARACTERS_KEYS
        }
        else if(token == FlatbuffersTypes.COMMENT)
        {
            return COMMENT_KEYS
        }
        else if(token == FlatbuffersTypes.IDENTIFIER)
        {
            return ID_KEYS
        }
        else if(token == FlatbuffersTypes.FLOAT_CONSTANT ||
                token == FlatbuffersTypes.INTEGER_CONSTANT ||
                token == FlatbuffersTypes.BOOLEAN_CONSTANT)
        {
            return NUMBER_KEYS
        }
        else if(token == FlatbuffersTypes.INCLUDE ||
                token == FlatbuffersTypes.NAMESPACE ||
                token == FlatbuffersTypes.TABLE ||
                token == FlatbuffersTypes.STRUCT ||
                token == FlatbuffersTypes.ENUM ||
                token == FlatbuffersTypes.UNION ||
                token == FlatbuffersTypes.ROOT_TYPE ||
                token == FlatbuffersTypes.FILE_EXTENSION ||
                token == FlatbuffersTypes.FILE_IDENTIFIER ||
                token == FlatbuffersTypes.ATTRIBUTE ||
                token == FlatbuffersTypes.RPC_SERVICE)
        {
            return KEYWORD_KEYS
        }
        else if(token == FlatbuffersTypes.BOOL ||
                token == FlatbuffersTypes.BYTE ||
                token == FlatbuffersTypes.UBYTE ||
                token == FlatbuffersTypes.SHORT ||
                token == FlatbuffersTypes.USHORT ||
                token == FlatbuffersTypes.INT ||
                token == FlatbuffersTypes.UINT ||
                token == FlatbuffersTypes.FLOAT ||
                token == FlatbuffersTypes.LONG ||
                token == FlatbuffersTypes.ULONG ||
                token == FlatbuffersTypes.DOUBLE ||
                token == FlatbuffersTypes.INT8 ||
                token == FlatbuffersTypes.UINT8 ||
                token == FlatbuffersTypes.INT16 ||
                token == FlatbuffersTypes.UINT16 ||
                token == FlatbuffersTypes.INT32 ||
                token == FlatbuffersTypes.UINT32 ||
                token == FlatbuffersTypes.INT64 ||
                token == FlatbuffersTypes.UINT64 ||
                token == FlatbuffersTypes.FLOAT32 ||
                token == FlatbuffersTypes.FLOAT64 ||
                token == FlatbuffersTypes.TRUE ||
                token == FlatbuffersTypes.FALSE)
        {
            return TYPE_KEYS
        }
        else if(token == FlatbuffersTypes.DEC_INTEGER ||
                token == FlatbuffersTypes.HEX_INTEGER ||
                token == FlatbuffersTypes.DEC_FLOAT ||
                token == FlatbuffersTypes.HEX_FLOAT ||
                token == FlatbuffersTypes.SPECIAL_FLOAT)
        {
            return NUMBER_KEYS
        }
        else if(token == FlatbuffersTypes.STRING) {
            return STRING_KEYS
        }
        else if(token == FlatbuffersTypes.EQUALS) {
            return OPERATOR_KEYS
        }
        else {
            return EMPTY_KEYS
        }
    }

    override fun getHighlightingLexer() = FlatbuffersLexerAdapter()
}