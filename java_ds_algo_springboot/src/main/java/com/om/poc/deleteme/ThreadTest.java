package com.om.poc.deleteme;

public class ThreadTest {

  public static void main(String[] args) {
    Runnable task = () -> {
      System.out.println(Thread.currentThread().getName());
    };

    for (int i = 0; i < 20; i++) {
      Thread thread = new Thread(task);
      thread.setPriority(1);
      thread.start();

    }
  }
}
