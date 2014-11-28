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
package  com.github.xbn.util.copyval;
/**
	<P>Implementation of {@code GetValueForNull} using an {@code com.github.xbn.analyze.alter.ValueAlterer&lt;O&gt;}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SimpleNullHandlerForPrimitives<O> extends SimpleNullHandler<O> implements NullHandlerForPrimitives<O>  {
	@SuppressWarnings("unchecked")
	public static final NullHandlerForPrimitives CRASH = new SimpleNullHandlerForPrimitives(ActionForNull.CRASH, null);
	@SuppressWarnings("unchecked")
	public static final NullHandlerForPrimitives DELETE = new SimpleNullHandlerForPrimitives(ActionForNull.DELETE, null);
//constructors...START
	public SimpleNullHandlerForPrimitives(O non_nullReplacement)  {
		super(non_nullReplacement);
	}
	public SimpleNullHandlerForPrimitives(ActionForNull action, O non_nullReplacement)  {
		super(action, non_nullReplacement);
		if(action == ActionForNull.USE_NULL)  {
			throw  new IllegalArgumentException("action is equal to ActionForNull.USE_NULL.");
		}
	}
	/**
		<P>Create a new {@code SimpleNullHandlerForPrimitives} as a duplicate of another.</P>

		<P>This<OL>
			<LI>Calls {@link com.github.xbn.util.copyval.SimpleNullHandler#SimpleNullHandler(SimpleNullHandler) super}{@code (to_copy)}</LI>
			<LI>YYY</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	 **/
	public SimpleNullHandlerForPrimitives(SimpleNullHandlerForPrimitives<O> to_copy)  {
		super(to_copy);
	}
//constructors...END
//other...START
	/**
		<P>Duplicate this {@code SimpleNullHandlerForPrimitives}.</P>

		@return  <CODE>(new {@link #SimpleNullHandlerForPrimitives(SimpleNullHandlerForPrimitives) SimpleNullHandlerForPrimitives}&lt;O&gt;(this))</CODE>
	 **/
	public NullHandler<O> getObjectCopy()  {
		return  (new SimpleNullHandlerForPrimitives<O>(this));
	}
//other...END
}