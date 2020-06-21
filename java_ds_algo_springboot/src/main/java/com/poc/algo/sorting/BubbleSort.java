package com.poc.algo.sorting;

public class BubbleSort {

  public static void main(String[] args) {
    int[] input = {12,2, 40, 6, 1, 5, 11};
    int[] sortedInputAsc = doBubbleSort(input);
    printArray(sortedInputAsc);
  }

  private static int[] doBubbleSort(final int[] input) {
    int counter = input.length;
    for (int i = 0; i < counter; i++) {

      for (int j = 0; j < counter - 1; j++) {
        if (input[j] > input[j + 1]) {
          swap(j, input);
          //printArray(input);
        }

      }
      counter--;
    }
    return input;
  }

  private static void swap(final int i, final int[] input) {
    int temp = input[i];
    input[i] = input[i + 1];
    input[i + 1] = temp;
  }

  private static void printArray(final int[] sortedInputAsc) {
    for (int i = 0; i < sortedInputAsc.length; i++) {
      System.out.print(sortedInputAsc[i] + ", ");
    }
    System.out.println();
  }
}
