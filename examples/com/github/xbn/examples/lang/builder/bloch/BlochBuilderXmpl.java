/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.lang.builder.bloch;
/**
   <P>Demonstrates a Bloch Builder.</P>

   <P>{@code java com.github.xbn.examples.lang.builder.bloch.BlochBuilderXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class BlochBuilderXmpl  {
   public static final void main(String[] ignored)  {
      UserConfig uc = new UserConfig.Cfg("Kermit").age(50).favoriteColor("green").build();
      System.out.println(uc);
   }
}

//CLASS TO BUILD (ENCLOSING)
class UserConfig  {
   private final String sName    ;
   private final int    iAge     ;
   private final String sFavColor;
   public UserConfig(UserConfig.Cfg uchr)  {
      //transfer
         try  {
            sName  = uchr.sName;
         }  catch(NullPointerException rx)  {
            throw  new NullPointerException("uchr");
         }
         iAge      = uchr.iAge;
         sFavColor = uchr.sFavColor;

      //Validate all fields here
   }
   public String toString()  {
      return  "name=" + sName + ", age=" + iAge + ", sFavColor=" + sFavColor;
   }

   //BUILDER
   public static class Cfg  {
      private String sName    ;
      private int    iAge     ;
      private String sFavColor;
      public Cfg(String name)  {
         sName = name;
      }
      //self-returning setters...START
         public Cfg age(int years)  {
            iAge = years;
            return  this;
         }
         public Cfg favoriteColor(String selfCmprolor)  {
            sFavColor = selfCmprolor;
            return  this;
         }
      //self-returning setters...END
      public UserConfig build()  {
         return  (new UserConfig(this));
      }
   }
}
