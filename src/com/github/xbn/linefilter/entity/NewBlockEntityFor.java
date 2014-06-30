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
package  com.github.xbn.linefilter.entity;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
   import  com.github.xbn.linefilter.alter.NewTextLineAltererFor;
   import  com.github.xbn.linefilter.entity.EndRequired;
   import  com.github.xbn.linefilter.entity.raw.RawEntity;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.entity.z.BlockEntity_Cfg;
   import  com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.regexutil.NewPatternFor;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.util.IncludeJavaDoc;
   import  com.github.xbn.util.JavaRegexes;
   import  java.util.regex.Pattern;
/**
   <P>Convenience functions for creating {@code BlockEntity}s.</P>

   @see  com.github.xbn.linefilter.entity.raw.NewRawBlockEntityFor
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewBlockEntityFor  {
   /**
      <P>Create a <I>partially configured</I> block entity, to match a Java multi-line comment.</P>

      @return
<BLOCKQUOTE><PRE>{@link #lineRange_Cfg_startEndFilterDebug(String, Pattern, ValidResultFilter, Appendable, Pattern, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRange_Cfg_startEndFilterDebug}(name_ifNonNull,
   {@link java.util.regex.Pattern}.{@link java.util.regex.Pattern#compile(String) compile}(
         {@link com.github.xbn.util.JavaRegexes}.{@link com.github.xbn.util.JavaRegexes#getMultiLineCommentOpenMarkerRegex(IncludeJavaDoc) getMultiLineCommentOpenMarkerRegex}(java_doc)),
      null, dbgStart_ifNonNull,
   Pattern.compile(&quot;*&quot;+&quot;/&quot;, Pattern.{@link java.util.regex.Pattern#LITERAL LITERAL}), null, dbgEnd_ifNonNull,
   filter_ifNonNull, dbgLineNums_ifNonNull)</PRE></BLOCKQUOTE>
    **/
   public static final BlockEntity_CfgForNeeder<?,?> javaComment_Cfg_startEndDebug(String name_ifNonNull, IncludeJavaDoc java_doc, Appendable dbgStart_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRange_Cfg_startEndFilterDebug(name_ifNonNull,
         Pattern.compile(
               JavaRegexes.getMultiLineCommentOpenMarkerRegex(java_doc)),
            null, dbgStart_ifNonNull,
         Pattern.compile("*"+"/", Pattern.LITERAL), null, dbgEnd_ifNonNull,
         filter_ifNonNull, dbgLineNums_ifNonNull);
   }
   /**
      <P>Create a <I>partially configured</I> block entity, to match a JavaDoc multi-line comment.</P>

      @param  filter_ifNonNull  If non-{@code null}, then a {@linkplain com.github.xbn.analyze.validate.ValidResultFilter#getObjectCopy() unique copy} is used by both the start and end alterers. If {@code null}, then {@code null} is provided to both.
      @return
<BLOCKQUOTE><PRE>{@link #lineRange_Cfg_startEndFilterDebug(String, Pattern, ValidResultFilter, Appendable, Pattern, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRange_Cfg_startEndFilterDebug}(name_ifNonNull,
   startPattern, filter_ifNonNull, null, dbgStart_ifNonNull,
   endPattern, filter_ifNonNull, null, dbgEnd_ifNonNull,
   dbgLineNums_ifNonNull)</PRE></BLOCKQUOTE>
      <BR>Where {@code startPattern} and {@code endPattern} are the {@linkplain java.util.regex.Pattern.LITERAL literal} strings {@code "/"+"**"} and {@code "*"+"/"}.
    **/
   public static final BlockEntity_CfgForNeeder<?,?> javaDocComment_Cfg_startEndFilterDebug(String name_ifNonNull, Appendable dbgStart_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRange_Cfg_startEndFilterDebug(name_ifNonNull,
         Pattern.compile("/"+"**", Pattern.LITERAL), null, dbgStart_ifNonNull,
         Pattern.compile("*"+"/", Pattern.LITERAL), null, dbgEnd_ifNonNull,
         filter_ifNonNull, dbgLineNums_ifNonNull);
   }
   /**
      <P>Create a <I>partially configured</I> block entity, to match a block of lines starting and ending with ones that contain specific text.</P>

      @param  endPtrn_ifNonNull  The pattern that defines the end line (must be found somewhere in the end line). If {@code null}, defaults to <CODE>{@link com.github.xbn.regexutil.NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#IMPOSSIBLE_TO_MATCH IMPOSSIBLE_TO_MATCH}</CODE>
      @return
<BLOCKQUOTE><PRE>new {@link com.github.xbn.linefilter.entity.z.BlockEntity_Cfg#BlockEntity_Cfg(String) BlockEntity_Cfg}(name_ifNonNull).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startAlter(ValueAlterer) startAlter}(NewTextLineAltererFor#textValidateOnly(
      start_ptrn, null, dbgStart_ifNonNull)).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#endAlter(EndRequired, ValueAlterer) endAlter}(endRqd, {@link com.github.xbn.linefilter.alter.NewTextLineAltererFor}.{@link com.github.xbn.linefilter.alter.NewTextLineAltererFor#textValidateOnly(Pattern, ValidResultFilter, Appendable) textValidateOnly} textValidateOnly}(
      endPtrn_ifNonNull, null, dbgEnd_ifNonNull)).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}(dbgLineNums_ifNonNull)</PRE></BLOCKQUOTE>
      <BR>Where {@code endRqd} is, if {@code endPtrn_ifNonNull} is<UL>
         <LI>non-{@code null}: {@link com.github.xbn.linefilter.entity.EndRequired}.{@link com.github.xbn.linefilter.entity.EndRequired#YES YES}</LI>
         <LI>{@code null}: EndRequired.{@link com.github.xbn.linefilter.entity.EndRequired#NO NO}</LI>
      </UL>
      @see  #javaComment_Cfg_startEndDebug(String, IncludeJavaDoc, Appendable, Appendable, RawOnOffEntityFilter, Appendable)
      @see  #javaDocComment_Cfg_startEndFilterDebug(String, Appendable, Appendable, RawOnOffEntityFilter, Appendable)
    **/
   public static final BlockEntity_CfgForNeeder<?,?> lineRange_Cfg_startEndFilterDebug(String name_ifNonNull, Pattern start_ptrn, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, Pattern endPtrn_ifNonNull, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      EndRequired endRqd = EndRequired.YES;
      if(endPtrn_ifNonNull == null)  {
         endPtrn_ifNonNull = NewPatternFor.IMPOSSIBLE_TO_MATCH;
         endRqd = EndRequired.NO;
      }

      return  new BlockEntity_Cfg(name_ifNonNull).
         startAlter(NewTextLineAltererFor.textValidateOnly(
            start_ptrn, startFilter_ifNonNull, dbgStart_ifNonNull)).
         endAlter(endRqd, NewTextLineAltererFor.textValidateOnly(
            endPtrn_ifNonNull, endFilter_ifNonNull, dbgEnd_ifNonNull)).
         filter(filter_ifNonNull).
         debugLineNumbers(dbgLineNums_ifNonNull);
   }
   /**
      <P>Create a new block entity that contains specific text in the start and end lines.</P>

      @param  keep_all  May not be {@code null}.
      @return
<BLOCKQUOTE><PRE>{@link #lineRange(String, KeepStartLine, KeepMidLines, KeepEndLine, Pattern, ValidResultFilter, Appendable, Pattern, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRange}(name_ifNonNull,
         {@link KeepStartLine}.{@link KeepStartLine#getForKeepMatched(KeepMatched, String) getForKeepMatched}(keep_all, ...),
         {@link KeepMidLines}.{@link KeepMidLines#getForKeepMatched(KeepMatched, String) getForKeepMatched}(keep_all, ...),
         {@link KeepEndLine}.{@link KeepEndLine#getForKeepMatched(KeepMatched, String) getForKeepMatched}(keep_all, ...),
         start_ptrn, null, dbgStart_ifNonNull,
         endPtrn_ifNonNull, null, dbgEnd_ifNonNull,
         dbgLineNums_ifNonNull)</PRE></BLOCKQUOTE>
    **/
   public static final BlockEntity lineRange(String name_ifNonNull, KeepMatched keep_all, Pattern start_ptrn, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, Pattern endPtrn_ifNonNull, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRange(name_ifNonNull,
         KeepStartLine.getForKeepMatched(keep_all, "keep_all"),
         KeepMidLines.getForKeepMatched(keep_all, null),
         KeepEndLine.getForKeepMatched(keep_all, null),
         start_ptrn, startFilter_ifNonNull, dbgStart_ifNonNull,
         endPtrn_ifNonNull, endFilter_ifNonNull, dbgEnd_ifNonNull,
         filter_ifNonNull, dbgLineNums_ifNonNull);
   }
   /**
      <P>Create a block entity that contains specific text in the start and end lines.</P>

      @param  keep_start  May not be {@code null}
      @param  keep_mids  May not be {@code null}
      @param  keep_end  May not be {@code null}
      @return
<BLOCKQUOTE><PRE>{@link #lineRange_Cfg_startEndFilterDebug(String, Pattern, ValidResultFilter, Appendable, Pattern, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRange_Cfg_startEndFilterDebug}(name_ifNonNull,
      start_ptrn, null, dbgStart_ifNonNull,
      endPtrn_ifNonNull, null, dbgEnd_ifNonNull,
      dbgLineNums_ifNonNull).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(keep_start.{@link KeepStartLine#isYes() isYes}(), keep_mids.{@link KeepMidLines#isYes() isYes}(), keep_end.{@link KeepEndLine#isYes() isYes}()).
   build()
</PRE></BLOCKQUOTE>
      @see  #lineRange(String, KeepMatched, Pattern, ValidResultFilter, Appendable, Pattern, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable)
    **/
   public static final BlockEntity lineRange(String name_ifNonNull, KeepStartLine keep_start, KeepMidLines keep_mids, KeepEndLine keep_end, Pattern start_ptrn, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, Pattern endPtrn_ifNonNull, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  lineRange_Cfg_startEndFilterDebug(name_ifNonNull,
               start_ptrn, startFilter_ifNonNull, dbgStart_ifNonNull,
               endPtrn_ifNonNull, endFilter_ifNonNull, dbgEnd_ifNonNull,
               filter_ifNonNull, dbgLineNums_ifNonNull).
            keepStartMidEnd(keep_start.isYes(), keep_mids.isYes(), keep_end.isYes()).
            build();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(keep_start, "keep_start", null);
         CrashIfObject.nnull(keep_mids, "keep_mids", null);
         throw  CrashIfObject.nullOrReturnCause(keep_end, "keep_end", null, rx);
      }
   }
   /**
      <P>Create a <I>partially configured</I> block entity that contains specific text in the start and end lines--this also makes replacements on each line.</P>

      @param  midAlterer_ifNonNull  The alterer that modifies any lines between the start and end lines. If {@code null}, {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#midAlter(ValueAlterer) midAlter} is never called.
      @param  endPtrn_ifNonNull  The pattern that defines the end line (must be found somewhere in the end line). If {@code null}, defaults to <CODE>{@link com.github.xbn.regexutil.NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#IMPOSSIBLE_TO_MATCH IMPOSSIBLE_TO_MATCH}</CODE>
      @return
<BLOCKQUOTE><PRE>new {@link com.github.xbn.linefilter.entity.z.BlockEntity_Cfg#BlockEntity_Cfg(String) BlockEntity_Cfg}(
      name_ifNonNull).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#startAlter(ValueAlterer) startAlter}(AdaptRegexReplacerTo.lineReplacer(
      start_ptrn, start_rplcWith, startRplcWhat_notMatchNums,
      null, dbgStart_ifNonNull)).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#midAlter(ValueAlterer) midAlter}(midAlterer_ifNonNull).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#endAlter(EndRequired, ValueAlterer) endAlter}(endRqd, AdaptRegexReplacerTo.lineReplacer(
      endPtrn_ifNonNull, end_rplcWith, endRplcWhat_notMatchNums,
      null, dbgEnd_ifNonNull)).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#debugLineNumbers(Appendable) debugLineNumbers}(dbgLineNums_ifNonNull)</PRE></BLOCKQUOTE>
      <BR>Where {@code endRqd} is, if {@code endPtrn_ifNonNull} is<UL>
         <LI>non-{@code null}: {@link com.github.xbn.linefilter.entity.EndRequired}.{@link com.github.xbn.linefilter.entity.EndRequired#YES YES}</LI>
         <LI>{@code null}: EndRequired.{@link com.github.xbn.linefilter.entity.EndRequired#NO NO}</LI>
      </UL>
      @see  #lineRangeWithReplace(String, KeepStartLine, KeepMidLines, KeepEndLine, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, ValueAlterer, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRangeWithReplace(...,KeepStartLine, KeepMidLines, KeepEndLine,...)
    **/
   public static final BlockEntity_CfgForNeeder<?,?> lineRangeWithReplace_Cfg_startEndFilterDebug(String name_ifNonNull, Pattern start_ptrn, String start_rplcWith, ReplacedInEachInput startRplcWhat_notMatchNums, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, ValueAlterer<String,String> midAlterer_ifNonNull, Pattern endPtrn_ifNonNull, String end_rplcWith, ReplacedInEachInput endRplcWhat_notMatchNums, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      EndRequired endRqd = EndRequired.YES;
      if(endPtrn_ifNonNull == null)  {
         endPtrn_ifNonNull = NewPatternFor.IMPOSSIBLE_TO_MATCH;
         endRqd = EndRequired.NO;
      }

      BlockEntity_CfgForNeeder<?,?> blockCfn = new BlockEntity_Cfg(
            name_ifNonNull).
         startAlter(AdaptRegexReplacerTo.lineReplacer(
            start_ptrn, start_rplcWith, startRplcWhat_notMatchNums,
            startFilter_ifNonNull, dbgStart_ifNonNull)).
         endAlter(endRqd, AdaptRegexReplacerTo.lineReplacer(
            endPtrn_ifNonNull, end_rplcWith, endRplcWhat_notMatchNums,
            endFilter_ifNonNull, dbgEnd_ifNonNull)).
         filter(filter_ifNonNull).
         debugLineNumbers(dbgLineNums_ifNonNull);

      if(midAlterer_ifNonNull != null)  {
         blockCfn.midAlter(midAlterer_ifNonNull);
      }

      return  blockCfn;
   }
   /**
      <P>Create a block entity that contains specific text in the start and end lines--this also makes replacements on each line.</P>

      @return
<BLOCKQUOTE><PRE>{@link #lineRangeWithReplace(String, KeepStartLine, KeepMidLines, KeepEndLine, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, ValueAlterer, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRangeWithReplace}(name_ifNonNull,
   {@link KeepStartLine}.{@link KeepStartLine#getForKeepMatched(KeepMatched, String) getForKeepMatched}(keep_all, ...),
   {@link KeepMidLines}.{@link KeepMidLines#getForKeepMatched(KeepMatched, String) getForKeepMatched}(keep_all, ...),
   {@link KeepEndLine}.{@link KeepEndLine#getForKeepMatched(KeepMatched, String) getForKeepMatched}(keep_all, ...),
   start_ptrn, start_rplcWith, startRplcWhat_notMatchNums,
         null, dbgStart_ifNonNull,
   midAlterer_ifNonNull,
   endPtrn_ifNonNull, end_rplcWith, endRplcWhat_notMatchNums,
      null, dbgEnd_ifNonNull,
   dbgLineNums_ifNonNull)</PRE></BLOCKQUOTE>
      @see  #lineRangeWithReplace(String, KeepStartLine, KeepMidLines, KeepEndLine, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, ValueAlterer, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRangeWithReplace(String, KeepStartLine, ...)
    **/
   public static final BlockEntity lineRangeWithReplace(String name_ifNonNull, KeepMatched keep_all, Pattern start_ptrn, String start_rplcWith, ReplacedInEachInput startRplcWhat_notMatchNums, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, ValueAlterer<String,String> midAlterer_ifNonNull, Pattern endPtrn_ifNonNull, String end_rplcWith, ReplacedInEachInput endRplcWhat_notMatchNums, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRangeWithReplace(name_ifNonNull,
         KeepStartLine.getForKeepMatched(keep_all, "keep_all"),
         KeepMidLines.getForKeepMatched(keep_all, null),
         KeepEndLine.getForKeepMatched(keep_all, null),
         start_ptrn, start_rplcWith, startRplcWhat_notMatchNums,
            startFilter_ifNonNull, dbgStart_ifNonNull,
         midAlterer_ifNonNull,
         endPtrn_ifNonNull, end_rplcWith, endRplcWhat_notMatchNums,
            endFilter_ifNonNull, dbgEnd_ifNonNull,
         filter_ifNonNull, dbgLineNums_ifNonNull);
   }
   /**
      <P>Create a block entity that contains specific text in the start and end lines--this also makes replacements on each line.</P>

      @return
<BLOCKQUOTE><PRE>{@link #lineRange_Cfg_startEndFilterDebug(String, Pattern, ValidResultFilter, Appendable, Pattern, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRange_Cfg_startEndFilterDebug}(name_ifNonNull,
   start_ptrn, start_rplcWith, startRplcWhat_notMatchNums,
      startFilter_ifNonNull, dbgStart_ifNonNull,
   midAlterer_ifNonNull,
   endPtrn_ifNonNull, end_rplcWith, endRplcWhat_notMatchNums,
      endFilter_ifNonNull, dbgEnd_ifNonNull,
   dbgLineNums_ifNonNull).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(keep_start.{@link KeepStartLine#isYes() isYes}(), keep_mids.{@link KeepMidLines#isYes() isYes}(), keep_end.{@link KeepEndLine#isYes() isYes}()).
   build()</PRE></BLOCKQUOTE>
      @see  #lineRangeWithReplace(String, KeepMatched, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, ValueAlterer, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable, RawOnOffEntityFilter, Appendable) lineRangeWithReplace(String, KeepMatched, ...)
    **/
   public static final BlockEntity lineRangeWithReplace(String name_ifNonNull, KeepStartLine keep_start, KeepMidLines keep_mids, KeepEndLine keep_end, Pattern start_ptrn, String start_rplcWith, ReplacedInEachInput startRplcWhat_notMatchNums, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, ValueAlterer<String,String> midAlterer_ifNonNull, Pattern endPtrn_ifNonNull, String end_rplcWith, ReplacedInEachInput endRplcWhat_notMatchNums, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  lineRangeWithReplace_Cfg_startEndFilterDebug(name_ifNonNull,
               start_ptrn, start_rplcWith, startRplcWhat_notMatchNums,
                  startFilter_ifNonNull, dbgStart_ifNonNull,
               midAlterer_ifNonNull,
               endPtrn_ifNonNull, end_rplcWith, endRplcWhat_notMatchNums,
                  endFilter_ifNonNull, dbgEnd_ifNonNull,
               filter_ifNonNull, dbgLineNums_ifNonNull).
            keepStartMidEnd(keep_start.isYes(), keep_mids.isYes(), keep_end.isYes()).
            build();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(keep_start, "keep_start", null);
         CrashIfObject.nnull(keep_mids, "keep_mids", null);
         throw  CrashIfObject.nullOrReturnCause(keep_end, "keep_end", null, rx);
      }
   }
   /**
      <P>Create a <I>partially configured</I> block entity that may be used as a {@linkplain com.github.xbn.linefilter.FilteredIterator#getRootBlock() root block}, to which {@linkplain com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(TextChildEntity...) children} may be added. This keeps all lines unless overridden by a child entity.</P>

      @return
<BLOCKQUOTE><PRE>new {@link com.github.xbn.linefilter.entity.z.BlockEntity_Cfg#BlockEntity_Cfg(String) BlockEntity_Cfg}(name_ifNonNull).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#keepStartMidEnd(boolean, boolean, boolean) keepStartMidEnd}(
      (keep_start.{@link KeepStartLine#isYes() isYes}(), keep_mids.{@link KeepMidLines#isYes() isYes}(), keep_end.{@link KeepEndLine#isYes() isYes}()))</PRE></BLOCKQUOTE>
      @see  #keepAllUnchanged(String, RawOnOffEntityFilter, Appendable)
      @see  com.github.xbn.linefilter.FilteredLineIterator#FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) FilteredLineIterator#FilteredLineIterator(..., RawChildEntity[])
    **/
   public static final BlockEntity_CfgForNeeder<?,?> returnKeptUnchanged_Cfg_keepFilterDebug(String name_rootIfNull, KeepStartLine keep_start, KeepMidLines keep_mids, KeepEndLine keep_end, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  new BlockEntity_Cfg(name_rootIfNull).
            keepStartMidEnd(keep_start.isYes(), keep_mids.isYes(), keep_end.isYes()).
            filter(filter_ifNonNull).
            debugLineNumbers(dbgLineNums_ifNonNull);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(keep_start, "keep_start", null);
         CrashIfObject.nnull(keep_mids, "keep_mids", null);
         throw  CrashIfObject.nullOrReturnCause(keep_end, "keep_end", null, rx);
      }
   }
   /**
      <P>Create a block entity that does nothing: All lines are kept and unaltered.</P>

      @return
<BLOCKQUOTE><PRE>{@link #returnKeptUnchanged_Cfg_keepFilterDebug(String, KeepStartLine, KeepMidLines, KeepEndLine, RawOnOffEntityFilter, Appendable) returnKeptUnchanged_Cfg_keepFilterDebug}(name_rootIfNull,
   {@link KeepStartLine}.{@link KeepStartLine#YES YES}, {@link KeepMidLines}.{@link KeepMidLines#YES YES}, {@link KeepEndLine}.{@link KeepEndLine#YES YES}).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#build() build}()</PRE></BLOCKQUOTE>
    **/
   public static final BlockEntity keepAllUnchanged(String name_rootIfNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  returnKeptUnchanged_Cfg_keepFilterDebug(name_rootIfNull,
         KeepStartLine.YES, KeepMidLines.YES, KeepEndLine.YES, filter_ifNonNull, dbgLineNums_ifNonNull).			build();
   }
   private NewBlockEntityFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
