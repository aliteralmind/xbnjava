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
package  com.github.xbn.array;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.util.copyval.ValueCopier;
	import  java.util.ArrayList;
	import  java.util.Arrays;
	import  java.util.List;
/**
	<P>Utilities related to non-primitive arrays, including error checking and conversion to other non-primitive containers.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ArrayUtil  {
	public static final StringBuilder[] asdEMPTY = new StringBuilder[0];
	/**
		<P>Same as <CODE>Arrays.toString</CODE>, with the addition of highlighting a single element.</P>

		@return  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#appendToString(java.lang.StringBuilder, E[], java.lang.String, int, java.lang.String)">appendToString</A>(new StringBuilder(), array, prefix, index, postfix).toString()</CODE>
	 **/
	public static final <E> String toStringHighlightElement(E[] array, String prefix, int index, String postfix)  {
		return  appendToStringHighlightElement(new StringBuilder(), array, prefix, index, postfix).toString();
	}
	/**
		<P>Same as <CODE>{@link java.util.Arrays}.{@link java.util.Arrays#toString(Object[]) toString}</CODE>, with the addition of highlighting a single element.</P>

		@param  to_appendTo May not be {@code null}.
		@param  array  May not be {@code null}.
		@param  prefix  Placed before the highlighted element. <I>Should</I> not be {@code null} or empty.
		@param  index  The element to highlight. <I>Should</I> be a valid index.
		@param  postfix  Placed after the highlighted element.
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#toStringHighlightElement(E[], java.lang.String, int, java.lang.String)">toStringHighlightElement</A></CODE>
	 **/
	public static final <E> StringBuilder appendToStringHighlightElement(StringBuilder to_appendTo, E[] array, String prefix, int index, String postfix)  {
		try  {
//			int lenMinus1 = array.length - 1;
			for(int i = 0; i < array.length; i++)  {
				if(i == index)  {
					to_appendTo.append(prefix);
				}
				to_appendTo.append(array[i]);
				if(i == index)  {
					to_appendTo.append(postfix);
				}
				if(i < array.length - 1)  {
					to_appendTo.append(", ");
				}
			}
		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(to_appendTo, "to_appendTo", null);
			throw  CrashIfObject.nullOrReturnCause(array, "array", null, rx);
		}
		return  to_appendTo;
	}
	/**
		<P>Get the length of an array, or crash if it's {@code null}.</P>

		@param  array  The array whose length is needed.
		@param  array_name  Descriptive name of {@code coll}. <I>Should</I> be non-{@code null} and non-empty.
		@return  {@code array.length}
		@exception  NullPointerException  If {@code array} is {@code null}.
	 **/
	public static final <E> int getLengthCrashIfNull(E[] array, String array_name)  {
		try  {
			return  array.length;
		}  catch(RuntimeException rx)    {
			throw  CrashIfObject.nullOrReturnCause(array, array_name, null, rx);
		}
	}
	/**
		<P>Get a new non-primitive array, from another of a potentially different type.</P>

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</A>(E[],vc,b,s)</CODE>
	 **/
	public static final <U,T> T[] getArrayCopyNewType(U[] original, Class<? extends T[]> new_type)  {
		if(original == null)  {
			return  null;
		}
		try  {
			return  Arrays.copyOf(original, original.length, new_type);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(new_type, "new_type", null, rx);
		}
	}
	/**
		<P>Get a new object array from a non-primitive array.</P>

		@param  get_valCopy  If non-{@code null}, all elements are duplicated. When {@code null}, the original elements are referenced. When non-{@code null}, <CODE>get_valCopy.{@link com.github.xbn.util.copyval.ValueCopier#isValueCopyable() isValueCopyable}()</CODE> must be {@code true}.
		@param  nnull  If non-{@code null}, {@code array} may not be {@code null}. This is the name of the function calling this one. It <I>should</I> not be empty.

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getStringListOrNull(E[], java.lang.String, java.lang.String)">getStringListOrNull</A>(E[],s,s)</CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getObjectListOrNull(E[], xbn.util.copyval.ValueCopier, java.lang.String, java.lang.String)">getObjectListOrNull</A>(E[],vc,s,s)</CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getListOrNull(E[], xbn.util.copyval.ValueCopier, java.lang.String, java.lang.String)">getListOrNull</A>(E[],vc,s,s)</CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getArrayCopyNewType(U[], java.lang.Class)">getArrayCopyNewType</A>(U[],cls)</CODE>
	 **/
	public static final <E> Object[] getObjectArrayOrNull(E[] array, ValueCopier<E> get_valCopy, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(get_valCopy == null)  {
			return  (Arrays.asList(array).toArray(new Object[array.length]));
		}

		Object[] ao = new Object[array.length];
		for(int i = 0; i < ao.length; i++)  {
			ao[i] = (Object)get_valCopy.getValueCopy(array[i], "array[i]");
		}
		return  ao;
	}

	/**
		<P>Get a new string array from a non-primitive array.</P>

		@param  array  The array to convert.
		@param  nnull  If {@code false}, then {@code array} may not be {@code null}.
		@param  cntrName_forNullBad  Descriptive name for {@code array}. When {@code null_ok} is {@code true}, this is ignored.
		@return  If {@code array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>Non-{@code null}: A new string array containing each element's {@code toString()}, in the same order. If an element is {@code null}, it's corresponding element in the returned array is also {@code null}.</LI>
		</UL>
	 **/
	public static final <E> String[] getStringArrayOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		String[] as = new String[array.length];
		for(int i = 0; i < array.length; i++)  {
			E e = array[i];
			as[i] = ((e == null) ? null : e.toString());
		}
		return  as;
	}
	/**
		<P>Get the middle index of a non-primitive array.</P>

		@param  array  May not be {@code null}.
		@return  <CODE>{@link com.github.xbn.array.IndexableUtil IndexableUtil}.{@link com.github.xbn.array.IndexableUtil#getMiddleIndex(int) getMiddleIndex}(array.length)</CODE>

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getNonPArrayElementTSLengthIterator(E[])">getNonPArrayElementTSLengthIterator</A>(E[])</CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="forIsElementValid(R[], xbn.analyze.validate.ValueValidator)">forIsElementValid</A>(R[],vv)</CODE>
	 **/
	public static final <E> int getMiddleIndex(E[] array)  {
		try  {
			return  IndexableUtil.getMiddleIndex(array.length);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(array, "array", null, rx);
		}
	}
	/**
		<P>Get a string list from a non-primitive array.</P>

		@param  array  The array to convert.
		@param  nnull  If {@code false}, then {@code array} may not be {@code null}.
		@param  cntrName_forNullBad  Descriptive name for {@code array}. When {@code null_ok} is {@code true}, this is ignored.
		@return  If {@code array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>Non-{@code null}: A new list of strings, containing every element's {@code toString()}, or {@code null} if it's {@code null}.</LI>
		</UL>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</A>(E[],vc,b,s)</CODE>
	 **/
	public static final <E> List<String> getStringListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		ArrayList<String> vs = new ArrayList<String>(array.length);
		for(int i = 0; i < array.length; i++)  {
			E o = array[i];
			vs.add(((o == null) ? null : o.toString()));
		}
		return  vs;
	}
	/**
		<P>Get an object list from a non-primitive array.</P>

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</A>(E[],vc,b,s)</CODE>
	 **/
	public static final <E> List<Object> getObjectListOrNull(E[] array, ValueCopier<E> get_valCopy, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		ArrayList<Object> vs = new ArrayList<Object>(array.length);
		if(get_valCopy == null)  {
			for(int i = 0; i < array.length; i++)  {
				vs.add((Object)array[i]);
			}
		}  else  {

			for(int i = 0; i < array.length; i++)  {
				vs.add((Object)get_valCopy.getValueCopy(array[i], "array[i]"));
			}
		}
		return  vs;
	}
	/**
		<P>Get a list of the element-type, from a non-primitive array.</P>

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</A>(E[],vc,b,s)</CODE>
	 **/
	public static final <E> List<E> getListOrNull(E[] array, ValueCopier<E> get_valCopy, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		if(get_valCopy == null)  {
			return  Arrays.asList(array);
		}  else  {
			ArrayList<E> ve = new ArrayList<E>(array.length);

			for(int i = 0; i < array.length; i++)  {
				ve.add(get_valCopy.getValueCopy(array[i], "array[i]"));
			}

			return  ve;
		}
	}
	public static final <E> E getElementOrCrash(E[] array, int index, String array_name)  {
		try  {
			return  array[index];
		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new ArrayIndexOutOfBoundsException("index (" + index + ") invalid given " + array_name + ".length is " + array.length + ".");
		}
	}
	/*
		<P>Get a list containing a primitive array's elements, in its wrapper-type, or {@code null} if it's {@code null}.</P>

		@param  nnull  If non-{@code null}, then {@code array} may not be {@code null}. This is used for the potential error message, and <I>should</I> not be empty.
		@return  If {@code array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null}:
			<BR> &nbsp; &nbsp; {@code Arrays.asList(array)}</LI>
		</UL>
	public static final <E> List<E> getListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		return  Arrays.asList(array);
	}
	 */
	/*
		<P>Get a {@code java.util.List&lt;Object&gt;} containing all elements from a primitive array.</P>

		@param  nnull  If non-{@code null}, then {@code array} may not be {@code null}. This is used for the potential error message, and <I>should</I> not be empty.
		@return  If {@code array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null}: A new object-list, containing all elements from {@code array}</LI>
		</UL>
	public static final <E> List<Object> getObjectListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		ArrayList<Object> vo = new ArrayList<Object>(array.length);
		for(int i = 0; i < array.length; i++)  {
			vo.add((Object)array[i]);
		}

		return  vo;
	}
	 */
	/*
		<P>Get a {@code java.util.List&lt;String&gt;} containing all elements from a primitive array.</P>

		@param  nnull  If non-{@code null}, then {@code array} may not be {@code null}. This is used for the potential error message, and <I>should</I> not be empty.
		@return  If {@code array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null}: A new string-list, containing all elements from {@code array}</LI>
		</UL>
	public static final <E> List<String> getStringListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
		if(array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		ArrayList<String> vo = new ArrayList<String>(array.length);
		for(int i = 0; i < array.length; i++)  {
			E o = array[i];
			vo.add(((o == null) ? null : o.toString()));
		}
		return  vo;
	}
	 */
	private ArrayUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
}
