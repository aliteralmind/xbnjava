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
   <p>{@code IndexOutOfBoundsException} with accessors to relevant databuilder, and accessors.</p>

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg XbnStringIndexOutOfBoundsException_Cfg}</h3>

   <p><ol>
      <li><b>Bad index/index-range:</b> <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#badIndex(int) badIndex}(i)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#badIndex(int, String) badIndex}(i,s)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#badRange(int, int) badRange}(i,i)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#badRange(int, int, String, String) badRange}(i,i,s,s)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#chainID(boolean, Object) chainID}(b,o)</code></li>
      <li><b>Absolute bounds:</b><ul>
      <!-- //Delete in XbnArr_ayIndexOutOfBoundsException...START -->
         <li><b>Strings:</b> <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absStringLength(Object) absStringLength}(o)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absStringLength(Object, String) absStringLength}(o,s)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absMinAndStringLength(int, Object) absMinAndStringLength}(i,o)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absMinAndStringLength(int, Object, String, String) absMinAndStringLength}(i,o,s,s)</code></li>
      <!-- //Delete in XbnArr_ayIndexOutOfBoundsException...END -->
         <li><b>Integers:</b> <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absBounds(int, int) absBounds}(i,i)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absBounds(int, int, String, String) absBounds}(i,i,s,s)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absMaxX(int) absMaxX}(i)</code>, <code>{@link com.github.xbn.array.z.XbnStringIndexOutOfBoundsException_Cfg#absMaxX(int, String) absMaxX}(i,s)</code></li>
      </ul></li>
   </ol></p>

   <p><i>{@code XbnArray}{@code IndexOutOfBoundsException} and {@code XbnString}{@code IndexOutOfBoundsException} both derive from {@code Xbn}{@code IndexOutOfBoundsException}. <b>Do not edit any class except {@code Xbn}{@code IndexOutOfBoundsException}</b></i></p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class XbnStringIndexOutOfBoundsException extends XbnIbxBase  {
//constructors...START
   /**
      <p>Create a new {@code XbnStringIndexOutOfBoundsException}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link com.github.xbn.array.XbnIbxBase#XbnIbxBase(XIbxData) super}{@code (x_data)}</p>
    **/
   public XbnStringIndexOutOfBoundsException(XIbxData x_data)  {
      super(x_data);
   }
   /**
      <p>Create a new {@code XbnStringIndexOutOfBoundsException}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link com.github.xbn.array.XbnIbxBase#XbnIbxBase(XbnIbxBase) super}{@code (to_copy)}</p>
    **/
   public XbnStringIndexOutOfBoundsException(XbnIbxBase to_copy)  {
      super(to_copy);
   }
//constructors...END
}
