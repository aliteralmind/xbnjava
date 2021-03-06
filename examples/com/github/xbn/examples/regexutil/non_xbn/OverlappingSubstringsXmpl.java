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
   import  java.util.regex.Pattern;
   import  java.util.regex.Matcher;
 /**
 	<p>Using both regex and logic (non-regex), find a string that may overlap itself in a larger string--such as {@code "cdc"} is found at indexes 0 and 2 in {@code "cdcdc"}.</p>

    <p>{@code java com.github.xbn.examples.regexutil.non_xbn.OverlappingSubstringsXmpl}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
  **/
 public class OverlappingSubstringsXmpl  {
    public static final void main(String[] ignored)  {
      String sToFind = "cdc";
      String sToSearch = "cdcdcdedcdc";

      System.out.println("Non regex way:");

         int iMinIdx = 0;
         while(iMinIdx <= (sToSearch.length() - sToFind.length()))  {
            int iIdxFound = sToSearch.indexOf(sToFind, iMinIdx);

            if(iIdxFound == -1)  {
               break;
            }

             System.out.println(sToFind + " found at index " + iIdxFound);

            iMinIdx = iIdxFound + 1;
         }

      System.out.println("Regex way:");

         Matcher m = Pattern.compile(sToFind, Pattern.LITERAL).matcher(sToSearch);
         boolean bFound = m.find();
         while (bFound) {
            System.out.println(sToFind + " found at index " + m.start());
            bFound = m.find(m.start() + 1);
         }
      }
   }
