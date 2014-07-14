package  com.github.xbn.list.lister;
   import  com.github.xbn.list.lister.z.LLCIndexableElement_Fieldable;
   import  com.github.xbn.analyze.validate.ValueValidator;
/**
   <P>{@code LLCfgElement} for elements that are themselves indexable-containers (such as strings, lists, or arrays).</P>

   <A NAME="cfg"></A><H3>Builder Configuration: {@link com.github.xbn.list.lister.z.LLCIndexableElement_Cfg LLCIndexableElement_Cfg}</H3>

   <P><UL>
      <LI><B>Parent:</B> {@code <A HREF="ListLister.html#cfg">ListLister</A>}</LI>
   </UL></P>
 **/
public class LLCIndexableElement<E> extends LLCfgElement<E>  {
   private final ValueValidator<Integer> vv4LLen;
   private final String sIfLLen;
//constructors...START
   public LLCIndexableElement(LLCIndexableElement_Fieldable<E> fieldable)  {
      super(fieldable);
      LLCfgForLengthItems.crashIfBad(fieldable.getVVForElementLength(), fieldable.getIfElementLength(), "fieldable.getVVForElementLength()", "fieldable.getIfElementLength()");
      vv4LLen = fieldable.getVVForElementLength();
      sIfLLen = fieldable.getIfElementLength();
   }
   public LLCIndexableElement(LLCIndexableElement<E> to_copy)  {
      super(to_copy);
      vv4LLen = to_copy.getVVForElementLength();
      sIfLLen = to_copy.getIfElementLength();
   }
//constructors...END
//getters...START
   public ValueValidator<Integer> getVVForElementLength()  {
      return  vv4LLen;
   }
   public String getIfElementLength()  {
      return  sIfLLen;
   }
//getters...END
//other...START
   public String toString()  {
      return  appendToString(new StringBuilder()).toString();
   }
   public StringBuilder appendToString(StringBuilder to_appendTo)  {
      super.appendToString(to_appendTo);
      LLCfgForLengthItems.appendToTS(to_appendTo, getVVForElementLength(), getIfElementLength());
      return  to_appendTo;
   }
//other...END
//static...END
}
