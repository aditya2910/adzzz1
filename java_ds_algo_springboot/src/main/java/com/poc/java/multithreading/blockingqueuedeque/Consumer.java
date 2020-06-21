package com.poc.java.multithreading.blockingqueuedeque;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

  protected BlockingQueue<String> queue = null;

  public Consumer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  public void run() {
    try {
      String msg = "";
      while (!((msg = queue.take()).equals("last_msg_ack"))) {
        System.out.println("Consumed: " + msg);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
