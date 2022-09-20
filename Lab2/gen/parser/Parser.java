package parser;

import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "parser.beaver".
 */
public class Parser extends beaver.Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short ID = 1;
		static public final short LBRACKET = 2;
		static public final short LPAREN = 3;
		static public final short MINUS = 4;
		static public final short STRING_LITERAL = 5;
		static public final short INT_LITERAL = 6;
		static public final short TRUE = 7;
		static public final short FALSE = 8;
		static public final short RCURLY = 9;
		static public final short RPAREN = 10;
		static public final short VOID = 11;
		static public final short BOOLEAN = 12;
		static public final short INT = 13;
		static public final short LCURLY = 14;
		static public final short SEMICOLON = 15;
		static public final short RBRACKET = 16;
		static public final short IF = 17;
		static public final short WHILE = 18;
		static public final short BREAK = 19;
		static public final short RETURN = 20;
		static public final short COMMA = 21;
		static public final short EQL = 22;
		static public final short IMPORT = 23;
		static public final short PUBLIC = 24;
		static public final short PLUS = 25;
		static public final short TIMES = 26;
		static public final short DIV = 27;
		static public final short MOD = 28;
		static public final short TYPE = 29;
		static public final short MODULE = 30;
		static public final short ELSE = 31;
		static public final short EQEQ = 32;
		static public final short NEQ = 33;
		static public final short LT = 34;
		static public final short LEQ = 35;
		static public final short GT = 36;
		static public final short GEQ = 37;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pLLlTtL4KK$jxR06PDJ49CI11K0gI02IcK5588118IILGaAaeHqGI38Bqen8A8WYZy0$x" +
		"aiL8KmGvsh80TH04H6ug8gDYuVczsThFxTbys2yTpTC$vvhPlxhixCs$k0yor68yYN88gZ4" +
		"8rQj68ePY98IZ4UPY5kKX62bBH7UUW1thYN9mT8RzRXFpUOVXPDdxxxFuHiNDjx0Mu4dKOZ" +
		"XgCnYHCbYzWOZ5kmir8ap$aGVJ51SX3GGZUoZOUN1tXeHbHJZmqu1eVRpMQ7FC9hlRn9g2B" +
		"8#ydpFRLTnJpVBpWrPcYLiV9Ns#hypgSPQsZ$8ZRCH1JSHaknnNo9wuAaI738NEEWt#GWx$" +
		"4mN#XW$yY1$#b3lw9OVAC3F2N1Qr9dAmBybK6p5eK50zdDuTbTFMiFPgu5mjvUZeX4Qim3T" +
		"UZ1TDn0sROAg#8k8RJjKS4F3yMjwWti3FkmHciD1Pkd8aOHCjwsac8r$Oot8PoESZJdK1j2" +
		"UxWUBu#owNojTOyeyeetw0N#Y0Tov69RFJ30EIZ64in6EKOXZ5enSKOIsqShiMDk1LpC9yx" +
		"SYTMu2xSZNjn7wpVQcR8O8OiPkZFjoMRvtG0xuiyPYlWMH$4VDPvA6Bk4fwEqlyO$zza6xm" +
		"LNRozEd7tkd2tedbpMdiLoziWcYkSmDEOoBuHp4lnunaTuaKHJZpBylAwyHvtue6doSjBOd" +
		"OddcLxUPRkvJcjZfFVddUaNaVB7yTxojDlekcFDFF$rn#yrkuWN#2i#93xqvuT5PRXrckVg" +
		"YF3kDF3UP$qOl$ipLkZRr3baTPmkdRWyylqoQbafIDOQPcwFMjeksb7SwR7hcAUSjf9l6iD" +
		"thfn70rzbclrJHghHqz6DpdM$9xKNFmQiknapezZdWfQLLn$argyYXYKyMf7abcfPSS9Vtp" +
		"hW3MjwiBaDmUmdjXCRBFyn47Y4F40O6HOF2y0SnnzwoZhYV7KznCMToNjQftpVkeD$lFiO7" +
		"mYCLdpDr5lqluPpCSwp6aqjbCsKkxLiLcCMRxfD8vgNxD76ZsqtM9xpXJ6TchEXyHkAbif3" +
		"n29Z9kQvswlNitfIipHDU#WtfsOgMDBYJHYjdxMhX3p#t7uY38$T7w3wsqkqjog3jGpJzTo" +
		"WlfyhP#ala3dEq9i235lAZ51wyiqDvFwGZ$E2c8kiPnOukTVhEKgehNDZp5#$sCZOr5#SsA" +
		"2Qy1nltY2L#VXtEEd7mkt1hQSxa3RYD7#D2sB$68fsjTWczF7ER#Hg#jDfSxtnYprd2abr#" +
		"fOKlWwZQ4skzfcZstJpSeG$$EmvaqAdH$xmjKGAVYibj1#i$ZKyfcTGzIz1ledVyin9JdAx" +
		"t92VeFj9x#gyO3ibttokNmcU#LJvTcZnjq#tiV49pwBRvzmn#G3udtP9Jjb2xKTyYR7DuYN" +
		"Y1U8f#KfsIARvKdP94$8ushkHdbNoRVb7INVaXVbENbMdf7dTVR7v65vI1wHHvMrWTWcMsM" +
		"xl2wloQloYhnCptigzfqQ3riPvLiv8Z$8zyhp5V6bqWx9BxwgZylFN96JIl#BGoE$rZgpjv" +
		"W4s5zSx2mc0NONmuTHx1JLx54rv9RHBcCydzAB0ZyCP0ulh5uqcjmwwdNKgvYxL07yfZGSC" +
		"PZy8KGXEs8X#qqHKSnv9GekVe6Q$Cum579fPr1Qo6ID5gmli3pwQob38OUn7DKnFSYcRNNw" +
		"2Z#ayndfb5cESB57H$5hpY30RpaNOR1hkzYt3ONwVm1Kw6Jw");

	static final Action RETURN6 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 6];
		}
	};

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	static final Action RETURN9 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 9];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

	static final Action RETURN7 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 7];
		}
	};

	static final Action RETURN5 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 5];
		}
	};

	// turn off automated error recovery
	@Override
	protected void recoverFromError(Symbol token, TokenStream in) throws java.io.IOException, Exception {
		super.recoverFromError(new Symbol(0), in);
	}

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			RETURN6,	// [0] Module = MODULE ID LCURLY Imports Declarations RCURLY; returns 'RCURLY' although none is marked
			RETURN2,	// [1] Imports = Import Imports; returns 'Imports' although none is marked
			Action.NONE,  	// [2] Imports = 
			RETURN3,	// [3] Import = IMPORT ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [4] Declarations = Declaration Declarations; returns 'Declarations' although none is marked
			Action.NONE,  	// [5] Declarations = 
			Action.RETURN,	// [6] Declaration = FunctionDeclaration
			Action.RETURN,	// [7] Declaration = FieldDeclaration
			Action.RETURN,	// [8] Declaration = TypeDeclaration
			RETURN9,	// [9] FunctionDeclaration = Accessibility TypeName ID LPAREN Parameters RPAREN LCURLY Statements RCURLY; returns 'RCURLY' although none is marked
			RETURN4,	// [10] FieldDeclaration = Accessibility TypeName ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN6,	// [11] TypeDeclaration = Accessibility TYPE ID EQL STRING_LITERAL SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [12] Accessibility = PUBLIC
			Action.NONE,  	// [13] Accessibility = 
			Action.RETURN,	// [14] TypeName = PrimitiveType
			Action.RETURN,	// [15] TypeName = ArrayType
			Action.RETURN,	// [16] TypeName = ID
			Action.RETURN,	// [17] PrimitiveType = VOID
			Action.RETURN,	// [18] PrimitiveType = BOOLEAN
			Action.RETURN,	// [19] PrimitiveType = INT
			RETURN3,	// [20] ArrayType = ArrayType LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3,	// [21] ArrayType = PrimitiveType LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3,	// [22] ArrayType = ID LBRACKET RBRACKET; returns 'RBRACKET' although none is marked
			Action.RETURN,	// [23] Parameters = NonEmptyPList
			Action.NONE,  	// [24] Parameters = 
			new Action() {	// [25] NonEmptyPList = NonEmptyPList COMMA Parameter
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [26] NonEmptyPList = Parameter
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN2,	// [27] Parameter = TypeName ID; returns 'ID' although none is marked
			RETURN2,	// [28] Statements = Statement Statements; returns 'Statements' although none is marked
			Action.NONE,  	// [29] Statements = 
			Action.RETURN,	// [30] Statement = LocalVarDeclaration
			Action.RETURN,	// [31] Statement = BlockStatement
			Action.RETURN,	// [32] Statement = IfStatement
			Action.RETURN,	// [33] Statement = WhileStatement
			Action.RETURN,	// [34] Statement = BreakStatement
			Action.RETURN,	// [35] Statement = ReturnStatement
			Action.RETURN,	// [36] Statement = ExpressionStatement
			RETURN3,	// [37] LocalVarDeclaration = TypeName ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [38] BlockStatement = LCURLY Statements RCURLY; returns 'RCURLY' although none is marked
			RETURN7,	// [39] IfStatement = IF LPAREN Expression RPAREN Statement ELSE Statement; returns 'Statement' although none is marked
			RETURN5,	// [40] IfStatement = IF LPAREN Expression RPAREN Statement; returns 'Statement' although none is marked
			RETURN5,	// [41] WhileStatement = WHILE LPAREN Expression RPAREN Statement; returns 'Statement' although none is marked
			RETURN2,	// [42] BreakStatement = BREAK SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [43] ReturnStatement = RETURN SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [44] ReturnStatement = RETURN Expression SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [45] ExpressionStatement = Expression SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [46] Expression = Assignment
			Action.RETURN,	// [47] Expression = RHSExpression
			RETURN3,	// [48] Assignment = LHSExpression EQL Expression; returns 'Expression' although none is marked
			Action.RETURN,	// [49] LHSExpression = ID
			Action.RETURN,	// [50] LHSExpression = ArrayAccess
			RETURN4,	// [51] ArrayAccess = ID LBRACKET Expression RBRACKET; returns 'RBRACKET' although none is marked
			RETURN4,	// [52] ArrayAccess = ArrayAccess LBRACKET Expression RBRACKET; returns 'RBRACKET' although none is marked
			Action.RETURN,	// [53] RHSExpression = ArithmeticExpression
			RETURN3,	// [54] RHSExpression = ArithmeticExpression ComparisonOperator ArithmeticExpression; returns 'ArithmeticExpression' although none is marked
			Action.RETURN,	// [55] ComparisonOperator = EQEQ
			Action.RETURN,	// [56] ComparisonOperator = NEQ
			Action.RETURN,	// [57] ComparisonOperator = LT
			Action.RETURN,	// [58] ComparisonOperator = LEQ
			Action.RETURN,	// [59] ComparisonOperator = GT
			Action.RETURN,	// [60] ComparisonOperator = GEQ
			new Action() {	// [61] ArithmeticExpression = ArithmeticExpression AdditiveOperator Term
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [62] ArithmeticExpression = Term
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [63] AdditiveOperator = PLUS
			Action.RETURN,	// [64] AdditiveOperator = MINUS
			new Action() {	// [65] Term = Term MultiplicativeOperator Factor
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [66] Term = Factor
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [67] MultiplicativeOperator = TIMES
			Action.RETURN,	// [68] MultiplicativeOperator = DIV
			Action.RETURN,	// [69] MultiplicativeOperator = MOD
			RETURN2,	// [70] Factor = MINUS Factor; returns 'Factor' although none is marked
			Action.RETURN,	// [71] Factor = PrimaryExpression
			Action.RETURN,	// [72] PrimaryExpression = LHSExpression
			Action.RETURN,	// [73] PrimaryExpression = FunctionCall
			Action.RETURN,	// [74] PrimaryExpression = ArrayExpression
			Action.RETURN,	// [75] PrimaryExpression = STRING_LITERAL
			Action.RETURN,	// [76] PrimaryExpression = INT_LITERAL
			Action.RETURN,	// [77] PrimaryExpression = BooleanLiteral
			RETURN3,	// [78] PrimaryExpression = LPAREN Expression RPAREN; returns 'RPAREN' although none is marked
			RETURN4,	// [79] FunctionCall = ID LPAREN Expressions RPAREN; returns 'RPAREN' although none is marked
			Action.RETURN,	// [80] Expressions = NonEmptyEList
			Action.NONE,  	// [81] Expressions = 
			new Action() {	// [82] NonEmptyEList = NonEmptyEList COMMA Expression
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [83] NonEmptyEList = Expression
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			RETURN3,	// [84] ArrayExpression = LBRACKET NonEmptyEList RBRACKET; returns 'RBRACKET' although none is marked
			Action.RETURN,	// [85] BooleanLiteral = TRUE
			Action.RETURN	// [86] BooleanLiteral = FALSE
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
