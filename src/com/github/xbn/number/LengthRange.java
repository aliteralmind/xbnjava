package  com.github.xbn.number;

/**
	<P>An {@code IntRange} for lengths, with an inclusive minimum and a maximum that may be inclusive or exclusive.</P>
 **/
public interface LengthRange extends IntRange  {
	@Override
	IntBoundInclusive getMinBound();
	@Override
	IntBound getMaxBound();
}
