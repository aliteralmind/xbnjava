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
package  com.github.xbn.analyze.alter;
/**
	<P>A {@code ValueAlterer} that always changes the object to a pre-determined value.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SetToStaticValue<V,A> extends AbstractValueAlterer<V,A>  {
	private final A toAltrTo;
	public SetToStaticValue(A to_alterTo)  {
		super();
		toAltrTo = to_alterTo;
	}
	public SetToStaticValue(boolean ignored, SetToStaticValue<V,A> to_copy)  {
		super(to_copy);
		toAltrTo = to_copy.getStaticValue();
	}
	public A getAlteredPostResetCheck(V ignored, A to_alter)  {
		declareAltered(Altered.YES, NeedsToBeDeleted.NO);
		return  getStaticValue();
	}
	public A getStaticValue()  {
		return  toAltrTo;
	}
	/**
		@return  <CODE>(new {@link #SetToStaticValue(boolean, SetToStaticValue) SetToStaticValue}&lt;V,A&gt;(false*, this))</CODE>
	 **/
	public SetToStaticValue<V,A> getObjectCopy()  {
		return  (new SetToStaticValue<V,A>(false, this));
	}
/*
	public SetToStaticValue<V,A> extraErrInfo(Object info)  {
		setExtraErrInfo(info);
		return  this;
	}
 */
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  to_appendTo.append(this.getClass().getName()).append(": getStaticValue()=[" + getStaticValue() + "]");
	}
}
