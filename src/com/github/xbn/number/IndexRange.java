package  com.github.xbn.number;

/**
   <P>{@code IntRange} for indexes, with an inclusive minimum and exclusive maximum.</P>
 **/
public interface IndexRange extends IntRange  {
   @Override
   IntBoundInclusive getMinBound();
   @Override
   IntBoundExclusive getMaxBound();
}
