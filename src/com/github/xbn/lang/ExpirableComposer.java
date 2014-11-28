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
   <P>For classes that need to implement <CODE>Expirable</CODE>, that cannot extend abstract or concrete implementations.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class ExpirableComposer  {
	private boolean bXprbl;
	private boolean bXprd;
   public ExpirableComposer()  {
		this(false);
	}
   public ExpirableComposer(boolean is_expirable)  {
		bXprbl = is_expirable;
		bXprd = false;
	}
	public ExpirableComposer(boolean ignored, ExpirableComposer to_copy)  {
		try  {
			bXprbl = to_copy.doesExpire();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
		}
		bXprd = to_copy.isExpired();
	}
	public ExpirableComposer(Expirable exp_bl)  {
		try  {
			bXprbl = exp_bl.doesExpire();
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(exp_bl, "exp_bl", null, rx);
		}
		bXprd = exp_bl.isExpired();
	}
	public boolean doesExpire()  {
		return  bXprbl;
	}
	public void declareExpirable_4prot()  {
		bXprbl = true;
	}
	public void declareExpired_4prot()  {
		if(!doesExpire())  {
			throw  new IllegalStateException("doesExpire() is false.");
		}
		bXprd = true;
	}
	public boolean isExpired()  {
		return  bXprd;
	}
	public String toString()  {
		return  appendToString(new StringBuilder()).toString();
	}
	public StringBuilder appendToString(StringBuilder to_appendTo)  {
		try  {
			if(!doesExpire())  {
				return  to_appendTo.append("does-not-expire");
			}

			return  to_appendTo.append("expirable ").append(isExpired() ? "and expired" : "but not-expired");
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
		}
	}
}