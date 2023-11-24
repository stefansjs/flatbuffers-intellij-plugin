package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.psi.util.PsiTreeUtil
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredName
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypeName
import io.github.stefansjs.flatbuffersplugin.psi.impl.getFlatbuffersFiles
import io.github.stefansjs.flatbuffersplugin.psi.impl.getTextRangeInParent
import io.github.stefansjs.flatbuffersplugin.psi.impl.getVariants

class FlatbuffersTypeReference(element: FlatbuffersDeclaredName) :
    PsiReferenceBase<FlatbuffersDeclaredName>(element, getTextRangeInParent(element.identifier))
{
    val typeName = rangeInElement.substring(element.text)

    override fun resolve(): PsiElement? {
        // Try and find the declaration locally first. IIUC flatbuffers only allows one declaration per namespace,
        // which means finding more than one result is actually an error
        val localDeclarations = findTypes(element.containingFile, typeName)
        if (localDeclarations.size == 1) {
            return localDeclarations[0]
        }

        val resolveResult = findTypes(element.project, typeName)
        if (resolveResult.size == 1){
            return resolveResult[0]
        }

        return null
    }

    private fun multiResolve(): Array<ResolveResult> {
        val declarations = findTypes(element.project, element.text)
        return declarations.map { PsiElementResolveResult(it) }.toTypedArray()
    }

    override fun getVariants(): Array<LookupElement> {
        val declarations = findTypes(element.project)
        return getVariants(declarations)
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        element.setName(newElementName)
        return element
    }
}

// Reference resolvers. Based (conveniently) on the above getName implementations
private fun findTypes(project: Project, typeName: String? = null): List<FlatbuffersNamedElement>
{
    // find all matching declarations in all flatbuffers files
    val fbFiles = getFlatbuffersFiles(project)
    val results = ArrayList<FlatbuffersNamedElement>()
    for(fbFile in fbFiles) {
        results.addAll(findTypes(fbFile, typeName))
    }

    return results
}

private fun findTypes(file: PsiFile, typeName: String? = null): List<FlatbuffersNamedElement>
{
    val types = PsiTreeUtil.findChildrenOfAnyType(file, FlatbuffersTypeName::class.java).filterNotNull().filter {
        typeName == it.name
    }
    return types.toList()
}
