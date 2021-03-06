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
package  com.github.xbn.neederneedable;
   import  com.github.xbn.testdev.CompositionConstructor;
   import  com.github.xbn.testdev.CompositionFunction;
   import  com.github.xbn.lang.CrashIfObject;
/**
   <p>For classes that need to implement {@code Chainable}, that cannot extend {@code SimpleChainable}.</p>

 * @see  Chainable
 * @see  SimpleChainable
 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class ChainableComposer  {//implements Chainable  {
   private Object cid = null;
   private static Object CID = null;
   private static final CIDForXMsg cID_FOR_XMSG = new CIDForXMsg();
//constructors...START
   /**
      <p>Create a new instance with no chain-id.</p>

      <p>This calls {@link #unsetChainID(boolean) unsetChainID}{@code (false)}</p>

    * @see  #ChainableComposer(boolean, ChainableComposer) this(b,cc)
    * @see  #ChainableComposer(Chainable) this(chbl)
    */
   @CompositionConstructor
   public ChainableComposer()  {
      unsetChainID(false);
   }
   /**
      <p>Create a new instance as a duplicate of another.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; {@link #setChainID_4prot(boolean, Object) setChainID_4prot}{@code (false, to_copy.getChainID())}</p>

      <p>This does nothing with the <a href="#getStaticChainID()">static id</a>, because &quot;duplicating&quot; it would just overwrite the existing value.</p>

    * @param  to_copy  May not be {@code null}.
    * @see  #ChainableComposer() this()
    */
   @CompositionConstructor
   protected ChainableComposer(boolean ignored, ChainableComposer to_copy)  {
      try  {
         setChainID_4prot(false, to_copy.getChainID());
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_copy, "to_copy", null, rx);
      }

      //Pointless. Static, if set is...already set...so don't set it, because you're just re-setting it. Get it?
      //setStaticChainID_4prot(to_copy.getStaticChainID());
   }
   /**
      <p>Create a new instance from a {@code Chainable}.</p>

      <p>This calls<ol>
         <li>{@link #unsetChainID(boolean) unsetChainID}{@code (false)}</li>
      </ol></p>

    * @param  to_copy  May not be {@code null}.
    * @see  #ChainableComposer() this()
    */
   @CompositionConstructor
   public ChainableComposer(Chainable to_copy)  {
      unsetChainID(false);
   }
//constructors...END
//setters...START
   /**
      <p>Set the chain-id to {@code null}.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; {@link #setChainID_4prot(boolean, Object) setChainID_4prot(do_unsetStatic, null)}</p>
    */
   @CompositionFunction
   public void unsetChainID(boolean do_unsetStatic)  {
      setChainID_4prot(do_unsetStatic, null);
   }
   /**
      <p>Set the chain-id. This must be implemented as {@code protected}, with the name &quot;{@code setChainID}&quot;.</p>

    * @param  id  The chain-id.

    * @see  #unsetChainID(boolean) unsetChainID()
    */
   @CompositionFunction
   public void setChainID_4prot(boolean do_setStatic, Object id)  {
      cid = id;
      if(do_setStatic)  {
         CID = id;
      }
   }
//setters...END
//getters...START
   /**
    * @see  #setChainID_4prot(boolean, Object)
    */
   @CompositionFunction
   public Object getChainID()  {
      return  cid;
   }
   @CompositionFunction
   public Object getStaticChainID()  {
      return  CID;
   }
//getters...END
//main functionality...START
//main functionality...END
//other...START
   /**
    */
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      return  to_appendTo.append("getChainID()=[").append(getChainID()).append(", getStaticChainID()=").
         append((getChainID() == getStaticChainID())
            ?  "[same object as getChainID()"
            :  getStaticChainID()).append("]");
   }
//other...END
//static...START
   /**
      <p>Get a simple object containing the chain-id, for the purpose of appending it to error messages, as the {@code xtra_errInfo} parameter. For example:
      <br/> &nbsp; &nbsp; <code>throw  new RuntimeException({@link com.github.xbn.lang.CrashIfBase CrashIfBase.}{@link com.github.xbn.lang.CrashIfBase#getXMsg(String, Object) getXMsg}(&quot;Don't do that please&quot;, ChainableComposer.getChainIDForXMsgCINull(<i>[a-Chainable]</i>), null, rtxCause));</code>
      <br/>The returned object's {@code toString()} prints
      <br/> &nbsp; &nbsp; {@code &quot;getChainID()=[" + <i>[the-chain-id]</i> + "]&quot;}
      <br/>When used in a {@code catch} block, the {@code toString()} will not execute unless an exception is caught.</p>

      <p><i><b>See:</b></i><ul>
      </ul></p>

    * @return  The same object is returned for each call. Its internal chain-id is updated.
    */
   public static final Object getChainIDForXMsgCINull(Chainable chainable, Object xtra_errInfo)  {
      try  {
         return  cID_FOR_XMSG.chainIDXtraInfo(chainable.getChainID(), xtra_errInfo);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(chainable, "chainable", null, rx);
      }
   }
   public static final Object getSttaticChainID()  {
      return  CID;
   }
//static...END
}
class CIDForXMsg  {
   private Object oCid = null;
   private Object oXI = null;
   public CIDForXMsg()  {
   }
   public CIDForXMsg chainIDXtraInfo(Object id, Object xtra_errInfo)  {
      oCid = id;
      oXI = xtra_errInfo;
      return  this;
   }
   public String toString()  {
      StringBuilder sd = (new StringBuilder("getChainID()=[")).append(oCid).
         append("], getStaticChainID()=[").append((oCid == ChainableComposer.getSttaticChainID())
            ?  "static and non-static ids same object"
            :  ChainableComposer.getSttaticChainID()).
         append("]");
      if(oXI != null)  {
         sd.append("], extra-info=[").append(oXI);
      }
      return  sd.append("]").toString();
   }
}
