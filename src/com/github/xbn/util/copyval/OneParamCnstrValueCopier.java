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
package  com.github.xbn.util.copyval;
   import  java.lang.reflect.InvocationTargetException;
/**
   <p>Duplicates the original value by passing it to the <i>one-parameter</i> constructor of the same type, via reflection--such as {@code (new Integer(<i>original-integer</i>))}</p>

   <p>The idea for this comes from
   <br/> &nbsp; &nbsp; {@code <a href="http://stackoverflow.com/questions/6094575/creating-an-instance-using-the-class-name-and-calling-constructor">http://stackoverflow.com/questions/6094575/creating-an-instance-using-the-class-name-and-calling-constructor</a>}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class OneParamCnstrValueCopier<O> extends AbstractValueCopier<O>  {
   private Class<O> cls = null;
   public static final OneParamCnstrValueCopier<StringBuilder> STRING_BUILDER = new OneParamCnstrValueCopier<StringBuilder>(StringBuilder.class);
   public static final OneParamCnstrValueCopier<String> STRING = new OneParamCnstrValueCopier<String>(String.class);
   public static final OneParamCnstrValueCopier<Boolean> BOOLEAN = new OneParamCnstrValueCopier<Boolean>(Boolean.class);
   public static final OneParamCnstrValueCopier<Character> CHAR = new OneParamCnstrValueCopier<Character>(Character.class);
   public static final OneParamCnstrValueCopier<Byte> BYTE = new OneParamCnstrValueCopier<Byte>(Byte.class);
   public static final OneParamCnstrValueCopier<Short> SHORT = new OneParamCnstrValueCopier<Short>(Short.class);
   public static final OneParamCnstrValueCopier<Integer> INT = new OneParamCnstrValueCopier<Integer>(Integer.class);
   public static final OneParamCnstrValueCopier<Long> LONG = new OneParamCnstrValueCopier<Long>(Long.class);
   public static final OneParamCnstrValueCopier<Float> FLOAT = new OneParamCnstrValueCopier<Float>(Float.class);
   public static final OneParamCnstrValueCopier<Double> DOUBLE = new OneParamCnstrValueCopier<Double>(Double.class);
//internal
   /**
      <p>Create a new {@code OneParamCnstrValueCopier}.</p>

      @param  cls  The class of type {@code O} (if {@code O} is {@code java.lang.Integer}, this should be {@code Integer.class}). May not be {@code null} and must be a type that has a constructor of {@code new TYPE(TYPE original_value)} (such as {@code new Integer(Integer I_original)}). Get with {@link #getClass() getEClass}{@code ()}.

      @see  #OneParamCnstrValueCopier(OneParamCnstrValueCopier) this
    **/
   public OneParamCnstrValueCopier(Class<O> cls)  {
      super(true);
      if(cls == null)  {
         throw  new NullPointerException("cls");
      }
      this.cls = cls;
   }
   /**
      <p>Create a new {@code OneParamCnstrValueCopier} as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.util.copyval.AbstractValueCopier#AbstractValueCopier(AbstractValueCopier) super}{@code (to_copy)}</li>
         <li>YYY</li>
      </ol></p>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #OneParamCnstrValueCopier(Class) this(cls)
    **/
   public OneParamCnstrValueCopier(OneParamCnstrValueCopier<O> to_copy)  {
      super(to_copy);
      cls = to_copy.getEClass();
   }
   /**
      @see  #OneParamCnstrValueCopier(Class) this(cls)
    **/
   public Class<O> getEClass()  {
      return  cls;
   }
   /**
      @return  {@link #getEClass() getEClass}{@code ().getConstructor(getEClass()).newInstance}{@code (new Object[] { original_value })}
      <br/>(&quot;newInstance() is a varargs method (just as GetConstructor()), there's no need for explicit Object-array creation. &quot;–  Joachim Sauer May 23 '11 at 8:28
      <br/>&quot;@Joachim: I know it's varargs, but as it can get tricky when you have an Object[] argument, I prefer to create the array explicitly in this case.&quot; –  Jon Skeet May 23 '11 at 8:32)</i>
      @exception  InvocationTargetException  If getEClass is not a type that has a constructor like {@code new TYPE(TYPE original_value)} (such as {@code new Integer(Integer I_original)}).
    **/
   protected O getCopyOfNonNullOrig(O non_nullOrig, String orig_name)  {
      Throwable tbl;
      try  {
         return  getEClass().getConstructor(getEClass()).newInstance(new Object[] { non_nullOrig });
      }  catch(InstantiationException ix)  {
         tbl = ix;
      }  catch(InvocationTargetException itx)  {
         tbl = itx;
      }  catch(NoSuchMethodException nsmx)  {
         tbl = nsmx;
      }  catch(IllegalAccessException icx)  {
         tbl = icx;
      }  catch(RuntimeException rx)  {
         tbl = rx;
      }
      throw  new RuntimeException("Attempting getEClass().getConstructor(getEClass()).newInstance(new Object[] { non_nullOrig }), getEClass().getName()=" + getEClass().getName(), tbl);
   }
   /**
      <p>Get a complete copy of this {@code OneParamCnstrValueCopier}.</p>

      @return  <code>(new {@link #OneParamCnstrValueCopier(OneParamCnstrValueCopier) OneParamCnstrValueCopier}&lt;O&gt;(this))</code>.
    **/
   public ValueCopier<O> getObjectCopy()  {
      return  (new OneParamCnstrValueCopier<O>(this));
   }
}

