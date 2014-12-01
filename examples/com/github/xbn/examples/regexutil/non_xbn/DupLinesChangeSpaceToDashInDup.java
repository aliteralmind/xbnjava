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
   <p>Duplicate lines where the duplicate has punctuation removed, and spaces replaced with dashes.</p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.DupLinesChangeSpaceToDashInDup}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class DupLinesChangeSpaceToDashInDup  {
   public static final void main(String[] ignored)  {
      //input
         String LINE_SEP = System.getProperty("line.separator", "\r\n");
         StringBuilder inputBldr = new StringBuilder().
            append("Hi. My name is Ni__ck.").append(LINE_SEP).
            append("This is the second line!").append(LINE_SEP);
         String[] textInputArr = inputBldr.toString().split(LINE_SEP);

      //config
         //"": Dummy search string, to reuse matcher
         Matcher mtchrNonWordChar = Pattern.compile("(\\W|_)").matcher("");

      //go
         StringBuffer rplcmntBfr = new StringBuffer();
         for(String lineText : textInputArr)  {
            rplcmntBfr.append(lineText).append("|");

            String[] wordArr = lineText.split(" ");

            for(int i = 0; i < wordArr.length; i++)  {
               String s = wordArr[i];
               rplcmntBfr.append(mtchrNonWordChar.reset(s).replaceAll(""));
               if(i < wordArr.length - 1)  {
                  rplcmntBfr.append("-");
               }
            }
            rplcmntBfr.append(LINE_SEP);
         }

      System.out.println(rplcmntBfr);
   }
}
