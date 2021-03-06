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

package  com.github.xbn.examples.util.non_xbn;
   import  java.util.ArrayList;
   import  java.util.HashMap;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.Map;
   import  java.util.Set;
/**
   <p>Demonstrates a map with multiple values per key: {@code Map<Integer<List<String>>>}.</p>

   <p>{@code java com.github.xbn.examples.util.non_xbn.MultiValueHashMap}</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class MultiValueHashMap  {
   public static final void main(String[] ignored)  {
      Map<Integer,List<String>> mapOfIntStrs = new HashMap<Integer,List<String>>();

      //Add elements
         addStringToMap(mapOfIntStrs, 1, "one");
         addStringToMap(mapOfIntStrs, 1, "two");
         addStringToMap(mapOfIntStrs, 1, "three");
         addStringToMap(mapOfIntStrs, 2, "four");
         addStringToMap(mapOfIntStrs, 2, "five");

      //Output
         Set<Integer> keyNumSet = mapOfIntStrs.keySet();
         Iterator<Integer> keyNumItr = keyNumSet.iterator();
         while(keyNumItr.hasNext())  {
            Integer keyNum = keyNumItr.next();
            List<String> strList = mapOfIntStrs.get(keyNum);
            System.out.println(keyNum);
            for(String s : strList)  {
               System.out.println("  " + s);
            }
         }
   }
   private static final void addStringToMap(Map<Integer,List<String>> mapTo_addTo, int keyNum, String value)  {
      if(mapTo_addTo.containsKey(keyNum))  {
         mapTo_addTo.get(keyNum).add(value);
      }  else  {
         List<String> strList = new ArrayList<String>();
         strList.add(value);
         mapTo_addTo.put(keyNum, strList);
      }
   }

}
