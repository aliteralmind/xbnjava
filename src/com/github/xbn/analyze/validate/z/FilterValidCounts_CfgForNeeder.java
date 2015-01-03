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
package  com.github.xbn.analyze.validate.z;
   import  com.github.xbn.analyze.validate.FilterPreAction;
   import  com.github.xbn.analyze.validate.FilterCountType;
   import  com.github.xbn.analyze.validate.FilterAfterValue;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.neederneedable.AbstractNeedable;
   import  com.github.xbn.analyze.validate.FilterValidCounts;
   import  com.github.xbn.neederneedable.Needer;
/**
   <p>For indirectly configuring a {@link FilterValidCounts}.</p>

 * @see  <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a>
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class FilterValidCounts_CfgForNeeder<F extends FilterValidCounts,R extends Needer> extends AbstractNeedable<F,R> implements FilterValidCounts_Fieldable  {
   public LengthInRange   liRange            ;
   public FilterCountType vfCountType        ;
   public FilterAfterValue vfPostValForBelow  ;
   public FilterAfterValue vfPostValForIn     ;
   public FilterAfterValue vfPostValForAfter  ;
   public FilterPreAction vfPreActionForBelow;
   public FilterPreAction vfPreActionForIn   ;
   public FilterPreAction vfPreActionForAfter;
   public Appendable      apblDebug          ;
//constructors...START
   /**
      <p>Create a new instance.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/neederneedable/AbstractNeedable.html#AbstractNeedable(boolean, boolean, R)">super</a>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</code></li>
         <li>{@link #resetVVN() resetVVN}{@code ()}</li>
      </ol>
    */
   public FilterValidCounts_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
      resetVVN();
   }
   /**
      <p>Reset all configuration so the filter does nothing.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link #resetVVN() resetVVN}{@code ()}</p>

    * @return  <i>{@code this}</i>
    */
   public FilterValidCounts_CfgForNeeder<F,R> reset()  {
      resetVVN();
      return  this;
   }
   /**
      <p>Reset configuration specific to this {@code FilterValidCounts_CfgForNeeder}.</p>

      <p>This<ol>
         <li>{@link #unfiltered() unfiltered}{@code ()}</li>
         <li>{@link #debugTo(Appendable) debugTo}{@code (null)}</li>
      </ol>
    */
   protected final void resetVVN()  {
      unfiltered();
      debugTo(null);
   }
//constructors...END
//setters...START
   /**
      <p>Set debugging.</p>

    * @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
    * @return  <i>{@code this}</i>
    */
   public FilterValidCounts_CfgForNeeder<F,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
      <p>Set the range that the count must conform to.</p>

    * @param  range  May not be {@code null}, and its {@linkplain com.github.xbn.number.IntInRange#getMin() minimum} may not be zero. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getRange() getRange}{@code ()}.
    * @return  <i>{@code this}</i>
    */
   public FilterValidCounts_CfgForNeeder<F,R> range(LengthInRange range)  {
      liRange = range;
      return  this;
   }
   /**
      <p>Do not filter at all.</p>

      <p>This calls<ol>
         <li><code>{@link #range(LengthInRange) range}({@link com.github.xbn.number.LengthInRange LengthInRange}.{@link com.github.xbn.number.LengthInRange#UNRESTRICTED UNRESTRICTED})</code></li>
         <li>{@link #postValueAlwaysUnchanged() postValueAlwaysUnchanged}{@code ()}</li>
         <li><code>{@link #preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction)}({@link com.github.xbn.analyze.validate.FilterPreAction FilterPreAction}.{@link com.github.xbn.analyze.validate.FilterPreAction#PROCEED PROCEED}, FilterPreAction.PROCEED, FilterPreAction.PROCEED)</code></li>
         <li>{@link #countValid() countValid}{@code ()}</li>
      </ol>

    * @return  <i>{@code this}</i>
    */
   public FilterValidCounts_CfgForNeeder<F,R> unfiltered()  {
      range(LengthInRange.UNRESTRICTED);
      postValueAlwaysUnchanged();
      preActionBelowInAfter(FilterPreAction.PROCEED, FilterPreAction.PROCEED, FilterPreAction.PROCEED);
      return  countValid();
   }
   /**
      <p>If the count is above or below range, return {@code false}, otherwise return true if the <i>something</i> follows-the-rules (post inversion).</p>

      <p>This calls<ol>
         <li>{@link #preActionProceed_afterFalse() preActionProceed_afterFalse}{@code ()}</li>
         <li>{@link #postValue_inUnchanged_outFalse() postValue_inUnchanged_outFalse}{@code ()}</li>
      </ol>

    * @return  <i>{@code this}</i>
    * @see  com.github.xbn.analyze.validate.Validator#doInvertRules()
    */
   public FilterValidCounts_CfgForNeeder<F,R> inUnchangedOutFalse()  {
      preActionProceed_afterFalse();
      return  postValue_inUnchanged_outFalse();
   }
   /**
      <p><b>Post-filter:</b> If the count is in range, return the follows-the-rules (post-inversion) value unchanged. If it is below or above the range, return {@code false}.</p>

    * @return  <code>{@link #postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter}({@link com.github.xbn.analyze.validate.FilterAfterValue FilterAfterValue}.{@link com.github.xbn.analyze.validate.FilterAfterValue#FALSE FALSE}, FilterAfterValue.{@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED UNCHANGED}, FilterAfterValue.FALSE)</code>
    * @see  com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType()*
    */
   public FilterValidCounts_CfgForNeeder<F,R> postValue_inUnchanged_outFalse()  {
      return  postValueBelowInAfter(FilterAfterValue.FALSE, FilterAfterValue.UNCHANGED, FilterAfterValue.FALSE);
   }
   /**
      <p><b>Post-filter:</b> Always pass the follows-the-rules (post-inversion) value through unchanged.</p>

    * @return  <code>{@link #postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter}({@link com.github.xbn.analyze.validate.FilterAfterValue FilterAfterValue}.{@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED UNCHANGED}, FilterAfterValue.UNCHANGED, FilterAfterValue.FALSE)</code>
    */
   public FilterValidCounts_CfgForNeeder<F,R> postValueAlwaysUnchanged()  {
      return  postValueBelowInAfter(FilterAfterValue.UNCHANGED, FilterAfterValue.UNCHANGED, FilterAfterValue.UNCHANGED);
   }
   /**
      <p>What should the post-filter do?.</p>

    * @param  fpv_below  What to do when the {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() count} is below <code>{@link com.github.xbn.analyze.validate.FilterValidCounts#getRange() getRange}()*.{@link com.github.xbn.number.NumberInRange#getMinNumber() getMinNumber}()</code>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getBelowAfterValue() getBelowAfterValue}{@code ()}{@code ()}.
    * @param  fpv_in  What to do when the count is <!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/number/NumberInRange.html#isValid(N)">valid</a> according to the range?
    * @param  fpv_after  What to do when the count is &quot;greater&quot; than <code>getRange()*.{@link com.github.xbn.number.NumberInRange#getMaxNumber() getMaxNumber}()</code>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getAfterAfterValue() getAfterAfterValue}{@code ()}{@code ()}. <b><i>Note:</i></b> Since the filter is expired when the maximum is reached, it will never be exceeded. This is therefore, more accurately: &quot;What to do when the maximum has been reached, and this is the first (or subsequent) check <i><b>after</b></i> that?&quot;.
    * @return  <i>{@code this}</i>
    * @see  #unfiltered()
    * @see  #inUnchangedOutFalse()
    * @see  #postValueAlwaysUnchanged()
    * @see  #postValue_inUnchanged_outFalse()
    * @see  #preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction) preActionBelowInAfter(fpa,fpa,fpa)
    */
   public FilterValidCounts_CfgForNeeder<F,R> postValueBelowInAfter(FilterAfterValue fpv_below, FilterAfterValue fpv_in, FilterAfterValue fpv_after)  {
      vfPostValForBelow = fpv_below;
      vfPostValForIn = fpv_in;
      vfPostValForAfter = fpv_after;
      return  this;
   }
   /**
      <p><b>Pre-filter:</b> If the count is below-or-equal-to the range max, {@code PROCEED}, otherwise, return {@code false}.</p>

    * @return  <code>{@link #preActionBelowInAfter(FilterPreAction, FilterPreAction, FilterPreAction)}({@link com.github.xbn.analyze.validate.FilterPreAction FilterPreAction}.{@link com.github.xbn.analyze.validate.FilterPreAction#PROCEED PROCEED}, FilterPreAction.PROCEED, FilterPreAction.{@link com.github.xbn.analyze.validate.FilterPreAction#RETURN_FALSE RETURN_FALSE})</code>
    */
   public FilterValidCounts_CfgForNeeder<F,R> preActionProceed_afterFalse()  {
      return  preActionBelowInAfter(FilterPreAction.PROCEED, FilterPreAction.PROCEED, FilterPreAction.RETURN_FALSE);
   }
   /**
      <p>What should the post-filter do?.</p>

    * @param  fpa_below  What to do when the {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() count} is below <code>{@link com.github.xbn.analyze.validate.FilterValidCounts#getRange() getRange}()*.{@link com.github.xbn.number.NumberInRange#getMinNumber() getMinNumber}()</code>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getBelowAfterValue() getBelowAfterValue}{@code ()}{@code ()}.
    * @param  fpa_in  What to do when the count is <!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/number/NumberInRange.html#isValid(N)">valid</a> according to the range?
    * @param  fpa_after  What to do when the count is &quot;greater&quot; than <code>getRange()*.{@link com.github.xbn.number.NumberInRange#getMaxNumber() getMaxNumber}()</code>? May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.FilterValidCounts#getAfterAfterValue() getAfterAfterValue}{@code ()}{@code ()}. <b><i>Note:</i></b> Since the filter is expired when the maximum is reached, it will never be exceeded. This is therefore, more accurately: &quot;What to do when the maximum has been reached, and this is the first (or subsequent) check <i><b>after</b></i> that?&quot;.
    * @return  <i>{@code this}</i>
    * @see  #preActionProceed_afterFalse()
    * @see  #postValueBelowInAfter(FilterAfterValue, FilterAfterValue, FilterAfterValue) postValueBelowInAfter(fpv,fpv,fpv)
    * @see  #unfiltered()
    */
   public FilterValidCounts_CfgForNeeder<F,R> preActionBelowInAfter(FilterPreAction fpa_below, FilterPreAction fpa_in, FilterPreAction fpa_after)  {
      vfPreActionForBelow = fpa_below;
      vfPreActionForIn = fpa_in;
      vfPreActionForAfter = fpa_after;
      return  this;
   }
   /**
      <p>Count every analysis.</p>

      <p>This sets {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType}{@code ()}* to <code>{@link com.github.xbn.analyze.validate.FilterCountType FilterCountType}.{@link com.github.xbn.analyze.validate.FilterCountType#ALL ALL}</code></p>

    * @return  <i>{@code this}</i>
    * @see  #countValid()
    * @see  #countInvalid()
    */
   public FilterValidCounts_CfgForNeeder<F,R> countAll()  {
      vfCountType = FilterCountType.ALL;
      return  this;
   }
   /**
      <p>Count only when the <i>something</i> is deemed valid (post-inversion).</p>

      <p>This sets {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType}{@code ()}* to <code>{@link com.github.xbn.analyze.validate.FilterCountType FilterCountType}.{@link com.github.xbn.analyze.validate.FilterCountType#VALID VALID}</code></p>

    * @return  <i>{@code this}</i>
    * @see  #countAll()
    * @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    */
   public FilterValidCounts_CfgForNeeder<F,R> countValid()  {
      vfCountType = FilterCountType.VALID;
      return  this;
   }
   /**
      <p>Count only when the <i>something</i> is deemed invalid (post-inversion).</p>

      <p>This sets {@link com.github.xbn.analyze.validate.FilterValidCounts#getFilterCountType() getFilterCountType}{@code ()}* to <code>{@link com.github.xbn.analyze.validate.FilterCountType FilterCountType}.{@link com.github.xbn.analyze.validate.FilterCountType#INVALID INVALID}</code></p>

    * @return  <i>{@code this}</i>
    * @see  #countAll()
    * @see  com.github.xbn.analyze.validate.Validator#doInvertRules() Validator#doInvertRules()
    */
   public FilterValidCounts_CfgForNeeder<F,R> countInvalid()  {
      vfCountType = FilterCountType.INVALID;
      return  this;
   }
//setters...END
   public FilterCountType getFilterCountType()  {
      return  vfCountType;
   }
   public LengthInRange getRange()  {
      return  liRange;
   }
   public FilterAfterValue getBelowAfterValue()  {
      return  vfPostValForBelow;
   }
   public FilterAfterValue getInAfterValue()  {
      return  vfPostValForIn;
   }
   public FilterAfterValue getAfterAfterValue()  {
      return  vfPostValForAfter;
   }
   public FilterPreAction getBelowPreAction()  {
      return  vfPreActionForBelow;
   }
   public FilterPreAction getInPreAction()  {
      return  vfPreActionForIn;
   }
   public FilterPreAction getAfterPreAction()  {
      return  vfPreActionForAfter;
   }
   public Appendable getDebugApbl()  {
      return  apblDebug;
   }

   public String toString()  {
      return  super.toString() + ", 	getFilterCountType()=" + getFilterCountType() + ", pre-below/in/after=[" + getBelowPreAction() + "," + getInPreAction() + "," + getAfterPreAction() + "], post-below/in/after=[" + getBelowAfterValue() + "," + getInAfterValue() + "," + getAfterAfterValue() + "], range=<" + getRange().getRules() + ">, getDebugApbl()=[" + getDebugApbl() + "]";
   }

   /**
      <p>Create a new {@code FilterValidCounts} as configured.</p>

    * @return  <code>(F)(new {@link com.github.xbn.analyze.validate.FilterValidCounts#FilterValidCounts(FilterValidCounts_Fieldable) FilterValidCounts}(this))</code>
    */
   public F build()  {
      @SuppressWarnings("unchecked")
      F f = (F)(new FilterValidCounts(this));
      return  f;
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public FilterValidCounts_CfgForNeeder<F,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   /**
      <p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

    * @return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
    */
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   /**
    * @return  <i>{@code this}</i>
    */
   public FilterValidCounts_CfgForNeeder<F,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<F> clsv = (Class<F>)(Class)FilterValidCounts.class;
      startConfig(needer, clsv);
      return  this;
   }
}
