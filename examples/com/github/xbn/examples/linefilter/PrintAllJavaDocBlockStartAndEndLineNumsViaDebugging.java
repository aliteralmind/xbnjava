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
   import  com.github.xbn.util.IncludeJavaDoc;
   import  com.github.xbn.linefilter.entity.BlockEntity;
   import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
   import  java.util.Iterator;
   import  com.github.xbn.linefilter.entity.KeepMatched;
   import  com.github.xbn.linefilter.KeepUnmatched;
   import  com.github.xbn.linefilter.Returns;
   import  com.github.xbn.linefilter.entity.NewBlockEntityFor;
   import  com.github.xbn.linefilter.entity.NewStealthBlockEntityFor;
   import  com.github.xbn.linefilter.FilteredLineIterator;
   import  com.github.xbn.linefilter.entity.StealthBlockEntity;
/**
   <P>Demonstrates using {@link com.github.xbn.linefilter.FilteredLineIterator} to print the start and end line numbers of all JavaDoc blocks in a source code, via automated debugging.</P>

   <P>{@code java com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt}</P>

   @see  <CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_jd_block_lines">{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_jd_block_lines</A></CODE>
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging  {
   public static final void main(String[] cmd_lineParams)  {
      //Example setup
         Iterator<String> itr = GetFromCommandLineAtIndex.fileLineIterator(
            cmd_lineParams, 0,
            null);   //debugPath

      //Example proper:

      StealthBlockEntity javaMlcStealth = NewStealthBlockEntityFor.javaComment(
         "comment", IncludeJavaDoc.NO,
         null,         //dbgStart (on:System.out, off:null)
         null,         //dbgEnd
         null,         //on-off filter
         null);        //dbgLineNums

      BlockEntity javaDocBlock = NewBlockEntityFor.javaDocComment_Cfg_startEndFilterDebug(
         "doccomment", null,
         null,          //dbgStart
         null,          //dbgEnd
         System.out).   //<--Automated line-number debugging
         keepAll().build();

      FilteredLineIterator filteredItr = new FilteredLineIterator(
         itr, Returns.KEPT, KeepUnmatched.NO,
//Debug every line OFF:
         null, null,    //dbgEveryLine and its line-range
//Debug every line ON (all lines):
//       System.out, null,
//Debug every line ON (lines 3-6 only):
//       System.out, com.github.xbn.number.NewLengthInRangeFor.minMaxInclusive(null, 3, 6, null, null),
         javaMlcStealth, javaDocBlock);

      while(filteredItr.hasNext())  {
         filteredItr.next();
      }   //End snippet
   }
}
