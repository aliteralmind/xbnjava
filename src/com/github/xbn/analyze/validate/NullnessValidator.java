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
package  com.github.xbn.analyze.validate;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.analyze.validate.z.ValueValidator_Fieldable;
   import  com.github.xbn.text.Trim;
   import  com.github.xbn.text.StringUtilBase;
/**
   <p>A {@code ValueValidator} that only checks for {@code null}-ness. This is useful in and of itself, but is mostly intended as a base-class for custom validators.</p>

   <h3>Implementation</h3>

   <p>At a minimum, the following functions must be overridden:<ul>
      <li>{@link #appendRules(StringBuilder) appendRules}{@code (sd)}</li>
      <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#doesFollowRulesPreInvert(O)">doesFollowRulesPreInvert</a>(O)</code></li>
      <li>{@link #getRuleTypeFromFieldsVVN(ValueValidator_Fieldable) getRuleTypeFromFieldsVVN}{@code (fieldable)}</li>
   </ul>Commonly, the super-version of these functions (in <i>this</i> class, {@code NullnessValidator}) will be called by sub-versions.</p>

   <p>Depending on the needs of sub-classes, it may also be necessary to override {@link #adjustForPostFilterReturnValue(boolean) adjustForPostFilterReturnValue}{@code (b)}.</p>

   <A NAME="cfg"></a><h3>Builder configuration: {@link com.github.xbn.analyze.validate.z.ValueValidator_Cfg}</h3>

   <p><ul>
      <li><b>Convenience builders:</b> {@link com.github.xbn.analyze.validate.NewValueValidatorFor}</li>
      <li><b>Basic:</b> <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#invert(boolean) invert}(b)</code>, <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#nullOk(boolean) nullOk}(b)</code>, <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#reset() reset}()</code></li>
      <li><b>Filter:</b> <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#unfiltered() unfiltered}()</code>, <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#filter(ValidResultFilter) filter}(vrf)</code></li>
      <li><b>Other:</b> <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#chainID(boolean, Object) chainID}(b,o)</code>, <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#debugTo(Appendable) debugTo}(apbl)</code>, <code>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#extraErrInfo(Object) extraErrInfo}(o)</code></li>
   </ul></p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NullnessValidator<O> extends AbstractValidator implements ValueValidator<O>  {
   private final boolean isNullOk;
   /**
      <p>Create a new instance from its fieldable.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>this(NullnessValidator.{@link #getRuleTypeFromFieldsVVN(ValueValidator_Fieldable) getRuleTypeFromFieldsVVN}(fieldable), fieldable)</code></p>
    **/
   public NullnessValidator(ValueValidator_Fieldable fieldable)  {
      this(NullnessValidator.getRuleTypeFromFieldsVVN(fieldable), fieldable);
   }
   /**
      <p>Create a new instance from its rule-type and fieldable.</p>

      @param  rule_type  Defines the restrictiveness of this instance. May not be {@code null}. Get with {@link com.github.xbn.analyze.validate.AbstractValidator#getRuleType() getRuleType}{@code ()}*.
      @param  fieldable  May not be {@code null}, and its fields must conform to the restrictions as documented in the <a href="#cfg">buider's setter functions</a>.
      @see  #NullnessValidator(ValueValidator_Fieldable)
      @see  #NullnessValidator(ValueValidator)
    **/
   protected NullnessValidator(RuleType rule_type, ValueValidator_Fieldable fieldable)  {
      super(rule_type, fieldable);
      isNullOk = fieldable.isNullOk();
   }
   /**
      <p>Create a new instance from a <code>ValueValidator</code>.</p>

      @see  #NullnessValidator(RuleType, ValueValidator_Fieldable)
    **/
   public NullnessValidator(ValueValidator<O> validator)  {
      super(validator);
      isNullOk = validator.isNullOk();
   }
   /**
      <p>Is the value acceptable?.</p>

      <p>Steps taken:<ol>
         <li>If the {@link com.github.xbn.analyze.validate.ValidResultFilter#getPreAction() pre-filter} &nbsp; {@link com.github.xbn.analyze.validate.FilterPreAction#isReturn() returns a value}: This <i><b>returns</b></i> {@link FilterPreAction#getReturnValue() that value} (values returned by the filter are never {@link com.github.xbn.analyze.validate.Validator#doInvertRules() inverted}).</li>
         <li>Otherwise, {@code to_validate} is <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#doesFollowRulesPreInvert(O)">validated</a> against the <i>un-inverted</i> rules, and that result is inverted if necessary.</li>
         <li>If the {@link com.github.xbn.analyze.validate.ValidResultFilter#getAfterValueFromInvertedRules(boolean) post-filter} leaves that value alone (because it is either {@link com.github.xbn.analyze.validate.FilterAfterValue#UNCHANGED UNCHANGED}, or equal to the follows-the-rules finding), this <i><b>returns</b></i> it.</li>
         <li>Otherwise this {@link #adjustForPostFilterReturnValue(boolean) makes adjustments}, and then <i><b>returns</b></i> it (un-inverted).</li>
      </ol></p>

      @see  com.github.xbn.analyze.Analyzer#getAnalyzedCount() Analyzer#getAnalyzedCount()
      @see  com.github.xbn.analyze.validate.Validator#getValidCount() Validator#getValidCount()
      @see  com.github.xbn.analyze.validate.Validator#getValidResultSource() Validator#getValidResultSource()
      @see  com.github.xbn.analyze.validate.Validator#isValid() Validator#isValid()
    **/
   public final boolean isValid(O to_validate)  {
      if(isDebugOn()) { getDebugAptr().appentln("<NV> isValid(to_validate): to_validate=[" + StringUtilBase.getChopped(Trim.YES, to_validate, 30, "...") + "], " + this); }

      ValidatorComposer.autoResetStateOrCINeedTo(this);

      FilterPreAction vfpa = getFilter().getPreAction();
      if(vfpa.isReturn())  {
         if(isDebugOn()) { getDebugAptr().appentln("<NV>    Returning declarePreInvertGetValidSetSource(" + vfpa.getReturnValue() + ", " + ResultReturnedBy.PRE_FILTER + ")"); }
         return  declareGetValidFromPreFilterNoInvert(vfpa.getReturnValue());
//			return  declarePreInvertGetValidSetSource(vfpa.getReturnValue(), ResultReturnedBy.PRE_FILTER);
      }

      //vfpa.isProceed() is true

      boolean bPreInvFollowsRules = false;
      try  {
         bPreInvFollowsRules = doesFollowRulesPreInvert(to_validate);
      }  catch(RuntimeException rx)  {
         throw  new IllegalStateException("Attempting doesFollowRulesPreInvert(to_validate)", rx);
      }

      if(isDebugOn()) { getDebugAptr().appentln("<NV>    doesFollowRulesPreInvert(to_validate)=" + bPreInvFollowsRules); }

      boolean bFollowsRules = declareValidForRulesGetInverted(bPreInvFollowsRules);

      FilterAfterValue fpv = getFilter().getAfterValueFromInvertedRules(bFollowsRules);

      if(getFilter().isExpired())  {
         if(isDebugOn()) { getDebugAptr().appentln("<NV>    getFilter().isExpired()=true. Calling declareExpired()"); }
         declareExpired();
      }

      boolean bPostValid = ValidResultFilterUtil.getPostReturnValueFromInvertedRules(fpv, bFollowsRules);
      if(isDebugOn()) {
         getDebugAptr().appentln("<NV>    follows-rules-post-invert=" + bFollowsRules);
         getDebugAptr().appentln("<NV>    getFilter().getAfterValueFromInvertedRules(bFollowsRules)=FilterAfterValue." + fpv);
         getDebugAptr().appentln("<NV>    ValidResultFilterUtil.getPostReturnValueFromInvertedRules(FilterAfterValue." + fpv + ", bFollowsRules)=" + bPostValid);
      }

      if(bPostValid != bFollowsRules)  {
         if(isDebugOn())  { getDebugAptr().appentln("<NV>    Post-filter return value different than rules: Calling adjustForPostFilterReturnValue(" + bPostValid + ")"); }
         adjustForPostFilterReturnValue(bPostValid);

         declarePostFilterReturnValue(fpv, bPostValid);
      }

      if(isDebugOn()) { getDebugAptr().appentln("<NV>    Returning " + bPostValid + " (getValidResultSource()=" + getValidResultSource() + ")"); }

      return  bPostValid;
   }
   /**
      <p>Adjusts internal state when the (post-inverted) <i>does-follow-the-rules</i> finding is overridden with a <i>different</i> post-filter value. This implementation of {@code adjustForPostFilterReturnValue(b)} does nothing. It must be overriden in sub-classes.</p>

      <h3>Example</h3>
<pre>   bPreInvFollowsRules = <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#doesFollowRulesPreInvert(O)">doesFollowRulesPreInvert</a>(value);
   boolean bFollowsRules = ({@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}() ? !bFollowsRules : bFollowsRules);
   {@link com.github.xbn.analyze.validate.FilterAfterValue} fpv = {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}().{@link com.github.xbn.analyze.validate.ValidResultFilter#getAfterValueFromInvertedRules(boolean) getAfterValueFromInvertedRules}(bFollowsRules);
   boolean bPostValid = {@link com.github.xbn.analyze.validate.ValidResultFilterUtil}.{@link com.github.xbn.analyze.validate.ValidResultFilterUtil#getPostReturnValueFromInvertedRules(FilterAfterValue, boolean) getPostReturnValueFromInvertedRules}(fpv, bFollowsRules);

   if(bPostValid != bFollowsRules)  {
      adjustForPostFilterReturnValue(bPostValid);
   }</pre>
      @param  isValid_fromPostFilter  The value from the post filter, which is <i>different</i> than that just-returned by {@code doesFollowRulesPreInvert(O)} (post-inversion).
    **/
   public void adjustForPostFilterReturnValue(boolean isValid_fromPostFilter)  {
   }
   @Override
   public void crashIfBadValue(O to_validate, String to_vldtName)  {
      if(!isValid(to_validate))  {
         throw  new IllegalArgumentException(getXMsg(to_vldtName + " (rules: " + getRules() + "). " + to_vldtName + "=[" + StringUtilBase.getChopped(Trim.YES, to_validate, 30, "...") + "]", getExtraErrInfo()));
      }
   }
   /**
      <p>Given the current invert-setting, is {@code null} an acceptable value?.</p>

      @return  <code>NullnessValidator.{@link #isNullOkGivenInvert(ValueValidator) isNullOkGivenInvert}(this)</code>
    **/
   public boolean isNullOkGivenInvert()  {
      return  NullnessValidator.isNullOkGivenInvert(this);
   }
   /**
      <p>Given the current invert-setting, is {@code null} an acceptable value?.</p>

      @param  validator  May not be {@code null}.
      @return  <code>(validator.{@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}()* ? !validator.{@link com.github.xbn.analyze.validate.ValueValidator#isNullOk() isNullOk}()* : validator.isNullOk())</code>
      @see  #isNullOkGivenInvert()
      @see  #isImpossibleConsideringNullInvert(ValueValidator) isImpossibleConsideringNullInvert(vv)
    **/
   public static final <O> boolean isNullOkGivenInvert(ValueValidator<O> validator)  {
      try  {
         return  (validator.doInvertRules() ? !validator.isNullOk() : validator.isNullOk());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(validator, "validator", null, rx);
      }
   }
   /**
      <p>Given the current invert and {@code null} settings, is impossible for a value to be valid?.</p>

      @param  validator  May not be {@code null}.
      @return  <code>(validator.{@link com.github.xbn.analyze.validate.ValueValidator#isNullOk() isNullOk}() &nbsp;&amp;&amp; &nbsp;validator.{@link #doInvertRules() doInvertRules}())</code>
    **/
   public static final <O> boolean isImpossibleConsideringNullInvert(ValueValidator<O> validator)  {
      try  {
         return  (validator.isNullOk()  &&  validator.doInvertRules());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(validator, "validator", null, rx);
      }
   }
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      try  {
         return  to_appendTo.append(isNullOk()
            ?  ((doInvertRules() ? "null-ok, inverted (impossible)" : "null-ok (unrestricted)"))
            :  ((doInvertRules() ? "only null acceptable" : "null bad") + " (restricted)"));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
   }
   /**
      <p>Are the rules followed?.</p>

      @param  to_validate  The value to validate.
      @return  {@code true}  If {@link com.github.xbn.analyze.validate.ValueValidator#isNullOk() null is okay}, or the value is not {@code null}.
      @see   <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="isValid(O)">isValid</a>(O)</code>
    **/
   public boolean doesFollowRulesPreInvert(O to_validate)  {
      if(isNullOk())  {
         if(isDebugOn()) { getDebugAptr().appentln("<NV>    doesFollowRulesPreInvert(to_validate): isNullOk() is true. Returning true."); }
         return  true;
      }
      if(isDebugOn()) { getDebugAptr().appentln("<NV>    doesFollowRulesPreInvert(to_validate): isNullOk() is false and to_validate is " + ((to_validate != null)?"non-":"") + "null. Returning " + to_validate != null); }
      return  (to_validate != null);
   }
   /**
      @see  com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#nullOk(boolean) ValueValidator_Cfg#nullOk(b)
    **/
   public boolean isNullOk()  {
      return  isNullOk;
   }
   /**
    	@return  <code>true</code> If <code>to_compareTo</code> is non-<code>null</code>, a <code>NullnessValidator</code>, and <code><a href="#areFieldsEqual(xbn.lang.NullnessValidator)">areFieldsEqual</a>((NullnessValidator)to_compareTo)</code> is <code>true</code>. <i>This is implemented as suggested by Joshua Bloch in &quot;Effective Java&quot; (2nd ed, item 8, page 46).</i>
    **/
   @Override
   public boolean equals(Object to_compareTo)  {
      //Check for object equality first, since it's faster than instanceof.
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof NullnessValidator))  {
         //to_compareTo is either null or not an NullnessValidator.
         //java.lang.Object.object(o):
         //   "For any non-null reference value x, x.equals(null) should return false."
         //See the bottom of this class for a counter-argument (which I'm not going with).
         return  false;
      }

      //Safe to cast
      NullnessValidator o = (NullnessValidator)to_compareTo;

      //Finish with field-by-field comparison.
      return  areFieldsEqual(o);
   }
   public boolean areFieldsEqual(NullnessValidator to_compareTo)  {
      return  super.areFieldsEqual(to_compareTo)  &&
         isNullOk() == to_compareTo.isNullOk();
   }
//other...END
//static...START
   /**
      <p>Get the rule-type from the fieldable instance. This must be overridden by sub-classes, which will likely call this function ({@code super.getRuleTypeFromFieldsVVN(fieldable)}) as their first line.</p>

@return
<pre>
is_nullOk  do_invert  Returns       Description
----------------    ------------  --------------
 true      true     IMPOSSIBLE
 true      false    UNRESTRICTED
 false     true     RESTRICTED    Non-null bad, null okay
 false     false    RESTRICTED    Non-null okay, null bad</pre>
 		@see  #NullnessValidator(ValueValidator_Fieldable) this(vv_f)
    **/
   public static final RuleType getRuleTypeFromFieldsVVN(ValueValidator_Fieldable fieldable)  {
      return  (fieldable.isNullOk()
         ?  (fieldable.doInvertRules() ? RuleType.IMPOSSIBLE : RuleType.UNRESTRICTED)
         :  RuleType.RESTRICTED);
   }
   /**
      <p>Duplicate this <code>NullnessValidator</code>.</p>

      @return  <code>(new <a href="#NullnessValidator(NullnessValidator)">NullnessValidator</a>&lt;O&gt;(this))</code>
    **/
   public NullnessValidator<O> getObjectCopy()  {
      return  (new NullnessValidator<O>(this));
   }
   public static final <O> boolean isValidDefensive(ValueValidator<O> validator, O to_validate, String validator_name, String to_validateName)  {
      try  {
         return validator.isValid(to_validate);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(validator, validator_name, null);
         throw  new RuntimeException("Attempting " + validator_name + ".isValid(" + to_validateName + ")", rx);
      }
   }
}
