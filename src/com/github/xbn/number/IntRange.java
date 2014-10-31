package  com.github.xbn.number;

/**
	<P><CODE>NumberRange</CODE> for ints.</P>
 **/
public interface IntRange extends NumberRange<Integer>  {
	@Override
	IntBound getMinBound();
	@Override
	IntBound getMaxBound();
}
