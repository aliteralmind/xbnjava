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
package  com.github.xbn.text.padchop;
   import  com.github.xbn.text.padchop.z.PadChopBase_Fieldable;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>. The base class for {@code PadString} and {@code ChopString}. See {@link com.github.xbn.text.padchop.PadString PadString} and {@link com.github.xbn.text.padchop.ChopString ChopString}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class PadChopBase implements Copyable  {
   private final int iGoal;
   private final boolean bSideR;
//constructors...START
   /**
      <p>Create a new {@code PadChopBase} with defaults.</p>

    * @see  #PadChopBase(PadChopBase)
    * @see  #PadChopBase(PadChopBase, int)
    */
   public PadChopBase(PadChopBase_Fieldable fieldable)  {
      iGoal = getCIBGoalLenForCnstr(fieldable.getGoalLen(), "fieldable.getGoalLen()");
      bSideR = fieldable.isSideRight();
   }
      private int getCIBGoalLenForCnstr(int goal_len, String var_name)  {
         if(goal_len < -1  ||  goal_len == 0)  {
            throw  new IllegalArgumentException(var_name + " is less than -1, or equal to zero.");
         }
         return  goal_len;
      }
   /**
      <p>YYY</p>

    * @see  #PadChopBase(xbn.text.padchop.z.PadChopBase_Fieldable) this(fieldable)
    * @see  #PadChopBase(PadChopBase, int)
    */
   public PadChopBase(PadChopBase to_copy)  {
      this(to_copy, -2);
   }
   /**
      <p>Create a new {@code PadChopBase} as a duplicate of another, with a potentially-new goal-length.</p>

      <p>This<ol>
         <li>Sets {@link #getGoalLen() getGoalLen}{@code ()} as described below.</li>
         <li>Sets {@link #isSideRight() isSideRight}{@code ()} to {@code to_copy.isSideRight())}</li>
      </ol>

    * @param  to_copy  May not be {@code null}.
    * @param  new_goalLen  The new goal length. If {@code -2}, this is ignored, and {@code to_copy.getGoalLen()} is used in its place.
    * @see  #PadChopBase(xbn.text.padchop.z.PadChopBase_Fieldable) this(pcb_f)
    * @see  #PadChopBase(PadChopBase)
    */
   public PadChopBase(PadChopBase to_copy, int new_goalLen)  {
      try  {
         iGoal = getCIBGoalLenForCnstr((new_goalLen != -2) ? new_goalLen
            :  to_copy.getGoalLen(), "new_goalLen");
         bSideR = to_copy.isSideRight();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
   }
//constructors...END
//getters...START
   /**
      <p>Get the length to pad-or-chop to.</p>

    * @see  PadChopBase#PadChopBase(PadChopBase_Fieldable) this(pcb_f)
    */
   public int getGoalLen()  {
      return  iGoal;
   }
   /**
      <p>Is the right side of the string altered?.</p>

    * @see  PadChopBase#PadChopBase(PadChopBase_Fieldable) this(pcb_f)
    */
   public boolean isSideRight()  {
      return  bSideR;
   }
//getters...END
   public String toString()  {
      return  this.getClass().getName() + ": goal=" + getGoalLen() + ", side=" + (isSideRight() ? "right" : "left");
   }
   protected static final int getCIBGoalLenForOutput(int goal_len, String padd_orChopp)  {
      if(goal_len < 1)  {
         throw  new IllegalArgumentException("output" + padd_orChopp + "ed(o,i): goal_len (" + goal_len + ") is less than one. Must setGoalLen(i).");
      }
      return  goal_len;
   }
   /**
      <p>Duplicate this {@code PadChopBase}, with a new goal-length.</p>
    */
   public abstract PadChopBase getCopyNewGoalLen(int goal_len);
}
