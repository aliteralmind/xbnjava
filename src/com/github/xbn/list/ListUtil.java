/*license*\
   XBN-Java Library

   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.list;
   import  com.github.xbn.analyze.validate.ValueValidator;
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.z.XbnIndexOutOfBoundsException_Cfg;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.number.CrashIfIntIs;
   import  com.github.xbn.util.copyval.ValueCopier;
   import  com.github.xbn.util.itr.AbstractElementTSLengthIterator;
   import  com.github.xbn.util.itr.AbstractIsValidElementIterator;
   import  java.util.ArrayList;
   import  java.util.Collection;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.Objects;
   import  org.apache.commons.lang3.StringUtils;
   import  static com.github.xbn.lang.CrashIfBase.*;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Translate lists to arrays and lists of primitives, objects, and strings, and other list-related utilities.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ListUtil  {
   /**
      <P>YYY</P>

      @exception  XbnIndexOutOfBoundsException  If any {@code list_ofUniqueAscIdxsToDelete} are invalid for {@code list}, or if its elements are not unique or ascending, causing subsequent indexes (that <I>were</I> valid) to not be valid.
    **/
   public static final void deleteElementsNotInAscUnqIndexList(List<?> list, List<Integer> list_ofUniqueAscIdxsToDelete)  {
      int iOrigSz = -1;
      int iLXSz = -1;
      try  {
         iOrigSz = list.size();
         iLXSz = list_ofUniqueAscIdxsToDelete.size();
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(list, "list");
         throw  CrashIfObject.nullOrReturnCause(list_ofUniqueAscIdxsToDelete, "list_ofUniqueAscIdxsToDelete", null, rx);
      }

      //Going backwards, so indexes in list_ofUniqueAscIdxsToDelete don't have to be decremented.
      for(int i = (list_ofUniqueAscIdxsToDelete.size() - 1); i >= 0; i--)  {
         int ix = list_ofUniqueAscIdxsToDelete.get(i);
         try  {
            list.remove(ix);
         }  catch(IndexOutOfBoundsException ibx)  {
            String sInfo = "Attempting list.remove(list_ofUniqueAscIdxsToDelete.get(" + i + "). list_ofUniqueAscIdxsToDelete.get(" + i + ")=[" + ix + "]. It is assumed-but-not-verified that list_ofUniqueAscIdxsToDelete contains only unique elements and is ordered ascending: [" + StringUtils.join(list_ofUniqueAscIdxsToDelete, ", ") + "]. Also note that list is as it exists after some deletions -- Its original size was " + iOrigSz + ".";
            throw  new XbnIndexOutOfBoundsException_Cfg().
               badIndex(ix, "list_ofUniqueAscIdxsToDelete.get(" + i + ")").absCollectionSize(list, "list").buildWithCauseInfo(ibx, sInfo);
         }
      }
   }
   /**
      <P>YYY</P>
    **/
   public static final <E> List<E> getEListCopyOrNull(Collection<E> coll, ValueCopier<E> copier, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      ArrayList<E> ve = new ArrayList<E>(coll.size());
      if(copier == null)  {
         for(E e : coll)  {
            ve.add(e);
         }
      }  else  {
         for(E e : coll)  {
            ve.add(copier.getValueCopy(e, "[element in coll]"));
         }
      }
      return  ve;
   }
   /**
      <P>YYY</P>
    **/
   public static final <E> List<Object> getObjectListOrNull(Collection<E> coll, ValueCopier<E> copier, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      ArrayList<Object> vo = new ArrayList<Object>(coll.size());
      if(copier == null)  {
         for(Object o : coll)  {
            vo.add(o);
         }
      }  else  {
         for(E e : coll)  {
            vo.add(copier.getValueCopy(e, "[element in coll]"));
         }
      }
      return  vo;
   }
   /**
      <P>YYY</P>
    **/
   public static final <E> List<String> getStringListOrNull(Collection<E> coll, ValueCopier<E> copier, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      ArrayList<String> ve = new ArrayList<String>(coll.size());
      if(copier == null)  {
         for(E e : coll)  {
            ve.add((e == null) ? null : e.toString());
         }
      }  else  {
         for(E e : coll)  {
            e = copier.getValueCopy(e, "[element in coll]");
            ve.add((e == null) ? null : e.toString());
         }
      }
      return  ve;
   }
   public static final <E> String[] getStringArrayOrNull(Collection<E> coll, ValueCopier<E> copier, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      String[] as = new String[coll.size()];
      Iterator<E> itr = coll.iterator();
      int i = 0;
      if(copier == null)  {
         while(itr.hasNext())  {
            E e = itr.next();
            as[i++] = ((e == null) ? null : e.toString());
         }
      }  else  {
         while(itr.hasNext())  {
            E e = copier.getValueCopy(itr.next(), "[element in coll]");
            as[i++] = ((e == null) ? null : e.toString());
         }
      }
      return  as;
   }
   public static final <E> Object[] getObjectArrayOrNull(Collection<E> coll, ValueCopier<E> copier, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      Object[] as = new Object[coll.size()];
      Iterator<E> itr = coll.iterator();
      int i = 0;
      if(copier == null)  {
         while(itr.hasNext())  {
            as[i++] = (Object)itr.next();
         }
      }  else  {
         while(itr.hasNext())  {
            as[i++] = (Object)copier.getValueCopy(itr.next(), "[element in coll]");
         }
      }
      return  as;
   }
   public static final <E> E[] getEArrayOrNull(Collection<E> coll, ValueCopier<E> copier, E[] elementAry_initdToCollSize, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      Iterator<E> itr = coll.iterator();
      int i = 0;
      try  {
         if(copier == null)  {
            while(itr.hasNext())  {
               elementAry_initdToCollSize[i++] = itr.next();
            }
         }  else  {
            while(itr.hasNext())  {
               elementAry_initdToCollSize[i++] = copier.getValueCopy(itr.next(), "[element in coll]");
            }
         }
      }  catch(RuntimeException rx)  {
         Objects.requireNonNull(elementAry_initdToCollSize, "elementAry_initdToCollSize");
         if(elementAry_initdToCollSize.length < coll.size())  {
            throw  new IllegalArgumentException("elementAry_initdToCollSize.length=" + elementAry_initdToCollSize.length + ", coll.size()=" + coll.size());
         }
      }
      return  elementAry_initdToCollSize;
   }
   /*
      <P>If the array or element is {@code null}, or the index is bad, crash--otherwise, <I>return</I> the causing error.</P>
   public static final RuntimeException ciListOrElementNullBadIndexOrReturnCause(List<? extends Object> list, String list_name, int index, String idx_name, RuntimeException cause)  {
      try  {
         if(list.get(index) == null)  {
            throw  new NullPointerException("Element " + index + " in " + list_name);
         }
      }  catch(RuntimeException rx)  {
         CrashIfIndex.badForLength(index, list.size(), idx_name, list_name);
         throw  CrashIfObject.nullOrReturnCause(list, list_name, null, rx);
      }
      return  regetRtxCrashIfNull(cause, "cause");
   }
   public static final RuntimeException ciListNullBadIndexOrReturnCause(List<? extends Object> list, String list_name, int index, String idx_name, RuntimeException cause)  {
      try  {
         CrashIfIndex.badForLength(index, list.size(), idx_name, list_name);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(list, list_name, null, rx);
      }

      return  new RuntimeException(getXMsg(idx_name + " (" + index + ") is invalid given " + list_name + ".size() is " + list.size() + ".", null), cause);
   }
    */
   /**
      <P>YYY</P>


    **/
   public static final String getJoinedWithDelimiter(List<?> list, char delimiter, int idx_start, int idx_endX)  {
      return  getJoinedWithDelimiter(list, String.valueOf(delimiter), idx_start, idx_endX);
   }
   /**
      <P>YYY</P>

      <P>The missing {@code join(...)} functions from {@link org.apache.commons.lang3.StringUtils}</P>
    **/
   public static final String getJoinedWithDelimiter(List<?> list, String to_appendToelim, int idx_start, int idx_endX)  {
      StringBuilder sd = new StringBuilder();
      int iEXMinus1 = (idx_endX - 1);
      for(int i = idx_start; i < idx_endX; i++)  {
         sd.append(list.get(i));
         if(i < iEXMinus1)  {
            sd.append(to_appendToelim);
         }
      }
      return  sd.toString();
   }
   public static final <E> ArrayList<E> newNulledArrayListOfSize(int size)  {
      ArrayList<E> al = null;
      try  {
         al = new ArrayList<E>(size);
      }  catch(RuntimeException rx)  {
         throw  CrashIfIntIs.lessThanZeroOrReturnCause(size, "size", null, rx);
      }
      for(int i = 0; i < size; i++)  {
         al.add(null);
      }
      return  al;
   }
   public static final <E> Iterator<Integer> newIteratorForListOfArraysLengths(List<E[]> list)  {
      return  (new ListOfArraysLengthIterator<E>(list));
   }
   public static final <E> Iterator<Boolean> newIteratorForIsElementValid(List<E> list, ValueValidator<E> element_validator)  {
      return  (new IsValidListElementIterator<E>(list, element_validator));
   }
   private ListUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
}
class ListOfArraysLengthIterator<R> extends AbstractElementTSLengthIterator<R[]>  {
   public ListOfArraysLengthIterator(List<R[]> list)  {
      super(list);
   }
   @SuppressWarnings("unchecked")
   private List<R[]> getRawList()  {
      return  (List<R[]>)getContainer();
   }
   protected R[] getRawElementRTXOkay(int index)  {
      return  getRawList().get(index);
   }
   public int getTotalElementCount()  {
      return  getRawList().size();
   }
}
class IsValidListElementIterator<R> extends AbstractIsValidElementIterator<R> {
   public IsValidListElementIterator(List<R> list, ValueValidator<R> element_validator)  {
      super(list, element_validator);
   }
   @SuppressWarnings("unchecked")
   private List<R> getRawList()  {
      return  (List<R>)getContainer();
   }
   protected R getRawElementRTXOkay(int index)  {
      return  getRawList().get(index);
   }
   public int getTotalElementCount()  {
      return  getRawList().size();
   }
}
