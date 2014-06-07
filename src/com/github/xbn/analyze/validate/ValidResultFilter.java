/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/

package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.Expirable;
   import  com.github.xbn.io.Debuggable;
   import  com.github.xbn.lang.ToStringAppendable;
   import  com.github.xbn.lang.Copyable;
/**
   <P>Changes the result of a {@code Validator} based on conditions.</P>

{@.codelet.and.out com.github.xbn.examples.analyze.validate.ValidResultFilterXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

{@.codelet.and.out com.github.xbn.examples.analyze.validate.FirstCheckIsAlwaysValidThenExpireXmpl:eliminateCmtBlocksPkgLineAndPkgReferences(true, true, false)}

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public interface ValidResultFilter extends Copyable, ToStringAppendable, Debuggable, Expirable  {
   /**
      <P>Before the <I>something</I> is ever validated against the rules, what should happen?.</P>

      @return  {@link FilterPreAction#RETURN_FALSE RETURN_FALSE}: If {@link #isExpired() isExpired}{@code ()} is {@code true}.
    **/
   FilterPreAction getPreAction();
   /**
      <P>After the <I>something</I> is validated against the rules, what value should be returned?.</P>

      @param  were_postInvertRulesFollowed  If the rules--post inversion--were followed.
      @return  {@link FilterAfterValue#FALSE FALSE}  If {@link #isExpired() isExpired}{@code ()} is {@code true}.
    **/
   FilterAfterValue getAfterValueFromInvertedRules(boolean were_postInvertRulesFollowed);
   ValidResultFilter getObjectCopy();
   /**
      <P>Is this filter expired?.</P>

      <P>When this filter is expired, the containing {@link Validator validator} is also expired.</P>
    **/
   @Override
   boolean isExpired();
   /**
      <P>Does this filter do nothing?.</P>
    **/
   boolean doesNothing();
}
