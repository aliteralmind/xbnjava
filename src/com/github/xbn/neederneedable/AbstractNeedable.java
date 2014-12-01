/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inblc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.neederneedable;
/**
   <p>Abstract implementation of {@code Needable}. For classes needing to implement {@code Needable}, that cannot extend {@code AbstractNeedable}, see {@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractNeedable<O,R extends Needer> implements Needable<O,R>  {
   private NeedableComposer<O,R> nblc = null;
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...START
   /**
      <p>Create a new instance and potentially start configuration.</p>

      <p>This<ol>
         <li>Creates an internal
         <br/> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeedableComposer#NeedableComposer(boolean, boolean) NeedableComposer}{@code (is_avaliableToNeeders, is_neededUseableAtInit)}</li>
         <li>If {@code needer} is non-{@code null}, this calls
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.Needable Needable}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="#startConfigReturnNeedable(R)">startConfigReturnNeedable</a>(needer)</code></li>
      </ol></p>
    */
   public AbstractNeedable(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      nblc = new NeedableComposer<O,R>(is_avaliableToNeeders, is_neededUseableAtInit);
      if(needer != null)  {
         startConfigReturnNeedable(needer);
      }
//Created in AbstractNeedable, needed by AbstractNeedableWithSubs...END
   }
   //Composition implementation: NeedableComposer...START
      /**
         <p>Declare that the needed object was reset to its default value. It may or may not be {@link #isNeededUseableAtStart() usable}.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededReset_4prot() declareNeededReset_4prot}()</code></p>
       */
      protected void declareNeededReset()  {
         nblc.declareNeededReset_4prot();
      }
      /**
         <p>Start a new configuration for the provided {@code Needer}, for an object of a specific type.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</a>(needer, expected_type)</code></p>
       */
      protected void startConfig(R needer, Class<O> expected_type)  {
         nblc.startConfig_4prot(needer, expected_type);
      }
      /**
       * @return  <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/neederneedable/NeedableComposer.html#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</a>(fully_configured)</code>
       */
      protected R endCfgWithNeededReturnNeeder(O fully_configured)  {
         return  nblc.endCfgWithNeededReturnNeeder_4prot(fully_configured);
      }
      /**
         <p>Declare that {@code endCfg()} may be safely called.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#declareNeededUseable_4prot(boolean) declareNeededUseable_4prot}(is_usable)</p>
       */
      protected void declareNeededUseable(boolean is_usable)  {
         nblc.declareNeededUseable_4prot(is_usable);
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUsable() isNeededUsable}()</code>
       */
      public boolean isNeededUsable()  {
         return  nblc.isNeededUsable();
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#isNeededUseableAtStart() isNeededUseableAtStart}()</code>
       */
      public boolean isNeededUseableAtStart()  {
         return  nblc.isNeededUseableAtStart();
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#getActiveNeeder() getActiveNeeder}()</code>
       */
      public R getActiveNeeder()  {
         return  nblc.getActiveNeeder();
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#isAvailableToNeeder() isAvailableToNeeder}()</code>
       */
      public boolean isAvailableToNeeder()  {
         return  nblc.isAvailableToNeeder();
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#doReverifyInEnclosing() doReverifyInEnclosing}()</code>
      public boolean doReverifyInEnclosing()  {
         return  nblc.doReverifyInEnclosing();
      }
       */
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#toString() toString}()</code>
       */
      public String toString()  {
         return  nblc.toString();
      }
      /**
         <p>If a configuration is active, crash.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#ciActive_4prot() ciActive_4prot}()</code></p>
       */
      protected void ciActive()  {
         nblc.ciActive_4prot();
      }
      /**
         <p>If no configuration is active, crash.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeedableComposer NeedableComposer}]</i>.{@link com.github.xbn.neederneedable.NeedableComposer#ciInactive_4prot() ciInactive_4prot}()</code></p>
       */
      protected void ciInactive()  {
         nblc.ciInactive_4prot();
      }
   //Composition implementation: NeedableComposer...END
   //Composition implementation: ChainableComposer...START
      /**
         <p>Set the chain-id to {@code null}.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#unsetChainID(boolean) unsetChainID}(unset_static)</code></p>
       */
      public void unsetChainID(boolean unset_static)  {
         nblc.unsetChainID(unset_static);
      }
      /**
         <p>Set the chain-id.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp;<i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#setChainID_4prot(boolean, Object) setChainID_4prot}(do_setStatic, id)</p>
       */
      protected void setChainID(boolean do_setStatic, Object id)  {
         nblc.setChainID_4prot(do_setStatic, id);
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#getChainID() getChainID}()</code>
       */
      public Object getChainID()  {
         return  nblc.getChainID();
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer}]</i>.{@link com.github.xbn.neederneedable.ChainableComposer#getStaticChainID() getStaticChainID}()</code>
       */
      public Object getStaticChainID()  {
         return  nblc.getStaticChainID();
      }
   //Composition implementation: ChainableComposer...END
//Created in SimpleChainable, needed  by AbstractNeedable, AbstractNeedableWithSubs...START
   /**
    * @return  {@link com.github.xbn.neederneedable.ChainableComposer ChainableComposer.}{@link com.github.xbn.neederneedable.ChainableComposer#getChainIDForXMsgCINull(Chainable, Object) getChainIDForXMsgCINull}{@code (this, xtra_errInfo, null)}</p>
    */
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
