package com.om.poc.java.multithreading.blockingqueuedeque;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

  protected BlockingQueue<String> queue = null;

  public Producer(BlockingQueue<String> queue) {
    this.queue = queue;
  }

  public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        String msg = "" + i;
        System.out.println("producing: " + msg);
        queue.put(msg);
      }
      queue.put("last_msg_ack");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}