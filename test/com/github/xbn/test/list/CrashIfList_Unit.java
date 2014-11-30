package  com.github.xbn.test.list;
   import  com.github.xbn.array.Duplicates;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.NullElement;
   import  com.github.xbn.lang.BadDuplicateException;
   import  com.github.xbn.lang.LengthLessThanRequiredException;
   import  com.github.xbn.list.CrashIfList;
   import  java.util.Arrays;
   import  org.junit.Test;
   import  static org.junit.Assert.*;

/**

java com.github.xbn.test.list.CrashIfList_Unit

 **/
public class CrashIfList_Unit  {
   public static final void main(String[] ignored)  {
      CrashIfList_Unit unit = new CrashIfList_Unit();
      unit.test_bad();
   }
   @Test
   public void test_bad()  {
      CrashIfList.bad(null, null, NullContainer.OK, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
      CrashIfList.bad(Arrays.asList(new String[]{}), null,
         NullContainer.BAD, 0, null, NullElement.BAD, 1, null, Duplicates.BAD);
      CrashIfList.bad(Arrays.asList(new String[]{null}), null,
         NullContainer.BAD, 1, null, NullElement.OK, 1, null, Duplicates.BAD);
      CrashIfList.bad(Arrays.asList(new String[]{""}), null,
         NullContainer.BAD, 1, null, NullElement.BAD, 0, null, Duplicates.BAD);
      CrashIfList.bad(Arrays.asList(new String[]{"", ""}), null,
         NullContainer.BAD, 1, null, NullElement.BAD, 0, null, Duplicates.OK);

      try  {
         CrashIfList.bad(null, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
         fail("null array");
      }  catch(NullPointerException x)  {
         assertTrue(true);
      }
      try  {
         CrashIfList.bad(Arrays.asList(new String[]{}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
         fail("array empty");
      }  catch(LengthLessThanRequiredException x)  {
         assertTrue(true);
      }
      try  {
         CrashIfList.bad(Arrays.asList(new Object[]{null}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
         fail("null element");
      }  catch(NullPointerException x)  {
         assertTrue(true);
      }

      try  {
         CrashIfList.bad(Arrays.asList(new Object[]{""}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
         fail("empty element");
      }  catch(LengthLessThanRequiredException x)  {
         assertTrue(true);
      }
      try  {
         CrashIfList.bad(Arrays.asList(new Object[]{"x", "x"}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null, Duplicates.BAD);
         fail("duplicate elements");
      }  catch(BadDuplicateException x)  {
         assertTrue(true);
      }
   }
}
