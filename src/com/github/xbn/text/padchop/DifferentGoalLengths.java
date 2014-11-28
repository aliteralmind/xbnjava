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
package  com.github.xbn.text.padchop;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>When creating a {@code VzblPadChop}, if the goal lengths in the {@code PadString} and {@code ChopString} are different, what action should be taken?.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum DifferentGoalLengths  {
	/**
		<P>If the goal lengths are different, leave them that way. The goal-length must be explicitely specified by the int-parameter with each call to <CODE>{@link VzblPadChop}.{@link VzblPadChop#appendX(Appendable, int, Object) appendX}(apbl,i,O)</CODE>.</P>

		@see  #CRASH
		@see  #USE_PAD
		@see  #USE_CHOP
		@see  #USE_NON_NEG_1
		@see  #doIgnore()
	 **/
	IGNORE,
	/**
		<P>If the goal lengths of the {@code PadString} and {@code ChopString} are different, crash with an {@link com.github.xbn.lang.IllegalArgumentStateException}.</P>

		@see  #IGNORE
		@see  #doCrash()
	 **/
	CRASH,
	/**
		<P>If the goal lengths are different, use the {@code PadString}'s goal length. If it happens to be {@code -1}, using this setting will result in an {@code IllegalStateException}.</P>

		@see  #IGNORE
		@see  #doUsePad()
	 **/
	USE_PAD,
	/**
		<P>If the goal lengths are different, use the {@code ChopString}'s goal length. If it happens to be {@code -1}, using this setting will result in an {@code IllegalStateException}.</P>

		@see  #IGNORE
		@see  #doUseChop()
	 **/
	USE_CHOP,
	/**
		<P>If the goal lengths are different, use whichever goal length is not {@code -1}. If both happen to be {@code -1}, using this setting will result in an {@code IllegalStateException}.</P>

		@see  #IGNORE
		@see  #doUseNonNeg1()
	 **/
	USE_NON_NEG_1;
	/**
		<P>Is this {@code DifferentGoalLengths} equal to {@code IGNORE}?.</P>

		@return  <CODE>this == {@link #IGNORE}</CODE>

		@see  #doCrash()
		@see  #doUsePad()
		@see  #doUseChop()
		@see  #doUseNonNeg1()
	 **/
	public final boolean doIgnore()  {
		return  this == IGNORE;
	}
	/**
		<P>Is this {@code DifferentGoalLengths} equal to {@code CRASH}?.</P>

		@return  <CODE>this == {@link #CRASH}</CODE>

		@see  #doIgnore()
	 **/
	public final boolean doCrash()  {
		return  this == CRASH;
	}
	/**
		<P>Is this {@code DifferentGoalLengths} equal to {@code USE_PAD}?.</P>

		@return  <CODE>this == {@link #USE_PAD}</CODE>

		@see  #doIgnore()
	 **/
	public final boolean doUsePad()  {
		return  this == USE_PAD;
	}
	/**
		<P>Is this {@code DifferentGoalLengths} equal to {@code USE_PAD}?.</P>

		@return  <CODE>this == {@link #USE_PAD}</CODE>

		@see  #doIgnore()
	 **/
	public final boolean doUseChop()  {
		return  this == USE_PAD;
	}
	/**
		<P>Is this {@code DifferentGoalLengths} equal to {@code USE_NON_NEG_1}?.</P>

		@return  <CODE>this == {@link #USE_NON_NEG_1}</CODE>

		@see  #doIgnore()
	 **/
	public final boolean doUseNonNeg1()  {
		return  this == USE_NON_NEG_1;
	}
	/**
		<P>If an <CODE>DifferentGoalLengths</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, pcgl_da, this_enumsVarName, &quot;DifferentGoalLengths&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfForbiddenValue(DifferentGoalLengths, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(DifferentGoalLengths pcgl_da, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, pcgl_da, this_enumsVarName, xtra_errInfo);
	}
	/**
		<P>If an <CODE>DifferentGoalLengths</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, pcgl_da, this_enumsVarName, &quot;DifferentGoalLengths&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(DifferentGoalLengths, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(DifferentGoalLengths pcgl_da, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, pcgl_da, this_enumsVarName, xtra_errInfo);
	}
}