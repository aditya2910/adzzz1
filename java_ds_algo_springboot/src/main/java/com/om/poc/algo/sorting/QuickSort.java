package com.om.poc.algo.sorting;

import java.util.Arrays;

public class QuickSort {

  private static void quickSort(final int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private static int partition(final int[] arr, final int low, final int high) {

    int i = low -1;
    int pivot = arr[high];

    for (int j = low; j < high; j++) {
      if(arr[j] <= pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;

    return i+1;
  }

  public static void main(String[] args) {
    int[] arr = {3,4,1,5,6,2};
    quickSort(arr, 0, arr.length-1);

    Arrays.stream(arr).forEach(System.out::println);
  }
}
