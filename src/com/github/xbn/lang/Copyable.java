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
package  com.github.xbn.lang;
/**
   <p>{@code Copyable} objects may be safely duplicated.</p>

   @see  <code><a href="http://stackoverflow.com/questions/21388479/how-to-rectify-both-define-getobjectcopy-but-with-unrelated-return-types">http://stackoverflow.com/questions/21388479/how-to-rectify-both-define-getobjectcopy-but-with-unrelated-return-types</a></code>
   @see  <code><a href="http://stackoverflow.com/questions/21421576/how-to-justify-why-an-unchecked-cast-is-okay-regarding-copyable-getobjectcopy">http://stackoverflow.com/questions/21421576/how-to-justify-why-an-unchecked-cast-is-okay-regarding-copyable-getobjectcopy</a></code>
   @see  <code><a href="http://stackoverflow.com/questions/21471663/linear-inheritance-structure-not-working-b-c-of-root-interface-copyablec-exten">http://stackoverflow.com/questions/21471663/linear-inheritance-structure-not-working-b-c-of-root-interface-copyablec-exten</a></code>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface Copyable  {
   /**
    * <p>Get a deep-as-possible duplicate of this {@code Copyable}--when copyable, this function contains a description of exactly what is and is not copied. In most cases, this calls the copy constructor (whose only parameter is of the same type as the class itself). In less-common cases, this may be a reference to the original object.</p>

      @return A non-{@code null} copy of this {@code Copyable}.
    **/
   Copyable getObjectCopy();
}
