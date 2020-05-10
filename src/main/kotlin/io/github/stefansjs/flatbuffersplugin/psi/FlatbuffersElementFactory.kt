package io.github.stefansjs.flatbuffersplugin.psi

import io.github.stefansjs.flatbuffersplugin.FlatbuffersFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.*


fun createClass(project: Project, name: String): PsiElement? {
    val file = createFile(project, name)
    return file.getFirstChild()
}

fun createFile(project: Project, text: String): FlatbuffersFile {
    val name = "dummy.simple"
    return PsiFileFactory.getInstance(project).createFileFromText(name, FlatbuffersFileType, text) as FlatbuffersFile
}