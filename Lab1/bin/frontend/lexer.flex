/* You do not need to change anything up here. */
package lexer;

import frontend.Token;
import static frontend.Token.Type.*;

%%

%public
%final
%class Lexer
%function nextToken
%type Token
%unicode
%line
%column

%{
	private Token token(Token.Type type) {
		String text = yytext();
		
		if (type == STRING_LITERAL) {
			text = text.substring(1, text.length() - 1);
		}
	
		return new Token(type, yyline, yycolumn, text);
	}
%}

/* This definition may come in handy. If you wish, you can add more definitions here. */
WhiteSpace = [ ] | \t | \f | \n | \r
Digit = [0-9]
Alpha = [a-zA-Z]
StringLiteral = \" [^\"\n]* \"


%%

"boolean" { return token(BOOLEAN); }
"break" { return token(BREAK); }
"else" { return token(ELSE); }
"false" { return token(FALSE); }
"if" { return token(IF); }
"import" { return token(IMPORT); }
"int" { return token(INT); }
"module" { return token(MODULE); }
"public" { return token(PUBLIC); }
"return" { return token(RETURN); }
"true" { return token(TRUE); }
"type" { return token(TYPE); }
"void" { return token(VOID); }
"while" { return token(WHILE); }

"," { return token(COMMA); }
"[" { return token(LBRACKET); }
"{" { return token(LCURLY); }
"(" { return token(LPAREN); }
"]" { return token(RBRACKET); }
"}" { return token(RCURLY); }
")" { return token(RPAREN); }
";" { return token(SEMICOLON); }

"/" { return token(DIV); }
"==" { return token(EQEQ); }
"=" { return token(EQL); }
">=" { return token(GEQ); }
">" { return token(GT); }
"<=" { return token(LEQ); }
"<" { return token(LT); }
"-" { return token(MINUS); }
"!=" { return token(NEQ); }
"+" { return token(PLUS); }
"*" { return token(TIMES); }

/**
 * An identifier in PL/3007 is a sequence of one or more characters.
 * The first character must be a letter. Each subsequent character in the
 * sequence must be a letter, a digit or an underscore.
 */
{Alpha}({Alpha}|{Digit}|_)* { return token(ID); }

/**
 * Integer literals consist of a sequence of one or more decimal digits.
  * Note
 * that integer literals are unsigned: positive or negative sign are
 * considered to be unary operators. Also note that superfluous leading zeros
 * are allowed. */
{Digit}+ { return token(INT_LITERAL); }
{StringLiteral} { return token(STRING_LITERAL); }

{WhiteSpace} { }


/* You don't need to change anything below this line. */
.							{ throw new Error("unexpected character '" + yytext() + "'"); }
<<EOF>>						{ return token(EOF); }
