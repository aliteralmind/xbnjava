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
package  com.github.xbn.examples.regexutil;
	import  com.github.xbn.regexutil.IndirectRegexReplacer;
/**
	<P>Example code from {@code e.util.}{@link com.github.xbn.regexutil.Rewriter Rewriter}, refitted to work with {@code com.github.xbn.regexutil.}{@link com.github.xbn.regexutil.IndirectRegexReplacer IndirectRegexReplacer}.</P>

	<P>{@code java com.github.xbn.examples.regexutil.RegexReplacerXmplsFromRewriter}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexReplacerXmplsFromRewriter  {
	public static void main(String[] ignored)  {

	 // Rewrite an ancient unit of length in SI units.
	 String result = new IndirectRegexReplacer("([0-9]+(\\.[0-9]+)?)[- ]?(inch(es)?)") {
		  public String getIndirectReplacement() {
				float inches = Float.parseFloat(getGroup(1));
				return Float.toString(2.54f * inches) + " cm";
		  }
	 }.getReplaced("a 17 inch display");
	 System.out.println(result);

	 // The "Searching and Replacing with Non-Constant Values Using a
	 // Regular Expression" example from the Java Almanac.
	 result = new IndirectRegexReplacer("([a-zA-Z]+[0-9]+)") {
		  public String getIndirectReplacement() {
				return getGroup(1).toUpperCase();
		  }
	 }.getReplaced("ab12 cd efg34");
	 System.out.println(result);

	 result = new IndirectRegexReplacer("([0-9]+) US cents") {
		  public String getIndirectReplacement() {
				long dollars = Long.parseLong(getGroup(1))/100;
				return "$" + dollars;
		  }
	 }.getReplaced("5000 US cents");
	 System.out.println(result);
	}
}
