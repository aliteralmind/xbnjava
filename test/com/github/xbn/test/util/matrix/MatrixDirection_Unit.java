package  com.github.xbn.test.util.matrix;
   import  org.junit.Test;
   import  static org.junit.Assert.*;
   import  com.github.xbn.util.matrix.MatrixDirection;

/*

java com.github.xbn.test.util.matrix.MatrixDirection_Unit

 */
public class MatrixDirection_Unit  {
   public static final void main(String[] ignored)  {
      MatrixDirection_Unit unit = new MatrixDirection_Unit();
      unit.test_horizVertDiag_isHasFlags();
   }
   @Test
   public void test_horizVertDiag_isHasFlags()  {
      MatrixDirection dir = MatrixDirection.UP;
      assertTrue(dir.isVertical());
      assertFalse(dir.isHorizontal());
      assertTrue(dir.isVertOrHoriz());
      assertFalse(dir.isDiagonal());
      assertTrue(dir.isUp());
      assertFalse(dir.isDown());
      assertFalse(dir.isRight());
      assertFalse(dir.isLeft());
      assertTrue(dir.hasUp());
      assertFalse(dir.hasDown());
      assertFalse(dir.hasRight());
      assertFalse(dir.hasLeft());
      assertTrue(dir.hasVertical());
      assertTrue(dir.isVertOrHoriz());

      dir = MatrixDirection.DOWN;
      assertTrue(dir.isVertical());
      assertFalse(dir.isHorizontal());
      assertTrue(dir.isVertOrHoriz());
      assertFalse(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertTrue(dir.isDown());
      assertFalse(dir.isRight());
      assertFalse(dir.isLeft());
      assertFalse(dir.hasUp());
      assertTrue(dir.hasDown());
      assertFalse(dir.hasRight());
      assertFalse(dir.hasLeft());
      assertTrue(dir.hasVertical());
      assertTrue(dir.isVertOrHoriz());

      dir = MatrixDirection.LEFT;
      assertFalse(dir.isVertical());
      assertTrue(dir.isHorizontal());
      assertTrue(dir.isVertOrHoriz());
      assertFalse(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertFalse(dir.isDown());
      assertFalse(dir.isRight());
      assertTrue(dir.isLeft());
      assertFalse(dir.hasUp());
      assertFalse(dir.hasDown());
      assertFalse(dir.hasRight());
      assertTrue(dir.hasLeft());
      assertFalse(dir.hasVertical());
      assertTrue(dir.isVertOrHoriz());

      dir = MatrixDirection.RIGHT;
      assertFalse(dir.isVertical());
      assertTrue(dir.isHorizontal());
      assertTrue(dir.isVertOrHoriz());
      assertFalse(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertFalse(dir.isDown());
      assertTrue(dir.isRight());
      assertFalse(dir.isLeft());
      assertFalse(dir.hasUp());
      assertFalse(dir.hasDown());
      assertTrue(dir.hasRight());
      assertFalse(dir.hasLeft());
      assertFalse(dir.hasVertical());
      assertTrue(dir.isVertOrHoriz());

      dir = MatrixDirection.UP_LEFT;
      assertFalse(dir.isVertical());
      assertFalse(dir.isHorizontal());
      assertFalse(dir.isVertOrHoriz());
      assertTrue(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertFalse(dir.isDown());
      assertFalse(dir.isRight());
      assertFalse(dir.isLeft());
      assertTrue(dir.hasUp());
      assertFalse(dir.hasDown());
      assertFalse(dir.hasRight());
      assertTrue(dir.hasLeft());
      assertTrue(dir.hasVertical());
      assertTrue(dir.hasHorizontal());
      assertFalse(dir.isVertOrHoriz());

      dir = MatrixDirection.UP_RIGHT;
      assertFalse(dir.isVertical());
      assertFalse(dir.isHorizontal());
      assertFalse(dir.isVertOrHoriz());
      assertTrue(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertFalse(dir.isDown());
      assertFalse(dir.isRight());
      assertFalse(dir.isLeft());
      assertTrue(dir.hasUp());
      assertFalse(dir.hasDown());
      assertTrue(dir.hasRight());
      assertFalse(dir.hasLeft());
      assertTrue(dir.hasVertical());
      assertTrue(dir.hasHorizontal());
      assertFalse(dir.isVertOrHoriz());

      dir = MatrixDirection.DOWN_LEFT;
      assertFalse(dir.isVertical());
      assertFalse(dir.isHorizontal());
      assertFalse(dir.isVertOrHoriz());
      assertTrue(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertFalse(dir.isDown());
      assertFalse(dir.isRight());
      assertFalse(dir.isLeft());
      assertFalse(dir.hasUp());
      assertTrue(dir.hasDown());
      assertFalse(dir.hasRight());
      assertTrue(dir.hasLeft());
      assertFalse(dir.isVertOrHoriz());

      dir = MatrixDirection.DOWN_RIGHT;
      assertFalse(dir.isVertical());
      assertFalse(dir.isHorizontal());
      assertFalse(dir.isVertOrHoriz());
      assertTrue(dir.isDiagonal());
      assertFalse(dir.isUp());
      assertFalse(dir.isDown());
      assertFalse(dir.isRight());
      assertFalse(dir.isLeft());
      assertFalse(dir.hasUp());
      assertTrue(dir.hasDown());
      assertTrue(dir.hasRight());
      assertFalse(dir.hasLeft());
      assertTrue(dir.hasVertical());
      assertTrue(dir.hasHorizontal());
      assertFalse(dir.isVertOrHoriz());
   }
}
