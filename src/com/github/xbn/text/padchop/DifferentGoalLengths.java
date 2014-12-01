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
   import  com.github.xbn.util.EnumUtil;
/**
   <p>When creating a {@code VzblPadChop}, if the goal lengths in the {@code PadString} and {@code ChopString} are different, what action should be taken?.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public enum DifferentGoalLengths  {
   /**
      <p>If the goal lengths are different, leave them that way. The goal-length must be explicitely specified by the int-parameter with each call to <code>{@link VzblPadChop}.{@link VzblPadChop#appendX(Appendable, int, Object) appendX}(apbl,i,O)</code>.</p>

    * @see  #CRASH
    * @see  #USE_PAD
    * @see  #USE_CHOP
    * @see  #USE_NON_NEG_1
    * @see  #doIgnore()
    */
   IGNORE,
   /**
      <p>If the goal lengths of the {@code PadString} and {@code ChopString} are different, crash with an {@link com.github.xbn.lang.IllegalArgumentStateException}.</p>

    * @see  #IGNORE
    * @see  #doCrash()
    */
   CRASH,
   /**
      <p>If the goal lengths are different, use the {@code PadString}'s goal length. If it happens to be {@code -1}, using this setting will result in an {@code IllegalStateException}.</p>

    * @see  #IGNORE
    * @see  #doUsePad()
    */
   USE_PAD,
   /**
      <p>If the goal lengths are different, use the {@code ChopString}'s goal length. If it happens to be {@code -1}, using this setting will result in an {@code IllegalStateException}.</p>

    * @see  #IGNORE
    * @see  #doUseChop()
    */
   USE_CHOP,
   /**
      <p>If the goal lengths are different, use whichever goal length is not {@code -1}. If both happen to be {@code -1}, using this setting will result in an {@code IllegalStateException}.</p>

    * @see  #IGNORE
    * @see  #doUseNonNeg1()
    */
   USE_NON_NEG_1;
   /**
      <p>Is this {@code DifferentGoalLengths} equal to {@code IGNORE}?.</p>

    * @return  <code>this == {@link #IGNORE}</code>

    * @see  #doCrash()
    * @see  #doUsePad()
    * @see  #doUseChop()
    * @see  #doUseNonNeg1()
    */
   public final boolean doIgnore()  {
      return  this == IGNORE;
   }
   /**
      <p>Is this {@code DifferentGoalLengths} equal to {@code CRASH}?.</p>

    * @return  <code>this == {@link #CRASH}</code>

    * @see  #doIgnore()
    */
   public final boolean doCrash()  {
      return  this == CRASH;
   }
   /**
      <p>Is this {@code DifferentGoalLengths} equal to {@code USE_PAD}?.</p>

    * @return  <code>this == {@link #USE_PAD}</code>

    * @see  #doIgnore()
    */
   public final boolean doUsePad()  {
      return  this == USE_PAD;
   }
   /**
      <p>Is this {@code DifferentGoalLengths} equal to {@code USE_PAD}?.</p>

    * @return  <code>this == {@link #USE_PAD}</code>

    * @see  #doIgnore()
    */
   public final boolean doUseChop()  {
      return  this == USE_PAD;
   }
   /**
      <p>Is this {@code DifferentGoalLengths} equal to {@code USE_NON_NEG_1}?.</p>

    * @return  <code>this == {@link #USE_NON_NEG_1}</code>

    * @see  #doIgnore()
    */
   public final boolean doUseNonNeg1()  {
      return  this == USE_NON_NEG_1;
   }
   /**
      <p>If an <code>DifferentGoalLengths</code> is not a required value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfNotRequiredValue(Enum, Enum, String, Object) crashIfNotRequiredValue}(this, pcgl_da, this_enumsVarName, &quot;DifferentGoalLengths&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfForbiddenValue(DifferentGoalLengths, String, Object) crashIfForbiddenValue(ert,s,o)
    */
   public void crashIfNotRequiredValue(DifferentGoalLengths pcgl_da, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfNotRequiredValue(this, pcgl_da, this_enumsVarName, xtra_errInfo);
   }
   /**
      <p>If an <code>DifferentGoalLengths</code> is a forbidden value, crash.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.util.EnumUtil EnumUtil}.{@link com.github.xbn.util.EnumUtil#crashIfForbiddenValue(Enum, Enum, String, Object) crashIfForbiddenValue}(this, pcgl_da, this_enumsVarName, &quot;DifferentGoalLengths&quot;, xtra_errInfo)</code></p>
    * @see  #crashIfNotRequiredValue(DifferentGoalLengths, String, Object) crashIfNotRequiredValue(ert,s,o)
    */
   public void crashIfForbiddenValue(DifferentGoalLengths pcgl_da, String this_enumsVarName, Object xtra_errInfo)  {
      EnumUtil.crashIfForbiddenValue(this, pcgl_da, this_enumsVarName, xtra_errInfo);
   }
}
