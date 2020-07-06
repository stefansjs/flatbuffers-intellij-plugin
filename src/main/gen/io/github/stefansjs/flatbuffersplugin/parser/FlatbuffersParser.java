// This is a generated file. Not intended for manual editing.
package io.github.stefansjs.flatbuffersplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.github.stefansjs.flatbuffersplugin.psi.FlatbuffersTypes.*;
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
  // LBRACK (primitive | declared_type) RBRACK
  public static boolean array_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_TYPE, null);
    r = consumeToken(b, LBRACK);
    p = r; // pin = 1
    r = r && report_error_(b, array_type_1(b, l + 1));
    r = p && consumeToken(b, RBRACK) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // primitive | declared_type
  private static boolean array_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_1")) return false;
    boolean r;
    r = primitive(b, l + 1);
    if (!r) r = declared_type(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ATTRIBUTE ( ident | string_constant ) SEMICOLON
  public static boolean attribute_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_decl")) return false;
    if (!nextTokenIs(b, ATTRIBUTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE_DECL, null);
    r = consumeToken(b, ATTRIBUTE);
    r = r && attribute_decl_1(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ident | string_constant
  private static boolean attribute_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_decl_1")) return false;
    boolean r;
    r = ident(b, l + 1);
    if (!r) r = string_constant(b, l + 1);
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
  // unionval_decl ( COMMA unionval_decl )* COMMA?
  static boolean commasep_unionval_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_unionval_decl")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unionval_decl(b, l + 1);
    r = r && commasep_unionval_decl_1(b, l + 1);
    r = r && commasep_unionval_decl_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA unionval_decl )*
  private static boolean commasep_unionval_decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_unionval_decl_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!commasep_unionval_decl_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "commasep_unionval_decl_1", c)) break;
    }
    return true;
  }

  // COMMA unionval_decl
  private static boolean commasep_unionval_decl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_unionval_decl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && unionval_decl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean commasep_unionval_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "commasep_unionval_decl_2")) return false;
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
  // !(NAMESPACE |
  //                            TABLE |
  //                            STRUCT |
  //                            ENUM |
  //                            UNION |
  //                            ROOT_TYPE |
  //                            FILE_EXTENSION |
  //                            FILE_IDENTIFIER |
  //                            ATTRIBUTE |
  //                            RPC_SERVICE)
  static boolean decl_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !decl_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NAMESPACE |
  //                            TABLE |
  //                            STRUCT |
  //                            ENUM |
  //                            UNION |
  //                            ROOT_TYPE |
  //                            FILE_EXTENSION |
  //                            FILE_IDENTIFIER |
  //                            ATTRIBUTE |
  //                            RPC_SERVICE
  private static boolean decl_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_recover_0")) return false;
    boolean r;
    r = consumeToken(b, NAMESPACE);
    if (!r) r = consumeToken(b, TABLE);
    if (!r) r = consumeToken(b, STRUCT);
    if (!r) r = consumeToken(b, ENUM);
    if (!r) r = consumeToken(b, UNION);
    if (!r) r = consumeToken(b, ROOT_TYPE);
    if (!r) r = consumeToken(b, FILE_EXTENSION);
    if (!r) r = consumeToken(b, FILE_IDENTIFIER);
    if (!r) r = consumeToken(b, ATTRIBUTE);
    if (!r) r = consumeToken(b, RPC_SERVICE);
    return r;
  }

  /* ********************************************************** */
  // namespace_decl
  //               | type_decl
  //               | enum_decl
  //               | union_decl
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
    if (!r) r = union_decl(b, l + 1);
    if (!r) r = root_decl(b, l + 1);
    if (!r) r = file_extension_decl(b, l + 1);
    if (!r) r = file_identifier_decl(b, l + 1);
    if (!r) r = attribute_decl(b, l + 1);
    if (!r) r = rpc_decl(b, l + 1);
    if (!r) r = object(b, l + 1);
    exit_section_(b, l, m, r, false, decl_recover_parser_);
    return r;
  }

  /* ********************************************************** */
  // (ident DOT)*
  public static boolean declared_namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declared_namespace")) return false;
    Marker m = enter_section_(b, l, _NONE_, DECLARED_NAMESPACE, "<declared namespace>");
    while (true) {
      int c = current_position_(b);
      if (!declared_namespace_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "declared_namespace", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // ident DOT
  private static boolean declared_namespace_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declared_namespace_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // declared_namespace ident
  public static boolean declared_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declared_type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declared_namespace(b, l + 1);
    r = r && ident(b, l + 1);
    exit_section_(b, m, DECLARED_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // DOCLINE*
  public static boolean documentation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "documentation")) return false;
    Marker m = enter_section_(b, l, _NONE_, DOCUMENTATION, "<documentation>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, DOCLINE)) break;
      if (!empty_element_parsed_guard_(b, "documentation", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // documentation? ENUM ident ( COLON primitive )? metadata? LCURLY commasep_enumval_decl? RCURLY
  public static boolean enum_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl")) return false;
    if (!nextTokenIs(b, "<enum decl>", DOCLINE, ENUM)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DECL, "<enum decl>");
    r = enum_decl_0(b, l + 1);
    r = r && consumeToken(b, ENUM);
    r = r && ident(b, l + 1);
    p = r; // pin = ident
    r = r && report_error_(b, enum_decl_3(b, l + 1));
    r = p && report_error_(b, enum_decl_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LCURLY)) && r;
    r = p && report_error_(b, enum_decl_6(b, l + 1)) && r;
    r = p && consumeToken(b, RCURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // documentation?
  private static boolean enum_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_0")) return false;
    documentation(b, l + 1);
    return true;
  }

  // ( COLON primitive )?
  private static boolean enum_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_3")) return false;
    enum_decl_3_0(b, l + 1);
    return true;
  }

  // COLON primitive
  private static boolean enum_decl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && primitive(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // metadata?
  private static boolean enum_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_4")) return false;
    metadata(b, l + 1);
    return true;
  }

  // commasep_enumval_decl?
  private static boolean enum_decl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enum_decl_6")) return false;
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
  // field_ident COLON field_type ( EQUALS field_value )? metadata? SEMICOLON
  public static boolean field_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FIELD_DECL, "<field decl>");
    r = field_ident(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && report_error_(b, field_type(b, l + 1)) && r;
    r = p && report_error_(b, field_decl_3(b, l + 1)) && r;
    r = p && report_error_(b, field_decl_4(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( EQUALS field_value )?
  private static boolean field_decl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_3")) return false;
    field_decl_3_0(b, l + 1);
    return true;
  }

  // EQUALS field_value
  private static boolean field_decl_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && field_value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // metadata?
  private static boolean field_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_decl_4")) return false;
    metadata(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ident | keyword
  public static boolean field_ident(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_ident")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_IDENT, "<field ident>");
    r = ident(b, l + 1);
    if (!r) r = keyword(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // primitive
  //              | array_type
  //              | declared_type
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_TYPE, "<field type>");
    r = primitive(b, l + 1);
    if (!r) r = array_type(b, l + 1);
    if (!r) r = declared_type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ident | scalar
  public static boolean field_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_VALUE, "<field value>");
    r = ident(b, l + 1);
    if (!r) r = scalar(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // float
  //                      | double
  //                      | float32
  //                      | float64
  static boolean float_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_type")) return false;
    boolean r;
    r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, FLOAT32);
    if (!r) r = consumeToken(b, FLOAT64);
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
  // bool
  //                    | byte
  //                    | ubyte
  //                    | short
  //                    | ushort
  //                    | int
  //                    | uint
  //                    | long
  //                    | ulong
  //                    | int8
  //                    | uint8
  //                    | int16
  //                    | uint16
  //                    | int32
  //                    | uint32
  //                    | int64
  //                    | uint64
  static boolean int_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "int_type")) return false;
    boolean r;
    r = consumeToken(b, BOOL);
    if (!r) r = consumeToken(b, BYTE);
    if (!r) r = consumeToken(b, UBYTE);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, USHORT);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, UINT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, ULONG);
    if (!r) r = consumeToken(b, INT8);
    if (!r) r = consumeToken(b, UINT8);
    if (!r) r = consumeToken(b, INT16);
    if (!r) r = consumeToken(b, UINT16);
    if (!r) r = consumeToken(b, INT32);
    if (!r) r = consumeToken(b, UINT32);
    if (!r) r = consumeToken(b, INT64);
    if (!r) r = consumeToken(b, UINT64);
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
  // primitive
  //                   | TABLE
  //                   | STRUCT
  static boolean keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword")) return false;
    boolean r;
    r = primitive(b, l + 1);
    if (!r) r = consumeToken(b, TABLE);
    if (!r) r = consumeToken(b, STRUCT);
    return r;
  }

  /* ********************************************************** */
  // LPAREN metadata_value ( COMMA metadata_value )* RPAREN
  public static boolean metadata(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && metadata_value(b, l + 1);
    r = r && metadata_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, METADATA, r);
    return r;
  }

  // ( COMMA metadata_value )*
  private static boolean metadata_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!metadata_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "metadata_2", c)) break;
    }
    return true;
  }

  // COMMA metadata_value
  private static boolean metadata_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "metadata_2_0")) return false;
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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_DECL, null);
    r = consumeToken(b, NAMESPACE);
    r = r && ident(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, namespace_decl_2(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // int_type | float_type | string
  public static boolean primitive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE, "<primitive>");
    r = int_type(b, l + 1);
    if (!r) r = float_type(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ROOT_TYPE declared_type SEMICOLON
  public static boolean root_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_decl")) return false;
    if (!nextTokenIs(b, ROOT_TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ROOT_DECL, null);
    r = consumeToken(b, ROOT_TYPE);
    r = r && declared_type(b, l + 1);
    p = r; // pin = declared_type
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // RPC_SERVICE ident LCURLY rpc_method+ RCURLY
  public static boolean rpc_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_decl")) return false;
    if (!nextTokenIs(b, RPC_SERVICE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RPC_DECL, null);
    r = consumeToken(b, RPC_SERVICE);
    r = r && ident(b, l + 1);
    p = r; // pin = ident
    r = r && report_error_(b, consumeToken(b, LCURLY));
    r = p && report_error_(b, rpc_decl_3(b, l + 1)) && r;
    r = p && consumeToken(b, RCURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // ident LPAREN ident RPAREN COLON ident metadata? SEMICOLON
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
    r = r && rpc_method_6(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, RPC_METHOD, r);
    return r;
  }

  // metadata?
  private static boolean rpc_method_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rpc_method_6")) return false;
    metadata(b, l + 1);
    return true;
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
  // STRING_LITERAL
  public static boolean string_constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_constant")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING_CONSTANT, r);
    return r;
  }

  /* ********************************************************** */
  // ( TABLE | STRUCT ) ident metadata? LCURLY field_decl* RCURLY
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    if (!nextTokenIs(b, "<type decl>", STRUCT, TABLE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, "<type decl>");
    r = type_decl_0(b, l + 1);
    r = r && ident(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, type_decl_2(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LCURLY)) && r;
    r = p && report_error_(b, type_decl_4(b, l + 1)) && r;
    r = p && consumeToken(b, RCURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TABLE | STRUCT
  private static boolean type_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_0")) return false;
    boolean r;
    r = consumeToken(b, TABLE);
    if (!r) r = consumeToken(b, STRUCT);
    return r;
  }

  // metadata?
  private static boolean type_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_2")) return false;
    metadata(b, l + 1);
    return true;
  }

  // field_decl*
  private static boolean type_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_decl_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // documentation? union ident LCURLY commasep_unionval_decl? RCURLY
  public static boolean union_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_decl")) return false;
    if (!nextTokenIs(b, "<union decl>", DOCLINE, UNION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNION_DECL, "<union decl>");
    r = union_decl_0(b, l + 1);
    r = r && consumeToken(b, UNION);
    r = r && ident(b, l + 1);
    p = r; // pin = ident
    r = r && report_error_(b, consumeToken(b, LCURLY));
    r = p && report_error_(b, union_decl_4(b, l + 1)) && r;
    r = p && consumeToken(b, RCURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // documentation?
  private static boolean union_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_decl_0")) return false;
    documentation(b, l + 1);
    return true;
  }

  // commasep_unionval_decl?
  private static boolean union_decl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_decl_4")) return false;
    commasep_unionval_decl(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ( ident COLON )? declared_type
  public static boolean unionval_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionval_decl")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unionval_decl_0(b, l + 1);
    r = r && declared_type(b, l + 1);
    exit_section_(b, m, UNIONVAL_DECL, r);
    return r;
  }

  // ( ident COLON )?
  private static boolean unionval_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionval_decl_0")) return false;
    unionval_decl_0_0(b, l + 1);
    return true;
  }

  // ident COLON
  private static boolean unionval_decl_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unionval_decl_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ident(b, l + 1);
    r = r && consumeToken(b, COLON);
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

  static final Parser decl_recover_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return decl_recover(b, l + 1);
    }
  };
}
