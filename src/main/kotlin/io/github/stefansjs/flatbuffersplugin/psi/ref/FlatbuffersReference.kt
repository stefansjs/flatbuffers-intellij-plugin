package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import io.github.stefansjs.flatbuffersplugin.icons.FlatbuffersIcon.FILE
import io.github.stefansjs.flatbuffersplugin.psi.impl.findTypes

class FlatbuffersReference(element: PsiElement, textRange: TextRange):
    PsiReferenceBase<PsiElement>(element, textRange),
    PsiPolyVariantReference
{
    private val type: String
    init {
        type = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun resolve(): PsiElement? {
        val resolveResult = multiResolve(false)
        return if (resolveResult.size == 1) resolveResult[0].element else null
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val declarations = findTypes(myElement.project, type)
        return declarations.map { PsiElementResolveResult(it) }.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val declarations = findTypes(myElement.project)
        val variants = declarations.filter { it.name != null && it.name!!.isNotEmpty() }
        return variants.map {
            LookupElementBuilder.create(it).withIcon(FILE).withTypeText(it.containingFile.name)
        }.toTypedArray()
    }
}