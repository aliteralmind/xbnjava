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
package  com.github.xbn.regexutil.z;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.regexutil.NewPatternFor;
   import  com.github.xbn.regexutil.MatcherUses;
   import  com.github.xbn.regexutil.RegexValidator;
   import  com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder;
   import  com.github.xbn.neederneedable.DummyForNoNeeder;
   import  java.util.regex.Pattern;
   import  com.github.xbn.neederneedable.Needer;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.regexutil.RegexValidator RegexValidator}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexValidator_CfgForNeeder<V extends RegexValidator,R extends Needer> extends ValueValidator_CfgForNeeder<String,V,R> implements RegexValidator_Fieldable  {
   public Pattern     p         = null;
   public MatcherUses mtchrUses = null;
//constructors...START
   /**
      <P>Create a new instance.</P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/validate/ValueValidator_CfgForNeeder.html#ValueValidator_CfgForNeeder(boolean, boolean, R)">super</A>(true, true, needer)</CODE></LI>
         <LI>{@link #resetRVCFN() resetRVCFN}{@code ()}</LI>
      </OL></P>
    **/
   public RegexValidator_CfgForNeeder(R needer)  {
      super(true, true, needer);
      resetRVCFN();
   }
   /**
      <P>Reset configuration to <I>nothing</I>.</P>

      <P>This calls<OL>
         <LI><CODE>{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder ValueValidator_CfgForNeeder}.{@link com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder#reset() reset}()</CODE></LI>
         <LI>{@link #resetRVCFN() resetRVCFN}{@code ()}</LI>
      </OL></P>

      @return  <I>{@code this}</I>
    **/
   public RegexValidator_CfgForNeeder<V,R> reset()  {
      super.reset();
      resetRVCFN();
      return  this;
   }
   /**
      <P>Reset configuration specific to this {@code RegexValidator_CfgForNeeder}.</P>

      <P>This sets the following to {@code null}: {@link com.github.xbn.regexutil.RegexValidator#getPattern() getPattern}{@code ()}*, {@link com.github.xbn.regexutil.RegexValidator#getMatcherUses() getMatcherUses}{@code ()}*</P>

      @see  #reset()
    **/
   protected final void resetRVCFN()  {
      p = null;
      mtchrUses = null;
   }
   /**
      <P>Set debugging.</P>

      @param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
      @return  <I>{@code this}</I>
    **/
   public RegexValidator_CfgForNeeder<V,R> debugTo(Appendable dest_ifNonNull)  {
      apblDebug = dest_ifNonNull;
      return  this;
   }
   /**
      <P>Declare no filtering.</P>

      @return  {@link #filter(ValidResultFilter) filter}{@code (null)}
    **/
   public RegexValidator_CfgForNeeder<V,R> unfiltered()  {
      return  filter(null);
   }
   /**
      <P>Set the valid-result filter.</P>

      @param  filter_offIfNull  If {@code null}, the validator is {@link #unfiltered() unfiltered}. Get with {@link com.github.xbn.analyze.validate.Validator#getFilter() getFilter}{@code ()}.
      @return  <I>{@code this}</I>
    **/
   public RegexValidator_CfgForNeeder<V,R> filter(ValidResultFilter filter_offIfNull)  {
      super.filter(filter_offIfNull);
      return  this;
   }
   /**
      <P>Search the string-as-a-whole.</P>

      <P>This sets <CODE>{@link RegexValidator}.{@link RegexValidator#getMatcherUses() mtchrUses}()</CODE> to <CODE>{@link com.github.xbn.regexutil.MatcherUses}.{@link com.github.xbn.regexutil.MatcherUses#MATCHES MATCHES}</CODE>.</P>

      <P><I>Note: <CODE>MatcherUses.{@link com.github.xbn.regexutil.MatcherUses#CUSTOM CUSTOM}</CODE> is not a legal value for {@link com.github.xbn.regexutil.RegexValidator RegexValidator}</I></P>

      @return  <I>{@code this}</I>
      @see  #useFind()
      @see  #useLookingAt()
    **/
   public RegexValidator_CfgForNeeder<V,R> useMatches()  {
      mtchrUses = MatcherUses.MATCHES;
      return  this;
   }
   /**
      <P>Search multiple sub-sequences within the string.</P>

      <P>This sets <CODE>{@link RegexValidator}.{@link RegexValidator#getMatcherUses() mtchrUses}()</CODE> to <CODE>{@link com.github.xbn.regexutil.MatcherUses}.{@link com.github.xbn.regexutil.MatcherUses#FIND FIND}</CODE>.</P>

      @return  <I>{@code this}</I>
      @see  #useFind()
    **/
   public RegexValidator_CfgForNeeder<V,R> useFind()  {
      mtchrUses = MatcherUses.FIND;
      return  this;
   }
   /**
      <P>Search multiple sub-sequences within the string.</P>

      <P>This sets <CODE>{@link RegexValidator}.{@link RegexValidator#getMatcherUses() mtchrUses}()</CODE> to <CODE>{@link com.github.xbn.regexutil.MatcherUses}.{@link com.github.xbn.regexutil.MatcherUses#LOOKING_AT LOOKING_AT}</CODE>.</P>

      @return  <I>{@code this}</I>
      @see  #useFind()
    **/
   public RegexValidator_CfgForNeeder<V,R> useLookingAt()  {
      mtchrUses = MatcherUses.LOOKING_AT;
      return  this;
   }
   /**
      <P>Set the find-what term to a literal string.</P>

      @return  <CODE>{@link #pattern(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#literal(String) literal}(text_toFind))</CODE>
    **/
   public RegexValidator_CfgForNeeder<V,R> literal(String text_toFind)  {
      return  pattern(NewPatternFor.literal(text_toFind, "text_toFind"));
   }
   /**
      <P>Set the find-what term to a regular expression.</P>

      @return  <CODE>{@link #pattern(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#regex(String, String) regex}(regex_toFind, &quot;regex_toFind&quot;))</CODE>
    **/
   public RegexValidator_CfgForNeeder<V,R> regex(String regex_toFind)  {
      return  pattern(NewPatternFor.regex(regex_toFind, "regex_toFind"));
   }
   /**
      <P>Set the find-what term to a regular expression with flags.</P>

      @return  <CODE>{@link #pattern(Pattern) pattern}({@link com.github.xbn.regexutil.NewPatternFor NewPatternFor}.{@link com.github.xbn.regexutil.NewPatternFor#regex(String, int, String) regex}(regex_toFind, bit_flags, &quot;regex_toFind&quot;))</CODE>
    **/
   public RegexValidator_CfgForNeeder<V,R> regex(String regex_toFind, int bit_flags)  {
      return  pattern(NewPatternFor.regex(regex_toFind, bit_flags, "regex_toFind"));
   }
   /**
      <P>Set the find-what term to a pattern.</P>

      @param  to_find  May not be {@code null}. Get with {@link com.github.xbn.regexutil.RegexValidator#getPattern() getPattern}{@code ()}*
      @return  <I>{@code this}</I>
      @see  #literal(String) literal(s)
      @see  #regex(String) regex(s)
      @see  #regex(String, int) regex(s,i)
    **/
   public RegexValidator_CfgForNeeder<V,R> pattern(Pattern to_find)  {
      p = to_find;
      return  this;
   }
   /**
      <P>Declare if the rules should be inverted.</P>

      @param  do_invert  If {@code true}, the rules are inverted. Get with {@link com.github.xbn.analyze.validate.Validator#doInvertRules() doInvertRules}{@code ()}*
      @return  <I>{@code this}</I>
    **/
   public RegexValidator_CfgForNeeder<V,R> invert(boolean do_invert)  {
      super.invert(do_invert);
      return  this;
   }
   /**
      <P>Set information to append to error messages.</P>

      @param  info  If non-{@code null}, this object's {@code toString()} is appended to error messages. Get with {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}{@code ()}*
      @return  <I>{@code this}</I>
    **/
   public RegexValidator_CfgForNeeder<V,R> extraErrInfo(Object info)  {
      super.extraErrInfo(info);
      return  this;
   }
   /**
      <P>Declare if {@code null} is acceptable (pre-inversion).</P>

      @param  is_ok  If {@code true}, {@code null} is acceptable.
      @return  <I>{@code this}</I>
      @see  #invert(boolean)
      @see  com.github.xbn.analyze.validate.NullnessValidator#isNullOkGivenInvert() isNullOkGivenInvert()*
    **/
   public RegexValidator_CfgForNeeder<V,R> nullOk(boolean is_ok)  {
      super.nullOk(is_ok);
      return  this;
   }
   public Pattern getPattern()  {
      return  p;
   }
   public MatcherUses getMatcherUses()  {
      return  mtchrUses;
   }
   public V build()  {
      @SuppressWarnings("unchecked")
      V v = (V)(new RegexValidator(this));
      return  v;
   }
   public String toString()  {
      return  super.toString() + ", getPattern()=[" + getPattern() + "], getMatcherUses()=" + getMatcherUses() + "";
   }
   public RegexValidator_CfgForNeeder<V,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")  //See xbn.neederneedable.Needer.startConfig(Class)
      Class<V> cpvo = (Class<V>)(Class)RegexValidator.class;
      startConfig(needer, cpvo);

      return  this;
   }
   public RegexValidator_CfgForNeeder<V,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  (R)endCfgWithNeededReturnNeeder(build());
   }
}
