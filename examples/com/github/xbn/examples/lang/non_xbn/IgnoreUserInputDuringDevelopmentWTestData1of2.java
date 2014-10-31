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
  import  java.util.Scanner;
/**
	<P>Demonstrates the use of test-data in an application requiring user-input at the console, preventing the need for user-input during development.</P>

	<P>{@code java com.github.xbn.examples.lang.non_xbn.IgnoreUserInputDuringDevelopmentWTestData1of2}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IgnoreUserInputDuringDevelopmentWTestData1of2  {
	public static void main(String[] ignored) {
  //Exactly one of the following lines must be commented out
  //printUserPromptData();
  printTestData();
	}
	private static final void printTestData()  {
  printGrid(0, 0, 4);
  printGrid(5, 3, 9);
  printGrid(1, 1, 1);
	}

	private static final void printGrid(int x_pos, int y_pos, int length)  {
		System.out.println("Print grid HERE: x_pos=" + x_pos + ", y_pos=" + y_pos + ", length=" + length);
	}

	private static final void printUserPromptData()  {
  Scanner scnr = new Scanner(System.in);
  System.out.print("Position in x:");
  int positionInX = Integer.parseInt(scnr.nextLine());

  System.out.print("Position in y:");
  int positionInY = Integer.parseInt(scnr.nextLine());

  System.out.print("Length of the square:");
  int lengthOfSquare = Integer.parseInt(scnr.nextLine());

  printGrid(positionInX, positionInY, lengthOfSquare);
	}
}
