/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.array;
   import  java.util.Arrays;
   import  com.github.xbn.array.BinarySearcher;
/**
   <P>Use {@code com.github.xbn.array.}{@link com.github.xbn.array.BinarySearcher BinarySearcher} to find the index at which a string exists in an ordered array (or where to insert it).</P>

   <P>{@code java com.github.xbn.examples.array.BinarySearcherXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class BinarySearcherXmpl  {
   public static final void main(String[] ignored)  {
      test("abc");
      test("abcd");
      test("ghi");
      test("kl");
   }
   private static final void test(String searching_for)  {
      String[] asToSearch = {"abc", "def", "ghi", "jkl", "mno"};

      System.out.println("Searching for \"" + searching_for + "\" in " + Arrays.toString(asToSearch));

      BinarySearcher bs = new BinarySearcher(true).containerLength(asToSearch.length);

      while(!bs.isDone())  {
         String sPossibility = asToSearch[bs.getIndexMiddle()];

         int iCompare = searching_for.compareTo(sPossibility);
         if(iCompare == 0)  {
            System.out.println("   Found at index " + bs.getIndexMiddle());
            return;
         }

         bs.resetIteration(iCompare < 0);
      }

      System.out.println("   Not found. Can be INSERTED at index " + bs.getIndexInsertAt() + ".");
   }
}
