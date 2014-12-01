//: net/mindview/util/FiveTuple.java
package com.github.xbn.util.tuple;
/**
   <p>A {@code Tuple} for five values.</p>
 **/
public class FiveTuple<A,B,C,D,E> extends FourTuple<A,B,C,D>  {
//config
   private final E o5;
//constructors...START
   /**
      <p>Create a new instance.</p>

    * @param  o_5  Get with {@link #get5() get5}{@code ()}
    */
   public FiveTuple(A o_1, B o_2, C o_3, D o_4, E o_5)  {
      super(o_1, o_2, o_3, o_4);
      o5 = o_5;
   }
//constructors...END
   public final E get5()  {
      return  o5;
   }
   public String toString()  {
      return  super.toString() + ", get5()=[" + get5() + "]";
   }
} ///:~
