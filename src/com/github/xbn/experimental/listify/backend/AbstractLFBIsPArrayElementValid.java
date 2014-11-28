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
package  com.github.xbn.experimental.listify.backend;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
	<P>For building listifiers whose raw object is a primitive array, and whose virtual elements are booleans expressing the <I>validity</I> of those primitive elements.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractLFBIsPArrayElementValid<R> extends AbstractListifyBooleanValidity<R>  {
//constructors...START
	private PrimitiveArrayHelper<R> pah = null;
	public AbstractLFBIsPArrayElementValid(Object array, PrimitiveArrayHelper<R> array_helper, ValueValidator<R> raw_elementVldtr)  {
		super(array, raw_elementVldtr);
	}
	public AbstractLFBIsPArrayElementValid(Object array, PrimitiveArrayHelper<R> array_helper, ValueValidator<R> raw_elementVldtr, NullHandlerForPrimitives<Boolean> null_handler)  {
		super(array, raw_elementVldtr, null_handler);
	}
	public AbstractLFBIsPArrayElementValid(AbstractLFBIsPArrayElementValid<R> to_copy)  {
		super(to_copy);
		pah = to_copy.pah;
	}
//constructors...END
	public final int getSizeNPXOkay()  {
		return  pah.getLength(getRawObject(), "getRawObject()");
	}
	protected R getRawElementRTXOkay(int index)  {
		return  pah.getWrapper(getRawObject(), index, "getRawObject()");
	}
/*stub functions for non-abstract compile...START
	public final Iterator<Boolean> iterator()  {
//		return  NewArrayIterator.forIsElementValid(getRawArray(), getVVRawElement());
		return  null;
	}
 stub functions for non-abstract compile...END*/
}
