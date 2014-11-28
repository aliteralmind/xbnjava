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
	import  com.github.xbn.array.NullContainer;
	import  com.github.xbn.array.IndexableUtil;
	import  java.util.Vector;
	import  com.github.xbn.util.copyval.NullHandler;
	import  com.github.xbn.util.copyval.ResettableNullHandler;
/**
	<P>Translate a wrapper array to an array of its primitives (such as {@code Integer[]} to {@code int[]}), with {@code null}-element management.</P>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class PrimitiveArrayFromWrapper  {
	@SuppressWarnings("unchecked")  //hnrrv works for all types
	private static final ResettableNullHandler hnrrv = new ResettableNullHandler(1);
	/**
		<P>This constructor does nothing.</P>
	 **/
	public PrimitiveArrayFromWrapper()  {
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

<!-- nwrqm input
forByte Byte byte
forCharacter Character char
get Double double
forFloat Float float
forLong Long long
forInteger Integer int
forShort Short short
forBoolean Boolean boolean

		Leave comments here, but in output, delete them:

			<P>This function is derived from {@code getPrimitiveB<!--  -->yte(B<!--  -->yte[], byte)}. <I>Do not edit any function except {@code getPrimitiveB<!--  -->yte(B<!--  -->yte[], byte)}.</I></P>
			__AT__ see  #getPrimitiveB<!--  -->yte(B<!--  -->yte[], byte)

		No comments. For master at-see list in forByte
		__AT__ see  #get(Byte[] wrapper_array, byte if_null)
 -->
		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Boolean[], boolean) get(B[],b)
		@see  #get(Character[], char) get(C[],c)
		@see  #get(Short[], short) get(H[],h)
		@see  #get(Integer[], int) get(I[],i)
		@see  #get(Long[], long) get(L[],l)
		@see  #get(Float[], float) get(F[],f)
		@see  #get(Double[], double) get(D[],d)
	 **/
	public static final byte[] get(Byte[] wrapper_array, byte if_null)  {
		byte[] ab = new byte[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Byte o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.byteValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final boolean[] get(Boolean[] wrapper_array, boolean if_null)  {
		boolean[] ab = new boolean[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Boolean o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.booleanValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final char[] get(Character[] wrapper_array, char if_null)  {
		char[] ab = new char[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Character o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.charValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final short[] get(Short[] wrapper_array, short if_null)  {
		short[] ab = new short[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Short o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.shortValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final int[] get(Integer[] wrapper_array, int if_null)  {
		int[] ab = new int[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Integer o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.intValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final long[] get(Long[] wrapper_array, long if_null)  {
		long[] ab = new long[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Long o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.longValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final float[] get(Float[] wrapper_array, float if_null)  {
		float[] ab = new float[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Float o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.floatValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from its wrapper-array, or {@code null} if it's {@code null}.</P>

		<P>This function is derived from {@code get(Byte[], byte)}. <I>Do not edit any function except {@code get(Byte[], byte)}.</I></P>

		@return  {@code null} If {@code wrapper_array} is {@code null}. Otherwise, an array containing all values in {@code wrapper_array}. {@code null} elements are replaced with {@code if_null}.
		@see  #get(Byte[], byte)
	 **/
	public static final double[] get(Double[] wrapper_array, double if_null)  {
		double[] ab = new double[wrapper_array.length];
		for(int i = 0; i < wrapper_array.length; i++)  {
			Double o = wrapper_array[i];
			ab[i] = ((o == null) ? if_null : o.doubleValue());
		}
		return  ab;
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Character[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Character&gt;(if_null)))</CODE>
	 **/
	public static final char[] get(Character[] wrapper_array, char if_null, NullContainer nnull, String cntrName_forNullBad)  {
		@SuppressWarnings("unchecked")
		char[] ac = get(wrapper_array, (NullHandler<Character>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
		return  ac;
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Boolean[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Boolean&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final boolean[] get(Boolean[] wrapper_array, boolean if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Boolean>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Byte[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Byte&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final byte[] get(Byte[] wrapper_array, byte if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Byte>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Short[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Short&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final short[] get(Short[] wrapper_array, short if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Short>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Integer[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Integer&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final int[] get(Integer[] wrapper_array, int if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Integer>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Long[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Long&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final long[] get(Long[] wrapper_array, long if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Long>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Float[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Float&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final float[] get(Float[] wrapper_array, float if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Float>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@return  The equivalent of
		<BR> &nbsp; &nbsp; <CODE>{@link #get(Double[], NullHandler, NullContainer, String) get}(wrapper_array, (new ResettableNullHandler&lt;Double&gt;(if_null)))</CODE>
	 **/
	@SuppressWarnings("unchecked")
	public static final double[] get(Double[] wrapper_array, double if_null, NullContainer nnull, String cntrName_forNullBad)  {
		return  get(wrapper_array, (NullHandler<Double>)hnrrv.nonNullValue(if_null), nnull, cntrName_forNullBad);
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

<!--
---nwrqm input for
	get(C[],c)
	get(C[],hnv)

Character wrapper_array char
Double wrapper_array double
Float wrapper_array float
Long wrapper_array long
Integer wrapper_array int
Short wrapper_array short
Byte wrapper_array byte
Boolean wrapper_array boolean

Use this see link, and change Char to Char when done. (NOT IN THIS HTML COMMENT THOUGH!!!)
		@see  #get(Character[], char, NullContainer, String) get(C[],c)
		&#64;see #get(Character[], NullHandler, NullContainer, String) get(C[],hnv)

 -->
		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
	 **/
	@SuppressWarnings("unchecked")
	public static final char[] get(Character[] wrapper_array, NullHandler<Character> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Character> vc = new Vector<Character>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Character o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forCharacterCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			char[] ac = new char[iSz];
			for(int i = 0; i < iSz; i++)  {
				Character o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			char[] ac = new char[iSz];
			Character oNNull = null;
			oNNull = (Character)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Character o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Double[], double, NullContainer, String) get(D[],d)
		@see  #get(Character[], NullHandler, NullContainer, String) get(C[],hnv)
	 **/
	@SuppressWarnings("unchecked")
	public static final double[] get(Double[] wrapper_array, NullHandler<Double> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Double> vc = new Vector<Double>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Double o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forDoubleCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			double[] ac = new double[iSz];
			for(int i = 0; i < iSz; i++)  {
				Double o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			double[] ac = new double[iSz];
			Double oNNull = null;
			oNNull = (Double)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Double o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Float[], float, NullContainer, String) get(F[],f)
		@see  #get(Character[], NullHandler, NullContainer, String) get(C[],hnv,s,s)
	 **/
	@SuppressWarnings("unchecked")
	public static final float[] get(Float[] wrapper_array, NullHandler<Float> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Float> vc = new Vector<Float>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Float o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forFloatCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			float[] ac = new float[iSz];
			for(int i = 0; i < iSz; i++)  {
				Float o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			float[] ac = new float[iSz];
			Float oNNull = null;
			oNNull = (Float)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Float o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Long[], long, NullContainer, String) get(L[],l)
		@see  #get(Character[], NullHandler, NullContainer, String) get(C[],hnv,s,s)
	 **/
	@SuppressWarnings("unchecked")
	public static final long[] get(Long[] wrapper_array, NullHandler<Long> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Long> vc = new Vector<Long>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Long o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forLongCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			long[] ac = new long[iSz];
			for(int i = 0; i < iSz; i++)  {
				Long o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			long[] ac = new long[iSz];
			Long oNNull = null;
			oNNull = (Long)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Long o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Integer[], int, NullContainer, String) get(I[],i)
		@see  #get(Character[], NullHandler, NullContainer, String) get(C[],hnv,s,s)
	 **/
	@SuppressWarnings("unchecked")
	public static final int[] get(Integer[] wrapper_array, NullHandler<Integer> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Integer> vc = new Vector<Integer>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Integer o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forIntegerCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			int[] ac = new int[iSz];
			for(int i = 0; i < iSz; i++)  {
				Integer o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			int[] ac = new int[iSz];
			Integer oNNull = null;
			oNNull = (Integer)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Integer o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Short[], short, NullContainer, String) get(H[],h)
		@see  #get(Short[], NullHandler, NullContainer, String) get(H[],hnv,s,s)
	 **/
	@SuppressWarnings("unchecked")
	public static final short[] get(Short[] wrapper_array, NullHandler<Short> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Short> vc = new Vector<Short>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Short o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forShortCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			short[] ac = new short[iSz];
			for(int i = 0; i < iSz; i++)  {
				Short o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			short[] ac = new short[iSz];
			Short oNNull = null;
			oNNull = (Short)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Short o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Byte[], byte, NullContainer, String) get(Y[],y)
		@see  #get(Byte[], NullHandler, NullContainer, String) get(Y[],hnv,s,s)
	 **/
	@SuppressWarnings("unchecked")
	public static final byte[] get(Byte[] wrapper_array, NullHandler<Byte> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Byte> vc = new Vector<Byte>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Byte o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forByteCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			byte[] ac = new byte[iSz];
			for(int i = 0; i < iSz; i++)  {
				Byte o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			byte[] ac = new byte[iSz];
			Byte oNNull = null;
			oNNull = (Byte)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Byte o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}
	/**
		<P>Get a primitive array from an non-primitive array of its wrapper-type.</P>

		@param  wrapper_array  The wrapper array.
		@param  null_handler  Defines how {@code null} values are handled. May not be {@code null}.
		@see  #get(Boolean[], boolean, NullContainer, String) get(B[],b)
		@see  #get(Boolean[], NullHandler, NullContainer, String) get(H[],hnv,s,s)
	 **/
	@SuppressWarnings("unchecked")
	public static final boolean[] get(Boolean[] wrapper_array, NullHandler<Boolean> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
		if(wrapper_array == null)  {
			IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
			return  null;
		}
		int iSz = wrapper_array.length;

		if(null_handler.getAction().doDelete())  {
			                        //Assume 50% kept (div by two)
			Vector<Boolean> vc = new Vector<Boolean>(iSz >>> 2);
			for(int i = 0; i < iSz; i++)  {
				Boolean o = wrapper_array[i];
				if(o != null)  {
					vc.add(o);
				}
			}
			return  PrimitiveArrayFromCollection.forBooleanCrashIfNullElement(vc);
		}  else if(null_handler.getAction().doCrash())  {
			boolean[] ac = new boolean[iSz];
			for(int i = 0; i < iSz; i++)  {
				Boolean o = wrapper_array[i];
				if(o == null)  {
					throw  new NullPointerException("wrapper_array[" + i + "] is null, and null_handler.doCrash() is true.");
				}
				ac[i] = o;
			}
			return  ac;
		}  else  {
			boolean[] ac = new boolean[iSz];
			Boolean oNNull = null;
			oNNull = (Boolean)null_handler.getNonNull();
			for(int i = 0; i < iSz; i++)  {
				Boolean o = wrapper_array[i];
				ac[i] = ((o == null) ? oNNull : o);
			}
			return  ac;
		}
	}


}
