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
   <P>Information about a user -- <I>[builder: UserConfig_Cfg]</I></P>

   <P>Validation of all fields occurs in this classes constructor. However, each validation requirement is document only in the builder's setter functions.</P>

   <P>{@code java com.github.xbn.examples.lang.builder.finalv.UserConfig}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class UserConfig  {
   private final String sName    ;
   private final int    iAge     ;
   private final String sFavColor;
   /**
   	<P>Create a new instance. This sets and validates all fields.</P>

   	@param  fieldable  May not be {@code null}.
    **/
   public UserConfig(UserConfig_Fieldable fieldable)  {
      //transfer
         try  {
            sName  = fieldable.getName();
         }  catch(NullPointerException rx)  {
            throw  new NullPointerException("fieldable");
         }
         iAge      = fieldable.getAge();
         sFavColor = fieldable.getFavoriteColor();

      //validate
         try  {
            if(!Pattern.compile("\\w+").matcher(sName).matches())  {
               throw  new IllegalArgumentException("fieldable.getName() (\"" + sName + "\") may not be empty, and must contain only letters digits and underscores.");
            }
         }  catch(NullPointerException rx)  {
            throw  new NullPointerException("fieldable.getName()");
         }
         if(iAge < 0)  {
            throw  new IllegalArgumentException("fieldable.getAge() (" + iAge + ") is less than zero.");
         }
         try  {
            if(!Pattern.compile("(?:red|blue|green|hot pink)").matcher(sFavColor).matches())  {
               throw  new IllegalArgumentException("fieldable.getFavoriteColor() (\"" + fieldable.getFavoriteColor() + "\") is not red, blue, green, or hot pink.");
            }
         }  catch(NullPointerException rx)  {
            throw  new NullPointerException("fieldable.getFavoriteColor()");
         }
   }
   //getters...START
      /**
         <P>The user's name.</P>

         @return  A non-{@code null}, non-empty string.
         @see  UserConfig_Cfg#UserConfig_Cfg(String)
         @see  #getAge()
         @see  #getFavoriteColor()
       **/
      public String getName()  {
         return  sName;
      }
      /**
         <P>The user's age.</P>

         @return  A number greater-than-or-equal-to zero.
         @see  UserConfig_Cfg#age(int)
         @see  #getName()
       **/
      public int getAge()  {
         return  iAge;
      }
      /**
         <P>The user's favorite color.</P>

         @return  A non-{@code null}, non-empty string.
         @see  UserConfig_Cfg#age(int)
         @see  #getName()
       **/
      public String getFavoriteColor()  {
         return  sFavColor;
      }
   //getters...END
   public String toString()  {
      return  "getName()=" + getName() + ", getAge()=" + getAge() + ", getFavoriteColor()=" + getFavoriteColor();
   }
}
