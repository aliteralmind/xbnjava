package  com.github.xbn.number;
/**
	<P>bounded min-max range.</P>
 **/
public interface NumberRange<N extends Number>  {
	NumberBound<N> getMinBound();
	NumberBound<N> getMaxBound();
}
