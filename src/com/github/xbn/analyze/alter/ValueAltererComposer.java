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
package  com.github.xbn.analyze.alter;
/**
	<p>For classes that need to implement {@code AltererComposer}, that cannot extend {@code AbstractAlterer}.</p>

	@see  AbstractAlterer
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ValueAltererComposer<V,A> extends AltererComposer  {
//constructors...START
	/**
		<p>Create a new {@code ValueAltererComposer}.</p>

		YYY
	 **/
	public ValueAltererComposer()  {
		super();
	}
	public ValueAltererComposer(AlterationRequired required)  {
		super(required);
	}
	public ValueAltererComposer(boolean ignored, ValueAltererComposer to_copy)  {
		super(ignored, to_copy);
	}
	/**
		<p>Create a new {@code ValueAltererComposer} as a duplicate of another.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@link com.github.xbn.analyze.alter.AltererComposer#AltererComposer(Alterer) super}{@code (to_copy)}</p>

		@param  to_copy  May not be {@code null}.
	 **/
	public ValueAltererComposer(ValueAlterer<V,A> to_copy)  {
		super(to_copy);
	}

//static...START
	public static final <V,A> A getAltered_selfIfAltererNull(ValueAlterer<V,A> prim_array, V to_validate, A to_alter)  {
		return  ((prim_array == null)
			?  to_alter
			:  prim_array.getAltered(to_validate, to_alter));
	}
	/**
		<p>YYY</p>

		<h1>//MOVE INTERNAL CHECKS LIKE BELOW TO IW...//MOVE INTERNAL CHECKS LIKE BELOW TO IW...</h1>
	public static final <p> P getDeclareSameTypeSubAltered_selfIfSubNull(ValueAltererComposer<p> avb_containsSub, ValueAlterer<p> av_sub, P to_alter)  {
		P o = getAltered_selfIfAltererNull(av_sub, to_alter);
		boolean bNtbd = av_sub.needsToBeDeleted();

		if(bNtbd  &&  o != null)  {
			throw  new IllegalStateException("av_sub.needsToBeDeleted() is true, but av_sub.getAltered(to_alter) returned something non-null: [" + o + "]");
		}

		return  avb_containsSub.declareThenReturnAltered_4prot(bNtbd, o);
	}
	 **/
//static...END
}
