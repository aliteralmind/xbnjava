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
package  com.github.xbn.number.z;
   import  com.github.xbn.number.NumberInRange;
   import  com.github.xbn.number.NumberInRangeValidator;
   import  com.github.xbn.analyze.validate.z.ValueValidator_CfgForNeeder;
   import  com.github.xbn.neederneedable.Needer;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/chain/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.number.NumberInRangeValidator}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class NumberInRangeValidator_CfgForNeeder<N extends Number,G extends NumberInRange<N>,V extends NumberInRangeValidator<N>, R extends Needer> extends ValueValidator_CfgForNeeder<N,V,R> implements NumberInRangeValidator_Fieldable<N,G>  {
   public G nir = null;
   /**
      <p>YYY</p>

         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="NumberInRangeValidator_CfgForNeeder.html#NumberInRangeValidator_CfgForNeeder(boolean, boolean, R)">super</a>(is_avaliableToNeeders, is_neededUseableAtInit, needer)</code></li>

    **/
   public NumberInRangeValidator_CfgForNeeder(boolean is_avaliableToNeeders, boolean is_neededUseableAtInit, R needer)  {
      super(is_avaliableToNeeders, is_neededUseableAtInit, needer);
   }
   public G getRange()  {
      return  nir;
   }
   public String toString()  {
      return  super.toString() + ", getRange()=[" + getRange() + "]";
   }
}
