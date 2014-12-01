package  com.github.xbn.list.lister;
   import  com.github.xbn.analyze.validate.ValidatorComposer;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.number.LengthInRangeValidator;
   import  com.github.xbn.number.NewLengthInRangeFor;
   import  com.github.xbn.number.z.LengthInRangeValidator_Cfg;
   import  com.github.xbn.text.StringWithNullDefault;
/**
   <p>Utility class for size-related configuration, as in the length of the overall list, and the length of each element (if lengthable).</p>

 **/
class LLCfgForLengthItems   {
//internal
   /**
      <p>YYY</p>

      <p>If the output of any configuration item, aside from  <code><i>[{@link com.github.xbn.list.lister.LLConfigBase LLConfigBase}]</i>{@link com.github.xbn.list.lister.LLConfigBase#getIfNull() getIfNull}()</code>, contains a {@link #sDISPLAY_SIZE_MARKER}, it is replaced with the list's {@code size()}. Only the first [left-most] marker in each item is recognized. This also includes the string-value of the list itself, if any only if it is altered.</p>

    */
   public static final String sDISPLAY_SIZE_MARKER = "~size~";

   public static final void crashIfBad(ValueValidator<Integer> element_lenValidator, String display_ifValid, String vldtr_name, String disp_ifName)  {
      ValidatorComposer.ciForbiddenRuleType(element_lenValidator, RuleType.UNRESTRICTED, vldtr_name, null);

      if(element_lenValidator.getRuleType().isRestricted()  &&
            (display_ifValid == null  ||  display_ifValid.length() == 0))  {
         String sMsg = vldtr_name + ".getRuleType().isRestricted() is true, but " + disp_ifName + " is (" + StringWithNullDefault.get("\"", display_ifValid, "\"", null) + ").";
         throw  new IllegalArgumentException(sMsg);
      }
   }
   public static final LengthInRangeValidator getLengthInRangeValidatorForZeroLength()  {
      return  new LengthInRangeValidator_Cfg().range(NewLengthInRangeFor.exactly(null, 0, null)).build();
   }
   public static final StringBuilder appendToTS(StringBuilder to_appendTo, ValueValidator<Integer> int_validator, String ifElementLen_alt)  {
      try  {
         if(!int_validator.getRuleType().isUnrestricted())  {
            return  to_appendTo;
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(int_validator, "int_validator", null, rx);
      }
      try  {
         to_appendTo.append(", if-element-length=<alt=\"").append(ifElementLen_alt).
            append("\", [").append(int_validator).append("]>");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }

}
