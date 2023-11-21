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

import com.intellij.psi.PsiElement
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredName
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
