package com.om.codeisgood;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] input = {8, 3, 6, -5, 40, -9, 45, 1, 9};
    insertionSort(input);
    Arrays.stream(input).forEach(x -> System.out.print(x + " "));
  }

  private static void insertionSort(final int[] input) {
    for (int fui = 1; fui < input.length ; fui++) {
      int ne = input[fui];
      int i;
      for (i = fui; i > 0 && input[i-1] > ne ; i--) {
        input[i] = input[i-1];
      }
      input[i] = ne;
    }
  }
}
