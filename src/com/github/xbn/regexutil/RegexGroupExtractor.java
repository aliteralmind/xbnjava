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
	import  com.github.xbn.regexutil.z.RegexGroupExtractor_Fieldable;
	import  java.io.IOException;
	import  java.util.ArrayList;
	import  java.util.List;
	import  java.util.NoSuchElementException;
	import  java.util.regex.Matcher;
	import  java.util.regex.Pattern;
	import  org.apache.commons.lang3.StringUtils;
	import  com.github.xbn.io.IOUtil;
	import  com.github.xbn.io.RTIOException;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.Copyable;
	import  com.github.xbn.util.BitBinaryUtil;
	import  com.github.xbn.util.itr.AbstractIterator;
/**
	<p>Iterates through a search string, placing all capture-groups for each match into a list. This is intended for capture groups that are mutually-exclusive (do not overlap).</p>

{@.codelet.and.out com.github.xbn.examples.regexutil.RegexGroupExtractorXmpl%eliminateCommentBlocksAndPackageDecl()}

	<A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.regexutil.z.RegexGroupExtractor_Cfg RegexGroupExtractor_Cfg}</h3>

	<p><ul>
		<li><b>Using:</b> <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#useMatches() useMatches}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#useFind() useFind}()</code>, <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#useLookingAt() useLookingAt}()</code></li>
		<li><b>Pattern:</b> <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#pattern(String) pattern}(s)</code>, <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#pattern(String, int) pattern}(s,i)</code>, <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#pattern(Pattern) pattern}(p)</code></li>
		<li><b>Other:</b> <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#requiredGroups(int) requiredGroups}(i)</code>, <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#chainID(boolean, Object) chainID}(b,o)</code></li>
	</ul></p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RegexGroupExtractor extends AbstractIterator<List<String>> implements Copyable, PatternHaser   {
//state: immutable
	private final int                iRqdGrps;
	private final SimplePatternHaser sph     ;
//state: mutable
	private ArrayList<String> alGroups = null ;
	private Matcher           m        = null ;
//internal
//constructors...START
	/**
		<p>Create a new instance with a pattern <i>that contains groups</i>.</p>

		@param  fieldable  May not be <code>null</code>.
		@see  #RegexGroupExtractor(RegexGroupExtractor, String) this(rgx,s)
		@see  #RegexGroupExtractor(RegexGroupExtractor) this(rgx)
		@see  #RegexGroupExtractor(RegexGroupExtractor, String) this(rgx,s)
		@see  #RegexGroupExtractor(RegexGroupExtractor, Pattern) this(rgx,p)
	 **/
	public RegexGroupExtractor(RegexGroupExtractor_Fieldable fieldable)  {

		iRqdGrps = fieldable.getRequiredGroups();
		if(iRqdGrps < 1  &&  iRqdGrps != -1)  {
			throw  new IllegalArgumentException("fieldable.getRequiredGroups() (" + iRqdGrps + ") must be -1 or greater than zero.");
		}

		sph = (new SimplePatternHaser()).pattern(fieldable.getPattern(), "fieldable.getPattern()").
			matcherUses(fieldable.getMatcherUses(), "fieldable.getMatcherUses()");
		getMatcherUses().crashIfForbiddenValue(MatcherUses.CUSTOM, "fieldable.getMatcherUses()", null);

		                  //Search the empty-string
		                  //So matcher can be reused (reset)
		m = getPattern().matcher("");

		if(BitBinaryUtil.doesIntHaveBit(getPattern().flags(), Pattern.LITERAL))  {
			throw  new IllegalArgumentException("fieldable.getPattern() contains Pattern.LITERAL.");
		}
	}
	/**
		<p>Create a new instance as a duplicate of another, with a new regex.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link #RegexGroupExtractor(RegexGroupExtractor, Pattern) this}(to_copy, {@link NewPatternFor}.{@link NewPatternFor#regex(String, String) regex}(regex_withGroups))</code></p>

		@param  regex_withGroups  May not be <code>null</code>.
	 **/
	public RegexGroupExtractor(RegexGroupExtractor to_copy, String regex_withGroups)  {
		this(to_copy, NewPatternFor.regex(regex_withGroups, "regex_withGroups"));
	}
	public RegexGroupExtractor(RegexGroupExtractor to_copy, String regex_withGroups, int bit_flags)  {
		this(to_copy, NewPatternFor.regex(regex_withGroups, bit_flags, "regex_withGroups"));
	}
	/**
		<p>Create a new instance as a duplicate of another.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link #RegexGroupExtractor(RegexGroupExtractor, Pattern) this}(to_copy, {@link RegexUtil}.{@link RegexUtil#getPatternCopy(PatternHaser, String) getPatternCopy}(to_copy, ...))</code></p>

		@param  to_copy  May not be <code>null</code>.
	 **/
	public RegexGroupExtractor(RegexGroupExtractor to_copy)  {
		this(to_copy, RegexUtil.getPatternCopy(to_copy, "to_copy"));
	}
	/**
		<p>Create a new instance as a duplicate of another, with a new pattern.</p>

		@param  to_copy  May not be <code>null</code>.
		@param  ptrn_withGroups  If <code>null</code>, the <a href="#getPattern()">pattern</a> in <code>to_copy</code> is duplicated. If non-{@code null}, this is expected to have at least one group. If <code>to_copy.{@link #getRequiredGroupCount() getRequiredGroupCount}()</code> is not {@code -1}, this must contain exactly that number of groups. Get with {@link #getPattern() getPattern}{@code ()}.
		@see  #RegexGroupExtractor(RegexGroupExtractor, Pattern) this(rgx, p)
	 **/
	public RegexGroupExtractor(RegexGroupExtractor to_copy, Pattern ptrn_withGroups)  {
		sph = new SimplePatternHaser(to_copy, ptrn_withGroups);
		iRqdGrps = to_copy.getRequiredGroupCount();
		m = getPattern().matcher("");
	}
//constructors...END
//getters...START
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
			<p>Should the string be matched as a whole?. Should <code><i>[{@link java.util.regex.Matcher}]</i>.{@link java.util.regex.Matcher#matches() matches}()</code> be used?.</p>

			@return  A non-null {@link MatcherUses} that defines what is matched in each iteration.
			@see  com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#useMatches() Cfg.useMatches()
			@see  com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#useFind() Cfg.useFind()
			@see  com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#useLookingAt() Cfg.useLookingAt()
		 **/
		public MatcherUses getMatcherUses()  {
			return  sph.getMatcherUses();
		}
	//Composition implementation: null...END
	/**
		<p>How many groups are required in the pattern?.</p>

		@return  <ul>
			<li>{@code -1}:  At least one group is required.</li>
			<li>A number greater than zero: That exact number of groups is required.</li>
		</ul><b>Set by:</b> <code>{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder Cfg}.{@link com.github.xbn.regexutil.z.RegexGroupExtractor_CfgForNeeder#requiredGroups(int) requiredGroups}(i)</code>
	 **/
	public int getRequiredGroupCount()  {
		return  iRqdGrps;
	}
//getters...END
	/**
		<p>Set the string to be searched. If {@link #getMatcherUses() getMatcherUses}{@code ()} is true, follow this with a call to {@link #next() next}{@code ()}.</p>

		@param  to_search  May not be <code>null</code>.
	 **/
	public RegexGroupExtractor search(String to_search)  {
		try  {
			m.reset(to_search);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_search, "to_search", null, rx);
		}

		//Assume no match
		sph.declareNotMatched();

		if(getMatcherUses().isMatches())  {
			if(!m.matches())  {
				alGroups = null;
				return this;
			}
			addGroupsToNewList();
			m = null;
			return  this;

		}  else if(getMatcherUses().isFind())  {
			if(!m.find())  {
				alGroups = null;
				return this;
			}
		}  else if(getMatcherUses().isLookingAt())  {
			if(!m.lookingAt())  {
				alGroups = null;
				return this;
			}
		}

		//Matched
		sph.matchedIndex(m.start());
		addGroupsToNewList();
		return  this;
	}
		private void addGroupsToNewList()  {
			if(alGroups != null)  {
				throw  new IllegalStateException("(alGroups != null)");
			}
			int iGrps = m.groupCount();
			if(iGrps == 0)  {
				throw  new IllegalArgumentException("Pattern has no capture groups.");
			}
			alGroups = new ArrayList<String>(iGrps);
			for(int i = 1; i <= m.groupCount(); i++)  {
				alGroups.add(m.group(i));
			}
			if(getRequiredGroupCount() != -1  &&  iGrps != getRequiredGroupCount())  {
				throw  new IllegalArgumentException("Actual group count=" + iGrps + ", getRequiredGroupCount()=" + getRequiredGroupCount() + ", All-groups:[" + nextAsJoined("  //  ") + "]");
			}
		}
	public boolean hasNext()  {
		return  (alGroups != null);
	}
	/**
		<p>Returns all groups in the next iteration concatenated into a single string--for debugging and testing.</p>

		@return  <code>{@link org.apache.commons.lang3.StringUtils StringUtils}*.{@link org.apache.commons.lang3.StringUtils#join(Iterable, String) join}({@link #next() next}(), separator)</code>
	 **/
	public String nextAsJoined(String separator)  {
		return  StringUtils.join(next(), separator);
	}
	/**
		<p>Append the next set of groups, joined into a single string, and followed by a new-line--for debugging and testing.</p>

		@return  <code>{@link #appendNextAsJoinedlns(int, Appendable, String) appendNextAsJoinedlns}(1, to_appendTo, separator)</code>
	 **/
	public Appendable appendNextAsJoinedln(Appendable to_appendTo, String separator)  {
		return  appendNextAsJoinedlns(1, to_appendTo, separator);
	}
	/**
		<p>Append the next set of groups, joined into a single string and followed by some new-lines--for debugging and testing.</p>

		<p>This<ol>
			<li>Calls
			<br/> &nbsp; &nbsp; <code>to_appendTo.append({@link #nextAsJoined(String) nextAsJoined}(separator))</code></li>
			<li><i><b>Returns</b></i>
			<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.io.IOUtil IOUtil}.{@link com.github.xbn.io.IOUtil#appendNewLinesX(int, Appendable) appendNewLinesX}(new_lineCount, to_appendTo)</code></li>
		</ol></p>

		@exception  RTIOException  If a {@code java.io.IOException} is thrown for any reason.
	 **/
	public Appendable appendNextAsJoinedlns(int new_lineCount, Appendable to_appendTo, String separator)  {
		try  {
			to_appendTo.append(nextAsJoined(separator));
			return  IOUtil.appendNewLinesX(new_lineCount, to_appendTo);
		}  catch(IOException iox)  {
			throw  new RTIOException("appendNextAsJoinedlns", iox);
		}
	}
	/**
		<p>Get the list containing all groups in the next iteration.</p>

		@see  #nextAsJoined(String) nextAsJoined(s)
		@exception  NoSuchElementException  If {@link #hasNext() hasNext}{@code ()} is {@code false}.
	 **/
	public List<String> next()  {
		if(!hasNext())  {
			throw  new NoSuchElementException("hasNext() is false. Must search(s).");
		}

		List<String> lg2Ret = alGroups;
		alGroups = null;

		if(m.find())  {
			addGroupsToNewList();
		}

		return  lg2Ret;
	}
	/**
		<p>Duplicate this <code>RegexGroupExtractor</code>, where all internal fields are duplicateted, and the search is started anew.</p>

		@return  <code>(new {@link #RegexGroupExtractor(RegexGroupExtractor) RegexGroupExtractor}(this))</code>
	 **/
	public RegexGroupExtractor getObjectCopy()  {
		return  (new RegexGroupExtractor(this));
	}
}
