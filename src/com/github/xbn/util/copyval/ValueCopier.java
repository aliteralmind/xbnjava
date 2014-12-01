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
package  com.github.xbn.util.copyval;
   import  com.github.xbn.lang.Copyable;
/**
   <p>Determines if an object is duplicate-able, and safely duplicates it.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public interface ValueCopier<O> extends Copyable  {
   /**
      <p>Is the value copyable?.</p>

    * @return  {@code true}  If {@link #getValueCopy(O, String) getValueCopy(O,s)} may be safely called.
    */
   boolean isValueCopyable();
   /**
      <p>Duplicate a value.</p>

    * @return  <code>{@link #getValueCopy(O, String, NullHandler) getValueCopy}(original_value, orig_name, (NullHandler&lt;O&gt;){@link com.github.xbn.util.copyval.SimpleNullHandler SimpleNullHandler.}{@link com.github.xbn.util.copyval.SimpleNullHandler#USE_NULL USE_NULL})</code>
    */
   O getValueCopy(O original_value, String orig_name);
   /**
      <p>Duplicate a value.</p>

    * @param  original_value  The original value.
    * @param  orig_name  Descriptive name of {@code original_value}. <i>Should</i> not be {@code null} or empty.
    * @param  null_handler  May not be {@code null}.
    * @return  A duplicate of {@code original_value}, or {@code null} if {@code original_value} is {@code null}.
    * @exception  NotCopyableException  If {@link #isValueCopyable() isValueCopyable}{@code ()} is {@code false}.
    * @exception  IllegalStateException  If {@code original_value} is {@code null} and <code>null_handler.{@link com.github.xbn.util.copyval.NullHandler#doDelete() doDelete}()</code> is {@code true}.
    */
   O getValueCopy(O original_value, String orig_name, NullHandler<O> null_handler);
   /**
      <p>Duplicate this {@code ValueCopier} which, by default, is a reference to the original--if any sub-classes contain state, this should be overridden.</p>

    * @return  <i>{@code this}</i>
    */
   ValueCopier<O> getObjectCopy();
}
