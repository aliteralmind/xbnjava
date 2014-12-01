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
   import  com.github.xbn.text.StringWithNullDefault;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>Data related to an {@code XbnIndexOutOfBoundsException} when an index <i>range</i> is bad.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class XIbxBadRange extends XIbxData  {
   private int    iBadIdxMin   = -1  ;
   private String iBadIdxMinNm = null;
   private int    iBadIdxMaxX   = -1  ;
   private String iBadIdxMaxXNm = null;
   public XIbxBadRange(int min_inclusive, int max_exclusive)  {
      this(min_inclusive, max_exclusive, null, null);
   }
   public XIbxBadRange(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      iBadIdxMin = min_inclusive;
      iBadIdxMaxX = max_exclusive;
      iBadIdxMinNm = min_name;
      iBadIdxMaxXNm = max_name;
   }
   public int getBadMin()  {
      return  iBadIdxMin;
   }
   public String getBadMinName()  {
      return  iBadIdxMinNm;
   }
   public int getBadMaxX()  {
      return  iBadIdxMaxX;
   }
   public String getBadMaxXName()  {
      return  iBadIdxMaxXNm;
   }
   public void ciNOTBadForAbsBounds_forCfgBuild()  {
      XIbxBadRange.ciNOTBadForAbsBounds_forCfgBuild(this);
   }
   public static final void ciNOTBadForAbsBounds_forCfgBuild(XIbxBadRange xibx_fb)  {
      boolean bMinGood = false;
      try  {
         bMinGood = (xibx_fb.getBadMin() >= xibx_fb.getAbsMin()  &&
               xibx_fb.getBadMin() < xibx_fb.getAbsMaxX());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(xibx_fb, "xibx_fb", null, rx);
      }
      boolean bMaxGood = (xibx_fb.getBadMaxX() > xibx_fb.getAbsMin()  &&
         xibx_fb.getBadMaxX() <= xibx_fb.getAbsMaxX());

      if(bMinGood  &&  bMaxGood)  {
         throw  new IllegalArgumentStateException("The 'bad' index range is not bad! getBadMin()=" + xibx_fb.getBadMin() + ", getBadMaxX()=" + xibx_fb.getBadMaxX() + ", getAbsMin()=" + xibx_fb.getAbsMin() + ", getAbsMaxX()=" + xibx_fb.getAbsMaxX());
      }
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo).append(", ");
      StringWithNullDefault.append(to_appendTo, getBadMinName(), "[bad-index-range-min_inclusive]");
      to_appendTo.append("=").append(getBadMin()).append(", ");
      StringWithNullDefault.append(to_appendTo, getBadMaxXName(), "[bad-index-range-max-exclusive]");

      return  to_appendTo.append("=").append(getBadMaxX());
   }
}
