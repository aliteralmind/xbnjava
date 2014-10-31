package  com.github.xbn.test.text.padchop;
	import  com.github.xbn.text.padchop.EscapeAction;
	import  com.github.xbn.text.padchop.VzblPadChop;
	import  com.github.xbn.text.padchop.NewVzblPadChopFor;
	import  org.junit.Test;
	import  static org.junit.Assert.*;

/**

java com.github.xbn.test.text.padchop.VzblPadChop_Unit

 **/
public class VzblPadChop_Unit  {
	public static final void main(String[] as_clp)  {
		VzblPadChop_Unit unit = new VzblPadChop_Unit();
		unit.test1();
	}
	@Test
	public void test1()  {
		VzblPadChop padchop = NewVzblPadChopFor.trimEscChopWithDDD(true, null, 30);
		String sActl = padchop.get(15, "123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.123456789.");
		assertEquals("123456789.12...", sActl);

		assertEquals("\"\nhello\n\"", padchop.get("\"\nhello\n\""));

		padchop = NewVzblPadChopFor.trimEscChopWithDDD(true, EscapeAction.ESCAPE, 30);
		assertEquals("\\\"\\nhello\\n\\\"", padchop.get("\"\nhello\n\""));

		padchop = NewVzblPadChopFor.trimEscChopWithDDD(true, EscapeAction.UNESCAPE, 30);
		assertEquals("\"\nhello\n\"", padchop.get("\"\nhello\n\""));
	}
}
