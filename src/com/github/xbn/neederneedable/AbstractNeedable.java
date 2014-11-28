/*license*\
	XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

	Copyright (C) 2014, Jeff Epstein

	This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

	This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

	You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inblc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.neederneedable;
/**
	<P>Abstract implementation of {@code Needable}. For classes needing to implement {@code Needable}, that cannot extend {@code AbstractNeedable}, see {@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractNeedable<O,R extends Needer> implements Needable<O,R>  {
	private NeedableComposer<O,R> nblc = null;
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...START
	/**
		<P>Create a new instance and potentially start configuration.</P>

		<P>This<OL>
			<LI>Creates an internal
			<BR> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeedableComposer#NeedableComposer(boolean, boolean) NeedableComposer}{@code (is_avaliableToNeeders, is_neededUseableAtInit)}</LI>
			<LI>If {@code needer} is non-{@code null}, this calls
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.Needable Needable}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(needer)</CODE></LI>
		</OL></P>
	 **/
	public AbstractNeedable(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
		nblc = new NeedableComposer<O,R>(is_avaliableToNeeders, is_neededUseableAtInit);
		if(needer != null)  {
			startConfigReturnNeedable(needer);
		}
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...END
	}
	//Composition implementation: NeedableComposer...START
		/**
			<P>Declare that the needed object was reset to its default value. It may or may not be {@link #isNeededUseableAtStart() usable}.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededReset_4prot() declareNeededReset_4prot}()</CODE></P>
		 **/
		protected void declareNeededReset()  {
			nblc.declareNeededReset_4prot();
		}
		/**
			<P>Start a new configuration for the provided {@code Needer}, for an object of a specific type.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp;<CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</A>(needer, expected_type)</CODE></P>
		 **/
		protected void startConfig(R needer, Class<O> expected_type)  {
			nblc.startConfig_4prot(needer, expected_type);
		}
		/**
			@return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/chain/NeedableComposer.html#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</A>(fully_configured)</CODE>
		 **/
		protected R endCfgWithNeededReturnNeeder(O fully_configured)  {
			return  nblc.endCfgWithNeededReturnNeeder_4prot(fully_configured);
		}
		/**
			<P>Declare that {@code endCfg()} may be safely called.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp;<I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededUseable_4prot(boolean) declareNeededUseable_4prot}(is_usable)</P>
		 **/
		protected void declareNeededUseable(boolean is_usable)  {
			nblc.declareNeededUseable_4prot(is_usable);
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUsable() isNeededUsable}()</CODE>
		 **/
		public boolean isNeededUsable()  {
			return  nblc.isNeededUsable();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUseableAtStart() isNeededUseableAtStart}()</CODE>
		 **/
		public boolean isNeededUseableAtStart()  {
			return  nblc.isNeededUseableAtStart();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#getActiveNeeder() getActiveNeeder}()</CODE>
		 **/
		public R getActiveNeeder()  {
			return  nblc.getActiveNeeder();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#isAvailableToNeeder() isAvailableToNeeder}()</CODE>
		 **/
		public boolean isAvailableToNeeder()  {
			return  nblc.isAvailableToNeeder();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#doReverifyInEnclosing() doReverifyInEnclosing}()</CODE>
		public boolean doReverifyInEnclosing()  {
			return  nblc.doReverifyInEnclosing();
		}
		 **/
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#toString() toString}()</CODE>
		 **/
		public String toString()  {
			return  nblc.toString();
		}
		/**
			<P>If a configuration is active, crash.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#ciActive_4prot() ciActive_4prot}()</CODE></P>
		 **/
		protected void ciActive()  {
			nblc.ciActive_4prot();
		}
		/**
			<P>If no configuration is active, crash.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#ciInactive_4prot() ciInactive_4prot}()</CODE></P>
		 **/
		protected void ciInactive()  {
			nblc.ciInactive_4prot();
		}
	//Composition implementation: NeedableComposer...END
	//Composition implementation: ChainableComposer...START
		/**
			<P>Set the chain-id to {@code null}.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#unsetChainID(boolean) unsetChainID}(unset_static)</CODE></P>
		 **/
		public void unsetChainID(boolean unset_static)  {
			nblc.unsetChainID(unset_static);
		}
		/**
			<P>Set the chain-id.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp;<I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#setChainID_4prot(boolean, Object) setChainID_4prot}(do_setStatic, id)</P>
		 **/
		protected void setChainID(boolean do_setStatic, Object id)  {
			nblc.setChainID_4prot(do_setStatic, id);
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#getChainID() getChainID}()</CODE>
		 **/
		public Object getChainID()  {
			return  nblc.getChainID();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#getStaticChainID() getStaticChainID}()</CODE>
		 **/
		public Object getStaticChainID()  {
			return  nblc.getStaticChainID();
		}
	//Composition implementation: ChainableComposer...END
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...START
	/**
		@return  {@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer.}{@link com.github.xbn.neederneedable.ChainableComposer#getChainIDForXMsgCINull(Chainable, Object) getChainIDForXMsgCINull}{@code (this, xtra_errInfo, null)}</P>
	 **/
	protected Object getChainIDForXMsg(Object xtra_errInfo)  {
		return  ChainableComposer.getChainIDForXMsgCINull(this, xtra_errInfo);
	}
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...END
/*stub functions for non-abstract compile...START
	public Needable<O,R> startConfigReturnNeedable(R needer)  {
		return  null;
	}
	public R endCfg()  {
		return  null;
	}
	public AbstractNeedable chainID(boolean do_setStatic, Object id)  {
		return  null;
	}
 stub functions for non-abstract compile...END*/
}