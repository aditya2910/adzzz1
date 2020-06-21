package com.codeisgood;

import java.util.Arrays;

public class SumOfNumbers {

  public static void main(String[] args) {
    int[] input = {5, 6, 2, 6, 7};
    int sum = getSum(input);
    System.out.println(sum);
  }

  private static int getSum(final int[] input) {
    if(input.length == 1)
      return input[0];
    return Arrays.stream(input).sum();
  }
}
