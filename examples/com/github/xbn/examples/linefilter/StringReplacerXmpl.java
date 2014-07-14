/*license*\
   Codelet

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.linefilter;
   import  com.github.xbn.analyze.alter.AlterationRequired;
   import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.StringReplacer;
   import  java.util.regex.Pattern;
/**
   <P>Uses a {@code com.github.xbn.regexutil.}{@link com.github.xbn.regexutil.StringReplacer StringReplacer} and {@code com.github.xbn.analyze.validate.}{@link com.github.xbn.analyze.validate.FilterValidCounts FilterValidCounts} to replace the second-through-fourth occurances of a string.</P>

   <P>{@code java com.github.xbn.examples.linefilter.StringReplacerXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class StringReplacerXmpl  {
   public static final void main(String[] ignored)  {
      System.out.println("Replacing 2nd-through-4th \"T.\" with \"The\"");

      ValidResultFilter vrf = NewValidResultFilterFor.inUnchangedOutFalse(2, 4, null, null,
         null);     //<--Debug filter: System.out. No debug: null

      StringReplacer svrTDotToThe234 = AdaptRegexReplacerTo.stringReplacer(
         AlterationRequired.YES, Pattern.compile("T.", Pattern.LITERAL),
         "The", ReplacedInEachInput.FIRST, vrf,
            null);  //<--Debug replacer

      for(int i = 0; i < 10; i++)  {
         String sRplcd = svrTDotToThe234.getAltered("Kermit T. Frog");
         System.out.println(sRplcd);
      }
   }
}
