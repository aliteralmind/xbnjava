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
package  com.github.xbn.analyze.validate.z;
   import  com.github.xbn.analyze.validate.ValidatorComposer;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.Validator;
   import  com.github.xbn.neederneedable.AbstractNeedable;
   import  com.github.xbn.neederneedable.Needer;
/**
   <p>Base class for building {@link Validator}s.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class Validator_CfgForNeederBase<V extends Validator,R extends Needer> extends AbstractNeedable<V,R> implements Validator_Fieldable  {
   public boolean           bInvert     ;
   public Object            oXtraErrInfo;
   public Appendable        apblDebug   ;
   public ValidResultFilter vrFilter    ;
//constructors...START
   /**
      <p>Create a new instance with defaults.</p>

      <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}xbn/chain/AbstractNeedableWithSubs.html#AbstractNeedableWithSubs(boolean, boolean, R)">super</a>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</code></li>
      </ol></p>
    **/
   public Validator_CfgForNeederBase(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
      resetV();
   }
   public Validator_CfgForNeederBase<V,R> reset()  {
      resetV();
      return  this;
   }
   protected final void resetV()  {
      bInvert      = false;
      oXtraErrInfo = null ;
      apblDebug    = null ;
      setFilter_unfilteredIfNull(null);
   }
   protected void setFilter_unfilteredIfNull(ValidResultFilter filter_offIfNull)  {
      vrFilter = ((filter_offIfNull == null)
         ?  ValidatorComposer.unfiltered()
         :  filter_offIfNull);
   }
   public boolean doInvertRules()  {
      return  bInvert;
   }
   public Object getExtraErrInfo()  {
      return  oXtraErrInfo;
   }
   public Appendable getDebugApbl()  {
      return  apblDebug;
   }
   public ValidResultFilter getFilter()  {
      return  vrFilter;
   }
//constructors...END
   public String toString()  {
      return  this.getClass().getName() + ": doInvertRules()=" + doInvertRules() + ", getDebugApbl()=[" + getDebugApbl() + "], getFilter()=[" + getFilter() + "]";
   }
}
