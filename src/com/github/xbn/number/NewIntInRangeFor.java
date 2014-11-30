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
   import  com.github.xbn.lang.Invert;
/**
   <p>Convenience functions for creating {@code IntInRange}s.</p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class NewIntInRangeFor  {
   private NewIntInRangeFor()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>An {@code IntInRange} with no bounds.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link IntInRange}.{@link IntInRange#UNRESTRICTED UNRESTRICTED}</code></p>
    **/
   public static final IntInRange UNRESTRICTED = IntInRange.UNRESTRICTED;
   /**
      <p>An {@code IntInRange} with no members.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link IntInRange}.{@link IntInRange#IMPOSSIBLE IMPOSSIBLE}</code></p>
    **/
   public static final IntInRange IMPOSSIBLE = IntInRange.IMPOSSIBLE;
   /**
      <p>Create a new instance with an inclusive minimum.</p>

      @return  {@link #minInclusive(Invert, int, String) minInclusive}{@code (min, min_name)}
    **/
   public static final IntInRange min(Invert invert_dontIfNull, int min, String min_name)  {
      return  minInclusive(getInvNoIfNull(invert_dontIfNull),
         min, min_name);
   }
   /**
      <p>Create a new instance with an inclusive maximum.</p>

      @return  {@link #maxInclusive(Invert, int, String) maxInclusive}{@code (max, max_name)}
    **/
   public static final IntInRange max(Invert invert_dontIfNull, int max, String max_name)  {
      return  maxInclusive(getInvNoIfNull(invert_dontIfNull),
         max, max_name);
   }
   /**
      <p>Create a new instance with inclusive bounds.</p>

      @return  (new {@link IntInRange#IntInRange(int, int, String, String) IntInRange}(min_max, min_max, minMax_name, minMax_name){@code </p>}
    **/
   public static final IntInRange exactly(Invert invert_dontIfNull, int min_max, String minMax_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         min_max, min_max, minMax_name, minMax_name);
   }
   /**
      <p>Create a new instance with an inclusive minimum.</p>

      @return  <code>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name), null))</code></p>
    **/
   public static final IntInRange minInclusive(Invert invert_dontIfNull, int min, String min_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(min, min_name), null);
   }
   /**
      <p>Create a new instance with an inclusive maximum.</p>

      @return  <code>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(null, (new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(max, max_name))))</code>
    **/
   public static final IntInRange maxInclusive(Invert invert_dontIfNull, int max, String max_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         null, (new IntBoundInclusive(max, max_name)));
   }
   /**
      <p>Create a new instance with an exclusive minimum.</p>

      @return  <code>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}((new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(min, min_name)), null))</code>
    **/
   public static final IntInRange minExclusive(Invert invert_dontIfNull, int min, String min_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         (new IntBoundExclusive(min, min_name)), null);
   }
   /**
      <p>Create a new instance with an exclusive maximum.</p>

      @return  <code>(new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(null, (new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max, max_name))))</code>
    **/
   public static final IntInRange maxExclusive(Invert invert_dontIfNull, int max, String max_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         null, (new IntBoundExclusive(max, max_name)));
   }
   /**
      <p>Create a new instance with inclusive bounds.</p>

      @return  <code>{@link #minMaxInclusive(Invert, int, int, String, String) minMaxInclusive}(min, max, min_name, max_name)</code>
    **/
   public static final IntInRange minMax(Invert invert_dontIfNull, int min, int max, String min_name, String max_name)  {
      return  minMaxInclusive(getInvNoIfNull(invert_dontIfNull),
         min, max, min_name, max_name);
   }
   /**
      <p>Create a new instance with inclusive bounds.</p>

      @return  <code>(new {@link IntInRange#IntInRange(int, int, String, String) IntInRange}(min, max, min_name, max_name))</code>
    **/
   public static final IntInRange minMaxInclusive(Invert invert_dontIfNull, int min, int max, String min_name, String max_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         min, max, min_name, max_name);
   }
   /**
      <p>Create a new instance with an inclusive minimum and exclusive maximum.</p>

      @return  <code>new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(
         <br/> &nbsp; &nbsp; new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(min, min_name),
         <br/> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max, max_name))</code>
    **/
   public static final IntInRange minInMaxExclusive(Invert invert_dontIfNull, int min, int max, String min_name, String max_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundInclusive(min, min_name),
         new IntBoundExclusive(max, max_name));
   }
   /**
      <p>Create a new instance with an exclusive minimum and inclusive maximum.</p>

      @return  <code>new {@link IntInRange#IntInRange(IntBound, IntBound) IntInRange}(
         <br/> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(min, min_name),
         <br/> &nbsp; &nbsp; new {@link IntBoundInclusive#IntBoundInclusive(Integer, String) IntBoundInclusive}(max, max_name))</code>
    **/
   public static final IntInRange minExMaxInclusive(Invert invert_dontIfNull, int min, int max, String min_name, String max_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundExclusive(min, min_name),
         new IntBoundInclusive(max, max_name));
   }
   /**
      <p>Create a new instance with exclusive bounds.</p>

      @return  <code>new {@link IntInRange#IntInRange(int, int) IntInRange}(
         <br/> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(min, min_name),
         <br/> &nbsp; &nbsp; new {@link IntBoundExclusive#IntBoundExclusive(Integer, String) IntBoundExclusive}(max, max_name))</code>
    **/
   public static final IntInRange minMaxExclusive(Invert invert_dontIfNull, int min, int max, String min_name, String max_name)  {
      return  new IntInRange(getInvNoIfNull(invert_dontIfNull),
         new IntBoundExclusive(min, min_name),
         new IntBoundExclusive(max, max_name));
   }
      private static final Invert getInvNoIfNull(Invert invert_dontIfNull)  {
         return  ((invert_dontIfNull != null) ? invert_dontIfNull : Invert.NO);
      }
}
