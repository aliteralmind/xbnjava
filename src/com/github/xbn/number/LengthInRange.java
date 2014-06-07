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
   import  com.github.xbn.text.StringUtilBase;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  java.util.Collection;
/**
   <P>Determines if a length is within a {@code LengthRange}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LengthInRange extends IntInRange implements LengthRange  {
//public
   /**
      <P>An instance no bounds--Equal to <CODE>new {@link #LengthInRange() LengthInRange}()</CODE></P>
    **/
   public static final LengthInRange UNRESTRICTED = new LengthInRange();
   /**
      <P>An instance in which only zero is bad--Equal to <CODE>new #LengthInRange(IntBoundInclusive, IntBoundInclusive)((new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(1, null)), null)</CODE></P>
    **/
   public static final LengthInRange GREATER_THAN_ZERO = new LengthInRange((new IntBoundInclusive(1, null)), null);
   /**
      <P>An instance in which only zero is good--Equal to <CODE>new #LengthInRange(int, int)(0, 0)</CODE></P>
    **/
   public static final LengthInRange ZERO_ONLY = new LengthInRange(0, 0);
   /**
      <P>Create an instance with no maximum bound.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #LengthInRange(IntBoundInclusive, IntBoundInclusive) this}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(0, null), null)</CODE></P>

      @see  #UNRESTRICTED
    **/
   public LengthInRange()  {
      this(new IntBoundInclusive(0, null), null);
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link IntInRange#IntInRange(int, int) super}(min, max)</CODE></P>
    **/
   public LengthInRange(int min, int max)  {
      super(min, max);
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link IntInRange#IntInRange(int, int, String, String) super}(min, max, min_name, max_name)</CODE></P>
    **/
   public LengthInRange(int min, int max, String min_name, String max_name)  {
      super(min, max, min_name, max_name);
   }
   /**
      <P>Create a new instance.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link IntInRange#IntInRange(IntBound, IntBound) super}{@code (min_bound, max_bound)}</P>

      @see  #LengthInRange()
      @see  #LengthInRange(int, int) LengthInRange(i,i)
      @see  #LengthInRange(LengthInRange) LengthInRange(lir)
    **/
   public LengthInRange(IntBoundInclusive min_bound, IntBoundInclusive max_bound)  {
      super(min_bound, max_bound);
   }
   /**
      <P>Create a new instance as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link IntInRange#IntInRange(IntInRange) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #LengthInRange(IntBoundInclusive, IntBoundInclusive) this(ibi,ibi)
    **/
   public LengthInRange(LengthInRange to_copy)  {
      super(to_copy);
   }
/*
   public LengthInRange extraErrInfo(Object info)  {
      setExtraErrInfo(info);
      return  this;
   }
 */
   /**
      @return  <CODE>(new {@link #LengthInRange(LengthInRange) LengthInRange}(this))</CODE>
    **/
   public LengthInRange getObjectCopy()  {
      return  (new LengthInRange(this));
   }
   /**
      <P>If the bounds of this {@code LengthInRange} are invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>IntInRange.{@link #crashIfBadBoundsForLength(IntBoundInclusive, IntBound, String, String, Object) crashIfBadBoundsForLength}({@link com.github.xbn.number.NumberInRange#getMinBound() getMinBound}(), {@link com.github.xbn.number.NumberInRange#getMaxBound() getMaxBound}, &quot;getMinBound()&quot;, &quot;getMaxBound()&quot;, {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}())</CODE></P>
    **/
   public void crashIfBadBoundsForCnstr()  {
      IntInRange.crashIfBadBoundsForLength(getMinBound(), getMaxBound(), "getMinBound()", "getMaxBound()", getExtraErrInfo());
   }
   public IntBoundInclusive getMinBound()  {
      return  (IntBoundInclusive)super.getMinBound();
   }
   public IntBoundInclusive getMaxBound()  {
      return  (IntBoundInclusive)super.getMaxBound();
   }
   public void crashIfBadValue(int index, String idx_name)  {
      crashIfBadContainer(index, idx_name);
   }
   /**
      <P>If a container's length is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><I>[{@link IntInRange super}]</I>.{@link IntInRange#crashIfBadIntObject(Integer, String) crashIfBadIntObject}(length, cntr_name)</CODE></P>
    **/
   public void crashIfBadContainer(int length, String cntr_name)  {
      crashIfBadIntObject(length, cntr_name);
   }
   /**
      <P>If a string's length is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainer}{@code (text.toString().length(), cntr_name)}</P>

      @param  text  May not be {@code null}.
      @see  #crashIfBadContainer(int, String)
    **/
   public void crashIfBadString(Object text, String cntr_name)  {
      crashIfBadContainer(text.toString().length(), cntr_name);
   }
   /**
      <P>If an array's length is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainerLength}{@code (array.length, cntr_name)}</P>

      @param  array  May not be {@code null}.
      @see  #crashIfBadContainer(int, String)
    **/
   public <E> void crashIfBadArray(E[] array, String cntr_name)  {
      crashIfBadContainer(ArrayUtil.getLengthCrashIfNull(array, "array"), cntr_name);
   }
   /**
      <P>If a collection's size is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainerLength}{@code (coll.size(), cntr_name)}</P>

      @param  coll  May not be {@code null}.
      @see  #crashIfBadContainer(int, String) crashIfBadContainer(i,s)
    **/
   public void crashIfBadCollection(Collection<?> coll, String cntr_name)  {
      crashIfBadContainer(CollectionUtil.getSizeCrashIfNull(coll, cntr_name), cntr_name);
   }
   /**
      <P>If a primitive array's length is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainerLength}{@code (coll.size(), cntr_name)}</P>

      @param  objThatIs_primArray  May not be {@code null}, and must be a primitive array.
      @see  #crashIfBadContainer(int, String)
    **/
   public void crashIfBadPArray(Object objThatIs_primArray, String cntr_name)  {
      crashIfBadContainer(ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(objThatIs_primArray, cntr_name, getExtraErrInfo()), cntr_name);
   }
   /**
      <P>If an element's length is invalid, crash. The only difference between this and {@code crashIfBadContainer(i,s,s,o)} is the potential error message.</P>

      <!-- MAIN FUNCTION -->
      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><I>[{@link IntInRange super}]</I>.{@link IntInRange#crashIfBadIntElement(Integer, String, int) crashIfBadIntElement}(length, cntr_name, idx_inCntr)</CODE></P>
    **/
   public void crashIfBadElement(int length, String cntr_name, int idx_inCntr)  {
      crashIfBadIntElement(length, cntr_name, idx_inCntr);
   }
   /**
      <P>If the length of a string <I>that is an element in a larger container</I> is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadElement(int, String, int) crashIfBadElementLength}{@code (text.toString().length(), cntr_name, idx_inCntr)}</P>

      @param  text  May not be {@code null}.
      @see  #crashIfBadElement(int, String, int) crashIfBadElement(i,s,i)
    **/
   public void crashIfBadStringElement(Object text, String cntr_name, int idx_inCntr)  {
      crashIfBadElement(StringUtilBase.getLengthCrashIfNull(text, cntr_name), cntr_name, idx_inCntr);
   }
   /**
      <P>If the length of an array <I>that is an element in a larger container</I> is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadElement(int, String, int) crashIfBadElement(array.length, cntr_name, idx_inCntr)}</P>

      @param  array  May not be {@code null}.
      @see  #crashIfBadElement(int, String, int) crashIfBadElement(i,s,i)
    **/
   public <E> void crashIfBadArrayTIAElement(E[] array, String cntr_name, int idx_inCntr)  {
      crashIfBadElement(ArrayUtil.getLengthCrashIfNull(array, cntr_name), cntr_name, idx_inCntr);
   }
   /**
      <P>If the length of a {@code java.util.Collection} <I>that is an element in a larger container</I> is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #crashIfBadElement(int, String, int) crashIfBadElementLength}{@code (coll.size(), cntr_name, idx_inCntr)}</P>

      @param  coll  May not be {@code null}.
      @see  #crashIfBadElement(int, String, int) crashIfBadElement(i,s,i)
    **/
   public void crashIfBadCollectionTIAElement(Collection<?> coll, String cntr_name, int idx_inCntr)  {
      crashIfBadElement(coll.size(), cntr_name, idx_inCntr);
   }
}
