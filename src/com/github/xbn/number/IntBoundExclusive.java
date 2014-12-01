package  com.github.xbn.number;

/**
 * <p>{@code IntBound} that may not be equal to the value.</p>
 **/
public class IntBoundExclusive extends IntBound  {
   /**
    * <p>Create a new {@code IntBoundExclusive}.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp;  {@link IntBound#IntBound(Integer, boolean, String) super}{@code (num, {@link Inclusive}.{@link Inclusive#NO NO}, name)}</p>
    */
   public IntBoundExclusive(Integer num, String name)  {
      super(num, Inclusive.NO, name);
   }
   /**
    * <p>Create a new {@code IntBoundExclusive} as a duplicate of another.</p>
    *
    * <p>Equal to
    * <br/> &nbsp; &nbsp; <a href="IntBound.html#IntBound(IntBound)">super</a>(to_copy)</code></p>
    * @param  to_copy  May not be {@code null}.
    */
   public IntBoundExclusive(IntBoundExclusive to_copy)  {
      super(to_copy);
   }
}
