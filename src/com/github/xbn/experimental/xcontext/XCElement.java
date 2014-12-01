package  com.github.xbn.experimental.xcontext;
   import  com.github.xbn.text.CrashIfString;

/**
   <p>Implementation of {@code ExceptionContextElement}.</p>
 **/
public class XCElement extends XCObject implements ExceptionContextElement  {
   //state
      private int ix = -1;
//Constructors...START
   /**
      <p>Create a new {@code XCElement}.</p>

      <p>This calls<ol>
         <li>{@link com.github.xbn.experimental.xcontext.XCObject#XCObject(String) super}{@code (cntr_name)}</li>
         <li>{@link #setIndex(int) setIndex(index)}</li>
      </ol></p>

    * @see  #XCElement(ExceptionContextElement) this(xce)
    */
   public XCElement(String cntr_name, int index)  {
      super(cntr_name);
      setIndex(index);
   }
   /**
      <p>Create a new {@code XCElement} from an {@code ExceptionContextElement}.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.experimental.xcontext.XCObject#XCObject(ExceptionContextObject) super}{@code (to_copy)}</li>
         <li><code>{@link #setIndex(int) setIndex}(to_copy.{@link #getIndex() getIndex}())</code></li>
      </ol></p>
    * @see  #getObjectCopy()
    * @see  #XCElement(ExceptionContext, String, int) XCElement(xc,s,i)
    */
   public XCElement(ExceptionContextElement to_copy)  {
      super(to_copy);
      setIndex(to_copy.getIndex());
   }
//Constructors...END
//Setters...START
   /**
      <p>Set the just-called function in which the error happened (may happen).</p>

    * @param  index  May not be {@code null} or empty. Get with {@link #getIndex() getIndex}{@code ()}.
    */
   public void setIndex(int index)  {
      CrashIfString.nullEmpty(index, "index", null);
      ix = index;
   }
//Setters...END
//Getters...START
   public String getContainerName()  {
      return  getName();
   }
   /**
    * @return  {@code index}, as provided to {@link #setIndex(int) setIndex(i)}, the {@link #XCElement(ExceptionContext, String, int) constructor}, or the {@link #XCElement(XCElement) copy-constructor}.
    */
   public int getIndex()  {
      return  ix;
   }
//Getters...END
//Other...START
   /**
    * <p>Get a duplicate of this object.</p>
    * @return  <code>(new {@link #XCElement(XCElement) XCElement}(this)</code>
    */
   public XCElement getObjectCopy()  {
      return  (new XCElement(this));
   }
   public String toString()  {
      return  super.toString() + ", getIndex()=" + getIndex();
   }
   /**
    * @return  {@code true} If {@code to_compareTo} is non-{@code null}, aYYY {@code XCElement}, and {@link #areFieldsEqual(XCElement) areFieldsEqual}{@code ((XCElement)to_compareTo)} is {@code true}.
    */
   @Override public boolean equals(Object to_compareTo)  {
      if(to_compareTo == null)  {
         throw  new NullPointerException("to_compareTo");
      }
      if(this == to_compareTo)  {
         return  true;
      }
      if(!(to_compareTo instanceof XCElement))  {
         return  false;
      }

      XCElement xce = (XCElement)to_compareTo;

      return  areFieldsEqual(xce);
   }
   /**
      <p>Are all internal values in the provided {@code XCElement} the same as in <i>{@code this}</i>?.</p>

    * @return  <code>({@link com.github.xbn.experimental.xcontext.XCObject super}.{@link com.github.xbn.experimental.xcontext.XCObject#areFieldsEqual(XCObject) areFieldsEqual}(SUPER_CLASS_ABBREVIATION) &nbsp;&amp;&amp; &nbsp; {@link #getIndex() getIndex}() == xc_e.getIndex())</code>
    */
   public boolean areFieldsEqual(XCElement xc_e)  {
      return  (super.areFieldsEqual(xc_e)  &&  getIndex() == xc_e.getIndex());
   }
//Other...END
}

