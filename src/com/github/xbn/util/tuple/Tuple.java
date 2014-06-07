//: net/mindview/util/Tuple.java
// Tuple library using type argument inference.
package com.github.xbn.util.tuple;

/**
   <P>Create a {@code Tuple} of length two-through-five.</P>
 **/
public class Tuple {
  public static final <A,B> TwoTuple<A,B> tuple(A a, B b) {
    return new TwoTuple<A,B>(a, b);
  }
  public static final <A,B,C> ThreeTuple<A,B,C> tuple(A a, B b, C c) {
    return new ThreeTuple<A,B,C>(a, b, c);
  }
  public static final <A,B,C,D> FourTuple<A,B,C,D> tuple(A a, B b, C c, D d) {
    return new FourTuple<A,B,C,D>(a, b, c, d);
  }
  public static final <A,B,C,D,E> FiveTuple<A,B,C,D,E> tuple(A a, B b, C c, D d, E e) {
    return new FiveTuple<A,B,C,D,E>(a, b, c, d, e);
  }
} ///:~
