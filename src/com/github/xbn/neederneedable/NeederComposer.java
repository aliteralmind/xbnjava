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
package  com.github.xbn.neederneedable;
	import  com.github.xbn.lang.CrashIfObject;
	import  com.github.xbn.testdev.CompositionConstructor;
	import  com.github.xbn.testdev.CompositionFunction;
/**
	<p>For classes that need to implement {@code Needer}, that cannot extend {@code AbstractNeeder}.</p>

	@see  Needer
	@see  AbstractNeeder
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NeederComposer  {//implements Needer  {
//state
	Class<?> clsNdd = null;
	boolean bCfgActv = false;
//internal
//constructors...START
	/**
		<p>Create a new instance.</p>
	 **/
	@CompositionConstructor
	public NeederComposer()  {
	}
//constructors...END
	//documented by interface
	@SuppressWarnings("unchecked")
	@CompositionFunction
	public Class getNeededType()  {
		return  clsNdd;
	}
	//documented by interface
	@CompositionFunction
	public boolean isConfigActive()  {
		return  bCfgActv;
	}
//main functionality...START
	//documented by interface
	@CompositionFunction
	public <O> void startConfig(Class<O> needed_class)  {
		if(isConfigActive())  {
			throw  new IllegalStateException("isConfigActive() is true.");
		}
		if(needed_class == null)  {
			throw  new NullPointerException("needed_class");
		}
		clsNdd = needed_class;
		bCfgActv = true;
	}
	/**
		<p>End configuration and get the fully-configured object--this must be implemented as {@code protected} with the name &quot;{@code setGetNeededEndConfig}&quot;.</p>
	 **/
	@CompositionFunction
	public Object setGetNeededEndConfig_4prot(Object needed_fullyConfigured)  {
		if(!isConfigActive())  {
			throw  new IllegalStateException("isConfigActive() is false.");
		}

		if(!getNeededType().isInstance(needed_fullyConfigured))  {
			throw  new ClassCastException("getNeededType().isInstance(needed_fullyConfigured) is false. getNeededType()=" + getNeededType() + ", needed_fullyConfigured=[" + needed_fullyConfigured + "]");
		}
		bCfgActv = false;
		return  needed_fullyConfigured;
	}
//main functionality...END
	public static final void isxIfActiveIs(Needer needer, boolean crash_ifConfigIsActive)  {
		try  {
			if(needer.isConfigActive() == crash_ifConfigIsActive)  {
				throw  new IllegalStateException("isConfigActive() is " + crash_ifConfigIsActive + ".");
			}
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(needer, "needer", null, rx);
		}
	}
/*stub functions for implements compile...START
	public void neeadableSetsNeeded(Object fully_configured)  {
	}
 stub functions for implements compile...END*/
}