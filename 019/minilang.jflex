import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;

%%
%public
%class MParser
%cup
%implements sym
%char
%line
%column

%{
  StringBuffer string = new StringBuffer();
  public MParser(java.io.Reader in, ComplexSymbolFactory sf){
    this(in);
    symbolFactory = sf;
  }
  ComplexSymbolFactory symbolFactory;
  /* Konstruktoren */
  private Symbol symbol(String name, int sym) {
      return symbolFactory.newSymbol(name, sym, new Location(yyline+1,yycolumn+1,(int) yychar), new Location(yyline+1,yycolumn+yylength(),(int)yychar+yylength()));
  }
  private Symbol symbol(String name, int sym, Object val) {
      Location left = new Location(yyline+1,yycolumn+1, (int) yychar);
      Location right= new Location(yyline+1,yycolumn+yylength(),(int) yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  } 
  private Symbol symbol(String name, int sym, Object val,int buflength) {
      Location left = new Location(yyline+1,yycolumn+yylength()-buflength,(int)yychar+yylength()-buflength);
      Location right= new Location(yyline+1,yycolumn+yylength(),(int) yychar+yylength());
      return symbolFactory.newSymbol(name, sym, left, right,val);
  }
  /* Hardcoded Error Methode */ 
  private void error(String message) {
    System.out.println(message);
  }
%} 

%eofval{
     return symbolFactory.newSymbol("EOF", EOF, new Location(yyline+1,yycolumn+1,(int)yychar), new Location(yyline+1,yycolumn+1,(int)yychar+1));
%eofval}

Identifiers = [a-zA-Z$_] [a-zA-Z0-9$_]*
IntLiteral = 0 | [1-9][0-9]*
BoolLiteral = true | false
LineTerminator = \r|\n|\r\n;
WhiteSpace = {LineTerminator} | [ \t\f]

%state STRING

%%
<YYINITIAL>{
/* Schluesselwoerter */
"int"             { return symbol("int",TYPE, "INT" ); }
"String"          { return symbol("String",TYPE, "STRING" ); }
"void"            { return symbol("void",TYPE,"VOID"); }
"if"              { return symbol("if",IF); }
"else"            { return symbol("else",ELSE); }
"while"           { return symbol("while",WHILE); }
"read"            { return symbol("read",READ); }
"write"           { return symbol("write",WRITE); }
"System"          { return symbol("System",SYSTEM); }
"out"             { return symbol("out",OUT); }
"println"         { return symbol("println",PRINTLN); }
"public"          { return symbol("public",PUBLIC); }
"static"          { return symbol("static",STATIC); }
"main"            { return symbol("main",MAIN); }
"class"           { return symbol("class",CLASS); }
"args"            { return symbol("args",ARGS); }

/* Identifiers */
{Identifiers}     { return symbol("Identifier",IDENT, yytext()); }

/* Literalen */
{BoolLiteral} { return symbol("Boolconst",BOOLCONST, new Boolean(Boolean.parseBool(yytext()))); }
{IntLiteral} { return symbol("Intconst",INTCONST, Integer.parseInt(yytext())); }

/* Separatoren */
  \"              { string.setLength(0); yybegin(STRING); }
";"               { return symbol("semicolon",SEMICOLON); }
","               { return symbol("comma",COMMA); }
"."               { return symbol("dot",DOT); }
"("               { return symbol("(",LPAR); }
")"               { return symbol(")",RPAR); }
"["               { return symbol("[",LBRACKET); }
"]"               { return symbol("]",RBRACKET); }
"{"               { return symbol("{",BEGIN); }
"}"               { return symbol("}",END); }
"="               { return symbol("=",ASSIGN); }
"+"               { return symbol("+",BINOP,"ADD"  ); }
"-"               { return symbol("-",BINOP, "SUB"  ); }
"*"               { return symbol("*",BINOP, "MUL"  ); }
"/"               { return symbol("/",BINOP, "DIV"  ); }
"%"               { return symbol("%",BINOP, "MOD"  ); }
"<="              { return symbol("<=",COMP,  "LEQ"  ); }
">="              { return symbol(">=",COMP, "GEQ"  ); }
"=="              { return symbol("==",COMP, "EQ"   ); }
"!="              { return symbol("!=",COMP, "NEQ"  ); }
"<"               { return symbol("<",COMP,  "LESS" ); }
">"               { return symbol(">",COMP,  "GT"   ); }
"&&"              { return symbol("&&",BBINOP,"AND" ); }
"||"              { return symbol("||",BBINOP,"OR"  ); }
"!"               { return symbol("!",BUNOP,  "NOT" ); }

{WhiteSpace}     { /* Ignore */ }

}
<STRING> {
  \"                             { yybegin(YYINITIAL); 
      return symbol("StringConst",STRINGCONST,string.toString(),string.length()); }
  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

/* Error fallback */
[^]              {error("Lexical error in line "+(yyline+1)+", invalid symbol "+yytext());}