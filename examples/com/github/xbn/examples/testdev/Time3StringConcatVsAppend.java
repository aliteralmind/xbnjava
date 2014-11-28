/*license*\
	XBN-Java Library

	Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

	This software is dual-licensed under the:
	- Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
	- Apache Software License (ASL) version 2.0.

	Either license may be applied at your discretion. More information may be found at
	- http://en.wikipedia.org/wiki/Multi-licensing.

	The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
	- LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
	- ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.examples.testdev;
	import  com.github.xbn.testdev.TimedTest;
/**
	<P>Demonstration of {@code com.github.xbn.testdev.}{@link com.github.xbn.testdev.TimedTest TimedTest}, comparing two ways to iterating through a list: by index or iterator.</P>

   <P>{@code java com.github.xbn.examples.testdev.Time3StringConcatVsAppend 1000000}</P>

   @see  <CODE><A HREF="http://aliteralmind.wordpress.com/2014/03/22/for_foreach/">http://aliteralmind.wordpress.com/2014/03/22/for_foreach/</A></CODE>
   @see  <CODE><A HREF="http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java">http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java</A></CODE>
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class Time3StringConcatVsAppend  {
   public static final void main(String[] tryCount_inParamIdx0)  {
		int testCount = TimedTest.getTestCountFromCmdLine(tryCount_inParamIdx0, 0);

		//Test proper...START
			TimedTest idxTest = new TimedTest("concat");
			TimedTest itrTest = new TimedTest("append");

			idxTest.declareStartWithOutput();
				for(int i = 0; i < testCount; i++)  {
					testConcat();
				}
			idxTest.declareEndThenStartNextWithOutput(itrTest);
				for(int i = 0; i < testCount; i++)  {
					testAppend();
				}
			itrTest.declareEndWithOutput();

			System.out.println(idxTest.getTestABTestNanoDifferenceMsg(itrTest));
   }
		private static final String testConcat()  {
			return  "one" + "two" + "three";
		}
		private static final String testAppend()  {
			return  (new StringBuilder("one")).append("two").append("three").toString();
		}
	//Test proper...END
}
