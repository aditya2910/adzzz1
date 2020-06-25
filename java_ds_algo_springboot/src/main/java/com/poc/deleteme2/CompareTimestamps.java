package com.poc.deleteme2;

import java.util.concurrent.TimeUnit;

public class CompareTimestamps {

  public static void main(String[] args) {
    long start = Long.parseLong("1592979481498");
    long end = Long.parseLong("1592979531502");

    long diff  = TimeUnit.MILLISECONDS.toMillis(end - start);
    System.out.println(diff);
  }
}
