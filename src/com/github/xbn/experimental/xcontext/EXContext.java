/*license*\
   XBN-Java: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.experimental.xcontext;

/**
   <p>Implementation of {@code ElementExceptionContext}.</p>
 **/
public class EXContext extends OXContext implements ElementExceptionContext  {
   /**
      <p>Create a new {@code EXContext}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #EXContext(String, String, int, String) this(cntr_name, index, null)}</p>
    **/
   public EXContext(String cntr_name, int index)  {
      this(cntr_name, index, null);
   }
   /**
      <p>Create a new {@code EXContext}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #EXContext(String, ExceptionContextElement) this}((new {@link com.github.xbn.experimental.xcontext.XCElement#XCElement(String, int) XCElement}(cntr_name, index)))</code></p>
    **/
   public EXContext(String cntr_name, int index, Object o_xtraInfo)  {
      this((new XCElement(cntr_name, index)), o_xtraInfo);
   }
   /**
      <p>Create a new {@code EXContext}.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; {@link #EXContext(String, String, int) this(xc_e, null)}</p>
    **/
   public EXContext(ExceptionContextElement xc_e)  {
      this(xc_e, null);
   }
   /**
      <p>Create a new {@code EXContext}.</p>

      <p>Calls
      <br/> &nbsp; &nbsp; {@link com.github.xbn.experimental.xcontext.OXContext#OXContext(String, ObjectExceptionContext, String) super}{@code (xc_e, o_xtraInfo)}</li>
      </ol></p>}

      @see  #EXContext(String, String, int) this(xc,s,s,i)
      @see  #EXContext(String, String, int, String) this(xc,s,s,i,s)
      @see  #EXContext(String, ExceptionContextElement) this(xc,s,xce)
      @see  #EXContext(ElementExceptionContext) this(exc)
    **/
   public EXContext(ExceptionContextElement xc_e, Object o_xtraInfo)  {
      super(xc_e, o_xtraInfo);
   }
   /**
      <p>Create a new {@code EXContext} from an {@code ElementExceptionContext}.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.experimental.xcontext.OXContext#OXContext(ObjectExceptionContext) super}{@code (to_copy)}</li>
         <li><code>{@link #setXCElement(ExceptionContextElement) setXCElement}(to_copy.{@link #getXCElement() getXCElement}())</code></li>
      </ol></p>
      @see  #EXContext(String, String, int, String, String) this(s,s,i,s,s)
    **/
   public EXContext(ElementExceptionContext to_copy)  {
      super(to_copy);
      setXCElement(to_copy.getXCElement());
   }
   /**
      <p>Set the error-causing object's container-name and element-index.</p>
    **/
   public void setContainerNameIndex(String cntr_name, int index)  {
      setXCElement(new XCElement(cntr_name, index));
   }
   public void setIndex(int index)  {
      getXCElement().setIndex(index);
   }
   /**
      <p>Set the error-causing object's metadata.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp;  <code><i>[{@link com.github.xbn.experimental.xcontext.OXContext super}]</i>.{@link com.github.xbn.experimental.xcontext.OXContext#setXCObject(ExceptionContextObject) setXCObject}(method_name)</code></p>
    **/
   public void setXCElement(ExceptionContextElement xc_e)  {
      setXCObject(xc_e);
   }
   public String getContainerName()  {
      return  getXCElement().getContainerName();
   }
   public int getIndex()  {
      return  getXCElement().getIndex();
   }
   /**
      @return   <code>(ExceptionContextElement)<i>[{@link com.github.xbn.experimental.xcontext.OXContext super}]</i>.{@link com.github.xbn.experimental.xcontext.OXContext#getXCObject() getXCObject}()</code>
    **/
   public ExceptionContextElement getXCElement()  {
      return  (ExceptionContextElement)getXCObject();
   }
}
