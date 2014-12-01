package  com.github.xbn.experimental.xcontext;
/**
   <p>{@code ExceptionContextObject} for objects that are also elements in an index-able container (such as an array or {@code java.util.Collection}).</p>
 **/
public interface ExceptionContextElement extends ExceptionContextObject  {
   /**
      <p>Descriptive name of the container in which the error-creating object exists.</p>

    * @return   <code><i>[{@link com.github.xbn.experimental.xcontext.ExceptionContextObject super}]</i>.{@link com.github.xbn.experimental.xcontext.ExceptionContextObject#getObjectName() getObjectName}()</code>

    * @see  #getIndex()
    */
   String getContainerName();
   /**
      <p>The index of the error-causing object, as it exists in the container.</p>

    * @return  {@code index}, as provided to {@link #setIndex(int) setIndex(i)}.
    * @see  #getContainerName()
    */
   int getIndex();
   /**
      <p>Update the error-causing object's element-index.</p>

    * @param  index  Must be zero or greater, and <i>should</i> be valid given the size of the {@link #getContainerName() container}. get with {@link #getIndex() getIndex}{@code ()}.
    */
   void setIndex(int index);
}
