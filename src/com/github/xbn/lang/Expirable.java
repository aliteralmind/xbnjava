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
   <P>For classes that do stuff, but once reaching a certain point, permanently stop doing it.</P>

   @see  com.github.xbn.analyze.alter.ExpirableAlterList
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface Expirable  {
   /**
   	<P>Does this object potentially expire?.</P>

   	@return  <UL>
   		<LI>{@code true}: {@link #isExpired() isExpired}{@code ()} could at some point become {@code true}.</LI>
   		<LI>{@code false}: {@code isExpired()} will never be {@code true}.</LI>
   	</UL>This value never changes.
    **/
   boolean doesExpire();
   /**
   	<P>Is this object expired?.</P>

   	@return  <UL>
   		<LI>{@code true}  The object is expired.</LI>
   		<LI>{@code false}: If {@link #doesExpire() doesExpire}{@code ()} is {@code false}.</LI>
   	</UL>This value may change from {@code true} to {@code false}, but never back.
    **/
   boolean isExpired();
}
