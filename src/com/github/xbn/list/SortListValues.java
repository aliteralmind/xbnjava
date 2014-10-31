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
	import  com.github.xbn.util.EnumUtil;
/**
	<P>Should the map's list values be sorted?.</P>

	@author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <CODE><A HREF="http://xbnjava.jeffyepstein.com">http://xbnjava.jeffyepstein.com</A></CODE>, <CODE><A HREF="https://github.com/aliteralmind/xbnjava">https://github.com/aliteralmind/xbnjava</A></CODE>
 **/
public enum SortListValues  {
	/**
		<P>YYY.</P>

		@see  #DUPLICATE
		@see  #UNSORTED
		@see  #doSortOriginal()
	 **/
	ORIGINAL,
	/**
		<P>YYY.</P>

		@see  #ORIGINAL
		@see  #doSortDuplicate()
	 **/
	DUPLICATE,
	/**
		<P>YYY.</P>

		@see  #ORIGINAL
		@see  #doNotSort()
	 **/
	UNSORTED;
	/**
		<P>Is this {@code SortListValues} equal to {@code ORIGINAL}?.</P>

		@return  <CODE>this == {@link #ORIGINAL}</CODE>

		@see  #doSortDuplicate()
		@see  #doNotSort()
	 **/
	public final boolean doSortOriginal()  {
		return  this == ORIGINAL;
	}
	/**
		<P>Is this {@code SortListValues} equal to {@code DUPLICATE}?.</P>

		@return  <CODE>this == {@link #DUPLICATE}</CODE>
		@see  #doSortOriginal()
	 **/
	public final boolean doSortDuplicate()  {
		return  this == DUPLICATE;
	}
	/**
		<P>Is this {@code SortListValues} equal to {@code UNSORTED}?.</P>

		@return  <CODE>this == {@link #UNSORTED}</CODE>
		@see  #doSortOriginal()
	 **/
	public final boolean doNotSort()  {
		return  this == UNSORTED;
	}
	/**
		<P>If an <CODE>SortListValues</CODE> is not a required value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
		@see  #crashIfForbiddenValue(SortListValues, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(SortListValues e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
		<P>If an <CODE>SortListValues</CODE> is a forbidden value, crash.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; <CODE>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</CODE></P>
		@see  #crashIfNotRequiredValue(SortListValues, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(SortListValues e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};