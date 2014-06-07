
   import  java.util.ArrayList;

   /**
      <P>{@code java Test}</P>
    **/
   public class Test  {
      public static final void main(String[] ignored)  {

      }
      public static void quickSortInPlace(ArrayList<Integer> numbers, int left, int right) {
          if(left < right) {
              int index = generatePivot(numbers);
              index = partition(numbers, left, right, index);
              quickSortInPlace(numbers, left, index - 1);
              quickSortInPlace(numbers, index + 1, right);
          }
      }
      private static final int generatePivot(ArrayList<Integer> numbers)  {
         return  -1;
      }

      public static int partition(ArrayList<Integer> numbers, int left, int right, int index) {
          int pivot = numbers.get(index);
          int tmp = numbers.get(right);
          numbers.set(right, numbers.get(index));
          numbers.set(index, tmp);
          int newIndex = left;
          for(int i = left; i < right; i++) {
              if(numbers.get(i) <= pivot) {
                  tmp = numbers.get(i);
                  numbers.set(i, numbers.get(newIndex));
                  numbers.set(newIndex, tmp);
                  newIndex++;
              }
          }
          tmp = numbers.get(newIndex);
          numbers.set(newIndex, numbers.get(right));
          numbers.set(right, tmp);
          return newIndex;
}
   }
