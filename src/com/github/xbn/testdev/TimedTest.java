/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   import  java.util.Objects;
   import  com.github.xbn.io.IOUtil;
   import  com.github.xbn.number.NewIntInRangeFor;
   import  com.github.xbn.testdev.GetFromCommandLineAtIndex;
   import  java.io.PrintWriter;
   import  com.github.xbn.util.tuple.ThreeTuple;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.text.CrashIfString;
   import  java.util.Locale;
   import  java.text.NumberFormat;
/**
   <P>For benchmarking the speed of a process to the nano-second, and comparing it against another.</P>

{@.codelet.and.out com.github.xbn.examples.testdev.Time3StringConcatVsAppend(100000)%eliminateCommentBlocksAndPackageDecl()}

{@.codelet.and.out com.github.xbn.examples.testdev.TimeIteratorVsIndexIntegerList(1000000)%eliminateCommentBlocksAndPackageDecl()}

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class TimedTest  {
   private static NumberFormat numFmt;
   private final String name;
   private long startTime = -1;
   private long endTime = -1;
   private static PrintWriter writer;
   /**
      <P>The default number of digits to show after the decimal point in the &quot;percentage faster by&quot; message--Equal to {@code 3}</P>

      @see  #getTestABTestNanoDifferenceMsg(TimedTest)
    **/
   public static final int DECIMAL_PLACES_DEFAULT = 3;
   /**
      <P>Create a new instance with a descriptive name.</P>

      <P>If getWriter() is {@code null} (which only occurs in the first {@code TimedTest} instance), this calls<OL>
         <LI><CODE>TimedTest.{@link #setLocale(Locale) setLocale}({@link java.text.Locale Locale}.{@link java.text.Locale#US US})</CODE></LI>
         <LI><CODE>TimedTest.setWriter(new {@link java.io.PrintWriter#PrintWriter(OutputStream) PrintWriter}(System.out))</CODE></LI>
      </OL></P>

      @param  name  Descriptive name used in output. May not be {@code null} or empty. Get with {@link #getName() getName}{@code ()}.
    **/
   public TimedTest(String name)  {
      if(numFmt == null)  {
         TimedTest.setLocale(Locale.US);
         TimedTest.setWriter(new PrintWriter(System.out));
      }
      CrashIfString.nullEmpty(name, "name", null);
      this.name = name;
   }
   /**
      <P>Descriptive name of this test, used in output strings.</P>

      @see  #TimedTest(String)
    **/
   public String getName()  {
      return  name;
   }
   /**
      <P>Output a &quot;starting test&quot; message, then start it.</P>

      @see  #declareStart()
      @see  #declareEndWithOutput()
      @see  #declareEndThenStartNextWithOutput(TimedTest)
      @exception  RuntimeException  If attempting to write the message fails for any reason.
    **/
   public void declareStartWithOutput()  {
      try  {
         getWriter().println("Starting test \"" + getName() + "\"");
         getWriter().flush();
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("Attempting getWriter().write(...)", rx);
      }
      declareStart();
   }
   /**
      <P>End this test, output a &quot;test ended, starting next test&quot; message, then start the next.</P>

      <P>This<OL>
         <LI>Calls {@link #declareEnd() declareEnd}{@code ()}</LI>
         <LI>Outputs a message ia {@link #getWriter() getWriter}{@code ()}, its contents beginning with {@link #getTestTookXNanosMsg() getTestTookXNanosMsg}{@code ()}.</LI>
         <LI>Calls <CODE>next_test.{@link #declareStart() declareStart}()</CODE></LI>
      </OL></P>

      <P></P>

      @param  next_test  May not be {@code null}.
      @see  #declareEndWithOutput()
      @exception  RuntimeException  If attempting to write the message fails for any reason.
    **/
   public void declareEndThenStartNextWithOutput(TimedTest next_test)  {
      declareEnd();
      try  {
         getWriter().println(getTestTookXNanosMsg() + ". Starting test \"" + next_test.getName() + "\"");
         getWriter().flush();
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(next_test, "next_test");
         throw  new RuntimeException("Attempting getWriter().write(...)", rx);
      }
      next_test.declareStart();
   }
   /**
      <P>End the test, and print a "test ended" message.</P>

      <P>This<OL>
         <LI>Calls {@link #declareEnd() declareEnd}{@code ()}</LI>
         <LI>Outputs {@link #getTestTookXNanosMsg() getTestTookXNanosMsg}{@code ()} with {@link #getWriter() getWriter}{@code ()}.</LI>
      </OL></P>

      @exception  RuntimeException  If attempting to write the message fails for any reason.
    **/
   public void declareEndWithOutput()  {
      declareEnd();
      try  {
         getWriter().println(getTestTookXNanosMsg());
         getWriter().flush();
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("Attempting getWriter().write(...)", rx);
      }
   }
   /**
      <P>Start the test.</P>

      <P>This sets {@link #getStart() getStart}{@code ()} to <CODE>{@link java.lang.System System}.{@link java.lang.System#nanoTime() nanoTime}</CODE>.</P>

      @see  #declareEnd()
      @see  #declareStartWithOutput()
      @exception  IllegalStateException  If {@link #wasStarted() wasStarted}{@code ()} is {@code true}. (The test is not started until after this {@code wasStarted()} check.)
    **/
   public void declareStart()  {
      if(wasStarted())  {
         throw  new IllegalStateException("wasStarted() is true.");
      }
      startTime = System.nanoTime();
   }
   /**
      <P>End the test.</P>

      <P>This sets {@link #getEnd() getEnd}{@code ()} to <CODE>{@link java.lang.System System}.{@link java.lang.System#nanoTime() nanoTime}</CODE>.</P>

      @see  #declareStart()
      @see  #declareEndWithOutput()
      @see  #declareEndThenStartNextWithOutput(TimedTest)
      @exception  IllegalStateException  If {@link #wasStarted() wasStarted}{@code ()} is {@code false} or {@link #wasEnded() wasEnded}{@code ()} is {@code true}. (These {@code was*} tests are not done until after the test is stopped. But {@code getEnd()} is not set to this value until these tests pass.)
    **/
   public void declareEnd()  {
      long end2 = System.nanoTime();
      if(!wasStarted())  {
         throw  new IllegalStateException("wasStarted() is false.");
      }
      if(wasEnded())  {
         throw  new IllegalStateException("wasEnded() is true.");
      }
      endTime = end2;
   }
   /**
      <P>The nanosecond that the test started.</P>

      @return  The nanosecond the test started, or {@code -1} if {@link #wasStarted() wasStarted}{@code ()} is {@code false}.
      @see  #getEnd()
      @see  #declareStart()
    **/
   public long getStart()  {
      return  startTime;
   }
   /**
      <P>Was the test started?.</P>

      @return  <CODE>({@link #getStart() getStart}() != -1)</CODE>
      @see  #wasEnded()
    **/
   public boolean wasStarted()  {
      return  (getStart() != -1);
   }
   /**
      <P>Was the test ended?.</P>

      @return  <CODE>({@link #getEnd() getEnd}() != -1)</CODE>
      @see  #wasStarted()
    **/
   public boolean wasEnded()  {
      return  (getEnd() != -1);
   }
   /**
      <P>The nanosecond that the test ended.</P>

      @return  The nanosecond the test ended, or {@code -1} if {@link #wasEnded() wasEnded}{@code ()} is {@code false}.
      @see  #getStart()
      @see  #declareEnd()
    **/
   public long getEnd()  {
      return  endTime;
   }
   /**
      <P>Get the nanoseconds from test start-to-finish.</P>

      @return  <CODE>({@link #getEnd() getEnd}() - {@link #getStart() getStart}())</CODE>
      @exception  IllegalStateException  If {@link #wasEnded() wasEnded}{@code ()} is {@code false}.
    **/
   public long getDuration()  {
      if(!wasEnded())  {
         throw  new IllegalStateException("wasEnded() is false.");
      }
      return  (getEnd() - getStart());
   }
   public static final Locale[] getAvailableLocales()  {
      return  numFmt.getAvailableLocales();
   }
   public static final PrintWriter getWriter()  {
      return  writer;
   }
   /**
      <P>Was this test faster than another?.</P>

      @return  <CODE>({@link #longCompareTo(TimedTest) longCompareTo}(to_compareTo) &lt; 0)</CODE>
    **/
   public boolean didBeat(TimedTest to_compareTo)  {
      return  (longCompareTo(to_compareTo) < 0);  //this < to_compareTo
   }
   /**
      <P>Get the between this test and another's duration.</P>

      @param  to_compareTo  May not be {@code null}, and its test must be {@link #wasEnded() ended}.
      @return  <CODE>{@link java.lang.Long Long}.{@link java.lang.Long#compare(long, long) compare}({@link #getDuration() getDuration}(), to_compareTo.getDuration())</CODE>
      @exception  IllegalStateException  If {@link #wasEnded() wasEnded}{@code ()} is {@code false}.
      @see  #didBeat(TimedTest)
    **/
   public long longCompareTo(TimedTest to_compareTo)  {
      try  {
         return  Long.compare(getDuration(), to_compareTo.getDuration());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_compareTo, "to_compareTo", null, rx);
      }
   }
   /**
      <P>A basic message to display after this test ends.</P>

      @return  <CODE>TimedTest.{@link #getTestTookXNanosMsg(TimedTest) getTestTookXNanosMsg}(this)</CODE>
    **/
   public String getTestTookXNanosMsg()  {
      return  TimedTest.getTestTookXNanosMsg(this);
   }
   /**
      <P>Determines the winner, loser, and the time-difference between them.</P>

      @return  <CODE>TimedTest.{@link #getWinnerDifferenceLoser(TimedTest, TimedTest) getWinnerDifferenceLoser}(this, to_compareTo)</CODE>
    **/
   public ThreeTuple<TimedTest,Long,TimedTest> getWinnerDifferenceLoser(TimedTest to_compareTo)  {
      return  TimedTest.getWinnerDifferenceLoser(this, to_compareTo);
   }
   /**
      <P>A message stating which of two tests was faster, and by what percentage.</P>

      @return  <CODE>{@link #getTestABTestNanoDifferenceMsg(TimedTest, int) getTestABTestNanoDifferenceMsg}(to_compareTo, {@link #DECIMAL_PLACES_DEFAULT})</CODE>
    **/
   public String getTestABTestNanoDifferenceMsg(TimedTest to_compareTo)  {
      return  getTestABTestNanoDifferenceMsg(to_compareTo, DECIMAL_PLACES_DEFAULT);
   }
   /**
      <P>A message stating which of two tests was faster, and by what percentage.</P>

      @return  <CODE>TimedTest.{@link #getTestABTestNanoDifferenceMsg(TimedTest, TimedTest, int) getTestABTestNanoDifferenceMsg}(this, to_compareTo, decimal_places)</CODE>
    **/
   public String getTestABTestNanoDifferenceMsg(TimedTest to_compareTo, int decimal_places)  {
      return  TimedTest.getTestABTestNanoDifferenceMsg(this, to_compareTo, decimal_places);
   }
   /**
      <P>A message stating how long a test took.</P>

      @param  test  A test that has ended. May not be {@code null}.
      @see  #getTestTookXNanosMsg()
      @see  #getTestABTestNanoDifferenceMsg(TimedTest, TimedTest, int) getTestABTestNanoDifferenceMsg(tt,tt,i)
    **/
   public static final String getTestTookXNanosMsg(TimedTest test)  {
      try  {
         return  "Test \"" + test.getName() + "\" took " + numFmt.format(test.getDuration())  + " nanoseconds";
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(test, "test", null, rx);
      }
   }
   /**
      <P>Determines the winner, loser, and the time-difference between them.</P>

      @param  test_a  May not be {@code null} and must be {@link #wasEnded() ended}.
      @param  test_b  May not be {@code null} and must be ended.
      @return  An tuple containing the following three objects in order: The faster test, the nanosecond difference between them, and the slower tast.
      @exception  IllegalStateException  If this test is not ended.
      @see  #getWinnerDifferenceLoser(TimedTest, TimedTest) getWinnerDifferenceLoser(tt,tt)
      @see  #getTestABTestNanoDifferenceMsg(TimedTest, TimedTest, int) getTestABTestNanoDifferenceMsg(tt,tt,i)
    **/
   public static final ThreeTuple<TimedTest,Long,TimedTest> getWinnerDifferenceLoser(TimedTest test_a, TimedTest test_b)  {
      long diff = -1;
      TimedTest winner = null;
      TimedTest loser = null;
      try  {
         if(test_a.getDuration() > test_b.getDuration())  {
            winner = test_b;
            diff = test_a.getDuration() - test_b.getDuration();
            loser = test_a;
         }  else  {
            winner = test_a;
            diff = test_b.getDuration() - test_a.getDuration();
            loser = test_b;
         }
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(test_a, "test_a");
         throw  CrashIfObject.nullOrReturnCause(test_b, "test_b", null, rx);
      }
      return  (new ThreeTuple<TimedTest,Long,TimedTest>(winner, diff, loser));
   }
   /**
      <P>A message stating which of two tests was faster, and by what percentage.</P>

      @return  <CODE>{@link #getTestABTestNanoDifferenceMsg(TimedTest, TimedTest, int) getTestABTestNanoDifferenceMsg}(test_a, test_b, {@link #DECIMAL_PLACES_DEFAULT})</CODE>
    **/
   public static final String getTestABTestNanoDifferenceMsg(TimedTest test_a, TimedTest test_b)  {
      return  getTestABTestNanoDifferenceMsg(test_a, test_b, DECIMAL_PLACES_DEFAULT);
   }
   /**
      <P>A message stating which of two tests was faster, and by what percentage.</P>

      @param  test_a  May not be {@code null}, and must be {@link #wasEnded() ended}.
      @param  test_b  May not be {@code null}, and must be ended.
      @param  decimal_places  The number of digits to display to the right of the decimal point. May not be less than zero, and must be valid for <CODE>String.{@link java.lang.String#format(String, Object...) format}(s,o...)</CODE> (for use between {@code "%."} and {@code "f"}).
      @see  #getWinnerDifferenceLoser(TimedTest, TimedTest) getWinnerDifferenceLoser(tt,tt)
      @see  #getTestABTestNanoDifferenceMsg(TimedTest) getTestABTestNanoDifferenceMsg(tt)
      @see  #getTestABTestNanoDifferenceMsg(TimedTest, int) getTestABTestNanoDifferenceMsg(tt,i)
      @see  #getTestABTestNanoDifferenceMsg(TimedTest, TimedTest) getTestABTestNanoDifferenceMsg(tt,tt)
      @see  #getTestTookXNanosMsg(TimedTest) getTestTookXNanosMsg(tt)
    **/
   public static final String getTestABTestNanoDifferenceMsg(TimedTest test_a, TimedTest test_b, int decimal_places)  {
      ThreeTuple<TimedTest,Long,TimedTest> winnerDiffLoser = getWinnerDifferenceLoser(test_a, test_b);
      double dPct = 100.00 -
         (winnerDiffLoser.get1().getDuration() * 100.0 /
            winnerDiffLoser.get3().getDuration() + 0.5);
      String pctFrmtd;
      try  {
         pctFrmtd = String.format("%." + decimal_places + "f", dPct);
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("Attempting String.format(\"%.\" + decimal_places + \"f\", ...), decimal_places=" + decimal_places);
      }
      return  "FASTER: Test \"" + winnerDiffLoser.get1().getName() + "\", by " + numFmt.format(winnerDiffLoser.get2()) + " nanoseconds (" + pctFrmtd + "%)";
   }
   /**
      <P>Set the localization used for displaying the nanoseconds.</P>

      @param  locale  May not be {@code null}. Get with {@link #getAvailableLocales() getAvailableLocales}{@code ()}
      @see  #setWriter(PrintWriter)
    **/
   public static final void setLocale(Locale locale)  {
      Objects.requireNonNull(locale, "locale");
      numFmt = NumberFormat.getNumberInstance(locale);
   }
   /**
      <P>Set the writer for printing messages.</P>

      @param  writer  May not be {@code null}, and <CODE>writer.{@link java.io.PrintWriter#checkError() checkError}()</CODE> must be {@code false}. Get with {@link #getWriter() getWriter}{@code ()}
      @see  #setLocale(Locale)
    **/
   public static final void setWriter(PrintWriter writer)  {
      IOUtil.crashIfPrintWriterError(writer, "writer");
      TimedTest.writer = writer;
   }
   /**
      <P>Get the number of test iterations as provided in the command line.</P>

      @return  <CODE>{@link com.github.xbn.testdev.GetFromCommandLineAtIndex GetFromCommandLineAtIndex}.{@link com.github.xbn.testdev.GetFromCommandLineAtIndex#number(String[], int, IntInRange, String, Appendable) number}(cmd_lineParams, test_countIdx, {@link com.github.xbn.number.NewIntInRangeFor NewIntInRangeFor}.{@link com.github.xbn.number.NewIntInRangeFor#min(Invert, int, String) min}(1, null))</CODE>
    **/
   public static final int getTestCountFromCmdLine(String[] cmd_lineParams, int test_countIdx)  {
      return  GetFromCommandLineAtIndex.number(cmd_lineParams, test_countIdx, NewIntInRangeFor.min(null, 1, null), "[test count]", null);
   }
}
