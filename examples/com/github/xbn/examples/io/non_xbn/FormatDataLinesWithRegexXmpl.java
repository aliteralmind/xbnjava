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
package  com.github.xbn.examples.io.non_xbn;
	import  java.util.Arrays;
	import  java.util.ArrayList;
	import  java.util.regex.Pattern;
/**
	<P>Demonstrates using regex to parse multi-line input, where parts of the input is only on some lines, and  must be redundantly used on other lines. This is an answer to
	<BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/21341455/conditional-regular-expression">http://stackoverflow.com/questions/21341455/conditional-regular-expression</A></CODE></P>

	<P>{@code java com.github.xbn.examples.io.non_xbn.FormatDataLinesWithRegexXmpl}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FormatDataLinesWithRegexXmpl  {
	public static final void main(String[] ignored)  {
		String LINE_SEP = System.getProperty("line.separator", "\\n");
		StringBuilder sdInput = new StringBuilder().
			append("011110659																				").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("								  A101				000001					  $.45").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("031100762																				").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("								  1030				000001					  $.45").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("071000288																				").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("								  1040				000003					 $1.35").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("								  1040				000001					  $.45").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("103100195																				").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("								  1030				000001					$33.45").append(LINE_SEP).
			append("																							").append(LINE_SEP).
			append("								  J5BU				000001					  $.45").append(LINE_SEP);

		//config
			int iCOL1LEN = 9;
			String sRE234 = "" +
				"(\\w{4})[\\t ]+" +					//Column 2
				"(\\d{6})[\\t ]+" +					//Column 3
				"\\$(\\d*\\.*\\d+)$";				 //Column 4
		Pattern p234 = Pattern.compile(sRE234);

		ArrayList<String> alLines = new ArrayList<String>(Arrays.asList(sdInput.toString().split(LINE_SEP)));
		ArrayList<DataLine> aldl = new ArrayList<DataLine>();

		System.out.println("read...START");
		DataLine dlCurr = null;
		int lineNum = -1;

		while(alLines.size() > 0)  {
			lineNum++;				  //1st iteration: was -1, now 0

			String sLine = alLines.remove(0).trim();
			if(sLine.length() == 0)  {
				continue;

			}  else if(sLine.length() == iCOL1LEN)  {
				if(dlCurr != null)  {
					throw  new IllegalStateException("[line " + lineNum + "]: Found two column-1s in a row.");
				}
				dlCurr = new DataLine(sLine);
				System.out.print("1");

			}  else if(p234.matcher(sLine).matches())  {
				if(dlCurr == null)  {
					//Current 234-columns has no corresponding column-1.
					//Use previous.
					dlCurr = new DataLine(aldl.get(aldl.size() - 1).sCol1);
					System.out.print("1");
				}
				dlCurr.set234(sLine);
				aldl.add(dlCurr);
				System.out.println("234");
				dlCurr = null;
			}
		}
		System.out.println("read...END");

		System.out.println("Output:");

		for(DataLine dl : aldl)  {
			System.out.println(dl.sCol1 + "		  " + dl.sCol2 + "		  " + dl.sCol3 + "		  " + dl.sCol4);
		}
	}
}
class DataLine  {
	public String sCol1 = null;
	public String sCol2 = null;
	public String sCol3 = null;
	public String sCol4 = null;
	public DataLine(String selfCmprol1)  {
		sCol1 = selfCmprol1;
	}
	public void set234(String twoThreeFour_strs)  {
		String[] as = twoThreeFour_strs.split("[\t ]+");
		sCol2 = as[0];
		sCol3 = as[1];
		sCol4 = as[2];
	}
}