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
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.regexutil.RegexReplacer RegexReplacer}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
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
      <P>Configure a <CODE>RegexReplacer</CODE> with defaults.</P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}xbn/chain/AbstractNeedable.html#AbstractNeedable(boolean, boolean, R)">super</A>(true, true, needer)</CODE>{@code (true, true, needer)}</LI>
         <LI>{@link #resetRRCFN() resetRRCFN}{@code ()}</LI>
      </OL></P>
    **/
   public RegexReplacer_CfgForNeeder(R needer)  {
      super(true, true, needer);
      resetRRCFN();
   }
//constructors...END
   /**
      <P>Reset configuration with <I>no search terms</I>.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #resetRRCFN() resetRRCFN}{@code ()}</P>

      @return  <I>{@code this}</I>
    **/
   public RegexReplacer_CfgForNeeder<P,R> reset()  {
      resetRRCFN();
      return  this;
   }
   /**
      <P>Reset configuration specific to this {@code RegexReplacer_CfgForNeeder}</P>

      <P>This<OL>
         <LI>Calls<OL>
            <LI>{@link #direct(Pattern, Object) direct}{@code ((Pattern)null, null)}</LI>
            <LI>{@link #all() all}{@code ()}</LI>
         </OL></LI>
         <LI>Sets<OL>
            <LI>{@link com.github.xbn.regexutil.RegexReplacer#getMatchNumValidator() getMatchNumValidator}{@code ()}* to be {@link com.github.xbn.number.NewLengthInRangeValidatorFor#unrestricted(Null, ValidResultFilter, Appendable) unrestricted}</LI>
            <LI>{@link com.github.xbn.regexutil.RegexReplacer#getMaxUntilLoops() getMaxUntilLoops}{@code ()}* to its {@link com.github.xbn.regexutil.RegexReplacer#DEFAULT_MAX_UNTIL_LOOPS default}</LI>
            <LI>{@link com.github.xbn.regexutil.RegexReplacer#doCrashIfMaxUntilExceeded() doCrashIfMaxUntilExceeded}{@code ()}* to {@code true}.</LI>
         </OL></LI>
      </OL></P>

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
      <P>Replace the first match only.</P>

      <P>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <CODE>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#FIRST FIRST}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> first()  {
      rplcsWhat = ReplacedInEachInput.FIRST;
      return  this;
   }
   /**
      <P>Replace the first match only, <I>which must be anchored to the start of the search string</I>.</P>

      <P>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <CODE>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#LOOKING_AT LOOKING_AT}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> lookingAt()  {
      rplcsWhat = ReplacedInEachInput.LOOKING_AT;
      return  this;
   }
   /**
      <P>Only if the <I>entire string</I> matches the regex, replace it. Otherwise, do nothing.</P>

      <P>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <CODE>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#MATCHES MATCHES}</CODE></P>

      @return  <I>{@code this}</I>
      @see  #all()
    **/
   public RegexReplacer_CfgForNeeder<P,R> matches()  {
      rplcsWhat = ReplacedInEachInput.MATCHES;
      return  this;
   }
   /**
      <P>Set debugging.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public RegexReplacer_CfgForNeeder<P,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
      <P>Replace specific matches only, based on their numeric location in the search-string (such as the second-through-fourth matches only).</P>

      <P>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <CODE>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#MATCH_NUMBERS MATCH_NUMBERS}</CODE></P>

      @param  match_numValidator  May not be <CODE>null</CODE>, and
      <BR> &nbsp; &nbsp; <CODE>match_numValidator.{@link com.github.xbn.analyze.validate.ValueValidator#getRuleType() getRuleType}().{@link com.github.xbn.lang.RuleType#isImpossible() isImpossible}()</CODE>
      <BR>must be {@code false}. Get with {@link RegexReplacer#getMatchNumValidator() getMatchNumValidator}{@code ()}
      @return  <I>{@code this}</I>
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
      <P>Replace only the matches found within a specific numeric range.</P>

      @return  <CODE>{@link #matchNumbers(ValueValidator) matchNumbers}(new {@link com.github.xbn.number.z.LengthInRangeValidator_Cfg#LengthInRangeValidator_Cfg() LengthInRangeValidator_Cfg}().{@link com.github.xbn.number.z.LengthInRangeValidator_CfgForNeeder#range(LengthInRange) range}(range).{@link com.github.xbn.number.z.LengthInRangeValidator_CfgForNeeder#build() build}())</CODE>
    **/
   public RegexReplacer_CfgForNeeder<P,R> matchRange(LengthInRange range)  {
      return  matchNumbers(new LengthInRangeValidator_Cfg().range(range).build());
   }
   /**
      <P>Replace only the matches found within a specific numeric range, such as the second-through-fourth.</P>

      @return  <CODE>{@link #matchRange(LengthInRange) matchRange}(new {@link com.github.xbn.number.LengthInRange#LengthInRange(int, String, IntBound) LengthInRange}(min, null, new new com.github.xbn.number.IntBoundInclusive#IntBoundInclusive(Integer, String)(max_inclusive, null)))</CODE>
    **/
   public RegexReplacer_CfgForNeeder<P,R> matchRange(int min, int max_inclusive)  {
      return  matchRange(new LengthInRange(min, null, new IntBoundInclusive(max_inclusive, null)));
   }
   /**
      <P>Replace all matches.</P>

      <P>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <CODE>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#ALL ALL}</CODE></P>

      @return  <I>{@code this}</I>
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
      <P>Set the replaces-what Enum explicitely, to anything except &quot;match numbers&quot;.</P>

      @param  rplcs_what  May not be {@code null}, and may not equal <CODE>ReplacedInEachInput.{@link com.github.xbn.regexutil.ReplacedInEachInput#MATCH_NUMBERS MATCH_NUMBERS}</CODE>. If {@link com.github.xbn.regexutil.ReplacedInEachInput#UNTIL UNTIL}, then this calls {@link #until(int) until}{@code (20)}. Otherwise it sets {@link com.github.xbn.regexutil.RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to {@code rplcs_what}.
      @return  <I>{@code this}</I>
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
      <P>Replace all matches repeatedly, until no more are found.</P>

      <P>This sets {@link RegexReplacer#getReplacedInEachInput() getReplacedInEachInput}{@code ()}* to <CODE>{@link com.github.xbn.regexutil.ReplacedInEachInput ReplacedInEachInput}.{@link com.github.xbn.regexutil.ReplacedInEachInput#UNTIL UNTIL}</CODE></P>

      @return  <I>{@code this}</I>
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
      <P>Replace all matches repeatedly, until no more are found.</P>

      @return  <CODE>{@link #until(int, MaxUntilLoopsExceeded) until}(max_loops, {@link com.github.xbn.regexutil.z.MaxUntilLoopsExceeded MaxUntilLoopsExceeded}.{@link com.github.xbn.regexutil.z.MaxUntilLoopsExceeded#BAD BAD})</CODE>
    **/
   public RegexReplacer_CfgForNeeder<P,R> until(int max_loops)  {
      return  until(max_loops, MaxUntilLoopsExceeded.BAD);
   }
   /**
      <P>Set the find-what search-term for <I>indirect</I> replacements only.</P>

      @return  <I>{@code this}</I>
      @see  #findWhat(String) findWhat(s)
      @see  #findWhatLiteral(String) findWhatLiteral(s)
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhat(Pattern pattern_toFind)  {
      pFindWhat = pattern_toFind;
      return  this;
   }
   /**
      <P>Set the find-what search-term for <I>indirect</I> replacements only.</P>

      @param  findWhat_regex  May not be <CODE>null</CODE>.
      @return  <CODE>{@link #findWhat(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}{@link com.github.xbn.regexutil.NewPatternFor#regex(String, String) regex}(findWhat_regex))</CODE>
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhat(String findWhat_regex)  {
      return  findWhat(NewPatternFor.regex(findWhat_regex, "findWhat_regex"));
   }
   /**
      <P>Set the find-what search-term for <I>indirect</I> replacements only.</P>

      @param  findWhat_regex  May not be <CODE>null</CODE>.
      @return  <CODE>{@link #findWhat(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}{@link com.github.xbn.regexutil.NewPatternFor#regex(String, int, String) regex}(findWhat_regex, bit_flags))</CODE>
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhat(String findWhat_regex, int bit_flags)  {
      return  findWhat(NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"));
   }
   /**
      <P>Set the find-what search-term for <I>indirect</I> replacements only.</P>

      @param  findWhat_literal  May not be <CODE>null</CODE>.
      @return  <CODE>{@link #findWhat(Pattern) pattern}([PRE_LINK-file].{@link  NewPatternFor#literal(String) literal}(findWhat_literal))</CODE>
    **/
   public RegexReplacer_CfgForNeeder<P,R> findWhatLiteral(String findWhat_literal)  {
      return  findWhat(NewPatternFor.literal(findWhat_literal, "findWhat_literal"));
   }
   /**
      <P>Set the <I>direct</I>-replacement search terms.</P>

    **/
   public RegexReplacer_CfgForNeeder<P,R> direct(Pattern pattern_toFind, Object direct_rplcWithStr)  {
      findWhat(pattern_toFind);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <P>Set the direct-replacement search terms.</P>

      <P>This calls<OL>
         <LI>{@link #findWhat(String) findWhat}{@code (findWhat_regex)}</LI>
         <LI>{@link #directReplacement(Object) directReplacement}{@code (direct_rplcWithStr)}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
    **/
   public RegexReplacer_CfgForNeeder<P,R> direct(String findWhat_regex, Object direct_rplcWithStr)  {
      findWhat(findWhat_regex);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <P>Set the direct-replacement search terms.</P>

      <P>This calls<OL>
         <LI>{@link #findWhat(String, int) findWhat}{@code (findWhat_regex, bit_flags)}</LI>
         <LI>{@link #directReplacement(Object) directReplacement}{@code (direct_rplcWithStr)}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
    **/
   public RegexReplacer_CfgForNeeder<P,R> direct(String findWhat_regex, int bit_flags, Object direct_rplcWithStr)  {
      findWhat(findWhat_regex, bit_flags);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <P>Set the direct-replacement search terms.</P>

      <P>This calls<OL>
         <LI>{@link #findWhatLiteral(String) findWhatLiteral}{@code (findWhat_literal, bit_flags)}</LI>
         <LI>{@link #directReplacement(Object) directReplacement}{@code (direct_rplcWithStr)}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
    **/
   public RegexReplacer_CfgForNeeder<P,R> directLiteral(String findWhat_literal, Object direct_rplcWithStr)  {
      findWhatLiteral(findWhat_literal);
      return  directReplacement(direct_rplcWithStr);
   }
   /**
      <P>Set the direct replace-with string.</P>

      @param  direct_rplcWithStr  If non-{@code null}, this is a <A HREF="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#direct">direct</A> replacement. If {@code null}, this is an <A HREF="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#indirect">indirect</A> replacement. Get with {@link com.github.xbn.regexutil.RegexReplacer#getDirectReplacement() getDirectReplacement}{@code ()}*.
      @return  <I>{@code this}</I>
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
      <P>Replace all matches repeatedly, until no more are found.</P>

      @return  <CODE>{@link #until(int) until}(max_loops, {@link com.github.xbn.regexutil.RegexReplacer}.{@link com.github.xbn.regexutil.RegexReplacer#DEFAULT_MAX_UNTIL_LOOPS})</CODE>
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
      <P>Create a new <CODE>RegexReplacer</CODE> as configured, <I>for direct replacements only</I>.</P>

      @return  <CODE>(new {@link com.github.xbn.regexutil.RegexReplacer#RegexReplacer(RegexReplacer_Fieldable) RegexReplacer}(this))</CODE>
      @exception  IllegalArgumentException  If {@link #getDirectReplacement() getDirectReplacement}{@code ()} is {@code null}.
      @see  <A HREF="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#direct">Definition: direct</A>
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
      @return  <I>{@code this}</I>
    **/
   @SuppressWarnings("unchecked")  //See LLCfgOverall.startConfigReturnNeedable(R)
   public RegexReplacer_CfgForNeeder<P,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<P> clsp = (Class<P>)((Class)RegexReplacer.class);
      startConfig(needer, clsp);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   /**
      @return  <I>{@code this}</I>
    **/
   public RegexReplacer_CfgForNeeder<P,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
}
