/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.lang.builder.blind;
/**
   <P>Demonstrates a Blind Builder.</P>

   <P>{@code java com.github.xbn.examples.lang.builder.blind.BlindBuilderXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class BlindBuilderXmpl  {
   public static final void main(String[] ignored)  {
      UserConfig uc = new UserConfig_Cfg("Kermit").age(50).favoriteColor("green").build();
      System.out.println(uc);
   }
}

//CLASS TO BUILD
class UserConfig  {
   private final String sName    ;
   private final int    iAge     ;
   private final String sFavColor;
   public UserConfig(UserConfig_Fieldable fieldable)  {
      //transfer
         try  {
            sName  = fieldable.getName();
         }  catch(NullPointerException rx)  {
            throw  new NullPointerException("fieldable");
         }
         iAge      = fieldable.getAge();
         sFavColor = fieldable.getFavoriteColor();

      //Validate all fields here
   }
   public String toString()  {
      return  "name=" + sName + ", age=" + iAge + ", sFavColor=" + sFavColor;
   }
}

//FIELDABLE
interface UserConfig_Fieldable  {
   String getName();
   int getAge();
   String getFavoriteColor();
}

//BUILDER
class UserConfig_Cfg implements UserConfig_Fieldable  {
   public String sName    ;
   public int    iAge     ;
   public String sFavColor;
   public UserConfig_Cfg(String name)  {
      sName = name;
   }
   //self-returning setters...START
      public UserConfig_Cfg age(int years)  {
         iAge = years;
         return  this;
      }
      public UserConfig_Cfg favoriteColor(String color)  {
         sFavColor = color;
         return  this;
      }
   //self-returning setters...END
   //getters...START
      public String getName()  {
         return  sName;
      }
      public int getAge()  {
         return  iAge;
      }
      public String getFavoriteColor()  {
         return  sFavColor;
      }
   //getters...END
   public UserConfig build()  {
      return  (new UserConfig(this));
   }
}
