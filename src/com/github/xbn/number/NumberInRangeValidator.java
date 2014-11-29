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
	import  com.github.xbn.analyze.validate.NullnessValidator;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.RuleType;
	import  com.github.xbn.number.NumberInRange;
	import  com.github.xbn.number.z.NumberInRangeValidator_Fieldable;
	import  static com.github.xbn.lang.CrashIfBase.*;
/**
	<p>{@code ValueValidator} for testing a number's {@code null}-ness and that it is in a {@code NumberInRange}.</p>

	@see  NumberInRange
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class NumberInRangeValidator<N extends Number> extends NullnessValidator<N>  {
	private final NumberInRange<N> nir;

//constructors...START
	/**
		<p>Create a new and unrestricted instance.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link #NumberInRangeValidator(RuleType, NumberInRangeValidator_Fieldable) this}(NumberInRangeValidator.getRuleTypeFromFieldsVNIR(filter), filter)</code></p>
	 **/
	public NumberInRangeValidator(NumberInRangeValidator_Fieldable<N,? extends NumberInRange<N>> filter)  {
		this(NumberInRangeValidator.getRuleTypeFromFieldsVNIR(filter), filter);
	}
	protected NumberInRangeValidator(RuleType type, NumberInRangeValidator_Fieldable<N,? extends NumberInRange<N>> filter)  {
		super(type, filter);

		nir = filter.getRange();
		if(nir == null)  {
			throw  new NullPointerException("filter.getRange()");
		}
	}
	/**
		<p>Create a new {@code NumberInRangeValidator} as a duplicate of another.</p>

		<p>This<ol>
			<li>Calls {@link NullnessValidator#NullnessValidator(ValueValidator) super}{@code (to_copy)}</li>
			<li>Sets {@link #getRange() getRange}{@code ()} to <code>to_copy.{@link #getRange() getRange}()</code></li>
		</ol></p>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
		@see  #NumberInRangeValidator(NumberInRangeValidator_Fieldable) NumberInRangeValidator(vnir.cfn)
	 **/
	public NumberInRangeValidator(NumberInRangeValidator<N> to_copy)  {
		super(to_copy);
		nir = to_copy.getRange();
	}
//constructors...END
//getters...START
	/**
		<p>Get the current number-range.</p>

		@return  {@code range}, as provided to .......
	 **/
	public NumberInRange<N> getRange()  {
		return  nir;
	}

	public StringBuilder appendRules(StringBuilder to_appendTo)  {
		try  {
			to_appendTo.append(getRange());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}

		to_appendTo.append(", null-" + (isNullOk() ? "ok" : "bad"));

		if(doInvertRules())  {
			to_appendTo.append(", doInvertRules()=true");
		}

		if(!getFilter().doesNothing())  {
			to_appendTo.append(", filter: ");
			getFilter().appendToString(to_appendTo);
		}

		return  to_appendTo;
	}
//getters...END
//ValueValidator...START
	/**
		<p>Is the number within the specified range?.</p>

		@see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="crashIfBadValue(N, java.lang.String)">crashIfBadValue</a>(N,s)</code>
	 **/
	public boolean doesFollowRulesPreInvert(N to_validate)  {
		if(!super.doesFollowRulesPreInvert(to_validate))  {
			return  false;
		}

		if(to_validate == null)  {
			if(isDebugOn()) { getDebugAptr().appentln("<VNIR>   doesFollowRulesPreInvert(to_validate): super is true and to_validate is null. Returning true."); }
			return  true;
		}

		if(isDebugOn()) { getDebugAptr().appentln("<VNIR>   doesFollowRulesPreInvert(to_validate): super is true and to_validate is non-null. Returning validity: <<<to_validate=" + getRange().getDebuggingForIsIn(to_validate) + ">>>"); }
		return  getRange().isIn(to_validate);
	}
//ValueValidator...END
	public static final <N extends Number> RuleType getRuleTypeFromFieldsVNIR(NumberInRangeValidator_Fieldable<N,? extends NumberInRange<N>> filter)  {
		RuleType ert = getRuleTypeFromFieldsVVN(filter);
		try  {
			return  (ert.isImpossible() ? ert : filter.getRange().getRuleType());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(filter.getRange(), "filter.getRange()", null, rx);
		}
	}
	/**
		<p>Get the error message needed by {@code crashIfBadValue(N,s)}.</p>

		@return  {@link com.github.xbn.lang.CrashIfBase#getXMsg(String, Object) getXMsg}{@code (..., xtra_errInfo)}
		@see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="crashIfBadValue(N, java.lang.String)">crashIfBadValue</a>(N,s)</code>
	 **/
	public static final <N extends Number,G extends NumberInRangeValidator<N>> String getVNIRXMsg(G range, N to_validate, String val_name)  {
		try  {
			return  getXMsg(val_name + " (currently " + to_validate + ") is not valid. getRules()=\"" + range.getRules() + '\"', range.getExtraErrInfo());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
		}
	}
}
