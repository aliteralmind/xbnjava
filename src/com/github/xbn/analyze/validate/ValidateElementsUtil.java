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
package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.Vector;
//------------------
   import  java.util.Iterator;
   import  java.util.Collection;
   import  java.util.List;

/**
   <p>Validate all elements in a collection<h1> or array</h1></p>

   @since  0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>

 **/
public class ValidateElementsUtil  {
   private ValidateElementsUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <p>Are all elements in a collection valid?.</p>

      @param  to_validate  May not be {@code null}.
      @param  element_validator  The rules to validate for. May not be {@code null}.

      @see  #getValidElements(Collection, ValueValidator) getValidElements(cll,vv)
      @see  #getInvalidElements(Collection, ValueValidator) getInvalidElements(cll,vv)
    **/
   @SuppressWarnings("unchecked")
   public static final <E> boolean areElementsValid(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      Iterator<E> itr = null;
      try  {
         itr = to_validate.iterator();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_validate, "to_validate", null, rx);
      }

      while(itr.hasNext())  {
         try  {
            if(!element_validator.isValid((E)itr.next()))  {
               return  false;
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(element_validator, "element_validator", null, rx);
         }
      }
      return  true;
   }
   /**
      <p>Get a new collection of all good elements.</p>

      @return  {@link #getValidInvalidElements(boolean, Collection, ValueValidator) getValidInvalidElements(true, to_validate, element_validator)}
    **/
   public static final <E> Collection<E> getValidElements(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElements(true, to_validate, element_validator);
   }
   /**
      <p>Get a new collection of all bad elements.</p>

      @return  {@link #getValidInvalidElements(boolean, Collection, ValueValidator) getValidInvalidElements(false, to_validate, element_validator)}
    **/
   public static final <E> Collection<E> getInvalidElements(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElements(false, to_validate, element_validator);
   }

   /**
      <p>Get a new collection of all good/bad elements.</p>

      @param  do_getValid  If {@code true}, then the first valid element-index is return. If {@code false}, the first invalid.
      @param  to_validate  May not be {@code null}.
      @param  element_validator  May not be {@code null}.

      @see
         <li>{@link #getValidElements(Collection, ValueValidator) getValidElements(cll,vv)}, {@link #getInvalidElements(Collection, ValueValidator) getInvalidElements(cll,vv)}</li>
      </ul>
    **/
   @SuppressWarnings("unchecked")
   static final <E> Collection<E> getValidInvalidElements(boolean do_getValid, Collection<E> to_validate, ValueValidator<E> element_validator)  {
      Iterator<E> itr = null;
      try  {
         itr = to_validate.iterator();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_validate, "to_validate", null, rx);
      }

      Vector<E> v = new Vector<E>(to_validate.size());

      while(itr.hasNext())  {
         E e = (E)itr.next();
         try  {
            if(element_validator.isValid(e) == do_getValid)  {
               v.add(e);
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(element_validator, "element_validator", null, rx);
         }
      }
      return  v;
   }
   /**
      <p>Get a new list containing the indexes of all good/bad elements.</p>

      @return  {@link #getValidInvalidElementIndexes(boolean, List, ValueValidator) getValidInvalidElementIndexes(true, to_validate, element_validator)}
    **/
   public static final <E> List<Integer> getValidElementIndexes(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElementIndexes(true, to_validate, element_validator);
   }
   /**
      <p>Get a new list containing the indexes of all good/bad elements.</p>

      @return  {@link #getValidInvalidElementIndexes(boolean, List, ValueValidator) getValidInvalidElementIndexes(false, to_validate, element_validator)}
    **/
   public static final <E> List<Integer> getInvalidElementIndexes(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElementIndexes(false, to_validate, element_validator);
   }

   /**
      <p>Get a new list containing the indexes of all good/bad elements.</p>

      @param  do_getValid  If {@code true}, then the first valid element-index is return. If {@code false}, the first invalid.
      @param  to_validate  May not be {@code null}.
      @param  element_validator  May not be {@code null}.

      @see  #getValidElementIndexes(List, ValueValidator) getValidElementIndexes(lst,vv)
      @see  #getInvalidElementIndexes(List, ValueValidator) getInvalidElementIndexes(lst,vv)
    **/
   @SuppressWarnings("unchecked")
   static final <E> List<Integer> getValidInvalidElementIndexes(boolean do_getValid, List<E> to_validate, ValueValidator<E> element_validator)  {
      Iterator<E> itr = null;
      try  {
         itr = to_validate.iterator();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_validate, "to_validate", null, rx);
      }

      Vector<Integer> vi = new Vector<Integer>(to_validate.size());
      int i = 0;

      while(itr.hasNext())  {
         try  {
            if(element_validator.isValid(itr.next()) == do_getValid)  {
               vi.add(i);
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(element_validator, "element_validator", null, rx);
         }
         i++;
      }
      return  vi;
   }
   /**
      <p>Get the number of good elements.</p>

      @param  to_validate  May not be {@code null}.
      @param  element_validator  May not be {@code null}.
      @see  #areElementsValid(Collection, ValueValidator) areElementsValid(cll,vv)
    **/
   @SuppressWarnings("unchecked")
   public static final <E> int getValidElementCount(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      Iterator<E> itr = null;
      try  {
         itr = to_validate.iterator();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_validate, "to_validate", null, rx);
      }

      int i = 0;

      while(itr.hasNext())  {
         E e = (E)itr.next();
         try  {
            if(!element_validator.isValid(e))  {
               i++;
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(element_validator, "element_validator", null, rx);
         }
      }
      return  i;
   }
   /**
      <p>Get the number of bad elements.</p>

      @return   <code>to_validate.size() - {@link #getValidElementCount(Collection, ValueValidator) getValidElementCount}(to_validate, element_validator)</code>
      @see  #areElementsValid(Collection, ValueValidator) areElementsValid(cll,vv)
    **/
   public static final <E> int getInvalidElementCount(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      int iValid = getValidElementCount(to_validate, element_validator);
      //iwc set to to_validate in getValidElementCount()
      return  (to_validate.size() - iValid);
   }
   /**
      <p>Get the index of the first bad element.</p>

      @return  {@link #getIndexFirstValidInvalid(boolean, List, ValueValidator) getIndexFirstValidInvalid(false, to_validate, element_validator)}
    **/
   public static final <E> int getIndexFirstInvalid(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getIndexFirstValidInvalid(false, to_validate, element_validator);
   }
   /**
      <p>Get the index of the first good element.</p>

      @return  {@link #getIndexFirstValidInvalid(boolean, List, ValueValidator) getIndexFirstValidInvalid(true, to_validate, element_validator)}
    **/
   public static final <E> int getIndexFirstValid(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getIndexFirstValidInvalid(true, to_validate, element_validator);
   }
   /**
      <p>Get the index of the first good/bad element in the list.</p>


      @param  do_getValid  If {@code true}, then the first valid element-index is return. If {@code false}, the first invalid.
      @param  to_validate  May not be {@code null}.
      @param  element_validator  May not be {@code null}.
      @return  {@code -1} if there are no elements, or no element is valid/invalid.

      @see
         <li>{@link #getIndexFirstValid(List, ValueValidator) getIndexFirstValid(lst,vv)}, {@link #getIndexFirstInvalid(List, ValueValidator) getIndexFirstInvalid(lst,vv)}</li>
      </ul>
    **/
   @SuppressWarnings("unchecked")
   static final <E> int getIndexFirstValidInvalid(boolean do_getValid, List<E> to_validate, ValueValidator<E> element_validator)  {
      Iterator<E> itr = null;
      try  {
         itr = to_validate.iterator();
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_validate, "to_validate", null, rx);
      }

      int i = 0;
      while(itr.hasNext())  {
         E e = (E)itr.next();
         try  {
            if(element_validator.isValid(e) == do_getValid)  {
               return  i;
            }
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(element_validator, "element_validator", null, rx);
         }
         i++;
      }
      return  -1;
   }
}
