/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package com.github.xbn.examples.lang.non_xbn;
    import  java.util.Scanner;
    import  org.apache.commons.lang3.math.NumberUtils;
 /**
   <P>Confirm a user-input number is a valid number by reading a string an testing it is numeric before converting it to an it--this loops until a valid number is provided.</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.VerifyUserInputIsANumberWithIsNumber}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
  **/
 public class VerifyUserInputIsANumberWithIsNumber  {
   public static final void main(String[] ignored)  {

      int num = -1;
      boolean isNum = false;

      do  {
         System.out.print("Number please: ");
         String strInput = (new Scanner(System.in)).next();
         if(!NumberUtils.isNumber(strInput))  {
            System.out.println(strInput + " is not a number. Try again.");
         }  else  {
            //Safe to convert
            num = Integer.parseInt(strInput);
            isNum = true;
         }
      }  while(!isNum);

      System.out.println("Number: " + num);
   }
}
