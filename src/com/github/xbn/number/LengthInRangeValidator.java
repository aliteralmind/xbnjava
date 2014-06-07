/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   import  com.github.xbn.number.z.LengthInRangeValidator_Fieldable;
   import  com.github.xbn.lang.RuleType;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  java.util.Collection;
   import  com.github.xbn.number.IntBoundInclusive;
   import  com.github.xbn.number.LengthInRange;
/**
   <P>{@code ValueValidator} for testing an length's {@code null}-ness (the integer-object that represents length) and that it is in a {@code LengthInRange}.</P>

   <a name="cfg"/><H3>Builder Configuration: {@link com.github.xbn.number.z.LengthInRangeValidator_Cfg LengthInRangeValidator_Cfg}</H3>

   public LengthInRangeValidator_CfgForNeeder<G,V,R> extraErrInfo(Object info)  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> range(G line_itrr)  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> unfiltered()  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> filter(ValidResultFilter filter_offIfNull)  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> nullOk(boolean b_b)  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> invert(boolean b_b)  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> debugTo(Appendable dest_ifNonNull)  {
   public LengthInRangeValidator_CfgForNeeder<G,V,R> chainID(boolean do_setStatic, Object id)  {

   @see  LengthInRange
   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LengthInRangeValidator extends IntInRangeValidator  {
//constructors...START
   public LengthInRangeValidator(LengthInRangeValidator_Fieldable<? extends LengthInRange> fieldable)  {
      super(fieldable);
   }
   protected LengthInRangeValidator(RuleType type, LengthInRangeValidator_Fieldable<? extends LengthInRange> fieldable)  {
      super(type, fieldable);
   }
   /**
      <P>Create a new {@code LengthInRangeValidator} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link IntInRangeValidator#IntInRangeValidator(IntInRangeValidator) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #LengthInRangeValidator(RuleType, LengthInRangeValidator_Fieldable) this(rti,vlir_f)
    **/
   public LengthInRangeValidator(LengthInRangeValidator to_copy)  {
      super(to_copy);
   }
//constructors...END
//other...START
   public LengthInRange getRange()  {
      return  (LengthInRange)super.getRange();
   }
   public LengthInRangeValidator crashIfBad(int length, String cntrName_dotLenFunc)  {
      return  crashIfBadValue(length, cntrName_dotLenFunc);
   }
   public LengthInRangeValidator crashIfBadValue(int length, String cntrName_dotLenFunc)  {
      getRange().crashIfBadValue(length, cntrName_dotLenFunc);
      return  this;
   }
   public LengthInRangeValidator crashIfBadString(Object string, String cntrName_dotLenFunc)  {
      getRange().crashIfBadString(string, cntrName_dotLenFunc);
      return  this;
   }
   public <E> LengthInRangeValidator crashIfBadArray(E[] objects, String cntrName_dotLenFunc)  {
      getRange().crashIfBadArray(objects, cntrName_dotLenFunc);
      return  this;
   }
   public LengthInRangeValidator crashIfBadCollection(Collection<? extends Object> coll, String cntrName_dotLenFunc)  {
      getRange().crashIfBadCollection(coll, cntrName_dotLenFunc);
      return  this;
   }
   public LengthInRangeValidator crashIfBadPArray(Object obj_thatIsPrimArr, String cntrName_dotLenFunc)  {
      getRange().crashIfBadPArray(obj_thatIsPrimArr, cntrName_dotLenFunc);
      return  this;
   }
   public LengthInRangeValidator crashIfBadElement(int length, String cntr_name, int idx_inCntr)  {
      getRange().crashIfBadElement(length, cntr_name, idx_inCntr);
      return  this;
   }
   public LengthInRangeValidator crashIfBadStringElement(Object string, String cntr_name, int idx_inCntr)  {
      getRange().crashIfBadStringElement(string, cntr_name, idx_inCntr);
      return  this;
   }
   public <E> LengthInRangeValidator crashIfBadArrayTIAElement(E[] objects, String cntr_name, int idx_inCntr)  {
      getRange().crashIfBadArrayTIAElement(objects, cntr_name, idx_inCntr);
      return  this;
   }
   public LengthInRangeValidator crashIfBadCollectionTIAElement(Collection<? extends Object> coll, String cntr_name, int idx_inCntr)  {
      getRange().crashIfBadCollectionTIAElement(coll, cntr_name, idx_inCntr);
      return  this;
   }
   /**
      @return  <CODE>(new {@link #LengthInRangeValidator(LengthInRangeValidator) LengthInRangeValidator}(this))</CODE>
    **/
   public LengthInRangeValidator getObjectCopy()  {
      return  (new LengthInRangeValidator(this));
   }
//other...END
}
