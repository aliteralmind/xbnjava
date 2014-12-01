/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.util.copyval;
/**
   <p>Convenience functions for creating {@code ValueCopier}s.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewValueCopier  {
   private NewValueCopier()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>A new value copier for values that are not copyable.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.ValueNotCopyable ValueNotCopyable}.{@link com.github.xbn.util.copyval.ValueNotCopyable#INSTANCE INSTANCE}</code>
    */
   public static final ValueNotCopyable forNotCopyable()  {
      return  ValueNotCopyable.INSTANCE;
   }
   /**
      <p>A new value copier for string builders.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#STRING_BUILDER STRING_BUILDER}</code>
    * @see  #forString()
    * @see  #forBoolean()
    * @see  #forCharacter()
    * @see  #forByte()
    * @see  #forShort()
    * @see  #forInteger()
    * @see  #forLong()
    * @see  #forFloat()
    * @see  #forDouble()
    */
   public static final OneParamCnstrValueCopier<StringBuilder> forStringBuilder()  {
      return  	OneParamCnstrValueCopier.STRING_BUILDER;
   }
   /**
      <p>A new value copier for strings.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#STRING STRING}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<String> forString()  {
      return  	OneParamCnstrValueCopier.STRING;
   }
   /**
      <p>A new value copier for booleans.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#BOOLEAN BOOLEAN}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Boolean> forBoolean()  {
      return  	OneParamCnstrValueCopier.BOOLEAN;
   }
   /**
      <p>A new value copier for characters.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#CHAR CHAR}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Character> forCharacter()  {
      return  	OneParamCnstrValueCopier.CHAR;
   }
   /**
      <p>A new value copier for bytes.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#BYTE BYTE}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Byte> forByte()  {
      return  	OneParamCnstrValueCopier.BYTE;
   }
   /**
      <p>A new value copier for shorts.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#SHORT SHORT}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Short> forShort()  {
      return  	OneParamCnstrValueCopier.SHORT;
   }
   /**
      <p>A new value copier for integers.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#INT INT}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Integer> forInteger()  {
      return  	OneParamCnstrValueCopier.INT;
   }
   /**
      <p>A new value copier for longs.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#LONG LONG}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Long> forLong()  {
      return  	OneParamCnstrValueCopier.LONG;
   }
   /**
      <p>A new value copier for floats.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#FLOAT FLOAT}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Float> forFloat()  {
      return  	OneParamCnstrValueCopier.FLOAT;
   }
   /**
      <p>A new value copier for doubles.</p>

    * @return  <code>{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier OneParamCnstrValueCopier}.{@link com.github.xbn.util.copyval.OneParamCnstrValueCopier#DOUBLE DOUBLE}</code>
    * @see  #forStringBuilder()
    */
   public static final OneParamCnstrValueCopier<Double> forDouble()  {
      return  	OneParamCnstrValueCopier.DOUBLE;
   }

}
