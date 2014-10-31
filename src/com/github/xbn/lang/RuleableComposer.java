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
	import  java.util.Objects;
/**
	<P>For classes that need to implement {@code Rulable}, that cannot extend abstract or concrete implementations.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RuleableComposer  {//implements Ruleable  {
	private final RuleType type;
//constructors...START
	public RuleableComposer()  {
		this(RuleType.UNRESTRICTED);
	}
	public RuleableComposer(RuleType type)  {
		this(type, "type");
	}
	public RuleableComposer(RuleType type, String type_name)  {
		Objects.requireNonNull(type, type_name);
		this.type = type;
	}
	/*
		<P>Create a new {@code RuleableComposer} as a duplicate of another.</P>

		<P>This<OL>
			<LI>YYY</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	public RuleableComposer(boolean ignored, RuleableComposer to_copy)  {
		try  {
			this.type = to_copy.getRuleType();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}
	}
	 */
	/*
		<P>Create a new {@code RuleableComposer} from a {@code Ruleable}.</P>

		<P>This<OL>
			<LI>YYY</LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	public RuleableComposer(Ruleable to_copy)  {
		try  {
			this.type = to_copy.getRuleType();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}
	}
	 */
//constructors...END
	public RuleType getRuleType()  {
		return  type;
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		return  to_appendTo.append("RuleType.").append(getRuleType());
	}
	/*
		<P>Duplicate this {@code RuleableComposer}.</P>

		@return  <CODE>(new {@link #RuleableComposer(boolean, RuleableComposer) RuleableComposer}(false, this))</CODE>
	public RuleableComposer getObjectCopy()  {
		return  (new RuleableComposer(false, this));
	}
	 */
}
