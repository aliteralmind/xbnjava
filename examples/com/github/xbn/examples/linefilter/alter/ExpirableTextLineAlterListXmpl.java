/*license*\
   Codelet

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.linefilter.alter;
   import  com.github.xbn.analyze.alter.AlterationRequired;
   import  com.github.xbn.linefilter.AdaptRegexReplacerTo;
   import  com.github.xbn.linefilter.alter.ExpirableTextLineAlterList;
   import  com.github.xbn.linefilter.alter.TextLineAlterer;
   import  com.github.xbn.linefilter.alter.TextLineAlterAdapter;
   import  com.github.xbn.analyze.alter.ExpirableElements;
   import  com.github.xbn.analyze.alter.MultiAlterType;
   import  com.github.xbn.analyze.validate.NewValidResultFilterFor;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.StringReplacer;
   import  java.util.regex.Pattern;
/**
   <p>Demonstrates {@code com.github.xbn.analyze.alter.}{@link com.github.xbn.linefilter.alter.ExpirableTextLineAlterList ExpirableTextLineAlterList}: Alter some duplicate names, and once the alteration-limit for each name is met, expire its alterer.</p>

   <p>{@code java com.github.xbn.examples.linefilter.alter.ExpirableTextLineAlterListXmpl}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ExpirableTextLineAlterListXmpl  {
   public static final void main(String[] ignored)  {
      //Pre-setup
         String JA = "Johnny Appleseed";
         String KF = "Kermit T. Frog";
         String GG = "The Green Giant";
         int lineNum = 1;
         String[] input = new String[]  {
            (lineNum++) + " " + JA,
            (lineNum++) + " " + KF,
            (lineNum++) + " " + KF,
            (lineNum++) + " " + GG,
            (lineNum++) + " " + JA,
            (lineNum++) + " " + KF,
            (lineNum++) + " " + KF,
            (lineNum++) + " " + GG,
            (lineNum++) + " " + JA,
            (lineNum++) + " " + JA,
            (lineNum++) + " " + KF,
            (lineNum++) + " " + KF,
            (lineNum++) + " " + GG};

         System.out.println("Original:");
         for(String s : input)  {
            System.out.println(s);
         }

         System.out.println();

      //Configuration

         System.out.println("Replacing 1st and 2nd \"Apple\" with \"Pear\"");

            ValidResultFilter vrf12 = NewValidResultFilterFor.
               inUnchangedOutFalse(1, 2, null, null,
               null);    //<--Debugging: System.out. No debugging: null;
            TextLineAlterAdapter<StringReplacer> atlrAppleToPear12 = AdaptRegexReplacerTo.
               lineReplacer(AlterationRequired.YES,
                  Pattern.compile("Apple", Pattern.LITERAL),
                  "Pear", ReplacedInEachInput.FIRST, vrf12,
               null);    //<--Debugging


         System.out.println("Replacing 2nd-through-4th \"T.\" with \"The\"");

            ValidResultFilter vrf234 = NewValidResultFilterFor.
               inUnchangedOutFalse(2, 4, null, null,
               null);    //<--Debugging
            TextLineAlterAdapter<StringReplacer> atlrTDotToThe234 = AdaptRegexReplacerTo.
               lineReplacer(AlterationRequired.YES,
                  Pattern.compile("T.", Pattern.LITERAL),
                  "The", ReplacedInEachInput.FIRST, vrf234,
               null);    //<--Debugging


         System.out.println("Replacing 2nd \"Green\" with \"GREEN\"");

            ValidResultFilter vrf2Only = NewValidResultFilterFor.
               inUnchangedOutFalse(2, 2, null, null,
               null);    //<--Debugging
            TextLineAlterAdapter<StringReplacer> atlrCapGreen2Only = AdaptRegexReplacerTo.
               lineReplacer(AlterationRequired.YES,
                  Pattern.compile("Green", Pattern.LITERAL),
                  "GREEN", ReplacedInEachInput.FIRST, vrf2Only,
               null);    //<--Debugging

         System.out.println();

         ExpirableTextLineAlterList avxl = new ExpirableTextLineAlterList(
            new TextLineAlterer[] {atlrAppleToPear12, atlrTDotToThe234, atlrCapGreen2Only},
            ExpirableElements.REQUIRED, MultiAlterType.SHORT_CIRCUIT,
               null);    //<--Debugging

         //avxl.setDebug(System.out, true);

      //Go

         for(int i = 0; i < input.length; i++)  {
            String s = input[i];
            System.out.println(avxl.getAltered(s) +
               "  (Alters=" + avxl.size() +
               (avxl.isExpired() ? ", expired" : "") + ")");
         }
   }
}
