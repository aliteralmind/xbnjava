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
package  com.github.xbn.linefilter.entity.raw.z;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity RawStealthBlockEntity}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class RawStealthBlockEntity_CfgForNeeder<L,M extends RawStealthBlockEntity<L>,R extends Needer> extends RawLineEntity_CfgForNeeder<L,M,R> implements RawStealthBlockEntity_Fieldable<L>  {
   public ValueValidator<L> startValidator;
   public ValueValidator<L> endValidator  ;
   public boolean           doKeep        ;
//constructors...START
   /**
      <p>Create a new instance.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="RawLineEntity_CfgForNeeder.html#RawLineEntity_CfgForNeeder(R, com.github.xbn.linefilter.entity.EntityType, java.lang.String)">super</a>(needer, {@link com.github.xbn.linefilter.entity.EntityType}.{@link com.github.xbn.linefilter.entity.EntityType#STEALTH_BLOCK STEALTH_BLOCK}, name)</code></li>
         <li>{@link #resetRSBECFN() resetRSBECFN}{@code ()}</li>
      </ol></p>
    */
   public RawStealthBlockEntity_CfgForNeeder(R needer, String name)  {
      super(needer, EntityType.STEALTH_BLOCK, name);
      resetRSBECFN();
   }
   /**
      <p>Reverts configuration so a line never matches.</p>

    * <p>Equal to {@link #resetRSBECFN() resetRSBECFN}{@code ()}</p>

    * @return  <i>{@code this}</i>
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> reset()  {
      resetRSBECFN();
      return  this;
   }
   /**
      <p>Reset configuration specific to this {@code RawStealthBlockEntity_CfgForNeeder}.</p>

      <p>This calls<ul>
         <li><code>{@link #startValidator(ValueValidator) startValidator}(null)</code></li>
         <li><code>{@link #endValidator(ValueValidator) endValidator}(null)</code></li>
      </ul></p>

    * @see  #reset()
    */
   protected final void resetRSBECFN()  {
      startValidator(null);
      endValidator(null);
   }
//self-returning setters...START
   /**
      <p>Output the line number of each start and end line in block.</p>

    * @param  dest_ifNonNull  When non-{@code null}, this is used to write debugging output. Get with {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getDebugAptrLineNumbers() getDebugAptrLineNumbers}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> debugLineNumbers(Appendable dest_ifNonNull)  {
      dbgApblLineNums = dest_ifNonNull;
      return  this;
   }
   /**
      <p>Set the validator that detects the start line.</p>

    * @param  start_validator  May not be {@code null}, and <code>start_validator.{@link com.github.xbn.lang.Ruleable#getRuleType() getRuleType}()</code> must be {@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#getStartValidator() getStartValidator}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #endValidator(ValueValidator) endValidator
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> startValidator(ValueValidator<L> start_validator)  {
      startValidator = start_validator;
      return  this;
   }
   /**
      <p>Set the validator that detects the end line.</p>

    * @param  end_validator  May not be {@code null}, and <code>end_validator.{@link com.github.xbn.lang.Ruleable#getRuleType() getRuleType}()</code> must be {@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#getEndValidator() getEndValidator}{@code ()}*
    * @return  <i>{@code this}</i>
    * @see  #endValidator(ValueValidator) endValidator
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> endValidator(ValueValidator<L> end_validator)  {
      endValidator = end_validator;
      return  this;
   }
   /**
      <p>Set the on-off filter.</p>

    * @param  filter  May not be {@code null}. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawLineEntity#getFilter() getFilter}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> filter(RawOnOffEntityFilter<L> filter)  {
      filterIfNonNull = filter;
      return  this;
   }
   /**
      <p>Keep all matched lines.</p>

    * @return  {@link #keepLines(boolean) keepLines}{@code (true)}
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> keepLines()  {
      return  keepLines(true);
   }
   /**
      <p>Discard all matched lines.</p>

    * @return  {@link #keepLines(boolean) keepLines}{@code (false)}
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> discardLines()  {
      return  keepLines(false);
   }
   /**
      <p>Should matched lines be kept or discarded.</p>

    * @param  b  If {@code true}, lines are kept. Get with {@link com.github.xbn.linefilter.entity.raw.RawStealthBlockEntity#doKeepJustAnalyzed() doKeepJustAnalyzed}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  #keepLines()
    * @see  #discardLines()
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> keepLines(boolean b)  {
      doKeep = b;
      return  this;
   }
   /**
      <p>Is it required that this entity be found somewhere in the input?.</p>

    * @param  b  If {@code true}, then this entity must exist at least once in the input. If {@code false}, it's optional. Get with {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isRequired() isRequired}{@code ()}*.
    * @return  <i>{@code this}</i>
    * @see  com.github.xbn.linefilter.entity.raw.RawEntity#declareEndOfInput()
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> required(boolean b)  {
      isRqd = b;
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
//self-returning setters...END
   public String toString()  {
      return  super.toString() + ", getStartValidator()=" + getStartValidator() + ", getEndValidator()=" + getEndValidator();
   }
   /**
      <p>Create a new {@code RawStealthBlockEntity} as configured.</p>

    * @return  <code>(M)(new xbn.text.line.RawStealthBlockEntity#RawStealthBlockEntity(RawStealthBlockEntity_Fieldable)&lt;O,L&gt;(this))</code>
    */
   public M build()  {
      @SuppressWarnings("unchecked")
      M m = (M)(new RawStealthBlockEntity<L>(this));
      return  m;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")  //See xbn.neederneedable.Needer.startConfig(Class)
      Class<M> cblmo = (Class<M>)(Class)RawStealthBlockEntity.class;
      startConfig(needer, cblmo);
      return  this;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public RawStealthBlockEntity_CfgForNeeder<L,M,R> startConfigReturnNeedable(R needer, Class<M> needed_class)  {
      startConfigReturnNeedable(needer, needed_class);
      return  this;
   }
   /**
      <p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

    * @return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
    */
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
//getters...START
   public ValueValidator<L> getStartValidator()  {
      return  startValidator;
   }
   public ValueValidator<L> getEndValidator()  {
      return  endValidator;
   }
   public boolean doKeepLines()  {
      return  doKeep;
   }
//getters...END
}
