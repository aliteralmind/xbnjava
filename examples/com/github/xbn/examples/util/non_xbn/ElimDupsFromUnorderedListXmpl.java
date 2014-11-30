package  com.github.xbn.examples.util.non_xbn;
   import  java.util.Arrays;
   import  java.util.ArrayList;

/**
   <p>{@code java ElimDupsFromUnorderedListXmpl}</p>
 **/
public class ElimDupsFromUnorderedListXmpl  {
   public static final void main(String[] ignored)  {
      int[] ai = new int[]{0, 0, 1, 4, 2, 3, 4};
      ArrayList<Integer> ali = new ArrayList<Integer>(ai.length);
      for(int i : ai)  {
         ali.add(i);
      }
      System.out.println(Arrays.toString(ali.toArray()) + "  (original)");

      //Delete dups
      for(int i = 0; i < ali.size(); i++)  {
         Integer I = ali.get(i);
         int iA = ali.indexOf(I);
         if(iA != -1)  {
            int iB = ali.lastIndexOf(I);
            if(iB != iA)  {
                ali.remove(iB);  //remove second
               System.out.println(Arrays.toString(ali.toArray()));
            }
         }
      }

      System.out.println(Arrays.toString(ali.toArray()) + "     (final)");
   }
}
