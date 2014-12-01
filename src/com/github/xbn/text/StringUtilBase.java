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
package  com.github.xbn.text;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>Get a string's length (or crash if it's {@code null}), or value (or a default if {@code null}, or chopped value. These functions are fundamental to XBN-Java, and are therefore separated from {@link StringUtil} to avoid circular dependencies.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class StringUtilBase  {
   protected StringUtilBase()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final String getFromObject(Object obj_text)  {
      return  ((obj_text == null) ? null : obj_text.toString());
   }
   /**
      <p>Get the length of a string, or crash if it's {@code null}.</p>

      <!-- MAIN FUNCTION -->
    * @param  str_toPad  The string whose length is needed.
    * @exception  NullPointerException  If {@code str_toPad} is {@code null}.
    */
   public static final int getLengthCrashIfNull(Object str_toPad, String str_name)  {
      try  {
         return  str_toPad.toString().length();
      }  catch(RuntimeException rx)    {
         throw  CrashIfObject.nullOrReturnCause(str_toPad, str_name, null, rx);
      }
   }
   /*
      <p>Get the length of a string, or crash if it's {@code null}.</p>

      <!-- MAIN FUNCTION -->
    * @param  str_toPad  The string whose length is needed.
    * @exception  NullPointerException  If {@code str_toPad} is {@code null}.
   public static final int getLengthCrashIfNull(Object str_toPad, String str_name, Object xtra_errInfo)  {
      try  {
         return  str_toPad.toString().length();
      }  catch(RuntimeException rx)    {
         throw  CrashIfObject.nullOrReturnCause(str_toPad, str_name, xtra_errInfo, rx);
      }
   }
    */
   /**
      <p>Chop and optionally trim a string.</p>

    * @param  do_trim  If {@code YES}, {@code str_toPad} is trimmed first. May not be {@code null}.
    * @param  str_toPad  The string to trim.
    * @param  max_len  The length to trim to. If {@code -1}, it is not trimmed. Otherwise, must be zero or greater.
    * @param  ellipsis  If non-{@code null} and the string <i>is</i> chopped, then this is appended to the end. Example: {@code "..."}. When {@code null}, no ellipsis is appended.
    * @exception  StringIndexOutOfBoundsException  If {@code max_len} is invalid.
    */
   public static final String getChopped(Trim do_trim, Object str_toPad, int max_len, String ellipsis)  {
      if(str_toPad == null)  {
         return  null;
      }

      String s = str_toPad.toString();
      try  {
         if(do_trim.isYes())  {
            s = s.trim();
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(do_trim, "do_trim", null, rx);
      }

      if(max_len == -1  ||  s.length() <= max_len)  {
         return  s.toString();
      }

      try  {
         return  s.substring(0, max_len) + ((ellipsis == null) ? "" : ellipsis);
      }  catch(IndexOutOfBoundsException ibx)  {
         throw  new StringIndexOutOfBoundsException("max_len (" + max_len + ") is invalid given str_toPad.toString().length()=" + s.length() + ". // Original exception: " + ibx);
      }
   }
}
