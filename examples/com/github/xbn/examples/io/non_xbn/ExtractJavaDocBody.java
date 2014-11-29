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

package  com.github.xbn.examples.io.non_xbn;
    import  java.util.regex.Matcher;
    import  java.util.regex.Pattern;
/**
	<p>Reads through a series of source-code lines, extracting the body in each JavaDoc block (and eliminating the optional asterisk-prefix from each line).</p>

   <p>{@code java com.github.xbn.examples.io.non_xbn.ExtractJavaDocBody}</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class ExtractJavaDocBody  {
   public static final void main(String[] ignored)  {
      String LINE_SEP = System.getProperty("line.separator", "\r\n");
      StringBuilder input = new StringBuilder().
         append("...                     ").append(LINE_SEP).
         append("/").append("**          ").append(LINE_SEP).
         append("* Comment section for Asset Record config OnStatusChange").append(LINE_SEP).
         append("*                       ").append(LINE_SEP).
         append("* Updated for HT342408  Set Assetmeters to inactive when the asset they are").append(LINE_SEP).
         append("* associated with is retired. This will also cause the condition monitoring").append(LINE_SEP).
         append("* point associated with the meter to be displayed as inactive.").append(LINE_SEP).
         append("*").append("/            ").append(LINE_SEP).
         append("...                      ").append(LINE_SEP).
         append("/").append("**           ").append(LINE_SEP).
         append("* Another block line 1   ").append(LINE_SEP).
         append("*                        ").append(LINE_SEP).
         append("* Another block line 2   ").append(LINE_SEP).
         append("* Another block line 3   ").append(LINE_SEP).
         append("* Another block line 4   ").append(LINE_SEP).
         append("*").append("/            ").append(LINE_SEP).
         append("...                      ").append(LINE_SEP);
      String[] lines = input.toString().split(LINE_SEP);

      //"": To reuse matcher
      Matcher mtchrPostAstrsk = Pattern.compile("^\\*?[ \t]*(.*)$").matcher("");

      boolean isBlockStarted = false;
      for(String line : lines)  {
         line = line.trim();
         if(!isBlockStarted)  {
            if(line.startsWith("/" + "*"))  {
               //Assumes body starts on next line
               isBlockStarted = true;
            }
            continue;
         }  else if(line.endsWith("*" + "/"))  {
            isBlockStarted = false;
         }  else  {
            //Block is started
            mtchrPostAstrsk.reset(line).matches(); //Actually does the match

            //Trim to eliminate spaces between asterisk and text
            System.out.println(mtchrPostAstrsk.group(1).trim());
         }

      }

   }
}

