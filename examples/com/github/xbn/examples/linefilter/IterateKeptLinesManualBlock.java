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
package  com.github.xbn.examples.linefilter;
   import  com.github.xbn.linefilter.FilteredLineIterator;
   import  com.github.xbn.linefilter.Returns;
   import  com.github.xbn.linefilter.alter.NewTextLineAltererFor;
   import  com.github.xbn.linefilter.alter.TextLineAlterer;
   import  com.github.xbn.linefilter.entity.BlockEntity;
   import  com.github.xbn.linefilter.entity.EndRequired;
   import  com.github.xbn.linefilter.entity.z.BlockEntity_Cfg;
   import  com.github.xbn.text.StringUtil;
   import  java.util.Iterator;
/**
   <p>Demonstrates using {@link com.github.xbn.linefilter.FilteredLineIterator} to return only the lines in a block.</p>

   <p>{@code java com.github.xbn.examples.linefilter.IterateKeptLinesManualBlock}</p>

 * @see  <code><a href="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic">{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic</a></code>
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class IterateKeptLinesManualBlock  {
   public static final void main(String[] ignored)  {
      //Example setup
         String LINE_SEP = System.getProperty("line.separator", "\r\n");
         StringBuilder input = new StringBuilder().
            append("before1"          ).append(LINE_SEP).
            append("before2"          ).append(LINE_SEP).
            append("Block starts here").append(LINE_SEP).
            append("mid1"             ).append(LINE_SEP).
            append("mid2"             ).append(LINE_SEP).
            append("Block ends here"  ).append(LINE_SEP).
            append("after1"           ).append(LINE_SEP).
            append("after2"           ).append(LINE_SEP);
         Iterator<String> lineItr = StringUtil.getLineIterator(input);

      //Example proper:

      TextLineAlterer startIdOnly = NewTextLineAltererFor.
         textValidateOnly("start", null,
         null);            //debug (on:System.out, off:null)
      TextLineAlterer endIdOnly = NewTextLineAltererFor.
         textValidateOnly("end", null,
         null);            //debug

      BlockEntity block = new BlockEntity_Cfg("block").
         startAlter(startIdOnly).endAlter(EndRequired.YES, endIdOnly).
         keepMidsOnly().required(true).build();

      FilteredLineIterator filteredItr = new FilteredLineIterator(
            lineItr, Returns.KEPT,
         null, null,    //dbgEveryLine and its line-range
         block);

      while(filteredItr.hasNext())  {
         System.out.println(filteredItr.next());
      }
   }
}
