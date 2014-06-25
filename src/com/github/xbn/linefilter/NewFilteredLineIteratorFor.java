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
package  com.github.xbn.linefilter;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.linefilter.Returns;
   import  com.github.xbn.linefilter.entity.BlockEntity;
   import  com.github.xbn.linefilter.entity.KeepEndLine;
   import  com.github.xbn.linefilter.entity.KeepMatched;
   import  com.github.xbn.linefilter.entity.KeepMidLines;
   import  com.github.xbn.linefilter.entity.KeepStartLine;
   import  com.github.xbn.linefilter.entity.NewBlockEntityFor;
   import  com.github.xbn.linefilter.entity.raw.RawLine;
   import  com.github.xbn.number.LengthInRangeValidator;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  java.util.Iterator;
   import  java.util.regex.Pattern;
/**
   <P>Convenience functions for creating {@code FilteredLineIterator}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewFilteredLineIteratorFor  {
   /**
      <P>Create a new {@code FilteredLineIterator} that does nothing: All lines are kept and unaltered.</P>

      @return
<BLOCKQUOTE><PRE>new {@link FilteredLineIterator#FilteredLineIterator(Iterator, Returns, Appendable, LengthInRangeValidator, RawBlockEntity) FilteredLineIterator}(all_lineItr, {@link Returns}.{@link Returns#KEPT KEPT},
   dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
   {@link com.github.xbn.linefilter.entity.NewBlockEntityFor}.{@link com.github.xbn.linefilter.entity.NewBlockEntityFor#keepAllUnchanged(String) keepAllUnchanged}(&quot;root&quot;))</PRE></BLOCKQUOTE>
    **/
   public static final FilteredLineIterator keepAllLinesUnchanged(Iterator<String> all_lineItr, Appendable dbgEveryLine_ifNonNull, LengthInRangeValidator rangeForEveryLineDebug_ifNonNull)  {
      return  new FilteredLineIterator(all_lineItr, Returns.KEPT,
         dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
         NewBlockEntityFor.keepAllUnchanged("root"));
   }
   /*
      <P>Create a new {@code FilteredLineIterator} that optionally keeps the start or end lines, or mid lines, but otherwise does nothing. No lines are altered.</P>

      @return
<BLOCKQUOTE><PRE>new {@link FilteredLineIterator#FilteredLineIterator(Iterator, Returns, Appendable, LengthInRangeValidator, RawBlockEntity) FilteredLineIterator}(all_lineItr, {@link Returns}.{@link Returns#KEPT KEPT},
   dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
   {@link com.github.xbn.linefilter.entity.NewBlockEntityFor}.{@link com.github.xbn.linefilter.entity.NewBlockEntityFor#keepAllUnchanged(String) keepAllUnchanged}(&quot;root&quot;,
      root_startLine, root_midLines, root_endLine))</PRE></BLOCKQUOTE>
   public static final FilteredLineIterator keptLinesUnchanged(Iterator<String> all_lineItr, KeepStartLine root_startLine, KeepMidLines root_midLines, KeepEndLine root_endLine, Appendable dbgEveryLine_ifNonNull, LengthInRangeValidator rangeForEveryLineDebug_ifNonNull)  {
      return  new FilteredLineIterator(all_lineItr, Returns.KEPT,
         dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
         NewBlockEntityFor.keepAllUnchanged("root",
            root_startLine, root_midLines, root_endLine));
   }
    */
   public NewFilteredLineIteratorFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
