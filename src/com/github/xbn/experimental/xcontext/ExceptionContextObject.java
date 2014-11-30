package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.lang.Copyable;

/**
   <p>Information related to the object that caused (or may cause) an error.</p>
 **/
public interface ExceptionContextObject extends Copyable  {
   /**
      <p>Descriptive name for the error-causing object.</p>

      @return  A non-{@code null}, non-empty string.
    **/
   String getName();
}
