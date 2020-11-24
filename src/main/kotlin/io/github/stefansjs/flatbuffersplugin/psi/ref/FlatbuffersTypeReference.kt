package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import io.github.stefansjs.flatbuffersplugin.FlatbuffersFileType
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersDeclaredType
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersEnumDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypeDecl
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersUnionDecl

class FlatbuffersTypeReference(element: FlatbuffersDeclaredType) :
    PsiReferenceBase<FlatbuffersDeclaredType>(element,
                                              TextRange(element.ident!!.startOffsetInParent,
                                                        element.ident!!.startOffsetInParent + element.ident!!.textLength))
{
    override fun resolve(): PsiElement? {
        // Try and find the declaration locally first. IIUC flatbuffers only allows one declaratino per namespace,
        // which means finding more than one result is actually an error
        val typeText = rangeInElement.substring(element.text)

        val localDeclarations = findTypes(element.containingFile, typeText)
        if (localDeclarations.size == 1) {
            return localDeclarations[0]
        }

        val resolveResult = findTypes(element.project, typeText)
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
        val variants = declarations.filter { it.name != null && it.name!!.isNotEmpty() }
        return variants.map {
            LookupElementBuilder.create(it).withTypeText(it.containingFile.name)
        }.toTypedArray()
    }

}

// Reference resolvers. Based (conveniently) on the above getName implementations
private fun findTypes(project: Project, typeName: String? = null): List<FlatbuffersNamedElement>
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

private fun findTypes(file: PsiFile, typeName: String? = null): List<FlatbuffersNamedElement>
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
