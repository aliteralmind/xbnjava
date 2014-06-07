package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.Null;
   import  java.util.Objects;
   import  com.github.xbn.analyze.AnalyzerComposer;
   import  com.github.xbn.analyze.validate.z.Validator_Fieldable;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.RuleableComposer;
   import  com.github.xbn.lang.XInfoAccumulator;
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
   import  com.github.xbn.util.tuple.ThreeTSObjects;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>For classes that need to implement {@code Validator}, that cannot extend {@code AbstractValidator}. See {@link com.github.xbn.analyze.AbstractAnalyzer AbstractValidator}.</P>
 **/
public class ValidatorComposer extends AnalyzerComposer  {
//state
   private boolean      wasValid;
   private ResultReturnedBy validResultSource;
//counts
   private int validCount = -1;
//config
   private final boolean           doInvert ;
   private final RuleableComposer  ruleCmpsr;
   private final ValidResultFilter vrFilter ;
//constructors...START
   /**
      <P>Create a new instance.</P>

      <P>Field-documentation:<UL>
         <LI><CODE>fieldable.{@link com.github.xbn.analyze.validate.z.Validator_Fieldable#getFilter() getFilter}()</CODE>: If non-{@code null}, this suppresses or alters valid results. It may not be {@link com.github.xbn.lang.Expirable#isExpired() expired}. If {@code null}, then {@link #unfiltered() no filtering} occurs.</LI>
         <LI><CODE>fieldable.{@link com.github.xbn.analyze.validate.z.Validator_Fieldable#getDebugApbl() getDebugApbl}():</CODE> If non-{@code null}, then debugging is {@link com.github.xbn.io.Debuggable#setDebugOn(boolean) turned on}, and printed by this.</LI>
      </UL></P>

      @see  #ValidatorComposer(boolean, ValidatorComposer) this(b,vc)
      @see  #ValidatorComposer(Validator) this(v)
    **/
   public ValidatorComposer(RuleType rt_i, Validator_Fieldable fieldable)  {
      super();
      ruleCmpsr = new RuleableComposer(rt_i, "rt_i");
      doInvert = fieldable.doInvertRules();
      vrFilter = ((fieldable.getFilter() != null) ? fieldable.getFilter()
               :  ValidatorComposer.unfiltered());
      if(vrFilter.doesExpire())  {
         declareExpirable_4prot();
      }
      onIfNonNull(fieldable.getDebugApbl());
      //Never ever call interface functions, directly or indirectly, in a constructor.
      zresetCountsVB();
   }
   /**
      <P>Create a new {@code ValidatorComposer} as a duplicate of another.</P>

      <P>This<OL>
         <LI>Calls <CODE>{@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(boolean, AnalyzerComposer) super}(ignored, to_copy)</CODE></LI>
         <LI>Sets {@link #getValidCount() getValidCount}{@code ()} to {@code to_copy.getValidCount()}.</LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #ValidatorComposer(RuleType, Validator_Fieldable) this(rti,vrFilter)
    **/
   public ValidatorComposer(boolean ignored, ValidatorComposer to_copy)  {
      super(ignored, to_copy);
      validCount = to_copy.getValidCount();
      doInvert = to_copy.doInvertRules();
      ruleCmpsr = new RuleableComposer(to_copy.getRuleType());
      vrFilter = to_copy.getFilter();
   }
   /**
      <P>Create a new {@code ValidatorComposer} from a {@code Validator}.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.analyze.AnalyzerComposer#AnalyzerComposer(Analyzer) super}{@code (validator)}</LI>
         <LI>Sets {@link #getValidCount() getValidCount}{@code ()} to {@code validator.getValidCount()}</LI>
      </OL></P>
      @see  #ValidatorComposer(RuleType, Validator_Fieldable) this(rti,vrFilter)
    **/
   @CompositionConstructor
   public ValidatorComposer(Validator validator)  {
      super(validator);
      validCount = validator.getValidCount();
      doInvert = validator.doInvertRules();
      wasValid = false;
      ruleCmpsr = new RuleableComposer(validator.getRuleType());
      vrFilter = validator.getFilter();
   }
//constructors...END
//setters...START
   @CompositionFunction
   public void resetState()  {
      super.resetState();
      zresetStateVB();
   }
   protected final void zresetStateVB()  {
      wasValid = false;
      validResultSource = null;
   }
   /**
      <P>Revert all counts to zero.</P>

      <P><I>There is no {@code resetState()} function, because there is no state unique to this {@code ValidatorComposer}.</I></P>

      <P>This calls<OL>
         <LI>{@link com.github.xbn.analyze.AnalyzerComposer super}.{@link com.github.xbn.analyze.AnalyzerComposer#resetCounts() resetCounts}{@code ()}</LI>
         <LI>{@link #zresetCountsVB() zresetCountsVB}{@code ()}</LI>
      </OL></P>
    **/
   @CompositionFunction
   public void resetCounts()  {
      super.resetCounts();
      zresetCountsVB();
   }
   /**
      <P>Reset counts specific to this {@code ValidatorComposer}.</P>

      <P>This sets {@link #getValidCount() getValidCount}{@code ()} to zero.</P>
      @see  #resetCounts()
    **/
   protected final void zresetCountsVB()  {
      validCount = 0;
   }
   public ValidResultFilter getFilter()  {
      return  vrFilter;
   }
   public boolean declareGetValidFromPreFilterNoInvert_4prot(boolean is_validAccordingToPreFilter)  {
      return  declareValidSetSourceInvertIfRules_4prot(is_validAccordingToPreFilter, ResultReturnedBy.PRE_FILTER);
   }
   public boolean declareValidForRulesGetInverted_4prot(boolean are_preInvertRulesFollowed)  {
      return  declareValidSetSourceInvertIfRules_4prot(are_preInvertRulesFollowed, ResultReturnedBy.RULES);
   }
   public void declarePostFilterReturnValue_4prot(FilterAfterValue fp_v, boolean is_validAccordingToPostFilter)  {
      declareValidSetSourceInvertIfRules_4prot(is_validAccordingToPostFilter, ResultReturnedBy.POST_FILTER);
   }
      private boolean declareValidSetSourceInvertIfRules_4prot(boolean is_valid, ResultReturnedBy source)  {
         declareAnalyzed_4prot();

         try  {
            if(source.isRules())  {
               wasValid = (doInvertRules() ? !is_valid : is_valid);
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(source, "source", null, rx);
         }

         validResultSource = source;

         if(wasValid)  {
            validCount++;
         }

         return  wasValid;
      }
//setters...END
//getters...START
   /**
      @return  The number of times {@link #declareValidSetSourceInvertIfRules_4prot(boolean, ResultReturnedBy) declarePreInvertGetValidSetSource_4prot}{@code (true, ...)} was called, since the last call to {@link #zresetCountsVB() zresetCountsVB}{@code ()}.
    **/
   @CompositionFunction
   public int getValidCount()  {
      return  validCount;
   }
   @CompositionFunction
   public ResultReturnedBy getValidResultSource()  {
      return  validResultSource;
   }
   /**
      @return  {@code true} If {@link #declareValidSetSourceInvertIfRules_4prot(boolean, ResultReturnedBy) declarePreInvertGetValidSetSource_4prot}{@code (true, ...)} was called more recently than {@link #resetState() resetState}{@code ()}.
    **/
   @CompositionFunction
   public boolean isValid()  {
      return  wasValid;
   }
   @CompositionFunction
   public boolean doInvertRules()  {
      return  doInvert;
   }
   @CompositionFunction
   public final RuleType getRuleType()  {
      return  ruleCmpsr.getRuleType();
   }
   @CompositionFunction
   public void setERuleType_4prot(RuleType type)  {
   }
   @CompositionFunction
   public void setERuleType_4prot(RuleType type, String type_name)  {
      ruleCmpsr.setERuleType_4prot(type, type_name);
   }
//getters...END
//other...START
   @CompositionFunction
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo);
      if(doInvertRules())  {
         to_appendTo.append(", doInvertRules()=true");
      }
      if(wasAnalyzed())  {
         to_appendTo.append(", isValid()=").append(isValid());
      }
      to_appendTo.append(", getValidCount()=").append(getValidCount()).append(", ");

      ruleCmpsr.appendToString(to_appendTo);

      if(!getFilter().doesNothing())  {
         to_appendTo.append(", ").append("filter:<");
         getFilter().appendToString(to_appendTo).append(">");
      }

      return  to_appendTo;
   }
   public static final boolean areValidatorFieldsEqual(Validator vldtr_a, Validator vldtr_b)  {
      try  {
         return  vldtr_a.doInvertRules() == vldtr_b.doInvertRules()  &&
            vldtr_a.getRuleType().equals(vldtr_b.getRuleType());
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(vldtr_a, "vldtr_a");
         throw  CrashIfObject.nullOrReturnCause(vldtr_b, "vldtr_b", null, rx);
      }
   }
//other...END
//static...START
   /**
      <P>If a <CODE>Validator</CODE>-s rule-type is not as required, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>validator.getRuleType().{@link com.github.xbn.lang.RuleType#crashIfNotRequiredValue(RuleType, String, Object) ciNotRequiredRuleType}(validator.{@link #getRuleType() getRuleType}(), rqd_value, vldtr_name)</CODE></P>
    **/
   public static final void ciNotRequiredRuleType(Validator validator, RuleType rqd_value, String vldtr_name, Object xtra_errInfo)  {
      try  {
         validator.getRuleType().crashIfNotRequiredValue(rqd_value, sVNM_GERT,
            XInfoAccumulator.getAddedOrNew(xtra_errInfo, toVNM_EQLS.set2(vldtr_name)));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(validator, "validator", null, rx);
      }
   }
   /**
      <P>If a <CODE>Validator</CODE>-s rule-type is a forbidden value, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>validator.getRuleType().{@link com.github.xbn.lang.RuleType#crashIfForbiddenValue(RuleType, String, Object)}(validator.{@link #getRuleType() getRuleType}(), rqd_value, vldtr_name)</CODE></P>
    **/
   public static final void ciForbiddenRuleType(Validator validator, RuleType rqd_value, String vldtr_name, Object xtra_errInfo)  {
      try  {
         validator.getRuleType().crashIfForbiddenValue(rqd_value, sVNM_GERT,
            XInfoAccumulator.getAddedOrNew(xtra_errInfo, toVNM_EQLS.set2(vldtr_name)));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(validator, vldtr_name, null, rx);
      }
   }
      private static final String sVNM_GERT = "[Validator-name].getRuleType()";
      private static final ThreeTSObjects toVNM_EQLS = new ThreeTSObjects(
         "[Validator-name]=\"", null, "\"");
   public static final <O> void ciNullOk(ValueValidator<O> validator, String vldtr_name, Object xtra_errInfo)  {
      ciNullFlagEqualTo(true, validator, vldtr_name, xtra_errInfo);
   }
   public static final <O> void ciNullBad(ValueValidator<O> validator, String vldtr_name, Object xtra_errInfo)  {
      ciNullFlagEqualTo(false, validator, vldtr_name, xtra_errInfo);
   }
      private static final <O> void ciNullFlagEqualTo(boolean flag_value, ValueValidator<O> validator, String vldtr_name, Object xtra_errInfo)  {
         boolean bNk = false;
         try  {
            bNk = (validator.isNullOk()  &&  !validator.doInvertRules());
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(validator, "validator", null, rx);
         }
         if(bNk == flag_value)  {
            throw  new IllegalArgumentException(getXMsg(vldtr_name + ".isNullOk() is " + validator.isNullOk() + ", and validator.doInvertRules() is " + validator.doInvertRules() + ". This means null is " +
               (bNk ? "okay" : "bad")
            + ", which is unacceptable." + ".", xtra_errInfo));
         }
      }
   public static final boolean doesFilterExpire(ValidResultFilterable vr_fbl, String sreplacerfblName, Object xtra_errInfo)  {
      try  {
         return  vr_fbl.getFilter().doesExpire();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(vr_fbl, "vr_fbl", xtra_errInfo);
         throw  CrashIfObject.nullOrReturnCause(vr_fbl.getFilter(), sreplacerfblName + ".getFilter()", xtra_errInfo, rx);
      }
   }
//static...END
   /**
      <P>A valid-result filter that does nothing--it always passes the follows-the-rules value unchanged. This is a singleton that never {@link com.github.xbn.lang.Expirable#isExpired() expires}, whose {@link ValidResultFilter#getPreAction() pre-action} is always {@link FilterPreAction#PROCEED PROCEED}, {@link ValidResultFilter#getAfterValueFromInvertedRules(boolean) post-value} is always {@link FilterAfterValue#UNCHANGED UNCHANGED}.</P>
    **/
   public static final ValidResultFilter unfiltered()  {
      return  VRFDoesNothing.INSTANCE;
   }
}
enum VRFDoesNothing implements ValidResultFilter  {
   INSTANCE;

   public final FilterPreAction getPreAction()  {
      return  FilterPreAction.PROCEED;
   }
   public final FilterAfterValue getAfterValueFromInvertedRules(boolean ignored)  {
      return  FilterAfterValue.UNCHANGED;
   }
   public final VRFDoesNothing getObjectCopy()  {
      return  INSTANCE;
   }
   public final String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public final StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         return  to_appendTo.append(this.getClass().getName());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
   }
   public final boolean doesExpire()  {
      return  false;
   }
   public final boolean isExpired()  {
      return  false;
   }
   public final boolean doesNothing()  {
      return  true;
   }
   public final void setDebug(Appendable destination, boolean is_on)  {
   }
   public final void setDebugOn(boolean is_on)  {
   }
   public final boolean isDebugOn()  {
      return  false;
   }
   public final TextAppenter getDebugAptr()  {
      return  null;
   }
   public final Appendable getDebugApbl()  {
      return  null;
   }
}
