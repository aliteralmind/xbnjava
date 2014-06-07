/*license*\
   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
\*license*/
package  com.github.xbn.examples.io.non_xbn;
   import  java.util.Iterator;
   import  java.io.File;
   import  java.io.IOException;
   import  org.apache.commons.io.FileUtils;
   import  org.apache.commons.lang3.StringUtils;
/**
   <P>Read a text file where each line is a space-separated username, password, account-active boolean.</P>

   <P>{@code java com.github.xbn.examples.io.non_xbn.ReadInActiveAccountsFromFile xbn\examples\io\non_xbn\\username_password_active.txt}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
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
