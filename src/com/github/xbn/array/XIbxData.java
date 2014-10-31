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
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.lang.IllegalArgumentStateException;
	import  com.github.xbn.text.StringWithNullDefault;
	import  java.util.Collection;
/**
	<P>Data accessors for {@code Xbn*IndexOutOfBoundsException}-s.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class XIbxData  {
	private Throwable tCause     = null;
	private Object    oXtraInfo  = null;
	private int       iAbsMin    = -1  ;
	private int       iAbsMaxX   = -1  ;  //Usually length
	private String    sAbsMinNm  = null;
	private String    sAbsMaxXNm = null;
//public
	public static final String sDEFAULT_ABS_MIN_NAME = "[absolute-min]";
	public static final String sDEFAULT_ABS_MAXX_NAME = "[absolute-max-exclusive]";
	/**
		<P>Create a new instance with initialized values.</P>

		<P>This sets all non-{@code int} values to {@code null}
		<BR> &nbsp; &nbsp; {@link #getCause() getCause}{@code ()}, {@link #getExtraErrInfo() getExtraErrInfo}{@code ()}, {@link #getAbsMinName() getAbsMinName}{@code ()}, {@link #getAbsMaxXName() getAbsMaxXName}{@code ()}
		<BR>and the {@code int} values to {@code -1}: {@link #getAbsMin() getAbsMin}{@code ()}, {@link #getAbsMaxX() getAbsMaxX}{@code ()}</P>
	 **/
	public XIbxData()  {
		tCause     = null;
		oXtraInfo  = null;
		iAbsMin    = -1  ;
		iAbsMaxX   = -1  ;
		sAbsMinNm  = null;
		sAbsMaxXNm = null;
	}
//setters...START
	/**
		<P>From a string's length, set the absolute bounds that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setAbsMinAndStringLength(int, Object, String, String) setAbsMinAndStringLength}(min, obj_forStrLen, null, &quot;[the-string]&quot;)</CODE></P>
	 **/
	public void setAbsMinAndStringLength(int min, Object obj_forStrLen)  {
		setAbsMinAndStringLength(min, obj_forStrLen, null, "[the-string]");
	}
	/**
		<P>From a string's length, set the absolute bounds that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min, obj_forStrLen.toString().length(), min_name, str_name + &quot;.toString().length()&quot;)</CODE></P>
		@see  #setAbsMinAndStringLength(int, Object) setAbsMinAndStringLength(i,o)
	 **/
	public void setAbsMinAndStringLength(int min, Object obj_forStrLen, String min_name, String str_name)  {
		try  {
			setAbsoluteBounds(min, obj_forStrLen.toString().length(), min_name, str_name + ".toString().length()");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(obj_forStrLen, "obj_forStrLen", null, rx);
		}
	}
	/**
		<P>From a non-primitive array's length, set the absolute bounds that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setAbsMinAndArrayLength(int, Object[], String, String) setAbsMinAndArrayLength}(min, obj_forStrLen, null, &quot;[the-string]&quot;)</CODE></P>
	 **/
	public <E> void setAbsMinAndArrayLength(int min, E[] array)  {
		setAbsMinAndArrayLength(min, array, null, "[the-array]");
	}
	/**
		<P>From a non-primitive array's length, set the absolute bounds that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min, array.length, min_name, array_name + &quot;.length&quot;)</CODE></P>
		@see  #setAbsMinAndArrayLength(int, Object[]) setAbsMinAndArrayLength(i,E[])
	 **/
	public <E> void setAbsMinAndArrayLength(int min, E[] array, String min_name, String array_name)  {
		try  {
			setAbsoluteBounds(min, array.length, min_name, array_name + ".length");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(array, "array", null, rx);
		}
	}
	/**
		<P>From a collection's size, set the absolute bounds that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setAbsMinAndCollectionSize(int, Collection, String, String) setAbsMinAndCollectionSize}(min, obj_forStrLen, null, &quot;[the-string]&quot;)</CODE></P>
	 **/
	public void setAbsMinAndCollectionSize(int min, Collection<?> cll_forSize)  {
		setAbsMinAndCollectionSize(min, cll_forSize, null, "[the-collection]");
	}
	/**
		<P>From a collection's size, set the absolute bounds that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds}(min, cll_forSize.size(), min_name, selfCmprllName + &quot;.size()&quot;)</CODE></P>
		@see  #setAbsMinAndCollectionSize(int, Collection) setAbsMinAndCollectionSize(i,cll)
	 **/
	public void setAbsMinAndCollectionSize(int min, Collection<?> cll_forSize, String min_name, String selfCmprllName)  {
		try  {
			setAbsoluteBounds(min, cll_forSize.size(), min_name, selfCmprllName + ".size()");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(cll_forSize, "cll_forSize", null, rx);
		}
	}
	/**
		<P>Set the absolute bounds, that the bad index or range is supposed to conform to.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link #setAbsoluteBounds(int, int) setAbsoluteBounds(min, max_exclusive, null, null)}</P>
	 **/
	public void setAbsoluteBounds(int min, int max_exclusive)  {
		setAbsoluteBounds(min, max_exclusive, null, null);
	}
	/**
		<P>Set the absolute bounds, that the bad index or range is supposed to conform to.</P>

		@param  min  The minimum number, inclusive, that the indexes <I>should</I> conform to. May not be less than zero, or greater than {@code max_exclusive}. Get with {@link #getAbsMin() getAbsMin}{@code ()}.
		@param  max_exclusive  The maximum number, exclusive, that the indexes <I>should</I> conform to. This is usually the length of something. Get with {@link #getAbsMaxX() getAbsMaxX}{@code ()}.
		@param  min_name  Descriptive name of {@code min}. If {@code null}, {@link #sDEFAULT_ABS_MIN_NAME} is used. Get with {@link #getAbsMinName() getAbsMinName}{@code ()}.
		@param  max_name  Descriptive name of {@code max_exclusive}. If {@code null}, {@link #sDEFAULT_ABS_MAXX_NAME} is used. Get with {@link #getAbsMinName() getAbsMinName}{@code ()}.

		@see  #setAbsoluteBounds(int, int) setAbsoluteBounds(i,i)
		@see  #setAbsMinAndStringLength(int, Object) setAbsMinAndStringLength(i,o)
		@see  #setAbsMinAndStringLength(int, Object, String, String) setAbsMinAndStringLength(i,o,s,s)
		@see  #setAbsMinAndArrayLength(int, Object[]) setAbsMinAndArrayLength(i,E[])
		@see  #setAbsMinAndArrayLength(int, Object[], String, String) setAbsMinAndArrayLength(i,E[],s,s)
		@see  #setAbsMinAndCollectionSize(int, Collection) setAbsMinAndCollectionSize(i,cll)
		@see  #setAbsMinAndCollectionSize(int, Collection, String, String) setAbsMinAndCollectionSize(i,cll,s,s)
	 **/
	public void setAbsoluteBounds(int min, int max_exclusive, String min_name, String max_name)  {
		if(min < 0  ||  min >= max_exclusive)  {
			throw  new IllegalArgumentStateException("min (" + min + ") is less than zero, or greater-than-or-equal-to max_exclusive (" + max_exclusive + ").");
		}
		iAbsMin = min;
		iAbsMaxX = max_exclusive;
		sAbsMinNm = min_name;
		sAbsMaxXNm = max_name;
		ciNOTBadForAbsBounds_forCfgBuild();
	}
	/**
		<P>Set non-index related information.</P>

		@param  xtra_errInfo  Any extra information to append to the error message. Get with {@link #getExtraErrInfo() getExtraErrInfo}{@code ()}.
		@param  cause  The causing error. Get with {@link #getCause() getCause}{@code ()}
	 **/
	public void setExtraErrInfoCause(Object xtra_errInfo, Throwable cause)  {
		oXtraInfo = xtra_errInfo;
		tCause = cause;
	}
//setters...END
	/**
		@see  #setExtraErrInfoCause(Object, Throwable) setExtraErrInfoCause(s,o,thr)
	 **/
	public Throwable getCause()  {
		return  tCause;
	}
	/**
		@see  #setExtraErrInfoCause(Object, Throwable) setExtraErrInfoCause(s,o,thr)
	 **/
	public Object getExtraErrInfo()  {
		return  oXtraInfo;
	}
	/**
		@see  #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds(i,i,s,s)
	 **/
	public int getAbsMin()  {
		return  iAbsMin;
	}
	/**
		@see  #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds(i,i,s,s)
	 **/
	public int getAbsMaxX()  {
		return  iAbsMaxX;
	}
	/**
		@see  #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds(i,i,s,s)
	 **/
	public String getAbsMinName()  {
		return  sAbsMinNm;
	}
	/**
		@see  #setAbsoluteBounds(int, int, String, String) setAbsoluteBounds(i,i,s,s)
	 **/
	public String getAbsMaxXName()  {
		return  sAbsMaxXNm;
	}
	public abstract void ciNOTBadForAbsBounds_forCfgBuild();
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		StringWithNullDefault.append(to_appendTo, getAbsMinName(), sDEFAULT_ABS_MIN_NAME);
		to_appendTo.append("=").append(getAbsMin()).append(", ");
System.out.println("getAbsMaxXName()=\"" + getAbsMaxXName() + "\"");
		StringWithNullDefault.append(to_appendTo, getAbsMaxXName(), sDEFAULT_ABS_MAXX_NAME);
		to_appendTo.append("=").append(getAbsMaxX());
		if(getCause() != null)  {
			to_appendTo.append(", getCause(): ").append(getCause());
		}
		StringWithNullDefault.append(to_appendTo, ", extra-info=[", getExtraErrInfo(), "]", null);

		return  to_appendTo;
	}
}
