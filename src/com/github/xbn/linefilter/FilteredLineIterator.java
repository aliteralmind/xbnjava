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
   import  com.github.xbn.linefilter.entity.raw.RawBlockChildEntity;
   import  com.github.xbn.io.RTIOException;
   import  java.io.IOException;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.ExceptionUtil;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.linefilter.entity.BlockEntity;
   import  com.github.xbn.linefilter.entity.EntityRequired;
   import  com.github.xbn.linefilter.entity.KeepEndLine;
   import  com.github.xbn.linefilter.entity.KeepMidLines;
   import  com.github.xbn.linefilter.entity.KeepStartLine;
   import  com.github.xbn.linefilter.entity.LineEntityException;
   import  com.github.xbn.linefilter.entity.NewBlockEntityFor;
   import  com.github.xbn.linefilter.entity.SingleLineEntity;
   import  com.github.xbn.linefilter.entity.StealthBlockEntity;
   import  com.github.xbn.linefilter.entity.TextChildEntity;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  com.github.xbn.number.LengthInRange;
   import  java.util.Iterator;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>A string iterator that filters another string iterator whose elements are the lines in a text file--keeping or discarding lines that meet certain conditions, and optionally modifying kept lines.</p>

   <p><b>Examples</b><ul>
      <li>A basic example: <a href="#xmpl_basic">Extracting a block of text</a></li>
      <li><a href="#xmpl_modify">Modification</a> of kept lines</li>
      <li><a href="#xmpl_extract_blocks">More realistic block extraction</a></li>
      <li><a href="#xmpl_jd_block_lines">Detecting the start and end lines</a> of all JavaDoc blocks in source code</li>
      <li><a href="#xmpl_strip_cmts_pkgln">Strip all Java comment blocks</a> and the package declaration line from a classes source code</li>
      <li><a href="#xmpl_import_simples">Extract all simple class names</a> from the import lines in a Java source file</li>
      <li>Altering the lines in a <a href="#xmpl_sub_block">sub-block</a></li>
   </ul></p>

<A NAME="xmpl_basic"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: A basic use</h2>

   <p>This iterates through all lines in a &quot;text file&quot;, keeping only those between a block's &quot;start&quot; and &quot;end&quot; lines. <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/IterateKeptLines.html">full source</a>)</i></p>

   <p><b>Input:</b></p>

{@.codelet com.github.xbn.examples.linefilter.IterateKeptLines%lineRange(1, false, "LINE_SEP = System", 1, false, "inputLineItr = StringUtil", "^         ")}

   <p><b>Code</b>:</p>

{@.codelet.and.out com.github.xbn.examples.linefilter.IterateKeptLines%lineRangeWithReplace(1, true, "(block = NewBlockEntityFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   <p>An alternative way to create the same block entity: <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/IterateKeptLinesManualBlock.html">full source</a>)</i></p>

{@.codelet com.github.xbn.examples.linefilter.IterateKeptLinesManualBlock%lineRange(1, false, "startIdOnly = NewTextLineAltererFor", 1, false, "keepMidsOnly().required", "^      ")}

   <p>The block entity is also the filtered iterator's {@linkplain TextChildEntity#getTopParent() root entity}. An equivalent is to set the block as a child, and then declare that all unmatched lines (those not matched by any child entity) should be discarded: <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/IterateKeptLinesBlockAsChild.html">full source</a>)</i></p>

{@.codelet com.github.xbn.examples.linefilter.IterateKeptLinesBlockAsChild%lineRange(1, false, "tor filteredItr = ne", 1, false, "block);", "^      ")}

<A NAME="xmpl_modify"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: Modification of kept lines</h2>

   <p>Using the same input as above, this makes a simple replacement on each kept line: <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/ModifyBlockLines.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.ModifyBlockLines%lineRangeWithReplace(1, true, "(startIdOnly = NewTextLineAltererFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   <p>Any arbitrary modification can be made on kept lines (actually, {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active} lines). A more complicated version of the mid-alterer: <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/MoreComplicatedModifyExample.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.MoreComplicatedModifyExample%lineRange(1, false, "IndirectRegexReplacer replaceNumWithStrNum", 1, false, "lineReplacer(AlterationR", "^      ")}

<A NAME="xmpl_extract_blocks"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: More realistic block extraction</h2>

<p>A more realistic version of the <a href="#xmpl_basic">first example</a>, extracting all blocks that start with {@code "Reference Type:..."} and end with {@code "'File' Attachments:..."}: <i>(<a href="{@docRoot}/com/github/xbn/examples/linefilter/reference_type_through_attachment_blocks_input.txt.txt">input</a>, <a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/ExtractReferenceTypeBlocks.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.ExtractReferenceTypeBlocks("examples\com\github\xbn\examples\linefilter\reference_type_through_attachment_blocks_input.txt")%lineRangeWithReplace(1, true, "(block = NewBlockEntityFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<p>The above example takes advantage of {@link #appendAllBlockLinesX(Appendable to_appendTo, String block_startLine, StripFinalNewLine stripFinalNewline_noIfNull, ChildOnFirstLine childOn1stLine_noIfNull) appendAllBlockLinesX}. Here are two alternatives that behave the same as the above:<ul>
   <li>The block entity in the above example is the filter's {@linkplain #getRootBlock() root block}. This alternative example sets the block <a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/ExtractReferenceTypeBlocksWithChildRoot.html">as a child</a>.</li>
   <li>Uses a <a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/ExtractReferenceTypeBlocksWithChildStealth.html">stealth block entity</a> instead of a block entity--which must be a child (cannot be the root).</li>
</ul>.</p>

<A NAME="xmpl_jd_block_lines"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: Detecting the start and end lines of all JavaDoc blocks in source code</h2>

   <p><a href="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">This Java class</a>, contains a single Java multiline comment (starting with {@code "/}{@code *"} and ending with {@code "*}{@code /"}), and three JavaDoc blocks (starting with {@code "/}{@code **"} and ending with {@code "*}{@code /"}):</p>

   <p>The following reads in the source code, and prints only the line numbers of each JavaDoc block's start and end line. <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/PrintAllJavaDocBlockStartAndEndLineNums.html">full source</a>)</i></p>

   <p>A {@linkplain com.github.xbn.linefilter.entity.StealthBlockEntity stealth block} is used in order to avoid an incorrect &quot;block ended before started&quot; error when the close line in the first Java comment block is encountered. This is because {@code "*}{@code /"} is a valid close line for <i>both Java multi-line comments and JavaDoc blocks</i>. Stealth blocks are not &quot;wanted&quot; or {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept}--they are only to avoid false-positives in another block that shares the same parent.</p>

{@.codelet.and.out com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNums("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(Stealth = NewStealth)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   <p>An alternative way to display an entity's line numbers is to turn on its debugging. This example also contains information on how to print additional debugging information for all or specific lines: <i>(<a href="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">input</a>, <a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(javaDocBlock = NewBlockEntityFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<A NAME="xmpl_strip_cmts_pkgln"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: Strip all Java comment blocks and the package declaration line from a classes source code</h2>

   <p>This is useful for eliminating unnecessary or distracting lines from an example code, which might be displayed in your JavaDoc (which is the concept of <a href="http://codelet.aliteralmind.com">Codelet</a>). <i>(<a href="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">input</a>, <a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/EliminateAllCommentBlocksAndPackageLine.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.EliminateAllCommentBlocksAndPackageLine("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(Filter = new Post)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<A NAME="xmpl_import_simples"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: Extract all simple class names from the import lines in a Java source file</h2>

   <p>This gets the {@linkplain java.lang.Class#getSimpleName() simple class name} from each import line from a <a href="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">Java source file</a>. <i>(<a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/GetAllClassSimpleNamesFromImports.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.GetAllClassSimpleNamesFromImports("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(Filter = new Post)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<A NAME="xmpl_sub_block"></a>
   <h2><a href="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></a> &nbsp; {@code FilteredLineIterator}: Example: Altering the lines in a sub-block</h2>

   <p>This modifies the lines existing within a block that itself only exists within a JavaDoc block. Note the same sub-block as exists in the Java comment is not altered. <i>(<a href="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocksWithSub_input.txt">input</a>, <a href="{@docRoot}/src-html/com/github/xbn/examples/linefilter/GetAllClassSimpleNamesFromImports.html">full source</a>)</i></p>

{@.codelet.and.out com.github.xbn.examples.linefilter.PrintJavaDocBlockSubLinesBolded("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocksWithSub_input.txt")%lineRangeWithReplace(1, true, "(String subModePre)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class FilteredLineIterator extends FilteredIterator<String>  {
   /**
      <p>Create a new instance with a root block entity that matches all lines in the file.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) this}(all_lineItr, return_what,
      <br/> &nbsp; &nbsp; start_mid_end, start_mid_end, start_mid_end
      <br/> &nbsp; &nbsp; dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull, children)</code>
      <br/>Where {@code doKeepStartLine} is {@code true} if {@code start_mid_end} is {@link KeepStartLine#YES YES}</p>

      @param  start_mid_end May not be {@code null}.
    **/
   public FilteredLineIterator(Iterator<String> all_lineItr, Returns return_what, KeepUnmatched start_mid_end, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, TextChildEntity... children)  {
      this(all_lineItr, return_what,
         KeepStartLine.getForBoolean(
            ObjectOrCrashIfNull.get(start_mid_end, "start_mid_end").isYes()),
         KeepMidLines.getForBoolean(start_mid_end.isYes()),
         KeepEndLine.getForBoolean(start_mid_end.isYes()),
         dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
         children);
   }
   /**
      <p>Create a new instance with a root block entity that matches all lines.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) this}(all_lineItr, return_what,
      <br/> &nbsp; &nbsp; keep_rootStart, keep_rootMids, keep_rootEnd
      <br/> &nbsp; &nbsp; dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
      <br/> &nbsp; &nbsp; ({@link com.github.xbn.linefilter.entity.raw.RawChildEntity}&lt;String&gt;[])children)</code>
      <br/>Where {@code doKeepStartLine} is {@code true} if {@code start_mid_end} is {@link KeepStartLine#YES YES}</p>

      @param  keep_rootStart May not be {@code null}.
      @param  keep_rootMids May not be {@code null}.
      @param  keep_rootEnd May not be {@code null}.
    **/
   public FilteredLineIterator(Iterator<String> all_lineItr, Returns return_what, KeepStartLine keep_rootStart, KeepMidLines keep_rootMids, KeepEndLine keep_rootEnd, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, TextChildEntity... children)  {
      this(all_lineItr, return_what,
         keep_rootStart, keep_rootMids, keep_rootEnd,
         dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
         (RawChildEntity<String>[])children);
   }
   /**
      <p>Create a new instance with a root block entity that matches all lines.</p>

      <p>Equal to
<blockquote><pre>{@link #FilteredLineIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity) this}(all_lineItr, return_what, dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull
   {@link com.github.xbn.linefilter.entity.NewBlockEntityFor}.{@link com.github.xbn.linefilter.entity.NewBlockEntityFor#returnKeptUnchanged_Cfg(String, KeepStartLine, KeepMidLines, KeepEndLine, EntityRequired, RawOnOffEntityFilter, Appendable) returnKeptUnchanged_Cfg}(&quot;root&quot;,
      keep_rootStart, keep_rootMids, keep_rootEnd, {@link com.github.xbn.linefilter.entity.EntityRequired}.{@link com.github.xbn.linefilter.entity.EntityRequired#YES YES}, null, null).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(RawChildEntity[]) children}(children).{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#build() build}())</pre></blockquote></p>

      @param  keep_rootStart May not be {@code null}.
      @param  keep_rootMids May not be {@code null}.
      @param  keep_rootEnd May not be {@code null}.
    **/
   public FilteredLineIterator(Iterator<String> all_lineItr, Returns return_what, KeepStartLine keep_rootStart, KeepMidLines keep_rootMids, KeepEndLine keep_rootEnd, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, RawChildEntity<String>[] children)  {
      this(all_lineItr, return_what,
         dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
         NewBlockEntityFor.returnKeptUnchanged_Cfg("root",
               keep_rootStart, keep_rootMids, keep_rootEnd, EntityRequired.YES, null, null).
            children(children).build());
   }
   /**
      <p>Create a new instance from a root block that may or may not match all lines.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.linefilter.FilteredIterator#FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity) super}(all_lineItr, return_what, dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull, root_block)</code>
      @see  #FilteredLineIterator(Iterator, Returns, KeepUnmatched, Appendable, LengthInRange, TextChildEntity...) FilteredLineIterator(..., KeepUnmatched, ...)
      @see  #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, TextChildEntity...) FilteredLineIterator(..., KeepEndLine, ..., TextChildEntity...)
      @see  #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) FilteredLineIterator(..., KeepStartLine, ..., RawChildEntity[])
    **/
   public FilteredLineIterator(Iterator<String> all_lineItr, Returns return_what, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, RawBlockEntity<String> root_block)  {
      super(all_lineItr, return_what, dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull, root_block);
   }
   /**
      @return  <code>{@link #appendAllLines(StringBuilder) appendAllLines}(new StringBuilder()).toString()</code>
    **/
   public String getAllLines()  {
      return  appendAllLines(new StringBuilder()).toString();
   }
   /**
      @param  to_appendTo May not be {@code null}.
      @see  #getAllLines()
    **/
   public StringBuilder appendAllLines(StringBuilder to_appendTo)  {
      try  {
         while(hasNext())  {
            to_appendTo.append(next()).append(LINE_SEP);
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
   /**
      <p>Get the root block as a non-raw block entity.</p>

      @return  <code>(BlockEntity){@link FilteredIterator#getRawRootBlock() getRawRootBlock}()*</code>
      @see  #getActiveChild()
      @since  0.1.2
    **/
   public BlockEntity getRootBlock()  {
      try  {
         return  (BlockEntity)getRawRootBlock();
      }  catch(ClassCastException ccx)  {
         throw  ExceptionUtil.returnCauseSetIntoThrowable(ccx,
            new ClassCastException("getRawRootBlock() (a " + getRawRootBlock().getClass().getName() + " is not a com.github.xbn.linefilter.entity.BlockEntity."));
      }
   }
   /**
      @return  <code>(BlockEntity){@link FilteredIterator#getRawActiveChild() getRawActiveChild}()*</code>
      @see  #getActiveChildSingleLine()
      @see  #getActiveChildBlock()
      @see  FilteredIterator#getActiveChildStealthBlock()
      @see  #getRootBlock()
      @since  0.1.2
    **/
   public TextChildEntity getActiveChild()  {
      try  {
         return  (TextChildEntity)getRawActiveChild();
      }  catch(ClassCastException ccx)  {
         throw  ExceptionUtil.returnCauseSetIntoThrowable(ccx,
            new ClassCastException("getRawActiveChild() (a " + getRawActiveChild().getClass().getName() + " is not a com.github.xbn.linefilter.entity.TextChildEntity."));
      }
   }
   /**
      @return  <code>(BlockEntity){@link FilteredIterator#getRawActiveChildBlock() getRawActiveChildBlock}()*</code>
      @see  #getActiveChild()
      @since  0.1.2
    **/
   public BlockEntity getActiveChildBlock()  {
      try  {
         return  (BlockEntity)getRawActiveChildBlock();
      }  catch(ClassCastException ccx)  {
         throw  ExceptionUtil.returnCauseSetIntoThrowable(ccx,
            new ClassCastException("getRawActiveChildBlock() (a " + getRawActiveChildBlock().getClass().getName() + " is not a com.github.xbn.linefilter.entity.BlockEntity."));
      }
   }
   /**
      @return  <code>(BlockEntity){@link FilteredIterator#getActiveChildStealthBlock() getActiveChildStealthBlock}()*</code>
      @see  #getActiveChild()
      @since  0.1.2
    **/
   public StealthBlockEntity getActiveChildStealthBlock()  {
      try  {
         return  (StealthBlockEntity)getRawActiveChildStealthBlock();
      }  catch(ClassCastException ccx)  {
         throw  ExceptionUtil.returnCauseSetIntoThrowable(ccx,
            new ClassCastException("getRawActiveChildStealthBlock() (a " + getRawActiveChildStealthBlock().getClass().getName() + " is not a com.github.xbn.linefilter.entity.StealthBlockEntity."));
      }
   }
   /**
      @return  <code>(BlockEntity){@link FilteredIterator#getRawActiveChildSingleLine() getRawActiveChildSingleLine}()*</code>
      @see  #getActiveChild()
      @since  0.1.2
    **/
   public SingleLineEntity getActiveChildSingleLine()  {
      try  {
         return  (SingleLineEntity)getRawActiveChildSingleLine();
      }  catch(ClassCastException ccx)  {
         throw  ExceptionUtil.returnCauseSetIntoThrowable(ccx,
            new ClassCastException("getRawActiveChildSingleLine() (a " + getRawActiveChildSingleLine().getClass().getName() + " is not a com.github.xbn.linefilter.entity.SingleLineEntity."));
      }
   }
   /**
      <p>. Set the next line to be returned by {@code next()}.</p>

      <p>This sets {@link #next() next}{@code ()} to {@code altered_body}</p>

      @param  altered_body  <i>Should</i> not be {@code null}.

      @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="raw/FilteredIterator.html#setNextLineReturnTrue(int, O)">FilteredIterator.html#setNextLineReturnTrue</a></code>
    **/
   protected boolean setNextLineReturnTrue(String altered_body)  {
      nextLineNum = getMostRecentLineNum();
      nextLine = altered_body;
      debugNextLine(nextLine);
      return  true;
   }

   /**
      <p>Convenience function for retrieving all lines in a newly active block.</p>

      @since  0.1.2
      @return  <code>{@link #appendAllBlockLines(java.lang.StringBuilder, java.lang.String, com.github.xbn.linefilter.StripFinalNewLine, com.github.xbn.linefilter.ChildOnFirstLine) getAllBlockLines}(new StringBuilder(), block_startLine, stripFinalNewline_noIfNull, childOn1stLine_noIfNull).toString()</code>
    **/
   public String getAllBlockLines(String block_startLine, StripFinalNewLine stripFinalNewline_noIfNull, ChildOnFirstLine childOn1stLine_noIfNull)  {
      return  appendAllBlockLines(new StringBuilder(), block_startLine, stripFinalNewline_noIfNull, childOn1stLine_noIfNull).toString();
   }
   /**
      <p>Convenience function for retrieving all lines in a newly active block.</p>

      @return  <code>{@link #appendAllBlockLinesX(java.lang.StringBuilder, java.lang.String, com.github.xbn.linefilter.StripFinalNewLine, com.github.xbn.linefilter.ChildOnFirstLine) appendAllBlockLinesX}(new StringBuilder(), block_startLine, stripFinalNewline_noIfNull,
      @exception  RTIOException  If an {@link java.io.IOException} is thrown for any reason.
      @since  0.1.2
    **/
   public Appendable appendAllBlockLines(Appendable to_appendTo, String block_startLine, StripFinalNewLine stripFinalNewline_noIfNull, ChildOnFirstLine childOn1stLine_noIfNull)  {
      try  {
         return  appendAllBlockLinesX(to_appendTo, block_startLine, stripFinalNewline_noIfNull, childOn1stLine_noIfNull);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <p>Convenience function for retrieving all lines in a newly active block. This must be called immediately after the start-line in a block or stealth block is detected--before the next call to {@link FilteredIterator#next() next}{@code ()}* is made. (<a href="#xmpl_extract_blocks">Example</a>)</p>

      @param  to_appendTo May not be {@code null}.
      @param  block_startLine  The text of the just-retrieved block start-line. <i>Should</i> not be {@code null}.
      @param  stripFinalNewline_noIfNull  If {@link StripFinalNewLine#YES YES}, then a {@linkplain com.github.xbn.lang.XbnConstants#LINE_SEP new-line} is not appended to the final line in the block. If {@link StripFinalNewLine#NO NO} (or {@code null}), a new-line is appended.
      @param  childOn1stLine_noIfNull  For when the the first line in the root block happens to also be the first line in a child-block. If {@link ChildOnFirstLine#YES YES}, then the child-block is retrieved. If {@link ChildOnFirstLine#NO NO} (or {@code null}), the root-block is retrieved. If there is no child block, this must be {@code NO}.
      @return  {@code to_appendTo}, with all lines in the block appended (and, in the case of a non-stealth block, potentially altered).
      @exception  IllegalArgumentException  If this is <ul>
         <li>The first line in the input file, {@code childOn1stLine_noIfNull} is<ul>
            <li>{@code NO}, and this is not the {@linkplain #getRootBlock() root block}'s {@linkplain com.github.xbn.linefilter.entity.BlockEntity#isStartLine() start line}.</li>
            <li>{@code YES}, and there is no {@linkplain #hasActiveChild() active child}.</li>
         </ul></li>
         <li>Not the first line in the input file and there is no active child.</li>
      </ul>
      @exception  ClassCastException  If the active child is a {@linkplain #getActiveChildSingleLine() single-line entity}.
      @exception  LineEntityException  If the child block is active but, at the moment this function is called, it's not the start line.
      @see  #getAllBlockLines(String, StripFinalNewLine, ChildOnFirstLine) getAllBlockLines
      @see  #appendAllBlockLines(Appendable, String, StripFinalNewLine, ChildOnFirstLine) appendAllBlockLines
      @since  0.1.2
    **/
   public Appendable appendAllBlockLinesX(Appendable to_appendTo, String block_startLine, StripFinalNewLine stripFinalNewline_noIfNull, ChildOnFirstLine childOn1stLine_noIfNull) throws IOException  {
      childOn1stLine_noIfNull = ((childOn1stLine_noIfNull == null)
         ?  ChildOnFirstLine.NO
         :  childOn1stLine_noIfNull);

      if(getRootBlock().isStartLine()  &&  childOn1stLine_noIfNull.isNo())  {
         to_appendTo.append(block_startLine);
         while(hasNext())  {
            to_appendTo.append(LINE_SEP);
            String nextLn = next();
            if(getRootBlock().isEndLine())  {
               return  appendNewlnToLast(to_appendTo, nextLn, stripFinalNewline_noIfNull);
            }
            to_appendTo.append(nextLn);
         }

         //End line is optional. End of input reached.
         return  appendNewlnMaybe(to_appendTo, stripFinalNewline_noIfNull);
      }

      if(!hasActiveChild())  {
         throw  new IllegalArgumentException("getRootBlock().isStartLine()=" + getRootBlock().isStartLine() + ", hasActiveChild()=false, and childOn1stLine_noIfNull." + childOn1stLine_noIfNull + ". this=" + this);
      }

      //There is an active child (throws a ClassCastException if not a block)
      RawBlockChildEntity<String> child = null;
      try  {
         child = (getActiveChildType().isBlock()
            ?  getActiveChildBlock()
            :  getActiveChildStealthBlock());
      }  catch(ClassCastException ccx)  {
         throw  ExceptionUtil.returnCauseSetIntoThrowable(ccx,
            new ClassCastException("getActiveChildType()." + getActiveChildType() + ", getRootBlock().isStartLine()=" + getRootBlock().isStartLine() + ", hasActiveChild()=false, and childOn1stLine_noIfNull." + childOn1stLine_noIfNull));
      }

      if(!child.isStartLine())  {
         throw  new LineEntityException(getMostRecentLineNum(), null, child, "getActiveChildBlock().isStartLine() is false.");
      }

      to_appendTo.append(block_startLine);
      while(hasNext())  {
         to_appendTo.append(LINE_SEP);
         String nextLn = next();
         if(child.isEndLine())  {
            return  appendNewlnToLast(to_appendTo, nextLn, stripFinalNewline_noIfNull);
         }
         to_appendTo.append(nextLn);
      }

      //End line is optional. End of input reached.
      return  appendNewlnMaybe(to_appendTo, stripFinalNewline_noIfNull);
   }
      private final Appendable appendNewlnToLast(Appendable to_appendTo, String last_line, StripFinalNewLine stripFinalNewline_noIfNull) throws IOException  {
         to_appendTo.append(last_line);
         return  appendNewlnMaybe(to_appendTo, stripFinalNewline_noIfNull);
      }
      private final Appendable appendNewlnMaybe(Appendable to_appendTo, StripFinalNewLine stripFinalNewline_noIfNull) throws IOException  {
         return  ((stripFinalNewline_noIfNull != null  &&
               stripFinalNewline_noIfNull.isYes())
            ?  to_appendTo
            :  to_appendTo.append(LINE_SEP));
      }
}
