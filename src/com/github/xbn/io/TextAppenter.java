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
   import  java.io.InputStream;
   import  java.util.Scanner;
   import  java.io.IOException;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P><A HREF="http://en.wikipedia.org/wiki/Decorator_pattern">Decorator</A> for {@link java.lang.Appendable}-s, including conditional printing, with runtime-only exceptions. This is a companion to {@code TextAppender}.</P>

   <P><I>(Scroll down for two examples.)</I></P>

   <H3>From a blog-post written on 7/3/2014:</H3>

   <P>I've never used a debugger in my life. I exclusively develop in <A HREF="http://textpad.com">TextPad</A>, and use <A HREF="http://phraseexpress.com">PhraseExpress</A> for auto-completes. I will likely start using an IDE, such as Eclipse or the free version of IntelliJ, only for the purpose of using a debugger.</P>

   <P>Not using a debugger is not something I'm necessarily proud of (well...maybe a little), it's just something I've not gotten around to doing. Despite this, I've built some reasonably large projects. My primary form of debugging has always been <CODE>System.out.println()</CODE>-s and this utility: {@code TextAppenter}.</P>

   <P><CODE>TextAppenter</CODE> is a <A HREF="http://en.wikipedia.org/wiki/Decorator_pattern#Java">decorator</A> for <CODE>java.lang.<A HREF="http://docs.oracle.com/javase/7/docs/api/java/lang/Appendable.html">Appendables</A></CODE>. <CODE>Appendables</CODE>s only have the following three functions:<UL>
    	<LI><CODE>append(char)</CODE></LI>
      <LI><CODE>append(CharSequence)</CODE></LI>
      <LI><CODE>append(CharSequence, int, int)</CODE></LI>
   </UL></P>

   <P><CODE>TextAppenter</CODE> provides (&quot;decorates&quot; it with) some extra functionality:<UL>
    	<LI><CODE>appent(Object)</CODE></LI>
    	<LI><CODE>appentIfTrue(boolean, Object)</CODE></LI>
    	<LI><CODE>appentln()</CODE></LI>
    	<LI><CODE>appentln(Object)</CODE></LI>
    	<LI><CODE>appentlnIfTrue(boolean, Object)</CODE></LI>
    	<LI><CODE>appentlns(int)</CODE></LI>
    </UL></P>

   <P>But most importantly, <CODE>TextAppenter</CODE>s crash with only runtime errors. Hence the &quot;<CODE>appent</CODE>&quot;, with a <CODE>'t'</CODE>, prefix.</P>

   <P>In addition, <CODE>TextAppenter</CODE>s may be {@linkplain #isUseable() &quot;unusable&quot;}, which is a convenience when an object <I>optionally</I> outputs debugging information--when the debugging statements should remain in production code, but be off by default.</P>

   <H3>Example 1 of 2: Optionally debugging an object</H3>

   <P>Demonstrates an object that has optional-but-permanent debugging. It is off by default. This example shows an &quot;off&quot; example, followed by an &quot;on&quot;</P>

{@.codelet.and.out com.github.xbn.examples.io.TextAppenterObjectDebugging%eliminateCommentBlocksAndPackageDecl()}

   <H3>Example 2 of 2: Optionally debuging an application with potential levels</H3>

   <P>This trivial Java application uses a TextAppenter to provide three possible levels of debugging: Off, minimal, and verbose:</P>

{@.codelet com.github.xbn.examples.io.TextAppenterWithLevelsAppExample%eliminateCommentBlocksAndPackageDecl()}

   <P><B>Output for:</B> <CODE>java TextAppenterWithLevelsAppExample debugoff</CODE></P>

   <P><I>Not applicable: No output</I></P>

   <P><B>Output for:</B> <CODE>java TextAppenterWithLevelsAppExample debugminimal</CODE></P>

<BLOCKQUOTE><PRE style="background-color:#EEEEEE;">debugminimal --> DebugLevel.ONE
Minimally-important debugging information goes here...</PRE></BLOCKQUOTE>

<!--
   {&#64;.codelet.out com.github.xbn.examples.io.TextAppenterWithLevelsAppExample("debugminimal")}
 -->

   <P><B>Output for:</B> <CODE>java TextAppenterWithLevelsAppExample debugverbose</CODE></P>

<BLOCKQUOTE><PRE style="background-color:#EEEEEE;">debugverbose --> DebugLevel.TWO
Minimally-important debugging information goes here...
Very very verbose and highly-important debugging information...</PRE></BLOCKQUOTE>

<!--
   {&#64;.codelet.out com.github.xbn.examples.io.TextAppenterWithLevelsAppExample("debugverbose")}
 -->

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TextAppenter  {
   private final TextAppender tapndr;
   /**
      <P>An unusable appenter.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>new {@link #TextAppenter() TextAppenter}()</CODE></P>

      @see  #isUseable()
    **/
   public static final TextAppenter UNUSABLE = new TextAppenter();
   /**
      <P>An appenter that is useable, but discards all output.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>new {@link #TextAppenter(TextAppender) TextAppenter}({@link TAAppendable}.{@link TAAppendable#SUPPRESS SUPPRESS})</CODE></P>

      @see  #UNUSABLE
      @see  #isUseable()
    **/
   public static final TextAppenter SUPPRESS = new TextAppenter(TAAppendable.SUPPRESS);
   /**
      <P>An appenter that outputs to {@code System.out}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>new {@link #TextAppenter(TextAppender) TextAppenter}({@link TAAppendable}.{@link TAAppendable#CONSOLE CONSOLE})</CODE></P>

      @see  #isUseable()
    **/
   public static final TextAppenter CONSOLE = new TextAppenter(TAAppendable.CONSOLE);
   /**
      <P>Create a new <I>and unusable</I> appenter.</P>

      <P>This sets {@link #getTextAppender() getTextAppender}{@code ()} to {@code null}.</P>

      @see  #TextAppenter(TextAppender)
      @see  #UNUSABLE
      @see  #isUseable()
    **/
   private TextAppenter()  {
      tapndr = null;
   }
   /**
      <P>Create a new instance with a text appender.</P>

      @param  to_adapt  May not be {@code null}. Get with {@link #getTextAppender() getTextAppender}{@code ()}.
      @see  #TextAppenter()
    **/
   public TextAppenter(TextAppender to_adapt)  {
      if(to_adapt == null)  {
         throw  new NullPointerException("to_adapt");
      }
      tapndr = to_adapt;
   }
   /**
      <P>The text appender.</P>

      @see  #TextAppenter(TextAppender)
      @see  #TextAppenter()
      @see  #isUseable()
    **/
   public TextAppender getTextAppender()  {
      return  tapndr;
   }
   /**
      <P>Is this appenter useable?.</P>

      @return  {@code true}: If {@code appent*} can be safely called. Specifically, this returns
      <BR> &nbsp; &nbsp; <CODE>({@link #getTextAppender() getTextAppender}() != null)</CODE>
    **/
   public boolean isUseable()  {
      return  (getTextAppender() != null);
   }
   /**
      <P>Get the appendable object at the heard of the text appender--<I>This must only be called when it is known that {@code getTextAppender()} is a {@code TAAppendable}</I>.</P>

      @return  <CODE>(({@link TAAppendable}&lt;Appendable&gt;){@link #getTextAppender() getTextAppender}()).{@link TAAppendable#getAppendable() getAppendable}()</CODE>
      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  ClassCastException  If {@code getTextAppender()} is not a {@code TAAppendable}.
    **/
   @SuppressWarnings("unchecked")
   public Appendable getAppendable()  {
      try  {
         return  ((TAAppendable<Appendable>)getTextAppender()).getAppendable();
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getTextAppender() is not a TAAppendable<Appendable>. getTextAppender()=[" + getTextAppender() + "], original error: " + ccx);
      }
   }
   /**
      <P>Pause the application (that one using this appenter), with a message, until enter is pressed.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #pauseIfUseable(InputStream, Object) pauseIfUseable}({@link java.lang.System}.{@link java.lang.System#in in}, message)</CODE></P>
    **/
   public void pauseIfUseable(Object message)  {
      pauseIfUseable(System.in, message);
   }
   /**
      <P>Pause the application (that one using this appenter), with a message, until enter is pressed. If this appenter is {@linkplain #isUseable() unusable}, this does nothing.</P>

      <P>This calls<OL>
         <LI><CODE>appent(Object)((message == null) ? &quot;Paused. Press enter to proceed.&quot; : message)</CODE></LI>
         <LI><CODE>new {@link java.util.Scanner#Scanner(InputStream) Scanner}(source).{@link java.util.Scanner#nextLine() nextLine}()</CODE></LI>
      </OL></P>
    **/
   public void pauseIfUseable(InputStream source, Object message)  {
      if(!isUseable())  {
         return;
      }
      appent((message == null) ? "Paused. Press enter to proceed." : message);
      new Scanner(source).nextLine();
   }
   /**
      <P>Output a new line only.</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentln()  {
      try  {
         getTextAppender().appendln();
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendln()", iox);
      }
   }
   /**
      <P>Output a message followed by a new line.</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentln(Object message)  {
      try  {
         getTextAppender().appendln(message);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendln(Object), message=\"" + message + "\"", iox);
      }
   }
   /**
      <P>Output a message.</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public TextAppenter appent(Object message)  {
      try  {
         getTextAppender().append(message);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().append(Object), message=\"" + message + "\"", iox);
      }
      return  this;
   }
   /**
      <P>Output a message followed by a new line, only if a condition is met.</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentlnIfTrue(boolean condition, Object message)  {
      try  {
         getTextAppender().appendlnIfTrue(condition, message);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendlnIfTrue(condition, message), condition=" + condition + ", message=\"" + message + "\"", iox);
      }
   }
   /**
      <P>Output a message, only if a condition is met.</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public TextAppenter appentIfTrue(boolean condition, Object message)  {
      try  {
         getTextAppender().appendIfTrue(condition, message);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendIfTrue(condition, message), condition=" + condition + ", message=\"" + message + "\"", iox);
      }
      return  this;
   }
   /**
      <P>Output multiple new lines only, with no text.</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentlns(int newLine_count)  {
      try  {
         getTextAppender().appendlns(newLine_count);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appentlns(newLine_count), newLine_count=" + newLine_count, iox);
      }
   }
   public String toString()  {
      return  this.getClass().getName() + ": getTextAppender()=[" + getTextAppender() + "]";
   }
   /**
      <P>Flush the appendable, if it's flushable.</P>
    **/
   public void flushRtx()  {
      tapndr.flushRtx();
   }
   /**
      <P>(Flush and then) close the appendable, if it's (flushable and) closeable.</P>

      <P>First calls {@link #flushRtx() flushRtx}{@code ()}</P>
    **/
   public void closeRtx()  {
      flushRtx();
      tapndr.closeRtx();
   }
      private final RuntimeException crashIfUnusableOrReturnNpxCause(NullPointerException cause)  {
         if(isUseable())  {
            return  cause;
         }
         return  new UnusableAppenterException();
      }
}
