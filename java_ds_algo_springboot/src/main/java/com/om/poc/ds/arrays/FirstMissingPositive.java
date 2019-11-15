package com.om.poc.ds.arrays;

import java.util.Arrays;

public class FirstMissingPositive {

  public static void main(String[] args) {
    int arr[] = {1};


    int missingNo = getFirstMissingPositiveNumber(arr);
    System.out.println("missingNo: " + missingNo);

  }

  private static int getFirstMissingPositiveNumber(final int[] arr) {
    if(arr.length == 0) {
      return 1;
    }
    int[] testArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] <= arr.length && arr[i] > 0) {
        testArr[arr[i]-1] = 1;
      }
    }
    printArr(testArr);

    for (int i = 0; i < testArr.length; i++) {
      if(testArr[i] == 0) {
        return i+1;
      }
      if(i == testArr.length-1) {
        return testArr.length+1;
      }
    }
    return -1;
  }

  private static void printArr(final int[] arrFinal) {
    System.out.println("Printing Array");
    Arrays.stream(arrFinal)
        .forEach(e->System.out.print(e + " "));
    System.out.println();
  }
}
