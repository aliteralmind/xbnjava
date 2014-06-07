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
package  com.github.xbn.experimental.listify.arrayofsame;
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyIntable;
   import  java.util.List;
   import  java.util.Iterator;

/**
   <P>{@code java com.github.xbn.experimental.listify.arrayofsame.zListifyPrimitiveEArrayTest}</P>
 **/
public class ListifyPrimitiveEArrayTest<E> {
   public static void main(String args[])  {
      int[] ai = new int[]{1, 2, 3, 4, 5};
      ListifyIntable lfia = NewListifyPableArray.forInteger(ai);

      System.out.println("Integer array:");
      for(Integer I : lfia)  {
         System.out.println(I);
      }

      System.out.println("raw int array:");
      ai = lfia.getPArrayCopyOrNull(true);
      for(int i : ai)  {
         System.out.println(i);
      }

      System.out.println("Integer array:");
      Integer[] aI = lfia.getEArrayCopyOrNull(NullContainer.OK, CopyElements.NO);
      for(Integer I : aI)  {
         System.out.println(I);
      }

      System.out.println("Integer list:");
      List<Integer> li = lfia.getEListCopyOrNull(NullContainer.OK, CopyElements.NO);
      for(Integer I : li)  {
         System.out.println(I);
      }

   }
}

