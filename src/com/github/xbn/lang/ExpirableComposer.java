/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.lang;
/**
   <P>For classes that need to implement <CODE>Expirable</CODE>, that cannot extend abstract or concrete implementations.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ExpirableComposer  {
   private boolean bXprbl;
   private boolean bXprd;
   public ExpirableComposer()  {
      this(false);
   }
   public ExpirableComposer(boolean is_expirable)  {
      bXprbl = is_expirable;
      bXprd = false;
   }
   public ExpirableComposer(boolean ignored, ExpirableComposer to_copy)  {
      try  {
         bXprbl = to_copy.doesExpire();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      bXprd = to_copy.isExpired();
   }
   public ExpirableComposer(Expirable exp_bl)  {
      try  {
         bXprbl = exp_bl.doesExpire();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(exp_bl, "exp_bl", null, rx);
      }
      bXprd = exp_bl.isExpired();
   }
   public boolean doesExpire()  {
      return  bXprbl;
   }
   public void declareExpirable_4prot()  {
      bXprbl = true;
   }
   public void declareExpired_4prot()  {
      if(!doesExpire())  {
         throw  new IllegalStateException("doesExpire() is false.");
      }
      bXprd = true;
   }
   public boolean isExpired()  {
      return  bXprd;
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         if(!doesExpire())  {
            return  to_appendTo.append("does-not-expire");
         }

         return  to_appendTo.append("expirable ").append(isExpired() ? "and expired" : "but not-expired");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
   }
}
