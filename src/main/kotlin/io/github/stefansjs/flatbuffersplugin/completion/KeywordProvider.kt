package io.github.stefansjs.flatbuffersplugin.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class KeywordProvider: CompletionProvider<CompletionParameters>()
{
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext?, result: CompletionResultSet)
    {
        result.addElement(LookupElementBuilder.create("table"))
        result.addElement(LookupElementBuilder.create("struct"))
    }
}
