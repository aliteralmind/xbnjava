/*license*\
   XBN-Java: http://xbnjava.aliteralmind.com

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedHighestia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.examples.util.matrix;
   import  com.github.xbn.number.IndexInRange;
   import  com.github.xbn.util.matrix.BoundedMatrix;
   import  com.github.xbn.util.matrix.EdgeExceeded;
   import  com.github.xbn.util.matrix.MatrixDirection;
   import  com.github.xbn.util.matrix.MatrixElement;
   import java.text.DecimalFormat;
/**
 * <p>A duplicate of {@link com.github.xbn.examples.util.matrix.Largest4InARowProductInMatrixEfficient}
 * with no diagnostic output.</p>
 *
 * <p><code>java  com.github.xbn.examples.util.matrix.Largest4InARowProductInMatrixEfficientNoDiag</code></p>
 *
 * @since  0.1.4.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class Largest4InARowProductInMatrixEfficientNoDiag  {
   //The number of cells *next* to the first one. The element chain is one
   //greater than this
   public static final int NEIGHBOR_COUNT = 3;

   public static final int[][] intMatrixFromProjectEuler = {
      new int[] { 8,  2, 22, 97, 38, 15,  0, 40,  0, 75,  4,  5,  7, 78, 52, 12, 50, 77, 91,  8},
      new int[] {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48,  4, 56, 62,  0},
      new int[] {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,  3, 49, 13, 36, 65},
      new int[] {52, 70, 95, 23,  4, 60, 11, 42, 69, 24, 68, 56,  1, 32, 56, 71, 37,  2, 36, 91},
      new int[] {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
      new int[] {24, 47, 32, 60, 99,  3, 45,  2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
      new int[] {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
      new int[] {67, 26, 20, 68,  2, 62, 12, 20, 95, 63, 94, 39, 63,  8, 40, 91, 66, 49, 94, 21},
      new int[] {24, 55, 58,  5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
      new int[] {21, 36, 23,  9, 75,  0, 76, 44, 20, 45, 35, 14,  0, 61, 33, 97, 34, 31, 33, 95},
      new int[] {78, 17, 53, 28, 22, 75, 31, 67, 15, 94,  3, 80,  4, 62, 16, 14,  9, 53, 56, 92},
      new int[] {16, 39,  5, 42, 96, 35, 31, 47, 55, 58, 88, 24,  0, 17, 54, 24, 36, 29, 85, 57},
      new int[] {86, 56,  0, 48, 35, 71, 89,  7,  5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
      new int[] {19, 80, 81, 68,  5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77,  4, 89, 55, 40},
      new int[] { 4, 52,  8, 83, 97, 35, 99, 16,  7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
      new int[] {88, 36, 68, 87, 57, 62, 20, 72,  3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
      new int[] { 4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18,  8, 46, 29, 32, 40, 62, 76, 36},
      new int[] {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74,  4, 36, 16},
      new int[] {20, 73, 35, 29, 78, 31, 90,  1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57,  5, 54},
      new int[] { 1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52,  1, 89, 19, 67, 48}
   };

   //So I don't give the answer away, and for less output
   public static final int[][] intMatrixAnother = {
      new int[]  {31, 48, 50, 20, 57, 51, 48, 78},
      new int[]  {19,  7,  3,  2, 23, 76, 58, 51},
      new int[]  {99, 78, 12, 64,  9, 15, 72,  0},
      new int[]  {92,  5, 86, 68, 13, 55,  2, 98},
      new int[]  {43, 79,  4, 62,  0, 70, 57, 89},
      new int[]  {69, 65, 84, 27, 12, 14, 83, 16},
      new int[]  { 5, 97, 96, 65, 77, 77, 62, 67},
      new int[]  {94,  2,  5, 99,  3, 60, 49, 54}
   };
   public static final int[][] intMatrix = intMatrixAnother;

   //For moving from one element to another, in any direction, and
   //detecting which cells should be analyzed.
   public static final BoundedMatrix matrix = new BoundedMatrix(
                                                       intMatrix[0].length,
                                                       intMatrix.length);
   public static final void main(String[] cmd_lineParams)  {

      //A trivial object to hold the highest product and its starting
      //element, and with a convenient debugging function. ("3" because
      //you can't declare a private class having the same name as a private
      //class in *another* file.)
      ProductElementDirection3 pedHighest = new ProductElementDirection3();

      //Initialize it to the lowest-possible value, so the first product
      //overrides it.
      pedHighest.product = Integer.MIN_VALUE;

      for(int rowIdx = 0; rowIdx < matrix.getRowCount(); rowIdx++)  {

         //Analyze each row in all four directions. Only those cells known
         //to have the proper number of neighbors are analyzed.
         //
         //If a higher product is found, highestProductElem is updated.
         //
         //No need to do the opposites (LEFT, UP_LEFT, UP, UP_RIGHT),
         //because multiplication is commutative.
         processRowElementsForOneDirection(rowIdx, MatrixDirection.RIGHT, pedHighest);
         processRowElementsForOneDirection(rowIdx,MatrixDirection.DOWN, pedHighest);
         processRowElementsForOneDirection(rowIdx, MatrixDirection.DOWN_RIGHT, pedHighest);
         processRowElementsForOneDirection(rowIdx, MatrixDirection.DOWN_LEFT, pedHighest);
      }

      System.out.println("Highest product of " + (NEIGHBOR_COUNT + 1) +
         " contiguous elements is " + pedHighest);
   }
      private static final void processRowElementsForOneDirection(
               int row_idx, MatrixDirection direction,
               ProductElementDirection3 ped_highest)  {

         //Get the *range* of indexes in this row representing the elements
         //in it that have at least the required number of neighbors.
         IndexInRange indexRange = matrix.getRowItemIdxRangeForNeighborCount(
            row_idx, direction, NEIGHBOR_COUNT);

         if(indexRange == null)  {
            return;
         }

         //At least one element needs to be analyzed

         int product = 0;
         if(indexRange != null)  {

            //For each element in the index range, get the product of its
            //chain
            MatrixElement firstElement = null;
            for(int colIdx = indexRange.getMin(); colIdx < indexRange.getMax();
                  colIdx++)  {

               //Initialize
               int firstNum = intMatrix[row_idx][colIdx];
               firstElement = matrix.get(row_idx, colIdx);
               MatrixElement element = firstElement;

               if(firstNum == 0)  {
                  //If any of the numbers are zero, the product is
                  //definitely zero. No need to continue.
                  continue;
               }

               //The product of a single number (the first number in the
               //chain) is the number itself.
               product = firstNum;

               for(int counter = 0; counter < NEIGHBOR_COUNT; counter++)  {

                  //Get the value of its next-door neighbor
                  element = matrix.moveNextDoor(element, direction,
                     EdgeExceeded.CRASH);
                  int elemRowIdx = element.getRowIndex();
                  int elemColIdx = element.getColumnIndex();
                  int nextNum = intMatrix[elemRowIdx][elemColIdx];

                  if(nextNum == 0)  {
                     product = 0;
                     break;
                  }

                  //Multiply this number to the product
                  product *= nextNum;
               }

               if(product > ped_highest.product)  {
                  ped_highest.product = product;
                  ped_highest.firstElement = firstElement;
                  ped_highest.direction = direction;
               }
            }
         }
      }
}
class ProductElementDirection3  {
   public int product;
   public MatrixElement firstElement;
   public MatrixDirection direction;
   public String toString()  {
      return  "Starting at " + firstElement + ", going " + direction + ": Product=" + product;
   }
}
