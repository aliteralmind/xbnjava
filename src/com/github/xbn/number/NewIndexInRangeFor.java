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
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.text.StringUtilBase;
   import  java.util.Collection;
/**
   <P>Convenience functions for creating {@code IndexInRange}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewIndexInRangeFor  {
   private NewIndexInRangeFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>An instance with no maximum--Equal to <CODE>{@link IndexInRange}.{@link IndexInRange#UNRESTRICTED UNRESTRICTED}</CODE></P>
    **/
   public static final IndexInRange UNRESTRICTED = IndexInRange.UNRESTRICTED;

   /**
      <P>Create a new instance with a minimum.</P>

      @return  <CODE>(new {@link IndexInRange#IndexInRange(IntBoundInclusive, IntBoundExclusive) IndexInRange}((new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name)), min_name))</CODE>
    **/
   public static final IndexInRange min(int min, String min_name)  {
      return  new IndexInRange((new IntBoundInclusive(min, min_name)), null);
//		xir.setBoundNames(min_name, null);
//		return  xir;
   }
   /**
      <P>Create a new instance with bounds.</P>

      @return  <CODE>new IndexInRange(min, length)</CODE></P>
    **/
   public static final IndexInRange minAndLength(int min, int length, String min_name, String length_name)  {
      return  new IndexInRange(
         new IntBoundInclusive(min, min_name),
         new IntBoundExclusive(length, length_name));
//		xir.setBoundNames(min_name, length_name);
//		return  xir;
   }
   /**
      <P>Create a new instance with a maximum.</P>

      @return  <CODE>(new {@link IndexInRange#IndexInRange(IntBoundInclusive, IntBoundExclusive) IndexInRange}(0, length))</CODE>
    **/
   public static final IndexInRange length(int length, String length_name)  {
      return  new IndexInRange(
         new IntBoundInclusive(0, null),
         new IntBoundExclusive(length, length_name));
//		xir.setBoundNames(null, length_name);
//		return  xir;
   }
   /**
      <P>Create a new instance with the maximum set to a string's length.</P>

      @param  string_forLen  May not be {@code null}.
      @return  <CODE>{@link #length(int, String) length}(string_forLen.toString().length()))</CODE>
    **/
   public static final IndexInRange stringLength(Object string_forLen, String string_name)  {
      return  length(StringUtilBase.getLengthCrashIfNull(string_forLen, string_name), string_name);
   }
   /**
      <P>Create a new instance with the maximum set to a string's length.</P>

      @param  string_forLen  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min, string_forLen.toString().length(), min_name, string_name)</CODE></P>
    **/
   public static final IndexInRange minAndStringLength(int min, Object string_forLen, String min_name, String string_name)  {
      return  minAndLength(min, StringUtilBase.getLengthCrashIfNull(string_forLen, string_name), min_name, string_name);
   }
   /**
      <P>Create a new instance with the maximum set to a array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #length(int, String) length}(array_forLen.length, array_name)</CODE>
    **/
   public static final <E> IndexInRange length(E[] array_forLen, String array_name)  {
      return  length(ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), array_name);
   }
   /**
      <P>Create a new instance with the maximum set to a array's length.</P>

      @param  array_forLen  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min, array_forLen.length, min_name, array_name)</CODE></P>
    **/
   public static final <E> IndexInRange minAndLength(int min, E[] array_forLen, String min_name, String array_name)  {
      return  minAndLength(min, ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), min_name, array_name);
   }
   /**
      <P>Create a new instance with the maximum set to a collection's size.</P>

      @param  coll_forSize  May not be {@code null}.
      @return  <CODE>{@link #length(int, String) length}(coll_forSize.size()), coll_size)</CODE>
    **/
   public static final IndexInRange length(Collection<? extends Object> coll_forSize, String coll_name)  {
      return  length(CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), coll_name);
   }
   /**
      <P>Create a new instance with the maximum set to a collection's size.</P>

      @param  coll_forSize  May not be {@code null}.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min, coll_forSize.size(), min_name, coll_name)</CODE></P>
    **/
   public static final IndexInRange minAndLength(int min, Collection<? extends Object> coll_forSize, String min_name, String coll_name)  {
      return  minAndLength(min, CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), min_name, coll_name);
   }
   /**
      <P>Create a new instance with the maximum set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #length(int, String) length}(
         <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen, array_name, null),
         <BR> &nbsp; &nbsp; array_name)))</CODE>
    **/
   public static final IndexInRange primitiveArrayLength(Object primitiveArray_forLen, String array_name)  {
      return  length(
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         array_name);
   }
   /**
      <P>Create a new instance with the maximum set to a primitive array's length.</P>

      @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
      @return  <CODE>{@link #minAndLength(int, int, String, String) minAndLength}(min,
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <BR> &nbsp; &nbsp; min_name, array_name)</CODE>
    **/
   public static final IndexInRange minAndPArrayLength(int min, Object primitiveArray_forLen, String min_name, String array_name)  {
      return  minAndLength(min,
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         min_name, array_name);
   }
}
