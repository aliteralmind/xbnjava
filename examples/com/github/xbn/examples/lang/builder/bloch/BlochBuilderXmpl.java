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
package  com.github.xbn.examples.lang.builder.bloch;
/**
   <P>Demonstrates a Bloch Builder.</P>

	<P>{@code java com.github.xbn.examples.lang.builder.bloch.BlochBuilderXmpl}</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

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