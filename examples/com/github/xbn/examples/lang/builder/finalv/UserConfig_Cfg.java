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
package  com.github.xbn.examples.lang.builder.finalv;
/**
   <p>Builder for {@link UserConfig}.</p>

   <p>Validation of all fields occurs in the <code>UserConfig</code> constructor. However, each validation requirement is document only in this classes setter functions.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class UserConfig_Cfg implements UserConfig_Fieldable  {
   public String sName    ;
   public int    iAge     ;
   public String sFavColor;
   /**
      <p>Create a new instance with the user's name.</p>

    * @param  name  May not be {@code null} or empty, and must contain only letters, digits, and underscores. Get with {@code UserConfig#getName() getName()}{@code ()}*.
    */
   public UserConfig_Cfg(String name)  {
      sName = name;
   }
   //self-returning setters...START
      /**
         <p>Set the user's age.</p>

       * @param  years  May not be less than zero. Get with {@code UserConfig#getName() getName()}{@code ()}*.
       * @see  #favoriteColor(String)
       */
      public UserConfig_Cfg age(int years)  {
         iAge = years;
         return  this;
      }
      /**
         <p>Set the user's favorite color.</p>

       * @param  color  Must be {@code "red"}, {@code "blue"}, {@code green}, or {@code "hot pink"}. Get with {@code UserConfig#getName() getName()}{@code ()}*.
       * @see  #age(int)
       */
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
      <p>Build the {@code UserConfig}, as configured.</p>

    * @return  <code>(new {@link UserConfig#UserConfig(UserConfig_Fieldable) UserConfig}(this))</code>
    */
   public UserConfig build()  {
      return  (new UserConfig(this));
   }
}
