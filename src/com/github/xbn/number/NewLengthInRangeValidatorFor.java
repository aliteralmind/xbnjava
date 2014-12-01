/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.number;
   import  com.github.xbn.lang.Invert;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.number.z.LengthInRangeValidator_Cfg;
/**
   <p>Convenience functions for creating {@code LengthInRangeValidator}s.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewLengthInRangeValidatorFor  {
   private NewLengthInRangeValidatorFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final LengthInRangeValidator unrestricted(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.UNRESTRICTED,
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator exactly(Invert invertRange_dontIfNull, int both_minAndLength, String minLen_varName, Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.exactly(
            invertRange_dontIfNull, both_minAndLength, minLen_varName),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator notZero(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.GREATER_THAN_ZERO,
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator onlyZeroValid(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.ZERO_ONLY,
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator impossible(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.IMPOSSIBLE,
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
/*
   public static final LengthInRangeValidator nullBad(LengthInRange range, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      try  {
         return  new LengthInRangeValidator_Cfg().nullOk(false).range(range).filter(filter_offIfNull).debugTo(dbgDest_ifNonNull).build();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
   }
 */
   public static final LengthInRangeValidator min(Null nnull, Invert invertRange_dontIfNull, int min, String min_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.min(
            invertRange_dontIfNull, min, min_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator length(Null nnull, Invert invertRange_dontIfNull, int length, String length_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.length(
            invertRange_dontIfNull, length, length_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator exactly(Null nnull, Invert invertRange_dontIfNull, int both_minAndLen, String minLen_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.exactly(
            invertRange_dontIfNull, both_minAndLen, minLen_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator minAndLength(Null nnull, Invert invertRange_dontIfNull, int min, int length, String min_name, String length_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.minAndLength(
            invertRange_dontIfNull, min, length, min_name, length_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator max(Null nnull, Invert invertRange_dontIfNull, int length, String length_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  length(nnull, invertRange_dontIfNull, length, length_name, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator minMax(Null nnull, Invert invertRange_dontIfNull, int min, int length, String min_name, String length_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  minAndLength(nnull, invertRange_dontIfNull, min, length, min_name, length_name, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator stringLength(Null nnull, Invert invertRange_dontIfNull, Object string_forLen, String string_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.stringLength(
            invertRange_dontIfNull, string_forLen, string_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator stringLengthExactly(Null nnull, Invert invertRange_dontIfNull, Object str_forMinAndLen, String string_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.stringLengthExactly(
            invertRange_dontIfNull, str_forMinAndLen, string_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator minAndStringLength(Null nnull, Invert invertRange_dontIfNull, int min, Object str_forMinAndLen, String min_name, String string_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.minAndStringLength(
            invertRange_dontIfNull, min, str_forMinAndLen, min_name, string_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator primitiveArrayLength(Null nnull, Invert invertRange_dontIfNull, Object primitiveArray_forLen, String array_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.primitiveArrayLength(
            invertRange_dontIfNull, primitiveArray_forLen, array_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator primitiveArrayLengthExactly(Null nnull, Invert invertRange_dontIfNull, Object primitiveArray_forLen, String array_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.primitiveArrayLengthExactly(
            invertRange_dontIfNull, primitiveArray_forLen, array_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final LengthInRangeValidator minAndPArrayLength(Null nnull, Invert invertRange_dontIfNull, int min, Object primitiveArray_forLen, String min_name, String array_name, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(NewLengthInRangeFor.minAndPArrayLength(
            invertRange_dontIfNull, min, primitiveArray_forLen, min_name, array_name),
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
      private static final LengthInRangeValidator range(LengthInRange range, Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
         try  {
            return  new LengthInRangeValidator_Cfg().nullOk(nnull.isOk()).
            filter(filter_offIfNull).debugTo(dbgDest_ifNonNull).
            range(range).build();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(nnull, "nnull", null, rx);
         }
      }
}
