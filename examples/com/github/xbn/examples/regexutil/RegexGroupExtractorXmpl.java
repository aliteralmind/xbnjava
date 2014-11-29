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
	import  java.util.List;
	import  com.github.xbn.regexutil.RegexGroupExtractor;
	import  com.github.xbn.regexutil.z.RegexGroupExtractor_Cfg;
/**
	<p>Uses {@code com.github.xbn.regexutil.}{@link com.github.xbn.regexutil.RegexGroupExtractor RegexGroupExtractor} to extract the return-type, function-name, and all parameters from a series of function signature lines.</p>

	<p>{@code java com.github.xbn.examples.regexutil.RegexGroupExtractorXmpl}</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class RegexGroupExtractorXmpl  {
	public static final void main(String[] ignored)  {

		//Setup
			String LINE_SEP = System.getProperty("line.separator", "\\n");

			String sToSearch = (new StringBuilder()).
				append("public class SetGetInt  {"     ).append(LINE_SEP).
				append("   private int i = -1;"        ).append(LINE_SEP).
				append("   public SetGetInt(int i_i, boolean b_anotherParam)  {").append(LINE_SEP).
				append("      set(i_i);"               ).append(LINE_SEP).
				append("   }"                          ).append(LINE_SEP).
				append("   public void set(int i_i)  {").append(LINE_SEP).
				append("      i = i_i;"                ).append(LINE_SEP).
				append("   }"                          ).append(LINE_SEP).
				append("   public int get()  {"        ).append(LINE_SEP).
				append("      return  i;"              ).append(LINE_SEP).
				append("   }"                          ).append(LINE_SEP).
				append("}"                             ).append(LINE_SEP).toString();

		String sRegexFuncRetTypNmAllParams = (new StringBuilder()).
			append("\\s+\\b"               ).
			append("([\\w.]+)"             ). //Return type
			append("\\b(?:<[^>]+>)?\\s+\\b").
			append("([\\w.]+)"             ). //Function name
			append("\\b\\("                ).
			append("([^\\)\\n\\r]*)"       ). //All parameters
			append("\\)"                   ).toString();

		RegexGroupExtractor rgxFuncRetNamParams = new RegexGroupExtractor_Cfg().
			pattern(sRegexFuncRetTypNmAllParams).
			build().search(sToSearch);

		System.out.println("Return type  |  Function name  |  All parameters");
		System.out.println("------------------------------------------------");
		while(rgxFuncRetNamParams.hasNext())  {
			List<String> ls = rgxFuncRetNamParams.next();
			System.out.println(ls.get(0) + "  |  " + ls.get(1) + "  |  " + ls.get(2));
		}
	}
}
