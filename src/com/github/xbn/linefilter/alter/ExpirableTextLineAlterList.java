/*license*\
   Codelet

   XBN-Java is a collection of generically-useful backend (non-GUI) programming utilities, featuring automated insertion of example code into JavaDoc, regular expression convenience classes, shareable self-returning method chains, and highly-configurable output for lists.

   Copyright (C) 2014, Jeff Epstein

   This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option) any later version.

   This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA*)
\*license*/
package  com.github.xbn.linefilter.alter;
   import  com.github.xbn.array.NullElement;
   import  com.github.xbn.analyze.alter.ExpirableElements;
   import  com.github.xbn.analyze.alter.MultiAlterType;
   import  com.github.xbn.analyze.alter.ValueAlterer;
/**
   <p>For a series of alterers that expire--once an item is expired, it is removed from the list.</p>

{@.codelet.and.out com.github.xbn.examples.linefilter.alter.ExpirableTextLineAlterListXmpl%eliminateCommentBlocksAndPackageDecl()}

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ExpirableTextLineAlterList extends ExpirableRawLineAlterList<String>  {
   /*
      <p>Create a new instance in which expirable elements are optional, and {@code null} elements are forbidden.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link com.github.xbn.array.ExpirableAlterList#ExpirableAlterList(MultiAlterType, MultiAlterType) this}(text_lineAlterers, multi_alterType)</code></p>
   public ExpirableTextLineAlterList(ValueAlterer<String,String>[] text_lineAlterers, MultiAlterType multi_alterType)  {
      super(text_lineAlterers, multi_alterType);
   }
    */
   /**
      <p>Create a new instance.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link ExpirableRawLineAlterList#ExpirableRawLineAlterList(ValueAlterer[], ExpirableElements, MultiAlterType, Appendable) super}(text_lineAlterers, xprbl_lmntsAre, multi_alterType, debug_ifNonNull)</code></p>
    */
   public ExpirableTextLineAlterList(ValueAlterer<String,String>[] text_lineAlterers, ExpirableElements xprbl_lmntsAre, MultiAlterType multi_alterType, Appendable debug_ifNonNull)  {
      super(text_lineAlterers, xprbl_lmntsAre, multi_alterType, debug_ifNonNull);
   }
   public ExpirableTextLineAlterList(ExpirableTextLineAlterList to_copy)  {
      super(to_copy);
   }
   public String getAltered(String line)  {
      return  getAltered(line, line);
   }
   /**
      <p>Duplicate this <code>ExpirableTextLineAlterList</code>.</p>

    * @return  <code>(new <a href="#ExpirableTextLineAlterList(ExpirableTextLineAlterList)">ExpirableTextLineAlterList</a>(this))</code>
    */
   public ExpirableTextLineAlterList getObjectCopy()  {
      return  (new ExpirableTextLineAlterList(this));
   }
   public void crashIfNotExpired()  {
      if(!isExpired())  {
         throw  new IllegalStateException("linkCreatorList.isExpired() is false. " + toString());
      }
   }
   /**
      <p>Get a new text-line-alterer array from the provided <i>ordered</i> elements, optionally excluding {@code null} elements.</p>

    * @return  <code><!-- GENERIC PARAMETERS FAIL IN @link --><a href="{@docRoot}/com/github/xbn/analyze/alter/ExpirableAlterList.html#getAltererArrayFromOrderedElementsIfNonNull(L[], com.github.xbn.array.NullElement, java.lang.Class, java.lang.String)">getAltererArrayFromOrderedElementsIfNonNull</a>(orderedAlterers_whichMayBeNull, null_element, TextLineAlterer.class, alterers_varName)</code>
    */
   public static final <O> TextLineAlterer[] getTextLineAltererArrayFromOrderedElementsIfNonNull(NullElement null_element, String alterers_varName, TextLineAlterer... orderedAlterers_whichMayBeNull)  {
      return  getAltererArrayFromOrderedElementsIfNonNull(orderedAlterers_whichMayBeNull, null_element, TextLineAlterer.class, alterers_varName);
   }
}
