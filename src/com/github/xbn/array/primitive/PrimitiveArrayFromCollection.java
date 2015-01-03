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
package  com.github.xbn.array.primitive;
   import  com.github.xbn.array.IndexableUtil;
   import  com.github.xbn.array.NullContainer;
   import  com.github.xbn.lang.CrashIfObject;
   import  com.github.xbn.util.copyval.NullHandler;
   import  com.github.xbn.util.copyval.ResettableNullHandler;
   import  java.util.ArrayList;
   import  java.util.Collection;
   import  java.util.Iterator;
/**
   <p>Translate a collection of wrappers to an array of its primitive type (such as {@code List<Integer>} to {@code int[]}).</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class PrimitiveArrayFromCollection  {
//internal
   @SuppressWarnings("unchecked")
   private static final ResettableNullHandler rstblNullHndlr = new ResettableNullHandler(1);
   /**
      <p>Create a new instance--This does nothing.</p>
    */
   public PrimitiveArrayFromCollection()  {
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forBoolean(Collection, NullHandler, NullContainer, String) forBoolean}(coll, (new ResettableNullHandler&lt;Boolean&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final boolean[] forBoolean(Collection<Boolean> coll, boolean for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forBoolean(coll, (NullHandler<Boolean>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

<!--
---nwrqm input for
   forBoolean(lst,b,s,s)
   forBoolean(lst,hnv,s,s)

Boolean boolean Bool
Double double PDouble
Float float PFloat
Long long PLong
Integer int Int
Short short PShort
Byte byte PByte
Character char Char

Use this see link, and change Booxl to Bool when done. (NOT IN THIS HTML COMMENT THOUGH!!!)
      &#64;see #forBooxl(Collection, booxlean) forBooxl(lst,p)}
      &#64;see #forBooxl(Collection, NullHandler, boolean, String) forBooxl(lst,hnv)

 -->
    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final boolean[] forBoolean(Collection<Boolean> coll, NullHandler<Boolean> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Boolean> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Boolean> vo = new ArrayList<Boolean>(iSz >>> 2);
         while(itr.hasNext())  {
            Boolean o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forBooleanCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         boolean[] ap = new boolean[iSz];
         while(itr.hasNext())  {
            Boolean o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         boolean[] ap = new boolean[iSz];
         for(; i < iSz; i++)  {
            Boolean o = itr.next();
            ap[i] = ((o == null) ? (Boolean)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /*
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacter(Collection) forCharacter(cll)
   @SuppressWarnings("unchecked")
   public static final boolean[] forBoolean(Collection<Boolean> coll)  {
      boolean[] ap = null;
      try  {
         ap = new boolean[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Boolean> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Boolean o = null;
         try  {
            o = itr.next().booleanValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.booleanValue();
      }
      return ap;
   }
    */
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forCharacter(Collection, NullHandler, NullContainer, String) forCharacter}(coll, (new ResettableNullHandler&lt;Character&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final char[] forCharacter(Collection<Character> coll, char for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forCharacter(coll, (NullHandler<Character>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final char[] forCharacter(Collection<Character> coll, NullHandler<Character> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Character> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Character> vo = new ArrayList<Character>(iSz >>> 2);
         while(itr.hasNext())  {
            Character o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forCharacterCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         char[] ap = new char[iSz];
         while(itr.hasNext())  {
            Character o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         char[] ap = new char[iSz];
         for(; i < iSz; i++)  {
            Character o = itr.next();
            ap[i] = ((o == null) ? (Character)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forByte(Collection, NullHandler, NullContainer, String) forByte}(coll, (new ResettableNullHandler&lt;Byte&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final byte[] forByte(Collection<Byte> coll, byte for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forByte(coll, (NullHandler<Byte>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final byte[] forByte(Collection<Byte> coll, NullHandler<Byte> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Byte> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Byte> vo = new ArrayList<Byte>(iSz >>> 2);
         while(itr.hasNext())  {
            Byte o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forByteCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         byte[] ap = new byte[iSz];
         while(itr.hasNext())  {
            Byte o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         byte[] ap = new byte[iSz];
         for(; i < iSz; i++)  {
            Byte o = itr.next();
            ap[i] = ((o == null) ? (Byte)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forShort(Collection, NullHandler, NullContainer, String) forShort}(coll, (new ResettableNullHandler&lt;Short&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final short[] forShort(Collection<Short> coll, short for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forShort(coll, (NullHandler<Short>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final short[] forShort(Collection<Short> coll, NullHandler<Short> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Short> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Short> vo = new ArrayList<Short>(iSz >>> 2);
         while(itr.hasNext())  {
            Short o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forShortCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         short[] ap = new short[iSz];
         while(itr.hasNext())  {
            Short o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         short[] ap = new short[iSz];
         for(; i < iSz; i++)  {
            Short o = itr.next();
            ap[i] = ((o == null) ? (Short)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forInteger(Collection, NullHandler, NullContainer, String) forInteger}(coll, (new ResettableNullHandler&lt;Integer&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final int[] forInteger(Collection<Integer> coll, int for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forInteger(coll, (NullHandler<Integer>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final int[] forInteger(Collection<Integer> coll, NullHandler<Integer> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Integer> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Integer> vo = new ArrayList<Integer>(iSz >>> 2);
         while(itr.hasNext())  {
            Integer o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forIntegerCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         int[] ap = new int[iSz];
         while(itr.hasNext())  {
            Integer o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         int[] ap = new int[iSz];
         for(; i < iSz; i++)  {
            Integer o = itr.next();
            ap[i] = ((o == null) ? (Integer)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forLong(Collection, NullHandler, NullContainer, String) forLong}(coll, (new ResettableNullHandler&lt;Long&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final long[] forLong(Collection<Long> coll, long for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forLong(coll, (NullHandler<Long>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final long[] forLong(Collection<Long> coll, NullHandler<Long> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Long> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Long> vo = new ArrayList<Long>(iSz >>> 2);
         while(itr.hasNext())  {
            Long o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forLongCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         long[] ap = new long[iSz];
         while(itr.hasNext())  {
            Long o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         long[] ap = new long[iSz];
         for(; i < iSz; i++)  {
            Long o = itr.next();
            ap[i] = ((o == null) ? (Long)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forFloat(Collection, NullHandler, NullContainer, String) forFloat}(coll, (new ResettableNullHandler&lt;Float&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final float[] forFloat(Collection<Float> coll, float for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forFloat(coll, (NullHandler<Float>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final float[] forFloat(Collection<Float> coll, NullHandler<Float> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Float> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Float> vo = new ArrayList<Float>(iSz >>> 2);
         while(itr.hasNext())  {
            Float o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forFloatCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         float[] ap = new float[iSz];
         while(itr.hasNext())  {
            Float o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         float[] ap = new float[iSz];
         for(; i < iSz; i++)  {
            Float o = itr.next();
            ap[i] = ((o == null) ? (Float)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @return  The equivalent of
      <br> &nbsp; &nbsp; <code>{@link #forDouble(Collection, NullHandler, NullContainer, String) forDouble}(coll, (new ResettableNullHandler&lt;Double&gt;(for_whenNull)))</code>
    */
   @SuppressWarnings("unchecked")
   public static final double[] forDouble(Collection<Double> coll, double for_whenNull, NullContainer nnull, String cntrName_forNullBad)  {
      return  forDouble(coll, (NullHandler<Double>)rstblNullHndlr.nonNullValue(for_whenNull), nnull, cntrName_forNullBad);
   }
   /**
      <p>Get a primitive array from an non-primitive array of its wrapper-type.</p>

    * @param  null_handler  May not be {@code null}.
    */
   @SuppressWarnings("unchecked")
   public static final double[] forDouble(Collection<Double> coll, NullHandler<Double> null_handler, NullContainer nnull, String cntrName_forNullBad)  {
      if(coll == null)  {
         IndexableUtil.crashIfContainerIsNullAndThatIsBad(nnull, cntrName_forNullBad);
         return  null;
      }
      int iSz = coll.size();

      Iterator<Double> itr = coll.iterator();
      int i = 0;

      if(null_handler.getAction().doDelete())  {
                                      //Assume 50% kept (div by two)
         ArrayList<Double> vo = new ArrayList<Double>(iSz >>> 2);
         while(itr.hasNext())  {
            Double o = itr.next();
            if(o != null)  {
               vo.add(o);
            }
         }
         return  forDoubleCrashIfNullElement(vo);
      }  else if(null_handler.getAction().doCrash())  {
         double[] ap = new double[iSz];
         while(itr.hasNext())  {
            Double o = itr.next();
            if(o == null)  {
               throw  new NullPointerException("coll.get(" + i + ") is null (null_handler.doCrash() is true).");
            }
            ap[i++] = o;
         }
         return  ap;
      }  else  {
         double[] ap = new double[iSz];
         for(; i < iSz; i++)  {
            Double o = itr.next();
            ap[i] = ((o == null) ? (Double)null_handler.getNonNull() : o);
         }
         return  ap;
      }
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

<!--
---nwrqm input---
Character Character char
Double Double double
Float Float float
Long Long long
Integer Integer int
Short Short short
Byte Byte byte
Boolean Boolean boolean

Use this see link, and change Chaxracter to Character when done. (NOT IN THIS HTML COMMENT THOUGH!!!)
      &#64;see  {&#64;link #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)}
 -->

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final char[] forCharacterCrashIfNullElement(Collection<Character> coll)  {
      char[] ac = null;
      try  {
         ac = new char[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Character> itr = coll.iterator();
      for (int i = 0; i < ac.length; i++)  {
         Character o = null;
         try  {
            o = itr.next().charValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ac[i] = o.charValue();
      }
      return ac;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final double[] forDoubleCrashIfNullElement(Collection<Double> coll)  {
      double[] ap = null;
      try  {
         ap = new double[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Double> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Double o = null;
         try  {
            o = itr.next().doubleValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.doubleValue();
      }
      return ap;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final boolean[] forBooleanCrashIfNullElement(Collection<Boolean> coll)  {
      boolean[] ap = null;
      try  {
         ap = new boolean[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Boolean> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Boolean o = null;
         try  {
            o = itr.next().booleanValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.booleanValue();
      }
      return ap;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final float[] forFloatCrashIfNullElement(Collection<Float> coll)  {
      float[] ap = null;
      try  {
         ap = new float[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Float> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Float o = null;
         try  {
            o = itr.next().floatValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.floatValue();
      }
      return ap;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final long[] forLongCrashIfNullElement(Collection<Long> coll)  {
      long[] ap = null;
      try  {
         ap = new long[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Long> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Long o = null;
         try  {
            o = itr.next().longValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.longValue();
      }
      return ap;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final int[] forIntegerCrashIfNullElement(Collection<Integer> coll)  {
      int[] ap = null;
      try  {
         ap = new int[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Integer> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Integer o = null;
         try  {
            o = itr.next().intValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.intValue();
      }
      return ap;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final short[] forShortCrashIfNullElement(Collection<Short> coll)  {
      short[] ap = null;
      try  {
         ap = new short[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Short> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Short o = null;
         try  {
            o = itr.next().shortValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.shortValue();
      }
      return ap;
   }
   /**
      <p>Get a primitive array from a <i>non-{@code null}</i> collection that has <i>no {@code null} elements</i>.</p>

    * @see  #forCharacterCrashIfNullElement(Collection) forCharacterCrashIfNullElement(cll)
    */
   @SuppressWarnings("unchecked")
   public static final byte[] forByteCrashIfNullElement(Collection<Byte> coll)  {
      byte[] ap = null;
      try  {
         ap = new byte[coll.size()];
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(coll, "coll", null, rx);
      }
      Iterator<Byte> itr = coll.iterator();
      for (int i = 0; i < ap.length; i++)  {
         Byte o = null;
         try  {
            o = itr.next().byteValue();
         }  catch(RuntimeException rx)  {
            throw  CrashIfObject.nullOrReturnCause(o, "The " + i + "-th call to [coll.iterator()].next()", null, rx);
         }
         ap[i] = o.byteValue();
      }
      return ap;
   }
}
