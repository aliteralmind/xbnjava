/*license*\
   XBN-Java Library

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.SimpleAdapter;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.analyze.validate.z.SimpleValidator_F;
   import  com.github.xbn.analyze.validate.z.ValueValidator_Fieldable;
   import  com.github.xbn.lang.SimpleAdapter;
   import  com.github.xbn.lang.Adapter;
/**
   <P>Makes anything behave like a <CODE>ValueValidator</CODE>.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class ValueValidatorAdapter<O,D> extends NullnessValidator<O> implements Adapter<D>, ValueValidator<O>  {
   private final SimpleAdapter<D> sa;
   protected ValueValidatorAdapter(D to_adapt, ValueValidator_Fieldable fieldable)  {
      super(fieldable);
      sa = new SimpleAdapter<D>(to_adapt, "to_adapt");
   }
   protected ValueValidatorAdapter(D to_adapt, RuleType type, ValueValidator_Fieldable fieldable)  {
      super(type, fieldable);
      sa = new SimpleAdapter<D>(to_adapt, "to_adapt");
   }

   public ValueValidatorAdapter(ValueValidatorAdapter<O,D> to_copy)  {
      super(to_copy);
      sa = new SimpleAdapter<D>(to_copy.sa);
   }
   public D getAdapted()  {
      return  sa.getAdapted();
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  sa.appendToString(to_appendTo);
   }
}
