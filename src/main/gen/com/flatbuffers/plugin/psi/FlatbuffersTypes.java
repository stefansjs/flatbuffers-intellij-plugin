// This is a generated file. Not intended for manual editing.
package com.flatbuffers.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.flatbuffers.plugin.psi.impl.*;

public interface FlatbuffersTypes {

  IElementType ARRAY_TYPE = new FlatbuffersElementType("ARRAY_TYPE");
  IElementType ATTRIBUTE_DECL = new FlatbuffersElementType("ATTRIBUTE_DECL");
  IElementType BOOLEAN_CONSTANT = new FlatbuffersElementType("BOOLEAN_CONSTANT");
  IElementType DECIMAL_FLOAT_CONSTANT = new FlatbuffersElementType("DECIMAL_FLOAT_CONSTANT");
  IElementType DECLARATION = new FlatbuffersElementType("DECLARATION");
  IElementType DECLARED_TYPE = new FlatbuffersElementType("DECLARED_TYPE");
  IElementType DEC_INTEGER_CONSTANT = new FlatbuffersElementType("DEC_INTEGER_CONSTANT");
  IElementType ENUMVAL_DECL = new FlatbuffersElementType("ENUMVAL_DECL");
  IElementType ENUM_DECL = new FlatbuffersElementType("ENUM_DECL");
  IElementType FIELD_DECL = new FlatbuffersElementType("FIELD_DECL");
  IElementType FILE_EXTENSION_DECL = new FlatbuffersElementType("FILE_EXTENSION_DECL");
  IElementType FILE_IDENTIFIER_DECL = new FlatbuffersElementType("FILE_IDENTIFIER_DECL");
  IElementType FLOAT_CONSTANT = new FlatbuffersElementType("FLOAT_CONSTANT");
  IElementType HEXADECIMAL_FLOAT_CONSTANT = new FlatbuffersElementType("HEXADECIMAL_FLOAT_CONSTANT");
  IElementType HEX_INTEGER_CONSTANT = new FlatbuffersElementType("HEX_INTEGER_CONSTANT");
  IElementType IDENT = new FlatbuffersElementType("IDENT");
  IElementType INCL = new FlatbuffersElementType("INCL");
  IElementType INTEGER_CONSTANT = new FlatbuffersElementType("INTEGER_CONSTANT");
  IElementType METADATA = new FlatbuffersElementType("METADATA");
  IElementType NAMESPACE_DECL = new FlatbuffersElementType("NAMESPACE_DECL");
  IElementType OBJECT = new FlatbuffersElementType("OBJECT");
  IElementType RECOVER_TYPE = new FlatbuffersElementType("RECOVER_TYPE");
  IElementType ROOT_DECL = new FlatbuffersElementType("ROOT_DECL");
  IElementType RPC_DECL = new FlatbuffersElementType("RPC_DECL");
  IElementType RPC_METHOD = new FlatbuffersElementType("RPC_METHOD");
  IElementType SCALAR = new FlatbuffersElementType("SCALAR");
  IElementType SINGLE_VALUE = new FlatbuffersElementType("SINGLE_VALUE");
  IElementType SPECIAL_FLOAT_CONSTANT = new FlatbuffersElementType("SPECIAL_FLOAT_CONSTANT");
  IElementType STRING_CONSTANT = new FlatbuffersElementType("STRING_CONSTANT");
  IElementType TYPE = new FlatbuffersElementType("TYPE");
  IElementType TYPE_DECL = new FlatbuffersElementType("TYPE_DECL");
  IElementType VALUE = new FlatbuffersElementType("VALUE");

  IElementType ATTRIBUTE = new FlatbuffersTokenType("ATTRIBUTE");
  IElementType BOOL = new FlatbuffersTokenType("bool");
  IElementType BYTE = new FlatbuffersTokenType("byte");
  IElementType COLON = new FlatbuffersTokenType("COLON");
  IElementType COMMA = new FlatbuffersTokenType("COMMA");
  IElementType COMMENT = new FlatbuffersTokenType("COMMENT");
  IElementType DEC_FLOAT = new FlatbuffersTokenType("DEC_FLOAT");
  IElementType DEC_INTEGER = new FlatbuffersTokenType("DEC_INTEGER");
  IElementType DOT = new FlatbuffersTokenType("DOT");
  IElementType DOUBLE = new FlatbuffersTokenType("double");
  IElementType ENUM = new FlatbuffersTokenType("ENUM");
  IElementType EQUALS = new FlatbuffersTokenType("EQUALS");
  IElementType FALSE = new FlatbuffersTokenType("FALSE");
  IElementType FILE_EXTENSION = new FlatbuffersTokenType("FILE_EXTENSION");
  IElementType FILE_IDENTIFIER = new FlatbuffersTokenType("FILE_IDENTIFIER");
  IElementType FLOAT = new FlatbuffersTokenType("float");
  IElementType FLOAT32 = new FlatbuffersTokenType("float32");
  IElementType FLOAT64 = new FlatbuffersTokenType("float64");
  IElementType HEX_FLOAT = new FlatbuffersTokenType("HEX_FLOAT");
  IElementType HEX_INTEGER = new FlatbuffersTokenType("HEX_INTEGER");
  IElementType IDENTIFIER = new FlatbuffersTokenType("IDENTIFIER");
  IElementType INCLUDE = new FlatbuffersTokenType("INCLUDE");
  IElementType INT = new FlatbuffersTokenType("int");
  IElementType INT16 = new FlatbuffersTokenType("int16");
  IElementType INT32 = new FlatbuffersTokenType("int32");
  IElementType INT64 = new FlatbuffersTokenType("int64");
  IElementType INT8 = new FlatbuffersTokenType("int8");
  IElementType LBRACK = new FlatbuffersTokenType("LBRACK");
  IElementType LCURLY = new FlatbuffersTokenType("LCURLY");
  IElementType LONG = new FlatbuffersTokenType("long");
  IElementType LPAREN = new FlatbuffersTokenType("LPAREN");
  IElementType NAMESPACE = new FlatbuffersTokenType("NAMESPACE");
  IElementType QUESTION_MARK = new FlatbuffersTokenType("QUESTION_MARK");
  IElementType RBRACK = new FlatbuffersTokenType("RBRACK");
  IElementType RCURLY = new FlatbuffersTokenType("RCURLY");
  IElementType ROOT_TYPE = new FlatbuffersTokenType("ROOT_TYPE");
  IElementType RPAREN = new FlatbuffersTokenType("RPAREN");
  IElementType RPC_SERVICE = new FlatbuffersTokenType("RPC_SERVICE");
  IElementType SEMICOLON = new FlatbuffersTokenType("SEMICOLON");
  IElementType SHORT = new FlatbuffersTokenType("short");
  IElementType SPECIAL_FLOAT = new FlatbuffersTokenType("SPECIAL_FLOAT");
  IElementType STRING = new FlatbuffersTokenType("string");
  IElementType STRUCT = new FlatbuffersTokenType("STRUCT");
  IElementType TABLE = new FlatbuffersTokenType("TABLE");
  IElementType TRUE = new FlatbuffersTokenType("TRUE");
  IElementType UBYTE = new FlatbuffersTokenType("ubyte");
  IElementType UINT = new FlatbuffersTokenType("uint");
  IElementType UINT16 = new FlatbuffersTokenType("uint16");
  IElementType UINT32 = new FlatbuffersTokenType("uint32");
  IElementType UINT64 = new FlatbuffersTokenType("uint64");
  IElementType UINT8 = new FlatbuffersTokenType("uint8");
  IElementType ULONG = new FlatbuffersTokenType("ulong");
  IElementType UNION = new FlatbuffersTokenType("union");
  IElementType USHORT = new FlatbuffersTokenType("ushort");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARRAY_TYPE) {
        return new FlatbuffersArrayTypeImpl(node);
      }
      else if (type == ATTRIBUTE_DECL) {
        return new FlatbuffersAttributeDeclImpl(node);
      }
      else if (type == BOOLEAN_CONSTANT) {
        return new FlatbuffersBooleanConstantImpl(node);
      }
      else if (type == DECIMAL_FLOAT_CONSTANT) {
        return new FlatbuffersDecimalFloatConstantImpl(node);
      }
      else if (type == DECLARATION) {
        return new FlatbuffersDeclarationImpl(node);
      }
      else if (type == DECLARED_TYPE) {
        return new FlatbuffersDeclaredTypeImpl(node);
      }
      else if (type == DEC_INTEGER_CONSTANT) {
        return new FlatbuffersDecIntegerConstantImpl(node);
      }
      else if (type == ENUMVAL_DECL) {
        return new FlatbuffersEnumvalDeclImpl(node);
      }
      else if (type == ENUM_DECL) {
        return new FlatbuffersEnumDeclImpl(node);
      }
      else if (type == FIELD_DECL) {
        return new FlatbuffersFieldDeclImpl(node);
      }
      else if (type == FILE_EXTENSION_DECL) {
        return new FlatbuffersFileExtensionDeclImpl(node);
      }
      else if (type == FILE_IDENTIFIER_DECL) {
        return new FlatbuffersFileIdentifierDeclImpl(node);
      }
      else if (type == FLOAT_CONSTANT) {
        return new FlatbuffersFloatConstantImpl(node);
      }
      else if (type == HEXADECIMAL_FLOAT_CONSTANT) {
        return new FlatbuffersHexadecimalFloatConstantImpl(node);
      }
      else if (type == HEX_INTEGER_CONSTANT) {
        return new FlatbuffersHexIntegerConstantImpl(node);
      }
      else if (type == IDENT) {
        return new FlatbuffersIdentImpl(node);
      }
      else if (type == INCL) {
        return new FlatbuffersInclImpl(node);
      }
      else if (type == INTEGER_CONSTANT) {
        return new FlatbuffersIntegerConstantImpl(node);
      }
      else if (type == METADATA) {
        return new FlatbuffersMetadataImpl(node);
      }
      else if (type == NAMESPACE_DECL) {
        return new FlatbuffersNamespaceDeclImpl(node);
      }
      else if (type == OBJECT) {
        return new FlatbuffersObjectImpl(node);
      }
      else if (type == RECOVER_TYPE) {
        return new FlatbuffersRecoverTypeImpl(node);
      }
      else if (type == ROOT_DECL) {
        return new FlatbuffersRootDeclImpl(node);
      }
      else if (type == RPC_DECL) {
        return new FlatbuffersRpcDeclImpl(node);
      }
      else if (type == RPC_METHOD) {
        return new FlatbuffersRpcMethodImpl(node);
      }
      else if (type == SCALAR) {
        return new FlatbuffersScalarImpl(node);
      }
      else if (type == SINGLE_VALUE) {
        return new FlatbuffersSingleValueImpl(node);
      }
      else if (type == SPECIAL_FLOAT_CONSTANT) {
        return new FlatbuffersSpecialFloatConstantImpl(node);
      }
      else if (type == STRING_CONSTANT) {
        return new FlatbuffersStringConstantImpl(node);
      }
      else if (type == TYPE) {
        return new FlatbuffersTypeImpl(node);
      }
      else if (type == TYPE_DECL) {
        return new FlatbuffersTypeDeclImpl(node);
      }
      else if (type == VALUE) {
        return new FlatbuffersValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
