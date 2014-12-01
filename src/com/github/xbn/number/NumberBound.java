package  com.github.xbn.number;
   import  java.util.Objects;
   import  com.github.xbn.keyed.Named;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.text.CrashIfString;
   import  com.github.xbn.lang.CrashIfObject;
/**
 * <p>Minimum or maximum extreme of a range.</p>
 **/
public abstract class NumberBound<N extends Number> implements Named  {
   private final N num;
   private final boolean isInclusive;
   private final String name;
   /**
    * @deprecated Use <code><!-- Generic parameters fail in at-links: --><a href="#NumberBound(N, com.github.xbn.number.Inclusive, java.lang.String)">NumberBound</a>(N,i,s)</code>
    * @since  0.1.4.2
    */
   public NumberBound(N num, boolean is_inclusive, String name)  {
      this(num, Inclusive.getForBoolean(is_inclusive), name);
   }
   /**
    * <p>Create a new {@code NumberBound}.</p>
    * @param  num  May not be <code>null</code>. Get with {@link #get() get}{@code ()}.
    * @param  incl May not be <code>null</code>. Get with {@link #isInclusive() isInclusive}{@code ()}.
    * @param  name Descriptive name. Get with {@link #getName() getName}{@code ()}.
    * @since  0.1.4.2
    */
   public NumberBound(N num, Inclusive incl, String name)  {
      Objects.requireNonNull(num, "num");
      this.num = num;
      isInclusive = incl.isYes();
      CrashIfString.empty(Null.OK, name, "name", null);
      this.name = name;
   }
   /**
    * <p>Create a new {@code NumberBound} as a duplicate of another.</p>
    *
    * <p>This<ol>
    *    <li>YYY</li>
    * </ol></p>
    * @param  to_copy  May not be {@code null}.
    */
   public NumberBound(NumberBound<N> to_copy)  {
      try  {
         num = to_copy.get();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }
      isInclusive = to_copy.isInclusive();
      name = to_copy.getName();
   }
   /**
    * The descriptive name of this bound.
    * @return A name suitable for diagnostics.
    * @see <code><!-- Generic parameters fail in at-links: --><a href="#NumberBound(N, com.github.xbn.number.Inclusive, java.lang.String)">NumberBound</a>(N,i,s)</code>
    */
   public String getName()  {
      return  name;
   }
   /**
    * <p>Get the bound number.</p>
    * @see <code><!-- Generic parameters fail in at-links: --><a href="#NumberBound(N, com.github.xbn.number.Inclusive, java.lang.String)">NumberBound</a>(N,i,s)</code>
    * @see #getGivenIncl(com.github.xbn.number.BoundSide)
    */
   public final N get()  {
      return  num;
   }
   /**
    * Get the absolute bound-value, given its inclusivity.
    * @param  min_orMax May not be <code>null</code>.
    * @return  Integer example: If {@linkplain #isInclusive() inclusive}is <ul>
    *   <li>{@code true}:  {@link #get() get}{@code ()}</li>
    *   <li>{@code false}: If <code>min_orMax.{@link BoundSide#isMin() isMin}()</code> is <ul>
    *      <li>{@code true}: {@code (get() + 1)}</li>
    *      <li>{@code false}: {@code (get() - 1)}</li>
    *   </ul></li>
    * </ul>
    * @see #get()
    */
   public abstract N getGivenIncl(BoundSide min_orMax);
   /**
    * Compare the <i>inclusive</i> bound-value against a number.
    * @param  min_orMax May not be <code>null</code>.
    * @param  num       May not be <code>null</code>.
    * @return  Integer example:
    * <br/> &nbsp; &nbsp; <code>{@link #getGivenIncl(BoundSide) getGivenIncl}(min_orMax).intValue() - num.intValue();</code>
    * @exception NullPointerException If {@code num} is {@code null}.
    */
   public abstract N getInclComparedTo(BoundSide min_orMax, N num);
   /**
    * <p>Is this bound considered inclusive?.</p>
    * @return  <ul>
    *    <li>{@code true} This bound is inclusive (meaning--if a minimum--a number must be greater-than-or-equal-to it).</li>
    *    <li>{@code false}: Exclusive (a number must be greater than it).</li>
    * </ul>
    * @see <code><!-- Generic parameters fail in at-links: --><a href="#NumberBound(N, com.github.xbn.number.Inclusive, java.lang.String)">NumberBound</a>(N,i,s)</code>
    */
   public final boolean isInclusive()  {
      return  isInclusive;
   }
   public String toString()  {
      return  ((getName() == null) ? "" : getName() + "=") +
         get() + " (" + (isInclusive() ? "in" : "ex") + "clusive)";
   }
   /**
    * @param  to_compareTo  May not be {@code null}.
    */
   @Override
   public boolean equals(Object to_compareTo)  {
      //Check for object equality first, since it's faster than instanceof.
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof NumberBound))  {
         //to_compareTo is either null or not an NumberBound.
         //java.lang.Object.object(o): "For any non-null reference value x,
         //x.equals(null) should return false."
         return  false;
      }

      //Safe to cast
      @SuppressWarnings("unchecked")
      NumberBound<N> o = (NumberBound<N>)to_compareTo;

      //Finish with field-by-field comparison.
      return  areFieldsEqual(o);
   }
   /**
    * <p>Are all relevant fields equal?.</p>
    * @param  to_compareTo  May not be {@code null}.
    */
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
