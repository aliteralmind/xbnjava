package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.lang.Copyable;
//	import  com.github.xbn.experimental.xcontext.XContextable;
/**
   <P>Information related to a potential error.</P>
 **/
public interface ExceptionContext extends Copyable  {
   /**
      <P>Update the extra-information.</P>

      @param  info  If {@code null}, there is no extra information. Get with {@link #getExtraInfo() getExtraInfo}{@code ()}.
    **/
   void setExtraInfo(Object info);
   /**
      <P>Extra information to append to the error message.</P>

      @return  Is there extra information?<UL>
         <LI>No: {@code &quot;&quot;}</LI>
         <LI>Yes: A non-{@code null}, non-empty string.</LI>
      </UL>
    **/
   String getExtraInfo();
   /**
      <P>Get a copy of this {@code ExceptionContext} in which all fields are duplicated, except {@code getExtraInfo()}, which is a reference to the original.</P>

      @return  A copy of this {@code ExceptionContext} as specified above.
    **/
   @Override
   ExceptionContext getObjectCopy();
}
