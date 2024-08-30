package com.navi.calculator.backend.parser_lexer;
import java_cup.runtime.*;
import static com.navi.calculator.backend.parser_lexer.sym.*;
import com.navi.calculator.backend.parser_lexer.errors.*;
%% //separador de area

%public
%class Lexer
%cup
%line
%column


LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

/* ___Operators___ */
Plus = [+]
Minus = [-]
Times = [*]
Division = [\/]
LParen = [\(]
RParen = [\)]

/* Numbers */
Digit = [0-9]+
Decimal = {Digit}\.{Digit}

%{
    private Symbol symbol(int type){
        return new Symbol(type, yyline+1,yycolumn+1);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }
    private void error(){
        ErrorsLP.addError(yytext(), yyline+1, yycolumn+1, "Error Léxico","Cadena no definida");
    }
%}

%%

{Plus}
{return symbol(PLUS, yytext());}
{Minus}
{return symbol(MINUS, yytext());}
{Times}
{return symbol(TIMES, yytext());}
{Division}
{return symbol(DIVISION, yytext());}
{LParen}
{return symbol(LPAREN, yytext());}
{RParen}
{return symbol(RPAREN, yytext());}

{Digit}
{
    double num = 0;
    try{
        num = Double.parseDouble(yytext());
    } catch (NumberFormatException e){}
    return symbol(DIGIT, num);}
{Decimal}
{
     double num = 0;
    try{
        num = Double.parseDouble(yytext());
    } catch (NumberFormatException e){}
    return symbol(DIGIT, num);}

{WhiteSpace} { /* ignore */ }

[\^´°¬|!$%&=?'¡¿\w]+
{ErrorsLP.addError(yytext(), yyline+1, yycolumn+1, "Error Léxico","Cadena no definida");}
[^]                 {error(); }


<<EOF>>             {return symbol(EOF); }