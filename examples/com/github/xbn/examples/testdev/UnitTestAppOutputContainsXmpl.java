/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.testdev;
   import  com.github.xbn.testdev.DisplayOutputToConsole;
   import  com.github.xbn.testdev.VerifyApplicationOutput;
/**
   <P>Uses <CODE>{@link com.github.xbn.testdev.VerifyApplicationOutput VerifyApplicationOutput}.{@link com.github.xbn.testdev.VerifyApplicationOutput#assertWithNoParameters(DisplayOutputToConsole, String, Class, String...) assertWithNoParameters}</CODE> to confirm a Java application has specific text in its output--this crashes with a {@code java.lang.}{@link java.lang.AssertionError AssertionError}.</P>

   <P>{@code java com.github.xbn.examples.testdev.UnitTestAppOutputContainsXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class UnitTestAppOutputContainsXmpl  {
   public static final void main(String[] ignored)  {
      System.out.println("Successful test (no crash)...");
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null, com.github.xbn.examples.testdev.HelloWorld.class, "Hello world");

      System.out.println("Failure test... (crashes with an AssertionError)");
      VerifyApplicationOutput.assertWithNoParameters(DisplayOutputToConsole.NO, null, com.github.xbn.examples.testdev.HelloWorld.class, "Goodbye, cruel world");
   }
}
