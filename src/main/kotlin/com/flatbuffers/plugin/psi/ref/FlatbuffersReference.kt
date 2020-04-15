package com.flatbuffers.plugin.psi.ref

import com.flatbuffers.plugin.icons.FlatbuffersIcon
import com.flatbuffers.plugin.util.findClasses
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult


class FlatbuffersReference(element: PsiElement, textRange: TextRange): PsiReferenceBase<PsiElement>(element, textRange),
                                                                       PsiPolyVariantReference {
    private val className: String = element.text.substring(textRange.startOffset, textRange.endOffset)

    override fun resolve(): PsiElement? {
        val results = multiResolve(false)
        return if(results.size == 1) results[0].element else null
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val properties = findClasses(myElement.project, className)
        val results = properties.map(::PsiElementResolveResult)
        return results.toTypedArray()
    }

    override fun getVariants(): Array<Any> {
        val classes = findClasses(myElement.project)
        val variants = classes.map {
            LookupElementBuilder.create(it).withIcon(FlatbuffersIcon.ICON).withTypeText(it.containingFile.name)
        }
        return variants.toTypedArray()
    }
}