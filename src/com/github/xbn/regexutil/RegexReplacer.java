/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   import  com.github.xbn.text.padchop.z.VzblPadChop_Cfg;
   import  com.github.xbn.analyze.validate.ValidatorComposer;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.io.Debuggable;
   import  com.github.xbn.io.IOUtil;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.io.SimpleDebuggable;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.regexutil.z.RegexReplacer_Fieldable;
   import  java.io.IOException;
   import  java.util.Objects;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>For regular expression replacements where each match can be individually manipulated. The idea for this is based on in  <CODE>e.util.{@link com.github.xbn.regexutil.Rewriter Rewriter}</CODE>, with the additions of distinguishing between &quot;<A HREF="#indirect">indirect</A>&quot; and &quot;<A HREF="#direct">direct</A>&quot; replacements, and the ability to choose exactly which matches should be replaced (see &quot;Which terms&quot; in the below list).</P>

   <a name="cfg"/><H3>Builder Configuration: {@link com.github.xbn.regexutil.z.RegexReplacer_Cfg RegexReplacer_Cfg}</H3>

   <P><UL>
      <LI><B>Search terms:</B><UL>
         <LI><B>Find what and direct replace-with:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(Pattern, Object) direct}(p,O)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(String, Object) direct}(s,O)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(String, int, Object) direct}(s,i,O)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#directLiteral(String, Object) directLiteral}(s,O)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#directReplacement(Object) directReplacement}(O)</CODE></LI>
         <LI><B>Find what:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(Pattern) pattern}(p)</CODE> ,<CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(String) findWhat}(s)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(String, int) findWhat}(s,i)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhatLiteral(String) findWhatLiteral}(s)</CODE></LI>
      </UL></LI>
      <LI><B>Which terms:</B><UL>
         <LI><B>Match numbers:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(ValueValidator) matchNumbers}(vv)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchRange(LengthInRange) matchRange}(lir)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchRange(int, int) matchRange}(i,i)</CODE></LI>
         <LI><B>Until:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until() until}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int) until}(i)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) until}(i,muxi)</CODE></LI>
         <LI><B>Other:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#all() all}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#first() first}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#lookingAt() lookingAt}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matches() matches}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#replaceWhatNotMatchNums(ReplacedInEachInput) replaceWhatNotMatchNums}(rw)</CODE></LI>
      </UL></LI>
      <LI><B>Other:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#chainID(boolean, Object) chainID}(b,o)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#debugTo(Appendable) debugTo}(apbl)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#reset() reset}()</CODE></LI>
   </UL></P>

   <H3>Example: Direct replacement: Regex</H3>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerDirectXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   <H3>Example: Direct replacement: Literal</H3>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerLiteralXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

</LI>
   </UL></P>

   <a name="indirect"/><H4><CODE>[<A HREF="#skip-navbar_top">top                                                                                              </A>]</CODE> &nbsp; <U>RegexReplacer: Definition: Indirect</U></H4>

   <P><I>Indirect replacements are made with {@link IndirectRegexReplacer}.</I></P>

   <P>The function at the heart of {@code RegexReplacer} is {@link #getIndirectReplacement() getIndirectReplacement}{@code ()}, and is normally overridden in an inner class. It is the equivalent of {@link Rewriter}'s {@link com.github.xbn.regexutil.Rewriter#replacement() replacement}{@code ()}</P>

   <P>The advantage of indirect replacements is that each capture-group can be manipulated (such as changed to upper-case in this example).</P>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl1of2:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   <P>Internally, for each match, indirect replacements are done in two steps:<OL>
      <LI>Everything up-to-but-not-including the next match is appended to the {@code StringBuffer}:
      <BR> &nbsp; &nbsp; {@code <I>[Matcher]</I>.appendReplacement(to_appendTo, &quot;&quot;)}
      <BR>The match is &quot;replaced&quot; with <I>nothing</I>--the empty-string.</LI>
      <LI>The indirect replacement is then appended to the {@code StringBuffer} with
      <BR> &nbsp; &nbsp; {@code to_appendTo.append(getIndirectReplacement())}</LI>
   </OL></P>

   <a name="direct"/><H4><CODE>[<A HREF="#skip-navbar_top">top</A>]</CODE> &nbsp; <U>RegexReplacer: Definition: Direct</U></H4>

   <P>When capture groups do not need to be manipulated, the {@code Matcher} can make the replacement itself--&quot;directly&quot;. Internally, this is equivalent to the above step one, changed to
   <BR> &nbsp; &nbsp; {@code <I>[Matcher]</I>.appendReplacement(to_appendTo, <I>[the-replacement-string]</I>)}.</P>


   <a name="whichmatches"/><H3><CODE>[<A HREF="#skip-navbar_top">top</A>]</CODE> &nbsp; Choosing which matches to replace</H3>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerSpcfcTermsXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   <P>Here is the example code from {@code Rewriter}, which runs against {@code RegexReplacer} after only changing function-names:</P>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerXmplsFromRewriter:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexReplacer extends SimpleDebuggable implements Debuggable, Copyable, PatternHaser, ToStringAppendable, RegexReplacer_Fieldable  {
//config: mutable
   private final SimplePatternHaser      sph           ;  //Composition for implementing
                                                         //   PatternHaser
   private Object                        oRWDrct       ;  //Direct replace-with string
//config: immutable
   private final ReplacedInEachInput                erw           ;  //What is replaced?
   private final ValueValidator<Integer> vvMatchNum    ;  //If replacing MATCH_NUMBERS
   private final int                     iMaxUntilLoops;  //If replacing UNTIL
   private final boolean                 bMaxUCrash    ;  //If replacing UNTIL
//state
   private Matcher                       m             ;  //Reusable matcher
   private ReplaceWithAppender           rwApndr       ;  //Internal delta
   private int                           iRplcs        ;  //The number of replacements made.
//internal
   private static final VzblPadChop VPC_DBG = new VzblPadChop_Cfg().
      cfgChop(true, 100).inMiddle().ddd().endCfg().
      trim().build();
   /**
      <P>To replace the match with itself: &quot;{@code $0}&quot;</P>
    **/
   public static final String RPLC_WITH_SELF_DLR0 = "$0";
   /**
      <P>The default number of maximum &quot;until&quot; loops: {@code 20}.</P>
    **/
   public static final int DEFAULT_MAX_UNTIL_LOOPS = 20;
//constructors...START
   /**
      <P>Create a new {@code RegexReplacer}, for either direct or indirect replacements.</P>

      @param  fieldable  May not be {@code null}, and must contain valid fields as documented by the <A HREF="#cfg">builder's setter functions</A>. If <CODE>fieldable.{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#getDirectReplacement() getDirectReplacement}()</CODE> is non-{@code null}, then this is an <A HREF="#direct">direct</A> replacement. If {@code null}, <A HREF="#indirect">indirect</A>.
      @see  #RegexReplacer(RegexReplacer) this(rr)
		@see  #RegexReplacer(RegexReplacer, String, String) this(rr,s,s)
		@see  #RegexReplacer(RegexReplacer, String, int, String) this(rr,s,i,s)
      @see  #RegexReplacer(RegexReplacer, Pattern, String) this(rr,p,s)
    **/
   public RegexReplacer(RegexReplacer_Fieldable fieldable)  {
      //Transfer RegexReplacer_CfgForNeeder fields to THIS
         try  {
            sph = (new SimplePatternHaser()).
               pattern(fieldable.getPattern(), "fieldable.getPattern()").
               matcherUsesFromReplacedInEachInputWhat(fieldable.getReplacedInEachInput());
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(fieldable, "fieldable", null, rx);
         }
         vvMatchNum = fieldable.getMatchNumValidator();
         iMaxUntilLoops = fieldable.getMaxUntilLoops();
         bMaxUCrash = fieldable.doCrashIfMaxUntilExceeded();
         erw = fieldable.getReplacedInEachInput();

      ValidatorComposer.ciForbiddenRuleType(vvMatchNum, RuleType.IMPOSSIBLE, "fieldable.getMatchNumValidator()", null);
      if(iMaxUntilLoops < 1)  {
         throw  new IllegalArgumentException("fieldable.getMaxUntilLoops() (" + iMaxUntilLoops + ") is less than one.");
      }

      findWhat(fieldable.getPattern());
      replaceWith(fieldable.getDirectReplacement());

      setDebug(fieldable.getDebugApbl(), (fieldable.getDebugApbl() != null));

      iRplcs = 0;
   }
   /**
      <P>Create a new instance as a duplicate of another--with the same search-terms, and the same direct-or-indirect-ness.</P>

      @param  to_copy  May not be <CODE>null</CODE>.
      @see  <A HREF="#direct">Definition: direct replacement</A>
      @see  <A HREF="#indirect">Definition: indirect replacement</A>
      @see 	#RegexReplacer(RegexReplacer, Pattern, String) this(rr,p,s)
    **/
   public RegexReplacer(RegexReplacer to_copy)  {
      this(true, to_copy, null, null);
   }
   /**
      <P>Create a new instance as a duplicate of another, with new search terms, but the same direct-or-indirect-ness.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #RegexReplacer(RegexReplacer, Pattern, String) this}(to_copy, {@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#regex(String, String) regex}(findWhat_regex), new_directRplcWith)</CODE></P>

      @param  findWhat_regex  May not be <CODE>null</CODE>.
    **/
   public RegexReplacer(RegexReplacer to_copy, String findWhat_regex, String new_directRplcWith)  {
      this(to_copy, NewPatternFor.regex(findWhat_regex, "findWhat_regex"), new_directRplcWith);
   }
   /**
      <P>Create a new instance as a duplicate of another, with new search terms, but the same direct-or-indirect-ness.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #RegexReplacer(RegexReplacer, Pattern, String) this}(to_copy, {@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link NewPatternFor#regex(String, int, String) regex}(findWhat_regex, bit_flags), new_directRplcWith)</CODE></P>

      @param  findWhat_regex  May not be <CODE>null</CODE>.
    **/
   public RegexReplacer(RegexReplacer to_copy, String findWhat_regex, int bit_flags, String new_directRplcWith)  {
      this(to_copy, NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"), new_directRplcWith);
   }
   /**
      <P>Create a new instance as a duplicate of another, with new search terms, but the same direct-or-indirect-ness.</P>

      <P>To duplicate a <CODE>RegexReplacer</CODE> entirely (using the same search terms, and the same <A HREF="#direct">direct</A>-or-<A HREF="#indirect">indirect</A>-ness), use {@link #getObjectCopy() getObjectCopy}{@code ()}.</P>

      @param  to_copy  May not be <CODE>null</CODE>.
      @param  new_findWhat  May not be <CODE>null</CODE>. Get with {@link #getPattern() getPattern}{@code ()}.
      @param  new_directRplcWith  If {@code null}, then <CODE>to_copy.{@link #getDirectReplacement() getDirectReplacement}()</CODE> is used.
      @see  #RegexReplacer(RegexReplacer_Fieldable) this(rr_f)
      @see  #RegexReplacer(RegexReplacer) this(rr)
    **/
   public RegexReplacer(RegexReplacer to_copy, Pattern new_findWhat, String new_directRplcWith)  {
      this(false, to_copy, new_findWhat, new_directRplcWith);
   }
      private RegexReplacer(boolean null_ptrnOk, RegexReplacer to_copy, Pattern new_findWhat, String new_directRplcWith)  {
         super(to_copy);
         if(new_findWhat == null  &&  !null_ptrnOk)  {
            throw  new NullPointerException("new_findWhat");
         }

         erw = to_copy.getReplacedInEachInput();
         sph = (new SimplePatternHaser()).
               //pattern(...).           //<--Set in findWhat(p)
               matcherUsesFromReplacedInEachInputWhat(erw);

         findWhat(RegexUtil.getPatternCopyOrNewIfNNull(to_copy.getPattern(), new_findWhat, "to_copy.getPattern()"));

         replaceWith(((new_directRplcWith != null)
            ?  new_directRplcWith
                  //Strings are immutable. Copy unnecessary
            :  to_copy.getDirectReplacement()));

         @SuppressWarnings("unchecked")
         ValueValidator<Integer> vvi2 = (ValueValidator<Integer>)ObjectOrCrashIfNull.<ValueValidator>getCopy(to_copy.getMatchNumValidator(), ValueValidator.class, "to_copy.getMatchNumValidator()");
         vvMatchNum = vvi2;

         iMaxUntilLoops = to_copy.getMaxUntilLoops();
         bMaxUCrash     = to_copy.doCrashIfMaxUntilExceeded();
         iRplcs = 0;
      }
//constructors...END
   /**
      <P>Define the find-what search-term with a regular-expression string.</P>

      @param  regex  May not be <CODE>null</CODE>.
      @return  <CODE>{@link #findWhat(Pattern) findWhat}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link NewPatternFor#regex(String, String) regex}(regex))</CODE>
    **/
   public RegexReplacer findWhat(String regex)  {
      return  findWhat(NewPatternFor.regex(regex, "regex"));
   }
   /**
      <P>Define the find-what search-term with a regular-expression string.</P>

      @param  regex  May not be <CODE>null</CODE>.
      @return  <CODE>{@link #findWhat(Pattern) findWhat}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link NewPatternFor#regex(String, int, String) regex}(regex, bit_flags))</CODE>
    **/
   public RegexReplacer findWhat(String regex, int bit_flags)  {
      return  findWhat(NewPatternFor.regex(regex, bit_flags, "regex"));
   }

   /**
      <P>Define the find-what search-term with a pattern.</P>

      @param  pattern_toFind  May not be <CODE>null</CODE>. Get with {@link #getPattern() getPattern}{@code ()}.
      @see  #findWhat(String) findWhat(s)
      @see  #findWhat(String, int) findWhat(s,i)
      @see  #replaceWith(Object) replaceWith(O)
    **/
   public RegexReplacer findWhat(Pattern pattern_toFind)  {
      m = RegexUtil.newMatcherForPatternCINull(pattern_toFind, "", "pattern_toFind");
      sph.pattern(pattern_toFind);
      return  this;
   }
   /**
      <P>Declare a new replacement, which will be indirect.</P>

      @return  <CODE>{@link #replaceWith(Object) replaceWith}(null)</CODE>
      @see  <A HREF="#indirect">indirect replacement</A>
    **/
   public RegexReplacer declareIndirect()  {
      return  replaceWith(null);
   }
   /**
      <P>Declare a new direct replacement string.</P>

      @param  direct_rplcWithOrNull  If {@code null}, this is an <A HREF="#indirect">indirect</A> replacement. If non-{@code null}, <A HREF="#direct">direct</A> Get with {@link #getDirectReplacement() getDirectReplacement}{@code ()}.
      @see  #declareIndirect()
      @see  #findWhat(Pattern) findWhat(p)
    **/
   public RegexReplacer replaceWith(Object direct_rplcWithOrNull)  {
      if(direct_rplcWithOrNull == null)  {
         oRWDrct = "";
         rwApndr = (new RWAIndirect());
      }  else  {
         oRWDrct = direct_rplcWithOrNull;
         rwApndr = (new RWADirect());
      }
      return  this;
   }

   /**
      <P>The find what pattern. This is used only for duplicating this {@code RegexReplacer}, and for inclusion in the {@link #toString() toString}{@code ()}.</P>

      @see  #findWhat(Pattern)
    **/
   //Composition implementation: null...START
      public Pattern getPattern()  {
         return  sph.getPattern();
      }
      public int getMatchedIndex()  {
         return  sph.getMatchedIndex();
      }
      public int getMatchCount()  {
         return  sph.getMatchCount();
      }
      public boolean wasJustMatched()  {
         return  sph.wasJustMatched();
      }
      /**
         <P>The {@code MatcherUses} equivalent, derived from {@code getReplacedInEachInput()}.</P>

         @return  {@code true}  The string is matched as a whole.
         @see  #getReplacedInEachInput()
       **/
      public MatcherUses getMatcherUses()  {
         return  sph.getMatcherUses();
      }
   //Composition implementation: null...END
   /**
      <P>Which matches should be replaced?.</P>

      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#first() RegexReplacer_Cfg#first()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#lookingAt() RegexReplacer_Cfg#lookingAt()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matches() RegexReplacer_Cfg#matches()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(ValueValidator) RegexReplacer_Cfg#matchNumbers(vv)
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#all() RegexReplacer_Cfg#all()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) RegexReplacer_Cfg#until(i,muxi)
      @see  #getMatcherUses()
    **/
   public ReplacedInEachInput getReplacedInEachInput()  {
      return  erw;
   }
   /**
      <P>Determines the specific matches to be replaced, when {@code getReplacedInEachInput().isMatchNumbers()} is {@code true}. The matches-to-replaced is based on their <I>numeric location</I> in the search string.</P>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerValidTermXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

      @return  An int-validator, where a <!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/validate/ValueValidator.html#isValid(O)">valid</A> int indicates the match should be replaced.
      @see  #getReplacedInEachInput()
      @see  ReplacedInEachInput#isMatchNumbers()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(ValueValidator) xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(vv)
    **/
   public ValueValidator<Integer> getMatchNumValidator()  {
      return  vvMatchNum;
   }
   /**
      <P>The maximum number of loops to attempt for &quot;until&quot; replacements. When this maximum is exceeded, the action taken is determined by {@link #doCrashIfMaxUntilExceeded() doCrashIfMaxUntilExceeded}{@code ()}.</P>

      @return  An int one or greater.
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(i,muxi)
    **/
   public int getMaxUntilLoops()  {
      return  iMaxUntilLoops;
   }
   /**
      <P>When the maximum number of &quot;until&quot; replacements is exceeded, should an exception be thrown?.</P>

      @return  <UL>
         <LI>{@code true}:  An {@code IllegalStateException} is thrown</LI>
         <LI>{@code false}: Execution stops.</LI>
      </UL>
      @see  #getMaxUntilLoops()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(i,muxi)
    **/
   public boolean doCrashIfMaxUntilExceeded()  {
      return  bMaxUCrash;
   }
   /**
      <P>Get a capture group in the current match--intended for use only by {@code getIndirectReplacement()}.</P>

      @param  group_num  Must be a valid given {@link #getGroupCount() getGroupCount}{@code ()}.
      @return  <CODE>[getPattern().matcher(...)].{@link java.util.regex.Matcher#group(int) group}(group_num)</CODE>
      @see  #getIndirectReplacement()
    **/
   public String getGroup(int group_num)  {
      try  {
         return  m.group(group_num);
      }  catch(RuntimeException rx)  {
         RegexUtil.crashIfBadGroupNumberForCount(group_num, m, "group_num", "[getPattern().matcher(s)]");
         throw  rx;
      }
   }
   /**
      <P>The number of groups in the current match.--intended for use only by {@code getIndirectReplacement()}.</P>

      @return  <CODE><I>[{@link #getPattern() getPattern}().{@link java.util.regex.Pattern#matcher(CharSequence) matcher}(...)]</I>.{@link java.util.regex.Matcher#groupCount groupCount}()</CODE></I>
      @see  #getGroup(int) getGroup(i)
      @see  #getIndirectReplacement()
    **/
   public int getGroupCount()  {
      return  m.groupCount();
   }
   /**
      <P>The direct replacement string. See <A HREF="#direct">direct</A>. This is the string provided directly to <CODE><I>{@link java.util.regex.Matcher Matcher}</I>.{@link java.util.regex.Matcher#appendReplacement(StringBuffer, String) appendReplacement}(sb,s)</CODE>, as its second parameter.</P>

      @return  <UL>
         <LI>A non-{@code null}, non-empty string: For <A HREF="#direct">direct</A> replacements.</LI>
         <LI>&quot;&quot;: For <A HREF="#indirect">indirect</A> replacements.</LI>
      </UL>
      @see  #getIndirectReplacement()
    **/
   public Object getDirectReplacement()  {
      return  oRWDrct;
   }
   /**
      <P>The indirect replacement for a single match.</P>

      <P>In contrast with <A HREF="#direct">direct</A> replacements, &quot;<A HREF="#indirect">indirect</A>&quot; replacements allow for each capture group to be individually manipulated:</P>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl2of2:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

      @exception  IllegalStateException  This function must be overridden for indirect replacements.
      @see  #getDirectReplacement()
      @see  #getGroup(int) getGroup(i)
      @see  #getGroupCount()
    **/
   public String getIndirectReplacement()  {
      throw  new IllegalStateException("getIndirectReplacement()");
   }
   /**
      <P>How many replacements were made during the most-recent call to {@link #appendReplacedX(Appendable, Object) appendReplacedX}{@code (apbl,o)}</P>
    **/
   public int getReplacementCount()  {
      return  iRplcs;
   }
   /**
      <P>Get the entire replacement result, as configured.</P>

      @param  text_toRplc  May not be {@code null}.
      @return  {@link #appendReplaced(Appendable, Object) appendReplaced}{@code (new StringBuffer(text_toRplc.length()), text_toRplc).toString()}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public String getReplaced(Object text_toRplc)  {
      String sOrig = null;
      try  {
         sOrig = text_toRplc.toString();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(text_toRplc, "text_toRplc", null, rx);
      }

      if(isDebugOn())  {
         getDebugAptr().appentln("<RR> getReplaced(O): text_toRplc=\"" + VPC_DBG.get(sOrig) + "\", this=" + this);
      }

      m.reset(sOrig);
      int iLen = sOrig.length();

      sph.declareNotMatched();

      if(!m.find())  {
         if(isDebugOn()) { getDebugAptr().appentln("<RR> Not found"); }

         //Don't bother creating the StringBuffer, appending text_toRplc to it,
         //and then returning its toString().
         return  sOrig;

      }  else  {
         //Do bother.
         try  {
            return  appendReplaced1stFoundX((new StringBuffer(iLen)), sOrig).toString();
         }  catch(IOException iox)  {
            throw  new RTIOException("getReplaced", iox);
         }
      }
   }
   /**
      <P>Append the replacement as configured, with a new-line at the end, and with runtime errors only. Intended for debugging and testing.</P>

      @return  <CODE>{@link #appendReplacedlns(int, Appendable, Object) appendReplacedln}(1, to_appendTo, text_toRplc)</CODE>
    **/
   public Appendable appendReplacedln(Appendable to_appendTo, Object text_toRplc)  {
      return  appendReplacedlns(1, to_appendTo, text_toRplc);
   }
   /**
      <P>Append the replacement as configured, with a new-line at the end, and with runtime errors only. Intended for debugging and testing.</P>

      @return  <CODE>{@link #appendReplacedX(Appendable, Object) appendReplacedX}(to_appendTo, text_toRplc)</CODE>
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
      @see  #appendReplacedln(Appendable, Object) appendReplacedln(apbl,O)
    **/
   public Appendable appendReplacedlns(int newLine_count, Appendable to_appendTo, Object text_toRplc)  {
      try  {
         appendReplacedX(to_appendTo, text_toRplc);
         return  IOUtil.appendNewLinesX(newLine_count, to_appendTo);
      }  catch(IOException iox)  {
         throw  new RTIOException("appendReplacedln", iox);
      }
   }
   /**
      <P>Append the replacement as configured, with runtime errors only.</P>

      @return  <CODE>{@link #appendReplacedX(Appendable, Object) appendReplacedX}(to_appendTo, text_toRplc)</CODE>
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public Appendable appendReplaced(Appendable to_appendTo, Object text_toRplc)  {
      try  {
         return  appendReplacedX(to_appendTo, text_toRplc);
      }  catch(IOException iox)  {
         throw  new RTIOException("appendReplaced", iox);
      }
   }
   /**
      <P>Append the replacement as configured.</P>

      @param  to_appendTo  May not be <CODE>null</CODE>
      @return  <CODE>to_appendTo.{@link java.lang.Appendable#append(CharSequence) append}({@link #getReplaced(Object) getReplaced}(text_toRplc))</CODE> &nbsp; &nbsp; <I>(<CODE>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#appendReplacement(StringBuffer, String) appendReplacement}(sb,s)</CODE> requires a <CODE>{@link java.lang.StringBuffer StringBuffer}</CODE>)</I>
      @see  #getReplacementCount()
    **/
   public Appendable appendReplacedX(Appendable to_appendTo, Object text_toRplc) throws IOException  {
      try  {
         return  to_appendTo.append(getReplaced(text_toRplc));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
   }
   /**
      <P>Get the replacement result, as configured.</P>

      @param  to_appendTo  May not be {@code null}. <I>{@link java.util.regex.Matcher Matcher} requires a {@code StringBuffer}. This should ideally be an {@code Appendable}.</I>
      @param  text_toRplc  May not be {@code null}.
      @return  <CODE>to_appendTo</CODE>
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
      @see  #getReplaced(Object) getReplaced(cs)
      @see  #appendReplaced(Appendable, Object) getReplaced(apbl,O)
      @see  #appendReplacedX(Appendable, Object) appendReplacedX(apbl,O)
      @see  #appendReplacedln(Appendable, Object) appendReplacedln(apbl,O)
      @see  #appendReplacedlns(int, Appendable, Object) appendReplacedlns(i,apbl,O)
    **/
   public StringBuffer appendReplaced(StringBuffer to_appendTo, Object text_toRplc)  {
      String sOrig = null;
      try  {
         sOrig = text_toRplc.toString();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(text_toRplc, "text_toRplc", null, rx);
      }

      if(isDebugOn())  {
         getDebugAptr().appentln("<RR> appendReplaced(sd,O): text_toRplc=\"" + VPC_DBG.get(sOrig) + "\", this=" + this);
      }

      m.reset(sOrig);
      sph.declareNotMatched();

      //Finding the first instance here, before calling
      //appendReplaced1stFound(q,sb,ow) is primarily beneficial for
      //getReplaced(q)
      if(!m.find())  {
         if(isDebugOn()) { getDebugAptr().appentln("<RR> Not found"); }

         return  to_appendTo.append(sOrig);

      }  else  {
         try  {
            return  appendReplaced1stFoundX(to_appendTo, sOrig);
         }  catch(IOException iox)  {
            throw  new RTIOException("appendReplaced", iox);
         }
      }
   }
      private void debugFindWhat()  {
         if(isDebugOn())  {
            getDebugAptr().appentln("<RR> - Found at index " + m.start() + ": \"" + VPC_DBG.get(m.group()) + "\"");
         }
      }
      private StringBuffer appendReplaced1stFoundX(StringBuffer to_appendTo, String text_toRplc) throws IOException  {
         if(getReplacedInEachInput().isMatches())  {
            if(m.start() == 0  &&  m.end() == text_toRplc.length())  {
       		   sph.matchedIndex(0);
               rwApndr.appendDirect(m, to_appendTo, getDirectReplacement(), getDebugAptr(), isDebugOn());
               //No tail. Matches encompasses the entire string.
               iRplcs++;
            }  else  {
               to_appendTo.append(text_toRplc);
            }
            return  to_appendTo;
         }

         if(getReplacedInEachInput().isLookingAt())  {
            if(m.start() == 0 )  {
       		   sph.matchedIndex(0);
               rwApndr.appendDirect(m, to_appendTo, getDirectReplacement(), getDebugAptr(), isDebugOn());
               m.appendTail(to_appendTo);
               iRplcs++;
            }  else  {
               to_appendTo.append(text_toRplc);
            }
            return  to_appendTo;
         }

         if(getReplacedInEachInput().isFirst())  {
       		sph.matchedIndex(m.start());
            debugFindWhat();
            //Append everything up-to-but-not-including the next
            //match. Replace it with NOTHING.
            rwApndr.appendDirect(m, to_appendTo, getDirectReplacement(), getDebugAptr(), isDebugOn());

            //Now, getIndirectReplacement() populates that spot.
            rwApndr.appendIndirect(to_appendTo, this, getDebugAptr(), isDebugOn());
            m.appendTail(to_appendTo);

            iRplcs++;

            return  to_appendTo;
         }

         if(getReplacedInEachInput().isAll())  {
            do  {
          		sph.matchedIndex(m.start());
               debugFindWhat();
               //Append everything up-to-but-not-including the next
               //match. Replace it with NOTHING.
               rwApndr.appendDirect(m, to_appendTo, getDirectReplacement(), getDebugAptr(), isDebugOn());

               //Now, getIndirectReplacement() populates that spot.
               rwApndr.appendIndirect(to_appendTo, this, getDebugAptr(), isDebugOn());
               iRplcs++;
            }  while(m.find());
            m.appendTail(to_appendTo);

            return  to_appendTo;
         }

         if(getReplacedInEachInput().isMatchNumbers())  {
            int iSubsq = 0;
            do  {
               iSubsq++;
               if(getMatchNumValidator().isValid(iSubsq))  {
          		   sph.matchedIndex(m.start());
                  debugFindWhat();
                  //Do replace this sub-sequence.

                  //Append everything up-to-but-not-including the next
                  //match. Replace it with NOTHING.
                  rwApndr.appendDirect(m, to_appendTo, getDirectReplacement(), getDebugAptr(), isDebugOn());

                  //Now, getIndirectReplacement() populates that spot.
                  rwApndr.appendIndirect(to_appendTo, this, getDebugAptr(), isDebugOn());
                  iRplcs++;

               }  else  {
                  //Don't replace this sub-sequence. Repopulate it with itself.
                  m.appendReplacement(to_appendTo, m.group());
               }
               getMatchNumValidator().resetState();
            }  while(m.find());
            m.appendTail(to_appendTo);

            return  to_appendTo;
         }

         //getReplacedInEachInput().isUntil() is true

         StringBuffer sbTemp = new StringBuffer(text_toRplc.length());
         int iUntilLoops = 0;
         boolean bFound = false;
         while(true)  {
            bFound = false;
            iUntilLoops++;

            do  {
       		   sph.matchedIndex(m.start());
               debugFindWhat();
               bFound = true;

               //Append everything up-to-but-not-including the next
               //match. Replace it with NOTHING.
               rwApndr.appendDirect(m, sbTemp, getDirectReplacement(), getDebugAptr(), isDebugOn());

               //Now, getIndirectReplacement() populates that spot.
               rwApndr.appendIndirect(sbTemp, this, getDebugAptr(), isDebugOn());
               iRplcs++;
            }  while(m.find());
            m.appendTail(sbTemp);

            if(iUntilLoops >= getMaxUntilLoops())  {
               //The NEXT "while(m.find())" loop would exceed the maximum.

               if(doCrashIfMaxUntilExceeded())  {
                  throw  new IllegalStateException("Maximum number of 'until' loops reached. getMaxUntilLoops()=" + getMaxUntilLoops() + ". Original text_toRplc=\"" + text_toRplc + "\". Current replacement: [" + sbTemp + "]. -- this=[" + this + "]");
               }

               //ELSE: Stop
               to_appendTo.append(sbTemp);
               break;
            }

            if(!bFound)  {
               to_appendTo.append(sbTemp);
               break;
            }

            m.reset(sbTemp.toString());

            if(!m.find())  {
               to_appendTo.append(sbTemp);
               break;
            }

            sbTemp.setLength(0);
         }
         return  to_appendTo;
      }
   public String toString()  {
      return  appendToString((new StringBuilder())).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("replaced " + getMatchCount() + " times, find-what=\"").append(getPattern()).append("\" ");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      if(getPattern().flags() != 0)  {
         to_appendTo.append("(flags=").append(getPattern().flags()).append(") ");
      }

      to_appendTo.append("replace-with=");

      if(getDirectReplacement() != null)  {
         to_appendTo.append("\"").append(VPC_DBG.get(getDirectReplacement())).append("\"");
      }  else  {
         to_appendTo.append("[indirect replacement]");
      }

      to_appendTo.append(", ReplacedInEachInput.").append(getReplacedInEachInput());
      if(getReplacedInEachInput().isMatchNumbers())  {
         to_appendTo.append(" getMatchNumValidator()=[" + getMatchNumValidator() + "]");
      }  else if(getReplacedInEachInput().isUntil())  {
         to_appendTo.append(" (").append(doCrashIfMaxUntilExceeded() ? "crash" : "stop").
            append(" at ").append(getMaxUntilLoops()).append(")");
      }

      return  to_appendTo;
   }
   /**
      <P>Get a duplicate of this {@code RegexReplacer}.</P>

      @return  <CODE>(new {@link #RegexReplacer(RegexReplacer) RegexReplacer}(this))</CODE>
    **/
   public RegexReplacer getObjectCopy()  {
      return  (new RegexReplacer(this));
   }
}
abstract class ReplaceWithAppender  {
   public final void appendDirect(Matcher matcher, StringBuffer to_appendTo, Object rplc_withStr, TextAppenter dbg_apntr, boolean do_debug)  {
      try  {
         //to_appendTo.length();  //Needed to trigger an npx???? Why else would it be needed?
         matcher.appendReplacement(to_appendTo, rplc_withStr.toString());
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(rplc_withStr, "rplc_withStr");
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
   }
   public void appendIndirect(StringBuffer ignored1, RegexReplacer ignored3, TextAppenter ignored4, boolean ignored5)  {
      //Do nothing!
   }
}
class RWADirect extends ReplaceWithAppender  {
}
class RWAIndirect extends RWADirect  {
   public void appendIndirect(StringBuffer to_appendTo, RegexReplacer rr_containingIndirect, TextAppenter dbg_apntr, boolean do_debug)  {
      String sir = rr_containingIndirect.getIndirectReplacement();
      to_appendTo.append(sir);
   }
}
