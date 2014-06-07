/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.analyze.validate;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
   import  com.github.xbn.analyze.validate.NewValueValidatorFor;
/**
   <P>Blindly determine that the first <I>something</I> is valid, and then expire the validator, making all subsequent items invalid.</P>

   <P>{@code java com.github.xbn.examples.analyze.validate.FirstCheckIsAlwaysValidThenExpireXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FirstCheckIsAlwaysValidThenExpireXmpl  {
   public static final void main(String[] ignored)  {

      //Set the valid-filter range to be min 1, max 1.
      ValidResultFilter vrf = NewValidResultFilterFor.inUnchangedOutFalse(1, 1, null, null,
         null);  //Debug on: System.out, Off: null

      ValueValidator<Object> vvo = NewValueValidatorFor.<Object>unrestricted(vrf,
         null);  //Debug

      for(int i = 1; i <= 10; i++)  {
         System.out.println(i + " " + vvo.isValid("anything"));
      }
   }
}
