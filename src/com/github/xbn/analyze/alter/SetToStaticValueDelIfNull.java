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
	<p>A {@code ValueAlterer} that always changes it to a pre-determined value with an exception: When the <i>value-to-alter</i> is {@code null}, it is instead deleted.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class SetToStaticValueDelIfNull<V,A> extends AbstractValueAlterer<V,A>  {
	private A toAltrTo = null;
	public SetToStaticValueDelIfNull(A to_alterTo)  {
		super();
		toAltrTo = to_alterTo;
	}
	public SetToStaticValueDelIfNull(SetToStaticValueDelIfNull<V,A> to_copy)  {
		super(to_copy);
		toAltrTo = to_copy.getStaticValue();
	}
	public A getAlteredPostResetCheck(V ignored, A to_alter)  {
		boolean wasDel = (to_alter == null);
		declareAltered(Altered.getForBoolean(!wasDel), NeedsToBeDeleted.getForBoolean(wasDel));
		return  getStaticValue();
	}
	public A getStaticValue()  {
		return  toAltrTo;
	}
	/**
		@return  <code>(new {@link #SetToStaticValueDelIfNull(SetToStaticValueDelIfNull) SetToStaticValueDelIfNull}&lt;V,A&gt;(this))</code>
	 **/
	public SetToStaticValueDelIfNull<V,A> getObjectCopy()  {
		return  (new SetToStaticValueDelIfNull<V,A>(this));
	}
/*
	public SetToStaticValueDelIfNull<V,A> extraErrInfo(Object info)  {
		setExtraErrInfo(info);
		return  this;
	}
 */
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  to_appendTo.append(this.getClass().getName()).append(": getStaticValue()=[" + getStaticValue() + "]");
	}
}
