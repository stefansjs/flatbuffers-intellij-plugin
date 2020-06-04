package io.github.stefansjs.flatbuffersplugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.patterns.StandardPatterns

class FlatbuffersCompletionContributor: CompletionContributor() {
    init {
        val attributeDeclPattern = StandardPatterns.or(psiElement().afterLeaf(psiElement()), psiElement().isNull)
        extend(CompletionType.BASIC, attributeDeclPattern, KeywordProvider())
    }
}