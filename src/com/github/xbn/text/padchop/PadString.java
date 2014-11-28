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
package  com.github.xbn.text.padchop;
	import  com.github.xbn.text.padchop.z.PadString_Fieldable;
	import  com.github.xbn.io.IOUtil;
	import  com.github.xbn.lang.CrashIfObject;
	import  java.io.IOException;
	import  com.github.xbn.text.StringUtil;
	import  static com.github.xbn.lang.XbnConstants.*;
/**
	<P>Pad a string on a either side with a specific pad-character.</P>

{@.codelet.and.out com.github.xbn.examples.text.padchop.PadStringXmpl%eliminateCommentBlocksAndPackageDecl()}

	<A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.text.padchop.z.PadString_Cfg PadString_Cfg}</H3>

	<P><UL>
		<LI><B>Used by:</B> {@code <A HREF="VzblPadChop.html#cfg">VzblPadChop</A>}</LI>
		<LI>{@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#goalLen(int) goalLen}{@code (i)}</LI>
		<LI><B>Side:</B> {@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#left() left}{@code ()}, {@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#right() right}{@code ()}</LI>
		<LI><B>Character to pad with:</B> {@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#withSpace() withSpace}{@code ()}, {@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder#with(char) with}{@code (c)}</LI>
	</UL>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class PadString extends PadChopBase  {
	private final char cPad;
//constructors...START
	public PadString(PadString_Fieldable fieldable)  {
		super(fieldable);
		cPad = fieldable.getPadChar();
	}
	/**
		<P>Create a new {@code PadString} as a duplicate of another.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.text.padchop.PadString#PadString(PadString, int) super}{@code (to_copy, -2)}</P>
	 **/
	public PadString(PadString to_copy)  {
		this(to_copy, -2);
	}
	/**
		<P>Create a new {@code PadString} as a duplicate of another.</P>

		<P>This<OL>
			<LI>Calls {@link com.github.xbn.text.padchop.PadChopBase#PadChopBase(PadChopBase, int) super}{@code (to_copy, new_goalLen)}</LI>
			<LI>Sets {@link #getPadChar() getPadChar}{@code ()} to <CODE>to_copy.{@link #getPadChar() getPadChar}()</CODE></LI>
		</OL></P>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
		@see  #PadString(PadString_Fieldable) this(ps_f)
		@see  #PadString(PadString) this(ps)
	 **/
	public PadString(PadString to_copy, int new_goalLen)  {
		super(to_copy, new_goalLen);
		cPad = to_copy.getPadChar();
	}
//constructors...END
//getters...START
	/**
		<P>GetYYY.</P>

		@return  {@code pad_char}, as provided to ..............
	 **/
	public char getPadChar()  {
		return  cPad;
	}
//getters...END
//other...START
	/**
		<P>Chop the string as configured.</P>

		@return  <CODE>{@link #getPadded(int, Object) getPadded}({@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}(), str_toPad)</CODE>
	 **/
	public String getPadded(Object str_toPad)  {
		return  getPadded(getGoalLen(), str_toPad);
	}
	/**
		<P>Chop the string as configured, with a specific goal-length.</P>

		@return  {@link #appendPadded(Appendable, int, Object) appendPadded}{@code (new StringBuilder()), goal_len, str_toPad).toString()}
	 **/
	public String getPadded(int goal_len, Object str_toPad)  {
		return  appendPadded((new StringBuilder()), goal_len, str_toPad).toString();
	}
	/**
		<P>YYY</P>

		@return  {@code appendPaddedX(to_appendTo, str_toPad)}
	 **/
	public Appendable appendPadded(Appendable to_appendTo, Object str_toPad)  {
		try  {
			return  appendPaddedX(to_appendTo, str_toPad);
		}  catch(IOException  iox)  {
			throw  new RuntimeException("appendChopped", iox);
		}
	}
	/**
		<P>YYY</P>

		@return  {@link #appendPaddedX(Appendable, int, Object)}{@code (to_appendTo, goal_len, str_toPad)}
	 **/
	public Appendable appendPadded(Appendable to_appendTo, int goal_len, Object str_toPad)  {
		try  {
			return  appendPaddedX(to_appendTo, goal_len, str_toPad);
		}  catch(IOException  iox)  {
			throw  new RuntimeException("appendPadded", iox);
		}
	}
	/**
		<P>Chop the string as configured.</P>

		@return  {@link #appendPaddedX(Appendable, int, Object) appendPaddedX}(to_appendTo, {@link com.github.xbn.text.padchop.PadChopBase#getGoalLen() getGoalLen}(), str_toPad)
	 **/
	public Appendable appendPaddedX(Appendable to_appendTo, Object str_toPad) throws IOException  {
		return  appendPaddedX(to_appendTo, getGoalLen(), str_toPad);
	}
/*
	public Appendable appendPaddedln(Appendable to_appendTo, String prefix, Object str_toPad, String postfix)  {
		return  appendPaddedlns(1, to_appendTo, prefix, str_toPad, postfix);
	}
 */
	public Appendable appendPaddedlns(int newLine_count, Appendable to_appendTo, String prefix, Object str_toPad, String postfix)  {
		try  {
			to_appendTo.append(prefix);
			appendPaddedX(to_appendTo, str_toPad).append(LINE_SEP);
			IOUtil.appendNewLinesX(newLine_count, to_appendTo);
			return  to_appendTo.append(postfix);
		}  catch(IOException  iox)  {
			throw  new RuntimeException("appendPaddedln(i,apbl,s,O,s,O)", iox);
		}
	}
/*
	public Appendable appendPaddedln(Appendable to_appendTo, String prefix, Object str_toPad, String postfix, int goal_len)  {
		return  appendPaddedlns(1, to_appendTo, goal_len, prefix, str_toPad, postfix);
	}
 */
	public Appendable appendPaddedlns(int newLine_count, Appendable to_appendTo, int goal_len, String prefix, Object str_toPad, String postfix)  {
		try  {
			to_appendTo.append(prefix);
			appendPaddedX(to_appendTo, goal_len, str_toPad).append(postfix);
			IOUtil.appendNewLinesX(newLine_count, to_appendTo);
			return  to_appendTo;
		}  catch(IOException  iox)  {
			throw  new RuntimeException("appendPaddedln(i,apbl,i,s,O,s)", iox);
		}
	}
	public Appendable appendPaddedX(Appendable to_appendTo, int goal_len, Object str_toPad) throws IOException  {
		return  PadString.appendPaddedX(this, to_appendTo, goal_len, str_toPad);
	}
	/**
		<P>Chop the string as configured, with a specific goal-length.</P>

		@param  padder  May not be {@code null}.
		@param  to_appendTo  May not be {@code null}.
		@param  str_toPad  The string to chop.
		@param  goal_len  The goal length to chop to. May not be less than one.

		@see  #appendPadded(Appendable, Object) appendPadded(apbl,o)
		@see  #getPadded(Object) getPadded(o)
		@see  #getPadded(int, Object) getPadded(o,i)
	 **/
	public static final Appendable appendPaddedX(PadString padder, Appendable to_appendTo, int goal_len, Object str_toPad) throws IOException  {
		goal_len = PadChopBase.getCIBGoalLenForOutput(goal_len, "Padd");

		if(str_toPad == null)  {
			str_toPad = "null";
		}

		String s = str_toPad.toString();

		if(goal_len <= s.length())  {
			to_appendTo.append(s);
			return  to_appendTo;
		}

		int iPadLen = new Integer(goal_len - s.length());
		String sPadStr = null;
		try  {
			sPadStr = StringUtil.getDuped(padder.getPadChar(), iPadLen);
		}  catch(RuntimeException rx)  {
			CrashIfObject.nullOrReturnCause(padder, "padder", null, rx);
		}

		if(padder.isSideRight())  {
			to_appendTo.append(s).append(sPadStr);
		}  else  {
			to_appendTo.append(sPadStr).append(s);
		}
		return  to_appendTo;
	}
	public String toString()  {
		return  super.toString() + ", getPadChar()='" + getPadChar() + '\'';
	}
	/**
		@return  <CODE>(new {@link #PadString(PadString) PadString}(this))</CODE>
	 **/
	public PadString getObjectCopy()  {
		return  (new PadString(this));
	}
	/**
		<P>Duplicate this {@code PadString}, with a new goal-length.</P>

		@return  <CODE>(new {@link #PadString(PadString) PadString}(this))</CODE>
	 **/
	public PadString getCopyNewGoalLen(int goal_len)  {
		return  (new PadString(this, goal_len));
	}
//other...END
}