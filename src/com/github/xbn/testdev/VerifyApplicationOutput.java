/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.testdev;
   import  java.lang.reflect.Method;
   import  static org.junit.Assert.*;
   import  com.github.xbn.array.CrashIfArray;
   import  com.github.xbn.io.PrintStreamForString;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.reflect.InvokeMethodWithRtx;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Assert a Java application contains the expected console output.</P>

{@.codelet com.github.xbn.examples.testdev.UnitTestAppOutputContainsXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class VerifyApplicationOutput  {
   /**
      <P>Equal to {@code new String[]{}}</P>
    **/
   public static final String[] EMPTY_STRING_ARRAY = new String[]{};
   /**
      <P>Verify a Java application contains the expected console output, in the expected order, with no command line parameters.</P>

      @return  <CODE>getBadIndexWithParams(String, Class, String[], String...) getBadIndexWithParams(forbiddenOutput_ifNonNull, class_containingMainFunction, {@link #EMPTY_STRING_ARRAY}, xpctdOutputs_inOrder)</CODE>
    **/
   public static final int getBadIndexWithNoParams(String forbiddenOutput_ifNonNull, Class<?> class_containingMainFunction, String... xpctdOutputs_inOrder)  {
      return  getBadIndexWithParams(forbiddenOutput_ifNonNull, class_containingMainFunction, EMPTY_STRING_ARRAY, xpctdOutputs_inOrder);
   }
   /**
      <P>Verify a Java application contains the expected console output, in the expected order, with command line parameters.</P>

      @param  forbiddenOutput_ifNonNull  A single string that, if it appears anywhere in the output, the test fails ({@link org.junit.Assert#assertTrue(String, boolean) assertTrue}{@code (<I>[helpful error message]</I>, false)} is called).
      @param  class_containingMainFunction  The class to execute. May not be {@code null}.
      @param  cmd_lineParams  The command line parameters passed to the <A HREF="http://docs.oracle.com/javase/tutorial/getStarted/application/index.html#MAIN">{@code main} function</A>. May not be {@code null}.
      @param  xpctdOutputs_inOrder  The array of strings that are required to be in the output, in order.
      @return  <UL>
         <LI>{@code -1}:  If all output is as expected.</LI>
         <LI>{@code -2}:  If {@code forbiddenOutput_ifNonNull} was found.</LI>
         <LI>The index in {@code xpctdOutputs_inOrder}, of the first element not found.</LI>
      </UL>
    **/
   public static final int getBadIndexWithParams(String forbiddenOutput_ifNonNull, Class<?> class_containingMainFunction, String[] cmd_lineParams, String... xpctdOutputs_inOrder)  {
      CrashIfArray.nullEmpty(xpctdOutputs_inOrder, "xpctdOutputs_inOrder");

      String output = InvokeMethodWithRtx.getApplicationOutput(class_containingMainFunction, cmd_lineParams, "Obtaining output for unit test");

      int ix = 0;
      try  {
         for(int i = 0; i < xpctdOutputs_inOrder.length; i++)  {
            String s = xpctdOutputs_inOrder[i];
            if(output.indexOf(s, ix) == -1)  {
               return  i;
            }
            ix += s.length();
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(xpctdOutputs_inOrder, "xpctdOutputs_inOrder", null, rx);
      }

      if(forbiddenOutput_ifNonNull != null  &&
            output.indexOf(forbiddenOutput_ifNonNull) != -1)  {
         return  -2;
      }

      return  -1;
   }
   /**
      <P>If the application does not have the expected output, <CODE>{@link org.junit.Assert#fail() fail}()</CODE>. Otherwise, {@link org.junit.Assert#assertTrue(boolean) assertTrue}{@code (true)}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #assertWithParameters(DisplayOutputToConsole, String, Class, String[], String...) assertWithParameters}(out_toConsole.isYes(), forbiddenOutput_ifNonNull, class_containingMainFunction, EMPTY_STRING_ARRAY, xpctdOutputs_inOrder)</CODE></P>
    **/
   public static final void assertWithNoParameters(DisplayOutputToConsole out_toConsole, String forbiddenOutput_ifNonNull, Class<?> class_containingMainFunction, String... xpctdOutputs_inOrder)  {
      assertWithParameters(out_toConsole, forbiddenOutput_ifNonNull, class_containingMainFunction, EMPTY_STRING_ARRAY, xpctdOutputs_inOrder);
   }
   /**
      <P>If the application does not have the expected output, <CODE>{@link org.junit.Assert#fail() fail}()</CODE>. Otherwise, {@link org.junit.Assert#assertTrue(boolean) assertTrue}{@code (true)}.</P>

      <P>This calls
      <BR> &nbsp; &nbsp; <CODE>{@link #getBadIndexWithParams(String, Class, String[], String...) getBadIndexWithParams}(forbiddenOutput_ifNonNull, class_containingMainFunction, cmd_lineParams, xpctdOutputs_inOrder)</CODE>
      <BR>If it returns {@code -1}, this calls {@code assertTrue(true)}. Otherwise, this calls {@code fail()} with a diagnostic message.</P>

      @param  out_toConsole  If {@link com.github.xbn.testdev.DisplayOutputToConsole#YES YES}, output is also displayed on the console. If {@link com.github.xbn.testdev.DisplayOutputToConsole#NO NO}, it's suppressed. May not be {@code null}.
    **/
   public static final void assertWithParameters(DisplayOutputToConsole out_toConsole, String forbiddenOutput_ifNonNull, Class<?> class_containingMainFunction, String[] cmd_lineParams, String... xpctdOutputs_inOrder)  {
      int badIdx = getBadIndexWithParams(forbiddenOutput_ifNonNull, class_containingMainFunction, cmd_lineParams, xpctdOutputs_inOrder);

      try  {
         if(out_toConsole.isYes())  {
            System.out.println("Output(out_toConsole.isYes() is true): " + LINE_SEP + getOutputDisplay(class_containingMainFunction, cmd_lineParams));
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(out_toConsole, "out_toConsole", null, rx);
      }

      if(badIdx == -1)  {
         assertTrue(true);
         return;
      }

      if(badIdx == -2)  {
         fail(class_containingMainFunction.getName() + ".main(s[]): forbidden item found in output: \"" + forbiddenOutput_ifNonNull + "\" -- All output:" + LINE_SEP + getOutputDisplay(class_containingMainFunction, cmd_lineParams));
         return;
      }

      try  {
         fail(class_containingMainFunction.getName() + ".main(s[]): xpctdOutputs_inOrder[" + badIdx + "] not found in output (or not in its expected position). xpctdOutputs_inOrder[" + badIdx + "]: \"" + xpctdOutputs_inOrder[badIdx] + "\"" + LINE_SEP + getOutputDisplay(class_containingMainFunction, cmd_lineParams));
      }  catch(ArrayIndexOutOfBoundsException abx)  {
         throw  new ArrayIndexOutOfBoundsException("getBadIndexWithParams(s,c,s...) returned " + badIdx + ".");
      }
   }
      private static final String getOutputDisplay(Class<?> class_containingMainFunction, String[] cmd_lineParams)  {
         return  "--APPLICATION OUTPUT start--" + LINE_SEP +
            InvokeMethodWithRtx.getApplicationOutput(class_containingMainFunction, cmd_lineParams, "Obtaining output for unit test") +
            "--APPLICATION OUTPUT end--";
      }
}
