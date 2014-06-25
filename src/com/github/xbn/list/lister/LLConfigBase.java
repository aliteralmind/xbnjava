package  com.github.xbn.list.lister;
   import  com.github.xbn.text.StringWithNullDefault;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.list.lister.z.LLConfigBase_Fieldable;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.text.CrashIfString;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.text.padchop.VzblPadChop;
/**
   <P>Base class for {@code LLConfigBase} and {@code LLCfgElement}. See {@link com.github.xbn.list.lister.LLConfigBase LLConfigBase} and {@link com.github.xbn.list.lister.LLCfgElement LLCfgElement}.</P>

   <A NAME="short_circuit"><A/><H3>Short circuits</H3>

   <P>Some settings are &quot;short circuits&quot;--if one is used, all subsequent settings are ignored. The order of settings is<OL>
      <LI>{@link #getIfNull() getIfNull}{@code ()} &nbsp; &nbsp; <I>(short circuit)</I></LI>
      <LI>{@link #getIfNonNull() getIfNonNull}{@code ()} &nbsp; &nbsp; <I>(short circuit)</I></LI>
      <LI>{@link #getPrefix() getPrefix}{@code ()} and {@link #getPostfix() getPostfix}{@code ()}</LI>
   </OL></P>

   @param  <O>  Either the list itself, or the type of element in the list. See {@code LLConfigBase} and {@code zL_CfgElement}.
 **/
public abstract class LLConfigBase<O> implements ToStringAppendable  {
   private String            sIfNl   ;
   private String            sIfNNl  ;
   private String            sPre    ;
   private String            sPost   ;
   private final VzblPadChop vpcFinal;
   protected static String sOP = "output";
   public static final String s4ES_USE_NUL = "For the empty-string, provide null. ";
   /**
      <P>Create a new {@code LLConfigBase} with defaults.</P>

      @see  #LLConfigBase(LLConfigBase) this(llcb)
    **/
   public LLConfigBase(LLConfigBase_Fieldable fieldable)  {
      sIfNl = fieldable.getIfNull();
      sIfNNl = fieldable.getIfNonNull();
      sPre = fieldable.getPrefix();
      sPost = fieldable.getPostfix();
      vpcFinal = fieldable.getVPCFinalOutput();

      CrashIfString.empty(Null.OK, sIfNl, "fieldable.getIfNull()", s4ES_USE_NUL);
      CrashIfString.empty(Null.OK, sIfNNl, "fieldable.getIfNonNull()", s4ES_USE_NUL);
      CrashIfString.empty(Null.OK, sPre, "fieldable.getPrefix()", s4ES_USE_NUL);
      CrashIfString.empty(Null.OK, sPost, "fieldable.getPostfix()", s4ES_USE_NUL);
      if(vpcFinal == null)  {
         throw  new NullPointerException("fieldable.getVPCFinalOutput()");
      }
   }
   /**
      <P>Create a new {@code LLConfigBase} as a duplicate of another.</P>

      @param  to_copy  May not be {@code null}.
      @see  #LLConfigBase(LLConfigBase_Fieldable) this(s,s,s,s,padchop)
    **/
   public LLConfigBase(LLConfigBase<O> to_copy)  {
      try  {
         sIfNl = to_copy.sIfNl;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      sIfNNl = to_copy.sIfNNl;
      sPre = to_copy.sPre;
      sPost = to_copy.sPost;
      vpcFinal = to_copy.getVPCFinalOutput();
   }
//getters...START
   /**
      <P>Short circuit: What is displayed when the list-or-element is {@code null}?. Short-circuit <A HREF="#short_circuit">definition</A>.</P>

      @see  com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#setIfNull(String) LLConfigBase_Cfg#setIfNull(s)
    **/
   public String getIfNull()  {
      return  sIfNl;
   }
   /**
      <P>Short circuit: What is displayed when the list-or-element is <I>not</I> {@code null}?. Short-circuit <A HREF="#short_circuit">definition</A>.</P>

      @see  com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#setIfNonNull(String) LLConfigBase_Cfg#setIfNonNull(s)
    **/
   public String getIfNonNull()  {
      return  sIfNNl;
   }
   /**
      <P>Get the prefix to display before the list-or-element. Only used when no short-circuits are used.</P>

      @see  com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#setPrePost(String, String) LLConfigBase_Cfg#setPrePost(s,s)
    **/
   public String getPrefix()  {
      return  sPre;
   }
   /**
      <P>Get the postfix to display after the list-or-element. Only used when no short-circuits are used.</P>

      @see  com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#setPrePost(String, String) LLConfigBase_Cfg#setPrePost(s,s)
    **/
   public String getPostfix()  {
      return  sPost;
   }
   public VzblPadChop getVPCFinalOutput()  {
      return  vpcFinal;
   }
//getters...END
//other...START
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         StringWithNullDefault.append(to_appendTo, "getIfNull()=\"", getIfNull(), "\"", null);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      to_appendTo.append("\", pre/post=[");
         StringWithNullDefault.append(to_appendTo, getPrefix(), null);
         to_appendTo.append("/");
         StringWithNullDefault.append(to_appendTo, getPostfix(), null);
      StringWithNullDefault.append(to_appendTo, ", getIfNonNull()=\"", getIfNonNull(), "\"", null);
      StringUtil.appendPreTruePostOrFalse(to_appendTo,
         ", getVPCFinalOutput()=[", getVPCFinalOutput(), "]",
         (!getVPCFinalOutput().doesNothing()), null);
      return  to_appendTo;
   }
//other...END
}
