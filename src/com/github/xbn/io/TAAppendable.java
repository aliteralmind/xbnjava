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
   import  java.io.Closeable;
   import  java.io.Flushable;
   import  java.io.PrintStream;
   import  java.io.IOException;
/**
   <p>Immutable {@code TextAppender} for {@code Appendable}-s. See {@link com.github.xbn.io.TAAppendMutable TAAppendMutable}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class TAAppendable<A extends Appendable> extends TextAppender  {
   private final Flushable  flbl;
   private final Closeable  clbl;
   public static final TAAppendable<PrintStream> CONSOLE = new TAAppendable<PrintStream>(System.out);
   public static final TAAppendable<Appendable> SUPPRESS = new TAAppendable<Appendable>(IOUtil.APBL_SUPPRESS_ALL);
   private final A apbl;
   public TAAppendable(A to_appendTo)  {
      this(to_appendTo, "to_appendTo");
   }
   public TAAppendable(A to_appendTo, String apbl_name)  {
      if(to_appendTo == null)  {
         throw  new NullPointerException(apbl_name);
      }
      apbl = to_appendTo;

      //Avoids instanceof at every call to flush() and close()
      flbl = (Flushable)((to_appendTo instanceof Flushable) ? to_appendTo
         :  IOUtil.FLUSHABLE_DO_NOTHING);
      clbl = (Closeable)((to_appendTo instanceof Closeable) ? to_appendTo
         :  IOUtil.CLOSEABLE_DO_NOTHING);
   }
   public A getAppendable()  {
      return  apbl;
   }
   public TAAppendable append(char chr) throws IOException  {
      getAppendable().append(chr);
      flushRtx();
      return  this;
   }
   public TAAppendable append(CharSequence text) throws IOException  {
      getAppendable().append(text);
      flushRtx();
      return  this;
   }
   public TAAppendable append(CharSequence text, int idx_start, int idx_endX) throws IOException  {
      try  {
         getAppendable().append(text, idx_start, idx_endX);
      }  catch(IndexOutOfBoundsException ibx)  {
         throw  TextAppender.newIBXForCSSubstr(text, idx_start, idx_endX, ibx);
      }
      flushRtx();
      return  this;
   }
   public String toString()  {
      return  getAppendable().toString();
   }
   /**
      <p>Get a reference to <i>this</i> object</p>

    * @return  <i>{@code this}</i>
    */
   public TAAppendable<A> getObjectCopy()  {
      return  this;
   }
   @Override
   public void flushRtx()  {
      try  {
         flbl.flush();
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   @Override
   public void closeRtx()  {
      flushRtx();
      try  {
         clbl.close();
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
}
