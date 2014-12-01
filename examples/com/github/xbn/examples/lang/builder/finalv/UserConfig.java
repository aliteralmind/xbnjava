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
   import  java.util.regex.Pattern;
/**
   <p>Information about a user -- <i>[builder: UserConfig_Cfg]</i></p>

   <p>Validation of all fields occurs in this classes constructor. However, each validation requirement is document only in the builder's setter functions.</p>

   <p>{@code java com.github.xbn.examples.lang.builder.finalv.UserConfig}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class UserConfig  {
   private final String sName    ;
   private final int    iAge     ;
   private final String sFavColor;
   /**
   	<p>Create a new instance. This sets and validates all fields.</p>

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
         <p>The user's name.</p>

       * @return  A non-{@code null}, non-empty string.
       * @see  UserConfig_Cfg#UserConfig_Cfg(String)
       * @see  #getAge()
       * @see  #getFavoriteColor()
       */
      public String getName()  {
         return  sName;
      }
      /**
         <p>The user's age.</p>

       * @return  A number greater-than-or-equal-to zero.
       * @see  UserConfig_Cfg#age(int)
       * @see  #getName()
       */
      public int getAge()  {
         return  iAge;
      }
      /**
         <p>The user's favorite color.</p>

       * @return  A non-{@code null}, non-empty string.
       * @see  UserConfig_Cfg#age(int)
       * @see  #getName()
       */
      public String getFavoriteColor()  {
         return  sFavColor;
      }
   //getters...END
   public String toString()  {
      return  "getName()=" + getName() + ", getAge()=" + getAge() + ", getFavoriteColor()=" + getFavoriteColor();
   }
}
