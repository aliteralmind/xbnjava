package  com.github.xbn.number;

/**
	<p>{@code IntRange} for indexes, with an inclusive minimum and exclusive maximum.</p>
 **/
public interface IndexRange extends IntRange  {
	@Override
	IntBoundInclusive getMinBound();
	@Override
	IntBoundExclusive getMaxBound();
}
