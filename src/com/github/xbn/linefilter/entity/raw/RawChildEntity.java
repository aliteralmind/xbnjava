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
/**
	<p>An entity that may exist in a parent entity.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface RawChildEntity<L> extends RawEntity<L>  {
	/**
		<p>The number of levels this entity is below the root-entity.</p>

		@return  <ul>
			<li>{@code 0}: If this is the root entity.</li>
			<li>{@code 1}: If this is a child of the root entity.</li>
			<li>{@code 2}: If this is a grandchild of the root entity.</li>
			<li><i>etcetera</i></li>
		</ul>
		@see  #getParent()
		@see  #getTopParent()
		@see  #getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange) getCopyWithParentAssigned
	 **/
	int getParentCount();
	/**
		<p>The entity this is contained in.</p>

		@see  #getParentCount()
		@see  #getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange) getCopyWithParentAssigned
	 **/
	RawParentEntity<L> getParent();
	/**
		<p>The root entity this is contained in.</p>

		@see  #getParentCount()
		@see  #getCopyWithParentAssigned(int, RawParentEntity, TextAppenter, LengthInRange) getCopyWithParentAssigned
	 **/
	RawParentEntity<L> getTopParent();
	/**
		<p>Duplicates this entity, and assigns its parent. This function must be called before the entity is used.</p>

		@param  levels_belowRoot  The number of parents this entity is contained in. If zero, this is the {@linkplain #getTopParent() top-most entity}. If one, this is an immediate child of the root entity. If two, a grandchild. May not be less than zero. Get with <code>{@link #getParentCount() getParentCount}()</code>*.
		@param  parent  If {@code null}, this is the root entity. Otherwise this entity has {@linkplain #getParentCount() at least one parent}. It is assumed that this is a valid parent (not the same object as its child, or sibling, for example). Get with {@link #getParent() getParent}{@code ()}* and {@link #getTopParent() getTopParent}{@code ()}*
		@param  dbgAptrEveryLine_ifUseable  If {@linkplain com.github.xbn.io.TextAppenter#isUseable() useable}, information on each line is output by this. Get with {@link #getDebugAptrEveryLine() getDebugAptrEveryLine}{@code ()}. May not be {@code null}.
		@param  range_forEveryLineDebug  The range of lines to debug with {@code dbgAptrEveryLine_ifUseable}. May not be {@code null}. Get with {@link com.github.xbn.linefilter.FilteredIterator#getEveryLineDebugRange() getEveryLineDebugRange}{@code ()}.
	 **/
	RawChildEntity<L> getCopyWithParentAssigned(int levels_belowRoot, RawParentEntity<L> parent, TextAppenter dbgAptrEveryLine_ifUseable, LengthInRange range_forEveryLineDebug);
	/**
		<p>The on-off filter.</p>

		@return  A non-{@code null} filter.
		@see  RawEntity#doAbortIterator()
	 **/
	RawOnOffEntityFilter<L> getFilter();
}
