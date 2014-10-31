package  com.github.xbn.test.number;
   import  com.github.xbn.number.NumberUtil;
   import  org.junit.Test;
   import  static org.junit.Assert.*;

/**
 * java com.github.xbn.test.number.NumberUtil_Unit
 */
public class NumberUtil_Unit  {
   public static final void main(String[] as_clp)  {
      NumberUtil_Unit unit = new NumberUtil_Unit();
      unit.test_primes();
      unit.test_notPrimes();
   }
   @Test
   public void test_primes()  {
      assertTrue(NumberUtil.isPrime(1));
      assertTrue(NumberUtil.isPrime(2));
      assertTrue(NumberUtil.isPrime(3));
      assertTrue(NumberUtil.isPrime(5));
      assertTrue(NumberUtil.isPrime(7));
      assertTrue(NumberUtil.isPrime(11));
      assertTrue(NumberUtil.isPrime(13));
      assertTrue(NumberUtil.isPrime(17));
      assertTrue(NumberUtil.isPrime(19));
      assertTrue(NumberUtil.isPrime(23));
      assertTrue(NumberUtil.isPrime(29));
      assertTrue(NumberUtil.isPrime(31));
      assertTrue(NumberUtil.isPrime(1559));
      assertTrue(NumberUtil.isPrime(2837));
      assertTrue(NumberUtil.isPrime(3001));
      assertTrue(NumberUtil.isPrime(4793));
      assertTrue(NumberUtil.isPrime(6857));
      assertTrue(NumberUtil.isPrime(7877));
      assertTrue(NumberUtil.isPrime(7919));
   }
   public void test_notPrimes()  {
      assertTrue(NumberUtil.isPrime(4));
      assertTrue(NumberUtil.isPrime(10));
      assertTrue(NumberUtil.isPrime(125));
   }
}
