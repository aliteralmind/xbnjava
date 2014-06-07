
    import  java.util.TreeMap;

    /**
       <P>{@code java StringInObjectInMap}</P>
     **/
    public class StringInObjectInMap  {
       public static final void main(String[] ignored)  {
          TreeMap<String,ObjectWithStringField> objWStrMap = new TreeMap<String,ObjectWithStringField>();

          ObjectWithStringField[] owStrArr = new ObjectWithStringField[]  {
             new ObjectWithStringField("abc"),
             new ObjectWithStringField("def"),
             new ObjectWithStringField("ghi")};

          for(ObjectWithStringField owStr : owStrArr)  {
             objWStrMap.put(owStr.getString(), owStr);
          }

          System.out.println("abc? " + objWStrMap.containsKey("abc"));
          System.out.println("abcd? " + objWStrMap.containsKey("abcd"));

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
