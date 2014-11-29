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
	import  java.util.Iterator;
	import  java.io.File;
	import  java.io.IOException;
	import  org.apache.commons.io.FileUtils;
/**
	<p>Read a text file where each line is a space-separated username, password, account-active boolean.</p>

	<p>{@code java com.github.xbn.examples.io.non_xbn.ReadInActiveAccountsFromFile xbn\examples\io\non_xbn\\username_password_active.txt}</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ReadInActiveAccountsFromFile  {
	public static final void main(String[] rqdInputPathInStrArray)  {
		//Read command-line
			String sSrc = null;
			try  {
				sSrc = rqdInputPathInStrArray[0];
			}  catch(IndexOutOfBoundsException ibx)  {
				System.out.println("Missing one-and-only required parameter: The full path to Java source-code file.");
				return;
			}

		//Open input file
			File inputFile = new File(sSrc);
			Iterator<String> lineItr = null;
			try  {
				lineItr = FileUtils.lineIterator(inputFile);
			}  catch(IOException iox)  {
				System.out.println("Cannot open \"" + sSrc + "\". " + iox);
				return;
			}

		while(lineItr.hasNext())  {
			String line = lineItr.next();
			String[] userPassIsActive = line.split(" ");
			String username = userPassIsActive[0];
			String password = userPassIsActive[1];
			boolean isActive = Boolean.parseBoolean(userPassIsActive[2]);

			System.out.println("username=" + username + ", password=" + password + ", isActive=" + isActive + "");
		}
	}
}
