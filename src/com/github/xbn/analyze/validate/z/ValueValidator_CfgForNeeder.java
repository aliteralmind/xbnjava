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
package  com.github.xbn.analyze.validate.z;
	import  com.github.xbn.analyze.validate.ValidResultFilter;
	import  com.github.xbn.analyze.validate.NullnessValidator;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.neederneedable.Needer;
/**
	<P>For indirectly configuring a {@link NullnessValidator}.</P>

	@see  <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A>
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValueValidator_CfgForNeeder<O,V extends ValueValidator<O>,R extends Needer> extends Validator_CfgForNeederBase<V,R> implements ValueValidator_Fieldable  {
	public boolean bNullOk = false;
//constructors...START
	/**
		<P>YYY</P>

		<P>This calls<OL>
			<LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="zAbstractValidato_CfgForNeeder.html#zAbstractValidato_CfgForNeeder(boolean, boolean, R)">super</A>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</CODE></LI>
			<LI>{@link #nullOk(boolean) nullOk}{@code (true)}</LI>
		</OL></P>
	 **/
	public ValueValidator_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
		super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
		resetVVN();
	}
	/**
		<P>Reset configuration so that <I>anything</I> is valid.</P>

		<P>This calls<OL>
			<LI><CODE>{@link com.github.xbn.analyze.validate.z.Validator_CfgForNeederBase}.{@link com.github.xbn.analyze.validate.z.Validator_CfgForNeederBase#reset() reset}()</CODE></LI>
			<LI>{@link #resetVVN() resetVVN}{@code ()}</LI>
		</OL></P>

		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> reset()  {
		super.reset();
		resetVVN();
		return  this;
	}
	/**
		<P>Reset configuration specific to this {@code ValueValidator_CfgForNeeder}.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link #nullOk(boolean)}{@code (true)}</P>
	 **/
	protected final void resetVVN()  {
		nullOk(true);
	}
//constructors...END
//setters...START
	/**
		<P>Declare if the rules (if {@code null}-ness is okay) should be inverted.</P>

		@param  do_invert  If {@code true}, the rules are inverted. Get with {@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}{@code ()}*
		@return  <I>{@code this}</I>
		@see  com.github.xbn.analyze.validate.NullnessValidator#getRuleTypeFromFieldsVVN(ValueValidator_Fieldable) getRuleTypeFromFieldsVVN(vv_f)*
		@see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() isNullOkGivenInvert()*
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> invert(boolean do_invert)  {
		bInvert = do_invert;
		return  this;
	}
	/**
		<P>Set information to append to error messages.</P>

		@param  info  If non-{@code null}, this object's {@code toString()} is appended to error messages. Get with {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}{@code ()}*
		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> extraErrInfo(Object info)  {
		oXtraErrInfo = info;
		return  this;
	}
	/**
		<P>Declare if {@code null} is acceptable (pre-inversion).</P>

		@param  is_ok  If {@code true}, {@code null} is acceptable.
		@return  <I>{@code this}</I>
		@see  #invert(boolean)
		@see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() isNullOkGivenInvert()*
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> nullOk(boolean is_ok)  {
		bNullOk = is_ok;
		return  this;
	}
	/**
		<P>Declare no filtering.</P>

		@return  {@link #filter(ValidResultFilter) filter}{@code (null)}
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> unfiltered()  {
		return  filter(null);
	}
	/**
		<P>Set the valid-result filter.</P>

		@param  filter_offIfNull  If {@code null}, the validator is {@link #unfiltered() unfiltered}. Get with {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}{@code ()}.
		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> filter(ValidResultFilter filter_offIfNull)  {
		setFilter_unfilteredIfNull(filter_offIfNull);
		return  this;
	}
	/**
		<P>Set debugging.</P>

		@param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> debugTo(Appendable dest_ifNonNull)  {
		apblDebug = dest_ifNonNull;
		return  this;
	}
//setters...END
	public boolean isNullOk()  {
		return  bNullOk;
	}
	public String toString()  {
		return  super.toString() + ", isNullOk()=" + isNullOk();
	}
	/**
		<P>Create a new {@code NullnessValidator}.</P>

		@return  <CODE>(V)(new xbn.analyze.validate.NullnessValidator#NullnessValidator(ValueValidator_Fieldable){@code <O>}(this))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public V build()  {
		return  (V)(new NullnessValidator<O>(this));
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> startConfigReturnNeedable(R needer, Class<V> needed_class)  {
		startConfigReturnNeedable(needer, needed_class);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public ValueValidator_CfgForNeeder<O,V,R> startConfigReturnNeedable(R needer)  {
		@SuppressWarnings("unchecked")
		Class<V> clsv = (Class<V>)(Class)NullnessValidator.class;
		startConfigReturnNeedable(needer, clsv);
		return  this;
	}
	/**
		<P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

		@return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
	 **/
	public R endCfg()  {
		return  endCfgWithNeededReturnNeeder(build());
	}
}
