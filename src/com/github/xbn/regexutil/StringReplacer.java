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
package  com.github.xbn.regexutil;
   import  com.github.xbn.analyze.alter.AlterationRequired;
   import  com.github.xbn.analyze.alter.Altered;
   import  com.github.xbn.analyze.alter.NeedsToBeDeleted;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.lang.Adapter;
   import  com.github.xbn.lang.SimpleAdapter;
/**
   <p>Adapts {@code RegexReplacer} into a string alterer, via a {@code StringValidatorReplacer}.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class StringReplacer extends AbstractValueAlterer<String,String> implements Adapter<StringValidatorReplacer>  {
   private final SimpleAdapter<StringValidatorReplacer> sa;
   /**
      <p>Create a new instance from a {@code RegexReplacer} and filter.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #StringReplacer(StringValidatorReplacer) this}(new StringValidatorReplacer(replacer, vfr_unfilteredIfNull))</code></p>
    **/
   public StringReplacer(RegexReplacer replacer, AlterationRequired required, ValidResultFilter vfr_unfilteredIfNull)  {
      this(new StringValidatorReplacer(replacer, vfr_unfilteredIfNull), required);
   }
   /**
      <p>Create a new instance from a {@code StringValidatorReplacer}.</p>

      <p>This sets {@link com.github.xbn.analyze.alter.AbstractValueAlterer#doesExpire() doesExpire}{@code ()}* to  <code>sv_replacer.{@link com.github.xbn.analyze.validate.AbstractValidator#doesExpire() doesExpire}()</code>.

      @param  sv_replacer  May not be {@code null} or {@link com.github.xbn.lang.Expirable#isExpired() expired}. Get with {@link #getAdapted() getAdapted}{@code ()}. Get the {@link com.github.xbn.regexutil.RegexReplacer RegexReplacer} with {@link #getRegexReplacer() getRegexReplacer}{@code ()}.
      @see  #StringReplacer(RegexReplacer, AlterationRequired, ValidResultFilter) this(rr,ar,vrf)
      @see  #StringReplacer(StringReplacer) this(sr)
    **/
   public StringReplacer(StringValidatorReplacer sv_replacer, AlterationRequired required)  {
      super(required);
      sa = new SimpleAdapter<StringValidatorReplacer>(sv_replacer, "sv_replacer");
      if(sv_replacer.isExpired())  {
         throw  new IllegalArgumentException("sv_replacer.isExpired() is true");
      }
      if(sv_replacer.doesExpire())  {
         declareExpirable();
      }
   }
   /**
      <p>Create a new instance as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls <code>{@link com.github.xbn.analyze.alter.AbstractValueAlterer super}.{@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer(ValueAlterer) AbstractValueAlterer}(to_copy)</code></li>
         <li>Sets {@link #getAdapted() getAdapted}{@code ()} to {@code to_copy.getAdapted()}</li>
      </ol></p>

      @param  to_copy  May not be {@code null}.
      @see  #StringReplacer(StringValidatorReplacer) this(svr)
    **/
   public StringReplacer(StringReplacer to_copy)  {
      super(to_copy);
      sa = new SimpleAdapter<StringValidatorReplacer>(to_copy.getAdapted());
   }
   public String getAltered(String to_alter)  {
      return  getAltered(to_alter, to_alter);
   }
   public String getAlteredPostResetCheck(String ignored, String to_alter)  {
      StringValidatorReplacer svr = getAdapted();
      boolean bVld = svr.isValid(to_alter);

      if(svr.isExpired())  {
         declareExpired();
      }

      if(bVld)  {
         declareAltered(Altered.YES, NeedsToBeDeleted.NO);
         return  svr.getMostRecent();
      }

      //Invalid

      return  to_alter;
   }
   /**
      <p>Get the adapted {@code RegexReplacer}.</p>

      @return  <code>{@link #getAdapted() getAdapted}().{@link com.github.xbn.regexutil.StringValidatorReplacer#getAdapted() getAdapted}()</code>
    **/
   public RegexReplacer getRegexReplacer()  {
      return  getAdapted().getAdapted();
   }
   /**
      <p>Get the adapted {@code StringValidatorReplacer}.</p>

      @return  <code>sv_replacer</code> as provided to the {@link #StringReplacer(StringValidatorReplacer) constructor}
      @see  #getRegexReplacer()
    **/
   public StringValidatorReplacer getAdapted()  {
      return  sa.getAdapted();
   }
   /**
      <p>Duplicate this <code>StringReplacer</code>.</p>

      @return  <code>(new <a href="#StringReplacer(StringReplacer)">StringReplacer</a>(this))</code>
    **/
   public StringReplacer getObjectCopy()  {
      return  (new StringReplacer(this));
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo).append(", ");
      return  sa.appendToString(to_appendTo);
   }
}
