package  com.github.xbn.test.array;
	import  com.github.xbn.array.NullElement;
	import  com.github.xbn.lang.BadDuplicateException;
	import  com.github.xbn.lang.LengthLessThanRequiredException;
	import  com.github.xbn.array.CrashIfArray;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.array.Duplicates;
	import  org.junit.Test;
	import  static org.junit.Assert.*;

/**

java com.github.xbn.test.array.CrashIfArray_Unit

 **/
public class CrashIfArray_Unit  {
	public static final void main(String[] ignored)  {
		CrashIfArray_Unit unit = new CrashIfArray_Unit();
		unit.test_bad();
	}
	@Test
	public void test_bad()  {
		CrashIfArray.bad(null, null, NullContainer.OK, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
		CrashIfArray.bad(new String[]{}, null, NullContainer.BAD, 0, null, NullElement.BAD, 1, null, Duplicates.BAD);
		CrashIfArray.bad(new String[]{null}, null, NullContainer.BAD, 1, null, NullElement.OK, 1, null, Duplicates.BAD);
		CrashIfArray.bad(new String[]{""}, null, NullContainer.BAD, 1, null, NullElement.BAD, 0, null, Duplicates.BAD);
		CrashIfArray.bad(new String[]{"", ""}, null, NullContainer.BAD, 1, null, NullElement.BAD, 0, null, Duplicates.OK);

		try  {
			CrashIfArray.bad(null, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
			fail("null array");
		}  catch(NullPointerException x)  {
			assertTrue(true);
		}
		try  {
			CrashIfArray.bad(new String[]{}, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
			fail("array empty");
		}  catch(LengthLessThanRequiredException x)  {
			assertTrue(true);
		}
		try  {
			CrashIfArray.bad(new Object[]{null}, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
			fail("null element");
		}  catch(NullPointerException x)  {
			assertTrue(true);
		}

		try  {
			CrashIfArray.bad(new Object[]{""}, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
			fail("empty element");
		}  catch(LengthLessThanRequiredException x)  {
			assertTrue(true);
		}
		try  {
			CrashIfArray.bad(new Object[]{"x", "x"}, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
			fail("duplicate elements");
		}  catch(BadDuplicateException x)  {
			assertTrue(true);
		}
	}
}