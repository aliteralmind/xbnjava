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
package  com.github.xbn.examples.analyze.validate;
   import  com.github.xbn.lang.RuleType;
   import  com.github.xbn.analyze.validate.NullnessValidator;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.analyze.validate.z.ValueValidator_Cfg;
   import  com.github.xbn.analyze.validate.NewValueValidatorFor;
/**
   <P>Simple custom {@code com.github.xbn.analyze.validate.}{@link com.github.xbn.analyze.validate.ValueValidator ValueValidator} for integers (must be non-{@code null} and equal to 3), and also demonstrates {@link com.github.xbn.analyze.validate.NullnessValidator NullnessValidator}.</P>

   <P>{@code java com.github.xbn.examples.analyze.validate.ValueValidatorXmpl}</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ValueValidatorXmpl  {
   public static final void main(String[] ignored)  {

      //Test the values against some pre-built NullnessValidator's
         test(NewValueValidatorFor.<Integer>nullBad(null, null));
         test(NewValueValidatorFor.<Integer>onlyNullGood(null, null));

      //Test them against the custom ValueValidator (at the bottom of this file)
         test(new VVOnlyTheNumber3IsValid());
   }
   //Testing code...START
      private static final void test(ValueValidator<Integer> int_validator)  {
         System.out.println("Rules: " + int_validator.getRules());
         testValueForVVI(int_validator, null);
         testValueForVVI(int_validator, 3);
         testValueForVVI(int_validator, 10);
      }
      private static final void testValueForVVI(ValueValidator<Integer> int_validator, Integer num)  {
         System.out.println("   Testing " + num + "...");

         System.out.println("      Valid?  " + (int_validator.isValid(num) ? "Yes" : "No") + "  (source=" + int_validator.getValidResultSource() + ")");

         System.out.print("      Crash if bad: ");
         try  {
            int_validator.crashIfBadValue(num, "[thenumberobject]");

            System.out.println("(valid)");
         }  catch(RuntimeException rx)  {
            System.out.println(rx);
         }
      }
   //Testing code...END
}
class VVOnlyTheNumber3IsValid extends NullnessValidator<Integer>  {
   public VVOnlyTheNumber3IsValid()  {
      super(RuleType.RESTRICTED, new ValueValidator_Cfg().nullOk(false).invert(false));
   }
   public VVOnlyTheNumber3IsValid(VVOnlyTheNumber3IsValid to_copy)  {
      super(to_copy);
   }
   public boolean doesFollowRulesPreInvert(Integer num)  {
      if(!super.doesFollowRulesPreInvert(num))  {
         return  false;
      }
      if(num == null)  {
         //We know it's not null, because "nullOk(false)".
         //Putting this here prevents "nullOk(true)" from
         //causing a problem in the future.
         return  true;
      }

      if(isDebugOn()) { getDebugAptr().appentln("<VVON3>    super.doesFollowRulesPreInvert(num) is true. Returning (num == 3)=" + (num == 3) + ""); }

      return  (num == 3);
   }
   public VVOnlyTheNumber3IsValid getObjectCopy()  {
      return  (new VVOnlyTheNumber3IsValid(this));
   }
   public StringBuilder appendRules(StringBuilder to_appendTo)  {
      return  super.appendRules(to_appendTo).append(", only legal value is 3.");
   }
}
