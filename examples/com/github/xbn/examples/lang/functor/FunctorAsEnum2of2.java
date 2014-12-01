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
package  com.github.xbn.examples.lang.functor;
/**
   <p>Another example of implementing a functor with an Enum.</p>

   <p>{@code java com.github.xbn.examples.lang.functor.FunctorAsEnum2of2}</p>

 * @see  com.github.xbn.examples.lang.functor.FunctorAsEnum1of2
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class FunctorAsEnum2of2  {
   public static final void main(String[] ignored)  {
      test(MachineAction.ONE);
      test(MachineAction.TWO);
      test(MachineAction.THREE);
      test(MachineAction.FOUR);
   }
   private static final void test(MachineAction action)  {
      System.out.println("MachineAction." + action + ": name=" + action.name + ", ip=" + action.ip + "");
   }
}
enum MachineAction  {
   ONE("Name1", "192.1.1.1"),
   TWO("Name2", "292.2.2.2"),
   THREE("Name3", "392.3.3.3"),
   FOUR("Name4", "492.4.4.4"),
   FIVE("Name5", "592.5.5.5");

   public final String name;
   public final String ip;

   private MachineAction(String name, String ip)  {
      this.name = name;
      this.ip = ip;
   }
}
