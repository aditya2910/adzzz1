package com.om.poc.java.multithreading;

class ThreadSuperRunnable extends Thread {

  ThreadSuperRunnable() {
  }

  ThreadSuperRunnable(Runnable r) {
    super(r);
  }

  public void run() {
    System.out.print("Inside Thread ");
  }
}

class RunnableDemo implements Runnable {
  public void run() {
    System.out.print(" Inside Runnable");
  }
}

class ThreadDemo {
  public static void main(String[] args) {
    new ThreadSuperRunnable().start();

    new ThreadSuperRunnable(new RunnableDemo()).start();
  }
}