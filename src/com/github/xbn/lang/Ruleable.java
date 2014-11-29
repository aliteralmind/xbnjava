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
package  com.github.xbn.lang;
/**
	<p>{@code Ruleable}s have zero or more restrictions to impose on something else.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface Ruleable extends ToStringAppendable  {
	/**
		<p>Get the rules of this class in a concise format.</p>

		@return  <code>{@link #appendRules(StringBuilder) appendRules}(new StringBuilder()).toString()</code>
	 **/
	String getRules();
	/**
		<p>Append the rules in a concise format.</p>

		@param  to_appendTo  May not be {@code null}.
	 **/
	StringBuilder appendRules(StringBuilder to_appendTo);
	/**
		<p>What level of restrictive-ness is this ruleable?</p>

		@return  <ul>
			<li>{@code RuleType.}{@link com.github.xbn.lang.RuleType#UNRESTRICTED UNRESTRICTED}: If it is impossible for the rules to <i>not</i> be followed.</li>
			<li>{@code RuleType.}{@link com.github.xbn.lang.RuleType#RESTRICTED RESTRICTED}: If the rules may or may not be followable.</li>
			<li>{@code RuleType.}{@link com.github.xbn.lang.RuleType#IMPOSSIBLE IMPOSSIBLE}: If it is impossible for the rules to be followed.</li>
		</ul>
	 **/
	RuleType getRuleType();
}
