package io.github.stefansjs.flatbuffersplugin

import com.intellij.testFramework.ParsingTestCase

class ParsingFailuresTest: ParsingTestCase("parsingFailures", "fbs", FlatbuffersParserDefinition()) {
    fun testParsingTestData() = doTest(true)

    override fun getTestDataPath() = "src/test/testData"
    override fun skipSpaces() = false
    override fun includeRanges() = true
}
