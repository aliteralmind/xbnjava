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
package  com.github.xbn.experimental.listify.primitiveable;
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.util.copyval.SimpleNullHandlerForPrimitives;
   import  com.github.xbn.experimental.listify.primitiveable.ListifyCharable;
   import  com.github.xbn.experimental.listify.primitiveable.AbstractListifyPrimitiveable;
   import  com.github.xbn.array.helper.NewPrimitiveArrayHelper;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
   import  com.github.xbn.util.copyval.NullHandlerForPrimitives;
/**
   <P>Abstract implementation of {@code ListifyCharable}.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public abstract class AbstractListifyCharable extends AbstractListifyPrimitiveable<Character> implements ListifyCharable  {
//constructors...START
   @SuppressWarnings("unchecked")
   public AbstractListifyCharable(Object raw_obj)  {
      this(raw_obj, SimpleNullHandlerForPrimitives.CRASH);
   }
   public AbstractListifyCharable(Object raw_obj, NullHandlerForPrimitives<Character> null_handler)  {
      super(raw_obj, AddRemovable.NO, NewPrimitiveArrayHelper.forCharacter(), (new OneParamCnstrValueCopier<Character>(Character.class)), null_handler);
   }
//constructors...END
   public final char[] getPArrayCopyOrNull(NullContainer nnull)  {
      if(getRawObject() == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, "getRawObject()");
         return  null;
      }
      char[] ai = new char[size()];
      int j = 0;
      for(char i : this)  {
         ai[j++] = i;
      }
      return  ai;
   }
   public final Character[] getEArrayCopyOrNull(NullContainer nnull, char copy_elements)  {
      if(getRawObject() == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, "getRawObject()");
         return  null;
      }
      Character[] ao = new Character[size()];
      int j = 0;
      for(Character I : this)  {
         ao[j++] = I;
      }
      return  ao;
   }
   protected final Character getElementRTXOkay(int index)  {
      return  getChar(index);
   }
/*stub functions for non-abstract compile...START
   public final java.util.Iterator<Character> iterator()  {
      return  null;
   }
   public final char getChar(int index)  {
      return  ' ';
   }
 stub functions for non-abstract compile...END*/
}
