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
package  com.github.xbn.linefilter.entity.z;
	import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.neederneedable.Needer;
	import  com.github.xbn.linefilter.entity.StealthBlockEntity;
	import  com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity RawStealthBlockEntity}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class StealthBlockEntity_CfgForNeeder<M extends StealthBlockEntity,R extends Needer> extends RawStealthBlockEntity_CfgForNeeder<String,M,R>  {
//constructors...START
	/**
		<P>Create a new instance.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/raw/z/RawStealthBlockEntity_CfgForNeeder.html#RawStealthBlockEntity_CfgForNeeder(R, java.lang.String)">super</A>(needer, name)</CODE></P>
	 **/
	public StealthBlockEntity_CfgForNeeder(R needer, String name)  {
		super(needer, name);
	}
	/**
		<P>Reverts configuration so a line never matches.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder super}.{@link com.github.xbn.linefilter.entity.raw.z.RawStealthBlockEntity_CfgForNeeder#reset() reset}()</CODE></P>

		@return  <I>{@code this}</I>
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> reset()  {
		super.reset();
		return  this;
	}
//self-returning setters...START
	/**
		<P>Output the line number of each start and end line in block.</P>

		@param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
		super.debugLineNumbers(dest_ifNonNull);
		return  this;
	}
	/**
		<P>Set the validator that detects the start line.</P>

		@param  start_validator  May not be {@code null}, and <CODE>start_validator.{@link com.github.xbn.lang.Ruleable#getRuleType() getRuleType}()</CODE> must be {@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#getStartValidator() getStartValidator}{@code ()}*
		@return  <I>{@code this}</I>
		@see  #endValidator(ValueValidator) endValidator
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> startValidator(ValueValidator<String> start_validator)  {
		super.startValidator(start_validator);
		return  this;
	}
	/**
		<P>Set the validator that detects the end line.</P>

		@param  end_validator  May not be {@code null}, and <CODE>end_validator.{@link com.github.xbn.lang.Ruleable#getRuleType() getRuleType}()</CODE> must be {@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#getEndValidator() getEndValidator}{@code ()}*
		@return  <I>{@code this}</I>
		@see  #endValidator(ValueValidator) endValidator
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> endValidator(ValueValidator<String> end_validator)  {
		super.endValidator(end_validator);
		return  this;
	}
	/**
		<P>Set the on-off filter.</P>

		@param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> filter(RawOnOffEntityFilter<String> filter)  {
		super.filter(filter);
		return  this;
	}
	/**
		<P>Is it required that this entity be found somewhere in the input?.</P>

		@param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> required(boolean b)  {
		super.required(b);
		return  this;
	}
	/**
		<P>Keep all matched lines.</P>

		@return  {@link #keepLines(boolean) keepLines}{@code (true)}
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> keepLines()  {
		return  keepLines(true);
	}
	/**
		<P>Discard all matched lines.</P>

		@return  {@link #keepLines(boolean) keepLines}{@code (false)}
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> discardLines()  {
		return  keepLines(false);
	}
	/**
		<P>Should matched lines be kept or discarded.</P>

		@param  b  If {@code true}, lines are kept. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#doKeepJustAnalyzed() doKeepJustAnalyzed}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  keepLines()
		@see  discardLines()
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> keepLines(boolean b)  {
		doKeep = b;
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> chainID(boolean do_setStatic, Object id)  {
		super.chainID(do_setStatic, id);
		return  this;
	}
//self-returning setters...END
	/**
		<P>Create a new {@code RawStealthBlockEntity} as configured.</P>

		@return  <CODE>(M)(new xbn.text.line.RawStealthBlockEntity#RawStealthBlockEntity(RawStealthBlockEntity_Fieldable)&lt;O,String&gt;(this))</CODE>
	 **/
	public M build()  {
		@SuppressWarnings("unchecked")
		M m = (M)(new StealthBlockEntity(this));
		return  m;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer)  {
		@SuppressWarnings("unchecked")  //See xbn.neederneedable.Needer.startConfig(Class)
		Class<M> cblmo = (Class<M>)(Class)StealthBlockEntity.class;
		startConfig(needer, cblmo);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public StealthBlockEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
		startConfigReturnNeedable(needer, needed_class);
		return  this;
	}
	/**
		<P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

		@return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
	 **/
	public R endCfg()  {
		return  endCfgWithNeededReturnNeeder(build());
	}
//getters...START
	public ValueValidator<String> getStartValidator()  {
		return  startValidator;
	}
	public ValueValidator<String> getEndValidator()  {
		return  endValidator;
	}
//getters...END
}
