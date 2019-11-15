package com.om.poc.lambdas;

import java.util.concurrent.CompletableFuture;

public class Test2 {

  public static void main(String[] args) {
//    Intef i = new Demo();
//    i.add(1,2);

    Intef i2 = (a,b) -> {
      return a+b;
    };

    i2.add(10, 20);

    m1(i2);


    // get its Account Details
    // add deposited money
    // save updated balance



    CompletableFuture.supplyAsync(() -> {
      return "hello";
    })
        .thenAccept(product -> {
      System.out.println("Got product detail from remote service " );
    });
  }

  private static void m1(final Intef i2) {
  }

}
