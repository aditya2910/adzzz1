package com.om.poc.java.multithreading.interrupt;

/**
 * interrupt() works only on sleeping or waiting threads.
 * If the thread is doing some work and taking long time, then interrupt() doesnot do any effect.
 */
class TestInterruptingThread2 extends Thread {
  public void run() {
    try {
      System.out.println("task started");
      Thread.sleep(100000);
      System.out.println("task ended");
    } catch (InterruptedException e) {
      System.out.println("Exception handled " + e);
    }
    System.out.println("thread is running...");
  }

  public static void main(String args[]) {
    TestInterruptingThread2 t1 = new TestInterruptingThread2();
    t1.start();

    t1.interrupt();

  }
}
