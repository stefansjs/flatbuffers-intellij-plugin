package com.flatbuffers.plugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.flatbuffers.plugin.psi.FlatbuffersTypes.*;

%%

%{
  public FlatbuffersLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class FlatbuffersLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

STRING_LITERAL=\".*?\"
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
DEC_INTEGER=[-+]?[0-9]+
HEX_INTEGER=[-+]?0[xX][0-9a-fA-F]+
DEC_FLOAT=[-+]?(([.][0-9]+)|([0-9]+[.][0-9]*)|([0-9]+))([eE][-+]?[0-9]+)?
HEX_FLOAT=[-+]?0[xX](([.][0-9a-fA-F]+)|([0-9a-fA-F]+[.][0-9a-fA-F]*)|([0-9a-fA-F]+))([pP][-+]?[0-9]+)
SPECIAL_FLOAT=[-+]?(nan|inf|infinity)
DOCLINE="///"[^\r\n/]*
COMMENT="//"[^\r\n]*

%%
<YYINITIAL> {
  {WHITE_SPACE}        { return WHITE_SPACE; }

  "include"            { return INCLUDE; }
  "namespace"          { return NAMESPACE; }
  "attribute"          { return ATTRIBUTE; }
  "table"              { return TABLE; }
  "struct"             { return STRUCT; }
  "enum"               { return ENUM; }
  "union"              { return UNION; }
  "root_type"          { return ROOT_TYPE; }
  "rpc_service"        { return RPC_SERVICE; }
  "file_extension"     { return FILE_EXTENSION; }
  "file_identifier"    { return FILE_IDENTIFIER; }
  "bool"               { return BOOL; }
  "byte"               { return BYTE; }
  "ubyte"              { return UBYTE; }
  "short"              { return SHORT; }
  "ushort"             { return USHORT; }
  "int"                { return INT; }
  "uint"               { return UINT; }
  "float"              { return FLOAT; }
  "long"               { return LONG; }
  "ulong"              { return ULONG; }
  "double"             { return DOUBLE; }
  "int8"               { return INT8; }
  "uint8"              { return UINT8; }
  "int16"              { return INT16; }
  "uint16"             { return UINT16; }
  "int32"              { return INT32; }
  "uint32"             { return UINT32; }
  "int64"              { return INT64; }
  "uint64"             { return UINT64; }
  "float32"            { return FLOAT32; }
  "float64"            { return FLOAT64; }
  "string"             { return STRING; }
  ","                  { return COMMA; }
  ":"                  { return COLON; }
  "="                  { return EQUALS; }
  ";"                  { return SEMICOLON; }
  "."                  { return DOT; }
  "{"                  { return LCURLY; }
  "}"                  { return RCURLY; }
  "("                  { return LPAREN; }
  ")"                  { return RPAREN; }
  "["                  { return LBRACK; }
  "]"                  { return RBRACK; }
  "?"                  { return QUESTION_MARK; }

  "true"               { return TRUE; }
  "false"              { return FALSE; }
  {STRING_LITERAL}     { return STRING_LITERAL; }
  {DEC_INTEGER}        { return DEC_INTEGER; }
  {HEX_INTEGER}        { return HEX_INTEGER; }
  {DEC_FLOAT}          { return DEC_FLOAT; }
  {HEX_FLOAT}          { return HEX_FLOAT; }
  {SPECIAL_FLOAT}      { return SPECIAL_FLOAT; }
  {COMMENT}            { return COMMENT; }
  {IDENTIFIER}         { return IDENTIFIER; }

}

[^] { return BAD_CHARACTER; }
