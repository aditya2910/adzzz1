package com.poc.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("a", "b", "c");

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    list.stream()

        .map(y -> {return y.toUpperCase();})

        .filter(z -> z.contains("A"))
        .forEach(System.out::println);
        //.collect(Collectors.toList());
        //.count();

    Stream<String> stream
        = Stream.of("Geeks", "For",
        "Geeks", "A",
        "Computer",
        "Portal");

    // Print the stream
    // using double colon operator



  }

  void m1(String s1) {

  }
}
