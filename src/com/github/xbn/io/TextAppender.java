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
package  com.github.xbn.io;
	import  com.github.xbn.text.CrashIfString;
	import  java.io.IOException;
	import  static com.github.xbn.lang.XbnConstants.*;
/**
	<P>Decorator for {@code Appendable}-s, including conditional printing. For runtime-only errors, see {@link TextAppenter}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class TextAppender implements Appendable  {
	private String sLineSep = null;

	public TextAppender()  {
		sLineSep = LINE_SEP;
	}
	protected TextAppender(TextAppender to_copy)  {
		try  {
			sLineSep = to_copy.getLineSeparator();
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("to_copy");
		}
	}
	/**
		<P>Set the line separator to something other than &quot;&quot;</P>
	 **/
	public final void setLineSeparator(String separator)  {
		CrashIfString.nullEmpty(separator, "separator", null);
		sLineSep = separator;
	}
	/**
		<P>Get the line separator for calls to {@code appendln()}.</P>
	 **/
	public final String getLineSeparator()  {
		return  sLineSep;
	}
	public void appendln() throws IOException  {
		append(getLineSeparator());
	}
	public void appendln(CharSequence text) throws IOException  {
		append(text).append(getLineSeparator());
	}
	public void appendln(Object string) throws IOException  {
		appendln((string == null) ? null : string.toString());
	}
	public TextAppender append(Object string) throws IOException  {
		append((string == null) ? null : string.toString());
		return  this;
	}
/*
	public void appendln(int num) throws IOException  {
		appendln((new Integer(num)).toString());
	}
	public TextAppender append(int num) throws IOException  {
		append((new Integer(num)).toString());
		return  this;
	}
	public void appendln(boolean bool_toAppend) throws IOException  {
		appendln((new Boolean(bool_toAppend)).toString());
	}
	public TextAppender append(boolean bool_toAppend) throws IOException  {
		append((new Boolean(bool_toAppend)).toString());
		return  this;
	}
	public void appendlnIfTrue(boolean condition, CharSequence text) throws IOException  {
		if(condition)  {
			appendln(text);
		}
	}
	public TextAppender appendIfTrue(boolean condition, CharSequence text) throws IOException  {
		if(condition)  {
			append(text);
		}
		return  this;
	}
	public void appendlnIfTrue(boolean condition, int num) throws IOException  {
		if(condition)  {
			appendln(num);
		}
	}
	public TextAppender appendIfTrue(boolean condition, int num) throws IOException  {
		if(condition)  {
			append(num);
		}
		return  this;
	}
	public void appendlnIfTrue(boolean condition, boolean bool_toAppend) throws IOException  {
		if(condition)  {
			appendln(bool_toAppend);
		}
	}
	public TextAppender appendIfTrue(boolean condition, boolean bool_toAppend) throws IOException  {
		if(condition)  {
			append(bool_toAppend);
		}
		return  this;
	}
 */
	public void appendlnIfTrue(boolean condition, Object text) throws IOException  {
		if(condition)  {
			appendln(text);
		}
	}
	public TextAppender appendIfTrue(boolean condition, Object text) throws IOException  {
		if(condition)  {
			append(text);
		}
		return  this;
	}
	public void appendlns(int newLine_count) throws IOException  {
		for(int i = 0; i < newLine_count; i++)  {
			appendln();
		}
	}
	public static final IndexOutOfBoundsException newIBXForCSSubstr(CharSequence text, int idx_start, int idx_endX, IndexOutOfBoundsException ibx_cause)  {
		IndexOutOfBoundsException ibx = new IndexOutOfBoundsException("idx_start (" + idx_start + ") and idx_endX (" + idx_endX + ") is an invalid index range, given the text length is " + text.length());
		ibx.initCause(ibx_cause);
		return  ibx;
//		return  new XbnIndexOutOfBoundsException_Cfg().
//			badRange(idx_start, idx_endX, "idx_start", "idx_endX").
//			absStringLength(text).buildWithCause(ibx_cause);
	}
	public abstract void flushRtx();
	public abstract void closeRtx();
}
