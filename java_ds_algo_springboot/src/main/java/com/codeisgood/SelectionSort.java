package com.codeisgood;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] input = {3,1,6,1,-1,454,1,133};
    selectionSort(input);
    Arrays.stream(input).forEach(x -> System.out.print(x + " "));
  }

  private static void selectionSort(final int[] input) {
    for (int li = input.length-1; li > 0 ; li--) {
      int largest = 0;
      for (int i = 1; i <=li; i++) {
        if(input[i] > input[largest])
          largest = i;
      }
      swap(input, largest, li);
    }
  }

  public static void swap(int[] input, int i, int j) {
    if (i == j)
      return;
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
