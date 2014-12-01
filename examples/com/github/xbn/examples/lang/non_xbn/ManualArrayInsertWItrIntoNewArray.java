/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.examples.lang.non_xbn;
   import  java.util.Arrays;
/**
   <p>Duplicate an array, where the new array has an element inserted in it at an arbitrary index.</p>

   <p>{@code java com.github.xbn.examples.lang.non_xbn.ManualArrayInsertWItrIntoNewArray}</p>

   @see  com.github.xbn.examples.lang.ManualArrayInsertWItrDiscardLastElement
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class ManualArrayInsertWItrIntoNewArray  {
   public static final void main(String[] ignored)  {

      //You don't have to prefix it with ManualArrayInsertWItr in this static main,
      //but it's normally called this way.
      Integer[] intArr = new Integer[] {1, 2, 3, 5, 6, 7, 8, 9};

      Integer[] intArr2 = ManualArrayInsertWItrIntoNewArray.<Integer>getNewArrayWithInserted(3, 4,
         intArr, new Integer[intArr.length + 1]);

      System.out.println("Original: " + Arrays.toString(intArr));
      System.out.println("New with insert: " + Arrays.toString(intArr2));

   }
   public static final <O> O[] getNewArrayWithInserted(int insertIdx, O toInsert, O[] orig_arr, O[] arr_toInsInto)  {

      int idx = -1;

      try  {
         for(O o : orig_arr)  {
            idx++;                    //First iteration: was -1, now 0
            if(idx < insertIdx)  {
               arr_toInsInto[idx] = o;
               continue;
            }

            if(idx == insertIdx)  {
               arr_toInsInto[idx++] = toInsert;
            }
            arr_toInsInto[idx] = o;
         }
      }  catch(ArrayIndexOutOfBoundsException abx)  {
         throw  new ArrayIndexOutOfBoundsException("idx=" + idx + ", insertIdx=" + insertIdx + ", orig_arr.length=" + orig_arr.length + ", arr_toInsInto.length=" + arr_toInsInto.length + ", original error:" + abx);
      }
      return  arr_toInsInto;
   }
}
