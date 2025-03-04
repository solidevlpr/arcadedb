/* Generated By:JJTree&JavaCC: Do not edit this line. SqlParserConstants.java */
package com.arcadedb.query.sql.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface SqlParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int FORMAL_COMMENT = 8;
  /** RegularExpression Id. */
  int MULTI_LINE_COMMENT = 9;
  /** RegularExpression Id. */
  int SINGLE_LINE_COMMENT = 11;
  /** RegularExpression Id. */
  int ALIGN = 12;
  /** RegularExpression Id. */
  int SELECT = 13;
  /** RegularExpression Id. */
  int TRAVERSE = 14;
  /** RegularExpression Id. */
  int MATCH = 15;
  /** RegularExpression Id. */
  int INSERT = 16;
  /** RegularExpression Id. */
  int CREATE = 17;
  /** RegularExpression Id. */
  int CUSTOM = 18;
  /** RegularExpression Id. */
  int DELETE = 19;
  /** RegularExpression Id. */
  int DOCUMENT = 20;
  /** RegularExpression Id. */
  int VERTEX = 21;
  /** RegularExpression Id. */
  int EDGE = 22;
  /** RegularExpression Id. */
  int UPDATE = 23;
  /** RegularExpression Id. */
  int UPSERT = 24;
  /** RegularExpression Id. */
  int FROM = 25;
  /** RegularExpression Id. */
  int TO = 26;
  /** RegularExpression Id. */
  int WHERE = 27;
  /** RegularExpression Id. */
  int WHILE = 28;
  /** RegularExpression Id. */
  int INTO = 29;
  /** RegularExpression Id. */
  int VALUE = 30;
  /** RegularExpression Id. */
  int VALUES = 31;
  /** RegularExpression Id. */
  int SET = 32;
  /** RegularExpression Id. */
  int ADD = 33;
  /** RegularExpression Id. */
  int PUT = 34;
  /** RegularExpression Id. */
  int MERGE = 35;
  /** RegularExpression Id. */
  int CONTENT = 36;
  /** RegularExpression Id. */
  int REMOVE = 37;
  /** RegularExpression Id. */
  int INCREMENT = 38;
  /** RegularExpression Id. */
  int AND = 39;
  /** RegularExpression Id. */
  int OR = 40;
  /** RegularExpression Id. */
  int NULL = 41;
  /** RegularExpression Id. */
  int DEFINE = 42;
  /** RegularExpression Id. */
  int DEFINED = 43;
  /** RegularExpression Id. */
  int ORDER_BY = 44;
  /** RegularExpression Id. */
  int GROUP_BY = 45;
  /** RegularExpression Id. */
  int BY = 46;
  /** RegularExpression Id. */
  int LIMIT = 47;
  /** RegularExpression Id. */
  int SKIP2 = 48;
  /** RegularExpression Id. */
  int ERROR2 = 49;
  /** RegularExpression Id. */
  int OFFSET = 50;
  /** RegularExpression Id. */
  int TIMEOUT = 51;
  /** RegularExpression Id. */
  int ASC = 52;
  /** RegularExpression Id. */
  int AS = 53;
  /** RegularExpression Id. */
  int DESC = 54;
  /** RegularExpression Id. */
  int RETURN = 55;
  /** RegularExpression Id. */
  int BEFORE = 56;
  /** RegularExpression Id. */
  int AFTER = 57;
  /** RegularExpression Id. */
  int RECORD = 58;
  /** RegularExpression Id. */
  int WAIT = 59;
  /** RegularExpression Id. */
  int RETRY = 60;
  /** RegularExpression Id. */
  int LET = 61;
  /** RegularExpression Id. */
  int CHECK = 62;
  /** RegularExpression Id. */
  int UNSAFE = 63;
  /** RegularExpression Id. */
  int STRATEGY = 64;
  /** RegularExpression Id. */
  int DEPTH_FIRST = 65;
  /** RegularExpression Id. */
  int BREADTH_FIRST = 66;
  /** RegularExpression Id. */
  int NEAR = 67;
  /** RegularExpression Id. */
  int WITH = 68;
  /** RegularExpression Id. */
  int WITHIN = 69;
  /** RegularExpression Id. */
  int UNWIND = 70;
  /** RegularExpression Id. */
  int MAXDEPTH = 71;
  /** RegularExpression Id. */
  int MINDEPTH = 72;
  /** RegularExpression Id. */
  int TYPE = 73;
  /** RegularExpression Id. */
  int SUPERTYPE = 74;
  /** RegularExpression Id. */
  int TYPES = 75;
  /** RegularExpression Id. */
  int EXCEPTION = 76;
  /** RegularExpression Id. */
  int PROFILE = 77;
  /** RegularExpression Id. */
  int ON = 78;
  /** RegularExpression Id. */
  int OFF = 79;
  /** RegularExpression Id. */
  int TRUNCATE = 80;
  /** RegularExpression Id. */
  int POLYMORPHIC = 81;
  /** RegularExpression Id. */
  int FIND = 82;
  /** RegularExpression Id. */
  int EXTENDS = 83;
  /** RegularExpression Id. */
  int BACKUP = 84;
  /** RegularExpression Id. */
  int BUCKETS = 85;
  /** RegularExpression Id. */
  int BUCKETSELECTIONSTRATEGY = 86;
  /** RegularExpression Id. */
  int ALTER = 87;
  /** RegularExpression Id. */
  int NAME = 88;
  /** RegularExpression Id. */
  int ADDBUCKET = 89;
  /** RegularExpression Id. */
  int REMOVEBUCKET = 90;
  /** RegularExpression Id. */
  int DROP = 91;
  /** RegularExpression Id. */
  int PROPERTY = 92;
  /** RegularExpression Id. */
  int FORCE = 93;
  /** RegularExpression Id. */
  int SCHEMA = 94;
  /** RegularExpression Id. */
  int INDEX = 95;
  /** RegularExpression Id. */
  int NULL_STRATEGY = 96;
  /** RegularExpression Id. */
  int ENGINE = 97;
  /** RegularExpression Id. */
  int REBUILD = 98;
  /** RegularExpression Id. */
  int FORMAT = 99;
  /** RegularExpression Id. */
  int OVERWRITE = 100;
  /** RegularExpression Id. */
  int EXPORT = 101;
  /** RegularExpression Id. */
  int IMPORT = 102;
  /** RegularExpression Id. */
  int DATABASE = 103;
  /** RegularExpression Id. */
  int OPTIMIZE = 104;
  /** RegularExpression Id. */
  int LINK = 105;
  /** RegularExpression Id. */
  int INVERSE = 106;
  /** RegularExpression Id. */
  int EXPLAIN = 107;
  /** RegularExpression Id. */
  int GRANT = 108;
  /** RegularExpression Id. */
  int REVOKE = 109;
  /** RegularExpression Id. */
  int READ = 110;
  /** RegularExpression Id. */
  int EXECUTE = 111;
  /** RegularExpression Id. */
  int ALL = 112;
  /** RegularExpression Id. */
  int NONE = 113;
  /** RegularExpression Id. */
  int FUNCTION = 114;
  /** RegularExpression Id. */
  int PARAMETERS = 115;
  /** RegularExpression Id. */
  int LANGUAGE = 116;
  /** RegularExpression Id. */
  int BEGIN = 117;
  /** RegularExpression Id. */
  int COMMIT = 118;
  /** RegularExpression Id. */
  int ROLLBACK = 119;
  /** RegularExpression Id. */
  int IF = 120;
  /** RegularExpression Id. */
  int ELSE = 121;
  /** RegularExpression Id. */
  int CONTINUE = 122;
  /** RegularExpression Id. */
  int FAIL = 123;
  /** RegularExpression Id. */
  int FIX = 124;
  /** RegularExpression Id. */
  int ISOLATION = 125;
  /** RegularExpression Id. */
  int SLEEP = 126;
  /** RegularExpression Id. */
  int CONSOLE = 127;
  /** RegularExpression Id. */
  int START = 128;
  /** RegularExpression Id. */
  int OPTIONAL = 129;
  /** RegularExpression Id. */
  int COUNT = 130;
  /** RegularExpression Id. */
  int DISTINCT = 131;
  /** RegularExpression Id. */
  int EXISTS = 132;
  /** RegularExpression Id. */
  int FOREACH = 133;
  /** RegularExpression Id. */
  int MOVE = 134;
  /** RegularExpression Id. */
  int DEPTH_ALIAS = 135;
  /** RegularExpression Id. */
  int PATH_ALIAS = 136;
  /** RegularExpression Id. */
  int IDENTIFIED = 137;
  /** RegularExpression Id. */
  int RID = 138;
  /** RegularExpression Id. */
  int SYSTEM = 139;
  /** RegularExpression Id. */
  int THIS = 140;
  /** RegularExpression Id. */
  int RECORD_ATTRIBUTE = 141;
  /** RegularExpression Id. */
  int RID_ATTR = 142;
  /** RegularExpression Id. */
  int RID_STRING = 143;
  /** RegularExpression Id. */
  int OUT_ATTR = 144;
  /** RegularExpression Id. */
  int IN_ATTR = 145;
  /** RegularExpression Id. */
  int TYPE_ATTR = 146;
  /** RegularExpression Id. */
  int RID_ID_ATTR = 147;
  /** RegularExpression Id. */
  int RID_POS_ATTR = 148;
  /** RegularExpression Id. */
  int FIELDS_ATTR = 149;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 150;
  /** RegularExpression Id. */
  int DECIMAL_LITERAL = 151;
  /** RegularExpression Id. */
  int HEX_LITERAL = 152;
  /** RegularExpression Id. */
  int OCTAL_LITERAL = 153;
  /** RegularExpression Id. */
  int FLOATING_POINT_LITERAL = 154;
  /** RegularExpression Id. */
  int DECIMAL_FLOATING_POINT_LITERAL = 155;
  /** RegularExpression Id. */
  int DECIMAL_EXPONENT = 156;
  /** RegularExpression Id. */
  int HEXADECIMAL_FLOATING_POINT_LITERAL = 157;
  /** RegularExpression Id. */
  int HEXADECIMAL_EXPONENT = 158;
  /** RegularExpression Id. */
  int CHARACTER_LITERAL = 159;
  /** RegularExpression Id. */
  int STRING_LITERAL = 160;
  /** RegularExpression Id. */
  int INTEGER_RANGE = 161;
  /** RegularExpression Id. */
  int ELLIPSIS_INTEGER_RANGE = 162;
  /** RegularExpression Id. */
  int TRUE = 163;
  /** RegularExpression Id. */
  int FALSE = 164;
  /** RegularExpression Id. */
  int LPAREN = 165;
  /** RegularExpression Id. */
  int RPAREN = 166;
  /** RegularExpression Id. */
  int LBRACE = 167;
  /** RegularExpression Id. */
  int RBRACE = 168;
  /** RegularExpression Id. */
  int LBRACKET = 169;
  /** RegularExpression Id. */
  int RBRACKET = 170;
  /** RegularExpression Id. */
  int SEMICOLON = 171;
  /** RegularExpression Id. */
  int COMMA = 172;
  /** RegularExpression Id. */
  int DOT = 173;
  /** RegularExpression Id. */
  int AT = 174;
  /** RegularExpression Id. */
  int DOLLAR = 175;
  /** RegularExpression Id. */
  int BACKTICK = 176;
  /** RegularExpression Id. */
  int EQ = 177;
  /** RegularExpression Id. */
  int EQEQ = 178;
  /** RegularExpression Id. */
  int NSEQ = 179;
  /** RegularExpression Id. */
  int LT = 180;
  /** RegularExpression Id. */
  int GT = 181;
  /** RegularExpression Id. */
  int BANG = 182;
  /** RegularExpression Id. */
  int TILDE = 183;
  /** RegularExpression Id. */
  int HOOK = 184;
  /** RegularExpression Id. */
  int COLON = 185;
  /** RegularExpression Id. */
  int LE = 186;
  /** RegularExpression Id. */
  int GE = 187;
  /** RegularExpression Id. */
  int NE = 188;
  /** RegularExpression Id. */
  int NEQ = 189;
  /** RegularExpression Id. */
  int SC_OR = 190;
  /** RegularExpression Id. */
  int SC_AND = 191;
  /** RegularExpression Id. */
  int INCR = 192;
  /** RegularExpression Id. */
  int DECR = 193;
  /** RegularExpression Id. */
  int PLUS = 194;
  /** RegularExpression Id. */
  int MINUS = 195;
  /** RegularExpression Id. */
  int STAR = 196;
  /** RegularExpression Id. */
  int SLASH = 197;
  /** RegularExpression Id. */
  int BIT_AND = 198;
  /** RegularExpression Id. */
  int NULL_COALESCING = 199;
  /** RegularExpression Id. */
  int BIT_OR = 200;
  /** RegularExpression Id. */
  int XOR = 201;
  /** RegularExpression Id. */
  int REM = 202;
  /** RegularExpression Id. */
  int LSHIFT = 203;
  /** RegularExpression Id. */
  int PLUSASSIGN = 204;
  /** RegularExpression Id. */
  int MINUSASSIGN = 205;
  /** RegularExpression Id. */
  int STARASSIGN = 206;
  /** RegularExpression Id. */
  int SLASHASSIGN = 207;
  /** RegularExpression Id. */
  int ANDASSIGN = 208;
  /** RegularExpression Id. */
  int ORASSIGN = 209;
  /** RegularExpression Id. */
  int XORASSIGN = 210;
  /** RegularExpression Id. */
  int REMASSIGN = 211;
  /** RegularExpression Id. */
  int LSHIFTASSIGN = 212;
  /** RegularExpression Id. */
  int RSIGNEDSHIFTASSIGN = 213;
  /** RegularExpression Id. */
  int RUNSIGNEDSHIFTASSIGN = 214;
  /** RegularExpression Id. */
  int RSHIFT = 215;
  /** RegularExpression Id. */
  int RUNSIGNEDSHIFT = 216;
  /** RegularExpression Id. */
  int ELLIPSIS = 217;
  /** RegularExpression Id. */
  int RANGE = 218;
  /** RegularExpression Id. */
  int NOT = 219;
  /** RegularExpression Id. */
  int IN = 220;
  /** RegularExpression Id. */
  int LIKE = 221;
  /** RegularExpression Id. */
  int ILIKE = 222;
  /** RegularExpression Id. */
  int IS = 223;
  /** RegularExpression Id. */
  int BETWEEN = 224;
  /** RegularExpression Id. */
  int CONTAINS = 225;
  /** RegularExpression Id. */
  int CONTAINSALL = 226;
  /** RegularExpression Id. */
  int CONTAINSANY = 227;
  /** RegularExpression Id. */
  int CONTAINSKEY = 228;
  /** RegularExpression Id. */
  int CONTAINSVALUE = 229;
  /** RegularExpression Id. */
  int CONTAINSTEXT = 230;
  /** RegularExpression Id. */
  int MATCHES = 231;
  /** RegularExpression Id. */
  int KEY = 232;
  /** RegularExpression Id. */
  int INSTANCEOF = 233;
  /** RegularExpression Id. */
  int BUCKET = 234;
  /** RegularExpression Id. */
  int IDENTIFIER = 235;
  /** RegularExpression Id. */
  int QUOTED_IDENTIFIER = 236;
  /** RegularExpression Id. */
  int INDEX_COLON = 237;
  /** RegularExpression Id. */
  int INDEXVALUES_IDENTIFIER = 238;
  /** RegularExpression Id. */
  int INDEXVALUESASC_IDENTIFIER = 239;
  /** RegularExpression Id. */
  int INDEXVALUESDESC_IDENTIFIER = 240;
  /** RegularExpression Id. */
  int BUCKET_IDENTIFIER = 241;
  /** RegularExpression Id. */
  int BUCKET_NUMBER_IDENTIFIER = 242;
  /** RegularExpression Id. */
  int HTTP_URL = 243;
  /** RegularExpression Id. */
  int HTTPS_URL = 244;
  /** RegularExpression Id. */
  int FILE_URL = 245;
  /** RegularExpression Id. */
  int CLASSPATH_URL = 246;
  /** RegularExpression Id. */
  int SCHEMA_IDENTIFIER = 247;
  /** RegularExpression Id. */
  int LETTER = 248;
  /** RegularExpression Id. */
  int PART_LETTER = 249;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_FORMAL_COMMENT = 1;
  /** Lexical state. */
  int IN_MULTI_LINE_COMMENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "<token of kind 6>",
    "\"/*\"",
    "\"*/\"",
    "\"*/\"",
    "<token of kind 10>",
    "<SINGLE_LINE_COMMENT>",
    "<ALIGN>",
    "<SELECT>",
    "<TRAVERSE>",
    "<MATCH>",
    "<INSERT>",
    "<CREATE>",
    "<CUSTOM>",
    "<DELETE>",
    "<DOCUMENT>",
    "<VERTEX>",
    "<EDGE>",
    "<UPDATE>",
    "<UPSERT>",
    "<FROM>",
    "<TO>",
    "<WHERE>",
    "<WHILE>",
    "<INTO>",
    "<VALUE>",
    "<VALUES>",
    "<SET>",
    "<ADD>",
    "<PUT>",
    "<MERGE>",
    "<CONTENT>",
    "<REMOVE>",
    "<INCREMENT>",
    "<AND>",
    "<OR>",
    "<NULL>",
    "<DEFINE>",
    "<DEFINED>",
    "<ORDER_BY>",
    "<GROUP_BY>",
    "<BY>",
    "<LIMIT>",
    "<SKIP2>",
    "<ERROR2>",
    "<OFFSET>",
    "<TIMEOUT>",
    "<ASC>",
    "<AS>",
    "<DESC>",
    "<RETURN>",
    "<BEFORE>",
    "<AFTER>",
    "<RECORD>",
    "<WAIT>",
    "<RETRY>",
    "<LET>",
    "<CHECK>",
    "<UNSAFE>",
    "<STRATEGY>",
    "<DEPTH_FIRST>",
    "<BREADTH_FIRST>",
    "<NEAR>",
    "<WITH>",
    "<WITHIN>",
    "<UNWIND>",
    "<MAXDEPTH>",
    "<MINDEPTH>",
    "<TYPE>",
    "<SUPERTYPE>",
    "<TYPES>",
    "<EXCEPTION>",
    "<PROFILE>",
    "<ON>",
    "<OFF>",
    "<TRUNCATE>",
    "<POLYMORPHIC>",
    "<FIND>",
    "<EXTENDS>",
    "<BACKUP>",
    "<BUCKETS>",
    "<BUCKETSELECTIONSTRATEGY>",
    "<ALTER>",
    "<NAME>",
    "<ADDBUCKET>",
    "<REMOVEBUCKET>",
    "<DROP>",
    "<PROPERTY>",
    "<FORCE>",
    "<SCHEMA>",
    "<INDEX>",
    "<NULL_STRATEGY>",
    "<ENGINE>",
    "<REBUILD>",
    "<FORMAT>",
    "<OVERWRITE>",
    "<EXPORT>",
    "<IMPORT>",
    "<DATABASE>",
    "<OPTIMIZE>",
    "<LINK>",
    "<INVERSE>",
    "<EXPLAIN>",
    "<GRANT>",
    "<REVOKE>",
    "<READ>",
    "<EXECUTE>",
    "<ALL>",
    "<NONE>",
    "<FUNCTION>",
    "<PARAMETERS>",
    "<LANGUAGE>",
    "<BEGIN>",
    "<COMMIT>",
    "<ROLLBACK>",
    "<IF>",
    "<ELSE>",
    "<CONTINUE>",
    "<FAIL>",
    "<FIX>",
    "<ISOLATION>",
    "<SLEEP>",
    "<CONSOLE>",
    "<START>",
    "<OPTIONAL>",
    "<COUNT>",
    "<DISTINCT>",
    "<EXISTS>",
    "<FOREACH>",
    "<MOVE>",
    "<DEPTH_ALIAS>",
    "<PATH_ALIAS>",
    "<IDENTIFIED>",
    "<RID>",
    "<SYSTEM>",
    "<THIS>",
    "<RECORD_ATTRIBUTE>",
    "<RID_ATTR>",
    "<RID_STRING>",
    "<OUT_ATTR>",
    "<IN_ATTR>",
    "<TYPE_ATTR>",
    "<RID_ID_ATTR>",
    "<RID_POS_ATTR>",
    "<FIELDS_ATTR>",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<DECIMAL_FLOATING_POINT_LITERAL>",
    "<DECIMAL_EXPONENT>",
    "<HEXADECIMAL_FLOATING_POINT_LITERAL>",
    "<HEXADECIMAL_EXPONENT>",
    "<CHARACTER_LITERAL>",
    "<STRING_LITERAL>",
    "<INTEGER_RANGE>",
    "<ELLIPSIS_INTEGER_RANGE>",
    "<TRUE>",
    "<FALSE>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\",\"",
    "\".\"",
    "\"@\"",
    "\"$\"",
    "\"`\"",
    "\"=\"",
    "\"==\"",
    "\"<=>\"",
    "\"<\"",
    "\">\"",
    "\"!\"",
    "\"~\"",
    "\"?\"",
    "\":\"",
    "\"<=\"",
    "\">=\"",
    "\"!=\"",
    "\"<>\"",
    "\"||\"",
    "\"&&\"",
    "\"++\"",
    "\"--\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"&\"",
    "\"??\"",
    "\"|\"",
    "\"^\"",
    "\"%\"",
    "\"<<\"",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "\"&=\"",
    "\"|=\"",
    "\"^=\"",
    "\"%=\"",
    "\"<<=\"",
    "\">>=\"",
    "\">>>=\"",
    "\">>\"",
    "\">>>\"",
    "\"...\"",
    "\"..\"",
    "<NOT>",
    "<IN>",
    "<LIKE>",
    "<ILIKE>",
    "<IS>",
    "<BETWEEN>",
    "<CONTAINS>",
    "<CONTAINSALL>",
    "<CONTAINSANY>",
    "<CONTAINSKEY>",
    "<CONTAINSVALUE>",
    "<CONTAINSTEXT>",
    "<MATCHES>",
    "<KEY>",
    "<INSTANCEOF>",
    "<BUCKET>",
    "<IDENTIFIER>",
    "<QUOTED_IDENTIFIER>",
    "<INDEX_COLON>",
    "<INDEXVALUES_IDENTIFIER>",
    "<INDEXVALUESASC_IDENTIFIER>",
    "<INDEXVALUESDESC_IDENTIFIER>",
    "<BUCKET_IDENTIFIER>",
    "<BUCKET_NUMBER_IDENTIFIER>",
    "<HTTP_URL>",
    "<HTTPS_URL>",
    "<FILE_URL>",
    "<CLASSPATH_URL>",
    "<SCHEMA_IDENTIFIER>",
    "<LETTER>",
    "<PART_LETTER>",
    "\"#\"",
  };

}
