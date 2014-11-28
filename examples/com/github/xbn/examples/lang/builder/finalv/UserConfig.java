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
   <P>Information about a user -- <I>[builder: UserConfig_Cfg]</I></P>

   <P>Validation of all fields occurs in this classes constructor. However, each validation requirement is document only in the builder's setter functions.</P>

	<P>{@code java com.github.xbn.examples.lang.builder.finalv.UserConfig}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

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
