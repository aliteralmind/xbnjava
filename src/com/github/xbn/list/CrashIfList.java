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
package  com.github.xbn.list;
   import  com.github.xbn.lang.BadDuplicateException;
   import  com.github.xbn.lang.LengthLessThanRequiredException;
   import  com.github.xbn.array.Duplicates;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.array.NullElement;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.List;
   import  java.util.Objects;
/**
   <p>If a list is invalid, crash. Otherwise, do nothing. This is the same as {@link com.github.xbn.list.CrashIfCollection} except for the error messages.</p>

   @see  com.github.xbn.lang.CrashIfObject
   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class CrashIfList  {
   /**
      <p>The template for list error output--Equal to {@code "%name%.get(%idx%)"}.</p>

      @see  #bad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) bad
      @see  #ofStringsBad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) ofStringsBad
    **/
   static final String LIST_ERR_TMPL = "%name%.get(%idx%)";
   /**
      <p>If a list is {@code null} or has no elements, crash. Otherwise, do nothing.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #empty(List, String, NullContainer) empty}(list, list_name, {@link com.github.xbn.array.NullContainer}.{@link com.github.xbn.array.NullContainer#BAD BAD})</code></p>
    **/
   public static final void nullEmpty(List<?> list, String list_name)  {
      empty(list, list_name, NullContainer.BAD);
   }
   /**
      <p>If a list has no elements, crash. Otherwise, do nothing.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #bad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) bad}(list, list_name, null_list, 1, null, {@link com.github.xbn.array.NullElement}.{@link com.github.xbn.array.NullElement#OK OK}, 0, null, {@link com.github.xbn.array.Duplicates}.{@link com.github.xbn.array.Duplicates#OK OK})</code></p>
    **/
   public static final void empty(List<?> list, String list_name, NullContainer null_list)  {
      bad(list, list_name, null_list, 1, null, NullElement.OK, 0, null, Duplicates.OK);
   }
   /**
      <p>If a list's size is less than a number, crash. Otherwise, do nothing.</p>

      <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #bad(List, String, NullContainer, int, String, NullElement, int, String, Duplicates) bad}(list, list_name, null_list, min_allowedLength, min_varName, {@link com.github.xbn.array.NullElement}.{@link com.github.xbn.array.NullElement#OK OK}, 0, null, {@link com.github.xbn.array.Duplicates}.{@link com.github.xbn.array.Duplicates#OK OK})</code></p>
    **/
   public static final void sizeLessThan(List<?> list, String list_name, NullContainer null_list, int min_allowedLength, String min_varName)  {
      bad(list, list_name, null_list, min_allowedLength, min_varName, NullElement.OK, 0, null, Duplicates.OK);
   }
   /**
      <p>If a list is bad, crash. Otherwise, do nothing.</p>

      <p>With the exception of duplicate detection, this function behaves the same as
      <br/> &nbsp; &nbsp; <code>{@link CrashIfCollection}.{@link CrashIfCollection#bad(Collection, String, NullContainer, int, String, NullElement, int, String) bad}(list, list_name, null_list, min_allowedLength, min_varName, null_element, min_allowedElementLen, minElementLen_name)</code>
      <br/>.</p>

      @param  duplicates  If {@link com.github.xbn.array.Duplicates#BAD BAD}, then elements must be unique. This parameter may not be {@code null}.
      @exception  BadDuplicateException  If two elements are equal and {@code duplicates.BAD}.
      @see  #nullEmpty(List, String) nullEmpty
      @see  #empty(List, String, NullContainer) empty
      @see  #sizeLessThan(List, String, NullContainer, int, String) lengthLessThan
    **/
   public static final void bad(List<?> list, String list_name, NullContainer null_list, int min_allowedLength, String min_varName, NullElement null_element, int min_allowedElementLen, String minElementLen_name, Duplicates duplicates)  {
      CrashIfCollection.crashForNullnessAndSize(LIST_ERR_TMPL, list, list_name, null_list, min_allowedLength, min_varName);

      if(list == null)  {
         return;
      }
      int size = list.size();
      if(size == 0)  {
         return;
      }

      try  {
         if(null_element.isOk())  {
            if(min_allowedElementLen == 0)  {
               if(duplicates.isOk())  {
                  return;
               }

               for(int i = 0; i < size; i++)  {
                  for(int j = (i + 1); j < size; j++)  {
                     if(Objects.equals(list.get(i), list.get(j)))  {
                        throw  new BadDuplicateException("list.get(" + i + ")", "list.get(" + j + ")", list.get(i));
                     }
                  }
               }
               return;
            }

            //min_allowedElementLen > 0  (should be!)

            for(int i = 0; i < size; i++)  {
               Object elementi = list.get(i);
               if(elementi != null  &&  elementi.toString().length() < min_allowedElementLen)  {
                  throw  new LengthLessThanRequiredException("list.get(" + i + ")", elementi.toString().length(), min_allowedElementLen, minElementLen_name, null);
               }
               for(int j = (i + 1); j < size; j++)  {
                  if(Objects.equals(elementi, list.get(j)))  {
                     throw  new BadDuplicateException("list.get(" + i + ")", "list.get(" + j + ")", list.get(i));
                  }
               }
            }
            Object lastElement = list.get(size - 1);
            if(lastElement != null  &&  lastElement.toString().length() < min_allowedElementLen)  {
               throw  new LengthLessThanRequiredException("list.get(" + (size - 1) + ")", lastElement.toString().length(), min_allowedElementLen, minElementLen_name, null);
            }
            return;
         }
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(null_element, "null_element", null);
         throw  CrashIfObject.nullOrReturnCause(duplicates, "duplicates", null, rx);
      }

      //null_element.BAD

      if(min_allowedElementLen == 0)  {
         if(duplicates.isOk())  {
            for(int i = 0; i < size; i++)  {
               if(list.get(i) == null)  {
                  throw  new NullPointerException("list.get(" + i + ")");
               }
            }
            return;
         }

         for(int i = 0; i < size; i++)  {
            for(int j = (i + 1); j < size; j++)  {
               try  {
                  if(list.get(i).equals(list.get(j)))  {
                     throw  new BadDuplicateException("list.get(" + i + ")", "list.get(" + j + ")", list.get(i));
                  }
               }  catch(NullPointerException npx)  {
                  CrashIfObject.nnull(list.get(i), "list.get(" + i + ")", null);
                  throw  CrashIfObject.nullOrReturnCause(list.get(j), "list.get(" + j + ")", null, npx);
               }
            }
         }
//			Object lastElement = list.get(size - 1);
         if(list.get(size - 1) == null)  {
            throw  new NullPointerException("list.get(" + (size - 1) + ")");
         }
         return;
      }

      //min_allowedElementLen > 0  (should be!)

      if(duplicates.isOk())  {
         for(int i = 0; i < size; i++)  {
            if(list.get(i).toString().length() < min_allowedElementLen)  {
               throw  new LengthLessThanRequiredException("list.get(" + i + ")", list.get(i).toString().length(), min_allowedElementLen, minElementLen_name, null);
            }
         }
         return;
      }

      //duplicates.BAD

      for(int i = 0; i < size; i++)  {
         for(int j = (i + 1); j < size; j++)  {
            try  {
               if(list.get(i).equals(list.get(j)))  {
                  throw  new BadDuplicateException("list.get(" + i + ")", "list.get(" + j + ")", list.get(i));
               }
            }  catch(NullPointerException npx)  {
               CrashIfObject.nnull(list.get(i), "list.get(" + i + ")", null);
               throw  CrashIfObject.nullOrReturnCause(list.get(j), "list.get(" + j + ")", null, npx);
            }
         }
      }
      Object lastElement = list.get(size - 1);
      try  {
         if(lastElement.toString().length() < min_allowedElementLen)  {
            throw  new LengthLessThanRequiredException("list.get(" + (size - 1) + ")", lastElement.toString().length(), min_allowedElementLen, minElementLen_name, null);
         }
      }  catch(NullPointerException npx)  {
         throw  CrashIfObject.nullOrReturnCause(lastElement, "list.get(" + (size - 1) + ")", null, npx);
      }
   }
}
