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
package  com.github.xbn.array;
/**
   <P>{@code IndexOutOfBoundsException} with accessors to relevant data.</P>

   <a name="cfg"/><H3>Builder Configuration: {@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg XbnArrayIndexOutOfBoundsException_Cfg}</H3>

   <P><OL>
      <LI><B>Bad index/index-range:</B> <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#badIndex(int) badIndex}(i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#badIndex(int, String) badIndex}(i,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#badRange(int, int) badRange}(i,i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#badRange(int, int, String, String) badRange}(i,i,s,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#chainID(boolean, Object) chainID}(b,o)</CODE></LI>
      <LI><B>Absolute bounds:</B><UL>
      <!-- //Delete in XbnStr_ingIndexOutOfBoundsException...START -->
         <LI><B>Non-primitive arrays:</B> <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnArrayIndexOutOfBoundsException_Cfg#absArrayLength(E[])">absArrayLength</A>(o[])</CODE>, <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnArrayIndexOutOfBoundsException_Cfg#absArrayLength(E[], String)">absArrayLength</A>(o[],s)</CODE>, <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnArrayIndexOutOfBoundsException_Cfg.html#absMinAndArrayLength(int, E[])">absMinAndArrayLength</A>(i,o[])</CODE>, <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnArrayIndexOutOfBoundsException_Cfg#absMinAndArrayLength(int, E[], String, String)">absMinAndArrayLength</A>(i,o[],s,s)</CODE></LI>
         <LI><B>Primitive arrays:</B> <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absPArrayLength(Object) absPArrayLength}(o)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absPArrayLength(Object, String) absPArrayLength}(o,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absMinAndPArrayLength(int, Object) absMinAndPArrayLength}(i,o)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absMinAndPArrayLength(int, Object, String, String) absMinAndPArrayLength}(i,o,s,s)</CODE></LI>
      <!-- //Delete in XbnStr_ingIndexOutOfBoundsException...END -->
         <LI><B>Integers:</B> <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absBounds(int, int) absBounds}(i,i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absBounds(int, int, String, String) absBounds}(i,i,s,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absMaxX(int) absMaxX}(i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnArrayIndexOutOfBoundsException_Cfg#absMaxX(int, String) absMaxX}(i,s)</CODE></LI>
      </UL></LI>
   </OL></P>

   <P><I>{@code XbnArray}{@code IndexOutOfBoundsException} and {@code XbnString}{@code IndexOutOfBoundsException} both derive from {@code Xbn}{@code IndexOutOfBoundsException}. <B>Do not edit any class except {@code Xbn}{@code IndexOutOfBoundsException}</B></I></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XbnArrayIndexOutOfBoundsException extends XbnIbxBase  {
//constructors...START
   /**
      <P>Create a new {@code XbnArrayIndexOutOfBoundsException}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.XbnIbxBase#XbnIbxBase(XIbxData) super}{@code (x_data)}</P>
    **/
   public XbnArrayIndexOutOfBoundsException(XIbxData x_data)  {
      super(x_data);
   }
   /**
      <P>Create a new {@code XbnArrayIndexOutOfBoundsException}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.XbnIbxBase#XbnIbxBase(XbnIbxBase) super}{@code (to_copy)}</P>
    **/
   public XbnArrayIndexOutOfBoundsException(XbnIbxBase to_copy)  {
      super(to_copy);
   }
//constructors...END
}
