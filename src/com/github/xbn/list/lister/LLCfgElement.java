package  com.github.xbn.list.lister;
	import  com.github.xbn.list.lister.z.LLCfgElement_Fieldable;
	import  com.github.xbn.text.StringUtil;
	import  com.github.xbn.analyze.alter.ValueAlterer;

/**
	<P>{@code ListLister} configuration relating to individual elements. See {@link com.github.xbn.list.lister.LLCfgOverall LLCfgOverall}.</P>

	<A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.list.lister.z.LLCfgElement_Cfg LLCfgElement_Cfg}</H3>

	<P><UL>
		<LI><B>Parent:</B> <CODE><A HREF="ListLister.html#cfg">ListLister</A></CODE></LI>
		<LI><B>{@link #sDISPLAY_IDX_MARKER}:</B> If output by any configuration, it is replaced with the element's index.</LI>
		<LI><B>Sub config:</B><UL>
			<LI><B><CODE><A HREF="{@docRoot}/com/github/xbn/text/padchop/VzblPadChop.html#cfg">VzblPadChop</A></CODE>:</B> {@link com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#cfgVPCFinalOutput(int) cfgVPCFinalOutput}{@code (i)}, {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#cfgVPCFinalOutput() cfgVPCFinalOutput}{@code ()}</LI>
		</UL></LI>
		<LI><B>Alter the index:</B> {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#indexUnaltered() indexUnaltered}{@code ()}*, {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#alterIndex(ValueAlterer) alterIndex}{@code (av)}</LI>
		<LI></LI>
		<LI><B>Alter the value:</B> {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#valueUnaltered() valueUnaltered}{@code ()}*, {@link com.github.xbn.list.lister.z.LLCfgElement_CfgForNeeder#alterValue(ValueAlterer) alterValue}{@code (av)}</LI>
	</UL></P>
 **/
public class LLCfgElement<E> extends LLConfigBase<E>  {
	private final ValueAlterer<Integer,Integer> avIndex;
	private final ValueAlterer<E,E>       aValue;
	/**
		<P>The marker that, if found in a configuration item, is replaced with the element's index. See the {@link #LLCfgElement(LLCfgElement_Fieldable) default constructor}.</P>

	<P>If the output of any configuration item (including  <CODE><I>[{@link com.github.xbn.list.lister.LLConfigBase LLConfigBase}]</I>{@link com.github.xbn.list.lister.LLConfigBase#getIfNull() getIfNull}()</CODE>) contains a {@link #sDISPLAY_IDX_MARKER}, it is replaced with the element's index. Only the first [left-most] marker in each item is recognized. See the {@link #LLCfgElement(LLCfgElement_Fieldable) default constructor}. This also includes the string-value of the element itself, if and only if it is altered.</P>

		<P>Equal to
		<BR> &nbsp; &nbsp; &quot;{@code ~index~}&quot;</P>
	 **/
	public static final String sDISPLAY_IDX_MARKER = "~index~";
	/**
		<P>Create a new {@code LLCfgElement} with defaults.</P>

		<P>If the output of any configuration item contains a {@link #sDISPLAY_IDX_MARKER}, it is replaced with the element's index. Only the first [left-most] marker in each item is recognized. See the {@link #LLCfgElement(LLCfgElement_Fieldable) default constructor}.</P>

		<H3>Short-circuit and precedence</H3>

		<P>All &quot;short-circuits&quot; configuration items, if used, causes all subsequent configuration items--including the prefix and postfix--to be ignored. The order of precedence is<OL>
			<LI>{@link com.github.xbn.list.lister.LLConfigBase#getIfNull() getIfNull}{@code ()}</LI>
			<LI>{@link com.github.xbn.list.lister.LLConfigBase#getIfNonNull() getIfNonNull}{@code ()}</LI>
			<LI>{@link com.github.xbn.list.lister.LLConfigBase#getPrefix() getPrefix}{@code ()} and {@link com.github.xbn.list.lister.LLConfigBase#getPostfix() getPostfix}{@code ()}</LI>
		</OL></P>

		<P>The index alterer ({@link #getAlterIndex() getAlterIndex}{@code ()}) is never ignored.</P>

		<HR ALIGN="center" WIDTH="25%"/>

		<P>This constructor is equal to
		<BR> &nbsp; &nbsp; {@link com.github.xbn.list.lister.LLConfigBase#LLConfigBase super}{@code ()}</P>
	 **/
	public LLCfgElement(LLCfgElement_Fieldable<E> fieldable)  {
		super(fieldable);
		avIndex = fieldable.getAlterIndex();
		aValue = fieldable.getAlterValue();
	}
	/**
		<P>Create a new {@code LLCfgElement} as a duplicate of another.</P>

		<P>This<OL>
			<LI>Calls {@link com.github.xbn.list.lister.LLConfigBase#LLConfigBase(LLConfigBase) super}{@code (to_copy)}</LI>
		</OL></P>

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
		<P>Set the index alterer--this is only useful when the index is displayed. ..........by placing {@link #sDISPLAY_IDX_MARKER} in (the output of) at least one of the configuration items.</P>

		<P>The <I>unaltererd</I> index is analyzed by the index-filter.</P>

		@param  av_i  If {@code null}, indexes are presented without change. Get with {@link #getAlterIndex() getAlterIndex}{@code ()}
		@see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
	 **/
//setters...END
//getters...START
	/**
		<P>Alters the index.</P>

		@return  YYY
		@see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
	 **/
	public ValueAlterer<Integer,Integer> getAlterIndex()  {
		return  avIndex;
	}
	/**
		<P>Alters the value.</P>

		@return  YYY
		@see  #LLCfgElement(LLCfgElement_Fieldable) this(llce_f)
	 **/
	public ValueAlterer<E,E> getAlterValue()  {
		return  aValue;
	}
//getters...END
//other...START
	/**
		@return  <CODE>(new {@link #LLCfgElement(LLCfgElement) LLCfgElement}&lt;E&gt;(this))</CODE>
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

