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
package  com.github.xbn.examples.linefilter;
	import  com.github.xbn.analyze.alter.AlterationRequired;
	import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
	import  com.github.xbn.linefilter.FilteredLineIterator;
	import  com.github.xbn.linefilter.Returns;
	import  com.github.xbn.linefilter.alter.NewTextLineAltererFor;
	import  com.github.xbn.linefilter.alter.TextLineAlterer;
	import  com.github.xbn.linefilter.entity.BlockEntity;
	import  com.github.xbn.linefilter.entity.EndRequired;
	import  com.github.xbn.linefilter.entity.z.BlockEntity_Cfg;
	import  com.github.xbn.regexutil.IndirectRegexReplacer;
	import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
	import  com.github.xbn.text.StringUtil;
/**
	<p>Demonstrates using {@link com.github.xbn.linefilter.FilteredLineIterator} to make arbitrary modifications to kept lines.</p>

	<p>{@code java com.github.xbn.examples.linefilter.MoreComplicatedModifyExample}</p>

	@see  <code><a href="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_modify">{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_modify</a></code>
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class MoreComplicatedModifyExample  {
	public static final void main(String[] ignored)  {
		//Example setup
			String LINE_SEP = System.getProperty("line.separator", "\r\n");
			StringBuilder input = new StringBuilder().
				append("before1"          ).append(LINE_SEP).
				append("before2"          ).append(LINE_SEP).
				append("Block starts here").append(LINE_SEP).
				append("mid1"             ).append(LINE_SEP).
				append("mid2"             ).append(LINE_SEP).
				append("Block ends here"  ).append(LINE_SEP).
				append("after1"           ).append(LINE_SEP).
				append("after2"           ).append(LINE_SEP);

		//Example proper:

		IndirectRegexReplacer replaceNumWithStrNum = new IndirectRegexReplacer(
			new RegexReplacer_Cfg().findWhat("(.*)").first())  {
				public String getIndirectReplacement()  {

					String match = getGroup(1);
					String preNum = match.substring(0, match.length() - 1);
					String numStr = new Character(match.charAt(match.length() - 1)).toString();
					int num = Integer.parseInt(numStr);

					switch(num)  {
						case  1:  return  preNum + "ONE";
						case  2:  return  preNum + "TWO";
					}
					throw  new IllegalStateException("Unknown number in match: \"" + match + "\"");
				}
		};

		TextLineAlterer midAlterer = AdaptRegexReplacerTo.
			lineReplacer(AlterationRequired.YES, replaceNumWithStrNum, null);

		TextLineAlterer startIdOnly = NewTextLineAltererFor.
			textValidateOnly("start", null,
			null);            //debug (on:System.out, off:null)
		TextLineAlterer endIdOnly = NewTextLineAltererFor.
			textValidateOnly("end", null,
			null);            //debug

		BlockEntity block = new BlockEntity_Cfg("block").
			startAlter(startIdOnly).midAlter(midAlterer).
			endAlter(EndRequired.YES, endIdOnly).
			keepMidsOnly().required(true).build();

		FilteredLineIterator filteredItr = new FilteredLineIterator(
			StringUtil.getLineIterator(input), Returns.KEPT,
			null, null,    //dbgEveryLine and its line-range
			block);

		while(filteredItr.hasNext())  {
			System.out.println(filteredItr.next());
		}
	}
}