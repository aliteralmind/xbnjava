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
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.Invert;
   import  com.github.xbn.lang.CrashIfObject;
   import  static com.github.xbn.lang.CrashIfBase.*;

/**
   <p>Determines if an index is within an {@code IndexRange}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class IndexInRange extends IntInRange implements IndexRange  {
//public
   /**
      <p>An {@code IndexInRange} with no bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>new {@link #IndexInRange() IndexInRange}()</code></p>
    */
   public static final IndexInRange UNRESTRICTED = new IndexInRange();
   /**
      <p>An {@code IndexInRange} with no members.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>new {@link #IndexInRange(Invert, com.github.xbn.number.IntBoundInclusive, com.github.xbn.number.IntBoundExclusive) IndexInRange}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#YES YES}, new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(0, null), null</code></p>
    */
   public static final IndexInRange IMPOSSIBLE = new IndexInRange(Invert.YES, new IntBoundInclusive(0, null), null);
   /**
      <p>Create a new instance with no bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #IndexInRange(com.github.xbn.number.IntBoundInclusive, com.github.xbn.number.IntBoundExclusive) this}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(0, null), null)</code></p>

      @see  #UNRESTRICTED
    */
   public IndexInRange()  {
      this(new IntBoundInclusive(0, null), null);
   }
   /**
      <p>Create a new instance with bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link IntInRange#IntInRange(com.github.xbn.number.IntBound, com.github.xbn.number.IntBound) super}(new IntBoundInclusive(min, null), new IntBoundExclusive(max, null)</code></p>
    */
   public IndexInRange(int min, int max)  {
      super(new IntBoundInclusive(min, null), new IntBoundExclusive(max, null));
   }
   /**
    * <p>Create a new instance with bounds.</p>
    *
    * <p>Equal to
    * <blockquote><pre>{@link IntInRange#IntInRange(com.github.xbn.number.IntBound, com.github.xbn.number.IntBound) super}(new IntBoundInclusive(min, min_name),
    *    new IntBoundExclusive(max, max_name))</pre></blockquote></p>
    */
   public IndexInRange(int min, int max, String min_name, String max_name)  {
      super(new IntBoundInclusive(min, min_name),
         new IntBoundExclusive(max, max_name));
   }
   /**
      <p>Create a new instance.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link IntInRange#IntInRange(com.github.xbn.number.IntBound, com.github.xbn.number.IntBound) super}{@code (min_bound, max_bound)}</p>
    */
   public IndexInRange(IntBoundInclusive min_bound, IntBoundExclusive max_bound)  {
      super(min_bound, max_bound);
   }
   /**
      <p>Create a new instance with bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link IntInRange#IntInRange(com.github.xbn.lang.Invert, com.github.xbn.number.IntBound, com.github.xbn.number.IntBound) super}(invert, new IntBoundInclusive(min, null), new IntBoundExclusive(max, null)</code></p>
    */
   public IndexInRange(Invert invert, int min, int max)  {
      super(invert, new IntBoundInclusive(min, null), new IntBoundExclusive(max, null));
   }
   /**
      * <p>Create a new instance with bounds.</p>
      *
      * <p>Equal to
      * <blockquote><pre>{@link IntInRange#IntInRange(com.github.xbn.lang.Invert, com.github.xbn.number.IntBound, com.github.xbn.number.IntBound) super}(invert, new IntBoundInclusive(min, min_name),
      *    new IntBoundExclusive(max, max_name))</pre></blockquote></p>
    */
   public IndexInRange(Invert invert, int min, int max, String min_name, String max_name)  {
      super(invert, new IntBoundInclusive(min, min_name),
         new IntBoundExclusive(max, max_name));
   }
   /**
      <p>Create a new instance.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link IntInRange#IntInRange(com.github.xbn.lang.Invert, IntBound, IntBound) super}{@code (invert, min_bound, max_bound)}</p>

      @see  #IndexInRange()
      @see  #IndexInRange(int, int) IndexInRange(i,i)
      @see  #IndexInRange(Invert, int, int) IndexInRange(inv,i,i)
      @see  #IndexInRange(int, int) IndexInRange(i,i,s,s)
      @see  #IndexInRange(Invert, int, int) IndexInRange(inv,i,i,s,s)
    */
   public IndexInRange(Invert invert, IntBoundInclusive min_bound, IntBoundExclusive max_bound)  {
      super(invert, min_bound, max_bound);
   }
   /**
      <p>If the bounds of this {@code IndexInRange} are invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>IntInRange.{@link #crashIfBadBoundsForLength(IntBoundInclusive, IntBound, String, String, Object) crashIfBadBoundsForLength}({@link com.github.xbn.number.NumberInRange#getMinBound() getMinBound}(), {@link com.github.xbn.number.NumberInRange#getMaxBound() getMaxBound}, &quot;getMinBound()&quot;, &quot;getMaxBound()&quot;, {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}())</code></p>
    */
   public void crashIfBadBoundsForCnstr()  {
      IntInRange.crashIfBadBoundsForLength(getMinBound(), getMaxBound(), "getMinBound()", "getMaxBound()", getExtraErrInfo());
      if(hasMax()  &&  getMaxBound().isInclusive())  {
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
      <p>If a standalone-index is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>IndexInRange.{@link #crashIfBadIndexObject(IndexInRange, Integer, String, Object) crashIfBadIndexObject}(this, index, idx_name, {@link com.github.xbn.lang.AbstractExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}()*)</code></p>
    */
   public void crashIfBadIndexObject(int index, String idx_name)  {
      IndexInRange.crashIfBadIndexObject(this, index, idx_name, getExtraErrInfo());
   }
   /**
      <p>If an index (as contained by an object) <i>that is an element of a larger object</i> is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #crashIfBadIndexElement(IndexInRange, Integer, String, int, Object) crashIfBadIndexElement}(this, index, cntr_name, int idx_inCntr, {@link com.github.xbn.lang.AbstractExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}()*)</code></p>
    */
   public void crashIfBadIndexElement(int index, String cntr_name, int idx_inCntr)  {
      crashIfBadIndexElement(this, index, cntr_name, idx_inCntr, getExtraErrInfo());
   }
   public void crashIfBadIndexRange(int min, int maxusive, String min_name, String max_name)  {
      crashIfBadIndex(min, min_name);
      crashIfBadIndex(maxusive, max_name);
   }
   protected RuleType getRuleTypeFromBounds()  {
      return  getRuleTypeFromBoundsForLenIdx();
   }
   public IndexInRange getInvertedCopy()  {
      return  new IndexInRange(Invert.getForBoolean(!isInverted()), getMinBound(), getMaxBound());
   }
   public static final void crashIfBadIndexObject(IndexInRange range, Integer num, String idx_name, Object xtra_errInfo)  {
      boolean isIn = false;
      try  {
         isIn = range.isIn(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
      if(!isIn)  {
         throw  new IllegalArgumentException(
            getXMsg(idx_name + " (" + num + ") is invalid. rules=[" + range.getRules() + "]", xtra_errInfo));
      }
   }
   public static final void crashIfBadIndexElement(IndexInRange range, Integer num, String cntr_name, int idx_inCntr, Object xtra_errInfo)  {
      boolean isIn = false;
      try  {
         isIn = range.isIn(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
      if(!isIn)  {
         throw  new IllegalArgumentException(
            getXMsg("Element " + idx_inCntr + " in " + cntr_name +
               " (" + num + ") is invalid. rules=[" + range.getRules() + "]. NOTE: If the maximum bound is the length of an object (string, array, collection, etc.), then, for example, \"sMyName=3\" means that the *length* of sMyName is 3.", xtra_errInfo));
      }
   }
}
