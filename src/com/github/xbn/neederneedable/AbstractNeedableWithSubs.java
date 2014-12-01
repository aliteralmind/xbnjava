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
   <p>A {@code Needable} that is also a {@code Needer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractNeedableWithSubs<O,R extends Needer> implements Needable<O,R>, Needer  {
   private NeedableWithSubsComposer<O,R> nwsc = null;
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...START
   /**
      <p>Create a new instance and potentially start configuration.</p>

      <p>This<ol>
         <li>Creates an internal
         <br/> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#NeedableWithSubsComposer(boolean, boolean) NeedableWithSubsComposer}{@code (is_avaliableToNeeders, is_neededUseableAtInit)}</li>
         <li>If {@code needer} is non-{@code null}, this calls
         <br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(needer)</code></li>
      </ol></p>
    */
   public AbstractNeedableWithSubs(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      nwsc = new NeedableWithSubsComposer<O,R>(is_avaliableToNeeders, is_neededUseableAtInit);
      if(needer != null)  {
         startConfigReturnNeedable(needer);
      }
   }
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...END
   //Composition implementation: NeedableWithSubsComposer...START
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#getNeededType() getNeededType}()</code>
       */
      public Class getNeededType()  {
//		public <D> Class<D> getNeededType()  {
         return  nwsc.getNeededType();
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#isConfigActive() isConfigActive}()</code>
       */
      public boolean isConfigActive()  {
         return  nwsc.isConfigActive();
      }
      /**
         <p><O,R></p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#startConfig(Class) startConfig}(needed_class)</code></p>
       */
      public void startConfig(Class<?> needed_class)  {
         nwsc.startConfig(needed_class);
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableWithSubsComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableWithSubsComposer#setGetNeededEndConfig(Object) setGetNeededEndConfig}(needed_fullyConfigured)</code>
       */
      public Object setGetNeededEndConfig(Object needed_fullyConfigured)  {
         return  nwsc.setGetNeededEndConfig(needed_fullyConfigured);
      }
   //Composition implementation: NeedableWithSubsComposer...END
   //Composition implementation: NeedableComposer...START
      /**
         <p>Declare that the needed object was reset to its default value. It may or may not be {@link #isNeededUseableAtStart() useable}.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededReset_4prot() declareNeededReset_4prot}()</code></p>
       */
      protected void declareNeededReset()  {
         nwsc.declareNeededReset_4prot();
      }
      /**
         <p>Start a new configuration for the provided {@code Needer}, for an object of a specific type.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</a>(needer, expected_type)</code></p>
       */
      protected void startConfig(R needer, Class<O> expected_type)  {
         nwsc.startConfig_4prot(needer, expected_type);
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/neederneedable/NeedableComposer.html#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</a>(fully_configured)</code>
       */
      protected R endCfgWithNeededReturnNeeder(O fully_configured)  {
         return  nwsc.endCfgWithNeededReturnNeeder_4prot(fully_configured);
      }
      /**
         <p>Declare that {@code endCfg()} may be safely called.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededUseable_4prot(boolean) declareNeededUseable_4prot}(is_usable)</code></p>
       */
      protected void declareNeededUseable(boolean is_usable)  {
         nwsc.declareNeededUseable_4prot(is_usable);
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUsable() isNeededUsable}()</code>
       */
      public boolean isNeededUsable()  {
         return  nwsc.isNeededUsable();
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUseableAtStart() isNeededUseableAtStart}()</code>
       */
      public boolean isNeededUseableAtStart()  {
         return  nwsc.isNeededUseableAtStart();
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#getActiveNeeder() getActiveNeeder}()</code>
       */
      public R getActiveNeeder()  {
         return  nwsc.getActiveNeeder();
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#isAvailableToNeeder() isAvailableToNeeder}()</code>
       */
      public boolean isAvailableToNeeder()  {
         return  nwsc.isAvailableToNeeder();
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#doReverifyInEnclosing() doReverifyInEnclosing}()</code>
      public boolean doReverifyInEnclosing()  {
         return  nwsc.doReverifyInEnclosing();
      }
       */
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#toString() toString}()</code>
       */
      public String toString()  {
         return  nwsc.toString();
      }
      /**
         <p>If a configuration is active, crash.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#ciActive_4prot() ciActive_4prot}()</code></p>
       */
      protected void ciActive()  {
         nwsc.ciActive_4prot();
      }
      /**
         <p>If no configuration is active, crash.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#ciInactive_4prot() ciInactive_4prot}()</code></p>
       */
      protected void ciInactive()  {
         nwsc.ciInactive_4prot();
      }
   //Composition implementation: NeedableComposer...END
   //Composition implementation: ChainableComposer...START
      /**
         <p>Set the chain-id to {@code null}.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#unsetChainID(boolean) unsetChainID}(unset_static)</code></code></p>
       */
      public void unsetChainID(boolean unset_static)  {
         nwsc.unsetChainID(unset_static);
      }
      /**
         <p>Set the chain-id.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#setChainID_4prot(boolean, Object) setChainID_4prot}(do_setStatic, id)</code></p>
       */
      protected void setChainID(boolean do_setStatic, Object id)  {
         nwsc.setChainID_4prot(do_setStatic, id);
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#getChainID() getChainID}()</code>
       */
      public Object getChainID()  {
         return  nwsc.getChainID();
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#getStaticChainID() getStaticChainID}()</code>
       */
      public Object getStaticChainID()  {
         return  nwsc.getStaticChainID();
      }
   //Composition implementation: ChainableComposer...END
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...START
   /**
    * @return  {@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer.}{@link com.github.xbn.neederneedable.ChainableComposer#getChainIDForXMsgCINull(Chainable, Object) getChainID}{@code (this, xtra_errInfo)}</p>
    */
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
