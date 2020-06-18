package com.om.codeisgood;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {2,5,6,1,-3,-9,56,22,4,2,8};
    bubbleSort(arr);
    Arrays.stream(arr).forEach(x -> System.out.println(x + " "));
  }

  private static void bubbleSort(final int[] arr) {
    for (int li = arr.length-1; li > 0 ; li--) {
      for (int i = 0; i < li; i++) {
        if(arr[i] > arr[i+1]) {
          swapItems(arr, i, i+1);
        }
      }
    }
  }

  private static void swapItems(int[] arr, int i, int j) {
    if(i == j) {
      return;
    }
    int temp = arr[i];
    arr[i] = arr[i+1];
    arr[i+1] = temp;
  }

}
