/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.util.copyval;
/**
   <P>Convenience functions for creating {@code ValueCopier}s.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewValueCopier  {
   private NewValueCopier()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>A new value copier for values that are not copyable.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.ValueNotCopyable ValueNotCopyable}.{@link com.github.xbn.util.copyval.ValueNotCopyable#INSTANCE INSTANCE}</CODE>
    **/
   public static final ValueNotCopyable forNotCopyable()  {
      return  ValueNotCopyable.INSTANCE;
   }
   /**
      <P>A new value copier for string builders.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#STRING_BUILDER STRING_BUILDER}</CODE>
      @see  #forString()
      @see  #forBoolean()
      @see  #forCharacter()
      @see  #forByte()
      @see  #forShort()
      @see  #forInteger()
      @see  #forLong()
      @see  #forFloat()
      @see  #forDouble()
    **/
   public static final OneParamCnstrValueCopier<StringBuilder> forStringBuilder()  {
      return  	OneParamCnstrValueCopier.STRING_BUILDER;
   }
   /**
      <P>A new value copier for strings.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#STRING STRING}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<String> forString()  {
      return  	OneParamCnstrValueCopier.STRING;
   }
   /**
      <P>A new value copier for booleans.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#BOOLEAN BOOLEAN}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Boolean> forBoolean()  {
      return  	OneParamCnstrValueCopier.BOOLEAN;
   }
   /**
      <P>A new value copier for characters.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#CHAR CHAR}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Character> forCharacter()  {
      return  	OneParamCnstrValueCopier.CHAR;
   }
   /**
      <P>A new value copier for bytes.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#BYTE BYTE}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Byte> forByte()  {
      return  	OneParamCnstrValueCopier.BYTE;
   }
   /**
      <P>A new value copier for shorts.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#SHORT SHORT}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Short> forShort()  {
      return  	OneParamCnstrValueCopier.SHORT;
   }
   /**
      <P>A new value copier for integers.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#INT INT}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Integer> forInteger()  {
      return  	OneParamCnstrValueCopier.INT;
   }
   /**
      <P>A new value copier for longs.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#LONG LONG}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Long> forLong()  {
      return  	OneParamCnstrValueCopier.LONG;
   }
   /**
      <P>A new value copier for floats.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#FLOAT FLOAT}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Float> forFloat()  {
      return  	OneParamCnstrValueCopier.FLOAT;
   }
   /**
      <P>A new value copier for doubles.</P>

      @return  <CODE>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#DOUBLE DOUBLE}</CODE>
      @see  #forStringBuilder()
    **/
   public static final OneParamCnstrValueCopier<Double> forDouble()  {
      return  	OneParamCnstrValueCopier.DOUBLE;
   }

}
