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
	import  java.util.Arrays;
	import  com.github.xbn.lang.BadDuplicateException;
	import  com.github.xbn.array.Duplicates;
	import  com.github.xbn.array.NullElement;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.LengthLessThanRequiredException;
	import  java.util.Objects;
/**
	<P>If a non-primitive array is bad, crash. Otherwise, do nothing.</P>

	@see  com.github.xbn.lang.CrashIfObject
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CrashIfArray  {
	/**
		<P>If an array is {@code null} or empty, crash. Otherwise, do nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#empty(E[], java.lang.String, com.github.xbn.array.NullContainer)">empty</A>(array, array_name, {@link NullContainer}.{@link NullContainer#BAD BAD})</CODE></P>
	 **/
	public static final <E> void nullEmpty(E[] array, String array_name)  {
		empty(array, array_name, NullContainer.BAD);
	}
	/**
		<P>If an array has no elements, crash. Otherwise, do nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#bad(E[], java.lang.String, com.github.xbn.array.NullContainer, int, java.lang.String, com.github.xbn.array.NullElement, int, java.lang.String, com.github.xbn.array.Duplicates)">bad</A>(array, array_name, null_list, 1, null, {@link NullElement}.{@link NullElement#OK OK}, 0, null, {@link Duplicates}.{@link Duplicates#OK OK})</CODE></P>
	 **/
	public static final <E> void empty(E[] array, String array_name, NullContainer null_list)  {
		bad(array, array_name, null_list, 1, null, NullElement.OK, 0, null, Duplicates.OK);
	}
	/**
		<P>If an array's length is less than a number, crash. Otherwise, do nothing.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#bad(E[], java.lang.String, com.github.xbn.array.NullContainer, int, java.lang.String, com.github.xbn.array.NullElement, int, java.lang.String, com.github.xbn.array.Duplicates)">bad</A>(array, array_name, null_list, min_allowedLength, min_varName, {@link NullElement}.{@link NullElement#OK OK}, 0, null, {@link Duplicates}.{@link Duplicates#OK OK})</CODE></P>
	 **/
	public static final <E> void lengthLessThan(E[] array, String array_name, NullContainer null_list, int min_allowedLength, String min_varName)  {
		bad(array, array_name, null_list, min_allowedLength, min_varName, NullElement.OK, 0, null, Duplicates.OK);
	}
	/**
		<P>If a non-primitive array is bad, crash. Otherwise, do nothing.</P>

		@param  array  The array to test.
		@param  array_name  Descriptive name of {@code array}. <I>Should</I> not be {@code null} or empty.
		@param  null_array  If {@link NullContainer#BAD BAD}, the array may not be {@code null}. This parameter may not be {@code null}.
		@param  min_allowedLength  The minimum allowable length. <I>Should</I> not be less than zero.
		@param  min_varName  Descriptive name of {@code min_allowedLength}. <I>Should</I> not be {@code null} or empty.
		@param  null_element  If {@link NullElement#BAD BAD}, elements may not be {@code null}. This parameter may not be {@code null}.
		@param  min_allowedElementLen  The minimum allowable length for each element's {@code toString()}. <I>Should</I> be zero or greater. Intended for string arrays.
		@param  minElementLen_name  Descriptive name of {@code min_allowedElementLen}.
		@param  duplicates  If {@link Duplicates#BAD BAD}, elements must be unique. This parameter may not be {@code null}.
		@exception  NullPointerException  If the array is {@code null} and {@code null_array.BAD}, or an element is {@code null} and {@code null_element.BAD}.
		@exception  LengthLessThanRequiredException  If the array's length is less than {@code min_allowedLength}, or the element('s {@code toString()}) length is less than {@code min_allowedElementLen}.
		@exception  BadDuplicateException  If two elements are equal and {@code duplicates.BAD}.
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#nullEmpty(E[], String)">nullEmpty</A></CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#empty(E[], String, NullContainer)">empty</A></CODE>
		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#lengthLessThan(E[], String, NullContainer, int, String)">lengthLessThan</A></CODE>
		@see  com.github.xbn.list.CrashIfCollection#bad(Collection, String, NullContainer, int, String, NullElement, int, String) CrashIfCollection#bad
		@see  com.github.xbn.list.CrashIfList#bad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) CrashIfList#bad
	 **/
	public static final <E> void bad(E[] array, String array_name, NullContainer null_array, int min_allowedLength, String min_varName, NullElement null_element, int min_allowedElementLen, String minElementLen_name, Duplicates duplicates)  {
		try  {
			if(null_array.isOk()  &&  array == null)  {
				return;
			}
			int length = -1;
			try  {
				length = array.length;
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(array, array_name, null, rx);
			}
			if(length < min_allowedLength)  {
				throw  new LengthLessThanRequiredException(array_name, length, min_allowedLength, min_varName, null);
			}
			if(length == 0)  {
				return;
			}
			if(duplicates.isOk())  {
				if(null_element.isOk())  {
					return;
				}

				if(min_allowedElementLen == 0)  {
					for(int i = 0; i < length; i++)  {
						if(array[i] == null)  {
							throw  new NullPointerException(array_name + "[" + i + "]. Entire array: " + Arrays.toString(array));
						}
					}
					return;
				}

				//min_allowedElementLen > 0  (should be!)

				for(int i = 0; i < length; i++)  {
					try  {
						if(array[i].toString().length() < min_allowedElementLen)  {
							throw  new LengthLessThanRequiredException(array_name + "[" + i + "]",
								array[i].toString().length(),
								min_allowedElementLen, minElementLen_name, null);
						}
					}  catch(NullPointerException npx)  {
						throw  CrashIfObject.nullOrReturnCause(array[i], "array[" + i + "]", "Entire array: " + Arrays.toString(array), npx);
					}
				}
				return;
			}

			//duplicates.BAD

			if(null_element.isOk())  {
				if(min_allowedElementLen == 0)  {
					for(int i = 0; i < length; i++)  {
						Object o = array[i];
						for(int j = (i + 1); j < length; j++)  {
							Object o2 = array[j];
							try  {
								if(Objects.equals(o, o2))  {
								throw  new BadDuplicateException(array_name + "[" + i + "]", array_name + "[" + j + "]", o);
								}
							}  catch(NullPointerException npx)  {
								throw  CrashIfObject.nullOrReturnCause(o, array_name + "[" + i + "]", "Entire array: " + Arrays.toString(array), npx);
							}
						}
					}
					return;
				}

				//min_allowedElementLen > 0  (should be!)
					//null_element.OK
					//duplicates.BAD

				for(int i = 0; i < length; i++)  {
					Object o = array[i];
					if(o != null  && o.toString().length() < min_allowedElementLen)  {
						throw  new LengthLessThanRequiredException(array_name + "[" + i + "]", o.toString().length(), min_allowedElementLen, minElementLen_name, null);
					}
					for(int j = (i + 1); j < length; j++)  {
						Object o2 = array[j];
						try  {
							if(Objects.equals(o, o2))  {
							throw  new BadDuplicateException(array_name + "[" + i + "]", array_name + "[" + j + "]", o);
							}
						}  catch(NullPointerException npx)  {
							throw  CrashIfObject.nullOrReturnCause(o, array_name + "[" + i + "]", "Entire array: " + Arrays.toString(array), npx);
						}
					}
				}
				Object last = array[length - 1];
				if(last != null  &&
						last.toString().length() < min_allowedElementLen)  {
					throw  new LengthLessThanRequiredException(array_name + "[" + (length - 1) + "]", last.toString().length(),
						min_allowedElementLen, minElementLen_name, null);
				}
				return;
			}

			//null_element.BAD
				//duplicates.BAD

			if(min_allowedElementLen == 0)  {
				for(int i = 0; i < length; i++)  {
					Object o = array[i];
					for(int j = (i + 1); j < length; j++)  {
						Object o2 = array[j];
						try  {
							if(o.equals(o2))  {
								throw  new BadDuplicateException(array_name + "[" + i + "]", array_name + "[" + j + "]", o);
							}
						}  catch(NullPointerException npx)  {
							throw  CrashIfObject.nullOrReturnCause(o, array_name + "[" + i + "]", "Entire array: " + Arrays.toString(array), npx);
						}
					}
				}
				if(array[length - 1] == null)  {
					throw  new NullPointerException(array_name + "[" + (length - 1) + "]. Entire array: " + Arrays.toString(array));
				}
				return;
			}

			//min_allowedElementLen > 0  (should be!)
				//null_element.BAD
				//duplicates.BAD

			for(int i = 0; i < length; i++)  {
				Object o = array[i];
				try  {
					if(o.toString().length() < min_allowedElementLen)  {
						throw  new LengthLessThanRequiredException(array_name + "[" + i + "]", array[i].toString().length(), min_allowedElementLen, minElementLen_name, null);
					}
				}  catch(NullPointerException npx)  {
					throw  CrashIfObject.nullOrReturnCause(o, array_name + "[" + i + "]", "Entire array: " + Arrays.toString(array), npx);
				}
				for(int j = (i + 1); j < length; j++)  {
					Object o2 = array[j];
					try  {
						if(o.equals(o2))  {
							throw  new BadDuplicateException(array_name + "[" + i + "]",
								array_name + "[" + j + "]", o);
						}
					}  catch(NullPointerException npx)  {
						throw  CrashIfObject.nullOrReturnCause(o, array_name + "[" + i + "]", "Entire array: " + Arrays.toString(array), npx);
					}
				}
			}
			try  {
				if(array[length - 1].toString().length() < min_allowedElementLen)  {
					throw  new LengthLessThanRequiredException(array_name + "[" + (length - 1) + "]",
						array[length - 1].toString().length(),
						min_allowedElementLen, minElementLen_name, null);
				}
			}  catch(NullPointerException npx)  {
				throw  CrashIfObject.nullOrReturnCause(array_name + "[" + (length - 1) + "]",
					array_name + "[" + (length - 1) + "]", "Entire array: " + Arrays.toString(array), npx);
			}
		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(null_array, "null_array", null);
			CrashIfObject.nnull(duplicates, "duplicates", null);
			throw  CrashIfObject.nullOrReturnCause(null_element, "null_element", null, rx);
		}
	}
	/*
		<P>If a string array is bad, crash. Otherwise, do nothing. This treats each element's {@code toString()} as &quot;the element&quot;.</P>

		<P>This first calls
		<BR> &nbsp; &nbsp; <CODE><A HREF="#bad(E[], java.lang.String, com.github.xbn.array.NullContainer, int, java.lang.String, com.github.xbn.array.NullElement, int, java.lang.String, com.github.xbn.array.Duplicates)">bad</A>(array_ofStrsOrToStrs, array_name, null_array, min_allowedLength, min_varName, null_element, duplicates)</CODE></P>

		@param  min_allowedElementLen  The minimum allowable length for each element's {@code toString()}. <I>Should</I> be zero or greater. Intended for arrays of strings.
		@param  minElementLen_name  Descriptive name of {@code min_allowedElementLen}.
		@exception  LengthLessThanRequiredException  If an element's length is less than {@code min_allowedElementLen}.
		@see  com.github.xbn.text.CrashIfString
	public static final <E> void ofStringsBad(E[] array_ofStrsOrToStrs, String array_name, NullContainer null_array, int min_allowedLength, String min_varName, NullElement null_element, int min_allowedElementLen, String minElementLen_name, Duplicates duplicates)  {
		CrashIfArray.bad(array_ofStrsOrToStrs, array_name, null_array, min_allowedLength, min_varName, null_element, duplicates);
		if(min_allowedElementLen == 0  ||  array_ofStrsOrToStrs == null  ||  array_ofStrsOrToStrs.length == 0)  {
			return;
		}

		//min_allowedElementLen > 0

		if(null_element.isOk())  {
			for(int i = 0; i < array_ofStrsOrToStrs.length; i++)  {
				Object element = array_ofStrsOrToStrs[i];
				if(element != null  &&  element.toString().length() < min_allowedElementLen)  {
					throw  new LengthLessThanRequiredException(array_name, element.toString().length(), min_allowedElementLen, minElementLen_name);
				}
			}
			return;
		}

		//null_element.BAD (if any are null, this point will never be reached)

		for(int i = 0; i < array_ofStrsOrToStrs.length; i++)  {
			Object element = array_ofStrsOrToStrs[i];
			if(element.toString().length() < min_allowedElementLen)  {
				throw  new LengthLessThanRequiredException(array_name, element.toString().length(), min_allowedElementLen, minElementLen_name);
			}
		}
	}
	 */
	private CrashIfArray()  {
		throw  new IllegalStateException("Do not instantiate.");
	}
}