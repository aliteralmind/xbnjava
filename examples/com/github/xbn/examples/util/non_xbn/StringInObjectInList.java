
import  java.util.List;
import  java.util.Arrays;

/**
   <P>{@code java StringInObjectInList}</P>
 **/
public class StringInObjectInList  {
   public static final void main(String[] ignored)  {
      ObjectWithStringField[] owStrArr = new ObjectWithStringField[]  {
         new ObjectWithStringField("abc"),
         new ObjectWithStringField("def"),
         new ObjectWithStringField("ghi")};

      //Yes this is a List instead of an ArrayList, but you can easily
      //change this to work with an ArrayList. I'll leave that to you  :)
      List<ObjectWithStringField> objWStrList = Arrays.asList(owStrArr);

      System.out.println("abc? " + doesStringInObjExistInList("abc", objWStrList));
      System.out.println("abcd? " + doesStringInObjExistInList("abcd", objWStrList));
   }
   private static final boolean doesStringInObjExistInList(String str_toFind, List<ObjectWithStringField> owStrList_toSearch)  {
      for(ObjectWithStringField owStr : owStrList_toSearch)  {
         if(owStr.getString().equals(str_toFind))  {
            return  true;
         }
      }
      return  false;
   }
}

class ObjectWithStringField  {
   private final String s;
   public ObjectWithStringField(String s)  {
      this.s = s;
   }
   public String getString()  {
      return  s;
   }
}
