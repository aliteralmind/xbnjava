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
package  com.github.xbn.examples.util.tuple;
   import  com.github.xbn.util.tuple.ThreeTSObjects;
/**
   <p>Uses {@code com.github.xbn.util.tuple.}{@link com.github.xbn.util.tuple.ThreeTSObjects} to hold a moderately-complex object, whose {@code toString()} should only be executed when an exception is thrown--This class throws an {@code IllegalStateException}.</p>

   <p>{@code java com.github.xbn.examples.util.tuple.PotentialStringConcatWithThreeObjs}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class PotentialStringConcatWithThreeObjs  {
   public static final void main(String[] ignored)  {
      ThreeTSObjects to = new ThreeTSObjects("Extra information: [", (new AModeratelyComplexObject()), "]");

      try  {
         if(false)  {
            throw  new IllegalStateException("A bad: " + to.toString());
         }
         System.out.println("A good");
      }  catch(RuntimeException rx)  {
         System.out.println(rx);
      }
      try  {
         if(true)  {
            throw  new IllegalStateException("B bad: " + to.toString());
         }
         System.out.println("B good");
      }  catch(RuntimeException rx)  {
         System.out.println(rx);
      }
   }
}
class AModeratelyComplexObject  {
   public long getNeg300BPlus1FiveMTimes()  {
      long l = -300000000000L;
      for(int i = 0; i < 5000000; i++)  {
         l += 1;
      }
      return  l;
   }
   public String toString()  {
      return  this.getClass().getName() + ": getNeg300BPlus1FiveMTimes()=" + getNeg300BPlus1FiveMTimes();
   }
}
