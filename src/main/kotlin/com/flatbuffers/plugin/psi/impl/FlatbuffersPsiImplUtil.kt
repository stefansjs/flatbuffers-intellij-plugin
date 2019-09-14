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
package com.flatbuffers.plugin.psi.impl

import com.flatbuffers.plugin.psi.FlatbuffersTypeDecl
import com.flatbuffers.plugin.psi.FlatbuffersTypes
import com.flatbuffers.plugin.psi.createClass
import com.intellij.psi.PsiElement


/* Created by stefansullivan on 2019-02-21 */

fun getClassName(element: FlatbuffersTypeDecl): String? {
    val classNode = element.node.findChildByType(FlatbuffersTypes.IDENT) ?: return null
    return classNode.text
}

fun getName(element: FlatbuffersTypeDecl) = getClassName(element)

fun setName(element: FlatbuffersTypeDecl, newName: String): FlatbuffersTypeDecl {
    val classNode = element.node.findChildByType(FlatbuffersTypes.IDENT) ?: return element

    val property = createClass(element.project, newName)
    val newClassNode = property?.firstChild?.node ?: return element // That's a lot of null checking :/
    element.node.replaceChild(classNode, newClassNode)

    return element
}

fun getNameIdentifier(element: FlatbuffersTypeDecl): PsiElement? {
    val keyNode = element.node.findChildByType(FlatbuffersTypes.IDENT) ?: return null
    return keyNode.psi
}