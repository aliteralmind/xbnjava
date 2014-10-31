/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
	import  java.io.FileInputStream;
	import  java.io.FileNotFoundException;
	import  java.io.IOException;
	import  com.github.xbn.testdev.GetFromCommandLineAtIndex;

/**
   <P>A demonstration of a static utility function that reads in all plain text from a file</P>

   <P>{@code java com.github.xbn.examples.io.non_xbn.ManualReadAllPlainTextFromFile PATH_TO_FILE}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class ManualReadAllPlainTextFromFile  {
	public static final void main(String[] pathToFile_idx0)  {
		String path = GetFromCommandLineAtIndex.text(pathToFile_idx0, 0,
			"full path to file", null);
		System.out.println(appendFileText((new StringBuilder()), path).toString());
	}
   /*
      <P>Read all text in from a file and append it onto a StringBuilder. No parsing is done, this is just a blind file read. Note: This function is useful, not efficient (?).</P>

      <P><I>Finally, I have figured out how to read in <B>exactly</B> the contents of the file, even if it does not end with a newline  {@code :'  )}</I></P>

      @param  path  The full path and name of the file to be read. Must point to an existing and readable file.
      @exception RuntimeException  Thrown when {@code path} is invalid.
      @exception RTIOException  Thrown when an IOException is otherwise caused.
    */
	public static final StringBuilder appendFileText(StringBuilder to_appendTo, String path)  {
      FileInputStream fis = null;

      FileNotFoundException fnfxGlobal = null;
      IOException ioxGlobal = null;
      try  {
         fis = new FileInputStream(path);

         String s = null;

         byte[] ab = new byte[1];
         while(fis.read(ab) != -1)  {
            s = new String(ab);
            to_appendTo.append(s);
            ab = new byte[1];
         }

      }  catch(FileNotFoundException fnfx)  {
         fnfxGlobal = fnfx;

      }  catch(IOException iox)  {
         ioxGlobal = iox;

      }  finally  {
         IOException ioxFinally = null;
         try  {
            if(fis != null)  {
               fis.close();
            }
         }  catch(IOException iox)  {
            ioxFinally = iox;
         }  finally  {
            fis = null;

            //Throw the original exception.
            if(ioxGlobal != null  &&  ioxFinally != null)  {
               throw  new RuntimeException("appendFileText, while attempting to open the FileInputStream: " + ioxGlobal + ". Exception while attempting to close the FileInputStream: " + ioxFinally + ".");

            }  else if(fnfxGlobal != null)  {
               throw  new RuntimeException("appendFileText, while attempting to open the FileInputStream: " + fnfxGlobal);

            }  else if(ioxGlobal != null)  {
               throw  new RuntimeException("appendFileText, while attempting to open the FileInputStream: " + ioxGlobal);

            }  else if(ioxFinally != null)  {
               throw  new RuntimeException("appendFileText, while attempting to close the FileInputStream: " + ioxFinally);
            }
         }
      }
      return to_appendTo;
   }
}