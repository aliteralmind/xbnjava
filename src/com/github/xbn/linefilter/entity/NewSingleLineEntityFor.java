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
package  com.github.xbn.linefilter.entity;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.entity.z.SingleLineEntity_Cfg;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.linefilter.alter.NewTextLineAltererFor;
   import  java.util.regex.Pattern;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.NewPatternFor;
/**
   <P>Convenience functions for creating {@code SingleLineEntity}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewSingleLineEntityFor  {
   public static final SingleLineEntity match(String name_ifNonNull, KeepMatched keep, Pattern pattern_toFind, Appendable dbgAlter_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  new SingleLineEntity_Cfg(name_ifNonNull).
            alterer(NewTextLineAltererFor.textValidateOnly(pattern_toFind,
               null, dbgAlter_ifNonNull)).
            keepMatchedLines(keep.isYes()).
            filter(filter_ifNonNull).debugLineNumbers(dbgLineNums_ifNonNull).
            build();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(keep, "keep", null, rx);
      }
   }

   public static final SingleLineEntity literalReplacement(String name_ifNonNull, KeepMatched keep, String find_what, String rplc_with, ReplacedInEachInput rplcs_what, Appendable dbgAlter_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  replacement(name_ifNonNull, keep,
         NewPatternFor.literal(find_what, "find_what"),
         rplc_with, rplcs_what, dbgAlter_ifNonNull,
         null, dbgLineNums_ifNonNull);
   }
   public static final SingleLineEntity replacement(String name_ifNonNull, KeepMatched keep, Pattern ptrn_findWhat, String rplc_with, ReplacedInEachInput rplcs_what, Appendable dbgAlter_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  new SingleLineEntity_Cfg(name_ifNonNull).
            alterer(NewTextLineAltererFor.replacement(
               ptrn_findWhat, rplc_with, rplcs_what,
               dbgAlter_ifNonNull, null)).
            keepMatchedLines(keep.isYes()).
            filter(filter_ifNonNull).debugLineNumbers(dbgLineNums_ifNonNull).
            build();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(keep, "keep", null, rx);
      }
   }
   private NewSingleLineEntityFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
