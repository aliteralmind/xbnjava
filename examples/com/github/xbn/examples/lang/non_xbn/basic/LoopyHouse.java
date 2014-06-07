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
package  com.github.xbn.examples.lang.non_xbn.basic;
/**
   <P>Smart-ass answer to a puzzle inappropriately posted on stackoverflow. The question was closed literally seconds before I pressed the submit button.
   <BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/21423532/challenge-pattern-using-loops">http://stackoverflow.com/questions/21423532/challenge-pattern-using-loops</A></CODE></P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.basic.LoopyHouse}</P>

<PRE>RULES
    1. You can use a maximum of 3 LOOPS
    2. Use only FOR loops AND not the smart way
    3. Use only java to achieve this pattern
and of course, the fastest wins</PRE>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LoopyHouse  {
   public static final void main(String[] ignored)  {
      String[] asBuildingMaterials1of3 = new String[]  {
         "	/\\",
         "  /  \\",
         " /	 \\"};
      String[] asBuildingMaterials2of3 = new String[]  {
         "/		\\",
         "|		|",
         "|		|"};
      String[] asBuildingMaterials3of3 = new String[]  {
         "|		|",
         "|		|",
         "|______|"};

      //This is the first of three loops:
      for(String s : asBuildingMaterials1of3)  {
         System.out.println(s);
      }

      //This is the second of three loops:
      for(String s : asBuildingMaterials2of3)  {
         System.out.println(s);
      }

      //This is the third of three loops:
      for(String s : asBuildingMaterials3of3)  {
         System.out.println(s);
      }
   }
}
