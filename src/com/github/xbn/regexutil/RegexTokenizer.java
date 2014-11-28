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
	import  com.github.xbn.io.SimpleDebuggable;
	import  com.github.xbn.lang.Copyable;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.IllegalArgumentStateException;
	import  com.github.xbn.regexutil.z.RegexTokenizer_Fieldable;
	import  java.util.Iterator;
	import  java.util.NoSuchElementException;
	import  java.util.regex.Matcher;
	import  java.util.regex.Pattern;
/**
	<P>Splits a string based on a regular-expression separator, returning the matches, &quot;betweens&quot;, or both.</P>

	<P><I>Derived from {@code RETokenize}: <a href="http://www.exampledepot.com/egs/java.util.regex/Tokenize.html">{@code http://www.exampledepot.com/egs/java.util.regex/Tokenize.html}</a>, downloaded 8/13/2010.</I></P>

	<A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.regexutil.z.RegexTokenizer_Cfg RegexTokenizer_Cfg}</H3>

	<P><UL>
		<LI><B>Regex separator:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#separator(Pattern) separator}(p)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#separator(String, int) separator}(s,i)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#separator(String) separator}(s)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#separatorLiteral(String) separatorLiteral}(s)</CODE></LI>
		<LI><B>What to return:</B><UL>
			<LI><B>Only:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#allBetweensOnly() allBetweensOnly}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#nonEmptyBetweensOnly() nonEmptyBetweensOnly}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#separatorsOnly() separatorsOnly}()</CODE></LI>
			<LI><B>Non-only:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#separators() separators}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#emptyBetweens() emptyBetweens}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#nonEmptyBetweens() nonEmptyBetweens}()</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#allBetweens() allBetweens}()</CODE></LI>
		</UL></LI>
		<LI><B>Other:</B> <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#toTokenize(Object) toTokenize}(o)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#lineNumber(int) lineNumber}(i)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#debugTo(Appendable) debugTo}(apbl)</CODE>, <CODE>{@link com.github.xbn.regexutil.z.RegexTokenizer_CfgForNeeder#chainID(boolean, Object) chainID}(b,o)</CODE></LI>
	</UL></P>

{@.codelet.and.out com.github.xbn.examples.regexutil.TemplateTokenizer%eliminateCommentBlocksAndPackageDecl()}


{@.codelet.and.out com.github.xbn.examples.regexutil.RegexTokenizerXmpl%eliminateCommentBlocksAndPackageDecl()}

<P>An interesting problem solved with both java.util.regex and {@code RegexTokenizer}. From (viewed 12/31/2013)
<BR> &nbsp; &nbsp; {@code <A HREF="http://stackoverflow.com/questions/20859278/regex-split-up-parentheses-group">http://stackoverflow.com/questions/20859278/regex-split-up-parentheses-group</A>}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexTokenizer extends SimpleDebuggable implements Iterator<TokenizerElement>, Copyable, PatternHaser  {
//config: immutable
	private final SimplePatternHaser sph;
//config: mutable
	private int     iLnNum    = -1   ;
	private boolean bRtnSep   = false;
	private boolean bRtnNEBtw = false;
	private boolean bRtnEBtw  = false;
//state...START
	private String    sOrig            = null;
	private Matcher   m                = null;
	private TokenizerElement rteNextBetween   = null;
	private TokenizerElement rteNextSeparator = null;

	//Wanted to replace this with rteNextSeparator.getIdxEndX(), but that
	//wouldn't exist for a moment after calling next()
	private int ixLastMEnd = 0;
//state...END
//internal
	/**
		<P>Create a new regex tokenizer, where every match is manipulated before returned by {@code next()}.</P>

		@param  fieldable  May not be {@code null}.
	 **/
	public RegexTokenizer(RegexTokenizer_Fieldable fieldable)  {
		iLnNum = fieldable.getLineNumber();
		bRtnSep   = fieldable.doReturnSeparators();
		bRtnNEBtw = fieldable.doReturnNonEmptyBetweens();
		bRtnEBtw  = fieldable.doReturnEmptyBetweens();

		if(!bRtnSep  &&  !bRtnNEBtw  &&  !bRtnEBtw)  {
			throw  new IllegalArgumentStateException("fieldable.doReturnSeparators(), fieldable.doReturnNonEmptyBetweens(), and fieldable.doReturnEmptyBetweens() are all false. Nothing to do.");
		}

		sph = (new SimplePatternHaser()).pattern(fieldable.getPattern(), "fieldable.getPattern()").
			matcherUses(MatcherUses.FIND);

		sOrig = fieldable.getToTokenize();
		try  {
			m = getPattern().matcher(sOrig);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(sOrig, "fieldable.getToTokenize()", null, rx);
		}
		setDebug(fieldable.getDebugDestOnIfNonNull(), (fieldable.getDebugDestOnIfNonNull() != null));


		initState();
		hasNext();
	}
		private void initState()  {
			rteNextBetween = null;
			rteNextSeparator = null;
			ixLastMEnd = 0;
			sph.declareNotMatched();
		}
	public RegexTokenizer(RegexTokenizer to_copy)  {
		this(to_copy, (Pattern)null, null, -1);
	}

	public RegexTokenizer(RegexTokenizer to_copy, String findWhat_regex, Object string_toSearch, int line_num)  {
		this(to_copy, NewPatternFor.regex(findWhat_regex, "findWhat_regex"), string_toSearch, line_num);
	}
	public RegexTokenizer(RegexTokenizer to_copy, String findWhat_regex, int bit_flags, Object string_toSearch, int line_num)  {
		this(to_copy, NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"), string_toSearch, line_num);
	}

	/**
		<P>Create a new {@code RegexTokenizer} as a duplicate of another, but for a new search-string. This leaves debugging on, if it is already on in the original. This goes against the "exception".......................</P>

		@param  to_copy  May not be {@code null}.
	 **/
	public RegexTokenizer(RegexTokenizer to_copy, Pattern new_findWhat, Object string_toSearch, int line_num)  {
		super(to_copy);
		try  {
			bRtnSep = to_copy.bRtnSep;
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}

		bRtnNEBtw = to_copy.bRtnNEBtw;
		bRtnEBtw = to_copy.bRtnEBtw;

		sph = (new SimplePatternHaser(to_copy, new_findWhat));

		iLnNum = line_num;
		sOrig = ((string_toSearch == null) ? to_copy.getOriginal() : string_toSearch.toString());
		m = getPattern().matcher(sOrig);

		initState();
		hasNext();
	}
	public void setNewSearch(Object string_toSearch, int line_num)  {
		iLnNum = line_num;
		try  {
			sOrig = string_toSearch.toString();
		}  catch(RuntimeException rx)  {
			throw  new NullPointerException("string_toSearch");
		}
		m.reset(sOrig);

		initState();
		hasNext();
	}
	public void setNewSearch(Pattern find_whatPtrn, Object string_toSearch, int line_num)  {
		sph.pattern(find_whatPtrn, "find_whatPtrn");

		iLnNum = line_num;
		try  {
			sOrig = string_toSearch.toString();
		}  catch(RuntimeException rx)  {
			throw  new NullPointerException("string_toSearch");
		}
		m = getPattern().matcher(sOrig);

		initState();
		hasNext();
	}
	public void setNewSearch(String findWhat_regex, Object string_toSearch, int line_num)  {
		setNewSearch(NewPatternFor.regex(findWhat_regex, "findWhat_regex"), string_toSearch, line_num);
	}
	public void setNewSearch(String findWhat_regex, int bit_flags, Object string_toSearch, int line_num)  {
		setNewSearch(NewPatternFor.regex(findWhat_regex, bit_flags, "findWhat_regex"), string_toSearch, line_num);
	}
	public void setNewSearchLiteral(String findWhat_literal, Object string_toSearch, int line_num)  {
		setNewSearch(NewPatternFor.literal(findWhat_literal, "findWhat_literal"), string_toSearch, line_num);
	}
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
			<P>Should the string be matched as a whole?. Should <CODE><I>[{@link java.util.regex.Matcher}]</I>.{@link java.util.regex.Matcher#matches() matches}()</CODE> be used?.</P>

			@return  {@code true}  The string is matched as a whole.
			@see  com.github.xbn.regexutil.z.RegexGroupExtractor_Cfg#useMatches() Cfg.useMatches()
			@see  com.github.xbn.regexutil.z.RegexGroupExtractor_Cfg#useFind() Cfg.useFind()
			@see  com.github.xbn.regexutil.z.RegexGroupExtractor_Cfg#useLookingAt() Cfg.useLookingAt()
		 **/
		public MatcherUses getMatcherUses()  {
			return  sph.getMatcherUses();
		}
	//Composition implementation: null...END
	/**
		<P>Get the original string-to-tokenize.</P>

		@return  <B>{@code string_toSearch}</B>, as provided to the constructor.
	 **/
	public final String getOriginal()  {
		return  sOrig;
	}
	/**
		<P>Are regex-separators retrieved?.</P>
	 **/
	public final boolean doReturnSeparators()  {
		return  bRtnSep;
	}
	/**
		<P>Are betweens retrieved?.</P>
	 **/
	public final boolean doReturnNonEmptyBetweens()  {
		return  bRtnNEBtw;
	}
	/**
		<P>Are empty-string betweens retrieved?.</P>
	 **/
	public final boolean doReturnEmptyBetweens()  {
		return  bRtnEBtw;
	}
	/**
		<P>Is there another token (match) or between to get?.</P>

		@return  <B>{@code true}</B>  If there is another match or between remaining in the {@link #getOriginal() string-to-tokenize}, and it is wanted.
	 **/
	public final boolean hasNext() {
		if (rteNextBetween != null  ||  rteNextSeparator != null) {
			return  true;
		}

		if (m == null) {
			return  false;
		}

		sph.declareNotMatched();
		int i2tLen = getOriginal().length();

		if (m.find()) {
			sph.matchedIndex(m.start());
			if (doReturnNonEmptyBetweens()) {
				String sBt = getOriginal().subSequence(ixLastMEnd, m.start()).toString();
				if(sBt.length() != 0  ||  doReturnEmptyBetweens())  {
					rteNextBetween = new TokenizerElement(iLnNum, false, ixLastMEnd, sBt, isDebugOn(), getDebugAptr());
				}
			}

			if (doReturnSeparators()) {
				rteNextSeparator = new TokenizerElement(iLnNum, true, m.start(), m.group(), isDebugOn(), getDebugAptr());
			}
			ixLastMEnd = m.end();

		} else if (doReturnNonEmptyBetweens() && ixLastMEnd < i2tLen) {
			//The very last one :)
			String sBt = getOriginal().subSequence(ixLastMEnd, i2tLen).toString();

			rteNextBetween = new TokenizerElement(iLnNum, false, ixLastMEnd, sBt, isDebugOn(), getDebugAptr());

			ixLastMEnd = i2tLen;
			// Need to remove the m since it appears to automatically
			// reset itself once it reaches the end.
			m = null;
		}
		return  !(rteNextBetween == null  &&  rteNextSeparator == null);
	}
	/**
		<P>Get the next regex-match or between.</P>

		@exception  NoSuchElementException  If {@link #hasNext() hasNext}{@code ()} is false.
		@see  #isNextASeparator()
		@see  #isNextABetween()
	 **/
	public final TokenizerElement next() {
		TokenizerElement rte = null;

		if(rteNextBetween != null) {
			rte = rteNextBetween;
			rteNextBetween = null;
		} else if (rteNextSeparator != null) {
			rte = rteNextSeparator;
			rteNextSeparator = null;
		}  else  {
			throw  new NoSuchElementException("next");
		}

		hasNext();

		return  rte;
	}
	/**
		<P>Is the next token a regex-match?.</P>
		@see  #next()
		@see  #isNextABetween()
	 **/
	public boolean isNextASeparator() {
		return  (rteNextBetween == null  &&  rteNextSeparator != null);
	}
	/**
		<P>Is the next token a between?.</P>
		@see  #next()
		@see  #isNextASeparator()
	 **/
	public boolean isNextABetween() {
		//Betweens have precedence
		return  (rteNextBetween != null);
	}
	public String toString()  {
		return  "doReturnSeparators()=" + doReturnSeparators() + ", doReturnNonEmptyBetweens()=" + doReturnNonEmptyBetweens() + ", doReturnEmptyBetweens()=" + doReturnEmptyBetweens();
	}
	/**
		<P>Unsupported.</P>

		@exception  UnsupportedOperationException
	 **/
	public final void remove() {
		throw  new UnsupportedOperationException("remove");
	}
	/**
		<P>Duplicate this <CODE>RegexTokenizer</CODE>.</P>

		@return  <CODE>(new <A HREF="#RegexTokenizer(RegexTokenizer)">RegexTokenizer</A>(this))</CODE>
	 **/
	public RegexTokenizer getObjectCopy()  {
		return  (new RegexTokenizer(this));
	}
}
