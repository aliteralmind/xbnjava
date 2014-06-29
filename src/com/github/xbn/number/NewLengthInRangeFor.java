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
   import  com.github.xbn.lang.Invert;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  java.util.Collection;
   import  com.github.xbn.text.StringUtilBase;
/**
   <P>Convenience functions for creating {@code LengthInRange}s--unless otherwise stated, the maximum bound is always exclusive.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewLengthInRangeFor  {
   private NewLengthInRangeFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>An {@code LengthInRange} with no bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link LengthInRange}.{@link LengthInRange#UNRESTRICTED UNRESTRICTED}</CODE></P>
    **/
   public static final LengthInRange UNRESTRICTED = LengthInRange.UNRESTRICTED;
   /**
      <P>An {@code LengthInRange} with no members.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link LengthInRange}.{@link LengthInRange#IMPOSSIBLE IMPOSSIBLE}</CODE></P>
    **/
   public static final LengthInRange IMPOSSIBLE = LengthInRange.IMPOSSIBLE;
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

      @return  <CODE>new {@link LengthInRange#LengthInRange(Invert, IntBoundInclusive, IntBound) LengthInRange}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), null)</CODE>
    **/
   public static final LengthInRange min(Invert invert_dontIfNull, int min, String min_name)  {
      return  new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(min, min_name), null);
   }
      private static final Invert getInvNoIfNull(Invert invert_dontIfNull)  {
         return  ((invert_dontIfNull != null) ? invert_dontIfNull : Invert.NO);
      }
   /**
      <P>Create a new instance with a maximum.</P>

      @return  <CODE>new LengthInRange#LengthInRange(Invert, int, int, String, String)(invert_dontIfNull,
      <BR> &nbsp; &nbsp; 0, length, null, length_name)</CODE>
    **/
   public static final LengthInRange length(Invert invert_dontIfNull, int length, String length_name)  {
      return  new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         0, length, null, length_name);
   }
   /**
      <P>Create a new instance with an maximum.</P>

      @return  <CODE>{@link #length(Invert, int, String) length}(invert_dontIfNull, max, max_name)</CODE>
    **/
   public static final LengthInRange maxExclusive(Invert invert_dontIfNull, int max, String max_name)  {
      return  length(invert_dontIfNull, max, max_name);
   }
   /**
      <P>Create a new instance with an maximum.</P>

      @return  <CODE>{@link #maxExclusive(Invert, int, String) maxExclusive}(invert_dontIfNull, max, max_name)</CODE>
   public static final LengthInRange max(Invert invert_dontIfNull, int max, String max_name)  {
      return  maxExclusive(invert_dontIfNull, max, max_name);
   }
    **/
   /**
      <P>Create a new instance with inclusive bounds.</P>

      @return  <CODE>new LengthInRange(Invert, IntBoundInclusive, IntBound)(invert_dontIfNull,
         new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), new IntBoundInclusive(incl_max, max_name))</CODE>
    **/
   public static final LengthInRange minMaxInclusive(Invert invert_dontIfNull, int min, int incl_max, String min_name, String max_name)  {
      return  new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(min, min_name), new IntBoundInclusive(incl_max, max_name));
   }
   /**
      <P>Create a new instance with an inclusive maximum.</P>

      @return  <CODE>new LengthInRange(Invert, int, String, IntBound)(invert_dontIfNull,
         0, null, new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(incl_max, max_name))</CODE>
    **/
   public static final LengthInRange maxInclusive(Invert invert_dontIfNull, int incl_max, String max_name)  {
      return  new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         0, null, new IntBoundInclusive(incl_max, max_name));
   }
   /**
      <P>Create a new instance with a single legal value--both bounds are inclusive.</P>

      @return  <CODE>new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min_andMax, minMax_name), new IntBoundInclusive(min_andMax, minMax_name))</CODE></P>
    **/
   public static final LengthInRange exactly(Invert invert_dontIfNull, int min_andMax, String minMax_name)  {
      return  new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(min_andMax, minMax_name), new IntBoundInclusive(min_andMax, minMax_name));
   }
   /**
      <P>Create a new instance with bounds.</P>

      @return  <CODE>new {@link LengthInRange#LengthInRange(int, int, String, String) LengthInRange}(min, length, min_name, length_name)</CODE></P>
      @see  #exactly(Invert, int, String) exactly
    **/
   public static final LengthInRange minAndLength(Invert invert_dontIfNull, int min, int length, String min_name, String length_name)  {
      return  new LengthInRange(getInvNoIfNull(invert_dontIfNull),
         min, length, min_name, length_name);
   }
   /**
      <P>Create a new instance with bounds.</P>

      @return  <CODE>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(invert_dontIfNull, min, length, min_name, length_name)</CODE></P>
    **/
   public static final LengthInRange minInclMaxExcl(Invert invert_dontIfNull, int min, int max, String min_name, String length_name)  {
      return  minAndLength(invert_dontIfNull, min, max, min_name, length_name);
   }
   /**
      <P>Create a new instance with the maximum set to a string's length.</P>

      @return  <CODE>{@link #minAndStringLength(Invert, int, Object, String, String) minAndStringLength}(0, string_forLen, null, string_name)</CODE>
    **/
   public static final LengthInRange stringLength(Invert invert_dontIfNull, Object string_forLen, String string_name)  {
      return  minAndStringLength(getInvNoIfNull(invert_dontIfNull),
         0, string_forLen, null, string_name);
   }
   /**
      <P>Create a new instance with both bounds set to a string's length--both bounds are inclusive.</P>

      @param  str_forMinAndLen  May not be {@code null}.
      @return  <CODE>{@link #exactly(Invert, int, String) exactly}(str_forMinAndLen.toString().length(), string_name)</CODE></P>
    **/
   public static final LengthInRange stringLengthExactly(Invert invert_dontIfNull, Object str_forMinAndLen, String string_name)  {
      return  exactly(getInvNoIfNull(invert_dontIfNull),
         StringUtilBase.getLengthCrashIfNull(str_forMinAndLen, string_name), string_name);
   }
   /**
      <P>Create a new instance with the maximum set to a string's length.</P>

      @param  str_forMinAndLen  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min, str_forMinAndLen.toString().length(), min_name, string_name)</CODE></P>
    **/
   public static final LengthInRange minAndStringLength(Invert invert_dontIfNull, int min, Object str_forMinAndLen, String min_name, String string_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull),
         min, StringUtilBase.getLengthCrashIfNull(str_forMinAndLen, string_name), min_name, string_name);
   }
   /**
      <P>Create a new instance with the maximum set to a collection's size.</P>

      @return  <CODE>{@link #minAndSize(Invert, int, Collection, String, String) minAndSize}(0, coll_forSize, null, coll_name)</CODE>
    **/
   public static final <E> LengthInRange size(Invert invert_dontIfNull, Collection<?> coll_forSize, String coll_name)  {
      return  minAndSize(getInvNoIfNull(invert_dontIfNull),
         0, coll_forSize, null, coll_name);
   }
   /**
      <P>Create a new instance with both bounds set to a collection's size--both bounds are inclusive.</P>

      @param  coll_forSize  May not be {@code null}
      @return  <CODE>{@link #exactly(Invert, int, String) exactly}(coll_forSize.size(), coll_name)</CODE></P>
    **/
   public static final <E> LengthInRange collectionSizeExactly(Invert invert_dontIfNull, Collection<?> coll_forSize, String coll_name)  {
      return  exactly(getInvNoIfNull(invert_dontIfNull),
         CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), coll_name);
   }
   /**
      <P>Create a new instance with the maximum set to a collection's size.</P>

      @param  coll_forSize  May not be {@code null}
      @return  <CODE>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min, coll_forSize, min_name, coll_name)</CODE></P>
    **/
   public static final <E> LengthInRange minAndSize(Invert invert_dontIfNull, int min, Collection<?> coll_forSize, String min_name, String coll_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull),
         min, CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), min_name, coll_name);
   }
   /**
      <P>Create a new instance with the maximum set to an array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #length(Invert, int, String) length}(array_forLen.length, array_name)</CODE></P>
    **/
   public static final <E> LengthInRange length(Invert invert_dontIfNull, E[] array_forLen, String array_name)  {
      return  length(getInvNoIfNull(invert_dontIfNull),
         ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), array_name);
   }
   /**
      <P>Create a new instance with both bounds set to a array's length--both bounds are inclusive.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #exactly(Invert, int, String) exactly}(array_forLen.length, array_name)</CODE></P>
    **/
   public static final <E> LengthInRange arrayLengthExactly(Invert invert_dontIfNull, E[] array_forLen, String array_name)  {
      return  exactly(getInvNoIfNull(invert_dontIfNull),
         ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), array_name);
   }
   /**
      <P>Create a new instance with the maximum bound set to an array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min, array_forLen.length, min_name, array_name)</CODE></P>
    **/
   public static final <E> LengthInRange minAndLength(Invert invert_dontIfNull, int min, E[] array_forLen, String min_name, String array_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull),
         min, ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), min_name, array_name);
   }
   /**
      <P>Create a new instance with the maximum bound set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #length(Invert, int, String) length}(
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; array_name)</CODE></P>
    **/
   public static final LengthInRange primitiveArrayLength(Invert invert_dontIfNull, Object primitiveArray_forLen, String array_name)  {
      return  length(getInvNoIfNull(invert_dontIfNull),
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         array_name);
   }
   /**
      <P>Create a new instance with both bounds set to a primitive array's length--both bounds are inclusive.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #exactly(Invert, int, String) exactly}(
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; array_name)</CODE></P>
    **/
   public static final LengthInRange primitiveArrayLengthExactly(Invert invert_dontIfNull, Object primitiveArray_forLen, String array_name)  {
      return  exactly(getInvNoIfNull(invert_dontIfNull),
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         array_name);
   }
   /**
      <P>Create a new instance with the maximum bound set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min,
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; min_name, array_name)</CODE></P>
    **/
   public static final LengthInRange minAndPArrayLength(Invert invert_dontIfNull, int min, Object primitiveArray_forLen, String min_name, String array_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull), min,
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         min_name, array_name);
   }
}
