/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.examples.regexutil.non_xbn;
   import  java.util.regex.Pattern;
   import  java.util.regex.Matcher;
/**
   <P>Duplicate lines where the duplicate has punctuation removed, and spaces replaced with dashes.</P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.DupLinesChangeSpaceToDashInDup}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
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
