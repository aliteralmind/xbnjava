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
package  com.github.xbn.keyed;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.lang.CrashIfObject;
//	import  com.github.xbn.util.copyval.ValueNotCopyable;
   import  static com.github.xbn.lang.XbnConstants.*;
//	import  com.github.xbn.util.copyval.ValueCopier;
/**
   <P>Implementation of {@code Keyed}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SimpleKeyed<K> implements Keyed<K>  {
//state
   private K k = null;
//	private ValueCopier<K> keyCopier = null;
//constructors...START
   @SuppressWarnings("unchecked")
   public SimpleKeyed(K key)  {
      k = key;
//		this(key, (ValueCopier<K>)ValueNotCopyable.INSTANCE);
   }
/*
   public SimpleKeyed(K key, ValueCopier<K> get_valCopy)  {
      k = key;
      keyCopier = get_valCopy;
   }
 */
   /*
      <P>Create a new {@code SimpleKeyed} as a duplicate of another.</P>

      <P>This<OL>
         <LI>Calls {@link com.github.xbn.util.lock.AbstractOneWayLockable#AbstractOneWayLockable(AbstractOneWayLockable) super}{@code (_toCopy)}</LI>
         <LI>YYY</LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
   @SuppressWarnings("unchecked")
   public SimpleKeyed(Keyed<K> to_copy)  {
      try  {
         @SuppressWarnings("unchecked")
         ValueCopier<K> keyCopier2 = (ValueCopier<K>)ObjectOrCrashIfNull.
            <ValueCopier>getCopy(to_copy.getKeyCopier(), ValueCopier.class, "to_copy.getKeyCopier()");
         keyCopier = keyCopier2;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      k = to_copy.getKey();
      if(isKeyCopyable())  {
         k = to_copy.getKeyCopier().getValueCopy(k, "constructor");
      }
   }
    */
//constructors...END
/*
   public boolean isKeyCopyable()  {
      return  getKeyCopier().isValueCopyable();
   }
   public ValueCopier<K> getKeyCopier()  {
      return  keyCopier;
   }
 */
   public K getKey()  {
      return  k;
   }
   public String toString()  {
      return  "key=[" + getKey() + "]";
   }
   /**
      <P>Get a duplicate of this {@code SimpleKeyed}.</P>

      @return  <CODE>(new {@link #SimpleKeyed(Keyed) SimpleKeyed}&lt;K&gt;(this))</CODE>
   public SimpleKeyed<K> getObjectCopy()  {
      return  (new SimpleKeyed<K>(this));
   }
    **/
}
