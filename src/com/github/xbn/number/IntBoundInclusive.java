package  com.github.xbn.number;

/**
   <P>{@code IntBound} that may be equal to the value.</P>
 **/
public class IntBoundInclusive extends IntBound  {
   /**
      <P>Create a new {@code IntBoundInclusive}.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp;  {@link IntBound#IntBound(Integer, boolean, String) super}{@code (num, true, name)}</P>
    **/
   public IntBoundInclusive(Integer num, String name)  {
      super(num, true, name);
   }
   /**
      <P>Create a new {@code IntBoundInclusive} as a duplicate of another.</P>

      <P>Equal to
      <BR> &nbsp; &nbsp; <A HREF="IntBound.html#IntBound(IntBound)">super</A>(to_copy)</CODE></P>

      @param  to_copy  May not be {@code null}.
    **/
   public IntBoundInclusive(IntBoundInclusive to_copy)  {
      super(to_copy);
   }
}
