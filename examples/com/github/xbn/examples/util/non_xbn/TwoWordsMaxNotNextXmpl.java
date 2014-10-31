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
package  com.github.xbn.examples.util.non_xbn;
	import  java.util.ArrayList;
	import  java.util.Arrays;
/**
	<P>Reads in multiple words on the command line, crashing when two of the same word are next to each other, or appears more than twice total.<UL>
		<LI><B>Good:</B> {@code java TwoWordsMaxNotNextXmpl banana apple banana watermelon apple kiwi}</LI>
		<LI><B>Bad (next-to):</B> {@code java TwoWordsMaxNotNextXmpl banana apple banana watermelon watermelon apple kiwi}</LI>
		<LI><B>Bad (too many):</B> {@code java TwoWordsMaxNotNextXmpl banana apple banana watermelon apple banana kiwi}</LI>
	</UL></P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TwoWordsMaxNotNextXmpl  {
	public static final void main(String[] as_spaceDelimFruits)  {
		ArrayList<String> als = new ArrayList<String>(as_spaceDelimFruits.length);

		//Add the first, which is always okay.
		try  {
			als.add(as_spaceDelimFruits[0]);
			System.out.println(als.get(0));
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new IllegalArgumentException("No fruits to test. Must provide at least one.");
		}

		for(int i = 1; i < as_spaceDelimFruits.length; i++)  {
			String sFruit = as_spaceDelimFruits[i];
			if(als.get(i - 1).equals(sFruit))  {
				throw  new IllegalArgumentException("Two " + sFruit + "s in a row bad.");
			}
			int iX1 = als.indexOf(sFruit);
			int iX2 = als.lastIndexOf(sFruit);
			if(iX1 > -1  &&  iX1 != iX2)  {
				throw  new IllegalArgumentException("Two " + sFruit + "s already added (at indexes " + iX1 + ", " + iX2 + ").");
			}

			als.add(sFruit);
			System.out.println(sFruit);
		}

		System.out.println("DONE: " + Arrays.toString(als.toArray()));
	}
}
