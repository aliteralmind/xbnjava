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
package  com.github.xbn.array.helper;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.number.CrashIfIntIs;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.array.primitive.PrimitiveArrayFromObjThatIs;
   import  com.github.xbn.array.primitive.ObjectArrayFromPrimitive;
   import  com.github.xbn.array.primitive.StringArrayFromPrimitive;
   import  com.github.xbn.array.primitive.WrapperArrayFromPrimitive;
   import  org.apache.commons.lang3.ArrayUtils;
/**
   <p>Convenience functions for creating {@code PrimitiveArrayHelper}s of any type.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewPrimitiveArrayHelper  {
   private NewPrimitiveArrayHelper()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final PrimitiveArrayHelper<?> forUnknownType(Object obj_thatIsPrimArr)  {
      Class<?> cls = null;
      try  {
         cls = obj_thatIsPrimArr.getClass();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(obj_thatIsPrimArr, "obj_thatIsPrimArr", null, rx);
      }
/*
---nwrqm input---
boolean Bool
double Double
float Float
long Long
int Int
short Short
byte Byte
char Char
 */
      if(cls.isAssignableFrom(boolean[].class)){
         return  forBoolean();
      }
      if(cls.isAssignableFrom(char[].class)){
         return  forCharacter();
      }
      if(cls.isAssignableFrom(byte[].class)){
         return  forByte();
      }
      if(cls.isAssignableFrom(short[].class)){
         return  forShort();
      }
      if(cls.isAssignableFrom(int[].class)){
         return  forInteger();
      }
      if(cls.isAssignableFrom(long[].class)){
         return  forLong();
      }
      if(cls.isAssignableFrom(float[].class)){
         return  forFloat();
      }
      if(cls.isAssignableFrom(double[].class)){
         return  forDouble();
      }

      throw  new IllegalArgumentException("obj_thatIsPrimArr is not a primitive array. obj_thatIsPrimArr.getClass().getName()=" + obj_thatIsPrimArr.getClass().getName());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for booleans.</p>

      @return  {@code (new }{@link com.github.xbn.array.helper.BooleanArrayHelper#BooleanArrayHelper() BooleanArrayHelper}{@code ())}
      @see  #forCharacter()
    **/
   public static final PrimitiveArrayHelper<Boolean> forBoolean()  {
      return  (new BooleanArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for chars.</p>

<!--
---nwrqm input---
Character char CHARACTER_O CHAR
Double double DOUBLE_O DOUBLE
Float float FLOAT_O FLOAT
Long long LONG_O LONG
Integer int INTEGER_O INT
Short short SHORT_O SHORT
Byte byte BYTE_O BYTE

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {&#64;link #forChaxr() forChaxr()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forChaxr()}.</b></i></p>
 -->

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.

      @see  #forBoolean()
      @see  #forByte()
      @see  #forShort()
      @see  #forInteger()
      @see  #forLong()
      @see  #forFloat()
      @see  #forDouble()
    **/
   public static final PrimitiveArrayHelper<Character> forCharacter()  {
      return  (new CharacterArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for bytes.</p>

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {@link #forCharacter() forCharacter}{@code ()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forCharacter()}.</b></i></p>

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.
    **/
   public static final PrimitiveArrayHelper<Byte> forByte()  {
      return  (new ByteArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for shorts.</p>

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {@link #forCharacter() forCharacter}{@code ()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forCharacter()}.</b></i></p>

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.
    **/
   public static final PrimitiveArrayHelper<Short> forShort()  {
      return  (new ShortArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for ints.</p>

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {@link #forCharacter() forCharacter}{@code ()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forCharacter()}.</b></i></p>

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.
    **/
   public static final PrimitiveArrayHelper<Integer> forInteger()  {
      return  (new IntegerArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for longs.</p>

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {@link #forCharacter() forCharacter}{@code ()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forCharacter()}.</b></i></p>

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.
    **/
   public static final PrimitiveArrayHelper<Long> forLong()  {
      return  (new LongArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for floats.</p>

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {@link #forCharacter() forCharacter}{@code ()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forCharacter()}.</b></i></p>

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.
    **/
   public static final PrimitiveArrayHelper<Float> forFloat()  {
      return  (new FloatArrayHelper());
   }
   /**
      <p>Get a new {@code PrimitiveArrayHelper} for doubles.</p>

      <p><i>Except for {@code forBoolean()}, this and all primitive-type functions in this class are derived from {@link #forCharacter() forCharacter}{@code ()}{@code ()} (and its corresponding private class). <b>Do not edit any function except {@code forCharacter()}.</b></i></p>

      @return  A class equivalent to {@link com.github.xbn.array.helper.BooleanArrayHelper BooleanArrayHelper}.
    **/
   public static final PrimitiveArrayHelper<Double> forDouble()  {
      return  (new DoubleArrayHelper());
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class CharacterArrayHelper extends AbstractPrimitiveArrayHelper<Character>  {
   public CharacterArrayHelper()  {
      super(char[].class);
   }
   public char[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forCharacter(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Character getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Character(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public char[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForCharacter(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Character[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Character[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Character[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Character[] getEmpty()  {
      return  ArrayUtils.EMPTY_CHARACTER_OBJECT_ARRAY;
   }
   public char[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new char[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public char[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_CHAR_ARRAY;
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class ByteArrayHelper extends AbstractPrimitiveArrayHelper<Byte>  {
   public ByteArrayHelper()  {
      super(byte[].class);
   }
   public byte[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forByte(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Byte getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Byte(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public byte[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForByte(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Byte[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Byte[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Byte[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Byte[] getEmpty()  {
      return  ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY;
   }
   public byte[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new byte[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public byte[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_BYTE_ARRAY;
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class ShortArrayHelper extends AbstractPrimitiveArrayHelper<Short>  {
   public ShortArrayHelper()  {
      super(short[].class);
   }
   public short[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forShort(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Short getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Short(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public short[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForShort(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Short[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Short[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Short[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Short[] getEmpty()  {
      return  ArrayUtils.EMPTY_SHORT_OBJECT_ARRAY;
   }
   public short[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new short[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public short[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_SHORT_ARRAY;
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class IntegerArrayHelper extends AbstractPrimitiveArrayHelper<Integer>  {
   public IntegerArrayHelper()  {
      super(int[].class);
   }
   public int[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forInteger(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Integer getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Integer(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public int[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForInteger(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Integer[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Integer[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Integer[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Integer[] getEmpty()  {
      return  ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;
   }
   public int[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new int[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public int[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_INT_ARRAY;
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class LongArrayHelper extends AbstractPrimitiveArrayHelper<Long>  {
   public LongArrayHelper()  {
      super(long[].class);
   }
   public long[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forLong(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Long getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Long(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public long[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForLong(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Long[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Long[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Long[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Long[] getEmpty()  {
      return  ArrayUtils.EMPTY_LONG_OBJECT_ARRAY;
   }
   public long[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new long[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public long[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_LONG_ARRAY;
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class FloatArrayHelper extends AbstractPrimitiveArrayHelper<Float>  {
   public FloatArrayHelper()  {
      super(float[].class);
   }
   public float[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forFloat(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Float getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Float(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public float[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForFloat(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Float[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Float[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Float[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Float[] getEmpty()  {
      return  ArrayUtils.EMPTY_FLOAT_OBJECT_ARRAY;
   }
   public float[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new float[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public float[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_FLOAT_ARRAY;
   }
}
/**
   <p>This class is derived from BooleanArrayHelper (exactly the same except for no JavaDoc). EDIT BooleanArrayHelper ONLY!</p>
 **/
class DoubleArrayHelper extends AbstractPrimitiveArrayHelper<Double>  {
   public DoubleArrayHelper()  {
      super(double[].class);
   }
   public double[] getPrimitiveArray(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.forDouble(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public int getLength(Object obj_thatIsPrimArr, String array_name)  {
      try  {
         return  getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name).length;
      }  catch(RuntimeException rx)  {
         ciObjNullOrUnexpectedType(obj_thatIsPrimArr, "obj_thatIsPrimArr");
         throw  rx;
      }
   }
   public Double getWrapper(Object obj_thatIsPrimArr, int index, String array_name)  {
      try  {
         return  (new Double(getPrimitiveArray(obj_thatIsPrimArr, NullContainer.BAD, array_name)[index]));
      }  catch(RuntimeException rx)  {
         ciObjNullUnexpectedTypeOrBadIndex(obj_thatIsPrimArr, index, array_name);
         throw  rx;
      }
   }
   public double[] getPArrayCopyOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  PrimitiveArrayFromObjThatIs.copyForDouble(obj_thatIsPrimArr, nnull, cntrName_forNullBad);
   }
   public Double[] getWrapperArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  WrapperArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Object[] getObjectArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  ObjectArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public String[] getStringArrayOrNull(Object obj_thatIsPrimArr, NullContainer nnull, String cntrName_forNullBad)  {
      return  StringArrayFromPrimitive.get(getPrimitiveArray(obj_thatIsPrimArr, nnull, cntrName_forNullBad), nnull, cntrName_forNullBad);
   }
   public Double[] getInitialized(int length)  {
      if(length == 0)  {
         return  getEmpty();
      }
      try  {
         return  (new Double[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public Double[] getEmpty()  {
      return  ArrayUtils.EMPTY_DOUBLE_OBJECT_ARRAY;
   }
   public double[] getInitializedPrimitive(int length)  {
      if(length == 0)  {
         return  getEmptyPrimitive();
      }
      try  {
         return  (new double[length]);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(length, "length", null, rx);
      }
   }
   public double[] getEmptyPrimitive()  {
      return  ArrayUtils.EMPTY_DOUBLE_ARRAY;
   }
}
