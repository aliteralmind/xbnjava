package  com.github.xbn.examples.number.non_xbn;
  import  java.util.Iterator;
  import  java.util.TreeMap;
  import  java.util.Map;
  import  java.util.List;
  import  java.util.ArrayList;
/**
   <P>{@code java RandomNumberTest}</P>
 **/
public class RandomNumberTest  {
  private static final int tryCount = 1_000_000;
   public static final void main(String[] ignored)  {

     Map<Integer,Integer> randCountMap = new TreeMap<Integer,Integer>();
     for(int i = 0; i < tryCount; i++)  {
        int rand = getRandomBetweenInclusive(-10, 10);
        int value = ((!randCountMap.containsKey(rand)) ? 1
           :  randCountMap.get(rand) + 1);
        randCountMap.put(rand, value);
     }

     Iterator<Integer> allIntItr = randCountMap.keySet().iterator();

     List<NumWithCount> numWcountList = new ArrayList<NumWithCount>(randCountMap.size());

     while(allIntItr.hasNext())  {
        Integer I = allIntItr.next();
        int count = randCountMap.get(I);
        NumWithCount nwc = new NumWithCount(I, count);
        numWcountList.add(nwc);
     }

     Iterator<NumWithCount> intWCountItr = numWcountList.iterator();
     while(intWCountItr.hasNext())  {
        NumWithCount numWCount = intWCountItr.next();
        float pct = (float)numWCount.occurances  / tryCount * 100;
        System.out.println(numWCount.num + ": " + numWCount.occurances + "   " + String.format("%.3f", pct) + "%");
     }
   }
   public static final int getRandomBetweenInclusive(int min, int max)  {
      return  (int)(Math.random() * (max - min + 1)) + min;
   //Mine:
   //   return  (min + (int)(Math.random() * ((max - min) + 1)));
   }
}
class NumWithCount  {
   public final int num;
   public final int occurances;
   public NumWithCount(int num, int occurances)  {
      this.num = num;
      this.occurances = occurances;
   }
   public String toString()  {
      return  "num=" + num + ", occurances=" + occurances;
   }
}
