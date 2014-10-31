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
package  com.github.xbn.examples.util.itr;
	import  java.util.List;
	import  java.util.Arrays;
	import  com.github.xbn.util.itr.IteratorUtil;
	import  java.util.Iterator;
/**
	<P>Demonstrates a double-for-loop using iterators, featuring <CODE>{@link com.github.xbn.util.itr.IteratorUtil}.{@link com.github.xbn.util.itr.IteratorUtil#newIteratorStartingAtIndex(int, Iterable) newIteratorStartingAtIndex}</CODE></P>

	<P>{@code java com.github.xbn.examples.util.itr.DetectDupsWithIterators}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class DetectDupsWithIterators  {
	public static final void main(String[] ignored)  {
		test("a", "b", "c", "d", "e");
		test("a", "b", "c", "b", "d");
	}
	private static final void test(String... strings)  {
		List<String> list = Arrays.asList(strings);

		int idx1 = 0;
		Iterator<String> itr1 = list.iterator();
		while(itr1.hasNext())  {

			String one = itr1.next();
			int idx2 = idx1 + 1;
			Iterator<String> itr2 = IteratorUtil.newIteratorStartingAtIndex(idx2, list);

			while(itr2.hasNext())  {

				String two = itr2.next();
				System.out.println("Comparing indexes " + idx1 + " (\"" + one +
					"\") and " + idx2 + " (\"" + two + "\")");

				if(one.equals(two))  {
					System.out.println("Duplicate found: \"" + one + "\"");
					return;
				}
				idx2++;
			}
			idx1++;
		}

		System.out.println("No duplicates");
	}
}