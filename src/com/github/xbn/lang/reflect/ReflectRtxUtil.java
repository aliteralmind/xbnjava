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
package  com.github.xbn.lang.reflect;
   import  com.github.xbn.io.NewTextAppenterFor;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.RTExceptionInInitializerError;
   import  com.github.xbn.lang.RTIllegalAccessException;
   import  com.github.xbn.lang.RTInstantiationException;
   import  com.github.xbn.text.CrashIfString;
   import  java.lang.reflect.Constructor;
   import  java.lang.reflect.Field;
   import  java.lang.reflect.Method;
   import  java.util.ArrayList;
   import  java.util.List;
   import  java.util.Objects;
   import  static com.github.xbn.lang.CrashIfBase.*;
/**
   <p>Reflection-related utilities with runtime errors only. The original exception is accessible via {@code getCause()}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ReflectRtxUtil   {
   /**
      <p>Is one class assignable from another?.</p>

      @param  class_forPreDot  May not be {@code null}.
      @param  class_forParam  May not be {@code null}.
      @return  <code>class_forPreDot.{@link java.lang.Class#isAssignableFrom(Class) isAssignableFrom}(class_forParam)</code>
      @see  #crashIfNotAssignableFrom(Class, Class) crashIfNotAssignableFrom(c,c)
    **/
   public static final boolean isClassAssignableFrom(Class<?> class_forPreDot, Class<?> class_forParam)  {
      try  {
         return  class_forPreDot.isAssignableFrom(class_forParam);
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(class_forPreDot, "class_forPreDot");
         throw  CrashIfObject.nullOrReturnCause(class_forParam, "class_forParam", null, rx);
      }
   }
   /**
      <p>If one class is not assignable from another, crash. Otherwise, do nothing.</p>

      @exception  ClassCastException  If
      <br/> &nbsp; &nbsp; <code>{@link #isClassAssignableFrom(Class, Class) isClassAssignableFrom}(class_forPreDot, class_forParam)</code>
      <br/>is {@code false}
    **/
   public static final void crashIfNotAssignableFrom(Class<?> class_forPreDot, Class<?> class_forParam)  {
      if(!isClassAssignableFrom(class_forPreDot, class_forParam))  {
         throw  new ClassCastException("class_forPreDot expected to be of type " + class_forParam + ". class_forPreDot.getName()=\"" + class_forPreDot.getName() + "\"");
      }
   }
   /**
      <p>Invoke a non-{@code void} method, and get any {@code RuntimeException} thrown from it. If no exception is thrown, this returns {@code null}.</p>

      @param  obj_methodInvokedFrom  If non-{@code null}, the method is being invoked from this class. If {@code null}, the method must be static.
      @param  method  May not be {@code null}.
      @param  param_objArr  May not be {@code null}.
      @return  <code>method.{@link java.lang.reflect.Method#invoke(Object, Object...) invoke}(obj_methodInvokedFrom, param_objArr)</code>
      @exception  RuntimeException  If any error occurs. The original exception is accessible with {@link java.lang.RuntimeException#getCause() getCause}{@code ()}.
      @see  #invokeVoidMethodGetRtx(Object, Method, Object, Object...) invokeVoidMethodGetRtx
      @see  InvokeMethodWithRtx
    **/
   public static final Object invokeMethodWithRtxGetReturnValue(Object obj_methodInvokedFrom, Method method, Object xtra_errInfo, Object... param_objArr)  {
      Throwable tbl = null;
      try  {
         return  method.invoke(obj_methodInvokedFrom, param_objArr);
      }  catch(Exception x)  {
         Objects.requireNonNull(method, "method");
         tbl = x;
      }

      throw  newRtxForInvokeAttemptOrNullIfNullThrbl(obj_methodInvokedFrom, method, xtra_errInfo, tbl);
   }
      private static final RuntimeException newRtxForInvokeAttemptOrNullIfNullThrbl(Object obj_methodInvokedFrom, Method method, Object xtra_errInfo, Throwable cause)  {

         if(cause == null)  {
            return  null;
         }

         String sClsNm = getClassNameWithNullDefault("from object ", obj_methodInvokedFrom, null, "(the class from which the method is invoked is null, meaning the method is supposed to be static)");
         return  new RuntimeException(getXMsg("Attempting to invoke " +
            ((method == null)
               ?  "[method is null]"
               :  method.getName()) +
            " " + sClsNm, xtra_errInfo),
            cause);
      }
   /**
      <p>If a fully qualified name represents an actually-existing Java class, get its class object.</p>

      @return  <code>{@link #getClassIfExistsOrNull(String, Class) getClassIfExistsOrNull}(fully_qualifiedName, null)</code>
    **/
   public static final Class<?> getClassIfExistsOrNull(String fully_qualifiedName)  {
      return  getClassIfExistsOrNull(fully_qualifiedName, null);
   }
   /**
      <p>If a fully qualified name represents an actually-existing Java class, get its class object and optionally verify that it's assingable from a specific type. If the class doesn't exist, this returns {@code null}.</p>

      <p><i>This uses a {@code ClassNotFoundException} as its {@code false} logic. <a href="http://stackoverflow.com/questions/19809640/check-if-class-exists-without-running-into-classnotfoundexception">It seems not</a>.</i></p>

      @param  fully_qualifiedName  <i>Should</i> not be {@code null} or empty.
      @param  rqdType_ifNonNull  If non-{@code null}, this is the type the class must be {@linkplain java.lang.Class#isAssignableFrom(Class) assignable from}.
      @see  #getClassIfExistsOrNull(String)
      @exception  ClassCastException  if {@code rqdType_ifNonNull} is non-{@code null} and the class is not assignable from it.
    **/
   public static final <O> Class<O> getClassIfExistsOrNull(String fully_qualifiedName, Class<O> rqdType_ifNonNull)  {
      Class<O> cls = null;

      try  {
         @SuppressWarnings("unchecked")
         Class<O> cls2 = (Class<O>)Class.forName(fully_qualifiedName);
         cls = cls2;

      }  catch(ClassNotFoundException cnfx)  {
         //Class does not exist.

         //Exception for "false" logic  :(  Is there a non-exception way?
         return  null;
      }

      if(rqdType_ifNonNull != null)  {
         crashIfNotAssignableFrom(rqdType_ifNonNull, cls);
      }

      return  cls;
   }
   /**
      <p>Call a void function and get the exception thrown from it <i>which is wrapped in a {@code RuntimeException}</i>. If no exception is thrown, this returns {@code null}.</p>

      <p>This calls
      <br/> &nbsp; &nbsp; <code>method.{@link java.lang.reflect.Method#invoke(Object, Object...) invoke}(obj_methodInvokedFrom, dddo_params)</code></p>

      @param  obj_methodInvokedFrom  The object the underlying method is invoked from. If the method is {@code static}, set this to {@code null}.
      @param  method  May not be {@code null}.
      @return  <b>{@code null}</b> If the function returned normally. Otherwise, a <b>{@code RuntimeException}</b> whose {@code getCause()} contains the original exception.
      @see  #invokeMethodWithRtxGetReturnValue(Object, Method, Object, Object...) invokeMethodWithRtxGetReturnValue(o,m,o,o...)
      @see  InvokeMethodWithRtx
    **/
   public static final RuntimeException invokeVoidMethodGetRtx(Object obj_methodInvokedFrom, Method method, Object xtra_errInfo, Object... dddo_params)  {
      Throwable tbl = null;
      try  {
         method.invoke(obj_methodInvokedFrom, (Object[])dddo_params);
      }  catch(Exception x)  {
         Objects.requireNonNull(method, "method");
         tbl = x;
      }

      return  newRtxForInvokeAttemptOrNullIfNullThrbl(obj_methodInvokedFrom, method, xtra_errInfo, tbl);
   }
   /**
      <p>Get an object`s class-name with a prefix and postfix string, and an if-null default.</p>

      @param  prefix  If non-{@code null}, this precedes the class-name. If {@code null}, nothing precedes it. When {@code object} is {@code null}, this and {@code postfix} are ignored.
      @param  object  The object whose class-name is needed.
      @param  postfix  If non-{@code null}, this follows the class-name. If {@code null}, nothing follows it.
      @param  if_nonNull  What to return if {@code object} is {@code null}.
      @return  If {@code object} is<ul>
         <li>{@code null}: {@code if_nonNull}</li>
         <li>non-{@code null}: <code>prefix + object.{@link java.lang.Object#getClass getClass}().{@link java.lang.Class#getName() getName}() + prefix</code></li>
      </ul>
    **/
   private static final String getClassNameWithNullDefault(String prefix, Object object, String postfix, String if_nonNull)  {
      if(object == null)  {
         return  ((if_nonNull == null) ? "" : if_nonNull);
      }
      return
         ((prefix == null) ? "" : prefix) +
         object.getClass().getName() +
         ((postfix == null) ? "" : postfix);
   }
   /**
      <p>Get a new instance of a class from its no-parameter constructor, given its fully-qualified name.</p>

      @param  class_name  May not be {@code null}, and must represent an existing class, and one that has a publicly accessible zero-parameter constructor.
      @param  rqdType_ifNonNull  If non-{@code null}, this is the type that {@code class_name} must be {@linkplain java.lang.Class#isAssignableFrom(Class) assignable from}.
      @param  debugDest_ifNonNull  If non-{@code null}, debugging output is printed. Using this <i>should</i> not result in any errors.
      @exception  RTClassNotFoundException  If {@code class_name} is non-{@code null}, non-empty, but does not represent an actually-existing class.
      @exception  ClassCastException  if {@code rqdType_ifNonNull} is non-{@code null} and the class is not assignable from it.
    **/
   public static final <O> O getNewInstanceFromNoParamCnstr(String class_name, Class<O> rqdType_ifNonNull, Appendable debugDest_ifNonNull)  {
      TextAppenter dbgAptr = NewTextAppenterFor.appendableUnusableIfNull(debugDest_ifNonNull);
      if(dbgAptr.isUseable())  {
         dbgAptr.appentln("      Checking class (class_name=\"" + class_name + "\") exists and is of the rqdType_ifNonNull (" + rqdType_ifNonNull.getName() + ")...");
      }

      Class<O> oClass = ReflectRtxUtil.<O>getClassIfExistsOrNull(class_name, rqdType_ifNonNull);

      if(oClass == null)  {
         throw  new RTClassNotFoundException("class_name=\"" + class_name + "\"");
      }

      if(dbgAptr.isUseable())  {
         dbgAptr.appentln("      ...success. Instantiating...");
      }

      O oInstance = null;
      try  {
         oInstance = oClass.newInstance();
      }  catch(ExceptionInInitializerError xir)  {
         throw  new RTExceptionInInitializerError("class_name=\"" + class_name + "\"", xir);
      }  catch(InstantiationException ix)  {
         throw  new RTInstantiationException("class_name=\"" + class_name + "\"", ix);
      }  catch(IllegalAccessException icx)  {
         throw  new RTIllegalAccessException("class_name=\"" + class_name + "\"", icx);
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("Attempting to instantiate the class (class_name=" + class_name + ") with its no-parameter constructor. oInstance=" + oInstance, rx);
      }

      if(dbgAptr.isUseable())  {
         dbgAptr.appentln("      ...success");
      }

      return  oInstance;
   }
   /*

   public static final RuntimeException invokeMainMethodGetRtx(Object obj_withMain, Object xtra_errInfo, String... command_lineParams)  {
      Class<?> cls = null;
      try  {
         cls = obj_withMain.getClass();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(obj_withMain, "obj_withMain", null, rx);
      }
      return  invokeMainMethodGetRtx(cls, xtra_errInfo, command_lineParams);
   }
   public static final RuntimeException invokeMainMethodGetRtx(String fq_className, Object xtra_errInfo, String... command_lineParams)  {
      Method m = getDeclaredMethod(fq_className, &quot;main&quot;, xtra_errInfo, String[].class);
      return  invokeVoidMethodGetRtx(null, m, xtra_errInfo, (Object)command_lineParams);
   }
   public static final RuntimeException invokeMainMethodGetRtx(Class cls_withMain, Object xtra_errInfo, String... command_lineParams)  {
      Method m = getDeclaredMethod(cls_withMain, xtra_errInfo, String[].class);
      return  invokeVoidMethodGetRtx(null, m, xtra_errInfo, (Object)command_lineParams);
   }
    */
   /**
      <p>Get a method for a class whose fully-qualified name is provided.</p>

      <p>This<ol>
         <li>Gets the object's <code>Class</code> with
         <br/> &nbsp; &nbsp; <code>{@link #getClassForName(String, String) getClassForName}(fq_className, &quot;fq_className&quot;)</code></li>
         <li><i><b>Returns</b></i>
         <br/> &nbsp; &nbsp; <code>{@link #getMethod(Class, String, Declared, Object, Class...) getMethod}(<i>[that class]</i>, method_name, declared, xtra_errInfo, param_types)</code></li>
      </ol></p>
    **/
   public static final Method getMethodForClassName(String fq_className, String method_name, Declared declared, Object xtra_errInfo, Class... param_types)  {
      Class <?> cls = getClassForName(fq_className, "fq_className");
      return  getMethod(cls, method_name, declared, xtra_errInfo, param_types);
   }

   /**
      <p>Get an object's class, or crash if it's {@code null}.</p>

      @param  fq_className  The fully-qualified name of the class. Must be non-{@code null} and valid.
      @see  #getClass(Object, Object) getClass(o,o)
      @exception  RTClassNotFoundException  If a {@link java.lang.ClassNotFoundException ClassNotFoundException} is thrown.
    **/
   public static final Class getClassForName(String fq_className, String fqcn_varName)  {
      try  {
         return  Class.forName(fq_className);
      }  catch(ClassNotFoundException cnfx)  {
         throw  new RTClassNotFoundException("Unknown class name (is it compiled?): " + fqcn_varName + "=\"" + fq_className + "\"");
      }  catch(Exception x)  {
         CrashIfString.nullEmpty(fq_className, fq_className, null);
         throw  new RuntimeException("Attempting Class.forName(" + fqcn_varName + "), " + fqcn_varName + "=\"" + fq_className + "\"", x);
      }
   }
   /**
      <p>Get an object's class, or crash if it's {@code null}.</p>

      @param  object  May not be {@code null}.
      @see  #getClassForName(String, String) getClass(s,s)
    **/
   public static final Class getClass(Object object, Object xtra_errInfo)  {
      try  {
         return  object.getClass();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(object, "object", null, rx);
      }
   }
   /**
      <p>Get a constructor from its object.</p>

      @param  obj_withConstructor  May not be {@code null}.
      @return  <code>{@link #getConstructor(Class, Declared, Object, Class...) getConstructor}(obj_withConstructor.{@link java.lang.Object#getClass() getClass}(), declared, xtra_errInfo, param_types)</code>
    **/
   public static final Constructor getConstructor(Object obj_withConstructor, Declared declared, Object xtra_errInfo, Class<?>... param_types)  {
      try  {
         return  getConstructor(obj_withConstructor.getClass(), declared, xtra_errInfo, param_types);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(obj_withConstructor, "obj_withConstructor", null, rx);
      }
   }
   /**
      <p>Get a constructor from its class.</p>

      @param  containing_class  May not be {@code null}
      @return  If {@code declared} is<ul>
         <li>{@link com.github.xbn.lang.reflect.Declared#YES YES}: <code>containing_class.{@link java.lang.Class#getDeclaredConstructor(Class...) getDeclaredConstructor}(param_types)</code></li>
         <li>{@link com.github.xbn.lang.reflect.Declared#NO NO}: <code>containing_class.{@link java.lang.Class#getConstructor(Class...) getConstructor}(param_types)</code></li>
      </ul>
      @exception  RTNoSuchMethodException  If a {@link java.lang.NoSuchMethodException} is thrown.
      @exception  RuntimeException  If any error occurs. The original exception is accessible with {@link java.lang.RuntimeException#getCause() getCause}{@code ()}.
      @see  #getConstructor(Object, Declared, Object, Class...) getConstructor
    **/
   public static final Constructor getConstructor(Class<?> containing_class, Declared declared, Object xtra_errInfo, Class<?>... param_types)  {
      try  {
         return  ((declared.isNo())
            ?  containing_class.getConstructor(param_types)
            :  containing_class.getDeclaredConstructor(param_types));
      }  catch(NoSuchMethodException nsmx)  {
         throw  new RTNoSuchMethodException("containing_class=" + containing_class.getName() + ", param_types=(" + getClassNames(null, param_types, null, ", ") + ")", nsmx);
      }  catch(Exception x)  {
         CrashIfObject.nnull(declared, "declared", null);
         CrashIfString.nullEmpty(containing_class, "containing_class", xtra_errInfo);
         throw  new RuntimeException(getXMsg("Attempting containing_class.get" +
            (declared.isYes() ? "Declared" : "") +
            "Constructor(param_types), containing_class=" + containing_class.getName() + ", param_types=(" + getClassNames(null, param_types, null, ", ") + ")", xtra_errInfo), x);
      }
   }
   /**
      <p>Get a method from its containing object.</p>

      @param  obj_withMethod  May not be {@code null}.
      @return  <code>{@link #getMethod(Class, String, Declared, Object, Class...) getMethod}(obj_withMethod.{@link java.lang.Object#getClass() getClass}(), method_name, xtra_errInfo, param_types)</code>
    **/
   public static final Method getMethod(Object obj_withMethod, String method_name, Declared declared, Object xtra_errInfo, Class<?>... param_types)  {
      try  {
         return  getMethod(obj_withMethod.getClass(), method_name, declared, xtra_errInfo, param_types);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(obj_withMethod, "obj_withMethod", null, rx);
      }
   }
   /**
      <p>Get a method from its containing class.</p>

      @param  containing_class  May not be {@code null}
      @return  If {@code declared} is<ul>
         <li>{@link com.github.xbn.lang.reflect.Declared#YES YES}: <code>containing_class.{@link java.lang.Class#getDeclaredMethod(String, Class...) getDeclaredMethod}(method_name, param_types)</code></li>
         <li>{@link com.github.xbn.lang.reflect.Declared#NO NO}: <code>containing_class.{@link java.lang.Class#getMethod(String, Class...) getMethod}(method_name, param_types)</code></li>
      </ul>
      @exception  RTNoSuchMethodException  If a {@link java.lang.NoSuchMethodException} is thrown.
      @exception  RuntimeException  If any error occurs. The original exception is accessible with {@link java.lang.RuntimeException#getCause() getCause}{@code ()}.
      @see  #getMethod(Object, String, Declared, Object, Class...) getMethod(Object, *)
      @see  #getMethodForClassName(String, String, Declared, Object, Class...) getMethodForClassName
    **/
   public static final Method getMethod(Class<?> containing_class, String method_name, Declared declared, Object xtra_errInfo, Class<?>... param_types)  {
      try  {
         return  ((declared.isNo())
            ?  containing_class.getMethod(method_name, param_types)
            :  containing_class.getDeclaredMethod(method_name, param_types));
      }  catch(NoSuchMethodException nsmx)  {
         throw  new RTNoSuchMethodException("containing_class=" + containing_class.getName() + ", param_types=(" + getClassNames(null, param_types, null, ", ") + ")", nsmx);
      }  catch(Exception x)  {
         CrashIfObject.nnull(declared, "declared", null);
         CrashIfString.nullEmpty(containing_class, "containing_class", xtra_errInfo);
         throw  new RuntimeException(getXMsg("Attempting containing_class.get" +
            (declared.isYes() ? "Declared" : "") +
            "Method(method_name, param_types), containing_class=" + containing_class.getName() + ", method_name=\"" + method_name + "\", param_types=(" + getClassNames(null, param_types, null, ", ") + ")", xtra_errInfo), x);
      }
   }
   public static final Field getField(Class<?> containing_class, String field_name, Declared declared, Object xtra_errInfo)  {
      try  {
         return  (declared.isYes()
            ?  containing_class.getDeclaredField(field_name)
            :  containing_class.getField(field_name));
      }  catch(NoSuchFieldException | SecurityException x)  {
         throw  new RTNoSuchFieldException(getXMsg("containing_class:" + containing_class.getName() + ", field_name=\"" + field_name + "\"", xtra_errInfo));
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(containing_class, "containing_class", xtra_errInfo);
         CrashIfObject.nnull(declared, "declared", xtra_errInfo);
         throw  CrashIfObject.nullOrReturnCause(field_name, "field_name", xtra_errInfo, rx);
      }
   }
   /**
      <p>Get a list of {@code Class}es, for each object in an array, as required when obtaining a method.</p>

      @param  objects  May not be {@code null}, and no element may be {@code null}.
      @see  #getMethod(Class, String, Declared, Object, Class...)
    **/
   public static final List<Class<?>> getClassListFromObjects(Object[] objects)  {
      List<Class<?>> classList = null;
      try  {
         classList = new ArrayList<Class<?>>(objects.length);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(objects, "objects", null, rx);
      }
      for(int i = 0; i < objects.length; i++)  {
         Object o = objects[i];
         try  {
            classList.add(o.getClass());
         }  catch(RuntimeException rx)  {
            throw  new NullPointerException("objects[" + i + "]");
         }
      }
      return  classList;
   }
   /**
      <p>Get a list of {@code Class}es, for each object in a list, as required when obtaining a method.</p>

      @param  objectList  May not be {@code null}, and no element may be {@code null}.
      @see  #getMethod(Class, String, Declared, Object, Class...)
    **/
   public static final List<Class<?>> getClassListFromObjects(List<?> objectList)  {
      List<Class<?>> classList = null;
      try  {
         classList = new ArrayList<Class<?>>(objectList.size());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(objectList, "objectList", null, rx);
      }
      for(int i = 0; i < objectList.size(); i++)  {
         Object o = objectList.get(i);
         try  {
            classList.add(o.getClass());
         }  catch(RuntimeException rx)  {
            throw  new NullPointerException("objectList[" + i + "]");
         }
      }
      return  classList;
   }
   public static final <O> Class<?>[] getClassArrayFromObjects(O[] array)  {
      Class<?>[] classes = null;
      try  {
         classes = new Class<?>[array.length];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(array, "array", null, rx);
      }
      for(int i = 0; i < array.length; i++)  {
         classes[i] = array[i].getClass();
      }
      return  classes;
   }
   public static final String getClassNames(String element_prefix, Class<?>[] classes, String element_postfix, String separator)  {
      return  appendClassNames((new StringBuilder()), element_prefix, classes, element_postfix, separator).toString();
   }
   /**
      <p>YYY</p>

      @see  java.lang.Class#getName()
      @see  com.github.aliteralmind.codelet.util.JavaDocUtil#appendClassNameForParams(StringBuilder, Class[], VarArgs)
    **/
   public static final StringBuilder appendClassNames(StringBuilder to_appendTo, String element_prefix, Class<?>[] classes, String element_postfix, String separator)  {
      if(classes == null)  {
         return  to_appendTo.append("null");
      }
      int lenMinus1 = classes.length - 1;
      for(int i = 0; i < classes.length; i++)  {
         Class<?> cls = classes[i];
         if(element_prefix != null)  {
            to_appendTo.append(element_prefix);
         }

         to_appendTo.append(cls.getName());
         if(element_postfix != null)  {
            to_appendTo.append(element_postfix);
         }
         if(i < lenMinus1)  {
            to_appendTo.append(separator);
         }
      }
      return  to_appendTo;
   }
/*
   public static final Map<Character,String> newClassNameArrayElementEncodingCharMap()  {
      Map<Character,String> map = new HashMap<Character,String>(9);
      map.put('Z', "boolean");
      map.put('B', "byte");
      map.put('C', "char");
      map.put('L', null);
      map.put('D', "double");
      map.put('F', "float");
      map.put('I', "int");
      map.put('J', "long");
      map.put('S', "short");
      return  map;
   }
 */
   private ReflectRtxUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
}
