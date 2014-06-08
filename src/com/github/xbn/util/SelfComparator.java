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
package  com.github.xbn.util;
   import  java.util.Objects;
   import  com.github.xbn.lang.Copyable;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.Comparator;
/**
   <P>{@code Comparator} that uses the {@code Comparable} object itself to do the comparison.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class SelfComparator<M extends Comparable<? super M>> implements Comparator<M>, Copyable  {
   private boolean bAsc = false;
   public SelfComparator()  {
   }
   /**
      <P>Create a new {@code SelfComparator}.</P>

      @param  is_ascending  If {@code true}, then the comparator requires ascending order. If {@code false}, descending (see {@link #compare(M, M) compare(M,M)}). Get with {@link #isAscending() isAscending}{@code ()}.

      @see  #SelfComparator(SelfComparator) this(sc)
    **/
   public SelfComparator(boolean is_ascending)  {
      bAsc = is_ascending;
   }
   /**
      <P>Create a new {@code SelfComparator}, as a duplicate of another.</P>

      <P>This<OL>
         <LI>Sets {@link #isAscending() isAscending}{@code ()} to {@code to_copy.isAscending()}</LI>
      </OL></P>
      @see  #SelfComparator(boolean) this(b)
    **/
   public SelfComparator(SelfComparator<M> to_copy)  {
      try  {
         bAsc = to_copy.isAscending();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
   }
   /**
      @param  o_1  May not be {@code null}.
      @param  o_2  May not be {@code null}
      @return  If {@link #isAscending() isAscending}{@code ()} is<UL>
         <LI>{@code true}: {@code o_1.compareTo(o_2)}</LI>
         <LI>{@code false}: {@code (o_1.compareTo(o_2) * -1)}</LI>
      </UL>
    **/
   public int compare(M o_1, M o_2)  {
      int icmpr = -1;
      try  {
         icmpr = o_1.compareTo(o_2);
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(o_1, "o_1");
         throw  CrashIfObject.nullOrReturnCause(o_2, "o_2", null, rx);
      }

      if(!isAscending())  {
         return  (icmpr * -1);
      }
      return  icmpr;
   }
   @Override public int hashCode()  {
      return  27;
   }
   /**
      @param  to_compareTo  May not be {@code null}.
    **/
   @Override public boolean equals(Object to_compareTo)  {
      if(to_compareTo == null)  {
         throw  new NullPointerException("to_compareTo");
      }
      if(this == to_compareTo)  {
         return  true;
      }

      /**
         http://www.javapractices.com/topic/TopicAction.do?Id=17
         downloaded 10/14/2010
         use instanceof instead of getClass here for two reasons
         1. if need be, it can match any supertype, and not just one class;
         2. it renders an explict check for "that == null" redundant, since
         it does the check for null already - "null instanceof [type]" always
         returns false. (See Effective Java by Joshua Bloch.)

         [[[
            Item two is wrong. When the parameter is null, it should throw an npx instead of throwing false:
            See: xbnjava\z_build\answers\is-it-a-bad-idea-if-equalsnull-throws-nullpointerexception-instead.txt
         ]]]
       **/
      if(!(to_compareTo instanceof SelfComparator))  {
         return  false;
      }

      //Safe to cast
      @SuppressWarnings("unchecked")  //instanceof does not recognize generics
      SelfComparator selfCmpr = (SelfComparator)to_compareTo;

      //Field-by-field comparison
      return  isAscending() == selfCmpr.isAscending();
   }
   /**
      <P>Should the comparison be ordered ascending?.</P>

      @see  #SelfComparator(boolean) this(b)
    **/
   public final boolean isAscending()  {
      return  bAsc;
   }
   /**
      <P>Get a duplicate of this {@code SelfComparator}.</P>

      @return  <CODE>(new {@link #SelfComparator(SelfComparator) SelfComparator}&lt;M&gt;(this))</CODE>
    **/
   public SelfComparator<M> getObjectCopy()  {
      return  (new SelfComparator<M>(this));
   }
}
