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
package  com.github.xbn.examples.lang.non_xbn;
/**
   <P><I>Results in an intentional exception</I> -- Demonstration of &quot;if an object is null, throw an NullPointerException, otherwise throw the cause&quot;.</P>

   <P>{@code java com.github.xbn.examples.lang.non_xbn.ExceptionHandlingXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ExceptionHandlingXmpl  {
   public static final void main(String[] ignored)  {
      //doTheThingInTheThing(null);
      doTheThingInTheThing2(null);
   }
   public static final void doTheThingInTheThing(Object thing_thatMustBeNNull)  {
      try  {
         String sToString = thing_thatMustBeNNull.toString();
         System.out.println(sToString);
      }  catch(RuntimeException rx)  {
         if(thing_thatMustBeNNull == null)  {
            throw  new NullPointerException("thing_thatMustBeNNull");
         }
         throw  rx;
      }
   }

   public static final void doTheThingInTheThing2(Object thing_thatMustBeNNull)  {
      try  {
         String sToString = thing_thatMustBeNNull.toString();
         System.out.println(sToString);
      }  catch(RuntimeException rx)  {
         throw  nullOrReturnCause(thing_thatMustBeNNull, "thing_thatMustBeNNull", null, rx);
      }
   }

   public static final RuntimeException nullOrReturnCause(Object objToTest, String str_name, Object xtra_errInfo, RuntimeException cause)  {
      if(cause == null)  {
         throw  new NullPointerException("cause");
      }
      nnull(false, objToTest, str_name, xtra_errInfo);
      return  cause;
   }

   public static final void nnull(boolean is_nullOk, Object objToTest, String str_name, Object xtra_errInfo)  {
      if(objToTest == null  &&  !is_nullOk)  {
         throw  new NullPointerException(str_name + " is null (is_nullOk is false)" +
         	((xtra_errInfo == null) ? "" : " -- Extra info: " + xtra_errInfo));
      }
   }

}


