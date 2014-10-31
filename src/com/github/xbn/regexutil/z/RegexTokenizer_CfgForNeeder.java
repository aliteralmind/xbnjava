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
	import  com.github.xbn.regexutil.RegexTokenizer;
	import  com.github.xbn.neederneedable.AbstractNeedable;
	import  com.github.xbn.neederneedable.Needer;
	import  com.github.xbn.lang.CrashIfObject;
	import  java.util.regex.Pattern;
/**
	<P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring a {@link com.github.xbn.regexutil.RegexTokenizer RegexTokenizer}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexTokenizer_CfgForNeeder<T extends RegexTokenizer,R extends Needer> extends AbstractNeedable<T,R> implements RegexTokenizer_Fieldable  {
	public Pattern    sepPtrn            = null ;
	public String     toTokenize         = null ;
	public int        lineNum            = -1   ;
	public boolean    doReturnSeps       = false;
	public boolean    doReturnBtwns      = false;
	public boolean    doReturnEmptyBtwns = false;
	public Appendable apblDebug          = null ;
	/**
		<P>Create a new instance with defaults.</P>

		<P>This calls<OL>
			<LI>{@link #lineNumber(int) lineNumber}{@code (-1)}</LI>
			<LI>{@link #setReturnSepsBtwns(boolean, boolean, boolean) setReturnSepsBtwns}{@code (false, false, false)}</LI>
			<LI>{@link #debugTo(Appendable) debugTo}{@code (null)}</LI>
			<LI>{@link #toTokenize(Object) toTokenize}{@code ("")}</LI>
		</OL></P>
	 **/
	public RegexTokenizer_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
		super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
		lineNumber(-1);
		setReturnSepsBtwns(false, false, false);
		debugTo(null);
		toTokenize("");
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> lineNumber(int line_num)  {
		lineNum = line_num;
		return  this;
	}
	public RegexTokenizer_CfgForNeeder<T,R> separatorsOnly()  {
		return  setReturnSepsBtwns(true, false, false);
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	protected RegexTokenizer_CfgForNeeder<T,R> setReturnSepsBtwns(boolean do_separators, boolean do_nonEmptyBtwns, boolean do_emptyBtwns)  {
		doReturnSeps = do_separators;
		doReturnBtwns = do_nonEmptyBtwns;
		doReturnEmptyBtwns = do_emptyBtwns;
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> separators()  {
		doReturnSeps = true;
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> nonEmptyBetweens()  {
		doReturnBtwns = true;
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> emptyBetweens()  {
		doReturnBtwns = true;
		return  this;
	}
	public RegexTokenizer_CfgForNeeder<T,R> allBetweens()  {
		nonEmptyBetweens();
		return  emptyBetweens();
	}
	public RegexTokenizer_CfgForNeeder<T,R> nonEmptyBetweensOnly()  {
		return  setReturnSepsBtwns(false, true, false);
	}
	public RegexTokenizer_CfgForNeeder<T,R> allBetweensOnly()  {
		return  setReturnSepsBtwns(false, true, true);
	}
	/**
		<P>Set debugging.</P>

		@param  dest_ifNonNull  When non-{@code null}, this is the destination to write debugging output (and debugging is turned {@link com.github.xbn.io.Debuggable#isDebugOn() on}). Get with {@link com.github.xbn.io.Debuggable#getDebugApbl() getDebugApbl}{@code ()}* and {@link com.github.xbn.io.Debuggable#getDebugAptr() getDebugAptr}{@code ()}*.
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> debugTo(Appendable dest_ifNonNull)  {
		apblDebug = dest_ifNonNull;
		return  this;
	}
	public Pattern getPattern()  {
		return  sepPtrn;
	}
	public String getToTokenize()  {
		return  toTokenize;
	}
	public int getLineNumber()  {
		return  lineNum;
	}
	public Appendable getDebugDestOnIfNonNull()  {
		return  apblDebug;
	}
	public boolean doReturnSeparators()  {
		return  doReturnSeps;
	}
	public boolean doReturnNonEmptyBetweens()  {
		return  doReturnBtwns;
	}
	public boolean doReturnEmptyBetweens()  {
		return  doReturnEmptyBtwns;
	}
	public RegexTokenizer_CfgForNeeder<T,R> separatorLiteral(String findWhat_literal)  {
		return  separator(NewPatternFor.literal(findWhat_literal, "findWhat_literal"));
	}
	public RegexTokenizer_CfgForNeeder<T,R> separator(String findWhat_regex)  {
		return  separator(NewPatternFor.regex(findWhat_regex, "findWhat_regex"));
	}
	public RegexTokenizer_CfgForNeeder<T,R> separator(String findWhat_regex, int bit_flags)  {
		return  separator(NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"));
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> separator(Pattern pattern_toFind)  {
		sepPtrn = pattern_toFind;
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	public RegexTokenizer_CfgForNeeder<T,R> toTokenize(Object to_tokenize)  {
		try  {
			toTokenize = to_tokenize.toString();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_tokenize, "to_tokenize", null, rx);
		}
		return  this;
	}
	public T build()  {
		@SuppressWarnings("unchecked")
		T t = (T)new RegexTokenizer(this);
		return  t;
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
	public RegexTokenizer_CfgForNeeder<T,R> chainID(boolean do_setStatic, Object id)  {
		setChainID(do_setStatic, id);
		return  this;
	}
	/**
		@return  <I>{@code this}</I>
	 **/
	@SuppressWarnings("unchecked")  //See LLCfgOverall.startConfigReturnNeedable(R)
	public RegexTokenizer_CfgForNeeder<T,R> startConfigReturnNeedable(R needer)  {
		@SuppressWarnings("unchecked")
		Class<T> clsx = (Class<T>)(Class)RegexTokenizer.class;
		startConfig(needer, clsx);
		return  this;
	}
}
