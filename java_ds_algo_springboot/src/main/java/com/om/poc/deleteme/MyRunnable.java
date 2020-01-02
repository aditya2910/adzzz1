package com.om.poc.deleteme;

import java.util.Arrays;

public class MyRunnable  {

  public static void main(String[] args) {
    Solution[] qa = {new Solution()};

    Arrays.sort(qa);

    Arrays.stream(qa).forEach(System.out::println);
   }
}
