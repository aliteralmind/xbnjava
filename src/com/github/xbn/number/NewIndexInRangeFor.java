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
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.text.StringUtilBase;
   import  java.util.Collection;
/**
   <p>Convenience functions for creating {@code IndexInRange}s.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewIndexInRangeFor  {
   /**
      <p>An {@code IndexInRange} with no bounds.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link IndexInRange}.{@link IndexInRange#UNRESTRICTED UNRESTRICTED}</code></p>
    */
   public static final IndexInRange UNRESTRICTED = IndexInRange.UNRESTRICTED;
   /**
      <p>An {@code IndexInRange} with no members.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link IndexInRange}.{@link IndexInRange#IMPOSSIBLE IMPOSSIBLE}</code></p>
    */
   public static final IndexInRange IMPOSSIBLE = IndexInRange.IMPOSSIBLE;
   /**
      <p>Create a new instance with a minimum.</p>

    * @return  <code>(new {@link IndexInRange#IndexInRange(IntBoundInclusive, IntBoundExclusive) IndexInRange}((new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name)), min_name))</code>
    */
   public static final IndexInRange min(Invert invert_dontIfNull, int min, String min_name)  {
      return  new IndexInRange(getInvNoIfNull(invert_dontIfNull),
         (new IntBoundInclusive(min, min_name)), null);
   }
   /**
      <p>Create a new instance with bounds.</p>

    * @return  <code>new IndexInRange(min, length)</code></p>
    */
   public static final IndexInRange minAndLength(Invert invert_dontIfNull, int min, int length, String min_name, String length_name)  {
      return  new IndexInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(min, min_name),
         new IntBoundExclusive(length, length_name));
   }
   /**
      <p>Create a new instance with a maximum.</p>

    * @return  <code>(new {@link IndexInRange#IndexInRange(IntBoundInclusive, IntBoundExclusive) IndexInRange}(0, length))</code>
    */
   public static final IndexInRange length(Invert invert_dontIfNull, int length, String length_name)  {
      return  new IndexInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(0, null),
         new IntBoundExclusive(length, length_name));
   }
   /**
      <p>Create a new instance with the maximum set to a string's length.</p>

    * @param  string_forLen  May not be {@code null}.
    * @return  <code>{@link #length(Invert, int, String) length}(string_forLen.toString().length()))</code>
    */
   public static final IndexInRange stringLength(Invert invert_dontIfNull, Object string_forLen, String string_name)  {
      return  length(getInvNoIfNull(invert_dontIfNull),
         StringUtilBase.getLengthCrashIfNull(string_forLen, string_name), string_name);
   }
   /**
      <p>Create a new instance with the maximum set to a string's length.</p>

    * @param  string_forLen  May not be {@code null}.
    * @return  <code>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min, string_forLen.toString().length(), min_name, string_name)</code></p>
    */
   public static final IndexInRange minAndStringLength(Invert invert_dontIfNull, int min, Object string_forLen, String min_name, String string_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull),
         min, StringUtilBase.getLengthCrashIfNull(string_forLen, string_name), min_name, string_name);
   }
   /**
      <p>Create a new instance with the maximum set to a array's length.</p>

    * @param  array_forLen  May not be {@code null}.
    * @return  <code>{@link #length(Invert, int, String) length}(array_forLen.length, array_name)</code>
    */
   public static final <E> IndexInRange length(Invert invert_dontIfNull, E[] array_forLen, String array_name)  {
      return  length(getInvNoIfNull(invert_dontIfNull),
         ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), array_name);
   }
   /**
      <p>Create a new instance with the maximum set to a array's length.</p>

    * @param  array_forLen  May not be {@code null}.
    * @return  <code>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min, array_forLen.length, min_name, array_name)</code></p>
    */
   public static final <E> IndexInRange minAndLength(Invert invert_dontIfNull, int min, E[] array_forLen, String min_name, String array_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull),
         min, ArrayUtil.getLengthCrashIfNull(array_forLen, array_name), min_name, array_name);
   }
   /**
      <p>Create a new instance with the maximum set to a collection's size.</p>

    * @param  coll_forSize  May not be {@code null}.
    * @return  <code>{@link #length(Invert, int, String) length}(coll_forSize.size()), coll_size)</code>
    */
   public static final IndexInRange length(Invert invert_dontIfNull, Collection<? extends Object> coll_forSize, String coll_name)  {
      return  length(getInvNoIfNull(invert_dontIfNull),
         CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), coll_name);
   }
   /**
      <p>Create a new instance with the maximum set to a collection's size.</p>

    * @param  coll_forSize  May not be {@code null}.
    * @return  <code>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min, coll_forSize.size(), min_name, coll_name)</code></p>
    */
   public static final IndexInRange minAndLength(Invert invert_dontIfNull, int min, Collection<? extends Object> coll_forSize, String min_name, String coll_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull),
         min, CollectionUtil.getSizeCrashIfNull(coll_forSize, coll_name), min_name, coll_name);
   }
   /**
      <p>Create a new instance with the maximum set to a primitive array's length.</p>

    * @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
    * @return  <code>{@link #length(Invert, int, String) length}(
         <br/> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen, array_name, null),
         <br/> &nbsp; &nbsp; array_name)))</code>
    */
   public static final IndexInRange primitiveArrayLength(Invert invert_dontIfNull, Object primitiveArray_forLen, String array_name)  {
      return  length(getInvNoIfNull(invert_dontIfNull),
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         array_name);
   }
   /**
      <p>Create a new instance with the maximum set to a primitive array's length.</p>

    * @param  primitiveArray_forLen  May not be {@code null}, and must be a primitive array.
    * @return  <code>{@link #minAndLength(Invert, int, int, String, String) minAndLength}(min,
      <br/> &nbsp; &nbsp; {@link com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil}.{@link ObjThatIsPrimitiveArrayUtil#getLengthFromUnknownAsObject(Object) getLengthFromUnknownAsObject}(primitiveArray_forLen),
      <br/> &nbsp; &nbsp; min_name, array_name)</code>
    */
   public static final IndexInRange minAndPArrayLength(Invert invert_dontIfNull, int min, Object primitiveArray_forLen, String min_name, String array_name)  {
      return  minAndLength(getInvNoIfNull(invert_dontIfNull), min,
         ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(primitiveArray_forLen, array_name, null),
         min_name, array_name);
   }
      private static final Invert getInvNoIfNull(Invert invert_dontIfNull)  {
         return  ((invert_dontIfNull != null) ? invert_dontIfNull : Invert.NO);
      }
   private NewIndexInRangeFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
}
