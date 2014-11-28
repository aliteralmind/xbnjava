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
package  com.github.xbn.list;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.array.NullElement;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.LengthLessThanRequiredException;
	import  java.util.Collection;
/**
	<P>If a collection is invalid, crash. Otherwise, do nothing. This is the same as {@link com.github.xbn.list.CrashIfList} except for the error messages.</P>

	@see  com.github.xbn.lang.CrashIfObject
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CrashIfCollection  {
	/**
		<P>The template for collection error output--Equal to {@code "[%idx%-th element in %name%]"}.</P>

		@see  #bad(String, Collection, String, NullContainer, int, String, NullElement)
	 **/
	static final String COLL_ERR_TMPL = "[%idx%-th element in %name%]";
	/**
		<P>If a collection is {@code null} or has no elements, crash. Otherwise, do nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #empty(Collection, String, NullContainer) empty}(coll, coll_name, {@link com.github.xbn.array.NullContainer}.{@link com.github.xbn.array.NullContainer#BAD BAD})</CODE></P>
	 **/
	public static final void nullEmpty(Collection<?> coll, String coll_name)  {
		empty(coll, coll_name, NullContainer.BAD);
	}
	/**
		<P>If a collection has no elements, crash. Otherwise, do nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #bad(Collection, String, NullContainer, int, String, NullElement, int, String) bad}(coll, coll_name, null_coll, 1, null, {@link com.github.xbn.array.NullElement}.{@link com.github.xbn.array.NullElement#OK OK}, 0, null)</CODE></P>
	 **/
	public static final void empty(Collection<?> coll, String coll_name, NullContainer null_coll)  {
		bad(coll, coll_name, null_coll, 1, null, NullElement.OK, 0, null);
	}
	/**
		<P>If a collection's size is less than a number, crash. Otherwise, do nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #bad(Collection, String, NullContainer, int, String, NullElement, int, String) bad}(coll, coll_name, null_coll, min_allowedLength, min_varName, {@link com.github.xbn.array.NullElement}.{@link com.github.xbn.array.NullElement#OK OK}, 0, null)</CODE></P>
	 **/
	public static final void sizeLessThan(Collection<?> coll, String coll_name, NullContainer null_coll, int min_allowedLength, String min_varName)  {
		bad(coll, coll_name, null_coll, min_allowedLength, min_varName, NullElement.OK, 0, null);
	}
	/**
		<P>If a collection is bad, crash. Otherwise, do nothing.</P>

		<P>Error messages referring to the &quot;x-th element&quot;, mean the x-th element returned by the iterator, where &quot;0-th&quot; is the first.</P>

		@param  coll  The collection to test.
		@param  coll_name  Descriptive name of {@code coll}. <I>Should</I> not be {@code null} or empty.
		@param  null_coll  If {@link NullContainer#BAD BAD}, the collection may not be {@code null}. This parameter may not be {@code null}.
		@param  min_allowedLength  The minimum allowable length. <I>Should</I> not be less than zero.
		@param  min_varName  Descriptive name of {@code min_allowedLength}. <I>Should</I> not be {@code null} or empty.
		@param  null_element  If {@link NullElement#BAD BAD}, elements may not be {@code null}. This parameter may not be {@code null}.
		@param  min_allowedElementLen  The minimum allowable length for each element's {@code toString()}. <I>Should</I> be zero or greater. Intended for collections of strings.
		@param  minElementLen_name  Descriptive name of {@code min_allowedElementLen}.
		@exception  LengthLessThanRequiredException  If the collection's size is less than {@code min_allowedLength}, or the element('s {@code toString()}) length is less than {@code min_allowedElementLen}.
		@exception  NullPointerException  If the collection is {@code null} and {@code null_coll.BAD}, or an element is {@code null}, and {@code null_element.BAD}.
		@see  #nullEmpty(Collection, String) nullEmpty
		@see  #empty(Collection, String, NullContainer) empty
		@see  #sizeLessThan(Collection, String, NullContainer, int, String) lengthLessThan
		@see  CrashIfList#bad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) CrashIfList#bad
		@see  com.github.xbn.text.CrashIfString
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/CrashIfArray.html#bad(E[], java.lang.String, com.github.xbn.array.NullContainer, int, java.lang.String, com.github.xbn.array.NullElement, int, java.lang.String, com.github.xbn.array.Duplicates)">CrashIfArray#bad</A>
	 **/
	public static final void bad(Collection<?> coll, String coll_name, NullContainer null_coll, int min_allowedLength, String min_varName, NullElement null_element, int min_allowedElementLen, String minElementLen_name)  {
		bad(COLL_ERR_TMPL, coll, coll_name, null_coll, min_allowedLength, min_varName, null_element, min_allowedElementLen, minElementLen_name);
	}
	/**
		<P>. Core functionality.</P>

		@param  err_msgTmpl  Error message template. <I>Should</I> not be {@code null} or empty, and <I>should</I> contain two gaps: {@code %name%} and {@code %idx%}. Each of these gaps <I>should</I> only occur once.
		@see  #bad(Collection, String, NullContainer, int, String, NullElement, int, String) bad
		@see  #COLL_ERR_TMPL
		@see  CrashIfList#LIST_ERR_TMPL
	 **/
	static final void bad(String err_msgTmpl, Collection<?> coll, String coll_name, NullContainer null_coll, int min_allowedLength, String min_varName, NullElement null_element, int min_allowedElementLen, String minElementLen_name)  {
		crashForNullnessAndSize(err_msgTmpl, coll, coll_name, null_coll, min_allowedLength, min_varName);
		if(coll == null  ||  coll.size() == 0)  {
			return;
		}

		try  {
			if(null_element.isOk())  {
				if(min_allowedElementLen == 0)  {
					return;
				}

				//min_allowedElementLen > 0 (should be!)

				int idx = 0;
				for(Object o : coll)  {
					if(o != null  &&  o.toString().length() < min_allowedElementLen)  {
						throw  new LengthLessThanRequiredException(
							getXthElementName(err_msgTmpl, coll_name, idx),
							o.toString().length(), min_allowedElementLen, minElementLen_name, null);
					}
					idx++;
				}
				return;
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(null_element, "null_element", null, rx);
		}

		//null_element.BAD

		if(min_allowedElementLen == 0)  {
			int idx = 0;
			for(Object o : coll)  {
				if(o == null)  {
					throw  new NullPointerException(getXthElementName(err_msgTmpl, coll_name, idx));
				}
				idx++;
			}
			return;
		}

		//min_allowedElementLen > 0 (should be!)

		int idx = 0;
		for(Object o : coll)  {
			try  {
				if(o.toString().length() < min_allowedElementLen)  {
					throw  new LengthLessThanRequiredException(
						getXthElementName(err_msgTmpl, coll_name, idx),
						o.toString().length(), min_allowedElementLen, minElementLen_name, null);
				}
			}  catch(NullPointerException npx)  {
				CrashIfObject.nnull(o, getXthElementName(err_msgTmpl, coll_name, idx), null);
			}
			idx++;
		}
	}
	static final void crashForNullnessAndSize(String err_msgTmpl, Collection<?> coll, String coll_name, NullContainer null_coll, int min_allowedLength, String min_varName)  {
		try  {
			if(null_coll.isOk()  &&  coll == null)  {
				return;
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(null_coll, "null_coll", null, rx);
		}

		int size = -1;
		try  {
			size = coll.size();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(coll, coll_name, null, rx);
		}

		if(size < min_allowedLength)  {
			throw  new LengthLessThanRequiredException(coll_name, size, min_allowedLength, min_varName, null);
		}
		if(size == 0)  {
			return;
		}
	}
		private static final String getXthElementName(String template, String coll_name, int index)  {
			return  template.replace("%idx%", new Integer(index).toString()).
				replace("%name%", ((coll_name == null) ? "coll" : coll_name));
		}
}