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
package io.github.stefansjs.flatbuffersplugin

import io.github.stefansjs.flatbuffersplugin.parser.FlatbuffersParser
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersFile
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

/* Created by stefansullivan on 2019-02-15 */
class FlatbuffersParserDefinition: ParserDefinition {
    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(FlatbuffersTypes.COMMENT)
    val STRING_LITERAL = TokenSet.create(FlatbuffersTypes.STRING_CONSTANT)

    val FILE = IFileElementType(FlatbuffersLanguage)

    override fun createLexer(project: Project?) = FlatbuffersLexerAdapter()
    override fun createParser(project: Project?) = FlatbuffersParser()

    override fun createFile(fileViewProvider: FileViewProvider?) = FlatbuffersFile(fileViewProvider!!)
    override fun createElement(node: ASTNode?) = FlatbuffersTypes.Factory.createElement(node)

    override fun getFileNodeType() = FILE
    override fun getCommentTokens() = COMMENTS
    override fun getStringLiteralElements() = STRING_LITERAL
}