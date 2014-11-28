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
package  com.github.xbn.util.copyval;
	import  com.github.xbn.lang.CrashIfObject;
/**
	<P>For classes that need to implement {@code ValueCopier}, that cannot extend {@code AbstractValueCopier}.</P>

	@see  ValueCopier
	@see  AbstractValueCopier
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValueCopierComposer<O> {
	private final boolean bCpybl;

	public ValueCopierComposer(boolean is_copyable)  {
		bCpybl = is_copyable;
	}
	/**
		<P>Create a new {@code ValueCopierComposer} as a duplicate of another.</P>

		<P>This<OL>
			<LI>YYY</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
	 **/
	public ValueCopierComposer(boolean ignored, ValueCopierComposer<O> to_copy)  {
		bCpybl = to_copy.isValueCopyable();
	}
	public ValueCopierComposer(ValueCopier<O> to_copy)  {
		bCpybl = to_copy.isValueCopyable();
	}


	public final boolean isValueCopyable()  {
		return  bCpybl;
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  to_appendTo.append("isValueCopyable()=").append(isValueCopyable());
	}
//static...START
	public static final <O> boolean isValueCopyable(ValueCopier<O> get_valCopy)  {
		try  {
			return  get_valCopy.isValueCopyable();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(get_valCopy, "get_valCopy", null, rx);
		}
	}

//static...END
/*stub functions for implements compile...START
 	public final O getValueCopy(O original)  {
		return  null;
	}
 stub functions for implements compile...END*/
}

