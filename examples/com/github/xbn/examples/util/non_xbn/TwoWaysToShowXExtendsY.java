/*license*\
	XBN-Java Library

	Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

	This software is dual-licensed under the:
	- Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
	- Apache Software License (ASL) version 2.0.

	Either license may be applied at your discretion. More information may be found at
	- http://en.wikipedia.org/wiki/Multi-licensing.

	The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
	- LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
	- ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.examples.util.non_xbn;
/**
	<P>Demonstrates two ways of determining if one class extends another: Using <CODE>{@link java.lang.Class Class}.{@link java.lang.Class#isAssignableFrom(Class) isAssignableFrom}</CODE> (recommended), and manually iterating through the super-classes until the fully-qualified names match (not recommended).</P>

	<P>{@code java com.github.xbn.examples.util.non_xbn.TwoWaysToShowXExtendsY}</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class TwoWaysToShowXExtendsY  {
	public static final void main(String[] ignored)  {
		System.out.println("doesAClassExtendAnother(Sub.class, Base.class)=" + doesAClassExtendAnother(Sub.class, Base.class));
		System.out.println("doesAClassExtendAnother(Base.class, Sub.class)=" + doesAClassExtendAnother(Base.class, Sub.class));

		System.out.println("Base.class.isAssignableFrom(Sub.class)=" + Base.class.isAssignableFrom(Sub.class));
		System.out.println("Sub.class.isAssignableFrom(Base.class)=" + Sub.class.isAssignableFrom(Base.class));
	}
	public static final boolean doesAClassExtendAnother(Class cls_fqcnShouldExtend, Class cls_fqcnShouldBeExtended)  {

		String snSbx = null;
		try  {
			snSbx = cls_fqcnShouldBeExtended.getName();
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("cls_fqcnShouldBeExtended");
		}

		Class clsSuper = null;
		try  {
			clsSuper = cls_fqcnShouldExtend.getSuperclass();
		}  catch(NullPointerException npx)  {
			throw  new NullPointerException("cls_fqcnShouldExtend");
		}

		while(clsSuper != null)  {
			if(clsSuper.getName().equals(snSbx))  {
				return  true;
			}
			clsSuper = clsSuper.getSuperclass();
		}
		return  false;
	}
}
class Base  {
}
class Sub extends Base  {
}





