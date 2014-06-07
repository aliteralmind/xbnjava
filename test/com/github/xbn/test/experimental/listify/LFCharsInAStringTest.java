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
package  com.github.xbn.experimental.listify;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.experimental.listify.LFCharsInAString;
   import  java.util.List;
   import  java.util.Iterator;

/**
   <P>{@code java com.github.xbn.experimental.listify.zLFCharsInAStringTest}</P>
 **/
public class LFCharsInAStringTest<E> {
   public static void main(String args[])  {
      LFCharsInAString lfcs = new LFCharsInAString("hello");
      Iterator<Character> itrc = lfcs.iterator();
System.out.println("iterator:");
      while(itrc.hasNext())  {
         System.out.println(itrc.next());
      }

System.out.println("p-array:");
      char[] ac = lfcs.getPArrayCopyOrNull(NullContainer.OK);
      for(int i = 0; i < ac.length; i++)  {
         System.out.println(ac[i]);
      }

System.out.println("e-array:");
      Character[] aC = lfcs.getEArrayCopyOrNull(NullContainer.OK, CopyElements.NO);
      for(int i = 0; i < aC.length; i++)  {
         System.out.println(aC[i]);
      }

System.out.println("e-list:");
      List<Character> lc = lfcs.getEListCopyOrNull(NullContainer.OK, CopyElements.NO);
      itrc = lc.iterator();
      while(itrc.hasNext())  {
         System.out.println(itrc.next());
      }

System.out.println("string-list:");
      List<String> ls = lfcs.getStringListOrNull(NullContainer.OK, CopyElements.NO);
      for(String s : ls)  {
         System.out.println(s);
      }

System.out.println("object-list:");
      List<Object> lo = lfcs.getObjectListOrNull(NullContainer.OK, CopyElements.NO);
      for(Object o : lo)  {
         System.out.println(o);
      }
   }
}

