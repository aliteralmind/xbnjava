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
package  com.github.xbn.text.padchop.z;
   import  com.github.xbn.text.padchop.PadChopBase;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.neederneedable.AbstractNeedable;
/**
   <p>YYY</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
/**
   <p>. The base class for {@link com.github.xbn.text.padchop.z.PadString_CfgForNeeder PadString_CfgForNeeder} and {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder PadString_CfgForNeeder}.</p>
 **/
public abstract class PadChopBase_CfgForNeeder<P extends PadChopBase,R extends Needer> extends AbstractNeedable<P,R> implements PadChopBase_Fieldable  {
   public int iGoalLen = -1;
   public boolean bSideRight = false;
   /**
      <p>Create a new {@code PadChopBase_CfgForNeeder} with defaults.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#PadChopBase_CfgForNeeder(R, int)">this</a>(needer, -1)</code></p>

    */
   public PadChopBase_CfgForNeeder(R needer)  {
      this(needer, -1);
   }
   /**
      <p>Create a new {@code PadChopBase_CfgForNeeder} with defaults, but a specific goal length.</p>

         <p>This calls<ol>
         <li><code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/neederneedable/AbstractNeedable.html#AbstractNeedable(boolean, boolean, R)">super</a>(true, true, needer)</code></li>
      </ol></p>

    * @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#PadChopBase_CfgForNeeder(R)">this</a>(R)</code>
    */
   public PadChopBase_CfgForNeeder(R needer, int goal_len)  {
      super(true, true, needer);
      iGoalLen = goal_len;
   }
   /**
      <p>Declare which side of the string should be padded or chopped.</p>

    * @return  <i>{@code this}</i>
    * @see <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#PadChopBase_CfgForNeeder(int, R)">this</a>(-1, needer)</code>
    */
   public PadChopBase_CfgForNeeder<P,R> startConfigReturnNeedable(R needer, Class<P> expected_type)  {
      startConfig(needer, expected_type);
      return  this;
   }
   public int getGoalLen()  {
      return  iGoalLen;
   }
   public boolean isSideRight()  {
      return  bSideRight;
   }

}
