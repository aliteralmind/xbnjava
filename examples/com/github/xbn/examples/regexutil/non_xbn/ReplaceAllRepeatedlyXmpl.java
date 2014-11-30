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
   <p>Replace all text repeatedly, until no more matches are found.</p>

   <p>{@code java  com.github.xbn.examples.regexutil.non_xbn.ReplaceAllRepeatedlyXmpl}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ReplaceAllRepeatedlyXmpl  {
   public static final void main(String[] ignored)  {
  String sToSearch = "xxxxxxxxxxxxxxx";
  Pattern pFindWhat = Pattern.compile("xxx");
  String sRplcWith = "x";

  String sResult = appendReplaceUntil((new StringBuffer()), pFindWhat, sRplcWith, sToSearch).toString();
  System.out.println(sResult);
   }

   //Replace all matches repeatedly, until no more are found
   public static final StringBuffer appendReplaceUntil(StringBuffer to_appendTo, Pattern find_whatPtrn, String rplc_with, String to_search)  {

  int iMaxUntil = 5;

  Matcher m = find_whatPtrn.matcher(to_search);
  StringBuffer sdTemp = (new StringBuffer(to_appendTo));

  boolean bFound = false;
  int iUntilLoops = 0;
  while(true)  {
     bFound = false;
     iUntilLoops++;

     while(m.find())  {
        bFound = true;
        m.appendReplacement(sdTemp, rplc_with);
     }
     m.appendTail(sdTemp);

     if(iUntilLoops >= iMaxUntil)  {
        //The NEXT "while(m.find())" loop would exceed the maximum.

        throw  new IllegalStateException("Maximum number of 'until' loops reached.");
     }

     if(!bFound)  {
        //No matches were found at all during this iteration
        to_appendTo.append(sdTemp);
        break;
     }

     m.reset(sdTemp.toString());

     sdTemp.setLength(0);
  }
  return  to_appendTo;
   }
}

