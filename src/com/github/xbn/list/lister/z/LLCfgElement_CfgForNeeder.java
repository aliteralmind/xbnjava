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
package  com.github.xbn.list.lister.z;
	import  com.github.xbn.list.lister.LLCfgElement;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.analyze.alter.ReturnValueUnchanged;
	import  com.github.xbn.analyze.alter.ValueAlterer;
	import  com.github.xbn.neederneedable.Needer;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring an {@link com.github.xbn.list.lister.LLCfgElement LLCfgElement}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LLCfgElement_CfgForNeeder<E,C extends LLCfgElement<E>,R extends Needer> extends LLConfigBase_CfgForNeeder<E,C,R> implements LLCfgElement_Fieldable<E>  {
	public ValueAlterer<Integer,Integer> avIndex;
	public ValueAlterer<E,E>             aValue ;
//public
//constructors...START
	/**
		<P>Create a new {@code LLCfgElement_CfgForNeeder} with defaults.</P>

		<P>This<OL>
			<LI>Calls <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="LLConfigBase_CfgForNeeder.html#LLConfigBase_CfgForNeeder(R)">super</A>(needer)</CODE></LI>
		</OL></P>

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="LLConfigBase_CfgForNeeder.html#LLConfigBase_CfgForNeeder(R)">super</A>(R)</CODE>
	 **/
	public LLCfgElement_CfgForNeeder(R needer)  {
		super(needer);
		indexUnaltered();
		valueUnaltered();
	}
//constructors...END
//setters...START
	public LLCfgElement_CfgForNeeder<E,C,R> indexUnaltered()  {
		return  alterIndex(new ReturnValueUnchanged<Integer,Integer>());
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public LLCfgElement_CfgForNeeder<E,C,R> alterIndex(ValueAlterer<Integer,Integer> alterer)  {
		CrashIfObject.nnull(alterer, "alterer", getChainIDForXMsg(null));
		avIndex = alterer;
		return  this;
	}
	public LLCfgElement_CfgForNeeder<E,C,R> valueUnaltered()  {
		return  alterIndex(new ReturnValueUnchanged<Integer,Integer>());
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public LLCfgElement_CfgForNeeder<E,C,R> alterValue(ValueAlterer<E,E> alterer)  {
		CrashIfObject.nnull(alterer, "alterer", getChainIDForXMsg(null));
		aValue = alterer;
		return  this;
	}
//setters...END
//other...START
	public ValueAlterer<Integer,Integer> getAlterIndex()  {
		return  avIndex;
	}
	public ValueAlterer<E,E> getAlterValue()  {
		return  aValue;
	}
	/**
		<P>Create a new {@code LLCfgElement} from the configuration.</P>

		@return  <CODE>(new {@link com.github.xbn.list.lister.LLCfgElement#LLCfgElement(LLCfgElement_Fieldable) LLCfgElement}(this))</CODE>
		@see  #endCfg()
	 **/
	public C build()  {
		//This function is not appropriate for sub-classes.
		//C: <C extends LLCfgElement<E>>
		@SuppressWarnings("unchecked")
		C l = (C)(new LLCfgElement<E>(this));
		return  l;
	}
	/**
		<P>YYY</P>

		<P>Equal to
		<BR> &nbsp; &nbsp;  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="LLConfigBase.html#startConfigReturnNeedable(R, java.lang.Class)">startConfigReturnNeedable</A>(needer, (Class&lt;LLCfgElement&lt;E&gt;&gt;)((Class)LLCfgElement.class))</CODE></P>
		@return  <I>{@code this}</I>
		@see  com.github.xbn.neederneedable.Needer#startConfig(Class)
	 **/
	@SuppressWarnings("unchecked")  //See above
	public LLCfgElement_CfgForNeeder<E,C,R> startConfigReturnNeedable(R needer)  {
		startConfigReturnNeedable(needer, (Class<C>)((Class)LLCfgElement.class));
		return  this;
	}
	/**
		<P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

		@return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
	 **/
	public R endCfg()  {
		return  endCfgWithNeededReturnNeeder(build());
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public LLCfgElement_CfgForNeeder<E,C,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
//other...END
}
