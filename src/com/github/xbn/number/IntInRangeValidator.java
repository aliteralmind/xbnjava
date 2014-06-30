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
   import  com.github.xbn.number.z.IntInRangeValidator_Fieldable;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.number.IntBoundInclusive;
   import  com.github.xbn.number.IntBoundExclusive;
   import  com.github.xbn.number.IntInRange;
   import  com.github.xbn.lang.RuleType;
/**
   <P>{@code ValueValidator} for testing an integer's {@code null}-ness and that it is in an {@code IntInRange}.</P>

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.number.z.IntInRangeValidator_Cfg IntInRangeValidator_Cfg}</H3>

   public IntInRangeValidator_CfgForNeeder<G,V,R> extraErrInfo(Object info)  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> range(G range)  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> nullOk(boolean b_b)  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> invert(boolean b_b)  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> unfiltered()  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> filter(ValidResultFilter filter_offIfNull)  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> debugTo(Appendable dest_ifNonNull)  {
   public IntInRangeValidator_CfgForNeeder<G,V,R> chainID(boolean do_setStatic, Object id)  {

   @see  IntInRange
   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IntInRangeValidator extends NumberInRangeValidator<Integer>  {
//constructors...START
   public IntInRangeValidator(IntInRangeValidator_Fieldable<? extends IntInRange> fieldable)  {
      super(fieldable);
   }
   protected IntInRangeValidator(RuleType type, IntInRangeValidator_Fieldable<? extends IntInRange> fieldable)  {
      super(type, fieldable);
   }
   /**
      <P>Create a new {@code IntInRangeValidator} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link NumberInRangeValidator#NumberInRangeValidator(NumberInRangeValidator) super}{@code (to_copy)}</P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #IntInRangeValidator(RuleType, IntInRangeValidator_Fieldable) this(rti,viir_f)
    **/
   public IntInRangeValidator(IntInRangeValidator to_copy)  {
      super(to_copy);
   }
//constructors...END
//other...START
   public IntInRange getRange()  {
      return  (IntInRange)super.getRange();
   }
   /**
      @return  <CODE>(new {@link #IntInRangeValidator(IntInRangeValidator) IntInRangeValidator}(this))</CODE>
    **/
   public IntInRangeValidator getObjectCopy()  {
      return  (new IntInRangeValidator(this));
   }
//other...END
}
