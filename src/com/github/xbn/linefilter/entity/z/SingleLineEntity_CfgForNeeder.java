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
	import  com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder;
	import  com.github.xbn.analyze.alter.ValueAlterer;
	import  com.github.xbn.neederneedable.Needer;
	import  com.github.xbn.linefilter.entity.SingleLineEntity;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.linefilter.entity.raw.RawSingleLineEntity RawSingleLineEntity}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class SingleLineEntity_CfgForNeeder<M extends SingleLineEntity,R extends Needer> extends RawSingleLineEntity_CfgForNeeder<String,M,R>  {
//constructors...START
	/**
		<P>Create a new instance.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/linefilter/entity/raw/z/RawSingleLineEntity_CfgForNeeder.html#RawSingleLineEntity_CfgForNeeder(R, java.lang.String)">super</A>(needer, name)</CODE></P>
	 **/
	public SingleLineEntity_CfgForNeeder(R needer, String name)  {
		super(needer, name);
	}
	/**
		<P>Reverts configuration so a line never matches.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder super}.{@link com.github.xbn.linefilter.entity.raw.z.RawSingleLineEntity_CfgForNeeder#reset() reset}()</CODE></P>

		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> reset()  {
		super.reset();
		return  this;
	}
//self-returning setters...START
	/**
		<P>Output the line number of each match.</P>

		@param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
		super.debugLineNumbers(dest_ifNonNull);
		return  this;
	}
	/**
		<P>Set the alterer that defines the entity, optionally modifying lines that match.</P>

		@param  alterer  May not be {@code null} or {@linkplain com.github.xbn.analyze.alter.Alterer#mayDelete() delete}. Get with {@link com.github.xbn.linefilter.entity.raw.RawSingleLineEntity#getAlterer() getAlterer}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> alterer(ValueAlterer<String,String> alterer)  {
		super.alterer(alterer);
		return  this;
	}
	/**
		<P>Should matched lines be kept?.</P>

		@param  b  If {@code true}, any lines that are {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() matched}, are also {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept}. Get with {@link com.github.xbn.linefilter.entity.raw.RawSingleLineEntity#doKeepMatched() doKeepMatched}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> keepMatchedLines(boolean b)  {
		super.keepMatchedLines(b);
		return  this;
	}
	/**
		<P>Set the on-off filter.</P>

		@param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> filter(RawOnOffEntityFilter<String> filter)  {
		super.filter(filter);
		return  this;
	}
	/**
		<P>Is it required that this entity be found somewhere in the input?.</P>

		@param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
		@return  <I>{@code this}</I>
		@see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> required(boolean b)  {
		super.required(b);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> chainID(boolean do_setStatic, Object id)  {
		super.chainID(do_setStatic, id);
		return  this;
	}
//self-returning setters...END
	/**
		<P>Create a new {@code RawSingleLineEntity} as configured.</P>

		@return  <CODE>(M)(new xbn.text.line.RawSingleLineEntity#RawSingleLineEntity(RawSingleLineEntity_Fieldable)&lt;O,L&gt;(this))</CODE>
	 **/
	public M build()  {
		@SuppressWarnings("unchecked")
		M m = (M)(new SingleLineEntity(this));
		return  m;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer)  {
		super.startConfigReturnNeedable(needer);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public SingleLineEntity_CfgForNeeder<M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
		super.startConfigReturnNeedable(needer, needed_class);
		return  this;
	}
}
