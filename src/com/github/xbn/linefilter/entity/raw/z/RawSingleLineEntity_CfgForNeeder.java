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
package  com.github.xbn.linefilter.entity.raw.z;
	import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
	import  com.github.xbn.linefilter.entity.EntityType;
	import  com.github.xbn.analyze.alter.ValueAlterer;
	import  com.github.xbn.neederneedable.Needer;
	import  com.github.xbn.linefilter.entity.raw.RawSingleLineEntity;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.linefilter.entity.raw.RawSingleLineEntity RawSingleLineEntity}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class RawSingleLineEntity_CfgForNeeder<L,M extends RawSingleLineEntity<L>,R extends Needer> extends RawLineEntity_CfgForNeeder<L,M,R> implements RawSingleLineEntity_Fieldable<L>  {
	public boolean           keepAltered;
	public ValueAlterer<L,L> alterer    ;
//constructors...START
	/**
		<P>Create a new instance.</P>

		<P>This calls<OL>
			<LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="RawLineEntity_CfgForNeeder.html#RawLineEntity_CfgForNeeder(R, com.github.xbn.linefilter.entity.EntityType, java.lang.String)">super</A>(needer, {@link com.github.xbn.linefilter.entity.EntityType}.{@link com.github.xbn.linefilter.entity.EntityType#SINGLE_LINE SINGLE_LINE}, name)</CODE></LI>
			<LI>{@link #resetRSLECFN() resetRSLECFN}{@code ()}</LI>
		</OL></P>
	 **/
	public RawSingleLineEntity_CfgForNeeder(R needer, String name)  {
		super(needer, EntityType.SINGLE_LINE, name);
		resetRSLECFN();
	}
	/**
		<P>Reverts configuration so a line never matches.</P>

		<P>Equal to {@link #resetRSLECFN() resetRSLECFN}{@code ()}</P>

		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> reset()  {
		resetRSLECFN();
		return  this;
	}
	/**
		<P>Reset configuration specific to this {@code RawSingleLineEntity_CfgForNeeder}.</P>

		<P>This<UL>
			<LI>Sets </LI>
		</UL></P>
	 **/
	protected final void resetRSLECFN()  {
		keepAltered = true;
		alterer = null;
	}
//self-returning setters...START
	/**
		<P>Output the line number of each match.</P>

		@param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
		dbgApblLineNums = dest_ifNonNull;
		return  this;
	}
	/**
		<P>Set the alterer that defines the entity, optionally modifying lines that match.</P>

		@param  alterer  May not be {@code null} or {@linkplain com.github.xbn.analyze.alter.Alterer#mayDelete() delete}. Get with {@link com.github.xbn.linefilter.entity.raw.RawSingleLineEntity#getAlterer() getAlterer}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> alterer(ValueAlterer<L,L> alterer)  {
		this.alterer = alterer;
		return  this;
	}
	/**
		<P>Should matched lines be kept?.</P>

		@param  do_keep  If {@code true}, any lines that are {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() matched}, are also {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept}. Get with {@link com.github.xbn.linefilter.entity.raw.RawSingleLineEntity#doKeepMatched() doKeepMatched}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> keepMatchedLines(boolean do_keep)  {
		keepAltered = do_keep;
		return  this;
	}
	/**
		<P>Set the on-off filter.</P>

		@param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> filter(RawOnOffEntityFilter<L> filter)  {
		filterIfNonNull = filter;
		return  this;
	}
	/**
		<P>Is it required that this entity be found somewhere in the input?.</P>

		@param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> required(boolean b)  {
		isRqd = b;
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
//self-returning setters...END
	public String toString()  {
		return  super.toString() + ", getAlterer()=" + getAlterer() + ", doKeepMatched()=" + doKeepMatched();
	}
	/**
		<P>Create a new {@code RawSingleLineEntity} as configured.</P>

		@return  <CODE>(M)(new xbn.text.line.RawSingleLineEntity#RawSingleLineEntity(RawSingleLineEntity_Fieldable)&lt;O,L&gt;(this))</CODE>
	 **/
	public M build()  {
		@SuppressWarnings("unchecked")
		M m = (M)(new RawSingleLineEntity<L>(this));
		return  m;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer)  {
		@SuppressWarnings("unchecked")  //See xbn.neederneedable.Needer.startConfig(Class)
		Class<M> cblmo = (Class<M>)(Class)RawSingleLineEntity.class;
		startConfig(needer, cblmo);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RawSingleLineEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
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
	public ValueAlterer<L,L> getAlterer()  {
		return  alterer;
	}
	public boolean doKeepMatched()  {
		return  keepAltered;
	}
//getters...END
}
