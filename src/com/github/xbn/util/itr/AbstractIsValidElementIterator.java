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
package  com.github.xbn.util.itr;
   import  com.github.xbn.util.itr.IteratorDirection;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.array.CrashIfIndex;
/**
   <p>For building iterators on indexable containers, that return booleans expressing the <i>validity</i> of each element.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public abstract class AbstractIsValidElementIterator<R> extends AbstractIndexableIterator<R,Boolean>  {
//state
   private ValueValidator<R> vve = null;
//constructors...START
   public AbstractIsValidElementIterator(Object indexable_cntrOfR, ValueValidator<R> element_vldtr)  {
      this(indexable_cntrOfR, element_vldtr, IteratorDirection.LOW_TO_HIGH);
   }
   public AbstractIsValidElementIterator(Object indexable_cntrOfR, ValueValidator<R> element_vldtr, IteratorDirection direction)  {
      this(indexable_cntrOfR, element_vldtr, 0, -1, direction);
   }
   public AbstractIsValidElementIterator(Object indexable_cntrOfR, ValueValidator<R> element_vldtr, int idx_start, int idx_endX)  {
      this(indexable_cntrOfR, element_vldtr, idx_start, idx_endX, IteratorDirection.LOW_TO_HIGH);
   }
   /**
      <p>Create a new {@code AbstractIsValidElementIterator}.</p>

      YYY

    * <p>Equal to
      <br> &nbsp; &nbsp; {@link com.github.xbn.util.itr.AbstractIndexableIterator#AbstractIndexableIterator(Object, int, int) super}{@code (indexable_cntrOfR, idx_start, idx_endX)}</p>
    */
   public AbstractIsValidElementIterator(Object indexable_cntrOfR, ValueValidator<R> element_vldtr, int idx_start, int idx_endX, IteratorDirection direction)  {
      super(indexable_cntrOfR, idx_start, idx_endX, direction);
      if(element_vldtr == null)  {
         throw  new NullPointerException("element_vldtr");
      }
      vve = element_vldtr;
   }
//constructors...END
   protected ValueValidator<R> getVVElement()  {
      return  vve;
   }
   public final Boolean next()  {
      Boolean Bv = false;
      try  {
         Bv = vve.isValid(getRawElementRTXOkay(getIndex()));
      }  catch(RuntimeException rx)  {
         CrashIfIndex.badForLength(getIndex(), getTotalElementCount(), "index", XBL_CNTR_OF_R_NAME);
         throw  rx;
      }
      moveIndexToNext();
      return  Bv;
   }
   protected abstract R getRawElementRTXOkay(int index);
   public abstract int getTotalElementCount();
/*stub functions for non-abstract compile...START
   protected R getRawElementRTXOkay(int index)  {
      return  null;
   }
   public int getTotalElementCount()  {
      return  -1;
   }
 stub functions for non-abstract compile...END*/
}
