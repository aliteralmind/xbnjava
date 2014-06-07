/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.regexutil;
   import  com.github.xbn.analyze.validate.ValidResultFilter;
   import  com.github.xbn.analyze.validate.ValidatorComposer;
   import  com.github.xbn.analyze.alter.AbstractValueAlterer;
   import  com.github.xbn.lang.Adapter;
   import  com.github.xbn.lang.SimpleAdapter;
/**
   <P>Adapts {@code RegexReplacer} into a string alterer, via a {@code StringValidatorReplacer}.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class StringReplacer extends AbstractValueAlterer<String,String> implements Adapter<StringValidatorReplacer>  {
   private final SimpleAdapter<StringValidatorReplacer> sa;
   /**
      <P>Create a new instance from a {@code RegexReplacer} and filter.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <CODE>{@link #StringReplacer(StringValidatorReplacer) this}(new StringValidatorReplacer(replacer, vfr_unfilteredIfNull))</CODE></P>
    **/
   public StringReplacer(RegexReplacer replacer, ValidResultFilter vfr_unfilteredIfNull)  {
      this(new StringValidatorReplacer(replacer, vfr_unfilteredIfNull));
   }
   /**
      <P><I>[main]</I> -- Create a new instance from a {@code StringValidatorReplacer}.</P>

      <P>This sets {@link com.github.xbn.analyze.alter.AbstractValueAlterer#doesExpire() doesExpire}{@code ()}* to  <CODE>sv_replacer.{@link com.github.xbn.analyze.validate.AbstractValidator#doesExpire() doesExpire}()</CODE>.

      @param  sv_replacer  May not be {@code null} or {@link com.github.xbn.lang.Expirable#isExpired() expired}. Get with {@link #getAdapted() getAdapted}{@code ()}. Get the {@link com.github.xbn.regexutil.RegexReplacer RegexReplacer} with {@link #getRegexReplacer() getRegexReplacer}{@code ()}.
      @see  #StringReplacer(RegexReplacer, ValidResultFilter) this(rr,vrf)
      @see  #StringReplacer(StringReplacer) this(sr)
    **/
   public StringReplacer(StringValidatorReplacer sv_replacer)  {
      super();
      sa = new SimpleAdapter<StringValidatorReplacer>(sv_replacer, "sv_replacer");
      if(sv_replacer.isExpired())  {
         throw  new IllegalArgumentException("sv_replacer.isExpired() is true");
      }
      if(sv_replacer.doesExpire())  {
         declareExpirable();
      }
   }
   /**
      <P>Create a new instance as a duplicate of another.</P>

      <P>This<OL>
         <LI>Calls <CODE>{@link com.github.xbn.analyze.alter.AbstractValueAlterer super}.{@link com.github.xbn.analyze.alter.AbstractValueAlterer#AbstractValueAlterer(ValueAlterer) AbstractValueAlterer}(to_copy)</CODE></LI>
         <LI>Sets {@link #getAdapted() getAdapted}{@code ()} to {@code to_copy.getAdapted()}</LI>
      </OL></P>

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
         declareAlteredNotDeleted();
         return  svr.getMostRecent();
      }

      //Invalid

      return  to_alter;
   }
   /**
      <P>Get the adapted {@code RegexReplacer}.</P>

      @return  <CODE>{@link #getAdapted() getAdapted}().{@link com.github.xbn.regexutil.StringValidatorReplacer#getAdapted() getAdapted}()</CODE>
    **/
   public RegexReplacer getRegexReplacer()  {
      return  getAdapted().getAdapted();
   }
   /**
      <P>Get the adapted {@code StringValidatorReplacer}.</P>

      @return  <CODE>sv_replacer</CODE> as provided to the {@link #StringReplacer(StringValidatorReplacer) constructor}
      @see  #getRegexReplacer()
    **/
   public StringValidatorReplacer getAdapted()  {
      return  sa.getAdapted();
   }
   /**
      <P>Get a duplicate of this <CODE>StringReplacer</CODE>.</P>

      @return  <CODE>(new <A HREF="#StringReplacer(StringReplacer)">StringReplacer</A>(this))</CODE>
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
