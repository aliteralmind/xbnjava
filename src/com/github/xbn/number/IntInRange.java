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
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.lang.Invert;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.XInfoAccumulator;
   import  java.util.Objects;
   import  static com.github.xbn.lang.CrashIfBase.*;
/**
 * <p>Determines if an int is within an {@code IntRange}.</p>
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public class IntInRange extends NumberInRange<Integer> implements IntRange  {
   /**
    * <p>An {@code LengthInRange} with no bounds.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>new {@link #IntInRange() IntInRange}()</code></p>
    */
   public static final IntInRange UNRESTRICTED = new IntInRange();
   /**
    * <p>An {@code LengthInRange} with no members.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>new {@link #IntInRange(Invert, IntBound, IntBound) IntInRange}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#YES YES}, null, null</code></p>
    */
   public static final IntInRange IMPOSSIBLE = new IntInRange(Invert.YES, null, null);
//constructors...START
   /**
    * <p>Create a new unrestricted instance.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; {@link NumberInRange#NumberInRange super}{@code ()}</p>
    * @see  #IntInRange(IntBound, IntBound) IntInRange(nb,nb)
    */
   public IntInRange()  {
      super();
   }
   /**
    * <p>Create a new instance with bounds.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #IntInRange(int, int, String, String) this}(min, max, null, null)</code></p>
    */
   public IntInRange(int min, int max)  {
      this(min, max, null, null);
   }
   /**
    * <p>Create a new instance with bounds.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #IntInRange(IntBound, IntBound) this}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), new IntBoundInclusive(max, max_name))</code></p>
    */
   public IntInRange(int min, int max, String min_name, String max_name)  {
      this(new IntBoundInclusive(min, min_name), new IntBoundInclusive(max, max_name));
   }
   /**
    * <p>Create a new instance with bounds.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; {@link NumberInRange#NumberInRange(NumberBound, NumberBound) super}{@code (min, max)}</p>
    */
   public IntInRange(IntBound min, IntBound max)  {
      super(min, max);
   }
   /**
    * <p>Create a new instance with bounds and invert setting.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #IntInRange(Invert, int, int, String, String) this}(invert, min, max, null, null)</code></p>
    */
   public IntInRange(Invert invert, int min, int max)  {
      this(invert, min, max, null, null);
   }
   /**
    * <p>Create a new instance with bounds and invert setting.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #IntInRange(Invert, IntBound, IntBound) this}(invert, new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), new IntBoundInclusive(max, max_name))</code></p>
    */
   public IntInRange(Invert invert, int min, int max, String min_name, String max_name)  {
      this(invert, new IntBoundInclusive(min, min_name), new IntBoundInclusive(max, max_name));
   }
   /**
    * <p>Create a new instance with bounds and invert setting.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; {@link NumberInRange#NumberInRange(Invert, NumberBound, NumberBound) super}{@code (invert, min, max)}</p>
    * @see  #IntInRange()
    * @see  #IntInRange(int, int) IntInRange(i,i)
    * @see  #IntInRange(Invert, int, int) IntInRange(inv,i,i)
    * @see  #IntInRange(int, int, String, String) IntInRange(i,i,s,s)
    * @see  #IntInRange(Invert, int, int, String, String) IntInRange(inv,i,i,s,s)
    * @see  #IntInRange(IntBound, IntBound) IntInRange(ib,ib)
    */
   public IntInRange(Invert invert, IntBound min, IntBound max)  {
      super(invert, min, max);
   }
//constructors...END
//setters...START
/*
   public IntInRange extraErrInfo(Object info)  {
      setExtraErrInfo(info);
      return  this;
   }
 */
   /**
    * <p>If the bounds of this {@code IntInRange} are invalid, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>IntInRange.{@link #crashIfBadBounds(IntBound, IntBound, String, String, Object) crashIfBadBounds}({@link com.github.xbn.number.NumberInRange#getMinBound() getMinBound}(), {@link com.github.xbn.number.NumberInRange#getMaxBound() getMaxBound}, &quot;getMinBound()&quot;, &quot;getMaxBound()&quot;,
    * <br/> &nbsp; &nbsp; {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}())</code></p>
    */
   public void crashIfBadBoundsForCnstr()  {
      IntInRange.crashIfBadBounds(getMinBound(), getMaxBound(),
         "getMinBound()", "getMaxBound()", getExtraErrInfo());
   }
//setters...END
//getters...START
//getters: atomic...START
   public IntBound getMinBound()  {
      return  (IntBound)super.getMinBound();
   }
   public IntBound getMaxBound()  {
      return  (IntBound)super.getMaxBound();
   }
   /**
    * <p>Get the minimum bound int.</p>
    * @return   <code><i>[{@link NumberInRange super}]</i>.{@link NumberInRange#getMinNumber() getMinNumber}().intValue()</code>
    * @see  #getMax()
    */
   public int getMin()  {
      return  getMinNumber().intValue();
   }
   /**
    * <p>Get the maximum bound int.</p>
    * @return   <code><i>[{@link NumberInRange super}]</i>.{@link NumberInRange#getMaxNumber() getMaxNumber}().intValue()</code>
    * @see  #getMin()
    */
   public int getMax()  {
      return  getMaxNumber().intValue();
   }
   /**
    * @return <blockquote><pre>new {@link IntInRange#IntInRange(com.github.xbn.lang.Invert, int, int) IntInRange}({@link Invert}.{@link Invert#getForBoolean(boolean) getForBoolean}(!{@link NumberInRange.html#isInverted() isInverted}()),
    *    {@link #getMinBound()}(), {@link #getMaxBound()}()</pre></blockquote>
    */
   public IntInRange getInvertedCopy()  {
      return  new IntInRange(Invert.getForBoolean(!isInverted()),
                             getMinBound(), getMaxBound());
   }
   public NumberInRange<Integer> getIntersection(NumberInRange<Integer> to_intersectWith)  {
      if(!doesOverlap(to_intersectWith))  {
         return  null;
      }

      IntBound highestMinBound = null;
      try  {
         if(!to_intersectWith.hasMin())  {
            highestMinBound = (!hasMin() ? null
               :  new IntBoundInclusive(getMinBound().get(), null));
         }  else if(!hasMin())  {
            highestMinBound = (!to_intersectWith.hasMin() ? null
               :  new IntBoundInclusive(to_intersectWith.getMinBound().get(), null));
         }  else  {
            iasxIfDiffInclsivities("in", "intersect", getMinBound(),
               to_intersectWith.getMinBound());
            Inclusive incl = Inclusive.getForBoolean(getMinBound().isInclusive());
            int tiwMinIncl = to_intersectWith.getMinGivenIncl();
            int num = ((tiwMinIncl < getMinGivenIncl()) ? getMinGivenIncl() : tiwMinIncl);
            if(incl.isNo())  {
               //Both bounds exist, and they're both inclusive
               num--;
            }
            highestMinBound = new IntBound(num, incl, null);
         }
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("to_intersectWith");
      }

      IntBound lowestMaxBound = null;
      try  {
         if(!to_intersectWith.hasMax())  {
            lowestMaxBound = (!hasMax() ? null
               :  new IntBoundInclusive(getMaxBound().get(), null));
         }  else if(!hasMax())  {
            lowestMaxBound = (!to_intersectWith.hasMax() ? null
               :  new IntBoundInclusive(to_intersectWith.getMaxBound().get(), null));
         }  else  {
            iasxIfDiffInclsivities("ax", "intersect", getMaxBound(),
               to_intersectWith.getMaxBound());
            Inclusive incl = Inclusive.getForBoolean(getMaxBound().isInclusive());
            int tiwMaxIncl = to_intersectWith.getMaxGivenIncl();
            int num = ((getMaxGivenIncl() < tiwMaxIncl) ? getMaxGivenIncl() : tiwMaxIncl);
            if(incl.isNo())  {
               //Both bounds exist, and they're both inclusive
               num++;
            }
            lowestMaxBound = new IntBound(num, incl, null);
         }
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("to_intersectWith");
      }

      return  new IntInRange(highestMinBound, lowestMaxBound);
   }
   public NumberInRange<Integer> getMerged(NumberInRange<Integer> to_mergeWith,
            OverlapRequired overlap_rqd)  {
      try  {
         if(overlap_rqd.isYes()  &&  !doesOverlap(to_mergeWith))  {
            throw  new IllegalArgumentStateException("to_mergeWith < " +
               to_mergeWith + " > does not overlap *this* < " + this + " >");
         }
      }  catch(NullPointerException npx)  {
         CrashIfObject.nullOrReturnCause(overlap_rqd, "overlap_rqd", null, npx);
      }
      IntBound lowestMinBound = null;
      try  {
         if(!to_mergeWith.hasMin()  ||  !hasMin())  {
            lowestMinBound = null;
         }  else  {
            iasxIfDiffInclsivities("in", "merge", getMinBound(),
               to_mergeWith.getMinBound());
            Inclusive incl = Inclusive.getForBoolean(getMinBound().isInclusive());
            int tiwMinIncl = to_mergeWith.getMinGivenIncl();
            int num = ((getMinGivenIncl() < tiwMinIncl) ? getMinGivenIncl() : tiwMinIncl);
            if(incl.isNo())  {
               //Both bounds exist, and they're both inclusive
               num--;
            }
            lowestMinBound = new IntBound(num, incl, null);
         }
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("to_mergeWith");
      }

      IntBound highestMaxBound = null;
      try  {
         if(!to_mergeWith.hasMax()  ||  !hasMax())  {
            highestMaxBound = null;
         }  else  {
            iasxIfDiffInclsivities("ax", "merge", getMaxBound(),
               to_mergeWith.getMaxBound());
            Inclusive incl = Inclusive.getForBoolean(getMaxBound().isInclusive());
            int tiwMaxIncl = to_mergeWith.getMaxGivenIncl();
            int num = ((tiwMaxIncl < getMaxGivenIncl()) ? getMaxGivenIncl() : tiwMaxIncl);
            if(incl.isNo())  {
               //Both bounds exist, and they're both inclusive
               num++;
            }
            highestMaxBound = new IntBound(num, incl, null);
         }
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("to_mergeWith");
      }

      return  new IntInRange(lowestMinBound, highestMaxBound);
   }
      private void iasxIfDiffInclsivities(String in_ax, String mrg_intr,
               NumberBound<Integer> this_bound, NumberBound<Integer> that_bound)  {
         if(this_bound.isInclusive() != that_bound.isInclusive())  {
            throw  new IllegalArgumentStateException("getM" + in_ax +
               "Bound().isInclusive() (" + this_bound.isInclusive() +
               ") is different than to_" + mrg_intr + "With.getM" + in_ax +
               "Bound().isInclusive().");
         }
      }
//other...START
   public boolean isValidInclusiveRange(Integer min, Integer max)  {
      try  {
         return  ((min.compareTo(max) <= 0)  &&     //min <= max
            isIn(min)  &&  isIn(max));
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(min, "min");
         throw  CrashIfObject.nullOrReturnCause(max, "max", null, rx);
      }
   }
   public boolean isValidInclusiveRange(int min, int max)  {
      return  isValidInclusiveRange((new Integer(min)), (new Integer(max)));
   }



   public boolean isGTOEMinGivenIncl(Integer num)  {
      return  (getInclMinComparedTo(num) <= 0);
   }
   public boolean isLTOEMaxGivenIncl(Integer num)  {
      return  (getInclMaxComparedTo(num) >= 0);
   }
   public Integer getInclMinComparedToOrIfNoMin(Integer I_toCompare, Integer I_ifNoMin)  {
      return  (hasMin()
         ?  getInclMinComparedTo(I_toCompare)
         :  I_ifNoMin);
   }
   public Integer getInclMaxComparedToOrIfNoMax(Integer I_toCompare, Integer I_ifNoMax)  {
      return  (hasMax()
         ?  getInclMaxComparedTo(I_toCompare)
         :  I_ifNoMax);
   }
   /**
    * <p>If a range's min is greater than max, or either are outside of the
    * bounds <i>as configured in this class</i>, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #crashIfBadRange(int, int, String, String) crashIfBadRange}(min, max, &quot;min&quot;, &quot;max&quot;)</code></p>
    */
   public void crashIfBadRange(int min, int max)  {
      crashIfBadRange(min, max, "min", "max");
   }
   /**
    * <p>If a range's min is greater than max, or either are outside of the
    * bounds <i>as configured in this class</i>, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>IntInRange.{@link #crashIfBadRange(IntInRange, int, int, String, String, Object) crashIfBadRange}(this, min, max, min_name, max_name,
    * <br/> &nbsp; &nbsp; &nbsp; &nbsp; {@link com.github.xbn.lang.AbstractExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}()*)</code></p>
    */
   public void crashIfBadRange(int min, int max, String min_name, String max_name)  {
      IntInRange.crashIfBadRange(this, min, max, min_name, max_name,
         getExtraErrInfo());
   }
   public void crashIfBadValue(int num, String int_objName)  {
      crashIfBadIntObject(num, int_objName);
   }
   /**
    * <p>If a standalone-int is invalid, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>IntInRange.{@link #crashIfBadIntObject(IntInRange, Integer, String) crashIfBadIntObject}(this, num, int_objName)</code></p>
    */
   public void crashIfBadIntObject(Integer num, String int_objName)  {
      IntInRange.crashIfBadIntObject(this, num, int_objName);
   }
   /**
    * <p>If an int (as contained by an object) <i>that is an element of a
    * larger object</i> is invalid, crash.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #crashIfBadIntElement(IntInRange, Integer, String, int) crashIfBadIntElement}(this, num, cntr_name, idx_inCntr)</code></p>
    */
   public void crashIfBadIntElement(Integer num, String cntr_name, int idx_inCntr)  {
      IntInRange.crashIfBadIntElement(this, num, cntr_name, idx_inCntr);
   }
   protected RuleType getRuleTypeFromBoundsForLenIdx()  {
      return  ((getMinBound().get() == 0  &&  getMaxBound() == null)
         ?  (isInverted() ? RuleType.IMPOSSIBLE : RuleType.UNRESTRICTED)
         :  RuleType.RESTRICTED);
   }
   public boolean areFieldsEqual(NumberInRange<Integer> to_compareTo)  {
      try  {
         return  (Objects.equals(to_compareTo.getMinBound(), getMinBound())  &&
            Objects.equals(to_compareTo.getMaxBound(), getMaxBound())  &&
            to_compareTo.isInverted() == isInverted());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_compareTo, "to_compareTo", null, rx);
      }
   }
   public boolean areFieldsEqual(IntInRange to_compareTo)  {
      return  areFieldsEqual((NumberInRange<Integer>)to_compareTo);
   }
//other...END
//static...START
   /**
    * <p>If the bounds are not valid, crash.</p>
    *
    * <p>If either {@code min} or {@code max} are {@code null}, this
    * <i><b>exits</b></i>. Otherwise, if...<ul>
    *    <li>both <code>min.{@link NumberBound#isInclusive() isInclusive}()</code>
    *    and {@code max.isInclusive()} are {@code true}, then
    *    <code>min.{@link IntBoundInclusive#getInt() getInt}()</code> may
    *    not be greater than {@code max.getInt()}</li>
    *    <li>exactly one of {@code min.isInclusive()} or
    *    {@code max.isInclusive()} is {@code false}, then
    *    {@code min.getInt()} may not be greater than
    *    {@code (max.getInt() - 1)}</li>
    *    <li>both {@code min.isInclusive()} and {@code max.isInclusive()}
    *    are {@code false}, then {@code min.getInt()} may not be greater
    *    than {@code (max.getInt() - 2)}</li>
    *    <li>either (or both) {@code min} or {@code max} are {@code null},
    *    then (when non-{@code null}) there are no restrictions on
    *    {@code min.getInt()} (or {@code max.getInt()}).</li>
    * </ul></p>
    * @exception  IllegalArgumentStateException  If both bounds are non-{@code null}, and violated the above rules are violated.
    * @see  #crashIfBadBoundsForLength(IntBoundInclusive, IntBound, String, String, Object) crashIfBadBoundsForLength(ibi,nb,s,s,o)
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="NumberInRange.html#isIn(N)">isIn</a>(N)*</code>
    */
   public static final void crashIfBadBounds(IntBound min, IntBound max,
            String min_name, String max_name, Object xtra_errInfo)  {
      if(min == null  ||  max == null)  {
         return;
      }
      int iAway = (min.isInclusive() ? 0 : 1) + (max.isInclusive() ? 0 : 1);
      if(min.get() > (max.get() - iAway))  {
         String sMid = ((min.isInclusive()  &&  max.isInclusive()) ?  "."
            :  " minus " + iAway + " (max.get()-" + iAway + "=" +
               (max.get() - iAway) + ").");
         String sMsg = "Both " + min_name + " and " + max_name +
            " are non-null, but " + min_name + ".get() (" + min.get() +
               ") is greater than " + max_name + ".get() (" + max.get() + ")" +
               sMid;
         throw  new IllegalArgumentStateException(getXMsg(sMsg,
            XInfoAccumulator.getAddedOrNew(xtra_errInfo,
            min_name + ".isInclusive()=" + min.isInclusive() + ", " + max_name +
            ".isInclusive()=" + max.isInclusive())));
      }
   }
   /**
    * <p>If the bounds needed by {@code LengthInRange} or {@code IndexInRange}
    * are not valid, crash.</p>
    *
    * <p>In addition to the requirements of
    * {@link #crashIfBadBounds(IntBound, IntBound, String, String, Object) crashIfBadBounds},
    * the minimum bound must be non-{@code null} and
    * greater-than-or-equal-to zero.</p>
    */
   protected static final void crashIfBadBoundsForLength(IntBoundInclusive min,
            IntBound max, String min_name, String max_name, Object xtra_errInfo)  {
      try  {
         if(min.getInt() < 0)  {
            throw  new IllegalArgumentException("Min less than zero: " + min);
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(min, "min", null, rx);
      }
      if(!min.isInclusive())  {
         throw  new IllegalArgumentException("Min not inclusive: " + min);
      }
      crashIfBadBounds(min, max, min_name, max_name, xtra_errInfo);
   }
   /**
    * <p>If a standalone int is invalid, crash. The only difference between
    * this and {@link #crashIfBadIntElement(IntInRange, Integer, String, int) crashIfBadIntObject}{@code (iir,I,s,i)}
    * is the format of the potential error message.</p>
    * @param  int_objName  For example, &quot;{@code aString.length}&quot; or &quot;{@code coll.size()}&quot;. <i>Should</i> not be {@code null} or empty.
    * @exception  IllegalArgumentException  If
    * <br/> &nbsp; &nbsp; <code>range.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="NumberInRange.html#isIn(N)">isIn</a>(num)*</code>
    * <br/>is {@code false}.
    * @see  #crashIfBadIntObject(Integer, String) crashIfBadIntObject(I,s)
    */
   public static final void crashIfBadIntObject(IntInRange range, Integer num, String int_objName)  {
      boolean bValid = false;
      try  {
         bValid = range.isIn(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", range.getExtraErrInfo(), rx);
      }
      if(!bValid)  {
         throw  new IllegalArgumentException(
            getXMsg(int_objName + " (" + num + ") is invalid according to the rules: " + range.getRules(), range.getExtraErrInfo()));
      }
   }
   /**
    * <p>If an int (as contained by an object) <i>that is an element of a
    * larger object</i> is invalid, crash. The only difference between this
    * and {@link #crashIfBadIntObject(IntInRange, Integer, String) crashIfBadIntObject}{@code (iir,I,s)}
    * is the format of the potential error message.</p>
    * @param  cntr_name  The name of the container (string, array,
    * collection, etc.) in which the int is an element.
    * @param  idx_inCntr  The element index at which the int resides.
    * @exception  IllegalArgumentException  If
    * <code>range.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="NumberInRange.html#isIn(N)">isIn</a>(num)</code>
    * is {@code false}.
    * @see  #crashIfBadIntElement(Integer, String, int) crashIfBadIntElement(I,s,i)
    */
   public static final void crashIfBadIntElement(IntInRange range, Integer num, String cntr_name, int idx_inCntr)  {
      boolean bValid = false;
      try  {
         bValid = range.isIn(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", range.getExtraErrInfo(), rx);
      }
      if(!bValid)  {
         throw  new IllegalArgumentException(
            getXMsg("Element " + idx_inCntr + " in " + cntr_name +
               " (" + num + ") is invalid according to the rules: " + range.getRules(), range.getExtraErrInfo()));
      }
   }
   /**
    * <p>If a range's min is greater than max, or either are outside of the
    * bounds <i>as configured in this class</i>, crash.</p>
    * @param  min  Range-minimum to test.
    * @param  max  Range-maximum to test.
    * @param  range  The rules to test for. May not be {@code null}.
    * @param  min_name  Descriptive name of {@code min}. <i>Should</i> not
    * be {@code null} or empty.
    * @param  max_name  Descriptive name of {@code max}
    * @exception  IllegalArgumentException  If {@code min} is less than
    * {@link #getMin() getMin}{@code ()}, or {@code max} is greater than
    * {@link #getMax() getMax}{@code ()} (unless {@code getMax()} is
    * {@code -1}, in which case there is no maximum restriction).
    * @exception  IllegalArgumentStateException  If {@code min} is greater
    * than {@code max}.
    * @see  #crashIfBadRange(int, int) crashIfBadRange(i,i)
    * @see  #crashIfBadRange(int, int, String, String) crashIfBadRange(i,i,s,s)
    */
   public static final void crashIfBadRange(IntInRange range, int min, int max, String min_name, String max_name, Object xtra_errInfo)  {
      if(min < range.getMin())  {
         throw  new IllegalArgumentException(getXMsg(min_name + " (" + min + ") is less than range.getMin() (" + range.getMin() + ")", xtra_errInfo));
      }
      if(range.getMax() != -1  &&  max > range.getMax())  {
         throw  new IllegalArgumentException(getXMsg(max_name + " (" + max + ") is greater than range.getMax() (" + range.getMax() + ")", xtra_errInfo));
      }
      if(min > max)  {
         throw  new IllegalArgumentStateException(getXMsg(min_name + " (" + min + ") is greater than " + max_name + " (" + max + ")", xtra_errInfo));
      }
   }
//static...END
}
