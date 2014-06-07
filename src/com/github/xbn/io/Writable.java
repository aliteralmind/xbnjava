/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful non-GUI programming utilities, featuring shareable self-returning method chains, regular expression convenience classes, TextLineFilter, highly-configurable output for lists, and automated insertion of example code into documentation.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.io;
/**
   <P>Is write-ability required or optional?.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum Writable  {
   /**
      <P>YYY.</P>

      @see  #REQUIRED
      @see  #isOptional()
    **/
   OPTIONAL,
   /**
      <P>YYY.</P>

      @see  #OPTIONAL
      @see  #isRequired()
    **/
   REQUIRED;
   /**
      <P>Is this {@code Writable} equal to {@code OPTIONAL}?.</P>

      @return  <CODE>this == {@link #OPTIONAL}</CODE>

      @see  #isRequired()
    **/
   public final boolean isOptional()  {
      return  this == OPTIONAL;
   }
   /**
      <P>Is this {@code Writable} equal to {@code REQUIRED}?.</P>

      @return  <CODE>this == {@link #REQUIRED}</CODE>
      @see  #isOptional()
    **/
   public final boolean isRequired()  {
      return  this == REQUIRED;
   }
};
