/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.analyze.alter;
   import  com.github.xbn.util.EnumUtil;
/**
   <P>In {@code ReturnValueUnchanged} only, after each call to <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/alter/ReturnValueUnchanged.html#getAltered(V, A)">getAltered</A>(V,A)</CODE>, what should its {@link com.github.xbn.analyze.alter.ReturnValueUnchanged#wasAltered() wasAltered}{@code ()} flag be set to?.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum AlwaysSetWasAlteredTo {
   /**
      <P>Set {@code wasAltered()} to {@code false}.</P>

      @see  #FALSE
      @see  #isTrue()
    **/
   TRUE,
   /**
      <P>Set {@code wasAltered()} to {@code true}.</P>

      @see  #TRUE
      @see  #isFalse()
    **/
   FALSE;
   /**
      <P>Is this {@code AlwaysSetWasAlteredTo} equal to {@code TRUE}?.</P>

      @return  <CODE>this == {@link #TRUE}</CODE>

      @see  #isFalse()
    **/
   public final boolean isTrue()  {
      return  this == TRUE;
   }
   /**
      <P>Is this {@code AlwaysSetWasAlteredTo} equal to {@code FALSE}?.</P>

      @return  <CODE>this == {@link #FALSE}</CODE>
      @see  #isTrue()
    **/
   public final boolean isFalse()  {
      return  this == FALSE;
   }
};
