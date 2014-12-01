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
package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
/**
   <p>Searches input lines for a specific string followed by any digit.</p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.SearchDataLinesForPrefixThenNumXmpl}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SearchDataLinesForPrefixThenNumXmpl  {
   public static final void main(String[] ignored)  {
      String LINE_SEP = System.getProperty("line.separator", "\n");

      StringBuilder sdInput = new StringBuilder().
         append("<a id=\"SheetContentPlaceHolder_ctl00_gvForeclosureResutls_lbCaseNum_0\" href=\"javascript:__doPostBack(&#39;ctl00$SheetContentPlaceHolder$ctl00$gvForeclosureResutls$ctl02$lbCaseNum&#39;,&#39;&#39;)\" style=\"display:inline-block;width:100px;\">CV-13-798497</a>").append(LINE_SEP).
         append("				  </td><td align=\"center\">488-05-029</td><td align=\"center\">I</td><td align=\"center\">01/02/2013</td>").append(LINE_SEP).
         append("  </tr><tr style=\"background-color:Gainsboro;\">").append(LINE_SEP).
         append("		<td align=\"left\">UNKNOWN HEIRS, ETC OF D.C. RUFUS, ET AL  </td><td align=\"left\">10603 HAMPDEN AVENUE</td><td align=\"center\">CLEVELAND</td><td align=\"center\">44108-0000</td><td align=\"center\">").append(LINE_SEP).
         append("						<a id=\"SheetContentPlaceHolder_ctl00_gvForeclosureResutls_lbCaseNum_1\" href=\"javascript:__doPostBack(&#39;ctl00$SheetContentPlaceHolder$ctl00$gvForeclosureResutls$ctl03$lbCaseNum&#39;,&#39;&#39;)\" style=\"display:inline-block;width:100px;\">CV-13-798498</a>").append(LINE_SEP).
         append("				  </td><td align=\"center\">109-16-094</td><td align=\"center\">A</td><td align=\"center\">01/02/2013</td>").append(LINE_SEP).
         append("  </tr><tr style=\"background-color:LightGrey;\">").append(LINE_SEP).
         append("		<td align=\"left\">SHARECE MILLER, ET AL  </td><td align=\"left\">13514 ALVIN AVENUE</td><td align=\"center\">GARFIELD HTS</td><td align=\"center\">44105-0000</td><td align=\"center\">").append(LINE_SEP).
         append("						<a id=\"SheetContentPlaceHolder_ctl00_gvForeclosureResutls_lbCaseNum_2\" href=\"javascript:__doPostBack(&#39;ctl00$Shee").append(LINE_SEP);

      String sRqdValuePrefix = "ForeclosureResutls_lbCaseNum_";
      Pattern checkerLoopPattern = Pattern.compile(sRqdValuePrefix + "\\d");
      Matcher m = checkerLoopPattern.matcher("");  //Unused. so the matcher can be reused in the loop.

      int lineNum = 0;
      String[] asInput = sdInput.toString().split(LINE_SEP);
      for(String s : asInput)  {
         lineNum++;	 //1st iteration: Was zero, now 1

         //Resuing matcher instead of retrieving new one from Pattern each iteration
         m.reset(s);

         if(m.find())  {
            int iCheckerNumber = Integer.parseInt(s.substring(m.start() + sRqdValuePrefix.length(), m.end()));
            System.out.println("Found on line " + lineNum + ", at index " + m.start() + " with checker number " + iCheckerNumber);
         }
      }
   }
}
