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
package  com.github.xbn.lang;

/**
   <p>Fundamental constants used throughout {@code com.github.xbn.*}. Consider importing this staticly:
   <br/> &nbsp; &nbsp; {@code import  com.github.xbn.lang.XbnConstants.*;}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class XbnConstants  {
   public static final String sXMK = "X" + "XX";
   public static final String sYMK = "Y" + "YY";
   /**
      <p>The line separator appropriate for this environment--Equal to <code>System.getProperty("line.separator", "\r\n")</code></p>
    **/
   public static final String LINE_SEP = System.getProperty("line.separator", "\r\n");
   /**
      <p>The default file-separator--Equal to <code>System.getProperty(&quot;file.separator&quot;, &quot;\\&quot;</code></p>
    **/
   public static final String FILE_SEP = System.getProperty("file.separator", "\\");
}

