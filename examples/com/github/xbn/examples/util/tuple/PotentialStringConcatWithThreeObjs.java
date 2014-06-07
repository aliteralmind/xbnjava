/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.util.tuple;
   import  com.github.xbn.util.tuple.ThreeTSObjects;
/**
   <P>Uses {@code com.github.xbn.util.tuple.}{@link com.github.xbn.util.tuple.ThreeTSObjects} to hold a moderately-complex object, whose {@code toString()} should only be executed when an exception is thrown--This class throws an {@code IllegalStateException}.</P>

   <P>{@code java com.github.xbn.examples.util.tuple.PotentialStringConcatWithThreeObjs}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
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
