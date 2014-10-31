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
	import  com.github.xbn.regexutil.NewPatternFor;
	import  com.github.xbn.regexutil.RegexGroupExtractor;
	import  com.github.xbn.regexutil.MatcherUses;
	import  com.github.xbn.neederneedable.Needer;
	import  com.github.xbn.neederneedable.AbstractNeedable;
	import  java.util.regex.Pattern;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.regexutil.RegexGroupExtractor RegexGroupExtractor}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexGroupExtractor_CfgForNeeder<X extends RegexGroupExtractor,R extends Needer> extends AbstractNeedable<X,R> implements RegexGroupExtractor_Fieldable  {
	public Pattern      pWithGroups    ;
	public MatcherUses mtchrUses      ;
	public int          iRequiredGroups;
	/**
		<P>Create a new instance with defaults.</P>

		<P>This calls<OL>
			<LI>{@link #useFind() useFind}{@code ()}</LI>
			<LI><CODE>{@link #requiredGroups(int) requiredGroups}(-1)</CODE></LI>
		</OL></P>
	 **/
	public RegexGroupExtractor_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
		super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
		useFind();
		requiredGroups(-1);
	}
	/**
		<P>Search the string-as-a-whole.</P>

		<P>This sets <CODE>{@link RegexGroupExtractor}.{@link RegexGroupExtractor#getMatcherUses() getMatcherUses}()</CODE> to <CODE>{@link MatcherUses}.{@link MatcherUses#MATCHES MATCHES}</CODE>.</P>

		@return  <I>{@code this}</I>
		@see  #useFind()
		@see  #useLookingAt()
	 **/
	public RegexGroupExtractor_CfgForNeeder<X,R> useMatches()  {
		mtchrUses = MatcherUses.MATCHES;
		return  this;
	}
	/**
		<P>Search multiple sub-sequences within the string.</P>

		<P>This sets <CODE>{@link RegexGroupExtractor}.{@link RegexGroupExtractor#getMatcherUses() getMatcherUses}()</CODE> to <CODE>{@link MatcherUses}.{@link MatcherUses#FIND FIND}</CODE>.</P>

		@return  <I>{@code this}</I>
		@see  #useFind()
	 **/
	public RegexGroupExtractor_CfgForNeeder<X,R> useFind()  {
		mtchrUses = MatcherUses.FIND;
		return  this;
	}
	/**
		<P>Search multiple sub-sequences within the string.</P>

		<P>This sets <CODE>{@link RegexGroupExtractor}.{@link RegexGroupExtractor#getMatcherUses() getMatcherUses}()</CODE> to <CODE>{@link MatcherUses}.{@link MatcherUses#LOOKING_AT LOOKING_AT}</CODE>.</P>

		@return  <I>{@code this}</I>
		@see  #useFind()
	 **/
	public RegexGroupExtractor_CfgForNeeder<X,R> useLookingAt()  {
		mtchrUses = MatcherUses.LOOKING_AT;
		return  this;
	}
	/**
		<P>Declare a specific number of groups is required in every iteration.</P>

		@param  num  If {@code -1}, at least one group is required. Otherwise, must be greater than zero, and represents the exact number of groups that must be found. Get with <CODE>[PRE_LINK-file-italic].{@link RegexGroupExtractor#getRequiredGroupCount() getRequiredGroupCount}()</CODE>
		@return  <I>{@code this}</I>
	 **/
	public RegexGroupExtractor_CfgForNeeder<X,R> requiredGroups(int num)  {
		iRequiredGroups = num;
		return  this;
	}
	public RegexGroupExtractor_CfgForNeeder<X,R> pattern(String regex_withGroups)  {
		return  pattern(NewPatternFor.regex(regex_withGroups, "regex_withGroups"));
	}
	public RegexGroupExtractor_CfgForNeeder<X,R> pattern(String regex_withGroups, int bit_flags)  {
		return  pattern(NewPatternFor.regex(regex_withGroups, bit_flags, "regex_withGroups"));
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexGroupExtractor_CfgForNeeder<X,R> pattern(Pattern pattern_toFind)  {
		pWithGroups = pattern_toFind;
		return  this;
	}

	public Pattern getPattern()  {
		return  pWithGroups;
	}
	public MatcherUses getMatcherUses()  {
		return  mtchrUses;
	}
	public int getRequiredGroups()  {
		return  iRequiredGroups;
	}

	/**
		<P>Create a new <CODE>RegexGroupExtractor</CODE> with a pattern <I>that contains groups</I>.</P>

		@return  <CODE>(new {@link RegexGroupExtractor#RegexGroupExtractor(RegexGroupExtractor_Fieldable) RegexGroupExtractor}(this))</CODE>
	 **/
	public X build()  {
		@SuppressWarnings("unchecked")
		X x = (X)new RegexGroupExtractor(this);
		return  x;
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
	public RegexGroupExtractor_CfgForNeeder<X,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	@SuppressWarnings("unchecked")  //See LLCfgOverall.startConfigReturnNeedable(R)
	public RegexGroupExtractor_CfgForNeeder<X,R> startConfigReturnNeedable(R needer)  {
		@SuppressWarnings("unchecked")
		Class<X> clsx = (Class<X>)(Class)RegexGroupExtractor.class;
		startConfig(needer, clsx);
		return  this;
	}
}
