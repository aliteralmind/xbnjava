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
package  com.github.xbn.examples.lang.reflect;
   import  com.github.xbn.lang.reflect.Declared;
   import  java.lang.reflect.Method;
   import  com.github.xbn.lang.reflect.GetMethodWithRtx;
   import  com.github.xbn.lang.reflect.InvokeMethodWithRtx;
/**
   <P>Uses {@code com.github.xbn.util.}{@link com.github.xbn.lang.reflect.GetMethodWithRtx GetMethodWithRtx} and {@link com.github.xbn.lang.reflect.InvokeMethodWithRtx InvokeMethodWithRtx}, (both of which use {@link com.github.xbn.lang.reflect.ReflectRtxUtil ReflectRtxUtil}) to invoke a specific method, which may be non-public.</P>

   <P><CODE>java com.github.xbn.examples.lang.reflect.InvokePrivateStaticMethodWithRtxXmpl</CODE></P>

   <P>See (viewed 1/23/2014)
   <BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/4770425/how-do-i-invoke-a-private-static-method-using-reflection-java">http://stackoverflow.com/questions/4770425/how-do-i-invoke-a-private-static-method-using-reflection-java</A></CODE>
   <BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/11483647/how-to-access-private-methods-and-private-data-members-via-reflection">http://stackoverflow.com/questions/11483647/how-to-access-private-methods-and-private-data-members-via-reflection</A></CODE></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class InvokePrivateStaticMethodWithRtxXmpl  {
   public static final void main(String[] ignored)  {
      System.out.println("Invoking a private static method:");

         Method m = new GetMethodWithRtx(Declared.YES).
            containingClass(InvokePrivateStaticMethodWithRtxXmpl.class).
            name("getPrivateString").noParams().
            get();

         m.setAccessible(true);  //required for private

         Object o = new InvokeMethodWithRtx(m).
            sstatic().noParams().
            invokeGetReturnValue();

      System.out.println("Returned from getPrivateString: " + o);
   }
      private static final String getPrivateString()  {
         return  "HEY!";
      }
}
