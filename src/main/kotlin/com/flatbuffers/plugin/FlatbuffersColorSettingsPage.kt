package com.flatbuffers.plugin

import com.flatbuffers.plugin.icons.FlatbuffersIcon
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage


class FlatbuffersColorSettingsPage: ColorSettingsPage {
    companion object {
        val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Comment", FlatbuffersSyntaxHighlighter.COMMENT),
            AttributesDescriptor("String", FlatbuffersSyntaxHighlighter.STRING),
            AttributesDescriptor("Keyword", FlatbuffersSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Type", FlatbuffersSyntaxHighlighter.TYPE),
            AttributesDescriptor("Number", FlatbuffersSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Operator", FlatbuffersSyntaxHighlighter.OPERATOR),
            //no identifier because the below types should cover identifiers
            AttributesDescriptor("Class Name", FlatbuffersAnnotator.CLASS_NAME),
            AttributesDescriptor("Class Reference", FlatbuffersAnnotator.CLASS_REFERENCE)
        )
    }

    override fun getIcon() = FlatbuffersIcon.ICON
    override fun getHighlighter() = FlatbuffersSyntaxHighlighter()
    override fun getDisplayName() = FlatbuffersLanguage.displayName

    override fun getAttributeDescriptors() = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY!!
    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = null

    override fun getDemoText() = """
        |// example IDL file
        |
        |namespace MyGame;
        |
        |attribute "priority";
        |
        |enum Color : byte { Red = 1, Green, Blue }
        |
        |union Any { Monster, Weapon, Pickup }
        |
        |struct Vec3 {
        |  x:float;
        |  y:float;
        |  z:float;
        |}
        |
        |table Monster {
        |  pos:Vec3;
        |  mana:short = 150;
        |  hp:short = 100;
        |  name:string;
        |  friendly:bool = false (deprecated, priority: 1);
        |  inventory:[ubyte];
        |  color:Color = Blue;
        |  test:Any;
        |}
        |
        |root_type Monster;
        |""".trimMargin()
}