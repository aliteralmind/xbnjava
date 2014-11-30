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
package  com.github.xbn.regexutil.z;
   import  com.github.xbn.number.IntBoundInclusive;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.neederneedable.AbstractNeedable;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.number.NewLengthInRangeValidatorFor;
   import  com.github.xbn.number.z.LengthInRangeValidator_Cfg;
   import  com.github.xbn.regexutil.NewPatternFor;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  java.util.regex.Pattern;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.regexutil.RegexReplacer RegexReplacer}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RegexReplacer_CfgForNeeder<P extends RegexReplacer,R extends Needer> extends AbstractNeedable<P,R> implements RegexReplacer_Fieldable  {
//config
   public Pattern             pFindWhat       = null ;
   public Object              oRplcWithDirect = null ;
   public Appendable          apblDebug       = null ;
   public ReplacedInEachInput rplcsWhat       = null ;
   public ValueValidator<Integer> vvMatchNum  = null ;
   public int                 iMaxUntilLoops  = -1   ;
   public boolean             doCrashIfMaxUntilExceeded  = false;

//constructors...START
   /**
      <p>Configure a <code>RegexReplacer</code> with defaults.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}xbn/chain/AbstractNeedable.html#AbstractNeedable(boolean, boolean, R)">super</a>(true, true, needer)</code>{@code (true, true, needer)}</li>
         <li>{@link #resetRRCFN() resetRRCFN}{@code ()}</li>
      </ol></p>
    **/
   public RegexReplacer_CfgForNeeder(R needer)  {
      super(true, true, needer);
      resetRRCFN();
   }
//constructors...END
   /**
      <p>Reset configuration with <i>no search terms</i>.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #resetRRCFN() resetRRCFN}{@code ()}</p>

      @return  <i>{@code this}</i>
    **/
   public RegexReplacer_CfgForNeeder<P,R> reset()  {
      resetRRCFN();
      return  this;
   }
   /**
      <p>Reset configuration specific to this {@code RegexReplacer_CfgForNeeder}</p>

      <p>This<ol>
         <li>Calls<ol>
            <li>{@link #direct(Pattern, Object) direct}{@code ((Pattern)null, null)}</li>
            <li>{@link #all() all}{@code ()}</li>
         </ol></li>
         <li>Sets<ol>
            <li>{@link com.github.xbn.regexutil.RegexReplacer#getMatchNumValidator() getMatchNumValidator}{@code ()}* to be {@link com.github.xbn.number.NewLengthInRangeValidatorFor#unrestricted(Null, ValidResultFilter, Appendable) unrestricted}</li>
            <li>{@link com.github.xbn.regexutil.RegexReplacer#getMaxUntilLoops() getMaxUntilLoops}{@code ()}* to its {@link com.github.xbn.regexutil.RegexReplacer#DEFAULT_MAX_UNTIL_LOOPS default}</li>
            <li>{@link com.github.xbn.regexutil.RegexReplacer#doCrashIfMaxUntilExceeded() doCrashIfMaxUntilExceeded}{@code ()}* to {@code true}.</li>
         </ol></li>
      </ol></p>

      @see  #reset()
    **/
   protected final void resetRRCFN()  {
      direct((Pattern)null, null);
      all();
      vvMatchNum = NewLengthInRangeValidatorFor.unrestricted(Null.BAD, null, null);
      iMaxUntilLoops = RegexReplacer.DEFAULT_MAX_UNTIL_LOOPS;
      doCrashIfMaxUntilExceeded = false;
   }
   /**
      <p>Replace the first match only.</p>

      <p>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <code>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#FIRST FIRST}</code></p>

      @return  <i>{@code this}</i>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> first()  {
      rplcsWhat = ReplacedInEachInput.FIRST;
      return  this;
   }
   /**
      <p>Replace the first match only, <i>which must be anchored to the start of the search string</i>.</p>

      <p>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <code>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#LOOKING_AT LOOKING_AT}</code></p>

      @return  <i>{@code this}</i>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> lookingAt()  {
      rplcsWhat = ReplacedInEachInput.LOOKING_AT;
      return  this;
   }
   /**
      <p>Only if the <i>entire string</i> matches the regex, replace it. Otherwise, do nothing.</p>

      <p>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <code>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#MATCHES MATCHES}</code></p>

      @return  <i>{@code this}</i>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> matches()  {
      rplcsWhat = ReplacedInEachInput.MATCHES;
      return  this;
   }
   /**
      <p>Set debugging.</p>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
      @return  <i>{@code this}</i>
    **/
   public RegexReplacer_CfgForNeeder<P,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
      <p>Replace specific matches only, based on their numeric location in the search-string (such as the second-through-fourth matches only).</p>

      <p>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <code>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#MATCH_NUMBERS MATCH_NUMBERS}</code></p>

      @param  match_numValidator  May not be <code>null</code>, and
      <br/> &nbsp; &nbsp; <code>match_numValidator.{@link com.github.xbn.analyze.validate.ValueValidator#getRuleType() getRuleType}().{@link com.github.xbn.lang.RuleType#isImpossible() isImpossible}()</code>
      <br/>must be {@code false}. Get with {@link RegexReplacer#getMatchNumValidator() getMatchNumValidator}{@code ()}
      @return  <i>{@code this}</i>
      @see  #all()
      @see  #matchRange(LengthInRange) matchRange(iir)
      @see  #matchRange(int, int) matchRange(i,i)
    **/
   public RegexReplacer_CfgForNeeder<P,R> matchNumbers(ValueValidator<Integer> match_numValidator)  {
      vvMatchNum = match_numValidator;
      rplcsWhat = ReplacedInEachInput.MATCH_NUMBERS;
      return  this;
   }
   /**
      <p>Replace only the matches found within a specific numeric range.</p>

      @return  <code>{@link #matchNumbers(ValueValidator) matchNumbers}(new {@link com.github.xbn.number.z.LengthInRangeValidator_Cfg#LengthInRangeValidator_Cfg() LengthInRangeValidator_Cfg}().{@link com.github.xbn.number.z.LengthInRangeValidator_CfgForNeeder#range(LengthInRange) range}(range).{@link com.github.xbn.number.z.LengthInRangeValidator_CfgForNeeder#build() build}())</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> matchRange(LengthInRange range)  {
      return  matchNumbers(new LengthInRangeValidator_Cfg().range(range).build());
   }
   /**
      <p>Replace only the matches found within a specific numeric range, such as the second-through-fourth.</p>

      @return  <code>{@link #matchRange(LengthInRange) matchRange}(new {@link com.github.xbn.number.LengthInRange#LengthInRange(int, String, IntBound) LengthInRange}(min, null, new new com.github.xbn.number.IntBoundInclusive#IntBoundInclusive(Integer, String)(max_inclusive, null)))</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> matchRange(int min, int max_inclusive)  {
      return  matchRange(new LengthInRange(min, null, new IntBoundInclusive(max_inclusive, null)));
   }
   /**
      <p>Replace all matches.</p>

      <p>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <code>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#ALL ALL}</code></p>

      @return  <i>{@code this}</i>
      @see  #first()
      @see  #lookingAt()
      @see  #matches()
      @see  #matchNumbers(ValueValidator) matchNumbers(vv)
      @see  #until(int, MaxUntilLoopsExceeded) until(i,muxi)
      @see  #replaceWhatNotMatchNums(ReplacedInEachInput) replaceWhatNotMatchNums(rw)
    **/
   public RegexReplacer_CfgForNeeder<P,R> all()  {
      rplcsWhat = ReplacedInEachInput.ALL;
      return  this;
   }
   /**
      <p>Set the replaces-what Enum explicitely, to anything except &quot;match numbers&quot;.</p>

      @param  rplcs_what  May not be {@code null}, and may not equal <code>ReplacedInEachInput.{@link com.github.xbn.regexutil.ReplacedInEachInput#MATCH_NUMBERS MATCH_NUMBERS}</code>. If {@link com.github.xbn.regexutil.ReplacedInEachInput#UNTIL UNTIL}, then this calls {@link #until(int) until}{@code (20)}. Otherwise it sets {@link com.github.xbn.regexutil.RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to {@code rplcs_what}.
      @return  <i>{@code this}</i>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> replaceWhatNotMatchNums(ReplacedInEachInput rplcs_what)  {
      try  {
         rplcs_what.crashIfForbiddenValue(ReplacedInEachInput.MATCH_NUMBERS, "rplcs_what", null);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(rplcs_what, "rplcs_what", null, rx);
      }
      if(rplcs_what == ReplacedInEachInput.UNTIL)  {
         until(20);
      }  else  {
         rplcsWhat = rplcs_what;
      }
      return  this;
   }
   /**
      <p>Replace all matches repeatedly, until no more are found.</p>

      <p>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <code>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#UNTIL UNTIL}</code></p>

      @return  <i>{@code this}</i>
      @see  #first()
      @see  #until(int) until(i)
      @see  #until()
    **/
   public RegexReplacer_CfgForNeeder<P,R> until(int max_loops, MaxUntilLoopsExceeded exceeded_is)  {
      iMaxUntilLoops = max_loops;
      try  {
         doCrashIfMaxUntilExceeded = exceeded_is.isBad();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(exceeded_is, "exceeded_is", null, rx);
      }
      rplcsWhat = ReplacedInEachInput.UNTIL;
      return  this;
   }
   /**
      <p>Replace all matches repeatedly, until no more are found.</p>

      @return  <code>{@link #until(int, MaxUntilLoopsExceeded) until}(max_loops, {@link com.github.xbn.regexutil.z.MaxUntilLoopsExceeded MaxUntilLoopsExceeded}.{@link com.github.xbn.regexutil.z.MaxUntilLoopsExceeded#BAD BAD})</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> until(int max_loops)  {
      return  until(max_loops, MaxUntilLoopsExceeded.BAD);
   }
   /**
      <p>Set the find-what search-term for <i>indirect</i> replacements only.</p>

      @return  <i>{@code this}</i>
      @see  #findWhat(String) findWhat(s)
      @see  #findWhatLiteral(String) findWhatLiteral(s)
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhat(Pattern pattern_toFind)  {
      pFindWhat = pattern_toFind;
      return  this;
   }
   /**
      <p>Set the find-what search-term for <i>indirect</i> replacements only.</p>

      @param  findWhat_regex  May not be <code>null</code>.
      @return  <code>{@link #findWhat(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}{@link com.github.xbn.regexutil.NewPatternFor#regex(String, String) regex}(findWhat_regex))</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhat(String findWhat_regex)  {
      return  findWhat(NewPatternFor.regex(findWhat_regex, "findWhat_regex"));
   }
   /**
      <p>Set the find-what search-term for <i>indirect</i> replacements only.</p>

      @param  findWhat_regex  May not be <code>null</code>.
      @return  <code>{@link #findWhat(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}{@link com.github.xbn.regexutil.NewPatternFor#regex(String, int, String) regex}(findWhat_regex, bit_flags))</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhat(String findWhat_regex, int bit_flags)  {
      return  findWhat(NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"));
   }
   /**
      <p>Set the find-what search-term for <i>indirect</i> replacements only.</p>

      @param  findWhat_literal  May not be <code>null</code>.
      @return  <code>{@link #findWhat(Pattern) pattern}([PRE_LINK-file].{@link  NewPatternFor#literal(String) literal}(findWhat_literal))</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhatLiteral(String findWhat_literal)  {
      return  findWhat(NewPatternFor.literal(findWhat_literal, "findWhat_literal"));
   }
   /**
      <p>Set the <i>direct</i>-replacement search terms.</p>

    **/
   public RegexReplacer_CfgForNeeder<P,R> direct(Pattern pattern_toFind, Object direct_rplcWithStr)  {
      findWhat(pattern_toFind);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <p>Set the direct-replacement search terms.</p>

      <p>This calls<ol>
         <li>{@link #findWhat(String) findWhat}{@code (findWhat_regex)}</li>
         <li>{@link #directReplacement(Object) directReplacement}{@code (direct_rplcWithStr)}</li>
      </ol></p>

      @return  <i>{@code this}</i>
    **/
   public RegexReplacer_CfgForNeeder<P,R> direct(String findWhat_regex, Object direct_rplcWithStr)  {
      findWhat(findWhat_regex);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <p>Set the direct-replacement search terms.</p>

      <p>This calls<ol>
         <li>{@link #findWhat(String, int) findWhat}{@code (findWhat_regex, bit_flags)}</li>
         <li>{@link #directReplacement(Object) directReplacement}{@code (direct_rplcWithStr)}</li>
      </ol></p>

      @return  <i>{@code this}</i>
    **/
   public RegexReplacer_CfgForNeeder<P,R> direct(String findWhat_regex, int bit_flags, Object direct_rplcWithStr)  {
      findWhat(findWhat_regex, bit_flags);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <p>Set the direct-replacement search terms.</p>

      <p>This calls<ol>
         <li>{@link #findWhatLiteral(String) findWhatLiteral}{@code (findWhat_literal, bit_flags)}</li>
         <li>{@link #directReplacement(Object) directReplacement}{@code (direct_rplcWithStr)}</li>
      </ol></p>

      @return  <i>{@code this}</i>
    **/
   public RegexReplacer_CfgForNeeder<P,R> directLiteral(String findWhat_literal, Object direct_rplcWithStr)  {
      findWhatLiteral(findWhat_literal);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <p>Set the direct replace-with string.</p>

      @param  direct_rplcWithStr  If non-{@code null}, this is a <a href="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#direct">direct</a> replacement. If {@code null}, this is an <a href="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#indirect">indirect</a> replacement. Get with {@link com.github.xbn.regexutil.RegexReplacer#getDirectReplacement() getDirectReplacement}{@code ()}*.
      @return  <i>{@code this}</i>
      @see  #direct(Pattern, Object) direct(p,O)
      @see  #direct(String, Object) direct(s,O)
      @see  #direct(String, int, Object) direct(s,i,O)
      @see  #directLiteral(String, Object) directLiteral(s,O)
    **/
   public RegexReplacer_CfgForNeeder<P,R> directReplacement(Object direct_rplcWithStr)  {
      oRplcWithDirect = direct_rplcWithStr;
      return  this;
   }
   /**
      <p>Replace all matches repeatedly, until no more are found.</p>

      @return  <code>{@link #until(int) until}(max_loops, {@link com.github.xbn.regexutil.RegexReplacer}.{@link com.github.xbn.regexutil.RegexReplacer#DEFAULT_MAX_UNTIL_LOOPS})</code>
    **/
   public RegexReplacer_CfgForNeeder<P,R> until()  {
      return  until(RegexReplacer.DEFAULT_MAX_UNTIL_LOOPS);
   }
   public Appendable getDebugApbl()  {
      return apblDebug;
   }
   public Pattern getPattern()  {
      return  pFindWhat;
   }
   public ReplacedInEachInput getReplacedInEachInput()  {
      return  rplcsWhat;
   }
   public ValueValidator<Integer> getMatchNumValidator()  {
      return  vvMatchNum;
   }
   public int getMaxUntilLoops()  {
      return  iMaxUntilLoops;
   }
   public boolean doCrashIfMaxUntilExceeded()  {
      return  doCrashIfMaxUntilExceeded;
   }
   public Object getDirectReplacement()  {
      return  oRplcWithDirect;
   }
   /**
      <p>Create a new <code>RegexReplacer</code> as configured, <i>for direct replacements only</i>.</p>

      @return  <code>(new {@link com.github.xbn.regexutil.RegexReplacer#RegexReplacer(RegexReplacer_Fieldable) RegexReplacer}(this))</code>
      @exception  IllegalArgumentException  If {@link #getDirectReplacement() getDirectReplacement}{@code ()} is {@code null}.
      @see  <a href="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#direct">Definition: direct</a>
    **/
   public P build()  {
      if(getDirectReplacement() == null)  {
         throw  new IllegalArgumentException("getDirectReplacement() (build() may only be used for direct replacements)");
      }

      @SuppressWarnings("unchecked")
      P p = (P)(new RegexReplacer(this));
      return  p;
   }
   /**
      @return  <i>{@code this}</i>
    **/
   @SuppressWarnings("unchecked")  //See LLCfgOverall.startConfigReturnNeedable(R)
   public RegexReplacer_CfgForNeeder<P,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<P> clsp = (Class<P>)((Class)RegexReplacer.class);
      startConfig(needer, clsp);
      return  this;
   }
   /**
      <p>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</p>

      @return  <code>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</code>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   /**
      @return  <i>{@code this}</i>
    **/
   public RegexReplacer_CfgForNeeder<P,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
}
