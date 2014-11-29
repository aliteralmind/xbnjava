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

package  com.github.xbn.examples.io;
	import  java.io.PrintWriter;
	import  com.github.xbn.io.NewPrintWriterToFile;
/**
   <p>Demonstration of {@code com.github.xbn.io.}{@link com.github.xbn.io.NewPrintWriterToFile}.</p>

   <p>{@code java com.github.xbn.examples.io.NewPrintWriterToFileXmpl NewPrintWriterToFileXmpl.txt}</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewPrintWriterToFileXmpl  {
	public static final void main(String[] oneRqdParam_pathToFile)  {
		PrintWriter fileTextWriter = null;
		try  {

			fileTextWriter = new NewPrintWriterToFile().append().autoFlush().
				build(oneRqdParam_pathToFile[0]);

		}  catch(ArrayIndexOutOfBoundsException abx)  {
			throw  new IllegalArgumentException("One required parameter: The path to the file to write to: " + abx);
		}  catch(RuntimeException rx)  {
			throw  new IllegalArgumentException("Path invalid? oneRqdParam_pathToFile[0]=\"" + oneRqdParam_pathToFile[0] + "\"");
		}

		fileTextWriter.write("Hello");
		fileTextWriter.close();         //Must close, or the text is not flushed!

		System.out.println("Text written to \"" + oneRqdParam_pathToFile[0] + "\"");
	}
}