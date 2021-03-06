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
package  com.github.xbn.regexutil;
   import  com.github.xbn.text.padchop.NewVzblPadChopFor;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.io.TextAppenter;

/**
   <p>Regex-match or between token, as returned by <code>[<i>RegexTokenizer</i>].next()</code>.

 * @see  RegexTokenizer#next()
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class TokenizerElement implements Copyable  {
   private static final VzblPadChop VPC_DBG = NewVzblPadChopFor.trimEscChopWithDDD(true, null, 30);
   private int lineNum = -1;
   private boolean isSep = false;
   private int startIdx = -1;
   private String text = null;
   /**
      <p>Create a new TokenizerElement.</p>

    * @param  line_num  The line number of the string in which this token was found, if it happens to be part of a multi-line source. Get with {@link #getLineNumber() getLineNumber}{@code ()}.
    * @param  is_separatorOrBtwn  Is this token a regex-match, or a between? Get with {@link #isSeparator() isSeparator}{@code ()} and {@link #isBetween() isBetween}{@code ()}.
    * @param  start_idx  Get the index at which this token starts <i>in the original string. Get with {@link #getIdxStart() getIdxStart}{@code ()}.
    * @param  text   The token text. May not be {@code null} and, if {@code is_separatorOrBtwn} is {@code true}, it may not be empty. Get with {@link #getText() getText}{@code ()}.
    */
   public TokenizerElement(int line_num, boolean is_separatorOrBtwn, int start_idx, String text, boolean do_debug, TextAppenter debug_apntr)  {
      try  {
         if(is_separatorOrBtwn  &&  text.length() == 0)  {
            throw  new NullPointerException("This is a sepatator token, but the text is empty. is_separatorOrBtwn=true, text=\"\"");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(text, "text", null, rx);
      }

      isSep = is_separatorOrBtwn;
      lineNum = line_num;
      startIdx = start_idx;
      this.text = text;

      if(do_debug)  {
         try  {
            debug_apntr.appent("<RT> ");
            if(lineNum != -1)  {
               debug_apntr.appent("line=").appent(lineNum).appent(", ");
            }
            debug_apntr.appent("start-index=").appent(startIdx).appent(", ").
               appent(is_separatorOrBtwn ? "separator" : "between").appent(": ").
               appent("\"").appent(VPC_DBG.get(text)).appentln("\"");
         }  catch(RuntimeException rx)  {
            CrashIfObject.nullOrReturnCause(debug_apntr, "debug_apntr", "do_debug is true", rx);
         }
      }
   }
   /**
      <p>Create a new {@code TokenizerElement} as a duplicate of another.</p>

      <p>This<ol>
         <li>YYY</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    * @see  #getObjectCopy()
    */
   public TokenizerElement(TokenizerElement to_copy)  {
      try  {
         isSep = to_copy.isSeparator();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      lineNum = to_copy.getLineNumber();
      startIdx = to_copy.getIdxStart();
      text = to_copy.getText();
   }
   /**
      <p>Get the line number on which this element exists.</p>
    */
   public final int getLineNumber()  {
      return  lineNum;
   }
   /**
      <p>The token text.</p>
    */
   public String getText()  {
      return  text;
   }
   /**
      <p>The token's start index, as it exists in the original string.</p>
    */
   public final int getIdxStart()  {
      return  startIdx;
   }
   /**
      <p>Is this a separator token?.</p>
    */
   public boolean isSeparator()  {
      return  isSep;
   }
   /**
      <p>Is this a between token?.</p>

    * @return  <b> <code>(!{@link #isSeparator() isSeparator}())</code></b>
    */
   public final boolean isBetween()  {
      return  (!isSeparator());
   }
   public String toString()  {
      return  this.getClass().getName() + ": start-index=" + getIdxStart() + ", " + (isSeparator() ? "separator" : "between") + ", getText()=\"" + getText() + "\"";
   }
   /**
      <p>Duplicate this {@code TokenizerElement}.</p>

    * @return  <code>(new {@link #TokenizerElement(TokenizerElement) TokenizerElement}(this))</code>
    */
   public TokenizerElement getObjectCopy()  {
      return  (new TokenizerElement(this));
   }
}
