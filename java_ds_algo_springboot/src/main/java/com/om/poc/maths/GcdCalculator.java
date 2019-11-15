package com.om.poc.maths;

public class GcdCalculator {

  public static void main(String[] args) {
    int gcd = getGcd(2,2);
    System.out.println(gcd);

  }

  private static int getGcd(final int a, final int b) {
    if (b == 0)
      return a;
    return getGcd(b, a % b);
  }

}
