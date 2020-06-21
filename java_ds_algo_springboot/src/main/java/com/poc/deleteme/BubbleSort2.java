package com.poc.deleteme;

import java.util.Arrays;

public class BubbleSort2 {
  public static void main(String[] args) {
    int arr[] ={3,60,35,2,45,320,-5};
    bubbleSort(arr);
    Arrays.stream(arr).forEach(System.out::println);
  }

  private static void bubbleSort(final int[] arr) {
    int lastIndex = arr.length;
    for (int i = 0; i < lastIndex; i++) {
      //compare element at ith index to rest of the elements in arr
      for (int j = i; j < lastIndex-1; j++) {
        if(arr[j] > arr[j+1])
          swapNumbersInArray(arr, j);
      }
      lastIndex -= 1;
    }
  }

  private static void swapNumbersInArray(final int[] arr, final int j) {
    int temp = arr[j + 1];
    arr[j + 1] = arr[j];
    arr[j] = temp;
  }
}
