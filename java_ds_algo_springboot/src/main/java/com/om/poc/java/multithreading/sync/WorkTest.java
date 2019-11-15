package com.om.poc.java.multithreading.sync;

public class WorkTest {

  public static void main(String[] args) {

    Work work = new Work();

    Runnable r1 = () -> {
      work.m1();
    };
    Runnable r2 = () -> {
      work.m2();
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();
  }
}
