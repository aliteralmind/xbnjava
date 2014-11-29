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
	import  com.github.xbn.linefilter.Returns;
	import  com.github.xbn.linefilter.entity.raw.NewRawBlockEntityFor;
	import  com.github.xbn.number.LengthInRange;
	import  java.util.Iterator;
/**
	<p>Convenience functions for creating {@code FilteredIterator}s.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewFilteredIteratorFor  {
	/**
		<p>Create a new {@code FilteredIterator} that does nothing: All lines are kept and unaltered.</p>

		@return
<blockquote><pre>new {@link FilteredIterator#FilteredIterator(Iterator, Returns, Appendable, LengthInRange, RawBlockEntity) FilteredLineIterator}(all_lineItr, {@link Returns}.{@link Returns#KEPT KEPT},
	dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
	{@link com.github.xbn.linefilter.entity.NewBlockEntityFor}.&lt;O,L&gt;{@link com.github.xbn.linefilter.entity.raw.NewRawBlockEntityFor#keepAllUnchanged(String) keepAllUnchanged}(&quot;root&quot;, {@link com.github.xbn.linefilter.entity.KeepMatched}.{@link com.github.xbn.linefilter.entity.KeepMatched#YES YES}))</pre></blockquote>
	 **/
	public static final <L> FilteredIterator<L> keepAllLinesUnchanged(Iterator<L> all_lineItr, Appendable dbgEveryLine_ifNonNull, LengthInRange rangeForEveryLineDebug_ifNonNull)  {
		return  new FilteredIterator<L>(all_lineItr, Returns.KEPT,
			dbgEveryLine_ifNonNull, rangeForEveryLineDebug_ifNonNull,
			NewRawBlockEntityFor.<L>keepAllUnchanged("root"));
	}
	public NewFilteredIteratorFor()  {
		throw  new IllegalStateException("Do not instantiate.");
	}
}
