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
package  com.github.xbn.experimental.listify.primitiveable;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.experimental.listify.Listify;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
/**
	<P>Listifier whose virtual elements are primitive wrappers, such as {@code java.lang.Integer}s or {@code java.lang.Boolean}s.</P>
 **/
public interface ListifyPrimitiveable<E> extends Listify<E>  {
	/**
		<P>For obtaining initialized arrays of both the wrapper and primitive type, and basic manipulation and access of the raw object, when it is also a primitive array.</P>
	 **/
	@Override
	PrimitiveArrayHelper<E> getArrayHelper();
	/**
		<P>Defines how {@code null} elements should be handled when creating new primitive arrays containing the virtual elements.</P>
	 **/
	NullHandlerForPrimitives<E> getNullHandlerForPrimitives();
	/**
		<P>Createa new primitive array containing all virtual elements.</P>

		@param  nnull  If the <A HREF="#getRawObject()">raw object</A> is {@code null}, and this parameter is<UL>
			<LI>non-{@code null}: crash ({@code is_nullCntrOk} is the name of the function calling this one)</LI>
			<LI>{@code null}: <I><B>return</B></I> {@code null}</LI>
		</UL>.
		@see  com.github.xbn.array.IndexableUtil#crashIfContainerIsNullAndThatIsBad(NullContainer, boolean) CrashIfObject#crashIfContainerIsNullAndThatIsBad(nci,b)
	 **/
	Object getPArrayCopyOrNull(NullContainer nnull);
}
