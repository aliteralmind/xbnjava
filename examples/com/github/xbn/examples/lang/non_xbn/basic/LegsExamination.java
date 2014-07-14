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
package  com.github.xbn.examples.lang.non_xbn.basic;
/**
   <P><I>No main class</I> -- An &quot;examination&quot; of one or both of a patients legs, designed as two classes (and a boolean-Enum): A {@code OneLegExam}, and a {@code LegsExamination}, whose constructor accepts one or two {@code OneLegExam}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class LegsExamination  {
   private final OneLegExam leftLegExam;
   private final OneLegExam rightLegExam;
   public LegsExamination(OneLegExam leftLegExam, OneLegExam rightLegExam)  {
      if(leftLegExam == null  &&  rightLegExam == null)  {
         throw  new IllegalArgumentException("No legs! Both null");
      }
      this.leftLegExam = leftLegExam;
      this.rightLegExam = rightLegExam;
   }
   public OneLegExam getLeft()  {
      return  leftLegExam;
   }
   public OneLegExam getRight()  {
      return  rightLegExam;
   }
   public boolean wasLeftExamined()  {
      return  (leftLegExam != null);
   }
   public boolean wasRightExamined()  {
      return  (rightLegExam != null);
   }
}
class OneLegExam  {
   private final Object scanImg ;
   private final String      probDesc;
   private final String      comments;
   public OneLegExam(Object scanImg, String probDesc, String comments)  {
      this.scanImg = scanImg;
      this.probDesc = probDesc;
      this.comments = comments;
   }

   //Put getters here
 }
enum LegSide  { LEFT, RIGHT; };
