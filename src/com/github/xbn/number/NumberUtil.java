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
	import  java.util.List;
	import  java.util.Collections;
	import  java.util.Arrays;
/**
	<P>Get the median of two ints, determine a long's digit-length, retrieve random values, and other number-related utilites.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NumberUtil  {
	/**
		<P>The infinity character: <CODE>'&infin;'</CODE></P>

		<P>In html: {@code "&infin;"} or {@code "&#8734;"}</P>

		<P><I>With thanks to <A HREF="http://stackoverflow.com/users/1093528/fge">fge</A> at stackoverflow.</I></P>

		@see  <CODE><A HREF="http://www.fileformat.info/info/unicode/char/221e/index.htm">http://www.fileformat.info/info/unicode/char/221e/index.htm</A></CODE></I>
		@see  <CODE><A HREF="http://stackoverflow.com/questions/2254913/infinity-symbol-with-html">http://stackoverflow.com/questions/2254913/infinity-symbol-with-html</A></CODE>
	 **/
	public static final char INFINITY_CHAR = '\u221E';
	/**
		<P>For representing up to the number 62 with a single character. This is an unmodifiable character list of digits (0-9), followed by lowercase letters (a-z), uppercase letters (A-Z), and finally the infinity character (&infin;).</P>

		@see  #getCharForNumber0Through62(int)
	 **/
	public static final List<Character> CHAR_LIST_FOR_NUMBERS_0_THROUGH_62 = Collections.
		unmodifiableList(Arrays.asList(new Character[]{
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
			'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', INFINITY_CHAR}));
	/**
		<P>Get a character representing a number, using {@code CHAR_LIST_FOR_NUMBERS_0_THROUGH_62}.</P>

		@return  If {@code num} is<UL>
			<LI>Negative: {@code '-'}</LI>
			<LI>1 through 62: <CODE>{@link #CHAR_LIST_FOR_NUMBERS_0_THROUGH_62}.{@link java.util.List#get(int) get}(num)</CODE></LI>
			<LI>63 or greater: {@link #INFINITY_CHAR}</LI>
		</UL>
	 **/
	public static final char getCharForNumber0Through62(int num)  {
		return  ((num < 0) ? '-'
			:  (num > 62 ? INFINITY_CHAR
				:  CHAR_LIST_FOR_NUMBERS_0_THROUGH_62.get(num)));
	}
	/**
		<P>Get the middle integer between two others.</P>

		<P>From
		<BR> &nbsp; &nbsp; {@code http://stackoverflow.com/questions/2707605/java-arraylist-middle}
		<BR>(User {@code polygenelubricants}, downloaded 11/13/2013)
		<BR>&quot;Generally, if you need to find the middle of items between index low (inclusive) and high (exclusive), it's mathematically
		<BR> &nbsp; &nbsp; {@code int mid = (low + high) / 2}
		<BR>But due to arithmetic overflow in limited-precision integer, the proper formula is
		<BR> &nbsp; &nbsp; {@code int mid = (low + high) >>> 1}&quot;</P>

		<P>{@code low} <I>should</I> be less-than-or-equal-to {@code high}.</P>
	 **/
	public static final int getMiddleInt(int low, int high)  {
		return  (low + high) >>> 1;
	}
	/**
		<P>Is the int in the int-array?.</P>

		@return  <CODE>({@link #getFoundIdx(int, int[]) getFoundIdx}(num, ints) != -1)</CODE>
	 **/
	public static final boolean isIn(int num, int[] ints)  {
		return  (getFoundIdx(num, ints) != -1);
	}
	/**
		<P>Is the int in the int-array?.</P>

		@return  <CODE>({@link #getFoundIdx(int, int[], boolean) getFoundIdx}(num, ints, do_orderAsc) != -1)</CODE>
	 **/
	public static final boolean isIn(int num, int[] ints, boolean do_orderAsc)  {
		return  (getFoundIdx(num, ints, do_orderAsc) != -1);
	}
	/**
		<P>Get the (first) index at which a int exists in a int-array.</P>

		@return  {@link #getFoundIdx(int, int[], boolean) getFoundIdx(num, ints, true)}
	 **/
	public static final int getFoundIdx(int num, int[] ints)  {
		return  getFoundIdx(num, ints, true);
	}
	/**
		<P>Get the (first) index at which a int exists in a int-array.</P>

		@param  num  The int to analyze.
		@param  ints  The array which {@code num} should be in. May not be null, and, if {@code do_orderAsc} is true, <I>should</I> be non-empty, unique, and sorted ascending. If not, this function will not work properly.
		@param  do_orderAsc  If true, then <CODE>{@link java.util.Arrays}.{@link java.util.Arrays#binarySearch(char[], char) binarySearch}(c[],c)</CODE> is used to search the array. If false, a for loop is used.
		@return  The first index in {@code ints} at which {@code num} exists.
		<BR>{@code <B>-1</B>} If it doesn't.
	 **/
	public static final int getFoundIdx(int num, int[] ints, boolean do_orderAsc)  {
		if(ints == null)  {
			throw  new NullPointerException("ints");
		}

		if(do_orderAsc)  {
			return  Arrays.binarySearch(ints, num);
		}

		for(int i = 0; i < ints.length; i++)  {
			if(num == ints[i])  {
				return  i;
			}
		}

		return  -1;
	}
	/**
		<P>How many digits in length is the provided number?.</P>

		<P>An alternative method for determining the number of digits is to convert the number to a string, and then get the string's length (although you need to anticipate the possible dash, with negative numbers):</P>

		<PRE>((new Long(num)).toString()).length()</PRE>

		<P><FONT SIZE="-1"><I>The answer to &quot;how many digits does a number contain?&quot; is &quot;how many times can you divide ten into it?..plus one&quot;.</I></FONT></P>

		@param  num  The number you want to know the amount of digits in. Trailing zeros (zeros on the left side of the number) are ignored, however, the number zero is considered a one-digit number.
		@return  The number of digits in num. For example:<UL>
			<LI><B>10:</B>  Returns <B>2</B>.</LI>
			<LI><B>-94:</B>  Returns <B>2</B>.</LI>
			<LI><B>000037:</B>  Returns <B>2</B>.</LI>
			<LI><B>0:</B>  Returns <B>1</B></LI>
			<LI><B>687482:</B>  Returns <B>6</B></LI>
		</UL>
	 **/
	public static int getDigitLength(long num)  {
		//How many digits does this number contain?  It contains at least one.
		int iDigits = 1;

		if(num < 0)  {
			//The number is less than zero. The below divide-by-ten
			//will never work unless we positive-ize it.
			num = (num * -1);
		}

		//A temporary variable that holds the value of the divide-by-ten
		//answer. We don't care what the value is, as long as it's
		//GTOET 10.
		long lAnswerTEMP = num;

		while(lAnswerTEMP >= 10)  {
			//There's another digit.
			lAnswerTEMP = lAnswerTEMP / 10;
			iDigits++;
		}

		return  iDigits;
	}
	/**
		<P>Get a string-version of a double, with a specific-decimal precision.</P>

		@param  num  The double.
		@param  decimalPlace_count  The number of decimal places to return. May not be less than one.
		@param  do_rightZeroPad  Should zeros be padded to the right side of the returned string (to ensure the returned number always contains {@code decimalPlace_count} decimal places)? If true, yes. If false, no.
	 **/
	public static final String getPreciseDbl(double num, int decimalPlace_count, boolean do_rightZeroPad)  {
		if(decimalPlace_count < 1)  {
			throw  new IllegalArgumentException("decimalPlace_count (" + decimalPlace_count + ") is less than one.");
		}

		String sDbl = (new Double(num)).toString();

		int ixDec = sDbl.indexOf(".");
		if(ixDec == -1)  {
			return  do_rightZeroPad
				?  sDbl + getDuped("0", decimalPlace_count)
				:  sDbl;
		}

		int iDecPlacesNow = sDbl.length() - ixDec - 1;

		String sDblChopped = null;
		if(decimalPlace_count > iDecPlacesNow)  {
			//Not enough precision anyway.
			sDblChopped = sDbl;
		}  else  {
			//Too precise. Less precision necessary.
			sDblChopped = sDbl.substring(0, (ixDec + 1 + decimalPlace_count));
		}

		Double DChopped = new Double(sDblChopped);
		String sdAfterConvert = DChopped.toString();
//		double dChopped = DChopped.doubleValue();

		if(!do_rightZeroPad)  {
			return  sDblChopped;
		}

		iDecPlacesNow = sdAfterConvert.length() - sdAfterConvert.indexOf(".") - 1;
		return  sDblChopped + getDuped("0", (decimalPlace_count - iDecPlacesNow));
	}
		private static String getDuped(String to_duplicate, int total_dups)  {
			if(total_dups == 0)  {
				return  "";
			}

			StringBuilder sb = new StringBuilder();

			for(int i = 0; i < total_dups; i++)  {
				sb.append(to_duplicate);
			}

			return  sb.toString();
		}

	public static final boolean isEven(int num)  {
		return  ((num % 2) == 0);
	}
	public static final boolean isOdd(int num)  {
		return  ((num % 2) == 1);
	}
	/**
		<P>Get a random int.</P>

		@return  {@link #getRandomBetweenInclusive(int, int) getRandomBetweenInclusive(0, max)}
	public static final int getRandomInt(int max)  {
		return  getRandomBetweenInclusive(0, max);
	}
	 **/
	/**
		<P>Get a random int between (or equal to) two bounds.</P>

		@param  min_inclusive  The minimum possible int to return. <I>Should</I> be less than {@code max}.
		@param  max  The maximum possible int to return.
		@return  <CODE>(min_inclusive + (int)({@link java.lang.Math Math}.{@link java.lang.Math#random() random}() * ((max - min_inclusive) + 1)))</CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java">http://stackoverflow.com/questions/363681/generating-random-numbers-in-a-range-with-java</A></CODE>
	 **/
   public static final int getRandomBetweenInclusive(int min_inclusive, int max)  {
		return  (min_inclusive + (int)(Math.random() * ((max - min_inclusive) + 1)));
		/*
			//Alternative:

			if(min_inclusive > max)  {
				throw  new IllegalArgumentStateException("min_inclusive (" + min_inclusive + ") must be less than or equal to max (" + max + ").");
			}

			int i = ((new Double(Math.random() * 100000000)).intValue());

			try  {
				i = i % (max + 1 - min_inclusive);
			}  catch(ArithmeticException arithx)  {
				throw  new IllegalArgumentException("max (" + max + ") equals -1. Original exception: " + arithx.toString());
			}

			return  (i + min_inclusive);
		*/

	}
	/**
		<P>Get a random hexidecimal number as a String, using {@code Math.random()} at its core.</P>

		@param  digit_count  The number of digits the returned number should be. May not be less than zero.
		@param  do_useUpperLetters  If true, then all numbers above 9 (A, B, C, D, E, F) are returned as uppercase. If false, lowercase.
	 **/
	public static String getRandomHex(int digit_count, boolean do_useUpperLetters)  {
		if(digit_count < 0)  {

			throw  new IllegalArgumentException("digit_count (currently " + digit_count + ") is less than zero.");
		}

		char[] acHEX = null;
		if(do_useUpperLetters)  {
			acHEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		}  else  {
			acHEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < digit_count; i++)  {
			sb.append(acHEX[getRandomBetweenInclusive(0, 15)]);
		}

		return  sb.toString();
	}
	/**
	 * <p>Is the provided number evenly divisible only by itself and one?.</p>
	 *
	 * <p>This analyzes every odd number starting with three, the number's square root. If <code>num</code> is evenly divisible by any, this returns <code>false</code>.</p>
	 *
	 * @param  num The number that may or may not be prime.
	 * @return     <code>true</code> if the <code>num</code> is prime.
	 * @since 0.1.4.2
	 * @see http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java
	 */
	public static final boolean isPrime(long num)  {
		int sqrt = new Double(Math.sqrt(num)).intValue();

		//System.out.println("num=" + num + ", highestOddBelowSqrt=" + highestOddBelowSqrt);

		for(int i = 3; i <= sqrt; i += 2)  {
			if(num % i == 0)  {
				return  false;
			}
		}
		return  true;
	}

	private NumberUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
}


