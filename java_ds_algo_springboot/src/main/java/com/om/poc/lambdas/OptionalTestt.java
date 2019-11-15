package com.om.poc.lambdas;

import java.util.Optional;

public class OptionalTestt {

  public static void main(String[] args) {
    String s = null;

    Optional<String> s2 = m1();
    if(s2.isPresent()) {
      System.out.println("Hello: " + s2.get());
    }
  }

  private static Optional<String> m1() {

    //iff a =a abbbb
    //return Optional.of("abc");
    //return Optional.ofNullable(null);
    //return Optional.empty();



    String nullName = "assdf";
    return Optional.of(Optional.ofNullable(nullName).orElse("john"));
  }
}
