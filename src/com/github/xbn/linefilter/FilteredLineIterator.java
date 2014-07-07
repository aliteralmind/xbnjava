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
   import  com.github.xbn.linefilter.entity.EntityRequired;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.linefilter.entity.KeepEndLine;
   import  com.github.xbn.linefilter.entity.KeepMidLines;
   import  com.github.xbn.linefilter.entity.KeepStartLine;
   import  com.github.xbn.linefilter.entity.NewBlockEntityFor;
   import  com.github.xbn.linefilter.entity.TextChildEntity;
   import  com.github.xbn.linefilter.entity.TextParentEntity;
   import  com.github.xbn.linefilter.entity.raw.RawBlockEntity;
   import  com.github.xbn.linefilter.entity.raw.RawChildEntity;
   import  com.github.xbn.linefilter.entity.z.BlockEntity_Cfg;
   import  com.github.xbn.number.LengthInRange;
   import  java.util.Iterator;
   import  java.util.List;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>A string iterator that filters another string iterator whose elements are the lines in a text file--keeping or discarding lines that meet certain conditions, and optionally modifying kept lines.</P>

   <P><B>Examples</B><UL>
      <LI><A HREF="#xmpl_basic">A basic example</A></LI>
      <LI><A HREF="#xmpl_modify">Modification</A> of kept lines</LI>
      <LI><A HREF="#xmpl_jd_block_lines">Detecting the start and end lines</A> of all JavaDoc blocks in source code</LI>
      <LI><A HREF="#xmpl_strip_cmts_pkgln">Strip all Java comment blocks</A> and the package declaration line from a classes source code</LI>
      <LI><A HREF="#xmpl_import_simples">Extract all simple class names</A> from the import lines in a Java source file</LI>
      <LI>Altering the lines in a <A HREF="#xmpl_sub_block">sub-block</A></LI>
   </UL></P>

<A NAME="xmpl_basic"></A>
   <H2><A HREF="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></A> &nbsp; {@code FilteredLineIterator}: Example: A basic use</H2>

   <P>This iterates through all lines in a &quot;text file&quot;, keeping only those between a block's &quot;start&quot; and &quot;end&quot; lines. <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/IterateKeptLines.html">full source</A>)</I></P>

   <P><B>Input:</B></P>

{@.codelet com.github.xbn.examples.linefilter.IterateKeptLines%lineRange(1, false, "LINE_SEP = System", 1, false, "inputLineItr = StringUtil", "^         ")}

   <P><B>Code</B>:</P>

{@.codelet.and.out com.github.xbn.examples.linefilter.IterateKeptLines%lineRangeWithReplace(1, true, "(block = NewBlockEntityFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   <P>An alternative way to create the same block entity: <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/IterateKeptLinesManualBlock.html">full source</A>)</I></P>

{@.codelet com.github.xbn.examples.linefilter.IterateKeptLinesManualBlock%lineRange(1, false, "startIdOnly = NewTextLineAltererFor", 1, false, "keepMidsOnly().required", "^      ")}

   <P>The block entity is also the filtered iterator's {@linkplain TextChildEntity#getTopParent() root entity}. An equivalent is to set the block as a child, and then declare that all unmatched lines (those not matched by any child entity) should be discarded: <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/IterateKeptLinesBlockAsChild.html">full source</A>)</I></P>

{@.codelet com.github.xbn.examples.linefilter.IterateKeptLinesBlockAsChild%lineRange(1, false, "tor filteredItr = ne", 1, false, "block);", "^      ")}

<A NAME="xmpl_modify"></A>
   <H2><A HREF="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></A> &nbsp; {@code FilteredLineIterator}: Example: Modification of kept lines</H2>

   <P>Using the same input as above, this makes a simple replacement on each kept line: <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/ModifyBlockLines.html">full source</A>)</I></P>

{@.codelet.and.out com.github.xbn.examples.linefilter.ModifyBlockLines%lineRangeWithReplace(1, true, "(startIdOnly = NewTextLineAltererFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   <P>Any arbitrary modification can be made on kept lines (actually, {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active} lines). A more complicated version of the mid-alterer: <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/MoreComplicatedModifyExample.html">full source</A>)</I></P>

{@.codelet.and.out com.github.xbn.examples.linefilter.MoreComplicatedModifyExample%lineRange(1, false, "IndirectRegexReplacer replaceNumWithStrNum", 1, false, "lineReplacer(replaceNumWithStrNum", "^      ")}

<A NAME="xmpl_jd_block_lines"></A>
   <H2><A HREF="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></A> &nbsp; {@code FilteredLineIterator}: Example: Detecting the start and end lines of all JavaDoc blocks in source code</H2>

   <P><A HREF="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">This Java class</A>, contains a single Java multiline comment (starting with {@code "/}{@code *"} and ending with {@code "*}{@code /"}), and three JavaDoc blocks (starting with {@code "/}{@code **"} and ending with {@code "*}{@code /"}):</P>

   <P>The following reads in the source code, and prints only the line numbers of each JavaDoc block's start and end line. <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/PrintAllJavaDocBlockStartAndEndLineNums.html">full source</A>)</I></P>

   <P>A {@linkplain com.github.xbn.linefilter.entity.StealthBlockEntity stealth block} is used in order to avoid an incorrect &quot;block ended before started&quot; error when the close line in the first Java comment block is encountered. This is because {@code "*}{@code /"} is a valid close line for <I>both Java multi-line comments and JavaDoc blocks</I>. Stealth blocks are not &quot;wanted&quot; or {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#doKeepJustAnalyzed() kept}--they are only to avoid false-positives in another block that shares the same parent.</P>

{@.codelet.and.out com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNums("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(Stealth = NewStealth)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   <P>An alternative way to display an entity's line numbers is to turn on its debugging. This example also contains information on how to print additional debugging information for all or specific lines: <I>(<A HREF="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">input</A>, <A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging.html">full source</A>)</I></P>

{@.codelet.and.out com.github.xbn.examples.linefilter.PrintAllJavaDocBlockStartAndEndLineNumsViaDebugging("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(javaDocBlock = NewBlockEntityFor)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<A NAME="xmpl_strip_cmts_pkgln"></A>
   <H2><A HREF="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></A> &nbsp; {@code FilteredLineIterator}: Example: Strip all Java comment blocks and the package declaration line from a classes source code</H2>

   <P>This is useful for eliminating unnecessary or distracting lines from an example code, which might be displayed in your JavaDoc (which is the concept of <A HREF="http://codelet.aliteralmind.com">Codelet</A>). <I>(<A HREF="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">input</A>, <A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/EliminateAllCommentBlocksAndPackageLine.html">full source</A>)</I></P>

{@.codelet.and.out com.github.xbn.examples.linefilter.EliminateAllCommentBlocksAndPackageLine("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(Filter = new Post)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<A NAME="xmpl_import_simples"></A>
   <H2><A HREF="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></A> &nbsp; {@code FilteredLineIterator}: Example: Extract all simple class names from the import lines in a Java source file</H2>

   <P>This gets the {@linkplain java.lang.Class#getSimpleName() simple class name} from each import line from a <A HREF="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt">Java source file</A>. <I>(<A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/GetAllClassSimpleNamesFromImports.html">full source</A>)</I></P>

{@.codelet.and.out com.github.xbn.examples.linefilter.GetAllClassSimpleNamesFromImports("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocks_input.txt")%lineRangeWithReplace(1, true, "(Filter = new Post)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

<A NAME="xmpl_sub_block"></A>
   <H2><A HREF="#skip-navbar_top"><IMG SRC="{@docRoot}/resources/up_arrow.gif"/></A> &nbsp; {@code FilteredLineIterator}: Example: Altering the lines in a sub-block</H2>

   <P>This modifies the lines existing within a block that itself only exists within a JavaDoc block. Note the same sub-block as exists in the Java comment is not altered. <I>(<A HREF="{@docRoot}/com/github/xbn/examples/linefilter/JavaClassWithOneCommentAndTwoJavaDocBlocksWithSub_input.txt">input</A>, <A HREF="{@docRoot}/src-html/com/github/xbn/examples/linefilter/GetAllClassSimpleNamesFromImports.html">full source</A>)</I></P>

{@.codelet.and.out com.github.xbn.examples.linefilter.PrintJavaDocBlockSubLinesBolded("examples\com\github\xbn\examples\linefilter\JavaClassWithOneCommentAndTwoJavaDocBlocksWithSub_input.txt")%lineRangeWithReplace(1, true, "(String subModePre)", "$1", "FIRST", 1, true, " +//End snippet$", "", "FIRST", "^      ")}

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class FilteredLineIterator extends FilteredIterator<String>  {
   /**
      <P>Create a new instance with a root block entity that matches all lines in the file.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) this}(all_lineItr, return_what,
      <BR> &nbsp; &nbsp; start_mid_end, start_mid_end, start_mid_end
      <BR> &nbsp; &nbsp; dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull, children)</CODE>
      <BR>Where {@code doKeepStartLine} is {@code true} if {@code start_mid_end} is {@link KeepStartLine#YES YES}</P>

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
      <P>Create a new instance with a root block entity that matches all lines.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) this}(all_lineItr, return_what,
      <BR> &nbsp; &nbsp; keep_rootStart, keep_rootMids, keep_rootEnd
      <BR> &nbsp; &nbsp; dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
      <BR> &nbsp; &nbsp; ({@link com.github.xbn.linefilter.entity.raw.RawChildEntity}&lt;String&gt;[])children)</CODE>
      <BR>Where {@code doKeepStartLine} is {@code true} if {@code start_mid_end} is {@link KeepStartLine#YES YES}</P>

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
      <P>Create a new instance with a root block entity that matches all lines.</P>

      <P>Equal to
<BLOCKQUOTE><PRE>{@link #FilteredLineIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity) this}(all_lineItr, return_what, dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull
   {@link com.github.xbn.linefilter.entity.NewBlockEntityFor}.{@link com.github.xbn.linefilter.entity.NewBlockEntityFor#returnKeptUnchanged_Cfg(String, KeepStartLine, KeepMidLines, KeepEndLine, EntityRequired, RawOnOffEntityFilter, Appendable) returnKeptUnchanged_Cfg}(&quot;root&quot;,
      keep_rootStart, keep_rootMids, keep_rootEnd, {@link com.github.xbn.linefilter.entity.EntityRequired}.{@link com.github.xbn.linefilter.entity.EntityRequired#YES YES}, null, null).
   {@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#children(RawChildEntity[]) children}(children).{@link com.github.xbn.linefilter.entity.z.BlockEntity_CfgForNeeder#build() build}())</PRE></BLOCKQUOTE></P>

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
      <P>Create a new instance from a root block that may or may not match all lines.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.linefilter.FilteredIterator#FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity) super}(all_lineItr, return_what, dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull, root_block)</CODE>
      @see  #FilteredLineIterator(Iterator, Returns, KeepUnmatched, Appendable, LengthInRange, TextChildEntity...) FilteredLineIterator(..., KeepUnmatched, ...)
      @see  #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, TextChildEntity...) FilteredLineIterator(..., KeepEndLine, ..., TextChildEntity...)
      @see  #FilteredLineIterator(Iterator, Returns, KeepStartLine, KeepMidLines, KeepEndLine, Appendable, LengthInRange, RawChildEntity[]) FilteredLineIterator(..., KeepStartLine, ..., RawChildEntity[])
    **/
   public FilteredLineIterator(Iterator<String> all_lineItr, Returns return_what, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull, RawBlockEntity<String> root_block)  {
      super(all_lineItr, return_what, dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull, root_block);
   }
   /**
      @return  <CODE>{@link #appendAllLines(StringBuilder) appendAllLines}(new StringBuilder()).toString()</CODE>
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
      <P>. Set the next line to be returned by {@code next()}.</P>

      <P>This sets {@link #next() next}{@code ()} to {@code altered_body}</P>

      @param  altered_body  <I>Should</I> not be {@code null}.

      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="raw/FilteredIterator.html#setNextLineReturnTrue(int, O)">FilteredIterator.html#setNextLineReturnTrue</A></CODE>
    **/
   protected boolean setNextLineReturnTrue(String altered_body)  {
      nextLineNum = getMostRecentLineNum();
      nextLine = altered_body;
      debugNextLine(nextLine);
      return  true;
   }
   /*
      <P>Get the root block as a {@code TextParentEntity}.</P>

      @return  <CODE>(TextParentEntity){@link FilteredIterator super}.{@link FilteredIterator#getRootBlock() getRootBlock}()</CODE>
   public TextParentEntity getRootBlock()  {
      return  (TextParentEntity)super.getRootBlock();
   }
    */
   /*
      <P>Get the active child entity as a {@code TextChildEntity}.</P>

      @return  <CODE>(TextChildEntity){@link #getRootBlock() getRootBlock}().{@link com.github.xbn.linefilter.entity.TextParentEntity#getActiveChild() getActiveChild}()</CODE>
   public TextChildEntity getActiveChild()  {
      return  (TextChildEntity)getRootBlock().getActiveChild();
   }
    */
   /*
      <P>Get an immutable list of all child entities.</P>

      @return  <CODE>(TextChildEntity){@link #getRootBlock() getRootBlock}().{@link com.github.xbn.linefilter.entity.TextParentEntity#getActiveChild() getActiveChild}()</CODE>
   List<TextChildEntity> getEntityList()  {
      return  getRootBlock().getChildList();
   }
    */
}
