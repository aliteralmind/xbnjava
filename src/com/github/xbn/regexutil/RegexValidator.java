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
package  com.github.xbn.regexutil;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.analyze.validate.NullnessValidator;
   import  com.github.xbn.regexutil.z.RegexValidator_Fieldable;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.text.padchop.NewVzblPadChopFor;
/**
   <p>Validate a string against a regular expression.</p>

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.regexutil.z.RegexValidator_Cfg RegexValidator_Cfg}</h3>

   <p><ul>
      <li><b>Find what:</b> <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#literal(String) literal}(s)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#pattern(Pattern) pattern}(p)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#regex(String) regex}(s)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#regex(String, int) regex}(s,i)</code></li>
      <li><b>Matcher uses:</b> <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#useFind() useFind}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#useLookingAt() useLookingAt}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#useMatches() useMatches}()</code></li>
      <li><b>Basics:</b> <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#unfiltered() unfiltered}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#filter(ValidResultFilter) filter}(vrf)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#invert(boolean) invert}(b)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#nullOk(boolean) nullOk}(b)</code></li>
      <li><b>Other:</b> <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#reset() reset}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#debugTo(Appendable) debugTo}(apbl)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#extraErrInfo(Object) extraErrInfo}(o)</code>, <code>{@link com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#chainID(boolean, Object) chainID}(b,o)</code></li>
   </ul>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RegexValidator extends NullnessValidator<String> implements PatternHaser  {
   private final SimplePatternHaser ptrnHsr;
   private final Matcher            mtchr  ;
   private String                   validStr = null;
//internal
   private static final VzblPadChop VPC_DBG = NewVzblPadChopFor.trimEscChopWithDDD(true, null, 30);
   /**
      <p>Create a new instance from a fieldable.</p>

    * <p>Equal to
      <br> &nbsp; &nbsp; <code>{@link #RegexValidator(RuleType, RegexValidator_Fieldable) this}({@link com.github.xbn.lang.RuleType RuleType}.{@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}, fieldable)</code></p>
    */
   public RegexValidator(RegexValidator_Fieldable fieldable)  {
      this(RuleType.RESTRICTED, fieldable);
   }
   /**
      <p>Create a new instance from a fieldable.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.analyze.validate.NullnessValidator#NullnessValidator(RuleType, ValueValidator_Fieldable) super}{@code (rule_type, fieldable)}</li>
         <li>Sets all internal fields from {@code fieldable}.</li>
         <li>Calls {@link #resetStateRV() resetStateRV}{@code ()}.</li>
      </ol>

    * @param  fieldable  May not be {@code null}, and its fields must conform to all restrictions as documented in the <a href="#cfg">builder's setter functions</a>.
    * @see  #RegexValidator(RegexValidator_Fieldable) this(rv_f)
    * @see  #RegexValidator(RegexValidator) this(rv)
    */
   protected RegexValidator(RuleType rule_type, RegexValidator_Fieldable fieldable)  {
      super(rule_type, fieldable);
      ptrnHsr = (new SimplePatternHaser()).pattern(fieldable.getPattern()).
         matcherUses(fieldable.getMatcherUses());

      ptrnHsr.getMatcherUses().crashIfForbiddenValue(MatcherUses.CUSTOM, "fieldable.getMatcherUses()", null);

      //Unused search, so the matcher can be reset(s) at each call to isValid(o)
      mtchr = getPattern().matcher("");
      resetStateRV();
   }
   /**
      <p>Create a new instance as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.analyze.validate.NullnessValidator#NullnessValidator(ValueValidator) super}{@code (to_copy)}</li>
      </ol>

    * @param  to_copy  May not be {@code null}.
    * @see  #RegexValidator(RuleType, RegexValidator_Fieldable) this(rti,rv_f)
    * @see  #getObjectCopy()
    */
   public RegexValidator(RegexValidator to_copy)  {
      super(to_copy);
      ptrnHsr = new SimplePatternHaser(to_copy);

      //Unused search, so the matcher can be reset(s) at each call to isValid(o)
      mtchr = getPattern().matcher("");
      validStr = to_copy.getValidString();
   }
   /**
      <p>Reset state in preparation for the next validation.</p>

      <p>This calls<ol>
         <li><code>{@link com.github.xbn.analyze.validate.NullnessValidator NullnessValidator}.{@link com.github.xbn.analyze.validate.NullnessValidator#resetState() resetState}()</code></li>
         <li>{@link #resetStateRV() resetStateRV}{@code ()}</li>
      </ol>
    */
   public void resetState()  {
      super.resetState();
      resetStateRV();
   }
   /**
      <p>Reset state specific to this {@code RegexValidator}.</p>

      <p>This sets<ol>
         <li>{@link #getValidString() getValidString}{@code ()} to {@code null}</li>
         <li>{@link #wasJustMatched() wasJustMatched}{@code ()} to {@code false}.</li>
      </ol>

    * @see  #resetState()
    */
   public void resetStateRV()  {
      validStr = null;
      ptrnHsr.declareNotMatched();
   }
   /**
      <p>The most-recently analyzed string that <i>did match</i> the pattern.</p>

    * @return  If {@link #wasJustMatched() wasJustMatched}{@code ()} is<ul>
         <li>{@code true}: The string from the most recent call to {@link #doesFollowRulesPreInvert(String) doesFollowRulesPreInvert}{@code (s)}.</li>
         <li>{@code false}: {@code null}</li>
      </ul>
    * @see  #getMatchedIndex()
    */
   public String getValidString()  {
      return  validStr;
   }
   //Composition implementation: null...START
      /**
         <p>The pattern a string must match, in order to be considered valid.</p>

       * @see  com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#pattern(Pattern) RegexValidator_Cfg#pattern(p)
       */
      public Pattern getPattern()  {
         return  ptrnHsr.getPattern();
      }
      /**
         <p>The index in {@code getValidString()} at which the match was found.</p>

       * @return  If {@link #wasJustMatched() wasJustMatched}{@code ()} is<ul>
            <li>{@code true}: A number zero through <code>({@link #getValidString() getValidString}().length() - 1)</code>.</li>
            <li>{@code false}: {@code -1}</li>
         </ul>
       */
      public int getMatchedIndex()  {
         return  ptrnHsr.getMatchedIndex();
      }
      public int getMatchCount()  {
         return  ptrnHsr.getMatchCount();
      }
      /**
         <p>Did the most-recently analyzed string match the pattern?.</p>

       * @return  The value as returned by the most recent call to {@link #doesFollowRulesPreInvert(String) doesFollowRulesPreInvert}{@code ()}, or {@code false} if {@link #resetState() resetState}{@code ()} was more recently called. This returns the same value as <code>{@link com.github.xbn.analyze.validate.AbstractValidator AbstractValidator}.{@link com.github.xbn.analyze.validate.AbstractValidator#isValid() wasValid}()</code>.
       */
      public boolean wasJustMatched()  {
         return  ptrnHsr.wasJustMatched();
      }
      /**
         <p>Should the string be matched as a whole?. Should <code><i>[{@link java.util.regex.Matcher}]</i>.{@link java.util.regex.Matcher#matches() matches}()</code> be used?.</p>

       * @return  A non-{@code null} {@code MatcherUses} that is equal to something other than {@link com.github.xbn.regexutil.MatcherUses#CUSTOM CUSTOM}
       * @see  com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#useMatches() Cfg.useMatches()
       * @see  com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#useFind() Cfg.useFind()
       * @see  com.github.xbn.regexutil.z.RegexValidator_CfgForNeeder#useLookingAt() Cfg.useLookingAt()
       */
      public MatcherUses getMatcherUses()  {
         return  ptrnHsr.getMatcherUses();
      }
   //Composition implementation: null...END
   /**
      <p>The matcher that searches each string. This is not affected by {@link #resetState() resetState}{@code ()}).</p>
    */
   protected Matcher getMatchedMatcher()  {
      return  mtchr;
   }
   /**
      <p>Does the string match the pattern?.</p>

    * @return  {@code true}: If<ul>
         <li>{@code to_validate} is {@code null} and that is {@link com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() okay}, or</li>
         <li>it is non-{@code null} and {@link #getMatchedMatcher() matches} the {@link #getPattern() pattern} in the {@link #getMatcherUses() expected way}.</li>
      </ul>
    * @see  <code>NullnessValidator.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="#doesFollowRulesPreInvert(O)">doesFollowRulesPreInvert</a>(O)</code></li>
    * @see  #getValidString()
    * @see  #getMatchedIndex()
    * @see  #wasJustMatched()
    */
   public boolean doesFollowRulesPreInvert(String to_validate)  {
      if(isDebugOn()) { getDebugAptr().appentln("<RV> testing \"" + VPC_DBG.get(to_validate) + "\", " + this); }
      validStr = null;
      if(!super.doesFollowRulesPreInvert(to_validate))  {
         if(isDebugOn()) { getDebugAptr().appentln("<RV> super.doesFollowRulesPreInvert(s) is false."); }
         return  false;
      }
      if(to_validate == null)  {
         if(isDebugOn()) { getDebugAptr().appentln("<RV> to_validate is null (which is valid)."); }
         return  true;
      }

      ptrnHsr.declareNotMatched();

      //Assume matched (1/2)
      validStr = to_validate;

      mtchr.reset(validStr);

      if(getMatcherUses().isMatches()  &&  mtchr.matches())  {
         ptrnHsr.matchedIndex(0);
         if(isDebugOn()) { getDebugAptr().appentln("<RV> Matched via matches."); }
         return  true;
      }

      if(getMatcherUses().isFind()  &&  mtchr.find())  {
         ptrnHsr.matchedIndex(mtchr.start());
         if(isDebugOn()) { getDebugAptr().appentln("<RV> Found at index " + mtchr.start() + "."); }
         return  true;
      }

      if(mtchr.lookingAt())  {
         ptrnHsr.matchedIndex(0);
         if(isDebugOn()) { getDebugAptr().appentln("<RV> Matched via lookingAt."); }
         return  true;
      }

      //Not matched (2/2)
      validStr = null;

      if(isDebugOn()) { getDebugAptr().appentln("<RV> Not matched (invalid)."); }
      return  false;
   }
   /*
      <p>Does not change the value of {@link #getMatchedIndex}{@code ()}</p>
   public void crashIfBadValue(String to_validate, String toVldt_name)  {
      super.crashIfBadValue(to_validate, toVldt_name);

      if(getMatcherUses().isMatches())  {
         if(!mtchr.matches())  {
            throw  new IllegalArgumentException(getXMsg("[getPattern().matcher(" + toVldt_name + ").matches() is false.", getExtraErrInfo()));
         }
      }  else if(getMatcherUses().isFind())  {
         if(!mtchr.find())  {
            throw  new IllegalArgumentException(getXMsg("(The first call to) [getPattern().matcher(" + toVldt_name + ").find() is false.", getExtraErrInfo()));
         }
      }  else if(!mtchr.lookingAt())  {
         throw  new IllegalArgumentException(getXMsg("[getPattern().matcher(" + toVldt_name + ").lookingAt() is false.", getExtraErrInfo()));
      }
   }
    */
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      if(NullnessValidator.isImpossibleConsideringNullInvert(this))  {
         return  to_appendTo.append("impossible (null-ok, inverted)");
      }

      to_appendTo.append("null-").
         append(isNullOk() ? "ok" : "bad");
      if(doInvertRules())  {
         to_appendTo.append(", inverted");
      }
      return  to_appendTo.append(", pattern=[\"").append(getPattern()).
         append("\", flags=" + getPattern().flags() + "], MatcherUses=").append(getMatcherUses());
   }
   /**
      <p>Duplicate this <code>RegexValidator</code>.</p>

    * @return  <code>(new {@link #RegexValidator(RegexValidator) RegexValidator}(this))</code>
    */
   public RegexValidator getObjectCopy()  {
      return  (new RegexValidator(this));
   }
/*
   public RegexValidator extraErrInfo(Object info)  {
      super.extraErrInfo(info);
      return  this;
   }
 */
}
