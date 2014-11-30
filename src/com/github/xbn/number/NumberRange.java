package  com.github.xbn.number;
/**
   <p>bounded min-max range.</p>
 **/
public interface NumberRange<N extends Number>  {
   NumberBound<N> getMinBound();
   NumberBound<N> getMaxBound();
}
