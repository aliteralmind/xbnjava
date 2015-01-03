package  com.github.xbn.number;

/**
 * <p>{@code IntBound} that may be equal to the value.</p>
 **/
public class IntBoundInclusive extends IntBound  {
   /**
    * <p>Create a new {@code IntBoundInclusive}.</p>
    *
    * <p>Equal to
    * <br> &nbsp; &nbsp;  {@link IntBound#IntBound(Integer, boolean, String) super}{@code (num, {@link Inclusive}.{@link Inclusive#YES YES}, name)}</p>
    */
   public IntBoundInclusive(Integer num, String name)  {
      super(num, Inclusive.YES, name);
   }
   /**
    * <p>Create a new {@code IntBoundInclusive} as a duplicate of another.</p>
    *
    * <p>Equal to
    * <br> &nbsp; &nbsp; <a href="IntBound.html#IntBound(IntBound)">super</a>(to_copy)</code></p>
    * @param  to_copy  May not be {@code null}.
    */
   public IntBoundInclusive(IntBoundInclusive to_copy)  {
      super(to_copy);
   }
}
