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
package  com.github.xbn.examples.regexutil.non_xbn.basic;
/**
   <p>ReplacedInEachInput all pipe characters (&quot;<code>|</code>&quot;) to new-lines, using the system property &quot;<code>line.separator</code>&quot;</p>

   <p>{@code java com.github.xbn.examples.regexutil.non_xbn.basic.ReplacePipeToLineSeparator}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ReplacePipeToLineSeparator  {
   public static final void main(String[] ignored)  {
      String sInput = "Tassimo T46 Home Brewing System|43-0439-6|17999|0.30:Moto Precise Fit Rear Wiper Blade|0210919|799|0.0: Easton Stealth Reflex Composite Hockey Stick| 83-4567-0|8999|0.5:Yardworks 4-Ton Log Splitter|60-3823-0|39999|0";

      String output = sInput.replaceAll("\\|", " ").replaceAll(":", System.getProperty("line.separator", "\n"));

      System.out.println(output);
   }
}

