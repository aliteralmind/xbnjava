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
   <P>Basic implementation of {@code Adapter}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SimpleAdapter<D> implements Adapter<D>  {
   private final D oAdptd;
   public SimpleAdapter(D to_adapt)  {
      this(to_adapt, "to_adapt");
   }
   public SimpleAdapter(D to_adapt, String toAdapt_name)  {
      if(to_adapt == null)  {
         throw  new NullPointerException(toAdapt_name);
      }
      oAdptd = to_adapt;
   }
   public SimpleAdapter(SimpleAdapter<D> to_copy)  {
      try  {
         oAdptd = to_copy.getAdapted();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
   }
   public D getAdapted()  {
      return  oAdptd;
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  to_appendTo.append("getAdapted()=<<").append(getAdapted()).append(">>");
   }

}
