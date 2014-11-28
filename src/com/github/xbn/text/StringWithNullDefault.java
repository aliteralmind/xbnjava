/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.text;
	import  java.io.IOException;
	import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Get a string, or a default value when {@code null}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class StringWithNullDefault  {
   private StringWithNullDefault()  {
		throw  new IllegalStateException("Do not instantiate.");
	}
	/**
		<P>Get a string, or a default value if it's {@code null}.</P>

		@return  {@link #get(String, Object, String, String) get}{@code (null, stringThatMay_beNull, null, if_null)}
	 **/
	public static final String get(Object stringThatMay_beNull, String if_null)  {
		return  get(null, stringThatMay_beNull, null, if_null);
	}
	/**
		<P>Get a string, or a default value if it's {@code null}.</P>

		@return  {@link #get(Object, String) get}{@code (null, stringThatMay_beNull, null, if_null)}
	 **/
	public static final String get(String prefix_ifNonNull, Object stringThatMay_beNull, String postfix_ifNonNull, String if_null)  {
		return  append((new StringBuilder()), prefix_ifNonNull, stringThatMay_beNull, postfix_ifNonNull, if_null).toString();
	}
	/**
		<P>Append a string, or a default value if {@code null}.</P>

		@return  {@link #append(Appendable, String, Object, String, String) append}{@code (to_appendTo, null, stringThatMay_beNull, null, if_null)}
	 **/
	public static final Appendable append(Appendable to_appendTo, Object stringThatMay_beNull, String if_null)  {
		return  append(to_appendTo, null, stringThatMay_beNull, null, if_null);
	}
	/**
		<P>Append a string, or a default value if {@code null}.</P>

		@param  to_appendTo  To append to. May not be {@code null}.
		@param  prefix_ifNonNull  When the string is non-{@code null}, this will be displayed before it. <I>Should</I> not be empty. When {@code null}, there is no prefix.
		@param  stringThatMay_beNull  The string.
		@param  postfix_ifNonNull  When the string is non-{@code null}, this will be displayed after it. <I>Should</I> not be empty. When {@code null}, there is no postfix.
		@param  if_null  When the string is {@code null}, this is displayed in its place. If this parameter, {@code if_null} is {@code null}, then <I>nothing</I> is appended (this is the same as providing the empty-string).
		@return  {@code to_appendTo}
		@see  #get(Object, String) get(O,s)
		@see  #get(String, Object, String, String) get(s,O,s,s)
		@see  #append(Appendable, Object, String) append(apbl,O,s)
	 **/
	public static final Appendable append(Appendable to_appendTo, String prefix_ifNonNull, Object stringThatMay_beNull, String postfix_ifNonNull, String if_null)  {
		try  {
			try  {
				if(stringThatMay_beNull == null)  {
					return  to_appendTo.append(((if_null == null) ? "" : if_null));
				}
				return
					to_appendTo.append((prefix_ifNonNull == null) ? "" : prefix_ifNonNull).
						append(stringThatMay_beNull.toString()).
						append((postfix_ifNonNull == null) ? "" : postfix_ifNonNull);
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
			}
		}  catch(IOException iox)  {
			throw  new RuntimeException("append", iox);
		}
	}

}