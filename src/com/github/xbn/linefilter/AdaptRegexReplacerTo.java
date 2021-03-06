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
package  com.github.xbn.linefilter;
   import  com.github.xbn.analyze.alter.AlterationRequired;
   import  com.github.xbn.lang.ObjectOrCrashIfNull;
   import  com.github.xbn.linefilter.alter.AbstractTextLineAlterAdapter;
   import  com.github.xbn.linefilter.alter.TextLineAlterAdapter;
   import  com.github.xbn.regexutil.RegexReplacer;
   import  com.github.xbn.regexutil.ReplacedInEachInput;
   import  com.github.xbn.regexutil.StringReplacer;
   import  com.github.xbn.regexutil.StringValidatorReplacer;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.io.TextAppenter;
   import  com.github.xbn.regexutil.z.RegexReplacer_Cfg;
   import  java.util.regex.Pattern;
/**
   <p>Create a new string-validator, string-alterer, or text-line alterer from a {@code RegexReplacer}.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class AdaptRegexReplacerTo  {
   /**
      <p>Create a text-line alterer makes a regular expression replacement.</p>

    * @return  {@link #lineReplacer(StringReplacer) lineReplacer}(new {@link com.github.xbn.regexutil.StringReplacer#StringReplacer(RegexReplacer, AlterationRequired, ValidResultFilter) StringReplacer}(required, rr, filter_ifNonNull))
      <br/>Where {@code rr} is created with
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg}.{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg#buildDirect(Pattern, String, ReplacedInEachInput, Appendable) buildDirect}(pattern_toFind, rplcWith_direct, rplcWhat_notMatchNums, dbgDest_ifNonNull)</code>
    */
   public static final TextLineAlterAdapter<StringReplacer> lineReplacer(AlterationRequired required, Pattern pattern_toFind, String rplcWith_direct, ReplacedInEachInput rplcWhat_notMatchNums, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      RegexReplacer rr = RegexReplacer_Cfg.buildDirect(pattern_toFind, rplcWith_direct, rplcWhat_notMatchNums, dbgDest_ifNonNull);
      return  lineReplacer(required, rr, filter_ifNonNull);
   }
   /**
      <p>Create a string alterer from a {@code RegexReplacer}.</p>

    * @return  {@link #stringReplacer(AlterationRequired, RegexReplacer, ValidResultFilter) lineReplacer}(required, rr, filter_ifNonNull))
      <br/>Where {@code rr} is created with
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg}.{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg#buildDirect(Pattern, String, ReplacedInEachInput, Appendable) buildDirect}(pattern_toFind, rplcWith_direct, rplcWhat_notMatchNums, dbgDest_ifNonNull)</code>
    */
   public static final StringReplacer stringReplacer(AlterationRequired required, Pattern pattern_toFind, String rplcWith_direct, ReplacedInEachInput rplcWhat_notMatchNums, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      RegexReplacer rr = RegexReplacer_Cfg.buildDirect(pattern_toFind, rplcWith_direct, rplcWhat_notMatchNums, dbgDest_ifNonNull);
      return  stringReplacer(required, rr, filter_ifNonNull);
   }
   /**
      <p>Create a string validator from a {@code RegexReplacer}--If the string is matched (is replaced), then it is valid.</p>

    * @return  (new {@link com.github.xbn.regexutil.StringValidatorReplacer#StringValidatorReplacer(RegexReplacer, ValidResultFilter) lineReplacer}(rr, filter_ifNonNull))
      <br/>Where {@code rr} is created with
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg}.{@link com.github.xbn.regexutil.z.RegexReplacer_Cfg#buildDirect(Pattern, String, ReplacedInEachInput, Appendable) buildDirect}(pattern_toFind, rplcWith_direct, rplcWhat_notMatchNums, dbgDest_ifNonNull)</code>
    */
   public static final StringValidatorReplacer stringValidator(AlterationRequired required, Pattern pattern_toFind, String rplcWith_direct, ReplacedInEachInput rplcWhat_notMatchNums, ValidResultFilter filter_ifNonNull, Appendable dbgDest_ifNonNull)  {
      RegexReplacer rr = RegexReplacer_Cfg.buildDirect(pattern_toFind, rplcWith_direct, rplcWhat_notMatchNums, dbgDest_ifNonNull);
      return  (new StringValidatorReplacer(rr, filter_ifNonNull));
   }
   /**
      <p>Create a string alterer from a {@code RegexReplacer} and filter.</p>

    * @return  <code>(new {@link com.github.xbn.regexutil.StringReplacer#StringReplacer(StringValidatorReplacer, AlterationRequired) StringReplacer}(new {@link com.github.xbn.regexutil.StringValidatorReplacer#StringValidatorReplacer(RegexReplacer, ValidResultFilter) StringValidatorReplacer}(replacer, filter_ifNonNull), required)</code>
    */
   public static final StringReplacer stringReplacer(AlterationRequired required, RegexReplacer replacer, ValidResultFilter filter_ifNonNull)  {
      return  new StringReplacer(new StringValidatorReplacer(replacer, filter_ifNonNull), required);
   }
   /**
      <p>Create a text-line alterer from a {@code RegexReplacer} (adapted into a string validator).</p>

    * @param  sreplacer  May not be {@code null}.
    * @return  A new text-line alter-adapter, whose<ul>
         <li>{@link com.github.xbn.lang.Adapter#getAdapted() adapted} object is a
      {@code StringReplacer},</li>
      <li>sub-adapted object ({@code getAdapted().getAdapted()}) is a {@link
      com.github.xbn.regexutil.StringValidatorReplacer}</li>
      <li>and sub-sub adapted object is a {@link
      com.github.xbn.regexutil.RegexReplacer RegexReplacer}.</li>
      </ul>When a match is found by the {@code RegexReplacer}, the text-line alter's <!-- GENERIC PARAMETERS FAIL IN @link --><A
      HREF="{@docRoot}/com/github/xbn/analyze/alter/ValueAlterer.html#getAltered(V, A)">getAltered</a>{@code (V,A)} function returns that {@link com.github.xbn.regexutil.RegexReplacer#getReplaced(Object) replacement}. When no match is found (or
      it is matched, but that match is suppressed or altered by the {@link com.github.xbn.analyze.validate.ValidResultFilterable#getFilter() filter}) the original text is returned
      unchanged.
    * @see  #lineReplacer(AlterationRequired, RegexReplacer, ValidResultFilter) lineReplacer(rr,vrf)
    * @see  #lineReplacer(AlterationRequired, Pattern, String, ReplacedInEachInput, ValidResultFilter, Appendable) lineReplacer(p,s,rw,vrf,apbl)
    * @see  #lineReplacer(AlterationRequired, RegexReplacer, ValidResultFilter) lineReplacer(rr,vrf)
    */
   public static final TextLineAlterAdapter<StringReplacer> lineReplacer(StringReplacer sreplacer)  {
      return  new ATLForSVR(sreplacer);
   }
   /**
      <p>Create a text-line alterer from a {@code RegexReplacer} and filter.</p>

    * @return  <code>{@link #lineReplacer(StringReplacer) lineReplacer}(replacer, new {@link com.github.xbn.regexutil.StringReplacer#StringReplacer(RegexReplacer, AlterationRequired, ValidResultFilter) StringReplacer}(replacer, required, filter_ifNonNull))</code>
    */
   public static final TextLineAlterAdapter<StringReplacer> lineReplacer(AlterationRequired required, RegexReplacer replacer, ValidResultFilter filter_ifNonNull)  {
      return  lineReplacer(new StringReplacer(replacer, required, filter_ifNonNull));
   }
}
final class ATLForSVR extends AbstractTextLineAlterAdapter<StringReplacer>  {
   public ATLForSVR(StringReplacer sv_r)  {
      super(sv_r);
   }
   public ATLForSVR(ATLForSVR to_copy)  {
      super(ObjectOrCrashIfNull.get(to_copy, "to_copy").getAdapted().getObjectCopy());
   }
   public ATLForSVR getObjectCopy()  {
      return  (new ATLForSVR(this));
   }
   public String getAltered(String ignored, String to_alter)  {
      return  getAdapted().getAltered(to_alter);
   }
   public String getAlteredString(String ignored, String to_alter)  {
      return  getAdapted().getAlteredString(null, to_alter);
   }
   public boolean isRequired()  {
      return  getAdapted().isRequired();
   }
   public void resetState()  {
      getAdapted().resetState();
   }
   public void resetCounts()  {
      getAdapted().resetCounts();
   }
   public boolean wasAltered()  {
      return  getAdapted().wasAltered();
   }
   public boolean isComplete()  {
      return  getAdapted().isComplete();
   }
   public StringBuilder appendIncompleteInfo(StringBuilder to_appendTo)  {
      return  getAdapted().appendIncompleteInfo(to_appendTo);
   }
   public boolean mayDelete()  {
      return  getAdapted().mayDelete();
   }
   public boolean doesExpire()  {
      return  getAdapted().doesExpire();
   }
   public boolean isExpired()  {
      return  getAdapted().isExpired();
   }
   public int getAlteredCount()  {
      return  getAdapted().getAlteredCount();
   }
   public int getDeletedCount()  {
      return  getAdapted().getDeletedCount();
   }
   public boolean needsToBeDeleted()  {
      return  getAdapted().needsToBeDeleted();
   }
   public boolean doAutoResetState()  {
      return  getAdapted().doAutoResetState();
   }
   public void resetForDeletion()  {
      getAdapted().resetForDeletion();
   }
   public final String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  getAdapted().appendToString(to_appendTo);
   }
   public int getAnalyzedCount()  {
      return  getAdapted().getAnalyzedCount();
   }
   public boolean wasAnalyzed()  {
      return  getAdapted().wasAnalyzed();
   }
   public void setDebug(Appendable destination, boolean is_on)  {
      getAdapted().setDebug(destination, is_on);
   }
   public void setDebugOn(boolean is_on)  {
      getAdapted().setDebugOn(is_on);
   }
   public boolean isDebugOn()  {
      return  getAdapted().isDebugOn();
   }
   public final Appendable getDebugApbl()  {
      return  getAdapted().getDebugApbl();
   }
   public final TextAppenter getDebugAptr()  {
      return  getAdapted().getDebugAptr();
   }
   public final TextAppenter debug(Object message)  {
      return  getAdapted().debug(message);
   }
   public final void debugln(Object message)  {
      getAdapted().debugln(message);
   }
   public Object getExtraErrInfo()  {
      return  getAdapted().getExtraErrInfo();
   }
   public void setExtraErrInfo(Object info)  {
      getAdapted().setExtraErrInfo(info);
   }
}
