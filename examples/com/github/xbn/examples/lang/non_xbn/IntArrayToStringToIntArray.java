/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com
   
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
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
   import  java.util.ArrayList;
   import  java.util.Arrays;
/**
   <P>Translate an int array to a string array, and safely translate it back, by verifying each is indeed a number with a regular expression.</P>

   <P>java com.github.xbn.examples.lang.non_xbn.IntArrayToStringToIntArray</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IntArrayToStringToIntArray  {
   private static final Pattern pDigits = Pattern.compile("-?\\d+");
   public static final void main(String[] ignored)  {

      String sArray = Arrays.toString(new int[]{1, 2, -45, 678});
         System.out.println("---The array: " + sArray);
         System.out.println(isSafeToConvertToStringedArrayToIntArray(sArray));
         int[] ai = getIntArrayFromToStringedArray(sArray);
         for(int i : ai)  {
            System.out.println(i);
         }
         System.out.println();

      sArray = Arrays.toString(new int[]{1});
         System.out.println("---The array: " + sArray);
         System.out.println(isSafeToConvertToStringedArrayToIntArray(sArray));
         ai = getIntArrayFromToStringedArray(sArray);
         for(int i : ai)  {
            System.out.println(i);
         }
         System.out.println();

      sArray = "bogus";
         System.out.println("---The array: " + sArray);
         System.out.println(isSafeToConvertToStringedArrayToIntArray(sArray));
   }
   //Assumes the string is formatted as if by Arrays.toString(int[])
   public static final boolean isSafeToConvertToStringedArrayToIntArray(String str_ofInts)  {
      //Eliminate the surrounding square brackets
      str_ofInts = str_ofInts.substring(1, str_ofInts.length() - 1);
      String[] as = str_ofInts.split(", ");

      for(String s : as)  {
         Matcher m = pDigits.matcher(s);
         if(!m.matches())  {
            return  false;
         }
      }

      return  true;
   }

   //Assumes the string is formatted as if by Arrays.toString(int[])
   public static final int[] getIntArrayFromToStringedArray(String str_ofInts)  {
      //Eliminate the surrounding square brackets
      str_ofInts = str_ofInts.substring(1, str_ofInts.length() - 1);

      String[] as = str_ofInts.split(", ");

      int[] ai = new int[as.length];
      for(int i = 0; i < as.length; i++)  {
         String s = as[i];
         Matcher m = pDigits.matcher(s);
         if(m.matches())  {
            ai[i] = Integer.parseInt(s);
         }  else  {
            throw  new IllegalArgumentException("Element " + i + " in str_ofInts is not an int: \"" + s + "\".");
         }
      }
      return  ai;
   }
}
