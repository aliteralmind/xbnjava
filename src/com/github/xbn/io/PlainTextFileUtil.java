/*license*\
	XBN-Java Library

	Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
	import  java.util.Iterator;
	import  org.apache.commons.io.FileUtils;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.io.File;
   import  java.io.IOException;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>Obtain line-iterators or the full-text from a plain-text file.</p>

   @see  com.github.xbn.text.StringUtil
   @author  Copyright (C) 2014, Jeff Epstein, with asistance by Marc Baumbach for {@code newWriterForAppendable(apbl)}. Released under the LPGL 2.1. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class PlainTextFileUtil  {
	private PlainTextFileUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<p>Get all plain-text from a file, given its path.</p>

		@return  <code>{@link #appendText(StringBuilder, String, String) appendText}((new StringBuilder()), path, file_varName).toString()</code>
	 **/
	public static final String getText(String path, String file_varName)  {
		return  appendText((new StringBuilder()), path, file_varName).toString();
	}
	/**
		<p>Get all plain-text from a file, given its path.</p>

		@return  <code>{@link #appendText(StringBuilder, String, String) appendText}((new StringBuilder()), file, file_varName).toString()</code>
	 **/
	public static final String getText(File file, String file_varName)  {
		return  appendText((new StringBuilder()), file, file_varName).toString();
	}
	/**
		<p>Append all plain-text from a file, given its path.</p>

		@return  {@code to_appendTo}, after all lines from
		<br/> &nbsp; &nbsp; {@link #getLineIterator(String, String) getLineIterator}{@code (path, file_varName)}
		<br/>are appended to it.
		@see  #appendText(StringBuilder, File, String)
	 **/
	public static final StringBuilder appendText(StringBuilder to_appendTo, String path, String file_varName)  {
		Iterator<String> lineItr = getLineIterator(path, file_varName);
		while(lineItr.hasNext())  {
			to_appendTo.append(lineItr.next()).append(LINE_SEP);
		}
		return  to_appendTo;
	}
	/**
		<p>Append all plain-text from a file.</p>

		@return  {@code to_appendTo}, after all lines from
		<br/> &nbsp; &nbsp; {@link #getLineIterator(File, String) getLineIterator}{@code (file, file_varName)}
		<br/>are appended to it.
		@see  #appendText(StringBuilder, String, String)
	 **/
	public static final StringBuilder appendText(StringBuilder to_appendTo, File file, String file_varName)  {
		Iterator<String> lineItr = getLineIterator(file, file_varName);
		while(lineItr.hasNext())  {
			to_appendTo.append(lineItr.next()).append(LINE_SEP);
		}
		return  to_appendTo;
	}
	/**
		<p>Get a line-iterator for a file.</p>

		@see  com.github.xbn.text.StringUtil#getLineIterator(Object) StringUtil#getLineIteratorForString(cs)
		@return  <code>{@link #getLineIterator(File, String) getLineIterator}((new {@link java.io.File#File(String) File}(path, path_varName)))</code>
	 **/
	public static final Iterator<String> getLineIterator(String path, String path_varName)  {
		try  {
			return  getLineIterator((new File(path)), path_varName);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(path, path_varName, null, rx);
		}
	}
   /**
		<p>Get a line-iterator for a file.</p>

		@return  <code>{@link org.apache.commons.io.FileUtils}.{@link org.apache.commons.io.FileUtils#lineIterator(File) lineIterator}(file)</code>
		@exception  RTIOException  If attempting to open the file results in an {@code java.io.IOException}
		@see  #getLineIterator(String, String)
    **/
	public static final Iterator<String> getLineIterator(File file, String file_varName)  {
		try  {
			return  FileUtils.lineIterator(file);
		}  catch(IOException iox)  {
			throw  new RTIOException(file_varName + "=" + file, iox);
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(file, file_varName, null, rx);
		}
	}

}
