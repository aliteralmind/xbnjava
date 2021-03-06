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
package  com.github.xbn.keyed;
//	import  static com.github.xbn.lang.XbnConstants.*;
/**
   <p>Implementation of {@code KeyValue}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SimpleKeyValue<K,V> extends SimpleKeyed<K> implements KeyValue<K,V>  {
//state
   private final V v;
//constructors...START
//	@SuppressWarnings("unchecked")
   public SimpleKeyValue(K key, V value)  {
//		this(key, (ValueCopier<K>)ValueNotCopyable.INSTANCE, value, (ValueCopier<V>)ValueNotCopyable.INSTANCE);
      super(key);
      v = value;
   }
/*
   public SimpleKeyValue(K key, ValueCopier<K> key_copier, V value, ValueCopier<V> copier)  {
      super(key, key_copier);
      v = value;
      gvcv = copier;
   }
 */
   /*
      <p>Create a new {@code SimpleKeyValue} as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls {@link SimpleKeyed#SimpleKeyed(Keyed) super}{@code (_toCopy)}</li>
         <li>YYY</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    * @see  #getObjectCopy()
   @SuppressWarnings("unchecked")
   public SimpleKeyValue(KeyValue<K,V> to_copy)  {
      super(to_copy);
      @SuppressWarnings("unchecked")
      ValueCopier<V> gvcv2 = (ValueCopier<V>)ObjectOrCrashIfNull.
         <ValueCopier>getCopy(to_copy.getValueCopier(), ValueCopier.class, "to_copy.getValueCopier()");
      gvcv = gvcv2;
      v = to_copy.getValue();
      if(isValueCopyable())  {
         v = to_copy.getValueCopier().getValueCopy(v, "constructor");
      }
   }
   public boolean isValueCopyable()  {
      return  getValueCopier().isValueCopyable();
   }
   public ValueCopier<V> getValueCopier()  {
      return  gvcv;
   }
    */
//constructors...END
   public V getValue()  {
      return  v;
   }
   public String toString()  {
      return  super.toString() + ", value=[" + getValue() + "]";
   }
   /**
      <p>Duplicate this {@code SimpleKeyValue}.</p>

    * @return  <code>(new {@link #SimpleKeyValue(KeyValue) SimpleKeyValue}&lt;K,V&gt;(this))</code>
   public SimpleKeyValue<K,V> getObjectCopy()  {
      return  (new SimpleKeyValue<K,V>(this));
   }
    */
}
