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
/**
   <p>For regular expression replacements where each match can be individually manipulated. The idea for this is based on in  <code>e.util.{@link com.github.xbn.regexutil.Rewriter Rewriter}</code>, with the additions of distinguishing between &quot;<a href="#indirect">indirect</a>&quot; and &quot;<a href="#direct">direct</a>&quot; replacements, and the ability to choose exactly which matches should be replaced (see &quot;Which terms&quot; in the below list).</p>

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.regexutil.z.RegexReplacer_Cfg RegexReplacer_Cfg}</h3>

   <p><ul>
      <li><b>Search terms:</b><ul>
         <li><b>Find what and direct replace-with:</b> <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(Pattern, Object) direct}(p,O)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(String, Object) direct}(s,O)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(String, int, Object) direct}(s,i,O)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#directLiteral(String, Object) directLiteral}(s,O)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#directReplacement(Object) directReplacement}(O)</code></li>
         <li><b>Find what:</b> <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(Pattern) pattern}(p)</code> ,<code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(String) findWhat}(s)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(String, int) findWhat}(s,i)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhatLiteral(String) findWhatLiteral}(s)</code></li>
      </ul></li>
      <li><b>Which terms:</b><ul>
         <li><b>Match numbers:</b> <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(ValueValidator) matchNumbers}(vv)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchRange(LengthInRange) matchRange}(lir)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchRange(int, int) matchRange}(i,i)</code></li>
         <li><b>Until:</b> <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until() until}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int) until}(i)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) until}(i,muxi)</code></li>
         <li><b>Other:</b> <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#all() all}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#first() first}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#lookingAt() lookingAt}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matches() matches}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#replaceWhatNotMatchNums(ReplacedInEachInput) replaceWhatNotMatchNums}(rw)</code></li>
      </ul></li>
      <li><b>Other:</b> <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#chainID(boolean, Object) chainID}(b,o)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#debugTo(Appendable) debugTo}(apbl)</code>, <code>{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#reset() reset}()</code></li>
   </ul></p>

   <h3>Example: Direct replacement: Regex</h3>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerDirectXmpl%eliminateCommentBlocksAndPackageDecl()}

   <h3>Example: Direct replacement: Literal</h3>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerLiteralXmpl%eliminateCommentBlocksAndPackageDecl()}

</li>
   </ul></p>

   <A NAME="indirect"></a><h4><code>[<a href="#skip-navbar_top">top                                                                                              </a>]</code> &nbsp; <u>RegexReplacer: Definition: Indirect</u></h4>

   <p><i>Indirect replacements are made with {@link IndirectRegexReplacer}.</i></p>

   <p>The function at the heart of {@code RegexReplacer} is {@link #getIndirectReplacement() getIndirectReplacement}{@code ()}, and is normally overridden in an inner class. It is the equivalent of {@link Rewriter}'s {@link com.github.xbn.regexutil.Rewriter#replacement() replacement}{@code ()}</p>

   <p>The advantage of indirect replacements is that each capture-group can be manipulated (such as changed to upper-case in this example).</p>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl1of2%eliminateCommentBlocksAndPackageDecl()}

   <p>Internally, for each match, indirect replacements are done in two steps:<ol>
      <li>Everything up-to-but-not-including the next match is appended to the {@code StringBuffer}:
      <br/> &nbsp; &nbsp; {@code <i>[Matcher]</i>.appendReplacement(to_appendTo, &quot;&quot;)}
      <br/>The match is &quot;replaced&quot; with <i>nothing</i>--the empty-string.</li>
      <li>The indirect replacement is then appended to the {@code StringBuffer} with
      <br/> &nbsp; &nbsp; {@code to_appendTo.append(getIndirectReplacement())}</li>
   </ol></p>

   <A NAME="direct"></a><h4><code>[<a href="#skip-navbar_top">top</a>]</code> &nbsp; <u>RegexReplacer: Definition: Direct</u></h4>

   <p>When capture groups do not need to be manipulated, the {@code Matcher} can make the replacement itself--&quot;directly&quot;. Internally, this is equivalent to the above step one, changed to
   <br/> &nbsp; &nbsp; {@code <i>[Matcher]</i>.appendReplacement(to_appendTo, <i>[the-replacement-string]</i>)}.</p>


   <A NAME="whichmatches"></a><h3><code>[<a href="#skip-navbar_top">top</a>]</code> &nbsp; Choosing which matches to replace</h3>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerSpcfcTermsXmpl%eliminateCommentBlocksAndPackageDecl()}

   <p>Here is the example code from {@code Rewriter}, which runs against {@code RegexReplacer} after only changing function-names:</p>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerXmplsFromRewriter%eliminateCommentBlocksAndPackageDecl()}

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
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
      <p>To replace the match with itself: &quot;{@code $0}&quot;</p>
    **/
   public static final String RPLC_WITH_SELF_DLR0 = "$0";
   /**
      <p>The default number of maximum &quot;until&quot; loops: {@code 20}.</p>
    **/
   public static final int DEFAULT_MAX_UNTIL_LOOPS = 20;
//constructors...START
   /**
      <p>Create a new {@code RegexReplacer}, for either direct or indirect replacements.</p>

      @param  fieldable  May not be {@code null}, and must contain valid fields as documented by the <a href="#cfg">builder's setter functions</a>. If <code>fieldable.{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#getDirectReplacement() getDirectReplacement}()</code> is non-{@code null}, then this is an <a href="#direct">direct</a> replacement. If {@code null}, <a href="#indirect">indirect</a>.
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
      <p>Create a new instance as a duplicate of another--with the same search-terms, and the same direct-or-indirect-ness.</p>

      @param  to_copy  May not be <code>null</code>.
      @see  <a href="#direct">Definition: direct replacement</a>
      @see  <a href="#indirect">Definition: indirect replacement</a>
      @see 	#RegexReplacer(RegexReplacer, Pattern, String) this(rr,p,s)
    **/
   public RegexReplacer(RegexReplacer to_copy)  {
      this(true, to_copy, null, null);
   }
   /**
      <p>Create a new instance as a duplicate of another, with new search terms, but the same direct-or-indirect-ness.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #RegexReplacer(RegexReplacer, Pattern, String) this}(to_copy, {@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#regex(String, String) regex}(findWhat_regex), new_directRplcWith)</code></p>

      @param  findWhat_regex  May not be <code>null</code>.
    **/
   public RegexReplacer(RegexReplacer to_copy, String findWhat_regex, String new_directRplcWith)  {
      this(to_copy, NewPatternFor.regex(findWhat_regex, "findWhat_regex"), new_directRplcWith);
   }
   /**
      <p>Create a new instance as a duplicate of another, with new search terms, but the same direct-or-indirect-ness.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #RegexReplacer(RegexReplacer, Pattern, String) this}(to_copy, {@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link NewPatternFor#regex(String, int, String) regex}(findWhat_regex, bit_flags), new_directRplcWith)</code></p>

      @param  findWhat_regex  May not be <code>null</code>.
    **/
   public RegexReplacer(RegexReplacer to_copy, String findWhat_regex, int bit_flags, String new_directRplcWith)  {
      this(to_copy, NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"), new_directRplcWith);
   }
   /**
      <p>Create a new instance as a duplicate of another, with new search terms, but the same direct-or-indirect-ness.</p>

      <p>To duplicate a <code>RegexReplacer</code> entirely (using the same search terms, and the same <a href="#direct">direct</a>-or-<a href="#indirect">indirect</a>-ness), use {@link #getObjectCopy() getObjectCopy}{@code ()}.</p>

      @param  to_copy  May not be <code>null</code>.
      @param  new_findWhat  May not be <code>null</code>. Get with {@link #getPattern() getPattern}{@code ()}.
      @param  new_directRplcWith  If {@code null}, then <code>to_copy.{@link #getDirectReplacement() getDirectReplacement}()</code> is used.
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
      <p>Define the find-what search-term with a regular-expression string.</p>

      @param  regex  May not be <code>null</code>.
      @return  <code>{@link #findWhat(Pattern) findWhat}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link NewPatternFor#regex(String, String) regex}(regex))</code>
    **/
   public RegexReplacer findWhat(String regex)  {
      return  findWhat(NewPatternFor.regex(regex, "regex"));
   }
   /**
      <p>Define the find-what search-term with a regular-expression string.</p>

      @param  regex  May not be <code>null</code>.
      @return  <code>{@link #findWhat(Pattern) findWhat}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link NewPatternFor#regex(String, int, String) regex}(regex, bit_flags))</code>
    **/
   public RegexReplacer findWhat(String regex, int bit_flags)  {
      return  findWhat(NewPatternFor.regex(regex, bit_flags, "regex"));
   }

   /**
      <p>Define the find-what search-term with a pattern.</p>

      @param  pattern_toFind  May not be <code>null</code>. Get with {@link #getPattern() getPattern}{@code ()}.
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
      <p>Declare a new replacement, which will be indirect.</p>

      @return  <code>{@link #replaceWith(Object) replaceWith}(null)</code>
      @see  <a href="#indirect">indirect replacement</a>
    **/
   public RegexReplacer declareIndirect()  {
      return  replaceWith(null);
   }
   /**
      <p>Declare a new direct replacement string.</p>

      @param  direct_rplcWithOrNull  If {@code null}, this is an <a href="#indirect">indirect</a> replacement. If non-{@code null}, <a href="#direct">direct</a> Get with {@link #getDirectReplacement() getDirectReplacement}{@code ()}.
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
      <p>The find what pattern. This is used only for duplicating this {@code RegexReplacer}, and for inclusion in the {@link #toString() toString}{@code ()}.</p>

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
         <p>The {@code MatcherUses} equivalent, derived from {@code getReplacedInEachInput()}.</p>

         @return  {@code true}  The string is matched as a whole.
         @see  #getReplacedInEachInput()
       **/
      public MatcherUses getMatcherUses()  {
         return  sph.getMatcherUses();
      }
   //Composition implementation: null...END
   /**
      <p>Which matches should be replaced?.</p>

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
      <p>Determines the specific matches to be replaced, when {@code getReplacedInEachInput().isMatchNumbers()} is {@code true}. The matches-to-replaced is based on their <i>numeric location</i> in the search string.</p>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerValidTermXmpl%eliminateCommentBlocksAndPackageDecl()}

      @return  An int-validator, where a <!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/analyze/validate/ValueValidator.html#isValid(O)">valid</a> int indicates the match should be replaced.
      @see  #getReplacedInEachInput()
      @see  ReplacedInEachInput#isMatchNumbers()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(ValueValidator) xbn.regexutil.z.RegexReplacer_CfgForNeeder#matchNumbers(vv)
    **/
   public ValueValidator<Integer> getMatchNumValidator()  {
      return  vvMatchNum;
   }
   /**
      <p>The maximum number of loops to attempt for &quot;until&quot; replacements. When this maximum is exceeded, the action taken is determined by {@link #doCrashIfMaxUntilExceeded() doCrashIfMaxUntilExceeded}{@code ()}.</p>

      @return  An int one or greater.
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(i,muxi)
    **/
   public int getMaxUntilLoops()  {
      return  iMaxUntilLoops;
   }
   /**
      <p>When the maximum number of &quot;until&quot; replacements is exceeded, should an exception be thrown?.</p>

      @return  <ul>
         <li>{@code true}:  An {@code IllegalStateException} is thrown</li>
         <li>{@code false}: Execution stops.</li>
      </ul>
      @see  #getMaxUntilLoops()
      @see  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(int, MaxUntilLoopsExceeded) xbn.regexutil.z.RegexReplacer_CfgForNeeder#until(i,muxi)
    **/
   public boolean doCrashIfMaxUntilExceeded()  {
      return  bMaxUCrash;
   }
   /**
      <p>Get a capture group in the current match--intended for use only by {@code getIndirectReplacement()}.</p>

      @param  group_num  Must be a valid given {@link #getGroupCount() getGroupCount}{@code ()}.
      @return  <code>[getPattern().matcher(...)].{@link java.util.regex.Matcher#group(int) group}(group_num)</code>
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
      <p>The number of groups in the current match.--intended for use only by {@code getIndirectReplacement()}.</p>

      @return  <code><i>[{@link #getPattern() getPattern}().{@link java.util.regex.Pattern#matcher(CharSequence) matcher}(...)]</i>.{@link java.util.regex.Matcher#groupCount groupCount}()</code></i>
      @see  #getGroup(int) getGroup(i)
      @see  #getIndirectReplacement()
    **/
   public int getGroupCount()  {
      return  m.groupCount();
   }
   /**
      <p>The direct replacement string. See <a href="#direct">direct</a>. This is the string provided directly to <code><i>{@link java.util.regex.Matcher Matcher}</i>.{@link java.util.regex.Matcher#appendReplacement(StringBuffer, String) appendReplacement}(sb,s)</code>, as its second parameter.</p>

      @return  <ul>
         <li>A non-{@code null}, non-empty string: For <a href="#direct">direct</a> replacements.</li>
         <li>&quot;&quot;: For <a href="#indirect">indirect</a> replacements.</li>
      </ul>
      @see  #getIndirectReplacement()
    **/
   public Object getDirectReplacement()  {
      return  oRWDrct;
   }
   /**
      <p>The indirect replacement for a single match.</p>

      <p>In contrast with <a href="#direct">direct</a> replacements, &quot;<a href="#indirect">indirect</a>&quot; replacements allow for each capture group to be individually manipulated:</p>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl2of2%eliminateCommentBlocksAndPackageDecl()}

      @exception  IllegalStateException  This function must be overridden for indirect replacements.
      @see  #getDirectReplacement()
      @see  #getGroup(int) getGroup(i)
      @see  #getGroupCount()
    **/
   public String getIndirectReplacement()  {
      throw  new IllegalStateException("getIndirectReplacement()");
   }
   /**
      <p>How many replacements were made during the most-recent call to {@link #appendReplacedX(Appendable, Object) appendReplacedX}{@code (apbl,o)}</p>
    **/
   public int getReplacementCount()  {
      return  iRplcs;
   }
   /**
      <p>Get the entire replacement result, as configured.</p>

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
      <p>Append the replacement as configured, with a new-line at the end, and with runtime errors only. Intended for debugging and testing.</p>

      @return  <code>{@link #appendReplacedlns(int, Appendable, Object) appendReplacedln}(1, to_appendTo, text_toRplc)</code>
    **/
   public Appendable appendReplacedln(Appendable to_appendTo, Object text_toRplc)  {
      return  appendReplacedlns(1, to_appendTo, text_toRplc);
   }
   /**
      <p>Append the replacement as configured, with a new-line at the end, and with runtime errors only. Intended for debugging and testing.</p>

      @return  <code>{@link #appendReplacedX(Appendable, Object) appendReplacedX}(to_appendTo, text_toRplc)</code>
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
      <p>Append the replacement as configured, with runtime errors only.</p>

      @return  <code>{@link #appendReplacedX(Appendable, Object) appendReplacedX}(to_appendTo, text_toRplc)</code>
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
      <p>Append the replacement as configured.</p>

      @param  to_appendTo  May not be <code>null</code>
      @return  <code>to_appendTo.{@link java.lang.Appendable#append(CharSequence) append}({@link #getReplaced(Object) getReplaced}(text_toRplc))</code> &nbsp; &nbsp; <i>(<code>{@link java.util.regex.Matcher Matcher}.{@link java.util.regex.Matcher#appendReplacement(StringBuffer, String) appendReplacement}(sb,s)</code> requires a <code>{@link java.lang.StringBuffer StringBuffer}</code>)</i>
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
      <p>Get the replacement result, as configured.</p>

      @param  to_appendTo  May not be {@code null}. <i>{@link java.util.regex.Matcher Matcher} requires a {@code StringBuffer}. This should ideally be an {@code Appendable}.</i>
      @param  text_toRplc  May not be {@code null}.
      @return  <code>to_appendTo</code>
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
      <p>Duplicate this {@code RegexReplacer}.</p>

      @return  <code>(new {@link #RegexReplacer(RegexReplacer) RegexReplacer}(this))</code>
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
