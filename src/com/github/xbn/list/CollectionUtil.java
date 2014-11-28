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
package  com.github.xbn.list;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.number.NumberUtil;
	import  java.util.Collection;
	import  java.util.Iterator;
	import  java.util.Map;
	import  java.util.Objects;
/**
	<P>Find the middle index in a collection, and functions to assist in implementing {@code contains(...)} and {@code containsAll(...)}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class CollectionUtil  {
	private CollectionUtil()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	public static final int getSizeCrashIfNull(Collection<?> coll, String coll_name)  {
		try  {
			return  coll.size();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(coll, coll_name, null, rx);
		}
	}
	/**
		<P>Get the middle index of a List.</P>

		@param  coll  May not be {@code null}.
		@return  <CODE>{@link com.github.xbn.number.NumberUtil NumberUtil.}{@link com.github.xbn.number.NumberUtil#getMiddleInt(int, int) getMiddleInt}(0, coll.size())</CODE>
	 **/
	public static final int getMiddleIndex(Collection<?> coll)  {
		try  {
			return  NumberUtil.getMiddleInt(0, coll.size());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
		}
	}
 	/**
 		<P>Does a(n equivalent) object exist in <I>{@code this}</I> collection?.</P>

 		@param  objY  May not be {@code null}.
 	 **/
 	public static final boolean xItrContainsY(Iterator<?> itr_forCollX, Object objY)  {
		int i = 0;
		while(itr_forCollX.hasNext())  {
			Object o = itr_forCollX.next();
			try  {
				if(objY.equals(o))  {
					return true;
				}
			}  catch(RuntimeException rx)  {
				Objects.requireNonNull(objY, "objY");
				throw  CrashIfObject.nullOrReturnCause(o, "[the " + i + "-th call to <iterator()>.next()]", null, rx);
			}
			i++;
		}
		return false;
	}
 	/**
 		@exception  NullPointerException  If {@link #isNull() isNull}{@code ()} is {@code true}.
 	 **/
 	public static final boolean xItrContainsAllY(Iterator<?> itr_forCollX, Collection<?> collY)  {
		Iterator<?> itr = null;
		try  {
			itr = collY.iterator();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(collY, "collY", null, rx);
		}

		while(itr.hasNext())  {
			try  {
				if(!xItrContainsY(itr_forCollX, itr.next()))  {
					return false;
				}
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(itr_forCollX, "itr_forCollX", null, rx);
			}
		}
		return true;
	}
 	public static final boolean xItrContainsY_nullOk(Iterator<?> itr_forCollX, Object objY)  {
		int i = 0;
		try  {
			while(itr_forCollX.hasNext())  {
				Object o = itr_forCollX.next();
				try  {
					if(Objects.equals(objY, o))  {  //null is equal to null
						return true;
					}
				}  catch(RuntimeException rx)  {
					Objects.requireNonNull(objY, "objY");
					throw  CrashIfObject.nullOrReturnCause(o, "[the " + i + "-th call to <getCollection().iterator()>.next()]", null, rx);
				}
				i++;
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(itr_forCollX, "itr_forCollX", null, rx);
		}
		return false;
	}
 	public static final boolean xItrContainsAllY_nullOk(Iterator<?> itr_forCollX, Collection<?> collY)  {
		Iterator<?> itr = null;
		try  {
			itr = collY.iterator();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(collY, "collY", null, rx);
		}

		while(itr.hasNext())  {
			if(!xItrContainsY_nullOk(itr_forCollX, itr.next()))  {
				return false;
			}
		}
		return true;
	}

	public static final <K,V> String toString(Map<K,V> map, String between)  {
		return  appendToString((new StringBuilder()), map, between).toString();
	}
	/**
		<P>YYY</P>

		<P>From (viewed 2/4/2014):
		<BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/a/10120408/2736496">http://stackoverflow.com/a/10120408/2736496</A></CODE></P>
	 **/
	public static final <K,V> StringBuilder appendToString(StringBuilder to_appendTo, Map<K,V> map, String between)  {
		Iterator<Map.Entry<K, V>> iter = null;
		try  {
			iter = map.entrySet().iterator();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(map, "map", null, rx);
		}
		between = ((between == null) ? ", " : between);
		while (iter.hasNext()) {
			Map.Entry<K, V> entry = iter.next();
			try  {
				to_appendTo.append(entry.getKey());
			}  catch(RuntimeException rx)  {
				throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
			}
			to_appendTo.append("=\"");
			to_appendTo.append(entry.getValue());
			to_appendTo.append("\"");
			if (iter.hasNext()) {
				to_appendTo.append(between);
			}
		}
		return  to_appendTo;
	}
}
