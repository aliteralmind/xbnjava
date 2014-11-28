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
package  com.github.xbn.examples.testdev;
	import  com.github.xbn.io.PathMustBe;
	import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
	import  com.github.xbn.testdev.ReplaceAllIndentTabsWithSpaces;
	import  com.github.xbn.testdev.TabToSpaceDebugLevel;
	import  java.io.File;
	import  java.nio.file.Path;
	import  java.util.Iterator;
	import  java.util.Scanner;
	import  org.apache.commons.io.FileUtils;
	import  org.apache.commons.io.filefilter.FileFilterUtils;
	import  org.apache.commons.io.filefilter.IOFileFilter;
/**
	<P>Demonstration of {@code com.github.xbn.util.}{@link com.github.xbn.testdev.ReplaceAllIndentTabsWithSpaces}.{@link com.github.xbn.testdev.ReplaceAllIndentTabsWithSpaces#overwriteDirectory(Iterator) overwriteDirectory}--<I>this overwrites the files in the provided directory.</I>.</P>

	<P>{@code java com.github.xbn.examples.util.ReplaceAllIndentTabsWithSpacesXmpl C:\java_code\project_name\}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ReplaceAllIndentTabsWithSpacesXmpl  {
	public static final void main(String[] directoryRoot_paramIdxZero)  {
		//Setup and protection
			String dirRoot = GetFromCommandLineAtIndex.text(
				directoryRoot_paramIdxZero, 0, "directoryRoot_paramIdxZero", null);

			System.out.println("This example code will overwrite the files in \"" + dirRoot + "\". Enter the number 1234567890 to proceed.");
			if(!new Scanner(System.in).nextLine().equals("1234567890"))  {
				System.out.println("Abort.");
				return;
			}

			Path dirPath = new PathMustBe().existing().writable().
				directory().noFollowLinks().
				getOrCrashIfBad(dirRoot, "directoryRoot_paramIdxZero[0]");

			File fileRootDir = new File(dirRoot);

		//Go

		IOFileFilter allFileTypesKeepFilter = FileFilterUtils.and(
			FileFilterUtils.suffixFileFilter(".java"),
			FileFilterUtils.suffixFileFilter(".html"));

		Iterator<File> fileItr = FileUtils.iterateFiles(fileRootDir,
			allFileTypesKeepFilter, null);

		new ReplaceAllIndentTabsWithSpaces(3, System.out,
			TabToSpaceDebugLevel.FILE_SUMMARIES).
			overwriteDirectory(fileItr);
	}
}
