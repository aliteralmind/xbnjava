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
package  com.github.xbn.array.primitive;
	import  com.github.xbn.array.IndexableUtil;
	import  com.github.xbn.array.NullContainer;
	import  org.apache.commons.lang3.ArrayUtils;
/**
   <P>Translate a primitive array to an object array.</P>

	@since 0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ObjectArrayFromPrimitive  {
	/**
		<P>This constructor does nothing.</P>
	 **/
	public ObjectArrayFromPrimitive()  {
	}
	/**
		<P>Convert an array of an unknown <I>primitive</I> type, to an array of {@code java.lang.Object}-s.</P>

		<P>Derived from
		<BR> &nbsp; &nbsp; {@code <A HREF="http://stackoverflow.com/a/5606435/2736496">http://stackoverflow.com/a/5606435/2736496</A>}
		<BR>(viewed 12/5/2013)</P>

		@param  objThatIsAPArray  If non-{@code null}, must be an array of a primitive type ({@code boolean}, {@code char}, {@code int}, ...).
		@return  If {@code objThatIsAPArray} is <UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>Otherwise (for example), if {@code objThatIsAPArray} is a {@code boolean} array:
		<BR> &nbsp; &nbsp; {@link #get(boolean[], NullContainer, String) get}{@code ((b[])objThatIsAPArray, null, null)}</LI>
		</UL>
		@see  com.github.xbn.array.primitive.ObjThatIsPrimitiveArrayUtil#isPrimitive(Object) ObjThatIsPrimitiveArrayUtil#isPrimitive(o)
	 **/
	public static final Object[] getFromUnknown(Object objThatIsAPArray, NullContainer nnull, String cntrName_forNullBad)  {
		if(objThatIsAPArray == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(objThatIsAPArray instanceof boolean[])  {
			return  get((boolean[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof char[])  {
			return  get((char[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof byte[])  {
			return  get((byte[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof short[])  {
			return  get((short[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof int[])  {
			return  get((int[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof long[])  {
			return  get((long[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof float[])  {
			return  get((float[])objThatIsAPArray, nnull, null);
		}  else if(objThatIsAPArray instanceof double[])  {
			return  get((double[])objThatIsAPArray, nnull, null);
		}  else  {
			throw  new IllegalArgumentException("isPrimitive(objThatIsAPArray) is false (actually: " + ObjThatIsPrimitiveArrayUtil.isPrimitive(objThatIsAPArray) + ")");
		}
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code boolean}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>

		@see  #get(char[], NullContainer, String) get(char[],s)
		@see  #get(byte[], NullContainer, String) get(byte[],s)
		@see  #get(short[], NullContainer, String) get(short[],s)
		@see  #get(int[], NullContainer, String) get(int[],s)
		@see  #get(long[], NullContainer, String) get(long[],s)
		@see  #get(float[], NullContainer, String) get(float[],s)
		@see  #get(double[], NullContainer, String) get(double[],s)
	 **/
	public static final Object[] get(boolean[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Object[] ao = new Object[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Boolean(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code char}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(char[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Character[] ao = new Character[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Character(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code byte}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(byte[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Byte[] ao = new Byte[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Byte(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code short}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(short[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Short[] ao = new Short[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Short(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code int}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(int[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Integer[] ao = new Integer[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Integer(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code long}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(long[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Long[] ao = new Long[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Long(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code float}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(float[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Float[] ao = new Float[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Float(prmtv_array[i]);
		}

		return  ao;
	}
	/**
		<P>Get a {@code java.lang.Object} array from an array of {@code double}-s.</P>

		@return  If {@code prmtv_array} is<UL>
			<LI>{@code null}: {@code null}</LI>
			<LI>non-{@code null} and has no elements: <CODE>org.apache.commons.lang3.{@link org.apache.commons.lang3.ArrayUtils ArrayUtils}.{@link org.apache.commons.lang3.ArrayUtils#EMPTY_OBJECT_ARRAY EMPTY_OBJECT_ARRAY}</CODE></LI>
			<LI>Otherwise: A new {@code Object} array containing all elements in {@code prmtv_array}.</LI>
		</UL>
		@see  #get(boolean[], NullContainer, String) get(b[])
	 **/
	public static final Object[] get(double[] prmtv_array, NullContainer nnull, String cntrName_forNullBad)  {
		if(prmtv_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}

		if(prmtv_array.length == 0)  {
			return  ArrayUtils.EMPTY_OBJECT_ARRAY;
		}

		Double[] ao = new Double[prmtv_array.length];
		for(int i = 0; i < prmtv_array.length; i++)  {
			ao[i] = new Double(prmtv_array[i]);
		}

		return  ao;
	}
}