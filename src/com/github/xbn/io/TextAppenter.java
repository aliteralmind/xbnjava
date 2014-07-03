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

   <H3>Example 1 of 2: Optionally debugging an object</H3>

{@.codelet.and.out com.github.xbn.examples.io.TextAppenterObjectDebugging%eliminateCommentBlocksAndPackageDecl()}

   <H3>Example 2 of 2: Optionally debuging an application with potential levels</H3>

   <P>This trivial Java application uses a TextAppenter to provide three possible levels of debugging: Off, minimal, and verbose:</P>

{@.codelet com.github.xbn.examples.io.TextAppenterWithLevelsAppExample%eliminateCommentBlocksAndPackageDecl()}

   <P><B>Output for
   <BR> &nbsp; &nbsp; <CODE>java TextAppenterWithLevelsAppExample debugoff</CODE></B></P>

   <P><I>Not applicable: No output</I></P>

   <P><B>Output for
   <BR> &nbsp; &nbsp; <CODE>TextAppenterWithLevelsAppExample debugminimal</CODE></B></P>

<BLOCKQUOTE><PRE style="background-color:#EEEEEE;">debugminimal --> DebugLevel.ONE
Minimally-important debugging information goes here...</PRE></BLOCKQUOTE>

<!--
   {&#64;.codelet.out com.github.xbn.examples.io.TextAppenterWithLevelsAppExample("debugminimal")}
 -->

   <P><B>Output for
   <BR> &nbsp; &nbsp; <CODE>TextAppenterWithLevelsAppExample debugverbose</CODE></B></P>

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
   public static final TextAppenter UNUSABLE = new TextAppenter();
   public static final TextAppenter SUPPRESS = new TextAppenter(TAAppendable.SUPPRESS);
   public static final TextAppenter CONSOLE = new TextAppenter(TAAppendable.CONSOLE);
   private TextAppenter()  {
      tapndr = null;
   }
   public TextAppenter(TextAppender to_adapt)  {
      if(to_adapt == null)  {
         throw  new NullPointerException("to_adapt");
      }
      tapndr = to_adapt;
   }
   public TextAppender getTextAppender()  {
      return  tapndr;
   }
   /**
      <P>Is this appenter useable?.</P>

      @return  <UL>
         <LI>{@code true}  If this object was created via the {@linkplain #TextAppenter(TextAppender) constructor}.</LI>
         <LI>{@code false}  If created by {@link #newForUnusable() newForUnusable}{@code ()}.</LI>
      </UL>
      @see  UnusableAppenterException
    **/
   public boolean isUseable()  {
      return  (getTextAppender() != null);
   }
   @SuppressWarnings("unchecked")
   public Appendable getAppendable()  {
      try  {
         return  ((TAAppendable<Appendable>)getTextAppender()).getAppendable();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getTextAppender() is not a TAAppendable<Appendable>. getTextAppender()=[" + getTextAppender() + "], original error: " + ccx);
      }
   }
   public void pauseIfUseable(Object message)  {
      pauseIfUseable(System.in, message);
   }
   public void pauseIfUseable(InputStream source, Object message)  {
      if(isUseable())  {
         appent((message == null) ? "Paused. Press enter to proceed."
            :  message);
         new Scanner(source).nextLine();
      }
   }
   /**
      <P>YYY</P>

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
      <P>YYY</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentln(Object string)  {
      try  {
         getTextAppender().appendln(string);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendln(Object), string=\"" + string + "\"", iox);
      }
   }
   /**
      <P>YYY</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public TextAppenter appent(Object string)  {
      try  {
         getTextAppender().append(string);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().append(Object), string=\"" + string + "\"", iox);
      }
      return  this;
   }
   /**
      <P>YYY</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentlnIfTrue(boolean condition, Object string)  {
      try  {
         getTextAppender().appendlnIfTrue(condition, string);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendlnIfTrue(condition, string), condition=" + condition + ", string=\"" + string + "\"", iox);
      }
   }
   /**
      <P>YYY</P>

      @exception  UnusableAppenterException  If {@link #isUseable() isUseable}{@code ()} is {@code false}
      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public TextAppenter appentIfTrue(boolean condition, Object string)  {
      try  {
         getTextAppender().appendIfTrue(condition, string);
      }  catch(NullPointerException npx)  {
         throw  crashIfUnusableOrReturnNpxCause(npx);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendIfTrue(condition, string), condition=" + condition + ", string=\"" + string + "\"", iox);
      }
      return  this;
   }
   /**
      <P>YYY</P>

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
   public void flushRtx()  {
      tapndr.flushRtx();
   }
   public void closeRtx()  {
      flushRtx();
      tapndr.closeRtx();
   }
   /*
      <P>Creates a new and unusable appenter.</P>

{@.codelet.and.out com.github.xbn.examples.io.UnusableAppenterExample%eliminateCommentBlocksAndPackageDecl()}

   public static final TextAppenter newForUnusable()  {
      return  new TextAppenter();
   }
    */
      private final RuntimeException crashIfUnusableOrReturnNpxCause(NullPointerException cause)  {
         if(isUseable())  {
            return  cause;
         }
         return  new UnusableAppenterException();
      }
}
