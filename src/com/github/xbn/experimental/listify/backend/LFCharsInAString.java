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
package  com.github.xbn.experimental.listify.backend;
   import  com.github.xbn.array.CrashIfIndex;
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyPrimitiveable;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyCharable;
   import  com.github.xbn.experimental.listify.CopyElements;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  java.util.Collection;
   import  java.util.Iterator;
   import  java.util.Objects;
   import  org.apache.commons.lang3.ArrayUtils;
/**
   <p>Listifier whose raw object is a string, and whose virtual elements are the characters in that string.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class LFCharsInAString extends AbstractListifyPrimitiveable<Character> implements ListifyCharable  {
//constructors...START
   /**
      <p>Create a new {@code LFCharsInAString}.</p>
    */
   public LFCharsInAString(Object string)  {
      this((String)string);
   }
   /**
      <p>Create a new {@code LFCharsInAString}.</p>
    */
   public LFCharsInAString(CharSequence string)  {
      super(string, AddRemovable.NO, NewPrimitiveArrayHelper.forCharacter(), (new OneParamCnstrValueCopier<Character>(Character.class)));
   }
//constructors...END
   public CharSequence getRawString()  {
      return  (CharSequence)getRawObject();
   }
   public final Character getElementRTXOkay(int index)  {
      return  getChar(index);
   }
   public final char getChar(int index)  {
      try  {
         return  getRawString().charAt(index);
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(getRawString(), "getRawString()");
         CrashIfIndex.badForLength(index, size(), "index", "size()");
         throw  rx;
      }
   }
   public final int getSizeNPXOkay()  {
      return  getRawString().length();
   }
   public final Iterator<Character> iterator()  {
      return  StringUtil.getCharIterator(getRawString());
   }
   public final Character[] getEArrayCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  ArrayUtils.toObject(getPArrayCopyOrNull(nnull));
   }
   public final char[] getPArrayCopyOrNull(NullContainer nnull)  {
      if(getRawString() == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, "getPArrayCopyOrNull(...)");
         return  null;
      }
      return  getRawString().toString().toCharArray();
   }
   /**
      <p>Duplicate this {@code LFCharsInAString}.</p>

    * @return  <code>(new {@link #LFCharsInAString(com.github.xbn.experimental.listify.backend.LFCharsInAString) LFCharsInAString}(this))</code>
    */
   public LFCharsInAString getObjectCopy()  {
      return  (new LFCharsInAString(this));
   }
}
