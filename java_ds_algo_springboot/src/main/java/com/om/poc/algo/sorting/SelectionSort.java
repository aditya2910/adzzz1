package com.om.poc.algo.sorting;

public class SelectionSort {

  public static void main(String[] args) {
    int[] input = {12,2, 40, 6, 1, 5, 11};
    int[] sortedInputAsc = doSelectionSort(input);
    printArray(sortedInputAsc);
  }

  private static int[] doSelectionSort(final int[] input) {
    for (int i = 0; i < input.length; i++) {
      int selectedNo = input[i];
      int smallestNoIndex = i;
      for (int j = i+1; j < input.length; j++) {
        if(input[j] < selectedNo) {
          selectedNo = input[j];
          smallestNoIndex = j;
        }
      }
      if(i != smallestNoIndex) {
        swapElement(i, smallestNoIndex, input);
      }
    }
    return input;
  }

  private static void swapElement(final int currentIndex, final int smallestNoIndex, final int[] input) {
    int temp = input[currentIndex];
    input[currentIndex] = input[smallestNoIndex];
    input[smallestNoIndex] = temp;
  }

  private static void printArray(final int[] sortedInputAsc) {
    for (int i = 0; i < sortedInputAsc.length; i++) {
      System.out.print(sortedInputAsc[i] + ", ");
    }
    System.out.println();
  }
}
