/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package com.github.xbn.examples.lang.non_xbn;
      import  java.util.Scanner;
/**
   <P>Confirm a user-input number is a valid number by reading a string and attempting to convert it to a number--this loops until this conversion <I>does not crash</I>.</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.VerifyUserInputIsANumberWithExceptionCatchingLoop}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
**/
public class VerifyUserInputIsANumberWithExceptionCatchingLoop  {
   public static final void main(String[] ignored)  {

      int num = -1;

      NumberFormatException nfx2 = null;
      do  {
            nfx2 = null;
            System.out.print("Number please: ");
            String strInput = (new Scanner(System.in)).next();
            try  {
               num = Integer.parseInt(strInput);
            }  catch(NumberFormatException nfx)  {
               nfx2 = nfx;
               System.out.println(strInput + " is not a number. Try again.");
            }
         }  while(nfx2 != null);

      System.out.println("Number: " + num);
   }
}
