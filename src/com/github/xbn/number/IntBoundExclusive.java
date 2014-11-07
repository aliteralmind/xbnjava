package  com.github.xbn.number;

/**
 * <P>{@code IntBound} that may not be equal to the value.</P>
 **/
public class IntBoundExclusive extends IntBound  {
	/**
	 * <P>Create a new {@code IntBoundExclusive}.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp;  {@link IntBound#IntBound(Integer, boolean, String) super}{@code (num, {@link Inclusive}.{@link Inclusive#NO NO}, name)}</P>
	 **/
	public IntBoundExclusive(Integer num, String name)  {
		super(num, Inclusive.NO, name);
	}
	/**
	 * <P>Create a new {@code IntBoundExclusive} as a duplicate of another.</P>
	 *
	 * <P>Equal to
	 * <BR> &nbsp; &nbsp; <A HREF="IntBound.html#IntBound(IntBound)">super</A>(to_copy)</CODE></P>
	 * @param  to_copy  May not be {@code null}.
	 **/
	public IntBoundExclusive(IntBoundExclusive to_copy)  {
		super(to_copy);
	}
}
