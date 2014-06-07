/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.text;
   import  com.github.xbn.util.EnumUtil;
/**
   <P>Should the string be trimmed?.</P>

   @see  StringUtilBase#getChopped(Trim, Object, int, String) StringUtilBase#getChopped
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum Trim  {
   /**
      <P>Trim the string.</P>

      @see  #NO
      @see  #isYes()
    **/
   YES,
   /**
      <P>Do not trim the string.</P>

      @see  #YES
      @see  #isNo()
    **/
   NO;
   /**
      <P>Is this {@code Trim} equal to {@code YES}?.</P>

      @return  <CODE>(this == {@link #YES})</CODE>
      @see  #isNo()
    **/
   public final boolean isYes()  {
      return  (this == YES);
   }
   /**
      <P>Is this {@code Trim} equal to {@code NO}?.</P>

      @return  <CODE>(this == {@link #NO})</CODE>
      @see  #isYes()
    **/
   public final boolean isNo()  {
      return  (this == NO);
   }
   /**
      <P>Get a {@code Trim} from an actual boolean.</P>

      @return  <CODE>(b ? {@link #YES} : {@link #NO})</CODE>
    **/
   public static final Trim getForBoolean(boolean b)  {
      return  (b ? YES : NO);
   }
};
