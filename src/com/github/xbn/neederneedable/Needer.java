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
/**
	<P>{@code Needer}s need another object, as created by a {@code Needable}.</P>

	<P><I>This interface results in a number of unchecked-cast warnings, due to the possibility of multiple types of objects being needed by the same class. Type-safety is ensured by the {@code needed_class} parameter in {@link #startConfig(Class) startConfig(cls)}.</I></P>

	@see  Needable
	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface Needer  {
	/**
		<P>Start the configuration of a new object of a specific type.</P>

		<P>This<OL>
			<LI>Calls <CODE><I>[{@link com.github.xbn.neederneedable.Needable Needable}]</I>.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="Needable.html#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(this)</CODE></LI>
			<LI>Sets {@link #isConfigActive() isConfigActive}{@code ()} to {@code true}.</LI>
		</OL>

		@param  needed_class  The type of object needed. Get with {@link #getNeededType() getNeededType}{@code ()}. For example: {@code Integer.class} or
		<BR> &nbsp; &nbsp; {@code (Class<ListLister<E>>)((Class)ListLister.class))}
		<BR>Why the crazy casting is necessary with generics:

		<P><TABLE ALIGN="center" WIDTH="100%" BORDER="1" CELLSPACING="0" CELLPADDING="4" BGCOLOR="#EEEEEE"><TR ALIGN="left" VALIGN="middle">
			<TD>From (viewed 1/4/2014)
			<BR> &nbsp; &nbsp; <CODE><A HREF="http://stackoverflow.com/questions/7502243/java-casting-class-operator-used-on-a-generic-type-e-g-list-to-classlist">http://stackoverflow.com/questions/7502243/java-casting-class-operator-used-on-a-generic-type-e-g-list-to-classlist</A></CODE><P/>

			<PRE>{@literal Class<List<Integer>> tListInt3 =
   (Class<List<Integer>>)((Class<Integer>)List.class);}</PRE>

			<P>doesn't work. you probably meant</P>

			<PRE>{@literal Class<List<Integer>> tListInt3 =
   (Class<List<Integer>>)((Class)List.class);}</PRE>

			<P>we can always cast from one type to another by up-cast then down-cast
			<BR> &nbsp; &nbsp; {@code Integer x = (Integer)(Object)"string";}</P>

			<P>The type of {@code List.class} is {@code Class<List>} it is not a subtype/supertype of {@code Class<List<Whatever>>} therefore direct cast between the two types is illegal.</P>

			<P>It can be argued that {@code Class<List<Integer>>} doesn't exist - there is only a class for {@code List} there is no such class for {@code List<Integer>} (which really is just {@code List} at runtime)</P>

			</P>However, this is a flaw of Java type system; in practice we do need things like {@code Class<List<Integer>>}. Our solution - casting and pretending {@code Class<List<Int>>} exists - is likewise flawed - but it's not our fault.</TD>
		</TR></TABLE></P>

		@exception  IllegalStateException  If {@link #isConfigActive() isConfigActive}{@code ()} is {@code true}.
	 **/
	void startConfig(Class<?> needed_class);
	/**
		<P>Is an object being configured?.</P>

		@return  {@code true}  If {@link #startConfig(Class) startConfig(cls)} was more-recently called than {@link #neeadableSetsNeeded(Object) neeadableSetsNeeded(o)}.
	 **/
	boolean isConfigActive();
	/**
		<P>The type of object currently being configured.</P>

		@see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="Needable.html#startConfigReturnNeedable(R)">startConfigReturnNeedable</A>(R)</CODE>
		@see  #isConfigActive()
	 **/
	Class getNeededType();
	/**
		<P>Called by the {@code Needable} to set the fully configured object. This {@link com.github.xbn.neederneedable.Needable Needable} is the same one as called in the first step of {@link #startConfig(Class) startConfig(cls)}. This function is never called directly.</P>

		<P>This sets<OL>
			<LI>{@code fully_configured} to an internal object.</LI>
			<LI>{@link #isConfigActive() isConfigActive}{@code ()} to {@code false}.</LI>
		</OL>

		@exception  IllegalStateException  If {@code isConfigActive()} is {@code null}.
		@exception  ClassCastException  If <CODE>({@link #getNeededType() getNeededType}().isInstance(fully_configured))</CODE> is {@code false}. <I>{@code Needer}-s may need multiple types of objects, so {@code Needer&lt;ASingleClassType&gt;} is not possible. {@code <I>[Class]</I>.isInstance(o)} ensures that the needable-configuration completes as expected, and avoids an {@code instanceof} &quot;switch&quot; (if-then-else) block.</I>
	 **/
	void neeadableSetsNeeded(Object fully_configured);
}

