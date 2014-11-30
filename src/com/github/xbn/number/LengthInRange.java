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
   import  com.github.xbn.list.CollectionUtil;
   import  com.github.xbn.text.StringUtilBase;
   import  com.github.xbn.array.ArrayUtil;
   import  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil;
   import  java.util.Collection;
/**
   <p>Determines if a length is within a {@code LengthRange}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class LengthInRange extends IntInRange implements LengthRange  {
//public
   /**
      <p>An {@code LengthInRange} with no bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>new {@link #LengthInRange() LengthInRange}()</code></p>
    **/
   public static final LengthInRange UNRESTRICTED = new LengthInRange();
   /**
      <p>An {@code LengthInRange} with no members.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>new {@link #LengthInRange(Invert, int, String, IntBound) LengthInRange}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#YES YES}, 0, null, null)</code></p>
    **/
   public static final LengthInRange IMPOSSIBLE = new LengthInRange(Invert.YES, 0, null, null);
   /**
      <p>An instance in which only zero is bad--Equal to <code>new #LengthInRange(int, String, IntBoundInclusive)(1, null, null)</code></p>
    **/
   public static final LengthInRange GREATER_THAN_ZERO = new LengthInRange(1, null, null);
   /**
      <p>An instance in which only zero is good--Equal to <code>new #LengthInRange(int, String, IntBound)(0, null, new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(0, null))</code></p>
    **/
   public static final LengthInRange ZERO_ONLY = new LengthInRange(0, null, new IntBoundInclusive(0, null));
   /**
      <p>Create an instance with no maximum bound.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #LengthInRange(int, String, IntBound) this}(0, null, null)</code></p>

      @see  #UNRESTRICTED
    **/
   public LengthInRange()  {
      this(0, null, null);
   }
   /**
      <p>Create a new instance with bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link LengthInRange#LengthInRange(int, int, String, String) this}(min, max_exclusive, null, null)</code></p>
    **/
   public LengthInRange(int min, int max_exclusive)  {
      this(min, max_exclusive, null, null);
   }
   /**
      <p>Create a new instance with bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link LengthInRange#LengthInRange(Invert, int, int, String, String) this}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, min, max_exclusive, min_name, max_name)</code></p>
    **/
   public LengthInRange(int min, int max_exclusive, String min_name, String max_name)  {
      this(Invert.NO, min, max_exclusive, min_name, max_name);
   }
   /**
      <p>Create a new instance with bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link LengthInRange#LengthInRange(Invert, int, int, String, String) this}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, min, min_name, max_bound)</code></p>
    **/
   public LengthInRange(int min, String min_name, IntBound max_bound)  {
      this(Invert.NO, min, min_name, max_bound);
   }
   /**
      <p>Create a new instance with bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link LengthInRange#LengthInRange(Invert, IntBoundInclusive, IntBound) this}{@code ({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, min_bound, max_bound)}</p>
    **/
   public LengthInRange(IntBoundInclusive min_bound, IntBound max_bound)  {
      this(Invert.NO, min_bound, max_bound);
   }
   /**
      <p>Create a new instance with bounds and invert-setting.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link LengthInRange#LengthInRange(Invert, int, int, String, String) this}(invert, min, max_exclusive, null, null)</code></p>
    **/
   public LengthInRange(Invert invert, int min, int max_exclusive)  {
      this(invert, min, max_exclusive, null, null);
   }
   /**
      <p>Create a new instance with bounds and invert setting.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link LengthInRange#LengthInRange(Invert, int, String, IntBound) this}(invert, min, min_name, new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max_exclusive, max_name))</code></p>
    **/
   public LengthInRange(Invert invert, int min, int max_exclusive, String min_name, String max_name)  {
      this(invert, min, min_name, new IntBoundExclusive(max_exclusive, max_name));
   }
   /**
      <p>Create a new instance with bounds and invert-setting.</p>
    **/
   public LengthInRange(Invert invert, int min, String min_name, IntBound max_bound)  {
      this(invert, new IntBoundInclusive(min, min_name), max_bound);
   }
   /**
      <p>Create a new instance with bounds and invert-setting.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link IntInRange#IntInRange(Invert, IntBound, IntBound) super}{@code (invert, min_bound, max_bound)}</p>

      @see  #LengthInRange() this()
      @see  #LengthInRange(int, int) this(i,i)
      @see  #LengthInRange(int, int, String, String) this(i,i,s,s)
      @see  #LengthInRange(int, String, IntBound) this(i,s,ib)
      @see  #LengthInRange(IntBoundInclusive, IntBound) this(ibi,ib)
      @see  #LengthInRange(Invert, int, int) this(inv,i,i)
      @see  #LengthInRange(Invert, int, int, String, String) this(inv,i,i,s,s)
      @see  #LengthInRange(Invert, int, String, IntBound) this(inv,i,s,ib)
    **/
   public LengthInRange(Invert invert, IntBoundInclusive min_bound, IntBound max_bound)  {
      super(invert, min_bound, max_bound);
   }
   /**
      <p>If the bounds of this {@code LengthInRange} are invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>IntInRange.{@link #crashIfBadBoundsForLength(IntBoundInclusive, IntBound, String, String, Object) crashIfBadBoundsForLength}({@link com.github.xbn.number.NumberInRange#getMinBound() getMinBound}(), {@link com.github.xbn.number.NumberInRange#getMaxBound() getMaxBound}, &quot;getMinBound()&quot;, &quot;getMaxBound()&quot;, {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}())</code></p>
    **/
   public void crashIfBadBoundsForCnstr()  {
      IntInRange.crashIfBadBoundsForLength(getMinBound(), getMaxBound(), "getMinBound()", "getMaxBound()", getExtraErrInfo());
   }
   public IntBoundInclusive getMinBound()  {
      return  (IntBoundInclusive)super.getMinBound();
   }
   public IntBound getMaxBound()  {
      return  (IntBound)super.getMaxBound();
   }
   public void crashIfBadValue(int index, String idx_name)  {
      crashIfBadContainer(index, idx_name);
   }
   public LengthInRange getInvertedCopy()  {
      return  new LengthInRange(Invert.getForBoolean(!isInverted()), getMinBound(), getMaxBound());
   }
   /**
      <p>If a container's length is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp;  <code><i>[{@link IntInRange super}]</i>.{@link IntInRange#crashIfBadIntObject(Integer, String) crashIfBadIntObject}(length, cntr_name)</code></p>
    **/
   public void crashIfBadContainer(int length, String cntr_name)  {
      crashIfBadIntObject(length, cntr_name);
   }
   /**
      <p>If a string's length is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainer}{@code (text.toString().length(), cntr_name)}</p>

      @param  text  May not be {@code null}.
      @see  #crashIfBadContainer(int, String)
    **/
   public void crashIfBadString(Object text, String cntr_name)  {
      crashIfBadContainer(text.toString().length(), cntr_name);
   }
   /**
      <p>If an array's length is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainerLength}{@code (array.length, cntr_name)}</p>

      @param  array  May not be {@code null}.
      @see  #crashIfBadContainer(int, String)
    **/
   public <E> void crashIfBadArray(E[] array, String cntr_name)  {
      crashIfBadContainer(ArrayUtil.getLengthCrashIfNull(array, "array"), cntr_name);
   }
   /**
      <p>If a collection's size is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainerLength}{@code (coll.size(), cntr_name)}</p>

      @param  coll  May not be {@code null}.
      @see  #crashIfBadContainer(int, String) crashIfBadContainer(i,s)
    **/
   public void crashIfBadCollection(Collection<?> coll, String cntr_name)  {
      crashIfBadContainer(CollectionUtil.getSizeCrashIfNull(coll, cntr_name), cntr_name);
   }
   /**
      <p>If a primitive array's length is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadContainer(int, String) crashIfBadContainerLength}{@code (coll.size(), cntr_name)}</p>

      @param  objThatIs_primArray  May not be {@code null}, and must be a primitive array.
      @see  #crashIfBadContainer(int, String)
    **/
   public void crashIfBadPArray(Object objThatIs_primArray, String cntr_name)  {
      crashIfBadContainer(ObjThatIsPrimitiveArrayUtil.getLengthFromUnknownAsObject(objThatIs_primArray, cntr_name, getExtraErrInfo()), cntr_name);
   }
   /**
      <p>If an element's length is invalid, crash. The only difference between this and {@code crashIfBadContainer(i,s,s,o)} is the potential error message.</p>

      <!-- MAIN FUNCTION -->
      <p>Equal to
      <br/> &nbsp; &nbsp;  <code><i>[{@link IntInRange super}]</i>.{@link IntInRange#crashIfBadIntElement(Integer, String, int) crashIfBadIntElement}(length, cntr_name, idx_inCntr)</code></p>
    **/
   public void crashIfBadElement(int length, String cntr_name, int idx_inCntr)  {
      crashIfBadIntElement(length, cntr_name, idx_inCntr);
   }
   /**
      <p>If the length of a string <i>that is an element in a larger container</i> is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadElement(int, String, int) crashIfBadElementLength}{@code (text.toString().length(), cntr_name, idx_inCntr)}</p>

      @param  text  May not be {@code null}.
      @see  #crashIfBadElement(int, String, int) crashIfBadElement(i,s,i)
    **/
   public void crashIfBadStringElement(Object text, String cntr_name, int idx_inCntr)  {
      crashIfBadElement(StringUtilBase.getLengthCrashIfNull(text, cntr_name), cntr_name, idx_inCntr);
   }
   /**
      <p>If the length of an array <i>that is an element in a larger container</i> is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadElement(int, String, int) crashIfBadElement(array.length, cntr_name, idx_inCntr)}</p>

      @param  array  May not be {@code null}.
      @see  #crashIfBadElement(int, String, int) crashIfBadElement(i,s,i)
    **/
   public <E> void crashIfBadArrayTIAElement(E[] array, String cntr_name, int idx_inCntr)  {
      crashIfBadElement(ArrayUtil.getLengthCrashIfNull(array, cntr_name), cntr_name, idx_inCntr);
   }
   /**
      <p>If the length of a {@code java.util.Collection} <i>that is an element in a larger container</i> is invalid, crash.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #crashIfBadElement(int, String, int) crashIfBadElementLength}{@code (coll.size(), cntr_name, idx_inCntr)}</p>

      @param  coll  May not be {@code null}.
      @see  #crashIfBadElement(int, String, int) crashIfBadElement(i,s,i)
    **/
   public void crashIfBadCollectionTIAElement(Collection<?> coll, String cntr_name, int idx_inCntr)  {
      crashIfBadElement(coll.size(), cntr_name, idx_inCntr);
   }
   protected RuleType getRuleTypeFromBounds()  {
      return  getRuleTypeFromBoundsForLenIdx();
   }
}
