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
package  com.github.xbn.examples.lang.non_xbn;
	 import java.util.Arrays;
/**
	<P>Find all words in a string that have a specific letter.</P>

  	<P>{@code java com.github.xbn.examples.lang.non_xbn.AllWordsInLineThatHaveALetter}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
  **/
public class AllWordsInLineThatHaveALetter {
	private String line;
	public AllWordsInLineThatHaveALetter(String line)  {
		this.line = line;
	}
	public static final void main(String[] ignored)  {
		testLine('b', "abc def ghi cba def ghi");
	}
	private static final void testLine(char letter, String line)  {
		System.out.println("Line: \"" + line + "\"");
		String[] asAllWordsWith = (new AllWordsInLineThatHaveALetter(line)).allWordsWith(letter);
		System.out.println("Words with '" + letter + "': " + Arrays.toString(asAllWordsWith));
	}
	public String mark (char letter){
		String replaceletters = line.replace(letter, '#');
		return replaceletters;
	}
	public String[] allWordsWith (char letter){
		String[] asAllWordsInLine = line.split(" ");
		java.util.ArrayList<String> alsAllWordsWithChar = new java.util.ArrayList<String>();
		for ( String ss : asAllWordsInLine) {
			if(ss.indexOf(letter) != -1)  {
				alsAllWordsWithChar.add(ss);
				continue;	//No need to check any more letters.
			}
		}
		return  alsAllWordsWithChar.toArray(new String[alsAllWordsWithChar.size()]);
	}
}