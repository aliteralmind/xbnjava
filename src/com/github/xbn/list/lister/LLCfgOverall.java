package  com.github.xbn.list.lister;
   import  com.github.xbn.list.lister.z.LLCfgOverall_Fieldable;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  java.util.List;
/**
   <p>{@code ListLister} configuration relating to the list as a whole--not its elements. Elements are configured by {@link com.github.xbn.list.lister.LLCfgElement LLCfgElement}.</p>

   <A NAME="cfg"></a><h3>Builder Configuration: {@link com.github.xbn.list.lister.z.LLCfgOverall_Cfg LLCfgOverall_Cfg}</h3>

   <p><ul>
      <li><b>Parent:</b> {@code <a href="ListLister.html#cfg">ListLister</a>}</li>
      <li><b>{@link com.github.xbn.list.lister.LLCfgForLengthItems#sDISPLAY_SIZE_MARKER}:</b> If output by any configuration, it is replaced with the list's size.</li>
      <li><b>Sub configs:</b><ul>
         <li><b>{@code <a href="../../text/padchop/VzblPadChop.html#cfg">VzblPadChop</a>}:</b> {@link com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#cfgVPCFinalOutput() cfgVPCFinalOutput}{@code ()}, {@link com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#cfgVPCFinalOutput(int) cfgVPCFinalOutput}{@code (i)}</li>
      </ul></li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#noAltForElementLength() noAltForElementLength}{@code ()}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifElementLength(ValueValidator, String) ifElementLength}{@code (vv,s)}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifNoElements(String) ifNoElements}{@code (s)}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#finalOutputUnaltered() finalOutputUnaltered}{@code ()}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#reset() reset}{@code ()}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifNull(String) ifNull}{@code (s)}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifNonNull(String) ifNonNull}{@code (s)}</li>
      <li>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#prePost(String, String) prePost}{@code (s,s)}</li>
   </ul></p>

 * @param  E  The type of element in the {@code List}.
 **/
public class LLCfgOverall<E> extends LLConfigBase<List<E>>  {
   private final ValueValidator<Integer> vv4LLen;
   private final String sIfLLen;
//constructor...START
   public LLCfgOverall(LLCfgOverall_Fieldable fieldable)  {
      super(fieldable);

      LLCfgForLengthItems.crashIfBad(fieldable.getVVForElementLength(), fieldable.getIfElementLength(), "fieldable.getVVForElementLength()", "fieldable.getIfElementLength()");

      vv4LLen = fieldable.getVVForElementLength();
      sIfLLen = fieldable.getIfElementLength();
   }
   public LLCfgOverall(LLCfgOverall<E> to_copy)  {
      super(to_copy);
      vv4LLen = to_copy.getVVForElementLength();
      sIfLLen = to_copy.getIfElementLength();
   }
//constructor...END
   public ValueValidator<Integer> getVVForElementLength()  {
      return  vv4LLen;
   }
   public String getIfElementLength()  {
      return  sIfLLen;
   }
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo);
      LLCfgForLengthItems.appendToTS(to_appendTo, getVVForElementLength(), getIfElementLength());
      return  to_appendTo;
   }
}
