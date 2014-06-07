/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.util.itr;
   import  java.util.Objects;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.array.CrashIfIndex;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  java.util.Iterator;
   import  java.util.NoSuchElementException;
/**
   <P>Assists in building iterators. Sub-classes must implement {@link java.util.Iterator#next() next}{@code ()} and {@link java.util.Iterator#hasNext() hasNext}{@code ()}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractIterator<E> implements Iterator<E>  {
//state
   /**
      <P>Create a new instance. This does nothing.</P>
    **/
   public AbstractIterator()  {
   }
   /**
      <P><I>Do not use.</I></P>

      @exception  UnsupportedOperationException
    **/
   public void remove() {
      throw  new UnsupportedOperationException("remove()");
   }
   /**
      <P>If there are no more elements, crash. Otherwise, do nothing.</P>

      @exception  NoSuchElementException  If {@link #hasNext() hasNext}{@code ()} is {@code false}.
    **/
   protected void crashIfNoNext()  {
      if(!hasNext())  {
         throw  new NoSuchElementException();
      }
   }
/*stub functions for implements compile...START
   public boolean hasNext()  {
      return  false;
   }
   public E next()  {
      return  null;
   }
 stub functions for implements compile...END*/
}
