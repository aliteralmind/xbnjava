/*license*\
   XBN-Java: http://xbnjava.aliteralmind.com

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
package  com.github.xbn.linefilter.alter;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.lang.SimpleAdapter;
   import  com.github.xbn.lang.RuleType;
/**
   <p>Makes anything behave like a text-line alterer.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractTextLineAlterAdapter<E> extends SimpleAdapter<E> implements TextLineAlterAdapter<E>  {
//	private final boolean isRequired;
   public AbstractTextLineAlterAdapter(E to_adapt)  {
/*
      this(to_adapt, AlterationRequired.YES);
   }
   public AbstractTextLineAlterAdapter(E to_adapt, AlterationRequired required)  {
 */
      super(to_adapt);
/*
      try  {
         isRequired = required.isYes();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(required, "required", null, rx);
      }
   }
   public boolean isRequired()  {
      return  isRequired;
 */
   }
   public RuleType getRuleType()  {
      return  RuleType.UNRESTRICTED;
   }
   /**
    * @return  <code>{@link #appendRules(StringBuilder) appendRules}(new StringBuilder()).toString()</code>
    */
   public String getRules()  {
      return  appendRules(new StringBuilder()).toString();
   }
   /**
    * @param  to_appendTo May not be {@code null}.
    * @see  #getRules()
    */
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      try  {
         to_appendTo.append("[NO RULES. MUST OVERRIDE appendRules(sd)]");
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_appendTo, "to_appendTo", null, rx);
      }
      return  to_appendTo;
   }
}
