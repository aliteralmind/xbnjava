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
package  com.github.xbn.text.padchop.z;
   import  com.github.xbn.text.padchop.PadString;
   import  com.github.xbn.neederneedable.DummyForNoNeeder;
   import  com.github.xbn.neederneedable.Needer;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring a {@link com.github.xbn.text.padchop.PadString PadString}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class PadString_Cfg extends PadString_CfgForNeeder<PadString,DummyForNoNeeder>   {
   /**
      <P>Create a new {@code PadString_Cfg} with defaults.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="PadString_CfgForNeeder.html#PadString_CfgForNeeder(R)">super</A>(null)</CODE></P>
      @see  #PadString_Cfg(int) this(i)
    **/
   public PadString_Cfg()  {
      super(null);
   }
   /**
      <P>Create a new {@code PadString_Cfg} with defaults, but a specific goal length.</P>

         <P><I><B>See:</B></I><UL>
         <LI><I>{@link #PadString_Cfg() this}{@code ()}</I></LI>
         </UL></P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="PadString_CfgForNeeder.html#PadString_CfgForNeeder(R, int)">super</A>(null, goal_len)</CODE></P>
    **/
   public PadString_Cfg(int goal_len)  {
      super(null, goal_len);
   }
}
