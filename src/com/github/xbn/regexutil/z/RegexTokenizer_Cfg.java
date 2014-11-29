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
	import  com.github.xbn.regexutil.RegexTokenizer;
	import  java.util.regex.Pattern;
	import  com.github.xbn.neederneedable.DummyForNoNeeder;
/**
	<p>For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</a> configuring a {@link com.github.xbn.regexutil.RegexReplacer RegexReplacer}.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
/**
	<p>. For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</a> configuring a {@link RegexTokenizer}.</p>
 **/
public class RegexTokenizer_Cfg extends RegexTokenizer_CfgForNeeder<RegexTokenizer,DummyForNoNeeder>  {
	public RegexTokenizer_Cfg()  {
		super(false, true, null);
	}
	public RegexTokenizer_Cfg(Pattern separator_regex)  {
		super(false, true, null);
		separator(separator_regex);
	}
	public RegexTokenizer_Cfg(Pattern separator_regex, String to_tokenize)  {
		super(false, true, null);
		separator(separator_regex);
		toTokenize(to_tokenize);
	}
	public RegexTokenizer_Cfg(String separator_regex)  {
		super(false, true, null);
		separator(separator_regex);
	}
	public RegexTokenizer_Cfg(String separator_regex, String to_tokenize)  {
		super(false, true, null);
		separator(separator_regex);
		toTokenize(to_tokenize);
	}
	public RegexTokenizer_Cfg(String separator_regex, int bit_flags)  {
		super(false, true, null);
		separator(separator_regex, bit_flags);
	}
	public RegexTokenizer_Cfg(String separator_regex, int bit_flags, String to_tokenize)  {
		super(false, true, null);
		separator(separator_regex, bit_flags);
		toTokenize(to_tokenize);
	}
}
