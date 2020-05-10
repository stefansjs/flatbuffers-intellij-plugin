/*
 * Copyright (c) 2020. Stefan Sullivan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.stefansjs.flatbuffersplugin

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase

class FlatbuffersCodeInsightTest: LightCodeInsightFixtureTestCase() {
    override fun getTestDataPath() = "src/test/testData"

    /**
     *  The annotator is meant primarily for annotating warnings and errors, but it also provides functionality for
     *  modifying the highlighting. Currently we're only really doing highlighting and not yet doing code-intelligence
     *  types of annotations. Hence we test checkInfos=true and ignoreExtraHighlighting=false
     */
    fun testAnnotator() {
        myFixture.configureByFiles("HighlightTestData.fbs")
        myFixture.checkHighlighting(false, true, true, false)
    }
}
