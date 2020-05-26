package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import io.github.stefansjs.flatbuffersplugin.icons.FlatbuffersIcon.FILE
import io.github.stefansjs.flatbuffersplugin.psi.impl.findTypes

class FlatbuffersTypeReference(element: PsiElement):
    PsiReferenceBase<PsiElement>(element, TextRange(0, element.textLength))
{
    override fun resolve(): PsiElement? {
        // Try and find the declaration locally first. IIUC flatbuffers only allows one declaratino per namespace,
        // which means finding more than one result is actually an error
        val localDeclarations = findTypes(element.containingFile)
        if (localDeclarations.size == 1) {
            return localDeclarations[0]
        }

        val resolveResult = multiResolve()
        if (resolveResult.size == 1){
            return resolveResult[0].element
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
            LookupElementBuilder.create(it).withIcon(FILE).withTypeText(it.containingFile.name)
        }.toTypedArray()
    }
}