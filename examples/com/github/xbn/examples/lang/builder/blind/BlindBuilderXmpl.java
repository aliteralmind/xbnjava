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
package  com.github.xbn.examples.lang.builder.blind;
/**
   <P>Demonstrates a Blind Builder.</P>

   <P>{@code java com.github.xbn.examples.lang.builder.blind.BlindBuilderXmpl}</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

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
