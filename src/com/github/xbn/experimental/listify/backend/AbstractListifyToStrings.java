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
   import  com.github.xbn.experimental.listify.AddRemovable;
   import  com.github.xbn.experimental.listify.AbstractListify;
   import  com.github.xbn.array.helper.StringArrayHelper;
   import  com.github.xbn.util.copyval.OneParamCnstrValueCopier;
/**
   <p>For building listifiers whose virtual elements are the {@code toString()}-s of the elements in its raw object.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractListifyToStrings extends AbstractListify<String>  {
//constructors...START
   public AbstractListifyToStrings(Object raw_obj)  {
      super(raw_obj, AddRemovable.NO, (new StringArrayHelper()), OneParamCnstrValueCopier.STRING);
   }
   public AbstractListifyToStrings(AbstractListifyToStrings to_copy)  {
      super(to_copy);
   }
//constructors...END
/*stub functions for implements compile...START
   public final R[] getEArrayCopyOrNull(NullContainer nnull, CopyElements copy_elements)  {
      return  null;
   }
   public final R get(int index)  {
      return  null;
   }
   public final int size()  {
      return  -1;
   }
   public final java.util.Iterator<R> iterator()  {
      return  null;
   }
   public final Object getPArrayCopyOrNull(NullContainer nnull)  {
      return  null;
   }
 stub functions for implements compile...END*/
}
