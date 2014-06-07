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

package  com.github.xbn.examples.lang.non_xbn.basic;
/**
   <P>YYY</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.basic.RawNumericValueOfChar}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
/**
   <P>{@code java RawNumericValueOfChar}</P>
 **/
public class RawNumericValueOfChar  {
   public static final void main(String[] ignored)  {
      int intValueOfCharOne = '1';
      int intValueOfCharALower = 'a';
      int intValueOfCharAUpper = 'A';

      System.out.println("intValueOfCharOne=" + intValueOfCharOne);
      System.out.println("intValueOfCharALower=" + intValueOfCharALower);
      System.out.println("intValueOfCharAUpper=" + intValueOfCharAUpper);

      int intValueOfCharOneInc = ((int)'1') + 1;
      int intValueOfCharALowerInc = ((int)'a') + 1;
      int intValueOfCharAUpperInc = ((int)'A') + 1;

      System.out.println("intValueOfCharOneInc=" + intValueOfCharOneInc);
      System.out.println("intValueOfCharALowerInc=" + intValueOfCharALowerInc);
      System.out.println("intValueOfCharAUpperInc=" + intValueOfCharAUpperInc);
   }
}
