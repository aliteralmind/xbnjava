/*license*\
	Codelet

	XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

	Copyright (C) 2014, Jeff Epstein

	This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

	This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

	You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.linefilter.alter;
	import  com.github.xbn.analyze.alter.ExpirableElements;
	import  com.github.xbn.analyze.alter.MultiAlterType;
	import  com.github.xbn.analyze.alter.ExpirableAlterList;
	import  com.github.xbn.analyze.alter.ValueAlterer;
/**
	<P>For a series of alterers that expire--once an item is expired, it is removed from the list.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ExpirableRawLineAlterList<L> extends ExpirableAlterList<L,L>  {
	/*
		<P>Create a new instance in which expirable elements are optional, and {@code null} elements are forbidden.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.analyze.alter.ExpirableAlterList#ExpirableAlterList(MultiAlterType, MultiAlterType) this}(line_alterers, multi_alterType)</CODE></P>
	public ExpirableRawLineAlterList(ValueAlterer<L,L>[] line_alterers, MultiAlterType multi_alterType)  {
		super(line_alterers, multi_alterType);
	}
	 */
	/**
		<P>Create a new instance.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.analyze.alter.ExpirableAlterList#ExpirableAlterList(ValueAlterer[], ExpirableElements, MultiAlterType, Appendable) super}(line_alterers, xprbl_lmntsAre, multi_alterType, debug_ifNonNull)</CODE></P>
	 **/
	public ExpirableRawLineAlterList(ValueAlterer<L,L>[] line_alterers, ExpirableElements xprbl_lmntsAre, MultiAlterType multi_alterType, Appendable debug_ifNonNull)  {
		super(line_alterers, xprbl_lmntsAre, multi_alterType, debug_ifNonNull);
	}
	public ExpirableRawLineAlterList(ExpirableRawLineAlterList<L> to_copy)  {
		super(to_copy);
	}
	/**
		<P>Duplicate this <CODE>ExpirableRawLineAlterList</CODE>.</P>

		@return  <CODE>(new <A HREF="#ExpirableRawLineAlterList(ExpirableRawLineAlterList)">ExpirableRawLineAlterList</A>&lt;O&gt;(this))</CODE>
	 **/
	public ExpirableRawLineAlterList<L> getObjectCopy()  {
		return  (new ExpirableRawLineAlterList<L>(this));
	}
}