//: net/mindview/util/ThreeTuple.java
package com.github.xbn.util.tuple;
/**
   <p>A {@code Tuple} for three values.</p>
 **/
public class ThreeTuple<A,B,C> extends TwoTuple<A,B>  {
//config
   private final C o3;
//constructors...START
   /**
      <p>Create a new instance.</p>

    * @param  o_3  Get with {@link #get3() get3}{@code ()}
    */
   public ThreeTuple(A o_1, B o_2, C o_3)  {
      super(o_1, o_2);
      o3 = o_3;
   }
//constructors...END
   public final C get3()  {
      return  o3;
   }
   public String toString()  {
      return  super.toString() + ", get3()=[" + get3() + "]";
   }
} ///:~
