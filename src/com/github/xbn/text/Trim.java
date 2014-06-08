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
package  com.github.xbn.text;
   import  com.github.xbn.util.EnumUtil;
/**
   <P>Should the string be trimmed?.</P>

   @see  StringUtilBase#getChopped(Trim, Object, int, String) StringUtilBase#getChopped
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
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
