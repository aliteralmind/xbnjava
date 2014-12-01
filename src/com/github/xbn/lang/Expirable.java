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
   <p>For classes that do stuff, but once reaching a certain point, permanently stop doing it.</p>

   @see  com.github.xbn.analyze.alter.ExpirableAlterList
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public interface Expirable  {
   /**
   	<p>Does this object potentially expire?.</p>

   	@return  <ul>
   		<li>{@code true}: {@link #isExpired() isExpired}{@code ()} could at some point become {@code true}.</li>
   		<li>{@code false}: {@code isExpired()} will never be {@code true}.</li>
   	</ul>This value never changes.
    **/
   boolean doesExpire();
   /**
   	<p>Is this object expired?.</p>

   	@return  <ul>
   		<li>{@code true}  The object is expired.</li>
   		<li>{@code false}: If {@link #doesExpire() doesExpire}{@code ()} is {@code false}.</li>
   	</ul>This value may change from {@code true} to {@code false}, but never back.
    **/
   boolean isExpired();
}
