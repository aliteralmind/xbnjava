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
	import  com.github.xbn.io.NewTextAppenterFor;
	import  com.github.xbn.lang.IllegalArgumentStateException;
	import  com.github.xbn.io.NewPrintWriterToFile;
	import  com.github.xbn.io.PlainTextFileUtil;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.linefilter.alter.ExpirableTextLineAlterList;
	import  com.github.xbn.text.StringUtil;
	import  java.io.File;
	import  java.io.PrintWriter;
	import  java.util.Iterator;
	import  static com.github.xbn.lang.XbnConstants.*;
/**
	<p>For duplicating a text file with alterations such as regular expression replacements--optionally overwrites the original file.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class DuplicateTextFileWithAlterations  {
	public static final void go(String input_path, String output_path, Overwrite overwrite, ExpirableTextLineAlterList all_alterer, Appendable dbgInOut_ifNonNull)  {
		try  {
			go(new File(input_path), new File(output_path), overwrite, all_alterer, dbgInOut_ifNonNull);
		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(input_path, "input_path", null);
			throw  CrashIfObject.nullOrReturnCause(output_path, "output_path", null, rx);
		}
	}
	public static final void go(File input, File output, Overwrite overwrite, ExpirableTextLineAlterList all_alterer, Appendable dbgInOut_ifNonNull)  {
		boolean inAndOutAreEqual = false;
		try  {
			inAndOutAreEqual = input.getAbsolutePath().equals(
				output.getAbsolutePath());
			if(overwrite.isBad()  &&  inAndOutAreEqual)  {
				throw  new IllegalArgumentStateException("Input and output are the same file: " + input.getAbsolutePath());
			}
		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(input, "input", null);
			CrashIfObject.nnull(output, "output", null);
			throw  CrashIfObject.nullOrReturnCause(overwrite, "overwrite", null, rx);
		}
		Iterator<String> lineItr = null;
		if(inAndOutAreEqual)  {
			String text = PlainTextFileUtil.getText(input, "input");
			lineItr = StringUtil.getLineIterator(text);
		}  else  {
			lineItr = PlainTextFileUtil.getLineIterator(input, "input");
		}

		PrintWriter fileWriter = new NewPrintWriterToFile().overwrite().
			manualFlush().build(output);

		NewTextAppenterFor.appendableSuppressIfNull(dbgInOut_ifNonNull).
			appentln("DuplicateTextFileWithAlterations(overwrite." + overwrite + "):" + LINE_SEP +
				" - input: " + input.getAbsolutePath() + LINE_SEP +
				" - output: " + output.getAbsolutePath());

		go(lineItr, fileWriter, all_alterer);
	}

	public static final void go(Iterator<String> input_lineItr, PrintWriter output, ExpirableTextLineAlterList all_alterer)  {
		try  {
			while(input_lineItr.hasNext())  {
				String line = input_lineItr.next();
				try  {
					if(!all_alterer.isExpired())  {
						line = all_alterer.getAltered(line);
					}
				}  catch(RuntimeException rx)  {
					throw  CrashIfObject.nullOrReturnCause(all_alterer, "all_alterer", null, rx);
				}

				output.write(line);
				output.write(LINE_SEP);
			}

			output.flush();
			output.close();

		}  catch(RuntimeException rx)  {
			CrashIfObject.nnull(input_lineItr, "input_lineItr", null);
			CrashIfObject.nnull(output, "output", null);
			CrashIfObject.nnull(all_alterer, "all_alterer", null);
			throw  new RuntimeException("input_lineItr: " + input_lineItr + ", output: " + output + ", all_alterer=" + all_alterer, rx);
		}

	}
}