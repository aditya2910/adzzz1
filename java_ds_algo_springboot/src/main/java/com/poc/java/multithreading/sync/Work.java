package com.poc.java.multithreading.sync;

public class Work {

  public synchronized void m1() {
    System.out.println("I am in m1 " + Thread.currentThread().getName());
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("I am out of m1 " + Thread.currentThread().getName());
  }

  public synchronized void m2() {
    System.out.println("I am in m2 " + Thread.currentThread().getName());
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("I am out of m2 " + Thread.currentThread().getName());
  }
}
