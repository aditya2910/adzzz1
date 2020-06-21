package com.poc.deleteme;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int arr[] ={3,60,35,2,45,320,-5};
    bubbleSort(arr);
    Arrays.stream(arr).forEach(System.out::println);
  }

  private static void bubbleSort(final int[] arr) {
    int i = 0, n = arr.length;
    boolean swapNeeded = true;
    while (i < n - 1 && swapNeeded) {
      swapNeeded = false;
      for (int j = 1; j < n - i; j++) {
        if (arr[j - 1] > arr[j]) {
          swapNumbersInArray(arr, j);
          swapNeeded = true;
        }
      }
      if(!swapNeeded) {
        break;
      }
      i++;
    }
  }

  private static void swapNumbersInArray(final int[] arr, final int j) {
    int temp = arr[j - 1];
    arr[j - 1] = arr[j];
    arr[j] = temp;
  }
}
