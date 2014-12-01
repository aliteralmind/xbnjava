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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
/**
   <p>For classes that need to implement {@code Needable}, that cannot extend {@code AbstractNeedable}.</p>

 * @see  Needable
 * @see  AbstractNeedable
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NeedableComposer<O,R extends Needer> extends ChainableComposer  {//  implements Needable<O,R>  {
//state
   private boolean bNdUsbl      = false;
   private boolean bNdUsblAtStrt = false;
   private boolean bAv2Ndr      = false;
   private R       cndr         = null;
//internal: For error messages
//constructors...START
   /**
      <p>Create a new instance and potentially start configuration--this must be implemented as {@code protected}.</p>

      <p>This calls<ol>
         <li>{@link com.github.xbn.neederneedable.ChainableComposer#ChainableComposer() super}{@code ()}</li>
         <li>{@link #declareNeededReset_4prot() declareNeededReset_4prot}{@code ()}</li>
      </ol></p>

    * @param  is_avaliableToNeeders  Get with {@link #isAvailableToNeeder() isAvailableToNeeder}{@code ()}.
    * @param  is_neededUseableAtInit  If {@code true}, the needed object is useable immediately after a configuration is started. Get with {@link #isNeededUseableAtStart() isNeededUseableAtStart}{@code ()}.
    */
   @CompositionConstructor
   public NeedableComposer(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit)  {
      super();
      bAv2Ndr = is_avaliableToNeeders;
      bNdUsblAtStrt = is_neededUseableAtInit;
      declareNeededReset_4prot();
   }
//constructors...END
//main...START
   /**
      <p>Immediately reverts to as if a configuration was never started. Under most circumstances, this is called by  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</a>(O)</code>. <i>If called manually, the {@link #getActiveNeeder() active needer} will be left in an unstable state.</i></p>

      <p>This<ol>
         <li>Sets {@code getActiveNeeder()} to {@code null}</li>
         <li>Sets {@link #isNeededUsable() isNeededUsable}{@code ()} to {@code false}</li>
         <li>Calls  <code><i>[{@link com.github.xbn.neederneedable.SimpleChainable super}]</i>.{@link com.github.xbn.neederneedable.SimpleChainable#unsetChainID(boolean) unsetChainID}(false)</code></li>
      </ol></p>

      <h3><i>Does this interact acceptably with directly-used {@code Needables}?</i></h3>
    */
   @CompositionFunction
   public void declareNeededReset_4prot()  {
      cndr = null;
      bNdUsbl = isNeededUseableAtStart();
      unsetChainID(false);
   }
   /**
      <p>Start configuration with a default object--this must be implemented as {@code protected} with the name &quot;{@code startConfig}&quot;.</p>

      <p>This<ol>
         <li>Calls <code>{@link #ciActive_4prot() ciActive_4prot}()</code></li>
         <li>Calls <code>needer.{@link com.github.xbn.neederneedable.Needer#startConfig(Class) startConfig}(expected_type)</code></li>
         <li>Sets {@link #getActiveNeeder() getActiveNeeder}{@code ()} to {@code needer}</li>
      </ol></p>

    * @param  needer  May not be equal to <i>{@code this}</i> (for situations where classes implement both {@code Needable} and {@code Needer}. See {@link com.github.xbn.neederneedable.NeedableWithSubsComposer NeedableWithSubsComposer}).

    * @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#endCfgWithNeededReturnNeeder_4prot(O)">endCfgWithNeededReturnNeeder_4prot</a>(O)</code>
    * @see  #declareNeededUseable_4prot(boolean) declareNeededUseable_4prot(b)
    */
   @CompositionFunction
   public void startConfig_4prot(R needer, Class<O> expected_type)  {
      if(needer == this)  {
         throw  new IllegalArgumentException("needer is the SAME OBJECT as this Needable.");
      }
      ciActive_4prot();
      try  {
         needer.startConfig(expected_type);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(needer, "needer", null, rx);
      }
      cndr = needer;
   }
   /**
      <p>Sets the fully configured object into the {@code Needer} and then ends configuration--this must be implemented as {@code protected} with the name &quot;{@code endCfgWithNeededReturnNeeder}&quot;.</p>

      <p>This<ol>
         <li>Calls
         <br/> &nbsp; &nbsp; {@link #getActiveNeeder() getActiveNeeder}{@code ().}{@link com.github.xbn.neederneedable.Needer#neeadableSetsNeeded(Object) neeadableSetsNeeded}{@code ()}</li>
         <li>Calls {@link #declareNeededReset_4prot() declareNeededReset_4prot}{@code ()} (which sets {@code getActiveNeeder()} to {@code null}).</li>
         <li>Returns the (now inactive) {@code Needer}.</li>
      </ol></p>
    * @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</a>(R,cls)</code>
    */
   @CompositionFunction
   public R endCfgWithNeededReturnNeeder_4prot(O fully_configured)  {
      ciInactive_4prot();
      if(!isNeededUsable())  {
         throw  new IllegalStateException("isNeededUsable() is false.");
      }

      getActiveNeeder().neeadableSetsNeeded(fully_configured);

      R cndr = getActiveNeeder();
      declareNeededReset_4prot();  //Sets getActiveNeeder() to null.
      return  cndr;
   }
//main...END
//setters...START
   /**
      <p>Declare that {@code endCfg()} may be safely called.--this must be implemented as {@code protected} with the name &quot;{@code declareNeededUseable}&quot;.</p>

    * @param  is_usable  If {@code null}, the needed object is ready for use. It may be configured further, or may be retrieved immediately (by first ending the configuration).
    * @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is {@code null}.
    * @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="NeedableComposer.html#startConfig_4prot(R, java.lang.Class)">startConfig_4prot</a>(R,cls)</code>
    */
   @CompositionFunction
   public void declareNeededUseable_4prot(boolean is_usable)  {
      ciInactive_4prot();
      bNdUsbl = is_usable;
   }
//setters...END
//getters...START
   /**
    * @see  #declareNeededUseable_4prot(boolean)
    */
   @CompositionFunction
   public boolean isNeededUsable()  {
      ciInactive_4prot();
      return  bNdUsbl;
   }
   /**
    * @see  #NeedableComposer(boolean, boolean)
    */
   @CompositionFunction
   public boolean isNeededUseableAtStart()  {
      return  bNdUsblAtStrt;
   }
   @CompositionFunction
   public R getActiveNeeder()  {
      return  cndr;
   }
   /**
    * @see  #NeedableComposer(boolean, boolean)
    */
   @CompositionFunction
   public boolean isAvailableToNeeder()  {
      return  bAv2Ndr;
   }
//getters...END
//other...START
   //Not a composition-function, because super.toString() already is
   public String toString()  {
      return  super.toString() +
         ((getActiveNeeder() != null) ? ", isNeededUsable()=" + isNeededUsable() : "") +
         ", isNeededUseableAtStart()=" + isNeededUseableAtStart() + ", isAvailableToNeeder()=" + isAvailableToNeeder() + ", getActiveNeeder()=[" + getActiveNeeder() + "]";
   }
   /**
         <p>If a configuration is active, crash.</p>

    * @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is non-{@code null}.

    * @see  #ciInactive_4prot()
    */
   @CompositionFunction
   public void ciActive_4prot()  {
      if(getActiveNeeder() != null)  {
         throw  new IllegalStateException("Must endCfg(). getActiveNeeder()=[" + getActiveNeeder() + "]");
      }
   }
   /**
         <p>If no configuration is active, crash.</p>

    * @exception  IllegalStateException  If {@link #getActiveNeeder() getActiveNeeder}{@code ()} is {@code null}.
    * @see  #ciActive_4prot() ciActive_4prot(s)
    */
   @CompositionFunction
   public void ciInactive_4prot()  {
      if(getActiveNeeder() == null)  {
         throw  new IllegalStateException("Must startConfigReturnNeedable(cndr). getActiveNeeder()=null");
      }
   }
//other...END
}
