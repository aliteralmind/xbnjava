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
package  com.github.xbn.util;
   import  java.util.Objects;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.IllegalArgumentStateException;
/**
   <p>Get a boolean primitive from a string, with specific strings representing true and false, and optional {@code null} and empty defaults.</p>

   @author  Copyright (C) 2013 Jeff Epstein, released under the LPGL 2.1. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class GetBooleanFromString  {
   private String stringName;
   private String trueVal;
   private String falseVal;
   private Boolean ifNull;
   private Boolean ifEmpty;
   public GetBooleanFromString()  {
      this(null);
   }
   /**
   	@since  0.1.1
    **/
   public GetBooleanFromString(String string_varName)  {
      stringName = ((string_varName != null) ? string_varName : "boolean_string");
      trueFalse("true", "false");
      nullEmptyDefaults_ifNullThenBad(null, null);
   }
   public GetBooleanFromString trueFalse(String true_value, String false_value)  {
      try  {
         if(true_value.equals(false_value))  {
            throw  new IllegalArgumentStateException("true_value and false_value both equal \"" + true_value + "\"");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(true_value, "true_value", null, rx);
      }
      Objects.requireNonNull(false_value, "false_value");
      trueVal = true_value;
      falseVal = false_value;
      return  this;
   }
   public GetBooleanFromString nullEmptyDefaults_ifNullThenBad(Boolean if_null, Boolean if_empty)  {
      ifNull = if_null;
      ifEmpty = if_empty;
      return  this;
   }
   public boolean get(String boolean_string)  {
      if(boolean_string == null  &&  getIfNull() != null)  {
         return  getIfNull().booleanValue();
      }
      try  {
         if(boolean_string.length() == 0  &&  getIfEmpty() != null)  {
            return  getIfEmpty().booleanValue();
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(boolean_string, getStringName(), null, rx);
      }

      try  {
         if(getTrue().equals(boolean_string))  {
            return  true;
         }  else if(getFalse().equals(boolean_string))  {
            return  false;
         }
      }  catch(NullPointerException npx)  {
         if(trueVal == null)  {
            throw  new IllegalStateException("Must set trueFalse(s,s)");
         }
      }

      throw  new IllegalArgumentException(getStringName() + " (\"" + boolean_string + "\") is not equal to getTrue() (\"" + getTrue() + "\") or getFalse() (\"" + getFalse() + "\") values.");
   }
   public String getStringName()  {
      return  stringName;
   }
   public String getTrue()  {
      return  trueVal;
   }
   public String getFalse()  {
      return  falseVal;
   }
   public Boolean getIfNull()  {
      return  ifNull;
   }
   public Boolean getIfEmpty()  {
      return  ifEmpty;
   }
}
