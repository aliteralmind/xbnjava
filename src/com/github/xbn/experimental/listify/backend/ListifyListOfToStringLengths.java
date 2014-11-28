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
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.experimental.listify.CopyElements;
	import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyIntable;
	import  java.util.Iterator;
	import  java.util.List;
	import  com.github.xbn.util.copyval.SimpleNullHandler;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
	<P>Listifier whose virtual elements are the <I>lengths of the {@code toString()}-s</I> of its raw elements.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ListifyListOfToStringLengths<R> extends AbstractListifyIntable  {
//constructors...START
	public ListifyListOfToStringLengths(List<R> list)  {
		super(list);
	}
	public ListifyListOfToStringLengths(List<R> list, NullHandlerForPrimitives<Integer> null_handler)  {
		super(list, null_handler);
	}
	/**
		<P>Create a new {@code ListifyListOfToStringLengths} as a duplicate of another.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.primitiveable.AbstractListifyIntable#AbstractListifyIntable(ListifyIntable) super}{@code (to_copy)}</P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	 **/
	public ListifyListOfToStringLengths(ListifyListOfToStringLengths<R> to_copy)  {
		super(to_copy);
	}
//constructors...END
	@SuppressWarnings("unchecked")
	public List<R> getRawList()  {
		return  (List<R>)getRawObject();
	}
	public final Iterator<Integer> iterator()  {
		try  {
			return  getEListCopyOrNull(NullContainer.BAD, CopyElements.NO).iterator();
		}  catch(RuntimeException rx)  {
			ciRawObjectNull();
			throw  rx;
		}
	}
	public final int getInt(int index)  {
		R e = null;
		try  {
			e = getRawList().get(index);
		}  catch(RuntimeException rx)  {
			ciRawObjectNullOrBadIndex(index);
			throw  rx;
		}
		Integer I = ((e == null) ? null : e.toString().length());
		return  SimpleNullHandler.getCopyCIOrigNullAndActionCrashOrDel(getNullHandlerForPrimitives(), I);
	}
	public final int getSizeNPXOkay()  {
		return  getRawList().size();
	}
	/**
		<P>Duplicate this {@code ListifyListOfToStringLengths}.</P>

		@return  <CODE>(new {@link #ListifyListOfToStringLengths(ListifyListOfToStringLengths) ListifyListOfToStringLengths}&lt;R&gt;(this))</CODE>
	 **/
	public ListifyListOfToStringLengths<R> getObjectCopy()  {
		return  (new ListifyListOfToStringLengths<R>(this));
	}
}
