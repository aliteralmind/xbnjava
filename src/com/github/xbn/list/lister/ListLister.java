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
package  com.github.xbn.list.lister;
   import  com.github.xbn.analyze.validate.ValidatorComposer;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.io.RTIOException;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.list.lister.z.ListLister_Fieldable;
   import  com.github.xbn.text.CrashIfString;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.text.StringWithNullDefault;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  java.io.IOException;
   import  java.util.List;
   import  org.apache.commons.lang3.StringUtils;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Highly-configurable printing of a {@code java.util.List}.</P>

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.list.lister.z.ListLister_Cfg ListLister_Cfg}</H3>

   <P><UL>
      <LI><B>Sub configs:</B><UL>
         <LI><B><A HREF="LLCfgElement.html#cfg">LLCfgElement</A>:</B> {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#cfgElement() cfgElement}{@code ()}</LI>
         <LI><B><A HREF="LLCfgOverall.html#cfg">LLCfgOverall</A>:</B> {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#cfgOverall() cfgOverall}{@code ()}</LI>
      </UL></LI>
      <LI><B>Between:</B> {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#between(String) between}{@code (s)}, {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#commaSpaceBetween() commaSpaceBetween}{@code ()}, {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#newLineBetween() newLineBetween}{@code ()}</LI>
      <LI><B>Display only valid indexes:</B> {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#indexFilter(ValueValidator) indexFilter}{@code (vv)}, {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#keepAllIndexes() keepAllIndexes}{@code ()}, {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#keepIndexesBelow(int) keepIndexesBelow}{@code (i)}, {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#keepIndexesBetween(int, int) keepIndexesBetween}{@code (i,i)}</LI>
      <LI><B>Display only valid values:</B> {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#valueFilter(ValueValidator) valueFilter}{@code (vv)}, {@link com.github.xbn.list.lister.z.ListLister_CfgForNeeder#filterNullValues() filterNullValues}{@code ()}</LI>
   </UL></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ListLister<E> implements ToStringAppendable  {
//state
   private final LLCfgOverall<E>           llco     ;
   private final LLCfgElement<E>           llce     ;
   private final ValueValidator<Integer>    vvIdxFltr;
   private final ValueValidator<E>          vValFltr ;
   private final String                    sBtw     ;
//internal
   //"": Replace withs to be determined
   private static final RegexReplacer lr4SZ_MRK = new RegexReplacer_Cfg().first().directLiteral(LLCfgForLengthItems.sDISPLAY_SIZE_MARKER, "").build();
   private static final RegexReplacer lr4IDX_MRK = new RegexReplacer_Cfg().first().directLiteral(LLCfgElement.sDISPLAY_IDX_MARKER, "").build();
//constructor...START
   public ListLister(ListLister_Fieldable<E> fieldable)  {
      llco = fieldable.getOverallConfig();
      llce = fieldable.getElementConfig();
      vvIdxFltr = fieldable.getIndexFilter();
      vValFltr = fieldable.getValueFilter();
      sBtw = fieldable.getBetween();

      if(llco == null)  {
         throw  new NullPointerException("fieldable.getOverallConfig()");
      }
      if(llce == null)  {
         throw  new NullPointerException("fieldable.getElementConfig()");
      }
      ValidatorComposer.ciForbiddenRuleType(vvIdxFltr, RuleType.IMPOSSIBLE, "fieldable.getIndexFilter()", null);
      ValidatorComposer.ciForbiddenRuleType(vValFltr, RuleType.IMPOSSIBLE, "fieldable.getValueFilter()", null);
      CrashIfString.empty(Null.OK, sBtw, "fieldable.getBetween()", LLConfigBase.s4ES_USE_NUL);
   }
   public ListLister(ListLister<E> to_copy)  {
      try  {
         llco = to_copy.getOverallConfig();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      llce = to_copy.getElementConfig();
      vvIdxFltr = to_copy.getIndexFilter();
      vValFltr = to_copy.getValueFilter();
      sBtw = to_copy.getBetween();
   }
//constructor...END
   //getters...START
      public LLCfgOverall<E> getOverallConfig()  {
         return  llco;
      }
      public LLCfgElement<E> getElementConfig()  {
         return  llce;
      }
      public ValueValidator<Integer> getIndexFilter()  {
         return  vvIdxFltr;
      }
      public ValueValidator<E> getValueFilter()  {
         return  vValFltr;
      }
      public String getBetween()  {
         return  sBtw;
      }
   //getters...END
 	public String get(List<E> list)  {
      return  append(this, (new StringBuilder()), list).toString();
   }
 	public Appendable append(Appendable to_appendTo, List<E> list)  {
      return  ListLister.append(this, to_appendTo, list);
   }
 	public Appendable appendX(Appendable to_appendTo, List<E> list) throws IOException  {
      return  ListLister.append(this, to_appendTo, list);
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         StringUtil.appendPreTruePostOrFalse(to_appendTo,
            ", getIndexFilter()=[", getIndexFilter(), "]",
            (!getIndexFilter().getRuleType().isUnrestricted()), null);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      StringUtil.appendPreTruePostOrFalse(to_appendTo,
         ", getValueFilter()=[", getValueFilter(), "]",
         (!getValueFilter().getRuleType().isUnrestricted()), null);
      to_appendTo.append(LINE_SEP).append("--getOverallConfig()--").append(LINE_SEP);
      getOverallConfig().appendToString(to_appendTo).
         append(getOverallConfig()).append(LINE_SEP).
         append("--getElementConfig()--").append(LINE_SEP);
      getElementConfig().appendToString(to_appendTo);

      return  to_appendTo;
   }
//static...START
 	/**
 		<P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
 	 **/
 	public static final <E> Appendable append(ListLister<E> lister, Appendable to_appendTo, List<E> list)  {
      try  {
         return  appendX(lister, to_appendTo, list);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting appendX(lister, to_appendTo, list). to_appendTo=[" + to_appendTo + "], list=[" + StringUtils.join(list, ", ") + "], lister=[" + lister + "]");
      }
   }
   /**
<PRE>getOverallConfig()
   getIfNull()               <I>(short circuit)</I>
   getIfNonNull()              <I>(short circuit)</I>
   getVVForElementLength()   <I>(short circuit)</I>
           getIfElementLength()
getIndexFilter()
getValueFilter()
   getElementConfig()
getOverallConfig()
   getVPCFinalOutput()
   getPrefix()
   getPostfix()</PRE>
    **/
 	public static final <E> Appendable appendX(ListLister<E> lister, Appendable to_appendTo, List<E> list) throws IOException  {
      LLCfgOverall<E> llco = null;
      try  {
         llco = lister.getOverallConfig();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(lister, "lister", null, rx);
      }

      if(list == null)  {
         return  StringWithNullDefault.append(to_appendTo, llco.getIfNull(), null);
      }

      ListLister.lr4SZ_MRK.replaceWith(list.size());

      StringWithNullDefault.append(to_appendTo, llco.getPrefix(), null);

      Appendable apblTmp = (llco.getVPCFinalOutput().doesNothing() ? to_appendTo
         :  new StringBuilder());

      if(llco.getIfNonNull() != null)  {
         return  lr4SZ_MRK.appendReplaced(apblTmp, llco.getIfNonNull());
      }

      if(llco.getVVForElementLength().getRuleType().isRestricted()  &&
            llco.getVVForElementLength().isValid(list.size()))  {
         return  lr4SZ_MRK.appendReplaced(apblTmp, llco.getIfElementLength());
      }

      String sBetween = StringWithNullDefault.get(lister.getBetween(), null);

      boolean bFilterUsed = (lister.getIndexFilter().getRuleType().isRestricted()  ||
            lister.getValueFilter().getRuleType().isRestricted());

      int ix = -1;
      if(!bFilterUsed)  {
         boolean b1stLmntWritten = false;
         for(E e : list)  {
            ix++;               //First iteration: Was -1, now 0
            if(!lister.getIndexFilter().isValid(ix)  ||
                  !lister.getValueFilter().isValid(e))  {
               continue;
            }

            if(b1stLmntWritten)  {
               apblTmp.append(sBetween);
            }  else  {
               b1stLmntWritten = true;
            }

            appendElement(lister.getElementConfig(), apblTmp, ix, e);
         }

       //ELSE: bFilterUsed is false
      }  else  {
         for(E e : list)  {
            if(ix > -1)  {
               apblTmp.append(sBetween);
            }
                                //First iteration: Was -1, now 0
            appendElement(lister.getElementConfig(), apblTmp, ++ix, e);
         }
      }

      if(!llco.getVPCFinalOutput().doesNothing())  {
         llco.getVPCFinalOutput().append(to_appendTo, apblTmp.toString());
      }

      return  StringWithNullDefault.append(to_appendTo, llco.getPostfix(), null);
   }
 	/**
 		<P>YYY</P>

      @exception  RTIOException  If an {@link java.io.IOException IOException} is thrown
 	 **/
 	public static final <E> Appendable appendElement(LLCfgElement<E> llc_e, Appendable to_appendTo, int index, E obj)  {
      try  {
         return  appendElementX(llc_e, to_appendTo, index, obj);
      }  catch(IOException iox)  {
         throw  new RTIOException("Attempting appendElementX(llc_e, to_appendTo, index, obj). index=" + index + ", obj=[" + obj + "], to_appendTo=[" + to_appendTo + "], llc_e=[" + llc_e + "]");
      }
   }
 	/**
<PRE>getElementConfig()
   getIfNull()            <I>(short circuit)</I>
   getIfNonNull()           <I>(short circuit)</I>
           getAlterIndex()
           getAlterValue()
   getPrefix()
   getPostfix()
   getVPCFinalOutput()
getOverallConfig()
   getBetween()</PRE>
 	 **/
 	public static final <E> Appendable appendElementX(LLCfgElement<E> llc_e, Appendable to_appendTo, int index, E obj) throws IOException  {
      try  {
         if(obj == null)  {
            return  StringWithNullDefault.append(to_appendTo, llc_e.getIfNull(), null);
         }

         lr4IDX_MRK.replaceWith(index);

      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(llc_e, "llc_e", null, rx);
      }

      if(llc_e.getIfNonNull() != null)  {
         return  lr4IDX_MRK.appendReplaced(to_appendTo, llc_e.getIfNonNull());
      }

      if(!llc_e.getAlterIndex().isExpired())  {
         index = llc_e.getAlterIndex().getAltered(index, index);
      }
      if(!llc_e.getAlterValue().isExpired())  {
         obj = llc_e.getAlterValue().getAltered(obj, obj);
      }

      StringWithNullDefault.append(to_appendTo, llc_e.getPrefix(), null);
      llc_e.getVPCFinalOutput().appendX(to_appendTo, obj);
      return  StringWithNullDefault.append(to_appendTo, llc_e.getPostfix(), null);
   }
//static...END
}
