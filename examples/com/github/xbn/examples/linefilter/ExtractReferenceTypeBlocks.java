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
   import  com.github.xbn.linefilter.entity.BlockEntity;
   import  com.github.xbn.linefilter.entity.EntityRequired;
   import  com.github.xbn.linefilter.entity.KeepMatched;
   import  com.github.xbn.linefilter.entity.NewBlockEntityFor;
   import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
   import  java.util.Iterator;
   import  java.util.regex.Pattern;
/**
   <p>Demonstrates using {@code FilteredLineIterator} to return only the lines in a particular kind of block.</p>

   <p>{@code java com.github.xbn.examples.linefilter.ExtractReferenceTypeBlocks examples\com\github\xbn\examples\linefilter\reference_type_through_attachment_blocks_input.txt}</p>

 * @see  <code><a href="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic">{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic</a></code>
 * @since  0.1.2
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ExtractReferenceTypeBlocks  {
   public static final void main(String[] params)  {
      //Example setup
         Iterator<String> rawInputLineItr = GetFromCommandLineAtIndex.fileLineIterator(
            params, 0,
            null);   //debugPath

      //Example proper:

      BlockEntity block = NewBlockEntityFor.lineRange(null,
         KeepMatched.YES, EntityRequired.YES,
         Pattern.compile("^Reference Type: +"), null,
            null,          //dbgStart (on:System.out, off:null)
         Pattern.compile("^'File' Attachments: +"), null,
            null,          //dbgEnd
         null,
            null);         //dbgLineNums

      FilteredLineIterator filteredItr = new FilteredLineIterator(
         rawInputLineItr, Returns.KEPT,
            null, null,    //dbgEveryLine and its line-range
         block);

      StringBuilder allBlockTextBldr = new StringBuilder();

      final String LINE_SEP = System.getProperty("line.separator", "\r\n");

      while(filteredItr.hasNext())  {
         String nextKeptLine = filteredItr.next();

         if(!filteredItr.getRootBlock().isActive())  {
            continue;
         }

         System.out.println("--BLOCK FOUND:");

         filteredItr.appendAllBlockLines(System.out, nextKeptLine, null, null);

         System.out.println();
      }  //End snippet
   }
}
