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
   import  com.github.xbn.linefilter.KeepUnmatched;
   import  com.github.xbn.linefilter.Returns;
   import  com.github.xbn.linefilter.alter.NewTextLineAltererFor;
   import  com.github.xbn.linefilter.alter.TextLineAlterer;
   import  com.github.xbn.linefilter.entity.BlockEntity;
   import  com.github.xbn.linefilter.entity.KeepMatched;
   import  com.github.xbn.linefilter.entity.NewBlockEntityFor;
   import  com.github.xbn.linefilter.entity.NewStealthBlockEntityFor;
   import  com.github.xbn.linefilter.entity.StealthBlockEntity;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
   import  com.github.xbn.util.IncludeJavaDoc;
   import  java.util.Iterator;
   import  java.util.regex.Pattern;
/**
   <P>Demonstrates using {@link com.github.xbn.linefilter.FilteredLineIterator} to modify the lines in a sub-block: a block that is a child of another block.</P>

   <P>{@code java com.github.xbn.examples.linefilter.PrintJavaDocBlockSubLinesBolded examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt}</P>

   @see  <CODE><A HREF="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_sub_block">{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_sub_block</A></CODE>
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class PrintJavaDocBlockSubLinesBolded  {
   public static final void main(String[] cmd_lineParams)  {
      //Example setup:
         Iterator<String> itr = GetFromCommandLineAtIndex.fileLineIterator(
            cmd_lineParams, 0,
            null);   //debugPath

      //Example proper:

      String subModePre = "^(.*?) +\\Q//sub-mode...";

      //Sub-entity
         TextLineAlterer midAlterer = NewTextLineAltererFor.replacement(
            Pattern.compile("^([ \\t]*)(.*)"), "$1<B>$2</B>", ReplacedInEachInput.FIRST,
            null,       //dbgDest (on:System.out, off:null)
            null);

         BlockEntity subBlock = NewBlockEntityFor.lineRangeWithReplace(
            "jdsub", KeepMatched.YES,
            Pattern.compile(subModePre + "START\\E$"), "<B>$1</B>",
               ReplacedInEachInput.FIRST, null,
            null,       //dbgStart
            midAlterer,
            Pattern.compile(subModePre + "END\\E$"), "<B>$1</B>",
               ReplacedInEachInput.FIRST, null,
            null,       //dbgEnd
            null,       //on-off filter
            null);      //dbgLineNums

      //Main-entities
         StealthBlockEntity javaMlcBlock = NewStealthBlockEntityFor.javaComment(
            "comment", IncludeJavaDoc.NO,
            null,       //dbgStart
            null,       //dbgEnd
            null,       //on-off filter
            null);      //dbgLineNums


         BlockEntity javaDocBlock = NewBlockEntityFor.javaDocComment_Cfg_startEndFilterDebug(
            "doccomment",
            null,       //dbgStart
            null,       //dbgEnd
            null,       //on-off filter
            null).      //dbgLineNums
            keepAll().children(subBlock).build();

      FilteredLineIterator filteredItr = new FilteredLineIterator(
         itr, Returns.KEPT, KeepUnmatched.YES,
         null, null,    //dbgEveryLine and its line-range
         javaMlcBlock, javaDocBlock);

      while(filteredItr.hasNext())  {
         System.out.println(filteredItr.next());
      }     //End snippet
   }
}
