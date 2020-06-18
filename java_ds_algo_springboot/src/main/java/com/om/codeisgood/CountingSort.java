package com.om.codeisgood;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingSort {

  public static void main(String[] args) {
    int[] input = {2,5,9,8,2,8,7,10,4,3};
    countingSort(input, 2, 10);
    Arrays.stream(input).forEach(x -> System.out.print(x + " "));


  }

  private static void countingSort(final int[] input, final int min, final int max) {
    int[] countArr = new int[(max-min) - 1];

    for (int i = 0; i < input.length; i++) {
      //countArr[input[i] + min] =
    }
  }
}
