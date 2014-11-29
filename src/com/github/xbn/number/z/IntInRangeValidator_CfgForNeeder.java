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
package  com.github.xbn.number.z;
	import  com.github.xbn.analyze.validate.ValidResultFilter;
	import  com.github.xbn.number.IntInRange;
	import  com.github.xbn.number.IntInRangeValidator;
	import  com.github.xbn.neederneedable.Needer;
/**
	<p>. For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</a> configuring a {@link IntInRangeValidator}.</p>
 **/
public class IntInRangeValidator_CfgForNeeder<G extends IntInRange,V extends IntInRangeValidator,R extends Needer> extends NumberInRangeValidator_CfgForNeeder<Integer,G,V,R> implements IntInRangeValidator_Fieldable<G>  {
	public IntInRangeValidator_CfgForNeeder(R needer)  {
		this(true, true, needer);
	}
	/**
		<p>YYY</p>

			<li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="zAbstractValidato_CfgForNeeder.html#zAbstractValidato_CfgForNeeder(boolean, boolean, R)">super</a>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</code></li>

	 **/
	public IntInRangeValidator_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
		super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
	}
	/**
		<p>Set information to append to error messages.</p>

		@param  info  If non-{@code null}, this object's {@code toString()} is appended to error messages. Get with {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}{@code ()}*
		@return  <i>{@code this}</i>
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> extraErrInfo(Object info)  {
		oXtraErrInfo = info;
		return  this;
	}
	protected void setIntInRange(IntInRange range)  {
		@SuppressWarnings("unchecked")
		G g = (G)range;
		nir = g;
	}
	/**
		@return  <i>{@code this}</i>
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> range(G range)  {
		setIntInRange(range);
		return  this;
	}
	/**
		<p>Declare if {@code null} is acceptable (pre-inversion).</p>

		@param  is_ok  If {@code true}, {@code null} is acceptable.
		@return  <i>{@code this}</i>
		@see  #invert(boolean)
		@see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() isNullOkGivenInvert()*
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> nullOk(boolean is_ok)  {
		super.nullOk(is_ok);
		return  this;
	}
	/**
		<p>Declare if the rules should be inverted.</p>

		@param  do_invert  If {@code true}, the rules are inverted. Get with {@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}{@code ()}*
		@return  <i>{@code this}</i>
		@see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() NullnessValidator#isNullOkGivenInvert()
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> invert(boolean do_invert)  {
		super.invert(do_invert);
		return  this;
	}
	/**
		<p>Declare no filtering.</p>

		@return  {@link #filter(ValidResultFilter) filter}{@code (null)}
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> unfiltered()  {
		return  filter(null);
	}
	/**
		<p>Set the valid-result filter.</p>

		@param  filter_offIfNull  If {@code null}, the validator is {@link #unfiltered() unfiltered}. Get with {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}{@code ()}.
		@return  <i>{@code this}</i>
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> filter(ValidResultFilter filter_offIfNull)  {
		super.filter(filter_offIfNull);
		return  this;
	}
	/**
		<p>Set debugging.</p>

		@param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
		@return  <i>{@code this}</i>
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> debugTo(Appendable dest_ifNonNull)  {
		apblDebug = dest_ifNonNull;
		return  this;
	}
	/**
		@return  <i>{@code this}</i>
	 **/
	public IntInRangeValidator_CfgForNeeder<G,V,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
	public V build()  {
		@SuppressWarnings("unchecked")
		V v = (V)(new IntInRangeValidator(this));
		return  v;
	}
}
