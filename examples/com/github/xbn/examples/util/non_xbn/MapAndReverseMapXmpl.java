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
package  com.github.xbn.examples.util.non_xbn;
   import  java.util.Arrays;
   import  java.util.Iterator;
   import  java.util.Set;
   import  java.util.ArrayList;
   import  java.util.HashMap;
   import  java.util.List;
/**
   <p>Reverse lookup using two maps.</p>

   <p>{@code java com.github.xbn.examples.util.non_xbn.MapAndReverseMapXmpl}</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class MapAndReverseMapXmpl  {
   public static void main(String[] ignored)  {
      HashMap<String,Integer> mainMap = new HashMap<String,Integer>();
      HashMap<Integer,List<String>> rvrsMap = new HashMap<Integer,List<String>>();
      addItem(mainMap, rvrsMap, "abc",1);
      addItem(mainMap, rvrsMap, "def",2);
      addItem(mainMap, rvrsMap, "ghi",3);
      addItem(mainMap, rvrsMap, "jkl",1);
      addItem(mainMap, rvrsMap, "mno",1);

      System.out.println("string-to-int:");
         Set<String> strKeySet = mainMap.keySet();
         Iterator<String> strKeyItr = strKeySet.iterator();
         while(strKeyItr.hasNext())  {
            String strKey = strKeyItr.next();
            System.out.println(strKey + ": " + mainMap.get(strKey));
         }
         System.out.println();

      System.out.println("int-to-string:");
         Set<Integer> intKeySet = rvrsMap.keySet();
         Iterator<Integer> intKeyItr = intKeySet.iterator();
         while(intKeyItr.hasNext())  {
            Integer intkey = intKeyItr.next();
            System.out.println(intkey + ": " + Arrays.toString(rvrsMap.get(intkey).toArray()));
         }
         System.out.println();

   }
   private static final void addItem(HashMap<String,Integer> main_strIntMap, HashMap<Integer,List<String>> rvrs_intStrMap, String new_strValue, int new_intNum)  {
      main_strIntMap.put(new_strValue, new_intNum);

      if(rvrs_intStrMap.containsKey(new_intNum))  {
         rvrs_intStrMap.get(new_intNum).add(new_strValue);

      }  else  {
         ArrayList<String> strList = new ArrayList<String>(5);
         strList.add(new_strValue);
         rvrs_intStrMap.put(new_intNum, strList);
      }
   }
}
