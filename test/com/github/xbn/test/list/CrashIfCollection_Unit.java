package  com.github.xbn.test.list;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.NullElement;
   import  com.github.xbn.lang.LengthLessThanRequiredException;
   import  com.github.xbn.list.CrashIfCollection;
   import  java.util.Arrays;
   import  org.junit.Test;
   import  static org.junit.Assert.*;

/**

java com.github.xbn.test.list.CrashIfCollection_Unit

 **/
public class CrashIfCollection_Unit  {
   public static final void main(String[] ignored)  {
      CrashIfCollection_Unit unit = new CrashIfCollection_Unit();
      unit.test_bad();
   }
   @Test
   public void test_bad()  {
      CrashIfCollection.bad(null, null, NullContainer.OK, 1, null, NullElement.BAD, 1, null);
      CrashIfCollection.bad(Arrays.asList(new String[]{}), null,
         NullContainer.BAD, 0, null, NullElement.BAD, 1, null);
      CrashIfCollection.bad(Arrays.asList(new String[]{null}), null,
         NullContainer.BAD, 1, null, NullElement.OK, 1, null);
      CrashIfCollection.bad(Arrays.asList(new String[]{""}), null,
         NullContainer.BAD, 1, null, NullElement.BAD, 0, null);

      try  {
         CrashIfCollection.bad(null, null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null);
         fail("null array");
      }  catch(NullPointerException x)  {
         assertTrue(true);
      }
      try  {
         CrashIfCollection.bad(Arrays.asList(new String[]{}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null);
         fail("array empty");
      }  catch(LengthLessThanRequiredException x)  {
         assertTrue(true);
      }
      try  {
         CrashIfCollection.bad(Arrays.asList(new Object[]{null}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null);
         fail("null element");
      }  catch(NullPointerException x)  {
         assertTrue(true);
      }

      try  {
         CrashIfCollection.bad(Arrays.asList(new Object[]{""}), null, NullContainer.BAD, 1, null, NullElement.BAD, 1, null);
         fail("empty element");
      }  catch(LengthLessThanRequiredException x)  {
         assertTrue(true);
      }
   }
}
