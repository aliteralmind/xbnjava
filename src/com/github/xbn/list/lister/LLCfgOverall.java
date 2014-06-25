package  com.github.xbn.list.lister;
   import  com.github.xbn.list.lister.z.LLCfgOverall_Fieldable;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.text.padchop.VzblPadChop;
   import  java.util.List;
/**
   <P>{@code ListLister} configuration relating to the list as a whole--not its elements. Elements are configured by {@link com.github.xbn.list.lister.LLCfgElement LLCfgElement}.</P>

   <A NAME="cfg"><A/><H3>Builder Configuration: {@link com.github.xbn.list.lister.z.LLCfgOverall_Cfg LLCfgOverall_Cfg}</H3>

   <P><UL>
      <LI><B>Parent:</B> {@code <A HREF="ListLister.html#cfg">ListLister</A>}</LI>
      <LI><B>{@link com.github.xbn.list.lister.LLCfgForLengthItems#sDISPLAY_SIZE_MARKER}:</B> If output by any configuration, it is replaced with the list's size.</LI>
      <LI><B>Sub configs:</B><UL>
         <LI><B>{@code <A HREF="../../text/padchop/VzblPadChop.html#cfg">VzblPadChop</A>}:</B> {@link com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#cfgVPCFinalOutput() cfgVPCFinalOutput}{@code ()}, {@link com.github.xbn.list.lister.z.LLConfigBase_CfgForNeeder#cfgVPCFinalOutput(int) cfgVPCFinalOutput}{@code (i)}</LI>
      </UL></LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#noAltForElementLength() noAltForElementLength}{@code ()}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifElementLength(ValueValidator, String) ifElementLength}{@code (vv,s)}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifNoElements(String) ifNoElements}{@code (s)}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#finalOutputUnaltered() finalOutputUnaltered}{@code ()}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#reset() reset}{@code ()}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifNull(String) ifNull}{@code (s)}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#ifNonNull(String) ifNonNull}{@code (s)}</LI>
      <LI>{@link com.github.xbn.list.lister.z.LLCfgOverall_CfgForNeeder#prePost(String, String) prePost}{@code (s,s)}</LI>
   </UL></P>

   @param  E  The type of element in the {@code List}.
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
