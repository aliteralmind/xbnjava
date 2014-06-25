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
package  com.github.xbn.number;
   import  java.util.Objects;
   import  com.github.xbn.number.z.IndexInRangeValidator_Fieldable;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.number.IndexInRange;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.List;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  java.util.Vector;

/**
   <P>{@code ValueValidator} for testing an indexes {@code null}-ness (an integer object that represents an index) and that it is in a {@code LengthInRange}. This also tests min-max index ranges.</P>

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.number.z.IndexInRangeValidator_Cfg IndexInRangeValidator_Cfg}</H3>

   public IndexInRangeValidator_CfgForNeeder<G,V,R> extraErrInfo(Object info)  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> range(G range)  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> nullOk(boolean b_b)  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> invert(boolean b_b)  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> unfiltered()  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> filter(ValidResultFilter filter_offIfNull)  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> debugTo(Appendable dest_ifNonNull)  {
   public IndexInRangeValidator_CfgForNeeder<G,V,R> chainID(boolean do_setStatic, Object id)  {

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
   @see  IndexInRange
 **/
public class IndexInRangeValidator extends IntInRangeValidator  {
//constructors...START
   public IndexInRangeValidator(IndexInRangeValidator_Fieldable<? extends IndexInRange> fieldable)  {
      super(fieldable);
   }
   protected IndexInRangeValidator(RuleType type, IndexInRangeValidator_Fieldable<? extends IndexInRange> fieldable)  {
      super(type, fieldable);
   }
   /**
      <P>Create a new {@code IndexInRangeValidator} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link IntInRangeValidator#IntInRangeValidator(IntInRangeValidator) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #IndexInRangeValidator(IndexInRangeValidator_Fieldable) this(vxir_f)
    **/
   public IndexInRangeValidator(IndexInRangeValidator to_copy)  {
      super(to_copy);
   }
//constructors...END
   public IndexInRange getRange()  {
      return  (IndexInRange)super.getRange();
   }
   public void crashIfBadRange(int min_inclusive, int max_exclusive, String min_name, String max_name)  {
      getRange().crashIfBadRange(min_inclusive, max_exclusive, min_name, max_name);
   }
   public void crashIfBad(int index, String idx_name)  {
      crashIfBadValue(index, idx_name);
   }
   public void crashIfBadValue(int index, String idx_name)  {
      getRange().crashIfBadValue(index, idx_name);
   }
   public void crashIfBadIndexObject(int index, String cntrName_dotLenFunc)  {
      getRange().crashIfBadIndexObject(index, cntrName_dotLenFunc);
   }
   public void crashIfBadIndexElement(int index, String cntr_name, int idx_inCntr)  {
      getRange().crashIfBadIndexElement(index, cntr_name, idx_inCntr);
   }
   /**
      @return  <CODE>(new {@link #IndexInRangeValidator(IndexInRangeValidator) IndexInRangeValidator}(this))</CODE>
    **/
   public IndexInRangeValidator getObjectCopy()  {
      return  (new IndexInRangeValidator(this));
   }
//static...START
   public static final List<Integer> getFilteredAscIndexList(int preFiltered_size, ValueValidator<Integer> filter)  {
      try  {
         return  getFilteredAscIndexList((new Vector<Integer>(preFiltered_size >>> 2)), preFiltered_size, filter);
      }  catch(IllegalArgumentException iax)  {
         throw  new IllegalArgumentException("preFiltered_size (" + preFiltered_size + ") is negative");
      }
   }
   public static final List<Integer> getFilteredAscIndexList(List<Integer> idxList_toOverwrite, int preFiltered_size, ValueValidator<Integer>  filter)  {
      for(int i = 0; i < preFiltered_size; i++)  {
         try  {
            if(filter.isValid(i))  {
               idxList_toOverwrite.add(i);
            }
         }  catch(RuntimeException rx)  {
            Objects.requireNonNull(idxList_toOverwrite, "idxList_toOverwrite");
            throw  CrashIfObject.nullOrReturnCause(filter, "filter", null, rx);
         }
      }
      return  idxList_toOverwrite;
   }
//static...END
}
