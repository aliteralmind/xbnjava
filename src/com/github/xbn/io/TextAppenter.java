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
package  com.github.xbn.io;
   import  java.io.InputStream;
   import  java.util.Scanner;
   import  java.io.IOException;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P><A HREF="http://en.wikipedia.org/wiki/Decorator_pattern">Decorator</A> for {@link java.lang.Appendable}-s, including conditional printing, with runtime-only exceptions. This is a companion to {@code TextAppender}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class TextAppenter  {
   private final TextAppender tapndr;
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

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentln()  {
      try  {
         getTextAppender().appendln();
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendln()", iox);
      }
   }
   /**
      <P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentln(Object string)  {
      try  {
         getTextAppender().appendln(string);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendln(Object), string=\"" + string + "\"", iox);
      }
   }
   /**
      <P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public TextAppenter appent(Object string)  {
      try  {
         getTextAppender().append(string);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().append(Object), string=\"" + string + "\"", iox);
      }
      return  this;
   }
   /**
      <P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentlnIfTrue(boolean condition, Object string)  {
      try  {
         getTextAppender().appendlnIfTrue(condition, string);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendlnIfTrue(condition, string), condition=" + condition + ", string=\"" + string + "\"", iox);
      }
   }
   /**
      <P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public TextAppenter appentIfTrue(boolean condition, Object string)  {
      try  {
         getTextAppender().appendIfTrue(condition, string);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting getTextAppender().appendIfTrue(condition, string), condition=" + condition + ", string=\"" + string + "\"", iox);
      }
      return  this;
   }
   /**
      <P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
    **/
   public void appentlns(int newLine_count)  {
      try  {
         getTextAppender().appendlns(newLine_count);
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
   /**
      <P>Creates a new and unusable appenter.</P>

{@.codelet.and.out com.github.xbn.examples.io.UnusableAppenterExample:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

    **/
   public static final TextAppenter newForUnusable()  {
      return  new TextAppenter();
   }
}
