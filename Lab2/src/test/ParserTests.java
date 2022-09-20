package test;

import static org.junit.Assert.fail;

import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import parser.Parser;

public class ParserTests {
	private void runtest(String src) {
		runtest(src, true);
	}

	private void runtest(String src, boolean succeed) {
    System.out.println(src);
		Parser parser = new Parser();
		try {
			parser.parse(new Lexer(new StringReader(src)));
			if(!succeed) {
				fail("Test was supposed to fail, but succeeded");
			}
		} catch (beaver.Parser.Exception e) {
			if(succeed) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
  
	@Test
	public void testEmptyModule() {
		runtest("module Test { }");
	}

  private void blocktest(String block) {
    StringBuffer sb = new StringBuffer();
    
    sb.append("module Test { ")
      .append(block)
      .append(" } ");

    runtest(sb.toString());
  }

  private void stmttest(String stmt) {
    StringBuffer sb = new StringBuffer();
    
    sb.append("public void foo () { ")
      .append(stmt)
      .append(" } ");

    blocktest(sb.toString());
  }

  @Test
  public void importSingle() {
    blocktest("import mod_a;");
  }

  @Test
  public void importMultiple() {
    runtest("module Test { import mod_a; import mod_b; }");
  }

  @Test
  public void declarations() {
    runtest("module Test {  }");
  }
  
  @Test
  public void decFunction() {
    blocktest("void foo () { }");
    blocktest("int foo () { }");
    
    // Parameters
    blocktest("public void foo () { }");
    blocktest("public void foo (int p1) { }");
    blocktest("public void foo (int p1, boolean p2) { }");
  }

  @Test
  public void decField() {
    blocktest("public void field1;");
    blocktest("int field2;");
    blocktest("boolean field3;");

    // ArrayType
    blocktest("boolean[] field3;");
  }

  @Test
  public void decType() {
    blocktest("type mytype = \"str\";");
  }

  @Test
  public void statements() {
    stmttest("int localVar;");
    stmttest("{ }");
    stmttest("if ( true ) { }");
    stmttest("if ( true ) { } else { }");
    stmttest("while ( true ) { }");
    stmttest("break;");
    stmttest("return;");
    stmttest("return true;");
    stmttest("true;");
  }

  @Test
  public void RHSExpression() {
    stmttest("123;");
    stmttest("123 == 123;");
    stmttest("123 <= 123;");
  }

  @Test
  public void assignment() {
    stmttest("var1 = 123;");
    stmttest("var1[1] = 123;");
    stmttest("var1[1][2] = 123;");
  }

  @Test
  public void arithmatic() {
    stmttest("var = 1 + 1;");
    stmttest("var = 1 * 1;");
    stmttest("var = 1 * 1 + 1;");
  }

  @Test
  public void primaryExp() {
    stmttest("var1 = 1 + var2;");
    stmttest("var1 = 1 + foo();");
    stmttest("var1 = 1 + arr[1];");
    stmttest("var1 = 1 + \"str\";");
    stmttest("var1 = 1 + 123;");
    stmttest("var1 = 1 + true;");
    stmttest("var1 = 1 + (2);");
  }
}
