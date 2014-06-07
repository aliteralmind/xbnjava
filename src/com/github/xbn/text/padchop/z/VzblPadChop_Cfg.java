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
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.neederneedable.DummyForNoNeeder;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring a {@link com.github.xbn.text.padchop.VzblPadChop VzblPadChop}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
/**
   <P>. For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#direct">directly</A> configuring a {@link VzblPadChop}.</P>
 **/
public class VzblPadChop_Cfg extends VzblPadChop_CfgForNeeder<VzblPadChop,DummyForNoNeeder>   {
   /**
      <P>Create a new {@code zVzblPadChop_Cfg} with defaults.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="#VzblPadChop_CfgForNeeder(R)">this</A>(null)</CODE></P>
      @see  #VzblPadChop_Cfg(int) this(i)
    **/
   public VzblPadChop_Cfg()  {
      super(null);
   }
   /**
      <P>Create a new {@code zVzblPadChop_Cfg} with defaults, but a specific goal length.</P>

         <P>Equal to
      <BR> &nbsp; &nbsp; <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="VzblPadChop_CfgForNeeder.html#VzblPadChop_CfgForNeeder(R, int)">super</A>(goal_len, null)</CODE></P>

      @see  #VzblPadChop_Cfg() this()
    **/
   public VzblPadChop_Cfg(int goal_len)  {
      super(null, goal_len);
   }
}
