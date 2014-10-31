/*license*\
	XBN-Java

	Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

	This software is dual-licensed under the:
	- Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
	- Apache Software License (ASL) version 2.0.

	Either license may be applied at your discretion. More information may be found at
	- http://en.wikipedia.org/wiki/Multi-licensing.

	The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
	- LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
	- ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.io;
	import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Off, or one through five, representing the amount of debugging that should be output.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public enum DebugLevel  {
   /**
      <P>YYY.</P>

      <P>This sets {@link #getNumber() getNumber}{@code ()} to zero.</P>

      @see  #ONE
      @see  #TWO
      @see  #isOff()
    **/
   OFF(0),
   /**
      <P>YYY.</P>

      <P>This sets {@link #getNumber() getNumber}{@code ()} to one.</P>

      @see  #OFF
      @see  #is1()
    **/
   ONE(1),
   /**
      <P>YYY.</P>

      <P>This sets {@link #getNumber() getNumber}{@code ()} to two.</P>

      @see  #OFF
      @see  #is2()
    **/
   TWO(2),
   /**
      <P>YYY.</P>

      <P>This sets {@link #getNumber() getNumber}{@code ()} to three.</P>

      @see  #OFF
      @see  #is2()
    **/
   THREE(3),
   /**
      <P>YYY.</P>

      <P>This sets {@link #getNumber() getNumber}{@code ()} to four.</P>

      @see  #OFF
      @see  #is2()
    **/
   FOUR(4),
   /**
      <P>YYY.</P>

      <P>This sets {@link #getNumber() getNumber}{@code ()} to five.</P>

      @see  #OFF
      @see  #is2()
    **/
   FIVE(5);
   private final int number;
   DebugLevel(int number)  {
		this.number = number;
	}
	/**
		<P>The number associated to this level.</P>

		@see  #OFF
	 **/
	public final int getNumber()  {
		return  number;
	}
   /**
      <P>Is this {@code DebugLevel} equal to {@code OFF}?.</P>

      @return  <CODE>this == {@link #OFF}</CODE>

      @see  #is1()
      @see  #is2()
      @see  #is3()
      @see  #is4()
      @see  #is5()
      @see  #isAtLeast(int)
    **/
   public final boolean isOff()  {
      return  this == OFF;
   }
   /**
      <P>Is this {@code DebugLevel} equal to {@code ONE}?.</P>

      @return  <CODE>this == {@link #ONE}</CODE>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is1()  {
      return  this == ONE;
   }
   /**
      <P>Is this {@code DebugLevel} equal to {@code TWO}?.</P>

      @return  <CODE>this == {@link #TWO}</CODE>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is2()  {
      return  this == TWO;
   }
   /**
      <P>Is this {@code DebugLevel} equal to {@code THREE}?.</P>

      @return  <CODE>this == {@link #THREE}</CODE>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is3()  {
      return  this == THREE;
   }
   /**
      <P>Is this {@code DebugLevel} equal to {@code FOUR}?.</P>

      @return  <CODE>this == {@link #FOUR}</CODE>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is4()  {
      return  this == FOUR;
   }
   /**
      <P>Is this {@code DebugLevel} equal to {@code FIVE}?.</P>

      @return  <CODE>this == {@link #FIVE}</CODE>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is5()  {
      return  this == FIVE;
   }
   /**
   	<P>Is debugging on?.</P>

   	@return  <CODE>({@link #is1() is1}() &nbsp;|| &nbsp;{@link #is2() is2}())</CODE>
    **/
   public final boolean isOn()  {
		return  (!isOff());
	}
   /**
   	<P>Is debugging at least a specific level?.</P>

   	@param  min  May not be less than zero or greater than five.
   	@return  <CODE>(min <= {@link #getNumber() getNumber}())</CODE>
   	@see  #isOnAndAtLeast(int)
    **/
   public final boolean isAtLeast(int min)  {
		return  DebugLevel.isNumberAtLeast(getNumber(), min);
	}
   /**
   	<P>Is debugging on and at least a specific level?.</P>

   	@param  min  May not be less than one.
   	@return  <CODE>{@link #isAtLeast(int) isAtLeast}(min)</CODE>
    **/
   public final boolean isOnAndAtLeast(int min)  {
		return  DebugLevel.isNumberOnAndAtLeast(getNumber(), min);
	}
	/**
		<P>Get the highest level--from either <I>{@code this}</I> or one of the provided levels.</P>

		@param  levels  Elements <I>should</I> be unique and not <I>this</I> object. {@code null} elements are ignored.
		@return  The level with the highest {@linkplain #getNumber() number}.
		@see  #isThisOrAnyOn(DebugLevel...)
		@see  #isHighestAtLeast(int, DebugLevel...)
		@see  #isHighestOnAndAtLeast(int, DebugLevel...)
	 **/
	public final DebugLevel getHighestLevel(DebugLevel... levels)  {
		DebugLevel highest = this;
		for(DebugLevel level : levels)  {
			if(level == null)  {
				continue;
			}
			if(highest.compareTo(level) < 0)  {  //highest < level
				highest = level;
			}
			if(highest.is5())  {
				break;
			}
		}
		return  highest;
	}
	/**
		<P>Get the highest level number--from either <I>{@code this}</I> or one of the provided levels.</P>

		@return  <CODE>{@link #getHighestLevel(DebugLevel...) getHighestLevel}(levels).{@link #getNumber() getNumber}()</CODE>
	 **/
	public final int getHighestNumber(DebugLevel... levels)  {
		return  getHighestLevel(levels).getNumber();
	}
	/**
		<P>Is this or any of the parameter levels on?.</P>

		@return  <CODE>{@link #isHighestAtLeast(int, DebugLevel...) isHighestAtLeast}(1, levels)</CODE>
	 **/
	public final boolean isThisOrAnyOn(DebugLevel... levels)  {
		return  isHighestAtLeast(1, levels);
	}
	/**
		<P>Is the highest number at least a minimum?.</P>

		@param  min  May not be less than zero.
		@return  <CODE>(min <= {@link #getHighestNumber(DebugLevel...) getHighestNumber}(levels))</CODE>
		@see  #getHighestNumber(DebugLevel...)
	 **/
	public final boolean isHighestAtLeast(int min, DebugLevel... levels)  {
		return  DebugLevel.isNumberAtLeast(getHighestNumber(levels), min);
	}
	/**
		<P>YYY</P>

		<P><TABLE ALIGN="center" WIDTH="100%" BORDER="1" CELLSPACING="0" CELLPADDING="4" BGCOLOR="#EEEEEE"><TR ALIGN="center" VALIGN="middle">
			<TD><B><U>{@code compareTo}</U></B></TD>
			<TD><B><U>{@code compareTo} result</U></B></TD>
			<TD><B><U>Psuedo-logic equivalent</U></B></TD>
		</TR><TR>
			<TD><CODE>DebugLevel.{@link #ONE}.compareTo(DebugLevel.ONE) == 0</CODE></TD>
			<TD>{@code 0}</TD>
			<TD><CODE>DebugLevel.ONE == DebugLevel.ONE</CODE></TD>
		</TR><TR>
			<TD><CODE>DebugLevel.ONE.compareTo(DebugLevel.{@link #TWO}) &lt; 0</CODE></TD>
			<TD>{@code -1}</TD>
			<TD><CODE>DebugLevel.ONE &lt; DebugLevel.TWO</CODE></TD>
		</TR><TR>
			<TD><CODE>DebugLevel.{@link #THREE}.compareTo(DebugLevel.{@link #OFF}) &gt;= 0</CODE></TD>
			<TD>{@code 3}</TD>
			<TD><CODE>DebugLevel.ONE &gt;= DebugLevel.OFF</CODE></TD>
		</TR></TABLE></P>
		@return  <CODE>({@link #getNumber() getNumber}() - to_compareTo.getNumber())</CODE>
	public int compareTo(DebugLevel to_compareTo)  {
		try  {
			return  (getNumber() - to_compareTo.getNumber());
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(to_compareTo, "to_compareTo", null, rx);
		}
	}
	 **/
	/**
		<P>Is the highest number on and at least a minimum?.</P>

		@param  min  May not be less than one.
		@return  <CODE>(min <= {@link #getHighestNumber(DebugLevel...) getHighestNumber}(levels))</CODE>
		@see  #getHighestNumber(DebugLevel...)
	 **/
	public final boolean isHighestOnAndAtLeast(int min, DebugLevel... levels)  {
		return  DebugLevel.isNumberOnAndAtLeast(getHighestNumber(levels), min);
	}
		private static final boolean isNumberAtLeast(int actual, int min)  {
			if(min < 0  ||  min > 5)  {
				throw  new IllegalArgumentException("min=" + min);
			}
			return  (min <= actual);
		}
		private static final boolean isNumberOnAndAtLeast(int number, int min)  {
			if(min == 0)  {
				throw  new IllegalArgumentException("min=" + min);
			}
			return  isNumberAtLeast(number, min);
		}
	/**
		<P>Get the {@code DebugLevel} for a string equal to {@code "off"}, or a number between one and five.</P>

		@param  value  May not be {@code null}, and must be a string equal to {@code "off"}, or a number one through five.
		@param  value_varName  Descriptive name of {@code value}. <I>Should</I> not be {@code null} or empty.
		@return  If {@code value} is<UL>
			<LI>{@code "off"}: {@link #OFF}</LI>
			<LI>{@code "1"}: {@link #ONE}</LI>
			<LI>{@code "2"}: {@link #TWO}</LI>
			<LI>{@code "3"}: {@link #THREE}</LI>
			<LI>{@code "4"}: {@link #FOUR}</LI>
			<LI>{@code "5"}: {@link #FIVE}</LI>
		</UL>
		@exception  IllegalArgumentException  If {@code value} is invalid.
	 **/
	public static final DebugLevel getFromStringOff12345(String value, String value_varName)  {
		try  {
			switch(value)  {
				case "off":  return  OFF;
				case "1":    return  ONE;
				case "2":    return  TWO;
				case "3":    return  THREE;
				case "4":    return  FOUR;
				case "5":    return  FIVE;
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(value, value_varName, null, rx);
		}
		throw  new IllegalArgumentException(value_varName + "=\"" + value + "\"");
	}
	public static final DebugLevel getFromString012345OrNeg1ForNull(String value, String value_varName)  {
		try  {
			switch(value)  {
				case "-1":  return  null;
				case "0":   return  OFF;
				case "1":   return  ONE;
				case "2":   return  TWO;
				case "3":   return  THREE;
				case "4":   return  FOUR;
				case "5":   return  FIVE;
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(value, value_varName, null, rx);
		}
		throw  new IllegalArgumentException(
			((value_varName == null) ? "" : value_varName + "=") +
			"\"" + value + "\"");
	}
};
