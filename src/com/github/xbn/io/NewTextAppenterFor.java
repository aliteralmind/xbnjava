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

package  com.github.xbn.io;
/**
   <P>Convenience functions for creating {@code TextAppenter}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewTextAppenterFor  {
   public static final TextAppenter SUPPRESS = TextAppenter.SUPPRESS;
   public static final TextAppenter CONSOLE = TextAppenter.CONSOLE;
   private NewTextAppenterFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>Creates a new appenter with an appendable, or an unusable appenter if its {@code null}</P>

      @return  <CODE>((toApndTo_ifNonNull == null) ? TextAppenter.{@link TextAppenter#newForUnusable() newForUnusable}()
      <BR> &nbsp; &nbsp; : &nbsp;{@link #appendable(Appendable) appendable}(toApndTo_ifNonNull))</CODE>
    **/
   public static final TextAppenter appendableUnusableIfNull(Appendable toApndTo_ifNonNull)  {
      return  ((toApndTo_ifNonNull == null) ? TextAppenter.newForUnusable()
         :  appendable(toApndTo_ifNonNull));
   }
   public static final TextAppenter textAppender(TextAppender to_adapt)  {
      return  (new TextAppenter(to_adapt));
   }
   public static final TextAppenter appendable(Appendable to_appendTo)  {
      return  (new TextAppenter(new TAAppendable<Appendable>(to_appendTo)));
   }
   public static final TextAppenter appendableSuppressIfNull(Appendable toApndTo_ifNonNull)  {
      return  ((toApndTo_ifNonNull == null) ? TextAppenter.SUPPRESS
         :  appendable(toApndTo_ifNonNull));
   }
   public static final TextAppenter stringBuilder(StringBuilder to_appendTo)  {
      return  (new TextAppenter(NewTextAppenderFor.stringBuilder(to_appendTo)));
   }
   public static final TextAppenter strBldrWithInitStringNullOk(Object string)  {
      return  (new TextAppenter(NewTextAppenderFor.strBldrWithInitStringNullOk(string)));
   }
   public static final TextAppenter file(String path, AppendOrOverwrite apnd_ovr)  {
      return  (new TextAppenter(NewTextAppenderFor.file(path, apnd_ovr)));
   }
}
