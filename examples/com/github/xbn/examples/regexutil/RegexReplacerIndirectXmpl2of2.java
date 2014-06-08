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
package  com.github.xbn.examples.regexutil;
   import  com.github.xbn.regexutil.IndirectRegexReplacer;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Demonstrates an indirect replacement using {@code com.github.xbn.regexutil.RegexReplacer}.</P>

   <P>{@code java com.github.xbn.examples.regexutil.RegexReplacerIndirectXmpl2of2}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RegexReplacerIndirectXmpl2of2  {
   public static void main(String[] ignored)  {

      System.out.println("Change all ${...}-s to their \"values\":");
      String sFindWhat = "\\$\\{([^\\}]+)\\}";
      String sToSearch = "xyz=${xyz}. abc=${abc}...";

      IndirectRegexReplacer rri = new IndirectRegexReplacer(new RegexReplacer_Cfg().findWhat(sFindWhat))  {
         public String getIndirectReplacement()  {
            String sBetweenCurlys = getGroup(1);
            if(sBetweenCurlys.equals("abc"))  {
               return  "VALUE_FOR_ABC";
            }  else if(sBetweenCurlys.equals("xyz"))  {
               return  "VALUE_FOR_XYZ";
            }  else  {
               throw  new IllegalStateException("Unknown token variable name: \"" + sBetweenCurlys + "\"");
            }
         }
      };
      System.out.println(rri.getReplaced(sToSearch));
   }
}
