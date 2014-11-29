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
	import  com.github.xbn.lang.IllegalArgumentStateException;
	import  static com.github.xbn.lang.CrashIfBase.*;
/**
	<p>Crash if an int is less or greater than another number.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class CrashIfIntIs  {//extends CrashIfObject  {
	public static final void lessThanZero(int num, String num_name, Object xtra_errInfo)  {
		lessThan(num, 0, num_name, null, xtra_errInfo);
	}
	public static final void lessThan(int num, int min, String num_name, String min_name, Object xtra_errInfo)  {
		if(num < min)  {
			throw  new IllegalArgumentStateException(getXMsg(
				num_name + " (" + num + ") is less than " +
				((min_name == null)
					?  (new Integer(min)).toString()
					:  min_name + " (" + min + ")"),
				xtra_errInfo));

		}
	}
	/*
		<p>If a minimum number is greater than a maximum, crash.</p>

		@param  num  The int to test.
		@param  max  The maximum bound.
		@exception  IllegalArgumentException  If {@code num} is greater than {@code max}. Its message is constructed by {@link com.github.xbn.lang.CrashIfBase#getXMsg(String, Object) getXMsg}{@code (s,o)}
	public static final CrashIfIntIs greaterThan(int num, int max, String num_name, String max_nameName, Object xtra_errInfo)  {
		if(num > max)  {
			throw  new IllegalArgumentStateException(getXMsg(num_name + " (" + num + ") is greater than " + gtBndPstMaybeName(max_nameName, max), xtra_errInfo));
		}
		return  INSTANCE;
	}
	public static final CrashIfIntIs greaterThanOE(int num, int max_exclusive, String num_name, String max_nameName, Object xtra_errInfo)  {
		if(num >= max_exclusive)  {
			return  INSTANCE;
		}
		throw  new IllegalArgumentStateException(getXMsg(num_name + " (" + num + ") is greater-than-or-equal-to " + gtBndPstMaybeName(max_nameName, max_exclusive), xtra_errInfo));
	}
	public static final CrashIfIntIs lessThanOE(int num, int min_exclusive, String num_name, String min_name, Object xtra_errInfo)  {
		if(num <= min_exclusive)  {
			return  INSTANCE;
		}
		throw  new IllegalArgumentStateException(getXMsg(num_name + " (" + num + ") is less-than-or-equal-to " + gtBndPstMaybeName(min_name, min_exclusive), xtra_errInfo));
	}
	private static final String gtBndPstMaybeName(String name, int value)  {
		return  ((name == null)
				?  (new Integer(value)).toString()
				:  name + " (" + value + ")");

	}
	 */


	public static final RuntimeException lessThanZeroOrReturnCause(int num, String num_name, Object xtra_errInfo, RuntimeException cause)  {
		lessThanZero(num, num_name, xtra_errInfo);
		return  regetRtxCrashIfNull(cause, "cause");
	}
/*
	public static final RuntimeException greaterThanOrReturnCause(int num, int max, String num_name, String max_nameName, Object xtra_errInfo, RuntimeException cause)  {
		greaterThan(num, max, num_name, max_nameName, xtra_errInfo);
		return  regetRtxCrashIfNull(cause, "cause");
	}
	public static final RuntimeException lessThanOrReturnCause(int num, int min, String num_name, String min_name, Object xtra_errInfo, RuntimeException cause)  {
		lessThan(num, min, num_name, min_name, xtra_errInfo);
		return  regetRtxCrashIfNull(cause, "cause");
	}
	public static final RuntimeException greaterThanOEOrReturnCause(int num, int max_exclusive, String num_name, String max_nameName, Object xtra_errInfo, RuntimeException cause)  {
		greaterThanOE(num, max_exclusive, num_name, max_nameName, xtra_errInfo);
		return  regetRtxCrashIfNull(cause, "cause");
	}
	public static final RuntimeException lessThanOEOrReturnCause(int num, int min_exclusive, String num_name, String min_name, Object xtra_errInfo, RuntimeException cause)  {
		lessThanOE(num, min_exclusive, num_name, min_name, xtra_errInfo);
		return  regetRtxCrashIfNull(cause, "cause");
	}
 */
}