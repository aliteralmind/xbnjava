/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

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
package  com.github.xbn.regexutil.z;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  java.util.regex.Pattern;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.neederneedable.DummyForNoNeeder;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring a {@link com.github.xbn.regexutil.RegexReplacer RegexReplacer}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexReplacer_Cfg extends RegexReplacer_CfgForNeeder<RegexReplacer,DummyForNoNeeder>   {
   /**
      <P>Create a new {@code RegexReplacer_Cfg} with defaults.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="RegexReplacer_CfgForNeeder.html#RegexReplacer_CfgForNeeder(R)">super</A>(null)</CODE></P>
    **/
   public RegexReplacer_Cfg()  {
      super(null);
   }
   /**
      <P>Create a new {@code RegexReplacer} for a direct replacement.</P>

      @return  <CODE>new {@link #RegexReplacer_Cfg() RegexReplacer_Cfg}().{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#direct(Pattern, Object) direct}(pattern_toFind, rplcWith_direct).
      <BR> &nbsp; &nbsp; {@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#replaceWhatNotMatchNums(ReplacedInEachInput) replaceWhatNotMatchNums}(rplcWhat_notMatchNums).
      <BR> &nbsp; &nbsp; {@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#debugTo(Appendable) debugTo}(dbgDest_ifNonNull).{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#build() build}()</CODE>
      @see  <A HREF="{@docRoot}/com/github/xbn/text/regex/RegexReplacer.html#direct">Definition: direct</A>
    **/
   public static final RegexReplacer buildDirect(Pattern pattern_toFind, String rplcWith_direct, ReplacedInEachInput rplcWhat_notMatchNums, Appendable dbgDest_ifNonNull)  {
      return  new RegexReplacer_Cfg().direct(pattern_toFind, rplcWith_direct).
         replaceWhatNotMatchNums(rplcWhat_notMatchNums).
         debugTo(dbgDest_ifNonNull).build();
   }
}
