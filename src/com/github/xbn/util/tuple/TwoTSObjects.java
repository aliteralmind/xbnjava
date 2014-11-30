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
package  com.github.xbn.util.tuple;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.ToStringDefensive;
/**
   <p>Holds two objects.</p>

{@.codelet.and.out com.github.xbn.examples.util.tuple.PotentialStringConcatWithThreeObjs%eliminateCommentBlocksAndPackageDecl()}

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class TwoTSObjects  {
   private final String callingNonFQClnNm;
   private Object o1;
   private Object o2;
//constructors...START
   public TwoTSObjects(Object o_1, Object o_2)  {
      this("TwoTSObjects", o_1, o_2);
   }
   protected TwoTSObjects(String calling_nonFQclassName, Object o_1, Object o_2)  {
      callingNonFQClnNm = calling_nonFQclassName;
      set1(o_1);
      set2(o_2);
   }
//constructors...END
   public Object get1()  {
      return  o1;
   }
   public Object get2()  {
      return  o2;
   }
   public TwoTSObjects set1(Object o_1)  {
      o1 = o_1;
      return  this;
   }
   public TwoTSObjects set2(Object o_2)  {
      o2 = o_2;
      return  this;
   }
   public TwoTSObjects set(Object o_1, Object o_2)  {
      set1(o_1);
      return  set2(o_2);
   }
   public String toString()  {
      return  getJoined();
   }
   public String getJoined()  {
      return  appendJoined(new StringBuilder()).toString();
   }
   public Appendable appendJoined(Appendable to_appendTo, Object... dddo_3AndUp)  {
      try  {
         if(get1() != null)  {
            ToStringDefensive.append(to_appendTo, get1(), callingNonFQClnNm, 1);
         }
         if(get2() != null)  {
            ToStringDefensive.append(to_appendTo, get2(), callingNonFQClnNm, 2);
         }
         for(int i = 0, j = 3; i < dddo_3AndUp.length; i++, j++)  {
            ToStringDefensive.append(to_appendTo, dddo_3AndUp[i], callingNonFQClnNm, j);
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
}
