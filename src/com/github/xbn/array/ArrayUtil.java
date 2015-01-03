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
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  java.util.ArrayList;
   import  java.util.Arrays;
   import  java.util.List;
/**
   <p>Utilities related to non-primitive arrays, including error checking and conversion to other non-primitive containers.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ArrayUtil  {
   public static final StringBuilder[] asdEMPTY = new StringBuilder[0];
   /**
      <p>Same as <code>Arrays.toString</code>, with the addition of highlighting a single element.</p>

    * @return  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#appendToString(java.lang.StringBuilder, E[], java.lang.String, int, java.lang.String)">appendToString</a>(new StringBuilder(), array, prefix, index, postfix).toString()</code>
    */
   public static final <E> String toStringHighlightElement(E[] array, String prefix, int index, String postfix)  {
      return  appendToStringHighlightElement(new StringBuilder(), array, prefix, index, postfix).toString();
   }
   /**
      <p>Same as <code>{@link java.util.Arrays}.{@link java.util.Arrays#toString(Object[]) toString}</code>, with the addition of highlighting a single element.</p>

    * @param  to_appendTo May not be {@code null}.
    * @param  array  May not be {@code null}.
    * @param  prefix  Placed before the highlighted element. <i>Should</i> not be {@code null} or empty.
    * @param  index  The element to highlight. <i>Should</i> be a valid index.
    * @param  postfix  Placed after the highlighted element.
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#toStringHighlightElement(E[], java.lang.String, int, java.lang.String)">toStringHighlightElement</a></code>
    */
   public static final <E> StringBuilder appendToStringHighlightElement(StringBuilder to_appendTo, E[] array, String prefix, int index, String postfix)  {
      try  {
//			int lenMinus1 = array.length - 1;
         for(int i = 0; i < array.length; i++)  {
            if(i == index)  {
               to_appendTo.append(prefix);
            }
            to_appendTo.append(array[i]);
            if(i == index)  {
               to_appendTo.append(postfix);
            }
            if(i < array.length - 1)  {
               to_appendTo.append(", ");
            }
         }
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(to_appendTo, "to_appendTo", null);
         throw  CrashIfObject.nullOrReturnCause(array, "array", null, rx);
      }
      return  to_appendTo;
   }
   /**
      <p>Get the length of an array, or crash if it's {@code null}.</p>

    * @param  array  The array whose length is needed.
    * @param  array_name  Descriptive name of {@code coll}. <i>Should</i> be non-{@code null} and non-empty.
    * @return  {@code array.length}
    * @exception  NullPointerException  If {@code array} is {@code null}.
    */
   public static final <E> int getLengthCrashIfNull(E[] array, String array_name)  {
      try  {
         return  array.length;
      }  catch(RuntimeException rx)    {
         throw  CrashIfObject.nullOrReturnCause(array, array_name, null, rx);
      }
   }
   /**
      <p>Get a new non-primitive array, from another of a potentially different type.</p>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</a>(E[],vc,b,s)</code>
    */
   public static final <U,T> T[] getArrayCopyNewType(U[] original, Class<? extends T[]> new_type)  {
      if(original == null)  {
         return  null;
      }
      try  {
         return  Arrays.copyOf(original, original.length, new_type);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(new_type, "new_type", null, rx);
      }
   }
   /**
      <p>Get a new object array from a non-primitive array.</p>

    * @param  get_valCopy  If non-{@code null}, all elements are duplicated. When {@code null}, the original elements are referenced. When non-{@code null}, <code>get_valCopy.{@link com.github.xbn.util.copyval.ValueCopier#isValueCopyable() isValueCopyable}()</code> must be {@code true}.
    * @param  nnull  If non-{@code null}, {@code array} may not be {@code null}. This is the name of the function calling this one. It <i>should</i> not be empty.

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getStringListOrNull(E[], java.lang.String, java.lang.String)">getStringListOrNull</a>(E[],s,s)</code>
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getObjectListOrNull(E[], xbn.util.copyval.ValueCopier, java.lang.String, java.lang.String)">getObjectListOrNull</a>(E[],vc,s,s)</code>
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getListOrNull(E[], xbn.util.copyval.ValueCopier, java.lang.String, java.lang.String)">getListOrNull</a>(E[],vc,s,s)</code>
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getArrayCopyNewType(U[], java.lang.Class)">getArrayCopyNewType</a>(U[],cls)</code>
    */
   public static final <E> Object[] getObjectArrayOrNull(E[] array, ValueCopier<E> get_valCopy, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }

      if(get_valCopy == null)  {
         return  (Arrays.asList(array).toArray(new Object[array.length]));
      }

      Object[] ao = new Object[array.length];
      for(int i = 0; i < ao.length; i++)  {
         ao[i] = (Object)get_valCopy.getValueCopy(array[i], "array[i]");
      }
      return  ao;
   }

   /**
      <p>Get a new string array from a non-primitive array.</p>

    * @param  array  The array to convert.
    * @param  nnull  If {@code false}, then {@code array} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name for {@code array}. When {@code null_ok} is {@code true}, this is ignored.
    * @return  If {@code array} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>Non-{@code null}: A new string array containing each element's {@code toString()}, in the same order. If an element is {@code null}, it's corresponding element in the returned array is also {@code null}.</li>
      </ul>
    */
   public static final <E> String[] getStringArrayOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      String[] as = new String[array.length];
      for(int i = 0; i < array.length; i++)  {
         E e = array[i];
         as[i] = ((e == null) ? null : e.toString());
      }
      return  as;
   }
   /**
      <p>Get the middle index of a non-primitive array.</p>

    * @param  array  May not be {@code null}.
    * @return  <code>{@link com.github.xbn.array.IndexableUtil IndexableUtil}.{@link com.github.xbn.array.IndexableUtil#getMiddleIndex(int) getMiddleIndex}(array.length)</code>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getNonPArrayElementTSLengthIterator(E[])">getNonPArrayElementTSLengthIterator</a>(E[])</code>
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#forIsElementValid(R[], xbn.analyze.validate.ValueValidator)">forIsElementValid</a>(R[],vv)</code>
    */
   public static final <E> int getMiddleIndex(E[] array)  {
      try  {
         return  IndexableUtil.getMiddleIndex(array.length);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(array, "array", null, rx);
      }
   }
   /**
      <p>Get a string list from a non-primitive array.</p>

    * @param  array  The array to convert.
    * @param  nnull  If {@code false}, then {@code array} may not be {@code null}.
    * @param  cntrName_forNullBad  Descriptive name for {@code array}. When {@code null_ok} is {@code true}, this is ignored.
    * @return  If {@code array} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>Non-{@code null}: A new list of strings, containing every element's {@code toString()}, or {@code null} if it's {@code null}.</li>
      </ul>
    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</a>(E[],vc,b,s)</code>
    */
   public static final <E> List<String> getStringListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }

      ArrayList<String> vs = new ArrayList<String>(array.length);
      for(int i = 0; i < array.length; i++)  {
         E o = array[i];
         vs.add(((o == null) ? null : o.toString()));
      }
      return  vs;
   }
   /**
      <p>Get an object list from a non-primitive array.</p>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</a>(E[],vc,b,s)</code>
    */
   public static final <E> List<Object> getObjectListOrNull(E[] array, ValueCopier<E> get_valCopy, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }

      ArrayList<Object> vs = new ArrayList<Object>(array.length);
      if(get_valCopy == null)  {
         for(int i = 0; i < array.length; i++)  {
            vs.add((Object)array[i]);
         }
      }  else  {

         for(int i = 0; i < array.length; i++)  {
            vs.add((Object)get_valCopy.getValueCopy(array[i], "array[i]"));
         }
      }
      return  vs;
   }
   /**
      <p>Get a list of the element-type, from a non-primitive array.</p>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#getObjectArrayOrNull(E[], xbn.util.copyval.ValueCopier, boolean, java.lang.String)">getObjectArrayOrNull</a>(E[],vc,b,s)</code>
    */
   public static final <E> List<E> getListOrNull(E[] array, ValueCopier<E> get_valCopy, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      if(get_valCopy == null)  {
         return  Arrays.asList(array);
      }  else  {
         ArrayList<E> ve = new ArrayList<E>(array.length);

         for(int i = 0; i < array.length; i++)  {
            ve.add(get_valCopy.getValueCopy(array[i], "array[i]"));
         }

         return  ve;
      }
   }
   public static final <E> E getElementOrCrash(E[] array, int index, String array_name)  {
      try  {
         return  array[index];
      }  catch(ArrayIndexOutOfBoundsException abx)  {
         throw  new ArrayIndexOutOfBoundsException("index (" + index + ") invalid given " + array_name + ".length is " + array.length + ".");
      }
   }
   /*
      <p>Get a list containing a primitive array's elements, in its wrapper-type, or {@code null} if it's {@code null}.</p>

    * @param  nnull  If non-{@code null}, then {@code array} may not be {@code null}. This is used for the potential error message, and <i>should</i> not be empty.
    * @return  If {@code array} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}:
         <br> &nbsp; &nbsp; {@code Arrays.asList(array)}</li>
      </ul>
   public static final <E> List<E> getListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      return  Arrays.asList(array);
   }
    */
   /*
      <p>Get a {@code java.util.List&lt;Object&gt;} containing all elements from a primitive array.</p>

    * @param  nnull  If non-{@code null}, then {@code array} may not be {@code null}. This is used for the potential error message, and <i>should</i> not be empty.
    * @return  If {@code array} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: A new object-list, containing all elements from {@code array}</li>
      </ul>
   public static final <E> List<Object> getObjectListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      ArrayList<Object> vo = new ArrayList<Object>(array.length);
      for(int i = 0; i < array.length; i++)  {
         vo.add((Object)array[i]);
      }

      return  vo;
   }
    */
   /*
      <p>Get a {@code java.util.List&lt;String&gt;} containing all elements from a primitive array.</p>

    * @param  nnull  If non-{@code null}, then {@code array} may not be {@code null}. This is used for the potential error message, and <i>should</i> not be empty.
    * @return  If {@code array} is<ul>
         <li>{@code null}: {@code null}</li>
         <li>non-{@code null}: A new string-list, containing all elements from {@code array}</li>
      </ul>
   public static final <E> List<String> getStringListOrNull(E[] array, NullContainer nnull, String cntrName_forNullBad)  {
      if(array == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      ArrayList<String> vo = new ArrayList<String>(array.length);
      for(int i = 0; i < array.length; i++)  {
         E o = array[i];
         vo.add(((o == null) ? null : o.toString()));
      }
      return  vo;
   }
    */
   private ArrayUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
}
