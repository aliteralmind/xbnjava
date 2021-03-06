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
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.io.z.GetDebugApbl_Fieldable;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>Basic implementation of {@code Debuggable}.</p>

 * @author  Copyright (C) 2014, Jeff Epstein. Released under the LPGL 2.1. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
**/
public class SimpleDebuggable implements Debuggable  {
   private TextAppenter xpnt = null;
   private boolean bOn = false;

//constructors...START
   /**
      <p>Create a new {@code SimpleDebuggable}.</p>

      <p>This calls<ol>
         <li>Sets {@link #getDebugAptr() getDebugAptr}{@code ()} to {@code null}.</li>
         <li>Sets {@link #isDebugOn() isDebugOn}{@code ()} to {@code false}.</li>
      </ol></p>

    * @see  #SimpleDebuggable(GetDebugApbl_Fieldable) this(gda_f)
    */
   public SimpleDebuggable()  {
      //Never ever call interface functions, directly or indirectly, in a constructor.
      zsetDebugDB(null, false);
   }
   public SimpleDebuggable(GetDebugApbl_Fieldable fieldable)  {
      try  {
         onIfNonNull(fieldable.getDebugApbl());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(fieldable, "fieldable", null, rx);
      }
   }

   /**
      <p>YYY</p>


      <p>This calls<ol>
         <li>Sets {@link #getDebugAptr() getDebugAptr}{@code ()} to {@code to_copy.getDebugAptr()}.</li>
         <li>Sets {@link #isDebugOn() isDebugOn}{@code ()} to {@code to_copy.isDebugOn()}.</li>
      </ol></p>
    * @see  #SimpleDebuggable() this()
    */
   public SimpleDebuggable(Debuggable to_copy)  {
      //Never ever call interface functions, directly or indirectly, in a constructor.
      try  {
         xpnt = to_copy.getDebugAptr();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      zsetDebugOnDB(to_copy.isDebugOn());
   }
//constructors...END
//setters...START
   public SimpleDebuggable onIfNonNull(Appendable destination)  {
      setDebug(destination, (destination != null));
      return  this;
   }
   public void setDebug(Appendable destination, boolean is_on)  {
      zsetDebugDB(destination, is_on);
   }
   protected final void zsetDebugDB(Appendable destination, boolean is_on)  {
      if(destination == null)  {
         if(is_on)  {
            throw  new IllegalArgumentStateException("destination is null and is_on is true.");
         }
         xpnt = TextAppenter.SUPPRESS;
      }  else  {
         xpnt = NewTextAppenterFor.appendable(destination);
      }
      setDebugOn(is_on);
   }
   public void setDebugOn(boolean is_on)  {
      zsetDebugOnDB(is_on);
   }
   protected final void zsetDebugOnDB(boolean is_on)  {
      if(is_on  &&  getDebugAptr() == null)  {
         throw  new IllegalStateException("is_on is true, but getDebugAptr() is null.");
      }
      bOn = is_on;
   }
//setters...END
//getters...START
   public boolean isDebugOn()  {
      return  bOn;
   }
   public final TextAppenter getDebugAptr()  {
      return  xpnt;
   }
   public Appendable getDebugApbl()  {
      return  getDebugAptr().getAppendable();
   }
//getters...END
//other...START
   public TextAppenter debug(Object message)  {
      return  getDebugAptr().appent(message);
   }
   public void debugln(Object message)  {
      getDebugAptr().appentln(message);
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      if(!isDebugOn())  {
         return  to_appendTo.append("<debug-off>");
      }

      return  to_appendTo.append("<Debug to ").append(getDebugApbl().getClass().getName()).append(">");
   }
   /**
      <p>Duplicate this {@code SimpleDebuggable}</p>

    * @return  <code>(new {@link #SimpleDebuggable(Debuggable) SimpleDebuggable}(this)</code>
    */
   public SimpleDebuggable getObjectCopy()  {
      return  (new SimpleDebuggable(this));
   }
//other...END
}
