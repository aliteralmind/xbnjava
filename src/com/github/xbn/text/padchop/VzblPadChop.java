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
   import  java.io.IOException;
   import  org.apache.commons.lang3.StringEscapeUtils;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.io.IOUtil;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.Copyable;
   import  com.github.xbn.lang.IllegalArgumentStateException;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.text.padchop.z.VzblPadChop_Fieldable;
/**
   <P>Highly configurable trimming, unescaping, padding, and chopping of a string.</P>

{@.codelet.and.out com.github.xbn.examples.text.padchop.VzblPadChopXmpl%eliminateCommentBlocksAndPackageDecl()}

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.text.padchop.z.VzblPadChop_Cfg VzblPadChop_Cfg}</H3>

   <P><UL>
      <LI><B>Used by:</B> <CODE>xbn.list.lister.<a href="../../list/lister/zL_CfgOverall.html#cfg">zL_CfgOverall</A></CODE> and <CODE><a href="../../list/lister/zL_CfgElement.html#cfg">zL_CfgElement</A></CODE></LI>
      </UL></LI>
      <LI><B>Sub configs:</B><UL>
         <LI><B><CODE><A HREF="ChopString.html#cfg">ChopString</A></CODE>:</B> {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgChop() cfgChop}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgChop(boolean) cfgChop}{@code (b)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgChop(int) cfgChop}{@code (b)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgChop(boolean, int) cfgChop}{@code (b,i)}<UL>
            <LI>{@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#chop(boolean) chop}{@code (b)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#chopFirst() chopFirst}{@code ()}</LI>
         </UL></LI>
         <LI><B><CODE><A HREF="PadString.html#cfg">PadString</A></CODE>:</B> {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgPad() cfgPad}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgPad(boolean) cfgPad}{@code (b)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgPad(int) cfgPad}{@code (i)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgPad(boolean, int) cfgPad}{@code (b,i)}<UL>
            <LI>{@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#pad(boolean) pad}{@code (b)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#padFirst() padFirst}{@code ()}</LI>
         </UL></LI>
      </UL>
      <LI><B>Pad-chop goal length:</B> {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#goalLen(int) goalLen}{@code (i)}</LI>
      <LI><B>EscapeAction:</B> {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#escape() escape}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#noEscape() noEscape}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#unescape() unescape}{@code ()}</LI>
      <LI><B>Trim:</B> {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#trim() trim}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#trim(boolean, boolean) trim}{@code (b,b)}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#trimLeft() trimLeft}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#trimRight() trimRight}{@code ()}</LI>
      <LI><B>Defaults:</B> {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#reset() reset}{@code ()}, {@link com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#reset(int) reset}{@code (i)}</LI>
   </UL></P>

 **/
public class VzblPadChop extends SimpleDebuggable implements ToStringAppendable, Copyable, Debuggable  {
   private boolean      bTrimR  = false;
   private boolean      bTrimL  = false;
   private EscapeAction eesc    = null;
   private boolean      bPad    = false;
   private boolean      bChop   = false;
   private PadString    ps      = null;
   private ChopString   cs      = null;
   private boolean      bPad1st = false;


//constructors...START
   /**
      <P>Create a new {@code VzblPadChop}.</P>


      @see  #VzblPadChop(VzblPadChop) this(padchop)
    **/
   public VzblPadChop(DifferentGoalLengths gl_da, VzblPadChop_Fieldable fieldable)  {
      super(fieldable);
      bTrimR =  fieldable.doTrimRight();
      bTrimL =  fieldable.doTrimLeft();
      eesc =    fieldable.getEscapeAction();
      bPad =    fieldable.doPad();
      ps =      fieldable.getPad();
      bChop =   fieldable.doChop();
      cs =      fieldable.getChop();
      bPad1st = fieldable.doPadFirst();

      try  {
         if(eesc == null)  {
            throw  new NullPointerException("fieldable.getEscapeAction()");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(fieldable, "fieldable", null, rx);
      }

/*

      try  {
         if(bChop  &&  cs.getGoalLen() == -1)  {
            throw  new IllegalArgumentStateException("fieldable.doChop() is true, but fieldable.getChop().getGoalLen() is -1.");
         }
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(cs, "fieldable.getChop()");
         CrashIfObject.nullOrReturnCause(ps, "fieldable.getPad()", null, rx);
      }
 */

      int iNewPadGl = ps.getGoalLen();   //Will be new after the next if-block
      int iNewChopGl = cs.getGoalLen();

      if(iNewPadGl != iNewChopGl)  {
         if(gl_da.doCrash())  {
            throw  new IllegalArgumentStateException("fieldable.getPad().getGoalLen() (" + iNewPadGl + ") and fieldable.getChop().getGoalLen() (" + cs.getGoalLen() + ") are different, and gl_da.doCrash() is true.");
         }

         if(gl_da.doUsePad())  {
            if(iNewPadGl == -1)  {
               throw  new IllegalArgumentStateException("fieldable.getPad().getGoalLen() is -1, fieldable.getChop().getGoalLen() is " + cs.getGoalLen() + ", and gl_da.doUsePad() is true");
            }
            iNewChopGl = iNewPadGl;
         }

         if(gl_da.doUseChop())  {
            if(ps.getGoalLen() == -1)  {
               throw  new IllegalArgumentStateException("fieldable.getChop().getGoalLen() is -1, fieldable.getPad().getGoalLen() is " + ps.getGoalLen() + ", and gl_da.doUseChop() is true");
            }
            iNewPadGl = iNewChopGl;
         }

         if(gl_da.doUseNonNeg1())  {
            if(iNewPadGl != -1)  {
               iNewChopGl = iNewPadGl;
            }  else  {
               iNewPadGl = iNewChopGl;
            }
         }
      }

      if(cs.getGoalLen() != iNewChopGl)  {
         cs = cs.getCopyNewGoalLen(iNewChopGl);
      }

      if(ps.getGoalLen() != iNewPadGl)  {
         ps = ps.getCopyNewGoalLen(iNewPadGl);
      }

      setDebug(getDebugApbl(), isDebugOn());  //See setDebugOn(apbl,b)
   }
   /**
      <P>Create a new {@code VzblPadChop} as a duplicate of another.</P>

      <P>This<OL>
      </OL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #VzblPadChop(DifferentGoalLengths, VzblPadChop_Fieldable) this(idgl,vpc_cfn)
    **/
   public VzblPadChop(VzblPadChop to_copy)  {
      super(to_copy);
      bTrimR =  to_copy.doTrimRight();
      bTrimL =  to_copy.doTrimLeft();
      eesc =    to_copy.getEscapeAction();
      bPad =    to_copy.doPad();
      ps =      to_copy.getPad();
      bChop =   to_copy.doChop();
      cs =      to_copy.getChop();
      bPad1st = to_copy.doPadFirst();
   }
//constructors...END
//getters...START
   /**
      <P>Is the string trimmed on the left side?.</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#trim(boolean, boolean) VzblPadChop_Cfg#trim(b,b)
      @see  #doTrimLeftRight()
      @see  #doTrimRight()
      @see  #getEscapeAction()
    **/
   public boolean doTrimLeft()  {
      return  bTrimL;
   }
   /**
      <P>Is the string trimmed on the right side?.</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#trim(boolean, boolean) VzblPadChop_Cfg#trim(b,b)
      @see  #doTrimLeft()
    **/
   public boolean doTrimRight()  {
      return  bTrimR;
   }
   /**
      <P>Will the string be escaped, unescaped, or left alone?.</P>

      @see  #doTrimLeft()
    **/
   public EscapeAction getEscapeAction()  {
      return  eesc;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgPad(boolean, int) VzblPadChop_Cfg#cfgPad(b,i)
      @see  #getPad()
    **/
   public boolean doPad()  {
      return  bPad;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgChop(boolean, int) VzblPadChop_Cfg#cfgChop(b,i)
      @see  #getPad()
    **/
   public boolean doChop()  {
      return  bChop;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgPad(boolean, int) VzblPadPad_Cfg#cfgPad(b,i)
      @see  #doChop()
      @see  #doPad()
      @see  #doPadChop()
      @see  #doPadFirst()
      @see  #getChop()
    **/
   public PadString getPad()  {
      return  ps;
   }
   /**
      <P>YYY</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#cfgChop(boolean, int) VzblPadChop_Cfg#cfgChop(b,i)
      @see  #getPad()
    **/
   public ChopString getChop()  {
      return  cs;
   }
   /**
      <P>When both padding and chopping are active, which occurs first?.</P>

      @see  com.github.xbn.text.padchop.z.VzblPadChop_CfgForNeeder#padFirst() VzblPadChop_Cfg#padFirst()
      @see  #getPad()
    **/
   public boolean doPadFirst()  {
      return  bPad1st;
   }
   /**
      <P>Is the string trimmed on both sides?.</P>

      @return  <CODE>({@link #doTrimLeft() doTrimLeft}() &nbsp;&amp;&amp; &nbsp;{@link #doTrimRight() doTrimRight}())</CODE>
      @see  #getPad()
    **/
   public boolean doTrimLeftRight()  {
      return  (doTrimLeft()  &&  doTrimRight());
   }
   /**
      <P>Is the string both padded and chopped?.</P>

      @return  <CODE>({@link #doPad() doPad}() &nbsp;&amp;&amp; &nbsp;{@link #doChop() doChop}())</CODE>
      @see  #getPad()
    **/
   public boolean doPadChop()  {
      return  (doPad()  &&  doChop());
   }
   public boolean doesNothing()  {
      int iStps = ((doTrimLeft()  ||  doTrimRight()) ? 1 : 0) +
         ((!getEscapeAction().isNothing()) ? 1 : 0) +
         (doPad() ? 1 : 0) +
         (doChop() ? 1 : 0);
      return  (iStps == 0);
   }
   public int getGoalLenFromPadChop()  {
      if(doPadChop())  {
         return  (doPadFirst()
            ?  getPad().getGoalLen()
         :  getChop().getGoalLen());
      }

      if(doPad())  {
         return  getPad().getGoalLen();
      }

      if(doChop())  {
         return  getChop().getGoalLen();
      }

      return  -1;
   }
//getters...END
//other...START
   public void setDebug(Appendable destination, boolean is_on)  {
      super.setDebug(destination, is_on);
      if(getChop() != null)  {  //null during construction! (see bottom of constructor)
         getChop().setDebug(destination, is_on);
      }
   }
   public void setDebugOn(boolean is_on)  {
      super.setDebugOn(is_on);
      if(getChop() != null)  {  //null during construction!
         getChop().setDebugOn(is_on);
      }
   }
   /**
      <P>Alter the string as configured.</P>

      @return  <CODE>{@link #get(int, Object) get}({@link #getGoalLenFromPadChop() getGoalLenFromPadChop}(), text)</CODE>
    **/
   public String get(Object text)  {
      return  get(getGoalLenFromPadChop(), text);
   }
   /**
      <P>Alter the string as configured, with a specific goal-length.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #appendX(Appendable, int, Object) appendX}{@code ((new StringBuilder()), goal_len, text)}</P>

      @param  text  May not be {@code null}.
      @return  {@code append((new StringBuilder()), goal_len, text).toString()}
    **/
   public String get(int goal_len, Object text)  {
      return  append((new StringBuilder()), goal_len, text).toString();
   }
   public Appendable append(Appendable to_appendTo, Object text)  {
      try  {
         return  appendX(to_appendTo, text);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("append", iox);
      }
   }
   /**
      <P>YYY</P>
    **/
   public final Appendable append(Appendable to_appendTo, int goal_len, Object text)  {
      try  {
         return  appendX(to_appendTo, goal_len, text);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("append", iox);
      }
   }
/*
   public Appendable appendln(Appendable to_appendTo, String prefix, Object text, String postfix)  {
      return  appendlns(1, to_appendTo, prefix, text, postfix);
   }
 */
   public Appendable appendlns(int new_lineCount, Appendable to_appendTo, String prefix, Object text, String postfix)  {
      try  {
         to_appendTo.append(prefix);
         appendX(to_appendTo, text).append(postfix);
         IOUtil.appendNewLinesX(new_lineCount, to_appendTo);
         return  to_appendTo;
      }  catch(IOException  iox)  {
         throw  new RuntimeException("appendln(i,apbl,s,O,s)", iox);
      }
   }
   public Appendable appendln(Appendable to_appendTo, int goal_len, String prefix, Object text, String postfix)  {
      return  appendlns(1, to_appendTo, goal_len, prefix, text, postfix);
   }
   public Appendable appendlns(int new_lineCount, Appendable to_appendTo, int goal_len, String prefix, Object text, String postfix)  {
      try  {
         to_appendTo.append(prefix);
         appendX(to_appendTo, goal_len, text).append(LINE_SEP);
         IOUtil.appendNewLinesX(new_lineCount, to_appendTo);
         return  to_appendTo.append(postfix);
      }  catch(IOException  iox)  {
         throw  new RuntimeException("appendln(i,apbl,i,s,O,s)", iox);
      }
   }
   /**
      <P>Alter the string as configured.</P>

      @return  <CODE>{@link #appendX(Appendable, int, Object) appendX}(to_appendTo, text, {@link #getGoalLenFromPadChop() getGoalLenFromPadChop}())</CODE>
    **/
   public Appendable appendX(Appendable to_appendTo, Object text) throws IOException  {
      return  appendX(to_appendTo, getGoalLenFromPadChop(), text);
   }
   public final Appendable appendX(Appendable to_appendTo, int goal_len, Object text) throws IOException  {
      return  VzblPadChop.appendX(this, to_appendTo, goal_len, text);
   }

   /**
      <P>Format a string as configured.</P>

      <P>This:<OL>
         <LI>If {@code text} is {@code null}, this returns {@code null}.</LI>
         <LI>Otherwise, the string is<OL>
            <LI>Trimmed <CODE>({@link #doTrimLeftRight() doTrimLeftRight}())</CODE></LI>
            <LI>Unescaped <CODE>(@code getConfig().{@link #getEscapeAction() getEscapeAction}())</CODE></LI>
            <LI>Padded/chopped <CODE>(getConfig().{@link #doPad() doPad}(), {@link #doChop() doChop}())</CODE></LI>
         </OL></LI>
      </OL></P>

      @param  vpc  May not be {@code null}.
      @param  to_appendTo  May not be {@code null}.
      @param  text  The string to chop.
      @param  goal_len  The goal length to chop to. May not be less than one.
    **/
   public static final Appendable appendX(VzblPadChop vpc, Appendable to_appendTo, int goal_len, Object text) throws IOException  {

      if(text == null)  {
         text = "null";
      }
      String s = text.toString();
      try  {
         if(vpc.isDebugOn())  {
            vpc.getDebugAptr().appentln("<VPC> goal_len="+ goal_len + ", text:" + s.length());
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(vpc, "vpc", null, rx);
      }

//System.out.println("vpc1 text=" + text + "");

      if(vpc.doTrimLeftRight())  {
//System.out.println("vpc2");
         s = s.trim();
      }  else  if(vpc.doTrimLeft())  {
//System.out.println("vpc3");
         s = StringUtil.ltrim(s);
      }  else if(vpc.doTrimRight())  {
//System.out.println("vpc4");
         s = StringUtil.rtrim(s);
      }
//System.out.println("vpc5");

      if(vpc.getEscapeAction().isEscape())  {
         s = StringEscapeUtils.escapeJava(s);
      }	else if(vpc.getEscapeAction().isUnescape())  {
         s = StringEscapeUtils.unescapeJava(s);
      }

      if(vpc.doPadChop())  {
         if(vpc.isDebugOn())  {
            appendPadChoppedXWDbg(vpc, to_appendTo, goal_len, s);
         }  else  {
            if(vpc.doPadFirst())  {
               vpc.getChop().appendChoppedX(to_appendTo, vpc.getPad().getPadded(goal_len, s));
            }  else  {
               vpc.getPad().appendPaddedX(to_appendTo, vpc.getChop().getChopped(goal_len, s));
            }
         }
         return  to_appendTo;
      }

      if(vpc.doPad())  {
         vpc.getPad().appendPaddedX(to_appendTo, goal_len, s);
      }  else if(vpc.doChop())  {
         vpc.getChop().appendChoppedX(to_appendTo, goal_len, s);
      }
      return  to_appendTo;
   }
      private static final void appendPadChoppedXWDbg(VzblPadChop vpc, Appendable to_appendTo, int goal_len, String so_far)  throws IOException  {
         if(vpc.doPadFirst())  {
            so_far = vpc.getPad().getPadded(goal_len, so_far);
            vpc.getDebugAptr().appentln("<VPC> pad-first: Padded:  [" + so_far + "]");
            so_far = vpc.getChop().getChopped(goal_len, so_far);
            vpc.getDebugAptr().appentln("<VPC> pad-first: Chopped: [" + so_far + "]");
         }  else  {
            so_far = vpc.getChop().getChopped(goal_len, so_far);
            vpc.getDebugAptr().appentln("<VPC> chop-first: Chopped: [" + so_far + "]");
            so_far = vpc.getPad().getPadded(goal_len, so_far);
            vpc.getDebugAptr().appentln("<VPC> chop-first: Padded:  [" + so_far + "]");
         }
         to_appendTo.append(so_far);
      }

   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append(this.getClass().getName()).append(": ");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      if(doesNothing())  {
         return  to_appendTo.append("does nothing");
      }

      int iStp = 0;
      if(doTrimLeft())  {
         if(doTrimRight())  {
            to_appendTo.append(++iStp).append("=trim");
         }  else  {
            to_appendTo.append(++iStp).append("=trim-left");
         }
      }  else if(doTrimRight())  {
         to_appendTo.append(++iStp).append("=trim-right");
      }

      boolean b1StepSoFar = (iStp > 0);

      if(!getEscapeAction().isNothing())  {
         StringUtil.appendIfTrueFalse(to_appendTo, ", ", b1StepSoFar, null);
         to_appendTo.append(++iStp).append("=").append(getEscapeAction().name().toLowerCase());
         b1StepSoFar = true;
      }

      if(doPad())  {
         StringUtil.appendIfTrueFalse(to_appendTo, ", ", b1StepSoFar, null);
         if(doChop())  {
            if(doPadFirst())  {
               appendPadChopTS(to_appendTo, ++iStp, getPad()).append(", ");
               appendPadChopTS(to_appendTo, ++iStp, getChop());
            }  else  {
               appendPadChopTS(to_appendTo, ++iStp, getChop()).append(", ");
               appendPadChopTS(to_appendTo, ++iStp, getPad());
            }
         }
      }  else if(doChop())  {
         StringUtil.appendIfTrueFalse(to_appendTo, ", ", b1StepSoFar, null);
         appendPadChopTS(to_appendTo, ++iStp, getChop());
      }

      return  to_appendTo;
   }
      private static final StringBuilder appendPadChopTS(StringBuilder to_appendTo, int step_num, PadChopBase pc_base)  {
         return  to_appendTo.append(step_num).append("=<").append(pc_base).append(">");
      }
   /**
      <P>Duplicate this {@code VzblPadChop}</P>

      @return  <CODE>(new {@link #VzblPadChop(VzblPadChop) VzblPadChop}(this))</CODE>
    **/
   public VzblPadChop getObjectCopy()  {
      return  (new VzblPadChop(this));
   }
//other...END
}
