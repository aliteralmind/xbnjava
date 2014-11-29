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
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.testdev.CompositionFunction;
	import  java.util.regex.Pattern;
/**
	<p>Rudimentary implementation of {@code PatternHaser} with mutable fields.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SimplePatternHaser implements PatternHaser  {
//config
	private Pattern     p      ;
	private int         matchIdx;
	private int         matchCount;
	private MatcherUses mu     ;

	public SimplePatternHaser()  {
		p      = null ;
		mu     = null ;
		declareNotMatched();
		resetMatchCount();
	}
	public SimplePatternHaser(PatternHaser to_copy)  {
		this(to_copy, null);
	}
	public SimplePatternHaser(PatternHaser to_copy, Pattern newPtrn_ifNonNull)  {
		try  {
			p = RegexUtil.getPatternCopyOrNewIfNNull(to_copy.getPattern(), newPtrn_ifNonNull);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}
		matchIdx = to_copy.getMatchedIndex();
		matchCount = to_copy.getMatchCount();
		mu = to_copy.getMatcherUses();
	}
	public SimplePatternHaser pattern(Pattern pattern_toFind)  {
		return  pattern(pattern_toFind, "pattern_toFind");
	}
	public SimplePatternHaser pattern(Pattern pattern_toFind, String ptrn_name)  {
		if(pattern_toFind == null)  {
			throw  new NullPointerException(ptrn_name);
		}
		p = pattern_toFind;
		return  this;
	}
	public SimplePatternHaser declareNotMatched()  {
		matchIdx = -1;
		return  this;
	}
	public SimplePatternHaser matchedIndex(int index)  {
		if(index < -1)  {
			throw  new IllegalArgumentException("index (" + index + ") is less than -1.");
		}
		matchIdx = index;
		matchCount++;
		return  this;
	}
	public SimplePatternHaser matcherUses(MatcherUses uses)  {
		return  matcherUses(uses, "uses");
	}
	public SimplePatternHaser matcherUsesFromReplacedInEachInputWhat(ReplacedInEachInput what)  {
		return  matcherUses(ReplacedInEachInput.getMatcherUsesFrom(what));
	}
	public SimplePatternHaser matcherUses(MatcherUses uses, String mu_name)  {
		if(uses == null)  {
			throw  new NullPointerException(mu_name);
		}
		mu = uses;
		return  this;
	}

	@CompositionFunction
	public Pattern getPattern()  {
		return  p;
	}
	@CompositionFunction
	public int getMatchedIndex()  {
		return  matchIdx;
	}
	@CompositionFunction
	public int getMatchCount()  {
		return  matchCount;
	}
	public void resetMatchCount()  {
		matchCount = 0;
	}
	public boolean wasJustMatched()  {
		return  (getMatchedIndex() != -1);
	}
	@CompositionFunction
	public MatcherUses getMatcherUses()  {
		return  mu;
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  to_appendTo.append("getMatchedIndex()=").append(getMatchedIndex()).
			append(", getMatcherUses()=").append(getMatcherUses()).
			append(", getPattern()=[").append(getPattern()).append("]");
	}
}
