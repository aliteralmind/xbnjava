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
/**
   <P>Inserts an element into an existing array, moving all subsequent elements to the right (discarding the last).</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.ManualArrayInsertWItrDiscardLastElement}</P>

   @see  com.github.xbn.examples.lang.ManualArrayInsertWItrIntoNewArray
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
import  java.util.Arrays;
public class ManualArrayInsertWItrDiscardLastElement  {
   public static final void main(String[] ignored)  {

      //You don't have to prefix it with ManualArrayInsertWItr in this static main,
      //but it's normally called this way.
      Integer[] intArr = ManualArrayInsertWItrDiscardLastElement.<Integer>insertIntAtIndex(3, 4,
         new Integer[] {1, 2, 3, 5, 6, 7, 8, 9, -1});

      System.out.println("Inserted with no debugging: " + Arrays.toString(intArr));

      System.out.println("With debugging:");

      intArr = ManualArrayInsertWItrDiscardLastElement.<Integer>insertIntAtIndexWithDebugging(3, 4,
         new Integer[] {1, 2, 3, 5, 6, 7, 8, 9, -1});

   }
   public static final <O> O[] insertIntAtIndexWithDebugging(int insertIdx, O toInsert, O[] arr_toInsInto)  {

      System.out.println("insertIntAtIndex: insertIdx=" + insertIdx + ", toInsert=" + toInsert + ", arr_toInsInto=" +  Arrays.toString(arr_toInsInto) + "");
      int idx = -1;
      O elementToMove = null;
      for(O o : arr_toInsInto)  {
         idx++;                    //First iteration: was -1, now 0
         if(idx < insertIdx)  {
            System.out.println("idx (" + idx + ") is less than insertIdx (" + insertIdx + ")");
            continue;
         }  else if(idx == insertIdx)  {
            elementToMove = o;
            arr_toInsInto[idx] = toInsert;
            System.out.println("idx (" + idx + ") equals insertIdx (" + insertIdx + "): arr_toInsInto=" +  Arrays.toString(arr_toInsInto));
         }  else  {
            O elementToMove2 = elementToMove;
            elementToMove = o;
            arr_toInsInto[idx] = elementToMove2;
            System.out.println("idx (" + idx + ") greater than insertIdx (" + insertIdx + "): arr_toInsInto=" +  Arrays.toString(arr_toInsInto));
         }
      }
      return  arr_toInsInto;
   }

   public static final <O> O[] insertIntAtIndex(int insertIdx, O toInsert, O[] arr_toInsInto)  {

      int idx = -1;
      O elementToMove = null;
      for(O o : arr_toInsInto)  {
         idx++;                    //First iteration: was -1, now 0
         if(idx < insertIdx)  {
            continue;
         }  else if(idx == insertIdx)  {
            elementToMove = o;
            arr_toInsInto[idx] = toInsert;
         }  else  {
            O elementToMove2 = elementToMove;
            elementToMove = o;
            arr_toInsInto[idx] = elementToMove2;
         }
      }
      return  arr_toInsInto;
   }
}

