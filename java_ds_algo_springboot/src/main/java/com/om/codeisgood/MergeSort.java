package com.om.codeisgood;

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] input = {25, 35, -20, 10, 60, 1, -40, 10};
    mergeSort(input, 0, input.length);
    Arrays.stream(input).forEach(x -> System.out.print(x + " "));
    System.out.println();

    int firstHighest = Integer.MIN_VALUE;
    int secondHighest = Integer.MIN_VALUE;
    for (int i = 0; i < input.length; i++) {
      int current = input[i];
      if(current > firstHighest) {
        secondHighest = firstHighest;
        firstHighest = current;
      }
    }

    System.out.println("2nd highest: " + secondHighest);
  }

  private static void mergeSort(final int[] input, final int start, final int end) {
    if(end - start < 2)
      return;

    int mid = (start + end) / 2;
    mergeSort(input, start, mid);
    mergeSort(input, mid, end);
    merge(input, start, mid, end);
  }

  // {20, 4}
  private static void merge(final int[] input, final int start, final int mid, final int end) {
    if(input[mid-1] <= input[mid])
      return;

    int i = start;
    int j = mid;
    int tempIndex = 0;

    int[] temp = new int[end-start];

    while(i < mid && j < end) {
      temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
    }

    System.arraycopy(input, i, input, start + tempIndex, mid-i);
    System.arraycopy(temp, 0, input, start, tempIndex);
  }
}
