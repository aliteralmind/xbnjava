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
package  com.github.xbn.regexutil;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder;
   import  com.github.xbn.neederneedable.Needer;
   import  java.util.regex.Pattern;
/**
   <p>A {@code RegexReplacer} for indirect replacements only.</p>

   @see  <a href="RegexReplacer.html#indirect">Definition: indirect</a>
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class IndirectRegexReplacer extends RegexReplacer  {
   /**
      <p>Create a new instance for an <i>indirect replacement only</i>, with a regular-expression string.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link RegexReplacer}(new xbn.regexutil.z.RegexReplacer_Cfg#RegexReplacer_Cfg() RegexReplacer_Cfg}().{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(String) findWhat}(find_whatRegex))</code></p>

      @see  <a href="RegexReplacer.html#indirect">Definition: indirect</a>
    **/
   public IndirectRegexReplacer(String find_whatRegex)  {
      super(new RegexReplacer_Cfg().findWhat(find_whatRegex));
   }
   /**
      <p>Create a new instance for an <i>indirect replacement only</i>, with a regular-expression string.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link RegexReplacer}(new xbn.regexutil.z.RegexReplacer_Cfg#RegexReplacer_Cfg() RegexReplacer_Cfg}().{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(String, int) findWhat}(find_whatRegex, bit_flags))</code></p>

      @see  <a href="RegexReplacer.html#indirect">Definition: indirect</a>
    **/
   public IndirectRegexReplacer(String find_whatRegex, int bit_flags)  {
      super(new RegexReplacer_Cfg().findWhat(find_whatRegex, bit_flags));
   }
   /**
      <p>Create a new instance for an <i>indirect replacement only</i>, with a pattern.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link RegexReplacer}(new xbn.regexutil.z.RegexReplacer_Cfg#RegexReplacer_Cfg() RegexReplacer_Cfg}().{@link com.github.xbn.regexutil.z.RegexReplacer_CfgForNeeder#findWhat(Pattern) findWhat}(pattern_toFind))</code></p>

      @see  <a href="#indirect">Definition: indirect</a>
    **/
   public IndirectRegexReplacer(Pattern pattern_toFind)  {
      super(new RegexReplacer_Cfg().findWhat(pattern_toFind));
   }
   public IndirectRegexReplacer(RegexReplacer_CfgForNeeder<? extends RegexReplacer,? extends Needer> fieldable)  {
      super(fieldable);
      if(fieldable.getDirectReplacement() != null)  {
         throw  new IllegalStateException("fieldable.getDirectReplacement() is non-null. rr_c.getDirectReplacement()=\"" + fieldable.getDirectReplacement() + "\"");
      }
   }
}
