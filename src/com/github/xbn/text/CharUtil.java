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
package  com.github.xbn.text;
	import  com.github.xbn.lang.CrashIfObject;
	import  org.apache.commons.lang3.StringEscapeUtils;
	import  java.util.Arrays;
/**
	<P>Duplicate and unescape a character, and find one in an array.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CharUtil  {
	private CharUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	public static final char getFromOneCharString(String potential_char, String potentialChar_name)  {
		try  {
			if(potential_char.length() != 1)  {
				throw  new IllegalArgumentException(potentialChar_name + " (\"" + potential_char + "\") does not have exactly one character.");
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(potential_char, potentialChar_name, null, rx);
		}
		return  potential_char.charAt(0);
	}

	/**
		<P>XXX</P>
	 **/
	public static final String getDuped(char chr, int total_dups)  {
		StringBuilder sd = new StringBuilder();
		return  appendDuped(sd, chr, total_dups).toString();
	}
	/**
		<P>XXX</P>
	 **/
	public static final StringBuilder appendDuped(StringBuilder to_appendTo, char chr, int total_dups)  {
		if(total_dups < 1)  {
			return  to_appendTo;
		}

		try  {
			to_appendTo.setLength(to_appendTo.length() + total_dups);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}

		for(int i = 0; i < total_dups; i++)  {
			to_appendTo.append(chr);
		}

		return  to_appendTo;
	}
	/**
		<P>Is the char in the char-array?.</P>

		@return  <CODE>({@link #getFoundIdx(char, char[]) getFoundIdx}(to_find, to_search) &gt; -1)</CODE>
	 **/
	public static final boolean isIn(char to_find, char[] to_search)  {
		return  (getFoundIdx(to_find, to_search) > -1);
	}
	/**
		<P>Is the char in the char-array?.</P>

		@return  <CODE>({@link #getFoundIdx(char, char[], boolean) getFoundIdx}(to_find, to_search, do_orderAsc) &gt; -1)</CODE>
	 **/
	public static final boolean isIn(char to_find, char[] to_search, boolean do_orderAsc)  {
		return  (getFoundIdx(to_find, to_search, do_orderAsc) > -1);
	}
	/**
		<P>Get the (first) index at which a char exists in a char-array.</P>

		@return  {@link #getFoundIdx(char, char[], boolean) getFoundIdx(to_find, to_search, true)}
	 **/
	public static final int getFoundIdx(char to_find, char[] to_search)  {
		return  getFoundIdx(to_find, to_search, true);
	}
	/**
		<P>Get the (first) index at which a char exists in a char-array.</P>

		@param  to_find  The char to analyze.
		@param  to_search  The array which {@code to_find} should be in. May not be null, and, if {@code do_orderAsc} is true, <I>should</I> be non-empty, unique, and sorted ascending. If not, this function will not work properly.
		@param  do_orderAsc  If true, then <CODE>{@link java.util.Arrays}.{@link java.util.Arrays#binarySearch(char[], char) binarySearch}(c[],c)</CODE> is used to search the array. If false, a for loop is used.
		@return  The first index in {@code to_search} at which {@code to_find} exists.
		<BR>{@code <B>-1</B>} If it doesn't.
	 **/
	public static final int getFoundIdx(char to_find, char[] to_search, boolean do_orderAsc)  {
		if(to_search == null)  {
			throw  new NullPointerException("to_search");
		}

		if(do_orderAsc)  {
			return  Arrays.binarySearch(to_search, to_find);
		}

		for(int i = 0; i < to_search.length; i++)  {
			if(to_find == to_search[i])  {
				return  i;
			}
		}

		return  -1;
	}
	public static final String getVisible(Character chr)  {
		if(chr == null)  {
			return  "null";
		}
		return  StringEscapeUtils.escapeJava(chr.toString());
	}
}