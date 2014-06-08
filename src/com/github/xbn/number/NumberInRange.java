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
package  com.github.xbn.number;
   import  com.github.xbn.lang.Null;
   import  java.util.Objects;
   import  com.github.xbn.text.StringWithNullDefault;
   import  com.github.xbn.lang.AbstractExtraErrInfoable;
   import  com.github.xbn.lang.CrashIfObject;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.lang.RuleableComposer;
   import  com.github.xbn.lang.Ruleable;
/**
   <P>Determines if a number is within a {@code NumberRange}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class NumberInRange<N extends Number> extends AbstractExtraErrInfoable implements NumberRange<N>, Ruleable  {
//state
   private final NumberBound<N> nbMin;
   private final NumberBound<N> nbMax;
   private final RuleableComposer rc;
//constructors...START
   /**
      <P>Create a new {@code NumberInRange}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; {@link #NumberInRange(NumberBound, NumberBound) this}{@code (null, null)}</P>
    **/
   public NumberInRange()  {
      this(null, null);
   }
   /**
      <P>Create a new {@code NumberInRange}.</P>

      @param  nb_min  Get with {@link #getMinBound() getMinBound}{@code (null, null)}
      @param  nb_max  Get with {@link #getMaxBound() getMaxBound}{@code ()}
      @see  #NumberInRange()
      @see  #NumberInRange(NumberInRange)
    **/
   public NumberInRange(NumberBound<N> nb_min, NumberBound<N> nb_max)  {
      super();
      rc = new RuleableComposer();
      nbMin = nb_min;
      nbMax = nb_max;
      setERuleTypeFromBounds();
      crashIfBadBoundsForCnstr();
   }
   /**
      <P>Create a new {@code NumberInRange} as a duplicate of another.</P>

      @param  to_copy  May not be {@code null}.
      @see  #NumberInRange(NumberBound, NumberBound)
    **/
   public NumberInRange(NumberInRange<N> to_copy)  {
      super(to_copy);
      rc = new RuleableComposer(to_copy);
      nbMin = to_copy.getMinBound();
      nbMax = to_copy.getMaxBound();
      setERuleTypeFromBounds();
   }
//setters...START
   protected void setERuleTypeFromBounds()  {
      rc.setERuleType_4prot((getMinBound() == null  &&  getMaxBound() == null)
         ?  RuleType.UNRESTRICTED
         :  RuleType.RESTRICTED);
   }
//setters...END
//getters...START
   public final RuleType getRuleType()  {
      return  rc.getRuleType();
   }
   /**
      <P>Is there a minimum bound?.</P>

      @return  {@code (getMinBound() != null)}
      @see  #getMinBound()
    **/
   public boolean hasMin()  {
      return  (getMinBound() != null);
   }
   /**
      <P>Is there a maximum bound?.</P>

      @return  <CODE>({@link #getMaxBound() getMaxBound}() != null)</CODE>
      @see  #getMinBound()
    **/
   public boolean hasMax()  {
      return  (getMaxBound() != null);
   }
   /**
      <P>The minimum bound.</P>

      @return  {@code nb_min} as provided to ...................

      @see
         <LI>{@link #getMinBound() getMinBound}{@code ()}</LI>
         <LI>{@link #hasMin() hasMin}{@code ()}, {@link #hasMax() hasMax}{@code ()}</LI>
         <LI>{@link #getMinNumber() getMinNumber}{@code ()}, {@link #getMaxNumber() getMaxNumber}{@code ()}</LI>
         <LI>{@link #isMinInclusive() isMinInclusive}{@code ()}, {@link #isMaxInclusive() isMaxInclusive}{@code ()}</LI>
      </UL>
    **/
   public NumberBound<N> getMinBound()  {
      return nbMin;
   }
   /**
      <P>The maximum bound.</P>

      @return  {@code nb_max} as provided to ...........................................
      @see  #getMinBound()
    **/
   public NumberBound<N> getMaxBound()  {
      return nbMax;
   }
   /**
      <P>Get the minimum bound number.</P>

      @return  <CODE>getMinBound().{@link NumberBound#get() get}()</CODE>
      @exception  NullPointerException  If {@link #hasMin() hasMin}{@code ()} is {@code false}.
      @see  #getMinBound()
    **/
   public N getMinNumber()  {
      try  {
         return  getMinBound().get();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMinBound(), "in");
         throw  rx;
      }
   }
   /**
      <P>Is the minimum bound inclusive?.</P>

      @return  <CODE>getMinBound().{@link NumberBound#isInclusive() isInclusive}()</CODE>
      @exception  NullPointerException  If {@code getMinBound()} is {@code null}.
      @see  #getMinBound()
    **/
   public boolean isMinInclusive()  {
      try  {
         return  getMinBound().isInclusive();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMinBound(), "in");
         throw  rx;
      }
   }
   /**
      <P>Get the maximum bound number.</P>

      @return  <CODE>{@link #getMaxBound() getMaxBound}().{@link NumberBound#get() get}()</CODE>
      @exception  NullPointerException  If {@code getMaxBound()} is {@code null}.
      @see  #getMinBound()
    **/
   public N getMaxNumber()  {
      try  {
         return  getMaxBound().get();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMaxBound(), "ax");
         throw  rx;
      }
   }
   /**
      <P>Is the maximum bound inclusive?.</P>

      @return  <CODE>{@link #getMaxBound() getMaxBound}(){@link NumberBound#isInclusive() isInclusive}()</CODE>
      @exception  NullPointerException  If {@code getMaxBound()} is {@code null}.
      @see  #getMinBound()
    **/
   public boolean isMaxInclusive()  {
      try  {
         return  getMaxBound().isInclusive();
      }  catch(RuntimeException rx)  {
         throwISXIfBoundNull(getMaxBound(), "ax");
         throw  rx;
      }
   }
//getters...END
//other...START
   /**
      @return   <CODE>(!{@link #hasMin() hasMin}() &nbsp;&amp;&amp; &nbsp;!{@link #hasMax() hasMax}())</CODE>
    **/
   public boolean isUnrestricted()  {
      return  (!hasMin()  &&  !hasMax());
   }
   /**
      @return  {@link #appendRules(StringBuilder) appendRules}{@code ((new StringBuilder())).toString()}
    **/
   public String getRules()  {
      return  appendRules((new StringBuilder())).toString();
   }
   /**
      @see  #getRules()
      @see  <CODE><A HREF="http://en.wikibooks.org/wiki/Algebra/Interval_Notation">http://en.wikibooks.org/wiki/Algebra/Interval_Notation</A></CODE>
    **/
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      NumberBound<?> min = getMinBound();
      try  {
         if(min == null)  {
            to_appendTo.append("[-" + NumberUtil.INFINITY_CHAR);
         }  else  {
            to_appendTo.append(min.isInclusive() ? "[" : "(").append(min.get());
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }

      to_appendTo.append(",");

      NumberBound<?> max = getMaxBound();
      if(max == null)  {
         to_appendTo.append("+" + NumberUtil.INFINITY_CHAR + ")");
      }  else  {
         to_appendTo.append(max.get()).append(max.isInclusive() ? "]" : ")");
      }

      String minName = getMinBound().getName();
      String maxName = getMinBound().getName();

      if(minName != null  ||  maxName != null)  {
         to_appendTo.append(" (");
      }

      if(minName != null)  {
         to_appendTo.append("min=\"" + minName + "\"");
      }

      if(minName != null  &&  maxName != null)  {
         to_appendTo.append(", ");
      }

      if(maxName != null)  {
         to_appendTo.append("max=\"" + maxName + "\"");
      }

      if(minName != null  ||  maxName != null)  {
         to_appendTo.append(")");
      }
      return  to_appendTo;

   }
   public String toString()  {
      return  getRules();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  appendRules(to_appendTo);
   }
   /**
      <P>If a bound is {@code null}, throw an {@code IllegalStateException}.</P>

      @param  bound  The bound to check.
      @param  in_orAx  If checking the minimum bound, set this to &quot;{@code in}&quot;. If maximum, &quot;{@code ax}&quot;.
    **/
   protected void throwISXIfBoundNull(NumberBound<N> bound, String in_orAx)  {
      if(bound == null)  {
         throw  new IllegalStateException("hasM" + in_orAx + "() is false.");
      }
   }
   /**
      <P>If the bounds are not valid, crash.</P>

      @exception  IllegalArgumentStateException  If both bounds are non-{@code null} and the minimum bound is greater than the maximum (this correctly considers the {@link NumberBound#isInclusive() inclusive}-ness of both bounds).
    **/
//	public abstract void crashIfBadBoundsForCnstr(NumberBound<N> nb_min, NumberBound<N> nb_max);
   public abstract void crashIfBadBoundsForCnstr();

//	public abstract NumberInRange<N> getObjectCopy();
//other...END

   public abstract boolean isGTOEMinGivenIncl(N num);
   public abstract boolean isLTOEMaxGivenIncl(N num);

   public N getInclMinComparedTo(N num)  {
      try  {
         return  getMinBound().getInclComparedTo(BoundSide.MIN, num);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(getMinBound(), "getMinBound()", "hasMin() is false (actually " + hasMin() + ")");
         throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
      }
   }
   public N getInclMaxComparedTo(N num)  {
      try  {
         return  getMaxBound().getInclComparedTo(BoundSide.MAX, num);
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(getMaxBound(), "getMaxBound()", "hasMax() is false (actually " + hasMax() + ")");
         throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
      }
   }
   public abstract N getInclMinComparedToOrIfNoMin(N to_compareTo, N if_noMin);
   public abstract N getInclMaxComparedToOrIfNoMax(N to_compareTo, N if_noMax);

   public final boolean isValid(N num)  {
      boolean bV4Min = false;
      try  {
         bV4Min = (!hasMin()  ||  isGTOEMinGivenIncl(num));
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(num, "num", null, rx);
      }
      boolean bV4Max = (!hasMax()  ||  isLTOEMaxGivenIncl(num));

      return  (bV4Min  &&  bV4Max);
   }
   public static final <N extends Number> String getValidityDebugging(NumberInRange<N> range, N to_validate, String to_vldtName)  {
      return  to_vldtName + "=" + to_validate + ", range=<" + range + ">, valid-for-min?=" +
         (!range.hasMin()
            ?  "yes (no min-bound)"
            :  (!range.isGTOEMinGivenIncl(to_validate)
               ?  "no (less than min, given its inclusive-ness)"
               :  "yes (greater-than-or-equal-to min)")) +
      ", valid-for-max?=" +
         (!range.hasMax()
            ?  "yes (no max-bound)"
            :  (!range.isLTOEMaxGivenIncl(to_validate)
               ?  "no (greater than max, given its inclusive-ness)"
               :  "yes (greater-than-or-equal-to max)")) +
      ", valid entirely? " + ((
         (!range.hasMin()  ||  range.isGTOEMinGivenIncl(to_validate))  &&
         (!range.hasMax()  ||  range.isLTOEMaxGivenIncl(to_validate)))
            ? "yes" : "no");
   }
}
