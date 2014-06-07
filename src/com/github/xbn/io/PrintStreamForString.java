/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.io;
   import  com.github.xbn.text.CrashIfString;
   import  java.io.PrintStream;
   import  java.io.ByteArrayOutputStream;
   import  java.io.UnsupportedEncodingException;
/**
   <P>Temporarily redirects console output into a string--useful for capturing output from another Java application.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
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
