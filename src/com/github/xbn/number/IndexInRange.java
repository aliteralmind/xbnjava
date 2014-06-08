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
package  com.github.xbn.number;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.array.ArrayUtil;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  com.github.xbn.text.StringUtilBase;  //Must import Base, otherwise circular dependency
   import  java.util.Collection;

/**
   <P>Determines if an index is within an {@code IndexRange}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IndexInRange extends IntInRange implements IndexRange  {
//public
   /**
      <P>An instance no bounds--Equal to <CODE>new {@link #IndexInRange() IndexInRange}()</CODE></P>
    **/
   public static final IndexInRange UNRESTRICTED = new IndexInRange();
   /**
      <P>Create a new instance with no bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #IndexInRange(IntBoundInclusive, IntBoundExclusive) this}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(0, null), null)</CODE></P>

      @see  #UNRESTRICTED
    **/
   public IndexInRange()  {
      this(new IntBoundInclusive(0, null), null);
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link IntInRange#IntInRange(int, int) super}(min, max)</CODE></P>
    **/
   public IndexInRange(int min, int max)  {
      super(min, max);
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link IntInRange#IntInRange(int, int, String, String) super}(min, max, min_name, max_name)</CODE></P>
    **/
   public IndexInRange(int min, int max, String min_name, String max_name)  {
      super(min, max, min_name, max_name);
   }
   /**
      <P>Create a new {@code IndexInRange}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link IntInRange#IntInRange(IntBound, IntBound) super}{@code (min_bound, max_bound)}</P>

      @see  #IndexInRange()
      @see  #IndexInRange(int, int) IndexInRange(i,i)
      @see  #IndexInRange(IndexInRange) IndexInRange(xir)
    **/
   public IndexInRange(IntBoundInclusive min_bound, IntBoundExclusive max_bound)  {
      super(min_bound, max_bound);
   }
   /**
      <P>Create a new {@code IndexInRange} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link IntInRange#IntInRange(IntInRange) super(to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #IndexInRange(IntBoundInclusive, IntBoundExclusive) this(ibi,ibx)
    **/
   public IndexInRange(IndexInRange to_copy)  {
      super(to_copy);
   }
/*
   public IndexInRange extraErrInfo(Object info)  {
      setExtraErrInfo(info);
      return  this;
   }
 */
   /**
      @return  <CODE>(new {@link #IndexInRange(IndexInRange) IndexInRange}(this))</CODE>
    **/
   public IndexInRange getObjectCopy()  {
      return  (new IndexInRange(this));
   }
   /**
      <P>If the bounds of this {@code IndexInRange} are invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>IntInRange.{@link #crashIfBadBoundsForLength(IntBoundInclusive, IntBound, String, String, Object) crashIfBadBoundsForLength}({@link com.github.xbn.number.NumberInRange#getMinBound() getMinBound}(), {@link com.github.xbn.number.NumberInRange#getMaxBound() getMaxBound}, &quot;getMinBound()&quot;, &quot;getMaxBound()&quot;, {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}())</CODE></P>
    **/
   public void crashIfBadBoundsForCnstr()  {
      IntInRange.crashIfBadBoundsForLength(getMinBound(), getMaxBound(), "getMinBound()", "getMaxBound()", getExtraErrInfo());
      if(getMaxBound().isInclusive())  {
         throw  new IllegalArgumentException("Max not exclusive: " + getMaxBound());
      }
   }
   public IntBoundInclusive getMinBound()  {
      return  (IntBoundInclusive)super.getMinBound();
   }
   public IntBoundExclusive getMaxBound()  {
      return  (IntBoundExclusive)super.getMaxBound();
   }
   public void crashIfBadIndex(int index, String idx_name)  {
      crashIfBadIndexObject(index, idx_name);
   }
   public void crashIfBadValue(int index, String idx_name)  {
      crashIfBadIndexObject(index, idx_name);
   }
   /**
      <P>If a standalone-index is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>IndexInRange.{@link #crashIfBadIndexObject(IndexInRange, Integer, String, Object) crashIfBadIndexObject}(this, index, idx_name, {@link com.github.xbn.lang.AbstractExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}()*)</CODE></P>
    **/
   public void crashIfBadIndexObject(int index, String idx_name)  {
      IndexInRange.crashIfBadIndexObject(this, index, idx_name, getExtraErrInfo());
   }
   /**
      <P>If an index (as contained by an object) <I>that is an element of a larger object</I> is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #crashIfBadIndexElement(IndexInRange, Integer, String, int, Object) crashIfBadIndexElement}(this, index, cntr_name, int idx_inCntr, {@link com.github.xbn.lang.AbstractExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}()*)</CODE></P>
    **/
   public void crashIfBadIndexElement(int index, String cntr_name, int idx_inCntr)  {
      crashIfBadIndexElement(this, index, cntr_name, idx_inCntr, getExtraErrInfo());
   }
   public void crashIfBadIndexRange(int min, int maxusive, String min_name, String max_name)  {
      crashIfBadIndex(min, min_name);
      crashIfBadIndex(maxusive, max_name);
   }
   public static final void crashIfBadIndexObject(IndexInRange range, Integer num, String idx_name, Object xtra_errInfo)  {
      boolean bValid = false;
      try  {
         bValid = range.isValid(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
      if(!bValid)  {
         throw  new IllegalArgumentException(
            getXMsg(idx_name + " (" + num + ") is invalid. rules=[" + range.getRules() + "]", xtra_errInfo));
      }
   }
   public static final void crashIfBadIndexElement(IndexInRange range, Integer num, String cntr_name, int idx_inCntr, Object xtra_errInfo)  {
      boolean bValid = false;
      try  {
         bValid = range.isValid(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
      if(!bValid)  {
         throw  new IllegalArgumentException(
            getXMsg("Element " + idx_inCntr + " in " + cntr_name +
               " (" + num + ") is invalid. rules=[" + range.getRules() + "]. NOTE: If the maximum bound is the length of an object (string, array, collection, etc.), then, for example, \"sMyName=3\" means that the *length* of sMyName is 3.", xtra_errInfo));
      }
   }
}
