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
   import  com.github.xbn.io.PrintStreamForString;
   import  org.apache.commons.lang3.ArrayUtils;
   import  java.lang.reflect.Method;
/**
   <p>Builder for invoking an already obtained method, with runtime errors only (the original exception is accessible with {@link java.lang.Throwable#getCause() getCause}{@code ()}).</p>

{@.codelet.and.out com.github.xbn.examples.lang.reflect.InvokeMainWithRtxXmpl%eliminateCommentBlocksAndPackageDecl()}

{@.codelet.and.out com.github.xbn.examples.lang.reflect.InvokePrivateStaticMethodWithRtxXmpl%eliminateCommentBlocksAndPackageDecl()}

   @see  <code>{@link com.github.xbn.array.ArrayUtil}.<!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/array/ArrayUtil.html#getStringArrayOrNull(E[], boolean, java.lang.String)">getStringArrayOrNull</a>(E[],b,s)</code>
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class InvokeMethodWithRtx  {
//state
   private Object[] aoParams    ;
   private Method   m           ;
   private boolean  bInvkdSttSet;
   private Object   oInvkdFrm   ;
//internal
   public InvokeMethodWithRtx(Method method)  {
      if(method == null)  {
         throw  new NullPointerException("method");
      }
      m = method;
      bInvkdSttSet = false;
      oInvkdFrm = null;
      aoParams = null;
   }
   public InvokeMethodWithRtx sstatic()  {
      return  invokingObject(null);
   }
   public InvokeMethodWithRtx invokingObject(Object obj)  {
      oInvkdFrm = obj;
      bInvkdSttSet = true;
      return  this;
   }
   public InvokeMethodWithRtx parameters(Object[] ao_params)  {
      if(aoParams  != null)  {
         throw  new IllegalStateException("Params already set.");
      }
      if(ao_params == null)  {
         throw  new NullPointerException("ao_params");
      }
      aoParams = ao_params;
      return  this;
   }
   public InvokeMethodWithRtx noParams()  {
      parameters(ArrayUtils.EMPTY_OBJECT_ARRAY);
      return  this;
   }
   public InvokeMethodWithRtx noCmdLineParams()  {
      return  cmdLineParams(ArrayUtils.EMPTY_STRING_ARRAY);
   }
   public InvokeMethodWithRtx cmdLineParams(String[] cmd_lineParams)  {
      return  parameters(new Object[] {cmd_lineParams});
   }
   public RuntimeException invokeVoidGetRtx()  {
      return  invokeVoidGetRtxWXtraInfo(null);
   }
   public RuntimeException invokeVoidGetRtxWXtraInfo(Object xtra_errInfo)  {
      return  ReflectRtxUtil.invokeVoidMethodGetRtx(oInvkdFrm, m, xtra_errInfo, aoParams);
   }
   public void invokeVoid()  {
      invokeVoidWXtraInfo(null);
   }
   public void invokeVoidWXtraInfo(Object xtra_errInfo)  {
      RuntimeException rx = ReflectRtxUtil.invokeVoidMethodGetRtx(oInvkdFrm, m, xtra_errInfo, aoParams);
      if(rx != null)  {
         throw  rx;
      }
   }
   public Object invokeGetReturnValue()  {
      return  invokeGetReturnValueWXtraInfo(null);
   }
   public Object invokeGetReturnValueWXtraInfo(Object xtra_errInfo)  {
      if(!bInvkdSttSet)  {
         throw  new IllegalStateException("Must declare method as either static() or set its invokingObject(o).");
      }
      if(aoParams == null)  {
         throw  new IllegalStateException("Must set parameters(o[])");
      }
      return  ReflectRtxUtil.invokeMethodWithRtxGetReturnValue(oInvkdFrm, m, xtra_errInfo, (Object[])aoParams);
   }
   public static final String getApplicationOutput(String fq_clsNmContainingMain, String[] cmd_lineParams, String attempting_errMsg)  {
      return  getApplicationOutput(ReflectRtxUtil.getClassForName(fq_clsNmContainingMain, "fq_clsNmContainingMain"), cmd_lineParams, attempting_errMsg);
   }
   /**
      <p>YYY</p>

      @param  attempting_errMsg  Brief description of the application (example: {@code "Obtaining output for example code"}). <i>Should</i> not be {@code null} or empty. <i>The name of the class is already in the error message. It does not need to be in this parameter.</i>
    **/
   public static final String getApplicationOutput(Class<?> cls_containingMain, String[] cmd_lineParams, String attempting_errMsg)  {
      PrintStreamForString pss = new PrintStreamForString().setSystemOutTo();
      String output;
      try  {
         Method m = new GetMethodWithRtx(Declared.NO).
            containingClass(cls_containingMain).
            mainMethod().get();


         new InvokeMethodWithRtx(m).
            cmdLineParams(cmd_lineParams).
            invokeVoid();
      }  catch(RuntimeException rx)  {
         throw  new RuntimeException("cls_containingMain.getName()=" + cls_containingMain.getName() + ". attempting_errMsg=" + attempting_errMsg, rx);
      }  finally  {
         output = pss.getStringAndReset();
      }
      return  output;
   }
}
