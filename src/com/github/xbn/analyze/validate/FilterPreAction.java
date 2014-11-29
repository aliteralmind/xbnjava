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
	<p>Action taken by the {@link ValidResultFilter} <b><u>before</u></b> the <i>something</i> is ever analyzed against the rules.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum FilterPreAction {
	/**
		<p>Return true--do not validate the <i>something</i> against the rules.</p>

		<p>This causes the validation function, such as <code><i>{@link ValueValidator}</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="ValueValidator.html#isValid(O)">isValid</a>(O)</code>, to return {@code true} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis} and {@link com.github.xbn.analyze.validate.Validator#getValidCount() valid} counts.</p>

		@see  #RETURN_FALSE
		@see  #PROCEED
		@see  #isReturnTrue()
	 **/
	RETURN_TRUE,
	/**
		<p>Return false--do not validate the <i>something</i> against the rules.</p>

		<p>This causes the validation function, such as <code><i>{@link ValueValidator}</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="ValueValidator.html#isValid(O)">isValid</a>(O)</code>, to return {@code false} (it is never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}) and increases the {@link com.github.xbn.analyze.Analyzer#getAnalyzedCount() analysis count}.</p>

		@see  #RETURN_TRUE
		@see  #isReturnFalse()
	 **/
	RETURN_FALSE,
	/**
		<p>Validate the <i>something</i> against the rules.</p>

		<p>This causes the <i>something</i> to be validated against the rules, after which, the {@link FilterAfterValue post filter} decides the final return value.</p>

		@see  #RETURN_TRUE
		@see  #isProceed()
	 **/
	PROCEED;
	/**
		<p>Is this {@code FilterPreAction} equal to {@code RETURN_TRUE}?.</p>

		@return  <code>this == {@link #RETURN_TRUE}</code>

		@see  #isReturnFalse()
		@see  #isProceed()
	 **/
	public final boolean isReturnTrue()  {
		return  this == RETURN_TRUE;
	}
	/**
		<p>Is the pre-action to return either {@code true} or {@code false}?</p>

		@return  <code>({@link #isReturnTrue() isReturnTrue}()  ||  {@link #isReturnFalse() isReturnFalse}())</code>
		@see  #getReturnValue()
	 **/
	public final boolean isReturn()  {
		return  (isReturnTrue()  ||  isReturnFalse());
	}

	/**
		<p>Get the return value based on the value of this {@code FilterPreAction}.</p>

		@return  <ul>
			<li>{@code true}: If {@link #isReturnTrue() isReturnTrue}{@code ()} is {@code true}.</li>
			<li>{@code false}: If {@link #isReturnFalse() isReturnFalse}{@code ()} is {@code true}.</li>
		</ul>
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
		<p>Is this {@code FilterPreAction} equal to {@code RETURN_FALSE}?.</p>

		@return  <code>this == {@link #RETURN_FALSE}</code>
		@see  #isReturnTrue()
	 **/
	public final boolean isReturnFalse()  {
		return  this == RETURN_FALSE;
	}
	/**
		<p>Is this {@code FilterPreAction} equal to {@code PROCEED}?.</p>

		@return  <code>this == {@link #PROCEED}</code>
		@see  #isReturnTrue()
		@see  #isReturnFalse()
	 **/
	public final boolean isProceed()  {
		return  this == PROCEED;
	}
	/**
		<p>If an <code>FilterPreAction</code> is not a required value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, rqd_value, this_enumsVarName, &quot;FilterPreAction&quot;, xtra_errInfo)</code></p>
		@see  #crashIfForbiddenValue(FilterPreAction, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(FilterPreAction rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
	/**
		<p>If an <code>FilterPreAction</code> is a forbidden value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, rqd_value, this_enumsVarName, &quot;FilterPreAction&quot;, xtra_errInfo)</code></p>
		@see  #crashIfNotRequiredValue(FilterPreAction, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(FilterPreAction rqd_value, String this_enumsVarName, Object xtra_errInfo)  {
		EnumUtil.crashIfForbiddenValue(this, rqd_value, this_enumsVarName, xtra_errInfo);
	}
};
