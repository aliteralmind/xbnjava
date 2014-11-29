//package EDU.oswego.cs.dl.util.concurrent.misc;
package  com.github.xbn.number;
	import  java.io.Serializable;
	import  java.util.regex.Pattern;
	import  java.util.regex.Matcher;
/**
  <p>Represents a fraction in reduced and mixed-number form, with some mathematical functionality.</p>

{&#64;.codelet.and.out com.github.xbn.examples.number.FractionXmpl%eliminateCommentBlocksAndPackageDecl()}

  <p>Originally {@code EDU.oswego.cs.dl.util.concurrent.misc.Fraction.java}, with some minor edits, and the addition of mixed numbers, testing function, and string-constructor, by Jeff Epstein.</p>

  <p>Originally written by Doug Lea and released into the public domain.
  This may be used for any purposes whatsoever without acknowledgment.
  Thanks for the assistance and support of Sun Microsystems Labs,
  and everyone contributing, testing, and using this code.</p>

  <p><i>Original description:</i> An immutable class representing fractions as pairs of longs. Fractions are always maintained in reduced form.</p>

<pre>  History:
  Date       Who              What
  7Jul1998   dl               Create public version
  11Oct1999  dl               add hashCode
  201011     je               Added mixed-numbers and testing function</pre>
**/
public class Fraction implements Cloneable, Comparable<Fraction>, Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 8586858857475058852L;
	/*
	public static final void main(String[] ignored)  {
		System.out.println("Parse string 5/10:");

			Fraction f = new Fraction("5/10");
			System.out.println("Reduced to: " + f.toString());
			System.out.println();

		System.out.println("Parse numerator 5, denominator 10:");
			f = new Fraction(5, 10);
			System.out.println(f.toString());
	}
 */
	private long numerator;
	private long denominator;
	/**
		<p>Create a Fraction in 'mixed number form' (such as {@code '3 1/2'}). See <a href="http://en.wikipedia.org/wiki/Fraction_%28mathematics%29#Mixed_numbers">Fractions:Mixed Numbers </a> on Wikipedia.</p>

		<p>This is the same as (using the example {@code 3 1/2})</p>

<pre>	long lWhole = (new Integer(mixed_whole)).longValue();       //3
	long lNumerator = (new Integer(mixed_numerator)).longValue();      //1
	long lDenominator = (new Integer(demoninator)).longValue();  //2

	Fraction f = new Fraction(
		((lWhole / lDenominator) + lNumerator),
		lDenominator)

	System.out.println(f.{@link #toString() toString}());     //<b>7/2</b></pre>
	System.out.println(f.{@link #getMixedWholeString() getMixedWholeString}());     //<b>'3 1/2'</b></pre>
	**/
	public Fraction(long mixed_whole, long mixed_numerator, long mixed_denominator) {
		setFraction(mixed_whole, mixed_numerator, mixed_denominator);
	}
	/**
		<p>Create a Fraction where the denominator is 1.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@code this(whole_number, 1)}</p>
	 **/
	public Fraction(long whole_number) {
		this(whole_number, 1);
	}
	/**
		<p>Create a Fraction from a string in 'mixed number form' (such as {@code '3 1/2'}). See <a href="http://en.wikipedia.org/wiki/Fraction_%28mathematics%29#Mixed_numbers">Fractions:Mixed Numbers </a> on Wikipedia.</p>

		@param  frac_str  A string representation of a fraction, in one of the following forms:<ul>
			<li><b>{@code 'whole-number'}</b>, such as {@code 3}, which is translated to {@code 3/1}.</li>
			<li><b>{@code 'numerator/denominator'}</b>, such as {@code 1/2}.</li>
			<li><b>{@code 'whole-number numerator/denominator'}</b>, such as {@code '3 1/2'}, translated to {@code 7/2}.</li>
		</ul>
		May not be {@code null}. Must have whitespace only (spaces or tabs) between the whole-number and numerator. No other whitespace allowed.
		@see  #Fraction(long, long, long) Fraction(l,l,l)
	 **/
	public Fraction(String frac_str) {
		try  {
			if(frac_str.length() == 0)  {
				throw  new IllegalArgumentException("frac_str.length() is zero.");
			}
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("frac_str");
		}

		String spIntOnly = "([0-9]+)";
		String spFracOnly = "([0-9]+/[0-9]+)";
		String spIntFrac = "([0-9]+[ \t]+[0-9]+/[0-9]+)";

		Pattern p = Pattern.compile("(" + spIntOnly + "|" + spFracOnly + "|" + spIntFrac + ")");
		if(!p.matcher(frac_str).matches())  {
			throw  new NumberFormatException("frac_str ('" + frac_str + "') does not match the pattern [" + p.toString() + "]. It must be in the form [whole-number], [numerator/denominator], or [whole-number numerator/denominator]. Only tabs and spaces may separate the whole-number and numerator. Otherwise on whitespace is allowed.");
		}

		String sSpcTb = "[ \t]+";
		Pattern pws = Pattern.compile(sSpcTb);
		Matcher m = pws.matcher(frac_str);
		boolean bHasWS = m.find();

		int ixSlash = frac_str.indexOf("/");

		long lWhole = -1;
		long lNumerator = -1;
		long lDenominator = -1;

		if(bHasWS)  {
			//Both whole-number and fraction

			int ixWSStart = m.start();
			int ixxWSEnd = m.end();
			lWhole = (new Long(frac_str.substring(0, ixWSStart)));
			lNumerator = (new Long(frac_str.substring(ixxWSEnd, ixSlash)));
			lDenominator = (new Long(frac_str.substring((ixSlash + 1), frac_str.length())));
			setFraction(lWhole, lNumerator, lDenominator);

		}  else if(ixSlash != -1)  {
			//Fraction only
			lNumerator = (new Long(frac_str.substring(0, ixSlash)));
			lDenominator = (new Long(frac_str.substring((ixSlash + 1), frac_str.length())));
			setFraction(lNumerator, lDenominator);

		}  else  {
			//Integer only
			lWhole = (new Long(frac_str));
			setFraction(lWhole, 1);
		}
	}
	/** Create a Fraction equal in value to num / den **/
	public Fraction(long num, long den) {
		setFraction(num, den);
	}
	private void setFraction(long mixed_whole, long mixed_numerator, long mixed_denominator)  {
		setFraction(
			((mixed_whole * mixed_denominator) + mixed_numerator),
			mixed_denominator);
	}
	private void setFraction(long numerator, long denominator)  {
		// normalize while constructing
		boolean numNonnegative = (numerator >= 0);
		boolean denNonnegative = (denominator >= 0);
		long a = numNonnegative? numerator : -numerator;
		long b = denNonnegative? denominator : -denominator;
		long g = gcd(a, b);
		numerator = (numNonnegative == denNonnegative)? (a / g) : (-a / g);
		denominator = b / g;
	}
  /** Create a fraction with the same value as Fraction frac **/
  public Fraction(Fraction frac) {
    numerator = frac.getNumerator();
    denominator = frac.getDenominator();
  }


  /** Return the numerator **/
  public final long getNumerator() { return  numerator; }

  /** Return the denominator **/
  public final long getDenominator() { return  denominator; }

	/**
		<p>Get the whole-number from the mixed-number fraction. If this fraction were {@code 5/3}, that equals the mixed-number {@code 1 2/3}. This function would return  the {@code 1}.</p>

		@return  If {@link #getNumerator() getNumerator}{@code ()} is greater-than-or-equal-to {@link #getDenominator() getDenominator}{@code ()}:  {@code <b>(getNumerator() / getDenominator())</b>}
		<br/>Otherwise: <b>{@code 0}</b>
		@see  #getMixedNumerator()
		@see  #getMixedDenominator()
	 **/
	public final long getMixedWhole() {
		return  ((getNumerator() >= getDenominator())
			?  (getNumerator() / getDenominator())
			:  0);
	}
	/**
		<p>Get the numerator from the mixed-number fraction. If this fraction were {@code 5/3}, that equals the mixed-number {@code 1 2/3}. This function would return  the {@code 2}.</p>

		@return  If {@code getMixedWhole()} is greater than zero:   <code><b>(getNumerator() - ({@link #getMixedWhole() getMixedWhole}() * getDenominator()))</b></code>
		<br/>Otherwise: <b>{@code getNumerator()}</b>
		@see  #getMixedDenominator()
	 **/
	public final long getMixedNumerator() {
		long lMi = getMixedWhole();
		return  (lMi > 0
			?  (getNumerator() - (lMi * getDenominator()))
			:  getNumerator());
	}
	/**
		<p>Get the denominator from the mixed-number fraction. If this fraction were {@code 5/3}, that equals the mixed-number {@code 1 2/3}. This function would return  the {@code 3}.</p>

		@return  {@link #getDenominator() getDenominator}{@code ()}
		@see  #getMixedDenominator()
	 **/
	public final long getMixedDenominator()  {
		return  getDenominator();
	}
 	/**
  		<p>Return the numerator as a string.</p>

  		@return  <code>(new Long({@link #getNumerator() getNumerator}())).toString()</code>
  	 **/
	public final String getNumeratorString()  {
		return  (new Long(getNumerator())).toString();
	}
 	/**
  		<p>Return the denominator as a string.</p>

  		@return  <code>(new Long({@link #getDenominator() getDenominator}())).toString()</code>
  	 **/
	public final String getDenominatorString()  {
		return  (new Long(getDenominator())).toString();
	}
 	/**
  		<p>Return the mixed-number integer as a string.</p>

  		@return  <code>(new Long({@link #getMixedWhole() getMixedWhole}())).toString()</code>
  	 **/
	public final String getMixedWholeString()  {
		return  (new Long(getMixedWhole())).toString();
	}
 	/**
  		<p>Return the mixed-number numerator as a string.</p>

  		@return  <code>(new Long({@link #getMixedNumerator() getMixedNumerator}())).toString()</code>
  	 **/
	public final String getMixedNumeratorString()  {
		return  (new Long(getMixedNumerator())).toString();
	}
 	/**
  		<p>Return the mixed-number denominator as a string.</p>

  		@return  <code>(new Long({@link #getMixedDenominator() getMixedDenominator}())).toString()</code>
  	 **/
	public final String getMixedDenominatorString()  {
		return  (new Long(getMixedDenominator())).toString();
	}
  public Object clone() { return  new Fraction(this); }

  /** Return the value of the Fraction as a double **/
  public double asDouble() {
    return  ((double)(getNumerator())) / ((double)(getDenominator()));
  }

  /**
   * Compute the nonnegative greatest common divisor of a and b.
   * (This is needed for normalizing Fractions, but can be
   * useful on its own.)
   **/
  public static long gcd(long a, long b) {
    long x;
    long y;

    if (a < 0) a = -a;
    if (b < 0) b = -b;

    if (a >= b) { x = a; y = b; }
    else        { x = b; y = a; }

    while (y != 0) {
      long t = x % y;
      x = y;
      y = t;
    }
    return  x;
  }

  /** return  a Fraction representing the negated value of this Fraction **/
  public Fraction negative() {
    long an = getNumerator();
    long ad = getDenominator();
    return  new Fraction(-an, ad);
  }

  /** return  a Fraction representing 1 / this Fraction **/
  public Fraction inverse() {
    long an = getNumerator();
    long ad = getDenominator();
    return  new Fraction(ad, an);
  }


  /** return  a Fraction representing this Fraction plus frac **/
  public Fraction plus(Fraction frac) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = frac.getNumerator();
    long bd = frac.getDenominator();
    return  new Fraction(an*bd+bn*ad, ad*bd);
  }

  /** return  a Fraction representing this Fraction plus num **/
  public Fraction plus(long num) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = num;
    long bd = 1;
    return  new Fraction(an*bd+bn*ad, ad*bd);
  }

	/**
  		<p>return  a Fraction representing this Fraction plus num</p>
	 **/
  public Fraction plus(int num) {
	  return  plus((new Integer(num)).longValue());
  }

	/**
		<p>Assuming this fraction represents a musical duration, add to it, as made necessary by its 'dots'.</p>

		<p>For example: Dotted quarter note</p>

<pre>	Fraction fDuration = new Fraction(1, 4);
	Fraction durationW1Dot = fDuration.plusDurationDots(1);
	System.out.println(durationW1Dot);
		//1/4 + (1/4 * 1/2) = 1/4 + 1/8 = 2/8 + 1/8 = <b>3/8</b></pre>

		<p>Or: Doubly-dotted quarter note.</p>

<pre>	Fraction durationFrac2 = new Fraction(1, 4);
	Fraction durationW2Dots = durationFrac2.plusDurationDots(2);
	System.out.println(durationW2Dots);
		//1/4 + (1/4 * 1/2) + ((1/4 * 1/2) * 1/2) =
		//   1/4 + 1/8 + (1/8 * 1/2) = 1/4 + 1/8 + 1/16 =
		//   4/16 + 2/16 + 1/16 = <b>7/16</b></pre>

		@param  dot_count  The number of dots following the duration. May not be less than zero.
	**/
	public Fraction plusDurationDots(int dot_count) {
		Fraction fTotalDuration = new Fraction(this);
		Fraction fToBeHalved = this;
		Fraction fOneHalf = new Fraction(1,2);
		for(int i = 0; i < dot_count; i++)  {
			fToBeHalved = fOneHalf.times(fToBeHalved);
			fTotalDuration = fTotalDuration.plus(fToBeHalved);
		}

		return  fTotalDuration;
	}
  /** return  a Fraction representing this Fraction minus to_beSubtracted **/
  public Fraction minus(Fraction to_beSubtracted) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = to_beSubtracted.getNumerator();
    long bd = to_beSubtracted.getDenominator();
    return  new Fraction(an*bd-bn*ad, ad*bd);
  }

  /** return  a Fraction representing this Fraction minus num **/
  public Fraction minus(long num) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = num;
    long bd = 1;
    return  new Fraction(an*bd-bn*ad, ad*bd);
  }


  /** return  a Fraction representing this Fraction times to_beMultipliedBy **/
  public Fraction times(Fraction to_beMultipliedBy) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = to_beMultipliedBy.getNumerator();
    long bd = to_beMultipliedBy.getDenominator();
    return  new Fraction(an*bn, ad*bd);
  }

  /** return  a Fraction representing this Fraction times num **/
  public Fraction times(long num) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = num;
    long bd = 1;
    return  new Fraction(an*bn, ad*bd);
  }

  /** return  a Fraction representing this Fraction divided by frac **/
  public Fraction dividedBy(Fraction frac) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = frac.getNumerator();
    long bd = frac.getDenominator();
    return  new Fraction(an*bd, ad*bn);
  }

  /** return  a Fraction representing this Fraction divided by frac **/
  public Fraction dividedBy(long frac) {
    long an = getNumerator();
    long ad = getDenominator();
    long bn = frac;
    long bd = 1;
    return  new Fraction(an*bd, ad*bn);
  }

  /** return  a number less, equal, or greater than zero
   * reflecting whether this Fraction is less, equal or greater than
   * the value of Fraction other.
		@param  fraction  May not be {@code null}.
   **/
	public int compareTo(Fraction fraction) {
		long an = getNumerator();
		long ad = getDenominator();
		long bn = fraction.getNumerator();
		long bd = fraction.getDenominator();
		long l = an*bd;
		long r = bn*ad;
		return  (l < r)? -1 : ((l == r)? 0: 1);
  }

  /** return  a number less, equal, or greater than zero
   * reflecting whether this Fraction is less, equal or greater than to_compareTo.
   **/

  public int compareTo(long to_compareTo) {
	  return  compareTo(new Fraction(to_compareTo, 1));
/**
    long an = getNumerator();
    long ad = getDenominator();
    long bn = to_compareTo;
    long bd = 1;
    long l = an*bd;
    long r = bn*ad;
    return  (l < r)? -1 : ((l == r)? 0: 1);
 **/
  }

  @Override public boolean equals(Object to_compareTo) {
		if(to_compareTo == null)  {
			throw  new NullPointerException("to_compareTo");
		}
		if(this == to_compareTo)  {
			return  true;
		}

		/**
			http://www.javapractices.com/topic/TopicAction.do?Id=17
			downloaded 10/14/2010
			use instanceof instead of getClass here for two reasons
			1. if need be, it can match any supertype, and not just one class;
			2. it renders an explict check for "that == null" redundant, since
			it does the check for null already - "null instanceof [type]" always
			returns false. (See Effective Java by Joshua Bloch.)

			[[[
				Item two is wrong. When the parameter is null, it should throw an npx instead of throwing false:
				See: xbnjava\z_build\answers\is-it-a-bad-idea-if-equalsnull-throws-nullpointerexception-instead.txt
			]]]
		 **/
		if(!(to_compareTo instanceof Fraction))  {
			return  false;
		}

		//Safe to cast
		Fraction fraction = (Fraction)to_compareTo;
		return  compareTo(fraction) == 0;
  }

  public boolean equals(long to_compareTo) {
    return  compareTo(to_compareTo) == 0;
  }

  public int hashCode() {
    return  (int) (numerator ^ denominator);
  }

	public final String getMixedString()  {
		long lMi = getMixedWhole();
		String s = "";
		if(lMi > 0)  {
			s = (new Long(lMi)).toString();
		}

		long lMn = getMixedNumerator();
		if(lMn > 0)  {
			s += ((s.length() > 0)
				?  " "
				:  "") +
				(new Long(lMn)).toString() + "/" +
				getMixedDenominatorString();
		}

		return  s;
	}
	public String toString() {
		if (getDenominator() == 1)
			return  "" + getNumerator();
		else
			return  getNumerator() + "/" + getDenominator();
	}

	private static final String LINE_SEP = System.getProperty("line.separator", "\n");

	public final String test_values(long mixed_wholeNum, long mixed_numerator, long mixed_denominator, long unmixed_numerator, long unmixed_denominator, String mixed_fracStr, String unmixedFrac_str)  {
		String s = "";
		if(getMixedWhole() != mixed_wholeNum)  {
			s += "[1: getMixedWhole()=" + getMixedWhole() + ", mixed_wholeNum=" + mixed_wholeNum + "]" + LINE_SEP;
		}
		if(getMixedNumerator() != mixed_numerator)  {
			s += "[2: getMixedNumerator()=" + getMixedNumerator() + ", mixed_numerator=" + mixed_numerator + "]" + LINE_SEP;
		}
		if(getMixedDenominator() != mixed_denominator)  {
			s += "[3: getMixedDenominator()=" + getMixedDenominator() + ", mixed_denominator=" + mixed_denominator + "]" + LINE_SEP;
		}
		if(getNumerator() != unmixed_numerator)  {
			s += "[4: getNumerator()=" + getNumerator() + ", unmixed_numerator=" + unmixed_numerator + "]" + LINE_SEP;
		}
		if(getDenominator() != unmixed_denominator)  {
			s += "[5: getDenominator()=" + getDenominator() + ", unmixed_denominator=" + unmixed_denominator + "]" + LINE_SEP;
		}
		if(getDenominator() != unmixed_denominator)  {
			s += "[6: getDenominator()=" + getDenominator() + ", unmixed_denominator=" + unmixed_denominator + "]" + LINE_SEP;
		}
		if(!getMixedString().equals(mixed_fracStr))  {
			s += "[7: getMixedString()='" + getMixedString() + "', mixed_fracStr='" + mixed_fracStr + "']" + LINE_SEP;
		}
		if(!toString().equals(unmixedFrac_str))  {
			s += "[8: toString()='" + toString() + "', unmixedFrac_str='" + unmixedFrac_str + "']" + LINE_SEP;
		}

		return  ((s.length() == 0)  ?  null  :  s);
	}
}
