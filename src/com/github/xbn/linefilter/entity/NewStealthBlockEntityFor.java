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
   import  com.github.xbn.linefilter.NewTextLineValidatorFor;
   import  java.util.regex.Pattern;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.linefilter.entity.z.StealthBlockEntity_Cfg;
/**
   <P>Convenience functions for creating {@code StealthBlockEntity}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewStealthBlockEntityFor  {
   public static final StealthBlockEntity javaComment(String name_ifNonNull, ValidResultFilter filter_ifNonNull, Appendable dbgStart_ifNonNull, Appendable dbgEnd_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRange(name_ifNonNull,
         Pattern.compile("(?:/"+"\\*(?!\\*))"),
         filter_ifNonNull, dbgStart_ifNonNull,
         Pattern.compile("*"+"/", Pattern.LITERAL),
         ((filter_ifNonNull == null) ? null
            :  filter_ifNonNull.getObjectCopy()),
         dbgEnd_ifNonNull, dbgLineNums_ifNonNull);
   }
   public static final StealthBlockEntity javaDocComment(String name_ifNonNull, ValidResultFilter filter_ifNonNull, Appendable dbgStart_ifNonNull, Appendable dbgEnd_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  lineRange(name_ifNonNull,
         Pattern.compile("/"+"**", Pattern.LITERAL),
         filter_ifNonNull, dbgStart_ifNonNull,
         Pattern.compile("*"+"/", Pattern.LITERAL),
         ((filter_ifNonNull == null) ? null
            :  filter_ifNonNull.getObjectCopy()),
         dbgEnd_ifNonNull, dbgLineNums_ifNonNull);
   }
   public static final StealthBlockEntity lineRange(String name_ifNonNull, Pattern start_ptrn, ValidResultFilter startFilter_ifNonNull, Appendable dbgStart_ifNonNull, Pattern end_ptrn, ValidResultFilter endFilter_ifNonNull, Appendable dbgEnd_ifNonNull, Appendable dbgLineNums_ifNonNull)  {
      return  new StealthBlockEntity_Cfg(name_ifNonNull).
         startValidator(
            NewTextLineValidatorFor.text(
               start_ptrn, startFilter_ifNonNull, dbgStart_ifNonNull)).
         endValidator(
            NewTextLineValidatorFor.text(
               end_ptrn, endFilter_ifNonNull, dbgEnd_ifNonNull)).
         debugLineNumbers(dbgLineNums_ifNonNull).
         build();
   }
   private NewStealthBlockEntityFor()  {
      throw  new IllegalStateException("Do not instantiate.");
   }
}
