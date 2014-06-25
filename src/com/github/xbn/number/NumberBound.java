package  com.github.xbn.number;
   import  java.util.Objects;
   import  com.github.xbn.keyed.Named;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.text.CrashIfString;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.lang.CrashIfObject;

/**
   <P>Minimum or maximum extreme of a range.</P>
 **/
public abstract class NumberBound<N extends Number> implements Named  {
   private final N num;
   private final boolean isInclusive;
   private final String name;
   /**
      <P>Create a new {@code NumberBound}.</P>
    **/
   public NumberBound(N num, boolean is_inclusive, String name)  {
      Objects.requireNonNull(num, "num");
      this.num = num;
      isInclusive = is_inclusive;
      CrashIfString.empty(Null.OK, name, "name", null);
      this.name = name;
   }
   /**
      <P>Create a new {@code NumberBound} as a duplicate of another.</P>

      <P>This<OL>
         <LI>YYY</LI>
      </OL></P>

      @param  to_copy  May not be {@code null}.
    **/
   public NumberBound(NumberBound<N> to_copy)  {
      try  {
         num = to_copy.get();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      isInclusive = to_copy.isInclusive();
      name = to_copy.getName();
   }
   public String getName()  {
      return  name;
   }
   /**
      <P>Get the bound number.</P>
    **/
   public final N get()  {
      return  num;
   }
   public abstract N getGivenIncl(BoundSide min_orMax);
   public abstract N getInclComparedTo(BoundSide min_orMax, N num);
   /**
      <P>Is this bound considered inclusive?.</P>

      @return  <UL>
         <LI>{@code true} This bound is inclusive (meaning--if a minimum--a number must be greater-than-or-equal-to it).</LI>
         <LI>{@code false}: Exclusive (a number must be greater than it).</LI>
      </UL>
    **/
   public final boolean isInclusive()  {
      return  isInclusive;
   }
   public String toString()  {
      return  ((getName() == null) ? "" : getName() + "=") +
         get() + " (" + (isInclusive() ? "in" : "ex") + "clusive)";
   }
   /**
      @param  to_compareTo  May not be {@code null}.
    **/
   @Override
   public boolean equals(Object to_compareTo)  {
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
      if(!(to_compareTo instanceof NumberBound))  {
         return  false;
      }

      @SuppressWarnings("unchecked")
      NumberBound<?> o = (NumberBound<?>)to_compareTo;

      //Finish with field-by-field comparison.
      return  areFieldsEqual(o);
   }
   /**
      <P>Are all relevant fields equal?.</P>

      @param  to_compareTo  May not be {@code null}.
    **/
   public boolean areFieldsEqual(NumberBound<?> to_compareTo)  {
      return  (get().equals(to_compareTo.get())  &&
            isInclusive() == to_compareTo.isInclusive());
   }
   @Override
   public int hashCode()  {
      return  27 * get().hashCode() +
         (isInclusive() ? 1 : 0);
   }
   public static final <N extends Number> StringBuilder appendExclusiveOrES(StringBuilder sd_toAppendTo, String prefixfixForEx, NumberBound<N> bound, String postfixfixForEx)  {
      try  {
         if(bound.isInclusive())  {
            //Nothing to append
            return  sd_toAppendTo;
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(bound, "bound", null, rx);
      }
      return  sd_toAppendTo.append(prefixfixForEx).append("exclusive").append(postfixfixForEx);
   }
   public String getKey()  {
      return  getName();
   }
}
