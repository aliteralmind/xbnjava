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
   import  com.github.xbn.lang.BadDuplicateException;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.regexutil.IgnoreCase;
   import  com.google.common.base.Joiner;
   import  java.util.Arrays;
   import  java.util.HashSet;
   import  java.util.Set;
   import  static com.github.xbn.lang.CrashIfBase.*;
/**
   <p>Get the title case of an enum's value, and crash if a specific enum is a forbidden or not a required value.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class EnumUtil  {
   private EnumUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>If an Enum does not have a required value, crash. Otherwise, do nothing.</p>

    * @param  to_check  May not be {@code null}.
    * @param  required_value  May not be {@code null}.
    * @param  toCheck_name  Descriptive name of {@code to_check}. <i>Should</i> not be {@code null} or empty.
    * @param  xtra_errInfo  If non-{@code null}, appended to the error message.
    * @exception  IllegalArgumentException  If <code>to_check</code> is not equal to <code>required_value</code>.
    * @see  #crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue(e,e,s,o)
    */
   public static final <T extends Enum<T>> void crashIfNotRequiredValue(T to_check, T required_value, String toCheck_name, Object xtra_errInfo)  {
      if(to_check == null)  {
         throw  new NullPointerException("to_check");
      }
      if(required_value == null)  {
         throw  new NullPointerException("required_value");
      }
      if(to_check != required_value)  {
         throw  new IllegalArgumentException(getXMsg(toCheck_name + " (" + to_check + ") is not " + required_value.getClass().getName() + "." + required_value + ".", xtra_errInfo));
      }
   }
   /**
      <p>If an Enum does has a forbidden value, crash. Otherwise, do nothing.</p>

    * @param  to_check  May not be {@code null}.
    * @param  forbidden_value  May not be {@code null}.
    * @param  toCheck_name  Descriptive name of {@code to_check}. <i>Should</i> not be {@code null} or empty.
    * @param  xtra_errInfo  If non-{@code null}, appended to the error message.
    * @exception  IllegalArgumentException  If <code>to_check</code> is equal to <code>forbidden_value</code>.
    * @see  #crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue(e,e,s,o)
    */
   public static final <T extends Enum<T>> void crashIfForbiddenValue(T to_check, T forbidden_value, String toCheck_name, Object xtra_errInfo)  {
      if(to_check == null)  {
         throw  new NullPointerException("to_check");
      }
      if(forbidden_value == null)  {
         throw  new NullPointerException("forbidden_value");
      }
      if(to_check == forbidden_value)  {
         throw  new IllegalArgumentException(getXMsg(toCheck_name + " (" + to_check + ") may not be " + forbidden_value.getClass().getName() + "." + forbidden_value + ".", xtra_errInfo));
      }
   }
/*
   public static final <T extends Enum<T>> int getHasCount(T looking_for, T... array_toTest)  {
      int i = 0;
      for(T e : array_toTest)  {
         if(e == looking_for)  {
            i++;
         }
      }
      return  i;
   }
   public static final <T extends Enum<T>> int getDoesNotHaveCount(T looking_for, T... array_toTest)  {
      int i = 0;
      for(T e : array_toTest)  {
         if(e != looking_for)  {
            i++;
         }
      }
      return  i;
   }
 */
   public static final <T extends Enum<T>> T toValueWithNullDefault(String string_value, String str_varName, IgnoreCase ignore_case, DefaultValueFor default_for, T defaultValue_whichMustBeNonNull)  {
      try  {
         if((string_value == null  &&  default_for.atLeastNull())  ||
               (string_value.length() == 0  &&  default_for.atLeastEmpty()))  {
            return  defaultValue_whichMustBeNonNull;
         }

         string_value = ignore_case.toUpperCaseIfYes(
            string_value, str_varName);
         return  Enum.<T>valueOf(defaultValue_whichMustBeNonNull.
            getDeclaringClass(), string_value);

      }  catch(IllegalArgumentException iax)  {
         throw  new IllegalArgumentException("[ignore_case." + ignore_case + ", default_for." + default_for + "] " + str_varName + " (" + string_value + ") is not equal to any value-names in " + defaultValue_whichMustBeNonNull.getClass().getSimpleName() + ": " + Arrays.toString(defaultValue_whichMustBeNonNull.getClass().getEnumConstants()));
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(default_for, "default_for", null);
         throw  CrashIfObject.nullOrReturnCause(defaultValue_whichMustBeNonNull, "defaultValue_whichMustBeNonNull", null, rx);
      }
   }
   /**
      <p>Assigns an arbitrary string to each enum value then, given a value, returns the actual enum-value it represents.</p>

    * @param  enumInstance_anyNonNullValue  The enum to return. May not be {@code null}, but its value is ignored.
    * @param  value  The string representing an actual enum value, which must equal one of the <i>non-{@code null}</i> values in {@code one_perEnumValueInOrder}.
    * @param  value_varName  Descriptive name for {@code value}. <i>Should</i> not be {@code null} or empty.
    * @param  ignore_case  If {@link com.github.xbn.regexutil.IgnoreCase#YES YES}, the case of {@code value} is changed to lowercase. If {@link com.github.xbn.regexutil.IgnoreCase#NO NO}, its case is <i>expected</i> to be exactly as in {@code one_perEnumValueInOrder}.
    * @param  one_perEnumValueInOrder  The string values that each reperesent a single value in {@code enumInstance_anyNonNullValue}. Its length must equal
      <br> &nbsp; &nbsp; <code>enumInstance_anyNonNullValue.{@link java.lang.Object#getClass() getClass}().{@link java.lang.Class#getEnumConstants() getEnumConstants}().length</code>
      <br>At least one element must be non-{@code null}, and all non-null elements must be contiguous, non-empty, and unique. Use this to accept a sub-set of values.
    * @return  The enum value in {@code enumInstance_anyNonNullValue} that has the same element index as the one in {@code one_perEnumValueInOrder}, that {@code value} is equal to.
    */
   public static final <T extends Enum<T>> T getFromExplicitStringValues(T enumInstance_anyNonNullValue, String value, String value_varName, IgnoreCase ignore_case, String... one_perEnumValueInOrder)  {
      T[] allEnumValues = null;
      try  {
         @SuppressWarnings("unchecked")
         T[] at = (T[])enumInstance_anyNonNullValue.getClass().getEnumConstants();
         allEnumValues = at;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(enumInstance_anyNonNullValue, "enumInstance_anyNonNullValue", null, rx);
      }

      if(one_perEnumValueInOrder.length != allEnumValues.length)  {
         throw  new IllegalArgumentException("one_perEnumValueInOrder.length (" + one_perEnumValueInOrder.length + ") is not equal to enumInstance_anyNonNullValue.getClass().getEnumConstants().length " + allEnumValues.length + ".");
      }

      Set<String> set = new HashSet<String>(one_perEnumValueInOrder.length);
      int idx = 0;
      for(; idx < one_perEnumValueInOrder.length; idx++)  {
         if(one_perEnumValueInOrder[idx] != null)  {
            addToSetCIDupOrEmpty(set, one_perEnumValueInOrder, idx);
            break;
         }
      }
      if(idx == -1)  {
         throw  new IllegalArgumentException("All elements in one_perEnumValueInOrder are null.");
      }

      //idx is at first non-null element.

      idx++;

      for(; idx < one_perEnumValueInOrder.length; idx++)  {
         if(one_perEnumValueInOrder[idx] == null)  {
            break;
         }
         addToSetCIDupOrEmpty(set, one_perEnumValueInOrder, idx);
      }

      //idx is at first null element AFTER the first non-null element.
      idx++;

      for(; idx < one_perEnumValueInOrder.length; idx++)  {
         if(one_perEnumValueInOrder[idx] != null)  {
            throw  new IllegalArgumentException("one_perEnumValueInOrder[" + idx + "] (\"" + one_perEnumValueInOrder[idx] + "\") follows a null element.");
         }
      }

      value = ignore_case.toLowerCaseIfYes(value, value_varName);
      for(int i = 0; i < one_perEnumValueInOrder.length; i++)  {
         if(one_perEnumValueInOrder[i] != null  &&
               value.equals(one_perEnumValueInOrder[i]))  {
            return  allEnumValues[i];
         }
      }
      throw  new IllegalArgumentException("value (\"" + value + "\") does not equal any of the possible values: " +
         Joiner.on(", ").skipNulls().join(one_perEnumValueInOrder));
   }
      private static final void addToSetCIDupOrEmpty(Set<String> set, String[] one_perEnumValueInOrder, int idx)  {
         String s = one_perEnumValueInOrder[idx];
         if(s.length() == 0)  {
            throw  new IllegalArgumentException("one_perEnumValueInOrder[" + idx + "] contains no characters.");
         }
         if(set.contains(s))  {
            throw  new BadDuplicateException("one_perEnumValueInOrder[" + idx + "]=\"" + s + "\". Values found so far: " + Arrays.toString(set.toArray()) + ", All values: " + Arrays.toString(one_perEnumValueInOrder));
         }
         set.add(s);
      }
}
