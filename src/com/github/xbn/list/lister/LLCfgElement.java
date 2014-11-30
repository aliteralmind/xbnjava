package  com.github.xbn.list.lister;
   import  com.github.xbn.list.lister.z.LLCfgElement_Fieldable;
   import  com.github.xbn.text.StringUtil;
   import  com.github.xbn.analyze.alter.ValueAlterer;

/**
   <p>{@code ListLister} configuration relating to individual elements. See {@link com.github.xbn.list.lister.LLCfgOverall LLCfgOverall}.</p>

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.list.lister.z.LLCfgElement_Cfg LLCfgElement_Cfg}</h3>

   <p><ul>
      <li><b>Parent:</b> <code><a href="ListLister.html#cfg">ListLister</a></code></li>
      <li><b>{@link #sDISPLAY_IDX_MARKER}:</b> If output by any configuration, it is replaced with the element's index.</li>
      <li><b>Sub config:</b><ul>
         <li><b><code><a href="{@docRoot}/com/github/xbn/text/padchop/VzblPadChop.html#cfg">VzblPadChop</a></code>:</b> {@link com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#cfgVPCFinalOutput(int) cfgVPCFinalOutput}{@code (i)}, {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#cfgVPCFinalOutput() cfgVPCFinalOutput}{@code ()}</li>
      </ul></li>
      <li><b>Alter the index:</b> {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#indexUnaltered() indexUnaltered}{@code ()}*, {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#alterIndex(ValueAlterer) alterIndex}{@code (av)}</li>
      <li></li>
      <li><b>Alter the value:</b> {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#valueUnaltered() valueUnaltered}{@code ()}*, {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#alterValue(ValueAlterer) alterValue}{@code (av)}</li>
   </ul></p>
 **/
public class LLCfgElement<E> extends LLConfigBase<E>  {
   private final ValueAlterer<Integer,Integer> avIndex;
   private final ValueAlterer<E,E>       aValue;
   /**
      <p>The marker that, if found in a configuration item, is replaced with the element's index. See the {@link #LLCfgElement(LLCfgElement_Fieldable) default constructor}.</p>

   <p>If the output of any configuration item (including  <code><i>[{@link com.github.xbn.list.lister.LLConfigBase LLConfigBase}]</i>{@link com.github.xbn.list.lister.LLConfigBase#getIfNull() getIfNull}()</code>) contains a {@link #sDISPLAY_IDX_MARKER}, it is replaced with the element's index. Only the first [left-most] marker in each item is recognized. See the {@link #LLCfgElement(LLCfgElement_Fieldable) default constructor}. This also includes the string-value of the element itself, if and only if it is altered.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; &quot;{@code ~index~}&quot;</p>
    **/
   public static final String sDISPLAY_IDX_MARKER = "~index~";
   /**
      <p>Create a new {@code LLCfgElement} with defaults.</p>

      <p>If the output of any configuration item contains a {@link #sDISPLAY_IDX_MARKER}, it is replaced with the element's index. Only the first [left-most] marker in each item is recognized. See the {@link #LLCfgElement(LLCfgElement_Fieldable) default constructor}.</p>

      <h3>Short-circuit and precedence</h3>

      <p>All &quot;short-circuits&quot; configuration items, if used, causes all subsequent configuration items--including the prefix and postfix--to be ignored. The order of precedence is<ol>
         <li>{@link com.github.xbn.list.lister.LLConfigBase#getIfNull() getIfNull}{@code ()}</li>
         <li>{@link com.github.xbn.list.lister.LLConfigBase#getIfNonNull() getIfNonNull}{@code ()}</li>
         <li>{@link com.github.xbn.list.lister.LLConfigBase#getPrefix() getPrefix}{@code ()} and {@link com.github.xbn.list.lister.LLConfigBase#getPostfix() getPostfix}{@code ()}</li>
      </ol></p>

      <p>The index alterer ({@link #getAlterIndex() getAlterIndex}{@code ()}) is never ignored.</p>

      <HR ALIGN="center" WIDTH="25%"/>

      <p>This constructor is equal to
      <br/> &nbsp; &nbsp; {@link com.github.xbn.list.lister.LLConfigBase#LLConfigBase super}{@code ()}</p>
    **/
   public LLCfgElement(LLCfgElement_Fieldable<E> fieldable)  {
      super(fieldable);
      avIndex = fieldable.getAlterIndex();
      aValue = fieldable.getAlterValue();
   }
   /**
      <p>Create a new {@code LLCfgElement} as a duplicate of another.</p>

      <p>This<ol>
         <li>Calls {@link com.github.xbn.list.lister.LLConfigBase#LLConfigBase(LLConfigBase) super}{@code (to_copy)}</li>
      </ol></p>

      @param  to_copy  May not be {@code null}.
      @see  #getObjectCopy()
      @see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
    **/
   public LLCfgElement(LLCfgElement<E> to_copy)  {
      super(to_copy);
      avIndex = to_copy.getAlterIndex();
      aValue = to_copy.getAlterValue();
   }
//setters...START
   /**
      <p>Set the index alterer--this is only useful when the index is displayed. ..........by placing {@link #sDISPLAY_IDX_MARKER} in (the output of) at least one of the configuration items.</p>

      <p>The <i>unaltererd</i> index is analyzed by the index-filter.</p>

      @param  av_i  If {@code null}, indexes are presented without change. Get with {@link #getAlterIndex() getAlterIndex}{@code ()}
      @see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
    **/
//setters...END
//getters...START
   /**
      <p>Alters the index.</p>

      @return  YYY
      @see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
    **/
   public ValueAlterer<Integer,Integer> getAlterIndex()  {
      return  avIndex;
   }
   /**
      <p>Alters the value.</p>

      @return  YYY
      @see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
    **/
   public ValueAlterer<E,E> getAlterValue()  {
      return  aValue;
   }
//getters...END
//other...START
   /**
    * <p>Get a duplicate of this object.</p>

      @return  <code>(new {@link #LLCfgElement(LLCfgElement) LLCfgElement}&lt;E&gt;(this))</code>
    **/
   public LLCfgElement<E> getObjectCopy()  {
      return  (new LLCfgElement<E>(this));
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo);
      StringUtil.appendPreTruePostOrFalse(to_appendTo,
         ", getAlterIndex()=[", getAlterIndex(), "]",
         (!getAlterIndex().isExpired()), null);
      StringUtil.appendPreTruePostOrFalse(to_appendTo,
         ", getAlterValue()=[", getAlterValue(), "]",
         (!getAlterValue().isExpired()), null);
      return  to_appendTo;
   }
//other...END
}

