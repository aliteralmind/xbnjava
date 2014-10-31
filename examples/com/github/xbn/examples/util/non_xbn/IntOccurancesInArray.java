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
	import  java.util.Iterator;
	import  java.util.Map;
	import  java.util.Set;
	import  java.util.TreeMap;
/**
	<P>Collection-based solution to finding the number of occurances of each number in an int-array.</P>

	<P>{@code java com.github.xbn.examples.util.non_xbn.IntOccurancesInArray}</P>

	@see  IntOccurancesInArrayElegant
	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IntOccurancesInArray  {
	public static final void main(String[] ignored)  {
		int[] ai = new int[]{52, 67, 32, 43, 32, 21, 12, 5, 0, 3, 2, 0, 0};
		Map<Integer,Integer> mpNumWHits = new TreeMap<Integer,Integer>();
		for(int i = 0; i < ai.length; i++)  {
			int iValue = ai[i];
			if(!mpNumWHits.containsKey(iValue))  {
				mpNumWHits.put(iValue, 1);
			}  else  {
				mpNumWHits.put(iValue, (mpNumWHits.get(iValue) + 1));
			}
		}

		Set<Integer> stInts = mpNumWHits.keySet();
		Iterator<Integer> itrInts = stInts.iterator();

		int[] ai100 = new int[100];

//		int i = 0;
		while(itrInts.hasNext())  {
			int iValue = itrInts.next();
			int iHits = mpNumWHits.get(iValue);
			System.out.println(iValue + " found " + iHits + " times");
			ai100[iValue] = iHits;
		}

		for(int j = 0; j < ai100.length; j++)  {
			if(ai100[j] > 0)  {
				System.out.println("ai100[" + j + "]=" + ai100[j]);
			}
		}
	}
}
