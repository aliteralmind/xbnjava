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
package  com.github.xbn.examples.regexutil.non_xbn.basic;
   import  java.util.regex.Matcher;
   import  java.util.regex.Pattern;
/**
   <P>Read in a {@code "MOVE"} command for a text-based game, where the only legal values after {@code MOVE} are {@code 'N'}, {@code 'E'}, {@code 'W'}, or {@code 'S'}.</P>

   <P>{@code java com.github.xbn.examples.regexutil.non_xbn.basic.ExtractDirectionFromTextutalMoveCmd}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ExtractDirectionFromTextutalMoveCmd  {
  //Create a matcher with a dummy-string, so it can be reused (reset).
  private static Matcher mMove = Pattern.compile("^MOVE *<([NEWS])>$").matcher("");

   public static final void main(String[] ignored)  {
     System.out.println("Null if badly formatted");

     System.out.println(getDirection("MOVE<S>"));
     System.out.println(getDirection("MOVE<BAD>"));
     System.out.println(getDirection("MOVE<W>"));
     System.out.println(getDirection("MOVE <N>"));
     System.out.println(getDirection("MOVE<N>BAD"));
   }
   public static final String getDirection(String input)  {
     //Reuse the same matcher
     mMove.reset(input);

     if(!mMove.matches())  {
        return  null;
     }
     return  mMove.group(1);
  }
}

