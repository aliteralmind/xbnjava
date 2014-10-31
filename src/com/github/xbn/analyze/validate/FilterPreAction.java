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
package  com.github.xbn.analyze.validate;
	import  com.github.xbn.util.EnumUtil;
/**
	<P>Action taken by the {@link ValidResultFilter} <B><U>before</U></B> the <I>something</I> is ever analyzed against the rules.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public enum FilterPreAction {
	/**
		<P>Return true--do not validate the <I>something</I> against the rules.</P>

		<P>This causes the validation function, such as <CODE><I>{@link ValueValidator}</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ValueValidator.html#isValid(O)">isValid</A>(O)</CODE>, to return {@code true} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis} and {@link com.github.xbn.analyze.validate.Validator#getValidCount() valid} counts.</P>

		@see  #RETURN_FALSE
		@see  #PROCEED
		@see  #isReturnTrue()
	 **/
	RETURN_TRUE,
	/**
		<P>Return false--do not validate the <I>something</I> against the rules.</P>

		<P>This causes the validation function, such as <CODE><I>{@link ValueValidator}</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="ValueValidator.html#isValid(O)">isValid</A>(O)</CODE>, to return {@code false} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis count}.</P>

		@see  #RETURN_TRUE
		@see  #isReturnFalse()
	 **/
	RETURN_FALSE,
	/**
		<P>Validate the <I>something</I> against the rules.</P>

		<P>This causes the <I>something</I> to be validated against the rules, after which, the {@link FilterAfterValue post filter} decides the final return value.</P>

		@see  #RETURN_TRUE
		@see  #isProceed()
	 **/
	PROCEED;
	/**
		<P>Is this {@code FilterPreAction} equal to {@code RETURN_TRUE}?.</P>

		@return  <CODE>this == {@link #RETURN_TRUE}</CODE>

		@see  #isReturnFalse()
		@see  #isProceed()
	 **/
	public final boolean isReturnTrue()  {
		return  this == RETURN_TRUE;
	}
	/**
		<P>Is the pre-action to return either {@code true} or {@code false}?</P>

		@return  <CODE>({@link #isReturnTrue() isReturnTrue}()  ||  {@link #isReturnFalse() isReturnFalse}())</CODE>
		@see  #getReturnValue()
	 **/
	public final boolean isReturn()  {
		return  (isReturnTrue()  ||  isReturnFalse());
	}

	/**
		<P>Get the return value based on the value of this {@code FilterPreAction}.</P>

		@return  <UL>
			<LI>{@code true}: If {@link #isReturnTrue() isReturnTrue}{@code ()} is {@code true}.</LI>
			<LI>{@code false}: If {@link #isReturnFalse() isReturnFalse}{@code ()} is {@code true}.</LI>
		</UL>
		@exception  IllegalStateException  If this is equal to {@link #PROCEED}
	 **/
	public final boolean getReturnValue()  {
		if(isReturnTrue())  {
			return  true;
		}
		if(isReturnFalse())  {
			return  false;
		}
		throw  new IllegalStateException("this is equal to PROCEED (isReturn() is false).");
	}
	/**
		<P>Is this {@code FilterPreAction} equal to {@code RETURN_FALSE}?.</P>

		@return  <CODE>this == {@link #RETURN_FALSE}</CODE>
		@see  #isReturnTrue()
	 **/
	public final boolean isReturnFalse()  {
		return  this == RETURN_FALSE;
	}
	/**
		<P>Is this {@code FilterPreAction} equal to {@code PROCEED}?.</P>

		@return  <CODE>this == {@link #PROCEED}</CODE>
		@see  #isReturnTrue()
		@see  #isReturnFalse()
	 **/
	public final boolean isProceed()  {
		return  this == PROCEED;
	}
	/**
		<P>If an <CODE>FilterPreAction</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;FilterPreAction&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfForbiddenValue(FilterPreAction, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(FilterPreAction rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
	/**
		<P>If an <CODE>FilterPreAction</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;FilterPreAction&quot;, xtra_errInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(FilterPreAction, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(FilterPreAction rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
};
