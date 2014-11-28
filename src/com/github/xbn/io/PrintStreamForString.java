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
	import  java.io.PrintStream;
	import  java.io.ByteArrayOutputStream;
	import  java.io.UnsupportedEncodingException;
/**
   <P>Temporarily redirects console output into a string--useful for capturing output from another Java application.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class PrintStreamForString  {
	public String sCharSetName = null;
	public ByteArrayOutputStream baos = null;
	public PrintStream psNew = null;
	public PrintStream psOrig = null;

	public PrintStreamForString()  {
		this("US-ASCII");
	}
	public PrintStreamForString(String selfCmprharSetName)  {
		baos = new ByteArrayOutputStream();
		psNew = new PrintStream(baos);
		CrashIfString.nullEmpty(selfCmprharSetName, "selfCmprharSetName", null);
		sCharSetName = selfCmprharSetName;
	}

	public PrintStreamForString setSystemOutTo()  {
		psOrig = System.out;
		System.setOut(psNew);
		return  this;
	}
	public void resetSystemOut()  {
		if(psOrig == null)  {
			throw  new NullPointerException("psOrig (must first setSystemOutTo())");
		}
		System.setOut(psOrig);
		psOrig = null;
	}
	public String getStringAndReset()  {
		String s = toString();
		baos.reset();
		resetSystemOut();
		return  s;
	}
	public String toString()  {
		try  {
			return  baos.toString(sCharSetName);
		}  catch(UnsupportedEncodingException uex)  {
			throw  new RuntimeException("sCharSetName=\"" + sCharSetName + "\"", uex);
		}

	}

}