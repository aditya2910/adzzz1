package com.om.poc.algo.recursion;

public class FibonacciSeriesIterative {

  //1, 1, 2, 3, 5,
  public static void main(String[] args) {
    getFiboSeries(10);
    //System.out.println(fibo);
  }

  private static void getFiboSeries(final int n) {
    int[] fibo = new int[n];
    for (int i = 0; i < n; i++) {
      if(i == 0) {
        fibo[i] = 1;
      }
      else if(i == 1) {
        fibo[i] = 1;
      }
      else {
        fibo[i] = fibo[i - 1] + fibo[i - 2];
      }
    }
    printArray(fibo);
  }

  private static void printArray(final int[] fibo) {
    for (int i = 0; i < fibo.length; i++) {
      System.out.println(fibo[i]);
    }
  }
}
