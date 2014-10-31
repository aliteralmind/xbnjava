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
package  com.github.xbn.util;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.io.NewTextAppenterFor;
	import  com.github.xbn.io.TextAppenter;
	import  com.github.xbn.lang.IllegalArgumentStateException;
/**
	<P>If an error occurs, should it be logged or thrown in an exception?.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum IfError  {
	/**
		<P>YYY.</P>

		@see  #CRASH
		@see  #isWarn()
	 **/
	WARN,
	/**
		<P>YYY.</P>

		@see  #WARN
		@see  #isCrash()
	 **/
	CRASH;
	/**
		<P>Is this {@code IfError} equal to {@code WARN}?.</P>

		@return  <CODE>this == {@link #WARN}</CODE>

		@see  #isCrash()
	 **/
	public final boolean isWarn()  {
		return  this == WARN;
	}
	/**
		<P>Is this {@code IfError} equal to {@code CRASH}?.</P>

		@return  <CODE>this == {@link #CRASH}</CODE>
		@see  #isWarn()
	 **/
	public final boolean isCrash()  {
		return  this == CRASH;
	}
	/**
		<P>Return {@code IfError.CRASH} if the flag is {@code true}, or {@code WARN} if {@code false}.</P>

		@return  <CODE>(flag ? {@link #CRASH} : {@link #WARN})</CODE>
	 **/
	public static final IfError getCRASHIfTrue(boolean flag)  {
		return  (flag ? CRASH : WARN);
	}
	/**
		<P>Get a debug appenter from an appendable, and crash if the appendable is {@code null} and <I>this</I> is {@code WARN}. Useful for when errors are logged but no exceptions are thrown. This assures that the error is logged.</P>

		@param  debugError_ifNonNull  The destination for the warning message. If <CODE>this.{@link #WARN}</CODE>, then this parameter may not be {@code null}.
		@param  debugError_varName  Descriptive name for {@code debugError_ifNonNull}.
		@exception  NullPointerException  If {@code if_error.WARN} and {@code debugError_varName} is {@code null}.
	 **/
	public TextAppenter newAptrForApblCrashIfWarn(Appendable debugError_ifNonNull, String debugError_varName)  {
		if(isWarn()  &&  debugError_ifNonNull == null)  {
			throw  new IllegalArgumentStateException("this.WARN and " + debugError_varName + " is null.");
		}
		return  NewTextAppenterFor.appendable(debugError_ifNonNull);
	}
	/**
		<P>Prints the warning message, and crashes if {@code IfError.WARN} and the appendable is {@code null}.</P>

		@param  if_error  May not be {@code null}.
		@param  ifError_varName  Descriptive name for {@code if_error}. <I>Should</I> not be {@code null} or empty.
		@param  message  The error message. <I>Should</I> not be {@code null} or empty. When output via {@code debugError_ifNonNull}, {@code "Warning: "} is prepended.
		@param  cause  May not be {@code null}.
	 **/
	public static final void printWarning_crashIfApblNull(String message, Throwable cause, IfError if_error, String ifError_varName, Appendable debugError_ifNonNull, String debugError_varName)  {
		try  {
			if_error.newAptrForApblCrashIfWarn(debugError_ifNonNull, debugError_varName).
				appentln("Warning: " + message + ((cause == null) ? "" : ": " + cause));
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(if_error, ifError_varName, null, rx);
		}
	}
};