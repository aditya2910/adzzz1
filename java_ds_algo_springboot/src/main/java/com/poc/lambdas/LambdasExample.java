package com.poc.lambdas;

public class LambdasExample {

  public static void main(String[] args) {
    Runnable runnable = new MyRunnable();
    Thread t1 = new Thread(runnable);
    t1.start();


    Runnable worker = () -> {
      System.out.println("Hello2");
    };
    Thread t2 = new Thread(worker);
    t2.start();
  }

}

class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("Hello");
  }
}
