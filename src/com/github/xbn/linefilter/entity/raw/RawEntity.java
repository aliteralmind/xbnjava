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
package  com.github.xbn.linefilter.entity.raw;
   import  com.github.xbn.number.LengthInRange;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.keyed.Named;
/**
   <P>Represents a set of requirements that may or may not be met by a single line or series of lines (a block). Matched lines may be optionally modified.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface RawEntity<L> extends ValueAlterer<L,L>, Named  {
   /**
      <P>Communicates to an entity that the end of its parent block has reached or, in the case of the root entity, the end of the text file itself.</P>

      @exception  LineFilterException  If this entity is {@linkplain #isRequired() required} but was never found in the input.
    **/
   void declareEndOfInput();
   /**
      <P>Should the just-analyzed line be returned by the filtered iterator?. A kept line may or may not be {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active}.</P>

      <P>An example <A HREF="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic">iterating kept lines</A>.</P>

      <P>Changing the return type to {@link com.github.xbn.linefilter.Returns#ACTIVE ACTIVE} prints only lines that match one of the block's alterers. Note only the mid-lines are kept. Changing {@code "ACTIVE"} to &quot;{@link com.github.xbn.linefilter.Returns#KEPT KEPT}&quot; results in the start and end lines being suppressed:</P>

{@.codelet.and.out com.github.xbn.examples.linefilter.IterateActiveLines:lineRange(1, false, "filteredItr = new FilteredLineIterator", 1, false, "block);", "^      ")}

      @return  If<UL>
         <LI>{@code true}: The line is returned by <CODE><I>{@link com.github.xbn.linefilter.FilteredLineIterator}</I>.{@link com.github.xbn.linefilter.FilteredLineIterator#next() next}()</CODE> (when <CODE><I>{@link com.github.xbn.linefilter.FilteredIterator}</I>.{@link com.github.xbn.linefilter.FilteredIterator#getReturnsWhat() getReturnsWhat}()</CODE> is {@link com.github.xbn.linefilter.Returns#KEPT KEPT})</LI>
         <LI>{@code false}: The line is discarded.</LI>
      </UL>
      @see  RawBlockEntity#doKeepJustAnalyzed()
      @see  RawSingleLineEntity#doKeepJustAnalyzed()
      @see  RawStealthBlockEntity#doKeepJustAnalyzed()
    **/
   boolean doKeepJustAnalyzed();
   /**
      <P>The type of this entity.</P>

      @return  A non-{@code null} enum.
      @see  com.github.xbn.linefilter.FilteredIterator#getActiveChildType()
    **/
   EntityType getType();
   /**
      <P>How many times has this entity been active?.</P>

      @return  If this entity is a<UL>
         <LI>Single-line: The number of lines <I>previous to this one</I> that matched.</LI>
         <LI>Block: The number of times a block has opened and then closed. In other words, this number does not increment until the line <I>after</I> the block's end line.</LI>
      </UL>
      @see  RawLineEntity#incrementFullyActiveCount()
    **/
   int getFullyActiveCount();
   /**
      <P>Was the just-analyzed line part of the entity?. An active line may or may not be {@linkplain #doKeepJustAnalyzed() kept}.</P>

      <P>For a single line entity, &quot;activeness&quot; is determined by whether the just-analyzed line (&quot;the line&quot;) was altered. <I>This does not necessarily mean that the line was <B><U>modified</U></B> in any way,</I> rather that when, after calling
      <BR> &nbsp; &nbsp; <CODE><I>[the-raw-entity]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/alter/ReturnValueUnchanged.html#getAltered(V, A)">getAltered</A>(<I>[the-line]</I>, <I>[the-line]</I>)</CODE>
      <BR>this
      <BR> &nbsp; &nbsp; <CODE><I>{@link com.github.xbn.analyze.alter.ValueAlterer}</I>.{@link com.github.xbn.analyze.alter.ValueAlterer#wasAltered() wasAltered}()</CODE>
      <BR>returns {@code true}. (A line entity <I>is</I> a value alterer--a line-alterer.)</P>

      <P>In many cases, there will be an underlying {@linkplain com.github.xbn.analyze.validate.ValueValidator `validator} that, when the line is deemed &quot;valid&quot; (it &quot;matches&quot; the entity), will result in the line's body-text being returned unchanged.</P>

      <P>Two examples: <A HREF="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic">Match (identify) lines</A> only, <A HREF="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_modify">also modify</A> lines.</P>

      @return  {@code true}  If this entity is a<UL>
         <LI>Single-line: If the just-analyzed line is part of this entity.</LI>
         <LI>Block: If the just-analyzed <I>or any previous</I> line was a {@linkplain RawBlockChildEntity#isStartLine() start-line} (and the {@linkplain RawBlockChildEntity#isEndLine() end line} or {@linkplain #declareEndOfInput() end of input} has not yet been reached), or the just-analyzed line was the end line.</LI>
      </UL>
    **/
   boolean isActive();
   /**
      <P>The outputter for diagnostics on every analyzed line.</P>

      @see  RawChildEntity#getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange)
    **/
   public TextAppenter getDebugAptrEveryLine();
   /**
      <P>YYY</P>

      @see  RawChildEntity#getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange)
    **/
   public LengthInRange getEveryLineDebugRange();
   /**
      <P>Should all remaining lines in the containing {@code FilteredIterator} be discarded?. This is a special potential state returned by the {@link RawChildEntity#getFilter() filter}.</P>
    **/
   boolean doAbortIterator();
   String getDebuggingPrefix();
   int getMostRecentLineNum();
   L getAltered(int line_num, L line_toAnalyze, L line_toAlter);
   /**
      <P>Is this entity required to be found somewhere in the input?.</P>

      @return  <UL>
         <LI>{@code true}: This entity must exist at least once in the input.</LI>
         <LI>{@code false}: This entity is optional.</LI>
      </UL>
      @see  #declareEndOfInput()
    **/
   boolean isRequired();
}
