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
package  com.github.xbn.linefilter.entity;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>Should the lines between the start and end lines in a block entity be kept?.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum KeepMidLines  {
   /**
      <p>YYY.</p>

    * @see  #NO
    * @see  #isYes()
    */
   YES,
   /**
      <p>YYY.</p>

    * @see  #YES
    * @see  #isNo()
    */
   NO;
   /**
      <p>Is this {@code KeepMidLines} equal to {@code YES}?.</p>

    * @return  <code>this == {@link #YES}</code>

    * @see  #isNo()
    */
   public final boolean isYes()  {
      return  this == YES;
   }
   /**
      <p>Is this {@code KeepMidLines} equal to {@code NO}?.</p>

    * @return  <code>this == {@link #NO}</code>
    * @see  #isYes()
    */
   public final boolean isNo()  {
      return  this == NO;
   }
   /**
      <p>Return {@code KeepMidLines.YES} if the flag is {@code true}, or {@code NO} if {@code false}.</p>

    * @return  <code>(flag ? {@link #YES} : {@link #NO})</code>
    */
   public static final KeepMidLines getForBoolean(boolean flag)  {
      return  (flag ? YES : NO);
   }
   public static final KeepMidLines getForKeepMatched(KeepMatched matched, String kam_varName)  {
      try  {
         return  (matched.isYes() ? YES : NO);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(matched, kam_varName, null, rx);
      }
   }
};
