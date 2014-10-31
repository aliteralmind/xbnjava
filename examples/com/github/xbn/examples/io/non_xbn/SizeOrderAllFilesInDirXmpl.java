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
package  com.github.xbn.examples.io.non_xbn;
	import  java.io.File;
	import  java.util.ArrayList;
	import  java.util.Collection;
	import  java.util.Iterator;
	import  java.util.List;
	import  java.util.TreeMap;
	import  org.apache.commons.io.FileUtils;
/**
	<P>Demonstration of listing all files in a directory, in size order, using a {@link java.util.Map} in which each item is a list of values (multiple values per key). This is an answer to (viewed 1/2/2014)
	<BR> &nbsp; &nbsp; {@code <A HREF="http://stackoverflow.com/questions/20889571/java-list-of-subdirectories-and-files-within-a-path-size">http://stackoverflow.com/questions/20889571/java-list-of-subdirectories-and-files-within-a-path-size</A>}</P>

	<P>java com.github.xbn.examples.io.SizeOrderAllFilesInDirXmpl</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SizeOrderAllFilesInDirXmpl  {
	public static final void main(String[] ignored)  {
		File fDir = (new File("R:\\jeffy\\programming\\sandbox\\xbnjava\\xbn\\"));
		Collection<File> cllf = FileUtils.listFiles(fDir, (new String[]{"java"}), true);

		//Add all file paths to a Map, keyed by size.
		//It's actually a map of lists-of-files, to
		//allow multiple files that happen to have the
		//same length.

		TreeMap<Long,List<File>> tmFilesBySize = new TreeMap<Long,List<File>>();
		Iterator<File> itrf = cllf.iterator();
		while(itrf.hasNext())  {
			File f = itrf.next();
			Long LLen = f.length();
			if(!tmFilesBySize.containsKey(LLen))  {
				ArrayList<File> alf = new ArrayList<File>();
				alf.add(f);
				tmFilesBySize.put(LLen, alf);
			}  else  {
				tmFilesBySize.get(LLen).add(f);
			}
		}

		//Iterate backwards by key through the map. For each
		//List<File>, iterate through the files, printing out
		//its size and path.

		ArrayList<Long> alSize = new ArrayList<Long>(tmFilesBySize.keySet());
		for(int i=alSize.size() - 1; i >= 0; i--)  {
			itrf = tmFilesBySize.get(alSize.get(i)).iterator();
			while(itrf.hasNext())  {
				File f = itrf.next();
				System.out.println(f.length() + ": " + f.getPath());
			}
		}
	}
}
