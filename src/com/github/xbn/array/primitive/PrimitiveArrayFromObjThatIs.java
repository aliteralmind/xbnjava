/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)		(*Two tabs plus this comment, to force this phrase to be (a) imported, and (b) with NO autotext*)
\*license*/
package  com.github.xbn.array.primitive;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.IndexableUtil;
/**
   <p>Utilities related to primitive arrays, and {@code java.lang.Object}-s that are actually primitive arrays.</p>

   <p>This is released as a Gist on GitHub:
   <br/> &nbsp; &nbsp; {@code <a href="https://gist.github.com/aliteralmind/7813097">https://gist.github.com/aliteralmind/7813097</a>}
   <br/>To publish: Comment out the {@code package} and the {@code extends}, and change tabs to spaces.</p>

 * @see  com.github.xbn.array.GetArrayFromObjectThatIs
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class PrimitiveArrayFromObjThatIs  {
   /**
      <p>This constructor does nothing.</p>
    */
   public PrimitiveArrayFromObjThatIs()  {
   }
//internal
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <!-- MAIN FUNCTION -->
<!--
---nwrqm input---
Bool boolean
PDouble double
PFloat float
PLong long
Int int
PShort short
PByte byte
Char char

      <p><i>All {&#64;code get[Type]OrNullFromObject(o,s,s)} are derived from {&#64;link #forBooxlean(Object, NullContainer, String) forBooxlean(o,s,s)}. <b>Do not edit any function except {&#64;code forBooxlean(o,s,s)}.</b></i></p>
 -->

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code boolean}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (boolean[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final boolean[] forBoolean(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (boolean[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of booleans. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code char}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (char[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final char[] forCharacter(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (char[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of chars. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code byte}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (byte[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final byte[] forByte(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (byte[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of bytes. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code short}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (short[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final short[] forShort(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (short[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of shorts. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code int}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (int[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final int[] forInteger(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (int[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of ints. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code long}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (long[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final long[] forLong(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (long[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of longs. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code float}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (float[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final float[] forFloat(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (float[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of floats. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a primitive array from an object (that <i>is</i> a primitive array).</p>

      <p><i>All {@code get[Type]OrNullFromObject(o,s,s)} are derived from {@link #forBoolean(Object, NullContainer, String) forBoolean(o,s,s)}. <b>Do not edit any function except {@code forBoolean(o,s,s)}.</b></i></p>

    * @param  obj_thatIsPrimArr  When non-{@code null}, must be a primitive array of {@code double}-s.
    * @param  nnull  May not be {@code null}. If {@link com.github.xbn.array.NullContainer#OK OK}, {@code obj_thatIsPrimArr} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name of {@code obj_thatIsPrimArr}. When {@code is_nullCntrOk} is {@code true}, this is ignored. Otherwise, <i>should</i> not be {@code null} or empty.
    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@code (double[])obj_thatIsPrimArr}</li>
      </ul>
    * @exception  NullPointerException  If {@code obj_thatIsPrimArr} is {@code null} and {@code is_nullCntrOk} is {@code false}.
    */
   public static final double[] forDouble(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      if(obj_thatIsPrimArr == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      try  {
         return  (double[])obj_thatIsPrimArr;
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("obj_thatIsPrimArr is not a primitive array of doubles. obj_thatIsPrimArr.getClass().getName()=\"" + obj_thatIsPrimArr.getClass().getName() + "\"");
      }
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>
<!--
---nwrqm input---
Bool boolean
PDouble double
PFloat float
PLong long
Int int
PShort short
PByte byte
Char char

      <p><i>All {&#64;code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {&#64;link #forBooxleanCopy(Object, boolean, String) forBooxlCopy(o,s,s)}. <b>Do not edit any function except {&#64;code forBooxlCopy(o,s,s)}.</b></i></p>
 -->

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forBoolean(Object, NullContainer, String) forBoolean}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final boolean[] copyForBoolean(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      boolean[] ap = forBoolean(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forCharacter(Object, NullContainer, String) forCharacter}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final char[] copyForCharacter(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      char[] ap = forCharacter(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forByte(Object, NullContainer, String) forByte}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final byte[] copyForByte(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      byte[] ap = forByte(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forShort(Object, NullContainer, String) forShort}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final short[] copyForShort(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      short[] ap = forShort(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forInteger(Object, NullContainer, String) forInteger}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final int[] copyForInteger(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      int[] ap = forInteger(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forLong(Object, NullContainer, String) forLong}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final long[] copyForLong(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      long[] ap = forLong(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forFloat(Object, NullContainer, String) forFloat}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final float[] copyForFloat(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      float[] ap = forFloat(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
   /**
      <p>Get a copy of a primitive array from an object .</p>

      <p><i>All {@code get[Type]CopyOrNullFromObject(o,s,s)} are derived from {@link #copyForBoolean(Object, NullContainer, String) copyForBoolean(o,nci,s)}. <b>Do not edit any function except {@code copyForBoolean(o,nci,s)}.</b></i></p>

    * @return  If {@code obj_thatIsPrimArr} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: {@link #forDouble(Object, NullContainer, String) forDouble}{@code (obj_thatIsPrimArr, nnull, cntrName_forNullBad).clone()}</li>
      </ul>
    */
   public static final double[] copyForDouble(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      double[] ap = forDouble(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
      if(ap == null)  {
         return  null;
      }
      return  ap.clone();
   }
}
