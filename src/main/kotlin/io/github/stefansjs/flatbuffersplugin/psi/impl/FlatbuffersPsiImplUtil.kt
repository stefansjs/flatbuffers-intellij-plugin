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

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import io.github.stefansjs.flatbuffersplugin.FlatbuffersFileType
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypeDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersUnionDecl
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
fun <T : FlatbuffersNamedElement> setName(element: T, newName: String): FlatbuffersNamedElement
{
    val identifierNode = element.nameIdentifier!!.node

    val type = createClass(element.project, newName)
    val newClassNode = type?.firstChild?.node ?: return element // That's a lot of null checking :/
    element.node.replaceChild(identifierNode, newClassNode)

    return element
}

// FlatbuffersNamedElement implementations for FlatbuffersTypeDecl
fun getNameIdentifier(element: FlatbuffersTypeDecl) = element.ident
fun getName(element: FlatbuffersTypeDecl) = element.ident.text
fun setName(element: FlatbuffersTypeDecl, newName: String) = setName<FlatbuffersTypeDecl>(element, newName)

// Replicate the same for FlatbuffersEnumDecl
fun getNameIdentifier(element: FlatbuffersEnumDecl) = element.ident
fun getName(element: FlatbuffersEnumDecl) = element.ident.text
fun setName(element: FlatbuffersEnumDecl, newName: String) = setName<FlatbuffersEnumDecl>(element, newName)

// and for union decl
fun getNameIdentifier(element: FlatbuffersUnionDecl) = element.ident
fun getName(element: FlatbuffersUnionDecl) = element.ident.text
fun setName(element: FlatbuffersUnionDecl, newName: String) = setName<FlatbuffersUnionDecl>(element, newName)


// Reference resolvers. Based (conveniently) on the above getName implementations
fun findTypes(project: Project, typeName: String?=null): List<FlatbuffersNamedElement>
{
    // Try the current file first
    val results = ArrayList<FlatbuffersNamedElement>()
    for(virtualFile in FileTypeIndex.getFiles(FlatbuffersFileType, GlobalSearchScope.allScope(project))) {
        val fbFile = PsiManager.getInstance(project).findFile(virtualFile)
        if(fbFile != null) {
            results.addAll(findTypes(fbFile, typeName))
        }
    }
    return results
}

fun findTypes(file: PsiFile, typeName: String? = null): List<FlatbuffersNamedElement>
{
    var declarations = PsiTreeUtil.findChildrenOfAnyType(file,
                                                         FlatbuffersTypeDecl::class.java,
                                                         FlatbuffersUnionDecl::class.java,
                                                         FlatbuffersEnumDecl::class.java)
    if (typeName != null) {
        declarations = declarations.filter { typeName == it.name }
    }
    return declarations.toList()
}