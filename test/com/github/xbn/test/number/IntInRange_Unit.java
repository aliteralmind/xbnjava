package  com.github.xbn.test.number;
   import  com.github.xbn.number.IntInRange;
   import  com.github.xbn.number.IntBound;
   import  com.github.xbn.number.BoundSide;
   import  org.junit.Test;
   import  static org.junit.Assert.*;

/**

java com.github.xbn.test.number.IntInRange_Unit

 **/
public class IntInRange_Unit  {
   public static final void main(String[] as_clp)  {
      IntInRange_Unit unit = new IntInRange_Unit();
      unit.test_1();
   }
   @Test
   public void test_1()  {
      IntInRange iir = new IntInRange(1, 2);
      assertEquals(false, iir.isIn(0));
      assertEquals(true, iir.isIn(1));
      assertEquals(true, iir.isIn(2));
      assertEquals(false, iir.isIn(3));

      IntInRange iir2 = iir.getInvertedCopy();
      assertEquals(true, iir2.isIn(0));
      assertEquals(false, iir2.isIn(1));
      assertEquals(false, iir2.isIn(2));
      assertEquals(true, iir2.isIn(3));

      assertEquals(1, (int)iir.getInclMinComparedTo(0));
      assertEquals(0, (int)iir.getInclMinComparedTo(1));
      assertEquals(-1, (int)iir.getInclMinComparedTo(2));
      assertEquals(-2, (int)iir.getInclMinComparedTo(3));

      assertEquals(2, (int)iir.getInclMaxComparedTo(0));
      assertEquals(1, (int)iir.getInclMaxComparedTo(1));
      assertEquals(0, (int)iir.getInclMaxComparedTo(2));
      assertEquals(-1, (int)iir.getInclMaxComparedTo(3));

      IntBound ibMin = iir.getMinBound();

      assertEquals(1, (int)ibMin.getInclComparedTo(BoundSide.MIN, 0));
      assertEquals(0, (int)ibMin.getInclComparedTo(BoundSide.MIN, 1));
      assertEquals(-1, (int)ibMin.getInclComparedTo(BoundSide.MIN, 2));
      assertEquals(-2, (int)ibMin.getInclComparedTo(BoundSide.MIN, 3));

      IntBound ibMax = iir.getMaxBound();

      assertEquals(2, (int)ibMax.getInclComparedTo(BoundSide.MAX, 0));
      assertEquals(1, (int)ibMax.getInclComparedTo(BoundSide.MAX, 1));
      assertEquals(0, (int)ibMax.getInclComparedTo(BoundSide.MAX, 2));
      assertEquals(-1, (int)ibMax.getInclComparedTo(BoundSide.MAX, 3));
   }
}
