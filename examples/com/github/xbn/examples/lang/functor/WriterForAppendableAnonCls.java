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

package  com.github.xbn.examples.lang.functor;
   import  java.io.Closeable;
   import  java.io.Flushable;
   import  java.io.IOException;
   import  java.io.Writer;
/**
   <p>Obtain the text from a file or web-page, wrap an {@code java.lang.Appendable} into a {@code java.io.Writer}, and other I/O utilities.</p>

   <p>{@code java com.github.xbn.examples.lang.functor.WriterForAppendableAnonCls}</p>

   @author  Copyright (C) 2014, Jeff Epstein, with asistance by Marc Baumbach for {@code newWriterForAppendable(apbl)}. Released under the LPGL 2.1. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class WriterForAppendableAnonCls extends Writer  {
   public static final void main(String[] ignored)  {
      Writer wrtr = new WriterForAppendableAnonCls(System.out);
      try  {
         wrtr.append("hello");
         wrtr.close();            //System.out isn't closeable, but let's do it anyway...
      }  catch(IOException iox)  {
         throw  new RuntimeException(iox);
      }
   }
   private final Appendable apbl;
   private final Flushable  flshbl;
   private final Closeable  clsbl;
   public WriterForAppendableAnonCls(Appendable apbl)  {
      if(apbl == null)  {
         throw  new NullPointerException("apbl");
      }
      this.apbl = apbl;

      //Avoids instanceof at every call to flush() and close()
      flshbl = ((apbl instanceof Flushable)
         ?  (Flushable)apbl
         :  new Flushable()  {
            public void flush() throws IOException  {
            }
            });
      clsbl = ((apbl instanceof Closeable)
         ?  (Closeable)apbl
         :  new Closeable()  {
            public void close() throws IOException  {
            }
            });
   }
   @Override
   public void write(char[] prim_array, int idx_start, int idx_endX) throws IOException {
      apbl.append(String.valueOf(prim_array), idx_start, idx_endX);
   }
   @Override
   public Writer append(char chr) throws IOException {
      apbl.append(chr);
      return  this;
   }
   @Override
   public Writer append(CharSequence text) throws IOException {
      apbl.append(text);
      return  this;
   }
   @Override
   public Writer append(CharSequence text, int idx_start, int idx_endX) throws IOException  {
      apbl.append(text, idx_start, idx_endX);
      return  this;
   }
   @Override
   public void flush() throws IOException {
      flshbl.flush();
   }
   @Override
   public void close() throws IOException {
      flush();
      clsbl.close();
   }
}
