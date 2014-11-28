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
package  com.github.xbn.examples.util.non_xbn;
	import  java.io.*;
	import  java.io.IOException;
	import  java.util.zip.ZipEntry;
	import  java.util.zip.ZipInputStream;
/**
	<P>List all items in a zip file. From (viewed 4/26/2012):
	<BR> &nbsp; &nbsp; <CODE><A HREF="http://www.roseindia.net/tutorial/java/corejava/zip/zipentry.html">http://www.roseindia.net/tutorial/java/corejava/zip/zipentry.html</A></CODE></P>

	<CODE>{@code java com.github.xbn.examples.util.non_xbn.ZipEntryDemo xbnjava_20120425152952_8hours.zip}</CODE>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ZipEntryDemo {
  public static void main(String[] args) throws IOException {
doEntry(args[0]);
  }
  public static void doEntry(String file) throws IOException {
FileInputStream inStream = new FileInputStream(file);
ZipInputStream zis = new ZipInputStream(inStream);
ZipEntry entry;

while ((entry = zis.getNextEntry()) != null) {
  System.out.println('[' + entry.getCompressedSize() + "/" + entry.getSize() + "]  " + entry.getName());
}
System.out.println("[compressed-size/uncompressed] name");
  }
}