package com.codeisgood;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int[] input = {25, 35, -20, 10, 60, 4, -40};
    quickSort(input, 0, input.length - 1);
    Arrays.stream(input).forEach(x -> System.out.print(x + " "));
  }

  private static void quickSort(final int[] input, final int start, final int end) {
    if(start < end) {
      int pivotIndex = partition(input, start, end);
      quickSort(input, start, pivotIndex -1);
      quickSort(input, pivotIndex + 1, end);
    }
  }

  private static int partition(final int[] input, final int start, final int end) {
    int pivot = input[end];
    int i = start - 1;
    for (int j = start; j < end; j++) {
      if(input[j] < pivot) {
        i++;
        // swap input[i] to input[j]
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
      }
    }

    // swap input[i+1] to input[end]
    int temp = input[i+1];
    input[i+1] = input[end];
    input[end] = temp;

    return i+1;
  }
}
