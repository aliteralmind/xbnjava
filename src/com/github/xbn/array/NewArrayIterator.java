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
package  com.github.xbn.array;
	import  com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator;
	import  com.github.xbn.array.primitive.IsValidPArrayElementIterator;
	import  java.util.Iterator;
	import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
	import  com.github.xbn.array.helper.PrimitiveArrayHelper;
	import  com.github.xbn.analyze.validate.ValueValidator;
	import  com.github.xbn.util.itr.AbstractIsValidElementIterator;
	import  com.github.xbn.util.itr.AbstractElementTSLengthIterator;
/**
	<P>Convenience functions for creating array-iterators that obtain each element's <I>validity</I> or {@code toString()} length.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class NewArrayIterator  {
   private NewArrayIterator()  {
		throw  new IllegalStateException("Do not instantiate");
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		<!-- MAIN FUNCTION -->
<!--
char Character Char
double Double Double
float Float Float
long Long Long
int Integer Int
short Short Short
byte Byte Byte
 -->

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Character&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forCharacter()))</CODE>

		@see  #forIsElementValid(byte[], ValueValidator) forIsElementValid(y[],vv)
		@see  #forIsElementValid(short[], ValueValidator) forIsElementValid(h[],vv)
		@see  #forIsElementValid(int[], ValueValidator) forIsElementValid(int[],vv)
		@see  #forIsElementValid(long[], ValueValidator) forIsElementValid(l[],vv)
		@see  #forIsElementValid(float[], ValueValidator) forIsElementValid(f[],vv)
		@see  #forIsElementValid(double[], ValueValidator) forIsElementValid(d[],vv)
		@see  #forDigitTSLength(byte[]) forDigitTSLength(y[])
		@see  #forDigitTSLength(short[]) forDigitTSLength(h[])
		@see  #forDigitTSLength(int[]) forDigitTSLength(int[])
		@see  #forDigitTSLength(long[]) forDigitTSLength(l[])
		@see  #forDigitTSLength(float[]) forDigitTSLength(f[])
		@see  #forDigitTSLength(double[]) forDigitTSLength(d[])
	 **/
	public static final Iterator<Boolean> forIsElementValid(char[] prim_array, ValueValidator<Character> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Character>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forCharacter()));
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Byte&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forByte()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Boolean> forIsElementValid(byte[] prim_array, ValueValidator<Byte> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Byte>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forByte()));
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Short&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forShort()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Boolean> forIsElementValid(short[] prim_array, ValueValidator<Short> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Short>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forShort()));
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Integer&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forIntegereger()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Boolean> forIsElementValid(int[] prim_array, ValueValidator<Integer> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Integer>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forInteger()));
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Long&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forLong()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Boolean> forIsElementValid(long[] prim_array, ValueValidator<Long> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Long>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forLong()));
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Float&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forFloat()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Boolean> forIsElementValid(float[] prim_array, ValueValidator<Float> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Float>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forFloat()));
	}
	/**
		<P>Get an iterator that states whether each element in a primitive array is &quot;good&quot; or &quot;bad&quot;.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.IsValidPArrayElementIterator#IsValidPArrayElementIterator(Object, ValueValidator, PrimitiveArrayHelper) IsValidPArrayElementIterator}&lt;Double&gt;(prim_array, element_vldtr, NewPrimitiveArrayHelper.forDouble()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Boolean> forIsElementValid(double[] prim_array, ValueValidator<Double> element_vldtr)  {
		return  (new IsValidPArrayElementIterator<Double>(prim_array, element_vldtr, NewPrimitiveArrayHelper.forDouble()));
	}
	/**
		<P>Get an iterator that returns the length (of the {@code toString()}) for each numeric element in a primitive array.</P>
<!--
byte Byte Byte
double Double Double
float Float Float
long Long Long
int Integer Int
short Short Short

		&#64;see  #forIsElementValid(chaxr[], ValueValidator) forIsElementValid(cx[],vv)
 -->
		@return  <CODE>(new {@link com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator#PrimitiveArrayTSLengthIterator(Object, PrimitiveArrayHelper) PrimitiveArrayTSLengthIterator}&lt;Byte&gt;(prim_array, NewPrimitiveArrayHelper.forByte()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Integer> forDigitTSLength(byte[] prim_array)  {
		return  (new PrimitiveArrayTSLengthIterator<Byte>(prim_array, NewPrimitiveArrayHelper.forByte()));
	}
	/**
		<P>Get an iterator that returns the length (of the {@code toString()}) for each numeric element in a primitive array.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator#PrimitiveArrayTSLengthIterator(Object, PrimitiveArrayHelper) PrimitiveArrayTSLengthIterator}&lt;Short&gt;(prim_array, NewPrimitiveArrayHelper.forShort()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Integer> forDigitTSLength(short[] prim_array)  {
		return  (new PrimitiveArrayTSLengthIterator<Short>(prim_array, NewPrimitiveArrayHelper.forShort()));
	}
	/**
		<P>Get an iterator that returns the length (of the {@code toString()}) for each numeric element in a primitive array.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator#PrimitiveArrayTSLengthIterator(Object, PrimitiveArrayHelper) PrimitiveArrayTSLengthIterator}&lt;Integer&gt;(prim_array, NewPrimitiveArrayHelper.forIntegereger()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Integer> forDigitTSLength(int[] prim_array)  {
		return  (new PrimitiveArrayTSLengthIterator<Integer>(prim_array, NewPrimitiveArrayHelper.forInteger()));
	}
	/**
		<P>Get an iterator that returns the length (of the {@code toString()}) for each numeric element in a primitive array.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator#PrimitiveArrayTSLengthIterator(Object, PrimitiveArrayHelper) PrimitiveArrayTSLengthIterator}&lt;Long&gt;(prim_array, NewPrimitiveArrayHelper.forLong()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Integer> forDigitTSLength(long[] prim_array)  {
		return  (new PrimitiveArrayTSLengthIterator<Long>(prim_array, NewPrimitiveArrayHelper.forLong()));
	}
	/**
		<P>Get an iterator that returns the length (of the {@code toString()}) for each numeric element in a primitive array.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator#PrimitiveArrayTSLengthIterator(Object, PrimitiveArrayHelper) PrimitiveArrayTSLengthIterator}&lt;Float&gt;(prim_array, NewPrimitiveArrayHelper.forFloat()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Integer> forDigitTSLength(float[] prim_array)  {
		return  (new PrimitiveArrayTSLengthIterator<Float>(prim_array, NewPrimitiveArrayHelper.forFloat()));
	}
	/**
		<P>Get an iterator that returns the length (of the {@code toString()}) for each numeric element in a primitive array.</P>

		@return  <CODE>(new {@link com.github.xbn.array.primitive.PrimitiveArrayTSLengthIterator#PrimitiveArrayTSLengthIterator(Object, PrimitiveArrayHelper) PrimitiveArrayTSLengthIterator}&lt;Double&gt;(prim_array, NewPrimitiveArrayHelper.forDouble()))</CODE>
		@see  #forIsElementValid(char[], ValueValidator)
	 **/
	public static final Iterator<Integer> forDigitTSLength(double[] prim_array)  {
		return  (new PrimitiveArrayTSLengthIterator<Double>(prim_array, NewPrimitiveArrayHelper.forDouble()));
	}
	public static final <E> Iterator<Integer> getNonPArrayElementTSLengthIterator(E[] array)  {
		return  (new NonPArrayElementTSLengthIterator<E>(array));
	}
	public static final <R> Iterator<Boolean> forIsElementValid(R[] array, ValueValidator<R> element_vldtr)  {
		return  (new IsValidNonPArrayEElementIterator<R>(array, element_vldtr));
	}
}
class IsValidNonPArrayEElementIterator<R> extends AbstractIsValidElementIterator<R>  {
	public IsValidNonPArrayEElementIterator(R[] array, ValueValidator<R> element_vldtr)  {
		super(array, element_vldtr);
	}
	protected R getRawElementRTXOkay(int index)  {
		return  getRawArray()[index];
	}
	@SuppressWarnings("unchecked")
	protected R[] getRawArray()  {
		return  ((R[])getContainer());
	}
	public int getTotalElementCount()  {
		return  getRawArray().length;
	}
}
class NonPArrayElementTSLengthIterator<R> extends AbstractElementTSLengthIterator<R>  {
	public NonPArrayElementTSLengthIterator(R[] prim_array)  {
		super(prim_array);
	}
	@SuppressWarnings("unchecked")
	protected R[] getRawArray()  {
		return  (R[])getContainer();
	}
	protected R getRawElementRTXOkay(int index)  {
		return  getRawArray()[index];
	}
	public int getTotalElementCount()  {
		return  getRawArray().length;
	}
}
