/*license*\
   Codelet: http://codelet.aliteralmind.com

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
package  com.github.xbn.linefilter;
   import  com.github.xbn.analyze.alter.AlwaysSetWasAlteredTo;
   import  com.github.xbn.analyze.alter.ReturnValueUnchanged;
   import  com.github.xbn.analyze.alter.ValueAlterer;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.analyze.alter.AlterValueWhen;
/**
   <P>An {@code AlterLineWhen} for text lines.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://codelet.aliteralmind.com">{@code http://codelet.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/codelet">{@code https://github.com/aliteralmind/codelet}</A>
 **/
public class AlterTextLineWhen extends AlterLineWhen<String,LineObject<String>> implements TextLineAlterer  {
   public AlterTextLineWhen()  {
      super();
   }
   public AlterTextLineWhen(ValueAlterer<LineObject<String>,String> alter_forValid)  {
      super(alter_forValid);
   }
   public AlterTextLineWhen(ValueValidator<LineObject<String>> condition, ValueAlterer<LineObject<String>,String> alter_forValid)  {
      super(condition, alter_forValid);
   }
   public AlterTextLineWhen(ValueValidator<LineObject<String>> condition, ValueAlterer<LineObject<String>,String> alter_forValid, ValueAlterer<LineObject<String>,String> alter_forInvalid)  {
      super(condition, alter_forValid, alter_forInvalid);
   }
   public AlterTextLineWhen(AlterTextLineWhen to_copy)  {
      super(to_copy);
   }
   public static final AlterTextLineWhen newATLWAlwaysReturnSelf(ValueValidator<LineObject<String>> validator)  {
      AlterTextLineWhen atlw = new AlterTextLineWhen(validator, (new ReturnValueUnchanged<LineObject<String>,String>()), (new ReturnValueUnchanged<LineObject<String>,String>(AlwaysSetWasAlteredTo.FALSE)));
      atlw.setDebug(validator.getDebugApbl(), validator.isDebugOn());
      return  atlw;
   }
}
