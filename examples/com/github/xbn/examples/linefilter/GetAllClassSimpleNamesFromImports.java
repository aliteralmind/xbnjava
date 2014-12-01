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
   import  com.github.xbn.linefilter.entity.EntityRequired;
   import  com.github.xbn.linefilter.entity.KeepMatched;
   import  com.github.xbn.linefilter.entity.NewSingleLineEntityFor;
   import  com.github.xbn.linefilter.entity.NewStealthBlockEntityFor;
   import  com.github.xbn.linefilter.entity.OnOffAbort;
   import  com.github.xbn.linefilter.entity.OutOfRangeResponseWhen;
   import  com.github.xbn.linefilter.entity.PostFilterSelfActiveInOutRange;
   import  com.github.xbn.linefilter.entity.SingleLineEntity;
   import  com.github.xbn.linefilter.entity.StealthBlockEntity;
   import  com.github.xbn.number.NewLengthInRangeFor;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
   import  com.github.xbn.util.IncludeJavaDoc;
   import  com.github.xbn.util.JavaRegexes;
   import  java.util.Iterator;
   import  java.util.regex.Pattern;
/**
   <p>Uses a {@link com.github.xbn.linefilter.FilteredLineIterator} to get the simple class names from all import statements in a Java source file--Also demonstrates aborting the iterator with an {@linkplain com.github.xbn.linefilter.entity.OnOffEntityFilter on-off filter}.</p>

   <p>{@code java com.github.xbn.examples.linefilter.GetAllClassSimpleNamesFromImports examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class GetAllClassSimpleNamesFromImports  {
   public static final void main(String[] cmd_lineParams)  {
      //Example setup
         Iterator<String> rawInputLineItr = GetFromCommandLineAtIndex.fileLineIterator(
            cmd_lineParams, 0,
            null);     //debugPath

      //Example proper:

      PostFilterSelfActiveInOutRange onOffFilter = new PostFilterSelfActiveInOutRange(
         NewLengthInRangeFor.maxExclusive(null, 1, null),
         OnOffAbort.ON, OnOffAbort.ABORT_ITERATOR,
         OutOfRangeResponseWhen.NEXT_ACTIVE_LINE,
         null);        //debug (on:System.out, off:null)

      StealthBlockEntity javaMlcStealth = NewStealthBlockEntityFor.
         javaComment(null, KeepMatched.NO, EntityRequired.YES,
            IncludeJavaDoc.YES,
               null,      //dbgStart
               null,      //dbgEnd
            onOffFilter,
               null);     //dbgLineNums

      SingleLineEntity importLineEntity = NewSingleLineEntityFor.
         replacement("importline", KeepMatched.YES, EntityRequired.YES,
            Pattern.compile(JavaRegexes.IMPORT_LINE_CAPTURE_SIMPLE_NAME), "$1",
            ReplacedInEachInput.FIRST,
               null,      //dbgAlter
            null,
               null);     //dbgLineNums

      FilteredLineIterator filteredItr = new FilteredLineIterator(
         rawInputLineItr, Returns.KEPT, KeepUnmatched.NO,
         null, null,    //dbgEveryLine and its line-range
         javaMlcStealth, importLineEntity);

      while(filteredItr.hasNext())  {
         System.out.println(filteredItr.next());
      }  //End snippet
   }
}
