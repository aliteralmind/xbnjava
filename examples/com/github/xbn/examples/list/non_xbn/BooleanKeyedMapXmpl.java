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
package  com.github.xbn.examples.list.non_xbn;
   import  java.util.ArrayList;
   import  java.util.Arrays;
   import  java.util.List;
   import  java.util.Map;
   import  java.util.TreeMap;
/**
   <p>Adding multiple values per-key in a boolean-keyed map.</p>

   <p>{@code java com.github.xbn.examples.list.non_xbn.BooleanKeyedMapXmpl}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class BooleanKeyedMapXmpl  {
   public static final void main(String[] ignored)  {

      System.out.println("<Boolean,String>:");
         Map<Boolean,String> mbs = new TreeMap<Boolean,String>();

         mbs.put(true, "hello");
         mbs.put(false, "goodbye");
         mbs.put(null, "Kermit The Frog");

         System.out.println("true: " + mbs.get(true));
         System.out.println("false: " + mbs.get(false));
         //NullPointerException:
         //System.out.println("null: " + mbs.get(null));
         System.out.println();

      System.out.println("<Boolean,ArrayList<String>>:");
         Map<Boolean,List<String>> mbls = new TreeMap<Boolean,List<String>>();

         mbls.put(true, new ArrayList<String>());
         mbls.put(false, new ArrayList<String>());
         mbls.put(null, new ArrayList<String>());

         List<String> lsTrue = mbls.get(true);
            lsTrue.add("hello1");
            lsTrue.add("hello2");
            lsTrue.add("hello3");
            lsTrue.add("hello4");
            lsTrue.add("hello5");

         List<String> lsFalse = mbls.get(false);
            lsFalse.add("goodbye1");
            lsFalse.add("goodbye2");
            lsFalse.add("goodbye3");
            lsFalse.add("goodbye4");
            lsFalse.add("goodbye5");

         List<String> lsNull = mbls.get(null);
            lsNull.add("Kermit The Frog1");
            lsNull.add("Kermit The Frog2");
            lsNull.add("Kermit The Frog3");
            lsNull.add("Kermit The Frog4");
            lsNull.add("Kermit The Frog5");

         System.out.println("true: " + Arrays.deepToString(lsTrue.toArray()));
         System.out.println("false: " + Arrays.deepToString(lsFalse.toArray()));
         System.out.println("false: " + Arrays.deepToString(lsNull.toArray()));
   }
   }
