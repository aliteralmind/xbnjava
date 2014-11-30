//: net/mindview/util/TwoTuple.java
package com.github.xbn.util.tuple;
/**
   <p>A {@code Tuple} for two values.</p>
 **/
public class TwoTuple<A,B> {
//config
   private final A o1;
   private final B o2;
//constructors...START
   /**
      <p>Create a new instance.</p>

      @param  o_1  Get with {@link #get1() get1}{@code ()}
      @param  o_2  Get with {@link #get2() get2}{@code ()}
    **/
   public TwoTuple(A o_1, B o_2)  {
      o1 = o_1;
      o2 = o_2;
   }
//constructors...END
   public final A get1()  {
      return  o1;
   }
   public final B get2()  {
      return  o2;
   }
   public String toString()  {
      return  "get1()=[" + get1() + "], get2()=[" + get2() + "]";
   }
} ///:~
