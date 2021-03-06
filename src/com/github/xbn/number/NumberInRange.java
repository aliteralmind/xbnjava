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
   import  com.github.xbn.lang.Invert;
   import  com.github.xbn.lang.AbstractExtraErrInfoable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.RuleableComposer;
   import  com.github.xbn.lang.Ruleable;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
 * <p>Determines if a number is within a {@code NumberRange}.</p>
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 */
public abstract class NumberInRange<N extends Number> extends AbstractExtraErrInfoable implements NumberRange<N>, Ruleable  {
//state
   private final NumberBound<N> nbMin     ;
   private final NumberBound<N> nbMax     ;
   private final boolean        isInverted;
   protected final RuleableComposer ruleCmpsr;
//constructors...START
   /**
    * <p>Create a new {@code NumberInRange}.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #NumberInRange(Invert, NumberBound, NumberBound) this}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, null, null)</code></p>
    */
   public NumberInRange()  {
      this(Invert.NO, null, null);
   }
   /**
    * <p>Create a new {@code NumberInRange}.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <code>{@link #NumberInRange(Invert, NumberBound, NumberBound) this}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, nb_min, nb_max)</code></p>
    */
   public NumberInRange(NumberBound<N> nb_min, NumberBound<N> nb_max)  {
      this(Invert.NO, nb_min, nb_max);
   }
   /**
    * <p>Create a new {@code NumberInRange}.</p>
    * @param  nb_min  Get with {@link #getMinBound() getMinBound}{@code (null, null)}
    * @param  nb_max  Get with {@link #getMaxBound() getMaxBound}{@code ()}
    * @param  invert  If {@link com.github.xbn.lang.Invert#YES YES}, then
    * the range is made opposite--If the bounds are one and three, then
    * <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#isIn(N)">isIn</a>(2)</code>
    * will return {@code false}. If {@link com.github.xbn.lang.Invert#NO NO},
    * the range is treated normally ({@code isIn(2)} returns {@code true}).
    * May not be {@code null}. Get with {@link #isInverted() isInverted}{@code ()}.
    * @see  #NumberInRange()
    * @see  #NumberInRange(NumberBound, NumberBound)
    */
   public NumberInRange(Invert invert, NumberBound<N> nb_min, NumberBound<N> nb_max)  {
      super();
      nbMin = nb_min;
      nbMax = nb_max;
      try  {
         isInverted = invert.isYes();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(invert, "invert", null, rx);
      }

      crashIfBadBoundsForCnstr();
      ruleCmpsr = new RuleableComposer(getRuleTypeFromBounds());
   }
//setters...START
   protected RuleType getRuleTypeFromBounds()  {
      return  ((getMinBound() == null  &&  getMaxBound() == null)
         ?  (isInverted() ? RuleType.IMPOSSIBLE : RuleType.UNRESTRICTED)
         :  RuleType.RESTRICTED);
   }
//setters...END
//getters...START
   public final RuleType getRuleType()  {
      return  ruleCmpsr.getRuleType();
   }
   /**
    * <p>Is there a minimum bound?.</p>
    * @return  {@code (getMinBound() != null)}
    * @see  #getMinBound()
    */
   public boolean hasMin()  {
      return  (getMinBound() != null);
   }
   /**
    * <p>Is there a maximum bound?.</p>
    * @return  <code>({@link #getMaxBound() getMaxBound}() != null)</code>
    * @see  #getMinBound()
    */
   public boolean hasMax()  {
      return  (getMaxBound() != null);
   }
   /**
    * <p>The minimum bound.</p>
    * @see  #getMaxBound()
    * @see  #hasMin()
    * @see  #getMinNumber()
    * @see  #isMinInclusive()
    * @see  #NumberInRange(Invert, NumberBound, NumberBound) constructor
    */
   public NumberBound<N> getMinBound()  {
      return nbMin;
   }
   /**
    * <p>The maximum bound.</p>
    * @see  #getMinBound()
    * @see  #hasMax()
    * @see  #getMaxNumber()
    * @see  #isMaxInclusive()
    * @see  #NumberInRange(Invert, NumberBound, NumberBound) constructor
    */
   public NumberBound<N> getMaxBound()  {
      return nbMax;
   }
   /**
    * <p>Is the range inverted?.</p>
    * @return  <ul>
    *    <li>{@code true}: The range is made opposite--If the bounds are
    *    one and three, then
    *    <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#isIn(N)">isIn</a>(2)</code>
    *    will return {@code false}</li>
    *    <li>{@code false}: The range is treated normally ({@code isIn(2)}
    *    returns {@code true})</li>
    * </ul>
    * @see  #NumberInRange(Invert, NumberBound, NumberBound) constructor
    */
   public boolean isInverted()  {
      return  isInverted;
   }
   /**
    * <p>Get the minimum bound number.</p>
    * @return  <code>getMinBound().{@link NumberBound#get() get}()</code>
    * @exception  NullPointerException  If {@link #hasMin() hasMin}{@code ()} is {@code false}.
    * @see  #getMinBound()
    */
   public N getMinNumber()  {
      try  {
         return  getMinBound().get();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMinBound(), "in");
         throw  rx;
      }
   }
   /**
    * <p>Is the minimum bound inclusive?.</p>
    * @return  <code>getMinBound().{@link NumberBound#isInclusive() isInclusive}()</code>
    * @exception  NullPointerException  If {@code getMinBound()} is {@code null}.
    * @see  #getMinBound()
    */
   public boolean isMinInclusive()  {
      try  {
         return  getMinBound().isInclusive();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMinBound(), "in");
         throw  rx;
      }
   }
   /**
    * <p>Get the maximum bound number.</p>
    * @return  <code>{@link #getMaxBound() getMaxBound}().{@link NumberBound#get() get}()</code>
    * @exception  NullPointerException  If {@code getMaxBound()} is
    * {@code null}.
    * @see  #getMinBound()
    */
   public N getMaxNumber()  {
      try  {
         return  getMaxBound().get();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMaxBound(), "ax");
         throw  rx;
      }
   }
   /**
    * <p>Is the maximum bound inclusive?.</p>
    * @return  <code>{@link #getMaxBound() getMaxBound}(){@link NumberBound#isInclusive() isInclusive}()</code>
    * @exception  NullPointerException  If {@code getMaxBound()} is {@code null}.
    * @see  #getMinBound()
    */
   public boolean isMaxInclusive()  {
      try  {
         return  getMaxBound().isInclusive();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMaxBound(), "ax");
         throw  rx;
      }
   }
//getters...END
//other...START
   /**
    * @return   <code>(!{@link #hasMin() hasMin}() &nbsp;&amp;&amp; &nbsp;!{@link #hasMax() hasMax}())</code>
    */
   public boolean isUnrestricted()  {
      return  (!hasMin()  &&  !hasMax());
   }
   /**
    * @return  {@link #appendRules(StringBuilder) appendRules}{@code ((new StringBuilder())).toString()}
    */
   public String getRules()  {
      return  appendRules((new StringBuilder())).toString();
   }
   /**
    * @see  #getRules()
    * @see  <code><a href="http://en.wikibooks.org/wiki/Algebra/Interval_Notation">http://en.wikibooks.org/wiki/Algebra/Interval_Notation</a></code>
    */
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      NumberBound<?> min = getMinBound();
      try  {
         if(isInverted())  {
            to_appendTo.append("inverted:");
         }

         if(min == null)  {
            to_appendTo.append("[-inf");
         }  else  {
            to_appendTo.append(min.isInclusive() ? "[" : "(").append(min.get());
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      to_appendTo.append(",");

      NumberBound<?> max = getMaxBound();
      if(max == null)  {
         to_appendTo.append("+inf)");
      }  else  {
         to_appendTo.append(max.get()).append(max.isInclusive() ? "]" : ")");
      }

      String minName = (!hasMin() ? null : getMinBound().getName());
      String maxName = (!hasMax() ? null : getMinBound().getName());

      if(minName != null  ||  maxName != null)  {
         to_appendTo.append(" (");
      }

      if(minName != null)  {
         to_appendTo.append("min=\"" + minName + "\"");
      }

      if(minName != null  &&  maxName != null)  {
         to_appendTo.append(", ");
      }

      if(maxName != null)  {
         to_appendTo.append("max=\"" + maxName + "\"");
      }

      if(minName != null  ||  maxName != null)  {
         to_appendTo.append(")");
      }
      return  to_appendTo;

   }
   public String toString()  {
      return  getRules();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  appendRules(to_appendTo);
   }
   /**
    * <p>If a bound is {@code null}, throw an {@code IllegalStateException}.</p>
    * @param  bound  The bound to check.
    * @param  in_orAx  If checking the minimum bound, set this to
    * &quot;{@code in}&quot;. If maximum, &quot;{@code ax}&quot;.
    */
   protected void throwISXIfBoundNull(NumberBound<N> bound, String in_orAx)  {
      if(bound == null)  {
         throw  new IllegalStateException("hasM" + in_orAx + "() is false.");
      }
   }
   public abstract void crashIfBadBoundsForCnstr();

//other...END

   public abstract boolean isGTOEMinGivenIncl(N num);
   public abstract boolean isLTOEMaxGivenIncl(N num);

   public N getInclMinComparedTo(N num)  {
      try  {
         return  getMinBound().getInclComparedTo(BoundSide.MIN, num);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(getMinBound(), "getMinBound()", "hasMin() is false (actually " + hasMin() + ")");
         throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
      }
   }
   public N getInclMaxComparedTo(N num)  {
      try  {
         return  getMaxBound().getInclComparedTo(BoundSide.MAX, num);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(getMaxBound(), "getMaxBound()", "hasMax() is false (actually " + hasMax() + ")");
         throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
      }
   }
   public abstract N getInclMinComparedToOrIfNoMin(N to_compareTo, N if_noMin);
   public abstract N getInclMaxComparedToOrIfNoMax(N to_compareTo, N if_noMax);

   public final boolean isIn(N num)  {
      boolean bV4Min = false;
      try  {
         bV4Min = (!hasMin()  ||  isGTOEMinGivenIncl(num));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
      }
      boolean bV4Max = (!hasMax()  ||  isLTOEMaxGivenIncl(num));

      boolean isValidUninv = (bV4Min  &&  bV4Max);

      return  (!isInverted() ? isValidUninv : !isValidUninv);
   }
   /**
    * @return  <code>true</code> If {@code to_compareTo} is
    * non-{@code null}, a {@code NumberInRange}, and all relevant fields
    * {@linkplain #areFieldsEqual(NumberInRange) are equal}. This is
    * implemented as suggested by Joshua Bloch in &quot;Effective Java&quot;
    * (2nd ed, item 8, page 46).
    */
   @Override
   public boolean equals(Object to_compareTo)  {
      //Check for object equality first, since it's faster than instanceof.
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof NumberInRange))  {
         //to_compareTo is either null or not an NumberInRange.
         //java.lang.Object.object(o): "For any non-null reference value x,
         //x.equals(null) should return false."
         return  false;
      }

      //Safe to cast
      @SuppressWarnings("unchecked")
      NumberInRange<N> o = (NumberInRange<N>)to_compareTo;

      //Finish with field-by-field comparison.
      return  areFieldsEqual(o);
   }
   /**
    * Get a duplicate of this {@code NumberInRange}, with an opposite-value
    * inverted flag.
    * @return A duplicate of this object, whose {@link #isInverted() isInverted}{@code ()}
    * equal to {@code !this.isInverted()}.
    */
   public abstract NumberInRange<N> getInvertedCopy();
   /**
    * Get a new range containing the values in <i>both</i>
    * <i>{@code this}</i> and another range.
    * @param  to_intersectWith May not be <code>null</code>.
    * @return  If {@code to_intersectWith}
    * {@linkplain #doesOverlap(com.github.xbn.number.NumberInRange) overlaps}
    * <i>{@code this}</i> range, this returns a new range that
    * contains only those values in both. If they do not overlap, this
    * returns {@code null}.  It is required that both
    * {@linkplain #getMinBound() min bounds} and both
    * {@linkplain #getMaxBound() max bounds} have the same inclusivity
    * (must both be {@linkplain Inclusive#YES inclusive} or both
    * {@linkplain Inclusive#NO exclusive}). (It is okay for one min (or
    *  max) bound to exist, and the other not exist.)
    * @see #getMerged(NumberInRange, OverlapRequired)
    * @since  0.1.5
    */
   public abstract NumberInRange<N> getIntersection(
         NumberInRange<N> to_intersectWith);
   /**
    * Get a new range containing the values in <i>either</i>
    * <i>{@code this}</i> and another range.
    * @param  to_mergeWith May not be <code>null</code>. If
    * <code>overlap_rqd.{@link OverlapRequired#YES YES}</code>, must
    * {@linkplain #doesOverlap(com.github.xbn.number.NumberInRange) overlaps}
    *  <i>{@code this}</i> range.
    * @param  overlap_rqd  May not be <code>null</code>.
    * @return  A new range whose values are in <i>either</i>
    * <i>{@code this}</i> or {@code to_mergeWith}. It is required that both
    * {@linkplain #getMinBound() min bounds} and both
    * {@linkplain #getMaxBound() max bounds} have the same inclusivity
    * (must both be {@linkplain Inclusive#YES inclusive} or both
    * {@linkplain Inclusive#NO exclusive}). (It is okay for one min (or max)
    * bound to exist, and the other not exist.)
    * @exception IllegalArgumentException If {@code overlap_rqd.YES} and
    * {@code to_mergeWith} does not overlap or touch <i>{@code this}</i>
    * one.
    * @see #getIntersection(NumberInRange)
    * @since  0.1.5
    */
   public abstract NumberInRange<N> getMerged(NumberInRange<N> to_mergeWith,
         OverlapRequired overlap_rqd);
   /**
    * Get the minimum bound, given inclusivity.
    * @return <code>{@link #getMinBound() getMinBound}().{@link NumberBound#getGivenIncl(BoundSide) getGivenIncl}({@link BoundSide}.{@link BoundSide#MIN MIN})</code>
    * @exception IllegalStateException If {@link #hasMin() hasMin}{@code ()} is {@code false}.
    * @see #getMaxGivenIncl()
    * @since  0.1.5
    */
   public N getMinGivenIncl()  {
      try  {
         return  getMinBound().getGivenIncl(BoundSide.MIN);
      }  catch(NullPointerException npx)  {
         throw  new IllegalStateException("hasMin() is false.");
      }
   }
   /**
    * Get the maximum bound, given inclusivity.
    * @return <code>{@link #getMaxBound() getMaxBound}().{@link NumberBound#getGivenIncl(BoundSide) getGivenIncl}({@link BoundSide}.{@link BoundSide#MAX MAX})</code>
    * @exception IllegalStateException If {@link #hasMax() hasMax}{@code ()} is {@code false}.
    * @see #getMinGivenIncl()
    * @since  0.1.5
    */
   public N getMaxGivenIncl()  {
      try  {
         return  getMaxBound().getGivenIncl(BoundSide.MAX);
      }  catch(NullPointerException npx)  {
         throw  new IllegalStateException("hasMax() is false.");
      }
   }
   /**
    * Does <i>{@code this}</i> range overlap another?
    * @param  to_compareTo May not be <code>null</code>.
    * @return  <blockquote><pre>(<!-- GENERIC PARAMETERS FAIL IN @link --><a href="#isIn(N)">isIn</a>(to_compareTo.{@link #getMinGivenIncl() getMinGivenIncl}())  ||
    *	   isIn(to_compareTo.{@link #getMaxGivenIncl() getMaxGivenIncl}()())  ||
    *    to_compareTo.isIn(getMinGivenIncl())  ||
    *    to_compareTo.isIn(getMaxGivenIncl()))</pre></blockquote>
    * @see #getOverlapDebugging(NumberInRange)
    * @since  0.1.5
    */
   public boolean doesOverlap(NumberInRange<N> to_compareTo)  {
      N inclMinThis = (!hasMin() ?  null : getMinGivenIncl());
      N inclMaxThis = (!hasMax() ?  null : getMaxGivenIncl());
      N inclMinThat = null;
      try  {
         inclMinThat = (!to_compareTo.hasMin() ?  null
            :  to_compareTo.getMinGivenIncl());
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("to_compareTo");
      }
      N inclMaxThat = (!to_compareTo.hasMax() ?  null
         :  to_compareTo.getMaxGivenIncl());

      if(inclMinThis != null)  {
         if(to_compareTo.isIn(inclMinThis))  {
            return  true;
         }
      }
      if(inclMaxThis != null)  {
         if(to_compareTo.isIn(inclMaxThis))  {
            return  true;
         }
      }
      if(inclMinThat != null)  {
         if(isIn(inclMinThat))  {
            return  true;
         }
      }
      if(inclMaxThat != null)  {
         if(isIn(inclMaxThat))  {
            return  true;
         }
      }

      return  (inclMinThis == null  &&  inclMinThat == null  &&
         inclMaxThis == null  &&  inclMaxThat == null);
   }
   public String getOverlapDebugging(NumberInRange<N> to_compareTo)  {
      StringBuilder bldr = new StringBuilder("doesOverlap: this=" + this +
         ", to_compareTo=" + to_compareTo).append(LINE_SEP);
      if(to_compareTo.hasMin())  {
         bldr.append("   this.isIn(" + to_compareTo.getMinGivenIncl() + ")=" +
            isIn(to_compareTo.getMinGivenIncl())).append(LINE_SEP);
      }  else  {
         bldr.append("to_compareTo.hasMin() is false");
      }
      if(to_compareTo.hasMax())  {
         bldr.append("   this.isIn(" + to_compareTo.getMaxGivenIncl() + ")=" +
            isIn(to_compareTo.getMaxGivenIncl())).append(LINE_SEP);
      }  else  {
         bldr.append("to_compareTo.hasMax() is false");
      }
      if(hasMin())  {
         bldr.append("   to_compareTo.isIn(" + getMinGivenIncl() + ")=" +
            to_compareTo.isIn(getMinGivenIncl())).append(LINE_SEP);
      }  else  {
         bldr.append("this.hasMin() is false");
      }
      if(hasMax())  {
         bldr.append("   to_compareTo.isIn(" + getMaxGivenIncl() + ")=" +
            to_compareTo.isIn(getMaxGivenIncl())).append(LINE_SEP);
      }  else  {
         bldr.append("this.hasMax() is false");
      }
      return  bldr.toString();
   }
   /**
    * <p>Are all relevant fields equal?.</p>
    * @param  to_compareTo  May not be {@code null}.
    */
   public abstract boolean areFieldsEqual(NumberInRange<N> to_compareTo);
   /**
    * @deprecated Use <code><!-- Generics fail in at-links: --><a href="#getDebuggingForIsIn(N)">getDebuggingForIsIn</a>(N)</code>
    * @since  0.1.5
    */
   public static final <N extends Number> String getValidityDebugging(NumberInRange<N> range, N to_validate, String to_vldtName)  {
      try  {
         return  to_vldtName + "=" + to_validate + ", range=<" + range + ">, " + range.getDebuggingForIsIn(to_validate);
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("range");
      }
   }
   /**
    * In depth explanation on why a number is in or not in <i>{@code this}</i> range.
    * @param  to_validate The number to analyze. May not be <code>null</code>.
    * @return  Description on why {@code to_validate} is in or not in this range. This uses the terminology &quot;valid&quot; instead of &quot;in&quot;.
    * @since  0.1.5
    */
   public String getDebuggingForIsIn(N to_validate)  {
      return  "valid-for-min?=" +
         (!hasMin()
            ?  "yes (no min-bound)"
            :  (!isGTOEMinGivenIncl(to_validate)
               ?  "no (less than min, given its inclusive-ness)"
               :  "yes (greater-than-or-equal-to min)")) +
      ", valid-for-max?=" +
         (!hasMax()
            ?  "yes (no max-bound)"
            :  (!isLTOEMaxGivenIncl(to_validate)
               ?  "no (greater than max, given its inclusive-ness)"
               :  "yes (greater-than-or-equal-to max)")) +
      ", valid entirely, NOT considering invertedness? " + ((
         (!hasMin()  ||  isGTOEMinGivenIncl(to_validate))  &&
         (!hasMax()  ||  isLTOEMaxGivenIncl(to_validate)))
            ? "yes" : "no") +
      ", valid entirely, considering invertedness? " + ((
         (!hasMin()  ||  isGTOEMinGivenIncl(to_validate))  &&
         (!hasMax()  ||  isLTOEMaxGivenIncl(to_validate))  &&
         isInverted())
            ? "yes" : "no");
   }
}
