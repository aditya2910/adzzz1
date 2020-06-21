package com.poc.java.multithreading.waitnotify1;

import java.util.Queue;
import java.util.Random;

public class Producer extends Thread {

  Queue<Integer> queue;
  int max_size;

  public Producer(final Queue<Integer> queue, final int max_size, final String name) {
    super(name);
    this.queue = queue;
    this.max_size = max_size;
  }

  @Override
  public void run() {
    while(true) {
      synchronized (queue) {
        while (queue.size() == max_size) {
          try {
            System.out .println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue");
            queue.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        Random random = new Random();
        int i = random.nextInt();
        System.out.println("Producing value : " + i);
        queue.add(i);
        queue.notifyAll();
      }
    }
  }

}
