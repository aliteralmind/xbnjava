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
   import  com.github.xbn.array.CrashIfIndex;
   import  static com.github.xbn.lang.XbnConstants.*;
   import  com.github.xbn.util.lock.AbstractOneWayLockable;
   import  java.util.Iterator;
   import  java.util.ArrayList;
   import  java.util.NoSuchElementException;
/**
   <P>Iterator for a <I>series</I> of iterators, treating each as if it were a column in an odometer--getting every possible combination. IterationOdometer properly deals with each column 'flipping' (from 9 back to 0), and incrementing the 'higher'-place column (its left neighbor) when the flip occurs.</P>

   <P><a href="http://www.whitegauges.net/pages/Odometer-Reset.html"><IMG SRC="doc-files/odometer.jpg" border="0"></a></P>

   <H3>Warning</H3>

   <P>This properly recycles column-values as necessary. Such as going from 1001 to 1002, the first three columns (the 1, 0, and 0) are all reused. <I><B>Therefore, you must avoid altering the column-objects that are returned by {@code next()}</B></I> (each of the items in the {@code ArrayList} as returned by {@code next()}). If a to-be-recycled object is altered, unpredictable things will happen. If a to-be-recycled object must be altered, then it needs to be cloned or otherwise duplicated before doing so.</P>
**/
public class IterationOdometer<T> extends AbstractOneWayLockable implements Iterable<ArrayList<T>>  {
   private boolean bLastColAdded = false;
   private ArrayList<Iterable<T>> vitrblt = new ArrayList<Iterable<T>>();
   /**
      <P>Create a new IterationOdometer. Does nothing.</P>
    **/
   public IterationOdometer()  {
   }

   /**
      <P>How many columns are in this IterationOdometer?.</P>

      @return  An <B>int</B> representing the number of times {@code addColumn(Iterable)} was called.
    **/
   public final int getColumnCount()  {
      return  vitrblt.size();
   }
   /**
      <P>Get an odometer-column.</P>

      @param  index  The column-index. Must be valid given {@link #getColumnCount() getColumnCount}{@code ()}.
    **/
   public final Iterable<T> getIterableColumn(int index)  {
      try  {
         return  vitrblt.get(index);
      }  catch(IndexOutOfBoundsException ibx)  {
         CrashIfIndex.badForLength(index, getColumnCount(), "index", "getColumnCount()");
         throw  ibx;
      }
   }

   /**
      <P>Add a column. This appends a new column to the right of existing columns. When adding the final (right-most) column, either use {@code addLastColumn()}, or call {@link #wasLastColumnAdded() wasLastColumnAdded}{@code ()}.</P>

      @exception LockException  If {@code addLastColumn()} or {@code wasLastColumnAdded()} was already called.
      @see  #addColumnsFrom(IterationOdometer, boolean) addColumnsFrom(iod,b)
    **/
   public final IterationOdometer<T> addColumn(Iterable<T> itrblt_column)  {
      ciLocked();

//System.out.println("itrblt_column=" + itrblt_column + "");
      if(itrblt_column == null)  {
         throw  new NullPointerException(" itrblt_column");
      }
      vitrblt.add((Iterable<T>)itrblt_column);
      return  this;
   }

   /**
      <P>Add the final (right-most) column. For all other columns, use {@code addColumn(itrbl)}</P>

      @exception LockException  If {@link #wasLastColumnAdded() wasLastColumnAdded}{@code ()} is true.
      @see  #addColumnsFrom(IterationOdometer, boolean) addColumnsFrom(iod,b)
    **/
   public final IterationOdometer<T> addLastColumn(Iterable<T> itrblt_column)  {
      addColumn(itrblt_column);
      lastColumnAdded();
      return  this;
   }

   /**
      <P>Add all columns existing in another IterationOdometer.</P>

      @return  {@code addColumnsFrom(itr_odometer, false)}
    **/
   public final IterationOdometer<T> addColumnsFrom(IterationOdometer itr_odometer)  {
      return  addColumnsFrom(itr_odometer, false);
   }

   /**
      <P>Add all columns existing in another IterationOdometer.</P>

      @param  itr_odometer  The columns to add. May not be null, and <CODE>itr_odometer.{@link #wasLastColumnAdded() wasLastColumnAdded}()</CODE> must be true.
      @param  does_containLastColumn  If true, then {@link #lastColumnAdded() lastColumnAdded}{@code ()} is called after the columns are added.
      @return  <B>{@code this}</B>
      @exception LockException  If {@code wasLastColumnAdded()} is true.
      @see  #addColumnsFrom(IterationOdometer) addColumnsFrom(iod)
      @see  #addColumn(Iterable)
    **/
   public final IterationOdometer<T> addColumnsFrom(IterationOdometer itr_odometer, boolean does_containLastColumn)  {
      ciLocked();



      try  {
         itr_odometer.ciNotLocked();
      }  catch(NullPointerException npx)  {
         throw  new NullPointerException("itr_odometer");
      }

      for(Iterable<T> itrbl : vitrblt)  {
         addColumn(itrbl);
      }

      if(does_containLastColumn)  {
         lastColumnAdded();
      }

      return  this;
   }

   /**
      <P>Get a new IteratorIOD, where each call to next returns a ArrayList of the elements as returned by each columns' iterator.</P>

      <P>See {@link #iteratorIOD() iteratorIOD}{@code ()}</P>
    **/
   public final Iterator<ArrayList<T>> iterator()  {
      ciNotLocked();
      return  (Iterator<ArrayList<T>>)(new IteratorIOD<T>(vitrblt));
   }
   /**
      <P>Get a new IteratorIOD, where each call to next returns a ArrayList of the elements as returned by each columns' iterator.</P>

      @return  <CODE>(IteratorIOD&lt;T&gt;){@link #iterator() iterator}()</CODE>
    **/
   public final IteratorIOD<T> iteratorIOD()  {
   	return  (IteratorIOD<T>)iterator();
   }

   public final boolean isLocked()  {
      return  wasLastColumnAdded();
   }
   public final boolean wasLastColumnAdded()  {
      return  bLastColAdded;
   }
   public final IterationOdometer lastColumnAdded()  {
  	   bLastColAdded = true;
      return  this;
   }
   public final void lock()  {
      if(!isLocked())  {
         lastColumnAdded();
         super.lock();
      }
   }

   /**
      <P>Testing/diagnostic function.</P>

      @return  <CODE>test_get1stIdxIfNotAtCurrPos({@link #iteratorIOD() iteratorIOD}(), 0, string_elements)</CODE>
    **/
   public final int test_get1stIdxIfNotAtStart(String... string_elements)  {
      return  test_get1stIdxIfNotAtCurrPos(iteratorIOD(), 0, string_elements);
   }
   /**
      <P>Testing/diagnostic function. Get the index number of the first element not found at the <I>current point</I> in this IterationOdometer (its iterator).</P>

      <P>Note that this function uses {@code IteratorIOD.nextString()}, which concatenates all the {@code toString()} values, of all the ArrayList elements returned by {@code IteratorIOD.next()}. See the example code at the top of this class for usage.</P>

      @param  iod_itr  An iterator as returned by {@link #iterator() iterator}{@code ()}. The next element retrieved is the point at which the first element in {@code string_elements} is expected to exist. May not be {@code null}.
      @param  idx_start  The index in {@code string_elements} at which to start analysis. This is needed by the {@code test_get1stIdxIfNotInMiddle()} function (It finds the first element, and then passes the iterator to this function...so in that case, this needs to tbe set to 1, so we don't try and <U>re</U>-find the first [0-th] element again).
      @return  <B>{@code -1}</B>  If all string elements in {@code string_elements} are the first elements in this IterationOdometer.
      <BR><B>{@code <I>the index</I>}</B> Of the first element not found.
    **/
   public final int test_get1stIdxIfNotAtCurrPos(IteratorIOD<T> iod_itr, int idx_start, String... string_elements)  {
      int i = idx_start;
      for(; i < string_elements.length; i++)  {
         try  {
            if(!iod_itr.hasNext())  {
               return  i;
            }
         }  catch(NullPointerException npx)  {
            throw  new NullPointerException("iod_itr");
         }

         String sNas = iod_itr.nextString();
         try  {

            if(!string_elements[i].equals(sNas))  {
               return  i;
            }
         }  catch(NullPointerException npx)  {
            throw  new NullPointerException("string_elements[" + i + ']');
         }
      }

      return  -1;
   }

   /**
      <P>Testing/diagnostic function.</P>

      @return  {@code test_get1stIdxIfNotInMiddle(0, string_elements)}
    **/
   public final int test_get1stIdxIfNotInMiddle(String... string_elements)  {
      return  test_get1stIdxIfNotInMiddle(0, string_elements);
   }
   /**
      <P>Testing/diagnostic function. Get the index of the first element in {@code string_elements} that is not found <I>anywhere</I> in this IterationOdometer (its iterator). Once the first item is found (at any point), all following strings in {@code string_elements} must be immediately following.</P>

      @param  elements_toBypassCount  If you're obviously testing far into the iterator, then you can bypass a certain number of elements, to save a bit of processing power.
      @return  <B>{@code -1}</B>  If all string elements in {@code string_elements} are found, sequentially, anywhere in this IterationOdometer.
      <BR><B>{@code <I>the index</I>}</B> Of the first element not found.
    **/
   public final int test_get1stIdxIfNotInMiddle(int elements_toBypassCount, String... string_elements)  {
      IteratorIOD<T> itrt = (IteratorIOD<T>)iteratorIOD();
      boolean bQ = false;
      int i = 0;
      while(itrt.hasNext())  {
         if(elements_toBypassCount > 0)  {
            itrt.next();
            elements_toBypassCount--;
            continue;
         }
         String s = itrt.nextString();
         try  {
            bQ = string_elements[i].equals(s);
         }  catch(NullPointerException npx)  {
            throw  new NullPointerException("string_elements[" + i + ']');
         }
         if(bQ)  {
            return  test_get1stIdxIfNotAtCurrPos(itrt, 1, string_elements);
         }
      }

      return  0;
   }

   /**
      <P>Testing/diagnostic function.</P>

      @return  {@code test_get1stIdxIfNotAtEnd(0, string_elements)}
    **/
   public final int test_get1stIdxIfNotAtEnd(String... string_elements)  {
      return  test_get1stIdxIfNotAtEnd(0, string_elements);
   }
   /**
      <P>Testing/diagnostic function. Get the index of the first element in {@code string_elements} that is not found <I>at the end</I> of this IterationOdometer (its iterator). The final string in {@code string_elements} must be the final element in this IterationOdometer. The second-to-last string must be the second-to-last element, and so on.</P>

      @param  elements_toBypassCount  If you're obviously testing far into the iterator, then you can bypass a certain number of elements, to save a bit of processing power.
      @return  <B>{@code -1}</B>  If all string elements in {@code string_elements} are found, sequentially, beginning anywhere in this IterationOdometer.
      <BR><B>{@code <I>the index</I>}</B> Of the first element not found.
    **/
   public final int test_get1stIdxIfNotAtEnd(int elements_toBypassCount, String... string_elements)  {
      ArrayList<String> vs = new ArrayList<String>(string_elements.length);
      IteratorIOD<T> ioditrt = (IteratorIOD<T>)iterator();

      boolean bQ = false;

      while(ioditrt.hasNext())  {
         if(elements_toBypassCount > 0)  {
            ioditrt.next();
            elements_toBypassCount--;
            continue;
         }

         if(vs.size() >= string_elements.length)  {
            vs.remove(0);
         }

         String s = ioditrt.nextString();
         vs.add(s);
      }


      for(int i = 0; i < string_elements.length; i++)  {
         if(vs.size() < string_elements.length)  {
            return  i;
         }

         try  {
            if(!string_elements[i].equals(vs.get(i)))  {
               return  i;
            }
         }  catch(NullPointerException npx)  {
            throw  new NullPointerException("string_elements[" + i + ']');
         }
      }

      return  -1;
   }
}

