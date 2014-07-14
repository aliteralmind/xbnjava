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
package  com.github.xbn.array;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.number.NumberUtil;
/**
   <P>Get the middle index given a specific length. Intended for future utilities related to indexable and lengthable containers (such as strings, arrays, and collections).</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class IndexableUtil  {
   private IndexableUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>Get the middle index of a container, given its length.</P>

      @return  {@link com.github.xbn.number.NumberUtil NumberUtil.}{@link com.github.xbn.number.NumberUtil#getMiddleInt(int, int) getMiddleInt}{@code (0, length)}
    **/
   public static final int getMiddleIndex(int length)  {
      return  NumberUtil.getMiddleInt(0, length);
   }
   /**
      <P>Get a random index for a container, given its length.</P>
    **/
   public static final int getRandomIndexForLength(int length)  {
      return  NumberUtil.getRandomBetweenInclusive(0, (length - 1));
   }
   public static final void crashIfContainerIsNullAndThatIsBad(NullContainer nnull, String obj_name)  {
      boolean isBad = false;
      try  {
         isBad = nnull.isBad();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(nnull, "nnull", null, rx);
      }
      if(isBad)  {
         throw  new NullPointerException(obj_name + " is null (nnull.isBad() is true).");
      }
   }
}
