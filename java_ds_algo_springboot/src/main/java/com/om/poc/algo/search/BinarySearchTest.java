package com.om.poc.algo.search;

public class BinarySearchTest {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    int no = 40;
    
    int indexOfFoundNo = getIndexOfFoundNo(arr, no);
    System.out.println("No. found at index: " + indexOfFoundNo);
  }

  private static int getIndexOfFoundNo(final int[] arr, final int no) {

    int l = 0, r  = arr.length-1;
    while (l < r) {
      int midIndex = (arr[l] + arr[r]) / 2;

      if (arr[midIndex] == no) {
        return midIndex;
      }
      if (arr[midIndex] > no) {
        r = midIndex - 1;
      }
      if (arr[midIndex] < no) {
        l = midIndex + 1;
      }

    }
    return -1;
  }

}
