package com.om.poc.deleteme;

public class MyTask implements Runnable {

  private int var;

  public MyTask(int var) {
    this.var = var;
  }

  @Override
  public void run() {

    System.out.println(Thread.currentThread().getName() + " : " + var);

    if(Thread.currentThread().isInterrupted()) {
      // Stops thread execution
    }
  }
}
