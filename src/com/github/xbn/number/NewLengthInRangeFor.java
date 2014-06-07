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

package  com.github.xbn.number;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  java.util.Collection;
   import  com.github.xbn.text.StringUtilBase;
/**
   <P>Convenience functions for creating {@code LengthInRange}s.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewLengthInRangeFor  {
   private NewLengthInRangeFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>An instance with no maximum--Equal to <CODE>{@link LengthInRange}.{@link LengthInRange#UNRESTRICTED UNRESTRICTED}</CODE></P>
    **/
   public static final LengthInRange UNRESTRICTED = LengthInRange.UNRESTRICTED;
   /**
      <P>An instance in which only zero is bad--Equal to <CODE>{@link LengthInRange}.{@link LengthInRange#GREATER_THAN_ZERO GREATER_THAN_ZERO}</CODE></P>
    **/
   public static final LengthInRange GREATER_THAN_ZERO = LengthInRange.GREATER_THAN_ZERO;
   /**
      <P>An instance in which only zero is good--Equal to <CODE>{@link LengthInRange}.{@link LengthInRange#ZERO_ONLY ZERO_ONLY}</CODE></P>
    **/
   public static final LengthInRange ZERO_ONLY = LengthInRange.ZERO_ONLY;

   /**
      <P>Create a new instance with a minimum.</P>

      @return  <CODE>new {@link LengthInRange#LengthInRange(IntBoundInclusive, IntBoundInclusive) LengthInRange}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), null)</CODE>
    **/
   public static final LengthInRange min(int min, String min_name)  {
      return  new LengthInRange(new IntBoundInclusive(min, min_name), null);
//		lir.setBoundNames(min_name, null);
//		return  lir;
   }
   /**
      <P>Create a new instance with a maximum.</P>

      @return  <CODE>new {@link LengthInRange#LengthInRange(IntBoundInclusive, IntBoundInclusive) LengthInRange}(null, new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(length, length_name))</CODE>
    **/
   public static final LengthInRange length(int length, String length_name)  {
      return  new LengthInRange(null, new IntBoundInclusive(length, length_name));
//		lir.setBoundNames(null, length_name);
//		return  lir;
   }
   /**
      <P>Create a new instance with a single legal value.</P>

      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(both_minAndLen, both_minAndLen, minLen_name, minLen_name)</CODE></P>
    **/
   public static final LengthInRange exactly(int both_minAndLen, String minLen_name)  {
      return  minAndLength(both_minAndLen, both_minAndLen, minLen_name, minLen_name);
   }
   /**
      <P>Create a new instance with bounds.</P>

      @return  <CODE>new {@link LengthInRange#LengthInRange(int, int, String, String) LengthInRange}(min, length, min_name, length_name)</CODE></P>
      @see  #exactly(int, String) exactly
    **/
   public static final LengthInRange minAndLength(int min, int length, String min_name, String length_name)  {
      return  new LengthInRange(min, length, min_name, length_name);
//		lir.setBoundNames(min_name, length_name);
//		return  lir;
   }
   /**
      <P>Create a new instance with the maximum set to a string's length.</P>

      @return  <CODE>{@link #minAndStringLength(int, Object, String, String) minAndStringLength}(0, string_forLen, null, string_name)</CODE>
    **/
   public static final LengthInRange stringLength(Object string_forLen, String string_name)  {
      return  minAndStringLength(0, string_forLen, null, string_name);
   }
   /**
      <P>Create a new instance with both bounds set to a string's length.</P>

      @param  str_forMinAndLen  May not be {@code null}.
      @return  <CODE>{@link #exactly(int, String) exactly}(str_forMinAndLen.toString().length(), string_name)</CODE></P>
    **/
   public static final LengthInRange stringLengthExactly(Object str_forMinAndLen, String string_name)  {
      return  exactly(StringUtilBase.getLengthCrashIfNull(str_forMinAndLen, string_name), string_name);
   }
   /**
      <P>Create a new instance with the maximum set to a string's length.</P>

      @param  str_forMinAndLen  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min, str_forMinAndLen.toString().length(), min_name, string_name)</CODE></P>
    **/
   public static final LengthInRange minAndStringLength(int min, Object str_forMinAndLen, String min_name, String string_name)  {
      return  minAndLength(min, StringUtilBase.getLengthCrashIfNull(str_forMinAndLen, string_name), min_name, string_name);
   }
   /**
      <P>Create a new instance with the maximum set to a collection's size.</P>

      @return  <CODE>{@link #minAndSize(int, Collection, String, String) minAndSize}(0, coll_forSize, null, coll_name)</CODE>
    **/
   public static final <E> LengthInRange size(Collection<?> coll_forSize, String coll_name)  {
      return  minAndSize(0, coll_forSize, null, coll_name);
   }
   /**
      <P>Create a new instance with both bounds set to a collection's size.</P>

      @param  coll_forSize  May not be {@code null}
      @return  <CODE>{@link #exactly(int, String) exactly}(coll_forSize.size(), coll_name)</CODE></P>
    **/
   public static final <E> LengthInRange collectionSizeExactly(Collection<?> coll_forSize, String coll_name)  {
      return  exactly(CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), coll_name);
   }
   /**
      <P>Create a new instance with the maximum set to a collection's size.</P>

      @param  coll_forSize  May not be {@code null}
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min, coll_forSize, min_name, coll_name)</CODE></P>
    **/
   public static final <E> LengthInRange minAndSize(int min, Collection<?> coll_forSize, String min_name, String coll_name)  {
      return  minAndLength(min, CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), min_name, coll_name);
   }
   /**
      <P>Create a new instance with the maximum set to an array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #length(int, String) length}(array_forLen.length, array_name)</CODE></P>
    **/
   public static final <E> LengthInRange length(E[] array_forLen, String array_name)  {
      return  length(ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), array_name);
   }
   /**
      <P>Create a new instance with both bounds set to a array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #exactly(int, String) exactly}(array_forLen.length, array_name)</CODE></P>
    **/
   public static final <E> LengthInRange arrayLengthExactly(E[] array_forLen, String array_name)  {
      return  exactly(ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), array_name);
   }
   /**
      <P>Create a new instance with the maximum bound set to an array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min, array_forLen.length, min_name, array_name)</CODE></P>
    **/
   public static final <E> LengthInRange minAndLength(int min, E[] array_forLen, String min_name, String array_name)  {
      return  minAndLength(min, ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), min_name, array_name);
   }
   /**
      <P>Create a new instance with the maximum bound set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #length(int, String) length}(
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; array_name)</CODE></P>
    **/
   public static final LengthInRange primitiveArrayLength(Object primitiveArray_forLen, String array_name)  {
      return  length(
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         array_name);
   }
   /**
      <P>Create a new instance with both bounds set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #exactly(int, String) exactly}(
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; array_name)</CODE></P>
    **/
   public static final LengthInRange primitiveArrayLengthExactly(Object primitiveArray_forLen, String array_name)  {
      return  exactly(
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         array_name);
   }
   /**
      <P>Create a new instance with the maximum bound set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min,
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; min_name, array_name)</CODE></P>
    **/
   public static final LengthInRange minAndPArrayLength(int min, Object primitiveArray_forLen, String min_name, String array_name)  {
      return  minAndLength(min,
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         min_name, array_name);
   }
}
