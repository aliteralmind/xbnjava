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
package  com.github.xbn.util;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.Objects;
   import  java.util.Comparator;
   import  com.github.xbn.lang.IllegalArgumentStateException;
/**
   <P>If a set of comparable objects are not ascending, crash.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ComparatorUtil  {
   private ComparatorUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   @SuppressWarnings({"unchecked", "varargs"})
   public static final <O> void ciNotAscending(Comparator<O> cmp_rtr, boolean ignored, O... objects)  {
      ciNotAscending(cmp_rtr, objects);
   }
   public static final <O> void ciNotAscending(Comparator<O> cmp_rtr, O[] objects)  {
      int iLen = -1;
      try  {
         iLen = objects.length;
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("objects");
      }

      for(int i = 0; i < (iLen - 1); i++)  {
         try  {
            if(cmp_rtr.compare(objects[i], objects[i+1]) > 0)  {
               throw  new IllegalArgumentStateException("objects[" + i + "] and objects[" + (i + 1) + "] are not in ascending order. -- objects[" + i + "]=<" + objects[i] + ">, objects[" + (i + 1) + "]=<" + " + objects[i+1] + " + ">");
            }
         }  catch(RuntimeException rx)  {
            Objects.requireNonNull(cmp_rtr, "cmp_rtr");
            Objects.requireNonNull(objects[i], "objects[" + i + "]");
            String sXi = "Attempting cmp_rtr.compare(objects[" + i + "], objects[" + (i+1) + "]). -- objects[" + i + "]=<" + objects[i] + "> and objects[" + (i + 1) + "]=<" + " + objects[i+1] + " + ">, cmp_rtr=[" + cmp_rtr + "]";
            throw  CrashIfObject.nullOrReturnCause(objects[i+1], "objects[" + (i+1) + "]", sXi, rx);
         }
      }
   }
}
