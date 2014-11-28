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
	import  com.github.xbn.testdev.CompositionConstructor;
	import  com.github.xbn.testdev.CompositionFunction;
/**
	<P>For classes that need to implement <I>both</I> {@code Needable} and {@code Needer}, that cannot extend {@code AbstractNeedableWithSubs}.</P>

	@see  AbstractNeedableWithSubs
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NeedableWithSubsComposer<O,R extends Needer> extends NeedableComposer<O,R>  {//implements Needer  {
	private final NeederComposer ndrc;
//Created in NeedableComposer, needed by NeedableWithSubsComposer...START
	/**
		<P>Create a new instance and potentially start configuration--this must be implemented as {@code protected}.</P>

		<P>This<OL>
			<LI>Calls {@link com.github.xbn.neederneedable.NeedableComposer#NeedableComposer(boolean, boolean) super}{@code (is_avaliableToNeeders, is_neededUseableAtInit)}</LI>
			<LI>Creates an internal
			<BR> &nbsp; &nbsp; {@code new }{@link com.github.xbn.neederneedable.NeederComposer#NeederComposer() NeederComposer}{@code ()}</LI>
		</OL></P>
	 **/
	@CompositionConstructor
	public NeedableWithSubsComposer(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit)  {
		super(is_avaliableToNeeders, is_neededUseableAtInit);
		ndrc = new NeederComposer();
	}
	//Composition implementation: NeederComposer...START
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeederComposer}]</I></A>.{@link com.github.xbn.neederneedable.NeederComposer#getNeededType() getNeededType}()</CODE>
		 **/
		@CompositionFunction
		public Class getNeededType()  {
			return  ndrc.getNeededType();
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeederComposer}]</I></A>.{@link com.github.xbn.neederneedable.NeederComposer#isConfigActive() isConfigActive}()</CODE>
		 **/
		@CompositionFunction
		public boolean isConfigActive()  {
			return  ndrc.isConfigActive();
		}
		/**
			<P>Starts configuration for a specific class-type.</P>

			<P>Equal to
			<BR> &nbsp; &nbsp; <CODE><I>[{@link com.github.xbn.neederneedable.NeederComposer}]</I></A>.{@link com.github.xbn.neederneedable.NeederComposer#startConfig(Class) startConfig}(needed_class)</CODE></P>
		 **/
		@CompositionFunction
		public void startConfig(Class<?> needed_class)  {
			ndrc.startConfig(needed_class);
		}
		/**
			@return   <CODE><I>[{@link com.github.xbn.neederneedable.NeederComposer}]</I></A>.{@link com.github.xbn.neederneedable.NeederComposer#setGetNeededEndConfig_4prot(Object) setGetNeededEndConfig_4prot}(needed_fullyConfigured)</CODE>
		 **/
		@CompositionFunction
		protected Object setGetNeededEndConfig(Object needed_fullyConfigured)  {
			return  ndrc.setGetNeededEndConfig_4prot(needed_fullyConfigured);
		}
	//Composition implementation: NeederComposer...END
/*stub functions for non-abstract compile...START
	public NeedableWithSubsComposer<O,R> chainID(boolean do_setStatic, Object id)  {
		return  null;
	}
	public R endCfg()  {
		return  null;
	}
	public Needable<O,R> startConfigReturnNeedable(R needer)  {
		return  null;
	}
	public void neeadableSetsNeeded(Object fully_configured)  {
	}
 stub functions for non-abstract compile...END*/
}