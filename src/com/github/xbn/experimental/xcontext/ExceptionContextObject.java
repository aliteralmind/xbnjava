package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.lang.Copyable;

/**
   <P>Information related to the object that caused (or may cause) an error.</P>
 **/
public interface ExceptionContextObject extends Copyable  {
   /**
      <P>Descriptive name for the error-causing object.</P>

      @return  A non-{@code null}, non-empty string.
    **/
   String getName();
}
