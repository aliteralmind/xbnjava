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
   import  com.github.xbn.number.z.IndexInRangeValidator_Cfg;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Null;
/**
   <p>Convenience functions for creating {@code IndexInRangeValidator}s.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewIndexInRangeValidatorFor  {
   private NewIndexInRangeValidatorFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final IndexInRangeValidator unrestricted(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(IndexInRange.UNRESTRICTED,
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
   public static final IndexInRangeValidator impossible(Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      return  range(IndexInRange.IMPOSSIBLE,
         nnull, filter_offIfNull, dbgDest_ifNonNull);
   }
/*
   public static final IndexInRangeValidator nullBad(Null nnull, IndexInRange range, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
      try  {
         return  new IndexInRangeValidator_Cfg().nullOk(nnull.isOk()).
         filter(filter_offIfNull).debugTo(dbgDest_ifNonNull).
         range(range).build();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
   }
 */
      private static final IndexInRangeValidator range(IndexInRange range, Null nnull, ValidResultFilter filter_offIfNull, Appendable dbgDest_ifNonNull)  {
         try  {
            return  new IndexInRangeValidator_Cfg().nullOk(nnull.isOk()).
            filter(filter_offIfNull).debugTo(dbgDest_ifNonNull).
            range(range).build();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(nnull, "nnull", null, rx);
         }
      }
}
