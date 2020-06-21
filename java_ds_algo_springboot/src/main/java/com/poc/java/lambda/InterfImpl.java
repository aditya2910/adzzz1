package com.poc.java.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterfImpl {

  public static void main(String[] args) {
    Interf interf = (textToPrint) -> {
      if(textToPrint == null) {
        throw new IllegalArgumentException("no null value allowed");
      }
      System.out.println(textToPrint);
    };

    interf.print("Hello World");


    List<Integer> range = IntStream.rangeClosed(1, 10)
        .boxed().collect(Collectors.toList());
    System.out.println(range);

    try {
      List<Integer> range2 = range.stream().filter(n -> filterNumber(n)).collect(Collectors.toList());
      System.out.println(range2);
    } catch (Exception e) {

    }
  }

  private static boolean filterNumber(final Integer n) {
    if(n==6) {
      throw new RuntimeException("no 6 value allowed");
    }
    return n==5;
  }
}
