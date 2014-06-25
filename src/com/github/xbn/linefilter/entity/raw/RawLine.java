/*license*\
   Codelet: http://codelet.aliteralmind.com

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
package  com.github.xbn.linefilter.entity.raw;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  com.github.xbn.text.padchop.z.VzblPadChop_Cfg;
/**
   <P>One in a series of <I>something</I> (called &quot;raw lines&quot;), most commonly the lines in a text file.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class RawLine<O>  {
   private static final VzblPadChop VPC_DBG = new VzblPadChop_Cfg(70).
      trim().unescape().cfgChop().ddd().inMiddle().endCfg().build();
   private final int lineNum;
   private final O body;
   /**
      <P>Create a new instance.</P>

      @param  line_num  Get with {@link #getNumber() getNumber}{@code ()}.
      @param  body  May not be {@code null}, <I>but this must be checked externally</I>. Get with {@link #getBody() getBody}{@code ()}.
    **/
   public RawLine(int line_num, O body)  {
      lineNum = line_num;
      this.body = body;
   }

   /**
      <P>The number at which this line-object exists in the series.</P>

      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="RawLine.html#RawLine(int, O)">RawLine</A>(i,O)</CODE>
    **/
   public int getNumber()  {
      return  lineNum;
   }
   /**
      <P>The content of this line.</P>

      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="RawLine.html#RawLine(int, O)">RawLine</A>(i,O)</CODE>
    **/
   public O getBody()  {
      return  body;
   }
   public String toString()  {
      return  "[line " + getNumber() + "]: \"" + VPC_DBG.get(getBody()) + "\"";
   }
   public static final <O> O getBodyCINull(RawLine<O> line, String line_name)  {
      try  {
         return  line.getBody();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line, line_name, null, rx);
      }
   }
   public static final int getNumberCrashIfNull(RawLine<?> line, String line_name)  {
      try  {
         return  line.getNumber();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(line, line_name, null, rx);
      }
   }
}
