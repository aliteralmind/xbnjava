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
   <p>Off, or one through five, representing the amount of debugging that should be output.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public enum DebugLevel  {
   /**
      <p>YYY.</p>

      <p>This sets {@link #getNumber() getNumber}{@code ()} to zero.</p>

      @see  #ONE
      @see  #TWO
      @see  #isOff()
    **/
   OFF(0),
   /**
      <p>YYY.</p>

      <p>This sets {@link #getNumber() getNumber}{@code ()} to one.</p>

      @see  #OFF
      @see  #is1()
    **/
   ONE(1),
   /**
      <p>YYY.</p>

      <p>This sets {@link #getNumber() getNumber}{@code ()} to two.</p>

      @see  #OFF
      @see  #is2()
    **/
   TWO(2),
   /**
      <p>YYY.</p>

      <p>This sets {@link #getNumber() getNumber}{@code ()} to three.</p>

      @see  #OFF
      @see  #is2()
    **/
   THREE(3),
   /**
      <p>YYY.</p>

      <p>This sets {@link #getNumber() getNumber}{@code ()} to four.</p>

      @see  #OFF
      @see  #is2()
    **/
   FOUR(4),
   /**
      <p>YYY.</p>

      <p>This sets {@link #getNumber() getNumber}{@code ()} to five.</p>

      @see  #OFF
      @see  #is2()
    **/
   FIVE(5);
   private final int number;
   DebugLevel(int number)  {
      this.number = number;
   }
   /**
      <p>The number associated to this level.</p>

    * @see  #OFF
    */
   public final int getNumber()  {
      return  number;
   }
   /**
      <p>Is this {@code DebugLevel} equal to {@code OFF}?.</p>

      @return  <code>this == {@link #OFF}</code>

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
      <p>Is this {@code DebugLevel} equal to {@code ONE}?.</p>

      @return  <code>this == {@link #ONE}</code>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is1()  {
      return  this == ONE;
   }
   /**
      <p>Is this {@code DebugLevel} equal to {@code TWO}?.</p>

      @return  <code>this == {@link #TWO}</code>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is2()  {
      return  this == TWO;
   }
   /**
      <p>Is this {@code DebugLevel} equal to {@code THREE}?.</p>

      @return  <code>this == {@link #THREE}</code>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is3()  {
      return  this == THREE;
   }
   /**
      <p>Is this {@code DebugLevel} equal to {@code FOUR}?.</p>

      @return  <code>this == {@link #FOUR}</code>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is4()  {
      return  this == FOUR;
   }
   /**
      <p>Is this {@code DebugLevel} equal to {@code FIVE}?.</p>

      @return  <code>this == {@link #FIVE}</code>
      @see  #isOn()
      @see  #isOff()
    **/
   public final boolean is5()  {
      return  this == FIVE;
   }
   /**
   	<p>Is debugging on?.</p>

   	@return  <code>({@link #is1() is1}() &nbsp;|| &nbsp;{@link #is2() is2}())</code>
    **/
   public final boolean isOn()  {
      return  (!isOff());
   }
   /**
   	<p>Is debugging at least a specific level?.</p>

   	@param  min  May not be less than zero or greater than five.
   	@return  <code>(min <= {@link #getNumber() getNumber}())</code>
   	@see  #isOnAndAtLeast(int)
    **/
   public final boolean isAtLeast(int min)  {
      return  DebugLevel.isNumberAtLeast(getNumber(), min);
   }
   /**
   	<p>Is debugging on and at least a specific level?.</p>

   	@param  min  May not be less than one.
   	@return  <code>{@link #isAtLeast(int) isAtLeast}(min)</code>
    **/
   public final boolean isOnAndAtLeast(int min)  {
      return  DebugLevel.isNumberOnAndAtLeast(getNumber(), min);
   }
   /**
      <p>Get the highest level--from either <i>{@code this}</i> or one of the provided levels.</p>

    * @param  levels  Elements <i>should</i> be unique and not <i>this</i> object. {@code null} elements are ignored.
    * @return  The level with the highest {@linkplain #getNumber() number}.
    * @see  #isThisOrAnyOn(DebugLevel...)
    * @see  #isHighestAtLeast(int, DebugLevel...)
    * @see  #isHighestOnAndAtLeast(int, DebugLevel...)
    */
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
      <p>Get the highest level number--from either <i>{@code this}</i> or one of the provided levels.</p>

    * @return  <code>{@link #getHighestLevel(DebugLevel...) getHighestLevel}(levels).{@link #getNumber() getNumber}()</code>
    */
   public final int getHighestNumber(DebugLevel... levels)  {
      return  getHighestLevel(levels).getNumber();
   }
   /**
      <p>Is this or any of the parameter levels on?.</p>

    * @return  <code>{@link #isHighestAtLeast(int, DebugLevel...) isHighestAtLeast}(1, levels)</code>
    */
   public final boolean isThisOrAnyOn(DebugLevel... levels)  {
      return  isHighestAtLeast(1, levels);
   }
   /**
      <p>Is the highest number at least a minimum?.</p>

    * @param  min  May not be less than zero.
    * @return  <code>(min <= {@link #getHighestNumber(DebugLevel...) getHighestNumber}(levels))</code>
    * @see  #getHighestNumber(DebugLevel...)
    */
   public final boolean isHighestAtLeast(int min, DebugLevel... levels)  {
      return  DebugLevel.isNumberAtLeast(getHighestNumber(levels), min);
   }
   /**
      <p>YYY</p>

      <TABLE ALIGN="center" WIDTH="100%" BORDER="1" CELLSPACING="0" CELLPADDING="4" BGCOLOR="#EEEEEE"><TR ALIGN="center" VALIGN="middle">
         <TD><b><u>{@code compareTo}</u></b></TD>
         <TD><b><u>{@code compareTo} result</u></b></TD>
         <TD><b><u>Psuedo-logic equivalent</u></b></TD>
      </TR><TR>
         <TD><code>DebugLevel.{@link #ONE}.compareTo(DebugLevel.ONE) == 0</code></TD>
         <TD>{@code 0}</TD>
         <TD><code>DebugLevel.ONE == DebugLevel.ONE</code></TD>
      </TR><TR>
         <TD><code>DebugLevel.ONE.compareTo(DebugLevel.{@link #TWO}) &lt; 0</code></TD>
         <TD>{@code -1}</TD>
         <TD><code>DebugLevel.ONE &lt; DebugLevel.TWO</code></TD>
      </TR><TR>
         <TD><code>DebugLevel.{@link #THREE}.compareTo(DebugLevel.{@link #OFF}) &gt;= 0</code></TD>
         <TD>{@code 3}</TD>
         <TD><code>DebugLevel.ONE &gt;= DebugLevel.OFF</code></TD>
      </TR></TABLE>
    * @return  <code>({@link #getNumber() getNumber}() - to_compareTo.getNumber())</code>
   public int compareTo(DebugLevel to_compareTo)  {
      try  {
         return  (getNumber() - to_compareTo.getNumber());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_compareTo, "to_compareTo", null, rx);
      }
   }
    */
   /**
      <p>Is the highest number on and at least a minimum?.</p>

    * @param  min  May not be less than one.
    * @return  <code>(min <= {@link #getHighestNumber(DebugLevel...) getHighestNumber}(levels))</code>
    * @see  #getHighestNumber(DebugLevel...)
    */
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
      <p>Get the {@code DebugLevel} for a string equal to {@code "off"}, or a number between one and five.</p>

    * @param  value  May not be {@code null}, and must be a string equal to {@code "off"}, or a number one through five.
    * @param  value_varName  Descriptive name of {@code value}. <i>Should</i> not be {@code null} or empty.
    * @return  If {@code value} is<ul>
         <li>{@code "off"}: {@link #OFF}</li>
         <li>{@code "1"}: {@link #ONE}</li>
         <li>{@code "2"}: {@link #TWO}</li>
         <li>{@code "3"}: {@link #THREE}</li>
         <li>{@code "4"}: {@link #FOUR}</li>
         <li>{@code "5"}: {@link #FIVE}</li>
      </ul>
    * @exception  IllegalArgumentException  If {@code value} is invalid.
    */
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
