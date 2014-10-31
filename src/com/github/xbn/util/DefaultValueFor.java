/*license*\
   XBN-Java: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.util;
/**
   <P>When retrieving an enum from its string representation, if the string is {@code null} or empty, should a default value be provided for it?.</P>

   <P><I>This is used by {@link com.github.xbn.util.EnumUtil EnumUtil}, and therefore this class cannot directly use it.</I></P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public enum DefaultValueFor  {
   /**
      <P>YYY.</P>

      @see  #NULL_ONLY
      @see  #EMPTY_ONLY
      @see  #NOTHING
      @see  #nullOrEmpty()
    **/
   NULL_OR_EMPTY,
   /**
      <P>YYY.</P>

      @see  #NULL_OR_EMPTY
      @see  #nullOnly()
    **/
   NULL_ONLY,
   /**
      <P>YYY.</P>

      @see  #NULL_OR_EMPTY
      @see  #emptyOnly()
    **/
   EMPTY_ONLY,
   /**
      <P>YYY.</P>

      @see  #NULL_OR_EMPTY
      @see  #nothing()
    **/
   NOTHING;
   public final boolean atLeastNull()  {
		return  (nullOrEmpty()  ||  nullOnly());
	}
   public final boolean atLeastEmpty()  {
		return  (nullOrEmpty()  ||  emptyOnly());
	}
   /**
      <P>Is this {@code DefaultValueFor} equal to {@code NULL_OR_EMPTY}?.</P>

      @return  <CODE>this == {@link #NULL_OR_EMPTY}</CODE>

      @see  #nullOnly()
      @see  #emptyOnly()
      @see  #nothing()
    **/
   public final boolean nullOrEmpty()  {
      return  this == NULL_OR_EMPTY;
   }
   /**
      <P>Is this {@code DefaultValueFor} equal to {@code NULL_ONLY}?.</P>

      @return  <CODE>this == {@link #NULL_ONLY}</CODE>
      @see  #nullOrEmpty()
    **/
   public final boolean nullOnly()  {
      return  this == NULL_ONLY;
   }
   /**
      <P>Is this {@code DefaultValueFor} equal to {@code EMPTY_ONLY}?.</P>

      @return  <CODE>this == {@link #EMPTY_ONLY}</CODE>
      @see  #nullOrEmpty()
    **/
   public final boolean emptyOnly()  {
      return  this == EMPTY_ONLY;
   }
   /**
      <P>Is this {@code DefaultValueFor} equal to {@code NOTHING}?.</P>

      @return  <CODE>this == {@link #NOTHING}</CODE>
      @see  #nullOrEmpty()
    **/
   public final boolean nothing()  {
      return  this == NOTHING;
   }
};