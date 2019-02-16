package com.flatbuffers.plugin

import com.flatbuffers.plugin.icons.FlatbuffersIcon
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

/* Created by stefansullivan on 2019-02-15 */
object FlatbuffersFileType: LanguageFileType(FlatbuffersLanguage) {
    override fun getIcon() = FlatbuffersIcon.ICON
    override fun getName() = "Flatbuffers file"
    override fun getDescription() = "Flatbuffers schema file"
    override fun getDefaultExtension() = "fbs"
}
