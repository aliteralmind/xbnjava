/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com
   
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
package  com.github.xbn.keyed;
   import  java.util.Objects;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.Comparator;
/**
   <P>Comparator for {@code Keyed} elements whose keys are comparable.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class KeyComparator<K extends Comparable<? super K>,D extends Keyed<K>> implements Comparator<D>  {
   @Override
   public int compare(D keyed_a, D keyed_2)  {
      try  {
         return  keyed_a.getKey().compareTo(keyed_2.getKey());
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(keyed_a, "keyed_a");
         throw  CrashIfObject.nullOrReturnCause(keyed_2, "keyed_2", null, rx);
      }
   }
}
