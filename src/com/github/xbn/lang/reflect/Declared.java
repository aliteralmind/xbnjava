/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.lang.reflect;
/**
   <P>Are declared or non-declared items wanted?.</P>

   @see  ReflectRtxUtil#getConstructor(Class, Declared, Object, Class...) ReflectRtxUtil#getConstructor
   @see  ReflectRtxUtil#getMethod(Class, String, Declared, Object, Class...) getMethod
   @see  ReflectRtxUtil#getField(Class, String, Declared, Object)  getField
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum Declared  {
   /**
      <P>YYY.</P>

      @see  #NO
      @see  #isYes()
    **/
   YES,
   /**
      <P>YYY.</P>

      @see  #YES
      @see  #isNo()
    **/
   NO;
   /**
      <P>Is this {@code Declared} equal to {@code YES}?.</P>

      @return  <CODE>this == {@link #YES}</CODE>

      @see  #isNo()
    **/
   public final boolean isYes()  {
      return  this == YES;
   }
   /**
      <P>Is this {@code Declared} equal to {@code NO}?.</P>

      @return  <CODE>this == {@link #NO}</CODE>
      @see  #isYes()
    **/
   public final boolean isNo()  {
      return  this == NO;
   }
   /**
      <P>Return {@code Declared.YES} if the flag is {@code true}, or {@code NO} if {@code false}.</P>

      @return  <CODE>(flag ? {@link #YES} : {@link #NO})</CODE>
    **/
   public static final Declared getForBoolean(boolean flag)  {
      return  (flag ? YES : NO);
   }
};
