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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.text.CrashIfString;
   import  java.io.IOException;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>{@code TextAppender} that writes to two or more destinations.</p>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for detapndrils. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class MultiTextAppender extends TextAppender  {
   private final TextAppender[] tappenders;
   public MultiTextAppender(TextAppender tappender_1, TextAppender... tappenders_2andUp)  {
      if(tappender_1 == null)  {
         throw  new NullPointerException("tappender_1");
      }
      CrashIfString.nullEmpty(tappenders_2andUp, "tappenders_2andUp", null);
      tappenders = new TextAppender[tappenders_2andUp.length + 1];
      tappenders[0] = tappender_1;
      for(int i = 0; i < tappenders_2andUp.length; i++)  {
         tappenders[i + 1] = tappenders_2andUp[i];
      }
   }
   public MultiTextAppender append(char chr) throws IOException  {
      for(TextAppender tapndr : tappenders)  {
         tapndr.append(chr);
      }
      return  this;
   }
   public MultiTextAppender append(CharSequence text) throws IOException  {
      for(TextAppender tapndr : tappenders)  {
         tapndr.append(text);
      }
      return  this;
   }
   public MultiTextAppender append(CharSequence text, int idx_stapndrrt, int idx_endX) throws IOException  {
      for(TextAppender tapndr : tappenders)  {
         tapndr.append(text, idx_stapndrrt, idx_endX);
      }
      return  this;
   }
   public void flushRtx()  {
      for(TextAppender tapndr : tappenders)  {
         tapndr.flushRtx();
      }
   }
   public void closeRtx()  {
      for(TextAppender tapndr : tappenders)  {
         tapndr.closeRtx();
      }
   }
   /**
      @return  <code>{@link #appendToString(StringBuilder) appendToString}(new StringBuilder()).toString()</code>
    **/
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   /**
      @param  to_appendTo May not be {@code null}.
      @see  #toString()
    **/
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("All appenders:").append(LINE_SEP);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      int lenMinus1 = tappenders.length - 1;
      for(int i = 0; i < tappenders.length; i++)  {
         TextAppender tapdr = tappenders[i];
         to_appendTo.append(" - ").append(tapdr);
         if(i < lenMinus1)  {
            to_appendTo.append(LINE_SEP);
         }
      }
      return  to_appendTo;
   }
}

