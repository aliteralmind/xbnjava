/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.examples.lang.builder.finalv;
   import  java.util.regex.Pattern;
/**
   <P>Builder for {@link UserConfig}.</P>

   <P>Validation of all fields occurs in the <CODE>UserConfig</CODE> constructor. However, each validation requirement is document only in this classes setter functions.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class UserConfig_Cfg implements UserConfig_Fieldable  {
   public String sName    ;
   public int    iAge     ;
   public String sFavColor;
   /**
      <P>Create a new instance with the user's name.</P>

      @param  name  May not be {@code null} or empty, and must contain only letters, digits, and underscores. Get with {@code UserConfig#getName() getName()}{@code ()}*.
    **/
   public UserConfig_Cfg(String name)  {
      sName = name;
   }
   //self-returning setters...START
      /**
         <P>Set the user's age.</P>

         @param  years  May not be less than zero. Get with {@code UserConfig#getName() getName()}{@code ()}*.
         @see  #favoriteColor(String)
       **/
      public UserConfig_Cfg age(int years)  {
         iAge = years;
         return  this;
      }
      /**
         <P>Set the user's favorite color.</P>

         @param  color  Must be {@code "red"}, {@code "blue"}, {@code green}, or {@code "hot pink"}. Get with {@code UserConfig#getName() getName()}{@code ()}*.
         @see  #age(int)
       **/
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
   /**
      <P>Build the {@code UserConfig}, as configured.</P>

      @return  <CODE>(new {@link UserConfig#UserConfig(UserConfig_Fieldable) UserConfig}(this))</CODE>
    **/
   public UserConfig build()  {
      return  (new UserConfig(this));
   }
}
