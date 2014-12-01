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
package  com.github.xbn.linefilter.entity.raw.z;
   import  com.github.xbn.linefilter.entity.raw.RawOnOffEntityFilter;
   import  com.github.xbn.linefilter.entity.EntityType;
   import  com.github.xbn.neederneedable.AbstractNeedable;
   import  com.github.xbn.neederneedable.Needer;
   import  com.github.xbn.linefilter.entity.raw.RawLineEntity;
/**
   <p>For <a href="{@docRoot}/com/github/xbn/neederneedable/Needable.html#indirect">indirectly</a> configuring a {@link com.github.xbn.linefilter.entity.raw.RawLineEntity RawLineEntity}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class RawLineEntity_CfgForNeeder<L,M extends RawLineEntity<L>,R extends Needer> extends AbstractNeedable<M,R> implements RawLineEntity_Fieldable<L>   {
   public String       name           ;
   public Appendable   dbgApblLineNums;
   public EntityType   type           ;
   public RawOnOffEntityFilter<L> filterIfNonNull;
   public boolean      isRqd          ;
//constructors...START
   /**
      <p>Create a new instance, for the root entity only.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code> <!-- GENERIC PARAMETERS FAIL IN @link --><a href="#RawLineEntity_CfgForNeeder(R, java.lang.String)">this</a>(needer, &quot;root&quot;)</code></p>
    */
   public RawLineEntity_CfgForNeeder(R needer, EntityType type)  {
      this(needer, type, "root");
   }
   /**
      <p>Create a new instance for a sub-mode.</p>

      <p>This<ol>
         <li>Calls <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/analyze/validate/z/ValueValidator_CfgForNeeder.html#ValueValidator_CfgForNeeder(boolean, boolean, R)">super</a>(true, true, needer)</code></li>
         <li>Sets {@link com.github.xbn.linefilter.entity.raw.RawLineEntity#getName() getName}{@code ()}* to {@code name}.</li>
         <li>Calls {@link #resetRLECFN() resetRLECFN}{@code ()}</li>
      </ol></p>

    * @see  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="#RawLineEntity_CfgForNeeder(R, int, java.lang.String)">this</a>(R)</code>
    */
   public RawLineEntity_CfgForNeeder(R needer, EntityType type, String name)  {
      super(true, true, needer);
      this.name = name;
      this.type = type;
      resetRLECFN();
   }
   /**
      <p>Reverts configuration so a line never matches.</p>

    * <p>Equal to {@link #resetRLECFN() resetRLECFN}{@code ()}</p>

    * @return  <i>{@code this}</i>
    */
   public RawLineEntity_CfgForNeeder<L,M,R> reset()  {
      resetRLECFN();
      return  this;
   }
   /**
      <p>Reset configuration specific to this {@code RawLineEntity_CfgForNeeder}.</p>

      <p>This<ul>
         <li>Sets </li>
      </ul></p>
    */
   protected final void resetRLECFN()  {
      //Do not reset the name.
      dbgApblLineNums = null;
      filterIfNonNull = null;
      isRqd = false;
   }
   public String toString()  {
      return  super.toString() + ", getName()=" + getName() + ", getDebugApblLineNumbers()=" + getDebugApblLineNumbers();
   }
//getters...START
   public String getName()  {
      return  name;
   }
   public Appendable getDebugApblLineNumbers()  {
      return  dbgApblLineNums;
   }
   public EntityType getType()  {
      return  type;
   }
   public RawOnOffEntityFilter<L> getFilterIfNonNull()  {
      return  filterIfNonNull;
   }
   public boolean isRequired()  {
      return  isRqd;
   }
//getters...END
}
