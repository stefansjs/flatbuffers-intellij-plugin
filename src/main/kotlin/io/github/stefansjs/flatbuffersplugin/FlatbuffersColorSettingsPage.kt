package io.github.stefansjs.flatbuffersplugin

import io.github.stefansjs.flatbuffersplugin.icons.FlatbuffersIcon
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage


class FlatbuffersColorSettingsPage: ColorSettingsPage {
    companion object {
        val DESCRIPTORS = arrayOf(
            AttributesDescriptor("Comment", FlatbuffersSyntaxHighlighter.COMMENT),
            AttributesDescriptor("Comment Block", FlatbuffersSyntaxHighlighter.BLOCK_COMMENT),
            AttributesDescriptor("String", FlatbuffersSyntaxHighlighter.STRING),
            AttributesDescriptor("Keyword", FlatbuffersSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("Type", FlatbuffersSyntaxHighlighter.TYPE),
            AttributesDescriptor("Number", FlatbuffersSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Operator", FlatbuffersSyntaxHighlighter.OPERATOR),
            //no identifier because the below types should cover identifiers
            AttributesDescriptor("Class Name", FlatbuffersAnnotator.CLASS_NAME),
            AttributesDescriptor("Class Reference", FlatbuffersAnnotator.CLASS_REFERENCE),
            AttributesDescriptor("Member", FlatbuffersAnnotator.MEMBER)
            , AttributesDescriptor("Enum constant", FlatbuffersAnnotator.ENUM_VALUE)
            , AttributesDescriptor("Enum reference", FlatbuffersAnnotator.ENUM_REFERENCE)
            , AttributesDescriptor("Union alias", FlatbuffersAnnotator.UNION_ALIAS)
            , AttributesDescriptor("Namespace", FlatbuffersAnnotator.NAMESPACE_NAME)
            , AttributesDescriptor("Namespace reference", FlatbuffersAnnotator.NAMESPACE_REF)
        )

        val TAGS = mutableMapOf(
            "type_name" to FlatbuffersAnnotator.CLASS_NAME
            , "type_ref" to FlatbuffersAnnotator.CLASS_REFERENCE
            , "member" to FlatbuffersAnnotator.MEMBER
            , "enum_val" to FlatbuffersAnnotator.ENUM_VALUE
            , "enum_ref" to FlatbuffersAnnotator.ENUM_REFERENCE
            , "alias" to FlatbuffersAnnotator.UNION_ALIAS
            , "namespace" to FlatbuffersAnnotator.NAMESPACE_NAME
            , "namespace_ref" to FlatbuffersAnnotator.NAMESPACE_REF
        )
    }

    override fun getIcon() = FlatbuffersIcon.FILE
    override fun getHighlighter() = FlatbuffersSyntaxHighlighter()
    override fun getDisplayName() = FlatbuffersLanguage.displayName

    override fun getAttributeDescriptors() = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? = TAGS

    override fun getDemoText() = """
        |// example IDL file
        |
        |namespace <namespace>MyGame</namespace>;
        |
        |/* Declaring a namespace creates a scope for further declarations */
        |
        |attribute "priority";
        |
        |enum <type_name>Color</type_name> : byte { <enum_val>Red</enum_val> = 1, <enum_val>Green</enum_val>, <enum_val>Blue</enum_val> }
        |
        |union Any { <alias>mon</alias>:<type_ref>Monster</type_ref>, <type_ref>Weapon</type_ref>, <type_ref>Pickup</type_ref> }
        |
        |struct <type_name>Vec3</type_name> {
        |  <member>x</member>:float;
        |  <member>y</member>:float;
        |  <member>z</member>:float;
        |}
        |
        |table <type_name>Monster</type_name> {
        |  <member>pos</member>:<type_ref>Vec3</type_ref>;
        |  <member>mana</member>:short = 150;
        |  <member>hp</member>:short = 100;
        |  <member>name</member>:string;
        |  <member>friendly</member>:bool = false (deprecated, priority: 1);
        |  <member>inventory</member>:[ubyte];
        |  <member>color</member>:<type_ref>Color</type_ref> = <enum_ref>Blue</enum_ref>;
        |  <member>test</member>:<namespace_ref>MyGame</namespace_ref>.<type_ref>Any</type_ref>;
        |}
        |
        |root_type <type_ref>Monster</type_ref>;
        |""".trimMargin()
}