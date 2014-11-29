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
package  com.github.xbn.experimental.listify.arrayofsame;
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyPrimitiveableComposer;
	import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
	import  com.github.xbn.experimental.listify.primitiveable.ListifyBoolable;
	import  com.github.xbn.array.primitive.PrimitiveArrayFromWrapper;
/**
	<p>Listifier whose raw object is a non-primitive boolean array, and whose virtual elements are of the same type.</p>

<!--
---nwrq input---
Boolean Boolable Bool boolean
Double Doubleable PDouble double
Float Floatable PFloat float
Long Longable PLong long
Integer Intable Int int
Short Shortable PShort short
Byte Byteable PByte byte
Character Charable Char char

PRIVATE CLASS HEADERS:
	/&#42;&#42;
		<p><i>All these internal classes are derived from {@code ListifyBooxleanEArray}. <b>Do not edit any classes except {@code ListifyBooxleanEArray}</b>.</i></p>
	 &#42;&#42;/

FUNCTIONS:
	/&#42;&#42;
		<p>Create a new {@code ListifyBoolable} for an array of {@code java.lang.Boolean}-s.</p>


		&#64;return  The equivalent of {@link ListifyBooxleanEArray#ListifyBooxleanEArray(Booxlean[]) ListifyBooxleanEArray(array)}
		@see  #forBoolean(Boolean[]) forBoolean(B[])
	&#42;&#42;/
	public static final ListifyBoolable forBoolean(Boolean[] array)  {
		return  (new ListifyBooleanEArray(array));
	}
	/&#42;&#42;
		<p>Create a new {@code ListifyBoolable} for an array of {@code java.lang.Boolean}-s.</p>

		<p><i>All {@code for[Type](x[])} and {@code for[Type](x[],hnvnb)} functions are derived from {@link #forBooxlean(Booxlean[]) forBooxlean(_4TV_Booxlean[])} and {@link #forBooxlean(Booxlean[], NullHandlerForPrimitives) forBooxlean(_4TV_Booxlean[],hnvnb)}. <b>Do not edit any functions except the boolean versions.</b></i></p>

		&#64;return  The equivalent of {@link ListifyBooxleanEArray#ListifyBooxleanEArray(Booxlean[], NullHandlerForPrimitives) ListifyBooxleanEArray(array, hnr_nb)}
	&#42;&#42;/
	public static final ListifyBoolable forBoolean(Boolean[] array, NullHandlerForPrimitives<Boolean> hnr_nb)  {
		return  (new ListifyBooleanEArray(array, hnr_nb));
	}
 -->

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ListifyBooleanEArray extends AbstractListifyPWrapperEArray<Boolean> implements ListifyBoolable  {
//constructors...START
	/**
		<p>Create a new {@code ListifyBooleanEArray}.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/experimental/listify/arrayofsame/AbstractListifyPWrapperEArray.html#AbstractListifyPWrapperEArray(E[], PrimitiveArrayHelper, Class)">super</a>(array, NewPrimitiveArrayHelper.forBoolean(), Boolean.class)</code></p>
		@see  #ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) this(B[],hnvnb)
	 **/
	public ListifyBooleanEArray(Boolean[] array)  {
		super(array, NewPrimitiveArrayHelper.forBoolean(), Boolean.class);
	}
	/**
		<p>Create a new {@code ListifyBooleanEArray}.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/experimental/listify/arrayofsame/AbstractListifyPWrapperEArray.html#AbstractListifyPWrapperEArray(E[], PrimitiveArrayHelper, Class, NullHandlerForPrimitives)">super</a>{@code (array, NewPrimitiveArrayHelper.forBoolean(), Boolean.class, hnr_nb)}</p>
		@see  #ListifyBooleanEArray(Boolean[], NullHandlerForPrimitives) this(B[],hnvnb)
	 **/
	public ListifyBooleanEArray(Boolean[] array, NullHandlerForPrimitives<Boolean> hnr_nb)  {
		super(array, NewPrimitiveArrayHelper.forBoolean(), Boolean.class, hnr_nb);
	}
	/**
		<p>Create a new {@code ListifyBooleanEArray} as a duplicate of another.</p>

		<p>Equal to
		<br/> &nbsp; &nbsp; {@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPWrapperEArray#AbstractListifyPWrapperEArray(ListifyPWrapperEArray) super}{@code (to_copy)}</p>

		@param  to_copy  May not be {@code null}.
		@see  #getObjectCopy()
	 **/
	public ListifyBooleanEArray(ListifyBooleanEArray to_copy)  {
		super(to_copy);
	}
//constructors...END
 	/**
 		@return  <code>{@link com.github.xbn.array.primitive.PrimitiveArrayFromWrapper PrimitiveArrayFromWrapper.}{@link com.github.xbn.array.primitive.PrimitiveArrayFromWrapper#get(Boolean[], NullHandler, String, String) get}(<i>[{@link com.github.xbn.experimental.listify.arrayofsame.NonPrimitiveEArrayBase NonPrimitiveEArrayBase}]</i>.{@link com.github.xbn.experimental.listify.arrayofsame.NonPrimitiveEArrayBase#getRawEArray() getRawEArray}(), <i>[{@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPWrapperEArray super}]</i>.{@link com.github.xbn.experimental.listify.arrayofsame.AbstractListifyPWrapperEArray#getNullHandlerForPrimitives() getNullHandlerForPrimitives}())</code>
 	 **/
 	public final boolean[] getPArrayCopyOrNull(NullContainer nnull)  {
		return  PrimitiveArrayFromWrapper.get(getRawEArray(), getNullHandlerForPrimitives(), nnull, "getRawEArray()");
	}
	public boolean getBool(int index)  {
		return  ListifyPrimitiveableComposer.getElementCopyCINullAndHNVCrashOrDel(this, index).booleanValue();
	}
	/**
		<p>Duplicate this {@code ListifyBooleanEArray}.</p>

		@return  <code>(new {@link #ListifyBooleanEArray(ListifyBooleanEArray) ListifyBooleanEArray}(this))</code>
	 **/
	public ListifyBooleanEArray getObjectCopy()  {
		return  (new ListifyBooleanEArray(this));
	}
}
