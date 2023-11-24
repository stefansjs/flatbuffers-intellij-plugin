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
package io.github.stefansjs.flatbuffersplugin.psi.impl

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import io.github.stefansjs.flatbuffersplugin.FlatbuffersFileType
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredName
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumValue
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumvalDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypeName
import io.github.stefansjs.flatbuffersplugin.psi.createClass
import io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersNamedElement


/* Created by stefansullivan on 2019-02-21
 *
 *  This util class uses overloading to implement a couple of common interfaces
 *  Specifically, the FlatbuffersNamedElement interface requires the following methods
 *    - getName(),
 *    - setName() both belong to the PsiNamedElement interface
 *    - getNameIdentifier() belongs to PsiNameIdentifierOwner
 *
 *  For any class that implements the FlatbuffersNamedElement interface, implementing those
 *  three methods for the type, and then modifying flatbuffers.bnf to add the following metadata:
 *    {methods=[getName setName getNameIdentifier]
 *     implements="io.github.stefansjs.flatbuffersplugin.psi.ref.FlatbuffersNamedElement"}
 */


// Named element generics
fun <T : FlatbuffersNamedElement> setName(element: T, newName: String): FlatbuffersNamedElement {
    val identifierNode = element.nameIdentifier!!.node

    val type = createClass(element.project, newName)
    val newClassNode = type?.firstChild?.node ?: return element // That's a lot of null checking :/
    element.node.replaceChild(identifierNode, newClassNode)

    return element
}

fun getNameIdentifier(element: FlatbuffersTypeName): PsiElement = element.identifier
fun getName(element: FlatbuffersTypeName) = element.identifier.text
fun setName(element: FlatbuffersTypeName, newName: String) = setName<FlatbuffersTypeName>(element, newName)

fun getNameIdentifier(element: FlatbuffersDeclaredName): PsiElement = element.identifier
fun getName(element: FlatbuffersDeclaredName) = element.identifier.text
fun setName(element: FlatbuffersDeclaredName, newName: String) = setName<FlatbuffersDeclaredName>(element, newName)

fun getNameIdentifier(element: FlatbuffersEnumvalDecl): PsiElement = element.identifier
fun getName(element: FlatbuffersEnumvalDecl) = element.identifier.text
fun setName(element: FlatbuffersEnumvalDecl, newName: String) = setName<FlatbuffersEnumvalDecl>(element, newName)

fun getNameIdentifier(element: FlatbuffersEnumValue): PsiElement = element.identifier
fun getName(element: FlatbuffersEnumValue) = element.identifier.text
fun setName(element: FlatbuffersEnumValue, newName: String) = setName<FlatbuffersEnumValue>(element, newName)


fun getTextRangeInParent(ident: PsiElement): TextRange {
    return TextRange(ident.startOffsetInParent, ident.startOffsetInParent + ident.textLength)
}

fun getFlatbuffersFiles(project: Project): List<PsiFile> {
    // get every flatbuffers file in the project
    val manager = PsiManager.getInstance(project)
    val fbFiles = FileTypeIndex.getFiles(FlatbuffersFileType, GlobalSearchScope.allScope(project)).map {
        manager.findFile(it)
    }
    return fbFiles.filterNotNull()
}

fun getVariants(declarations: List<FlatbuffersNamedElement>): Array<LookupElement> {
    val variants = declarations.filter { it.name != null && it.name!!.isNotEmpty() }
    return variants.map {
        LookupElementBuilder.create(it).withTypeText(it.containingFile.name)
    }.toTypedArray()
}
