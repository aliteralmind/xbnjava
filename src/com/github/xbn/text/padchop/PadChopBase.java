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
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <P>. The base class for {@code PadString} and {@code ChopString}. See {@link com.github.xbn.text.padchop.PadString PadString} and {@link com.github.xbn.text.padchop.ChopString ChopString}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class PadChopBase implements Copyable  {
   private final int iGoal;
   private final boolean bSideR;
//constructors...START
   /**
      <P>Create a new {@code PadChopBase} with defaults.</P>

      @see  #PadChopBase(PadChopBase)
      @see  #PadChopBase(PadChopBase, int)
    **/
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
      <P>YYY</P>

      @see  #PadChopBase(xbn.text.padchop.z.PadChopBase_Fieldable) this(fieldable)
      @see  #PadChopBase(PadChopBase, int)
    **/
   public PadChopBase(PadChopBase to_copy)  {
      this(to_copy, -2);
   }
   /**
      <P>Create a new {@code PadChopBase} as a duplicate of another, with a potentially-new goal-length.</P>

      <P>This<OL>
         <LI>Sets {@link #getGoalLen() getGoalLen}{@code ()} as described below.</LI>
         <LI>Sets {@link #isSideRight() isSideRight}{@code ()} to {@code to_copy.isSideRight())}</LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @param  new_goalLen  The new goal length. If {@code -2}, this is ignored, and {@code to_copy.getGoalLen()} is used in its place.
      @see  #PadChopBase(xbn.text.padchop.z.PadChopBase_Fieldable) this(pcb_f)
      @see  #PadChopBase(PadChopBase)
    **/
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
      <P>Get the length to pad-or-chop to.</P>

      @see  PadChopBase#PadChopBase(PadChopBase_Fieldable) this(pcb_f)
    **/
   public int getGoalLen()  {
      return  iGoal;
   }
   /**
      <P>Is the right side of the string altered?.</P>

      @see  PadChopBase#PadChopBase(PadChopBase_Fieldable) this(pcb_f)
    **/
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
      <P>Duplicate this {@code PadChopBase}, with a new goal-length.</P>
    **/
   public abstract PadChopBase getCopyNewGoalLen(int goal_len);
}
