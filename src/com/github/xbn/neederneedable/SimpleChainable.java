/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   <P>Basic implementation of {@code Chainable}. Classes that need to implement {@code Chainable}, but cannot extend this class, should use {@link com.github.xbn.neederneedable.ChainableComposer}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SimpleChainable implements Chainable  {
   private ChainableComposer cc = null;
//constructors...START
   /**
      <P>Create a new instance.</P>

      <P>This<OL>
         <LI>Creates an internal
         <BR> &nbsp; &nbsp; <CODE>new {@link com.github.xbn.neederneedable.ChainableComposer#ChainableComposer() ChainableComposer}()</CODE></LI>
      </OL></P>

      @see  #SimpleChainable(SimpleChainable)
    **/
   public SimpleChainable()  {
      cc = new ChainableComposer();
   }
   /**
      <P>Create a new instance as a duplicate of another.</P>

      <P>This<OL>
         <LI>Creates an internal
         <BR> &nbsp; &nbsp; <CODE>new {@link com.github.xbn.neederneedable.ChainableComposer#ChainableComposer(Chainable) ChainableComposer}(to_copy)</CODE></LI>
      </OL></P>
      @see  #SimpleChainable()
    **/
   public SimpleChainable(SimpleChainable to_copy)  {
      cc = new ChainableComposer(to_copy);
   }
//constructors...END
   /**
      <P>Set the chain-id.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#setChainID_4prot(boolean, Object) setChainID_4prot}(do_setStatic, id)</CODE></P>
    **/
   public SimpleChainable chainID(boolean do_setStatic, Object id)  {
      cc.setChainID_4prot(do_setStatic ,id);
      return  null;
   }
   /**
      <P>Set the chain-id to {@code null}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#unsetChainID(boolean) unsetChainID}(unset_static)</CODE></P>
    **/
   public void unsetChainID(boolean unset_static)  {
      cc.unsetChainID(unset_static);
   }
   /**
      @return   <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#getChainID() getChainID}()</CODE></P>
    **/
   public Object getChainID()  {
      return  cc.getChainID();
   }
   /**
      @return   <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#getStaticChainID() getStaticChainID}()</CODE></P>
    **/
   public Object getStaticChainID()  {
      return  cc.getStaticChainID();
   }
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...START
   /**
      @return  {@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer.}{@link com.github.xbn.neederneedable.ChainableComposer#getChainIDForXMsgCINull(Chainable, Object) getChainID}{@code (this, xtra_errInfo)}</P>
    **/
   protected Object getChainIDForXMsg(Object xtra_errInfo)  {
      return  ChainableComposer.getChainIDForXMsgCINull(this, xtra_errInfo);
   }
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...END
   public String toString()  {
      return  cc.toString();
   }
}

