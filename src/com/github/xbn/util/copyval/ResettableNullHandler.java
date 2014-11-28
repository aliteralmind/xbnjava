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
/**
	<P>Mutable {@code NullHandler} for static internal use only.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ResettableNullHandler<O> implements NullHandler<O>  {
	private O e = null;
	public ResettableNullHandler(O non_nullRplcmnt)  {
		nonNullValue(non_nullRplcmnt);
	}
	/**
		<P>Create a new {@code ResettableNullHandler} as a duplicate of another.</P>

		<P>This<OL>
			<LI>YYY</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	 **/
	public ResettableNullHandler(ResettableNullHandler<O> to_copy)  {
		nonNullValue(to_copy.getNonNull());
	}
	public final ResettableNullHandler nonNullValue(O non_nullRplcmnt)  {
		if(non_nullRplcmnt == null)  {
			throw  new NullPointerException("non_nullRplcmnt");
		}
		e = non_nullRplcmnt;
		return  this;
	}
	public ActionForNull getAction()  {
		return  ActionForNull.USE_NON_NULL;
	}
	public final boolean doCrash()  {
		return  false;
	}
	public final boolean doUseNull()  {
		return  false;
	}
	public final boolean doDelete()  {
		return  false;
	}
	public final boolean doUseNonNull()  {
		return  true;
	}
	public final O getNonNull()  {
		return  e;
	}
	/**
		<P>Duplicate this {@code ResettableNullHandler}.</P>

		@return  <CODE>(new {@link #ResettableNullHandler(ResettableNullHandler) ResettableNullHandler}&lt;O&gt;(this))</CODE>
	 **/
	public NullHandler<O> getObjectCopy()  {
		return  (new ResettableNullHandler<O>(this));
	}
	public String toString()  {
		return  "getNonNull()=[" + getNonNull() + "]";
	}

}
