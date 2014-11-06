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
/**
 * <P>Determines if a number is within a {@code NumberRange}.</P>
 * @since 0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 */
public abstract class NumberInRange<N extends Number> extends AbstractExtraErrInfoable implements NumberRange<N>, Ruleable  {
//state
	private final NumberBound<N> nbMin     ;
	private final NumberBound<N> nbMax     ;
	private final boolean        isInverted;
	protected final RuleableComposer ruleCmpsr;
//constructors...START
	/**
	 * <P>Create a new {@code NumberInRange}.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link #NumberInRange(Invert, NumberBound, NumberBound) this}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, null, null)</CODE></P>
	 */
	public NumberInRange()  {
		this(Invert.NO, null, null);
	}
	/**
	 * <P>Create a new {@code NumberInRange}.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <CODE>{@link #NumberInRange(Invert, NumberBound, NumberBound) this}({@link com.github.xbn.lang.Invert}.{@link com.github.xbn.lang.Invert#NO NO}, nb_min, nb_max)</CODE></P>
	 */
	public NumberInRange(NumberBound<N> nb_min, NumberBound<N> nb_max)  {
		this(Invert.NO, nb_min, nb_max);
	}
	/**
	 * <P>Create a new {@code NumberInRange}.</P>
	 * @param  nb_min  Get with {@link #getMinBound() getMinBound}{@code (null, null)}
	 * @param  nb_max  Get with {@link #getMaxBound() getMaxBound}{@code ()}
	 * @param  invert  If {@link com.github.xbn.lang.Invert#YES YES}, then
	 * the range is made opposite--If the bounds are one and three, then
	 * <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#isIn(N)">isIn</A>(2)</CODE>
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
	 * <P>Is there a minimum bound?.</P>
	 * @return  {@code (getMinBound() != null)}
	 * @see  #getMinBound()
	 */
	public boolean hasMin()  {
		return  (getMinBound() != null);
	}
	/**
	 * <P>Is there a maximum bound?.</P>
	 * @return  <CODE>({@link #getMaxBound() getMaxBound}() != null)</CODE>
	 * @see  #getMinBound()
	 */
	public boolean hasMax()  {
		return  (getMaxBound() != null);
	}
	/**
	 * <P>The minimum bound.</P>
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
	 * <P>The maximum bound.</P>
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
	 * <P>Is the range inverted?.</P>
	 * @return  <UL>
	 *    <LI>{@code true}: The range is made opposite--If the bounds are
	 *    one and three, then
	 *    <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#isIn(N)">isIn</A>(2)</CODE>
	 *    will return {@code false}</LI>
	 *    <LI>{@code false}: The range is treated normally ({@code isIn(2)}
	 *    returns {@code true})</LI>
	 * </UL>
	 * @see  #NumberInRange(Invert, NumberBound, NumberBound) constructor
	 */
	public boolean isInverted()  {
		return  isInverted;
	}
	/**
	 * <P>Get the minimum bound number.</P>
	 * @return  <CODE>getMinBound().{@link NumberBound#get() get}()</CODE>
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
	 * <P>Is the minimum bound inclusive?.</P>
	 * @return  <CODE>getMinBound().{@link NumberBound#isInclusive() isInclusive}()</CODE>
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
	 * <P>Get the maximum bound number.</P>
	 * @return  <CODE>{@link #getMaxBound() getMaxBound}().{@link NumberBound#get() get}()</CODE>
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
	 * <P>Is the maximum bound inclusive?.</P>
	 * @return  <CODE>{@link #getMaxBound() getMaxBound}(){@link NumberBound#isInclusive() isInclusive}()</CODE>
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
	 * @return   <CODE>(!{@link #hasMin() hasMin}() &nbsp;&amp;&amp; &nbsp;!{@link #hasMax() hasMax}())</CODE>
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
	 * @see  <CODE><A HREF="http://en.wikibooks.org/wiki/Algebra/Interval_Notation">http://en.wikibooks.org/wiki/Algebra/Interval_Notation</A></CODE>
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

		String minName = getMinBound().getName();
		String maxName = getMinBound().getName();

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
	 * <P>If a bound is {@code null}, throw an {@code IllegalStateException}.</P>
	 * @param  bound  The bound to check.
	 * @param  in_orAx  If checking the minimum bound, set this to
	 * &quot;{@code in}&quot;. If maximum, &quot;{@code ax}&quot;.
	 */
	protected void throwISXIfBoundNull(NumberBound<N> bound, String in_orAx)  {
		if(bound == null)  {
			throw  new IllegalStateException("hasM" + in_orAx + "() is false.");
		}
	}
	/**
	 * <P>If the bounds are not valid, crash.</P>
	 * @exception  IllegalArgumentStateException  If both bounds are
	 * non-{@code null} and the minimum bound is greater than the maximum
	 * (this correctly considers the
	 * {@link NumberBound#isInclusive() inclusive}-ness of both bounds).
	 */
//	public abstract void crashIfBadBoundsForCnstr(NumberBound<N> nb_min, NumberBound<N> nb_max);
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
	 * @return  <CODE>true</CODE> If {@code to_compareTo} is
	 * non-{@code null}, a {@code NumberInRange}, and all its fields
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
	 * @return A duplicate of this object, whose {@link #isInverted()}{@code ()}
	 * equal to {@code !this.isInverted()}.
	 */
	public abstract NumberInRange<N> getInvertedCopy();
	/**
	 * Get a new range containing the values in <i>both</i>
	 * <i>{@code this}</i> and another range.
	 * @param  to_intersectWith May not be <code>null</code>.
	 * @return  If {@code to_intersectWith} is overlapping with
	 * <i>{@code this}</i> (at least, its min is the same as
	 * <i>{@code this}</i>'s max, or its max is the same as
	 * <i>{@code this}</i>'s min--<i>{@linkplain #isGTOEMinGivenIncl() given inclusiveness}</i>),
	 * this returns a new range that contains only those
	 * values in both. If they do not overlap, this returns {@code null}.
	 * @see #getMerged(NumberInRange, TouchOverlapRequired)
	 */
	public abstract NumberInRange<N> getIntersection(
			NumberInRange<N> to_intersectWith);
	/**
	 * Get a new range containing the values in <i>either</i>
	 * <i>{@code this}</i> and another range.
	 * @param  to_mergeWith May not be <code>null</code>. If
	 * <code>to_rqd.{@link TouchOverlapRequired#YES YES}</code>, this must
	 * be touching or overlapping with <i>{@code this}</i> range (at least,
	 * its min is the same as <i>{@code this}</i>'s max, or its max is the
	 * same as <i>{@code this}</i>'s
	 * min--<i>{@linkplain #isGTOEMinGivenIncl() given inclusiveness}</i>).
	 * Otherwise, this may or may not be overlapping.
	 * @param  to_rqd  May not be <code>null</code>.
	 * @return  A new range whose values are in <i>either</i>
	 * <i>{@code this}</i> or {@code to_mergeWith}.
	 * @exception IllegalArgumentException If {@code to_rqd.YES} and
	 * {@code to_mergeWith} does not overlap or touch <i>{@code this}</i>
	 * one.
	 * @see #getIntersection(NumberInRange)
	 */
	public abstract NumberInRange<N> getMerged(NumberInRange<N> to_mergeWith,
			TouchOverlapRequired to_rqd);
	/**
	 * <P>Are all relevant fields equal?.</P>
	 * @param  to_compareTo  May not be {@code null}.
	 */
	public abstract boolean areFieldsEqual(NumberInRange<N> to_compareTo);
	public static final <N extends Number> String getValidityDebugging(NumberInRange<N> range, N to_validate, String to_vldtName)  {
		return  to_vldtName + "=" + to_validate + ", range=<" + range + ">, valid-for-min?=" +
			(!range.hasMin()
				?  "yes (no min-bound)"
				:  (!range.isGTOEMinGivenIncl(to_validate)
					?  "no (less than min, given its inclusive-ness)"
					:  "yes (greater-than-or-equal-to min)")) +
		", valid-for-max?=" +
			(!range.hasMax()
				?  "yes (no max-bound)"
				:  (!range.isLTOEMaxGivenIncl(to_validate)
					?  "no (greater than max, given its inclusive-ness)"
					:  "yes (greater-than-or-equal-to max)")) +
		", valid entirely, NOT considering invertedness? " + ((
			(!range.hasMin()  ||  range.isGTOEMinGivenIncl(to_validate))  &&
			(!range.hasMax()  ||  range.isLTOEMaxGivenIncl(to_validate)))
				? "yes" : "no") +
		", valid entirely, considering invertedness? " + ((
			(!range.hasMin()  ||  range.isGTOEMinGivenIncl(to_validate))  &&
			(!range.hasMax()  ||  range.isLTOEMaxGivenIncl(to_validate))  &&
			range.isInverted())
				? "yes" : "no");
	}
}
