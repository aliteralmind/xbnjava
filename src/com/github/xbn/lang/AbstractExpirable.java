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
   <P>Abstract implementation of <CODE>Expirable</CODE>. For classes needing to implement <CODE>Expirable</CODE>, that cannot extend <CODE>AbstractExpirable</CODE>, see <CODE><A HREF="ExpirableComposer.html">ExpirableComposer</A></CODE>.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class AbstractExpirable implements Expirable  {
   private final ExpirableComposer ec;
   public AbstractExpirable(boolean is_expirable)  {
      ec = new ExpirableComposer(is_expirable);
   }
   public AbstractExpirable(Expirable xpr_bl)  {
      ec = new ExpirableComposer(xpr_bl);
   }
   public boolean doesExpire()  {
      return  ec.doesExpire();
   }
   protected void declareExpired()  {
      ec.declareExpired_4prot();
   }
   public boolean isExpired()  {
      return  ec.isExpired();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  ec.appendToString(to_appendTo);
   }
}
