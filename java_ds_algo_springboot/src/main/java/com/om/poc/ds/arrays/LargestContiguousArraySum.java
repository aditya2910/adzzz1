package com.om.poc.ds.arrays;

import java.util.Arrays;

public class LargestContiguousArraySum {

  public static void main(String[] args) {
    //int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] a = {-2,-1};
    System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));

  }

  static int maxSubArraySum(int a[]) {
    int max_so_far = 0;
    int max_ending_here = 0;

    for (int i = 0; i < a.length; i++) {

      max_ending_here = max_ending_here + a[i];

      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
      }
      if (max_ending_here < 0) {
        max_ending_here = 0;
      }
    }
    return max_so_far;
  }

}
