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

package  com.github.xbn.examples.text;
   import  com.github.xbn.text.StringUtil;
/**
   <p>Demonstrates {@link com.github.xbn.text.StringUtil#getVisibleIndexMask(Object, int, int) getVisibleIndexMask}{@code O,i,i}.</p>

   <h4>{@code java com.github.xbn.examples.text.VisibleIndexMaskXmpl}</h4>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class VisibleIndexMaskXmpl  {
   public static final void main(String[] ignored)  {
      String sToMask = "Hi Ho! Kermit The Frog here.";

      //Masking indexs 3-10, and then 7

      System.out.println(sToMask);
      System.out.println(StringUtil.getVisibleIndexMask(sToMask, 3, 10));
      System.out.println(StringUtil.getVisibleIndexMask(sToMask, 7, 7));
   }
}
