package  com.github.xbn.experimental.xcontext;
/**
   <P>{@code ExceptionContextObject} for objects that are also elements in an index-able container (such as an array or {@code java.util.Collection}).</P>
 **/
public interface ExceptionContextElement extends ExceptionContextObject  {
   /**
      <P>Descriptive name of the container in which the error-creating object exists.</P>

      @return   <CODE><I>[{@link com.github.xbn.experimental.xcontext.ExceptionContextObject super}]</I>.{@link com.github.xbn.experimental.xcontext.ExceptionContextObject#getObjectName() getObjectName}()</CODE>

      @see  #getIndex()
    **/
   String getContainerName();
   /**
      <P>The index of the error-causing object, as it exists in the container.</P>

      @return  {@code index}, as provided to {@link #setIndex(int) setIndex(i)}.
      @see  #getContainerName()
    **/
   int getIndex();
   /**
      <P>Update the error-causing object's element-index.</P>

      @param  index  Must be zero or greater, and <I>should</I> be valid given the size of the {@link #getContainerName() container}. get with {@link #getIndex() getIndex}{@code ()}.
    **/
   void setIndex(int index);
}
