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
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.util.JavaUtil;
/**
   <p>Base class for {@code Xbn*IndexOutOfBoundsException}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class XbnIbxBase extends IndexOutOfBoundsException  {
   private final XIbxData  xdata;
   public XbnIbxBase(XIbxData x_data)  {
      super(getDataToStringOrCINull(x_data, "x_data"));
      if(x_data == null)  {
         throw  new NullPointerException("x_data");
      }
      xdata = x_data;
   }
   public XbnIbxBase(XbnIbxBase to_copy)  {
      super(to_copy.getMessage());
      xdata = to_copy.getData();
   }
   public XIbxData getData()  {
      return  xdata;
   }
   public XIbxBadIdx getBadIdxData()  {
      try  {
         return  (XIbxBadIdx)getData();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getData() is a " + JavaUtil.getNonFQClassName(getData()));
      }
   }
   public XIbxBadRange getBadRangeData()  {
      try  {
         return  (XIbxBadRange)getData();
      }  catch(ClassCastException ccx)  {
         throw  new ClassCastException("getData() is a " + JavaUtil.getNonFQClassName(getData()));
      }
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      to_appendTo.append(this.getClass().getName()).append(": ");
      return  getData().appendToString(to_appendTo);
   }
//static...START
   public static final XIbxData getXDataCINull(XIbxData x_data)  {
      if(x_data == null)  {
         throw  new IllegalStateException("Must first set bad index or range.");
      }
      return  x_data;
   }
   static final String getDataToStringOrCINull(XIbxData x_data, String xdata_name)  {
      try  {
         return  x_data.toString();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(x_data, xdata_name, null, rx);
      }
   }
//static...END
}

