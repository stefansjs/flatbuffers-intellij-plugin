package io.github.stefansjs.flatbuffersplugin.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class KeywordProvider: CompletionProvider<CompletionParameters>()
{
    val declarationKeywords = listOf("include", "import", "native_include", "namespace", "table", "struct", "attribute",
                                     "enum", "union", "root_type", "rpc_service", "file_extension", "file_identifier")
    val typeKeywords = listOf("bool", "byte", "ubyte", "short", "ushort", "int", "uint", "long", "ulong", "int8",
                              "uint8", "int16", "uint16", "int32", "uint32", "int64", "uint64", "float", "double",
                              "float32", "float64")
    val valueKeywords = listOf("true", "false")
    val allKeywords = declarationKeywords + typeKeywords + valueKeywords

    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet)
    {
        result.addAllElements(allKeywords.map { LookupElementBuilder.create(it) })
    }
}
