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
package  com.github.xbn.linefilter.alter;
   import  com.github.xbn.analyze.alter.AlterationRequired;
   import  com.github.xbn.linefilter.NewTextLineValidatorFor;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
   import  com.github.xbn.regexutil.NewPatternFor;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.StringReplacer;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  java.util.regex.Pattern;
   import  org.apache.commons.lang3.StringEscapeUtils;
/**
   <p>Convenience functions for creating text-line alterers from validators and regular expressions.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewTextLineAltererFor  {
   /**
      <p>Does nothing. The input is returned without change.</p>

    * @return  <code>(new {@link com.github.xbn.linefilter.alter.AlterTextLineWhen#AlterTextLineWhen() AlterTextLineWhen}()</code>
    */
   public static final AlterTextLineWhen alwaysReturnUnchanged()  {
      return  (new AlterTextLineWhen());
   }
   /**
      <p><i><b>Deprecated</b> for {@code textValidateOnly}</i>--Identifies the line's text based on a regular expression--the line is not altered.</p>

    * @return  <code>{@link #textValidateOnly(Pattern, ValidResultFilter, Appendable) textValidateOnly}(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull)</code>
      @deprecated  Use {@link #textValidateOnly(ValueValidator) textValidateOnly}
    */
   @Deprecated
   public static final AlterTextLineWhen text(Pattern pattern_toFind, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  textValidateOnly(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull);
   }
   /**
      <p><i><b>Deprecated</b> for {@code textValidateOnly}</i>--Identifies the line's text based on a regular expression--the line is not altered.</p>

    * @return  <code>{@link #textValidateOnly(ValueValidator) textValidateOnly}(string_validator)</code>
      @deprecated  Use {@link #textValidateOnly(ValueValidator) textValidateOnly}
    */
   @Deprecated
   public static final AlterTextLineWhen text(ValueValidator<String> string_validator)  {
      return  textValidateOnly(string_validator);
   }
   /**
      <p><i><b>Deprecated</b> for {@code textValidateOnly}</i>--Identifies the line's text based on a regular expression--the line is not altered.</p>

    * @return  <code>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#text(Pattern, ValidResultFilter, Appendable) text}(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull))</code>
    */
   public static final AlterTextLineWhen textValidateOnly(Pattern pattern_toFind, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.text(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull));
   }
   /**
      <p><i><b>Deprecated</b> for {@code textValidateOnly}</i>--Identifies the line's text based on a regular expression--the line is not altered.</p>

    * @return  <code>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#text(String, ValidResultFilter, Appendable) text}(literal_textToMatch, filter_ifNonNull, dbgDest_ifNonNull))</code>
    */
   public static final AlterTextLineWhen textValidateOnly(String literal_textToMatch, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.text(literal_textToMatch, filter_ifNonNull, dbgDest_ifNonNull));
   }
   /**
      <p>Identifies the line's text based on some condition--the line is not altered.</p>

    * @return  <code>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#text(ValueValidator) text}(string_validator))</code>
    */
   public static final AlterTextLineWhen textValidateOnly(ValueValidator<String> string_validator)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.text(string_validator));
   }
   /**
      <p>Identifies the line's number based on some condition--the line's text is not altered.</p>

    * @return  <code>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#number(ValueValidator) number}(int_validator))</code>
    */
   public static final AlterTextLineWhen number(ValueValidator<Integer> int_validator)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.number(int_validator));
   }
   /**
      <p>Inserts the line number before each line's body.</p>

    * @param  start_lineNum  The first line number. <i>Should</i> be 1 or greater.
    * @param  btw_numAndText  The text to go between the number and body. <i>Should</i> be non-{@code null} and non-empty.
    */
   public static final TextLineAlterer prependLineNumber(int start_lineNum, String btw_numAndText)  {
      return  (new PrependLineNumToText(start_lineNum, btw_numAndText));
   }
   /**
      <p>Escape all characters for html display. Uses <code>org.apache.commons.lang3.{@link org.apache.commons.lang3.StringEscapeUtils}{@link org.apache.commons.lang3.StringEscapeUtils#escapeHtml4 escapeHtml4}</code>.</p>
    */
   public static final TextLineAlterer escapeHtml()  {
      return  (new EscapeLineTextForHtmlDisplay());
   }
   /**
      <p>Make a literal string replacement.</p>

    * @return  <code>{@link #replacement(AlterationRequired, Pattern, String, ReplacedInEachInput, Appendable, ValidResultFilter) replacement}({@link com.github.xbn.regexutil.NewPatternFor#literal(String) literal}(find_what), rplc_with, rplcs_what, dbgDest_ifNonNull, filter_ifNonNull)</code>
    */
   public static final TextLineAlterAdapter<StringReplacer> literalReplacement(AlterationRequired required, String find_what, String rplc_with, ReplacedInEachInput rplcs_what, Appendable dbgDest_ifNonNull, ValidResultFilter filter_ifNonNull)  {
      return  replacement(required, NewPatternFor.literal(find_what, "find_what"), rplc_with, rplcs_what, dbgDest_ifNonNull, filter_ifNonNull);
   }
   /**
      <p>Makes a regular expression replacement.</p>

    * @return  <code>{@link com.github.xbn.linefilter.AdaptRegexReplacerTo AdaptRegexReplacerTo}.{@link com.github.xbn.linefilter.AdaptRegexReplacerTo#lineReplacer(AlterationRequired, RegexReplacer, ValidResultFilter) lineReplacer}(required, rr, filter_ifNonNull)</code>
      <br>Where {@code rr} is a
      <br> &nbsp; &nbsp; <code>new {@link com.github.xbn.regexutil.z.RegexReplacer_Cfg RegexReplacer_Cfg}.{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg#RegexReplacer_Cfg() RegexReplacer_Cfg}().
         {@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(Pattern, Object) direct}(ptrn_findWhat, rplc_with).{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#replaceWhatNotMatchNums(ReplacedInEachInput) replaceWhatNotMatchNums}(rplcs_what).
         {@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#debugTo(Appendable) debugTo}(dbgDest_ifNonNull).{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#build() build}();</code>
    * @see  #literalReplacement(AlterationRequired, String, String, ReplacedInEachInput, Appendable, ValidResultFilter)
    */
   public static final TextLineAlterAdapter<StringReplacer> replacement(AlterationRequired required, Pattern ptrn_findWhat, String rplc_with, ReplacedInEachInput rplcs_what, Appendable dbgDest_ifNonNull, ValidResultFilter filter_ifNonNull)  {
      RegexReplacer rr = new RegexReplacer_Cfg().
         direct(ptrn_findWhat, rplc_with).replaceWhatNotMatchNums(rplcs_what).
         debugTo(dbgDest_ifNonNull).build();
      return  AdaptRegexReplacerTo.lineReplacer(required, rr, filter_ifNonNull);
   }
   private NewTextLineAltererFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }

}
class PrependLineNumToText extends AbstractValueAlterer<String,String> implements TextLineAlterer  {
   private final String btwNumAndTxt;
   private int lineNum;
   public PrependLineNumToText(int first_lineNum)  {
      this(first_lineNum, ".  ");
   }
   public PrependLineNumToText(int first_lineNum, String between_numAndText)  {
      super();
      lineNum = first_lineNum;
      btwNumAndTxt = between_numAndText;
   }
   public PrependLineNumToText(PrependLineNumToText to_copy)  {
      super(to_copy);
      lineNum = to_copy.getLineNum();
      btwNumAndTxt = to_copy.getBetweenNumAndText();
   }
   public int getLineNum()  {
      return  lineNum;
   }
   public String getBetweenNumAndText()  {
      return  btwNumAndTxt;
   }
   public String getAlteredPostResetCheck(String ignored, String to_alter)  {
      declareAltered(Altered.YES, NeedsToBeDeleted.NO);
      return  (lineNum++) + getBetweenNumAndText() + to_alter;
   }
   public PrependLineNumToText getObjectCopy()  {
      return  (new PrependLineNumToText(this));
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  to_appendTo.append(this.getClass().getName()).append(": getLineNum()=" + getLineNum() + " getBetweenNumAndText()=\"" + getBetweenNumAndText() + "\"");
   }
}
class EscapeLineTextForHtmlDisplay extends AbstractValueAlterer<String,String> implements TextLineAlterer  {
   public EscapeLineTextForHtmlDisplay()  {
   }
   public EscapeLineTextForHtmlDisplay(EscapeLineTextForHtmlDisplay to_copy)  {
      super(to_copy);
   }
   public String getAlteredPostResetCheck(String ignored, String to_alter)  {
      declareAltered(Altered.YES, NeedsToBeDeleted.NO);
      return  StringEscapeUtils.escapeHtml4(to_alter);
   }
   public EscapeLineTextForHtmlDisplay getObjectCopy()  {
      return  (new EscapeLineTextForHtmlDisplay(this));
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  to_appendTo.append(this.getClass().getName());
   }
}
