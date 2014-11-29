package  com.github.xbn.number;

/**
	<p><code>NumberRange</code> for ints.</p>
 **/
public interface IntRange extends NumberRange<Integer>  {
	@Override
	IntBound getMinBound();
	@Override
	IntBound getMaxBound();
}
