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
package  com.github.xbn.neederneedable;
/**
	<p>Basic implementation of {@code Chainable}. Classes that need to implement {@code Chainable}, but cannot extend this class, should use {@link com.github.xbn.neederneedable.ChainableComposer}</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SimpleChainable implements Chainable  {
	private ChainableComposer cc = null;
//constructors...START
	/**
		<p>Create a new instance.</p>

		<p>This<ol>
			<li>Creates an internal
			<br/> &nbsp; &nbsp; <code>new {@link com.github.xbn.neederneedable.ChainableComposer#ChainableComposer() ChainableComposer}()</code></li>
		</ol></p>

		@see  #SimpleChainable(SimpleChainable)
	 **/
	public SimpleChainable()  {
		cc = new ChainableComposer();
	}
	/**
		<p>Create a new instance as a duplicate of another.</p>

		<p>This<ol>
			<li>Creates an internal
			<br/> &nbsp; &nbsp; <code>new {@link com.github.xbn.neederneedable.ChainableComposer#ChainableComposer(Chainable) ChainableComposer}(to_copy)</code></li>
		</ol></p>
		@see  #SimpleChainable()
	 **/
	public SimpleChainable(SimpleChainable to_copy)  {
		cc = new ChainableComposer(to_copy);
	}
//constructors...END
	/**
		<p>Set the chain-id.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp;  <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#setChainID_4prot(boolean, Object) setChainID_4prot}(do_setStatic, id)</code></p>
	 **/
	public SimpleChainable chainID(boolean do_setStatic, Object id)  {
		cc.setChainID_4prot(do_setStatic ,id);
		return  null;
	}
	/**
		<p>Set the chain-id to {@code null}.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp;  <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#unsetChainID(boolean) unsetChainID}(unset_static)</code></p>
	 **/
	public void unsetChainID(boolean unset_static)  {
		cc.unsetChainID(unset_static);
	}
	/**
		@return   <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#getChainID() getChainID}()</code></p>
	 **/
	public Object getChainID()  {
		return  cc.getChainID();
	}
	/**
		@return   <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#getStaticChainID() getStaticChainID}()</code></p>
	 **/
	public Object getStaticChainID()  {
		return  cc.getStaticChainID();
	}
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...START
	/**
		@return  {@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer.}{@link com.github.xbn.neederneedable.ChainableComposer#getChainIDForXMsgCINull(Chainable, Object) getChainID}{@code (this, xtra_errInfo)}</p>
	 **/
	protected Object getChainIDForXMsg(Object xtra_errInfo)  {
		return  ChainableComposer.getChainIDForXMsgCINull(this, xtra_errInfo);
	}
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...END
	public String toString()  {
		return  cc.toString();
	}
}

