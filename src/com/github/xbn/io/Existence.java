/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.io;
/**
   <p>Is existence required or optional?.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public enum Existence  {
   /**
      <p>YYY.</p>

      @see  #REQUIRED
      @see  #isOptional()
    **/
   OPTIONAL,
   /**
      <p>YYY.</p>

      @see  #OPTIONAL
      @see  #isRequired()
    **/
   REQUIRED;
   /**
      <p>Is this {@code Existence} equal to {@code OPTIONAL}?.</p>

      @return  <code>this == {@link #OPTIONAL}</code>

      @see  #isRequired()
    **/
   public final boolean isOptional()  {
      return  this == OPTIONAL;
   }
   /**
      <p>Is this {@code Existence} equal to {@code REQUIRED}?.</p>

      @return  <code>this == {@link #REQUIRED}</code>
      @see  #isOptional()
    **/
   public final boolean isRequired()  {
      return  this == REQUIRED;
   }
};
