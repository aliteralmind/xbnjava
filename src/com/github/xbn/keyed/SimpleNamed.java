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
package  com.github.xbn.keyed;
   import  com.github.xbn.lang.CrashIfObject;
//	import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
   import  java.util.regex.Pattern;
   import  java.util.regex.Matcher;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Implementation of {@code Named}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SimpleNamed extends SimpleKeyed<String> implements Named  {
//constructors...START
   private static final Matcher nameMtchr = Pattern.compile("\\w+").matcher("");
   public SimpleNamed(String name)  {
      this(name, "name");
   }
   /**
      <P>Create a new instance.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link SimpleKeyed#SimpleNamed(String, String) this}{@code (name, "name")}</P>
    **/
   public SimpleNamed(String name, String name_varName)  {
      super(name);
      ciBadNameInCnstr(name, name_varName);
//		this(name, "name");
   }
   /*
      <P>Create a new instance</P>
   public SimpleNamed(String name, String nameName)  {
      super(name, OneParamCnstrValueCopier.STRING);
   }
    */
   /*
      <P>Create a new {@code SimpleNamed} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link SimpleKeyed#SimpleKeyed(Keyed) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
   public SimpleNamed(Named to_copy)  {
      super(to_copy);
   }
    */
//constructors...END
   public String getName()  {
      return  getKey();
   }
   /*
      <P>Get a duplicate of this {@code SimpleNamed}.</P>

      @return  <CODE>(new {@link #SimpleNamed(Named) SimpleNamed}(this))</CODE>
   public SimpleNamed getObjectCopy()  {
      return  (new SimpleNamed(this));
   }
    */
   public static final void ciBadNameInCnstr(String name, String nameName)  {
      try  {
         if(!nameMtchr.reset(name).matches())  {
            throw  new IllegalArgumentException(nameName + " (\"" + name + "\") may not be empty, and may only contain letters, digits, and underscores (must match '\\w+')");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(name, nameName, null, rx);
      }
   }
}

