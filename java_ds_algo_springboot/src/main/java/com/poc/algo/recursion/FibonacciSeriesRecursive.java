package com.poc.algo.recursion;

public class FibonacciSeriesRecursive {

  //1, 1, 2, 3, 5,
  public static void main(String[] args) {
    int fibo = getFiboSeries(10);
    System.out.println(fibo);
  }

  private static int getFiboSeries(final int n) {

    if(n == 1) {
      return 1;
    }
    else if(n == 2) {
      return 1;
    } else {
      System.out.println(getFiboSeries(n-1) + getFiboSeries(n-2));
      return getFiboSeries(n-1) + getFiboSeries(n-2);

    }
  }

}
