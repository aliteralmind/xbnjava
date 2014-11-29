/*
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
 */
package  com.github.xbn.io;
	import  java.io.File;
	import  com.github.xbn.lang.CrashIfObject;
	import  java.io.PrintWriter;
/**
	<p>Builder for creating a {@code PrintWriter} that writes text to a file. (This does not implement <code>xbn.neederneedable.Chainable</code>, because there are no self-returning functions that throw an exception.)</p>

{@.codelet com.github.xbn.examples.io.NewPrintWriterToFileXmpl%eliminateCommentBlocksAndPackageDecl()}

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewPrintWriterToFile  {
//state
	private boolean doOverwrite    = false;
	private boolean bAutoFlush = false;
	/**
		<p>Create a new instance with defaults.</p>

		<p>This calls<ol>
			<li>{@link #overwrite() overwrite}{@code ()}</li>
			<li>{@link #manualFlush() manualFlush}{@code ()}</li>
		</ol></p>
	 **/
	public NewPrintWriterToFile()  {
		overwrite();
		manualFlush();
	}
	/**
		<p>Append to the file. Existing text is left untouched.</p>

		@return  {@link #overwrite(boolean) overwrite}{@code (false)}
	 **/
	public NewPrintWriterToFile append()  {
		return  overwrite(false);
	}
	/**
		<p>Overwrite the file. Existing text is erased.</p>

		@return  {@link #overwrite(boolean) overwrite}{@code (false)}
	 **/
	public NewPrintWriterToFile overwrite()  {
		return  overwrite(true);
	}
	/**
		<p>Declare if the file should be appended to or overwritten.</p>

		<p>This sets {@link #doAppend() doAppend}{@code ()} to {@code do_overwrite}.</p>

		@see  #append()
		@see  #overwrite()
	 **/
	public NewPrintWriterToFile overwrite(boolean do_overwrite)  {
		doOverwrite = do_overwrite;
		return  this;
	}
	/**
		<p>Output is flushed automatically.</p>

		<p>This sets {@link #doAutoFlush() doAutoFlush}{@code ()} to {@code true}.</p>

		@see  #manualFlush()
		@see  java.io.PrintWriter#flush()
	 **/
	public NewPrintWriterToFile autoFlush()  {
		bAutoFlush = true;
		return  this;
	}
	/**
		<p>Output must be flushed explicitly.</p>

		<p>This sets {@link #doAutoFlush() doAutoFlush}{@code ()} to {@code true}.</p>

		@see  #autoFlush()
	 **/
	public NewPrintWriterToFile manualFlush()  {
		bAutoFlush = false;
		return  this;
	}
	/**
		<p>Is text appended to the file?.</p>

		@return  <code>(!{@link #doOverwrite() doOverwrite}())</code>
	 **/
	public boolean doAppend()  {
		return  (!doOverwrite());
	}
	/**
		<p>If the file exists, is it overwritten?.</p>

		@return  {@code true} if {@link #overwrite() overwrite}{@code ()} was called more recently than {@link #append() append}{@code ()}.
	 **/
	public boolean doOverwrite()  {
		return  doOverwrite;
	}
	/**
		<p>Is output automatically flushed?.</p>

		@return  <code>true</code> if {@link #autoFlush() autoFlush}{@code ()} was called more recently than {@link #manualFlush() manualFlush}{@code ()}
		@see  #isManualFlush()
	 **/
	public boolean doAutoFlush()  {
		return  bAutoFlush;
	}
	/**
		<p>Must output be explicitly flushed?.</p>

		@return  <code>(!{@link #doAutoFlush() doAutoFlush}())</code>
	 **/
	public boolean isManualFlush()  {
		return  (!doAutoFlush());
	}
	/**
		<p>Create new {@code PrintWriter} that writes to a file as configured.</p>

		@return  <code>{@link #build(File) build}(new {@link java.io.File#File(String) File}(path))</code>
	 **/
	public PrintWriter build(String path)  {
		try  {
			return  build(new File(path));
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(path, "path", null, rx);
		}
	}
	/**
		<p>Create new {@code PrintWriter} that writes to a file as configured.</p>

		@return  <code>NewPrintWriterToFile.{@link #build(File, boolean, boolean) build}(file, {@link #doAppend() doAppend}(), {@link #doAutoFlush() doAutoFlush}())</code>
		@see  #buildTA(String) buildTA(s)
		@see  #buildMuteableTA(String) buildMuteableTA(s)
	 **/
	public PrintWriter build(File file)  {
		return  NewPrintWriterToFile.build(file, doAppend(), doAutoFlush());
	}
	/**
		<p>Create new {@code PrintWriter}, wrapped in a {@code TextAppender}, that writes to a file as configured.</p>

		@return  <code>(new {@link TAAppendable}&lt;{@link java.io.PrintWriter PrintWriter}&gt;({@link #build(String) build}(path)))</code>
	 **/
	public TextAppender buildTA(String path)  {
		return  (new TAAppendable<PrintWriter>(build(path)));
	}
	/**
		<p>Create new {@code PrintWriter}, wrapped in a {@code TAAppendMutable}, that writes to a file as configured.</p>

		@return  <code>(new {@link TAAppendMutable}&lt;{@link java.io.PrintWriter PrintWriter}&gt;({@link #build(String) build}(path)))</code>
	 **/
	public TAAppendMutable<PrintWriter> buildMuteableTA(String path)  {
		return  (new TAAppendMutable<PrintWriter>(build(path)));
	}
	public static final PrintWriter build(String path, boolean do_append, boolean do_autoFlush)  {
		return  build(new File(path), do_append, do_autoFlush);
	}
	/**
		<p><i>Deprecated: Use <code>{@link IOUtil}.{@link IOUtil#getPrintWriterToFile(File, boolean, boolean) getPrintWriterToFile}</code> instead</i> -- Create a new {@code PrintWriter} that writes to a file with specific configuration.</p>

		@deprecated  Use <code>{@link IOUtil}.{@link IOUtil#getPrintWriterToFile(File, boolean, boolean) getPrintWriterToFile}</code> instead</i>
		@return  <code>{@link IOUtil}.{@link IOUtil#getPrintWriterToFile(File, boolean, boolean) getPrintWriterToFile}(file, do_append, do_autoFlush)</code>
	 **/
	public static final PrintWriter build(File file, boolean do_append, boolean do_autoFlush)  {
		return  IOUtil.getPrintWriterToFile(file, do_append, do_autoFlush);
	}
}

