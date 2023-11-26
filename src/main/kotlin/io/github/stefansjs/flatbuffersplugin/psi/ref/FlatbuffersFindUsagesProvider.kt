package io.github.stefansjs.flatbuffersplugin.psi.ref

import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import io.github.stefansjs.flatbuffersplugin.FlatbuffersLexerAdapter
import io.github.stefansjs.flatbuffersplugin.FlatbuffersParserDefinition.Companion.COMMENTS
import io.github.stefansjs.flatbuffersplugin.FlatbuffersParserDefinition.Companion.IDENTIFIERS
import io.github.stefansjs.flatbuffersplugin.FlatbuffersParserDefinition.Companion.STRING_LITERAL
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypeName

class FlatbuffersFindUsagesProvider: FindUsagesProvider {
    override fun canFindUsagesFor(psiElement: PsiElement) = psiElement is FlatbuffersNamedElement
    override fun getHelpId(psiElement: PsiElement): String? = null

    @Suppress("RedundantNullableReturnType")
    override fun getWordsScanner(): WordsScanner? {
        return DefaultWordsScanner(FlatbuffersLexerAdapter(), IDENTIFIERS, COMMENTS, STRING_LITERAL)
    }

    override fun getType(element: PsiElement): String {
        return if (element is FlatbuffersTypeName) "Flatbuffers type"
        else ""
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return (element as FlatbuffersTypeName?)?.name ?: ""
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        val typeName = element as FlatbuffersNamedElement
        val namespace = if(useFullName) getNamespace(typeName) else null
        val fullName = if (namespace != null) "$namespace.${typeName.name}" else typeName.name
        return fullName ?: ""
    }
}

private fun getNamespace(typeName: FlatbuffersNamedElement?): String? {
    // for now just return an empty namespace all the time
    // When I add namespace support, I'm going to have to replace this implementation
    return null
}
