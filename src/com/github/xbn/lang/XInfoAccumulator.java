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
package  com.github.xbn.lang;
	import  java.util.ArrayList;
/**
	<p>For collecting multiple extra information objects during the execution of an error checking function--the {@code toString()} of these objects is not executed unless and until an error is thrown. This is not intended to be listed in the signature for any error-checking function. Instead, the extra-information parameter should always be an object. When and if a second piece of extra information is needed, it is added with
	<br/> &nbsp; &nbsp; <code>XInfoAccumulator.{@link #getAddedOrNew(Object, Object) getAddedOrNew}(xtra_errInfo, &quot;new info&quot;)</code>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class XInfoAccumulator implements ToStringAppendable  {
	private final ArrayList<Object> al;
//constructors...START
	public XInfoAccumulator(Object first_xtraInfo)  {
		al = new ArrayList<Object>(5);
		addIfNNull(first_xtraInfo);
	}
//constructors...END
	public XInfoAccumulator addIfNNull(Object xtra_errInfo)  {
		if(xtra_errInfo != null)  {
			al.add(xtra_errInfo);
		}
		return  this;
	}
	public XInfoAccumulator clear()  {
		al.clear();
		return  this;
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		int iItms = al.size();
		if(iItms == 0)  {
			return  to_appendTo;
		}
		int i = 0;
		try  {
			to_appendTo.append("Extra info").append(" (item-count=").append(iItms).append("): ");
		}  catch(RuntimeException rx)  {
			//Can't use CrashIfObject.nullOrReturnCause(...)
			//Circular dependency: XInfoAccumulater-->CrashIfObject-->CrashIfBase-->XInfoAccumulator

			if(to_appendTo == null)  {
				throw  new NullPointerException("to_appendTo");
			}
			throw  rx;
		}
		for(Object o : al)  {
			to_appendTo.append("item-").append(++i).append("=[");
			ToStringDefensive.append(to_appendTo, o, "[extra-info-items]", i);
			to_appendTo.append("]");
			if(i < iItms)  {
				to_appendTo.append(", ");
			}
		}
		return  to_appendTo;
	}
	public static final XInfoAccumulator getAddedOrNew(Object existing_infoMaybeXIA, Object new_infoNotAnXIA)  {
		XInfoAccumulator xia = ((existing_infoMaybeXIA instanceof XInfoAccumulator)
			?  ((XInfoAccumulator)existing_infoMaybeXIA)
			:  new XInfoAccumulator(existing_infoMaybeXIA));
		return  xia.addIfNNull(new_infoNotAnXIA);
	}
}
