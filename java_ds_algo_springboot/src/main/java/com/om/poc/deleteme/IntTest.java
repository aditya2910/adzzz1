package com.om.poc.deleteme;

import java.util.ArrayList;
import java.util.List;

public class IntTest {

  public static void main(String args[]) {
    long nthTermOfSeries = getNextSeq(12);
    System.out.println(nthTermOfSeries);
  }

  private static long getNextSeq(long n) {
    //Initializing three var to keep the value or iterating values.
    long n1 = 1, n2 = 1, n3 = 1;
    if (n <= 3) {
      return n3;
    }
    // Initializing the variable to keep sum of previous 2 values
    long nthSeqValue = 0;
    while (n >= 4) {
      // adding (n-3)th & (n-2)th term
      nthSeqValue = n1 + n2;
      // rearranging n1, n2 & n3 to accommodate n in n3
      // assigning n2 to n1
      n1 = n2;
      // assigning n3 to n2
      n2 = n3;
      // assigning nthSeqValue to n3
      n3 = nthSeqValue;

      // n is the counter for getting the nth term
      n--;
    }
    return nthSeqValue;
  }

}
