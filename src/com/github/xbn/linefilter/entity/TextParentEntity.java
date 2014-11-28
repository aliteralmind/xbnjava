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

package  com.github.xbn.linefilter.entity;
	import  java.util.List;
	import  com.github.xbn.linefilter.entity.raw.RawParentEntity;
/**
	<P>A textual entity that may contain zero or more child entities. One entity is always the root.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface TextParentEntity extends RawParentEntity<String>, TextChildEntity  {
	/**
		<P>An immutable list of all child entities.</P>

		@return  A non-{@code null} list. <I>While the list itself is immutable, the elements are not.</I> Making any changes to an element (for example, by resetting its {@linkplain com.github.xbn.analyze.alter.Alterer#resetState() state} or {@linkplain com.github.xbn.analyze.alter.Alterer#resetCounts() counts}, or by directly calling <CODE><I>[an-entity]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/analyze/alter/ValueAlterer.html#getAltered(V,A)">getAltered</A></CODE>) will cause unpredictable behavior.
	 **/
	List<TextChildEntity> getChildList();
}