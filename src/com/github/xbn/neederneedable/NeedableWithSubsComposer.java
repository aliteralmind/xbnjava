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
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
/**
   <p>For classes that need to implement <i>both</i> {@code Needable} and {@code Needer}, that cannot extend {@code AbstractNeedableWithSubs}.</p>

 * @see  AbstractNeedableWithSubs
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NeedableWithSubsComposer<O,R extends Needer> extends NeedableComposer<O,R>  {//implements Needer  {
   private final NeederComposer ndrc;
//Created in NeedableComposer, needed by NeedableWithSubsComposer...START
   /**
      <p>Create a new instance and potentially start configuration--this must be implemented as {@code protected}.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.neederneedable.NeedableComposer#NeedableComposer(boolean, boolean) super}{@code (is_avaliableToNeeders, is_neededUseableAtInit)}</li>
         <li>Creates an internal
         <br/> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeederComposer#NeederComposer() NeederComposer}{@code ()}</li>
      </ol></p>
    */
   @CompositionConstructor
   public NeedableWithSubsComposer(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit);
      ndrc = new NeederComposer();
   }
   //Composition implementation: NeederComposer...START
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeederComposer}]</i></a>.{@link com.github.xbn.neederneedable.NeederComposer#getNeededType() getNeededType}()</code>
       */
      @CompositionFunction
      public Class getNeededType()  {
         return  ndrc.getNeededType();
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeederComposer}]</i></a>.{@link com.github.xbn.neederneedable.NeederComposer#isConfigActive() isConfigActive}()</code>
       */
      @CompositionFunction
      public boolean isConfigActive()  {
         return  ndrc.isConfigActive();
      }
      /**
         <p>Starts configuration for a specific class-type.</p>

         <p>Equal to
         <br/> &nbsp; &nbsp; <code><i>[{@link com.github.xbn.neederneedable.NeederComposer}]</i></a>.{@link com.github.xbn.neederneedable.NeederComposer#startConfig(Class) startConfig}(needed_class)</code></p>
       */
      @CompositionFunction
      public void startConfig(Class<?> needed_class)  {
         ndrc.startConfig(needed_class);
      }
      /**
       * @return   <code><i>[{@link com.github.xbn.neederneedable.NeederComposer}]</i></a>.{@link com.github.xbn.neederneedable.NeederComposer#setGetNeededEndConfig_4prot(Object) setGetNeededEndConfig_4prot}(needed_fullyConfigured)</code>
       */
      @CompositionFunction
      protected Object setGetNeededEndConfig(Object needed_fullyConfigured)  {
         return  ndrc.setGetNeededEndConfig_4prot(needed_fullyConfigured);
      }
   //Composition implementation: NeederComposer...END
/*stub functions for non-abstract compile...START
   public NeedableWithSubsComposer<O,R> chainID(boolean do_setStatic, Object id)  {
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
