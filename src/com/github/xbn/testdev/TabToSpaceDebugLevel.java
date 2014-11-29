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
package  com.github.xbn.testdev;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.util.EnumUtil;
/**
	<p>YYY.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum TabToSpaceDebugLevel  {
	/**
		<p>YYY.</p>

		<p>This sets {@link #getNumber() getNumber}{@code ()} to {@code 0}.</p>

		@see  #ALL_SUMMARY_ONLY
		@see  #FILE_DOTS
		@see  #FILE_SUMMARIES
		@see  #LINE_COUNTS
		@see  #isOff()
	 **/
	OFF(0),
	/**
		<p>YYY.</p>

		<p>This sets {@link #getNumber() getNumber}{@code ()} to {@code 1}.</p>

		@see  #OFF
		@see  #isAllSummaryOnly()
	 **/
	ALL_SUMMARY_ONLY(1),
	/**
		<p>YYY.</p>

		<p>This sets {@link #getNumber() getNumber}{@code ()} to {@code 2}.</p>

		@see  #OFF
		@see  #isFileDots()
	 **/
	FILE_DOTS(2),
	/**
		<p>YYY.</p>

		<p>This sets {@link #getNumber() getNumber}{@code ()} to {@code 3}.</p>

		@see  #OFF
		@see  #isFileSummaries()
	 **/
	FILE_SUMMARIES(3),
	/**
		<p>YYY.</p>

		<p>This sets {@link #getNumber() getNumber}{@code ()} to {@code 4}.</p>

		@see  #OFF
		@see  #isLineCounts()
	 **/
	LINE_COUNTS(4);
	/**
		<p>Is this {@code TabToSpaceDebugLevel} equal to {@code OFF}?.</p>

		@return  <code>this == {@link #OFF}</code>

		@see  #isAllSummaryOnly()
		@see  #isFileDots()
		@see  #isFileSummaries()
		@see  #isLineCounts()
	 **/
	public final boolean isOff()  {
		return  this == OFF;
	}
	/**
		<p>Is this {@code TabToSpaceDebugLevel} equal to {@code ALL_SUMMARY_ONLY}?.</p>

		@return  <code>this == {@link #ALL_SUMMARY_ONLY}</code>
		@see  #isOff()
	 **/
	public final boolean isAllSummaryOnly()  {
		return  this == ALL_SUMMARY_ONLY;
	}
	/**
		<p>Is this {@code TabToSpaceDebugLevel} equal to {@code FILE_DOTS}?.</p>

		@return  <code>this == {@link #FILE_DOTS}</code>
		@see  #isOff()
	 **/
	public final boolean isFileDots()  {
		return  this == FILE_DOTS;
	}
	/**
		<p>Is this {@code TabToSpaceDebugLevel} equal to {@code FILE_SUMMARIES}?.</p>

		@return  <code>this == {@link #FILE_SUMMARIES}</code>
		@see  #isOff()
	 **/
	public final boolean isFileSummaries()  {
		return  this == FILE_SUMMARIES;
	}
	/**
		<p>Is this {@code TabToSpaceDebugLevel} equal to {@code LINE_COUNTS}?.</p>

		@return  <code>this == {@link #LINE_COUNTS}</code>
		@see  #isOff()
	 **/
	public final boolean isLineCounts()  {
		return  this == LINE_COUNTS;
	}
	public final boolean isOnAndAtLeast(TabToSpaceDebugLevel minimum)  {
		try  {
			if(minimum.isOff())  {
				throw  new IllegalArgumentException("minimum is OFF");
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(minimum, "minimum", null, rx);
		}
		return  (getNumber() >= minimum.getNumber());
	}
	private final int number;
	TabToSpaceDebugLevel(int number)  {
		this.number = number;
	}
	private int getNumber()  {
		return  number;
	}
	/**
		<p>If an <code>TabToSpaceDebugLevel</code> is not a required value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
		@see  #crashIfForbiddenValue(TabToSpaceDebugLevel, String, Object) crashIfForbiddenValue(ert,s,o)
	 **/
	public void crashIfNotRequiredValue(TabToSpaceDebugLevel e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfNotRequiredValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
	/**
		<p>If an <code>TabToSpaceDebugLevel</code> is a forbidden value, crash.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo)</code></p>
		@see  #crashIfNotRequiredValue(TabToSpaceDebugLevel, String, Object) crashIfNotRequiredValue(ert,s,o)
	 **/
	public void crashIfForbiddenValue(TabToSpaceDebugLevel e_rqd, String s_thisEnumsVarNm, Object o_xtraInfo)  {
		EnumUtil.crashIfForbiddenValue(this, e_rqd, s_thisEnumsVarNm, o_xtraInfo);
	}
};
