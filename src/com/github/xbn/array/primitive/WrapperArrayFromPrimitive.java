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
package  com.github.xbn.array.primitive;
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.array.NullContainer;
   import  org.apache.commons.lang3.ArrayUtils;
/**
   <p>Translate a primitive array to its wrapper-type ({@code int[]} to {@code Integer[]}).</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class WrapperArrayFromPrimitive  {
   /**
      <p>This constructor does nothing.</p>
    */
   public WrapperArrayFromPrimitive()  {
   }
   /**
      <p>Get an array of {@code java.lang.Boolean}-s from a {@code boolean[]}.</p>

      <p><i><b>See:</b><ul>
         <li>{@link #get(char[], NullContainer, String) get(char[],s)}</li>
         <li>{@link #get(byte[], NullContainer, String) get(byte[],s)}, {@link #get(short[], NullContainer, String) get(short[],s)}, {@link #get(int[], NullContainer, String) get(int[],s)}</li>
         <li>{@link #get(long[], NullContainer, String) get(long[],s)}, {@link #get(float[], NullContainer, String) get(float[],s)}, {@link #get(double[], NullContainer, String) get(double[],s)}</li>
      </ul></i></p>

<!--
---nwrqm input---
boolean Boolean
double Double
float Float
long Long
int Integer
short Short
byte Byte
char Character

Change booxl to bool--BUT NOT IN THIS HTML COMMENT!
      &#64;see #get(boolean[], NullContainer, String) get(b[],s)
 -->

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(boolean[]) toObject}(prmtv_array)</code>
    */
    public static Boolean[] get(boolean[] prmtv_array, NullContainer nnull, String cntrName_forNullBad) {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Character}-s from a {@code char[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(char[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Character[] get(char[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Byte}-s from a {@code byte[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(byte[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Byte[] get(byte[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Short}-s from a {@code short[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(short[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Short[] get(short[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Integer}-s from a {@code int[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(int[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Integer[] get(int[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Long}-s from a {@code long[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(long[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Long[] get(long[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Float}-s from a {@code float[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(float[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Float[] get(float[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
   /**
      <p>Get an array of {@code java.lang.Double}-s from a {@code double[]}.</p>

    * @param  nnull  If non-{@code null}, {@code prmtv_array} may not be {@code null}. This is used in the potential error message, and <i>should</i> not be {@code null}.
    * @return  <code>{@link org.apache.commons.lang3.ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#toObject(double[]) toObject}(prmtv_array)</code>
    * @see  #get(boolean[], NullContainer, String) get(b[],s)
    */
   public static final Double[] get(double[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
      if(prmtv_array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  ArrayUtils.toObject(prmtv_array);
   }
}
