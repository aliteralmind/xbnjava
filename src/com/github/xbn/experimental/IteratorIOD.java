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
package  com.github.xbn.experimental;
   import  com.github.xbn.list.ListUtil;
   import  java.util.Iterator;
   import  java.util.ArrayList;
      import  java.util.NoSuchElementException;
/**
   <P>Iterator tailored for {@code IterationOdometer}, with additional debugging functions. Returns a ArrayList of type T, containing as many elements, equal to the amount of times {@link IterationOdometer}{@code .add*()} was called.</P>

   <P>The function {@link #nextString() nextAsStr}{@code ()} is useful for diagnostics and testing. It joins the {@code toString()} of all ArrayList elements together, into a single string. It is used by all the {@code IterationOdometer.test_get1stIdxIfNot*()} functions.</P>

   <P>The {@code hasNext()} function in this class was one of the more challenging programming exercises I've encountered.</P>
 **/
public class IteratorIOD<T> implements Iterator<ArrayList<T>>  {
//	private int iodColCount = -1;
   private ArrayList<Iterable<T>> vitrblt = null;
   private ArrayList<Iterator<T>> vitrt = null;
   private int ixLastColumn = -1;
   ArrayList<T> vtNext = null;
   ArrayList<T> vtWrkg = null;


   private int ixRLIRb = 0;
   @SuppressWarnings("unchecked")
   public IteratorIOD(ArrayList<Iterable<T>> itrbl_arrayList)  {
      vitrblt = itrbl_arrayList;
      vtWrkg = (ArrayList<T>)ListUtil.newNulledArrayListOfSize(vitrblt.size());
      ixLastColumn = (vitrblt.size() - 1);

      vitrt = new ArrayList<Iterator<T>>(itrbl_arrayList.size());
      for(int i = 0; i < vitrblt.size(); i++)  {
         vitrt.add(vitrblt.get(i).iterator());
      }

      hasNext();
   }
   @SuppressWarnings("unchecked")
   public final boolean hasNext()  {
      if(vtNext != null)  {
         return  true;
      }
      if(ixRLIRb == 0  &&  !vitrt.get(0).hasNext())  {
         //For example:  9 9 9 9
         //             ^
         return  false;
      }
      for(int i = 0; i < vitrt.size(); i++)  {
         assert (ixRLIRb >= i) : "[io.a]";

         Iterator<T> itrt1 = vitrt.get(i);
         T tWrkg = vtWrkg.get(i);

         if(i < ixRLIRb)  {
            //Recycle this column's value.

            //i is to the left of the recycle-to-the-left/
            //iterate-to-the-right boundary (ixRLIRb)

            assert (tWrkg != null) : "[io.b]";
            //&&  tWrkg == itrt1.getMostRecentRetrieved()    ?????

            //Do nothing. It's in the working vector, and
            //ready to go for when next() is called.

            continue;
         }

         //i is to the right or (or equal to) the recycle-left/
         //iterate-right boundary. Must get the next item in this
         //column.

         assert (tWrkg == null  &&  itrt1.hasNext()) : "[io.c]";

         vtWrkg.set(i, itrt1.next());

         if(i == ixLastColumn)  {
            assert(ixRLIRb == ixLastColumn) : "[io.d]";

            //Must start at last/right-most Iterable, and
            //
            //-1- hasNext()  ?
            //  -a- Reset the iterator
            //  -b- break;
            //-2- Decrement the ixRLIRb, to point to the previous
            //    column
            //-3- Repeat until either a column's hasNext() is true, or
            //    every column has no next.

            //    Example 1        Example 2

            //-1-  0 0 0 9          9 9 9 9
            //          ^                ^
            //-2-  0 0 0 0          9 9 9 9
            //        ^                ^
            //                      9 9 9 9
            //                       ^
            //                      9 9 9 9
            //                     ^

            //    Next call to        Done.
            //    next() will
            //    cause the
            //    2nd-from-r
            //    to inc to 1,
            //    resulting in,
            //    ultimately:

            //    0 0 1 0
            //        ^


            //The overall IterationOdometer, however, always goes
            //back to index zero. Hence, i=0 in the for loop
            //above.


            int j = (ixLastColumn + 1);  //One extra...
            while(j > 0)  {
               j--;                        //To decrement first.

               if(vitrt.get(j).hasNext())  {
                   //Done resetting.      5 3 0 8    or      0 0 7 0
                   //                          ^                 ^
                   //                                         Was 0079
                   //                                      About to be 0080

                   break;
               }

               if(j > 0)  {
                  vitrt.set(j, vitrblt.get(j).iterator());
                  ixRLIRb--;
               }
               //Reset the column iterator
            }

            //Note, there IS at least one more item to get. Otherwise,
            //The second line in this function would have prevented
            //this point from being reached.

         }  else  {
            //This is not last column.
            if(i == ixRLIRb)  {
                //ixRLIRb must be equal to or greater than i. Must
                //increment this before the next iteration of this
                //for-loop (where i is incremented).
                ixRLIRb++;
            }
            //May be (about to do) last column.
         }
      }

      vtNext = vtWrkg;
      vtWrkg = (ArrayList<T>)ListUtil.newNulledArrayListOfSize(vitrblt.size());

      //Recycle!
      for(int i = 0; i < ixRLIRb; i++)  {
         vtWrkg.set(i, vtNext.get(i));
      }

      return  true;

   }
   public final ArrayList<T> next()  {
      if(vtNext == null)  {
         throw  new NoSuchElementException("next");
      }

      ArrayList<T> vt = vtNext;
      vtNext = null;
      hasNext();

      return  vt;
   }

   /**
      <P>Joins the {@code toString()} value for all columns into a single string. Use for testing.</P>
    **/
   public final String getNextAsStr(ArrayList<T> v_t)  {
      if(v_t == null)  {
         return  null;
      }
      StringBuilder sb = new StringBuilder();
      for(T t : v_t)  {
         sb.append(t);
      }
      return  sb.toString();
   }
   public final String nextString()  {
      return  getNextAsStr(next());
   }


   public final void remove()  {
      throw  new UnsupportedOperationException("remove");
   }
}
