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
package  com.github.xbn.number;
   import  java.util.Objects;
   import  com.github.xbn.lang.XInfoAccumulator;
   import  com.github.xbn.lang.CrashIfObject;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.IllegalArgumentStateException;
/**
   <P>Determines if an int is within an {@code IntRange}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IntInRange extends NumberInRange<Integer> implements IntRange  {
//internal
//public
   /**
      <P>An instance no bounds--Equal to <CODE>new {@link #IntInRange() IntInRange}()</CODE></P>
    **/
   public static final IntInRange UNRESTRICTED = new IntInRange();
//constructors...START
   /**
      <P>Create a new unrestricted instance.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link NumberInRange#NumberInRange super}{@code ()}</P>
      @see  #IntInRange(IntBound, IntBound) IntInRange(nb,nb)
    **/
   public IntInRange()  {
      super();
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #IntInRange(int, int, String, String) this}(min, max, null, null)</CODE></P>
    **/
   public IntInRange(int min, int max)  {
      this(min, max, null, null);
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #IntInRange(IntBound, IntBound) this}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), new IntBoundInclusive(max, max_name))</CODE></P>
    **/
   public IntInRange(int min, int max, String min_name, String max_name)  {
      this(new IntBoundInclusive(min, min_name), new IntBoundInclusive(max, max_name));
   }
   /**
      <P>Create a new instance with bounds.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link NumberInRange#NumberInRange(NumberBound, NumberBound) super}{@code (min, max)}</P>

      @see  #IntInRange()
      @see  #IntInRange(int, int) IntInRange(i,i)
      @see  #IntInRange(int, int, String, String) IntInRange(i,i,s,s)
      @see  #IntInRange(IntInRange) IntInRange(iir)
    **/
   public IntInRange(IntBound min, IntBound max)  {
      super(min, max);
   }
   /**
      <P>Create a new instance as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link NumberInRange#NumberInRange(NumberInRange) super}{@code (to_copy)}</LI>
      </UL></P>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #IntInRange(IntBound, IntBound) IntInRange(nb,nb)
    **/
   public IntInRange(IntInRange to_copy)  {
      super(to_copy);
   }
//constructors...END
//setters...START
/*
   public IntInRange extraErrInfo(Object info)  {
      setExtraErrInfo(info);
      return  this;
   }
 */
   /**
      <P>If the bounds of this {@code IntInRange} are invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>IntInRange.{@link #crashIfBadBounds(IntBound, IntBound, String, String, Object) crashIfBadBounds}({@link com.github.xbn.number.NumberInRange#getMinBound() getMinBound}(), {@link com.github.xbn.number.NumberInRange#getMaxBound() getMaxBound}, &quot;getMinBound()&quot;, &quot;getMaxBound()&quot;, {@link com.github.xbn.lang.ExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}())</CODE></P>
    **/
   public void crashIfBadBoundsForCnstr()  {
      IntInRange.crashIfBadBounds(getMinBound(), getMaxBound(), "getMinBound()", "getMaxBound()", getExtraErrInfo());
   }
//setters...END
//getters...START
//getters: atomic...START
   public IntBound getMinBound()  {
      return  (IntBound)super.getMinBound();
   }
   public IntBound getMaxBound()  {
      return  (IntBound)super.getMaxBound();
   }
   /**
      <P>Get the minimum bound int.</P>

      @return   <CODE><I>[{@link NumberInRange super}]</I>.{@link NumberInRange#getMinNumber() getMinNumber}().intValue()</CODE>

      @see
         <LI>{@link #getMax() getMax}{@code ()}</LI>
      </UL>
    **/
   public int getMin()  {
      return  getMinNumber().intValue();
   }
   /**
      <P>Get the maximum bound int.</P>

      @return   <CODE><I>[{@link NumberInRange super}]</I>.{@link NumberInRange#getMaxNumber() getMaxNumber}().intValue()</CODE>

      @see
         <LI>{@link #getMin() getMin}{@code ()}</LI>
      </UL>
    **/
   public int getMax()  {
      return  getMaxNumber().intValue();
   }
//getters: atomic...END
   /**
      @return  <CODE>(new {@link #IntInRange(IntInRange) IntInRange}(this))</CODE>
    **/
   public IntInRange getObjectCopy()  {
      return  (new IntInRange(this));
   }
//getters...END
//other...START
   public boolean isValidInclusiveRange(Integer min, Integer max)  {
      try  {
         return  ((min.compareTo(max) <= 0)  &&     //min <= max
            isValid(min)  &&  isValid(max));
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(min, "min");
         throw  CrashIfObject.nullOrReturnCause(max, "max", null, rx);
      }
   }
   public boolean isValidInclusiveRange(int min, int max)  {
      return  isValidInclusiveRange((new Integer(min)), (new Integer(max)));
   }



   public boolean isGTOEMinGivenIncl(Integer num)  {
      return  (getInclMinComparedTo(num) <= 0);
   }
   public boolean isLTOEMaxGivenIncl(Integer num)  {
      return  (getInclMaxComparedTo(num) >= 0);
   }
   public Integer getInclMinComparedToOrIfNoMin(Integer I_toCompare, Integer I_ifNoMin)  {
      return  (hasMin()
         ?  getInclMinComparedTo(I_toCompare)
         :  I_ifNoMin);
   }
   public Integer getInclMaxComparedToOrIfNoMax(Integer I_toCompare, Integer I_ifNoMax)  {
      return  (hasMax()
         ?  getInclMaxComparedTo(I_toCompare)
         :  I_ifNoMax);
   }
   /**
      <P>If a range's min is greater than max, or either are outside of the bounds <I>as configured in this class</I>, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #crashIfBadRange(int, int, String, String) crashIfBadRange}(min, max, &quot;min&quot;, &quot;max&quot;)</CODE></P>
    **/
   public void crashIfBadRange(int min, int max)  {
      crashIfBadRange(min, max, "min", "max");
   }
   /**
      <P>If a range's min is greater than max, or either are outside of the bounds <I>as configured in this class</I>, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>IntInRange.{@link #crashIfBadRange(IntInRange, int, int, String, String, Object) crashIfBadRange}(this, min, max, min_name, max_name, {@link com.github.xbn.lang.AbstractExtraErrInfoable#getExtraErrInfo() getExtraErrInfo}()*)</CODE></P>
    **/
   public void crashIfBadRange(int min, int max, String min_name, String max_name)  {
      IntInRange.crashIfBadRange(this, min, max, min_name, max_name, getExtraErrInfo());
   }
   public void crashIfBadValue(int num, String int_objName)  {
      crashIfBadIntObject(num, int_objName);
   }
   /**
      <P>If a standalone-int is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>IntInRange.{@link #crashIfBadIntObject(IntInRange, Integer, String) crashIfBadIntObject}(this, num, int_objName)</CODE></P>
    **/
   public void crashIfBadIntObject(Integer num, String int_objName)  {
      IntInRange.crashIfBadIntObject(this, num, int_objName);
   }
   /**
      <P>If an int (as contained by an object) <I>that is an element of a larger object</I> is invalid, crash.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #crashIfBadIntElement(IntInRange, Integer, String, int) crashIfBadIntElement}(this, num, cntr_name, idx_inCntr)</CODE></P>
    **/
   public void crashIfBadIntElement(Integer num, String cntr_name, int idx_inCntr)  {
      IntInRange.crashIfBadIntElement(this, num, cntr_name, idx_inCntr);
   }
//other...END

//static...START
   /**
      <P>If the bounds are not valid, crash.</P>

      <P>If either {@code min} or {@code max} are {@code null}, this <I><B>exits</B></I>. Otherwise, if...<UL>
         <LI>both <CODE>min.{@link NumberBound#isInclusive() isInclusive}()</CODE> and {@code max.isInclusive()} are {@code true}, then <CODE>min.{@link IntBoundInclusive#getInt() getInt}()</CODE> may not be greater than {@code max.getInt()}</LI>
         <LI>exactly one of {@code min.isInclusive()} or {@code max.isInclusive()} is {@code false}, then {@code min.getInt()} may not be greater than {@code (max.getInt() - 1)}</LI>
         <LI>both {@code min.isInclusive()} and {@code max.isInclusive()} are {@code false}, then {@code min.getInt()} may not be greater than {@code (max.getInt() - 2)}</LI>
         <LI>either (or both) {@code min} or {@code max} are {@code null}, then (when non-{@code null}) there are no restrictions on {@code min.getInt()} (or {@code max.getInt()}).</LI>
      </UL></P>

      @exception  IllegalArgumentStateException  If both bounds are non-{@code null}, and violated the above rules are violated.

      @see  #crashIfBadBoundsForLength(IntBoundInclusive, IntBound, String, String, Object) crashIfBadBoundsForLength(ibi,nb,s,s,o)
      @see  <CODE><!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NumberInRange#isValid(N)">isValid</A>(N)*</CODE>
    **/
   public static final void crashIfBadBounds(IntBound min, IntBound max, String min_name, String max_name, Object xtra_errInfo)  {
      if(min == null  ||  max == null)  {
         return;
      }
      int iAway = (min.isInclusive() ? 0 : 1) + (max.isInclusive() ? 0 : 1);
      if(min.get() > (max.get() - iAway))  {
         String sMid = ((min.isInclusive()  &&  max.isInclusive()) ?  "."
            :  " minus " + iAway + " (max.get()-" + iAway + "=" + (max.get() - iAway) + ").");
         String sMsg = "Both " + min_name + " and " + max_name + " are non-null, but " + min_name + ".get() (" + min.get() + ") is greater than " + max_name + ".get() (" + max.get() + ")" + sMid;
         throw  new IllegalArgumentStateException(getXMsg(sMsg,
            XInfoAccumulator.getAddedOrNew(xtra_errInfo,
            min_name + ".isInclusive()=" + min.isInclusive() + ", " + max_name + ".isInclusive()=" + max.isInclusive())));
      }
   }
   /**
      <P>If the bounds needed by {@code LengthInRange} or {@code IndexInRange} are not valid, crash.</P>

      <P>In addition to the requirements of {@link #crashIfBadBounds(IntBound, IntBound, String, String, Object) crashIfBadBounds}, the minimum bound must be non-{@code null} and greater-than-or-equal-to zero.</P>
    **/
   protected static final void crashIfBadBoundsForLength(IntBoundInclusive min, IntBound max, String min_name, String max_name, Object xtra_errInfo)  {
      try  {
         if(min.getInt() < 0)  {
            throw  new IllegalArgumentException("Min less than zero: " + min);
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(min, "min", null, rx);
      }
      if(!min.isInclusive())  {
         throw  new IllegalArgumentException("Min not inclusive: " + min);
      }
      crashIfBadBounds(min, max, min_name, max_name, xtra_errInfo);
   }
   /**
      <P>If a standalone int is invalid, crash. The only difference between this and {@link #crashIfBadIntElement(IntInRange, Integer, String, int) crashIfBadIntObject}{@code (iir,I,s,i)} is the format of the potential error message.</P>

      @param  int_objName  For example, &quot;{@code aString.length}&quot; or &quot;{@code coll.size()}&quot;. <I>Should</I> not be {@code null} or empty.
      @exception  IllegalArgumentException  If
      <BR> &nbsp; &nbsp; <CODE>range.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NumberInRange.html#isValid(N)">isValid</A>(num)*</CODE>
      <BR>is {@code false}.

      @see  #crashIfBadIntObject(Integer, String) crashIfBadIntObject(I,s)
    **/
   public static final void crashIfBadIntObject(IntInRange range, Integer num, String int_objName)  {
      boolean bValid = false;
      try  {
         bValid = range.isValid(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", range.getExtraErrInfo(), rx);
      }
      if(!bValid)  {
         throw  new IllegalArgumentException(
            getXMsg(int_objName + " (" + num + ") is invalid according to the rules: " + range.getRules(), range.getExtraErrInfo()));
      }
   }
   /**
      <P>If an int (as contained by an object) <I>that is an element of a larger object</I> is invalid, crash. The only difference between this and {@link #crashIfBadIntObject(IntInRange, Integer, String) crashIfBadIntObject}{@code (iir,I,s)} is the format of the potential error message.</P>

      @param  cntr_name  The name of the container (string, array, collection, etc.) in which the int is an element.
      @param  idx_inCntr  The element index at which the int resides.
      @exception  IllegalArgumentException  If <CODE>range.<!-- GENERIC PARAMETERS FAIL IN @link --><A HREF="NumberInRange.html#isValid(N)">isValid</A>(num)</CODE> is {@code false}.

      @see  #crashIfBadIntElement(Integer, String, int) crashIfBadIntElement(I,s,i)
    **/
   public static final void crashIfBadIntElement(IntInRange range, Integer num, String cntr_name, int idx_inCntr)  {
      boolean bValid = false;
      try  {
         bValid = range.isValid(num);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(range, "range", range.getExtraErrInfo(), rx);
      }
      if(!bValid)  {
         throw  new IllegalArgumentException(
            getXMsg("Element " + idx_inCntr + " in " + cntr_name +
               " (" + num + ") is invalid according to the rules: " + range.getRules(), range.getExtraErrInfo()));
      }
   }
   /**
      <P>If a range's min is greater than max, or either are outside of the bounds <I>as configured in this class</I>, crash.</P>

      @param  min  Range-minimum to test.
      @param  max  Range-maximum to test.
      @param  range  The rules to test for. May not be {@code null}.
      @param  min_name  Descriptive name of {@code min}. <I>Should</I> not be {@code null} or empty.
      @param  max_name  Descriptive name of {@code max}
      @exception  IllegalArgumentException  If {@code min} is less than {@link #getMin() getMin}{@code ()}, or {@code max} is greater than {@link #getMax() getMax}{@code ()} (unless {@code getMax()} is {@code -1}, in which case there is no maximum restriction).
      @exception  IllegalArgumentStateException  If {@code min} is greater than {@code max}.

      @see  #crashIfBadRange(int, int) crashIfBadRange(i,i)
      @see  #crashIfBadRange(int, int, String, String) crashIfBadRange(i,i,s,s)
    **/
   public static final void crashIfBadRange(IntInRange range, int min, int max, String min_name, String max_name, Object xtra_errInfo)  {
      if(min < range.getMin())  {
         throw  new IllegalArgumentException(getXMsg(min_name + " (" + min + ") is less than range.getMin() (" + range.getMin() + ")", xtra_errInfo));
      }
      if(range.getMax() != -1  &&  max > range.getMax())  {
         throw  new IllegalArgumentException(getXMsg(max_name + " (" + max + ") is greater than range.getMax() (" + range.getMax() + ")", xtra_errInfo));
      }
      if(min > max)  {
         throw  new IllegalArgumentStateException(getXMsg(min_name + " (" + min + ") is greater than " + max_name + " (" + max + ")", xtra_errInfo));
      }
   }
//static...END
}
