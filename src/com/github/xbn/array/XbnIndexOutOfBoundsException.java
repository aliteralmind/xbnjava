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
package  com.github.xbn.array;
/**
   <P>{@code IndexOutOfBoundsException} with accessors to relevant databuilder, and accessors.</P>

{@.codelet.and.out com.github.xbn.examples.array.XbnIndexOutOfBoundsExceptionXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   <a name="cfg"/><H3>Builder Configuration: {@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg XbnIndexOutOfBoundsException_Cfg}</H3>

   <P><OL>
      <LI><B>Bad index/index-range:</B> <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#badIndex(int) badIndex}(i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#badIndex(int, String) badIndex}(i,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#badRange(int, int) badRange}(i,i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#badRange(int, int, String, String) badRange}(i,i,s,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#chainID(boolean, Object) chainID}(b,o)</CODE></LI>
      <LI><B>Absolute bounds:</B><UL>
      <!-- //Delete in XbnStr_ingIndexOutOfBoundsException...START -->
         <LI><B>Non-primitive arrays:</B> <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnIndexOutOfBoundsException_Cfg#absArrayLength(E[])">absArrayLength</A>(o[])</CODE>, <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnIndexOutOfBoundsException_Cfg#absArrayLength(E[], String)">absArrayLength</A>(o[],s)</CODE>, <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnIndexOutOfBoundsException_Cfg.html#absMinAndArrayLength(int, E[])">absMinAndArrayLength</A>(i,o[])</CODE>, <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}/com/github/xbn/array/z/XbnIndexOutOfBoundsException_Cfg#absMinAndArrayLength(int, E[], String, String)">absMinAndArrayLength</A>(i,o[],s,s)</CODE></LI>
         <LI><B>Primitive arrays:</B> <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absPArrayLength(Object) absPArrayLength}(o)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absPArrayLength(Object, String) absPArrayLength}(o,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMinAndPArrayLength(int, Object) absMinAndPArrayLength}(i,o)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMinAndPArrayLength(int, Object, String, String) absMinAndPArrayLength}(i,o,s,s)</CODE></LI>
      <!-- //Delete in XbnStr_ingIndexOutOfBoundsException...END -->
      <!-- //Delete in XbnArr_ayIndexOutOfBoundsException...START -->
         <LI><B>Strings:</B> <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absStringLength(Object) absStringLength}(o)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absStringLength(Object, String) absStringLength}(o,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMinAndStringLength(int, Object) absMinAndStringLength}(i,o)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMinAndStringLength(int, Object, String, String) absMinAndStringLength}(i,o,s,s)</CODE></LI>
      <!-- //Delete in XbnArr_ayIndexOutOfBoundsException...END -->
      <!-- //Delete in Xbn[Array,String]IndexOutOfBoundsException...START -->
         <LI><B>Collections:</B> <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absCollectionSize(Collection) absCollectionSize}(cll)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absCollectionSize(Collection, String) absCollectionSize}(cll,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMinAndCollectionSize(int, Collection) absMinAndCollectionSize}(i,cll)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMinAndCollectionSize(int, Collection, String, String) absMinAndCollectionSize}(i,cll,s,s)</CODE></LI>
      <!-- //Delete in Xbn[Array,String]IndexOutOfBoundsException...END -->
         <LI><B>Integers:</B> <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absBounds(int, int) absBounds}(i,i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absBounds(int, int, String, String) absBounds}(i,i,s,s)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMaxX(int) absMaxX}(i)</CODE>, <CODE>{@link com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg#absMaxX(int, String) absMaxX}(i,s)</CODE></LI>
      </UL></LI>
   </OL></P>

   <P><I>{@code XbnArray}{@code IndexOutOfBoundsException} and {@code XbnString}{@code IndexOutOfBoundsException} both derive from {@code Xbn}{@code IndexOutOfBoundsException}. <B>Do not edit any class except {@code Xbn}{@code IndexOutOfBoundsException}</B></I></P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class XbnIndexOutOfBoundsException extends XbnIbxBase  {
//constructors...START
   /**
      <P>Create a new {@code XbnIndexOutOfBoundsException}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.XbnIbxBase#XbnIbxBase(XIbxData) super}{@code (x_data)}</P>
    **/
   public XbnIndexOutOfBoundsException(XIbxData x_data)  {
      super(x_data);
   }
   /**
      <P>Create a new {@code XbnIndexOutOfBoundsException}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link com.github.xbn.array.XbnIbxBase#XbnIbxBase(XbnIbxBase) super}{@code (to_copy)}</P>
    **/
   public XbnIndexOutOfBoundsException(XbnIbxBase to_copy)  {
      super(to_copy);
   }
//constructors...END
}
