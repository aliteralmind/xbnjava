package  com.github.xbn.number;

/**
   <P>An {@code IntRange} for lengths, with an inclusive minimum and maximum.</P>
 **/
public interface LengthRange extends IntRange  {
   @Override
   IntBoundInclusive getMinBound();
   @Override
   IntBoundInclusive getMaxBound();
}
