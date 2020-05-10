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
package io.github.stefansjs.flatbuffersplugin.psi

import io.github.stefansjs.flatbuffersplugin.FlatbuffersFileType
import io.github.stefansjs.flatbuffersplugin.FlatbuffersLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

/* Created by stefansullivan on 2019-02-15 */
class FlatbuffersFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, FlatbuffersLanguage) {
    override fun getFileType() = FlatbuffersFileType

    override fun toString() = "Flatbuffers File"
}