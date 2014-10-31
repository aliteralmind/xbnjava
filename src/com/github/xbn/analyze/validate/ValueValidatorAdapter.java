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
package  com.github.xbn.analyze.validate;
	import  com.github.xbn.lang.SimpleAdapter;
	import  com.github.xbn.lang.RuleType;
	import  com.github.xbn.analyze.validate.z.ValueValidator_Fieldable;
	import  com.github.xbn.lang.Adapter;
/**
   <P>Makes anything behave like a <CODE>ValueValidator</CODE>.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public abstract class ValueValidatorAdapter<O,D> extends NullnessValidator<O> implements Adapter<D>, ValueValidator<O>  {
	private final SimpleAdapter<D> sa;
	protected ValueValidatorAdapter(D to_adapt, ValueValidator_Fieldable fieldable)  {
		super(fieldable);
		sa = new SimpleAdapter<D>(to_adapt, "to_adapt");
	}
	protected ValueValidatorAdapter(D to_adapt, RuleType type, ValueValidator_Fieldable fieldable)  {
		super(type, fieldable);
		sa = new SimpleAdapter<D>(to_adapt, "to_adapt");
	}

	public ValueValidatorAdapter(ValueValidatorAdapter<O,D> to_copy)  {
		super(to_copy);
		sa = new SimpleAdapter<D>(to_copy.sa);
	}
	public D getAdapted()  {
		return  sa.getAdapted();
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  sa.appendToString(to_appendTo);
	}
}