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
//	import  com.github.xbn.util.copyval.ValueCopier;
//	import  com.github.xbn.util.copyval.ValueNotCopyable;
//	import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
//	import  com.github.xbn.util.copyval.ValueCopierComposer;
/**
	<P>Implementation of {@code NamedValue}.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SimpleNameValue<V> extends SimpleKeyValue<String,V> implements NameValue<V>  {
//constructors...START
	@SuppressWarnings("unchecked")
	public SimpleNameValue(String name, V value)  {
		super(name, value);
	}
	/*
	public SimpleNameValue(String name, V value, ValueCopier<V> copier)  {
		this(name, value, copier, "name");
	}
	@SuppressWarnings("unchecked")
	public SimpleNameValue(String name, V value, String nameName)  {
		this(name, value, (ValueCopier<V>)ValueNotCopyable.INSTANCE, nameName);
	}
	public SimpleNameValue(String name, V value, ValueCopier<V> copier, String nameName)  {
		super(name, (new OneParamCnstrValueCopier<String>(String.class)), value, copier);
		SimpleNamed.ciBadNameInCnstr(name, "name");
	}
		<P>Create a new {@code SimpleNameValue} as a duplicate of another.</P>

		<P>This<OL>
			<LI>Calls {@link SimpleKeyValue#SimpleKeyValue(KeyValue) super}{@code (to_copy)}</LI>
			<LI>YYY</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	public SimpleNameValue(NameValue<V> to_copy)  {
		super(to_copy);
	}
	 */
//constructors...END
	public String getName()  {
		return  getKey();
	}
	/*
		<P>Duplicate this {@code SimpleNameValue}.</P>

		@return  <CODE>(new {@link #SimpleNameValue(NameValue) SimpleNameValue}&lt;String,V&gt;(this))</CODE>
	public SimpleNameValue<V> getObjectCopy()  {
		return  (new SimpleNameValue<V>(this));
	}
	 */
}
