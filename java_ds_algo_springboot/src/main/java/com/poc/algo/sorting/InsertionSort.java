package com.poc.algo.sorting;

public class InsertionSort {

  public static void main(String[] args) {
    int[] input = {12,2, 40, 6, 1, 5, 11};
    int[] sortedInputAsc = doInsertionSort(input);
    printArray(sortedInputAsc);
  }

  private static int[] doInsertionSort(final int[] input) {
    for (int i = 0; i < input.length; i++) {
      int smallestElement = input[i];
      for (int j = 0; j < i; j++) {
        if (input[j] > smallestElement) {

         swap(j , i, input);
        }
      }
    }
    return input;
  }

  private static void swap(final int smallIndex, final int toReplaceIndex, final int[] input) {
    int temp = input[smallIndex];
    input[smallIndex] = input[toReplaceIndex];
    input[toReplaceIndex] = temp;
  }

  private static void printArray(final int[] sortedInputAsc) {
    for (int i = 0; i < sortedInputAsc.length; i++) {
      System.out.print(sortedInputAsc[i] + ", ");
    }
    System.out.println();
  }
}
