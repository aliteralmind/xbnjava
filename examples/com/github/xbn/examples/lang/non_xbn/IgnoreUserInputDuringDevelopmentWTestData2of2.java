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
	import java.util.*;
/**
	<P>Demonstrates the use of test-data in an application requiring user-input at the console, preventing the need for user-input during development. This is an answer to
	<BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/21584988/looping-with-different-variables">http://stackoverflow.com/questions/21584988/looping-with-different-variables</A></CODE></P>

	<P>{@code java com.github.xbn.examples.lang.non_xbn.IgnoreUserInputDuringDevelopmentWTestData2of2}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IgnoreUserInputDuringDevelopmentWTestData2of2  {

	public static void main(String[] ignored) {

		HourMin24[] ahm = null;

		//EXACTLY ONE of the following lines must be commented out
		//Test only:
			ahm = getTestData();
		//Live only:
		// ahm = getDataFromUserInput();

		double dTotalHours = 0.0;
		for (HourMin24 hm : ahm){
			System.out.println("Time: " + hm.iHour + ":" + hm.iMin);
			dTotalHours += hm.iHour + (hm.iMin / 60);
		}

		System.out.println("Average time (" + ahm.length + "): " + (dTotalHours / ahm.length));
	}
	private static final HourMin24[] getDataFromUserInput()  {
		Scanner in = new Scanner(System.in);

		System.out.print("How many times? ");
		int numOfTimes = in.nextInt();
		ArrayList<HourMin24> al24 = new ArrayList<HourMin24>(numOfTimes);
		while(numOfTimes < 0)  {
			System.out.println("What Time (military time):  ");
			System.out.print("Hour  ");
			int iHour = in.nextInt();
			System.out.print("Minute  ");
			int iMin = in.nextInt();

			al24.add(new HourMin24(iHour, iMin));

			numOfTimes--;
		}

		return  al24.toArray(new HourMin24[al24.size()]);
	}
	private static final HourMin24[] getTestData()  {
		System.out.println("TEST MODE ON");
		return  new HourMin24[] {
			new HourMin24(13, 1),
			new HourMin24(23, 19),
			new HourMin24(0, 59),
			new HourMin24(16, 16),
		};
	}
}
class HourMin24  {
	public int iHour;
	public int iMin;
	public HourMin24(int hour, int min_inclusive)  {
		iHour = hour;
		iMin = min_inclusive;
	}
}
