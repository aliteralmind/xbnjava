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
   import  com.github.xbn.io.z.GetDebugApbl_Fieldable;
/**
   <p>{@code Debuggable}-s provide optional run-time diagnostics.</p>

   @author  Copyright (C) 2014, Jeff Epstein. Released under the LPGL 2.1. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface Debuggable extends GetDebugApbl_Fieldable  {
//setters......START
   /**
      <p>Set the writer for debugging output.</p>

      @param  destination  If {@code null}, this also calls {@link #setDebugOn(boolean) setDebugOn(false)}. Get with {@link #getDebugAptr() getDebugAptr}{@code ()}.
    **/
   void setDebug(Appendable destination, boolean is_on);
   /**
      <p>Turn debugging on or off.</p>

      @param  is_on  If {@code true}, debugging is turned on. Get with {@link #isDebugOn() isDebugOn}{@code ()}.
      @exception  IllegalStateException  If {@link #getDebugAptr() getDebugAptr}{@code ()} is {@code null}.
    **/
   void setDebugOn(boolean is_on);
//setters......END
//getters...START
   /**
      <p>Is debugging active?.</p>

      @see  #setDebugOn(boolean)
    **/
   boolean isDebugOn();
   /**
      <p>Get the current debug-writer, <i>which throws {@code RuntimeException}-s only</i>.</p>

      @see  #setDebug(Appendable, boolean)
    **/
   TextAppenter getDebugAptr();
   Appendable getDebugApbl();
   TextAppenter debug(Object message);
   void debugln(Object message);
//getters...END
}
