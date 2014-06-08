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

package  com.github.xbn.number;
/**
   <P>Convenience functions for creating {@code IntInRange}s.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>

 **/
public class NewIntInRangeFor  {
   private NewIntInRangeFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>An instance with no bounds--Equal to <CODE>{@link IntInRange}.{@link IntInRange#UNRESTRICTED UNRESTRICTED}</CODE></P>
    **/
   public static final IntInRange UNRESTRICTED = IntInRange.UNRESTRICTED;
   /**
      <P>Create a new instance with an inclusive minimum.</P>

      @return  {@link #minInclusive(int, String) minInclusive}{@code (min, min_name)}
    **/
   public static final IntInRange min(int min, String min_name)  {
      return  minInclusive(min, min_name);
   }
   /**
      <P>Create a new instance with an inclusive maximum.</P>

      @return  {@link #maxInclusive(int, String) maxInclusive}{@code (max, max_name)}
    **/
   public static final IntInRange max(int max, String max_name)  {
      return  maxInclusive(max, max_name);
   }
   /**
      <P>Create a new instance with inclusive bounds.</P>

      @return  (new {@link IntInRange#IntInRange(int, int, String, String) IntInRange}(min_max, min_max, minMax_name, minMax_name){@code </P>}
    **/
   public static final IntInRange minMax(int min_max, String minMax_name)  {
      return  new IntInRange(min_max, min_max, minMax_name, minMax_name);
//		iir.setBoundNames(minMax_name, minMax_name);
//		return  iir;
   }
   /**
      <P>Create a new instance with an inclusive minimum.</P>

      @return  <CODE>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), null))</CODE></P>
    **/
   public static final IntInRange minInclusive(int min, String min_name)  {
      return  new IntInRange(new IntBoundInclusive(min, min_name), null);
//		iir.setBoundNames(min_name, null);
//		return  iir;
   }
   /**
      <P>Create a new instance with an inclusive maximum.</P>

      @return  <CODE>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(null, (new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(max, max_name))))</CODE>
    **/
   public static final IntInRange maxInclusive(int max, String max_name)  {
      return  new IntInRange(null, (new IntBoundInclusive(max, max_name)));
//		iir.setBoundNames(null, max_name);
//		return  iir;
   }
   /**
      <P>Create a new instance with an exclusive minimum.</P>

      @return  <CODE>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}((new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(min, min_name)), null))</CODE>
    **/
   public static final IntInRange minExclusive(int min, String min_name)  {
      return  new IntInRange((new IntBoundExclusive(min, min_name)), null);
//		iir.setBoundNames(min_name, null);
//		return  iir;
   }
   /**
      <P>Create a new instance with an exclusive maximum.</P>

      @return  <CODE>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(null, (new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max, max_name))))</CODE>
    **/
   public static final IntInRange maxExclusive(int max, String max_name)  {
      return  new IntInRange(null, (new IntBoundExclusive(max, max_name)));
//		iir.setBoundNames(null, max_name);
//		return  iir;
   }
   /**
      <P>Create a new instance with inclusive bounds.</P>

      @return  <CODE>{@link #minMaxInclusive(int, int, String, String) minMaxInclusive}(min, max, min_name, max_name)</CODE>
    **/
   public static final IntInRange minMax(int min, int max, String min_name, String max_name)  {
      return  minMaxInclusive(min, max, min_name, max_name);
   }
   /**
      <P>Create a new instance with inclusive bounds.</P>

      @return  <CODE>(new {@link IntInRange#IntInRange(int, int, String, String) IntInRange}(min, max, min_name, max_name))</CODE>
    **/
   public static final IntInRange minMaxInclusive(int min, int max, String min_name, String max_name)  {
      return  new IntInRange(min, max, min_name, max_name);
//		iir.setBoundNames(min_name, max_name);
//		return  iir;
   }
   /**
      <P>Create a new instance with an inclusive minimum and exclusive maximum.</P>

      @return  <CODE>new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(
         <BR> &nbsp; &nbsp; new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name),
         <BR> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max, max_name))</CODE>
    **/
   public static final IntInRange minInMaxExclusive(int min, int max, String min_name, String max_name)  {
      return  new IntInRange(
         new IntBoundInclusive(min, min_name),
         new IntBoundExclusive(max, max_name));
//		iir.setBoundNames(min_name, max_name);
//		return  iir;
   }
   /**
      <P>Create a new instance with an exclusive minimum and inclusive maximum.</P>

      @return  <CODE>new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(
         <BR> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(min, min_name),
         <BR> &nbsp; &nbsp; new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(max, max_name))</CODE>
    **/
   public static final IntInRange minExMaxInclusive(int min, int max, String min_name, String max_name)  {
      return  new IntInRange(
         new IntBoundExclusive(min, min_name),
         new IntBoundInclusive(max, max_name));
//		iir.setBoundNames(min_name, max_name);
//		return  iir;
   }
   /**
      <P>Create a new instance with exclusive bounds.</P>

      @return  <CODE>new {@link IntInRange#IntInRange(int, int) IntInRange}(
         <BR> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(min, min_name),
         <BR> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max, max_name))</CODE>
    **/
   public static final IntInRange minMaxExclusive(int min, int max, String min_name, String max_name)  {
      return  new IntInRange(
         new IntBoundExclusive(min, min_name),
         new IntBoundExclusive(max, max_name));
//		iir.setBoundNames(min_name, max_name);
//		return  iir;
   }
}
