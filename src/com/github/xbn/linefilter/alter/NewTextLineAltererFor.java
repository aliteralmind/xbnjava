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
   import  com.github.xbn.linefilter.NewTextLineValidatorFor;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
   import  com.github.xbn.regexutil.NewPatternFor;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.StringReplacer;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  com.github.xbn.text.StringUtil;
   import  java.util.regex.Pattern;
   import  org.apache.commons.lang3.StringEscapeUtils;
/**
   <P>Convenience functions for creating text-line alterers from validators and regular expressions.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewTextLineAltererFor  {
   /**
      <P>Does nothing. The input is returned without change.</P>

      @return  <CODE>(new {@link com.github.xbn.linefilter.alter.AlterTextLineWhen#AlterTextLineWhen() AlterTextLineWhen}()</CODE>
    **/
   public static final AlterTextLineWhen alwaysReturnUnchanged()  {
      return  (new AlterTextLineWhen());
   }
   /**
      <P>ReplacedInEachInput all tabs to spaces.</P>

      @return  <CODE>{@link #literalReplacement(String, String, ReplacedInEachInput, Appendable, ValidResultFilter) literalReplacement}(&quot;\t&quot;, spaces, {@link com.github.xbn.regexutil.ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#ALL ALL}, dbgDest_ifNonNull, null)</CODE>
      <BR>Where {@code spaces} is a {@linkplain com.github.xbn.text.StringUtil#getStringOfLengthAllCharsEqualTo(int, char, String) string of only} spaces, {@code space_count} characters in length.
      @see  #literalReplacement(String, String, ReplacedInEachInput, Appendable, ValidResultFilter)
   public static final TextLineAlterAdapter<StringReplacer> replaceTabToSpaces(int space_count, Appendable dbgDest_ifNonNull, String count_varName)  {
      String spaces = StringUtil.getStringOfLengthAllCharsEqualTo(space_count, ' ', count_varName);
      return  literalReplacement("\t", spaces, ReplacedInEachInput.ALL, dbgDest_ifNonNull, null);
   }
    **/
   /**
      <P><I><B>Deprecated</B> for {@code textValidateOnly}</I>--Identifies the line's text based on a regular expression--the line is not altered.</P>

      @return  <CODE>{@link #textValidateOnly(Pattern, ValidResultFilter, Appendable) textValidateOnly}(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull)</CODE>
      @deprecated  Use {@link #textValidateOnly(ValueValidator) textValidateOnly}
    **/
   @Deprecated
   public static final AlterTextLineWhen text(Pattern pattern_toFind, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  textValidateOnly(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull);
   }
   /**
      <P><I><B>Deprecated</B> for {@code textValidateOnly}</I>--Identifies the line's text based on a regular expression--the line is not altered.</P>

      @return  <CODE>{@link #textValidateOnly(ValueValidator) textValidateOnly}(string_validator)</CODE>
      @deprecated  Use {@link #textValidateOnly(ValueValidator) textValidateOnly}
    **/
   @Deprecated
   public static final AlterTextLineWhen text(ValueValidator<String> string_validator)  {
      return  textValidateOnly(string_validator);
   }
   /**
      <P><I><B>Deprecated</B> for {@code textValidateOnly}</I>--Identifies the line's text based on a regular expression--the line is not altered.</P>

      @return  <CODE>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#text(Pattern, ValidResultFilter, Appendable) text}(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull))</CODE>
    **/
   public static final AlterTextLineWhen textValidateOnly(Pattern pattern_toFind, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.text(pattern_toFind, filter_ifNonNull, dbgDest_ifNonNull));
   }
   /**
      <P><I><B>Deprecated</B> for {@code textValidateOnly}</I>--Identifies the line's text based on a regular expression--the line is not altered.</P>

      @return  <CODE>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#text(String, ValidResultFilter, Appendable) text}(literal_textToMatch, filter_ifNonNull, dbgDest_ifNonNull))</CODE>
    **/
   public static final AlterTextLineWhen textValidateOnly(String literal_textToMatch, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.text(literal_textToMatch, filter_ifNonNull, dbgDest_ifNonNull));
   }
   /**
      <P>Identifies the line's text based on some condition--the line is not altered.</P>

      @return  <CODE>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#text(ValueValidator) text}(string_validator))</CODE>
    **/
   public static final AlterTextLineWhen textValidateOnly(ValueValidator<String> string_validator)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.text(string_validator));
   }
   /**
      <P>Identifies the line's number based on some condition--the line's text is not altered.</P>

      @return  <CODE>{@link com.github.xbn.linefilter.alter.AlterTextLineWhen AlterTextLineWhen}.{@link com.github.xbn.linefilter.alter.AlterTextLineWhen#newATLWAlwaysReturnSelf(ValueValidator) newATLWAlwaysReturnSelf}{@link com.github.xbn.linefilter.NewTextLineValidatorFor NewTextLineValidatorFor}.{@link com.github.xbn.linefilter.NewTextLineValidatorFor#number(ValueValidator) number}(int_validator))</CODE>
    **/
   public static final AlterTextLineWhen number(ValueValidator<Integer> int_validator)  {
      return  AlterTextLineWhen.newATLWAlwaysReturnSelf(NewTextLineValidatorFor.number(int_validator));
   }
   /**
      <P>Inserts the line number before each line's body.</P>

      @param  start_lineNum  The first line number. <I>Should</I> be 1 or greater.
      @param  btw_numAndText  The text to go between the number and body. <I>Should</I> be non-{@code null} and non-empty.
    **/
   public static final TextLineAlterer prependLineNumber(int start_lineNum, String btw_numAndText)  {
      return  (new PrependLineNumToText(start_lineNum, btw_numAndText));
   }
   /**
      <P>Escape all characters for html display. Uses <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.StringEscapeUtils}{@link org.apache.commons.lang3.StringEscapeUtils#escapeHtml4 escapeHtml4}</CODE>.</P>
    **/
   public static final TextLineAlterer escapeHtml()  {
      return  (new EscapeLineTextForHtmlDisplay());
   }
   /**
      <P>Make a literal string replacement.</P>

      @return  <CODE>{@link #replacement(Pattern, String, ReplacedInEachInput, Appendable, ValidResultFilter) replacement}({@link com.github.xbn.regexutil.NewPatternFor#literal(String) literal}(find_what), rplc_with, rplcs_what, dbgDest_ifNonNull, filter_ifNonNull)</CODE>
    **/
   public static final TextLineAlterAdapter<StringReplacer> literalReplacement(String find_what, String rplc_with, ReplacedInEachInput rplcs_what, Appendable dbgDest_ifNonNull, ValidResultFilter filter_ifNonNull)  {
      return  replacement(NewPatternFor.literal(find_what, "find_what"), rplc_with, rplcs_what, dbgDest_ifNonNull, filter_ifNonNull);
   }
   /**
      <P>Makes a regular expression replacement.</P>

      @return  <CODE>{@link com.github.xbn.linefilter.AdaptRegexReplacerTo AdaptRegexReplacerTo}.{@link com.github.xbn.linefilter.AdaptRegexReplacerTo#lineReplacer(RegexReplacer, ValidResultFilter) lineReplacer}(rr, filter_ifNonNull)</CODE>
      <BR>Where {@code rr} is a
      <BR> &nbsp; &nbsp; <CODE>new {@link com.github.xbn.regexutil.z.RegexReplacer_Cfg RegexReplacer_Cfg}.{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg#RegexReplacer_Cfg() RegexReplacer_Cfg}().
         {@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(Pattern, Object) direct}(ptrn_findWhat, rplc_with).{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#replaceWhatNotMatchNums(ReplacedInEachInput) replaceWhatNotMatchNums}(rplcs_what).
         {@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#debugTo(Appendable) debugTo}(dbgDest_ifNonNull).{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#build() build}();</CODE>
      @see  #literalReplacement(String, String, ReplacedInEachInput, Appendable, ValidResultFilter)
    **/
   public static final TextLineAlterAdapter<StringReplacer> replacement(Pattern ptrn_findWhat, String rplc_with, ReplacedInEachInput rplcs_what, Appendable dbgDest_ifNonNull, ValidResultFilter filter_ifNonNull)  {
      RegexReplacer rr = new RegexReplacer_Cfg().
         direct(ptrn_findWhat, rplc_with).replaceWhatNotMatchNums(rplcs_what).
         debugTo(dbgDest_ifNonNull).build();
      return  AdaptRegexReplacerTo.lineReplacer(rr, filter_ifNonNull);
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
