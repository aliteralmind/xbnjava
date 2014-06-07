/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.experimental.listify;
   import  com.github.xbn.analyze.validate.NewValueValidatorFor;
   import  com.github.xbn.analyze.validate.NullnessValidator;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.array.NewArrayIterator;
   import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
   import  com.github.xbn.array.helper.PrimitiveArrayHelper;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.experimental.listify.backend.AbstractLFBIsPArrayElementValid;
   import  com.github.xbn.experimental.listify.backend.LFBIsNonPArrayElementValid;
   import  com.github.xbn.experimental.listify.backend.LFListElementsValidity;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyBoolable;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
   import  java.util.Iterator;
   import  java.util.List;
/**
   <P>Convenience functions for creating listifiers whose virtual elements are <I>booleans that express the validity</I> of the elements in the raw object.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewLFBooleanIsValidElement  {
   private NewLFBooleanIsValidElement()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   @SuppressWarnings("unchecked")
   public static final <R> ListifyBoolable nullIs(Null nnull, List<R> list, ValidResultFilter filter_ifNullOff, Appendable dbgDest_ifNonNull)  {
      return  (new LFListElementsValidity<R>(list, NewValueValidatorFor.<R>nullIs(nnull, filter_ifNullOff, dbgDest_ifNonNull)));
   }
   public static final <R> ListifyBoolable forOnlyNullValid(List<R> list, ValidResultFilter filter_ifNullOff, Appendable dbgDest_ifNonNull)  {
      return  (new LFListElementsValidity<R>(list, NewValueValidatorFor.<R>onlyNullGood(filter_ifNullOff, dbgDest_ifNonNull)));
   }
   public static final <R> ListifyBoolable forNullBad(List<R> list, ValidResultFilter filter_ifNullOff, Appendable dbgDest_ifNonNull)  {
      return  (new LFListElementsValidity<R>(list, NewValueValidatorFor.<R>nullBad(filter_ifNullOff, dbgDest_ifNonNull)));
   }
   public static final <R> ListifyBoolable nullIs(Null nnull, List<R> list, NullHandlerForPrimitives<Boolean> null_handler, ValidResultFilter filter_ifNullOff, Appendable dbgDest_ifNonNull)  {
      return  (new LFListElementsValidity<R>(list, NewValueValidatorFor.<R>nullIs(nnull, filter_ifNullOff, dbgDest_ifNonNull), null_handler));
   }
   public static final <R> ListifyBoolable forOnlyNullValid(List<R> list, NullHandlerForPrimitives<Boolean> null_handler, ValidResultFilter filter_ifNullOff, Appendable dbgDest_ifNonNull)  {
      return  (new LFListElementsValidity<R>(list, NewValueValidatorFor.<R>onlyNullGood(filter_ifNullOff, dbgDest_ifNonNull), null_handler));
   }
   public static final <R> ListifyBoolable forNullBad(List<R> list, NullHandlerForPrimitives<Boolean> null_handler, ValidResultFilter filter_ifNullOff, Appendable dbgDest_ifNonNull)  {
      return  (new LFListElementsValidity<R>(list, NewValueValidatorFor.<R>nullBad(filter_ifNullOff, dbgDest_ifNonNull), null_handler));
   }
   public static final <R> ListifyBoolable forList(List<R> list, ValueValidator<R> raw_elementVldtr)  {
      return  (new LFListElementsValidity<R>(list, raw_elementVldtr));
   }
   public static final <R> ListifyBoolable forList(List<R> list, ValueValidator<R> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFListElementsValidity<R>(list, raw_elementVldtr, null_handler));
   }
   public static final <R> ListifyBoolable forArray(R[] objects, ValueValidator<R> raw_elementVldtr)  {
      return  (new LFBIsNonPArrayElementValid<R>(objects, raw_elementVldtr));
   }
   public static final <R> ListifyBoolable forArray(R[] objects, ValueValidator<R> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsNonPArrayElementValid<R>(objects, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(byte[] prim_array, ValueValidator<Byte> raw_elementVldtr)  {
      return  (new LFBIsPByteArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(byte[] prim_array, ValueValidator<Byte> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsPByteArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(short[] prim_array, ValueValidator<Short> raw_elementVldtr)  {
      return  (new LFBIsPShortArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(short[] prim_array, ValueValidator<Short> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsPShortArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(int[] prim_array, ValueValidator<Integer> raw_elementVldtr)  {
      return  (new LFBIsIntArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(int[] prim_array, ValueValidator<Integer> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsIntArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(long[] prim_array, ValueValidator<Long> raw_elementVldtr)  {
      return  (new LFBIsPLongArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(long[] prim_array, ValueValidator<Long> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsPLongArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(float[] prim_array, ValueValidator<Float> raw_elementVldtr)  {
      return  (new LFBIsPFloatArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(float[] prim_array, ValueValidator<Float> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsPFloatArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(double[] prim_array, ValueValidator<Double> raw_elementVldtr)  {
      return  (new LFBIsPDoubleArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(double[] prim_array, ValueValidator<Double> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsPDoubleArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
   public static final ListifyBoolable forArray(char[] prim_array, ValueValidator<Character> raw_elementVldtr)  {
      return  (new LFBIsCharArrayElementValid(prim_array, raw_elementVldtr));
   }
   public static final ListifyBoolable forArray(char[] prim_array, ValueValidator<Character> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      return  (new LFBIsCharArrayElementValid(prim_array, raw_elementVldtr, null_handler));
   }
}
   /**
      <P>YYY</P>
<!--
char Character Char
double Double PDouble
float Float PFloat
long Long PLong
int Integer Int
short Short PShort
byte Byte PByte
 -->
    **/
class LFBIsCharArrayElementValid extends AbstractLFBIsPArrayElementValid<Character>  {
   private PrimitiveArrayHelper<Character> pah = null;
   public LFBIsCharArrayElementValid(char[] prim_array, ValueValidator<Character> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forCharacter(), raw_elementVldtr);
   }
   public LFBIsCharArrayElementValid(char[] prim_array, ValueValidator<Character> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forCharacter(), raw_elementVldtr, null_handler);
   }
   public LFBIsCharArrayElementValid(LFBIsCharArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((char[])getRawObject(), getVVRawElement());
   }
   public LFBIsCharArrayElementValid getObjectCopy()  {
      return  (new LFBIsCharArrayElementValid(this));
   }
}
class LFBIsPByteArrayElementValid extends AbstractLFBIsPArrayElementValid<Byte>  {
   private PrimitiveArrayHelper<Byte> pah = null;
   public LFBIsPByteArrayElementValid(byte[] prim_array, ValueValidator<Byte> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forByte(), raw_elementVldtr);
   }
   public LFBIsPByteArrayElementValid(byte[] prim_array, ValueValidator<Byte> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forByte(), raw_elementVldtr, null_handler);
   }
   public LFBIsPByteArrayElementValid(LFBIsPByteArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((byte[])getRawObject(), getVVRawElement());
   }
   public LFBIsPByteArrayElementValid getObjectCopy()  {
      return  (new LFBIsPByteArrayElementValid(this));
   }
}
class LFBIsPShortArrayElementValid extends AbstractLFBIsPArrayElementValid<Short>  {
   private PrimitiveArrayHelper<Short> pah = null;
   public LFBIsPShortArrayElementValid(short[] prim_array, ValueValidator<Short> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forShort(), raw_elementVldtr);
   }
   public LFBIsPShortArrayElementValid(short[] prim_array, ValueValidator<Short> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forShort(), raw_elementVldtr, null_handler);
   }
   public LFBIsPShortArrayElementValid(LFBIsPShortArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((short[])getRawObject(), getVVRawElement());
   }
   public LFBIsPShortArrayElementValid getObjectCopy()  {
      return  (new LFBIsPShortArrayElementValid(this));
   }
}
class LFBIsIntArrayElementValid extends AbstractLFBIsPArrayElementValid<Integer>  {
   private PrimitiveArrayHelper<Integer> pah = null;
   public LFBIsIntArrayElementValid(int[] prim_array, ValueValidator<Integer> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forInteger(), raw_elementVldtr);
   }
   public LFBIsIntArrayElementValid(int[] prim_array, ValueValidator<Integer> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forInteger(), raw_elementVldtr, null_handler);
   }
   public LFBIsIntArrayElementValid(LFBIsIntArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((int[])getRawObject(), getVVRawElement());
   }
   public LFBIsIntArrayElementValid getObjectCopy()  {
      return  (new LFBIsIntArrayElementValid(this));
   }
}
class LFBIsPLongArrayElementValid extends AbstractLFBIsPArrayElementValid<Long>  {
   private PrimitiveArrayHelper<Long> pah = null;
   public LFBIsPLongArrayElementValid(long[] prim_array, ValueValidator<Long> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forLong(), raw_elementVldtr);
   }
   public LFBIsPLongArrayElementValid(long[] prim_array, ValueValidator<Long> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forLong(), raw_elementVldtr, null_handler);
   }
   public LFBIsPLongArrayElementValid(LFBIsPLongArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((long[])getRawObject(), getVVRawElement());
   }
   public LFBIsPLongArrayElementValid getObjectCopy()  {
      return  (new LFBIsPLongArrayElementValid(this));
   }
}
class LFBIsPFloatArrayElementValid extends AbstractLFBIsPArrayElementValid<Float>  {
   private PrimitiveArrayHelper<Float> pah = null;
   public LFBIsPFloatArrayElementValid(float[] prim_array, ValueValidator<Float> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forFloat(), raw_elementVldtr);
   }
   public LFBIsPFloatArrayElementValid(float[] prim_array, ValueValidator<Float> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forFloat(), raw_elementVldtr, null_handler);
   }
   public LFBIsPFloatArrayElementValid(LFBIsPFloatArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((float[])getRawObject(), getVVRawElement());
   }
   public LFBIsPFloatArrayElementValid getObjectCopy()  {
      return  (new LFBIsPFloatArrayElementValid(this));
   }
}
class LFBIsPDoubleArrayElementValid extends AbstractLFBIsPArrayElementValid<Double>  {
   private PrimitiveArrayHelper<Double> pah = null;
   public LFBIsPDoubleArrayElementValid(double[] prim_array, ValueValidator<Double> raw_elementVldtr)  {
      super(prim_array, NewPrimitiveArrayHelper.forDouble(), raw_elementVldtr);
   }
   public LFBIsPDoubleArrayElementValid(double[] prim_array, ValueValidator<Double> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
      super(prim_array, NewPrimitiveArrayHelper.forDouble(), raw_elementVldtr, null_handler);
   }
   public LFBIsPDoubleArrayElementValid(LFBIsPDoubleArrayElementValid to_copy)  {
      super(to_copy);
      pah = to_copy.pah;
   }
   public final Iterator<Boolean> iterator()  {
      return  NewArrayIterator.forIsElementValid((double[])getRawObject(), getVVRawElement());
   }
   public LFBIsPDoubleArrayElementValid getObjectCopy()  {
      return  (new LFBIsPDoubleArrayElementValid(this));
   }
}
