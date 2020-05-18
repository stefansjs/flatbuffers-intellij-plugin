package io.github.stefansjs.flatbuffersplugin

import io.github.stefansjs.flatbuffersplugin.icons.FlatbuffersIcon
import com.intellij.openapi.fileTypes.LanguageFileType

/* Created by stefansullivan on 2019-02-15 */
object FlatbuffersFileType: LanguageFileType(FlatbuffersLanguage) {
    override fun getIcon() = FlatbuffersIcon.FILE
    override fun getName() = "Flatbuffers file"
    override fun getDescription() = "Flatbuffers schema file"
    override fun getDefaultExtension() = "fbs"
}
