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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.util.IncludeJavaDoc;
   import  com.github.xbn.util.JavaRegexes;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.NewTextLineValidatorFor;
   import  java.util.regex.Pattern;
   import  com.github.xbn.linefilter.entity.z.StealthBlockEntity_Cfg;
/**
   <p>Convenience functions for creating {@code StealthBlockEntity}s.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NewStealthBlockEntityFor  {
   public static final StealthBlockEntity javaComment(String name_ifNonNull, KeepMatched keep, EntityRequired required, IncludeJavaDoc java_doc, Appendable dbgStart_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  lineRange(
            ((name_ifNonNull != null) ? name_ifNonNull : "javaMlcStealth"),
            keep, required,
            Pattern.compile(
                  JavaRegexes.getMultiLineCommentOpenMarkerRegex(java_doc)),
               dbgStart_ifNonNull,
            Pattern.compile("*"+"/", Pattern.LITERAL), dbgEnd_ifNonNull, filter_ifNonNull, dbgLineNums_ifNonNull);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(required, "required", null, rx);
      }
   }
   public static final StealthBlockEntity javaDocComment(String name_ifNonNull, KeepMatched keep, EntityRequired required, Appendable dbgStart_ifNonNull, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRange(
         ((name_ifNonNull != null) ? name_ifNonNull : "javaDocBlockStealth"),
         keep, required,
         Pattern.compile("/"+"**", Pattern.LITERAL), dbgStart_ifNonNull,
         Pattern.compile("*"+"/", Pattern.LITERAL), dbgEnd_ifNonNull,
         filter_ifNonNull, dbgLineNums_ifNonNull);
   }
   public static final StealthBlockEntity lineRange(String name_ifNonNull, KeepMatched keep, EntityRequired required, Pattern start_ptrn, Appendable dbgStart_ifNonNull, Pattern end_ptrn, Appendable dbgEnd_ifNonNull, RawOnOffEntityFilter<String> filter_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      try  {
         return  new StealthBlockEntity_Cfg(
            ((name_ifNonNull != null) ? name_ifNonNull : "lineRange")).
            startValidator(NewTextLineValidatorFor.text(
               start_ptrn, null, dbgStart_ifNonNull)).
            endValidator(NewTextLineValidatorFor.text(
               end_ptrn, null, dbgEnd_ifNonNull)).
            debugLineNumbers(dbgLineNums_ifNonNull).
            filter(filter_ifNonNull).
            keepLines(keep.isYes()).
            required(required.isYes()).
            build();
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(keep, "keep", null);
         throw  CrashIfObject.nullOrReturnCause(required, "required", null, rx);
      }
   }
   private NewStealthBlockEntityFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
