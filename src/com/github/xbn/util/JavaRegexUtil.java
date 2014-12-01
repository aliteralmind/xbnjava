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
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  com.github.xbn.regexutil.RegexGroupExtractor;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.z.RegexGroupExtractor_Cfg;
/**
   <p>Regular expression-related utilities for Java code.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class JavaRegexUtil extends JavaUtil  {
   private JavaRegexUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   public static final RegexGroupExtractor newRXForCnstrSigLineToNameAllParams()  {
      return  (new RegexGroupExtractor_Cfg().requiredGroups(2).pattern(JavaRegexes.CNSTR_NAME_ALL_PARAMS).build());
   }
   public static final RegexGroupExtractor newRXForFuncSigLineToRetTypNameAllParams()  {
      return  (new RegexGroupExtractor_Cfg().requiredGroups(3).pattern(JavaRegexes.RTRN_TYPE_FNM_ALL_PARAMS).build());
   }
   public static final RegexReplacer newRRForAllParamTypeNamesToNames()  {
      return  (new RegexReplacer_Cfg().findWhat(JavaRegexes.PARAM_TYPE_NAME_DIV).directReplacement("$4$5").build());
   }
   public static final RegexReplacer newRRForAllParamTypeNamesTo4FQTypes()  {
      return  (new RegexReplacer_Cfg().findWhat(JavaRegexes.PARAM_TYPE_NAME_DIV).directReplacement("$2$5").build());
   }
}
