package com.om.codeisgood;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondHighest {

  public static void main(String[] args) {
    int[] input = {25, 35, -20, 10, 60, 4, -40};
    int secondHighestNo = getSecondHighestNo(input);
    System.out.println("secondHighestNo : " + secondHighestNo);


    System.out.println ("abc[".matches ("[a-zA-Z]+\\["));
    System.out.println ("abc[1111".matches ("[a-zA-Z]+\\[\\d+"));

    System.out.println ("abc[1111".matches ("[a-zA-Z]+\\[\\d+]"));
  }

  private static int getSecondHighestNo(final int[] input) {
    int firstHighestNo = Integer.MIN_VALUE;
    int secondHighestNo = Integer.MIN_VALUE;

    for (int i = 0; i < input.length; i++) {
      if(input[i] > firstHighestNo) {
        secondHighestNo = firstHighestNo;
        firstHighestNo = input[i];
      }
    }

    return secondHighestNo;
  }

}
