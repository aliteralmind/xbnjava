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
package  com.github.xbn.testdev.ant;
	import  java.io.FileNotFoundException;
	import  java.io.IOException;
	import  java.io.InputStream;
	import  java.net.MalformedURLException;
	import  java.net.URL;
	import  java.net.UnknownHostException;
	import  org.apache.tools.ant.BuildException;
	import  org.apache.tools.ant.Task;
/**
	<P>Detect if the internet is available, determined by the ability to reach a specific url.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ATDetectInternet extends Task  {
	private String sUrl = null;
	private String sProperty = null;

	/**
		<P>Create an ATDetectInternet. This does nothing.</P>
	 **/
	public ATDetectInternet()  {
	}
	/**
		<P>Set the url to reach.</P>

		@param  url  The url. May not be null or empty.
	 **/
	public void setUrl(String url)  {
		sUrl = url;
	}
	/**
		<P>The property which should be set only if the url can be reached. It is either set to true (if the url can be reached) or not set at all.</P>

		@param  prop_name  The property name. May not be null or empty.
	 **/
	public void setProperty(String prop_name)  {
		sProperty = prop_name;
	}
	/**
		<P>Do it. Uh huh. Oh yeah.</P>
	 **/
	public void execute() throws BuildException  {
		if(sUrl == null  ||  sUrl.length() == 0)  {
			throw  new BuildException("Parameter url ('" + sUrl + "') is null or empty.");
		}

		if(sProperty == null  ||  sProperty.length() == 0)  {
			throw  new BuildException("Parameter property ('" + sProperty + "') is null or empty.");
		}

		//Copied from xbn.util.Utility.appendWebPageSource

		try  {
			URL url = new URL(sUrl);
			InputStream isUNUSED = url.openStream();
			getProject().setProperty(sProperty, "true");
		}  catch(UnknownHostException uhx)  {
			System.out.println("INTERNET IS NOT AVAILABLE, or provided host is invalid. " + uhx.toString());
		}  catch(MalformedURLException mux)  {
			throw  new BuildException("Parameter url ('" + sUrl + "') is a malformed url. " + mux.toString() + ". (It does seem that we are connected to the internet, otherwise a uhx would have been thrown.)");
		}  catch(FileNotFoundException fnfx)  {
			throw  new BuildException("Parameter url ('" + sUrl + "') is invalid. " + fnfx.toString() + ". (It does seem that we are connected to the internet, otherwise a uhx would have been thrown.)");
		}  catch(IOException iox)  {
			System.out.println("INTERNET IS NOT AVAILABLE. " + iox.toString());
		}
	}
}
