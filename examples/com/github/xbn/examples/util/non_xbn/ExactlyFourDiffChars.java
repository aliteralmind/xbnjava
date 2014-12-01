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

package  com.github.xbn.examples.util.non_xbn;
/**
   <p>Function that returns true if a string has exactly four (or however many) unique characters--uniqueness is detected with a {@code Map<Character,Object>}, where the value is always {@code null}.</p>

   <p>{@code java com.github.xbn.examples.util.non_xbn.FirstDifferentCharIndex}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
   import  java.util.Map;
   import  java.util.TreeMap;

   /**
      <p>{@code java ExactlyFourDiffChars}</p>
    **/
   public class ExactlyFourDiffChars  {
      public static final void main(String[] ignored)  {
         System.out.println("aabbccdd: " + hasMoreThanXUniqueChars(4, "aabbccdd"));
         System.out.println("dictionary: " + hasMoreThanXUniqueChars(4, "dictionary"));
         System.out.println("reassesses: " + hasMoreThanXUniqueChars(4, "reassesses"));
      }
      public static final boolean hasMoreThanXUniqueChars(int maxAllowedChars, String str)  {
         Map<Character,Object> charMap = new TreeMap<Character,Object>();

         for(int i = 0; i < str.length(); i++)  {
            Character C = str.charAt(i);
            if(!charMap.containsKey(C))  {
               charMap.put(C, null);

               if(maxAllowedChars-- == 0)  {
                  return  false;
               }
            }

         }

         return  true;
      }
   }
