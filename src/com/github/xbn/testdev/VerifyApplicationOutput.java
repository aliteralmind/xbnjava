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
package  com.github.xbn.testdev;
   import  static org.junit.Assert.*;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.reflect.InvokeMethodWithRtx;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>Assert a Java application contains the expected console output.</p>

{@.codelet com.github.xbn.examples.testdev.UnitTestAppOutputContainsXmpl%eliminateCommentBlocksAndPackageDecl()}

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class VerifyApplicationOutput  {
   /**
      <p>Equal to {@code new String[]{}}</p>
    **/
   public static final String[] EMPTY_STRING_ARRAY = new String[]{};
   /**
      <p>Verify a Java application contains the expected console output, in the expected order, with no command line parameters.</p>

      @return  <code>getBadIndexWithParams(String, Class, String[], String...) getBadIndexWithParams(forbiddenOutputs_ifNonNull, class_containingMainFunction, {@link #EMPTY_STRING_ARRAY}, xpctdOutputs_inOrder)</code>
    **/
   public static final int getBadIndexWithNoParams(String[] forbiddenOutputs_ifNonNull, Class<?> class_containingMainFunction, String... xpctdOutputs_inOrder)  {
      return  getBadIndexWithParams(forbiddenOutputs_ifNonNull, class_containingMainFunction, EMPTY_STRING_ARRAY, xpctdOutputs_inOrder);
   }
   /**
      <p>Verify a Java application contains the expected console output, in the expected order, with command line parameters.</p>

      @param  forbiddenOutputs_ifNonNull  If non-{@code null}, an array of strings that, if any item appears anywhere in the output, the test fails ({@link org.junit.Assert#assertTrue(String, boolean) assertTrue}{@code (<i>[helpful-error-message]</i>, false)} is called). May not contain null elements, and <i>should</i> not be empty or contain empty elements.
      @param  class_containingMainFunction  The class to execute. May not be {@code null}.
      @param  cmd_lineParams  The command line parameters passed to the <a href="http://docs.oracle.com/javase/tutorial/getStarted/application/index.html#MAIN">{@code main} function</a>. May not be {@code null}.
      @param  xpctdOutputs_inOrder  The array of strings that are required to be in the output, in order.
      @return  <ul>
         <li>{@code -1}:  If all output is as expected.</li>
         <li>{@code -2} or less: Indicates the index of the element in {@code forbiddenOutputs_ifNonNull} that was found. This is the index plus two, then multiplied by {@code -1}. For example, if element index three is found, then {@code ((3 + 2) * -1)=(5 * -1)=-5} is returned.</li>
         <li>The index in {@code xpctdOutputs_inOrder}, of the first element not found.</li>
      </ul>
    **/
   public static final int getBadIndexWithParams(String[] forbiddenOutputs_ifNonNull, Class<?> class_containingMainFunction, String[] cmd_lineParams, String... xpctdOutputs_inOrder)  {
//		CrashIfArray.nullEmpty(xpctdOutputs_inOrder, "xpctdOutputs_inOrder");

      String output = InvokeMethodWithRtx.getApplicationOutput(class_containingMainFunction, cmd_lineParams, "Obtaining output for unit test");

      int ix = 0;
      try  {
         for(int i = 0; i < xpctdOutputs_inOrder.length; i++)  {
            String s = xpctdOutputs_inOrder[i];
            try  {
               if(output.indexOf(s, ix) == -1)  {
                  return  i;
               }
            }  catch(NullPointerException npx)  {
               throw  CrashIfObject.nullOrReturnCause(s, "xpctdOutputs_inOrder[" + i + "]", null, npx);
            }
            ix += s.length();
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(xpctdOutputs_inOrder, "xpctdOutputs_inOrder", null, rx);
      }

      if(forbiddenOutputs_ifNonNull == null)  {
         return  -1;
      }

      for(int i = 0; i < forbiddenOutputs_ifNonNull.length; i++)  {
         String forbidden = forbiddenOutputs_ifNonNull[i];
         try  {
            if(output.indexOf(forbidden) != -1)  {
               return  ((i + 2) * -1);
            }
         }  catch(NullPointerException npx)  {
            throw  CrashIfObject.nullOrReturnCause(forbidden, "forbiddenOutputs_ifNonNull[" + i + "]", null, npx);
         }
      }

      return  -1;
   }
   /**
      <p>If the application does not have the expected output, <code>{@link org.junit.Assert#fail() fail}()</code>. Otherwise, {@link org.junit.Assert#assertTrue(boolean) assertTrue}{@code (true)}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #assertWithParameters(DisplayOutputToConsole, String, Class, String[], String...) assertWithParameters}(out_toConsole.isYes(), forbiddenOutputs_ifNonNull, class_containingMainFunction, EMPTY_STRING_ARRAY, xpctdOutputs_inOrder)</code></p>
    **/
   public static final void assertWithNoParameters(DisplayOutputToConsole out_toConsole, String[] forbiddenOutputs_ifNonNull, Class<?> class_containingMainFunction, String... xpctdOutputs_inOrder)  {
      assertWithParameters(out_toConsole, forbiddenOutputs_ifNonNull, class_containingMainFunction, EMPTY_STRING_ARRAY, xpctdOutputs_inOrder);
   }
   /**
      <p>If the application does not have the expected output, <code>{@link org.junit.Assert#fail() fail}()</code>. Otherwise, {@link org.junit.Assert#assertTrue(boolean) assertTrue}{@code (true)}.</p>

      <p>This calls
      <br/> &nbsp; &nbsp; <code>{@link #getBadIndexWithParams(String, Class, String[], String...) getBadIndexWithParams}(forbiddenOutputs_ifNonNull, class_containingMainFunction, cmd_lineParams, xpctdOutputs_inOrder)</code>
      <br/>If it returns {@code -1}, this calls {@code assertTrue(true)}. Otherwise, this calls {@code fail()} with a diagnostic message.</p>

      @param  out_toConsole  If {@link com.github.xbn.testdev.DisplayOutputToConsole#YES YES}, output is also displayed on the console. If {@link com.github.xbn.testdev.DisplayOutputToConsole#NO NO}, it's suppressed. May not be {@code null}.
    **/
   public static final void assertWithParameters(DisplayOutputToConsole out_toConsole, String[] forbiddenOutputs_ifNonNull, Class<?> class_containingMainFunction, String[] cmd_lineParams, String... xpctdOutputs_inOrder)  {
      int badIdx = getBadIndexWithParams(forbiddenOutputs_ifNonNull, class_containingMainFunction, cmd_lineParams, xpctdOutputs_inOrder);

      try  {
         if(out_toConsole.isYes())  {
            System.out.println("Console output for class " + class_containingMainFunction.getName() + ": " + LINE_SEP + getOutputDisplay(class_containingMainFunction, cmd_lineParams));
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(out_toConsole, "out_toConsole", null, rx);
      }

      if(badIdx == -1)  {
         assertTrue(true);
         return;
      }

      if(badIdx <= -2)  {
         badIdx = (badIdx * -1) - 2;
         fail(class_containingMainFunction.getName() + ".main(s[]): Forbidden item element " + badIdx + " found in output: \"" + forbiddenOutputs_ifNonNull[badIdx] + "\" -- All output:" + LINE_SEP + getOutputDisplay(class_containingMainFunction, cmd_lineParams));
         return;
      }

      try  {
         fail(class_containingMainFunction.getName() + ".main(s[]): xpctdOutputs_inOrder[" + badIdx + "] not found in output (or not in its expected position). xpctdOutputs_inOrder[" + badIdx + "]: \"" + xpctdOutputs_inOrder[badIdx] + "\"" + LINE_SEP + getOutputDisplay(class_containingMainFunction, cmd_lineParams));
      }  catch(ArrayIndexOutOfBoundsException abx)  {
         throw  new ArrayIndexOutOfBoundsException("getBadIndexWithParams(s,c,s...) returned " + badIdx + ": " + abx);
      }
   }
      private static final String getOutputDisplay(Class<?> class_containingMainFunction, String[] cmd_lineParams)  {
         return  "--APPLICATION OUTPUT start--" + LINE_SEP +
            InvokeMethodWithRtx.getApplicationOutput(class_containingMainFunction, cmd_lineParams, "Obtaining output for unit test") +
            "--APPLICATION OUTPUT end--";
      }
}
