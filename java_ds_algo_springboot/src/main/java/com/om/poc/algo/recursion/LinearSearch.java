package com.om.poc.algo.recursion;

public class LinearSearch {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9};

    int indexOfFoundNo = getIndexOfSearchedNo(arr, 5, 0);
    System.out.println(indexOfFoundNo);
  }

  private static int getIndexOfSearchedNo(final int[] arr, final int n, int index) {
    if(arr[index] == n) {
      return index;
    }

    index++;
    return getIndexOfSearchedNo(arr, n, index);
  }


}
