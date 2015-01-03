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
   <p>Represents a set of requirements that may or may not be met by a single line or series of lines (a block). Matched lines may be optionally modified.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface RawEntity<L> extends ValueAlterer<L,L>, Named  {
   /**
      <p>Communicates to an entity that the end of its parent block has reached or, in the case of the root entity, the end of the text file itself.</p>

    * @exception  LineFilterException  If this entity is {@linkplain #isRequired() required} but was never found in the input.
    */
   void declareEndOfInput();
   /**
      <p>Should the just-analyzed line be returned by the filtered iterator?. A kept line may or may not be {@linkplain com.github.xbn.linefilter.entity.raw.RawEntity#isActive() active}.</p>

      <p>An example <a href="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic">iterating kept lines</a>.</p>

      <p>Changing the return type to {@link com.github.xbn.linefilter.Returns#ACTIVE ACTIVE} prints only lines that match one of the block's alterers. Note only the mid-lines are kept. Changing {@code "ACTIVE"} to &quot;{@link com.github.xbn.linefilter.Returns#KEPT KEPT}&quot; results in the start and end lines being suppressed:</p>

{@.codelet.and.out com.github.xbn.examples.linefilter.IterateActiveLines%lineRange(1, false, "filteredItr = new FilteredLineIterator", 1, false, "block);", "^      ")}

    * @return  If<ul>
         <li>{@code true}: The line is returned by <code><i>{@link com.github.xbn.linefilter.FilteredLineIterator}</i>.{@link com.github.xbn.linefilter.FilteredLineIterator#next() next}()</code> (when <code><i>{@link com.github.xbn.linefilter.FilteredIterator}</i>.{@link com.github.xbn.linefilter.FilteredIterator#getReturnsWhat() getReturnsWhat}()</code> is {@link com.github.xbn.linefilter.Returns#KEPT KEPT})</li>
         <li>{@code false}: The line is discarded.</li>
      </ul>
    * @see  RawBlockEntity#doKeepJustAnalyzed()
    * @see  RawSingleLineEntity#doKeepJustAnalyzed()
    * @see  RawStealthBlockEntity#doKeepJustAnalyzed()
    */
   boolean doKeepJustAnalyzed();
   /**
      <p>The type of this entity.</p>

    * @return  A non-{@code null} enum.
    * @see  com.github.xbn.linefilter.FilteredIterator#getActiveChildType()
    */
   EntityType getType();
   /**
      <p>How many times has this entity been active?.</p>

    * @return  If this entity is a<ul>
         <li>Single-line: The number of lines <i>previous to this one</i> that matched.</li>
         <li>Block: The number of times a block has opened and then closed. In other words, this number does not increment until the line <i>after</i> the block's end line.</li>
      </ul>
    * @see  RawLineEntity#incrementFullyActiveCount()
    */
   int getFullyActiveCount();
   /**
      <p>Was the just-analyzed line part of the entity?. An active line may or may not be {@linkplain #doKeepJustAnalyzed() kept}.</p>

      <p>For a single line entity, &quot;activeness&quot; is determined by whether the just-analyzed line (&quot;the line&quot;) was altered. <i>This does not necessarily mean that the line was <b><u>modified</u></b> in any way,</i> rather that when, after calling
      <br> &nbsp; &nbsp; <code><i>[the-raw-entity]</i>.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/analyze/alter/ReturnValueUnchanged.html#getAltered(V, A)">getAltered</a>(<i>[the-line]</i>, <i>[the-line]</i>)</code>
      <br>this
      <br> &nbsp; &nbsp; <code><i>{@link com.github.xbn.analyze.alter.ValueAlterer}</i>.{@link com.github.xbn.analyze.alter.ValueAlterer#wasAltered() wasAltered}()</code>
      <br>returns {@code true}. (A line entity <i>is</i> a value alterer--a line-alterer.)</p>

      <p>In many cases, there will be an underlying {@linkplain com.github.xbn.analyze.validate.ValueValidator `validator} that, when the line is deemed &quot;valid&quot; (it &quot;matches&quot; the entity), will result in the line's body-text being returned unchanged.</p>

      <p>Two examples: <a href="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_basic">Match (identify) lines</a> only, <a href="{@docRoot}/com/github/xbn/linefilter/package-summary.html#xmpl_modify">also modify</a> lines.</p>

    * @return  {@code true}  If this entity is a<ul>
         <li>Single-line: If the just-analyzed line is part of this entity.</li>
         <li>Block: If the just-analyzed <i>or any previous</i> line was a {@linkplain RawBlockChildEntity#isStartLine() start-line} (and the {@linkplain RawBlockChildEntity#isEndLine() end line} or {@linkplain #declareEndOfInput() end of input} has not yet been reached), or the just-analyzed line was the end line.</li>
      </ul>
    */
   boolean isActive();
   /**
      <p>The outputter for diagnostics on every analyzed line.</p>

    * @see  RawChildEntity#getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange)
    */
   public TextAppenter getDebugAptrEveryLine();
   /**
      <p>YYY</p>

    * @see  RawChildEntity#getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange)
    */
   public LengthInRange getEveryLineDebugRange();
   /**
      <p>Should all remaining lines in the containing {@code FilteredIterator} be discarded?. This is a special potential state returned by the {@link RawChildEntity#getFilter() filter}.</p>
    */
   boolean doAbortIterator();
   String getDebuggingPrefix();
   int getMostRecentLineNum();
   L getAltered(int line_num, L line_toAnalyze, L line_toAlter);
   /**
      <p>Is this entity required to be found somewhere in the input?.</p>

    * @return  <ul>
         <li>{@code true}: This entity must exist at least once in the input.</li>
         <li>{@code false}: This entity is optional.</li>
      </ul>
    * @see  #declareEndOfInput()
    */
   boolean isRequired();
}
