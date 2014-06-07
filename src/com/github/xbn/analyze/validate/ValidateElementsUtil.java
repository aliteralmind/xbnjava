package  com.github.xbn.analyze.validate;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.Vector;
//------------------
   import  java.util.Iterator;
   import  java.util.Collection;
   import  java.util.List;

/**
   <P>Validate all elements in a collection<H1> or array</H1></P>
 **/
public class ValidateElementsUtil  {
   private ValidateElementsUtil()  {
      throw  new IllegalStateException("Do not instantiate");
   }
   /**
      <P>Are all elements in a collection valid?.</P>

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
      <P>Get a new collection of all good elements.</P>

      @return  {@link #getValidInvalidElements(boolean, Collection, ValueValidator) getValidInvalidElements(true, to_validate, element_validator)}
    **/
   public static final <E> Collection<E> getValidElements(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElements(true, to_validate, element_validator);
   }
   /**
      <P>Get a new collection of all bad elements.</P>

      @return  {@link #getValidInvalidElements(boolean, Collection, ValueValidator) getValidInvalidElements(false, to_validate, element_validator)}
    **/
   public static final <E> Collection<E> getInvalidElements(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElements(false, to_validate, element_validator);
   }

   /**
      <P>Get a new collection of all good/bad elements.</P>

      @param  do_getValid  If {@code true}, then the first valid element-index is return. If {@code false}, the first invalid.
      @param  to_validate  May not be {@code null}.
      @param  element_validator  May not be {@code null}.

      @see
         <LI>{@link #getValidElements(Collection, ValueValidator) getValidElements(cll,vv)}, {@link #getInvalidElements(Collection, ValueValidator) getInvalidElements(cll,vv)}</LI>
      </UL>
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
      <P>Get a new list containing the indexes of all good/bad elements.</P>

      @return  {@link #getValidInvalidElementIndexes(boolean, List, ValueValidator) getValidInvalidElementIndexes(true, to_validate, element_validator)}
    **/
   public static final <E> List<Integer> getValidElementIndexes(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElementIndexes(true, to_validate, element_validator);
   }
   /**
      <P>Get a new list containing the indexes of all good/bad elements.</P>

      @return  {@link #getValidInvalidElementIndexes(boolean, List, ValueValidator) getValidInvalidElementIndexes(false, to_validate, element_validator)}
    **/
   public static final <E> List<Integer> getInvalidElementIndexes(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getValidInvalidElementIndexes(false, to_validate, element_validator);
   }

   /**
      <P>Get a new list containing the indexes of all good/bad elements.</P>

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
      <P>Get the number of good elements.</P>

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
      <P>Get the number of bad elements.</P>

      @return   <CODE>to_validate.size() - {@link #getValidElementCount(Collection, ValueValidator) getValidElementCount}(to_validate, element_validator)</CODE>
      @see  #areElementsValid(Collection, ValueValidator) areElementsValid(cll,vv)
    **/
   public static final <E> int getInvalidElementCount(Collection<E> to_validate, ValueValidator<E> element_validator)  {
      int iValid = getValidElementCount(to_validate, element_validator);
      //iwc set to to_validate in getValidElementCount()
      return  (to_validate.size() - iValid);
   }
   /**
      <P>Get the index of the first bad element.</P>

      @return  {@link #getIndexFirstValidInvalid(boolean, List, ValueValidator) getIndexFirstValidInvalid(false, to_validate, element_validator)}
    **/
   public static final <E> int getIndexFirstInvalid(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getIndexFirstValidInvalid(false, to_validate, element_validator);
   }
   /**
      <P>Get the index of the first good element.</P>

      @return  {@link #getIndexFirstValidInvalid(boolean, List, ValueValidator) getIndexFirstValidInvalid(true, to_validate, element_validator)}
    **/
   public static final <E> int getIndexFirstValid(List<E> to_validate, ValueValidator<E> element_validator)  {
      return  getIndexFirstValidInvalid(true, to_validate, element_validator);
   }
   /**
      <P>Get the index of the first good/bad element in the list.</P>


      @param  do_getValid  If {@code true}, then the first valid element-index is return. If {@code false}, the first invalid.
      @param  to_validate  May not be {@code null}.
      @param  element_validator  May not be {@code null}.
      @return  {@code -1} if there are no elements, or no element is valid/invalid.

      @see
         <LI>{@link #getIndexFirstValid(List, ValueValidator) getIndexFirstValid(lst,vv)}, {@link #getIndexFirstInvalid(List, ValueValidator) getIndexFirstInvalid(lst,vv)}</LI>
      </UL>
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
