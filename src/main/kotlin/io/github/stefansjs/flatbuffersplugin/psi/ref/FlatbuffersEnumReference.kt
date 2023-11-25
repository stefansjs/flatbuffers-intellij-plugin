package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumValue
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumvalDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersFieldDecl
import io.github.stefansjs.flatbuffersplugin.psi.impl.getFlatbuffersFiles
import io.github.stefansjs.flatbuffersplugin.psi.impl.getTextRangeInParent
import io.github.stefansjs.flatbuffersplugin.psi.impl.getVariants

class FlatbuffersEnumReference(element: FlatbuffersEnumValue) :
    PsiReferenceBase<FlatbuffersEnumValue>(element, getTextRangeInParent(element.identifier))
{
    override fun resolve(): PsiElement? {
        val enumValue = rangeInElement.substring(element.text)
        val enumType = getEnumType(element)

        // In theory there should be only one enum declaration of the same name and type,
        // but for now we're ignoring namespaces, so just return the first declaration
        val localDeclarations = findEnums(element.containingFile, enumValue, enumType)
        if(localDeclarations.isNotEmpty()) {
            return localDeclarations[0]
        }

        val allDeclarations = findEnums(element.project, enumValue, enumType)
        if(allDeclarations.isNotEmpty()) {
            return localDeclarations[0]
        }

        return null
    }

    override fun getVariants(): Array<LookupElement> {
        val declarations = findEnums(element.project)
        return getVariants(declarations)
    }
}

private fun getEnumType(enumValue: FlatbuffersEnumvalDecl): FlatbuffersNamedElement? {
    // get the containing class
    val enumClass = PsiTreeUtil.findFirstParent(enumValue) { e -> e is FlatbuffersEnumDecl } as FlatbuffersEnumDecl?
    return enumClass?.typeName
}

private fun getEnumType(enumValue: FlatbuffersEnumValue): FlatbuffersNamedElement? {
    // enumValue is FlatbuffersEnumValue
    val fieldDecl = PsiTreeUtil.findFirstParent(enumValue) { e -> e is FlatbuffersFieldDecl } as FlatbuffersFieldDecl?
    return fieldDecl?.fieldType?.declaredType?.declaredName?.reference?.resolve() as FlatbuffersNamedElement?
}

private fun findEnums(file: PsiFile?, enumValue: String?, enumType: PsiElement?): List<FlatbuffersNamedElement> {
    val values = PsiTreeUtil.findChildrenOfAnyType(file, FlatbuffersEnumvalDecl::class.java).filterNotNull().filter {
        enumValue == it.name && enumType == getEnumType(it)
    }
    return values.toList()
}

private fun findEnums(project: Project, enumValue: String? = null, enumType: PsiElement? = null): List<FlatbuffersNamedElement> {
    val enums = ArrayList<FlatbuffersNamedElement>()
    for(file in getFlatbuffersFiles(project)) {
        enums.addAll(findEnums(file, enumValue, enumType))
    }
    return enums
}
