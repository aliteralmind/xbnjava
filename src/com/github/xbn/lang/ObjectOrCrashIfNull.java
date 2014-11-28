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
/**
	<P>Safely get a potentially-{@code null} object, or a copy of a potentially-{@code null} {@code Copyable}.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ObjectOrCrashIfNull  {
	/**
		<P>Safely get potentially-{@code null} objects in {@code super} or {@code this} constructor calls, where try-catch is not possible.</P>

		@param  obj  The object to get. May not be {@code null}.
		@param  obj_varName  Descriptive name of {@code obj}. <I>Should</I> not be {@code null} or empty.
		@return  {@code obj}  If its non-{@code null}.
		@exception  NullPointerException  If it is.
	 **/
	public static final <O> O get(O obj, String obj_varName)  {
		if(obj == null)  {
			throw  new NullPointerException(obj_varName);
		}
		return  obj;
	}
	/**
		<P>Safely duplicate <CODE>Copyable</CODE> objects.</P>

		@param  to_copy  May not be {@code null}.
		@param  to_castTo  May not be {@code null}.
		@param  toCopy_varName  Descriptive name of {@code to_copy}. <I>Should</I> not be {@code null} or empty.
		@return  <CODE>to_castTo.{@link java.lang.Class#cast(Object) cast}(to_copy.{@link Copyable#getObjectCopy() getObjectCopy}())</CODE>
		@exception  NullPointerException  If {@code to_copy} is {@code null}.
	 **/
	@SuppressWarnings("unchecked")
	public static final <C extends Copyable> C getCopy(Copyable to_copy, Class<C> to_castTo, String toCopy_varName)  {
		Object oCopy = null;
		try  {
			oCopy = to_copy.getObjectCopy();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, toCopy_varName, null, rx);
		}
		try  {
			return  to_castTo.cast(oCopy);
		}  catch(ClassCastException ccx)  {
			throw  new ClassCastException("Attempting to_castTo.cast(" + toCopy_varName + ".getObjectCopy())  //  to_castTo.getName()=" + to_castTo.getName() + ", " + toCopy_varName + ".getClass().getName()=" + to_copy.getClass().getName() + ", to_castTo.getClass().getName()=" + to_castTo.getClass().getName() + ", " + toCopy_varName + ".getObjectCopy().getClass().getName()=" + to_copy.getObjectCopy().getClass().getName());
		}
	}
}