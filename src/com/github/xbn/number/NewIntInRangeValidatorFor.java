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
   import  com.github.xbn.number.z.IntInRangeValidator_Cfg;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <P>Convenience functions for creating new {@code IntInRangeValidator}s.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewIntInRangeValidatorFor  {
   private NewIntInRangeValidatorFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final IntInRangeValidator unrestricted(ValidResultFilter filter, Appendable dbgDest_ifNonNull)  {
      return  new IntInRangeValidator_Cfg().nullOk(true).invert(false).range(NewIntInRangeFor.UNRESTRICTED).filter(filter).debugTo(dbgDest_ifNonNull).build();
   }
   public static final IntInRangeValidator exactly(int min_andMax, String minMax_varName, ValidResultFilter filter, Appendable dbgDest_ifNonNull)  {
      return  new IntInRangeValidator_Cfg().nullOk(true).invert(false).
         range(NewIntInRangeFor.minMax(min_andMax, minMax_varName)).
         filter(filter).debugTo(dbgDest_ifNonNull).build();
   }
   public static final IntInRangeValidator impossible(ValidResultFilter filter, Appendable dbgDest_ifNonNull)  {
      return  new IntInRangeValidator_Cfg().nullOk(true).invert(true).range(NewIntInRangeFor.UNRESTRICTED).build();
   }
   public static final IntInRangeValidator nullBad(IntInRange range, ValidResultFilter filter, Appendable dbgDest_ifNonNull)  {
      try  {
         return  new IntInRangeValidator_Cfg().nullOk(false).invert(false).range(range).filter(filter).debugTo(dbgDest_ifNonNull).build();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", null, rx);
      }
   }

}
