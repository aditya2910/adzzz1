package com.poc.ds.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

  private static final int[] arr1 = {1, 2, 4, 5, 9};
  private static final int[] arr2 = {0, 3, 6, 8, 10};

  public static void main(String[] args) {
    int finalArrSize = arr1.length + arr2.length;
    int[] arrFinal = new int[finalArrSize];

    getMergedSortedArray(finalArrSize, arrFinal);
    printArr(arrFinal);


    double median = getMedian(arrFinal);
    System.out.println("median: " + median);
  }

  private static double getMedian(final int[] arrFinal) {
    if(arrFinal.length % 2 != 0) {
      return arrFinal[arrFinal.length/2];
    } else {
      return (double)(arrFinal[arrFinal.length/2] + arrFinal[arrFinal.length/2 -1]) / 2;
    }
  }

  private static void getMergedSortedArray(final int finalArrSize, final int[] arrFinal) {
    int x = 0, y = 0;
    for (int i = 0; i < finalArrSize; i++) {
      if (x == arr1.length) {
        arrFinal[i] = arr2[y];
        y++;
        continue;
      }
      if (y == arr2.length) {
        arrFinal[i] = arr1[x];
        x++;
        continue;
      }

      if (arr1[x] < arr2[y]) {
        arrFinal[i] = arr1[x];
        x++;
      } else {
        arrFinal[i] = arr2[y];
        y++;
      }
    }
  }



  private static void printArr(final int[] arrFinal) {
    Arrays.stream(arrFinal)
        .forEach(e->System.out.print(e + " "));
    System.out.println();
  }

}
