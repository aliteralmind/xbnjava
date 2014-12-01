package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.lang.Copyable;
//	import  com.github.xbn.experimental.xcontext.XContextable;
/**
   <p>Information related to a potential error.</p>
 **/
public interface ExceptionContext extends Copyable  {
   /**
      <p>Update the extra-information.</p>

    * @param  info  If {@code null}, there is no extra information. Get with {@link #getExtraInfo() getExtraInfo}{@code ()}.
    */
   void setExtraInfo(Object info);
   /**
      <p>Extra information to append to the error message.</p>

    * @return  Is there extra information?<ul>
         <li>No: {@code &quot;&quot;}</li>
         <li>Yes: A non-{@code null}, non-empty string.</li>
      </ul>
    */
   String getExtraInfo();
   /**
      <p>Get a copy of this {@code ExceptionContext} in which all fields are duplicated, except {@code getExtraInfo()}, which is a reference to the original.</p>

    * @return  A non-{@code null} duplicate of this {@code ExceptionContext}.
    */
   @Override
   ExceptionContext getObjectCopy();
}
