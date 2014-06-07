
   import  java.util.regex.Pattern;
   import  java.util.regex.Matcher;


public class NotExclamationImportantLines  {
   public static final String LINE_SEP = System.getProperty("line.separator", "\r\n");

   public static final void main(String[] ignored)  {
      String input = new StringBuilder().
         append("myclass {"                 ).append(LINE_SEP).
         append("width: 400px;"             ).append(LINE_SEP).
         append("color: #333;"              ).append(LINE_SEP).
         append("margin: 20px !important;"  ).append(LINE_SEP).
         append("padding: 20px !important ;").append(LINE_SEP).
         append("top: 1px;"                 ).append(LINE_SEP).
         append("}"                         ).toString();

      //Split on the newline
      String[] lines = input.split(LINE_SEP);

      //Skip over the first and last elements, and only
      //print out those that don't contain the regular
      //expression `"important! ?"
      Matcher importantMtchr = Pattern.compile("!important ?;").matcher("");
      for(int i = 1; i < lines.length - 1; i++)  {
         String line = lines[i];
         if(!importantMtchr.reset(line).find())  {
            System.out.println(line);
         }
      }
   }
}
