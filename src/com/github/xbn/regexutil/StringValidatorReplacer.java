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
package  com.github.xbn.regexutil;
	import  com.github.xbn.analyze.validate.ValueValidatorAdapter;
	import  com.github.xbn.analyze.validate.z.SimpleValueValidator_F;
	import  com.github.xbn.analyze.validate.ValidResultFilter;
/**
   <P>Adapts a {@code RegexReplacer} into a string-validator, where <CODE><I>[RegexReplacer]</I>.wasJustMatched()</CODE> determines validity--The replacement is made available via {@link #getMostRecentReplaced() getMostRecentReplaced}{@code ()}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class StringValidatorReplacer extends ValueValidatorAdapter<String,RegexReplacer>  {
	private String sMROrig;
	private String sMRRplcd;
	private String sMR;
	/**
		<P>Create a new instance from a {@code RegexReplacer} and filter.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.validate.ValueValidatorAdapter#ValueValidatorAdapter(Object, ValueValidator_Fieldable) super}(replacer, fieldable))</CODE>
			<BR>Where {@code fieldable} is equal to
			<BR> &nbsp; &nbsp; <CODE>(new {@link com.github.xbn.analyze.validate.z.SimpleValueValidator_F#SimpleValueValidator_F(boolean, boolean, ValidResultFilter, Appendable, Object) SimpleValueValidator_F}(false, false, filter_doNothingIfNull, replacer.getDebugApbl()),
				null)</CODE></LI>
			<LI>{@link #resetStateSVR() resetStateSVR}{@code ()}</LI>
		</OL></P>

		@param  replacer  May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.ValueValidatorAdapter#getAdapted() getAdapted}{@code ()}*.
		@param  filter_doNothingIfNull  If {@code null}, then this string-validator is left {@link com.github.xbn.analyze.validate.NewValidResultFilterFor#unfiltered() unfiltered}. Get with {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}{@code ()}. <I><B>Warning:</B> If either the {@link com.github.xbn.analyze.validate.ValidResultFilter#getPreAction() pre-} or {@link com.github.xbn.analyze.validate.ValidResultFilter#getAfterValueFromInvertedRules(boolean) post-}filters return {@code true}</I> ({@link com.github.xbn.analyze.validate.FilterPreAction#RETURN_TRUE pre}, {@link com.github.xbn.analyze.validate.FilterAfterValue#TRUE post}), the original string will be returned unchanged--in the case of the pre-filter, the string will never be analayzed by the {@code RegexReplacer}.
		@see  #StringValidatorReplacer(StringValidatorReplacer)
	 **/
	public StringValidatorReplacer(RegexReplacer replacer, ValidResultFilter filter_doNothingIfNull)  {
		super(replacer,
			(new SimpleValueValidator_F(false, false, filter_doNothingIfNull,
				(replacer == null  ?  null
					:  replacer.getDebugApbl()),
				null)));
		resetStateSVR();
	}
	/**
		<P>Create a new instance as a duplicate of another.</P>

		<P>This<OL>
			<LI>Calls {@link com.github.xbn.analyze.validate.ValueValidatorAdapter#ValueValidatorAdapter(ValueValidatorAdapter) super}{@code (to_copy)}</LI>
			<LI>Sets<OL>
				<LI>{@link #getMostRecentOriginal() getMostRecentOriginal}{@code ()} to {@code to_copy.getMostRecentOriginal()}</LI>
				<LI>{@link #getMostRecentReplaced() getMostRecentReplaced}{@code ()} to {@code to_copy.getMostRecentReplaced()}</LI>
				<LI>{@link #getMostRecent() getMostRecent}{@code ()} to {@code to_copy.getMostRecent()}</LI>
			</OL></LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #StringValidatorReplacer(RegexReplacer, ValidResultFilter)
	 **/
	public StringValidatorReplacer(StringValidatorReplacer to_copy)  {
		super(to_copy);
		sMROrig = to_copy.getMostRecentOriginal();
		sMRRplcd = to_copy.getMostRecentReplaced();
		sMR = to_copy.getMostRecent();
	}
	/**
		<P>Is a string matched (replaced) by the {@code RegexReplacer}?.</P>

		<P>This<OL>
			<LI>Sets {@link #getMostRecentOriginal() getMostRecentOriginal}{@code ()} to {@code to_match}</LI>
			<LI>Sets {@link #getMostRecentReplaced() getMostRecentReplaced}{@code ()} to <CODE>{@link com.github.xbn.analyze.validate.ValueValidatorAdapter#getAdapted() getAdapted}().{@link com.github.xbn.regexutil.RegexReplacer#getReplaced(Object) getReplaced}(to_match)</CODE></LI>
			<LI>Sets {@link #getMostRecentOriginal() getMostRecentOriginal}{@code ()} to {@code getMostRecentReplaced()}</LI>
		</OL></P>

		@param  to_match  The string to search. May not be {@code null}.
		@return  <CODE>getAdapted().{@link com.github.xbn.regexutil.RegexReplacer#wasJustMatched() wasJustMatched}()</CODE>
		@see   <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/validate/ValueValidator#isValid(V, A)">isValid</A>(V,A)</CODE>
		@see  #adjustForPostFilterReturnValue(boolean)
	 **/
	public boolean doesFollowRulesPreInvert(String to_match)  {
		sMROrig = to_match;
		sMRRplcd = getAdapted().getReplaced(to_match);

		//Assume the post-filter will return getAdapted().wasJustMatched() UNCHANGED
		//If not, sMR will be adjusted in adjustForPostFilterReturnValue(b)
		sMR = sMRRplcd;

		return  getAdapted().wasJustMatched();
	}
	/**
		<P>Adjusts internal state in the case that the string was matched and replaced, but the post-filter reversed that decision.</P>

		@param  isValid_fromPostFilter  If {@code false}, then {@link #getMostRecent() getMostRecent}{@code ()} is set to {@link #getMostRecentOriginal() getMostRecentOriginal}{@code ()}.
	 **/
	public void adjustForPostFilterReturnValue(boolean isValid_fromPostFilter)  {
		if(!isValid_fromPostFilter)  {
			sMR = getMostRecentOriginal();
		}
	}
 	/**
 		<P>Reset state to as if a validation/replacement was never done.</P>

 		<P>This calls<OL>
 			<LI><CODE>{@link com.github.xbn.analyze.validate.ValueValidatorAdapter super}.{@link com.github.xbn.analyze.validate.ValueValidatorAdapter#resetState() resetState}()</CODE></LI>
 			<LI>{@link #resetStateSVR() resetStateSVR}{@code ()}</LI>
 		</OL></P>
 	 **/
 	public void resetState()  {
		super.resetState();
		resetStateSVR();
	}
	/**
		<P>Reset state specific to this {@code StringValidatorReplacer}.</P>

		<P>This sets the following to {@code null}: {@link #getMostRecentOriginal() getMostRecentOriginal}{@code ()}, {@link #getMostRecentReplaced() getMostRecentReplaced}{@code ()}, {@link #getMostRecent() getMostRecent}{@code ()}</P>

 		@see  #resetState()
	 **/
	protected void resetStateSVR()  {
		sMROrig = null;
		sMRRplcd = null;
		sMR = null;
	}

	/**
		<P>The original string most-recently analyzed by {@code doesFollowRulesPreInvert(s)}.</P>

		@return  {@code null}  If {@link #doesFollowRulesPreInvert(String) doesFollowRulesPreInvert}{@code (s)} was never called, or {@link #resetState() resetState}{@code ()} was more recently called.
		@see  #getMostRecent()
	 **/
	public String getMostRecentOriginal()  {
		return  sMROrig;
	}
	/**
		<P>YYY</P>

		@see  #getMostRecent()
	 **/
	public String getMostRecentReplaced()  {
		return  sMRRplcd;
	}
	/**
		<P>Get the <I>resulting string</I> from the most-recent analysis.</P>

		@return <UL>
			<LI>{@link #getMostRecentOriginal() getMostRecentOriginal}{@code ()}: if the string was not matched, or that decision was {@link #adjustForPostFilterReturnValue(boolean) overridden} by the post-filter.</LI>
			<LI>{@link #getMostRecentReplaced() getMostRecentReplaced}{@code ()}, if the string was matched.</LI>
		</UL>
		@see  #doesFollowRulesPreInvert(String)
	 **/
	public String getMostRecent()  {
		return  sMR;
	}
	/**
		<P>Turn debugging output on or off, and set the destination.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.validate.AbstractValidator super}.{@link com.github.xbn.analyze.validate.AbstractValidator#setDebug(Appendable, boolean) setDebug}(destination, is_on)</CODE></LI>
			<LI><CODE>{@link com.github.xbn.analyze.validate.ValueValidatorAdapter#getAdapted() getAdapted}()*.{@link com.github.xbn.io.Debuggable#setDebug(Appendable, boolean) setDebug}(destination, is_on)</CODE></LI>
		</OL></P>
		@see  #setDebugOn(boolean)
	 **/
	public void setDebug(Appendable destination, boolean is_on)  {
		super.setDebug(destination, is_on);
		getAdapted().setDebug(destination, is_on);
	}
	/**
		<P>Turn debugging output on or off.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.validate.AbstractValidator super}.{@link com.github.xbn.analyze.validate.AbstractValidator#setDebugOn(boolean) setDebugOn}(is_on)</CODE></LI>
			<LI><CODE>{@link com.github.xbn.analyze.validate.ValueValidatorAdapter#getAdapted() getAdapted}()*.{@link com.github.xbn.io.Debuggable#setDebugOn(boolean) setDebugOn}(is_on)</CODE></LI>
		</OL></P>

		@see  #setDebug(Appendable, boolean)
	 **/
	public void setDebugOn(boolean is_on)  {
		super.setDebugOn(is_on);
		getAdapted().setDebugOn(is_on);
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  super.appendToString(to_appendTo);
	}
	/**
		<P>Duplicate this <CODE>StringValidatorReplacer</CODE>.</P>

		@return  <CODE>(new <A HREF="#StringValidatorReplacer(StringValidatorReplacer)">StringValidatorReplacer</A>(this))</CODE>
	 **/
	public StringValidatorReplacer getObjectCopy()  {
		return  (new StringValidatorReplacer(this));
	}
}
