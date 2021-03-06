package  com.github.xbn.test.util.matrix;
   import  org.junit.Test;
   import  static org.junit.Assert.*;
   import  com.github.xbn.util.matrix.MatrixElement;
/*

java com.github.xbn.test.util.matrix.MatrixElement_Unit

 */
public class MatrixElement_Unit  {
   public static final void main(String[] ignored)  {
      MatrixElement_Unit unit = new MatrixElement_Unit();
      unit.test_basics();
      unit.test_distances();
   }
   @Test
   public void test_basics()  {
      MatrixElement element = new MatrixElement(1, 2);
      assertEquals(1, element.getRowIndex());
      assertEquals(2, element.getColumnIndex());
      try  {
         new MatrixElement(-1, 2);
         fail("Row idx below zero should crash.");
      }  catch(IllegalArgumentException iax)  {
         assertTrue(true);
      }
      try  {
         new MatrixElement(1, -1);
         fail("Col idx below zero should crash.");
      }  catch(IllegalArgumentException iax)  {
         assertTrue(true);
      }

      MatrixElement a = new MatrixElement(0, 0);
      MatrixElement b = new MatrixElement(0, 0);
      assertEquals(a, b);

      b = new MatrixElement(0, 1);
      assertNotEquals(a, b);
   }
   @Test
   public void test_distances()  {
      MatrixElement start = new MatrixElement(0, 0);
      assertEquals(0, start.getHorizDistance(start));
      assertEquals(0, start.getVertDistance(start));

      MatrixElement end = new MatrixElement(0, 1);
      assertEquals(0, start.getVertDistance(end));
      assertEquals(1, start.getHorizDistance(end));

      end = new MatrixElement(1, 1);
      assertEquals(1, start.getHorizDistance(end));
      assertEquals(1, start.getVertDistance(end));

      start = new MatrixElement(2, 3);
      end = new MatrixElement(0, 0);
      assertEquals(-2, start.getVertDistance(end));
      assertEquals(-3, start.getHorizDistance(end));
      assertEquals(2, end.getVertDistance(start));
      assertEquals(3, end.getHorizDistance(start));

      start = new MatrixElement(1, 0);
      end = new MatrixElement(0, 1);
      assertEquals(-1, start.getVertDistance(end));
      assertEquals(1, start.getHorizDistance(end));
   }
}
