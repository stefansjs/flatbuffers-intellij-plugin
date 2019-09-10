// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.flatbuffers.plugin.psi.FlatbuffersTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FlatbuffersParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return schema(b, l + 1);
  }

  /* ********************************************************** */
  // ATTRIBUTE ident
  //                  | string_constant SEMICOLON
  public static boolean attribute_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_decl")) return false;
    if (!nextTokenIs(b, "<attribute decl>", ATTRIBUTE, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_DECL, "<attribute decl>");
    r = attribute_decl_0(b, l + 1);
    if (!r) r = attribute_decl_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ATTRIBUTE ident
  private static boolean attribute_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_decl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATTRIBUTE);
    r = r && ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_constant SEMICOLON
  private static boolean attribute_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_decl_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_constant(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (TRUE|FALSE) | (integer_constant QUESTION_MARK TRUE COLON FALSE)
  public static boolean boolean_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_CONSTANT, "<boolean constant>");
    r = boolean_constant_0(b, l + 1);
    if (!r) r = boolean_constant_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TRUE|FALSE
  private static boolean boolean_constant_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_constant_0")) return false;
    boolean r;
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    return r;
  }

  // integer_constant QUESTION_MARK TRUE COLON FALSE
  private static boolean boolean_constant_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_constant_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integer_constant(b, l + 1);
    r = r && consumeTokens(b, 0, QUESTION_MARK, TRUE, COLON, FALSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // enumval_decl ( COMMA enumval_decl )* COMMA?
  static boolean commasep_enumval_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_enumval_decl")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumval_decl(b, l + 1);
    r = r && commasep_enumval_decl_1(b, l + 1);
    r = r && commasep_enumval_decl_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA enumval_decl )*
  private static boolean commasep_enumval_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_enumval_decl_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!commasep_enumval_decl_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "commasep_enumval_decl_1", c)) break;
    }
    return true;
  }

  // COMMA enumval_decl
  private static boolean commasep_enumval_decl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_enumval_decl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enumval_decl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean commasep_enumval_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_enumval_decl_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ( value ( COMMA value )* )?
  static boolean commasep_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_value")) return false;
    commasep_value_0(b, l + 1);
    return true;
  }

  // value ( COMMA value )*
  private static boolean commasep_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_value_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value(b, l + 1);
    r = r && commasep_value_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA value )*
  private static boolean commasep_value_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_value_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!commasep_value_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "commasep_value_0_1", c)) break;
    }
    return true;
  }

  // COMMA value
  private static boolean commasep_value_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_value_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEC_INTEGER
  public static boolean dec_integer_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dec_integer_constant")) return false;
    if (!nextTokenIs(b, DEC_INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEC_INTEGER);
    exit_section_(b, m, DEC_INTEGER_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // DEC_FLOAT
  public static boolean decimal_float_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decimal_float_constant")) return false;
    if (!nextTokenIs(b, DEC_FLOAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEC_FLOAT);
    exit_section_(b, m, DECIMAL_FLOAT_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // namespace_decl
  //               | type_decl
  //               | enum_decl
  //               | root_decl
  //               | file_extension_decl
  //               | file_identifier_decl
  //               | attribute_decl
  //               | rpc_decl
  //               | object
  public static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECLARATION, "<declaration>");
    r = namespace_decl(b, l + 1);
    if (!r) r = type_decl(b, l + 1);
    if (!r) r = enum_decl(b, l + 1);
    if (!r) r = root_decl(b, l + 1);
    if (!r) r = file_extension_decl(b, l + 1);
    if (!r) r = file_identifier_decl(b, l + 1);
    if (!r) r = attribute_decl(b, l + 1);
    if (!r) r = rpc_decl(b, l + 1);
    if (!r) r = object(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( ENUM ident ( COLON type )? | union ident ) metadata LCURLY commasep_enumval_decl? RCURLY
  public static boolean enum_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl")) return false;
    if (!nextTokenIs(b, "<enum decl>", ENUM, UNION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECL, "<enum decl>");
    r = enum_decl_0(b, l + 1);
    r = r && metadata(b, l + 1);
    r = r && consumeToken(b, LCURLY);
    r = r && enum_decl_3(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ENUM ident ( COLON type )? | union ident
  private static boolean enum_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enum_decl_0_0(b, l + 1);
    if (!r) r = enum_decl_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ENUM ident ( COLON type )?
  private static boolean enum_decl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENUM);
    r = r && ident(b, l + 1);
    r = r && enum_decl_0_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COLON type )?
  private static boolean enum_decl_0_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_0_0_2")) return false;
    enum_decl_0_0_2_0(b, l + 1);
    return true;
  }

  // COLON type
  private static boolean enum_decl_0_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_0_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // union ident
  private static boolean enum_decl_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNION);
    r = r && ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // commasep_enumval_decl?
  private static boolean enum_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_3")) return false;
    commasep_enumval_decl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ident ( EQUALS integer_constant )?
  public static boolean enumval_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumval_decl")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && enumval_decl_1(b, l + 1);
    exit_section_(b, m, ENUMVAL_DECL, r);
    return r;
  }

  // ( EQUALS integer_constant )?
  private static boolean enumval_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumval_decl_1")) return false;
    enumval_decl_1_0(b, l + 1);
    return true;
  }

  // EQUALS integer_constant
  private static boolean enumval_decl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumval_decl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && integer_constant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ident COLON type ( EQUALS scalar )? metadata SEMICOLON
  public static boolean field_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && type(b, l + 1);
    r = r && field_decl_3(b, l + 1);
    r = r && metadata(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, FIELD_DECL, r);
    return r;
  }

  // ( EQUALS scalar )?
  private static boolean field_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_3")) return false;
    field_decl_3_0(b, l + 1);
    return true;
  }

  // EQUALS scalar
  private static boolean field_decl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && scalar(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FILE_EXTENSION string_constant SEMICOLON
  public static boolean file_extension_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_extension_decl")) return false;
    if (!nextTokenIs(b, FILE_EXTENSION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FILE_EXTENSION);
    r = r && string_constant(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, FILE_EXTENSION_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // FILE_IDENTIFIER string_constant SEMICOLON
  public static boolean file_identifier_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_identifier_decl")) return false;
    if (!nextTokenIs(b, FILE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FILE_IDENTIFIER);
    r = r && string_constant(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, FILE_IDENTIFIER_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // decimal_float_constant | hexadecimal_float_constant | special_float_constant
  public static boolean float_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOAT_CONSTANT, "<float constant>");
    r = decimal_float_constant(b, l + 1);
    if (!r) r = hexadecimal_float_constant(b, l + 1);
    if (!r) r = special_float_constant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // HEX_INTEGER
  public static boolean hex_integer_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hex_integer_constant")) return false;
    if (!nextTokenIs(b, HEX_INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEX_INTEGER);
    exit_section_(b, m, HEX_INTEGER_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // HEX_FLOAT
  public static boolean hexadecimal_float_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hexadecimal_float_constant")) return false;
    if (!nextTokenIs(b, HEX_FLOAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HEX_FLOAT);
    exit_section_(b, m, HEXADECIMAL_FLOAT_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ident")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENT, r);
    return r;
  }

  /* ********************************************************** */
  // INCLUDE string_constant SEMICOLON
  public static boolean incl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "incl")) return false;
    if (!nextTokenIs(b, INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCLUDE);
    r = r && string_constant(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, INCL, r);
    return r;
  }

  /* ********************************************************** */
  // dec_integer_constant | hex_integer_constant
  public static boolean integer_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_constant")) return false;
    if (!nextTokenIs(b, "<integer constant>", DEC_INTEGER, HEX_INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_CONSTANT, "<integer constant>");
    r = dec_integer_constant(b, l + 1);
    if (!r) r = hex_integer_constant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( LPAREN metadata_value ( COMMA metadata_value )* RPAREN )?
  public static boolean metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata")) return false;
    Marker m = enter_section_(b, l, _NONE_, METADATA, "<metadata>");
    metadata_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // LPAREN metadata_value ( COMMA metadata_value )* RPAREN
  private static boolean metadata_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && metadata_value(b, l + 1);
    r = r && metadata_0_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA metadata_value )*
  private static boolean metadata_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "metadata_0_2", c)) break;
    }
    return true;
  }

  // COMMA metadata_value
  private static boolean metadata_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && metadata_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ident ( COLON single_value )?
  static boolean metadata_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && metadata_value_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COLON single_value )?
  private static boolean metadata_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value_1")) return false;
    metadata_value_1_0(b, l + 1);
    return true;
  }

  // COLON single_value
  private static boolean metadata_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && single_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAMESPACE ident ( DOT ident )* SEMICOLON
  public static boolean namespace_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_decl")) return false;
    if (!nextTokenIs(b, NAMESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NAMESPACE);
    r = r && ident(b, l + 1);
    r = r && namespace_decl_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, NAMESPACE_DECL, r);
    return r;
  }

  // ( DOT ident )*
  private static boolean namespace_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_decl_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namespace_decl_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namespace_decl_2", c)) break;
    }
    return true;
  }

  // DOT ident
  private static boolean namespace_decl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_decl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // object_value ( COMMA object_value )*
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = object_value(b, l + 1);
    r = r && object_1(b, l + 1);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  // ( COMMA object_value )*
  private static boolean object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!object_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "object_1", c)) break;
    }
    return true;
  }

  // COMMA object_value
  private static boolean object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && object_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ident COLON value
  static boolean object_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_value")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ROOT_TYPE ident SEMICOLON
  public static boolean root_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_decl")) return false;
    if (!nextTokenIs(b, ROOT_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROOT_TYPE);
    r = r && ident(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ROOT_DECL, r);
    return r;
  }

  /* ********************************************************** */
  // RPC_SERVICE ident LCURLY rpc_method+ RCURLY
  public static boolean rpc_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_decl")) return false;
    if (!nextTokenIs(b, RPC_SERVICE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RPC_SERVICE);
    r = r && ident(b, l + 1);
    r = r && consumeToken(b, LCURLY);
    r = r && rpc_decl_3(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, RPC_DECL, r);
    return r;
  }

  // rpc_method+
  private static boolean rpc_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_decl_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rpc_method(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!rpc_method(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rpc_decl_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ident LPAREN ident RPAREN COLON ident metadata SEMICOLON
  public static boolean rpc_method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_method")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && ident(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, COLON);
    r = r && ident(b, l + 1);
    r = r && metadata(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RPC_METHOD, r);
    return r;
  }

  /* ********************************************************** */
  // integer_constant | float_constant | boolean_constant
  public static boolean scalar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scalar")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SCALAR, "<scalar>");
    r = integer_constant(b, l + 1);
    if (!r) r = float_constant(b, l + 1);
    if (!r) r = boolean_constant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // incl* declaration*
  static boolean schema(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = schema_0(b, l + 1);
    r = r && schema_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // incl*
  private static boolean schema_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!incl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schema_0", c)) break;
    }
    return true;
  }

  // declaration*
  private static boolean schema_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "schema_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!declaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "schema_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // scalar | string_constant
  public static boolean single_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_VALUE, "<single value>");
    r = scalar(b, l + 1);
    if (!r) r = string_constant(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SPECIAL_FLOAT
  public static boolean special_float_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "special_float_constant")) return false;
    if (!nextTokenIs(b, SPECIAL_FLOAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPECIAL_FLOAT);
    exit_section_(b, m, SPECIAL_FLOAT_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean string_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_constant")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // bool
  //        | byte
  //        | ubyte
  //        | short
  //        | ushort
  //        | int
  //        | uint
  //        | float
  //        | long
  //        | ulong
  //        | double
  //        | int8
  //        | uint8
  //        | int16
  //        | uint16
  //        | int32
  //        | uint32
  //        | int64
  //        | uint64
  //        | float32
  //        | float64
  //        | string
  //        | LBRACK type RBRACK
  //        | ident (DOT ident)*
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, UBYTE);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, USHORT);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, UINT);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, ULONG);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, INT8);
    if (!r) r = consumeToken(b, UINT8);
    if (!r) r = consumeToken(b, INT16);
    if (!r) r = consumeToken(b, UINT16);
    if (!r) r = consumeToken(b, INT32);
    if (!r) r = consumeToken(b, UINT32);
    if (!r) r = consumeToken(b, INT64);
    if (!r) r = consumeToken(b, UINT64);
    if (!r) r = consumeToken(b, FLOAT32);
    if (!r) r = consumeToken(b, FLOAT64);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = type_22(b, l + 1);
    if (!r) r = type_23(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACK type RBRACK
  private static boolean type_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  // ident (DOT ident)*
  private static boolean type_23(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_23")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && type_23_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT ident)*
  private static boolean type_23_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_23_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_23_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_23_1", c)) break;
    }
    return true;
  }

  // DOT ident
  private static boolean type_23_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_23_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && ident(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( TABLE | STRUCT ) ident metadata LCURLY field_decl+ RCURLY
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    if (!nextTokenIs(b, "<type decl>", STRUCT, TABLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, "<type decl>");
    r = type_decl_0(b, l + 1);
    r = r && ident(b, l + 1);
    r = r && metadata(b, l + 1);
    r = r && consumeToken(b, LCURLY);
    r = r && type_decl_4(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TABLE | STRUCT
  private static boolean type_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_0")) return false;
    boolean r;
    r = consumeToken(b, TABLE);
    if (!r) r = consumeToken(b, STRUCT);
    return r;
  }

  // field_decl+
  private static boolean type_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_decl(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!field_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_decl_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // single_value | object | LBRACK commasep_value RBRACK
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = single_value(b, l + 1);
    if (!r) r = object(b, l + 1);
    if (!r) r = value_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACK commasep_value RBRACK
  private static boolean value_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && commasep_value(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

}