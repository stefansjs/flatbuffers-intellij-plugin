package com.flatbuffers.plugin

import com.flatbuffers.plugin.icons.FlatbuffersIcon
import com.intellij.openapi.editor.colors.ColorKey
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
            AttributesDescriptor("Class Reference", FlatbuffersAnnotator.CLASS_REFERENCE),
            AttributesDescriptor("Member", FlatbuffersAnnotator.MEMBER)
        )

        val TAGS = mutableMapOf(
            "type_name" to FlatbuffersAnnotator.CLASS_NAME
            , "type_ref" to FlatbuffersAnnotator.CLASS_REFERENCE
            , "member" to FlatbuffersAnnotator.MEMBER
        )
    }

    override fun getIcon() = FlatbuffersIcon.ICON
    override fun getHighlighter() = FlatbuffersSyntaxHighlighter()
    override fun getDisplayName() = FlatbuffersLanguage.displayName

    override fun getAttributeDescriptors() = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY!!
    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = TAGS

    override fun getDemoText() = """
        |// example IDL file
        |
        |namespace MyGame;
        |
        |attribute "priority";
        |
        |enum <type_name>Color</type_name> : byte { Red = 1, Green, Blue }
        |
        |union Any { Monster, Weapon, Pickup }
        |
        |struct <type_name>Vec3</type_name> {
        |  <member>x</member>:float;
        |  <member>y</member>:float;
        |  <member>z</member>:float;
        |}
        |
        |table <type_name>Monster</type_name> {
        |  <member>pos</member>:<type_ref>Vec3</type_ref;
        |  <member>mana</member>:short = 150;
        |  <member>hp</member>:short = 100;
        |  <member>name</member>:string;
        |  <member>friendly</member>:bool = false (deprecated, priority: 1);
        |  <member>inventory</member>:[ubyte];
        |  <member>color</member>:<type_ref>Color</type_ref> = Blue;
        |  <member>test</member>:<type_ref>Any</type_ref>;
        |}
        |
        |root_type <type_ref>Monster</type_ref>;
        |""".trimMargin()
}