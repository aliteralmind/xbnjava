/*license*\
   XBN-Java Library

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
   <P>A {@code Needable} that is also a {@code Needer}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractNeedableWithSubs<O,R extends Needer> implements Needable<O,R>, Needer  {
   private NeedableWithSubsComposer<O,R> nwsc = null;
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...START
   /**
      <P>Create a new instance and potentially start configuration.</P>

      <P>This<OL>
         <LI>Creates an internal
         <BR> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#NeedableWithSubsComposer(boolean, boolean) NeedableWithSubsComposer}{@code (is_avaliableToNeeders, is_neededUseableAtInit)}</LI>
         <LI>If {@code needer} is non-{@code null}, this calls
         <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(needer)</CODE></LI>
      </OL></P>
    **/
   public AbstractNeedableWithSubs(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      nwsc = new NeedableWithSubsComposer<O,R>(is_avaliableToNeeders, is_neededUseableAtInit);
      if(needer != null)  {
         startConfigReturnNeedable(needer);
      }
   }
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...END
   //Composition implementation: NeedableWithSubsComposer...START
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#getNeededType() getNeededType}()</CODE>
       **/
      public Class getNeededType()  {
//		public <D> Class<D> getNeededType()  {
         return  nwsc.getNeededType();
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#isConfigActive() isConfigActive}()</CODE>
       **/
      public boolean isConfigActive()  {
         return  nwsc.isConfigActive();
      }
      /**
         <P><O,R></P>

         <P>Equal to
         <BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#startConfig(Class) startConfig}(needed_class)</CODE></P>
       **/
      public void startConfig(Class<?> needed_class)  {
         nwsc.startConfig(needed_class);
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#setGetNeededEndConfig(Object) setGetNeededEndConfig}(needed_fullyConfigured)</CODE>
       **/
      public Object setGetNeededEndConfig(Object needed_fullyConfigured)  {
         return  nwsc.setGetNeededEndConfig(needed_fullyConfigured);
      }
   //Composition implementation: NeedableWithSubsComposer...END
   //Composition implementation: NeedableComposer...START
      /**
         <P>Declare that the needed object was reset to its default value. It may or may not be {@link #isNeededUseableAtStart() useable}.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp;<CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededReset_4prot() declareNeededReset_4prot}()</CODE></P>
       **/
      protected void declareNeededReset()  {
         nwsc.declareNeededReset_4prot();
      }
      /**
         <P>Start a new configuration for the provided {@code Needer}, for an object of a specific type.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</A>(needer, expected_type)</CODE></P>
       **/
      protected void startConfig(R needer, Class<O> expected_type)  {
         nwsc.startConfig_4prot(needer, expected_type);
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/chain/NeedableComposer.html#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</A>(fully_configured)</CODE>
       **/
      protected R endCfgWithNeededReturnNeeder(O fully_configured)  {
         return  nwsc.endCfgWithNeededReturnNeeder_4prot(fully_configured);
      }
      /**
         <P>Declare that {@code endCfg()} may be safely called.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededUseable_4prot(boolean) declareNeededUseable_4prot}(is_usable)</CODE></P>
       **/
      protected void declareNeededUseable(boolean is_usable)  {
         nwsc.declareNeededUseable_4prot(is_usable);
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUsable() isNeededUsable}()</CODE>
       **/
      public boolean isNeededUsable()  {
         return  nwsc.isNeededUsable();
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUseableAtStart() isNeededUseableAtStart}()</CODE>
       **/
      public boolean isNeededUseableAtStart()  {
         return  nwsc.isNeededUseableAtStart();
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#getActiveNeeder() getActiveNeeder}()</CODE>
       **/
      public R getActiveNeeder()  {
         return  nwsc.getActiveNeeder();
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#isAvailableToNeeder() isAvailableToNeeder}()</CODE>
       **/
      public boolean isAvailableToNeeder()  {
         return  nwsc.isAvailableToNeeder();
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#doReverifyInEnclosing() doReverifyInEnclosing}()</CODE>
      public boolean doReverifyInEnclosing()  {
         return  nwsc.doReverifyInEnclosing();
      }
       **/
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#toString() toString}()</CODE>
       **/
      public String toString()  {
         return  nwsc.toString();
      }
      /**
         <P>If a configuration is active, crash.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp;<CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#ciActive_4prot() ciActive_4prot}()</CODE></P>
       **/
      protected void ciActive()  {
         nwsc.ciActive_4prot();
      }
      /**
         <P>If no configuration is active, crash.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp;<CODE><I>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</I>.{@link com.github.xbn.neederneedable.NeedableComposer#ciInactive_4prot() ciInactive_4prot}()</CODE></P>
       **/
      protected void ciInactive()  {
         nwsc.ciInactive_4prot();
      }
   //Composition implementation: NeedableComposer...END
   //Composition implementation: ChainableComposer...START
      /**
         <P>Set the chain-id to {@code null}.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp; <CODE><CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#unsetChainID(boolean) unsetChainID}(unset_static)</CODE></CODE></P>
       **/
      public void unsetChainID(boolean unset_static)  {
         nwsc.unsetChainID(unset_static);
      }
      /**
         <P>Set the chain-id.</P>

         <P>Equal to
         <BR> &nbsp; &nbsp;<CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#setChainID_4prot(boolean, Object) setChainID_4prot}(do_setStatic, id)</CODE></P>
       **/
      protected void setChainID(boolean do_setStatic, Object id)  {
         nwsc.setChainID_4prot(do_setStatic, id);
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#getChainID() getChainID}()</CODE>
       **/
      public Object getChainID()  {
         return  nwsc.getChainID();
      }
      /**
         @return  <CODE><I>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</I>.{@link com.github.xbn.neederneedable.ChainableComposer#getStaticChainID() getStaticChainID}()</CODE>
       **/
      public Object getStaticChainID()  {
         return  nwsc.getStaticChainID();
      }
   //Composition implementation: ChainableComposer...END
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...START
   /**
      @return  {@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer.}{@link com.github.xbn.neederneedable.ChainableComposer#getChainIDForXMsgCINull(Chainable, Object) getChainID}{@code (this, xtra_errInfo)}</P>
    **/
   protected Object getChainIDForXMsg(Object xtra_errInfo)  {
      return  ChainableComposer.getChainIDForXMsgCINull(this, xtra_errInfo);
   }
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...END
/*stub functions for non-abstract compile...START
   public AbstractNeedableWithSubs<O,R> chainID(boolean do_setStatic, Object id)  {
      return  null;
   }
   public R endCfg()  {
      return  null;
   }
   public Needable<O,R> startConfigReturnNeedable(R needer)  {
      return  null;
   }
   public void neeadableSetsNeeded(Object fully_configured)  {
   }
 stub functions for non-abstract compile...END*/
}
