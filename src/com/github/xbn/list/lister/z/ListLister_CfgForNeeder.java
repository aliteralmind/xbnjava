/*license*\
   XBN-Java Library

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
package  com.github.xbn.list.lister.z;
   import  com.github.xbn.number.NewIndexInRangeFor;
   import  com.github.xbn.list.lister.LLCfgElement;
   import  com.github.xbn.list.lister.LLCfgOverall;
   import  com.github.xbn.list.lister.LLConfigBase;
   import  com.github.xbn.list.lister.ListLister;
   import  com.github.xbn.neederneedable.AbstractNeedableWithSubs;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.analyze.validate.NewValueValidatorFor;
   import  com.github.xbn.number.z.IndexInRangeValidator_Cfg;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>For <A HREF="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</A> configuring an {@link com.github.xbn.list.lister.ListLister ListLister}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ListLister_CfgForNeeder<E,L extends ListLister<E>,R extends Needer> extends AbstractNeedableWithSubs<L,R> implements ListLister_Fieldable<E>   {
//state
   public LLCfgOverall<E>           llco     ;
   public LLCfgElement<E>           llce     ;
   public ValueValidator<Integer>    vvIdxFltr;
   public ValueValidator<E>          vValFltr ;
   public String                    sBtw     ;
   /**
      <P>Create a new {@code zListLister_CfgForNeeder} with defaults.</P>

      <P>This calls<OL>
         <LI><CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="{@docRoot}xbn/chain/AbstractNeedableWithSubs.html#AbstractNeedableWithSubs(boolean, boolean, R)">super</A>(true, true, needer)</CODE>{@code (true, true, needer)}</LI>
         <LI>{@link #resetLL() resetLL}{@code ()}</LI>
      </OL></P>
    **/
   public ListLister_CfgForNeeder(R needer)  {
      super(true, true, needer);
      resetLL();
   }
   /**
      <P>Revert configuration to <I>nothing</I>.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #resetLL() resetLL}{@code ()}</P>
    **/
   public void declareReset()  {
      resetLL();
   }
   /**
      <P>Revert configuration to <I>nothing</I>.</P>

      <P>This calls<OL>
         <LI><CODE>{@link #cfgOverall() cfgOverall}().{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#endCfg() endCfg}()</CODE></LI>;
         <LI><CODE>{@link #cfgElement() cfgElement}().{@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#endCfg() endCfg}()</CODE></LI>;
         <LI>{@link #commaSpaceBetween() commaSpaceBetween}{@code ()}</LI>
      </OL></P>
      @see  #declareReset()
    **/
   protected final void resetLL()  {
      cfgOverall().endCfg();
      cfgElement().endCfg();
      commaSpaceBetween();
   }

   public ListLister_CfgForNeeder<E,L,R> commaSpaceBetween()  {
      return  between(", ");
   }
   public ListLister_CfgForNeeder<E,L,R> newLineBetween()  {
      return  between(LINE_SEP);
   }
   public ListLister_CfgForNeeder<E,L,R> between(String text)  {
      sBtw = text;
      return  this;
   }
   public LLCfgOverall_CfgForNeeder<E,LLCfgOverall<E>,R> cfgOverall()  {

      //Not sure why this is necessary
      @SuppressWarnings("unchecked")
      R r = (R)this;

      return  (new LLCfgOverall_CfgForNeeder<E,LLCfgOverall<E>,R>(r));
   }
   public LLCfgElement_CfgForNeeder<E,LLCfgElement<E>,R> cfgElement()  {

      //Not sure why this is necessary
      @SuppressWarnings("unchecked")
      R r = (R)this;

      return  (new LLCfgElement_CfgForNeeder<E,LLCfgElement<E>,R>(r));
   }
   public ListLister_CfgForNeeder<E,L,R> keepAllIndexes(Appendable dbgDest_ifNonNull)  {

      //Checking null-ness only is appropriate for all types.
      @SuppressWarnings("unchecked")
      ValueValidator<Integer> vvi = NewValueValidatorFor.<Integer>unrestricted(null, dbgDest_ifNonNull);

      return  indexFilter(vvi);
   }
   public ListLister_CfgForNeeder<E,L,R> keepIndexesBetween(int min_inclusive, int max_exclusive)  {
      return  indexFilter(new IndexInRangeValidator_Cfg().range(NewIndexInRangeFor.minAndLength(min_inclusive, max_exclusive, "min_inclusive", "max_exclusive")).build());
   }
   public ListLister_CfgForNeeder<E,L,R> keepIndexesBelow(int max_exclusive)  {
      return  indexFilter(new IndexInRangeValidator_Cfg().range(NewIndexInRangeFor.length(max_exclusive, "max_exclusive")).build());
   }
   public ListLister_CfgForNeeder<E,L,R> indexFilter(ValueValidator<Integer> validator)  {
      vvIdxFltr = validator;
      return  this;
   }
   public ListLister_CfgForNeeder<E,L,R> filterNullValues(Appendable dbgDest_ifNonNull)  {

      //Safe for all types.
      @SuppressWarnings("unchecked")
      ValueValidator<E> vve = NewValueValidatorFor.<E>nullBad(null, dbgDest_ifNonNull);

      return  valueFilter(vve);
   }
   public ListLister_CfgForNeeder<E,L,R> valueFilter(ValueValidator<E> validator)  {
      vValFltr = validator;
      return  this;
   }
//setters...END
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
   public L build()  {
      @SuppressWarnings("unchecked")
      L l = (L)new ListLister<E>(this);
      return  l;
   }
   @SuppressWarnings("unchecked")  //See LLCfgOverall.startConfigReturnNeedable(R)
   public ListLister_CfgForNeeder<E,L,R> startConfigReturnNeedable(R needer)  {
      @SuppressWarnings("unchecked")
      Class<L> clsl = (Class<L>)(Class)ListLister.class;
      startConfig(needer, clsl);
      return  this;
   }
   /**
      <P>Sets the fully-configured object into the {@code Needer}, and returns control back to the needer-chain.</P>

      @return  <CODE>{@link com.github.xbn.neederneedable.AbstractNeedableWithSubs#endCfgWithNeededReturnNeeder(Object) endCfgWithNeededReturnNeeder}({@link #build() build}())</CODE>
    **/
   public R endCfg()  {
      return  endCfgWithNeededReturnNeeder(build());
   }
   public void neeadableSetsNeeded(Object fully_configured)  {

      //Type by both setGetNeededEndConfig(o) and below
      @SuppressWarnings("unchecked")
      LLConfigBase<E> llcb = (LLConfigBase<E>)setGetNeededEndConfig(fully_configured);

      @SuppressWarnings("unchecked")
      Class<?> clsNeeded = getNeededType();
      if(clsNeeded.isAssignableFrom(LLCfgOverall.class))  {

         //Well, it's definitely an LLCfgOverall. It is almost
         //surely of type <E>, but is this a risk at all?
         @SuppressWarnings("unchecked")
         LLCfgOverall<E> llco2 = (LLCfgOverall<E>)setGetNeededEndConfig(fully_configured);

         llco = llco2;
      }  else if(clsNeeded.isAssignableFrom(LLCfgElement.class))  {

         //See above
         @SuppressWarnings("unchecked")
         LLCfgElement<E> llce2 = (LLCfgElement<E>)setGetNeededEndConfig(fully_configured);

         llce = llce2;
      }  else  {
         throw  new IllegalStateException("getNeededType()=" + getNeededType() + ", fully_configured.getClass().getName()=" + fully_configured.getClass().getName());
      }
   }
   public ListLister_CfgForNeeder<E,L,R> chainID(boolean do_setStatic, Object id)  {
      setChainID(do_setStatic, id);
      return  this;
   }
}
