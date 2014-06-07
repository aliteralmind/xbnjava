//: net/mindview/util/FourTuple.java
package com.github.xbn.util.tuple;
/**
   <P>A {@code Tuple} for four values.</P>
 **/
public class FourTuple<A,B,C,D> extends ThreeTuple<A,B,C>  {
//config
   private final D o4;
//constructors...START
   /**
      <P>Create a new instance.</P>

      @param  o_4  Get with {@link #get4() get4}{@code ()}
    **/
   public FourTuple(A o_1, B o_2, C o_3, D o_4)  {
      super(o_1, o_2, o_3);
      o4 = o_4;
   }
//constructors...END
   public final D get4()  {
      return  o4;
   }
   public String toString()  {
      return  super.toString() + ", get4()=[" + get4() + "]";
   }
} ///:~
