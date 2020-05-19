package io.github.stefansjs.flatbuffersplugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import io.github.stefansjs.flatbuffersplugin.FlatbuffersLanguage
import io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypes

class FlatbuffersCompletionContributor: CompletionContributor() {
    init {
        val attributeDeclPattern = PlatformPatterns
            .psiElement(FlatbuffersTypes.DECLARATION)
            .withLanguage(FlatbuffersLanguage)
        extend(CompletionType.BASIC, attributeDeclPattern, KeywordProvider())
    }
}