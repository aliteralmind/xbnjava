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
   import  com.github.xbn.io.SimpleDebuggable;
   import  com.github.xbn.io.Debuggable;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.text.padchop.z.ChopString_Fieldable;
   import  com.github.xbn.io.IOUtil;
   import  java.io.IOException;
   import  com.github.xbn.lang.CrashIfObject;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Chop a string at a particular location (left, middle, right), and with-or-without an ellipsis.</P>

{@.codelet.and.out com.github.xbn.examples.text.padchop.ChopStringXmpl:eliminateCommentBlocksAndPackageDecl()}


{@.codelet.and.out com.github.xbn.examples.text.padchop.CharsBeforeChopXmpl:eliminateCommentBlocksAndPackageDecl()}

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.text.padchop.z.ChopString_Cfg ChopString_Cfg}</H3>

   <P><UL>
      <LI><B>Used by:</B> {@code <A HREF="VzblPadChop.html#cfg">VzblPadChop</A>}</LI>
      <LI>{@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#goalLen(int) goalLen}{@code (i)}</LI>
      <LI><B>Side:</B> {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#left() left}{@code ()}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#right() right}{@code ()}</LI>
      <LI><B>Ellipsis (dot-dot-dot):</B><UL>
         <LI><B>String:</B> {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#noDDD() noDDD}{@code ()}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#ddd() ddd}{@code ()}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#ddd(String) ddd}{@code (s)}</LI>
         <LI><B>Location (chars before):</B> {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#charsBefore(int) charsBefore}{@code (i)}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#inMiddle() inMiddle}{@code ()}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#atEnd() atEnd}{@code ()}</LI>
         <LI><B>Overhang:</B> {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#overhang(int) overhang}{@code (i)}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#noOverhang() noOverhang}{@code ()}, {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#maxOverhang() maxOverhang}{@code ()}</LI>
      </UL></LI>
   </UL></P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ChopString extends PadChopBase implements Debuggable, ToStringAppendable  {
//state
   private final int iChrsB4Ddd;
   private final int iDddOH;
   private final String sDdd;
//internal
   private final SimpleDebuggable sg;
//public
   private static final int iLOCATION_IGNORED = -3;
   public static final int iIN_MIDDLE = -1;
   public static final int iAT_END = -2;
   /**
      <P>A good test string.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; &quot;{@code ---------A---------B---------C---------D---------E---------F---------G---------H---------I---------J---------K---------L---------M---------N---------O---------P---------Q---------R---------S---------T---------U---------V---------W---------X---------Y---------Z}&quot;</P>
    **/
   public static final String sGOOD_TEST_STRING = "---------A---------B---------C---------D---------E---------F---------G---------H---------I---------J---------K---------L---------M---------N---------O---------P---------Q---------R---------S---------T---------U---------V---------W---------X---------Y---------Z";
//constructors...START
   /**
      <P>Create a new {@code ChopString}.</P>

      <P>This first calls {@link PadChopBase#PadChopBase(PadChopBase_Fieldable) super}{@code (cs_c)}, and sets <I>and validates</I> all internal variable as set into {@link com.github.xbn.text.padchop.z.ChopString_CfgForNeeder ChopString_CfgForNeeder}.</P>

      @see  #ChopString(ChopString) this(cs)
      @see  #ChopString(ChopString, int) this(cs,i)
    **/
   public ChopString(ChopString_Fieldable fieldable)  {
      super(fieldable);
      sg = new SimpleDebuggable(fieldable);

      sDdd = fieldable.getEllipsis();

      if(sDdd != null)  {
         iChrsB4Ddd = fieldable.getCharsBeforeDDD();
         iDddOH = fieldable.getOverhangCount();

         if(getGoalLen() != -1  &&  getEllipsis().length() > getGoalLen())  {
            throw  new IllegalArgumentException("ellipsis is non-null, but its length is greater than getGoalLen() (" + getGoalLen() + ").");
         }
         if(iChrsB4Ddd < -2)  {
            throw  new IllegalArgumentException("fieldable.getCharsBeforeDDD() (" + iChrsB4Ddd + ") is less than -2.");
         }

      }  else  {
         //Not used when no ellipsis
         iChrsB4Ddd = ChopString.iLOCATION_IGNORED;
         iDddOH = -1;
      }

   }
   /**
      <P>Create a new {@code ChopString} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link PadChopBase#PadChopBase(PadChopBase, int) super}{@code (to_copy, -2)}</P>
    **/
   public ChopString(ChopString to_copy)  {
      this(to_copy, -2);
   }
   /**
      <P>Create a new {@code ChopString} as a duplicate of another, with a potentially-new goal-length.</P>

      <P>This<OL>
         <LI>Calls {@link PadChopBase#PadChopBase(PadChopBase, int) super}{@code (to_copy, new_goalLen)}</LI>
         <LI>Sets<OL>
            <LI>{@link #getEllipsis() getEllipsis}{@code ()} to <CODE>to_copy.{@link #getEllipsis() getEllipsis}()</CODE></LI>
            <LI>{@link #getCharsBeforeDDD() getCharsBeforeDDD}{@code ()} to <CODE>to_copy.{@link #getCharsBeforeDDD() getCharsBeforeDDD}()</CODE> &nbsp; &nbsp; <I>(This is the value returned when it is between zero and <CODE><I>[{@link PadChopBase super}]</I>.{@link PadChopBase#getGoalLen() getGoalLen}()</CODE>, inclusive)</I></LI>
            <LI>{@link #getOverhangCount() getOverhangCount}{@code ()} to <CODE>to_copy.{@link #getOverhangCount() getOverhangCount}()</CODE> &nbsp; &nbsp; <I>(This is the value returned when it is between zero and {@code <I>[super]</I>.getGoalLen()}, inclusive)</I></LI>
         </OL></LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #ChopString(xbn.text.padchop.z.ChopString_Fieldable) this(cs_f)
    **/
   public ChopString(ChopString to_copy, int new_goalLen)  {
      super(to_copy, new_goalLen);
      sg = new SimpleDebuggable(to_copy);
      sDdd = to_copy.getEllipsis();
      iChrsB4Ddd = to_copy.getCharsBeforeDDD();
      iDddOH = to_copy.getOverhangCount();
   }
//constructors...END
//getters...START
   /**
      <P>The ellipsis (dot-dot-dot) that indicates the string was chopped.</P>

      @return  {@code null} If there is no ellipsis.
      @see  com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#ddd(String) ChopString_CfgForNeeder#ddd(s)
    **/
   public final String getEllipsis()  {
      return  sDdd;
   }
   /**
      <P>The ellipsis chars-before sub-setting.</P>

      @see  com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#charsBefore(int) ChopString_CfgForNeeder#charsBefore(i)
    **/
   public final int getCharsBeforeDDD()  {
      return  iChrsB4Ddd;
   }
   /**
      <P>The number of characters that, at a maximum, the ellipsis can exceed the chopped string.</P>

      @return  A number between zero and <CODE>{@link #getEllipsis() getEllipsis}().length()</CODE>, inclusive. When {@code getEllipsis()} is {@code null}, this returns zero.
      @see  com.github.xbn.text.padchop.z.ChopString_CfgForNeeder#overhang(int) ChopString_CfgForNeeder#overhang(i)
    **/
   public final int getOverhangCount()  {
      return  iDddOH;
   }
//getters...END
//other...START
   /**
      <P>Duplicate this {@code ChopString}.</P>

      @return  <CODE>(new {@link #ChopString(ChopString) ChopString}(this))</CODE>
    **/
   public ChopString getObjectCopy()  {
      return  (new ChopString(this));
   }
   /**
      <P>Duplicate this {@code ChopString}, with a new goal-length.</P>


      @return  <CODE>(new {@link #ChopString(ChopString) ChopString}(this))</CODE>
    **/
   public ChopString getCopyNewGoalLen(int goal_len)  {
      return  (new ChopString(this, goal_len));
   }
   /**
      <P>Chop the string as configured.</P>

      @return  <CODE>{@link #getChopped(int, Object) getChopped}({@link PadChopBase#getGoalLen() getGoalLen}(), str_toPad)</CODE>
    **/
   public String getChopped(Object str_toPad)  {
      return  getChopped(getGoalLen(), str_toPad);
   }
   /**
      <P>Chop the string as configured, with a specific goal-length.</P>

      @return  {@code appendChopped((new StringBuilder()), goal_len, str_toPad).toString()}
    **/
   public String getChopped(int goal_len, Object str_toPad)  {
      return  appendChopped((new StringBuilder()), goal_len, str_toPad).toString();
   }
   /**
      <P>Chop the string as configured.</P>

      @return  {@link #appendChoppedX(Appendable, Object) appendChoppedX(to_appendTo, str_toPad)}
    **/
   public Appendable appendChopped(Appendable to_appendTo, Object str_toPad)  {
      try  {
         return  appendChoppedX(to_appendTo, str_toPad);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("appendChopped", iox);
      }
   }
   public Appendable appendChopped(Appendable to_appendTo, int goal_len, Object str_toPad)  {
      try  {
         return  appendChoppedX(to_appendTo, goal_len, str_toPad);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("appendChopped", iox);
      }
   }
   public Appendable appendChoppedlns(int newLine_count, Appendable to_appendTo, Object str_toPad)  {
      try  {
         appendChoppedX(to_appendTo, str_toPad);
         return  IOUtil.appendNewLinesX(newLine_count, to_appendTo);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("appendChoppedln(i,apbl,O)", iox);
      }
   }
   public Appendable appendChoppedlns(int newLine_count, Appendable to_appendTo, int goal_len, Object str_toPad)  {
      try  {
         appendChoppedX(to_appendTo, goal_len, str_toPad).append(LINE_SEP);
         return  IOUtil.appendNewLinesX(newLine_count, to_appendTo);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("appendChoppedln(i,apbl,i,O)", iox);
      }
   }
   public Appendable appendChoppedX(Appendable to_appendTo, Object str_toPad) throws IOException  {
      return  appendChoppedX(to_appendTo, getGoalLen(), str_toPad);
   }
   public Appendable appendChoppedX(Appendable to_appendTo, int goal_len, Object str_toPad) throws IOException  {
      return  ChopString.appendChoppedX(this, to_appendTo, goal_len, str_toPad);
   }
   public void setDebug(Appendable destination, boolean is_on)  {
      sg.setDebug(destination, is_on);
   }
   public void setDebugOn(boolean is_on)  {
      sg.setDebugOn(is_on);
   }
   public boolean isDebugOn()  {
      return  sg.isDebugOn();
   }
   public TextAppenter getDebugAptr()  {
      return  sg.getDebugAptr();
   }
   public Appendable getDebugApbl()  {
      return  sg.getDebugApbl();
   }
   public final TextAppenter debug(Object message)  {
      return  sg.debug(message);
   }
   public final void debugln(Object message)  {
      sg.debugln(message);
   }
   /**
      <P>Chop the string as configured, with a specific goal-length.</P>

      @param  to_appendTo  May not be {@code null}.
      @param  str_toPad  The string to chop.
      @param  goal_len  The goal length to chop to. May not be less than one.

      @see  #appendChopped(Appendable, Object) appendChopped(apbl,o)
      @see  #getChopped(Object) getChopped(o)
      @see  #getChopped(int, Object) getChopped(o,i)
    **/
   public static final Appendable appendChoppedX(ChopString chpr, Appendable to_appendTo, int goal_len, Object str_toPad) throws IOException  {
      goal_len = PadChopBase.getCIBGoalLenForOutput(goal_len, "Chopp");
      if(str_toPad == null)  {
         to_appendTo.append("null");
         return  to_appendTo;
      }
      String s = str_toPad.toString();

      try  {
         if(chpr.isDebugOn())  {
            chpr.getDebugAptr().appentln("<CS> goal_len="+ goal_len + ", str_toPad:" + s.length() + ", this=" + chpr);
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(chpr, "chpr", null, rx);
      }

      int iLen = s.length();

      if(goal_len >= iLen)  {
         if(chpr.isDebugOn())  {
            chpr.getDebugAptr().appentln("<CS> Goal length > string length. Nothing to do.");
         }
         to_appendTo.append(s);
         return  to_appendTo;
      }

      String sDdd = chpr.getEllipsis();

      if(sDdd == null)  {
         int ixLeft = (chpr.isSideRight() ? 0
            :  iLen - goal_len);
         int ixxRight = (chpr.isSideRight() ? goal_len
            :  iLen);

         if(chpr.isDebugOn())  {
            chpr.getDebugAptr().appentln("<CS> No ellipsis. Chopping at end. keep-idxs=[" + ixLeft + "," + ixxRight + "]");
         }

         to_appendTo.append(s, ixLeft, ixxRight);
         return  to_appendTo;
      }

      //There is an ellipsis.

      int iDDDLen = sDdd.length();
      int iGoalPlusOH = goal_len + chpr.getOverhangCount();

      if(iDDDLen > iGoalPlusOH)  {
         throw  new IllegalStateException("The ellipsis won't fit. chpr.getEllipsis()=\"" + sDdd + "\", goal_len (" + goal_len + "), chpr.getOverhangCount() (" + chpr.getOverhangCount() + ").");
      }

      //The ellipsis, including its overhang, will fit without having to overhang.

      if(goal_len <= iDDDLen)  {
         to_appendTo.append(sDdd);

         if(chpr.isDebugOn())  {
            chpr.getDebugAptr().appentln("<CS> Ellipsis (length=" + sDdd.length() + ") larger than goal length. Only ellipsis printed.");
         }

         return  to_appendTo;
      }

      //There's at least one character beyond the ellipsis to display.
      if(chpr.getCharsBeforeDDD() == iIN_MIDDLE)  {
         int iHalfGoal = goal_len >>> 1;

         //Now take half of the length of the ellipsis away from that
         //(ignoring the overhang).
         iHalfGoal -= iDDDLen >>> 1;

         int iStart2ndHalf = s.length() - iHalfGoal + 1;

         if(chpr.isDebugOn())  {
            chpr.getDebugAptr().appentln("<CS> Chopping in middle. idxs-part1=[0," + iHalfGoal + "], part2=[" + iStart2ndHalf + ", " + s.length() + "]");
         }

         to_appendTo.append(s, 0, iHalfGoal).
            append(sDdd).
            append(s, iStart2ndHalf, s.length());
         return  to_appendTo;
      }

      if(chpr.getCharsBeforeDDD() == iAT_END)  {
         if(chpr.isSideRight())  {
            to_appendTo.append(s, 0, (goal_len - iDDDLen + chpr.getOverhangCount())).
               append(sDdd);
         }  else  {
            to_appendTo.append(sDdd).append(s, (goal_len + iDDDLen - chpr.getOverhangCount()), s.length());
         }

         if(chpr.isDebugOn())  {
            chpr.getDebugAptr().appentln("<CS> Chopping at end (side=" + chpr.isSideRight() + ")");
         }

         return  to_appendTo;
      }

      //Chop at getCharsBeforeDDD()

      int iB4DDD = chpr.getCharsBeforeDDD();

      if(chpr.isDebugOn())  {
         chpr.getDebugAptr().appentln("<CS> Chopping at specific number of characters: chpr.getCharsBeforeDDD()=" + chpr.getCharsBeforeDDD());
      }

      if((iB4DDD + iDDDLen) > iGoalPlusOH)  {
         iB4DDD -= (iB4DDD + iDDDLen) - iGoalPlusOH;
      }
      int iB4PlusDDD = iB4DDD + iDDDLen;
      int iPostDDDChars = goal_len - iB4PlusDDD;
      if(iPostDDDChars < 0)  {
         //There's an overhang.
         iPostDDDChars = 0;
      }

      if(chpr.isSideRight())  {
         to_appendTo.append(s, 0, iB4DDD).append(sDdd).
            append(s, (s.length() - iPostDDDChars), s.length());
      }  else  {
         to_appendTo.append(sDdd).append(s, 0, iPostDDDChars).
            append(s, (s.length() - iB4DDD), s.length());
      }

      return  to_appendTo;
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append(super.toString());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      if(getEllipsis() == null)  {
         return  to_appendTo.append(", no ellipsis (other settings ignored)");
      }

      to_appendTo.append(", ddd=\"").append(getEllipsis()).append("\"");

      to_appendTo.append(", location=");
      if(getCharsBeforeDDD() == ChopString.iIN_MIDDLE)  {
         to_appendTo.append("middle");
      }  else if(getCharsBeforeDDD() == ChopString.iAT_END)  {
         to_appendTo.append("end");
      }  else  {
         to_appendTo.append("after " + getCharsBeforeDDD() + " chars");
      }

      if(getOverhangCount() > 0)  {
         to_appendTo.append(", overhang=").append(getOverhangCount());
      }

      return  to_appendTo;
   }
//other...END
}
