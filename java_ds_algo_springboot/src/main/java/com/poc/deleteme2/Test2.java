package com.poc.deleteme2;

//@Profile("dev")
//@Component
public class Test2 {

  public static void main(String[] args) {

    tail(5);
    head(5);

    System.out.println(factorial(4));
  }

  private static int factorial(final int num) {
    if(num == 0)
      return 1;
    return num * factorial(num-1);
  }



  private static void head(final int n) {
    if(n==1)
      return;
    head(n-1);
    System.out.println(n);
  }

  private static void tail(final int n) {
    if (n == 1)
      return;
    System.out.println(n);
    tail(n - 1);
  }
}
